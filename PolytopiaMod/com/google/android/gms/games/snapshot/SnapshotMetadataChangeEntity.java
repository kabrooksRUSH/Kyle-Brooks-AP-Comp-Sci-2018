package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int mVersionCode;
    private final Long zzaBI;
    private final Uri zzaBK;
    private final Long zzaBL;
    private BitmapTeleporter zzaBM;
    private final String zzaqZ;

    SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int versionCode, String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        boolean z = true;
        this.mVersionCode = versionCode;
        this.zzaqZ = description;
        this.zzaBL = playedTimeMillis;
        this.zzaBM = coverImage;
        this.zzaBK = coverImageUri;
        this.zzaBI = progressValue;
        if (this.zzaBM != null) {
            if (this.zzaBK != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        } else if (this.zzaBK != null) {
            if (this.zzaBM != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        this(5, description, playedTimeMillis, coverImage, coverImageUri, progressValue);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        return this.zzaBM == null ? null : this.zzaBM.zzos();
    }

    public Uri getCoverImageUri() {
        return this.zzaBK;
    }

    public String getDescription() {
        return this.zzaqZ;
    }

    public Long getPlayedTimeMillis() {
        return this.zzaBL;
    }

    public Long getProgressValue() {
        return this.zzaBI;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataChangeCreator.zza(this, out, flags);
    }

    public BitmapTeleporter zzvS() {
        return this.zzaBM;
    }
}
