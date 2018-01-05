package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class InvitationBuffer extends zzf<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzo(i, i2);
    }

    protected Invitation zzo(int i, int i2) {
        return new InvitationRef(this.zzabq, i, i2);
    }

    protected String zzoy() {
        return "external_invitation_id";
    }
}
