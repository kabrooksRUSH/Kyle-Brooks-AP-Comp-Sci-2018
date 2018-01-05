package com.google.android.gms.games.stats;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public class PlayerStatsRef extends zzc implements PlayerStats {
    PlayerStatsRef(DataHolder holder, int rowIndex) {
        super(holder, rowIndex);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerStatsEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvU();
    }

    public float getAverageSessionLength() {
        return getFloat("ave_session_length_minutes");
    }

    public int getDaysSinceLastPlayed() {
        return getInteger("days_since_last_played");
    }

    public int getNumberOfPurchases() {
        return getInteger("num_purchases");
    }

    public int getNumberOfSessions() {
        return getInteger("num_sessions");
    }

    public float getSessionPercentile() {
        return getFloat("num_sessions_percentile");
    }

    public float getSpendPercentile() {
        return getFloat("spend_percentile");
    }

    public int hashCode() {
        return PlayerStatsEntity.zza(this);
    }

    public String toString() {
        return PlayerStatsEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerStatsEntity) zzvU()).writeToParcel(dest, flags);
    }

    public float zzvT() {
        return getFloat("churn_probability");
    }

    public PlayerStats zzvU() {
        return new PlayerStatsEntity(this);
    }
}
