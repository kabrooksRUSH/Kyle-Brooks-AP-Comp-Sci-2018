package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzgr
public final class zzib {

    public interface zzb {
        void zzd(Bundle bundle);
    }

    private static abstract class zza extends zzhz {
        private zza() {
        }

        public void onStop() {
        }
    }

    public static Future zza(final Context context, final int i) {
        return new zza() {
            public void zzbn() {
                Editor edit = zzib.zzv(context).edit();
                edit.putInt("webview_cache_version", i);
                edit.apply();
            }
        }.zzgz();
    }

    public static Future zza(final Context context, final zzb com_google_android_gms_internal_zzib_zzb) {
        return new zza() {
            public void zzbn() {
                SharedPreferences zzG = zzib.zzv(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", zzG.getBoolean("use_https", true));
                if (com_google_android_gms_internal_zzib_zzb != null) {
                    com_google_android_gms_internal_zzib_zzb.zzd(bundle);
                }
            }
        }.zzgz();
    }

    public static Future zza(final Context context, final boolean z) {
        return new zza() {
            public void zzbn() {
                Editor edit = zzib.zzv(context).edit();
                edit.putBoolean("use_https", z);
                edit.apply();
            }
        }.zzgz();
    }

    public static Future zzb(final Context context, final zzb com_google_android_gms_internal_zzib_zzb) {
        return new zza() {
            public void zzbn() {
                SharedPreferences zzG = zzib.zzv(context);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", zzG.getInt("webview_cache_version", 0));
                if (com_google_android_gms_internal_zzib_zzb != null) {
                    com_google_android_gms_internal_zzib_zzb.zzd(bundle);
                }
            }
        }.zzgz();
    }

    private static SharedPreferences zzv(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
