package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc implements Creator<CustomProperty> {
    static void zza(CustomProperty customProperty, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, customProperty.mVersionCode);
        zzb.zza(parcel, 2, customProperty.zzamD, i, false);
        zzb.zza(parcel, 3, customProperty.mValue, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdI(x0);
    }

    public CustomProperty zzbW(Parcel parcel) {
        String str = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < zzap) {
            CustomPropertyKey customPropertyKey2;
            int zzg;
            String str2;
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = zza.zzg(parcel, zzao);
                    str2 = str3;
                    break;
                case 2:
                    zzg = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) zza.zza(parcel, zzao, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzao);
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
            }
            i = zzg;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == zzap) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public CustomProperty[] zzdI(int i) {
        return new CustomProperty[i];
    }
}
