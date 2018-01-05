package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.internal.zzlc;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzlc<BatchResult> {
    private boolean zzaaA;
    private final PendingResult<?>[] zzaaB;
    private int zzaay;
    private boolean zzaaz;
    private final Object zzpd;

    class C01561 implements zza {
        final /* synthetic */ Batch zzaaC;

        C01561(Batch batch) {
            this.zzaaC = batch;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzt(com.google.android.gms.common.api.Status r6) {
            /*
            r5 = this;
            r0 = r5.zzaaC;
            r1 = r0.zzpd;
            monitor-enter(r1);
            r0 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            r0 = r0.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0011;
        L_0x000f:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        L_0x0010:
            return;
        L_0x0011:
            r0 = r6.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x003c;
        L_0x0017:
            r0 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.zzaaA = r2;	 Catch:{ all -> 0x0039 }
        L_0x001d:
            r0 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            r0.zzaay = r0.zzaay - 1;	 Catch:{ all -> 0x0039 }
            r0 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            r0 = r0.zzaay;	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0037;
        L_0x002a:
            r0 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            r0 = r0.zzaaA;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0049;
        L_0x0032:
            r0 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            super.cancel();	 Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            goto L_0x0010;
        L_0x0039:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            throw r0;
        L_0x003c:
            r0 = r6.isSuccess();	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x001d;
        L_0x0042:
            r0 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.zzaaz = r2;	 Catch:{ all -> 0x0039 }
            goto L_0x001d;
        L_0x0049:
            r0 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            r0 = r0.zzaaz;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0069;
        L_0x0051:
            r0 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x0039 }
            r2 = 13;
            r0.<init>(r2);	 Catch:{ all -> 0x0039 }
        L_0x0058:
            r2 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            r3 = new com.google.android.gms.common.api.BatchResult;	 Catch:{ all -> 0x0039 }
            r4 = r5.zzaaC;	 Catch:{ all -> 0x0039 }
            r4 = r4.zzaaB;	 Catch:{ all -> 0x0039 }
            r3.<init>(r0, r4);	 Catch:{ all -> 0x0039 }
            r2.zzb(r3);	 Catch:{ all -> 0x0039 }
            goto L_0x0037;
        L_0x0069:
            r0 = com.google.android.gms.common.api.Status.zzabb;	 Catch:{ all -> 0x0039 }
            goto L_0x0058;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.1.zzt(com.google.android.gms.common.api.Status):void");
        }
    }

    public static final class Builder {
        private GoogleApiClient zzVs;
        private List<PendingResult<?>> zzaaD = new ArrayList();

        public Builder(GoogleApiClient googleApiClient) {
            this.zzVs = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.zzaaD.size());
            this.zzaaD.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zzaaD, this.zzVs);
        }
    }

    private Batch(List<PendingResult<?>> pendingResultList, GoogleApiClient apiClient) {
        super(apiClient);
        this.zzpd = new Object();
        this.zzaay = pendingResultList.size();
        this.zzaaB = new PendingResult[this.zzaay];
        for (int i = 0; i < pendingResultList.size(); i++) {
            PendingResult pendingResult = (PendingResult) pendingResultList.get(i);
            this.zzaaB[i] = pendingResult;
            pendingResult.zza(new C01561(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.zzaaB) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zzaaB);
    }

    public /* synthetic */ Result zzb(Status status) {
        return createFailedResult(status);
    }
}
