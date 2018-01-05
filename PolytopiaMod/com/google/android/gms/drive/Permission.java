package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Permission implements SafeParcelable {
    public static final Creator<Permission> CREATOR = new zzi();
    final int mVersionCode;
    private String zzajj;
    private int zzajk;
    private String zzajl;
    private String zzajm;
    private int zzajn;
    private boolean zzajo;

    Permission(int versionCode, String accountIdentifier, int accountType, String accountDisplayName, String photoLink, int role, boolean isLinkRequired) {
        this.mVersionCode = versionCode;
        this.zzajj = accountIdentifier;
        this.zzajk = accountType;
        this.zzajl = accountDisplayName;
        this.zzajm = photoLink;
        this.zzajn = role;
        this.zzajo = isLinkRequired;
    }

    public static boolean zzcm(int i) {
        switch (i) {
            case FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED /*256*/:
            case FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY /*257*/:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcn(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
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
        Permission permission = (Permission) o;
        return zzw.equal(this.zzajj, permission.zzajj) && this.zzajk == permission.zzajk && this.zzajn == permission.zzajn && this.zzajo == permission.zzajo;
    }

    public int getRole() {
        return !zzcn(this.zzajn) ? -1 : this.zzajn;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzajj, Integer.valueOf(this.zzajk), Integer.valueOf(this.zzajn), Boolean.valueOf(this.zzajo));
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    public String zzqY() {
        return !zzcm(this.zzajk) ? null : this.zzajj;
    }

    public int zzqZ() {
        return !zzcm(this.zzajk) ? -1 : this.zzajk;
    }

    public String zzra() {
        return this.zzajl;
    }

    public String zzrb() {
        return this.zzajm;
    }

    public boolean zzrc() {
        return this.zzajo;
    }
}
