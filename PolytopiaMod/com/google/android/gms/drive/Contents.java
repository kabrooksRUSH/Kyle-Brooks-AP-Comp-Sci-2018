package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR = new zzb();
    final int mVersionCode;
    final ParcelFileDescriptor zzadS;
    final DriveId zzaiA;
    final boolean zzaiB;
    final int zzaiy;
    final int zzaiz;
    final String zzrW;

    Contents(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int requestId, int mode, DriveId driveId, boolean validForConflictDetection, String signature) {
        this.mVersionCode = versionCode;
        this.zzadS = parcelFileDescriptor;
        this.zzaiy = requestId;
        this.zzaiz = mode;
        this.zzaiA = driveId;
        this.zzaiB = validForConflictDetection;
        this.zzrW = signature;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaiA;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.zzadS.getFileDescriptor());
    }

    public int getMode() {
        return this.zzaiz;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.zzadS.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzadS;
    }

    public int getRequestId() {
        return this.zzaiy;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public boolean zzqM() {
        return this.zzaiB;
    }
}
