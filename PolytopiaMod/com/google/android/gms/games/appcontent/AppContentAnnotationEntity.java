package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
    private final int mVersionCode;
    private final String zzajf;
    private final String zzaqZ;
    private final Uri zzauG;
    private final String zzauH;
    private final String zzauI;
    private final int zzauJ;
    private final int zzauK;
    private final Bundle zzauL;
    private final String zzwN;

    AppContentAnnotationEntity(int versionCode, String description, Uri imageUri, String title, String id, String layoutSlot, String imageDefaultId, int imageHeight, int imageWidth, Bundle modifiers) {
        this.mVersionCode = versionCode;
        this.zzaqZ = description;
        this.zzwN = id;
        this.zzauI = imageDefaultId;
        this.zzauJ = imageHeight;
        this.zzauG = imageUri;
        this.zzauK = imageWidth;
        this.zzauH = layoutSlot;
        this.zzauL = modifiers;
        this.zzajf = title;
    }

    public AppContentAnnotationEntity(AppContentAnnotation annotation) {
        this.mVersionCode = 4;
        this.zzaqZ = annotation.getDescription();
        this.zzwN = annotation.getId();
        this.zzauI = annotation.zztT();
        this.zzauJ = annotation.zztU();
        this.zzauG = annotation.zztV();
        this.zzauK = annotation.zztX();
        this.zzauH = annotation.zztY();
        this.zzauL = annotation.zztW();
        this.zzajf = annotation.getTitle();
    }

    static int zza(AppContentAnnotation appContentAnnotation) {
        return zzw.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.getId(), appContentAnnotation.zztT(), Integer.valueOf(appContentAnnotation.zztU()), appContentAnnotation.zztV(), Integer.valueOf(appContentAnnotation.zztX()), appContentAnnotation.zztY(), appContentAnnotation.zztW(), appContentAnnotation.getTitle());
    }

    static boolean zza(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return zzw.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) && zzw.equal(appContentAnnotation2.getId(), appContentAnnotation.getId()) && zzw.equal(appContentAnnotation2.zztT(), appContentAnnotation.zztT()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zztU()), Integer.valueOf(appContentAnnotation.zztU())) && zzw.equal(appContentAnnotation2.zztV(), appContentAnnotation.zztV()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zztX()), Integer.valueOf(appContentAnnotation.zztX())) && zzw.equal(appContentAnnotation2.zztY(), appContentAnnotation.zztY()) && zzw.equal(appContentAnnotation2.zztW(), appContentAnnotation.zztW()) && zzw.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle());
    }

    static String zzb(AppContentAnnotation appContentAnnotation) {
        return zzw.zzv(appContentAnnotation).zzg("Description", appContentAnnotation.getDescription()).zzg("Id", appContentAnnotation.getId()).zzg("ImageDefaultId", appContentAnnotation.zztT()).zzg("ImageHeight", Integer.valueOf(appContentAnnotation.zztU())).zzg("ImageUri", appContentAnnotation.zztV()).zzg("ImageWidth", Integer.valueOf(appContentAnnotation.zztX())).zzg("LayoutSlot", appContentAnnotation.zztY()).zzg("Modifiers", appContentAnnotation.zztW()).zzg("Title", appContentAnnotation.getTitle()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztZ();
    }

    public String getDescription() {
        return this.zzaqZ;
    }

    public String getId() {
        return this.zzwN;
    }

    public String getTitle() {
        return this.zzajf;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentAnnotationEntityCreator.zza(this, out, flags);
    }

    public String zztT() {
        return this.zzauI;
    }

    public int zztU() {
        return this.zzauJ;
    }

    public Uri zztV() {
        return this.zzauG;
    }

    public Bundle zztW() {
        return this.zzauL;
    }

    public int zztX() {
        return this.zzauK;
    }

    public String zztY() {
        return this.zzauH;
    }

    public AppContentAnnotation zztZ() {
        return this;
    }
}
