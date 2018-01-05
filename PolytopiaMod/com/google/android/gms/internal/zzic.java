package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzgr
public final class zzic {
    private static final ExecutorService zzIr = Executors.newFixedThreadPool(10, zzay("Default"));
    private static final ExecutorService zzIs = Executors.newFixedThreadPool(5, zzay("Loader"));

    public static zziq<Void> zza(int i, final Runnable runnable) {
        return i == 1 ? zza(zzIs, new Callable<Void>() {
            public /* synthetic */ Object call() throws Exception {
                return zzgA();
            }

            public Void zzgA() {
                runnable.run();
                return null;
            }
        }) : zza(zzIr, new Callable<Void>() {
            public /* synthetic */ Object call() throws Exception {
                return zzgA();
            }

            public Void zzgA() {
                runnable.run();
                return null;
            }
        });
    }

    public static zziq<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zziq<T> zza(Callable<T> callable) {
        return zza(zzIr, (Callable) callable);
    }

    public static <T> zziq<T> zza(ExecutorService executorService, final Callable<T> callable) {
        final Object com_google_android_gms_internal_zzin = new zzin();
        try {
            final Future submit = executorService.submit(new Runnable() {
                public void run() {
                    try {
                        Process.setThreadPriority(10);
                        com_google_android_gms_internal_zzin.zzf(callable.call());
                    } catch (Throwable e) {
                        zzp.zzby().zzc(e, true);
                        com_google_android_gms_internal_zzin.cancel(true);
                    }
                }
            });
            com_google_android_gms_internal_zzin.zzd(new Runnable() {
                public void run() {
                    if (com_google_android_gms_internal_zzin.isCancelled()) {
                        submit.cancel(true);
                    }
                }
            });
        } catch (Throwable e) {
            zzb.zzd("Thread execution is rejected.", e);
            com_google_android_gms_internal_zzin.cancel(true);
        }
        return com_google_android_gms_internal_zzin;
    }

    private static ThreadFactory zzay(final String str) {
        return new ThreadFactory() {
            private final AtomicInteger zzIw = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "AdWorker(" + str + ") #" + this.zzIw.getAndIncrement());
            }
        };
    }
}
