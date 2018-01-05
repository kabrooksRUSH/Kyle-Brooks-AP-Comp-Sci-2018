package com.grumpycarrot.ane.playgameservices.player;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.grumpycarrot.ane.playgameservices.Extension;
import org.json.JSONException;
import org.json.JSONObject;

public class CurrentPlayer {

    class C07301 implements ResultCallback<LoadPlayerStatsResult> {
        C07301() {
        }

        public void onResult(LoadPlayerStatsResult result) {
            if (result.getStatus().isSuccess()) {
                PlayerStats stats = result.getPlayerStats();
                if (stats != null) {
                    Extension.logEvent("Stats Loaded : " + stats);
                    Extension.context.sendEventToAir("ON_PLAYERSTATS_LOADED", CurrentPlayer.this.StatsToJsonString(stats));
                    return;
                }
                Extension.logEvent("No stats available!");
            }
        }
    }

    public void checkPlayerStats() {
        Extension.logEvent("checkPlayerStats");
        Games.Stats.loadPlayerStats(Extension.context.getApiClient(), false).setResultCallback(new C07301());
    }

    private String StatsToJsonString(PlayerStats stats) {
        return StatsToJsonObject(stats).toString();
    }

    private JSONObject StatsToJsonObject(PlayerStats stats) {
        JSONObject jsonPlayerStats = new JSONObject();
        try {
            jsonPlayerStats.put("averageSessionLength", Float.toString(stats.getAverageSessionLength()));
            jsonPlayerStats.put("daysSinceLastPlayed", stats.getDaysSinceLastPlayed());
            jsonPlayerStats.put("numberOfPurchases", stats.getNumberOfPurchases());
            jsonPlayerStats.put("numberOfSessions", stats.getNumberOfSessions());
            jsonPlayerStats.put("sessionPercentile", Float.toString(stats.getSessionPercentile()));
            jsonPlayerStats.put("spendPercentile", Float.toString(stats.getSpendPercentile()));
        } catch (JSONException e) {
        }
        return jsonPlayerStats;
    }

    public String getActivePlayer() {
        Extension.logEvent("getActivePlayer");
        return PlayerToJsonObject(Games.Players.getCurrentPlayer(Extension.context.getApiClient())).toString();
    }

    public JSONObject PlayerToJsonObject(Player player) {
        JSONObject jsonPlayer = new JSONObject();
        if (player != null) {
            try {
                jsonPlayer.put("id", player.getPlayerId());
                jsonPlayer.put("displayName", player.getDisplayName());
                jsonPlayer.put("iconImageUri", Extension.context.getUriString(player.getIconImageUri()));
                jsonPlayer.put("iconImageUrl", player.getIconImageUrl());
                jsonPlayer.put("hiResImageUri", Extension.context.getUriString(player.getHiResImageUri()));
                jsonPlayer.put("hiResImageUrl", player.getHiResImageUrl());
            } catch (JSONException e) {
            }
        }
        return jsonPlayer;
    }
}
