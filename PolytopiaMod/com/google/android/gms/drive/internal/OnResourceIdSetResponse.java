package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Creator<OnResourceIdSetResponse> CREATOR = new zzbh();
    private final int mVersionCode;
    private final List<String> zzakb;

    OnResourceIdSetResponse(int versionCode, List<String> resourceIds) {
        this.mVersionCode = versionCode;
        this.zzakb = resourceIds;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbh.zza(this, dest, flags);
    }

    public List<String> zzrk() {
        return this.zzakb;
    }
}
