package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzazb = new Object();
    private Handler zzazc;
    private boolean zzazd;
    private HashMap<String, AtomicInteger> zzaze;
    private int zzazf;

    class C05351 implements Runnable {
        final /* synthetic */ EventIncrementCache zzazg;

        C05351(EventIncrementCache eventIncrementCache) {
            this.zzazg = eventIncrementCache;
        }

        public void run() {
            this.zzazg.zzvj();
        }
    }

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.zzazc = new Handler(looper);
        this.zzaze = new HashMap();
        this.zzazf = flushIntervalMillis;
    }

    private void zzvj() {
        synchronized (this.zzazb) {
            this.zzazd = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzazb) {
            for (Entry entry : this.zzaze.entrySet()) {
                zzs((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzaze.clear();
        }
    }

    protected abstract void zzs(String str, int i);

    public void zzw(String str, int i) {
        synchronized (this.zzazb) {
            if (!this.zzazd) {
                this.zzazd = true;
                this.zzazc.postDelayed(new C05351(this), (long) this.zzazf);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzaze.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzaze.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
