package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends zzc implements LeaderboardScore {
    private final PlayerRef zzaAk;

    LeaderboardScoreRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.zzaAk = new PlayerRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvI();
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        zza("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        zza("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return zzcg("external_player_id") ? null : this.zzaAk;
    }

    public String getScoreHolderDisplayName() {
        return zzcg("external_player_id") ? getString("default_display_name") : this.zzaAk.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (zzcg("external_player_id")) {
            zza("default_display_name", dataOut);
        } else {
            this.zzaAk.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return zzcg("external_player_id") ? null : this.zzaAk.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return zzcg("external_player_id") ? null : this.zzaAk.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return zzcg("external_player_id") ? zzcf("default_display_image_uri") : this.zzaAk.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return zzcg("external_player_id") ? getString("default_display_image_url") : this.zzaAk.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    public LeaderboardScore zzvI() {
        return new LeaderboardScoreEntity(this);
    }
}
