package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Creator<ValuesRemovedDetails> CREATOR = new zzj();
    final int mIndex;
    final int mVersionCode;
    final int zzaoF;
    final int zzaoG;
    final String zzapg;
    final int zzaph;

    ValuesRemovedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedToId, int movedToIndex) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzaoF = valueIndex;
        this.zzaoG = valueCount;
        this.zzapg = movedToId;
        this.zzaph = movedToIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
