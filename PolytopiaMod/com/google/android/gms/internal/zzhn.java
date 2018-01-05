package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzhs.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;

@zzgr
public class zzhn extends zzhz implements zzhm {
    private final Context mContext;
    private final zza zzDe;
    private final String zzGY;
    private final ArrayList<Future> zzHp = new ArrayList();
    private final ArrayList<String> zzHq = new ArrayList();
    private final HashSet<String> zzHr = new HashSet();
    private final zzhg zzHs;
    private final Object zzpd = new Object();

    public zzhn(Context context, String str, zza com_google_android_gms_internal_zzhs_zza, zzhg com_google_android_gms_internal_zzhg) {
        this.mContext = context;
        this.zzGY = str;
        this.zzDe = com_google_android_gms_internal_zzhs_zza;
        this.zzHs = com_google_android_gms_internal_zzhg;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzk(java.lang.String r10, java.lang.String r11) {
        /*
        r9 = this;
        r8 = r9.zzpd;
        monitor-enter(r8);
        r0 = r9.zzHs;	 Catch:{ all -> 0x0037 }
        r6 = r0.zzau(r10);	 Catch:{ all -> 0x0037 }
        if (r6 == 0) goto L_0x0017;
    L_0x000b:
        r0 = r6.zzgd();	 Catch:{ all -> 0x0037 }
        if (r0 == 0) goto L_0x0017;
    L_0x0011:
        r0 = r6.zzgc();	 Catch:{ all -> 0x0037 }
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r8);	 Catch:{ all -> 0x0037 }
    L_0x0018:
        return;
    L_0x0019:
        r0 = new com.google.android.gms.internal.zzhi;	 Catch:{ all -> 0x0037 }
        r1 = r9.mContext;	 Catch:{ all -> 0x0037 }
        r3 = r9.zzGY;	 Catch:{ all -> 0x0037 }
        r5 = r9.zzDe;	 Catch:{ all -> 0x0037 }
        r2 = r10;
        r4 = r11;
        r7 = r9;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0037 }
        r1 = r9.zzHp;	 Catch:{ all -> 0x0037 }
        r0 = r0.zzgz();	 Catch:{ all -> 0x0037 }
        r1.add(r0);	 Catch:{ all -> 0x0037 }
        r0 = r9.zzHq;	 Catch:{ all -> 0x0037 }
        r0.add(r10);	 Catch:{ all -> 0x0037 }
        monitor-exit(r8);	 Catch:{ all -> 0x0037 }
        goto L_0x0018;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0037 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhn.zzk(java.lang.String, java.lang.String):void");
    }

    public void onStop() {
    }

    public void zzav(String str) {
        synchronized (this.zzpd) {
            this.zzHr.add(str);
        }
    }

    public void zzb(String str, int i) {
    }

    public void zzbn() {
        final zzhs com_google_android_gms_internal_zzhs;
        for (zzed com_google_android_gms_internal_zzed : this.zzDe.zzHx.zzyW) {
            String str = com_google_android_gms_internal_zzed.zzyT;
            for (String zzk : com_google_android_gms_internal_zzed.zzyO) {
                zzk(zzk, str);
            }
        }
        int i = 0;
        while (i < this.zzHp.size()) {
            try {
                ((Future) this.zzHp.get(i)).get();
                synchronized (this.zzpd) {
                    if (this.zzHr.contains(this.zzHq.get(i))) {
                        com_google_android_gms_internal_zzhs = new zzhs(this.zzDe.zzHC.zzEn, null, this.zzDe.zzHD.zzyY, -2, this.zzDe.zzHD.zzyZ, this.zzDe.zzHD.zzEM, this.zzDe.zzHD.orientation, this.zzDe.zzHD.zzzc, this.zzDe.zzHC.zzEq, this.zzDe.zzHD.zzEK, (zzed) this.zzDe.zzHx.zzyW.get(i), null, (String) this.zzHq.get(i), this.zzDe.zzHx, null, this.zzDe.zzHD.zzEL, this.zzDe.zzqn, this.zzDe.zzHD.zzEJ, this.zzDe.zzHz, this.zzDe.zzHD.zzEO, this.zzDe.zzHD.zzEP, this.zzDe.zzHw, null);
                        com.google.android.gms.ads.internal.util.client.zza.zzJt.post(new Runnable(this) {
                            final /* synthetic */ zzhn zzHt;

                            public void run() {
                                this.zzHt.zzHs.zzb(com_google_android_gms_internal_zzhs);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e) {
            } catch (Exception e2) {
            }
        }
        com_google_android_gms_internal_zzhs = new zzhs(this.zzDe.zzHC.zzEn, null, this.zzDe.zzHD.zzyY, 3, this.zzDe.zzHD.zzyZ, this.zzDe.zzHD.zzEM, this.zzDe.zzHD.orientation, this.zzDe.zzHD.zzzc, this.zzDe.zzHC.zzEq, this.zzDe.zzHD.zzEK, null, null, null, this.zzDe.zzHx, null, this.zzDe.zzHD.zzEL, this.zzDe.zzqn, this.zzDe.zzHD.zzEJ, this.zzDe.zzHz, this.zzDe.zzHD.zzEO, this.zzDe.zzHD.zzEP, this.zzDe.zzHw, null);
        com.google.android.gms.ads.internal.util.client.zza.zzJt.post(new Runnable(this) {
            final /* synthetic */ zzhn zzHt;

            public void run() {
                this.zzHt.zzHs.zzb(com_google_android_gms_internal_zzhs);
            }
        });
        return;
        i++;
    }
}
