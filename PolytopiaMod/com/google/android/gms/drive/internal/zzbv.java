package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzbv implements Creator<StringListResponse> {
    static void zza(StringListResponse stringListResponse, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, stringListResponse.getVersionCode());
        zzb.zzb(parcel, 2, stringListResponse.zzrF(), false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdA(x0);
    }

    public StringListResponse zzbO(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    list = zza.zzD(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new StringListResponse(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public StringListResponse[] zzdA(int i) {
        return new StringListResponse[i];
    }
}
