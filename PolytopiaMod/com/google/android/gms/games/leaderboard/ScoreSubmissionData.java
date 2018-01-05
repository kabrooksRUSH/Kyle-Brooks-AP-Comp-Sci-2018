package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] zzazR = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private String zzYf;
    private int zzYm;
    private HashMap<Integer, Result> zzaAx = new HashMap();
    private String zzazT;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return zzw.zzv(this).zzg("RawScore", Long.valueOf(this.rawScore)).zzg("FormattedScore", this.formattedScore).zzg("ScoreTag", this.scoreTag).zzg("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzYm = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        zzx.zzaa(count == 3);
        for (int i = 0; i < count; i++) {
            int zzbt = dataHolder.zzbt(i);
            if (i == 0) {
                this.zzazT = dataHolder.zzd("leaderboardId", i, zzbt);
                this.zzYf = dataHolder.zzd("playerId", i, zzbt);
            }
            if (dataHolder.zze("hasResult", i, zzbt)) {
                zza(new Result(dataHolder.zzb("rawScore", i, zzbt), dataHolder.zzd("formattedScore", i, zzbt), dataHolder.zzd("scoreTag", i, zzbt), dataHolder.zze("newBest", i, zzbt)), dataHolder.zzc("timeSpan", i, zzbt));
            }
        }
    }

    private void zza(Result result, int i) {
        this.zzaAx.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.zzazT;
    }

    public String getPlayerId() {
        return this.zzYf;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.zzaAx.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        zza zzg = zzw.zzv(this).zzg("PlayerId", this.zzYf).zzg("StatusCode", Integer.valueOf(this.zzYm));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.zzaAx.get(Integer.valueOf(i));
            zzg.zzg("TimesSpan", TimeSpan.zzfZ(i));
            zzg.zzg("Result", result == null ? "null" : result.toString());
        }
        return zzg.toString();
    }
}
