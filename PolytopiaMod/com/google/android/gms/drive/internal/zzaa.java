package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzaa implements DrivePreferencesApi {

    private abstract class zzc extends zzt<FileUploadPreferencesResult> {
        final /* synthetic */ zzaa zzall;

        public zzc(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient) {
            this.zzall = com_google_android_gms_drive_internal_zzaa;
            super(googleApiClient);
        }

        protected FileUploadPreferencesResult zzF(Status status) {
            return new zzb(status, null);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzF(status);
        }
    }

    private class zza extends zzd {
        private final com.google.android.gms.internal.zzlb.zzb<FileUploadPreferencesResult> zzagy;
        final /* synthetic */ zzaa zzall;

        private zza(zzaa com_google_android_gms_drive_internal_zzaa, com.google.android.gms.internal.zzlb.zzb<FileUploadPreferencesResult> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult) {
            this.zzall = com_google_android_gms_drive_internal_zzaa;
            this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult;
        }

        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzagy.zzp(new zzb(Status.zzabb, onDeviceUsagePreferenceResponse.zzrx()));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzagy.zzp(new zzb(status, null));
        }
    }

    private class zzb implements FileUploadPreferencesResult {
        private final Status zzSC;
        final /* synthetic */ zzaa zzall;
        private final FileUploadPreferences zzaln;

        private zzb(zzaa com_google_android_gms_drive_internal_zzaa, Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzall = com_google_android_gms_drive_internal_zzaa;
            this.zzSC = status;
            this.zzaln = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzaln;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.zza(new zzc(this, apiClient) {
            final /* synthetic */ zzaa zzall;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzrm().zzd(new zza(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
            return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
                final /* synthetic */ zzaa zzall;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzrm().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new zzbt(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
