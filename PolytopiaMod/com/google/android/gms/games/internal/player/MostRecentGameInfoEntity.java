package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final int mVersionCode;
    private final String zzazk;
    private final String zzazl;
    private final long zzazm;
    private final Uri zzazn;
    private final Uri zzazo;
    private final Uri zzazp;

    MostRecentGameInfoEntity(int versionCode, String gameId, String gameName, long activityTimestampMillis, Uri gameIconImageUri, Uri gameHiResIconImageUri, Uri gameFeaturedImageUri) {
        this.mVersionCode = versionCode;
        this.zzazk = gameId;
        this.zzazl = gameName;
        this.zzazm = activityTimestampMillis;
        this.zzazn = gameIconImageUri;
        this.zzazo = gameHiResIconImageUri;
        this.zzazp = gameFeaturedImageUri;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo info) {
        this.mVersionCode = 2;
        this.zzazk = info.zzvw();
        this.zzazl = info.zzvx();
        this.zzazm = info.zzvy();
        this.zzazn = info.zzvz();
        this.zzazo = info.zzvA();
        this.zzazp = info.zzvB();
    }

    static int zza(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.hashCode(mostRecentGameInfo.zzvw(), mostRecentGameInfo.zzvx(), Long.valueOf(mostRecentGameInfo.zzvy()), mostRecentGameInfo.zzvz(), mostRecentGameInfo.zzvA(), mostRecentGameInfo.zzvB());
    }

    static boolean zza(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return zzw.equal(mostRecentGameInfo2.zzvw(), mostRecentGameInfo.zzvw()) && zzw.equal(mostRecentGameInfo2.zzvx(), mostRecentGameInfo.zzvx()) && zzw.equal(Long.valueOf(mostRecentGameInfo2.zzvy()), Long.valueOf(mostRecentGameInfo.zzvy())) && zzw.equal(mostRecentGameInfo2.zzvz(), mostRecentGameInfo.zzvz()) && zzw.equal(mostRecentGameInfo2.zzvA(), mostRecentGameInfo.zzvA()) && zzw.equal(mostRecentGameInfo2.zzvB(), mostRecentGameInfo.zzvB());
    }

    static String zzb(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.zzv(mostRecentGameInfo).zzg("GameId", mostRecentGameInfo.zzvw()).zzg("GameName", mostRecentGameInfo.zzvx()).zzg("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.zzvy())).zzg("GameIconUri", mostRecentGameInfo.zzvz()).zzg("GameHiResUri", mostRecentGameInfo.zzvA()).zzg("GameFeaturedUri", mostRecentGameInfo.zzvB()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvC();
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
        MostRecentGameInfoEntityCreator.zza(this, out, flags);
    }

    public Uri zzvA() {
        return this.zzazo;
    }

    public Uri zzvB() {
        return this.zzazp;
    }

    public MostRecentGameInfo zzvC() {
        return this;
    }

    public String zzvw() {
        return this.zzazk;
    }

    public String zzvx() {
        return this.zzazl;
    }

    public long zzvy() {
        return this.zzazm;
    }

    public Uri zzvz() {
        return this.zzazn;
    }
}
