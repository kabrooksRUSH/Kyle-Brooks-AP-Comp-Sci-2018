package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer zzaAY;
    private final TurnBasedMatchBuffer zzaAZ;
    private final TurnBasedMatchBuffer zzaBa;
    private final TurnBasedMatchBuffer zzaBb;

    public LoadMatchesResponse(Bundle matchData) {
        DataHolder zza = zza(matchData, 0);
        if (zza != null) {
            this.zzaAY = new InvitationBuffer(zza);
        } else {
            this.zzaAY = null;
        }
        zza = zza(matchData, 1);
        if (zza != null) {
            this.zzaAZ = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzaAZ = null;
        }
        zza = zza(matchData, 2);
        if (zza != null) {
            this.zzaBa = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzaBa = null;
        }
        zza = zza(matchData, 3);
        if (zza != null) {
            this.zzaBb = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzaBb = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String zzfZ = TurnBasedMatchTurnStatus.zzfZ(i);
        return !bundle.containsKey(zzfZ) ? null : (DataHolder) bundle.getParcelable(zzfZ);
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzaBb;
    }

    public InvitationBuffer getInvitations() {
        return this.zzaAY;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzaAZ;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzaBa;
    }

    public boolean hasData() {
        return (this.zzaAY == null || this.zzaAY.getCount() <= 0) ? (this.zzaAZ == null || this.zzaAZ.getCount() <= 0) ? (this.zzaBa == null || this.zzaBa.getCount() <= 0) ? this.zzaBb != null && this.zzaBb.getCount() > 0 : true : true : true;
    }

    public void release() {
        if (this.zzaAY != null) {
            this.zzaAY.release();
        }
        if (this.zzaAZ != null) {
            this.zzaAZ.release();
        }
        if (this.zzaBa != null) {
            this.zzaBa.release();
        }
        if (this.zzaBb != null) {
            this.zzaBb.release();
        }
    }
}
