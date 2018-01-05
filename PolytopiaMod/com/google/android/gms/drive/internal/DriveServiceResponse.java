package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzq.zza;

public class DriveServiceResponse implements SafeParcelable {
    public static final Creator<DriveServiceResponse> CREATOR = new zzad();
    final int mVersionCode;
    final IBinder zzals;

    DriveServiceResponse(int versionCode, IBinder cancelToken) {
        this.mVersionCode = versionCode;
        this.zzals = cancelToken;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzad.zza(this, dest, flags);
    }

    public zzq zzrr() {
        return zza.zzaI(this.zzals);
    }
}
