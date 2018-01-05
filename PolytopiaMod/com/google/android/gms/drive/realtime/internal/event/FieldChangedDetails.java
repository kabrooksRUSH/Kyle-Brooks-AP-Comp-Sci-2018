package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldChangedDetails implements SafeParcelable {
    public static final Creator<FieldChangedDetails> CREATOR = new zza();
    final int mVersionCode;
    final int zzaoE;

    FieldChangedDetails(int versionCode, int keyIndex) {
        this.mVersionCode = versionCode;
        this.zzaoE = keyIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
