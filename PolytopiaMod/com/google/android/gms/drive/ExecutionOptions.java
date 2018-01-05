package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.internal.zzu;

public final class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final String zzaiX;
    private final boolean zzaiY;
    private final int zzaiZ;

    public static final class Builder {
        private String zzaiX;
        private boolean zzaiY;
        private int zzaiZ = 0;

        public ExecutionOptions build() {
            if (this.zzaiZ != 1 || this.zzaiY) {
                return new ExecutionOptions(this.zzaiX, this.zzaiY, this.zzaiZ);
            }
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
        }

        public Builder setConflictStrategy(int strategy) {
            if (ExecutionOptions.zzcl(strategy)) {
                this.zzaiZ = strategy;
                return this;
            }
            throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + strategy);
        }

        public Builder setNotifyOnCompletion(boolean notify) {
            this.zzaiY = notify;
            return this;
        }

        public Builder setTrackingTag(String trackingTag) {
            if (ExecutionOptions.zzcC(trackingTag)) {
                this.zzaiX = trackingTag;
                return this;
            }
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[]{Integer.valueOf(ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH)}));
        }
    }

    public ExecutionOptions(String trackingTag, boolean notifyOnCompletion, int conflictStrategy) {
        this.zzaiX = trackingTag;
        this.zzaiY = notifyOnCompletion;
        this.zzaiZ = conflictStrategy;
    }

    public static void zza(GoogleApiClient googleApiClient, ExecutionOptions executionOptions) {
        zzu com_google_android_gms_drive_internal_zzu = (zzu) googleApiClient.zza(Drive.zzRk);
        if (executionOptions.zzqT() && !com_google_android_gms_drive_internal_zzu.zzrq()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public static boolean zzcC(String str) {
        return (str == null || str.isEmpty() || str.length() > MAX_TRACKING_TAG_STRING_LENGTH) ? false : true;
    }

    public static boolean zzck(int i) {
        switch (i) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcl(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) o;
        return zzw.equal(this.zzaiX, executionOptions.zzaiX) && this.zzaiZ == executionOptions.zzaiZ && this.zzaiY == executionOptions.zzaiY;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaiX, Integer.valueOf(this.zzaiZ), Boolean.valueOf(this.zzaiY));
    }

    public String zzqS() {
        return this.zzaiX;
    }

    public boolean zzqT() {
        return this.zzaiY;
    }

    public int zzqU() {
        return this.zzaiZ;
    }
}
