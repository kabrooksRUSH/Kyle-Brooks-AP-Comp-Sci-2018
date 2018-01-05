package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzp extends Metadata {
    private final MetadataBundle zzakt;

    public zzp(MetadataBundle metadataBundle) {
        this.zzakt = metadataBundle;
    }

    public /* synthetic */ Object freeze() {
        return zzqV();
    }

    public boolean isDataValid() {
        return this.zzakt != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.zzakt + "]";
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return this.zzakt.zza((MetadataField) metadataField);
    }

    public Metadata zzqV() {
        return new zzp(MetadataBundle.zza(this.zzakt));
    }
}
