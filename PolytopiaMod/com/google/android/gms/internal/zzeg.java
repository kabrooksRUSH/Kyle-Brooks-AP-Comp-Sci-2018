package com.google.android.gms.internal;

import com.google.android.gms.internal.zzeo.zza;

@zzgr
public final class zzeg extends zza {
    private final Object zzpd = new Object();
    private zzei.zza zzzh;
    private zzef zzzi;

    public void onAdClicked() {
        synchronized (this.zzpd) {
            if (this.zzzi != null) {
                this.zzzi.zzaX();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.zzpd) {
            if (this.zzzi != null) {
                this.zzzi.zzaY();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.zzpd) {
            if (this.zzzh != null) {
                this.zzzh.zzq(error == 3 ? 1 : 2);
                this.zzzh = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.zzpd) {
            if (this.zzzi != null) {
                this.zzzi.zzaZ();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
        r3 = this;
        r1 = r3.zzpd;
        monitor-enter(r1);
        r0 = r3.zzzh;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.zzzh;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.zzq(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.zzzh = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.zzzi;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.zzzi;	 Catch:{ all -> 0x001d }
        r0.zzbb();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeg.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.zzpd) {
            if (this.zzzi != null) {
                this.zzzi.zzba();
            }
        }
    }

    public void zza(zzef com_google_android_gms_internal_zzef) {
        synchronized (this.zzpd) {
            this.zzzi = com_google_android_gms_internal_zzef;
        }
    }

    public void zza(zzei.zza com_google_android_gms_internal_zzei_zza) {
        synchronized (this.zzpd) {
            this.zzzh = com_google_android_gms_internal_zzei_zza;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(com.google.android.gms.internal.zzep r4) {
        /*
        r3 = this;
        r1 = r3.zzpd;
        monitor-enter(r1);
        r0 = r3.zzzh;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.zzzh;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.zza(r2, r4);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.zzzh = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.zzzi;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.zzzi;	 Catch:{ all -> 0x001d }
        r0.zzbb();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeg.zza(com.google.android.gms.internal.zzep):void");
    }
}
