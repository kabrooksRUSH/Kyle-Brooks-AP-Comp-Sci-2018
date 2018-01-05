package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
class zzjd extends WebView implements OnGlobalLayoutListener, DownloadListener, zziz {
    private int zzAD = -1;
    private int zzAE = -1;
    private int zzAG = -1;
    private int zzAH = -1;
    private String zzBY = "";
    private Boolean zzHZ;
    private Map<String, zzdv> zzKA;
    private final zza zzKm;
    private zzja zzKn;
    private zzd zzKo;
    private boolean zzKp;
    private boolean zzKq;
    private boolean zzKr;
    private boolean zzKs;
    private int zzKt;
    private boolean zzKu = true;
    private zzce zzKv;
    private zzce zzKw;
    private zzce zzKx;
    private zzcf zzKy;
    private zzd zzKz;
    private final com.google.android.gms.ads.internal.zzd zzow;
    private final VersionInfoParcel zzpb;
    private final Object zzpd = new Object();
    private zzim zzqR;
    private final WindowManager zzri;
    private final zzan zzwL;
    private AdSizeParcel zzzm;

    class C06731 implements Runnable {
        final /* synthetic */ zzjd zzKB;

        C06731(zzjd com_google_android_gms_internal_zzjd) {
            this.zzKB = com_google_android_gms_internal_zzjd;
        }

        public void run() {
            super.destroy();
        }
    }

    @zzgr
    public static class zza extends MutableContextWrapper {
        private Activity zzJn;
        private Context zzKC;
        private Context zzqZ;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Object getSystemService(String service) {
            return this.zzKC.getSystemService(service);
        }

        public void setBaseContext(Context base) {
            this.zzqZ = base.getApplicationContext();
            this.zzJn = base instanceof Activity ? (Activity) base : null;
            this.zzKC = base;
            super.setBaseContext(this.zzqZ);
        }

        public void startActivity(Intent intent) {
            if (this.zzJn == null || zzmx.isAtLeastL()) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                this.zzqZ.startActivity(intent);
                return;
            }
            this.zzJn.startActivity(intent);
        }

        public Activity zzgZ() {
            return this.zzJn;
        }

        public Context zzha() {
            return this.zzKC;
        }
    }

    protected zzjd(zza com_google_android_gms_internal_zzjd_zza, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan com_google_android_gms_internal_zzan, VersionInfoParcel versionInfoParcel, zzcg com_google_android_gms_internal_zzcg, com.google.android.gms.ads.internal.zzd com_google_android_gms_ads_internal_zzd) {
        super(com_google_android_gms_internal_zzjd_zza);
        this.zzKm = com_google_android_gms_internal_zzjd_zza;
        this.zzzm = adSizeParcel;
        this.zzKr = z;
        this.zzKt = -1;
        this.zzwL = com_google_android_gms_internal_zzan;
        this.zzpb = versionInfoParcel;
        this.zzow = com_google_android_gms_ads_internal_zzd;
        this.zzri = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        zzp.zzbv().zza((Context) com_google_android_gms_internal_zzjd_zza, versionInfoParcel.zzJu, settings);
        zzp.zzbx().zza(getContext(), settings);
        setDownloadListener(this);
        zzhz();
        if (zzmx.zzqz()) {
            addJavascriptInterface(new zzje(this), "googleAdsJsInterface");
        }
        this.zzqR = new zzim(this.zzKm.zzgZ(), this, null);
        zzd(com_google_android_gms_internal_zzcg);
    }

    static zzjd zzb(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan com_google_android_gms_internal_zzan, VersionInfoParcel versionInfoParcel, zzcg com_google_android_gms_internal_zzcg, com.google.android.gms.ads.internal.zzd com_google_android_gms_ads_internal_zzd) {
        return new zzjd(new zza(context), adSizeParcel, z, z2, com_google_android_gms_internal_zzan, versionInfoParcel, com_google_android_gms_internal_zzcg, com_google_android_gms_ads_internal_zzd);
    }

    private void zzd(zzcg com_google_android_gms_internal_zzcg) {
        zzhD();
        this.zzKy = new zzcf(new zzcg(true, "make_wv", this.zzzm.zzte));
        this.zzKy.zzdm().zzc(com_google_android_gms_internal_zzcg);
        this.zzKw = zzcc.zzb(this.zzKy.zzdm());
        this.zzKy.zza("native:view_create", this.zzKw);
        this.zzKx = null;
        this.zzKv = null;
    }

    private void zzhA() {
        synchronized (this.zzpd) {
            if (!this.zzKs) {
                zzp.zzbx().zzm(this);
            }
            this.zzKs = true;
        }
    }

    private void zzhB() {
        synchronized (this.zzpd) {
            if (this.zzKs) {
                zzp.zzbx().zzl(this);
            }
            this.zzKs = false;
        }
    }

    private void zzhC() {
        synchronized (this.zzpd) {
            if (this.zzKA != null) {
                for (zzdv release : this.zzKA.values()) {
                    release.release();
                }
            }
        }
    }

    private void zzhD() {
        if (this.zzKy != null) {
            zzcg zzdm = this.zzKy.zzdm();
            if (zzdm != null && zzp.zzby().zzgo() != null) {
                zzp.zzby().zzgo().zza(zzdm);
            }
        }
    }

    private void zzhy() {
        synchronized (this.zzpd) {
            this.zzHZ = zzp.zzby().zzgs();
            if (this.zzHZ == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    zzb(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    zzb(Boolean.valueOf(false));
                }
            }
        }
    }

    private void zzhz() {
        synchronized (this.zzpd) {
            if (this.zzKr || this.zzzm.zztf) {
                if (VERSION.SDK_INT < 14) {
                    zzb.zzaF("Disabling hardware acceleration on an overlay.");
                    zzhA();
                } else {
                    zzb.zzaF("Enabling hardware acceleration on an overlay.");
                    zzhB();
                }
            } else if (VERSION.SDK_INT < 18) {
                zzb.zzaF("Disabling hardware acceleration on an AdView.");
                zzhA();
            } else {
                zzb.zzaF("Enabling hardware acceleration on an AdView.");
                zzhB();
            }
        }
    }

    public void destroy() {
        synchronized (this.zzpd) {
            zzhD();
            this.zzqR.zzgP();
            if (this.zzKo != null) {
                this.zzKo.close();
                this.zzKo.onDestroy();
                this.zzKo = null;
            }
            this.zzKn.reset();
            if (this.zzKq) {
                return;
            }
            zzp.zzbI().zza((zziz) this);
            zzhC();
            this.zzKq = true;
            zzb.m12v("Initiating WebView self destruct sequence in 3...");
            this.zzKn.zzhs();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
        r2 = this;
        r1 = r2.zzpd;
        monitor-enter(r1);
        r0 = r2.isDestroyed();	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0016;
    L_0x0009:
        r0 = "The webview is destroyed. Ignoring action.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r0);	 Catch:{ all -> 0x001b }
        if (r4 == 0) goto L_0x0014;
    L_0x0010:
        r0 = 0;
        r4.onReceiveValue(r0);	 Catch:{ all -> 0x001b }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0015:
        return;
    L_0x0016:
        super.evaluateJavascript(r3, r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0015;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjd.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public String getRequestId() {
        String str;
        synchronized (this.zzpd) {
            str = this.zzBY;
        }
        return str;
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.zzpd) {
            i = this.zzKt;
        }
        return i;
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzKq;
        }
        return z;
    }

    public void loadData(String data, String mimeType, String encoding) {
        synchronized (this.zzpd) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(data, mimeType, encoding);
            }
        }
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        synchronized (this.zzpd) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
            }
        }
    }

    public void loadUrl(String uri) {
        synchronized (this.zzpd) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(uri);
                } catch (Throwable th) {
                    zzb.zzaH("Could not call loadUrl. " + th);
                }
            }
        }
    }

    protected void onAttachedToWindow() {
        synchronized (this.zzpd) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzqR.onAttachedToWindow();
            }
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.zzpd) {
            if (!isDestroyed()) {
                this.zzqR.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            zzp.zzbv().zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzb.zzaF("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public void onGlobalLayout() {
        boolean zzhx = zzhx();
        zzd zzhc = zzhc();
        if (zzhc != null && zzhx) {
            zzhc.zzeI();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.zzpd;
        monitor-enter(r4);
        r1 = r9.isDestroyed();	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0019;
    L_0x0012:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0034 }
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
    L_0x0018:
        return;
    L_0x0019:
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x002f;
    L_0x001f:
        r1 = r9.zzKr;	 Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x002f;
    L_0x0023:
        r1 = r9.zzzm;	 Catch:{ all -> 0x0034 }
        r1 = r1.zzth;	 Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x002f;
    L_0x0029:
        r1 = r9.zzzm;	 Catch:{ all -> 0x0034 }
        r1 = r1.zzti;	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0037;
    L_0x002f:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x0034 }
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        goto L_0x0018;
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        throw r0;
    L_0x0037:
        r1 = r9.zzzm;	 Catch:{ all -> 0x0034 }
        r1 = r1.zztf;	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0054;
    L_0x003d:
        r0 = new android.util.DisplayMetrics;	 Catch:{ all -> 0x0034 }
        r0.<init>();	 Catch:{ all -> 0x0034 }
        r1 = r9.zzri;	 Catch:{ all -> 0x0034 }
        r1 = r1.getDefaultDisplay();	 Catch:{ all -> 0x0034 }
        r1.getMetrics(r0);	 Catch:{ all -> 0x0034 }
        r1 = r0.widthPixels;	 Catch:{ all -> 0x0034 }
        r0 = r0.heightPixels;	 Catch:{ all -> 0x0034 }
        r9.setMeasuredDimension(r1, r0);	 Catch:{ all -> 0x0034 }
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        goto L_0x0018;
    L_0x0054:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x0034 }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x0034 }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x0034 }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x0034 }
        if (r2 == r6) goto L_0x0068;
    L_0x0066:
        if (r2 != r8) goto L_0x00fd;
    L_0x0068:
        r2 = r3;
    L_0x0069:
        if (r5 == r6) goto L_0x006d;
    L_0x006b:
        if (r5 != r8) goto L_0x006e;
    L_0x006d:
        r0 = r1;
    L_0x006e:
        r5 = r9.zzzm;	 Catch:{ all -> 0x0034 }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x0034 }
        if (r5 > r2) goto L_0x007a;
    L_0x0074:
        r2 = r9.zzzm;	 Catch:{ all -> 0x0034 }
        r2 = r2.heightPixels;	 Catch:{ all -> 0x0034 }
        if (r2 <= r0) goto L_0x00e7;
    L_0x007a:
        r0 = r9.zzKm;	 Catch:{ all -> 0x0034 }
        r0 = r0.getResources();	 Catch:{ all -> 0x0034 }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x0034 }
        r0 = r0.density;	 Catch:{ all -> 0x0034 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0034 }
        r2.<init>();	 Catch:{ all -> 0x0034 }
        r5 = "Not enough space to show ad. Needs ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r5 = r9.zzzm;	 Catch:{ all -> 0x0034 }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x0034 }
        r5 = (float) r5;	 Catch:{ all -> 0x0034 }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x0034 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r5 = "x";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r5 = r9.zzzm;	 Catch:{ all -> 0x0034 }
        r5 = r5.heightPixels;	 Catch:{ all -> 0x0034 }
        r5 = (float) r5;	 Catch:{ all -> 0x0034 }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x0034 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r5 = " dp, but only has ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r3 = (float) r3;	 Catch:{ all -> 0x0034 }
        r3 = r3 / r0;
        r3 = (int) r3;	 Catch:{ all -> 0x0034 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0034 }
        r3 = "x";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0034 }
        r1 = (float) r1;	 Catch:{ all -> 0x0034 }
        r0 = r1 / r0;
        r0 = (int) r0;	 Catch:{ all -> 0x0034 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0034 }
        r1 = " dp.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0034 }
        r0 = r0.toString();	 Catch:{ all -> 0x0034 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r0);	 Catch:{ all -> 0x0034 }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0034 }
        if (r0 == r7) goto L_0x00df;
    L_0x00db:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0034 }
    L_0x00df:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0034 }
    L_0x00e4:
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        goto L_0x0018;
    L_0x00e7:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0034 }
        if (r0 == r7) goto L_0x00f1;
    L_0x00ed:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0034 }
    L_0x00f1:
        r0 = r9.zzzm;	 Catch:{ all -> 0x0034 }
        r0 = r0.widthPixels;	 Catch:{ all -> 0x0034 }
        r1 = r9.zzzm;	 Catch:{ all -> 0x0034 }
        r1 = r1.heightPixels;	 Catch:{ all -> 0x0034 }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0034 }
        goto L_0x00e4;
    L_0x00fd:
        r2 = r0;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjd.onMeasure(int, int):void");
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                if (zzmx.zzqu()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                zzb.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                if (zzmx.zzqu()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                zzb.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.zzwL != null) {
            this.zzwL.zza(event);
        }
        return isDestroyed() ? false : super.onTouchEvent(event);
    }

    public void setContext(Context context) {
        this.zzKm.setBaseContext(context);
        this.zzqR.zzk(this.zzKm.zzgZ());
    }

    public void setRequestedOrientation(int requestedOrientation) {
        synchronized (this.zzpd) {
            this.zzKt = requestedOrientation;
            if (this.zzKo != null) {
                this.zzKo.setRequestedOrientation(this.zzKt);
            }
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzja) {
            this.zzKn = (zzja) webViewClient;
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                zzb.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zzC(boolean z) {
        synchronized (this.zzpd) {
            this.zzKr = z;
            zzhz();
        }
    }

    public void zzD(boolean z) {
        synchronized (this.zzpd) {
            if (this.zzKo != null) {
                this.zzKo.zza(this.zzKn.zzbY(), z);
            } else {
                this.zzKp = z;
            }
        }
    }

    public void zzE(boolean z) {
        synchronized (this.zzpd) {
            this.zzKu = z;
        }
    }

    public void zza(Context context, AdSizeParcel adSizeParcel, zzcg com_google_android_gms_internal_zzcg) {
        synchronized (this.zzpd) {
            this.zzqR.zzgP();
            setContext(context);
            this.zzKo = null;
            this.zzzm = adSizeParcel;
            this.zzKr = false;
            this.zzKp = false;
            this.zzBY = "";
            this.zzKt = -1;
            zzp.zzbx().zzb(this);
            loadUrl("about:blank");
            this.zzKn.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.zzKu = true;
            zzd(com_google_android_gms_internal_zzcg);
        }
    }

    public void zza(AdSizeParcel adSizeParcel) {
        synchronized (this.zzpd) {
            this.zzzm = adSizeParcel;
            requestLayout();
        }
    }

    public void zza(zzaz com_google_android_gms_internal_zzaz, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zzb("onAdVisibilityChanged", hashMap);
    }

    protected void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzpd) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void zza(String str, String str2) {
        zzaM(str + "(" + str2 + ");");
    }

    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zza(str, jSONObject.toString());
    }

    public void zzaI(String str) {
        synchronized (this.zzpd) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                zzb.zzaH("Could not call loadUrl. " + th);
            }
        }
    }

    public void zzaJ(String str) {
        synchronized (this.zzpd) {
            if (str == null) {
                str = "";
            }
            this.zzBY = str;
        }
    }

    protected void zzaL(String str) {
        synchronized (this.zzpd) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    protected void zzaM(String str) {
        if (zzmx.zzqB()) {
            if (zzgs() == null) {
                zzhy();
            }
            if (zzgs().booleanValue()) {
                zza(str, null);
                return;
            } else {
                zzaL("javascript:" + str);
                return;
            }
        }
        zzaL("javascript:" + str);
    }

    public AdSizeParcel zzaN() {
        AdSizeParcel adSizeParcel;
        synchronized (this.zzpd) {
            adSizeParcel = this.zzzm;
        }
        return adSizeParcel;
    }

    public void zzb(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        synchronized (this.zzpd) {
            this.zzKo = com_google_android_gms_ads_internal_overlay_zzd;
        }
    }

    void zzb(Boolean bool) {
        this.zzHZ = bool;
        zzp.zzby().zzb(bool);
    }

    public void zzb(String str, Map<String, ?> map) {
        try {
            zzb(str, zzp.zzbv().zzz(map));
        } catch (JSONException e) {
            zzb.zzaH("Could not convert parameters to JSON.");
        }
    }

    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        zzb.m12v("Dispatching AFMA event: " + stringBuilder.toString());
        zzaM(stringBuilder.toString());
    }

    public void zzc(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        synchronized (this.zzpd) {
            this.zzKz = com_google_android_gms_ads_internal_overlay_zzd;
        }
    }

    public void zzeJ() {
        if (this.zzKv != null) {
            zzcc.zza(this.zzKy.zzdm(), this.zzKx, "aes");
            this.zzKv = zzcc.zzb(this.zzKy.zzdm());
            this.zzKy.zza("native:view_show", this.zzKx);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.zzpb.zzJu);
        zzb("onshow", hashMap);
    }

    public void zzgY() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.zzpb.zzJu);
        zzb("onhide", hashMap);
    }

    public Activity zzgZ() {
        return this.zzKm.zzgZ();
    }

    Boolean zzgs() {
        Boolean bool;
        synchronized (this.zzpd) {
            bool = this.zzHZ;
        }
        return bool;
    }

    public Context zzha() {
        return this.zzKm.zzha();
    }

    public com.google.android.gms.ads.internal.zzd zzhb() {
        return this.zzow;
    }

    public zzd zzhc() {
        zzd com_google_android_gms_ads_internal_overlay_zzd;
        synchronized (this.zzpd) {
            com_google_android_gms_ads_internal_overlay_zzd = this.zzKo;
        }
        return com_google_android_gms_ads_internal_overlay_zzd;
    }

    public zzd zzhd() {
        zzd com_google_android_gms_ads_internal_overlay_zzd;
        synchronized (this.zzpd) {
            com_google_android_gms_ads_internal_overlay_zzd = this.zzKz;
        }
        return com_google_android_gms_ads_internal_overlay_zzd;
    }

    public zzja zzhe() {
        return this.zzKn;
    }

    public boolean zzhf() {
        return this.zzKp;
    }

    public zzan zzhg() {
        return this.zzwL;
    }

    public VersionInfoParcel zzhh() {
        return this.zzpb;
    }

    public boolean zzhi() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzKr;
        }
        return z;
    }

    public void zzhj() {
        synchronized (this.zzpd) {
            zzb.m12v("Destroying WebView!");
            zzid.zzIE.post(new C06731(this));
        }
    }

    public boolean zzhk() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzKu;
        }
        return z;
    }

    public zziy zzhl() {
        return null;
    }

    public zzce zzhm() {
        return this.zzKx;
    }

    public zzcf zzhn() {
        return this.zzKy;
    }

    public void zzho() {
        this.zzqR.zzgO();
    }

    public void zzhp() {
        if (this.zzKx == null && !"about:blank".equals(getUrl())) {
            this.zzKx = zzcc.zzb(this.zzKy.zzdm());
            this.zzKy.zza("native:view_load", this.zzKx);
        }
    }

    public boolean zzhx() {
        if (!zzhe().zzbY()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics zza = zzp.zzbv().zza(this.zzri);
        int zzb = zzl.zzcF().zzb(zza, zza.widthPixels);
        int zzb2 = zzl.zzcF().zzb(zza, zza.heightPixels);
        Activity zzgZ = zzgZ();
        if (zzgZ == null || zzgZ.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            int[] zzg = zzp.zzbv().zzg(zzgZ);
            i2 = zzl.zzcF().zzb(zza, zzg[0]);
            i = zzl.zzcF().zzb(zza, zzg[1]);
        }
        if (this.zzAD == zzb && this.zzAE == zzb2 && this.zzAG == i2 && this.zzAH == i) {
            return false;
        }
        boolean z = (this.zzAD == zzb && this.zzAE == zzb2) ? false : true;
        this.zzAD = zzb;
        this.zzAE = zzb2;
        this.zzAG = i2;
        this.zzAH = i;
        new zzfh(this).zza(zzb, zzb2, i2, i, zza.density, this.zzri.getDefaultDisplay().getRotation());
        return z;
    }

    public void zzv(int i) {
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzpb.zzJu);
        zzb("onhide", hashMap);
    }
}
