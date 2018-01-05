package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.internal.zzse;

public class ChangeSequenceNumber implements SafeParcelable {
    public static final Creator<ChangeSequenceNumber> CREATOR = new zza();
    final int mVersionCode;
    final long zzaiu;
    final long zzaiv;
    final long zzaiw;
    private volatile String zzaix = null;

    ChangeSequenceNumber(int versionCode, long sequenceNumber, long databaseInstanceId, long accountId) {
        boolean z = true;
        zzx.zzaa(sequenceNumber != -1);
        zzx.zzaa(databaseInstanceId != -1);
        if (accountId == -1) {
            z = false;
        }
        zzx.zzaa(z);
        this.mVersionCode = versionCode;
        this.zzaiu = sequenceNumber;
        this.zzaiv = databaseInstanceId;
        this.zzaiw = accountId;
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzaix == null) {
            this.zzaix = "ChangeSequenceNumber:" + Base64.encodeToString(zzqL(), 10);
        }
        return this.zzaix;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.zzaiv == this.zzaiv && changeSequenceNumber.zzaiw == this.zzaiw && changeSequenceNumber.zzaiu == this.zzaiu;
    }

    public int hashCode() {
        return (String.valueOf(this.zzaiu) + String.valueOf(this.zzaiv) + String.valueOf(this.zzaiw)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    final byte[] zzqL() {
        zzse com_google_android_gms_drive_internal_zzas = new zzas();
        com_google_android_gms_drive_internal_zzas.versionCode = this.mVersionCode;
        com_google_android_gms_drive_internal_zzas.zzalN = this.zzaiu;
        com_google_android_gms_drive_internal_zzas.zzalO = this.zzaiv;
        com_google_android_gms_drive_internal_zzas.zzalP = this.zzaiw;
        return zzse.zzf(com_google_android_gms_drive_internal_zzas);
    }
}
