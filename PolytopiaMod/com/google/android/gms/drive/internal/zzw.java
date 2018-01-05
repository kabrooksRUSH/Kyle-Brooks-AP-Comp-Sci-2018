package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zzb;

public class zzw extends zzab implements DriveFile {

    private static class zza implements DownloadProgressListener {
        private final zzlm<DownloadProgressListener> zzakZ;

        public zza(zzlm<DownloadProgressListener> com_google_android_gms_internal_zzlm_com_google_android_gms_drive_DriveFile_DownloadProgressListener) {
            this.zzakZ = com_google_android_gms_internal_zzlm_com_google_android_gms_drive_DriveFile_DownloadProgressListener;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            final long j = bytesDownloaded;
            final long j2 = bytesExpected;
            this.zzakZ.zza(new zzb<DownloadProgressListener>(this) {
                final /* synthetic */ zza zzalc;

                public void zza(DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                public void zznN() {
                }

                public /* synthetic */ void zzq(Object obj) {
                    zza((DownloadProgressListener) obj);
                }
            });
        }
    }

    public zzw(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new zza(googleApiClient.zzo(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient apiClient, final int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            final DownloadProgressListener zza = zza(apiClient, listener);
            return apiClient.zza(new zzb(this, apiClient) {
                final /* synthetic */ zzw zzakY;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    zza(com_google_android_gms_drive_internal_zzu.zzrm().zza(new OpenContentsRequest(this.zzakY.getDriveId(), mode, 0), new zzbl(this, zza)).zzrr());
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
