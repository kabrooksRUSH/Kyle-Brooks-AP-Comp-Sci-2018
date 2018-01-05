package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzau;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR = new zze();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int mVersionCode;
    final String zzaiM;
    final long zzaiN;
    final int zzaiO;
    private volatile String zzaiP;
    final long zzaiv;
    private volatile String zzaix;

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        boolean z = false;
        this.zzaix = null;
        this.zzaiP = null;
        this.mVersionCode = versionCode;
        this.zzaiM = resourceId;
        zzx.zzaa(!"".equals(resourceId));
        if (!(resourceId == null && sqlId == -1)) {
            z = true;
        }
        zzx.zzaa(z);
        this.zzaiN = sqlId;
        this.zzaiv = databaseInstanceId;
        this.zzaiO = resourceType;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        this(1, resourceId, sqlId, databaseInstanceId, resourceType);
    }

    public static DriveId decodeFromString(String s) {
        zzx.zzb(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return zzk(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcB(String str) {
        zzx.zzw(str);
        return new DriveId(str, -1, -1, -1);
    }

    static DriveId zzk(byte[] bArr) {
        try {
            zzat zzl = zzat.zzl(bArr);
            return new DriveId(zzl.versionCode, "".equals(zzl.zzalQ) ? null : zzl.zzalQ, zzl.zzalR, zzl.zzalO, zzl.zzalS);
        } catch (zzsd e) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] zzqR() {
        zzse com_google_android_gms_drive_internal_zzau = new zzau();
        com_google_android_gms_drive_internal_zzau.zzalR = this.zzaiN;
        com_google_android_gms_drive_internal_zzau.zzalO = this.zzaiv;
        return zzse.zzf(com_google_android_gms_drive_internal_zzau);
    }

    public DriveFile asDriveFile() {
        if (this.zzaiO != 1) {
            return new zzw(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }

    public DriveFolder asDriveFolder() {
        if (this.zzaiO != 0) {
            return new zzy(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }

    public DriveResource asDriveResource() {
        return this.zzaiO == 1 ? asDriveFolder() : this.zzaiO == 0 ? asDriveFile() : new zzab(this);
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzaix == null) {
            this.zzaix = "DriveId:" + Base64.encodeToString(zzqL(), 10);
        }
        return this.zzaix;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzaiv != this.zzaiv) {
            zzz.zzy("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        } else if (driveId.zzaiN == -1 && this.zzaiN == -1) {
            return driveId.zzaiM.equals(this.zzaiM);
        } else {
            if (this.zzaiM == null || driveId.zzaiM == null) {
                if (driveId.zzaiN != this.zzaiN) {
                    z = false;
                }
                return z;
            } else if (driveId.zzaiN != this.zzaiN) {
                return false;
            } else {
                if (driveId.zzaiM.equals(this.zzaiM)) {
                    return true;
                }
                zzz.zzy("DriveId", "Unexpected unequal resourceId for same DriveId object.");
                return false;
            }
        }
    }

    public String getResourceId() {
        return this.zzaiM;
    }

    public int getResourceType() {
        return this.zzaiO;
    }

    public int hashCode() {
        return this.zzaiN == -1 ? this.zzaiM.hashCode() : (String.valueOf(this.zzaiv) + String.valueOf(this.zzaiN)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzaiP == null) {
            this.zzaiP = Base64.encodeToString(zzqR(), 10);
        }
        return this.zzaiP;
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }

    final byte[] zzqL() {
        zzse com_google_android_gms_drive_internal_zzat = new zzat();
        com_google_android_gms_drive_internal_zzat.versionCode = this.mVersionCode;
        com_google_android_gms_drive_internal_zzat.zzalQ = this.zzaiM == null ? "" : this.zzaiM;
        com_google_android_gms_drive_internal_zzat.zzalR = this.zzaiN;
        com_google_android_gms_drive_internal_zzat.zzalO = this.zzaiv;
        com_google_android_gms_drive_internal_zzat.zzalS = this.zzaiO;
        return zzse.zzf(com_google_android_gms_drive_internal_zzat);
    }
}
