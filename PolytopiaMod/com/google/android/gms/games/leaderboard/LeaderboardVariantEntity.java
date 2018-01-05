package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int zzaAl;
    private final int zzaAm;
    private final boolean zzaAn;
    private final long zzaAo;
    private final String zzaAp;
    private final long zzaAq;
    private final String zzaAr;
    private final String zzaAs;
    private final long zzaAt;
    private final String zzaAu;
    private final String zzaAv;
    private final String zzaAw;

    public LeaderboardVariantEntity(LeaderboardVariant variant) {
        this.zzaAl = variant.getTimeSpan();
        this.zzaAm = variant.getCollection();
        this.zzaAn = variant.hasPlayerInfo();
        this.zzaAo = variant.getRawPlayerScore();
        this.zzaAp = variant.getDisplayPlayerScore();
        this.zzaAq = variant.getPlayerRank();
        this.zzaAr = variant.getDisplayPlayerRank();
        this.zzaAs = variant.getPlayerScoreTag();
        this.zzaAt = variant.getNumScores();
        this.zzaAu = variant.zzvJ();
        this.zzaAv = variant.zzvK();
        this.zzaAw = variant.zzvL();
    }

    static int zza(LeaderboardVariant leaderboardVariant) {
        return zzw.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zzvJ(), leaderboardVariant.zzvL(), leaderboardVariant.zzvK());
    }

    static boolean zza(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzw.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && zzw.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && zzw.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && zzw.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && zzw.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && zzw.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && zzw.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && zzw.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && zzw.equal(leaderboardVariant2.zzvJ(), leaderboardVariant.zzvJ()) && zzw.equal(leaderboardVariant2.zzvL(), leaderboardVariant.zzvL()) && zzw.equal(leaderboardVariant2.zzvK(), leaderboardVariant.zzvK());
    }

    static String zzb(LeaderboardVariant leaderboardVariant) {
        return zzw.zzv(leaderboardVariant).zzg("TimeSpan", TimeSpan.zzfZ(leaderboardVariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzfZ(leaderboardVariant.getCollection())).zzg("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").zzg("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").zzg("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").zzg("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").zzg("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).zzg("TopPageNextToken", leaderboardVariant.zzvJ()).zzg("WindowPageNextToken", leaderboardVariant.zzvL()).zzg("WindowPagePrevToken", leaderboardVariant.zzvK()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvM();
    }

    public int getCollection() {
        return this.zzaAm;
    }

    public String getDisplayPlayerRank() {
        return this.zzaAr;
    }

    public String getDisplayPlayerScore() {
        return this.zzaAp;
    }

    public long getNumScores() {
        return this.zzaAt;
    }

    public long getPlayerRank() {
        return this.zzaAq;
    }

    public String getPlayerScoreTag() {
        return this.zzaAs;
    }

    public long getRawPlayerScore() {
        return this.zzaAo;
    }

    public int getTimeSpan() {
        return this.zzaAl;
    }

    public boolean hasPlayerInfo() {
        return this.zzaAn;
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

    public String zzvJ() {
        return this.zzaAu;
    }

    public String zzvK() {
        return this.zzaAv;
    }

    public String zzvL() {
        return this.zzaAw;
    }

    public LeaderboardVariant zzvM() {
        return this;
    }
}
