package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzh implements Creator<ProgressEvent> {
    static void zza(ProgressEvent progressEvent, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, progressEvent.mVersionCode);
        zzb.zza(parcel, 2, progressEvent.zzaiA, i, false);
        zzb.zzc(parcel, 3, progressEvent.zzys);
        zzb.zza(parcel, 4, progressEvent.zzajP);
        zzb.zza(parcel, 5, progressEvent.zzajQ);
        zzb.zzc(parcel, 6, progressEvent.zzWJ);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcv(x0);
    }

    public ProgressEvent zzaP(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzap = zza.zzap(parcel);
        DriveId driveId = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzao);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzao);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new ProgressEvent(i3, driveId, i2, j2, j, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ProgressEvent[] zzcv(int i) {
        return new ProgressEvent[i];
    }
}
