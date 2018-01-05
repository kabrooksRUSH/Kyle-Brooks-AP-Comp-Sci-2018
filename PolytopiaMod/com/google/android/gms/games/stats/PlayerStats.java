package com.google.android.gms.games.stats;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface PlayerStats extends Parcelable, Freezable<PlayerStats> {
    public static final float UNSET_VALUE = -1.0f;

    float getAverageSessionLength();

    int getDaysSinceLastPlayed();

    int getNumberOfPurchases();

    int getNumberOfSessions();

    float getSessionPercentile();

    float getSpendPercentile();

    float zzvT();
}
