package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR = new zzd();
    final int mVersionCode;
    final DataHolder zzaoV;
    final boolean zzaoW;
    final List<String> zzaoX;
    final ParcelableChangeInfo zzaoY;
    final List<ParcelableEvent> zzoQ;

    ParcelableEventList(int versionCode, List<ParcelableEvent> events, DataHolder eventData, boolean undoRedoStateChanged, List<String> affectedObjectIds, ParcelableChangeInfo previousChangeInfo) {
        this.mVersionCode = versionCode;
        this.zzoQ = events;
        this.zzaoV = eventData;
        this.zzaoW = undoRedoStateChanged;
        this.zzaoX = affectedObjectIds;
        this.zzaoY = previousChangeInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
