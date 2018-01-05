package com.google.android.gms.internal;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzgr
public class zzih {
    private static zzl zzIZ;
    public static final zza<Void> zzJa = new C06651();
    private static final Object zzpy = new Object();

    public interface zza<T> {
        T zzfF();

        T zzh(InputStream inputStream);
    }

    static class C06651 implements zza {
        C06651() {
        }

        public /* synthetic */ Object zzfF() {
            return zzgL();
        }

        public Void zzgL() {
            return null;
        }

        public /* synthetic */ Object zzh(InputStream inputStream) {
            return zzi(inputStream);
        }

        public Void zzi(InputStream inputStream) {
            return null;
        }
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzJe;
        private final com.google.android.gms.internal.zzm.zzb<T> zzaG;

        class C06681 implements com.google.android.gms.internal.zzm.zza {
            final /* synthetic */ com.google.android.gms.internal.zzm.zzb zzJf;
            final /* synthetic */ zza zzJg;

            C06681(com.google.android.gms.internal.zzm.zzb com_google_android_gms_internal_zzm_zzb, zza com_google_android_gms_internal_zzih_zza) {
                this.zzJf = com_google_android_gms_internal_zzm_zzb;
                this.zzJg = com_google_android_gms_internal_zzih_zza;
            }

            public void zze(zzr com_google_android_gms_internal_zzr) {
                this.zzJf.zzb(this.zzJg.zzfF());
            }
        }

        public zzb(String str, zza<T> com_google_android_gms_internal_zzih_zza_T, com.google.android.gms.internal.zzm.zzb<T> com_google_android_gms_internal_zzm_zzb_T) {
            super(0, str, new C06681(com_google_android_gms_internal_zzm_zzb_T, com_google_android_gms_internal_zzih_zza_T));
            this.zzJe = com_google_android_gms_internal_zzih_zza_T;
            this.zzaG = com_google_android_gms_internal_zzm_zzb_T;
        }

        protected zzm<InputStream> zza(zzi com_google_android_gms_internal_zzi) {
            return zzm.zza(new ByteArrayInputStream(com_google_android_gms_internal_zzi.data), zzx.zzb(com_google_android_gms_internal_zzi));
        }

        protected /* synthetic */ void zza(Object obj) {
            zzj((InputStream) obj);
        }

        protected void zzj(InputStream inputStream) {
            this.zzaG.zzb(this.zzJe.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzin<T> implements com.google.android.gms.internal.zzm.zzb<T> {
        final /* synthetic */ zzih zzJc;

        private zzc(zzih com_google_android_gms_internal_zzih) {
            this.zzJc = com_google_android_gms_internal_zzih;
        }

        public void zzb(T t) {
            super.zzf(t);
        }
    }

    public zzih(Context context) {
        zzIZ = zzP(context);
    }

    private static zzl zzP(Context context) {
        zzl com_google_android_gms_internal_zzl;
        synchronized (zzpy) {
            if (zzIZ == null) {
                zzIZ = zzac.zza(context.getApplicationContext());
            }
            com_google_android_gms_internal_zzl = zzIZ;
        }
        return com_google_android_gms_internal_zzl;
    }

    public <T> zziq<T> zza(String str, zza<T> com_google_android_gms_internal_zzih_zza_T) {
        Object com_google_android_gms_internal_zzih_zzc = new zzc();
        zzIZ.zze(new zzb(str, com_google_android_gms_internal_zzih_zza_T, com_google_android_gms_internal_zzih_zzc));
        return com_google_android_gms_internal_zzih_zzc;
    }

    public zziq<String> zza(final String str, Map<String, String> map) {
        final Object com_google_android_gms_internal_zzih_zzc = new zzc();
        final Map<String, String> map2 = map;
        zzIZ.zze(new zzab(this, str, com_google_android_gms_internal_zzih_zzc, new com.google.android.gms.internal.zzm.zza(this) {
            final /* synthetic */ zzih zzJc;

            public void zze(zzr com_google_android_gms_internal_zzr) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Failed to load URL: " + str + "\n" + com_google_android_gms_internal_zzr.toString());
                com_google_android_gms_internal_zzih_zzc.zzb(null);
            }
        }) {
            final /* synthetic */ zzih zzJc;

            public Map<String, String> getHeaders() throws zza {
                return map2 == null ? super.getHeaders() : map2;
            }
        });
        return com_google_android_gms_internal_zzih_zzc;
    }
}
