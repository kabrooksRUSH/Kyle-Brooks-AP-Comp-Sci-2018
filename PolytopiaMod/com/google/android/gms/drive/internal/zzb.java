package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class zzb implements Creator<AddPermissionRequest> {
    static void zza(AddPermissionRequest addPermissionRequest, Parcel parcel, int i) {
        int zzaq = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addPermissionRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, addPermissionRequest.zzaiA, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, addPermissionRequest.zzajT, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addPermissionRequest.zzajU);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addPermissionRequest.zzajV, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, addPermissionRequest.zzajW);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, addPermissionRequest.zzaiX, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcz(x0);
    }

    public AddPermissionRequest zzaS(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzap = zza.zzap(parcel);
        String str2 = null;
        boolean z2 = false;
        Permission permission = null;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    break;
                case 3:
                    permission = (Permission) zza.zza(parcel, zzao, Permission.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new AddPermissionRequest(i, driveId, permission, z2, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public AddPermissionRequest[] zzcz(int i) {
        return new AddPermissionRequest[i];
    }
}
