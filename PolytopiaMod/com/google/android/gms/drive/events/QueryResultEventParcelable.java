package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

public class QueryResultEventParcelable extends WriteAwareParcelable implements DriveEvent {
    public static final zzk CREATOR = new zzk();
    final int mVersionCode;
    final DataHolder zzabq;
    final boolean zzajR;
    final int zzajS;

    QueryResultEventParcelable(int versionCode, DataHolder dataHolder, boolean isStatusChanged, int queryStatus) {
        this.mVersionCode = versionCode;
        this.zzabq = dataHolder;
        this.zzajR = isStatusChanged;
        this.zzajS = queryStatus;
    }

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return 3;
    }

    public void zzJ(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public DataHolder zzrh() {
        return this.zzabq;
    }

    public boolean zzri() {
        return this.zzajR;
    }

    public int zzrj() {
        return this.zzajS;
    }
}
