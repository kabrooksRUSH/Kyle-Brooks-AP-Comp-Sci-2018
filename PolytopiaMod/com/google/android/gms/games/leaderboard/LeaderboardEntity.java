package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzmo;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    private final String zzTa;
    private final String zzatF;
    private final Uri zzatu;
    private final String zzazT;
    private final int zzazU;
    private final ArrayList<LeaderboardVariantEntity> zzazV;
    private final Game zzazW;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.zzazT = leaderboard.getLeaderboardId();
        this.zzTa = leaderboard.getDisplayName();
        this.zzatu = leaderboard.getIconImageUri();
        this.zzatF = leaderboard.getIconImageUrl();
        this.zzazU = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.zzazW = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.zzazV = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzazV.add((LeaderboardVariantEntity) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    static int zza(Leaderboard leaderboard) {
        return zzw.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean zza(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return zzw.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && zzw.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && zzw.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && zzw.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && zzw.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String zzb(Leaderboard leaderboard) {
        return zzw.zzv(leaderboard).zzg("LeaderboardId", leaderboard.getLeaderboardId()).zzg("DisplayName", leaderboard.getDisplayName()).zzg("IconImageUri", leaderboard.getIconImageUri()).zzg("IconImageUrl", leaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).zzg("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvG();
    }

    public String getDisplayName() {
        return this.zzTa;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzTa, dataOut);
    }

    public Game getGame() {
        return this.zzazW;
    }

    public Uri getIconImageUri() {
        return this.zzatu;
    }

    public String getIconImageUrl() {
        return this.zzatF;
    }

    public String getLeaderboardId() {
        return this.zzazT;
    }

    public int getScoreOrder() {
        return this.zzazU;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.zzazV);
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

    public Leaderboard zzvG() {
        return this;
    }
}
