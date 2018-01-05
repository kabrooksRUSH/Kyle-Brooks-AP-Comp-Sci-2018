package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public class zzg implements zzf<Boolean> {
    private Boolean zzaoi = Boolean.valueOf(false);

    private zzg() {
    }

    public static boolean zza(Filter filter) {
        return filter == null ? false : ((Boolean) filter.zza(new zzg())).booleanValue();
    }

    public /* synthetic */ Object zzb(zzb com_google_android_gms_drive_metadata_zzb, Object obj) {
        return zzc(com_google_android_gms_drive_metadata_zzb, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, MetadataField metadataField, Object obj) {
        return zzc(operator, metadataField, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, List list) {
        return zzc(operator, list);
    }

    public <T> Boolean zzc(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t) {
        return this.zzaoi;
    }

    public <T> Boolean zzc(Operator operator, MetadataField<T> metadataField, T t) {
        return this.zzaoi;
    }

    public Boolean zzc(Operator operator, List<Boolean> list) {
        return this.zzaoi;
    }

    public /* synthetic */ Object zzcL(String str) {
        return zzcM(str);
    }

    public Boolean zzcM(String str) {
        if (!str.isEmpty()) {
            this.zzaoi = Boolean.valueOf(true);
        }
        return this.zzaoi;
    }

    public Boolean zzd(Boolean bool) {
        return this.zzaoi;
    }

    public /* synthetic */ Object zzd(MetadataField metadataField, Object obj) {
        return zze(metadataField, obj);
    }

    public <T> Boolean zze(MetadataField<T> metadataField, T t) {
        return this.zzaoi;
    }

    public /* synthetic */ Object zze(MetadataField metadataField) {
        return zzf(metadataField);
    }

    public Boolean zzf(MetadataField<?> metadataField) {
        return this.zzaoi;
    }

    public /* synthetic */ Object zzrU() {
        return zzrX();
    }

    public /* synthetic */ Object zzrV() {
        return zzrW();
    }

    public Boolean zzrW() {
        return this.zzaoi;
    }

    public Boolean zzrX() {
        return this.zzaoi;
    }

    public /* synthetic */ Object zzx(Object obj) {
        return zzd((Boolean) obj);
    }
}
