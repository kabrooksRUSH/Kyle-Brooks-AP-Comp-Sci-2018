package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int mVersionCode;
    private final String zzauQ;
    private final String zzauR;
    private final String zzauS;
    private final Bundle zzauT;

    AppContentConditionEntity(int versionCode, String defaultValue, String expectedValue, String predicate, Bundle predicateParameters) {
        this.mVersionCode = versionCode;
        this.zzauQ = defaultValue;
        this.zzauR = expectedValue;
        this.zzauS = predicate;
        this.zzauT = predicateParameters;
    }

    public AppContentConditionEntity(AppContentCondition condition) {
        this.mVersionCode = 1;
        this.zzauQ = condition.zzuf();
        this.zzauR = condition.zzug();
        this.zzauS = condition.zzuh();
        this.zzauT = condition.zzui();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzw.hashCode(appContentCondition.zzuf(), appContentCondition.zzug(), appContentCondition.zzuh(), appContentCondition.zzui());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzw.equal(appContentCondition2.zzuf(), appContentCondition.zzuf()) && zzw.equal(appContentCondition2.zzug(), appContentCondition.zzug()) && zzw.equal(appContentCondition2.zzuh(), appContentCondition.zzuh()) && zzw.equal(appContentCondition2.zzui(), appContentCondition.zzui());
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzw.zzv(appContentCondition).zzg("DefaultValue", appContentCondition.zzuf()).zzg("ExpectedValue", appContentCondition.zzug()).zzg("Predicate", appContentCondition.zzuh()).zzg("PredicateParameters", appContentCondition.zzui()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuj();
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
        AppContentConditionEntityCreator.zza(this, out, flags);
    }

    public String zzuf() {
        return this.zzauQ;
    }

    public String zzug() {
        return this.zzauR;
    }

    public String zzuh() {
        return this.zzauS;
    }

    public Bundle zzui() {
        return this.zzauT;
    }

    public AppContentCondition zzuj() {
        return this;
    }
}
