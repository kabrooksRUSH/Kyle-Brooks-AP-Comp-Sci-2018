package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class zzip {

    public interface zza<D, R> {
        R zze(D d);
    }

    public static <A, B> zziq<B> zza(final zziq<A> com_google_android_gms_internal_zziq_A, final zza<A, B> com_google_android_gms_internal_zzip_zza_A__B) {
        final zziq com_google_android_gms_internal_zzin = new zzin();
        com_google_android_gms_internal_zziq_A.zzc(new Runnable() {
            public void run() {
                try {
                    com_google_android_gms_internal_zzin.zzf(com_google_android_gms_internal_zzip_zza_A__B.zze(com_google_android_gms_internal_zziq_A.get()));
                    return;
                } catch (CancellationException e) {
                } catch (InterruptedException e2) {
                } catch (ExecutionException e3) {
                }
                com_google_android_gms_internal_zzin.cancel(true);
            }
        });
        return com_google_android_gms_internal_zzin;
    }

    public static <V> zziq<List<V>> zzh(final List<zziq<V>> list) {
        final zziq com_google_android_gms_internal_zzin = new zzin();
        final int size = list.size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zziq zzc : list) {
            zzc.zzc(new Runnable() {
                public void run() {
                    Throwable e;
                    if (atomicInteger.incrementAndGet() >= size) {
                        try {
                            com_google_android_gms_internal_zzin.zzf(zzip.zzi(list));
                            return;
                        } catch (ExecutionException e2) {
                            e = e2;
                        } catch (InterruptedException e3) {
                            e = e3;
                        }
                    } else {
                        return;
                    }
                    zzb.zzd("Unable to convert list of futures to a future of list", e);
                }
            });
        }
        return com_google_android_gms_internal_zzin;
    }

    private static <V> List<V> zzi(List<zziq<V>> list) throws ExecutionException, InterruptedException {
        List<V> arrayList = new ArrayList();
        for (zziq com_google_android_gms_internal_zziq : list) {
            Object obj = com_google_android_gms_internal_zziq.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
