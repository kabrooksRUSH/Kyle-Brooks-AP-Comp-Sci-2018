package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

public class OnChangesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Creator<OnChangesResponse> CREATOR = new zzav();
    final int mVersionCode;
    final DataHolder zzalT;
    final List<DriveId> zzalU;
    final ChangeSequenceNumber zzalV;
    final boolean zzalW;

    OnChangesResponse(int versionCode, DataHolder newOrModifiedResourcesData, List<DriveId> deleted, ChangeSequenceNumber lastChangeSequenceNumber, boolean moreChangesExist) {
        this.mVersionCode = versionCode;
        this.zzalT = newOrModifiedResourcesData;
        this.zzalU = deleted;
        this.zzalV = lastChangeSequenceNumber;
        this.zzalW = moreChangesExist;
    }

    public int describeContents() {
        return 0;
    }

    protected void zzJ(Parcel parcel, int i) {
        zzav.zza(this, parcel, i | 1);
    }
}
