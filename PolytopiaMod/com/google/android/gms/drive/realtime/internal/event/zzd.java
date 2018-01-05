package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class zzd implements Creator<ParcelableEventList> {
    static void zza(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, parcelableEventList.mVersionCode);
        zzb.zzc(parcel, 2, parcelableEventList.zzoQ, false);
        zzb.zza(parcel, 3, parcelableEventList.zzaoV, i, false);
        zzb.zza(parcel, 4, parcelableEventList.zzaoW);
        zzb.zzb(parcel, 5, parcelableEventList.zzaoX, false);
        zzb.zza(parcel, 6, parcelableEventList.zzaoY, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzej(x0);
    }

    public ParcelableEventList zzcw(Parcel parcel) {
        boolean z = false;
        ParcelableChangeInfo parcelableChangeInfo = null;
        int zzap = zza.zzap(parcel);
        List list = null;
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    list2 = zza.zzc(parcel, zzao, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) zza.zza(parcel, zzao, DataHolder.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 5:
                    list = zza.zzD(parcel, zzao);
                    break;
                case 6:
                    parcelableChangeInfo = (ParcelableChangeInfo) zza.zza(parcel, zzao, ParcelableChangeInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new ParcelableEventList(i, list2, dataHolder, z, list, parcelableChangeInfo);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ParcelableEventList[] zzej(int i) {
        return new ParcelableEventList[i];
    }
}
