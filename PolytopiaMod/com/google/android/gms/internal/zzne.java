package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.zze.zza;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzne extends zzj<AppVisibleCustomProperties> {
    public static final zza zzanA = new C07111();

    static class C07111 implements zza {
        C07111() {
        }

        public void zzb(DataHolder dataHolder) {
            zzne.zzd(dataHolder);
        }

        public String zzrL() {
            return "customPropertiesExtraHolder";
        }
    }

    public zzne(int i) {
        super("customProperties", Arrays.asList(new String[]{"hasCustomProperties", "sqlId"}), Arrays.asList(new String[]{"customPropertiesExtra", "customPropertiesExtraHolder"}), i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzc(com.google.android.gms.common.data.DataHolder r8) {
        /*
        monitor-enter(r8);
        r0 = r8.zzor();	 Catch:{ all -> 0x0056 }
        r1 = "customPropertiesExtraHolder";
        r0 = r0.getParcelable(r1);	 Catch:{ all -> 0x0056 }
        r0 = (com.google.android.gms.common.data.DataHolder) r0;	 Catch:{ all -> 0x0056 }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r8);	 Catch:{ all -> 0x0056 }
    L_0x0010:
        return;
    L_0x0011:
        r3 = zzf(r0);	 Catch:{ all -> 0x0059 }
        r4 = new android.util.SparseArray;	 Catch:{ all -> 0x0059 }
        r4.<init>();	 Catch:{ all -> 0x0059 }
        r1 = 0;
        r2 = r1;
    L_0x001c:
        r1 = r8.getCount();	 Catch:{ all -> 0x0059 }
        if (r2 >= r1) goto L_0x003f;
    L_0x0022:
        r1 = "sqlId";
        r5 = r8.zzbt(r2);	 Catch:{ all -> 0x0059 }
        r6 = r8.zzb(r1, r2, r5);	 Catch:{ all -> 0x0059 }
        r1 = r3.get(r6);	 Catch:{ all -> 0x0059 }
        r1 = (com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza) r1;	 Catch:{ all -> 0x0059 }
        if (r1 == 0) goto L_0x003b;
    L_0x0034:
        r1 = r1.zzrI();	 Catch:{ all -> 0x0059 }
        r4.append(r2, r1);	 Catch:{ all -> 0x0059 }
    L_0x003b:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x001c;
    L_0x003f:
        r1 = r8.zzor();	 Catch:{ all -> 0x0059 }
        r2 = "customPropertiesExtra";
        r1.putSparseParcelableArray(r2, r4);	 Catch:{ all -> 0x0059 }
        r0.close();	 Catch:{ all -> 0x0056 }
        r0 = r8.zzor();	 Catch:{ all -> 0x0056 }
        r1 = "customPropertiesExtraHolder";
        r0.remove(r1);	 Catch:{ all -> 0x0056 }
        monitor-exit(r8);	 Catch:{ all -> 0x0056 }
        goto L_0x0010;
    L_0x0056:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0056 }
        throw r0;
    L_0x0059:
        r1 = move-exception;
        r0.close();	 Catch:{ all -> 0x0056 }
        r0 = r8.zzor();	 Catch:{ all -> 0x0056 }
        r2 = "customPropertiesExtraHolder";
        r0.remove(r2);	 Catch:{ all -> 0x0056 }
        throw r1;	 Catch:{ all -> 0x0056 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzne.zzc(com.google.android.gms.common.data.DataHolder):void");
    }

    private static void zzd(DataHolder dataHolder) {
        Bundle zzor = dataHolder.zzor();
        if (zzor != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) zzor.getParcelable("customPropertiesExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    zzor.remove("customPropertiesExtraHolder");
                }
            }
        }
    }

    private static LongSparseArray<AppVisibleCustomProperties.zza> zzf(DataHolder dataHolder) {
        Bundle zzor = dataHolder.zzor();
        String string = zzor.getString("entryIdColumn");
        String string2 = zzor.getString("keyColumn");
        String string3 = zzor.getString("visibilityColumn");
        String string4 = zzor.getString("valueColumn");
        LongSparseArray<AppVisibleCustomProperties.zza> longSparseArray = new LongSparseArray();
        for (int i = 0; i < dataHolder.getCount(); i++) {
            int zzbt = dataHolder.zzbt(i);
            long zzb = dataHolder.zzb(string, i, zzbt);
            String zzd = dataHolder.zzd(string2, i, zzbt);
            int zzc = dataHolder.zzc(string3, i, zzbt);
            CustomProperty customProperty = new CustomProperty(new CustomPropertyKey(zzd, zzc), dataHolder.zzd(string4, i, zzbt));
            AppVisibleCustomProperties.zza com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza = (AppVisibleCustomProperties.zza) longSparseArray.get(zzb);
            if (com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza == null) {
                com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza = new AppVisibleCustomProperties.zza();
                longSparseArray.put(zzb, com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza);
            }
            com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza.zza(customProperty);
        }
        return longSparseArray;
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzl(dataHolder, i, i2);
    }

    protected AppVisibleCustomProperties zzl(DataHolder dataHolder, int i, int i2) {
        Bundle zzor = dataHolder.zzor();
        SparseArray sparseParcelableArray = zzor.getSparseParcelableArray("customPropertiesExtra");
        if (sparseParcelableArray == null) {
            if (zzor.getParcelable("customPropertiesExtraHolder") != null) {
                zzc(dataHolder);
                sparseParcelableArray = zzor.getSparseParcelableArray("customPropertiesExtra");
            }
            if (sparseParcelableArray == null) {
                return AppVisibleCustomProperties.zzamA;
            }
        }
        return (AppVisibleCustomProperties) sparseParcelableArray.get(i, AppVisibleCustomProperties.zzamA);
    }
}
