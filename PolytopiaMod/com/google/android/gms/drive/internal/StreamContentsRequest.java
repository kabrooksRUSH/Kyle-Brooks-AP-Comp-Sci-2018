package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class StreamContentsRequest implements SafeParcelable {
    public static final Creator<StreamContentsRequest> CREATOR = new zzbu();
    final int mVersionCode;
    final DriveId zzakc;

    StreamContentsRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzakc = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbu.zza(this, dest, flags);
    }
}
