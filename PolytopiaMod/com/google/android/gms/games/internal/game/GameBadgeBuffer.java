package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameBadgeBuffer extends AbstractDataBuffer<GameBadge> {
    public /* synthetic */ Object get(int x0) {
        return zzgb(x0);
    }

    public GameBadge zzgb(int i) {
        return new GameBadgeRef(this.zzabq, i);
    }
}
