package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;

public final class ProgressEvent implements DriveEvent {
    public static final Creator<ProgressEvent> CREATOR = new zzh();
    final int mVersionCode;
    final int zzWJ;
    final DriveId zzaiA;
    final long zzajP;
    final long zzajQ;
    final int zzys;

    ProgressEvent(int versionCode, DriveId driveId, int status, long bytesTransferred, long totalBytes, int type) {
        this.mVersionCode = versionCode;
        this.zzaiA = driveId;
        this.zzys = status;
        this.zzajP = bytesTransferred;
        this.zzajQ = totalBytes;
        this.zzWJ = type;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        ProgressEvent progressEvent = (ProgressEvent) o;
        return zzw.equal(this.zzaiA, progressEvent.zzaiA) && this.zzys == progressEvent.zzys && this.zzajP == progressEvent.zzajP && this.zzajQ == progressEvent.zzajQ;
    }

    public int getType() {
        return this.zzWJ;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaiA, Integer.valueOf(this.zzys), Long.valueOf(this.zzajP), Long.valueOf(this.zzajQ));
    }

    public String toString() {
        return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[]{this.zzaiA, Integer.valueOf(this.zzys), Long.valueOf(this.zzajP), Long.valueOf(this.zzajQ)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
