package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzh();
    final int mVersionCode;
    final String zzaiX;
    final boolean zzaiY;
    final DriveId zzakc;
    final MetadataBundle zzakd;
    final Contents zzake;
    final int zzakf;
    final int zzakg;
    final boolean zzakh;

    CloseContentsAndUpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, boolean notifyOnCompletion, String trackingTag, int commitStrategy, int contentsRequestId, boolean isContentsValidForConflictDetection) {
        this.mVersionCode = versionCode;
        this.zzakc = id;
        this.zzakd = metadataChangeSet;
        this.zzake = contentsReference;
        this.zzaiY = notifyOnCompletion;
        this.zzaiX = trackingTag;
        this.zzakf = commitStrategy;
        this.zzakg = contentsRequestId;
        this.zzakh = isContentsValidForConflictDetection;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet, int contentsRequestId, boolean isContentsValidForConflictDetection, ExecutionOptions executionOptions) {
        this(1, id, metadataChangeSet, null, executionOptions.zzqT(), executionOptions.zzqS(), executionOptions.zzqU(), contentsRequestId, isContentsValidForConflictDetection);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
