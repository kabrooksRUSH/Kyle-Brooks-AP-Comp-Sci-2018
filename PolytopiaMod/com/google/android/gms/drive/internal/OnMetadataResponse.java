package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Creator<OnMetadataResponse> CREATOR = new zzbf();
    final int mVersionCode;
    final MetadataBundle zzako;

    OnMetadataResponse(int versionCode, MetadataBundle metadata) {
        this.mVersionCode = versionCode;
        this.zzako = metadata;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbf.zza(this, dest, flags);
    }

    public MetadataBundle zzrE() {
        return this.zzako;
    }
}
