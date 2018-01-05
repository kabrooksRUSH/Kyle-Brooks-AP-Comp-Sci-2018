package com.grumpycarrot.ane.playgameservices;

import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.Games.GamesOptions.Builder;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.request.GameRequest;
import java.util.ArrayList;

public class GameHelper implements ConnectionCallbacks, OnConnectionFailedListener {
    public static final int CLIENT_ALL = 9;
    public static final int CLIENT_GAMES = 1;
    public static final int CLIENT_NONE = 0;
    public static final int CLIENT_SNAPSHOT = 8;
    static final int DEFAULT_MAX_SIGN_IN_ATTEMPTS = 3;
    public static final int RC_RESOLVE = 9001;
    private final String GAMEHELPER_SHARED_PREFS = "GAMEHELPER_SHARED_PREFS";
    private final String KEY_SIGN_IN_CANCELLATIONS = "KEY_SIGN_IN_CANCELLATIONS";
    boolean mConnectOnStart = true;
    private boolean mConnecting = false;
    ConnectionResult mConnectionResult = null;
    boolean mExpectingResolution = false;
    GoogleApiClient mGoogleApiClient = null;
    Invitation mInvitation;
    GameHelperListener mListener = null;
    int mMaxAutoSignInAttempts = 3;
    int mRequestedClients = 0;
    ArrayList<GameRequest> mRequests;
    private boolean mSetupDone = false;
    boolean mSignInCancelled = false;
    SignInFailureReason mSignInFailureReason = null;
    TurnBasedMatch mTurnBasedMatch;
    boolean mUserInitiatedSignIn = false;

    public interface GameHelperListener {
        void onSignInFailed();

        void onSignInSucceeded();
    }

    public static class SignInFailureReason {
        public static final int NO_ACTIVITY_RESULT_CODE = -100;
        int mActivityResultCode;
        int mServiceErrorCode;

        public int getServiceErrorCode() {
            return this.mServiceErrorCode;
        }

        public int getActivityResultCode() {
            return this.mActivityResultCode;
        }

        public SignInFailureReason(int serviceErrorCode, int activityResultCode) {
            this.mServiceErrorCode = 0;
            this.mActivityResultCode = -100;
            this.mServiceErrorCode = serviceErrorCode;
            this.mActivityResultCode = activityResultCode;
        }

        public SignInFailureReason(int serviceErrorCode) {
            this(serviceErrorCode, -100);
        }
    }

    public GameHelper(GameHelperListener listenerActivity) {
        this.mListener = listenerActivity;
    }

    public void setup(int clientsToUse, int maxAutoSignInAttempts, boolean showPopUps) {
        if (this.mSetupDone) {
            logError("Cannot call setup() more than once!");
            return;
        }
        this.mRequestedClients = clientsToUse;
        this.mMaxAutoSignInAttempts = maxAutoSignInAttempts;
        if (this.mGoogleApiClient == null) {
            createApiClientBuilder(showPopUps);
        }
        this.mSetupDone = true;
    }

    private void createApiClientBuilder(boolean showPopUps) {
        debugLog("createApiClientBuilder : " + this.mRequestedClients);
        Builder mGamesApiOptionsBuilder = GamesOptions.builder();
        mGamesApiOptionsBuilder.setShowConnectingPopup(showPopUps);
        GamesOptions mGamesApiOptions = mGamesApiOptionsBuilder.build();
        GoogleApiClient.Builder googleApiClient = new GoogleApiClient.Builder(Extension.context.getActivity(), this, this);
        if (showPopUps) {
            googleApiClient.setViewForPopups(Extension.context.getAirView());
        }
        if ((this.mRequestedClients & 1) != 0) {
            googleApiClient.addApi(Games.API, mGamesApiOptions);
            googleApiClient.addScope(Games.SCOPE_GAMES);
        }
        if ((this.mRequestedClients & 8) != 0) {
            googleApiClient.addScope(Drive.SCOPE_APPFOLDER);
            googleApiClient.addApi(Drive.API);
        }
        this.mGoogleApiClient = googleApiClient.build();
    }

    public void onStart(boolean connectOnStart) {
        if (this.mSetupDone) {
            this.mConnectOnStart = connectOnStart;
            if (!this.mConnectOnStart) {
                debugLog("Not attempting to connect becase mConnectOnStart=false");
                return;
            } else if (this.mGoogleApiClient.isConnected()) {
                debugLog("client was already connected on onStart()");
                return;
            } else {
                debugLog("Connecting client.");
                this.mConnecting = true;
                this.mGoogleApiClient.connect();
                return;
            }
        }
        logError("Operation attempted without setup!");
    }

    private void resetSignInCancellations() {
        Editor editor = Extension.context.getActivity().getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
        editor.putInt("KEY_SIGN_IN_CANCELLATIONS", 0);
        editor.commit();
    }

    private int incrementSignInCancellations() {
        int cancellations = getSignInCancellations();
        Editor editor = Extension.context.getActivity().getApplicationContext().getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
        editor.putInt("KEY_SIGN_IN_CANCELLATIONS", cancellations + 1);
        editor.commit();
        return cancellations + 1;
    }

    private int getSignInCancellations() {
        return Extension.context.getActivity().getApplicationContext().getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).getInt("KEY_SIGN_IN_CANCELLATIONS", 0);
    }

    private void notifyListener(boolean success) {
        if (this.mListener == null) {
            return;
        }
        if (success) {
            this.mListener.onSignInSucceeded();
        } else {
            this.mListener.onSignInFailed();
        }
    }

    public void beginUserInitiatedSignIn() {
        resetSignInCancellations();
        this.mSignInCancelled = false;
        this.mConnectOnStart = true;
        if (this.mGoogleApiClient.isConnected()) {
            debugLog("SignIn() called when already connected.");
            notifyListener(true);
        } else if (this.mConnecting) {
            debugLog("SignIn() called when already connecting. Be patient!");
        } else {
            debugLog("Starting USER-INITIATED sign-in flow.");
            this.mUserInitiatedSignIn = true;
            if (this.mConnectionResult != null) {
                debugLog("beginUserInitiatedSignIn: continuing pending sign-in flow.");
                this.mConnecting = true;
                resolveConnectionResult();
                return;
            }
            debugLog("beginUserInitiatedSignIn: starting new sign-in flow.");
            this.mConnecting = true;
            connect();
        }
    }

    private void connect() {
        if (this.mGoogleApiClient.isConnected()) {
            debugLog("Already connected.");
            return;
        }
        debugLog("Starting connection.");
        this.mConnecting = true;
        this.mInvitation = null;
        this.mTurnBasedMatch = null;
        this.mGoogleApiClient.connect();
    }

    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        debugLog("onActivityResult: reqCode=" + requestCode + " responseCode :" + responseCode);
        this.mExpectingResolution = false;
        if (!this.mConnecting) {
            debugLog("onActivityResult: ignoring because we are not connecting.");
        } else if (responseCode == -1) {
            debugLog("onAR: Resolution was RESULT_OK, so connecting current client again.");
            connect();
        } else if (responseCode == 10001) {
            debugLog("onAR: Resolution was RECONNECT_REQUIRED, so reconnecting.");
            connect();
        } else if (responseCode == 0) {
            debugLog("onAR: Got a cancellation result, so disconnecting.");
            this.mSignInCancelled = true;
            this.mConnectOnStart = false;
            this.mUserInitiatedSignIn = false;
            this.mSignInFailureReason = null;
            this.mConnecting = false;
            this.mGoogleApiClient.disconnect();
            incrementSignInCancellations();
            notifyListener(false);
        } else {
            debugLog("onAR: responseCode=" + responseCode);
            giveUp(new SignInFailureReason(this.mConnectionResult.getErrorCode(), responseCode));
        }
    }

    public void onConnected(Bundle connectionHint) {
        debugLog("succeedSignIn");
        this.mSignInFailureReason = null;
        this.mConnectOnStart = true;
        this.mUserInitiatedSignIn = false;
        this.mConnecting = false;
        notifyListener(true);
    }

    public boolean hasInvitation() {
        return this.mInvitation != null;
    }

    public Invitation getInvitation() {
        return this.mInvitation;
    }

    public void clearInvitation() {
        this.mInvitation = null;
    }

    public boolean hasTurnBasedMatch() {
        return this.mTurnBasedMatch != null;
    }

    public boolean hasRequests() {
        return this.mRequests != null;
    }

    public void clearTurnBasedMatch() {
        this.mTurnBasedMatch = null;
    }

    public void clearRequests() {
        this.mRequests = null;
    }

    public TurnBasedMatch getTurnBasedMatch() {
        return this.mTurnBasedMatch;
    }

    public ArrayList<GameRequest> getRequests() {
        return this.mRequests;
    }

    public GoogleApiClient getApiClient() {
        return this.mGoogleApiClient;
    }

    public boolean isSignedIn() {
        return this.mGoogleApiClient != null && this.mGoogleApiClient.isConnected();
    }

    public boolean isConnecting() {
        return this.mConnecting;
    }

    public void signOut() {
        if (this.mGoogleApiClient.isConnected()) {
            if ((this.mRequestedClients & 1) != 0) {
                debugLog("Signing out from the Google API Client.");
                Games.signOut(this.mGoogleApiClient);
            }
            debugLog("Disconnecting client.");
            this.mConnectOnStart = false;
            this.mConnecting = false;
            this.mGoogleApiClient.disconnect();
            return;
        }
        debugLog("signOut: was already disconnected.");
    }

    public void onStop() {
        debugLog("onStop");
        if (this.mSetupDone) {
            if (this.mGoogleApiClient.isConnected()) {
                debugLog("Disconnecting client due to onStop");
                this.mGoogleApiClient.disconnect();
            } else {
                debugLog("Client already disconnected");
            }
            this.mConnecting = false;
            this.mExpectingResolution = false;
            return;
        }
        logError("Operation attempted without setup!");
    }

    private void resolveConnectionResult() {
        if (this.mExpectingResolution) {
            debugLog("We're already expecting the result of a previous resolution.");
        } else if (Extension.context == null) {
            debugLog("No need to resolve issue, activity does not exist anymore");
        } else {
            debugLog("resolveConnectionResult: trying to resolve result: " + this.mConnectionResult);
            if (this.mConnectionResult.hasResolution()) {
                debugLog("Result has resolution. Starting it.");
                try {
                    this.mExpectingResolution = true;
                    this.mConnectionResult.startResolutionForResult(Extension.context.getActivity(), RC_RESOLVE);
                    return;
                } catch (SendIntentException e) {
                    debugLog("SendIntentException, so connecting again.");
                    connect();
                    return;
                }
            }
            debugLog("resolveConnectionResult: result has no resolution. Giving up.");
            giveUp(new SignInFailureReason(this.mConnectionResult.getErrorCode()));
            this.mConnectionResult = null;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        boolean shouldResolve;
        this.mConnectionResult = result;
        debugLog("Connection failure:");
        debugLog("   - code: " + this.mConnectionResult.getErrorCode());
        debugLog("   - resolvable: " + this.mConnectionResult.hasResolution());
        debugLog("   - details: " + this.mConnectionResult.toString());
        int cancellations = getSignInCancellations();
        if (this.mUserInitiatedSignIn) {
            debugLog("onConnectionFailed: WILL resolve because user initiated sign-in.");
            shouldResolve = true;
        } else if (this.mSignInCancelled) {
            debugLog("onConnectionFailed WILL NOT resolve (user already cancelled once).");
            shouldResolve = false;
        } else if (cancellations < this.mMaxAutoSignInAttempts) {
            debugLog("onConnectionFailed: WILL resolve because we have below the mMaxAutoSignInAttempts ");
            shouldResolve = true;
        } else {
            shouldResolve = false;
            debugLog("onConnectionFailed: Will NOT resolve; not user-initiated and max attempts ");
        }
        if (shouldResolve) {
            debugLog("onConnectionFailed: resolving problem...");
            resolveConnectionResult();
            return;
        }
        debugLog("onConnectionFailed: since we won't resolve, failing now.");
        this.mConnectionResult = result;
        this.mConnecting = false;
        notifyListener(false);
    }

    public void onConnectionSuspended(int cause) {
        debugLog("onConnectionSuspended, cause=" + cause);
        disconnect();
        this.mSignInFailureReason = null;
        this.mConnecting = false;
        notifyListener(false);
    }

    private void disconnect() {
        if (this.mGoogleApiClient.isConnected()) {
            debugLog("Disconnecting client.");
            this.mGoogleApiClient.disconnect();
        }
    }

    private void giveUp(SignInFailureReason reason) {
        this.mConnectOnStart = false;
        disconnect();
        this.mSignInFailureReason = reason;
        if (reason.mActivityResultCode == GamesActivityResultCodes.RESULT_APP_MISCONFIGURED) {
            logError("RESULT_APP_MISCONFIGURED");
        }
        showFailureDialog();
        this.mConnecting = false;
        notifyListener(false);
    }

    private void showFailureDialog() {
        if (this.mSignInFailureReason != null) {
            int errorCode = this.mSignInFailureReason.getServiceErrorCode();
            switch (this.mSignInFailureReason.getActivityResultCode()) {
                case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
                    showToast("GooglePlayError : Failed to sign in. Please check your network connection and try again.");
                    return;
                case GamesActivityResultCodes.RESULT_LICENSE_FAILED /*10003*/:
                    showToast("GooglePlayError : License check failed.");
                    return;
                case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /*10004*/:
                    showToast("GooglePlayError : License check failed.");
                    return;
                default:
                    showToast("GooglePlayError : Unknown error : " + errorCode);
                    return;
            }
        }
    }

    void debugLog(String message) {
        Extension.logEvent("GameHelper: " + message);
    }

    void logError(String message) {
        Extension.logEvent("GameHelper ERROR: " + message);
    }

    private static void showToast(String toastText) {
        Toast.makeText(Extension.context.getActivity().getApplicationContext(), toastText, 0).show();
    }
}
