package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzmo;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
    private final int mVersionCode;
    private final boolean zzBa;
    private final String zzTa;
    private final String zzUM;
    private final String zzaqZ;
    private final int zzatA;
    private final int zzatB;
    private final int zzatC;
    private final boolean zzatD;
    private final boolean zzatE;
    private final String zzatF;
    private final String zzatG;
    private final String zzatH;
    private final boolean zzatI;
    private final boolean zzatJ;
    private final String zzatK;
    private final boolean zzatL;
    private final String zzatr;
    private final String zzats;
    private final String zzatt;
    private final Uri zzatu;
    private final Uri zzatv;
    private final Uri zzatw;
    private final boolean zzatx;
    private final boolean zzaty;
    private final String zzatz;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdN(x0);
        }

        public GameEntity zzdN(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzoT()) || DowngradeableSafeParcel.zzck(GameEntity.class.getCanonicalName())) {
                return super.zzdN(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(7, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted, boolean identitySharingConfirmed, boolean snapshotsEnabled, String themeColor, boolean hasGamepadSupport) {
        this.mVersionCode = versionCode;
        this.zzUM = applicationId;
        this.zzTa = displayName;
        this.zzatr = primaryCategory;
        this.zzats = secondaryCategory;
        this.zzaqZ = description;
        this.zzatt = developerName;
        this.zzatu = iconImageUri;
        this.zzatF = iconImageUrl;
        this.zzatv = hiResImageUri;
        this.zzatG = hiResImageUrl;
        this.zzatw = featuredImageUri;
        this.zzatH = featuredImageUrl;
        this.zzatx = playEnabledGame;
        this.zzaty = instanceInstalled;
        this.zzatz = instancePackageName;
        this.zzatA = gameplayAclStatus;
        this.zzatB = achievementTotalCount;
        this.zzatC = leaderboardCount;
        this.zzatD = realTimeEnabled;
        this.zzatE = turnBasedEnabled;
        this.zzBa = muted;
        this.zzatI = identitySharingConfirmed;
        this.zzatJ = snapshotsEnabled;
        this.zzatK = themeColor;
        this.zzatL = hasGamepadSupport;
    }

    public GameEntity(Game game) {
        this.mVersionCode = 7;
        this.zzUM = game.getApplicationId();
        this.zzatr = game.getPrimaryCategory();
        this.zzats = game.getSecondaryCategory();
        this.zzaqZ = game.getDescription();
        this.zzatt = game.getDeveloperName();
        this.zzTa = game.getDisplayName();
        this.zzatu = game.getIconImageUri();
        this.zzatF = game.getIconImageUrl();
        this.zzatv = game.getHiResImageUri();
        this.zzatG = game.getHiResImageUrl();
        this.zzatw = game.getFeaturedImageUri();
        this.zzatH = game.getFeaturedImageUrl();
        this.zzatx = game.zztx();
        this.zzaty = game.zztz();
        this.zzatz = game.zztA();
        this.zzatA = game.zztB();
        this.zzatB = game.getAchievementTotalCount();
        this.zzatC = game.getLeaderboardCount();
        this.zzatD = game.isRealTimeMultiplayerEnabled();
        this.zzatE = game.isTurnBasedMultiplayerEnabled();
        this.zzBa = game.isMuted();
        this.zzatI = game.zzty();
        this.zzatJ = game.areSnapshotsEnabled();
        this.zzatK = game.getThemeColor();
        this.zzatL = game.hasGamepadSupport();
    }

    static int zza(Game game) {
        return zzw.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zztx()), Boolean.valueOf(game.zztz()), game.zztA(), Integer.valueOf(game.zztB()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzty()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    static boolean zza(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (zzw.equal(game2.getApplicationId(), game.getApplicationId()) && zzw.equal(game2.getDisplayName(), game.getDisplayName()) && zzw.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && zzw.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && zzw.equal(game2.getDescription(), game.getDescription()) && zzw.equal(game2.getDeveloperName(), game.getDeveloperName()) && zzw.equal(game2.getIconImageUri(), game.getIconImageUri()) && zzw.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && zzw.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && zzw.equal(Boolean.valueOf(game2.zztx()), Boolean.valueOf(game.zztx())) && zzw.equal(Boolean.valueOf(game2.zztz()), Boolean.valueOf(game.zztz())) && zzw.equal(game2.zztA(), game.zztA()) && zzw.equal(Integer.valueOf(game2.zztB()), Integer.valueOf(game.zztB())) && zzw.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && zzw.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && zzw.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
            boolean z = game.isTurnBasedMultiplayerEnabled() && zzw.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && zzw.equal(Boolean.valueOf(game2.zzty()), Boolean.valueOf(game.zzty()));
            if (zzw.equal(valueOf, Boolean.valueOf(z)) && zzw.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && zzw.equal(game2.getThemeColor(), game.getThemeColor()) && zzw.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()))) {
                return true;
            }
        }
        return false;
    }

    static String zzb(Game game) {
        return zzw.zzv(game).zzg("ApplicationId", game.getApplicationId()).zzg("DisplayName", game.getDisplayName()).zzg("PrimaryCategory", game.getPrimaryCategory()).zzg("SecondaryCategory", game.getSecondaryCategory()).zzg("Description", game.getDescription()).zzg("DeveloperName", game.getDeveloperName()).zzg("IconImageUri", game.getIconImageUri()).zzg("IconImageUrl", game.getIconImageUrl()).zzg("HiResImageUri", game.getHiResImageUri()).zzg("HiResImageUrl", game.getHiResImageUrl()).zzg("FeaturedImageUri", game.getFeaturedImageUri()).zzg("FeaturedImageUrl", game.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(game.zztx())).zzg("InstanceInstalled", Boolean.valueOf(game.zztz())).zzg("InstancePackageName", game.zztA()).zzg("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).zzg("ThemeColor", game.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.zzatJ;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.zzatB;
    }

    public String getApplicationId() {
        return this.zzUM;
    }

    public String getDescription() {
        return this.zzaqZ;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzaqZ, dataOut);
    }

    public String getDeveloperName() {
        return this.zzatt;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzatt, dataOut);
    }

    public String getDisplayName() {
        return this.zzTa;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzTa, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.zzatw;
    }

    public String getFeaturedImageUrl() {
        return this.zzatH;
    }

    public Uri getHiResImageUri() {
        return this.zzatv;
    }

    public String getHiResImageUrl() {
        return this.zzatG;
    }

    public Uri getIconImageUri() {
        return this.zzatu;
    }

    public String getIconImageUrl() {
        return this.zzatF;
    }

    public int getLeaderboardCount() {
        return this.zzatC;
    }

    public String getPrimaryCategory() {
        return this.zzatr;
    }

    public String getSecondaryCategory() {
        return this.zzats;
    }

    public String getThemeColor() {
        return this.zzatK;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasGamepadSupport() {
        return this.zzatL;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.zzBa;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.zzatD;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.zzatE;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (zzoU()) {
            dest.writeString(this.zzUM);
            dest.writeString(this.zzTa);
            dest.writeString(this.zzatr);
            dest.writeString(this.zzats);
            dest.writeString(this.zzaqZ);
            dest.writeString(this.zzatt);
            dest.writeString(this.zzatu == null ? null : this.zzatu.toString());
            dest.writeString(this.zzatv == null ? null : this.zzatv.toString());
            if (this.zzatw != null) {
                str = this.zzatw.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.zzatx ? 1 : 0);
            if (!this.zzaty) {
                i = 0;
            }
            dest.writeInt(i);
            dest.writeString(this.zzatz);
            dest.writeInt(this.zzatA);
            dest.writeInt(this.zzatB);
            dest.writeInt(this.zzatC);
            return;
        }
        GameEntityCreator.zza(this, dest, flags);
    }

    public String zztA() {
        return this.zzatz;
    }

    public int zztB() {
        return this.zzatA;
    }

    public boolean zztx() {
        return this.zzatx;
    }

    public boolean zzty() {
        return this.zzatI;
    }

    public boolean zztz() {
        return this.zzaty;
    }
}
