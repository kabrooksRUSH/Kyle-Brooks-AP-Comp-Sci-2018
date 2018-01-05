package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFileRange;
import java.util.ArrayList;
import java.util.List;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR = new zzay();
    private static final List<DriveFileRange> zzalZ = new ArrayList();
    final int mVersionCode;
    final long zzama;
    final long zzamb;
    final List<DriveFileRange> zzamc;
    final int zzys;

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected, int status, List<DriveFileRange> rangesAvailable) {
        this.mVersionCode = versionCode;
        this.zzama = bytesLoaded;
        this.zzamb = bytesExpected;
        this.zzys = status;
        this.zzamc = rangesAvailable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzay.zza(this, dest, flags);
    }

    public long zzry() {
        return this.zzama;
    }

    public long zzrz() {
        return this.zzamb;
    }
}
