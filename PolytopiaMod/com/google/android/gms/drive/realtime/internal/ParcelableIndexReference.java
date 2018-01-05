package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Creator<ParcelableIndexReference> CREATOR = new zzr();
    final int mIndex;
    final int mVersionCode;
    final String zzaoB;
    final boolean zzaoC;
    final int zzaoD;

    ParcelableIndexReference(int versionCode, String objectId, int index, boolean legacyCanBeDeleted, int deleteMode) {
        this.mVersionCode = versionCode;
        this.zzaoB = objectId;
        this.mIndex = index;
        this.zzaoC = legacyCanBeDeleted;
        this.zzaoD = deleteMode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }
}
