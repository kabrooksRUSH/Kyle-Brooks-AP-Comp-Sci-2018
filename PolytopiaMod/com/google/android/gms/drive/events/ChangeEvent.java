package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<ChangeEvent> CREATOR = new zza();
    final int mVersionCode;
    final DriveId zzaiA;
    final int zzajw;

    ChangeEvent(int versionCode, DriveId driveId, int changeFlags) {
        this.mVersionCode = versionCode;
        this.zzaiA = driveId;
        this.zzajw = changeFlags;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaiA;
    }

    public int getType() {
        return 1;
    }

    public boolean hasBeenDeleted() {
        return (this.zzajw & 4) != 0;
    }

    public boolean hasContentChanged() {
        return (this.zzajw & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.zzajw & 1) != 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.zzaiA, Integer.valueOf(this.zzajw)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
