package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

public class zzy extends zzab implements DriveFolder {

    static abstract class zzd extends zzt<DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveFileResult zzD(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzD(status);
        }
    }

    static abstract class zzf extends zzt<DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveFolderResult zzE(Status status) {
            return new zze(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzE(status);
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.internal.zzlb.zzb<DriveFileResult> zzagy;

        public zza(com.google.android.gms.internal.zzlb.zzb<DriveFileResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult) {
            this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzagy.zzp(new zzc(Status.zzabb, new zzw(onDriveIdResponse.getDriveId())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzagy.zzp(new zzc(status, null));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.internal.zzlb.zzb<DriveFolderResult> zzagy;

        public zzb(com.google.android.gms.internal.zzlb.zzb<DriveFolderResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult) {
            this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzagy.zzp(new zze(Status.zzabb, new zzy(onDriveIdResponse.getDriveId())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzagy.zzp(new zze(status, null));
        }
    }

    private static class zzc implements DriveFileResult {
        private final Status zzSC;
        private final DriveFile zzali;

        public zzc(Status status, DriveFile driveFile) {
            this.zzSC = status;
            this.zzali = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.zzali;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    private static class zze implements DriveFolderResult {
        private final Status zzSC;
        private final DriveFolder zzalj;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzSC = status;
            this.zzalj = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.zzalj;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    public zzy(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        ExecutionOptions.zza(googleApiClient, executionOptions);
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i3 = i;
        final int i4 = i2;
        final ExecutionOptions executionOptions2 = executionOptions;
        return googleApiClient.zzb(new zzd(this, googleApiClient) {
            final /* synthetic */ zzy zzalh;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                metadataChangeSet2.zzqW().setContext(com_google_android_gms_drive_internal_zzu.getContext());
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new CreateFileRequest(this.zzalh.getDriveId(), metadataChangeSet2.zzqW(), i3, i4, executionOptions2), new zza(this));
            }
        });
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else if (!(driveContents instanceof zzv)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzqQ()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            i = driveContents.zzqO().getRequestId();
            driveContents.zzqP();
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return zza(googleApiClient, metadataChangeSet, i, 0, executionOptions);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    private Query zza(Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents) {
        return createFile(apiClient, changeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new ExecutionOptions.Builder().build();
        }
        if (executionOptions.zzqU() == 0) {
            return zza(apiClient, changeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.zzb(new zzf(this, apiClient) {
                final /* synthetic */ zzy zzalh;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    changeSet.zzqW().setContext(com_google_android_gms_drive_internal_zzu.getContext());
                    com_google_android_gms_drive_internal_zzu.zzrm().zza(new CreateFolderRequest(this.zzalh.getDriveId(), changeSet.zzqW()), new zzb(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        return new zzs().query(apiClient, zza(query));
    }
}
