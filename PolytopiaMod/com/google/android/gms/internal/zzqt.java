package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzqt implements SearchAuthApi {

    static abstract class zza extends com.google.android.gms.internal.zzqq.zza {
        zza() {
        }

        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        public void zzbb(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzb extends com.google.android.gms.internal.zzlb.zza<Status, zzqs> {
        private final GoogleApiClient zzVs;
        private final String zzaUN;
        private final boolean zzaUQ = Log.isLoggable("SearchAuth", 3);

        class C07121 extends zza {
            final /* synthetic */ zzb zzaUR;

            C07121(zzb com_google_android_gms_internal_zzqt_zzb) {
                this.zzaUR = com_google_android_gms_internal_zzqt_zzb;
            }

            public void zzbb(Status status) {
                if (this.zzaUR.zzaUQ) {
                    Log.d("SearchAuth", "ClearTokenImpl success");
                }
                this.zzaUR.zzb((Result) status);
            }
        }

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzRk, googleApiClient);
            this.zzVs = googleApiClient;
            this.zzaUN = str;
        }

        protected void zza(zzqs com_google_android_gms_internal_zzqs) throws RemoteException {
            if (this.zzaUQ) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            String packageName = this.zzVs.getContext().getPackageName();
            ((zzqr) com_google_android_gms_internal_zzqs.zzpc()).zzb(new C07121(this), packageName, this.zzaUN);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            if (this.zzaUQ) {
                Log.d("SearchAuth", "ClearTokenImpl received failure: " + status.getStatusMessage());
            }
            return status;
        }
    }

    static class zzc extends com.google.android.gms.internal.zzlb.zza<GoogleNowAuthResult, zzqs> {
        private final GoogleApiClient zzVs;
        private final boolean zzaUQ = Log.isLoggable("SearchAuth", 3);
        private final String zzaUS;

        class C07131 extends zza {
            final /* synthetic */ zzc zzaUT;

            C07131(zzc com_google_android_gms_internal_zzqt_zzc) {
                this.zzaUT = com_google_android_gms_internal_zzqt_zzc;
            }

            public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                if (this.zzaUT.zzaUQ) {
                    Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                }
                this.zzaUT.zzb(new zzd(status, googleNowAuthState));
            }
        }

        protected zzc(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzRk, googleApiClient);
            this.zzVs = googleApiClient;
            this.zzaUS = str;
        }

        protected void zza(zzqs com_google_android_gms_internal_zzqs) throws RemoteException {
            if (this.zzaUQ) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            String packageName = this.zzVs.getContext().getPackageName();
            ((zzqr) com_google_android_gms_internal_zzqs.zzpc()).zza(new C07131(this), packageName, this.zzaUS);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbc(status);
        }

        protected GoogleNowAuthResult zzbc(Status status) {
            if (this.zzaUQ) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + status.getStatusMessage());
            }
            return new zzd(status, null);
        }
    }

    static class zzd implements GoogleNowAuthResult {
        private final Status zzSC;
        private final GoogleNowAuthState zzaUU;

        zzd(Status status, GoogleNowAuthState googleNowAuthState) {
            this.zzSC = status;
            this.zzaUU = googleNowAuthState;
        }

        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.zzaUU;
        }

        public Status getStatus() {
            return this.zzSC;
        }
    }

    public PendingResult<Status> clearToken(GoogleApiClient client, String accessToken) {
        return client.zza(new zzb(client, accessToken));
    }

    public PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient client, String webAppClientId) {
        return client.zza(new zzc(client, webAppClientId));
    }
}
