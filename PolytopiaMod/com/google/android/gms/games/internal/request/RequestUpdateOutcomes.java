package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] zzazR = new String[]{"requestId", "outcome"};
    private final int zzYm;
    private final HashMap<String, Integer> zzazS;

    public static final class Builder {
        private int zzYm = 0;
        private HashMap<String, Integer> zzazS = new HashMap();

        public Builder zzgj(int i) {
            this.zzYm = i;
            return this;
        }

        public RequestUpdateOutcomes zzvF() {
            return new RequestUpdateOutcomes(this.zzYm, this.zzazS);
        }

        public Builder zzx(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.zzazS.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    private RequestUpdateOutcomes(int statusCode, HashMap<String, Integer> outcomeMap) {
        this.zzYm = statusCode;
        this.zzazS = outcomeMap;
    }

    public static RequestUpdateOutcomes zzaa(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.zzgj(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int zzbt = dataHolder.zzbt(i);
            builder.zzx(dataHolder.zzd("requestId", i, zzbt), dataHolder.zzc("outcome", i, zzbt));
        }
        return builder.zzvF();
    }

    public Set<String> getRequestIds() {
        return this.zzazS.keySet();
    }

    public int getRequestOutcome(String requestId) {
        zzx.zzb(this.zzazS.containsKey(requestId), "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.zzazS.get(requestId)).intValue();
    }
}
