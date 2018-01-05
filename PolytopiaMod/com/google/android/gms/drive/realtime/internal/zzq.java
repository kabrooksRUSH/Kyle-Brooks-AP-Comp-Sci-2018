package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<ParcelableCollaborator> {
    static void zza(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, parcelableCollaborator.mVersionCode);
        zzb.zza(parcel, 2, parcelableCollaborator.zzaox);
        zzb.zza(parcel, 3, parcelableCollaborator.zzaoy);
        zzb.zza(parcel, 4, parcelableCollaborator.zzHP, false);
        zzb.zza(parcel, 5, parcelableCollaborator.zzGY, false);
        zzb.zza(parcel, 6, parcelableCollaborator.zzTa, false);
        zzb.zza(parcel, 7, parcelableCollaborator.zzaoz, false);
        zzb.zza(parcel, 8, parcelableCollaborator.zzaoA, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzee(x0);
    }

    public ParcelableCollaborator zzcr(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzap = zza.zzap(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 4:
                    str5 = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 7:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 8:
                    str = zza.zzp(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ParcelableCollaborator[] zzee(int i) {
        return new ParcelableCollaborator[i];
    }
}
