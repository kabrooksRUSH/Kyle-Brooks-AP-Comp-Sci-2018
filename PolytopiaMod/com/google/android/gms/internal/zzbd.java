package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

@zzgr
public class zzbd implements zzbb {
    private final zziz zzoM;

    public zzbd(Context context, VersionInfoParcel versionInfoParcel, zzan com_google_android_gms_internal_zzan) {
        this.zzoM = zzp.zzbw().zza(context, new AdSizeParcel(), false, false, com_google_android_gms_internal_zzan, versionInfoParcel);
        this.zzoM.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzl.zzcF().zzgT()) {
            runnable.run();
        } else {
            zzid.zzIE.post(runnable);
        }
    }

    public void destroy() {
        this.zzoM.destroy();
    }

    public void zza(zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzdg com_google_android_gms_internal_zzdg, zzn com_google_android_gms_ads_internal_overlay_zzn, boolean z, zzdm com_google_android_gms_internal_zzdm, zzdo com_google_android_gms_internal_zzdo, zze com_google_android_gms_ads_internal_zze, zzfi com_google_android_gms_internal_zzfi) {
        this.zzoM.zzhe().zzb(com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzg, com_google_android_gms_internal_zzdg, com_google_android_gms_ads_internal_overlay_zzn, z, com_google_android_gms_internal_zzdm, com_google_android_gms_internal_zzdo, new zze(false), com_google_android_gms_internal_zzfi);
    }

    public void zza(final zzbb.zza com_google_android_gms_internal_zzbb_zza) {
        this.zzoM.zzhe().zza(new zzja.zza(this) {
            final /* synthetic */ zzbd zzrH;

            public void zza(zziz com_google_android_gms_internal_zziz, boolean z) {
                com_google_android_gms_internal_zzbb_zza.zzcj();
            }
        });
    }

    public void zza(String str, zzdk com_google_android_gms_internal_zzdk) {
        this.zzoM.zzhe().zza(str, com_google_android_gms_internal_zzdk);
    }

    public void zza(final String str, final String str2) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrH;

            public void run() {
                this.zzrH.zzoM.zza(str, str2);
            }
        });
    }

    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrH;

            public void run() {
                this.zzrH.zzoM.zza(str, jSONObject);
            }
        });
    }

    public void zzb(String str, zzdk com_google_android_gms_internal_zzdk) {
        this.zzoM.zzhe().zzb(str, com_google_android_gms_internal_zzdk);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzoM.zzb(str, jSONObject);
    }

    public zzbf zzci() {
        return new zzbg(this);
    }

    public void zzs(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str});
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrH;

            public void run() {
                this.zzrH.zzoM.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    public void zzt(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrH;

            public void run() {
                this.zzrH.zzoM.loadUrl(str);
            }
        });
    }

    public void zzu(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrH;

            public void run() {
                this.zzrH.zzoM.loadData(str, "text/html", "UTF-8");
            }
        });
    }
}
