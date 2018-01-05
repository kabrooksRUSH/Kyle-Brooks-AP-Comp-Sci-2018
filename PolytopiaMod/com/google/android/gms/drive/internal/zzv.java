package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzt.zza;
import com.google.android.gms.internal.zzmt;
import java.io.InputStream;
import java.io.OutputStream;

public class zzv implements DriveContents {
    private boolean mClosed = false;
    private final Contents zzakR;
    private boolean zzakS = false;
    private boolean zzakT = false;

    class C03933 implements ResultCallback<Status> {
        final /* synthetic */ zzv zzakU;

        C03933(zzv com_google_android_gms_drive_internal_zzv) {
            this.zzakU = com_google_android_gms_drive_internal_zzv;
        }

        public /* synthetic */ void onResult(Result x0) {
            zzo((Status) x0);
        }

        public void zzo(Status status) {
            if (status.isSuccess()) {
                zzz.zzx("DriveContentsImpl", "Contents discarded");
            } else {
                zzz.zzz("DriveContentsImpl", "Error discarding contents");
            }
        }
    }

    public zzv(Contents contents) {
        this.zzakR = (Contents) zzx.zzw(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        return commit(apiClient, changeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (this.zzakR.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzck(executionOptions.zzqU()) || this.zzakR.zzqM()) {
            ExecutionOptions.zza(apiClient, executionOptions);
            if (zzqQ()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (changeSet == null) {
                    changeSet = MetadataChangeSet.zzajc;
                }
                zzqP();
                return apiClient.zzb(new zza(this, apiClient) {
                    final /* synthetic */ zzv zzakU;

                    protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                        changeSet.zzqW().setContext(com_google_android_gms_drive_internal_zzu.getContext());
                        com_google_android_gms_drive_internal_zzu.zzrm().zza(new CloseContentsAndUpdateMetadataRequest(this.zzakU.zzakR.getDriveId(), changeSet.zzqW(), this.zzakU.zzakR.getRequestId(), this.zzakU.zzakR.zzqM(), executionOptions), new zzbt(this));
                    }
                });
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public void discard(GoogleApiClient apiClient) {
        if (zzqQ()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzqP();
        ((C03944) apiClient.zzb(new zza(this, apiClient) {
            final /* synthetic */ zzv zzakU;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new CloseContentsRequest(this.zzakU.zzakR.getRequestId(), false), new zzbt(this));
            }
        })).setResultCallback(new C03933(this));
    }

    public DriveId getDriveId() {
        return this.zzakR.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzqQ()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzakR.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.zzakS) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.zzakS = true;
            return this.zzakR.getInputStream();
        }
    }

    public int getMode() {
        return this.zzakR.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzqQ()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzakR.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.zzakT) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.zzakT = true;
            return this.zzakR.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzqQ()) {
            return this.zzakR.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient apiClient) {
        if (zzqQ()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzakR.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            zzqP();
            return apiClient.zza(new zzb(this, apiClient) {
                final /* synthetic */ zzv zzakU;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzrm().zza(new OpenContentsRequest(this.zzakU.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzakU.zzakR.getRequestId()), new zzbl(this, null));
                }
            });
        }
    }

    public Contents zzqO() {
        return this.zzakR;
    }

    public void zzqP() {
        zzmt.zza(this.zzakR.getParcelFileDescriptor());
        this.mClosed = true;
    }

    public boolean zzqQ() {
        return this.mClosed;
    }
}
