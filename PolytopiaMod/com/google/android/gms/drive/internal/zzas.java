package com.google.android.gms.drive.internal;

import com.google.ads.AdSize;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzse;
import java.io.IOException;

public final class zzas extends zzry<zzas> {
    public int versionCode;
    public long zzalN;
    public long zzalO;
    public long zzalP;

    public zzas() {
        zzrs();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzas)) {
            return false;
        }
        zzas com_google_android_gms_drive_internal_zzas = (zzas) o;
        return (this.versionCode == com_google_android_gms_drive_internal_zzas.versionCode && this.zzalN == com_google_android_gms_drive_internal_zzas.zzalN && this.zzalO == com_google_android_gms_drive_internal_zzas.zzalO && this.zzalP == com_google_android_gms_drive_internal_zzas.zzalP) ? (this.zzbik == null || this.zzbik.isEmpty()) ? com_google_android_gms_drive_internal_zzas.zzbik == null || com_google_android_gms_drive_internal_zzas.zzbik.isEmpty() : this.zzbik.equals(com_google_android_gms_drive_internal_zzas.zzbik) : false;
    }

    public int hashCode() {
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31) + ((int) (this.zzalN ^ (this.zzalN >>> 32)))) * 31) + ((int) (this.zzalO ^ (this.zzalO >>> 32)))) * 31) + ((int) (this.zzalP ^ (this.zzalP >>> 32)))) * 31;
        int hashCode2 = (this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode();
        return hashCode2 + hashCode;
    }

    protected int zzB() {
        return (((super.zzB() + zzrx.zzA(1, this.versionCode)) + zzrx.zze(2, this.zzalN)) + zzrx.zze(3, this.zzalO)) + zzrx.zze(4, this.zzalP);
    }

    public void zza(zzrx com_google_android_gms_internal_zzrx) throws IOException {
        com_google_android_gms_internal_zzrx.zzy(1, this.versionCode);
        com_google_android_gms_internal_zzrx.zzc(2, this.zzalN);
        com_google_android_gms_internal_zzrx.zzc(3, this.zzalO);
        com_google_android_gms_internal_zzrx.zzc(4, this.zzalP);
        super.zza(com_google_android_gms_internal_zzrx);
    }

    public /* synthetic */ zzse zzb(zzrw com_google_android_gms_internal_zzrw) throws IOException {
        return zzm(com_google_android_gms_internal_zzrw);
    }

    public zzas zzm(zzrw com_google_android_gms_internal_zzrw) throws IOException {
        while (true) {
            int zzFo = com_google_android_gms_internal_zzrw.zzFo();
            switch (zzFo) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zzrw.zzFr();
                    continue;
                case 16:
                    this.zzalN = com_google_android_gms_internal_zzrw.zzFu();
                    continue;
                case 24:
                    this.zzalO = com_google_android_gms_internal_zzrw.zzFu();
                    continue;
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    this.zzalP = com_google_android_gms_internal_zzrw.zzFu();
                    continue;
                default:
                    if (!zza(com_google_android_gms_internal_zzrw, zzFo)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public zzas zzrs() {
        this.versionCode = 1;
        this.zzalN = -1;
        this.zzalO = -1;
        this.zzalP = -1;
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
    }
}
