package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class zzs implements DriveApi {

    static abstract class zzg extends zzt<MetadataBufferResult> {
        zzg(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public MetadataBufferResult zzC(Status status) {
            return new zzf(status, null, false);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzC(status);
        }
    }

    static abstract class zzb extends zzt<DriveContentsResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveContentsResult zzA(Status status) {
            return new zza(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzA(status);
        }
    }

    static abstract class zze extends zzt<DriveIdResult> {
        zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveIdResult zzB(Status status) {
            return new zzd(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzB(status);
        }
    }

    static class zza implements Releasable, DriveContentsResult {
        private final Status zzSC;
        private final DriveContents zzaiD;

        public zza(Status status, DriveContents driveContents) {
            this.zzSC = status;
            this.zzaiD = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.zzaiD;
        }

        public Status getStatus() {
            return this.zzSC;
        }

        public void release() {
            if (this.zzaiD != null) {
                this.zzaiD.zzqP();
            }
        }
    }

    static class zzc extends zzd {
        private final com.google.android.gms.internal.zzlb.zzb<DriveIdResult> zzagy;

        public zzc(com.google.android.gms.internal.zzlb.zzb<DriveIdResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult) {
            this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzagy.zzp(new zzd(Status.zzabb, onDriveIdResponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzagy.zzp(new zzd(Status.zzabb, new zzp(onMetadataResponse.zzrE()).getDriveId()));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzagy.zzp(new zzd(status, null));
        }
    }

    private static class zzd implements DriveIdResult {
        private final Status zzSC;
        private final DriveId zzaiA;

        public zzd(Status status, DriveId driveId) {
            this.zzSC = status;
            this.zzaiA = driveId;
        }

        public DriveId getDriveId() {
            return this.zzaiA;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    static class zzf implements MetadataBufferResult {
        private final Status zzSC;
        private final MetadataBuffer zzakA;
        private final boolean zzakB;

        public zzf(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzSC = status;
            this.zzakA = metadataBuffer;
            this.zzakB = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.zzakA;
        }

        public Status getStatus() {
            return this.zzSC;
        }

        public void release() {
            if (this.zzakA != null) {
                this.zzakA.release();
            }
        }
    }

    private static class zzh extends zzd {
        private final com.google.android.gms.internal.zzlb.zzb<DriveContentsResult> zzagy;

        public zzh(com.google.android.gms.internal.zzlb.zzb<DriveContentsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult) {
            this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        }

        public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
            this.zzagy.zzp(new zza(Status.zzabb, new zzv(onContentsResponse.zzrv())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzagy.zzp(new zza(status, null));
        }
    }

    private static class zzi extends zzd {
        private final com.google.android.gms.internal.zzlb.zzb<MetadataBufferResult> zzagy;

        public zzi(com.google.android.gms.internal.zzlb.zzb<MetadataBufferResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.zzagy.zzp(new zzf(Status.zzabb, new MetadataBuffer(onListEntriesResponse.zzrB()), onListEntriesResponse.zzrC()));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzagy.zzp(new zzf(status, null, false));
        }
    }

    static class zzj extends com.google.android.gms.drive.internal.zzt.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            zzb((Result) status);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) {
        }
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, List<String> trackingTags) {
        return ((zzu) apiClient.zza(Drive.zzRk)).cancelPendingActions(apiClient, trackingTags);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.zza(new zze(this, apiClient) {
            final /* synthetic */ zzs zzakv;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new GetMetadataRequest(DriveId.zzcB(resourceId), false), new zzc(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        zzu com_google_android_gms_drive_internal_zzu = (zzu) apiClient.zza(Drive.zzRk);
        if (com_google_android_gms_drive_internal_zzu.zzrp()) {
            DriveId zzro = com_google_android_gms_drive_internal_zzu.zzro();
            return zzro != null ? new zzy(zzro) : null;
        } else {
            throw new IllegalStateException("Client is not yet connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzw(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzy(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        zzu com_google_android_gms_drive_internal_zzu = (zzu) apiClient.zza(Drive.zzRk);
        if (com_google_android_gms_drive_internal_zzu.zzrp()) {
            return new zzy(com_google_android_gms_drive_internal_zzu.zzrn());
        }
        throw new IllegalStateException("Client is not yet connected");
    }

    public PendingResult<BooleanResult> isAutobackupEnabled(GoogleApiClient apiClient) {
        return apiClient.zza(new zzt<BooleanResult>(this, apiClient) {
            final /* synthetic */ zzs zzakv;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zze(new zzd(this) {
                    final /* synthetic */ C03855 zzakz;

                    public void zzab(boolean z) {
                        this.zzb(new BooleanResult(Status.zzabb, z));
                    }
                });
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzz(status);
            }

            protected BooleanResult zzz(Status status) {
                return new BooleanResult(status, false);
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient apiClient) {
        return zza(apiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.zza(new zzg(this, apiClient) {
                final /* synthetic */ zzs zzakv;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzrm().zza(new QueryRequest(query), new zzi(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzs zzakv;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new zzbt(this));
            }
        });
    }

    public PendingResult<DriveContentsResult> zza(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzs zzakv;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new CreateContentsRequest(i), new zzh(this));
            }
        });
    }
}
