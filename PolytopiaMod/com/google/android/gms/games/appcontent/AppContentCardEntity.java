package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzGq;
    private final String zzajf;
    private final String zzaqZ;
    private final ArrayList<AppContentConditionEntity> zzauC;
    private final String zzauD;
    private final ArrayList<AppContentAnnotationEntity> zzauM;
    private final int zzauN;
    private final String zzauO;
    private final int zzauP;
    private final String zzwN;

    AppContentCardEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentAnnotationEntity> annotations, ArrayList<AppContentConditionEntity> conditions, String contentDescription, int currentProgress, String description, Bundle extras, String subtitle, String title, int totalProgress, String type, String id) {
        this.mVersionCode = versionCode;
        this.mActions = actions;
        this.zzauM = annotations;
        this.zzauC = conditions;
        this.zzauD = contentDescription;
        this.zzauN = currentProgress;
        this.zzaqZ = description;
        this.mExtras = extras;
        this.zzwN = id;
        this.zzauO = subtitle;
        this.zzajf = title;
        this.zzauP = totalProgress;
        this.zzGq = type;
    }

    public AppContentCardEntity(AppContentCard card) {
        int i;
        int i2 = 0;
        this.mVersionCode = 4;
        this.zzauD = card.zztQ();
        this.zzauN = card.zzub();
        this.zzaqZ = card.getDescription();
        this.mExtras = card.getExtras();
        this.zzwN = card.getId();
        this.zzajf = card.getTitle();
        this.zzauO = card.zzuc();
        this.zzauP = card.zzud();
        this.zzGq = card.getType();
        List actions = card.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = card.zzua();
        size = actions.size();
        this.zzauM = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzauM.add((AppContentAnnotationEntity) ((AppContentAnnotation) actions.get(i)).freeze());
        }
        List zztP = card.zztP();
        int size2 = zztP.size();
        this.zzauC = new ArrayList(size2);
        while (i2 < size2) {
            this.zzauC.add((AppContentConditionEntity) ((AppContentCondition) zztP.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzw.hashCode(appContentCard.getActions(), appContentCard.zzua(), appContentCard.zztP(), appContentCard.zztQ(), Integer.valueOf(appContentCard.zzub()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzuc(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzud()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzw.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzw.equal(appContentCard2.zzua(), appContentCard.zzua()) && zzw.equal(appContentCard2.zztP(), appContentCard.zztP()) && zzw.equal(appContentCard2.zztQ(), appContentCard.zztQ()) && zzw.equal(Integer.valueOf(appContentCard2.zzub()), Integer.valueOf(appContentCard.zzub())) && zzw.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzw.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzw.equal(appContentCard2.getId(), appContentCard.getId()) && zzw.equal(appContentCard2.zzuc(), appContentCard.zzuc()) && zzw.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzw.equal(Integer.valueOf(appContentCard2.zzud()), Integer.valueOf(appContentCard.zzud())) && zzw.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzw.zzv(appContentCard).zzg("Actions", appContentCard.getActions()).zzg("Annotations", appContentCard.zzua()).zzg("Conditions", appContentCard.zztP()).zzg("ContentDescription", appContentCard.zztQ()).zzg("CurrentSteps", Integer.valueOf(appContentCard.zzub())).zzg("Description", appContentCard.getDescription()).zzg("Extras", appContentCard.getExtras()).zzg("Id", appContentCard.getId()).zzg("Subtitle", appContentCard.zzuc()).zzg("Title", appContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(appContentCard.zzud())).zzg("Type", appContentCard.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzue();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public String getDescription() {
        return this.zzaqZ;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzwN;
    }

    public String getTitle() {
        return this.zzajf;
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
        AppContentCardEntityCreator.zza(this, out, flags);
    }

    public List<AppContentCondition> zztP() {
        return new ArrayList(this.zzauC);
    }

    public String zztQ() {
        return this.zzauD;
    }

    public List<AppContentAnnotation> zzua() {
        return new ArrayList(this.zzauM);
    }

    public int zzub() {
        return this.zzauN;
    }

    public String zzuc() {
        return this.zzauO;
    }

    public int zzud() {
        return this.zzauP;
    }

    public AppContentCard zzue() {
        return this;
    }
}
