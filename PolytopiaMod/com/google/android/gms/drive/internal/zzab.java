package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class zzab implements DriveResource {
    protected final DriveId zzaiA;

    private abstract class zzd extends zzt<MetadataResult> {
        final /* synthetic */ zzab zzalp;

        private zzd(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient) {
            this.zzalp = com_google_android_gms_drive_internal_zzab;
            super(googleApiClient);
        }

        public MetadataResult zzG(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzG(status);
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.internal.zzlb.zzb<MetadataBufferResult> zzagy;

        public zza(com.google.android.gms.internal.zzlb.zzb<MetadataBufferResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzagy.zzp(new zzf(Status.zzabb, new MetadataBuffer(onListParentsResponse.zzrD()), false));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzagy.zzp(new zzf(status, null, false));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.internal.zzlb.zzb<MetadataResult> zzagy;

        public zzb(com.google.android.gms.internal.zzlb.zzb<MetadataResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveResource_MetadataResult) {
            this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveResource_MetadataResult;
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzagy.zzp(new zzc(Status.zzabb, new zzp(onMetadataResponse.zzrE())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzagy.zzp(new zzc(status, null));
        }
    }

    private static class zzc implements MetadataResult {
        private final Status zzSC;
        private final Metadata zzalr;

        public zzc(Status status, Metadata metadata) {
            this.zzSC = status;
            this.zzalr = metadata;
        }

        public Metadata getMetadata() {
            return this.zzalr;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    public zzab(DriveId driveId) {
        this.zzaiA = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(this, googleApiClient) {
            final /* synthetic */ zzab zzalp;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new GetMetadataRequest(this.zzalp.zzaiA, z), new zzb(this));
            }
        });
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzu) apiClient.zza(Drive.zzRk)).zza(apiClient, this.zzaiA, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((zzu) apiClient.zza(Drive.zzRk)).zza(apiClient, this.zzaiA);
    }

    public PendingResult<Status> delete(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzab zzalp;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new DeleteResourceRequest(this.zzalp.zzaiA), new zzbt(this));
            }
        });
    }

    public DriveId getDriveId() {
        return this.zzaiA;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return zza(apiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.zza(new zzg(this, apiClient) {
            final /* synthetic */ zzab zzalp;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new ListParentsRequest(this.zzalp.zzaiA), new zza(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzu) apiClient.zza(Drive.zzRk)).zzb(apiClient, this.zzaiA, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((zzu) apiClient.zza(Drive.zzRk)).zzb(apiClient, this.zzaiA);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        }
        final List arrayList = new ArrayList(parentIds);
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzab zzalp;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new SetResourceParentsRequest(this.zzalp.zzaiA, arrayList), new zzbt(this));
            }
        });
    }

    public PendingResult<Status> trash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzab zzalp;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new TrashResourceRequest(this.zzalp.zzaiA), new zzbt(this));
            }
        });
    }

    public PendingResult<Status> untrash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzab zzalp;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zza(new UntrashResourceRequest(this.zzalp.zzaiA), new zzbt(this));
            }
        });
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.zzb(new zzd(this, apiClient) {
                final /* synthetic */ zzab zzalp;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    changeSet.zzqW().setContext(com_google_android_gms_drive_internal_zzu.getContext());
                    com_google_android_gms_drive_internal_zzu.zzrm().zza(new UpdateMetadataRequest(this.zzalp.zzaiA, changeSet.zzqW()), new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
