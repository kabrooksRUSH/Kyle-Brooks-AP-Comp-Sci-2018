package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzap.zza;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zznd;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR = new zze();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int mVersionCode;
    final String zzRs;
    final DriveId zzaiA;
    final ParcelFileDescriptor zzajC;
    final ParcelFileDescriptor zzajD;
    final MetadataBundle zzajE;
    final List<String> zzajF;
    final IBinder zzajG;
    private boolean zzajH = false;
    private boolean zzajI = false;
    private boolean zzajJ = false;
    final int zzys;

    CompletionEvent(int versionCode, DriveId driveId, String accountName, ParcelFileDescriptor baseParcelFileDescriptor, ParcelFileDescriptor modifiedParcelFileDescriptor, MetadataBundle modifiedMetadataBundle, List<String> trackingTags, int status, IBinder releaseCallback) {
        this.mVersionCode = versionCode;
        this.zzaiA = driveId;
        this.zzRs = accountName;
        this.zzajC = baseParcelFileDescriptor;
        this.zzajD = modifiedParcelFileDescriptor;
        this.zzajE = modifiedMetadataBundle;
        this.zzajF = trackingTags;
        this.zzys = status;
        this.zzajG = releaseCallback;
    }

    private void zzre() {
        if (this.zzajJ) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    private void zzt(boolean z) {
        zzre();
        this.zzajJ = true;
        zzmt.zza(this.zzajC);
        zzmt.zza(this.zzajD);
        if (this.zzajE != null && this.zzajE.zzc(zznd.zzano)) {
            ((BitmapTeleporter) this.zzajE.zza(zznd.zzano)).release();
        }
        if (this.zzajG == null) {
            zzz.zzz("CompletionEvent", "No callback on " + (z ? "snooze" : "dismiss"));
            return;
        }
        try {
            zza.zzaV(this.zzajG).zzt(z);
        } catch (RemoteException e) {
            zzz.zzz("CompletionEvent", "RemoteException on " + (z ? "snooze" : "dismiss") + ": " + e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        zzt(false);
    }

    public String getAccountName() {
        zzre();
        return this.zzRs;
    }

    public InputStream getBaseContentsInputStream() {
        zzre();
        if (this.zzajC == null) {
            return null;
        }
        if (this.zzajH) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzajH = true;
        return new FileInputStream(this.zzajC.getFileDescriptor());
    }

    public DriveId getDriveId() {
        zzre();
        return this.zzaiA;
    }

    public InputStream getModifiedContentsInputStream() {
        zzre();
        if (this.zzajD == null) {
            return null;
        }
        if (this.zzajI) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzajI = true;
        return new FileInputStream(this.zzajD.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        zzre();
        return this.zzajE != null ? new MetadataChangeSet(this.zzajE) : null;
    }

    public int getStatus() {
        zzre();
        return this.zzys;
    }

    public List<String> getTrackingTags() {
        zzre();
        return new ArrayList(this.zzajF);
    }

    public int getType() {
        return 2;
    }

    public void snooze() {
        zzt(true);
    }

    public String toString() {
        String str = this.zzajF == null ? "<null>" : "'" + TextUtils.join("','", this.zzajF) + "'";
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.zzaiA, Integer.valueOf(this.zzys), str});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags | 1);
    }
}
