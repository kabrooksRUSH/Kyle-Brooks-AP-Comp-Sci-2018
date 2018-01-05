package com.grumpycarrot.ane.playgameservices.leaderboards;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.grumpycarrot.ane.playgameservices.Extension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameLeaderboards {
    private final int RC_UNUSED = 5001;

    class C07271 implements ResultCallback<LoadPlayerScoreResult> {
        C07271() {
        }

        public void onResult(LoadPlayerScoreResult result) {
            if (result.getStatus().isSuccess()) {
                LeaderboardScore leaderboardScore = result.getScore();
                if (leaderboardScore != null) {
                    Extension.context.sendEventToAir("ON_PLAYER_SCORE_LOADED", GameLeaderboards.this.leaderboardScoreToJsonObject(leaderboardScore).toString());
                    return;
                } else {
                    Extension.context.sendEventToAir("ON_PLAYER_SCORE_UNKNOWN");
                    return;
                }
            }
            Extension.context.sendEventToAir("ON_PLAYER_SCORE_LOAD_FAILED");
        }
    }

    class C07282 implements ResultCallback<LoadScoresResult> {
        C07282() {
        }

        public void onResult(LoadScoresResult result) {
            GameLeaderboards.this.processLoadScoresResult(result);
        }
    }

    class C07293 implements ResultCallback<LoadScoresResult> {
        C07293() {
        }

        public void onResult(LoadScoresResult result) {
            GameLeaderboards.this.processLoadScoresResult(result);
        }
    }

    public void showAllLeaderboards() {
        Extension.context.getActivity().startActivityForResult(Games.Leaderboards.getAllLeaderboardsIntent(Extension.context.getApiClient()), 5001);
    }

    public void showLeaderboard(String leaderboardId) {
        Extension.context.getActivity().startActivityForResult(Games.Leaderboards.getLeaderboardIntent(Extension.context.getApiClient(), leaderboardId), 5001);
    }

    public void reportScore(String leaderboardId, int highScore) {
        Games.Leaderboards.submitScore(Extension.context.getApiClient(), leaderboardId, (long) highScore);
    }

    public void currentPlayerLeaderboardScore(String leaderboardId, int span, int leaderboardCollection) {
        Games.Leaderboards.loadCurrentPlayerLeaderboardScore(Extension.context.getApiClient(), leaderboardId, span, leaderboardCollection).setResultCallback(new C07271());
    }

    private JSONObject leaderboardScoreToJsonObject(LeaderboardScore leaderboardScore) {
        JSONObject jsonScore = new JSONObject();
        try {
            jsonScore.put("displayRank", leaderboardScore.getDisplayRank());
            jsonScore.put("displayScore", leaderboardScore.getDisplayScore());
            jsonScore.put("rank", leaderboardScore.getRank());
            jsonScore.put("rawScore", leaderboardScore.getRawScore());
            jsonScore.put("player", Extension.context.currentPlayer.PlayerToJsonObject(leaderboardScore.getScoreHolder()));
        } catch (JSONException e) {
        }
        Extension.logEvent("jsonScore: " + jsonScore);
        return jsonScore;
    }

    public void getTopLeaderboard(String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        if (maxResults > 25) {
            maxResults = 25;
        } else if (maxResults < 1) {
            maxResults = 1;
        }
        Games.Leaderboards.loadTopScores(Extension.context.getApiClient(), leaderboardId, span, leaderboardCollection, maxResults, true).setResultCallback(new C07282());
    }

    public void getPlayerCenteredLeaderboard(String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        if (maxResults > 25) {
            maxResults = 25;
        } else if (maxResults < 1) {
            maxResults = 1;
        }
        Games.Leaderboards.loadPlayerCenteredScores(Extension.context.getApiClient(), leaderboardId, span, leaderboardCollection, maxResults, true).setResultCallback(new C07293());
    }

    public void processLoadScoresResult(LoadScoresResult result) {
        if (result.getStatus().isSuccess()) {
            LeaderboardScoreBuffer leaderboardScoreBuffer = result.getScores();
            Leaderboard leaderboard = result.getLeaderboard();
            if (leaderboardScoreBuffer == null) {
                Extension.context.sendEventToAir("ON_LEADERBOARD_FAILED");
                return;
            } else {
                Extension.context.sendEventToAir("ON_LEADERBOARD_LOADED", scoresResultToJsonObject(leaderboard, leaderboardScoreBuffer).toString());
                return;
            }
        }
        Extension.context.sendEventToAir("ON_LEADERBOARD_FAILED");
    }

    private JSONObject scoresResultToJsonObject(Leaderboard leaderboard, LeaderboardScoreBuffer scoreBuffer) {
        JSONObject jsonLeaderboard = new JSONObject();
        try {
            jsonLeaderboard.put("leaderboardId", leaderboard.getLeaderboardId());
            jsonLeaderboard.put("displayName", leaderboard.getDisplayName());
            jsonLeaderboard.put("iconImageUri", Extension.context.getUriString(leaderboard.getIconImageUri()));
            jsonLeaderboard.put("iconImageUrl", leaderboard.getIconImageUrl());
            jsonLeaderboard.put("leaderboardScores", scoreBufferToJsonArray(scoreBuffer));
        } catch (JSONException e) {
        }
        return jsonLeaderboard;
    }

    private JSONArray scoreBufferToJsonArray(LeaderboardScoreBuffer scoreBuffer) {
        int scoresNb = scoreBuffer.getCount();
        JSONArray jsonScores = new JSONArray();
        for (int i = 0; i < scoresNb; i++) {
            jsonScores.put(leaderboardScoreToJsonObject(scoreBuffer.get(i)));
        }
        return jsonScores;
    }
}
