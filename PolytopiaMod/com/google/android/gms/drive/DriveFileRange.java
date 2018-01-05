package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DriveFileRange implements SafeParcelable {
    public static final Creator<DriveFileRange> CREATOR = new zzc();
    final int mVersionCode;
    final long zzaiK;
    final long zzaiL;

    DriveFileRange(int versionCode, long fromByte, long toByte) {
        this.mVersionCode = versionCode;
        this.zzaiK = fromByte;
        this.zzaiL = toByte;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
