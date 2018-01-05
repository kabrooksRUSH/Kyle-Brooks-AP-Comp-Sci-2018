package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<DrivePreferences> {
    static void zza(DrivePreferences drivePreferences, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, drivePreferences.mVersionCode);
        zzb.zza(parcel, 2, drivePreferences.zzaiQ);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzci(x0);
    }

    public DrivePreferences zzaG(Parcel parcel) {
        boolean z = false;
        int zzap = zza.zzap(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new DrivePreferences(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public DrivePreferences[] zzci(int i) {
        return new DrivePreferences[i];
    }
}
