package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class AddPermissionRequest implements SafeParcelable {
    public static final Creator<AddPermissionRequest> CREATOR = new zzb();
    final int mVersionCode;
    final DriveId zzaiA;
    final String zzaiX;
    final Permission zzajT;
    final boolean zzajU;
    final String zzajV;
    final boolean zzajW;

    AddPermissionRequest(int versionCode, DriveId driveId, Permission permission, boolean sendNotificationEmail, String emailMessage, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzaiA = driveId;
        this.zzajT = permission;
        this.zzajU = sendNotificationEmail;
        this.zzajV = emailMessage;
        this.zzajW = sendEventOnCompletion;
        this.zzaiX = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
