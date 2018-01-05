package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;

public class zzii {
    private Handler mHandler = null;
    private HandlerThread zzJh = null;
    private int zzJi = 0;
    private final Object zzpd = new Object();

    class C06691 implements Runnable {
        final /* synthetic */ zzii zzJj;

        C06691(zzii com_google_android_gms_internal_zzii) {
            this.zzJj = com_google_android_gms_internal_zzii;
        }

        public void run() {
            synchronized (this.zzJj.zzpd) {
                zzb.m12v("Suspending the looper thread");
                while (this.zzJj.zzJi == 0) {
                    try {
                        this.zzJj.zzpd.wait();
                        zzb.m12v("Looper thread resumed");
                    } catch (InterruptedException e) {
                        zzb.m12v("Looper thread interrupted.");
                    }
                }
            }
        }
    }

    public Looper zzgM() {
        Looper looper;
        synchronized (this.zzpd) {
            if (this.zzJi != 0) {
                zzx.zzb(this.zzJh, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzJh == null) {
                zzb.m12v("Starting the looper thread.");
                this.zzJh = new HandlerThread("LooperProvider");
                this.zzJh.start();
                this.mHandler = new Handler(this.zzJh.getLooper());
                zzb.m12v("Looper thread started.");
            } else {
                zzb.m12v("Resuming the looper thread");
                this.zzpd.notifyAll();
            }
            this.zzJi++;
            looper = this.zzJh.getLooper();
        }
        return looper;
    }

    public void zzgN() {
        synchronized (this.zzpd) {
            zzx.zzb(this.zzJi > 0, (Object) "Invalid state: release() called more times than expected.");
            int i = this.zzJi - 1;
            this.zzJi = i;
            if (i == 0) {
                this.mHandler.post(new C06691(this));
            }
        }
    }
}
