package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class zzf implements Creator<ChangeResourceParentsRequest> {
    static void zza(ChangeResourceParentsRequest changeResourceParentsRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, changeResourceParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, changeResourceParentsRequest.zzajY, i, false);
        zzb.zzc(parcel, 3, changeResourceParentsRequest.zzajZ, false);
        zzb.zzc(parcel, 4, changeResourceParentsRequest.zzaka, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcC(x0);
    }

    public ChangeResourceParentsRequest zzaV(Parcel parcel) {
        List list = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        List list2 = null;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzap) {
            DriveId driveId2;
            int zzg;
            Object zzc;
            ArrayList zzc2;
            int zzao = zza.zzao(parcel);
            List list3;
            List list4;
            switch (zza.zzbM(zzao)) {
                case 1:
                    list3 = list;
                    list = list2;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzao);
                    list4 = list3;
                    break;
                case 2:
                    zzg = i;
                    list3 = list2;
                    driveId2 = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    list4 = list;
                    list = list3;
                    break;
                case 3:
                    driveId2 = driveId;
                    zzg = i;
                    list3 = list;
                    zzc = zza.zzc(parcel, zzao, DriveId.CREATOR);
                    list4 = list3;
                    break;
                case 4:
                    zzc2 = zza.zzc(parcel, zzao, DriveId.CREATOR);
                    list = list2;
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzc2 = list;
                    list = list2;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            list2 = list;
            zzc = zzc2;
        }
        if (parcel.dataPosition() == zzap) {
            return new ChangeResourceParentsRequest(i, driveId, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ChangeResourceParentsRequest[] zzcC(int i) {
        return new ChangeResourceParentsRequest[i];
    }
}
