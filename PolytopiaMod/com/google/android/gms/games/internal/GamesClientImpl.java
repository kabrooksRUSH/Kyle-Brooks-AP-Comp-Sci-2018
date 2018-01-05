package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
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
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.signin.internal.zzi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

public final class GamesClientImpl extends zzj<IGamesService> {
    EventIncrementManager zzavh = new C04171(this);
    private final String zzavi;
    private PlayerEntity zzavj;
    private GameEntity zzavk;
    private final PopupManager zzavl;
    private boolean zzavm = false;
    private final Binder zzavn;
    private final long zzavo;
    private final GamesOptions zzavp;

    class C04171 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl zzavq;

        C04171(GamesClientImpl gamesClientImpl) {
            this.zzavq = gamesClientImpl;
        }

        public EventIncrementCache zzuU() {
            return new GameClientEventIncrementCache(this.zzavq);
        }
    }

    private static abstract class AbstractRoomStatusNotifier extends zzld<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzX(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzavr = new ArrayList();

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder);
            for (Object add : participantIds) {
                this.zzavr.add(add);
            }
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzavr);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static abstract class AbstractRoomNotifier extends zzld<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzX(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class GamesDataHolderResult extends zzle {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzfG(dataHolder.getStatusCode()));
        }
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements AcceptQuestResult {
        private final Quest zzavs;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzavs = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzavs = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.zzavs;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<UpdateAchievementResult> zzagy;

        AchievementUpdatedBinderCallback(zzb<UpdateAchievementResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(int i, String str) {
            this.zzagy.zzp(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadAchievementsResult> zzagy;

        AchievementsLoadedBinderCallback(zzb<LoadAchievementsResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadAppContentResult> zzavt;

        public AppContentLoadedBinderCallbacks(zzb<LoadAppContentResult> resultHolder) {
            this.zzavt = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder[] dataHolderArr) {
            this.zzavt.zzp(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status zzSC;
        private final String zzavu;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.zzSC = status;
            this.zzavu = externalMatchId;
        }

        public String getMatchId() {
            return this.zzavu;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements ClaimMilestoneResult {
        private final Quest zzavs;
        private final Milestone zzavv;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzavs = new QuestEntity((Quest) questBuffer.get(0));
                    List zzvP = this.zzavs.zzvP();
                    int size = zzvP.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) zzvP.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.zzavv = (Milestone) zzvP.get(i);
                            return;
                        }
                    }
                    this.zzavv = null;
                } else {
                    this.zzavv = null;
                    this.zzavs = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.zzavv;
        }

        public Quest getQuest() {
            return this.zzavs;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements CommitSnapshotResult {
        private final SnapshotMetadata zzavw;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzavw = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzavw = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzavw;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<ContactSettingLoadResult> zzagy;

        ContactSettingsLoadedBinderCallback(zzb<ContactSettingLoadResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzI(DataHolder dataHolder) {
            this.zzagy.zzp(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzagy;

        ContactSettingsUpdatedBinderCallback(zzb<Status> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzfS(int i) {
            this.zzagy.zzp(GamesStatusCodes.zzfG(i));
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status zzSC;
        private final String zzavx;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.zzSC = GamesStatusCodes.zzfG(statusCode);
            this.zzavx = snapshotId;
        }

        public String getSnapshotId() {
            return this.zzavx;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadEventsResult> zzagy;

        EventsLoadedBinderCallback(zzb<LoadEventsResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzi(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadEventResultImpl(dataHolder));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl zzavq;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.zzavq = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT);
        }

        protected void zzs(String str, int i) {
            try {
                if (this.zzavq.isConnected()) {
                    ((IGamesService) this.zzavq.zzpc()).zzp(str, i);
                } else {
                    GamesLog.zzz("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                this.zzavq.zzb(e);
            }
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadGameInstancesResult> zzagy;

        GameInstancesLoadedBinderCallback(zzb<LoadGameInstancesResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzp(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status zzSC;
        private final String zzavy;
        private final boolean zzavz;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.zzSC = GamesStatusCodes.zzfG(statusCode);
            this.zzavy = externalGameId;
            this.zzavz = isMuted;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<GameMuteStatusChangeResult> zzagy;

        GameMuteStatusChangedBinderCallback(zzb<GameMuteStatusChangeResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zza(int i, String str, boolean z) {
            this.zzagy.zzp(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status zzSC;
        private final String zzavy;
        private final boolean zzavz;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzSC = GamesStatusCodes.zzfG(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzavy = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzavz = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzavy = null;
                    this.zzavz = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<GameMuteStatusLoadResult> zzagy;

        GameMuteStatusLoadedBinderCallback(zzb<GameMuteStatusLoadResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzG(DataHolder dataHolder) {
            this.zzagy.zzp(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadGameSearchSuggestionsResult> zzagy;

        GameSearchSuggestionsLoadedBinderCallback(zzb<LoadGameSearchSuggestionsResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzq(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadGamesResult> zzagy;

        GamesLoadedBinderCallback(zzb<LoadGamesResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzn(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Status zzSC;
        private final Bundle zzavA;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.zzSC = status;
            this.zzavA = inboxCounts;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<InboxCountResult> zzagy;

        InboxCountsLoadedBinderCallback(zzb<InboxCountResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzagy.zzp(new InboxCountResultImpl(GamesStatusCodes.zzfG(i), bundle));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzavY;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzavY = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzavY = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzavY;
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzlm<OnInvitationReceivedListener> zzakZ;

        InvitationReceivedBinderCallback(zzlm<OnInvitationReceivedListener> listener) {
            this.zzakZ = listener;
        }

        public void onInvitationRemoved(String invitationId) {
            this.zzakZ.zza(new InvitationRemovedNotifier(invitationId));
        }

        public void zzs(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.zzakZ.zza(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }
    }

    private static final class InvitationReceivedNotifier implements zzlm.zzb<OnInvitationReceivedListener> {
        private final Invitation zzavB;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzavB = invitation;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzavB);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class InvitationRemovedNotifier implements zzlm.zzb<OnInvitationReceivedListener> {
        private final String zzavC;

        InvitationRemovedNotifier(String invitationId) {
            this.zzavC = invitationId;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzavC);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadInvitationsResult> zzagy;

        InvitationsLoadedBinderCallback(zzb<LoadInvitationsResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzr(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements LeaderboardMetadataResult {
        private final LeaderboardBuffer zzavD;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzavD = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.zzavD;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadScoresResult> zzagy;

        LeaderboardScoresLoadedBinderCallback(zzb<LoadScoresResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzagy.zzp(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LeaderboardMetadataResult> zzagy;

        LeaderboardsLoadedBinderCallback(zzb<LeaderboardMetadataResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzj(DataHolder dataHolder) {
            this.zzagy.zzp(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeftRoomNotifier implements zzlm.zzb<RoomUpdateListener> {
        private final int zzYm;
        private final String zzavE;

        LeftRoomNotifier(int statusCode, String roomId) {
            this.zzYm = statusCode;
            this.zzavE = roomId;
        }

        public void zza(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzYm, this.zzavE);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((RoomUpdateListener) obj);
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements LoadAchievementsResult {
        private final AchievementBuffer zzavF;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzavF = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.zzavF;
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements LoadAppContentResult {
        private final ArrayList<DataHolder> zzavG;

        LoadAppContentsResultImpl(DataHolder[] appContentData) {
            super(appContentData[0]);
            this.zzavG = new ArrayList(Arrays.asList(appContentData));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements LoadEventsResult {
        private final EventBuffer zzavH;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzavH = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.zzavH;
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements LoadGameInstancesResult {
        private final GameInstanceBuffer zzavI;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzavI = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzavJ;

        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
            this.zzavJ = new GameSearchSuggestionBuffer(data);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements LoadGamesResult {
        private final GameBuffer zzavK;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzavK = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.zzavK;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements LoadInvitationsResult {
        private final InvitationBuffer zzavL;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzavL = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.zzavL;
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status zzSC;
        private final LoadMatchesResponse zzavM;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.zzSC = status;
            this.zzavM = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.zzavM;
        }

        public Status getStatus() {
            return this.zzSC;
        }

        public void release() {
            this.zzavM.release();
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzavN;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzavN = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzavN = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.zzavN;
        }
    }

    private static final class LoadPlayerStatsResultImpl extends GamesDataHolderResult implements LoadPlayerStatsResult {
        private final PlayerStats zzavO;

        LoadPlayerStatsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzavO = new PlayerStatsEntity(playerStatsBuffer.zzgy(0));
                } else {
                    this.zzavO = null;
                }
                playerStatsBuffer.release();
            } catch (Throwable th) {
                playerStatsBuffer.release();
            }
        }

        public PlayerStats getPlayerStats() {
            return this.zzavO;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements LoadPlayersResult {
        private final PlayerBuffer zzavP;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzavP = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.zzavP;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements LoadProfileSettingsResult {
        private final boolean zzavQ;
        private final boolean zzave;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int zzbt = dataHolder.zzbt(0);
                    this.zzave = dataHolder.zze("profile_visible", 0, zzbt);
                    this.zzavQ = dataHolder.zze("profile_visibility_explicitly_set", 0, zzbt);
                } else {
                    this.zzave = true;
                    this.zzavQ = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements LoadQuestsResult {
        private final DataHolder zzabq;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzabq = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzabq);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status zzSC;
        private final Bundle zzavR;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.zzSC = status;
            this.zzavR = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String zzfZ = RequestType.zzfZ(requestType);
            return !this.zzavR.containsKey(zzfZ) ? null : new GameRequestBuffer((DataHolder) this.zzavR.get(zzfZ));
        }

        public Status getStatus() {
            return this.zzSC;
        }

        public void release() {
            for (String parcelable : this.zzavR.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzavR.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements LoadScoresResult {
        private final LeaderboardEntity zzavS;
        private final LeaderboardScoreBuffer zzavT;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzavS = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzavS = null;
                }
                leaderboardBuffer.release();
                this.zzavT = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.zzavS;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzavT;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzabq);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status zzSC;
        private final List<String> zzavU;
        private final Bundle zzavV;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.zzSC = status;
            this.zzavU = xpData.getStringArrayList("game_category_list");
            this.zzavV = xpData;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements LoadXpStreamResult {
        private final ExperienceEventBuffer zzavW;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzavW = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchRemovedNotifier implements zzlm.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzavX;

        MatchRemovedNotifier(String matchId) {
            this.zzavX = matchId;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzavX);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzlm<OnTurnBasedMatchUpdateReceivedListener> zzakZ;

        MatchUpdateReceivedBinderCallback(zzlm<OnTurnBasedMatchUpdateReceivedListener> listener) {
            this.zzakZ = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.zzakZ.zza(new MatchRemovedNotifier(matchId));
        }

        public void zzy(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.zzakZ.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class MatchUpdateReceivedNotifier implements zzlm.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzavY;

        MatchUpdateReceivedNotifier(TurnBasedMatch match) {
            this.zzavY = match;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzavY);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MessageReceivedNotifier implements zzlm.zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzavZ;

        MessageReceivedNotifier(RealTimeMessage message) {
            this.zzavZ = message;
        }

        public void zza(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzavZ);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((RealTimeMessageReceivedListener) obj);
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements zzlm.zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzawa;

        public void zza(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzawa);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((OnNearbyPlayerDetectedListener) obj);
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadAclResult> zzagy;

        NotifyAclLoadedBinderCallback(zzb<LoadAclResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzH(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzagy;

        NotifyAclUpdatedBinderCallback(zzb<Status> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzfR(int i) {
            this.zzagy.zzp(GamesStatusCodes.zzfG(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements OpenSnapshotResult {
        private final Snapshot zzawb;
        private final String zzawc;
        private final Snapshot zzawd;
        private final Contents zzawe;
        private final SnapshotContents zzawf;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzawb = null;
                    this.zzawd = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == GamesStatusCodes.STATUS_SNAPSHOT_CONFLICT) {
                        z = false;
                    }
                    com.google.android.gms.common.internal.zzb.zzZ(z);
                    this.zzawb = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzawd = null;
                } else {
                    this.zzawb = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzawd = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.zzawc = conflictId;
                this.zzawe = resolutionContents;
                this.zzawf = new SnapshotContentsEntity(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.zzawc;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzawd;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzawf;
        }

        public Snapshot getSnapshot() {
            return this.zzawb;
        }
    }

    private static final class P2PConnectedNotifier implements zzlm.zzb<RoomStatusUpdateListener> {
        private final String zzawg;

        P2PConnectedNotifier(String participantId) {
            this.zzawg = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzawg);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class P2PDisconnectedNotifier implements zzlm.zzb<RoomStatusUpdateListener> {
        private final String zzawg;

        P2PDisconnectedNotifier(String participantId) {
            this.zzawg = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzawg);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadPlayerScoreResult> zzagy;

        PlayerLeaderboardScoreLoadedBinderCallback(zzb<LoadPlayerScoreResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzJ(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadPlayerStatsResult> zzagy;

        public PlayerStatsLoadedBinderCallbacks(zzb<LoadPlayerStatsResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzW(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadPlayerStatsResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadXpForGameCategoriesResult> zzagy;

        PlayerXpForGameCategoriesLoadedBinderCallback(zzb<LoadXpForGameCategoriesResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzagy.zzp(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzfG(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadXpStreamResult> zzagy;

        PlayerXpStreamLoadedBinderCallback(zzb<LoadXpStreamResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzU(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadPlayersResult> zzagy;

        PlayersLoadedBinderCallback(zzb<LoadPlayersResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzl(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadPlayersResultImpl(dataHolder));
        }

        public void zzm(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzavl;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzavl = popupManager;
        }

        public PopupLocationInfoParcelable zzus() {
            return new PopupLocationInfoParcelable(this.zzavl.zzvi());
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<LoadProfileSettingsResult> zzagy;

        ProfileSettingsLoadedBinderCallback(zzb<LoadProfileSettingsResult> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzV(DataHolder dataHolder) {
            this.zzagy.zzp(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzb<Status> zzagy;

        ProfileSettingsUpdatedBinderCallback(zzb<Status> holder) {
            this.zzagy = (zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzfT(int i) {
            this.zzagy.zzp(GamesStatusCodes.zzfG(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<AcceptQuestResult> zzawh;

        public QuestAcceptedBinderCallbacks(zzb<AcceptQuestResult> resultHolder) {
            this.zzawh = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzQ(DataHolder dataHolder) {
            this.zzawh.zzp(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestCompletedNotifier implements zzlm.zzb<QuestUpdateListener> {
        private final Quest zzavs;

        QuestCompletedNotifier(Quest quest) {
            this.zzavs = quest;
        }

        public void zza(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzavs);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((QuestUpdateListener) obj);
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<ClaimMilestoneResult> zzawi;
        private final String zzawj;

        public QuestMilestoneClaimBinderCallbacks(zzb<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.zzawi = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
            this.zzawj = (String) zzx.zzb((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        public void zzP(DataHolder dataHolder) {
            this.zzawi.zzp(new ClaimMilestoneResultImpl(dataHolder, this.zzawj));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zzlm<QuestUpdateListener> zzakZ;

        QuestUpdateBinderCallback(zzlm<QuestUpdateListener> listener) {
            this.zzakZ = listener;
        }

        private Quest zzZ(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public void zzR(DataHolder dataHolder) {
            Quest zzZ = zzZ(dataHolder);
            if (zzZ != null) {
                this.zzakZ.zza(new QuestCompletedNotifier(zzZ));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadQuestsResult> zzawk;

        public QuestsLoadedBinderCallbacks(zzb<LoadQuestsResult> resultHolder) {
            this.zzawk = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzT(DataHolder dataHolder) {
            this.zzawk.zzp(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeMessageSentNotifier implements zzlm.zzb<ReliableMessageSentCallback> {
        private final int zzYm;
        private final String zzawl;
        private final int zzawm;

        RealTimeMessageSentNotifier(int statusCode, int token, String recipientParticipantId) {
            this.zzYm = statusCode;
            this.zzawm = token;
            this.zzawl = recipientParticipantId;
        }

        public void zza(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzYm, this.zzawm, this.zzawl);
            }
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((ReliableMessageSentCallback) obj);
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zzlm<ReliableMessageSentCallback> zzawn;

        public RealTimeReliableMessageBinderCallbacks(zzlm<ReliableMessageSentCallback> messageSentCallbacks) {
            this.zzawn = messageSentCallbacks;
        }

        public void zzb(int i, int i2, String str) {
            if (this.zzawn != null) {
                this.zzawn.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzlm<OnRequestReceivedListener> zzakZ;

        RequestReceivedBinderCallback(zzlm<OnRequestReceivedListener> listener) {
            this.zzakZ = listener;
        }

        public void onRequestRemoved(String requestId) {
            this.zzakZ.zza(new RequestRemovedNotifier(requestId));
        }

        public void zzt(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.zzakZ.zza(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class RequestReceivedNotifier implements zzlm.zzb<OnRequestReceivedListener> {
        private final GameRequest zzawo;

        RequestReceivedNotifier(GameRequest request) {
            this.zzawo = request;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzawo);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static final class RequestRemovedNotifier implements zzlm.zzb<OnRequestReceivedListener> {
        private final String zzBY;

        RequestRemovedNotifier(String requestId) {
            this.zzBY = requestId;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzBY);
        }

        public void zznN() {
        }

        public /* synthetic */ void zzq(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<SendRequestResult> zzawp;

        public RequestSentBinderCallbacks(zzb<SendRequestResult> resultHolder) {
            this.zzawp = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzL(DataHolder dataHolder) {
            this.zzawp.zzp(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadRequestSummariesResult> zzawq;

        public RequestSummariesLoadedBinderCallbacks(zzb<LoadRequestSummariesResult> resultHolder) {
            this.zzawq = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzM(DataHolder dataHolder) {
            this.zzawq.zzp(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadRequestsResult> zzawr;

        public RequestsLoadedBinderCallbacks(zzb<LoadRequestsResult> resultHolder) {
            this.zzawr = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzawr.zzp(new LoadRequestsResultImpl(GamesStatusCodes.zzfG(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<UpdateRequestsResult> zzaws;

        public RequestsUpdatedBinderCallbacks(zzb<UpdateRequestsResult> resultHolder) {
            this.zzaws = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzK(DataHolder dataHolder) {
            this.zzaws.zzp(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlm<? extends RoomUpdateListener> zzawt;
        private final zzlm<? extends RoomStatusUpdateListener> zzawu;
        private final zzlm<RealTimeMessageReceivedListener> zzawv;

        public RoomBinderCallbacks(zzlm<RoomUpdateListener> roomCallbacks) {
            this.zzawt = (zzlm) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzawu = null;
            this.zzawv = null;
        }

        public RoomBinderCallbacks(zzlm<? extends RoomUpdateListener> roomCallbacks, zzlm<? extends RoomStatusUpdateListener> roomStatusCallbacks, zzlm<RealTimeMessageReceivedListener> realTimeMessageReceivedCallbacks) {
            this.zzawt = (zzlm) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzawu = roomStatusCallbacks;
            this.zzawv = realTimeMessageReceivedCallbacks;
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.zzawt.zza(new LeftRoomNotifier(statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            if (this.zzawu != null) {
                this.zzawu.zza(new P2PConnectedNotifier(participantId));
            }
        }

        public void onP2PDisconnected(String participantId) {
            if (this.zzawu != null) {
                this.zzawu.zza(new P2PDisconnectedNotifier(participantId));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            if (this.zzawv != null) {
                this.zzawv.zza(new MessageReceivedNotifier(message));
            }
        }

        public void zzA(DataHolder dataHolder) {
            this.zzawt.zza(new JoinedRoomNotifier(dataHolder));
        }

        public void zzB(DataHolder dataHolder) {
            if (this.zzawu != null) {
                this.zzawu.zza(new RoomConnectingNotifier(dataHolder));
            }
        }

        public void zzC(DataHolder dataHolder) {
            if (this.zzawu != null) {
                this.zzawu.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void zzD(DataHolder dataHolder) {
            this.zzawt.zza(new RoomConnectedNotifier(dataHolder));
        }

        public void zzE(DataHolder dataHolder) {
            if (this.zzawu != null) {
                this.zzawu.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        public void zzF(DataHolder dataHolder) {
            if (this.zzawu != null) {
                this.zzawu.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzawu != null) {
                this.zzawu.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzawu != null) {
                this.zzawu.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzawu != null) {
                this.zzawu.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzawu != null) {
                this.zzawu.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzawu != null) {
                this.zzawu.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzawu != null) {
                this.zzawu.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzz(DataHolder dataHolder) {
            this.zzawt.zza(new RoomCreatedNotifier(dataHolder));
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements SendRequestResult {
        private final GameRequest zzawo;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzawo = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzawo = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<Status> zzagy;

        public SignOutCompleteBinderCallbacks(zzb<Status> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzur() {
            this.zzagy.zzp(GamesStatusCodes.zzfG(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<CommitSnapshotResult> zzaww;

        public SnapshotCommittedBinderCallbacks(zzb<CommitSnapshotResult> resultHolder) {
            this.zzaww = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzO(DataHolder dataHolder) {
            this.zzaww.zzp(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<DeleteSnapshotResult> zzagy;

        public SnapshotDeletedBinderCallbacks(zzb<DeleteSnapshotResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzj(int i, String str) {
            this.zzagy.zzp(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<OpenSnapshotResult> zzawx;

        public SnapshotOpenedBinderCallbacks(zzb<OpenSnapshotResult> resultHolder) {
            this.zzawx = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzawx.zzp(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzawx.zzp(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadSnapshotsResult> zzawy;

        public SnapshotsLoadedBinderCallbacks(zzb<LoadSnapshotsResult> resultHolder) {
            this.zzawy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzN(DataHolder dataHolder) {
            this.zzawy.zzp(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<SubmitScoreResult> zzagy;

        public SubmitScoreBinderCallbacks(zzb<SubmitScoreResult> resultHolder) {
            this.zzagy = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzk(DataHolder dataHolder) {
            this.zzagy.zzp(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements SubmitScoreResult {
        private final ScoreSubmissionData zzawz;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzawz = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.zzawz;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<CancelMatchResult> zzawA;

        public TurnBasedMatchCanceledBinderCallbacks(zzb<CancelMatchResult> resultHolder) {
            this.zzawA = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzi(int i, String str) {
            this.zzawA.zzp(new CancelMatchResultImpl(GamesStatusCodes.zzfG(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<InitiateMatchResult> zzawB;

        public TurnBasedMatchInitiatedBinderCallbacks(zzb<InitiateMatchResult> resultHolder) {
            this.zzawB = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzv(DataHolder dataHolder) {
            this.zzawB.zzp(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LeaveMatchResult> zzawC;

        public TurnBasedMatchLeftBinderCallbacks(zzb<LeaveMatchResult> resultHolder) {
            this.zzawC = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzx(DataHolder dataHolder) {
            this.zzawC.zzp(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadMatchResult> zzawD;

        public TurnBasedMatchLoadedBinderCallbacks(zzb<LoadMatchResult> resultHolder) {
            this.zzawD = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzu(DataHolder dataHolder) {
            this.zzawD.zzp(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<UpdateMatchResult> zzawE;

        public TurnBasedMatchUpdatedBinderCallbacks(zzb<UpdateMatchResult> resultHolder) {
            this.zzawE = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzw(DataHolder dataHolder) {
            this.zzawE.zzp(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzb<LoadMatchesResult> zzawF;

        public TurnBasedMatchesLoadedBinderCallbacks(zzb<LoadMatchesResult> resultHolder) {
            this.zzawF = (zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzawF.zzp(new LoadMatchesResultImpl(GamesStatusCodes.zzfG(i), bundle));
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status zzSC;
        private final String zzauq;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.zzSC = GamesStatusCodes.zzfG(statusCode);
            this.zzauq = achievementId;
        }

        public String getAchievementId() {
            return this.zzauq;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements UpdateRequestsResult {
        private final RequestUpdateOutcomes zzawG;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzawG = RequestUpdateOutcomes.zzaa(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.zzawG.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.zzawG.getRequestOutcome(requestId);
        }
    }

    public GamesClientImpl(Context context, Looper looper, zzf clientSettings, GamesOptions options, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
        super(context, looper, 1, clientSettings, connectedListener, connectionFailedListener);
        this.zzavi = clientSettings.zzoN();
        this.zzavn = new Binder();
        this.zzavl = PopupManager.zza(this, clientSettings.zzoJ());
        zzn(clientSettings.zzoP());
        this.zzavo = (long) hashCode();
        this.zzavp = options;
    }

    private static Room zzX(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private void zzb(RemoteException remoteException) {
        GamesLog.zzb("GamesClientImpl", "service died", remoteException);
    }

    private void zzuv() {
        this.zzavj = null;
        this.zzavk = null;
    }

    public void disconnect() {
        this.zzavm = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zzpc();
                iGamesService.zzuT();
                this.zzavh.flush();
                iGamesService.zzE(this.zzavo);
            } catch (RemoteException e) {
                GamesLog.zzy("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        this.zzavm = false;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzbN(iBinder);
    }

    public int zza(zzlm<ReliableMessageSentCallback> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zzpc()).zza(new RealTimeReliableMessageBinderCallbacks(com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzx.zzb((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) zzpc()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = ((IGamesService) zzpc()).zza(i, bArr, i2, str);
            zzx.zzb((Object) bitmap, (Object) "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zzpc()).zza(playerEntity);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zzpc()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zzpc()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzavm = bundle.getBoolean("show_welcome_popup");
            this.zzavj = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzavk = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zzpc()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zza(zza com_google_android_gms_common_api_GoogleApiClient_zza) {
        zzuv();
        super.zza(com_google_android_gms_common_api_GoogleApiClient_zza);
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        Contents zzqO = snapshotContents.zzqO();
        snapshotContents.close();
        try {
            ((IGamesService) zzpc()).zza(zzqO);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzb<LoadInvitationsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, int i) throws RemoteException {
        ((IGamesService) zzpc()).zza(new InvitationsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), i);
    }

    public void zza(zzb<LoadRequestsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzpc()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), i, i2, i3);
    }

    public void zza(zzb<LoadAppContentResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult, int i, String str, String[] strArr, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zza(new AppContentLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult), i, str, strArr, z);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzpc()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zza(zzb<LoadMatchesResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzpc()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), i, iArr);
    }

    public void zza(zzb<LoadScoresResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        ((IGamesService) zzpc()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), leaderboardScoreBuffer.zzvH().asBundle(), i, i2);
    }

    public void zza(zzb<InitiateMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        ((IGamesService) zzpc()).zza(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzvN(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zzb<CommitSnapshotResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        BitmapTeleporter zzvS = snapshotMetadataChange.zzvS();
        if (zzvS != null) {
            zzvS.zzc(getContext().getCacheDir());
        }
        Contents zzqO = snapshotContents.zzqO();
        snapshotContents.close();
        ((IGamesService) zzpc()).zza(new SnapshotCommittedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzqO);
    }

    public void zza(zzb<UpdateAchievementResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzpc()).zza(iGamesCallbacks, str, this.zzavl.zzvh(), this.zzavl.zzvg());
    }

    public void zza(zzb<UpdateAchievementResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzpc()).zza(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzavl.zzvh(), this.zzavl.zzvg());
    }

    public void zza(zzb<LoadScoresResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                ((IGamesService) zzpc()).zzd(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zzb<LoadMatchesResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, String str, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzpc()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), str, i, iArr);
    }

    public void zza(zzb<SubmitScoreResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult, String str, long j, String str2) throws RemoteException {
        ((IGamesService) zzpc()).zza(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult == null ? null : new SubmitScoreBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult), str, j, str2);
    }

    public void zza(zzb<LeaveMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzpc()).zzc(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str, str2);
    }

    public void zza(zzb<LoadPlayerScoreResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult, String str, String str2, int i, int i2) throws RemoteException {
        ((IGamesService) zzpc()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult), str, str2, i, i2);
    }

    public void zza(zzb<LoadRequestsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, String str, String str2, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzpc()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), str, str2, i, i2, i3);
    }

    public void zza(zzb<LoadScoresResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
                ((IGamesService) zzpc()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zzb<OpenSnapshotResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzx.zza(!snapshotContents.isClosed(), (Object) "SnapshotContents already closed");
        BitmapTeleporter zzvS = snapshotMetadataChange.zzvS();
        if (zzvS != null) {
            zzvS.zzc(getContext().getCacheDir());
        }
        Contents zzqO = snapshotContents.zzqO();
        snapshotContents.close();
        ((IGamesService) zzpc()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzqO);
    }

    public void zza(zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, str2, z);
    }

    public void zza(zzb<LoadQuestsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzavh.flush();
        ((IGamesService) zzpc()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, strArr, z);
    }

    public void zza(zzb<LoadQuestsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzavh.flush();
        ((IGamesService) zzpc()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, iArr, i, z);
    }

    public void zza(zzb<UpdateRequestsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String str, String str2, String[] strArr) throws RemoteException {
        ((IGamesService) zzpc()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), str, str2, strArr);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzf(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, z);
    }

    public void zza(zzb<OpenSnapshotResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, boolean z, int i) throws RemoteException {
        ((IGamesService) zzpc()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, z, i);
    }

    public void zza(zzb<UpdateMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzpc()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, str2, participantResultArr);
    }

    public void zza(zzb<UpdateMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzpc()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, participantResultArr);
    }

    public void zza(zzb<SendRequestResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_SendRequestResult, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        ((IGamesService) zzpc()).zza(new RequestSentBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_SendRequestResult), str, strArr, i, bArr, i2);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), z);
    }

    public void zza(zzb<Status> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status, boolean z, Bundle bundle) throws RemoteException {
        ((IGamesService) zzpc()).zza(new ContactSettingsUpdatedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status), z, bundle);
    }

    public void zza(zzb<LoadEventsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z, String... strArr) throws RemoteException {
        this.zzavh.flush();
        ((IGamesService) zzpc()).zza(new EventsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z, strArr);
    }

    public void zza(zzb<LoadQuestsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzavh.flush();
        ((IGamesService) zzpc()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), iArr, i, z);
    }

    public void zza(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzpc()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), strArr);
    }

    public void zza(zzlm<OnInvitationReceivedListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener) {
        try {
            ((IGamesService) zzpc()).zza(new InvitationReceivedBinderCallback(com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener), this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzlm<RoomUpdateListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzlm<RoomStatusUpdateListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzlm<RealTimeMessageReceivedListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzpc()).zza(new RoomBinderCallbacks(com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzavn, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzlm<RoomUpdateListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, String str) {
        try {
            ((IGamesService) zzpc()).zzc(new RoomBinderCallbacks(com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener), str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzpc()).zzb(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return ((IGamesService) zzpc()).zzb(iArr);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    protected Set<Scope> zzb(Set<Scope> set) {
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        int i = 0;
        boolean z = false;
        for (Scope scope3 : set) {
            int i2;
            boolean z2;
            if (scope3.equals(scope)) {
                i2 = i;
                z2 = true;
            } else if (scope3.equals(scope2)) {
                i2 = 1;
                z2 = z;
            } else {
                i2 = i;
                z2 = z;
            }
            z = z2;
            i = i2;
        }
        if (i != 0) {
            zzx.zza(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.zza(z, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    public void zzb(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzb(zzb<UpdateAchievementResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzpc()).zzb(iGamesCallbacks, str, this.zzavl.zzvh(), this.zzavl.zzvg());
    }

    public void zzb(zzb<UpdateAchievementResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzpc()).zzb(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzavl.zzvh(), this.zzavl.zzvg());
    }

    public void zzb(zzb<LoadScoresResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zzb(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
    }

    public void zzb(zzb<ClaimMilestoneResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, String str, String str2) throws RemoteException {
        this.zzavh.flush();
        ((IGamesService) zzpc()).zzf(new QuestMilestoneClaimBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, str2), str, str2);
    }

    public void zzb(zzb<LoadScoresResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zzb(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
    }

    public void zzb(zzb<LoadAchievementsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), str, str2, z);
    }

    public void zzb(zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzc(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzb(zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), z);
    }

    public void zzb(zzb<LoadQuestsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, boolean z, String[] strArr) throws RemoteException {
        this.zzavh.flush();
        ((IGamesService) zzpc()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), strArr, z);
    }

    public void zzb(zzb<UpdateRequestsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzpc()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzb(zzlm<OnTurnBasedMatchUpdateReceivedListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) zzpc()).zzb(new MatchUpdateReceivedBinderCallback(com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener), this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(zzlm<RoomUpdateListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzlm<RoomStatusUpdateListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzlm<RealTimeMessageReceivedListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzpc()).zza(new RoomBinderCallbacks(com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_internal_zzlm_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzavn, roomConfig.getInvitationId(), false, this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    protected IGamesService zzbN(IBinder iBinder) {
        return Stub.zzbQ(iBinder);
    }

    public Intent zzc(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzpc()).zzc(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzc(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzpc()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzc(zzb<InitiateMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzc(zzb<LoadXpStreamResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzc(zzb<InitiateMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzpc()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzc(zzb<LoadSnapshotsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzc(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), str, str2, z);
    }

    public void zzc(zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzd(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzc(zzb<LoadAchievementsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), z);
    }

    public void zzc(zzb<UpdateRequestsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new RequestsUpdatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzc(zzlm<QuestUpdateListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_quest_QuestUpdateListener) {
        try {
            ((IGamesService) zzpc()).zzd(new QuestUpdateBinderCallback(com_google_android_gms_internal_zzlm_com_google_android_gms_games_quest_QuestUpdateListener), this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzcW(String str) {
        try {
            ((IGamesService) zzpc()).zzde(str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzcX(String str) {
        try {
            return ((IGamesService) zzpc()).zzcX(str);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzcY(String str) {
        try {
            ((IGamesService) zzpc()).zza(str, this.zzavl.zzvh(), this.zzavl.zzvg());
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return ((IGamesService) zzpc()).zzb(bArr, str, null);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzd(zzb<LoadGamesResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult) throws RemoteException {
        ((IGamesService) zzpc()).zzd(new GamesLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult));
    }

    public void zzd(zzb<LoadPlayersResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzpc()).zze(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzd(zzb<InitiateMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzd(zzb<LoadXpStreamResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzpc()).zzc(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzd(zzb<InitiateMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzpc()).zze(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzd(zzb<GameMuteStatusChangeResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zza(new GameMuteStatusChangedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult), str, z);
    }

    public void zzd(zzb<LoadEventsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z) throws RemoteException {
        this.zzavh.flush();
        ((IGamesService) zzpc()).zzf(new EventsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z);
    }

    public void zzd(zzlm<OnRequestReceivedListener> com_google_android_gms_internal_zzlm_com_google_android_gms_games_request_OnRequestReceivedListener) {
        try {
            ((IGamesService) zzpc()).zzc(new RequestReceivedBinderCallback(com_google_android_gms_internal_zzlm_com_google_android_gms_games_request_OnRequestReceivedListener), this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zze(zzb<Status> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        this.zzavh.flush();
        ((IGamesService) zzpc()).zza(new SignOutCompleteBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status));
    }

    public void zze(zzb<LeaveMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzo(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str);
    }

    public void zze(zzb<LoadInvitationsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str, int i) throws RemoteException {
        ((IGamesService) zzpc()).zzb(new InvitationsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str, i, false);
    }

    public void zze(zzb<LoadPlayerStatsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzi(new PlayerStatsLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult), z);
    }

    public void zzf(zzb<LoadAclResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult) throws RemoteException {
        ((IGamesService) zzpc()).zzh(new NotifyAclLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult));
    }

    public void zzf(zzb<CancelMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzn(new TurnBasedMatchCanceledBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult), str);
    }

    public void zzf(zzb<LoadRequestSummariesResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult, String str, int i) throws RemoteException {
        ((IGamesService) zzpc()).zza(new RequestSummariesLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult), str, i);
    }

    public void zzf(zzb<LoadSnapshotsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzd(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), z);
    }

    protected String zzfK() {
        return "com.google.android.gms.games.service.START";
    }

    protected String zzfL() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void zzfV(int i) {
        this.zzavl.setGravity(i);
    }

    public void zzfW(int i) {
        try {
            ((IGamesService) zzpc()).zzfW(i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzg(zzb<InboxCountResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Notifications_InboxCountResult) throws RemoteException {
        ((IGamesService) zzpc()).zzt(new InboxCountsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Notifications_InboxCountResult), null);
    }

    public void zzg(zzb<LoadMatchResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzp(new TurnBasedMatchLoadedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult), str);
    }

    public void zzg(zzb<LoadProfileSettingsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzg(new ProfileSettingsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult), z);
    }

    public void zzh(zzb<AcceptQuestResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult, String str) throws RemoteException {
        this.zzavh.flush();
        ((IGamesService) zzpc()).zzu(new QuestAcceptedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult), str);
    }

    public void zzh(zzb<Status> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zzh(new ProfileSettingsUpdatedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status), z);
    }

    public void zzi(zzb<DeleteSnapshotResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzr(new SnapshotDeletedBinderCallbacks(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult), str);
    }

    public void zzi(zzb<ContactSettingLoadResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult, boolean z) throws RemoteException {
        ((IGamesService) zzpc()).zze(new ContactSettingsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult), z);
    }

    public void zzj(zzb<LoadGameInstancesResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzf(new GameInstancesLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult), str);
    }

    public void zzk(zzb<LoadGameSearchSuggestionsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzq(new GameSearchSuggestionsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult), str);
    }

    public Intent zzl(String str, int i, int i2) {
        try {
            return ((IGamesService) zzpc()).zzm(str, i, i2);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzl(zzb<LoadXpForGameCategoriesResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult), str);
    }

    public boolean zzlN() {
        return true;
    }

    protected Bundle zzly() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zztD = this.zzavp.zztD();
        zztD.putString("com.google.android.gms.games.key.gamePackageName", this.zzavi);
        zztD.putString("com.google.android.gms.games.key.desiredLocale", locale);
        zztD.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzavl.zzvh()));
        zztD.putInt("com.google.android.gms.games.key.API_VERSION", 1);
        zzf zzpa = zzpa();
        if (zzpa.zzoQ() != null) {
            zztD.putBundle("com.google.android.gms.games.key.signInOptions", zzi.zza(zzpa.zzoQ(), zzpa.zzoR(), Executors.newSingleThreadExecutor()));
        }
        return zztD;
    }

    public void zzm(zzb<LoadInvitationsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzk(new InvitationsLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str);
    }

    public Bundle zzmS() {
        try {
            Bundle zzmS = ((IGamesService) zzpc()).zzmS();
            if (zzmS == null) {
                return zzmS;
            }
            zzmS.setClassLoader(GamesClientImpl.class.getClassLoader());
            return zzmS;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzn(View view) {
        this.zzavl.zzo(view);
    }

    public void zzn(zzb<Status> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzj(new NotifyAclUpdatedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status), str);
    }

    public void zzo(zzb<GameMuteStatusLoadResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult, String str) throws RemoteException {
        ((IGamesService) zzpc()).zzi(new GameMuteStatusLoadedBinderCallback(com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult), str);
    }

    public void zzoW() {
        super.zzoW();
        if (this.zzavm) {
            this.zzavl.zzvf();
            this.zzavm = false;
        }
        if (!this.zzavp.zzatS) {
            zzuw();
        }
    }

    public void zzp(String str, int i) {
        this.zzavh.zzp(str, i);
    }

    public void zzq(String str, int i) {
        try {
            ((IGamesService) zzpc()).zzq(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzr(String str, int i) {
        try {
            ((IGamesService) zzpc()).zzr(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Game zzuA() {
        GameBuffer gameBuffer;
        zzpb();
        synchronized (this) {
            if (this.zzavk == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) zzpc()).zzuX());
                    if (gameBuffer.getCount() > 0) {
                        this.zzavk = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.zzavk;
    }

    public Intent zzuB() {
        try {
            return ((IGamesService) zzpc()).zzuB();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzuC() {
        try {
            return ((IGamesService) zzpc()).zzuC();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzuD() {
        try {
            return ((IGamesService) zzpc()).zzuD();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzuE() {
        try {
            return ((IGamesService) zzpc()).zzuE();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzuF() {
        try {
            ((IGamesService) zzpc()).zzF(this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzuG() {
        try {
            ((IGamesService) zzpc()).zzG(this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzuH() {
        try {
            ((IGamesService) zzpc()).zzI(this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzuI() {
        try {
            ((IGamesService) zzpc()).zzH(this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzuJ() {
        try {
            return ((IGamesService) zzpc()).zzuJ();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzuK() {
        try {
            return ((IGamesService) zzpc()).zzuK();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzuL() {
        try {
            return ((IGamesService) zzpc()).zzuL();
        } catch (RemoteException e) {
            zzb(e);
            return 4368;
        }
    }

    public String zzuM() {
        try {
            return ((IGamesService) zzpc()).zzuM();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzuN() {
        try {
            return ((IGamesService) zzpc()).zzuN();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zzuO() {
        try {
            return ((IGamesService) zzpc()).zzuO();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzuP() {
        try {
            return ((IGamesService) zzpc()).zzuP();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzuQ() {
        try {
            return ((IGamesService) zzpc()).zzuQ();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzuR() {
        try {
            return ((IGamesService) zzpc()).zzuR();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzuS() {
        try {
            return ((IGamesService) zzpc()).zzuS();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzuT() {
        if (isConnected()) {
            try {
                ((IGamesService) zzpc()).zzuT();
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zzuw() {
        try {
            ((IGamesService) zzpc()).zza(new PopupLocationInfoBinderCallbacks(this.zzavl), this.zzavo);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public String zzux() {
        try {
            return ((IGamesService) zzpc()).zzux();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public String zzuy() {
        if (this.zzavj != null) {
            return this.zzavj.getPlayerId();
        }
        try {
            return ((IGamesService) zzpc()).zzuy();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Player zzuz() {
        zzpb();
        synchronized (this) {
            if (this.zzavj == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) zzpc()).zzuV());
                    if (playerBuffer.getCount() > 0) {
                        this.zzavj = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.zzavj;
    }
}
