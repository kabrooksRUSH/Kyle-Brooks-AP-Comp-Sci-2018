package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

public class zzl {
    private String zzajf;
    private DriveId zzaji;
    protected MetadataChangeSet zzakl;
    private Integer zzakm;
    private final int zzakn;

    public zzl(int i) {
        this.zzakn = i;
    }

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zzb(this.zzakl, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        zzu com_google_android_gms_drive_internal_zzu = (zzu) apiClient.zza(Drive.zzRk);
        this.zzakl.zzqW().setContext(com_google_android_gms_drive_internal_zzu.getContext());
        try {
            return com_google_android_gms_drive_internal_zzu.zzrm().zza(new CreateFileIntentSenderRequest(this.zzakl.zzqW(), this.zzakm == null ? 0 : this.zzakm.intValue(), this.zzajf, this.zzaji, this.zzakn));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public void zza(DriveId driveId) {
        this.zzaji = (DriveId) zzx.zzw(driveId);
    }

    public void zza(MetadataChangeSet metadataChangeSet) {
        this.zzakl = (MetadataChangeSet) zzx.zzw(metadataChangeSet);
    }

    public void zzcE(String str) {
        this.zzajf = (String) zzx.zzw(str);
    }

    public void zzcI(int i) {
        this.zzakm = Integer.valueOf(i);
    }
}
