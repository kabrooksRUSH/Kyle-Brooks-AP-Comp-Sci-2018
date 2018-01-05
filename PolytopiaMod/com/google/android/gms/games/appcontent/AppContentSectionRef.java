package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzauX;

    AppContentSectionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow, int numChildren) {
        super(dataHolderCollection, 0, dataRow);
        this.zzauX = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzum();
    }

    public /* synthetic */ List getActions() {
        return zzun();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzabq, this.zzauU, "section_data", this.zzadl);
    }

    public String getId() {
        return getString("section_id");
    }

    public String getTitle() {
        return getString("section_title");
    }

    public String getType() {
        return getString("section_type");
    }

    public int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentSectionEntity) zzum()).writeToParcel(dest, flags);
    }

    public String zztQ() {
        return getString("section_content_description");
    }

    public /* synthetic */ List zzua() {
        return zzuo();
    }

    public String zzuc() {
        return getString("section_subtitle");
    }

    public /* synthetic */ List zzuk() {
        return zzup();
    }

    public String zzul() {
        return getString("section_card_type");
    }

    public AppContentSection zzum() {
        return new AppContentSectionEntity(this);
    }

    public ArrayList<AppContentAction> zzun() {
        return AppContentUtils.zza(this.zzabq, this.zzauU, "section_actions", this.zzadl);
    }

    public ArrayList<AppContentAnnotation> zzuo() {
        return AppContentUtils.zzb(this.zzabq, this.zzauU, "section_annotations", this.zzadl);
    }

    public ArrayList<AppContentCard> zzup() {
        ArrayList<AppContentCard> arrayList = new ArrayList(this.zzauX);
        for (int i = 0; i < this.zzauX; i++) {
            arrayList.add(new AppContentCardRef(this.zzauU, this.zzadl + i));
        }
        return arrayList;
    }
}
