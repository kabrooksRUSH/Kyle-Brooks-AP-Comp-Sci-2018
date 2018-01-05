package com.grumpycarrot.ane.playgameservices.achievements;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.grumpycarrot.ane.playgameservices.Extension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Achievements {
    private final int RC_UNUSED = 5001;

    class C07241 implements ResultCallback<LoadAchievementsResult> {
        C07241() {
        }

        public void onResult(LoadAchievementsResult result) {
            if (result.getStatus().isSuccess()) {
                AchievementBuffer achievementBuffer = result.getAchievements();
                int totalAchi = achievementBuffer.getCount();
                Extension.logEvent("LoadAchievementsResult : " + totalAchi);
                JSONArray jsonAchievements = new JSONArray();
                for (int i = 0; i < totalAchi; i++) {
                    jsonAchievements.put(Achievements.this.AchievementToJsonObject(achievementBuffer.get(i)));
                }
                achievementBuffer.close();
                Extension.context.sendEventToAir("ON_ACHIEVEMENTS_LOADED", jsonAchievements.toString());
                return;
            }
            Extension.context.sendEventToAir("ON_ACHIEVEMENTS_LOADING_FAILED");
        }
    }

    public void showAchivements() {
        Extension.context.getActivity().startActivityForResult(Games.Achievements.getAchievementsIntent(Extension.context.getApiClient()), 5001);
    }

    public void revealAchivement(String achievementId) {
        Games.Achievements.reveal(Extension.context.getApiClient(), achievementId);
    }

    public void unlockAchivement(String achievementId) {
        Extension.logEvent("unlockAchivement ");
        Games.Achievements.unlock(Extension.context.getApiClient(), achievementId);
    }

    public void incrementAchivement(String achievementId, int numSteps) {
        Games.Achievements.increment(Extension.context.getApiClient(), achievementId, numSteps);
    }

    public void setStepsAchivement(String achievementId, int numSteps) {
        Games.Achievements.setSteps(Extension.context.getApiClient(), achievementId, numSteps);
    }

    public void loadAchievements(boolean forceReload) {
        Games.Achievements.load(Extension.context.getApiClient(), forceReload).setResultCallback(new C07241());
    }

    private JSONObject AchievementToJsonObject(Achievement achievement) {
        boolean isIncremental;
        if (achievement.getType() == 1) {
            isIncremental = true;
        } else {
            isIncremental = false;
        }
        JSONObject jsonAchievement = new JSONObject();
        try {
            jsonAchievement.put("achievementId", achievement.getAchievementId());
            jsonAchievement.put("name", achievement.getName());
            jsonAchievement.put("description", achievement.getDescription());
            jsonAchievement.put("state", achievement.getState());
            jsonAchievement.put("revealedImageUri", Extension.context.getUriString(achievement.getRevealedImageUri()));
            jsonAchievement.put("revealedImageUrl", achievement.getRevealedImageUrl());
            jsonAchievement.put("unlockedImageUri", Extension.context.getUriString(achievement.getUnlockedImageUri()));
            jsonAchievement.put("unlockedImageUrl", achievement.getUnlockedImageUrl());
            jsonAchievement.put("type", achievement.getType());
            jsonAchievement.put("xpValue", achievement.getXpValue());
            if (isIncremental) {
                jsonAchievement.put("currentSteps", achievement.getCurrentSteps());
                jsonAchievement.put("totalSteps", achievement.getTotalSteps());
            } else {
                jsonAchievement.put("currentSteps", -1);
                jsonAchievement.put("totalSteps", -1);
            }
        } catch (JSONException e) {
        }
        return jsonAchievement;
    }
}
