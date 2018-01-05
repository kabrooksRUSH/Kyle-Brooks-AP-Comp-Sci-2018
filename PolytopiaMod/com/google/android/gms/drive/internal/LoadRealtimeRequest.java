package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR = new zzar();
    final int mVersionCode;
    final DriveId zzaiA;
    final boolean zzalI;
    final List<String> zzalJ;
    final boolean zzalK;
    final DataHolder zzalL;
    final String zzalM;

    LoadRealtimeRequest(int versionCode, DriveId driveId, boolean useTestMode, List<String> customTypeWhitelist, boolean isInMemory, DataHolder json, String localId) {
        this.mVersionCode = versionCode;
        this.zzaiA = driveId;
        this.zzalI = useTestMode;
        this.zzalJ = customTypeWhitelist;
        this.zzalK = isInMemory;
        this.zzalL = json;
        this.zzalM = localId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzar.zza(this, dest, flags);
    }
}
