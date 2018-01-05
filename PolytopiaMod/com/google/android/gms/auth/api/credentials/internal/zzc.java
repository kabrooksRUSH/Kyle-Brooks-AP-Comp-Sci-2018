package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;

public final class zzc implements CredentialsApi {

    private static class zza extends zza {
        private zzb<Status> zzSI;

        zza(zzb<Status> com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status) {
            this.zzSI = com_google_android_gms_internal_zzlb_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzg(Status status) {
            this.zzSI.zzp(status);
        }
    }

    public PendingResult<Status> delete(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zzd<Status>(this, client) {
            final /* synthetic */ zzc zzSF;

            protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
                com_google_android_gms_auth_api_credentials_internal_zzh.zza(new zza(this), new DeleteRequest(credential));
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzd(status);
            }

            protected Status zzd(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient client) {
        return client.zzb(new zzd<Status>(this, client) {
            final /* synthetic */ zzc zzSF;

            protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
                com_google_android_gms_auth_api_credentials_internal_zzh.zza(new zza(this));
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzd(status);
            }

            protected Status zzd(Status status) {
                return status;
            }
        });
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient client, final CredentialRequest request) {
        return client.zza(new zzd<CredentialRequestResult>(this, client) {
            final /* synthetic */ zzc zzSF;

            class C01501 extends zza {
                final /* synthetic */ C01511 zzSG;

                C01501(C01511 c01511) {
                    this.zzSG = c01511;
                }

                public void zza(Status status, Credential credential) {
                    this.zzSG.zzb(new zzb(status, credential));
                }

                public void zzg(Status status) {
                    this.zzSG.zzb(zzb.zzh(status));
                }
            }

            protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
                com_google_android_gms_auth_api_credentials_internal_zzh.zza(new C01501(this), request);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzi(status);
            }

            protected CredentialRequestResult zzi(Status status) {
                return zzb.zzh(status);
            }
        });
    }

    public PendingResult<Status> save(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zzd<Status>(this, client) {
            final /* synthetic */ zzc zzSF;

            protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
                com_google_android_gms_auth_api_credentials_internal_zzh.zza(new zza(this), new SaveRequest(credential));
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzd(status);
            }

            protected Status zzd(Status status) {
                return status;
            }
        });
    }
}
