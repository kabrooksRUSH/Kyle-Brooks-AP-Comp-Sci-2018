package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    public static final class Builder {
        private Long zzaBH;
        private Long zzaBI;
        private BitmapTeleporter zzaBJ;
        private Uri zzaBK;
        private String zzaqZ;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zzaqZ, this.zzaBH, this.zzaBJ, this.zzaBK, this.zzaBI);
        }

        public Builder fromMetadata(SnapshotMetadata metadata) {
            this.zzaqZ = metadata.getDescription();
            this.zzaBH = Long.valueOf(metadata.getPlayedTime());
            this.zzaBI = Long.valueOf(metadata.getProgressValue());
            if (this.zzaBH.longValue() == -1) {
                this.zzaBH = null;
            }
            this.zzaBK = metadata.getCoverImageUri();
            if (this.zzaBK != null) {
                this.zzaBJ = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap coverImage) {
            this.zzaBJ = new BitmapTeleporter(coverImage);
            this.zzaBK = null;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzaqZ = description;
            return this;
        }

        public Builder setPlayedTimeMillis(long playedTimeMillis) {
            this.zzaBH = Long.valueOf(playedTimeMillis);
            return this;
        }

        public Builder setProgressValue(long progressValue) {
            this.zzaBI = Long.valueOf(progressValue);
            return this;
        }
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract Long getProgressValue();

    public abstract BitmapTeleporter zzvS();
}
