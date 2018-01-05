package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UntrashResourceRequest implements SafeParcelable {
    public static final Creator<UntrashResourceRequest> CREATOR = new zzby();
    final int mVersionCode;
    final DriveId zzakc;

    UntrashResourceRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzakc = id;
    }

    public UntrashResourceRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzby.zza(this, dest, flags);
    }
}
