package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzju;

public final class zza {
    public static final zzc<zzjs> zzPT = new zzc();
    private static final com.google.android.gms.common.api.Api.zza<zzjs, NoOptions> zzPU = new C01401();
    public static final Api<NoOptions> zzPV = new Api("AppDataSearch.LIGHTWEIGHT_API", zzPU, zzPT);
    public static final zzk zzPW = new zzju();

    static class C01401 extends com.google.android.gms.common.api.Api.zza<zzjs, NoOptions> {
        C01401() {
        }

        public zzjs zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjs(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }
}
