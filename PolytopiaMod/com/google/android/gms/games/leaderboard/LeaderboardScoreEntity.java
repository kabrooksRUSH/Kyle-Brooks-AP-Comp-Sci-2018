package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final String zzaAa;
    private final long zzaAb;
    private final long zzaAc;
    private final String zzaAd;
    private final Uri zzaAe;
    private final Uri zzaAf;
    private final PlayerEntity zzaAg;
    private final String zzaAh;
    private final String zzaAi;
    private final String zzaAj;
    private final long zzazY;
    private final String zzazZ;

    public LeaderboardScoreEntity(LeaderboardScore score) {
        this.zzazY = score.getRank();
        this.zzazZ = (String) zzx.zzw(score.getDisplayRank());
        this.zzaAa = (String) zzx.zzw(score.getDisplayScore());
        this.zzaAb = score.getRawScore();
        this.zzaAc = score.getTimestampMillis();
        this.zzaAd = score.getScoreHolderDisplayName();
        this.zzaAe = score.getScoreHolderIconImageUri();
        this.zzaAf = score.getScoreHolderHiResImageUri();
        Player scoreHolder = score.getScoreHolder();
        this.zzaAg = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.zzaAh = score.getScoreTag();
        this.zzaAi = score.getScoreHolderIconImageUrl();
        this.zzaAj = score.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return zzw.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean zza(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return zzw.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && zzw.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && zzw.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && zzw.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && zzw.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && zzw.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && zzw.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && zzw.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && zzw.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && zzw.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return zzw.zzv(leaderboardScore).zzg("Rank", Long.valueOf(leaderboardScore.getRank())).zzg("DisplayRank", leaderboardScore.getDisplayRank()).zzg("Score", Long.valueOf(leaderboardScore.getRawScore())).zzg("DisplayScore", leaderboardScore.getDisplayScore()).zzg("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).zzg("DisplayName", leaderboardScore.getScoreHolderDisplayName()).zzg("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).zzg("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).zzg("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).zzg("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvI();
    }

    public String getDisplayRank() {
        return this.zzazZ;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzazZ, dataOut);
    }

    public String getDisplayScore() {
        return this.zzaAa;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzaAa, dataOut);
    }

    public long getRank() {
        return this.zzazY;
    }

    public long getRawScore() {
        return this.zzaAb;
    }

    public Player getScoreHolder() {
        return this.zzaAg;
    }

    public String getScoreHolderDisplayName() {
        return this.zzaAg == null ? this.zzaAd : this.zzaAg.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.zzaAg == null) {
            zzmo.zzb(this.zzaAd, dataOut);
        } else {
            this.zzaAg.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.zzaAg == null ? this.zzaAf : this.zzaAg.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.zzaAg == null ? this.zzaAj : this.zzaAg.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.zzaAg == null ? this.zzaAe : this.zzaAg.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.zzaAg == null ? this.zzaAi : this.zzaAg.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.zzaAh;
    }

    public long getTimestampMillis() {
        return this.zzaAc;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public LeaderboardScore zzvI() {
        return this;
    }
}
