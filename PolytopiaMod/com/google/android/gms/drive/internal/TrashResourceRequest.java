package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest implements SafeParcelable {
    public static final Creator<TrashResourceRequest> CREATOR = new zzbw();
    final int mVersionCode;
    final DriveId zzakc;

    TrashResourceRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzakc = id;
    }

    public TrashResourceRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbw.zza(this, dest, flags);
    }
}
