package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd implements Creator<OnListEntriesResponse> {
    static void zza(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, onListEntriesResponse.mVersionCode);
        zzb.zza(parcel, 2, onListEntriesResponse.zzamk, i, false);
        zzb.zza(parcel, 3, onListEntriesResponse.zzakB);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzby(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdk(x0);
    }

    public OnListEntriesResponse zzby(Parcel parcel) {
        boolean z = false;
        int zzap = zza.zzap(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            DataHolder dataHolder2;
            int zzg;
            boolean z2;
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzao);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    DataHolder dataHolder3 = (DataHolder) zza.zza(parcel, zzao, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzao);
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
            }
            i = zzg;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == zzap) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public OnListEntriesResponse[] zzdk(int i) {
        return new OnListEntriesResponse[i];
    }
}
