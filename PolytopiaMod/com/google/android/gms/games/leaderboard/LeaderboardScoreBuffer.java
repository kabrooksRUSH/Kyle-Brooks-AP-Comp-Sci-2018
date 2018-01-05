package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader zzazX;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzazX = new LeaderboardScoreBufferHeader(dataHolder.zzor());
    }

    public LeaderboardScore get(int position) {
        return new LeaderboardScoreRef(this.zzabq, position);
    }

    public LeaderboardScoreBufferHeader zzvH() {
        return this.zzazX;
    }
}
