package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzg;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.internal.zzt.zza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzu extends zzj<zzam> {
    private final String zzRq;
    final ConnectionCallbacks zzafE;
    private final Bundle zzakC;
    private final boolean zzakD;
    private volatile DriveId zzakE;
    private volatile DriveId zzakF;
    private volatile boolean zzakG = false;
    final Map<DriveId, Map<ChangeListener, zzae>> zzakH = new HashMap();
    final Map<zzc, zzae> zzakI = new HashMap();
    final Map<DriveId, Map<zzi, zzae>> zzakJ = new HashMap();
    final Map<DriveId, Map<zzi, zzae>> zzakK = new HashMap();

    public zzu(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzRq = com_google_android_gms_common_internal_zzf.zzoN();
        this.zzafE = connectionCallbacks;
        this.zzakC = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.zzakD = false;
                return;
            case 1:
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                if (serviceInfo.exported) {
                    this.zzakD = true;
                    return;
                }
                throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId) {
        zzx.zzb(zzg.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzu zzakP;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new RemoveEventListenerRequest(driveId, i), null, null, new zzbt(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, ChangesAvailableOptions changesAvailableOptions) {
        zzx.zzb(zzg.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        if (this.zzakD) {
            final DriveId driveId2 = driveId;
            final int i2 = i;
            final ChangesAvailableOptions changesAvailableOptions2 = changesAvailableOptions;
            return googleApiClient.zzb(new zza(this, googleApiClient) {
                final /* synthetic */ zzu zzakP;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzrm().zza(new AddEventListenerRequest(driveId2, i2, changesAvailableOptions2), null, null, new zzbt(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, zzae com_google_android_gms_drive_internal_zzae) {
        final DriveId driveId2 = driveId;
        final int i2 = i;
        final zzae com_google_android_gms_drive_internal_zzae2 = com_google_android_gms_drive_internal_zzae;
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzu zzakP;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new RemoveEventListenerRequest(driveId2, i2), com_google_android_gms_drive_internal_zzae2, null, new zzbt(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, zzae com_google_android_gms_drive_internal_zzae, ChangesAvailableOptions changesAvailableOptions) {
        final DriveId driveId2 = driveId;
        final int i2 = i;
        final ChangesAvailableOptions changesAvailableOptions2 = changesAvailableOptions;
        final zzae com_google_android_gms_drive_internal_zzae2 = com_google_android_gms_drive_internal_zzae;
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzu zzakP;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new AddEventListenerRequest(driveId2, i2, changesAvailableOptions2), com_google_android_gms_drive_internal_zzae2, null, new zzbt(this));
            }
        });
    }

    PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, final List<String> pendingTags) {
        boolean z = true;
        zzx.zzaa(pendingTags != null);
        if (pendingTags.isEmpty()) {
            z = false;
        }
        zzx.zzaa(z);
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return apiClient.zzb(new zza(this, apiClient) {
            final /* synthetic */ zzu zzakP;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new CancelPendingActionsRequest(pendingTags), new zzbt(this));
            }
        });
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzam) zzpc()).zza(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.zzakH) {
            this.zzakH.clear();
        }
        synchronized (this.zzakI) {
            this.zzakI.clear();
        }
        synchronized (this.zzakJ) {
            this.zzakJ.clear();
        }
        synchronized (this.zzakK) {
            this.zzakK.clear();
        }
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaR(iBinder);
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId, null);
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> com_google_android_gms_drive_internal_zzs_zzj;
        zzx.zzb(zzg.zza(1, driveId), (Object) "id");
        zzx.zzb((Object) changeListener, (Object) "listener");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        synchronized (this.zzakH) {
            Map map;
            zzae com_google_android_gms_drive_internal_zzae;
            Map map2 = (Map) this.zzakH.get(driveId);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.zzakH.put(driveId, hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            zzae com_google_android_gms_drive_internal_zzae2 = (zzae) map.get(changeListener);
            if (com_google_android_gms_drive_internal_zzae2 == null) {
                com_google_android_gms_drive_internal_zzae = new zzae(getLooper(), getContext(), 1, changeListener);
                map.put(changeListener, com_google_android_gms_drive_internal_zzae);
            } else if (com_google_android_gms_drive_internal_zzae2.zzcQ(1)) {
                com_google_android_gms_drive_internal_zzs_zzj = new zzj(googleApiClient, Status.zzabb);
            } else {
                com_google_android_gms_drive_internal_zzae = com_google_android_gms_drive_internal_zzae2;
            }
            com_google_android_gms_drive_internal_zzae.zzcP(1);
            com_google_android_gms_drive_internal_zzs_zzj = zza(googleApiClient, 1, driveId, com_google_android_gms_drive_internal_zzae, null);
        }
        return com_google_android_gms_drive_internal_zzs_zzj;
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzakE = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzakF = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            this.zzakG = true;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    protected zzam zzaR(IBinder iBinder) {
        return zzam.zza.zzaS(iBinder);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> com_google_android_gms_drive_internal_zzs_zzj;
        zzx.zzb(zzg.zza(1, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        zzx.zzb((Object) changeListener, (Object) "listener");
        synchronized (this.zzakH) {
            Map map = (Map) this.zzakH.get(driveId);
            if (map == null) {
                com_google_android_gms_drive_internal_zzs_zzj = new zzj(googleApiClient, Status.zzabb);
            } else {
                zzae com_google_android_gms_drive_internal_zzae = (zzae) map.remove(changeListener);
                if (com_google_android_gms_drive_internal_zzae == null) {
                    com_google_android_gms_drive_internal_zzs_zzj = new zzj(googleApiClient, Status.zzabb);
                } else {
                    if (map.isEmpty()) {
                        this.zzakH.remove(driveId);
                    }
                    com_google_android_gms_drive_internal_zzs_zzj = zza(googleApiClient, 1, driveId, com_google_android_gms_drive_internal_zzae);
                }
            }
        }
        return com_google_android_gms_drive_internal_zzs_zzj;
    }

    protected String zzfK() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String zzfL() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public boolean zzlN() {
        return (getContext().getPackageName().equals(this.zzRq) && zzrl()) ? false : true;
    }

    protected Bundle zzly() {
        String packageName = getContext().getPackageName();
        zzx.zzw(packageName);
        zzx.zzZ(!zzpa().zzoL().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzRq)) {
            bundle.putString("proxy_package_name", this.zzRq);
        }
        bundle.putAll(this.zzakC);
        return bundle;
    }

    public boolean zzpe() {
        return true;
    }

    boolean zzrl() {
        return GooglePlayServicesUtil.zze(getContext(), Process.myUid());
    }

    public zzam zzrm() throws DeadObjectException {
        return (zzam) zzpc();
    }

    public DriveId zzrn() {
        return this.zzakE;
    }

    public DriveId zzro() {
        return this.zzakF;
    }

    public boolean zzrp() {
        return this.zzakG;
    }

    public boolean zzrq() {
        return this.zzakD;
    }
}
