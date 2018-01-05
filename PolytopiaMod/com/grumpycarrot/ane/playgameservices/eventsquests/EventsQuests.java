package com.grumpycarrot.ane.playgameservices.eventsquests;

import android.content.Intent;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.grumpycarrot.ane.playgameservices.Extension;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventsQuests implements QuestUpdateListener {
    public static final int RC_QUEST = 12345;
    private static EventCallback eventCallback;
    private static QuestCallback questCallback;
    private ResultCallback<AcceptQuestResult> acceptQuestResultCallback;
    private ResultCallback<ClaimMilestoneResult> mClaimMilestoneResultCallback;

    class C07251 implements ResultCallback<AcceptQuestResult> {
        C07251() {
        }

        public void onResult(AcceptQuestResult result) {
            if (result.getStatus().isSuccess()) {
                Games.Quests.showStateChangedPopup(Extension.context.getApiClient(), result.getQuest().getQuestId());
                Extension.logEvent("Accepted succcess" + result.getQuest());
                Extension.context.sendEventToAir("ON_QUEST_ACCEPT_SUCCESS");
                return;
            }
            Extension.logEvent("Accepted Failed");
            Extension.context.sendEventToAir("ON_QUEST_ACCEPT_FAILED");
        }
    }

    class C07262 implements ResultCallback<ClaimMilestoneResult> {
        C07262() {
        }

        public void onResult(ClaimMilestoneResult result) {
            if (result.getStatus().isSuccess()) {
                String reward;
                try {
                    reward = new String(result.getQuest().getCurrentMilestone().getCompletionRewardData(), "UTF-8");
                    Extension.logEvent("Congratulations, you got a reward!");
                    Extension.context.sendEventToAir("ON_CLAIM_REWARD_SUCCESS", reward);
                    return;
                } catch (UnsupportedEncodingException e) {
                    reward = "Bad Data";
                    Extension.logEvent("Reward was not claimed due to error.");
                    Extension.context.sendEventToAir("ON_CLAIM_REWARD_FAILED");
                    return;
                }
            }
            Extension.logEvent("Reward was not claimed due to error.");
            Extension.context.sendEventToAir("ON_CLAIM_REWARD_FAILED");
        }
    }

    class EventCallback implements ResultCallback<LoadEventsResult> {
        public void onResult(LoadEventsResult result) {
            if (result.getStatus().isSuccess()) {
                EventBuffer eb = result.getEvents();
                Extension.logEvent("Event result found : " + eb.getCount());
                JSONArray jsonEvents = new JSONArray();
                for (int i = 0; i < eb.getCount(); i++) {
                    jsonEvents.put(EventsQuests.this.EventToJsonObject(eb.get(i)));
                }
                eb.close();
                Extension.context.sendEventToAir("ON_RETRIEVE_EVENT_SUCCESS", jsonEvents.toString());
                return;
            }
            Extension.context.sendEventToAir("ON_RETRIEVE_EVENT_FAILED");
        }
    }

    class QuestCallback implements ResultCallback<LoadQuestsResult> {
        public void onResult(LoadQuestsResult result) {
            if (result.getStatus().isSuccess()) {
                QuestBuffer qb = result.getQuests();
                Extension.logEvent("Number of quests:" + qb.getCount());
                JSONArray jsonQuests = new JSONArray();
                for (int i = 0; i < qb.getCount(); i++) {
                    jsonQuests.put(EventsQuests.this.QuestToJsonObject((Quest) qb.get(i)));
                }
                qb.close();
                Extension.context.sendEventToAir("ON_LOAD_QUESTS_SUCCESS", jsonQuests.toString());
                return;
            }
            Extension.context.sendEventToAir("ON_LOAD_QUESTS_FAILED");
        }
    }

    public void submitEvent(String eventId, int incrementAmount) {
        Extension.logEvent("submitEvent " + incrementAmount);
        if (incrementAmount > 0) {
            Games.Events.increment(Extension.context.getApiClient(), eventId, incrementAmount);
        }
    }

    public void retrieveEvent(boolean forceReload) {
        if (eventCallback == null) {
            eventCallback = new EventCallback();
        }
        Games.Events.load(Extension.context.getApiClient(), forceReload).setResultCallback(eventCallback);
    }

    public void retrieveEventById(String eventId, boolean forceReload) {
        if (eventCallback == null) {
            eventCallback = new EventCallback();
        }
        Games.Events.loadByIds(Extension.context.getApiClient(), forceReload, eventId).setResultCallback(eventCallback);
    }

    private JSONObject EventToJsonObject(Event event) {
        JSONObject jsonEvent = new JSONObject();
        try {
            jsonEvent.put("eventId", event.getEventId());
            jsonEvent.put("name", event.getName());
            jsonEvent.put("description", event.getDescription());
            jsonEvent.put("iconImageUrl", event.getIconImageUrl());
            jsonEvent.put("iconImageUri", Extension.context.getUriString(event.getIconImageUri()));
            jsonEvent.put("playerId", event.getPlayer().getPlayerId());
            jsonEvent.put("value", event.getValue());
            jsonEvent.put("formattedValue", event.getFormattedValue());
            jsonEvent.put("isVisible", event.isVisible());
        } catch (JSONException e) {
        }
        return jsonEvent;
    }

    public void showQuestsUI(int[] questSelector) {
        if (questSelector.length >= 1) {
            Extension.context.getActivity().startActivityForResult(Games.Quests.getQuestsIntent(Extension.context.getApiClient(), questSelector), RC_QUEST);
        }
    }

    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        if (responseCode != -1) {
            Extension.logEvent("User Cancel Quests Intent");
            Extension.context.sendEventToAir("ON_QUESTS_UI_CANCEL");
        } else if (intent != null && intent.hasExtra(Quests.EXTRA_QUEST)) {
            Extension.logEvent("EXTRA_QUEST");
            Quest quest = (Quest) intent.getParcelableExtra(Quests.EXTRA_QUEST);
            if (quest.getState() == 3) {
                Games.Quests.showStateChangedPopup(Extension.context.getApiClient(), quest.getQuestId());
                Extension.context.sendEventToAir("ON_QUESTS_UI_ACCEPTED", QuestToJsonObject(quest).toString());
            } else if (quest.getCurrentMilestone().getState() == 3) {
                Extension.context.sendEventToAir("ON_QUESTS_UI_CLAIM_REWARD", QuestToJsonObject(quest).toString());
            }
        }
    }

    public void loadQuests(int[] questSelector) {
        if (questSelector.length >= 1) {
            if (questCallback == null) {
                questCallback = new QuestCallback();
            }
            Games.Quests.load(Extension.context.getApiClient(), questSelector, 1, true).setResultCallback(questCallback);
        }
    }

    private JSONObject QuestToJsonObject(Quest quest) {
        JSONObject jsonQuest = new JSONObject();
        try {
            jsonQuest.put("questId", quest.getQuestId());
            jsonQuest.put("name", quest.getName());
            jsonQuest.put("description", quest.getDescription());
            jsonQuest.put("iconImageUrl", quest.getIconImageUrl());
            jsonQuest.put("bannerImageUrl", quest.getBannerImageUrl());
            jsonQuest.put("iconImageUri", Extension.context.getUriString(quest.getIconImageUri()));
            jsonQuest.put("bannerImageUri", Extension.context.getUriString(quest.getBannerImageUri()));
            jsonQuest.put("startTimestamp", quest.getStartTimestamp());
            jsonQuest.put("endTimestamp", quest.getEndTimestamp());
            jsonQuest.put("isEndingSoon", quest.isEndingSoon());
            jsonQuest.put("acceptedTimestamp", quest.getAcceptedTimestamp());
            jsonQuest.put("lastUpdatedTimestamp", quest.getLastUpdatedTimestamp());
            jsonQuest.put("state", quest.getState());
            jsonQuest.put("milestone", milestoneToJsonObject(quest.getCurrentMilestone()));
        } catch (JSONException e) {
        }
        return jsonQuest;
    }

    private JSONObject milestoneToJsonObject(Milestone milestone) {
        String rewardData;
        JSONObject jsonMilestone = new JSONObject();
        try {
            rewardData = new String(milestone.getCompletionRewardData(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            rewardData = "Bad Data";
        }
        try {
            jsonMilestone.put("milestoneId", milestone.getMilestoneId());
            jsonMilestone.put("eventId", milestone.getEventId());
            jsonMilestone.put("state", milestone.getState());
            jsonMilestone.put("currentProgress", milestone.getCurrentProgress());
            jsonMilestone.put("targetProgress", milestone.getTargetProgress());
            jsonMilestone.put("rewardData", rewardData);
        } catch (JSONException e2) {
        }
        return jsonMilestone;
    }

    public void acceptQuest(String questId) {
        createAcceptQuestResultCallback();
        Games.Quests.accept(Extension.context.getApiClient(), questId).setResultCallback(this.acceptQuestResultCallback);
    }

    private void createAcceptQuestResultCallback() {
        if (this.acceptQuestResultCallback == null) {
            this.acceptQuestResultCallback = new C07251();
        }
    }

    public void registerQuestUpdateListener() {
        Games.Quests.registerQuestUpdateListener(Extension.context.getApiClient(), this);
    }

    public void unregisterQuestUpdateListener() {
        Games.Quests.unregisterQuestUpdateListener(Extension.context.getApiClient());
    }

    public void onQuestCompleted(Quest quest) {
        Extension.logEvent("onQuestCompleted" + quest);
        claimReward(quest.getQuestId(), quest.getCurrentMilestone().getMilestoneId());
    }

    public void claimReward(String questId, String milestoneId) {
        createMilestoneResultCallback();
        Games.Quests.claim(Extension.context.getApiClient(), questId, milestoneId).setResultCallback(this.mClaimMilestoneResultCallback);
    }

    private void createMilestoneResultCallback() {
        if (this.mClaimMilestoneResultCallback == null) {
            this.mClaimMilestoneResultCallback = new C07262();
        }
    }
}
