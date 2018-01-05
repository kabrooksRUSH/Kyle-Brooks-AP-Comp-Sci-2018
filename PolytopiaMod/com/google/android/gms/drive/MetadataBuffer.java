package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zznd;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzaja;

    private static class zza extends Metadata {
        private final DataHolder zzabq;
        private final int zzadm;
        private final int zzajb;

        public zza(DataHolder dataHolder, int i) {
            this.zzabq = dataHolder;
            this.zzajb = i;
            this.zzadm = dataHolder.zzbt(i);
        }

        public /* synthetic */ Object freeze() {
            return zzqV();
        }

        public boolean isDataValid() {
            return !this.zzabq.isClosed();
        }

        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzabq, this.zzajb, this.zzadm);
        }

        public Metadata zzqV() {
            MetadataBundle zzrM = MetadataBundle.zzrM();
            for (MetadataField metadataField : zze.zzrK()) {
                if (metadataField != zznd.zzano) {
                    metadataField.zza(this.zzabq, zzrM, this.zzajb, this.zzadm);
                }
            }
            return new zzp(zzrM);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zzor().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        zza com_google_android_gms_drive_MetadataBuffer_zza = this.zzaja;
        if (com_google_android_gms_drive_MetadataBuffer_zza != null && com_google_android_gms_drive_MetadataBuffer_zza.zzajb == row) {
            return com_google_android_gms_drive_MetadataBuffer_zza;
        }
        Metadata com_google_android_gms_drive_MetadataBuffer_zza2 = new zza(this.zzabq, row);
        this.zzaja = com_google_android_gms_drive_MetadataBuffer_zza2;
        return com_google_android_gms_drive_MetadataBuffer_zza2;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    public void release() {
        if (this.zzabq != null) {
            zze.zza(this.zzabq);
        }
        super.release();
    }
}
