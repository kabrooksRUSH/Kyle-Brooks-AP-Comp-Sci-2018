package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> zzazh = new AtomicReference();

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzazh.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    public void zzp(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzazh.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = zzuU();
            if (!this.zzazh.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.zzazh.get();
            }
        }
        eventIncrementCache.zzw(str, i);
    }

    protected abstract EventIncrementCache zzuU();
}
