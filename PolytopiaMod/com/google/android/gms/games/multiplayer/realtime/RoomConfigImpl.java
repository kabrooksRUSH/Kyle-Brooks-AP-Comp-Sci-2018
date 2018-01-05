package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig.Builder;

public final class RoomConfigImpl extends RoomConfig {
    private final int zzaAD;
    private final RoomUpdateListener zzaAO;
    private final RoomStatusUpdateListener zzaAP;
    private final RealTimeMessageReceivedListener zzaAQ;
    private final Bundle zzaAT;
    private final String[] zzaAU;
    private final String zzavC;

    RoomConfigImpl(Builder builder) {
        this.zzaAO = builder.zzaAO;
        this.zzaAP = builder.zzaAP;
        this.zzaAQ = builder.zzaAQ;
        this.zzavC = builder.zzaAR;
        this.zzaAD = builder.zzaAD;
        this.zzaAT = builder.zzaAT;
        this.zzaAU = (String[]) builder.zzaAS.toArray(new String[builder.zzaAS.size()]);
        zzx.zzb(this.zzaAQ, (Object) "Must specify a message listener");
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzaAT;
    }

    public String getInvitationId() {
        return this.zzavC;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzaAU;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzaAQ;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzaAP;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.zzaAO;
    }

    public int getVariant() {
        return this.zzaAD;
    }
}
