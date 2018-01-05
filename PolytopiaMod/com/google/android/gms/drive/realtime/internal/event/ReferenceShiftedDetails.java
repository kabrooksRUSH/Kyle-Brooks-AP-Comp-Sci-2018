package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Creator<ReferenceShiftedDetails> CREATOR = new zze();
    final int mVersionCode;
    final String zzaoZ;
    final String zzapa;
    final int zzapb;
    final int zzapc;

    ReferenceShiftedDetails(int versionCode, String oldObjectId, String newObjectId, int oldIndex, int newIndex) {
        this.mVersionCode = versionCode;
        this.zzaoZ = oldObjectId;
        this.zzapa = newObjectId;
        this.zzapb = oldIndex;
        this.zzapc = newIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
