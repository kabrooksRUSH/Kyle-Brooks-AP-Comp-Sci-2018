package com.grumpycarrot.ane.playgameservices;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.adobe.air.ActivityResultCallback;
import com.adobe.air.AndroidActivityWrapper;
import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.grumpycarrot.ane.playgameservices.GameHelper.GameHelperListener;
import com.grumpycarrot.ane.playgameservices.achievements.Achievements;
import com.grumpycarrot.ane.playgameservices.achievements.functions.IncrementAchievementFunction;
import com.grumpycarrot.ane.playgameservices.achievements.functions.LoadAchievementsFunction;
import com.grumpycarrot.ane.playgameservices.achievements.functions.RevealAchievementFunction;
import com.grumpycarrot.ane.playgameservices.achievements.functions.SetStepsAchievementFunction;
import com.grumpycarrot.ane.playgameservices.achievements.functions.ShowAchievementsFunction;
import com.grumpycarrot.ane.playgameservices.achievements.functions.UnlockAchievementFunction;
import com.grumpycarrot.ane.playgameservices.admob.Banner;
import com.grumpycarrot.ane.playgameservices.admob.Interstitial;
import com.grumpycarrot.ane.playgameservices.admob.functions.BannerAdInitFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.BannerAdLoadFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.BannerHideFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.BannerIsActivatedFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.BannerIsShownFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.BannerRemoveFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.BannerShowFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.InterstitialInitFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.InterstitialIsLoadedFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.InterstitialLoadFunction;
import com.grumpycarrot.ane.playgameservices.admob.functions.InterstitialShowFunction;
import com.grumpycarrot.ane.playgameservices.eventsquests.EventsQuests;
import com.grumpycarrot.ane.playgameservices.eventsquests.functions.AcceptQuestFunction;
import com.grumpycarrot.ane.playgameservices.eventsquests.functions.ClaimRewardFunction;
import com.grumpycarrot.ane.playgameservices.eventsquests.functions.LoadQuestsFunction;
import com.grumpycarrot.ane.playgameservices.eventsquests.functions.RegisterQuestUpdateListenerFunction;
import com.grumpycarrot.ane.playgameservices.eventsquests.functions.RetrieveEventByIdFunction;
import com.grumpycarrot.ane.playgameservices.eventsquests.functions.RetrieveEventFunction;
import com.grumpycarrot.ane.playgameservices.eventsquests.functions.ShowQuestsUIFunction;
import com.grumpycarrot.ane.playgameservices.eventsquests.functions.SubmitEventFunction;
import com.grumpycarrot.ane.playgameservices.eventsquests.functions.UnregisterQuestUpdateListenerFunction;
import com.grumpycarrot.ane.playgameservices.functions.GetCurrentLoadedUriImageFunction;
import com.grumpycarrot.ane.playgameservices.functions.InitAPIFunction;
import com.grumpycarrot.ane.playgameservices.functions.LoadUriImageFunction;
import com.grumpycarrot.ane.playgameservices.functions.SignInFunction;
import com.grumpycarrot.ane.playgameservices.functions.SignOutFunction;
import com.grumpycarrot.ane.playgameservices.leaderboards.GameLeaderboards;
import com.grumpycarrot.ane.playgameservices.leaderboards.functions.GetCurrentPlayerLeaderboardScoreFunction;
import com.grumpycarrot.ane.playgameservices.leaderboards.functions.GetPlayerCenteredLeaderboardFunction;
import com.grumpycarrot.ane.playgameservices.leaderboards.functions.GetTopLeaderboardFunction;
import com.grumpycarrot.ane.playgameservices.leaderboards.functions.ReportScoreFunction;
import com.grumpycarrot.ane.playgameservices.leaderboards.functions.ShowAllLeaderboardsFunction;
import com.grumpycarrot.ane.playgameservices.leaderboards.functions.ShowLeaderboardFunction;
import com.grumpycarrot.ane.playgameservices.player.CurrentPlayer;
import com.grumpycarrot.ane.playgameservices.player.functions.CheckPlayerStatsFunction;
import com.grumpycarrot.ane.playgameservices.player.functions.GetActivePlayerFunction;
import com.grumpycarrot.ane.playgameservices.savedgames.SavedGames;
import com.grumpycarrot.ane.playgameservices.savedgames.functions.DeleteGameFunction;
import com.grumpycarrot.ane.playgameservices.savedgames.functions.GetSavedGamesListFunction;
import com.grumpycarrot.ane.playgameservices.savedgames.functions.OpenGameFunction;
import com.grumpycarrot.ane.playgameservices.savedgames.functions.ShowSavedGame_UIFunction;
import com.grumpycarrot.ane.playgameservices.savedgames.functions.WriteGameFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.TurnBaseMulti;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.AcceptInvitationFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.CancelMatchFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.CreateAutoMatchFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.CreateNewGame_UIFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.DeclineInvitationFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.DismissInvitationFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.DismissMatchFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.FinishMatchFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.FinishMatchWithDataFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.GetInvitationsFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.LeaveMatchDuringTurnFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.LeaveMatchFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.LoadMatchFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.LoadMatchesFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.LookAtMatches_UIFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.RematchFunction;
import com.grumpycarrot.ane.playgameservices.turnbasegames.functions.TakeTurnFunction;
import java.util.HashMap;
import java.util.Map;

public class ExtensionContext extends FREContext implements ActivityResultCallback, GameHelperListener {
    private static OnImageLoadedCallback onImageLoadedCallback;
    private AndroidActivityWrapper aaw = AndroidActivityWrapper.GetAndroidActivityWrapper();
    public Achievements achievements;
    private View adobeAirView;
    public Banner banner;
    public Bitmap currentLoadedUriImage;
    public CurrentPlayer currentPlayer;
    public EventsQuests eventsQuests;
    public Interstitial interstitial;
    public GameLeaderboards leaderboards;
    private GameHelper mHelper;
    public SavedGames savedGames;
    public TurnBaseMulti turnBaseMulti;

    class OnImageLoadedCallback implements OnImageLoadedListener {
        public void onImageLoaded(Uri uri, Drawable drawable, boolean isRequestedDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            ExtensionContext.this.currentLoadedUriImage = bitmapDrawable.getBitmap();
            Extension.logEvent("onImageLoaded");
            Extension.context.sendEventToAir("ON_URI_IMAGE_LOADED");
        }
    }

    public ExtensionContext() {
        Extension.logEvent("** ExtensionContext Construtor **");
        this.aaw.addActivityResultListener(this);
        this.aaw.getActivity();
        this.leaderboards = new GameLeaderboards();
        this.achievements = new Achievements();
        this.currentPlayer = new CurrentPlayer();
        this.eventsQuests = new EventsQuests();
        this.interstitial = new Interstitial();
        this.banner = new Banner();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Extension.logEvent("*** onActivityResult *** ");
        if (requestCode == GameHelper.RC_RESOLVE) {
            onActivityResult_SignIn(requestCode, resultCode, intent);
        } else if (requestCode == SavedGames.RC_SAVED_GAMES) {
            this.savedGames.onActivityResult(requestCode, resultCode, intent);
        } else if (requestCode == EventsQuests.RC_QUEST) {
            this.eventsQuests.onActivityResult(requestCode, resultCode, intent);
        } else if (requestCode == 10001) {
            this.turnBaseMulti.onActivityResult_LookAtMatches(resultCode, intent);
        } else if (requestCode == 10000) {
            this.turnBaseMulti.onActivityResult_ForSelectPlayers(resultCode, intent);
        }
    }

    public void saveAirView() {
        this.adobeAirView = getActivity().findViewById(16908290);
        Extension.logEvent("View Id : " + this.adobeAirView.getId());
    }

    public View getAirView() {
        return this.adobeAirView;
    }

    public void dispose() {
        Extension.logEvent("*** dispose ExtensionContext *** ");
        this.mHelper.onStop();
        this.eventsQuests.unregisterQuestUpdateListener();
        if (this.turnBaseMulti != null) {
            this.turnBaseMulti.unregisterTurnBaseMultiListeners();
        }
        this.mHelper = null;
        this.adobeAirView = null;
        this.aaw = null;
        onImageLoadedCallback = null;
        this.currentLoadedUriImage = null;
        this.turnBaseMulti = null;
        this.savedGames = null;
        this.interstitial = null;
        this.banner = null;
        this.eventsQuests = null;
        this.currentPlayer = null;
        this.achievements = null;
        this.leaderboards = null;
    }

    public Map<String, FREFunction> getFunctions() {
        Map<String, FREFunction> functionMap = new HashMap();
        functionMap.put("initAPI", new InitAPIFunction());
        functionMap.put("signIn", new SignInFunction());
        functionMap.put("signOut", new SignOutFunction());
        functionMap.put("getActivePlayer", new GetActivePlayerFunction());
        functionMap.put("checkPlayerStats", new CheckPlayerStatsFunction());
        functionMap.put("loadUriImage", new LoadUriImageFunction());
        functionMap.put("getCurrentLoadedUriImage", new GetCurrentLoadedUriImageFunction());
        functionMap.put("showAchievements", new ShowAchievementsFunction());
        functionMap.put("revealAchievement", new RevealAchievementFunction());
        functionMap.put("unlockAchievement", new UnlockAchievementFunction());
        functionMap.put("incrementAchievement", new IncrementAchievementFunction());
        functionMap.put("setStepsAchievement", new SetStepsAchievementFunction());
        functionMap.put("loadAchievements", new LoadAchievementsFunction());
        functionMap.put("showAllLeaderboards", new ShowAllLeaderboardsFunction());
        functionMap.put("showLeaderboard", new ShowLeaderboardFunction());
        functionMap.put("reportScore", new ReportScoreFunction());
        functionMap.put("getCurrentPlayerLeaderboardScore", new GetCurrentPlayerLeaderboardScoreFunction());
        functionMap.put("getTopLeaderboard", new GetTopLeaderboardFunction());
        functionMap.put("getPlayerCenteredLeaderboard", new GetPlayerCenteredLeaderboardFunction());
        functionMap.put("showSavedGamesUI", new ShowSavedGame_UIFunction());
        functionMap.put("getSavedGamesList", new GetSavedGamesListFunction());
        functionMap.put("openGame", new OpenGameFunction());
        functionMap.put("writeGame", new WriteGameFunction());
        functionMap.put("deleteGame", new DeleteGameFunction());
        functionMap.put("submitEvent", new SubmitEventFunction());
        functionMap.put("retrieveEvent", new RetrieveEventFunction());
        functionMap.put("RetrieveEventById", new RetrieveEventByIdFunction());
        functionMap.put("showQuestsUI", new ShowQuestsUIFunction());
        functionMap.put("registerQuestUpdateListener", new RegisterQuestUpdateListenerFunction());
        functionMap.put("unregisterQuestUpdateListener", new UnregisterQuestUpdateListenerFunction());
        functionMap.put("loadQuests", new LoadQuestsFunction());
        functionMap.put("acceptQuest", new AcceptQuestFunction());
        functionMap.put("claimReward", new ClaimRewardFunction());
        functionMap.put("interstitialInit", new InterstitialInitFunction());
        functionMap.put("interstitialIsLoaded", new InterstitialIsLoadedFunction());
        functionMap.put("interstitialLoad", new InterstitialLoadFunction());
        functionMap.put("interstitialShow", new InterstitialShowFunction());
        functionMap.put("bannerAdInit", new BannerAdInitFunction());
        functionMap.put("bannerAdLoad", new BannerAdLoadFunction());
        functionMap.put("bannerAdShow", new BannerShowFunction());
        functionMap.put("bannerAdHide", new BannerHideFunction());
        functionMap.put("bannerAdRemove", new BannerRemoveFunction());
        functionMap.put("bannerIsShown", new BannerIsShownFunction());
        functionMap.put("bannerIsActivated", new BannerIsActivatedFunction());
        functionMap.put("TBM_LookAtMatches_UI", new LookAtMatches_UIFunction());
        functionMap.put("TBM_CreateNewGame_UI", new CreateNewGame_UIFunction());
        functionMap.put("TBM_CreateAutoMatch", new CreateAutoMatchFunction());
        functionMap.put("getInvitations", new GetInvitationsFunction());
        functionMap.put("TBM_AcceptInvitation", new AcceptInvitationFunction());
        functionMap.put("TBM_DeclineInvitation", new DeclineInvitationFunction());
        functionMap.put("TBM_DismissInvitation", new DismissInvitationFunction());
        functionMap.put("TBM_LoadMatches", new LoadMatchesFunction());
        functionMap.put("TBM_LoadMatch", new LoadMatchFunction());
        functionMap.put("TBM_TakeTurn", new TakeTurnFunction());
        functionMap.put("TBM_FinishMatch", new FinishMatchFunction());
        functionMap.put("TBM_FinishMatchWithData", new FinishMatchWithDataFunction());
        functionMap.put("TBM_Rematch", new RematchFunction());
        functionMap.put("TBM_DismissMatch", new DismissMatchFunction());
        functionMap.put("TBM_CancelMatch", new CancelMatchFunction());
        functionMap.put("TBM_LeaveMatch", new LeaveMatchFunction());
        functionMap.put("TBM_LeaveMatchDuringTurn", new LeaveMatchDuringTurnFunction());
        return functionMap;
    }

    public void initAPI(boolean enableSavedGames, boolean enableTurnBaseMulti, boolean connectOnStart, int maxAutoSignInAttempts, boolean showPopUps) {
        if (this.mHelper == null) {
            int clientsToUse;
            saveAirView();
            this.mHelper = new GameHelper(this);
            if (enableSavedGames) {
                this.savedGames = new SavedGames();
                clientsToUse = 9;
            } else {
                clientsToUse = 1;
            }
            if (enableTurnBaseMulti) {
                this.turnBaseMulti = new TurnBaseMulti();
            }
            this.mHelper.setup(clientsToUse, maxAutoSignInAttempts, showPopUps);
            this.mHelper.onStart(connectOnStart);
        }
    }

    public void startSignIn() {
        Extension.logEvent("StartSignIn");
        this.mHelper.beginUserInitiatedSignIn();
    }

    public void onActivityResult_SignIn(int requestCode, int responseCode, Intent intent) {
        Extension.logEvent("onActivityResult_SignIn");
        this.mHelper.onActivityResult(requestCode, responseCode, intent);
    }

    public void signOut() {
        Extension.logEvent("signOut");
        this.mHelper.signOut();
        sendEventToAir("ON_SIGN_OUT_SUCCESS");
    }

    public GoogleApiClient getApiClient() {
        return this.mHelper.getApiClient();
    }

    public void onSignInFailed() {
        Extension.logEvent("onSignInFailed");
        sendEventToAir("ON_SIGN_IN_FAIL");
    }

    public void onSignInSucceeded() {
        Extension.logEvent("onSignInSucceeded");
        sendEventToAir("ON_SIGN_IN_SUCCESS");
        if (this.turnBaseMulti != null) {
            this.turnBaseMulti.registerTurnBaseMultiListeners();
        }
    }

    public void sendEventToAir(String eventName) {
        dispatchStatusEventAsync(eventName, "");
    }

    public void sendEventToAir(String eventName, String data) {
        dispatchStatusEventAsync(eventName, data);
    }

    public String getUriString(Uri uri) {
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    public int[] FREArraytoIntArray(FREArray mFREArray) {
        int arrayLength;
        Extension.logEvent("FREArraytoIntArray Started... ");
        try {
            arrayLength = (int) mFREArray.getLength();
        } catch (FREInvalidObjectException e) {
            arrayLength = 0;
        } catch (FREWrongThreadException e2) {
            arrayLength = 0;
        }
        int[] intArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            try {
                intArray[i] = mFREArray.getObjectAt((long) i).getAsInt();
            } catch (IllegalStateException e3) {
                intArray[i] = -1;
            } catch (IllegalArgumentException e4) {
                intArray[i] = -1;
            } catch (FRETypeMismatchException e5) {
                intArray[i] = -1;
            } catch (FREInvalidObjectException e6) {
                intArray[i] = -1;
            } catch (FREWrongThreadException e7) {
                intArray[i] = -1;
            }
        }
        Extension.logEvent("FREArraytoIntArray Finished... ");
        return intArray;
    }

    public void loadImageFromUriString(String uriString) {
        Extension.logEvent("loadImageFromUriString : " + uriString);
        if (onImageLoadedCallback == null) {
            onImageLoadedCallback = new OnImageLoadedCallback();
        }
        ImageManager.create(Extension.context.getActivity().getApplicationContext()).loadImage(onImageLoadedCallback, Uri.parse(uriString));
    }
}
