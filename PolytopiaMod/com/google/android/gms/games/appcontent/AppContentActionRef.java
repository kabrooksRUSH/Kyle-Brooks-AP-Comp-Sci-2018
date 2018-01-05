package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 1, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentActionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztS();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzabq, this.zzauU, "action_data", this.zzadl);
    }

    public String getId() {
        return getString("action_id");
    }

    public String getType() {
        return getString("action_type");
    }

    public int hashCode() {
        return AppContentActionEntity.zza(this);
    }

    public String toString() {
        return AppContentActionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentActionEntity) zztS()).writeToParcel(dest, flags);
    }

    public AppContentAnnotation zztO() {
        List zzb = AppContentUtils.zzb(this.zzabq, this.zzauU, "action_annotation", this.zzadl);
        return zzb.size() == 1 ? (AppContentAnnotation) zzb.get(0) : null;
    }

    public List<AppContentCondition> zztP() {
        return AppContentUtils.zzc(this.zzabq, this.zzauU, "action_conditions", this.zzadl);
    }

    public String zztQ() {
        return getString("action_content_description");
    }

    public String zztR() {
        return getString("overflow_text");
    }

    public AppContentAction zztS() {
        return new AppContentActionEntity(this);
    }
}
