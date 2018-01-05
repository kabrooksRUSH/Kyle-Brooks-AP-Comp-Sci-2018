package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;

@zzgr
public abstract class zzbu<T> {
    private final String zzue;
    private final T zzuf;

    private zzbu(String str, T t) {
        this.zzue = str;
        this.zzuf = t;
        zzp.zzbD().zza(this);
    }

    public static zzbu<String> zzP(String str) {
        zzbu<String> zzc = zzc(str, (String) null);
        zzp.zzbD().zzb(zzc);
        return zzc;
    }

    public static zzbu<String> zzQ(String str) {
        zzbu<String> zzc = zzc(str, (String) null);
        zzp.zzbD().zzc(zzc);
        return zzc;
    }

    public static zzbu<Integer> zza(String str, int i) {
        return new zzbu<Integer>(str, Integer.valueOf(i)) {
            public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
                return zzc(sharedPreferences);
            }

            public Integer zzc(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzde()).intValue()));
            }
        };
    }

    public static zzbu<Boolean> zza(String str, Boolean bool) {
        return new zzbu<Boolean>(str, bool) {
            public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
                return zzb(sharedPreferences);
            }

            public Boolean zzb(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzde()).booleanValue()));
            }
        };
    }

    public static zzbu<Long> zzb(String str, long j) {
        return new zzbu<Long>(str, Long.valueOf(j)) {
            public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
                return zzd(sharedPreferences);
            }

            public Long zzd(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzde()).longValue()));
            }
        };
    }

    public static zzbu<String> zzc(String str, String str2) {
        return new zzbu<String>(str, str2) {
            public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
                return zze(sharedPreferences);
            }

            public String zze(SharedPreferences sharedPreferences) {
                return sharedPreferences.getString(getKey(), (String) zzde());
            }
        };
    }

    public T get() {
        return zzp.zzbE().zzd(this);
    }

    public String getKey() {
        return this.zzue;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzde() {
        return this.zzuf;
    }
}
