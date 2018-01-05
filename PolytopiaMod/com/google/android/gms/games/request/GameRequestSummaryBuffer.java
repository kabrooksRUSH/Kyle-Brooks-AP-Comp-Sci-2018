package com.google.android.gms.games.request;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameRequestSummaryBuffer extends AbstractDataBuffer<GameRequestSummary> {
    public /* synthetic */ Object get(int x0) {
        return zzgt(x0);
    }

    public GameRequestSummary zzgt(int i) {
        return new GameRequestSummaryRef(this.zzabq, i);
    }
}
