package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzj implements Creator<ControlProgressRequest> {
    static void zza(ControlProgressRequest controlProgressRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, controlProgressRequest.mVersionCode);
        zzb.zzc(parcel, 2, controlProgressRequest.zzakj);
        zzb.zzc(parcel, 3, controlProgressRequest.zzakk);
        zzb.zza(parcel, 4, controlProgressRequest.zzaiA, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcG(x0);
    }

    public ControlProgressRequest zzaZ(Parcel parcel) {
        int i = 0;
        int zzap = zza.zzap(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 4:
                    driveId = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new ControlProgressRequest(i3, i2, i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ControlProgressRequest[] zzcG(int i) {
        return new ControlProgressRequest[i];
    }
}
