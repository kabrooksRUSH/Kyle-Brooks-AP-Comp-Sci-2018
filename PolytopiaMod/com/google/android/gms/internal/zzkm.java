package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzkm implements ProxyApi {
    public PendingResult<ProxyResult> performProxyRequest(GoogleApiClient client, final ProxyRequest request) {
        zzx.zzw(client);
        zzx.zzw(request);
        return client.zzb(new zzkl(this, client) {
            final /* synthetic */ zzkm zzSR;

            class C06831 extends zzkh {
                final /* synthetic */ C06841 zzSS;

                C06831(C06841 c06841) {
                    this.zzSS = c06841;
                }

                public void zza(ProxyResponse proxyResponse) {
                    this.zzSS.zzb(new zzkn(proxyResponse));
                }
            }

            protected void zza(Context context, zzkk com_google_android_gms_internal_zzkk) throws RemoteException {
                com_google_android_gms_internal_zzkk.zza(new C06831(this), request);
            }
        });
    }
}
