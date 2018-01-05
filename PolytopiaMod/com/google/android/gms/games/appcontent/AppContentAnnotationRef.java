package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
    AppContentAnnotationRef(ArrayList<DataHolder> dataHolders, int dataRow) {
        super(dataHolders, 2, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentAnnotationEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztZ();
    }

    public String getDescription() {
        return getString("annotation_description");
    }

    public String getId() {
        return getString("annotation_id");
    }

    public String getTitle() {
        return getString("annotation_title");
    }

    public int hashCode() {
        return AppContentAnnotationEntity.zza(this);
    }

    public String toString() {
        return AppContentAnnotationEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentAnnotationEntity) zztZ()).writeToParcel(dest, flags);
    }

    public String zztT() {
        return getString("annotation_image_default_id");
    }

    public int zztU() {
        return getInteger("annotation_image_height");
    }

    public Uri zztV() {
        return zzcf("annotation_image_uri");
    }

    public Bundle zztW() {
        return AppContentUtils.zzd(this.zzabq, this.zzauU, "annotation_modifiers", this.zzadl);
    }

    public int zztX() {
        return getInteger("annotation_image_width");
    }

    public String zztY() {
        return getString("annotation_layout_slot");
    }

    public AppContentAnnotation zztZ() {
        return new AppContentAnnotationEntity(this);
    }
}
