package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 0, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentCardEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzue();
    }

    public List<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzabq, this.zzauU, "card_actions", this.zzadl);
    }

    public String getDescription() {
        return getString("card_description");
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzabq, this.zzauU, "card_data", this.zzadl);
    }

    public String getId() {
        return getString("card_id");
    }

    public String getTitle() {
        return getString("card_title");
    }

    public String getType() {
        return getString("card_type");
    }

    public int hashCode() {
        return AppContentCardEntity.zza(this);
    }

    public String toString() {
        return AppContentCardEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentCardEntity) zzue()).writeToParcel(dest, flags);
    }

    public List<AppContentCondition> zztP() {
        return AppContentUtils.zzc(this.zzabq, this.zzauU, "card_conditions", this.zzadl);
    }

    public String zztQ() {
        return getString("card_content_description");
    }

    public List<AppContentAnnotation> zzua() {
        return AppContentUtils.zzb(this.zzabq, this.zzauU, "card_annotations", this.zzadl);
    }

    public int zzub() {
        return getInteger("card_current_steps");
    }

    public String zzuc() {
        return getString("card_subtitle");
    }

    public int zzud() {
        return getInteger("card_total_steps");
    }

    public AppContentCard zzue() {
        return new AppContentCardEntity(this);
    }
}
