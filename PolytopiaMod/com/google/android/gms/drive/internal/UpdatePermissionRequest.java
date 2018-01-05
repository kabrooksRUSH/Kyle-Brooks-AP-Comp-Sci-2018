package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UpdatePermissionRequest implements SafeParcelable {
    public static final Creator<UpdatePermissionRequest> CREATOR = new zzca();
    final int mVersionCode;
    final DriveId zzaiA;
    final String zzaiX;
    final boolean zzajW;
    final String zzajj;
    final int zzamu;

    UpdatePermissionRequest(int versionCode, DriveId driveId, String accountIdentifier, int newRole, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzaiA = driveId;
        this.zzajj = accountIdentifier;
        this.zzamu = newRole;
        this.zzajW = sendEventOnCompletion;
        this.zzaiX = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzca.zza(this, dest, flags);
    }
}
