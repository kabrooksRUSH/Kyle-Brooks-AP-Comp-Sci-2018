package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder;

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int zzaAD;
    private final Bundle zzaAT;
    private final String[] zzaAU;
    private final int zzaBc;

    TurnBasedMatchConfigImpl(Builder builder) {
        this.zzaAD = builder.zzaAD;
        this.zzaBc = builder.zzaBc;
        this.zzaAT = builder.zzaAT;
        this.zzaAU = (String[]) builder.zzaAS.toArray(new String[builder.zzaAS.size()]);
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzaAT;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzaAU;
    }

    public int getVariant() {
        return this.zzaAD;
    }

    public int zzvN() {
        return this.zzaBc;
    }
}
