package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzc implements Creator<AuthorizeAccessRequest> {
    static void zza(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, authorizeAccessRequest.mVersionCode);
        zzb.zza(parcel, 2, authorizeAccessRequest.zzajX);
        zzb.zza(parcel, 3, authorizeAccessRequest.zzaiA, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcA(x0);
    }

    public AuthorizeAccessRequest zzaT(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzao);
                    break;
                case 3:
                    driveId = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public AuthorizeAccessRequest[] zzcA(int i) {
        return new AuthorizeAccessRequest[i];
    }
}
