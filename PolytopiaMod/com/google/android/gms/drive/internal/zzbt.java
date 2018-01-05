package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;

public class zzbt extends zzd {
    private final zzb<Status> zzagy;

    public zzbt(zzb<Status> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status) {
        this.zzagy = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status;
    }

    public void onSuccess() throws RemoteException {
        this.zzagy.zzp(Status.zzabb);
    }

    public void zzy(Status status) throws RemoteException {
        this.zzagy.zzp(status);
    }
}
