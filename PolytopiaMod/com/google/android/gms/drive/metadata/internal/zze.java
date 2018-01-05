package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zze {
    private static final Map<String, MetadataField<?>> zzamE = new HashMap();
    private static final Map<String, zza> zzamF = new HashMap();

    public interface zza {
        void zzb(DataHolder dataHolder);

        String zzrL();
    }

    static {
        zzb(zznd.zzamJ);
        zzb(zznd.zzanp);
        zzb(zznd.zzang);
        zzb(zznd.zzann);
        zzb(zznd.zzanq);
        zzb(zznd.zzamW);
        zzb(zznd.zzamV);
        zzb(zznd.zzamX);
        zzb(zznd.zzamY);
        zzb(zznd.zzamZ);
        zzb(zznd.zzamT);
        zzb(zznd.zzanb);
        zzb(zznd.zzanc);
        zzb(zznd.zzand);
        zzb(zznd.zzanl);
        zzb(zznd.zzamK);
        zzb(zznd.zzani);
        zzb(zznd.zzamM);
        zzb(zznd.zzamU);
        zzb(zznd.zzamN);
        zzb(zznd.zzamO);
        zzb(zznd.zzamP);
        zzb(zznd.zzamQ);
        zzb(zznd.zzanf);
        zzb(zznd.zzana);
        zzb(zznd.zzanh);
        zzb(zznd.zzanj);
        zzb(zznd.zzank);
        zzb(zznd.zzanm);
        zzb(zznd.zzanr);
        zzb(zznd.zzans);
        zzb(zznd.zzamS);
        zzb(zznd.zzamR);
        zzb(zznd.zzano);
        zzb(zznd.zzane);
        zzb(zznd.zzamL);
        zzb(zznd.zzant);
        zzb(zznd.zzanu);
        zzb(zznd.zzanv);
        zzb(zznd.zzanw);
        zzb(zznd.zzanx);
        zzb(zznd.zzany);
        zzb(zznd.zzanz);
        zzb(zznf.zzanB);
        zzb(zznf.zzanD);
        zzb(zznf.zzanE);
        zzb(zznf.zzanF);
        zzb(zznf.zzanC);
        zzb(zznf.zzanG);
        zzb(zznh.zzanI);
        zzb(zznh.zzanJ);
        zzl com_google_android_gms_drive_metadata_internal_zzl = zznd.zzanl;
        zza(zzl.zzamI);
        zza(zzne.zzanA);
    }

    public static void zza(DataHolder dataHolder) {
        for (zza zzb : zzamF.values()) {
            zzb.zzb(dataHolder);
        }
    }

    private static void zza(zza com_google_android_gms_drive_metadata_internal_zze_zza) {
        if (zzamF.put(com_google_android_gms_drive_metadata_internal_zze_zza.zzrL(), com_google_android_gms_drive_metadata_internal_zze_zza) != null) {
            throw new IllegalStateException("A cleaner for key " + com_google_android_gms_drive_metadata_internal_zze_zza.zzrL() + " has already been registered");
        }
    }

    private static void zzb(MetadataField<?> metadataField) {
        if (zzamE.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        zzamE.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> zzcF(String str) {
        return (MetadataField) zzamE.get(str);
    }

    public static Collection<MetadataField<?>> zzrK() {
        return Collections.unmodifiableCollection(zzamE.values());
    }
}
