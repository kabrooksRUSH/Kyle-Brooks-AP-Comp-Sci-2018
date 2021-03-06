package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzk implements Creator<ParentDriveIdSet> {
    static void zza(ParentDriveIdSet parentDriveIdSet, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, parentDriveIdSet.mVersionCode);
        zzb.zzc(parcel, 2, parentDriveIdSet.zzamH, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdK(x0);
    }

    public ParentDriveIdSet zzbY(Parcel parcel) {
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
                    list = zza.zzc(parcel, zzao, PartialDriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new ParentDriveIdSet(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ParentDriveIdSet[] zzdK(int i) {
        return new ParentDriveIdSet[i];
    }
}
