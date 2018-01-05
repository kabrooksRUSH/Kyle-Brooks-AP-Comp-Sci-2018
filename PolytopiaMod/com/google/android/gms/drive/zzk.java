package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<UserMetadata> {
    static void zza(UserMetadata userMetadata, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, userMetadata.mVersionCode);
        zzb.zza(parcel, 2, userMetadata.zzajr, false);
        zzb.zza(parcel, 3, userMetadata.zzTa, false);
        zzb.zza(parcel, 4, userMetadata.zzajs, false);
        zzb.zza(parcel, 5, userMetadata.zzajt);
        zzb.zza(parcel, 6, userMetadata.zzaju, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcq(x0);
    }

    public UserMetadata zzaK(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzap = zza.zzap(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public UserMetadata[] zzcq(int i) {
        return new UserMetadata[i];
    }
}
