package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.zzlm;
import java.util.List;

public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
    private static <L> zzlm<L> zza(GoogleApiClient googleApiClient, L l) {
        return l == null ? null : googleApiClient.zzo(l);
    }

    public void create(GoogleApiClient apiClient, RoomConfig config) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zza(apiClient.zzo(config.getRoomUpdateListener()), zza(apiClient, config.getRoomStatusUpdateListener()), zza(apiClient, config.getMessageReceivedListener()), config);
        }
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzr(invitationId, 0);
        }
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzq(invitationId, 0);
        }
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.zzc(apiClient).zzc(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.zzc(apiClient).zzc(minPlayers, maxPlayers, allowAutomatch);
    }

    public Intent getWaitingRoomIntent(GoogleApiClient apiClient, Room room, int minParticipantsToStart) {
        return Games.zzc(apiClient).zza(room, minParticipantsToStart);
    }

    public void join(GoogleApiClient apiClient, RoomConfig config) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzb(apiClient.zzo(config.getRoomUpdateListener()), zza(apiClient, config.getRoomStatusUpdateListener()), zza(apiClient, config.getMessageReceivedListener()), config);
        }
    }

    public void leave(GoogleApiClient apiClient, RoomUpdateListener listener, String roomId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zza(apiClient.zzo(listener), roomId);
        }
    }

    public int sendReliableMessage(GoogleApiClient apiClient, ReliableMessageSentCallback callback, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.zzc(apiClient).zza(zza(apiClient, callback), messageData, roomId, recipientParticipantId);
    }

    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.zzc(apiClient).zza(messageData, roomId, new String[]{recipientParticipantId});
    }

    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, List<String> recipientParticipantIds) {
        return Games.zzc(apiClient).zza(messageData, roomId, (String[]) recipientParticipantIds.toArray(new String[recipientParticipantIds.size()]));
    }

    public int sendUnreliableMessageToOthers(GoogleApiClient apiClient, byte[] messageData, String roomId) {
        return Games.zzc(apiClient).zzd(messageData, roomId);
    }
}
