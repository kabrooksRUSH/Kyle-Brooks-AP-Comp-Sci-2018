package com.google.android.gms.drive.internal;

import com.google.ads.AdSize;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;
import java.io.IOException;

public final class zzat extends zzry<zzat> {
    public int versionCode;
    public long zzalO;
    public String zzalQ;
    public long zzalR;
    public int zzalS;

    public zzat() {
        zzrt();
    }

    public static zzat zzl(byte[] bArr) throws zzsd {
        return (zzat) zzse.zza(new zzat(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzat)) {
            return false;
        }
        zzat com_google_android_gms_drive_internal_zzat = (zzat) o;
        if (this.versionCode != com_google_android_gms_drive_internal_zzat.versionCode) {
            return false;
        }
        if (this.zzalQ == null) {
            if (com_google_android_gms_drive_internal_zzat.zzalQ != null) {
                return false;
            }
        } else if (!this.zzalQ.equals(com_google_android_gms_drive_internal_zzat.zzalQ)) {
            return false;
        }
        return (this.zzalR == com_google_android_gms_drive_internal_zzat.zzalR && this.zzalO == com_google_android_gms_drive_internal_zzat.zzalO && this.zzalS == com_google_android_gms_drive_internal_zzat.zzalS) ? (this.zzbik == null || this.zzbik.isEmpty()) ? com_google_android_gms_drive_internal_zzat.zzbik == null || com_google_android_gms_drive_internal_zzat.zzbik.isEmpty() : this.zzbik.equals(com_google_android_gms_drive_internal_zzat.zzbik) : false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.zzalQ == null ? 0 : this.zzalQ.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31)) * 31) + ((int) (this.zzalR ^ (this.zzalR >>> 32)))) * 31) + ((int) (this.zzalO ^ (this.zzalO >>> 32)))) * 31) + this.zzalS) * 31;
        if (!(this.zzbik == null || this.zzbik.isEmpty())) {
            i = this.zzbik.hashCode();
        }
        return hashCode + i;
    }

    protected int zzB() {
        int zzB = (((super.zzB() + zzrx.zzA(1, this.versionCode)) + zzrx.zzn(2, this.zzalQ)) + zzrx.zze(3, this.zzalR)) + zzrx.zze(4, this.zzalO);
        return this.zzalS != -1 ? zzB + zzrx.zzA(5, this.zzalS) : zzB;
    }

    public void zza(zzrx com_google_android_gms_internal_zzrx) throws IOException {
        com_google_android_gms_internal_zzrx.zzy(1, this.versionCode);
        com_google_android_gms_internal_zzrx.zzb(2, this.zzalQ);
        com_google_android_gms_internal_zzrx.zzc(3, this.zzalR);
        com_google_android_gms_internal_zzrx.zzc(4, this.zzalO);
        if (this.zzalS != -1) {
            com_google_android_gms_internal_zzrx.zzy(5, this.zzalS);
        }
        super.zza(com_google_android_gms_internal_zzrx);
    }

    public /* synthetic */ zzse zzb(zzrw com_google_android_gms_internal_zzrw) throws IOException {
        return zzn(com_google_android_gms_internal_zzrw);
    }

    public zzat zzn(zzrw com_google_android_gms_internal_zzrw) throws IOException {
        while (true) {
            int zzFo = com_google_android_gms_internal_zzrw.zzFo();
            switch (zzFo) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zzrw.zzFr();
                    continue;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    this.zzalQ = com_google_android_gms_internal_zzrw.readString();
                    continue;
                case 24:
                    this.zzalR = com_google_android_gms_internal_zzrw.zzFu();
                    continue;
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    this.zzalO = com_google_android_gms_internal_zzrw.zzFu();
                    continue;
                case 40:
                    this.zzalS = com_google_android_gms_internal_zzrw.zzFr();
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

    public zzat zzrt() {
        this.versionCode = 1;
        this.zzalQ = "";
        this.zzalR = -1;
        this.zzalO = -1;
        this.zzalS = -1;
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
    }
}
