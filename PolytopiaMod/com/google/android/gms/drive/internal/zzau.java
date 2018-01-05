package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzse;
import java.io.IOException;

public final class zzau extends zzry<zzau> {
    public long zzalO;
    public long zzalR;

    public zzau() {
        zzru();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzau)) {
            return false;
        }
        zzau com_google_android_gms_drive_internal_zzau = (zzau) o;
        return (this.zzalR == com_google_android_gms_drive_internal_zzau.zzalR && this.zzalO == com_google_android_gms_drive_internal_zzau.zzalO) ? (this.zzbik == null || this.zzbik.isEmpty()) ? com_google_android_gms_drive_internal_zzau.zzbik == null || com_google_android_gms_drive_internal_zzau.zzbik.isEmpty() : this.zzbik.equals(com_google_android_gms_drive_internal_zzau.zzbik) : false;
    }

    public int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzalR ^ (this.zzalR >>> 32)))) * 31) + ((int) (this.zzalO ^ (this.zzalO >>> 32)))) * 31;
        int hashCode2 = (this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode();
        return hashCode2 + hashCode;
    }

    protected int zzB() {
        return (super.zzB() + zzrx.zze(1, this.zzalR)) + zzrx.zze(2, this.zzalO);
    }

    public void zza(zzrx com_google_android_gms_internal_zzrx) throws IOException {
        com_google_android_gms_internal_zzrx.zzc(1, this.zzalR);
        com_google_android_gms_internal_zzrx.zzc(2, this.zzalO);
        super.zza(com_google_android_gms_internal_zzrx);
    }

    public /* synthetic */ zzse zzb(zzrw com_google_android_gms_internal_zzrw) throws IOException {
        return zzo(com_google_android_gms_internal_zzrw);
    }

    public zzau zzo(zzrw com_google_android_gms_internal_zzrw) throws IOException {
        while (true) {
            int zzFo = com_google_android_gms_internal_zzrw.zzFo();
            switch (zzFo) {
                case 0:
                    break;
                case 8:
                    this.zzalR = com_google_android_gms_internal_zzrw.zzFu();
                    continue;
                case 16:
                    this.zzalO = com_google_android_gms_internal_zzrw.zzFu();
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

    public zzau zzru() {
        this.zzalR = -1;
        this.zzalO = -1;
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
    }
}
