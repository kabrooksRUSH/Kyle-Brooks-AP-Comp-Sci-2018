package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions implements SafeParcelable {
    public static final Creator<ChangesAvailableOptions> CREATOR = new zzd();
    final int mVersionCode;
    final List<DriveSpace> zzajA;
    private final Set<DriveSpace> zzajB;
    final int zzajy;
    final boolean zzajz;

    ChangesAvailableOptions(int versionCode, int changesSizeLimit, boolean repeats, List<DriveSpace> spacesList) {
        this(versionCode, changesSizeLimit, repeats, spacesList, spacesList == null ? null : new HashSet(spacesList));
    }

    private ChangesAvailableOptions(int versionCode, int changesSizeLimit, boolean repeats, List<DriveSpace> spacesList, Set<DriveSpace> spaces) {
        this.mVersionCode = versionCode;
        this.zzajy = changesSizeLimit;
        this.zzajz = repeats;
        this.zzajA = spacesList;
        this.zzajB = spaces;
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
        ChangesAvailableOptions changesAvailableOptions = (ChangesAvailableOptions) o;
        return zzw.equal(this.zzajB, changesAvailableOptions.zzajB) && this.zzajy == changesAvailableOptions.zzajy && this.zzajz == changesAvailableOptions.zzajz;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzajB, Integer.valueOf(this.zzajy), Boolean.valueOf(this.zzajz));
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[]{Integer.valueOf(this.zzajy), Boolean.valueOf(this.zzajz), this.zzajA});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
