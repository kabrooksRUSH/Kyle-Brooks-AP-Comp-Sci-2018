package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbo implements Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, removeEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, removeEventListenerRequest.zzaiA, i, false);
        zzb.zzc(parcel, 3, removeEventListenerRequest.zzaho);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdu(x0);
    }

    public RemoveEventListenerRequest zzbI(Parcel parcel) {
        int i = 0;
        int zzap = zza.zzap(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            DriveId driveId2;
            int zzg;
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzao);
                    zzao = i3;
                    break;
                case 2:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    zzao = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzao = zza.zzg(parcel, zzao);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzao = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = zzao;
        }
        if (parcel.dataPosition() == zzap) {
            return new RemoveEventListenerRequest(i2, driveId, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public RemoveEventListenerRequest[] zzdu(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
