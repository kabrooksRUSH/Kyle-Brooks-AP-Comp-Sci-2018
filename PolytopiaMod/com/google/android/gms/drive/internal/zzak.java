package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzak implements Creator<GetPermissionsRequest> {
    static void zza(GetPermissionsRequest getPermissionsRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, getPermissionsRequest.mVersionCode);
        zzb.zza(parcel, 2, getPermissionsRequest.zzaiA, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbm(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcY(x0);
    }

    public GetPermissionsRequest zzbm(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new GetPermissionsRequest(i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public GetPermissionsRequest[] zzcY(int i) {
        return new GetPermissionsRequest[i];
    }
}
