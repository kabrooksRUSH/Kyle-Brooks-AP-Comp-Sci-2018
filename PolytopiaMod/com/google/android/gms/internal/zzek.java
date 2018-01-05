package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;

@zzgr
public class zzek implements zzec {
    private final Context mContext;
    private final zzcg zzoo;
    private final zzem zzox;
    private final Object zzpd = new Object();
    private final zzee zzzA;
    private final long zzzB;
    private final long zzzC;
    private boolean zzzD = false;
    private zzeh zzzE;
    private final boolean zzzn;
    private final AdRequestInfoParcel zzzz;

    public zzek(Context context, AdRequestInfoParcel adRequestInfoParcel, zzem com_google_android_gms_internal_zzem, zzee com_google_android_gms_internal_zzee, boolean z, long j, long j2, zzcg com_google_android_gms_internal_zzcg) {
        this.mContext = context;
        this.zzzz = adRequestInfoParcel;
        this.zzox = com_google_android_gms_internal_zzem;
        this.zzzA = com_google_android_gms_internal_zzee;
        this.zzzn = z;
        this.zzzB = j;
        this.zzzC = j2;
        this.zzoo = com_google_android_gms_internal_zzcg;
    }

    public void cancel() {
        synchronized (this.zzpd) {
            this.zzzD = true;
            if (this.zzzE != null) {
                this.zzzE.cancel();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzei zzc(java.util.List<com.google.android.gms.internal.zzed> r21) {
        /*
        r20 = this;
        r2 = "Starting mediation.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaF(r2);
        r14 = new java.util.ArrayList;
        r14.<init>();
        r0 = r20;
        r2 = r0.zzoo;
        r15 = r2.zzdn();
        r16 = r21.iterator();
    L_0x0016:
        r2 = r16.hasNext();
        if (r2 == 0) goto L_0x0123;
    L_0x001c:
        r7 = r16.next();
        r7 = (com.google.android.gms.internal.zzed) r7;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Trying mediation network: ";
        r2 = r2.append(r3);
        r3 = r7.zzyN;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzaG(r2);
        r2 = r7.zzyO;
        r17 = r2.iterator();
    L_0x0040:
        r2 = r17.hasNext();
        if (r2 == 0) goto L_0x0016;
    L_0x0046:
        r4 = r17.next();
        r4 = (java.lang.String) r4;
        r0 = r20;
        r2 = r0.zzoo;
        r18 = r2.zzdn();
        r0 = r20;
        r0 = r0.zzpd;
        r19 = r0;
        monitor-enter(r19);
        r0 = r20;
        r2 = r0.zzzD;	 Catch:{ all -> 0x00fa }
        if (r2 == 0) goto L_0x0069;
    L_0x0061:
        r2 = new com.google.android.gms.internal.zzei;	 Catch:{ all -> 0x00fa }
        r3 = -1;
        r2.<init>(r3);	 Catch:{ all -> 0x00fa }
        monitor-exit(r19);	 Catch:{ all -> 0x00fa }
    L_0x0068:
        return r2;
    L_0x0069:
        r2 = new com.google.android.gms.internal.zzeh;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r3 = r0.mContext;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r5 = r0.zzox;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r6 = r0.zzzA;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r8 = r0.zzzz;	 Catch:{ all -> 0x00fa }
        r8 = r8.zzEn;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r9 = r0.zzzz;	 Catch:{ all -> 0x00fa }
        r9 = r9.zzqn;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r10 = r0.zzzz;	 Catch:{ all -> 0x00fa }
        r10 = r10.zzqj;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r11 = r0.zzzn;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r12 = r0.zzzz;	 Catch:{ all -> 0x00fa }
        r12 = r12.zzqB;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r13 = r0.zzzz;	 Catch:{ all -> 0x00fa }
        r13 = r13.zzqD;	 Catch:{ all -> 0x00fa }
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r0.zzzE = r2;	 Catch:{ all -> 0x00fa }
        monitor-exit(r19);	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r2 = r0.zzzE;
        r0 = r20;
        r8 = r0.zzzB;
        r0 = r20;
        r10 = r0.zzzC;
        r2 = r2.zza(r8, r10);
        r3 = r2.zzzt;
        if (r3 != 0) goto L_0x00fd;
    L_0x00b5:
        r3 = "Adapter succeeded.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaF(r3);
        r0 = r20;
        r3 = r0.zzoo;
        r5 = "mediation_network_succeed";
        r3.zze(r5, r4);
        r3 = r14.isEmpty();
        if (r3 != 0) goto L_0x00d8;
    L_0x00c9:
        r0 = r20;
        r3 = r0.zzoo;
        r4 = "mediation_networks_fail";
        r5 = ",";
        r5 = android.text.TextUtils.join(r5, r14);
        r3.zze(r4, r5);
    L_0x00d8:
        r0 = r20;
        r3 = r0.zzoo;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mls";
        r4[r5] = r6;
        r0 = r18;
        r3.zza(r0, r4);
        r0 = r20;
        r3 = r0.zzoo;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "ttm";
        r4[r5] = r6;
        r3.zza(r15, r4);
        goto L_0x0068;
    L_0x00fa:
        r2 = move-exception;
        monitor-exit(r19);	 Catch:{ all -> 0x00fa }
        throw r2;
    L_0x00fd:
        r14.add(r4);
        r0 = r20;
        r3 = r0.zzoo;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mlf";
        r4[r5] = r6;
        r0 = r18;
        r3.zza(r0, r4);
        r3 = r2.zzzv;
        if (r3 == 0) goto L_0x0040;
    L_0x0115:
        r3 = com.google.android.gms.internal.zzid.zzIE;
        r4 = new com.google.android.gms.internal.zzek$1;
        r0 = r20;
        r4.<init>(r0, r2);
        r3.post(r4);
        goto L_0x0040;
    L_0x0123:
        r2 = r14.isEmpty();
        if (r2 != 0) goto L_0x0138;
    L_0x0129:
        r0 = r20;
        r2 = r0.zzoo;
        r3 = "mediation_networks_fail";
        r4 = ",";
        r4 = android.text.TextUtils.join(r4, r14);
        r2.zze(r3, r4);
    L_0x0138:
        r2 = new com.google.android.gms.internal.zzei;
        r3 = 1;
        r2.<init>(r3);
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzek.zzc(java.util.List):com.google.android.gms.internal.zzei");
    }
}
