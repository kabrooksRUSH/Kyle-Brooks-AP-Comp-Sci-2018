package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzz;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener, zzc {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzaeG;
    private CountDownLatch zzajK;
    zza zzajL;
    boolean zzajM;

    final class zza extends Handler {
        final /* synthetic */ DriveEventService zzajO;

        zza(DriveEventService driveEventService) {
            this.zzajO = driveEventService;
        }

        private Message zzb(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        private Message zzrg() {
            return obtainMessage(2);
        }

        public void handleMessage(Message msg) {
            zzz.zzx("DriveEventService", "handleMessage message type:" + msg.what);
            switch (msg.what) {
                case 1:
                    this.zzajO.zza((OnEventResponse) msg.obj);
                    return;
                case 2:
                    getLooper().quit();
                    return;
                default:
                    zzz.zzy("DriveEventService", "Unexpected message type:" + msg.what);
                    return;
            }
        }
    }

    final class zzb extends com.google.android.gms.drive.internal.zzao.zza {
        final /* synthetic */ DriveEventService zzajO;

        zzb(DriveEventService driveEventService) {
            this.zzajO = driveEventService;
        }

        public void zzc(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (this.zzajO) {
                zzz.zzx("DriveEventService", "onEvent: " + onEventResponse);
                this.zzajO.zzrf();
                if (this.zzajO.zzajL != null) {
                    this.zzajO.zzajL.sendMessage(this.zzajO.zzajL.zzb(onEventResponse));
                } else {
                    zzz.zzz("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        this.zzajM = false;
        this.zzaeG = -1;
        this.mName = name;
    }

    private void zza(OnEventResponse onEventResponse) {
        DriveEvent zzrA = onEventResponse.zzrA();
        zzz.zzx("DriveEventService", "handleEventMessage: " + zzrA);
        try {
            switch (zzrA.getType()) {
                case 1:
                    onChange((ChangeEvent) zzrA);
                    return;
                case 2:
                    onCompletion((CompletionEvent) zzrA);
                    return;
                case 4:
                    zza((ChangesAvailableEvent) zzrA);
                    return;
                default:
                    zzz.zzy(this.mName, "Unhandled event: " + zzrA);
                    return;
            }
        } catch (Throwable e) {
            zzz.zza(this.mName, e, "Error handling event: " + zzrA);
        }
        zzz.zza(this.mName, e, "Error handling event: " + zzrA);
    }

    private void zzrf() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.zzaeG) {
            if (GooglePlayServicesUtil.zze(this, callingUid)) {
                this.zzaeG = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder asBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.zzajL == null && !this.zzajM) {
                this.zzajM = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.zzajK = new CountDownLatch(1);
                new Thread(this) {
                    final /* synthetic */ DriveEventService zzajO;

                    public void run() {
                        try {
                            Looper.prepare();
                            this.zzajO.zzajL = new zza(this.zzajO);
                            this.zzajO.zzajM = false;
                            countDownLatch.countDown();
                            zzz.zzx("DriveEventService", "Bound and starting loop");
                            Looper.loop();
                            zzz.zzx("DriveEventService", "Finished loop");
                        } finally {
                            if (this.zzajO.zzajK != null) {
                                this.zzajO.zzajK.countDown();
                            }
                        }
                    }
                }.start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        zzz.zzz("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            asBinder = new zzb(this).asBinder();
        } else {
            asBinder = null;
        }
        return asBinder;
    }

    public void onChange(ChangeEvent event) {
        zzz.zzy(this.mName, "Unhandled change event: " + event);
    }

    public void onCompletion(CompletionEvent event) {
        zzz.zzy(this.mName, "Unhandled completion event: " + event);
    }

    public synchronized void onDestroy() {
        zzz.zzx("DriveEventService", "onDestroy");
        if (this.zzajL != null) {
            this.zzajL.sendMessage(this.zzajL.zzrg());
            this.zzajL = null;
            try {
                if (!this.zzajK.await(5000, TimeUnit.MILLISECONDS)) {
                    zzz.zzy("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.zzajK = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    public void zza(ChangesAvailableEvent changesAvailableEvent) {
        zzz.zzy(this.mName, "Unhandled changes available event: " + changesAvailableEvent);
    }
}
