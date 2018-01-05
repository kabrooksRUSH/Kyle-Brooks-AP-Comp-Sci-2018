package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class StringListResponse implements SafeParcelable {
    public static final Creator<StringListResponse> CREATOR = new zzbv();
    private final int mVersionCode;
    private final List<String> zzamt;

    StringListResponse(int versionCode, List<String> strings) {
        this.mVersionCode = versionCode;
        this.zzamt = strings;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbv.zza(this, dest, flags);
    }

    public List<String> zzrF() {
        return this.zzamt;
    }
}
