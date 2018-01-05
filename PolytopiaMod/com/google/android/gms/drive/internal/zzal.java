package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;
import java.util.List;

public class zzal implements Creator<GetPermissionsResponse> {
    static void zza(GetPermissionsResponse getPermissionsResponse, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, getPermissionsResponse.mVersionCode);
        zzb.zzc(parcel, 2, getPermissionsResponse.zzalG, false);
        zzb.zzc(parcel, 3, getPermissionsResponse.zzxM);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcZ(x0);
    }

    public GetPermissionsResponse zzbn(Parcel parcel) {
        int i = 0;
        int zzap = zza.zzap(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzao, Permission.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new GetPermissionsResponse(i2, list, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public GetPermissionsResponse[] zzcZ(int i) {
        return new GetPermissionsResponse[i];
    }
}
