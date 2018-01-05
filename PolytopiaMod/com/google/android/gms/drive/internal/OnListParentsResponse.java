package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListParentsResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR = new zzbe();
    final int mVersionCode;
    final DataHolder zzaml;

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.mVersionCode = versionCode;
        this.zzaml = parents;
    }

    public int describeContents() {
        return 0;
    }

    protected void zzJ(Parcel parcel, int i) {
        zzbe.zza(this, parcel, i);
    }

    public DataHolder zzrD() {
        return this.zzaml;
    }
}
