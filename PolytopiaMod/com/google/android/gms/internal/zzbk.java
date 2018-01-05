package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzbk extends Thread {
    private boolean mStarted = false;
    private boolean zzam = false;
    private final Object zzpd;
    private final int zzrN;
    private final int zzrP;
    private boolean zzrZ = false;
    private final zzbj zzsa;
    private final zzbi zzsb;
    private final zzgq zzsc;
    private final int zzsd;
    private final int zzse;
    private final int zzsf;

    @zzgr
    class zza {
        final /* synthetic */ zzbk zzsh;
        final int zzsm;
        final int zzsn;

        zza(zzbk com_google_android_gms_internal_zzbk, int i, int i2) {
            this.zzsh = com_google_android_gms_internal_zzbk;
            this.zzsm = i;
            this.zzsn = i2;
        }
    }

    public zzbk(zzbj com_google_android_gms_internal_zzbj, zzbi com_google_android_gms_internal_zzbi, zzgq com_google_android_gms_internal_zzgq) {
        this.zzsa = com_google_android_gms_internal_zzbj;
        this.zzsb = com_google_android_gms_internal_zzbi;
        this.zzsc = com_google_android_gms_internal_zzgq;
        this.zzpd = new Object();
        this.zzrN = ((Integer) zzby.zzuU.get()).intValue();
        this.zzse = ((Integer) zzby.zzuV.get()).intValue();
        this.zzrP = ((Integer) zzby.zzuW.get()).intValue();
        this.zzsf = ((Integer) zzby.zzuX.get()).intValue();
        this.zzsd = ((Integer) zzby.zzuY.get()).intValue();
        setName("ContentFetchTask");
    }

    public void run() {
        while (!this.zzam) {
            try {
                if (zzcu()) {
                    Activity activity = this.zzsa.getActivity();
                    if (activity == null) {
                        zzb.zzaF("ContentFetchThread: no activity");
                    } else {
                        zza(activity);
                    }
                } else {
                    zzb.zzaF("ContentFetchTask: sleeping");
                    zzcw();
                }
                Thread.sleep((long) (this.zzsd * CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT));
            } catch (Throwable th) {
                zzb.zzb("Error in ContentFetchTask", th);
                this.zzsc.zza(th, true);
            }
            synchronized (this.zzpd) {
                while (this.zzrZ) {
                    try {
                        zzb.zzaF("ContentFetchTask: waiting");
                        this.zzpd.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzpd) {
            this.zzrZ = false;
            this.zzpd.notifyAll();
            zzb.zzaF("ContentFetchThread: wakeup");
        }
    }

    zza zza(View view, zzbh com_google_android_gms_internal_zzbh) {
        int i = 0;
        if (view == null) {
            return new zza(this, 0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(this, 0, 0);
            }
            com_google_android_gms_internal_zzbh.zzw(text.toString());
            return new zza(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zziz)) {
            com_google_android_gms_internal_zzbh.zzcp();
            return zza((WebView) view, com_google_android_gms_internal_zzbh) ? new zza(this, 0, 1) : new zza(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zza(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                zza zza = zza(viewGroup.getChildAt(i), com_google_android_gms_internal_zzbh);
                i3 += zza.zzsm;
                i2 += zza.zzsn;
                i++;
            }
            return new zza(this, i3, i2);
        }
    }

    void zza(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                zzf(view);
            }
        }
    }

    void zza(zzbh com_google_android_gms_internal_zzbh, WebView webView, String str) {
        com_google_android_gms_internal_zzbh.zzco();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    com_google_android_gms_internal_zzbh.zzv(optString);
                } else {
                    com_google_android_gms_internal_zzbh.zzv(webView.getTitle() + "\n" + optString);
                }
            }
            if (com_google_android_gms_internal_zzbh.zzcl()) {
                this.zzsb.zzb(com_google_android_gms_internal_zzbh);
            }
        } catch (JSONException e) {
            zzb.zzaF("Json string may be malformed.");
        } catch (Throwable th) {
            zzb.zza("Failed to get webview content.", th);
            this.zzsc.zza(th, true);
        }
    }

    boolean zza(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean zza(final WebView webView, final zzbh com_google_android_gms_internal_zzbh) {
        if (!zzmx.zzqB()) {
            return false;
        }
        com_google_android_gms_internal_zzbh.zzcp();
        webView.post(new Runnable(this) {
            final /* synthetic */ zzbk zzsh;
            ValueCallback<String> zzsi = new C05601(this);

            class C05601 implements ValueCallback<String> {
                final /* synthetic */ C05612 zzsl;

                C05601(C05612 c05612) {
                    this.zzsl = c05612;
                }

                public /* synthetic */ void onReceiveValue(Object x0) {
                    zzy((String) x0);
                }

                public void zzy(String str) {
                    this.zzsl.zzsh.zza(com_google_android_gms_internal_zzbh, webView, str);
                }
            }

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzsi);
                    } catch (Throwable th) {
                        this.zzsi.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void zzct() {
        synchronized (this.zzpd) {
            if (this.mStarted) {
                zzb.zzaF("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    boolean zzcu() {
        try {
            Context context = this.zzsa.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (zza(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && zzr(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public zzbh zzcv() {
        return this.zzsb.zzcs();
    }

    public void zzcw() {
        synchronized (this.zzpd) {
            this.zzrZ = true;
            zzb.zzaF("ContentFetchThread: paused, mPause = " + this.zzrZ);
        }
    }

    public boolean zzcx() {
        return this.zzrZ;
    }

    boolean zzf(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable(this) {
            final /* synthetic */ zzbk zzsh;

            public void run() {
                this.zzsh.zzg(view);
            }
        });
        return true;
    }

    void zzg(View view) {
        try {
            zzbh com_google_android_gms_internal_zzbh = new zzbh(this.zzrN, this.zzse, this.zzrP, this.zzsf);
            zza zza = zza(view, com_google_android_gms_internal_zzbh);
            com_google_android_gms_internal_zzbh.zzcq();
            if (zza.zzsm != 0 || zza.zzsn != 0) {
                if (zza.zzsn != 0 || com_google_android_gms_internal_zzbh.zzcr() != 0) {
                    if (zza.zzsn != 0 || !this.zzsb.zza(com_google_android_gms_internal_zzbh)) {
                        this.zzsb.zzc(com_google_android_gms_internal_zzbh);
                    }
                }
            }
        } catch (Throwable e) {
            zzb.zzb("Exception in fetchContentOnUIThread", e);
            this.zzsc.zza(e, true);
        }
    }

    boolean zzr(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }
}
