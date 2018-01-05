package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class zzbs implements Creator<SetResourceParentsRequest> {
    static void zza(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, setResourceParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, setResourceParentsRequest.zzajY, i, false);
        zzb.zzc(parcel, 3, setResourceParentsRequest.zzams, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdy(x0);
    }

    public SetResourceParentsRequest zzbM(Parcel parcel) {
        List list = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzap) {
            DriveId driveId2;
            int zzg;
            ArrayList zzc;
            int zzao = zza.zzao(parcel);
            List list2;
            switch (zza.zzbM(zzao)) {
                case 1:
                    List list3 = list;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzao);
                    list2 = list3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    list2 = list;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzao, DriveId.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzc = list;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzap) {
            return new SetResourceParentsRequest(i, driveId, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public SetResourceParentsRequest[] zzdy(int i) {
        return new SetResourceParentsRequest[i];
    }
}
