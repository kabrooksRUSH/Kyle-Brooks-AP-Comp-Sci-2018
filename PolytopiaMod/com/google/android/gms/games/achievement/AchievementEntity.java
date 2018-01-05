package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final int zzWJ;
    private final String zzaqZ;
    private final long zzauA;
    private final long zzauB;
    private final String zzauq;
    private final Uri zzaur;
    private final String zzaus;
    private final Uri zzaut;
    private final String zzauu;
    private final int zzauv;
    private final String zzauw;
    private final PlayerEntity zzaux;
    private final int zzauy;
    private final String zzauz;

    AchievementEntity(int versionCode, String achievementId, int type, String name, String description, Uri unlockedImageUri, String unlockedImageUrl, Uri revealedImageUri, String revealedImageUrl, int totalSteps, String formattedTotalSteps, PlayerEntity player, int state, int currentSteps, String formattedCurrentSteps, long lastUpdatedTimestamp, long xpValue) {
        this.mVersionCode = versionCode;
        this.zzauq = achievementId;
        this.zzWJ = type;
        this.mName = name;
        this.zzaqZ = description;
        this.zzaur = unlockedImageUri;
        this.zzaus = unlockedImageUrl;
        this.zzaut = revealedImageUri;
        this.zzauu = revealedImageUrl;
        this.zzauv = totalSteps;
        this.zzauw = formattedTotalSteps;
        this.zzaux = player;
        this.mState = state;
        this.zzauy = currentSteps;
        this.zzauz = formattedCurrentSteps;
        this.zzauA = lastUpdatedTimestamp;
        this.zzauB = xpValue;
    }

    public AchievementEntity(Achievement achievement) {
        this.mVersionCode = 1;
        this.zzauq = achievement.getAchievementId();
        this.zzWJ = achievement.getType();
        this.mName = achievement.getName();
        this.zzaqZ = achievement.getDescription();
        this.zzaur = achievement.getUnlockedImageUri();
        this.zzaus = achievement.getUnlockedImageUrl();
        this.zzaut = achievement.getRevealedImageUri();
        this.zzauu = achievement.getRevealedImageUrl();
        this.zzaux = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzauA = achievement.getLastUpdatedTimestamp();
        this.zzauB = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzauv = achievement.getTotalSteps();
            this.zzauw = achievement.getFormattedTotalSteps();
            this.zzauy = achievement.getCurrentSteps();
            this.zzauz = achievement.getFormattedCurrentSteps();
        } else {
            this.zzauv = 0;
            this.zzauw = null;
            this.zzauy = 0;
            this.zzauz = null;
        }
        zzb.zzs(this.zzauq);
        zzb.zzs(this.zzaqZ);
    }

    static int zza(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return zzw.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean zza(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        boolean equal;
        boolean equal2;
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            equal = zzw.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            equal2 = zzw.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            equal2 = true;
            equal = true;
        }
        return zzw.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzw.equal(achievement2.getName(), achievement.getName()) && zzw.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzw.equal(achievement2.getDescription(), achievement.getDescription()) && zzw.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzw.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzw.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzw.equal(achievement2.getPlayer(), achievement.getPlayer()) && equal && equal2;
    }

    static String zzb(Achievement achievement) {
        zza zzg = zzw.zzv(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzg.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.zzauq;
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzZ(z);
        return zztM();
    }

    public String getDescription() {
        return this.zzaqZ;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzaqZ, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzZ(z);
        return zztN();
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzZ(z);
        zzmo.zzb(this.zzauz, dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzZ(z);
        return zztL();
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzZ(z);
        zzmo.zzb(this.zzauw, dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return this.zzauA;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zzmo.zzb(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.zzaux;
    }

    public Uri getRevealedImageUri() {
        return this.zzaut;
    }

    public String getRevealedImageUrl() {
        return this.zzauu;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzZ(z);
        return zztK();
    }

    public int getType() {
        return this.zzWJ;
    }

    public Uri getUnlockedImageUri() {
        return this.zzaur;
    }

    public String getUnlockedImageUrl() {
        return this.zzaus;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public long getXpValue() {
        return this.zzauB;
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

    public void writeToParcel(Parcel dest, int flags) {
        AchievementEntityCreator.zza(this, dest, flags);
    }

    public int zztK() {
        return this.zzauv;
    }

    public String zztL() {
        return this.zzauw;
    }

    public int zztM() {
        return this.zzauy;
    }

    public String zztN() {
        return this.zzauz;
    }
}
