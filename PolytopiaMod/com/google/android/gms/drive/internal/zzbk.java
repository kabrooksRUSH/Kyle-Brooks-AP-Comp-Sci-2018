package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbk implements Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, openContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, openContentsRequest.zzakc, i, false);
        zzb.zzc(parcel, 3, openContentsRequest.zzaiz);
        zzb.zzc(parcel, 4, openContentsRequest.zzamo);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdr(x0);
    }

    public OpenContentsRequest zzbF(Parcel parcel) {
        int i = 0;
        int zzap = zza.zzap(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzap) {
            DriveId driveId2;
            int zzg;
            int zzao = zza.zzao(parcel);
            int i4;
            switch (zza.zzbM(zzao)) {
                case 1:
                    i4 = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzao);
                    zzao = i4;
                    break;
                case 2:
                    zzg = i3;
                    i4 = i2;
                    driveId2 = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    zzao = i;
                    i = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    zzg = i3;
                    i4 = i;
                    i = zza.zzg(parcel, zzao);
                    zzao = i4;
                    break;
                case 4:
                    zzao = zza.zzg(parcel, zzao);
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzao = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
            }
            i3 = zzg;
            driveId = driveId2;
            i2 = i;
            i = zzao;
        }
        if (parcel.dataPosition() == zzap) {
            return new OpenContentsRequest(i3, driveId, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public OpenContentsRequest[] zzdr(int i) {
        return new OpenContentsRequest[i];
    }
}
