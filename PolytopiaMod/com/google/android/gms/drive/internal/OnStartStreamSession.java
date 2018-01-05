package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnStartStreamSession implements SafeParcelable {
    public static final Creator<OnStartStreamSession> CREATOR = new zzbi();
    final int mVersionCode;
    final ParcelFileDescriptor zzamm;
    final IBinder zzamn;
    final String zzrW;

    OnStartStreamSession(int versionCode, ParcelFileDescriptor pfd, IBinder closeToken, String signature) {
        this.mVersionCode = versionCode;
        this.zzamm = pfd;
        this.zzamn = closeToken;
        this.zzrW = signature;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbi.zza(this, dest, flags | 1);
    }
}
