package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<MetadataBundle> {
    static void zza(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, metadataBundle.mVersionCode);
        zzb.zza(parcel, 2, metadataBundle.zzamG, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdJ(x0);
    }

    public MetadataBundle zzbX(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    bundle = zza.zzr(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new MetadataBundle(i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public MetadataBundle[] zzdJ(int i) {
        return new MetadataBundle[i];
    }
}
