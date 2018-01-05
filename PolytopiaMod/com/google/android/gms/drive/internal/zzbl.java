package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.internal.zzlb.zzb;

class zzbl extends zzd {
    private final zzb<DriveContentsResult> zzagy;
    private final DownloadProgressListener zzamp;

    zzbl(zzb<DriveContentsResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult, DownloadProgressListener downloadProgressListener) {
        this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        this.zzamp = downloadProgressListener;
    }

    public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
        this.zzagy.zzp(new zza(onContentsResponse.zzrw() ? new Status(-1) : Status.zzabb, new zzv(onContentsResponse.zzrv())));
    }

    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.zzamp != null) {
            this.zzamp.onProgress(onDownloadProgressResponse.zzry(), onDownloadProgressResponse.zzrz());
        }
    }

    public void zzy(Status status) throws RemoteException {
        this.zzagy.zzp(new zza(status, null));
    }
}
