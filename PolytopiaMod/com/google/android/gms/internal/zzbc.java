package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbb.zza;
import java.util.concurrent.Future;

@zzgr
public class zzbc {
    private zzbb zza(Context context, VersionInfoParcel versionInfoParcel, final zzin<zzbb> com_google_android_gms_internal_zzin_com_google_android_gms_internal_zzbb, zzan com_google_android_gms_internal_zzan) {
        final zzbb com_google_android_gms_internal_zzbd = new zzbd(context, versionInfoParcel, com_google_android_gms_internal_zzan);
        com_google_android_gms_internal_zzbd.zza(new zza(this) {
            final /* synthetic */ zzbc zzrD;

            public void zzcj() {
                com_google_android_gms_internal_zzin_com_google_android_gms_internal_zzbb.zzf(com_google_android_gms_internal_zzbd);
            }
        });
        return com_google_android_gms_internal_zzbd;
    }

    public Future<zzbb> zza(Context context, VersionInfoParcel versionInfoParcel, String str, zzan com_google_android_gms_internal_zzan) {
        final Future com_google_android_gms_internal_zzin = new zzin();
        final Context context2 = context;
        final VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        final zzan com_google_android_gms_internal_zzan2 = com_google_android_gms_internal_zzan;
        final String str2 = str;
        zzid.zzIE.post(new Runnable(this) {
            final /* synthetic */ zzbc zzrD;

            public void run() {
                this.zzrD.zza(context2, versionInfoParcel2, com_google_android_gms_internal_zzin, com_google_android_gms_internal_zzan2).zzt(str2);
            }
        });
        return com_google_android_gms_internal_zzin;
    }
}
