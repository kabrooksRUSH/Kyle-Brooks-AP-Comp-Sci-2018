package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<DriveId> {
    static void zza(DriveId driveId, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, driveId.mVersionCode);
        zzb.zza(parcel, 2, driveId.zzaiM, false);
        zzb.zza(parcel, 3, driveId.zzaiN);
        zzb.zza(parcel, 4, driveId.zzaiv);
        zzb.zzc(parcel, 5, driveId.zzaiO);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzch(x0);
    }

    public DriveId zzaF(Parcel parcel) {
        long j = 0;
        int zzap = zza.zzap(parcel);
        int i = 0;
        String str = null;
        int i2 = -1;
        long j2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    j2 = zza.zzi(parcel, zzao);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzao);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new DriveId(i, str, j2, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public DriveId[] zzch(int i) {
        return new DriveId[i];
    }
}
