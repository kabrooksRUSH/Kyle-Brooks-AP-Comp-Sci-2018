package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdz.zzd;
import java.util.Map;
import java.util.concurrent.Future;

@zzgr
public final class zzgv {
    private String zzBY;
    private String zzFO;
    private zzin<zzgx> zzFP = new zzin();
    zzd zzFQ;
    public final zzdk zzFR = new C06431(this);
    public final zzdk zzFS = new C06442(this);
    zziz zzoM;
    private final Object zzpd = new Object();

    class C06431 implements zzdk {
        final /* synthetic */ zzgv zzFT;

        C06431(zzgv com_google_android_gms_internal_zzgv) {
            this.zzFT = com_google_android_gms_internal_zzgv;
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            synchronized (this.zzFT.zzpd) {
                if (this.zzFT.zzFP.isDone()) {
                } else if (this.zzFT.zzBY.equals(map.get("request_id"))) {
                    zzgx com_google_android_gms_internal_zzgx = new zzgx(1, map);
                    zzb.zzaH("Invalid " + com_google_android_gms_internal_zzgx.getType() + " request error: " + com_google_android_gms_internal_zzgx.zzfU());
                    this.zzFT.zzFP.zzf(com_google_android_gms_internal_zzgx);
                }
            }
        }
    }

    class C06442 implements zzdk {
        final /* synthetic */ zzgv zzFT;

        C06442(zzgv com_google_android_gms_internal_zzgv) {
            this.zzFT = com_google_android_gms_internal_zzgv;
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            synchronized (this.zzFT.zzpd) {
                if (this.zzFT.zzFP.isDone()) {
                    return;
                }
                zzgx com_google_android_gms_internal_zzgx = new zzgx(-2, map);
                if (this.zzFT.zzBY.equals(com_google_android_gms_internal_zzgx.getRequestId())) {
                    String url = com_google_android_gms_internal_zzgx.getUrl();
                    if (url == null) {
                        zzb.zzaH("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String replaceAll = url.replaceAll("%40mediation_adapters%40", zzhy.zza(com_google_android_gms_internal_zziz.getContext(), (String) map.get("check_adapters"), this.zzFT.zzFO));
                        com_google_android_gms_internal_zzgx.setUrl(replaceAll);
                        zzb.m12v("Ad request URL modified to " + replaceAll);
                    }
                    this.zzFT.zzFP.zzf(com_google_android_gms_internal_zzgx);
                    return;
                }
                zzb.zzaH(com_google_android_gms_internal_zzgx.getRequestId() + " ==== " + this.zzFT.zzBY);
            }
        }
    }

    public zzgv(String str, String str2) {
        this.zzFO = str2;
        this.zzBY = str;
    }

    public void zzb(zzd com_google_android_gms_internal_zzdz_zzd) {
        this.zzFQ = com_google_android_gms_internal_zzdz_zzd;
    }

    public void zze(zziz com_google_android_gms_internal_zziz) {
        this.zzoM = com_google_android_gms_internal_zziz;
    }

    public zzd zzfR() {
        return this.zzFQ;
    }

    public Future<zzgx> zzfS() {
        return this.zzFP;
    }

    public void zzfT() {
        if (this.zzoM != null) {
            this.zzoM.destroy();
            this.zzoM = null;
        }
    }
}