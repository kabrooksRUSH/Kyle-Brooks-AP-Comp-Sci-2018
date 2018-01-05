package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<DriveFileRange> {
    static void zza(DriveFileRange driveFileRange, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, driveFileRange.mVersionCode);
        zzb.zza(parcel, 2, driveFileRange.zzaiK);
        zzb.zza(parcel, 3, driveFileRange.zzaiL);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcg(x0);
    }

    public DriveFileRange zzaE(Parcel parcel) {
        long j = 0;
        int zzap = zza.zzap(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzao);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new DriveFileRange(i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public DriveFileRange[] zzcg(int i) {
        return new DriveFileRange[i];
    }
}
