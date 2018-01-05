package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdSize;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzgr
public class zzja extends WebViewClient {
    private static final String[] zzJU = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzJV = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private zzfi zzAl;
    private zza zzDn;
    private final HashMap<String, List<zzdk>> zzJW;
    private zzg zzJX;
    private zzb zzJY;
    private boolean zzJZ;
    private boolean zzKa;
    private zzn zzKb;
    private final zzfg zzKc;
    private boolean zzKd;
    private boolean zzKe;
    private boolean zzKf;
    private boolean zzKg;
    private int zzKh;
    protected zziz zzoM;
    private final Object zzpd;
    private boolean zzqW;
    private com.google.android.gms.ads.internal.client.zza zzsy;
    private zzdo zzxO;
    private zze zzxQ;
    private zzfc zzxR;
    private zzdm zzxT;
    private zzdg zzxn;

    public interface zza {
        void zza(zziz com_google_android_gms_internal_zziz, boolean z);
    }

    public interface zzb {
        void zzbf();
    }

    class C06721 implements Runnable {
        final /* synthetic */ zzja zzKi;

        C06721(zzja com_google_android_gms_internal_zzja) {
            this.zzKi = com_google_android_gms_internal_zzja;
        }

        public void run() {
            this.zzKi.zzoM.zzho();
            com.google.android.gms.ads.internal.overlay.zzd zzhc = this.zzKi.zzoM.zzhc();
            if (zzhc != null) {
                zzhc.zzeG();
            }
            if (this.zzKi.zzJY != null) {
                this.zzKi.zzJY.zzbf();
                this.zzKi.zzJY = null;
            }
        }
    }

    private static class zzc implements zzg {
        private zzg zzJX;
        private zziz zzKj;

        public zzc(zziz com_google_android_gms_internal_zziz, zzg com_google_android_gms_ads_internal_overlay_zzg) {
            this.zzKj = com_google_android_gms_internal_zziz;
            this.zzJX = com_google_android_gms_ads_internal_overlay_zzg;
        }

        public void zzaV() {
            this.zzJX.zzaV();
            this.zzKj.zzgY();
        }

        public void zzaW() {
            this.zzJX.zzaW();
            this.zzKj.zzeJ();
        }
    }

    private class zzd implements zzdk {
        final /* synthetic */ zzja zzKi;

        private zzd(zzja com_google_android_gms_internal_zzja) {
            this.zzKi = com_google_android_gms_internal_zzja;
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                this.zzKi.zzht();
            } else if (map.keySet().contains("stop")) {
                this.zzKi.zzhu();
            } else if (map.keySet().contains("cancel")) {
                this.zzKi.zzhv();
            }
        }
    }

    public zzja(zziz com_google_android_gms_internal_zziz, boolean z) {
        this(com_google_android_gms_internal_zziz, z, new zzfg(com_google_android_gms_internal_zziz, com_google_android_gms_internal_zziz.zzha(), new zzbq(com_google_android_gms_internal_zziz.getContext())), null);
    }

    zzja(zziz com_google_android_gms_internal_zziz, boolean z, zzfg com_google_android_gms_internal_zzfg, zzfc com_google_android_gms_internal_zzfc) {
        this.zzJW = new HashMap();
        this.zzpd = new Object();
        this.zzJZ = false;
        this.zzoM = com_google_android_gms_internal_zziz;
        this.zzqW = z;
        this.zzKc = com_google_android_gms_internal_zzfg;
        this.zzxR = com_google_android_gms_internal_zzfc;
    }

    private void zza(Context context, String str, String str2, String str3) {
        if (((Boolean) zzby.zzvp.get()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", zzaK(str3));
            zzp.zzbv().zza(context, this.zzoM.zzhh().zzJu, "gmob-apps", bundle, true);
        }
    }

    private String zzaK(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    private static boolean zzg(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void zzht() {
        synchronized (this.zzpd) {
            this.zzKa = true;
        }
        this.zzKh++;
        zzhw();
    }

    private void zzhu() {
        this.zzKh--;
        zzhw();
    }

    private void zzhv() {
        this.zzKg = true;
        zzhw();
    }

    public final void onLoadResource(WebView webView, String url) {
        com.google.android.gms.ads.internal.util.client.zzb.m12v("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r3, java.lang.String r4) {
        /*
        r2 = this;
        r1 = r2.zzpd;
        monitor-enter(r1);
        r0 = r2.zzKe;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x001b;
    L_0x0007:
        r0 = "about:blank";
        r0 = r0.equals(r4);	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x001b;
    L_0x000f:
        r0 = "Blank page loaded, 1...";
        com.google.android.gms.ads.internal.util.client.zzb.m12v(r0);	 Catch:{ all -> 0x0023 }
        r0 = r2.zzoM;	 Catch:{ all -> 0x0023 }
        r0.zzhj();	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x001a:
        return;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0 = 1;
        r2.zzKf = r0;
        r2.zzhw();
        goto L_0x001a;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzja.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        String valueOf = (errorCode >= 0 || (-errorCode) - 1 >= zzJU.length) ? String.valueOf(errorCode) : zzJU[(-errorCode) - 1];
        zza(this.zzoM.getContext(), "http_err", valueOf, failingUrl);
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    public final void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        if (error != null) {
            int primaryError = error.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= zzJV.length) ? String.valueOf(primaryError) : zzJV[primaryError];
            zza(this.zzoM.getContext(), "ssl_err", valueOf, zzp.zzbx().zza(error));
        }
        super.onReceivedSslError(view, handler, error);
    }

    public final void reset() {
        synchronized (this.zzpd) {
            this.zzJW.clear();
            this.zzsy = null;
            this.zzJX = null;
            this.zzDn = null;
            this.zzxn = null;
            this.zzJZ = false;
            this.zzqW = false;
            this.zzKa = false;
            this.zzxT = null;
            this.zzKb = null;
            this.zzJY = null;
            if (this.zzxR != null) {
                this.zzxR.zzn(true);
                this.zzxR = null;
            }
            this.zzKd = false;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        switch (event.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case AdSize.LARGE_AD_HEIGHT /*90*/:
            case 91:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        com.google.android.gms.ads.internal.util.client.zzb.m12v("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        } else if (this.zzJZ && webView == this.zzoM.getWebView() && zzg(parse)) {
            if (!this.zzKd) {
                this.zzKd = true;
                if (this.zzsy != null && ((Boolean) zzby.zzvd.get()).booleanValue()) {
                    this.zzsy.onAdClicked();
                }
            }
            return super.shouldOverrideUrlLoading(webView, url);
        } else if (this.zzoM.getWebView().willNotDraw()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("AdWebView unable to handle URL: " + url);
        } else {
            Uri uri;
            try {
                zzan zzhg = this.zzoM.zzhg();
                if (zzhg != null && zzhg.zzb(parse)) {
                    parse = zzhg.zza(parse, this.zzoM.getContext());
                }
                uri = parse;
            } catch (zzao e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to append parameter to URL: " + url);
                uri = parse;
            }
            if (this.zzxQ == null || this.zzxQ.zzbe()) {
                zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.zzxQ.zzp(url);
            }
        }
        return true;
    }

    public void zzF(boolean z) {
        this.zzJZ = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzKc.zze(i, i2);
        if (this.zzxR != null) {
            this.zzxR.zza(i, i2, z);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        zzg com_google_android_gms_ads_internal_overlay_zzg = null;
        boolean zzhi = this.zzoM.zzhi();
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!zzhi || this.zzoM.zzaN().zztf) ? this.zzsy : null;
        if (!zzhi) {
            com_google_android_gms_ads_internal_overlay_zzg = this.zzJX;
        }
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzg, this.zzKb, this.zzoM.zzhh()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zzef = this.zzxR != null ? this.zzxR.zzef() : false;
        com.google.android.gms.ads.internal.overlay.zze zzbt = zzp.zzbt();
        Context context = this.zzoM.getContext();
        if (!zzef) {
            z = true;
        }
        zzbt.zza(context, adOverlayInfoParcel, z);
    }

    public void zza(zza com_google_android_gms_internal_zzja_zza) {
        this.zzDn = com_google_android_gms_internal_zzja_zza;
    }

    public void zza(zzb com_google_android_gms_internal_zzja_zzb) {
        this.zzJY = com_google_android_gms_internal_zzja_zzb;
    }

    public final void zza(String str, zzdk com_google_android_gms_internal_zzdk) {
        synchronized (this.zzpd) {
            List list = (List) this.zzJW.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzJW.put(str, list);
            }
            list.add(com_google_android_gms_internal_zzdk);
        }
    }

    public final void zza(boolean z, int i) {
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!this.zzoM.zzhi() || this.zzoM.zzaN().zztf) ? this.zzsy : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_client_zza, this.zzJX, this.zzKb, this.zzoM, z, i, this.zzoM.zzhh()));
    }

    public final void zza(boolean z, int i, String str) {
        zzg com_google_android_gms_ads_internal_overlay_zzg = null;
        boolean zzhi = this.zzoM.zzhi();
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!zzhi || this.zzoM.zzaN().zztf) ? this.zzsy : null;
        if (!zzhi) {
            com_google_android_gms_ads_internal_overlay_zzg = new zzc(this.zzoM, this.zzJX);
        }
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzg, this.zzxn, this.zzKb, this.zzoM, z, i, str, this.zzoM.zzhh(), this.zzxT));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzhi = this.zzoM.zzhi();
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!zzhi || this.zzoM.zzaN().zztf) ? this.zzsy : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_client_zza, zzhi ? null : new zzc(this.zzoM, this.zzJX), this.zzxn, this.zzKb, this.zzoM, z, i, str, str2, this.zzoM.zzhh(), this.zzxT));
    }

    public void zzb(com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzdg com_google_android_gms_internal_zzdg, zzn com_google_android_gms_ads_internal_overlay_zzn, boolean z, zzdm com_google_android_gms_internal_zzdm, zzdo com_google_android_gms_internal_zzdo, zze com_google_android_gms_ads_internal_zze, zzfi com_google_android_gms_internal_zzfi) {
        if (com_google_android_gms_ads_internal_zze == null) {
            com_google_android_gms_ads_internal_zze = new zze(false);
        }
        this.zzxR = new zzfc(this.zzoM, com_google_android_gms_internal_zzfi);
        zza("/appEvent", new zzdf(com_google_android_gms_internal_zzdg));
        zza("/backButton", zzdj.zzxx);
        zza("/canOpenURLs", zzdj.zzxp);
        zza("/canOpenIntents", zzdj.zzxq);
        zza("/click", zzdj.zzxr);
        zza("/close", zzdj.zzxs);
        zza("/customClose", zzdj.zzxt);
        zza("/instrument", zzdj.zzxA);
        zza("/delayPageLoaded", new zzd());
        zza("/httpTrack", zzdj.zzxu);
        zza("/log", zzdj.zzxv);
        zza("/mraid", new zzdq(com_google_android_gms_ads_internal_zze, this.zzxR));
        zza("/mraidLoaded", this.zzKc);
        zza("/open", new zzdr(com_google_android_gms_internal_zzdm, com_google_android_gms_ads_internal_zze, this.zzxR));
        zza("/precache", zzdj.zzxz);
        zza("/touch", zzdj.zzxw);
        zza("/video", zzdj.zzxy);
        if (com_google_android_gms_internal_zzdo != null) {
            zza("/setInterstitialProperties", new zzdn(com_google_android_gms_internal_zzdo));
        }
        this.zzsy = com_google_android_gms_ads_internal_client_zza;
        this.zzJX = com_google_android_gms_ads_internal_overlay_zzg;
        this.zzxn = com_google_android_gms_internal_zzdg;
        this.zzxT = com_google_android_gms_internal_zzdm;
        this.zzKb = com_google_android_gms_ads_internal_overlay_zzn;
        this.zzxQ = com_google_android_gms_ads_internal_zze;
        this.zzAl = com_google_android_gms_internal_zzfi;
        this.zzxO = com_google_android_gms_internal_zzdo;
        zzF(z);
        this.zzKd = false;
    }

    public final void zzb(String str, zzdk com_google_android_gms_internal_zzdk) {
        synchronized (this.zzpd) {
            List list = (List) this.zzJW.get(str);
            if (list == null) {
                return;
            }
            list.remove(com_google_android_gms_internal_zzdk);
        }
    }

    public boolean zzbY() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzqW;
        }
        return z;
    }

    public void zzd(int i, int i2) {
        if (this.zzxR != null) {
            this.zzxR.zzd(i, i2);
        }
    }

    public void zze(zziz com_google_android_gms_internal_zziz) {
        this.zzoM = com_google_android_gms_internal_zziz;
    }

    public final void zzeG() {
        synchronized (this.zzpd) {
            this.zzJZ = false;
            this.zzqW = true;
            zzid.runOnUiThread(new C06721(this));
        }
    }

    public void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzdk> list = (List) this.zzJW.get(path);
        if (list != null) {
            Map zze = zzp.zzbv().zze(uri);
            if (com.google.android.gms.ads.internal.util.client.zzb.zzN(2)) {
                com.google.android.gms.ads.internal.util.client.zzb.m12v("Received GMSG: " + path);
                for (String path2 : zze.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.m12v("  " + path2 + ": " + ((String) zze.get(path2)));
                }
            }
            for (zzdk zza : list) {
                zza.zza(this.zzoM, zze);
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.m12v("No GMSG handler found for GMSG: " + uri);
    }

    public zze zzhq() {
        return this.zzxQ;
    }

    public boolean zzhr() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzKa;
        }
        return z;
    }

    public void zzhs() {
        synchronized (this.zzpd) {
            com.google.android.gms.ads.internal.util.client.zzb.m12v("Loading blank page in WebView, 2...");
            this.zzKe = true;
            this.zzoM.zzaI("about:blank");
        }
    }

    public final void zzhw() {
        if (this.zzDn != null && ((this.zzKf && this.zzKh <= 0) || this.zzKg)) {
            this.zzDn.zza(this.zzoM, !this.zzKg);
            this.zzDn = null;
        }
        this.zzoM.zzhp();
    }
}
