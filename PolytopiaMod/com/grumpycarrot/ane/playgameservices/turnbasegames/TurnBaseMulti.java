package com.grumpycarrot.ane.playgameservices.turnbasegames;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.grumpycarrot.ane.playgameservices.Extension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TurnBaseMulti implements OnInvitationReceivedListener, OnTurnBasedMatchUpdateReceivedListener {
    public static final int RC_LOOK_AT_MATCHES = 10001;
    public static final int RC_SELECT_PLAYERS = 10000;

    class C07351 implements ResultCallback<InitiateMatchResult> {
        C07351() {
        }

        public void onResult(InitiateMatchResult result) {
            TurnBaseMulti.this.processInitiateMatchResult(result);
        }
    }

    class C07362 implements ResultCallback<LoadMatchesResult> {
        C07362() {
        }

        public void onResult(LoadMatchesResult result) {
            TurnBaseMulti.this.loadInvitationsProcessResult(result);
        }
    }

    class C07373 implements ResultCallback<InitiateMatchResult> {
        C07373() {
        }

        public void onResult(InitiateMatchResult result) {
            if (result.getStatus().isSuccess()) {
                Extension.context.sendEventToAir("ON_LOAD_MATCH_SUCCESS", TurnBaseMulti.this.TurnBasedMatchToJsonObject(result.getMatch()).toString());
            } else {
                Extension.context.sendEventToAir("ON_LOAD_MATCH_FAILED");
            }
        }
    }

    class C07384 implements ResultCallback<LoadMatchesResult> {
        C07384() {
        }

        public void onResult(LoadMatchesResult result) {
            if (result.getStatus().isSuccess()) {
                int totalMatches;
                int i;
                Extension.logEvent("loadMatchesProcessResult");
                LoadMatchesResponse loadMatchesResponse = result.getMatches();
                TurnBasedMatchBuffer myTurnMatches_Buffer = loadMatchesResponse.getMyTurnMatches();
                TurnBasedMatchBuffer theirTurnMatches_Buffer = loadMatchesResponse.getTheirTurnMatches();
                TurnBasedMatchBuffer completedMatches_Buffer = loadMatchesResponse.getCompletedMatches();
                JSONArray jsonArray = new JSONArray();
                if (myTurnMatches_Buffer != null) {
                    totalMatches = myTurnMatches_Buffer.getCount();
                    Extension.logEvent("myTurnMatches_Buffer" + totalMatches);
                    for (i = 0; i < totalMatches; i++) {
                        jsonArray.put(TurnBaseMulti.this.TurnBasedMatchToJsonObject((TurnBasedMatch) myTurnMatches_Buffer.get(i)));
                    }
                    myTurnMatches_Buffer.close();
                }
                if (theirTurnMatches_Buffer != null) {
                    totalMatches = theirTurnMatches_Buffer.getCount();
                    Extension.logEvent("theirTurnMatches_Buffer" + totalMatches);
                    for (i = 0; i < totalMatches; i++) {
                        jsonArray.put(TurnBaseMulti.this.TurnBasedMatchToJsonObject((TurnBasedMatch) theirTurnMatches_Buffer.get(i)));
                    }
                    theirTurnMatches_Buffer.close();
                }
                if (completedMatches_Buffer != null) {
                    totalMatches = completedMatches_Buffer.getCount();
                    Extension.logEvent("completedMatches_Buffer" + totalMatches);
                    for (i = 0; i < totalMatches; i++) {
                        jsonArray.put(TurnBaseMulti.this.TurnBasedMatchToJsonObject((TurnBasedMatch) completedMatches_Buffer.get(i)));
                    }
                    completedMatches_Buffer.close();
                }
                loadMatchesResponse.close();
                Extension.context.sendEventToAir("ON_LOAD_MATCHES_SUCCESS", jsonArray.toString());
                return;
            }
            Extension.context.sendEventToAir("ON_LOAD_MATCHES_FAILED");
        }
    }

    class C07395 implements ResultCallback<LoadMatchResult> {
        C07395() {
        }

        public void onResult(LoadMatchResult result) {
            if (result.getStatus().isSuccess()) {
                Extension.context.sendEventToAir("ON_LOAD_MATCH_SUCCESS", TurnBaseMulti.this.TurnBasedMatchToJsonObject(result.getMatch()).toString());
            } else {
                Extension.context.sendEventToAir("ON_LOAD_MATCH_FAILED");
            }
        }
    }

    class C07406 implements ResultCallback<UpdateMatchResult> {
        C07406() {
        }

        public void onResult(UpdateMatchResult result) {
            TurnBaseMulti.this.processUpdateMatchResult(result);
        }
    }

    class C07417 implements ResultCallback<UpdateMatchResult> {
        C07417() {
        }

        public void onResult(UpdateMatchResult result) {
            TurnBaseMulti.this.processUpdateMatchResult(result);
        }
    }

    class C07428 implements ResultCallback<UpdateMatchResult> {
        C07428() {
        }

        public void onResult(UpdateMatchResult result) {
            TurnBaseMulti.this.processUpdateMatchResult(result);
        }
    }

    class C07439 implements ResultCallback<InitiateMatchResult> {
        C07439() {
        }

        public void onResult(InitiateMatchResult result) {
            TurnBaseMulti.this.processInitiateMatchResult(result);
        }
    }

    public TurnBaseMulti() {
        Extension.logEvent("TurnBaseMulti init");
    }

    public void registerTurnBaseMultiListeners() {
        Extension.logEvent("registerTurnBaseMultiListeners");
        Games.Invitations.registerInvitationListener(Extension.context.getApiClient(), this);
        Games.TurnBasedMultiplayer.registerMatchUpdateListener(Extension.context.getApiClient(), this);
    }

    public void unregisterTurnBaseMultiListeners() {
        Games.Invitations.unregisterInvitationListener(Extension.context.getApiClient());
        Games.TurnBasedMultiplayer.unregisterMatchUpdateListener(Extension.context.getApiClient());
    }

    public void selectOpponents(int minPlayersToSelect, int maxPlayersToSelect, boolean allowAutomatch) {
        Extension.logEvent("TurnBaseMulti selectOpponents");
        Extension.context.getActivity().startActivityForResult(Games.TurnBasedMultiplayer.getSelectOpponentsIntent(Extension.context.getApiClient(), minPlayersToSelect, maxPlayersToSelect, allowAutomatch), 10000);
    }

    public void onActivityResult_ForSelectPlayers(int responseCode, Intent intent) {
        Extension.logEvent("TurnBaseMulti selectPlayers RESULT ");
        if (responseCode != -1) {
            Extension.logEvent("User Cancel Select");
            Extension.context.sendEventToAir("ON_CREATE_MATCH_UI_CANCELED");
            return;
        }
        Bundle autoMatchCriteria;
        ArrayList<String> invitees = intent.getStringArrayListExtra(Games.EXTRA_PLAYER_IDS);
        int minAutoMatchPlayers = intent.getIntExtra(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, 0);
        int maxAutoMatchPlayers = intent.getIntExtra(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, 0);
        if (minAutoMatchPlayers > 0) {
            autoMatchCriteria = RoomConfig.createAutoMatchCriteria(minAutoMatchPlayers, maxAutoMatchPlayers, 0);
        } else {
            autoMatchCriteria = null;
        }
        createGame(TurnBasedMatchConfig.builder().addInvitedPlayers(invitees).setAutoMatchCriteria(autoMatchCriteria).build());
    }

    public void createAutoMatch(int minPlayersToSelect, int maxPlayersToSelect) {
        createGame(TurnBasedMatchConfig.builder().setAutoMatchCriteria(RoomConfig.createAutoMatchCriteria(minPlayersToSelect, maxPlayersToSelect, 0)).build());
    }

    private void createGame(TurnBasedMatchConfig tbmc) {
        Games.TurnBasedMultiplayer.createMatch(Extension.context.getApiClient(), tbmc).setResultCallback(new C07351());
    }

    private void processInitiateMatchResult(InitiateMatchResult result) {
        Extension.logEvent("InitiateMatchResult");
        if (result.getStatus().isSuccess()) {
            Extension.context.sendEventToAir("ON_INITIATE_MATCH_SUCCESS", TurnBasedMatchToJsonObject(result.getMatch()).toString());
        } else {
            Extension.context.sendEventToAir("ON_INITIATE_MATCH_FAILED");
        }
    }

    public void loadInvitations(int invitationSortOrder) {
        Games.TurnBasedMultiplayer.loadMatchesByStatus(Extension.context.getApiClient(), invitationSortOrder, new int[1]).setResultCallback(new C07362());
    }

    private void loadInvitationsProcessResult(LoadMatchesResult result) {
        Extension.logEvent("loadInvitationsProcessResult");
        if (result.getStatus().isSuccess()) {
            LoadMatchesResponse loadMatchesResponse = result.getMatches();
            InvitationBuffer invitationBuffer = loadMatchesResponse.getInvitations();
            if (invitationBuffer != null) {
                JSONArray jsonArray = new JSONArray();
                int totalInvitation = invitationBuffer.getCount();
                Extension.logEvent("totalInvitation " + totalInvitation);
                for (int i = 0; i < totalInvitation; i++) {
                    jsonArray.put(InvitationToJsonObject((Invitation) invitationBuffer.get(i)));
                }
                invitationBuffer.close();
                loadMatchesResponse.close();
                Extension.context.sendEventToAir("ON_LOAD_INVITATIONS_SUCCESS", jsonArray.toString());
                return;
            }
            Extension.logEvent("invitationBuffer is null");
            Extension.context.sendEventToAir("ON_LOAD_INVITATIONS_FAILED");
            return;
        }
        Extension.logEvent("ON_LOAD_INVITATIONS_FAILED");
        Extension.context.sendEventToAir("ON_LOAD_INVITATIONS_FAILED");
    }

    public void acceptInvitation(String invitationId) {
        Games.TurnBasedMultiplayer.acceptInvitation(Extension.context.getApiClient(), invitationId).setResultCallback(new C07373());
    }

    public void declineInvitation(String invitationId) {
        Games.TurnBasedMultiplayer.declineInvitation(Extension.context.getApiClient(), invitationId);
    }

    public void dismissInvitation(String invitationId) {
        Games.TurnBasedMultiplayer.dismissInvitation(Extension.context.getApiClient(), invitationId);
    }

    public void loadMatchesByStatus(int[] matchTurnStatuses) {
        Extension.logEvent("loadMatchesByStatus " + matchTurnStatuses[0]);
        Games.TurnBasedMultiplayer.loadMatchesByStatus(Extension.context.getApiClient(), matchTurnStatuses).setResultCallback(new C07384());
    }

    public void loadMatch(String matchId) {
        Extension.logEvent("loadMatch");
        Games.TurnBasedMultiplayer.loadMatch(Extension.context.getApiClient(), matchId).setResultCallback(new C07395());
    }

    public void lookAtMatches_UI() {
        Extension.logEvent("lookAtMatches_UI");
        Extension.context.getActivity().startActivityForResult(Games.TurnBasedMultiplayer.getInboxIntent(Extension.context.getApiClient()), 10001);
    }

    public void onActivityResult_LookAtMatches(int responseCode, Intent intent) {
        Extension.logEvent("onActivityResult_LookAtMatches");
        if (responseCode != -1) {
            Extension.context.sendEventToAir("ON_LOOK_AT_MATCH_UI_CANCELED");
            return;
        }
        TurnBasedMatch match = (TurnBasedMatch) intent.getParcelableExtra(Multiplayer.EXTRA_TURN_BASED_MATCH);
        if (match != null) {
            Extension.logEvent("TurnBasedMatch Selected");
            Extension.context.sendEventToAir("ON_LOAD_MATCH_SUCCESS", TurnBasedMatchToJsonObject(match).toString());
        }
    }

    public void takeTurn(String matchId, String nextParticipantId, String dataToSend) {
        Extension.logEvent("TakeTurn");
        Games.TurnBasedMultiplayer.takeTurn(Extension.context.getApiClient(), matchId, convertStringToBytes(dataToSend), nextParticipantId).setResultCallback(new C07406());
    }

    private void processUpdateMatchResult(UpdateMatchResult result) {
        Extension.logEvent("UpdateMatchResult");
        if (result.getStatus().isSuccess()) {
            Extension.context.sendEventToAir("ON_UPDATE_MATCH_SUCCESS", TurnBasedMatchToJsonObject(result.getMatch()).toString());
        } else {
            Extension.context.sendEventToAir("ON_UPDATE_MATCH_FAILED");
        }
    }

    public void finishMatchWithData(String matchId, String matchData) {
        Extension.logEvent("finishMatchWithData");
        Games.TurnBasedMultiplayer.finishMatch(Extension.context.getApiClient(), matchId, convertStringToBytes(matchData), new ParticipantResult[0]).setResultCallback(new C07417());
    }

    public void finishMatch(String matchId) {
        Extension.logEvent("finishMatch");
        Games.TurnBasedMultiplayer.finishMatch(Extension.context.getApiClient(), matchId).setResultCallback(new C07428());
    }

    public void rematch(String matchId) {
        Extension.logEvent("rematch");
        Games.TurnBasedMultiplayer.rematch(Extension.context.getApiClient(), matchId).setResultCallback(new C07439());
    }

    public void cancelMatch(String matchId) {
        Extension.logEvent("cancelMatch");
        Games.TurnBasedMultiplayer.cancelMatch(Extension.context.getApiClient(), matchId).setResultCallback(new ResultCallback<CancelMatchResult>() {
            public void onResult(CancelMatchResult result) {
                if (result.getStatus().isSuccess()) {
                    Extension.context.sendEventToAir("ON_CANCEL_MATCH_SUCCESS", result.getMatchId());
                } else {
                    Extension.context.sendEventToAir("ON_CANCEL_MATCH_FAILED");
                }
            }
        });
    }

    public void dismissMatch(String matchId) {
        Extension.logEvent("dismissMatch");
        Games.TurnBasedMultiplayer.dismissMatch(Extension.context.getApiClient(), matchId);
    }

    public void leaveMatch(String matchId) {
        Extension.logEvent("cancelMatch");
        Games.TurnBasedMultiplayer.leaveMatch(Extension.context.getApiClient(), matchId).setResultCallback(new ResultCallback<LeaveMatchResult>() {
            public void onResult(LeaveMatchResult result) {
                TurnBaseMulti.this.processLeaveMatchResult(result);
            }
        });
    }

    public void leaveMatchDuringTurn(String matchId, String pendingParticipantId) {
        Extension.logEvent("leaveMatchDuringTurn");
        Games.TurnBasedMultiplayer.leaveMatchDuringTurn(Extension.context.getApiClient(), matchId, pendingParticipantId).setResultCallback(new ResultCallback<LeaveMatchResult>() {
            public void onResult(LeaveMatchResult result) {
                TurnBaseMulti.this.processLeaveMatchResult(result);
            }
        });
    }

    private void processLeaveMatchResult(LeaveMatchResult result) {
        Extension.logEvent("LeaveMatchResult");
        if (result.getStatus().isSuccess()) {
            Extension.context.sendEventToAir("ON_LEAVE_MATCH_SUCCESS", TurnBasedMatchToJsonObject(result.getMatch()).toString());
        } else {
            Extension.context.sendEventToAir("ON_LEAVE_MATCH_FAILED");
        }
    }

    public void onTurnBasedMatchReceived(TurnBasedMatch match) {
        Extension.logEvent("->>> A match was updated");
        Extension.context.sendEventToAir("ON_NOTIFICATION_TBM_RECEIVED", TurnBasedMatchToJsonObject(match).toString());
    }

    public void onTurnBasedMatchRemoved(String matchId) {
        Extension.logEvent("->>> A match was removed");
        Extension.context.sendEventToAir("ON_NOTIFICATION_TBM_REMOVED", matchId);
    }

    public void onInvitationReceived(Invitation invitation) {
        Extension.logEvent("->>> An invitation has arrived");
        Extension.context.sendEventToAir("ON_NOTIFICATION_INVITATION_RECEIVED", InvitationToJsonObject(invitation).toString());
    }

    public void onInvitationRemoved(String invitationId) {
        Extension.logEvent("->>> An invitation was removed");
        Extension.context.sendEventToAir("ON_NOTIFICATION_INVITATION_REMOVED", invitationId);
    }

    private JSONObject TurnBasedMatchToJsonObject(TurnBasedMatch match) {
        int participantNumber;
        JSONObject jsonTurnBasedMatch = new JSONObject();
        JSONArray jsonParticipants = new JSONArray();
        if (match.getParticipants() == null) {
            participantNumber = 0;
        } else {
            participantNumber = match.getParticipants().size();
        }
        for (int i = 0; i < participantNumber; i++) {
            jsonParticipants.put(ParticipantToJsonObject((Participant) match.getParticipants().get(i)));
        }
        try {
            jsonTurnBasedMatch.put("matchId", match.getMatchId());
            jsonTurnBasedMatch.put("creationTimestamp", match.getCreationTimestamp());
            jsonTurnBasedMatch.put("creatorId", match.getCreatorId());
            jsonTurnBasedMatch.put("lastUpdatedTimestamp", match.getLastUpdatedTimestamp());
            jsonTurnBasedMatch.put("canRematch", match.canRematch());
            jsonTurnBasedMatch.put(Games.EXTRA_STATUS, match.getStatus());
            jsonTurnBasedMatch.put("turnStatus", match.getTurnStatus());
            jsonTurnBasedMatch.put("data", convertBytesToString(match.getData()));
            jsonTurnBasedMatch.put("pendingParticipantId", match.getPendingParticipantId());
            jsonTurnBasedMatch.put("totalParticipants", participantNumber);
            jsonTurnBasedMatch.put("participants", jsonParticipants);
            jsonTurnBasedMatch.put("availableAutoMatchSlots", match.getAvailableAutoMatchSlots());
            jsonTurnBasedMatch.put("myParticipantId", getCurrentPlayerParticipantId(match));
        } catch (JSONException e) {
        }
        return jsonTurnBasedMatch;
    }

    private JSONObject ParticipantToJsonObject(Participant participant) {
        String playerId;
        JSONObject jsonParticipant = new JSONObject();
        if (participant.getPlayer() != null) {
            playerId = participant.getPlayer().getPlayerId();
        } else {
            playerId = "Unknown";
        }
        try {
            jsonParticipant.put("participantId", participant.getParticipantId());
            jsonParticipant.put("playerId", playerId);
            jsonParticipant.put("displayName", participant.getDisplayName());
            jsonParticipant.put("iconImageUri", Extension.context.getUriString(participant.getIconImageUri()));
            jsonParticipant.put("iconImageUrl", participant.getIconImageUrl());
            jsonParticipant.put("hiResImageUri", Extension.context.getUriString(participant.getHiResImageUri()));
            jsonParticipant.put("hiResImageUrl", participant.getHiResImageUrl());
            jsonParticipant.put(Games.EXTRA_STATUS, participant.getStatus());
        } catch (JSONException e) {
        }
        return jsonParticipant;
    }

    private JSONObject InvitationToJsonObject(Invitation invitation) {
        JSONObject jsonInvitation = new JSONObject();
        try {
            jsonInvitation.put("invitationId", invitation.getInvitationId());
            jsonInvitation.put("invitationType", invitation.getInvitationType());
            jsonInvitation.put("creationTimestamp", invitation.getCreationTimestamp());
            jsonInvitation.put("inviter", ParticipantToJsonObject(invitation.getInviter()));
        } catch (JSONException e) {
        }
        return jsonInvitation;
    }

    private String getCurrentPlayerParticipantId(TurnBasedMatch match) {
        return match.getParticipantId(Games.Players.getCurrentPlayer(Extension.context.getApiClient()).getPlayerId());
    }

    private byte[] convertStringToBytes(String value) {
        return value.getBytes(Charset.forName("UTF-8"));
    }

    private String convertBytesToString(byte[] byteArray) {
        if (byteArray == null) {
            return "";
        }
        try {
            String st = new String(byteArray, "UTF-8");
            return st;
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
