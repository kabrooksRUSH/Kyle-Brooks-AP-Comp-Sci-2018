package com.google.android.gms.games.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PlayerStatsEntity implements SafeParcelable, PlayerStats {
    public static final Creator<PlayerStatsEntity> CREATOR = new PlayerStatsEntityCreator();
    private final int mVersionCode;
    private final float zzaBX;
    private final float zzaBY;
    private final int zzaBZ;
    private final int zzaCa;
    private final int zzaCb;
    private final float zzaCc;
    private final float zzaCd;

    PlayerStatsEntity(int versionCode, float averageSessionLength, float churnProbability, int daysSinceLastPlayed, int numberOfPurchases, int numberOfSessions, float sessionPercentile, float spendPercentile) {
        this.mVersionCode = versionCode;
        this.zzaBX = averageSessionLength;
        this.zzaBY = churnProbability;
        this.zzaBZ = daysSinceLastPlayed;
        this.zzaCa = numberOfPurchases;
        this.zzaCb = numberOfSessions;
        this.zzaCc = sessionPercentile;
        this.zzaCd = spendPercentile;
    }

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.mVersionCode = 1;
        this.zzaBX = playerStats.getAverageSessionLength();
        this.zzaBY = playerStats.zzvT();
        this.zzaBZ = playerStats.getDaysSinceLastPlayed();
        this.zzaCa = playerStats.getNumberOfPurchases();
        this.zzaCb = playerStats.getNumberOfSessions();
        this.zzaCc = playerStats.getSessionPercentile();
        this.zzaCd = playerStats.getSpendPercentile();
    }

    static int zza(PlayerStats playerStats) {
        return zzw.hashCode(Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.zzvT()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()));
    }

    static boolean zza(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return zzw.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) && zzw.equal(Float.valueOf(playerStats2.zzvT()), Float.valueOf(playerStats.zzvT())) && zzw.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) && zzw.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) && zzw.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) && zzw.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) && zzw.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile()));
    }

    static String zzb(PlayerStats playerStats) {
        return zzw.zzv(playerStats).zzg("AverageSessionLength", Float.valueOf(playerStats.getAverageSessionLength())).zzg("ChurnProbability", Float.valueOf(playerStats.zzvT())).zzg("DaysSinceLastPlayed", Integer.valueOf(playerStats.getDaysSinceLastPlayed())).zzg("NumberOfPurchases", Integer.valueOf(playerStats.getNumberOfPurchases())).zzg("NumberOfSessions", Integer.valueOf(playerStats.getNumberOfSessions())).zzg("SessionPercentile", Float.valueOf(playerStats.getSessionPercentile())).zzg("SpendPercentile", Float.valueOf(playerStats.getSpendPercentile())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvU();
    }

    public float getAverageSessionLength() {
        return this.zzaBX;
    }

    public int getDaysSinceLastPlayed() {
        return this.zzaBZ;
    }

    public int getNumberOfPurchases() {
        return this.zzaCa;
    }

    public int getNumberOfSessions() {
        return this.zzaCb;
    }

    public float getSessionPercentile() {
        return this.zzaCc;
    }

    public float getSpendPercentile() {
        return this.zzaCd;
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
        PlayerStatsEntityCreator.zza(this, out, flags);
    }

    public float zzvT() {
        return this.zzaBY;
    }

    public PlayerStats zzvU() {
        return this;
    }
}
