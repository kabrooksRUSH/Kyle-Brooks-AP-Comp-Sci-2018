package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<EndCompoundOperationRequest> {
    static void zza(EndCompoundOperationRequest endCompoundOperationRequest, Parcel parcel, int i) {
        int zzaq = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, endCompoundOperationRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeb(x0);
    }

    public EndCompoundOperationRequest zzcp(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new EndCompoundOperationRequest(i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public EndCompoundOperationRequest[] zzeb(int i) {
        return new EndCompoundOperationRequest[i];
    }
}
