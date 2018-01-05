package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhs.zza;

@zzgr
public class zzhi extends zzhz implements zzhj, zzhm {
    private final Context mContext;
    private final zza zzDe;
    private int zzDv = 3;
    private final String zzGY;
    private final zzhh zzHg;
    private final zzhm zzHh;
    private final String zzHi;
    private int zzHj = 0;
    private final Object zzpd;
    private final String zzzj;

    public zzhi(Context context, String str, String str2, String str3, zza com_google_android_gms_internal_zzhs_zza, zzhh com_google_android_gms_internal_zzhh, zzhm com_google_android_gms_internal_zzhm) {
        this.mContext = context;
        this.zzzj = str;
        this.zzGY = str2;
        this.zzHi = str3;
        this.zzDe = com_google_android_gms_internal_zzhs_zza;
        this.zzHg = com_google_android_gms_internal_zzhh;
        this.zzpd = new Object();
        this.zzHh = com_google_android_gms_internal_zzhm;
    }

    private void zzk(long j) {
        while (true) {
            synchronized (this.zzpd) {
                if (this.zzHj != 0) {
                    return;
                } else if (!zzf(j)) {
                    return;
                }
            }
        }
    }

    public void onStop() {
    }

    public void zzK(int i) {
        zzb(this.zzzj, 0);
    }

    public void zzav(String str) {
        synchronized (this.zzpd) {
            this.zzHj = 1;
            this.zzpd.notify();
        }
    }

    public void zzb(String str, int i) {
        synchronized (this.zzpd) {
            this.zzHj = 2;
            this.zzDv = i;
            this.zzpd.notify();
        }
    }

    public void zzbn() {
        if (this.zzHg != null && this.zzHg.zzgd() != null && this.zzHg.zzgc() != null) {
            final zzhl zzgd = this.zzHg.zzgd();
            zzgd.zza((zzhm) this);
            zzgd.zza((zzhj) this);
            final AdRequestParcel adRequestParcel = this.zzDe.zzHC.zzEn;
            final zzen zzgc = this.zzHg.zzgc();
            try {
                if (zzgc.isInitialized()) {
                    com.google.android.gms.ads.internal.util.client.zza.zzJt.post(new Runnable(this) {
                        final /* synthetic */ zzhi zzHl;

                        public void run() {
                            try {
                                zzgc.zza(adRequestParcel, this.zzHl.zzHi);
                            } catch (Throwable e) {
                                zzb.zzd("Fail to load ad from adapter.", e);
                                this.zzHl.zzb(this.zzHl.zzzj, 0);
                            }
                        }
                    });
                } else {
                    com.google.android.gms.ads.internal.util.client.zza.zzJt.post(new Runnable(this) {
                        final /* synthetic */ zzhi zzHl;

                        public void run() {
                            try {
                                zzgc.zza(zze.zzy(this.zzHl.mContext), adRequestParcel, this.zzHl.zzGY, zzgd, this.zzHl.zzHi);
                            } catch (Throwable e) {
                                zzb.zzd("Fail to initialize adapter " + this.zzHl.zzzj, e);
                                this.zzHl.zzb(this.zzHl.zzzj, 0);
                            }
                        }
                    });
                }
            } catch (Throwable e) {
                zzb.zzd("Fail to check if adapter is initialized.", e);
                zzb(this.zzzj, 0);
            }
            zzk(zzp.zzbz().elapsedRealtime());
            zzgd.zza(null);
            zzgd.zza(null);
            if (this.zzHj == 1) {
                this.zzHh.zzav(this.zzzj);
            } else {
                this.zzHh.zzb(this.zzzj, this.zzDv);
            }
        }
    }

    protected boolean zzf(long j) {
        long elapsedRealtime = 20000 - (zzp.zzbz().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpd.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void zzge() {
        this.zzHg.zzgd();
        AdRequestParcel adRequestParcel = this.zzDe.zzHC.zzEn;
        try {
            this.zzHg.zzgc().zza(adRequestParcel, this.zzHi);
        } catch (Throwable e) {
            zzb.zzd("Fail to load ad from adapter.", e);
            zzb(this.zzzj, 0);
        }
    }
}
