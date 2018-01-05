package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzGq;
    private final String zzajf;
    private final String zzauD;
    private final ArrayList<AppContentAnnotationEntity> zzauM;
    private final String zzauO;
    private final ArrayList<AppContentCardEntity> zzauV;
    private final String zzauW;
    private final String zzwN;

    AppContentSectionEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentCardEntity> cards, String contentDescription, Bundle extras, String subtitle, String title, String type, String id, String cardType, ArrayList<AppContentAnnotationEntity> annotations) {
        this.mVersionCode = versionCode;
        this.mActions = actions;
        this.zzauM = annotations;
        this.zzauV = cards;
        this.zzauW = cardType;
        this.zzauD = contentDescription;
        this.mExtras = extras;
        this.zzwN = id;
        this.zzauO = subtitle;
        this.zzajf = title;
        this.zzGq = type;
    }

    public AppContentSectionEntity(AppContentSection section) {
        int i;
        int i2 = 0;
        this.mVersionCode = 5;
        this.zzauW = section.zzul();
        this.zzauD = section.zztQ();
        this.mExtras = section.getExtras();
        this.zzwN = section.getId();
        this.zzauO = section.zzuc();
        this.zzajf = section.getTitle();
        this.zzGq = section.getType();
        List actions = section.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = section.zzuk();
        size = actions.size();
        this.zzauV = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzauV.add((AppContentCardEntity) ((AppContentCard) actions.get(i)).freeze());
        }
        List zzua = section.zzua();
        int size2 = zzua.size();
        this.zzauM = new ArrayList(size2);
        while (i2 < size2) {
            this.zzauM.add((AppContentAnnotationEntity) ((AppContentAnnotation) zzua.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzw.hashCode(appContentSection.getActions(), appContentSection.zzua(), appContentSection.zzuk(), appContentSection.zzul(), appContentSection.zztQ(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zzuc(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzw.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzw.equal(appContentSection2.zzua(), appContentSection.zzua()) && zzw.equal(appContentSection2.zzuk(), appContentSection.zzuk()) && zzw.equal(appContentSection2.zzul(), appContentSection.zzul()) && zzw.equal(appContentSection2.zztQ(), appContentSection.zztQ()) && zzw.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzw.equal(appContentSection2.getId(), appContentSection.getId()) && zzw.equal(appContentSection2.zzuc(), appContentSection.zzuc()) && zzw.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzw.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzw.zzv(appContentSection).zzg("Actions", appContentSection.getActions()).zzg("Annotations", appContentSection.zzua()).zzg("Cards", appContentSection.zzuk()).zzg("CardType", appContentSection.zzul()).zzg("ContentDescription", appContentSection.zztQ()).zzg("Extras", appContentSection.getExtras()).zzg("Id", appContentSection.getId()).zzg("Subtitle", appContentSection.zzuc()).zzg("Title", appContentSection.getTitle()).zzg("Type", appContentSection.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzum();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
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
        AppContentSectionEntityCreator.zza(this, out, flags);
    }

    public String zztQ() {
        return this.zzauD;
    }

    public List<AppContentAnnotation> zzua() {
        return new ArrayList(this.zzauM);
    }

    public String zzuc() {
        return this.zzauO;
    }

    public List<AppContentCard> zzuk() {
        return new ArrayList(this.zzauV);
    }

    public String zzul() {
        return this.zzauW;
    }

    public AppContentSection zzum() {
        return this;
    }
}
