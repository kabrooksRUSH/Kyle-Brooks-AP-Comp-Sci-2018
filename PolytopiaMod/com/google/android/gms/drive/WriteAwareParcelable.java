package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class WriteAwareParcelable implements Parcelable {
    private volatile transient boolean zzajv = false;

    public void writeToParcel(Parcel dest, int flags) {
        zzx.zzZ(!zzrd());
        this.zzajv = true;
        zzJ(dest, flags);
    }

    protected abstract void zzJ(Parcel parcel, int i);

    public final boolean zzrd() {
        return this.zzajv;
    }
}
