package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzGq;
    private final ArrayList<AppContentConditionEntity> zzauC;
    private final String zzauD;
    private final AppContentAnnotationEntity zzauE;
    private final String zzauF;
    private final String zzwN;

    AppContentActionEntity(int versionCode, ArrayList<AppContentConditionEntity> conditions, String contentDescription, Bundle extras, String type, String id, AppContentAnnotationEntity annotation, String overflowText) {
        this.mVersionCode = versionCode;
        this.zzauE = annotation;
        this.zzauC = conditions;
        this.zzauD = contentDescription;
        this.mExtras = extras;
        this.zzwN = id;
        this.zzauF = overflowText;
        this.zzGq = type;
    }

    public AppContentActionEntity(AppContentAction action) {
        this.mVersionCode = 5;
        this.zzauE = (AppContentAnnotationEntity) action.zztO().freeze();
        this.zzauD = action.zztQ();
        this.mExtras = action.getExtras();
        this.zzwN = action.getId();
        this.zzauF = action.zztR();
        this.zzGq = action.getType();
        List zztP = action.zztP();
        int size = zztP.size();
        this.zzauC = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzauC.add((AppContentConditionEntity) ((AppContentCondition) zztP.get(i)).freeze());
        }
    }

    static int zza(AppContentAction appContentAction) {
        return zzw.hashCode(appContentAction.zztO(), appContentAction.zztP(), appContentAction.zztQ(), appContentAction.getExtras(), appContentAction.getId(), appContentAction.zztR(), appContentAction.getType());
    }

    static boolean zza(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzw.equal(appContentAction2.zztO(), appContentAction.zztO()) && zzw.equal(appContentAction2.zztP(), appContentAction.zztP()) && zzw.equal(appContentAction2.zztQ(), appContentAction.zztQ()) && zzw.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && zzw.equal(appContentAction2.getId(), appContentAction.getId()) && zzw.equal(appContentAction2.zztR(), appContentAction.zztR()) && zzw.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String zzb(AppContentAction appContentAction) {
        return zzw.zzv(appContentAction).zzg("Annotation", appContentAction.zztO()).zzg("Conditions", appContentAction.zztP()).zzg("ContentDescription", appContentAction.zztQ()).zzg("Extras", appContentAction.getExtras()).zzg("Id", appContentAction.getId()).zzg("OverflowText", appContentAction.zztR()).zzg("Type", appContentAction.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztS();
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzwN;
    }

    public String getType() {
        return this.zzGq;
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
        AppContentActionEntityCreator.zza(this, out, flags);
    }

    public AppContentAnnotation zztO() {
        return this.zzauE;
    }

    public List<AppContentCondition> zztP() {
        return new ArrayList(this.zzauC);
    }

    public String zztQ() {
        return this.zzauD;
    }

    public String zztR() {
        return this.zzauF;
    }

    public AppContentAction zztS() {
        return this;
    }
}
