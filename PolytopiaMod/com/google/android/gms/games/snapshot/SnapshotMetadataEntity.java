package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final Creator<SnapshotMetadataEntity> CREATOR = new SnapshotMetadataEntityCreator();
    private final int mVersionCode;
    private final GameEntity zzaAy;
    private final Uri zzaBK;
    private final PlayerEntity zzaBN;
    private final String zzaBO;
    private final long zzaBP;
    private final long zzaBQ;
    private final float zzaBR;
    private final String zzaBS;
    private final boolean zzaBT;
    private final long zzaBU;
    private final String zzaBV;
    private final String zzajf;
    private final String zzaqZ;
    private final String zzavx;

    SnapshotMetadataEntity(int versionCode, GameEntity game, PlayerEntity owner, String snapshotId, Uri coverImageUri, String coverImageUrl, String title, String description, long lastModifiedTimestamp, long playedTime, float coverImageAspectRatio, String uniqueName, boolean changePending, long progressValue, String deviceName) {
        this.mVersionCode = versionCode;
        this.zzaAy = game;
        this.zzaBN = owner;
        this.zzavx = snapshotId;
        this.zzaBK = coverImageUri;
        this.zzaBO = coverImageUrl;
        this.zzaBR = coverImageAspectRatio;
        this.zzajf = title;
        this.zzaqZ = description;
        this.zzaBP = lastModifiedTimestamp;
        this.zzaBQ = playedTime;
        this.zzaBS = uniqueName;
        this.zzaBT = changePending;
        this.zzaBU = progressValue;
        this.zzaBV = deviceName;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.mVersionCode = 6;
        this.zzaAy = new GameEntity(snapshotMetadata.getGame());
        this.zzaBN = new PlayerEntity(snapshotMetadata.getOwner());
        this.zzavx = snapshotMetadata.getSnapshotId();
        this.zzaBK = snapshotMetadata.getCoverImageUri();
        this.zzaBO = snapshotMetadata.getCoverImageUrl();
        this.zzaBR = snapshotMetadata.getCoverImageAspectRatio();
        this.zzajf = snapshotMetadata.getTitle();
        this.zzaqZ = snapshotMetadata.getDescription();
        this.zzaBP = snapshotMetadata.getLastModifiedTimestamp();
        this.zzaBQ = snapshotMetadata.getPlayedTime();
        this.zzaBS = snapshotMetadata.getUniqueName();
        this.zzaBT = snapshotMetadata.hasChangePending();
        this.zzaBU = snapshotMetadata.getProgressValue();
        this.zzaBV = snapshotMetadata.getDeviceName();
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return zzw.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName());
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return zzw.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && zzw.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && zzw.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && zzw.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && zzw.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && zzw.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && zzw.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && zzw.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && zzw.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && zzw.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && zzw.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && zzw.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && zzw.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        return zzw.zzv(snapshotMetadata).zzg("Game", snapshotMetadata.getGame()).zzg("Owner", snapshotMetadata.getOwner()).zzg("SnapshotId", snapshotMetadata.getSnapshotId()).zzg("CoverImageUri", snapshotMetadata.getCoverImageUri()).zzg("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).zzg("Description", snapshotMetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).zzg("UniqueName", snapshotMetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).zzg("DeviceName", snapshotMetadata.getDeviceName()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.zzaBR;
    }

    public Uri getCoverImageUri() {
        return this.zzaBK;
    }

    public String getCoverImageUrl() {
        return this.zzaBO;
    }

    public String getDescription() {
        return this.zzaqZ;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzaqZ, dataOut);
    }

    public String getDeviceName() {
        return this.zzaBV;
    }

    public Game getGame() {
        return this.zzaAy;
    }

    public long getLastModifiedTimestamp() {
        return this.zzaBP;
    }

    public Player getOwner() {
        return this.zzaBN;
    }

    public long getPlayedTime() {
        return this.zzaBQ;
    }

    public long getProgressValue() {
        return this.zzaBU;
    }

    public String getSnapshotId() {
        return this.zzavx;
    }

    public String getTitle() {
        return this.zzajf;
    }

    public String getUniqueName() {
        return this.zzaBS;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasChangePending() {
        return this.zzaBT;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataEntityCreator.zza(this, out, flags);
    }
}
