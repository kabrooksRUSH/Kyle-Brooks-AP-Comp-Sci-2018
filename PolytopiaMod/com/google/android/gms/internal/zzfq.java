package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzgr
public class zzfq implements zzfo {
    private final Context mContext;
    final Set<WebView> zzCr = Collections.synchronizedSet(new HashSet());

    public zzfq(Context context) {
        this.mContext = context;
    }

    public void zza(String str, final String str2, final String str3) {
        zzb.zzaF("Fetching assets for the given html");
        zzid.zzIE.post(new Runnable(this) {
            final /* synthetic */ zzfq zzCu;

            public void run() {
                final WebView zzfh = this.zzCu.zzfh();
                zzfh.setWebViewClient(new WebViewClient(this) {
                    final /* synthetic */ C06251 zzCv;

                    public void onPageFinished(WebView view, String url) {
                        zzb.zzaF("Loading assets have finished");
                        this.zzCv.zzCu.zzCr.remove(zzfh);
                    }

                    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                        zzb.zzaH("Loading assets have failed.");
                        this.zzCv.zzCu.zzCr.remove(zzfh);
                    }
                });
                this.zzCu.zzCr.add(zzfh);
                zzfh.loadDataWithBaseURL(str2, str3, "text/html", "UTF-8", null);
                zzb.zzaF("Fetching assets finished.");
            }
        });
    }

    public WebView zzfh() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
