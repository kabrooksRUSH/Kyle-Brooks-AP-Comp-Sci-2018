package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef extends zzc implements ExperienceEvent {
    private final GameRef zzazi;

    public ExperienceEventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        if (zzcg("external_game_id")) {
            this.zzazi = null;
        } else {
            this.zzazi = new GameRef(this.zzabq, this.zzadl);
        }
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
