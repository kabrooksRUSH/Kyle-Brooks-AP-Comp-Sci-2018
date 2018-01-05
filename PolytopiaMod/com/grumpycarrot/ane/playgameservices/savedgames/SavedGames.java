package com.grumpycarrot.ane.playgameservices.savedgames;

import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.grumpycarrot.ane.playgameservices.Extension;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SavedGames {
    public static final int RC_SAVED_GAMES = 9009;
    private int asyncConflictPolicy;
    private boolean asyncForceReload;
    private String asyncNewData;
    private String asyncNewDescription;
    private long asyncNewPlayedTimeMillis;
    private long asyncNewProgressValue;
    private String asyncOpenGameName;
    private Snapshot currentOpenedSnapshot = null;
    private byte[] mSaveGameData;
    private SnapshotMetadataBuffer mSnapshotMetadataBuffer;

    class C07311 extends AsyncTask<Void, Void, Integer> {
        C07311() {
        }

        protected Integer doInBackground(Void... params) {
            LoadSnapshotsResult result = (LoadSnapshotsResult) Games.Snapshots.load(Extension.context.getApiClient(), SavedGames.this.asyncForceReload).await();
            if (result.getStatus().isSuccess()) {
                Extension.logEvent("Load all Snapshots Success");
                SavedGames.this.mSnapshotMetadataBuffer = result.getSnapshots();
            } else {
                Extension.logEvent("Error while loading games list: " + result.getStatus().getStatusCode());
                SavedGames.this.mSnapshotMetadataBuffer = null;
                Extension.context.sendEventToAir("ON_LOAD_SAVEDGAMES_FAILED");
            }
            return Integer.valueOf(result.getStatus().getStatusCode());
        }

        protected void onPostExecute(Integer status) {
            Extension.logEvent("Load ALL Snapshots Async Finished");
            if (SavedGames.this.mSnapshotMetadataBuffer != null) {
                SavedGames.this.sendGameListToFlash();
            }
        }
    }

    class C07322 extends AsyncTask<Void, Void, Integer> {
        C07322() {
        }

        protected Integer doInBackground(Void... params) {
            OpenSnapshotResult result = (OpenSnapshotResult) Games.Snapshots.open(Extension.context.getApiClient(), SavedGames.this.asyncOpenGameName, true, SavedGames.this.asyncConflictPolicy).await();
            int status = result.getStatus().getStatusCode();
            if (status == 0) {
                Extension.logEvent("Open Snapshot Success");
                SavedGames.this.currentOpenedSnapshot = result.getSnapshot();
                try {
                    SavedGames.this.mSaveGameData = SavedGames.this.currentOpenedSnapshot.getSnapshotContents().readFully();
                } catch (IOException e) {
                    Extension.logEvent("Exception reading snapshot: " + e.getMessage());
                    SavedGames.this.mSaveGameData = null;
                }
            } else {
                Extension.logEvent("Error while loading: " + status);
                SavedGames.this.currentOpenedSnapshot = null;
                SavedGames.this.mSaveGameData = null;
                Extension.context.sendEventToAir("ON_OPEN_FAILED");
            }
            return Integer.valueOf(status);
        }

        protected void onPostExecute(Integer status) {
            Extension.logEvent("Open Snapshot Async Finished");
            if (SavedGames.this.mSaveGameData != null) {
                Extension.logEvent("Data found");
                if (SavedGames.this.mSaveGameData.length > 0) {
                    Extension.context.sendEventToAir("OPEN_SUCCESS", SavedGames.this.convertBytesToString(SavedGames.this.mSaveGameData));
                } else {
                    Extension.context.sendEventToAir("OPEN_SUCCESS", "NewSnapshot");
                }
            }
            SavedGames.this.asyncOpenGameName = null;
            SavedGames.this.mSaveGameData = null;
        }
    }

    class C07333 extends AsyncTask<Void, Void, Integer> {
        C07333() {
        }

        protected Integer doInBackground(Void... params) {
            SnapshotMetadataChange metadataChange;
            SavedGames.this.currentOpenedSnapshot.getSnapshotContents().writeBytes(SavedGames.this.convertStringToBytes(SavedGames.this.asyncNewData));
            boolean isMetaDataChange = false;
            Builder metadataChangeBuilder = new Builder();
            if (SavedGames.this.currentOpenedSnapshot.getMetadata().getDescription() == null) {
                metadataChangeBuilder.setDescription(SavedGames.this.asyncNewDescription);
                isMetaDataChange = true;
            } else if (!SavedGames.this.currentOpenedSnapshot.getMetadata().getDescription().equals(SavedGames.this.asyncNewDescription)) {
                metadataChangeBuilder.setDescription(SavedGames.this.asyncNewDescription);
                isMetaDataChange = true;
            }
            if (SavedGames.this.currentOpenedSnapshot.getMetadata().getPlayedTime() != SavedGames.this.asyncNewPlayedTimeMillis) {
                metadataChangeBuilder.setPlayedTimeMillis(SavedGames.this.asyncNewPlayedTimeMillis);
                isMetaDataChange = true;
            }
            if (SavedGames.this.currentOpenedSnapshot.getMetadata().getProgressValue() != SavedGames.this.asyncNewProgressValue) {
                metadataChangeBuilder.setProgressValue(SavedGames.this.asyncNewProgressValue);
                isMetaDataChange = true;
            }
            if (isMetaDataChange) {
                Extension.logEvent("MetaData has changed since last time");
                metadataChange = metadataChangeBuilder.build();
            } else {
                Extension.logEvent("No change to Metadata");
                metadataChange = SnapshotMetadataChange.EMPTY_CHANGE;
            }
            CommitSnapshotResult result = (CommitSnapshotResult) Games.Snapshots.commitAndClose(Extension.context.getApiClient(), SavedGames.this.currentOpenedSnapshot, metadataChange).await();
            if (result.getStatus().isSuccess()) {
                Extension.logEvent("Write Snapshot Success " + result.getStatus().getStatusCode());
                Extension.context.sendEventToAir("WRITE_SUCCESS");
            } else {
                Extension.logEvent("Write Snapshot Error: " + result.getStatus().getStatusCode());
                Extension.context.sendEventToAir("WRITE_FAILED");
            }
            return Integer.valueOf(result.getStatus().getStatusCode());
        }

        protected void onPostExecute(Integer status) {
            Extension.logEvent("Write Snapshot Async Finished " + status);
            SavedGames.this.asyncNewData = null;
            SavedGames.this.asyncNewDescription = null;
            SavedGames.this.currentOpenedSnapshot = null;
            SavedGames.this.mSaveGameData = null;
        }
    }

    class C07344 extends AsyncTask<Void, Void, Integer> {
        C07344() {
        }

        protected Integer doInBackground(Void... params) {
            DeleteSnapshotResult result = (DeleteSnapshotResult) Games.Snapshots.delete(Extension.context.getApiClient(), SavedGames.this.currentOpenedSnapshot.getMetadata()).await();
            if (result.getStatus().isSuccess()) {
                Extension.logEvent("Delete Snapshot Success");
                Extension.context.sendEventToAir("ON_DELETE_SUCCESS");
            } else {
                Extension.logEvent("Delete Snapshot Failed: " + result.getStatus().getStatusCode());
                Extension.context.sendEventToAir("ON_DELETE_FAILED");
            }
            return Integer.valueOf(result.getStatus().getStatusCode());
        }

        protected void onPostExecute(Integer status) {
            Extension.logEvent("Delete Snapshot Async Finished");
            SavedGames.this.currentOpenedSnapshot = null;
            SavedGames.this.mSaveGameData = null;
        }
    }

    public void showSavedGamesUI(String title, boolean allowAddButton, boolean allowDelete, int maxSnapshotsToShow) {
        Extension.context.getActivity().startActivityForResult(Games.Snapshots.getSelectSnapshotIntent(Extension.context.getApiClient(), title, allowAddButton, allowDelete, maxSnapshotsToShow), RC_SAVED_GAMES);
    }

    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        if (responseCode != -1) {
            Extension.logEvent("User Cancel saved game Intent");
            Extension.context.sendEventToAir("ON_UI_CANCEL");
        } else if (intent == null) {
        } else {
            if (intent.hasExtra(Snapshots.EXTRA_SNAPSHOT_METADATA)) {
                Extension.logEvent("ActivityResult : Load a snapshot.");
                Extension.context.sendEventToAir("ON_UI_LOAD_GAME", SnapshotMetadataToJsonString((SnapshotMetadata) intent.getParcelableExtra(Snapshots.EXTRA_SNAPSHOT_METADATA)));
            } else if (intent.hasExtra(Snapshots.EXTRA_SNAPSHOT_NEW)) {
                Extension.logEvent("ActivityResult : Create NewFile");
                Extension.context.sendEventToAir("ON_UI_CREATE_GAME");
            }
        }
    }

    public void loadSnapshots(boolean forceReload) {
        Extension.logEvent("Load The entire game list of saved stuff for player");
        this.asyncForceReload = forceReload;
        this.mSnapshotMetadataBuffer = null;
        new C07311().execute(new Void[0]);
    }

    private void sendGameListToFlash() {
        int totalGames = this.mSnapshotMetadataBuffer.getCount();
        Extension.logEvent("Number of game found : " + totalGames);
        JSONArray jsonSavedGamesList = new JSONArray();
        for (int i = 0; i < totalGames; i++) {
            jsonSavedGamesList.put(SnapshotMetadataToJsonObject(this.mSnapshotMetadataBuffer.get(i)));
        }
        Extension.context.sendEventToAir("ON_LOAD_SAVEDGAMES_SUCCESS", jsonSavedGamesList.toString());
        this.mSnapshotMetadataBuffer = null;
    }

    public void openSnapshot(String openGameName, int conflictPolicy) {
        this.asyncOpenGameName = openGameName;
        this.asyncConflictPolicy = conflictPolicy;
        this.currentOpenedSnapshot = null;
        Extension.logEvent("openSnapshot");
        new C07322().execute(new Void[0]);
    }

    public void writeGame(String uniqueName, String newData, String newDescription, long newPlayedTimeMillis, long newProgressValue) {
        if (isCurrentSnapShotSameAs(uniqueName)) {
            Extension.logEvent("File is Open so we can write on it");
            writeToOpenSnapshot(newData, newDescription, newPlayedTimeMillis, newProgressValue);
            return;
        }
        Extension.logEvent("File not open");
        Extension.context.sendEventToAir("WRITE_ERROR_FILE_NOT_OPEN");
    }

    private void writeToOpenSnapshot(String newData, String newDescription, long newPlayedTimeMillis, long newProgressValue) {
        Extension.logEvent("writeToOpenSnapshot");
        this.asyncNewData = newData;
        this.asyncNewDescription = newDescription;
        this.asyncNewPlayedTimeMillis = newPlayedTimeMillis;
        this.asyncNewProgressValue = newProgressValue;
        new C07333().execute(new Void[0]);
    }

    public void deleteGame(String uniqueName) {
        if (isCurrentSnapShotSameAs(uniqueName)) {
            Extension.logEvent("File is Open so we can delete it");
            deleteSnapshot();
            return;
        }
        Extension.logEvent("File not open");
        Extension.context.sendEventToAir("ON_DELETE_ERROR_FILE_NOT_OPEN");
    }

    private void deleteSnapshot() {
        Extension.logEvent("deleteSnapshot");
        new C07344().execute(new Void[0]);
    }

    private boolean isCurrentSnapShotSameAs(String snapShotName) {
        if (this.currentOpenedSnapshot != null && this.currentOpenedSnapshot.getMetadata().getUniqueName().equals(snapShotName)) {
            return true;
        }
        return false;
    }

    private String SnapshotMetadataToJsonString(SnapshotMetadata snapshotMetadata) {
        return SnapshotMetadataToJsonObject(snapshotMetadata).toString();
    }

    private JSONObject SnapshotMetadataToJsonObject(SnapshotMetadata snapshotMetadata) {
        JSONObject jsonSnapshotMetadata = new JSONObject();
        try {
            jsonSnapshotMetadata.put("uniqueName", snapshotMetadata.getUniqueName());
            jsonSnapshotMetadata.put("description", snapshotMetadata.getDescription());
            jsonSnapshotMetadata.put("lastModifiedTimestamp", snapshotMetadata.getLastModifiedTimestamp());
            jsonSnapshotMetadata.put("playedTime", snapshotMetadata.getPlayedTime());
            jsonSnapshotMetadata.put("progressValue", snapshotMetadata.getProgressValue());
        } catch (JSONException e) {
        }
        return jsonSnapshotMetadata;
    }

    private byte[] convertStringToBytes(String value) {
        return value.getBytes(Charset.forName("UTF-8"));
    }

    private String convertBytesToString(byte[] byteArray) {
        try {
            String st = new String(byteArray, "UTF-8");
            return st;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return "";
        }
    }
}
