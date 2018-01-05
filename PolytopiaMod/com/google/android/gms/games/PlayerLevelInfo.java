package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final Creator<PlayerLevelInfo> CREATOR = new PlayerLevelInfoCreator();
    private final int mVersionCode;
    private final long zzauk;
    private final long zzaul;
    private final PlayerLevel zzaum;
    private final PlayerLevel zzaun;

    PlayerLevelInfo(int versionCode, long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        zzx.zzZ(currentXpTotal != -1);
        zzx.zzw(currentLevel);
        zzx.zzw(nextLevel);
        this.mVersionCode = versionCode;
        this.zzauk = currentXpTotal;
        this.zzaul = lastLevelUpTimestamp;
        this.zzaum = currentLevel;
        this.zzaun = nextLevel;
    }

    public PlayerLevelInfo(long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        this(1, currentXpTotal, lastLevelUpTimestamp, currentLevel, nextLevel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzw.equal(Long.valueOf(this.zzauk), Long.valueOf(playerLevelInfo.zzauk)) && zzw.equal(Long.valueOf(this.zzaul), Long.valueOf(playerLevelInfo.zzaul)) && zzw.equal(this.zzaum, playerLevelInfo.zzaum) && zzw.equal(this.zzaun, playerLevelInfo.zzaun);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzaum;
    }

    public long getCurrentXpTotal() {
        return this.zzauk;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzaul;
    }

    public PlayerLevel getNextLevel() {
        return this.zzaun;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzauk), Long.valueOf(this.zzaul), this.zzaum, this.zzaun);
    }

    public boolean isMaxLevel() {
        return this.zzaum.equals(this.zzaun);
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelInfoCreator.zza(this, out, flags);
    }
}
