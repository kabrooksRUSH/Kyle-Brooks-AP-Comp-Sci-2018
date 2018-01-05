package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.internal.zzlb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Games {
    public static final Api<GamesOptions> API = new Api("Games.API", zzRl, zzRk);
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final Stats Stats = new StatsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    static final zzc<GamesClientImpl> zzRk = new zzc();
    private static final zza<GamesClientImpl, GamesOptions> zzRl = new C04101();
    private static final zza<GamesClientImpl, GamesOptions> zzatM = new C04112();
    public static final Scope zzatN = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> zzatO = new Api("Games.API_1P", zzatM, zzRk);
    public static final AppContents zzatP = new AppContentsImpl();
    public static final Multiplayer zzatQ = new MultiplayerImpl();
    public static final Acls zzatR = new AclsImpl();

    private static abstract class GamesClientBuilder extends zza<GamesClientImpl, GamesOptions> {
        private GamesClientBuilder() {
        }

        public int getPriority() {
            return 1;
        }

        public GamesClientImpl zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, com_google_android_gms_common_internal_zzf, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C04101 extends GamesClientBuilder {
        C04101() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.SCOPE_GAMES);
        }

        public /* synthetic */ List zzm(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    static class C04112 extends GamesClientBuilder {
        C04112() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.zzatN);
        }

        public /* synthetic */ List zzm(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends zzlb.zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzRk, googleApiClient);
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    public static final class GamesOptions implements Optional {
        public final boolean zzatS;
        public final boolean zzatT;
        public final int zzatU;
        public final boolean zzatV;
        public final int zzatW;
        public final String zzatX;
        public final ArrayList<String> zzatY;

        public static final class Builder {
            boolean zzatS;
            boolean zzatT;
            int zzatU;
            boolean zzatV;
            int zzatW;
            String zzatX;
            ArrayList<String> zzatY;

            private Builder() {
                this.zzatS = false;
                this.zzatT = true;
                this.zzatU = 17;
                this.zzatV = false;
                this.zzatW = 4368;
                this.zzatX = null;
                this.zzatY = new ArrayList();
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int variant) {
                this.zzatW = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.zzatT = showConnectingPopup;
                this.zzatU = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.zzatT = showConnectingPopup;
                this.zzatU = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.zzatS = false;
            this.zzatT = true;
            this.zzatU = 17;
            this.zzatV = false;
            this.zzatW = 4368;
            this.zzatX = null;
            this.zzatY = new ArrayList();
        }

        private GamesOptions(Builder builder) {
            this.zzatS = builder.zzatS;
            this.zzatT = builder.zzatT;
            this.zzatU = builder.zzatU;
            this.zzatV = builder.zzatV;
            this.zzatW = builder.zzatW;
            this.zzatX = builder.zzatX;
            this.zzatY = builder.zzatY;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Bundle zztD() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzatS);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzatT);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzatU);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzatV);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzatW);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzatX);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzatY);
            return bundle;
        }
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return zzc(apiClient).zzuM();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return zzc(apiClient).zzux();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return zzc(apiClient).zzuL();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return zzc(apiClient).zzuK();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzfV(gravity);
        }
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        zzx.zzw(gamesContentView);
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzn(gamesContentView);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.zzb(new SignOutImpl(apiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zze(this);
            }
        });
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (GamesClientImpl) googleApiClient.zza(zzRk) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        }
    }
}
