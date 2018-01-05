package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class DriveSpace implements SafeParcelable {
    public static final Creator<DriveSpace> CREATOR = new zzh();
    public static final DriveSpace zzaiR = new DriveSpace("DRIVE");
    public static final DriveSpace zzaiS = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzaiT = new DriveSpace("PHOTOS");
    public static final Set<DriveSpace> zzaiU = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DriveSpace[]{zzaiR, zzaiS, zzaiT})));
    public static final String zzaiV = TextUtils.join(",", zzaiU.toArray());
    private static final Pattern zzaiW = Pattern.compile("[A-Z0-9_]*");
    private final String mName;
    final int mVersionCode;

    DriveSpace(int versionCode, String name) {
        this.mVersionCode = versionCode;
        this.mName = (String) zzx.zzw(name);
    }

    private DriveSpace(String name) {
        this(1, name);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return (o == null || o.getClass() != DriveSpace.class) ? false : this.mName.equals(((DriveSpace) o).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return 1247068382 ^ this.mName.hashCode();
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }
}
