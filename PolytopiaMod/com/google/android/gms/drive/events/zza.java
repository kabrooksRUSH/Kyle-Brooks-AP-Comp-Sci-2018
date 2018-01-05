package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zza implements Creator<ChangeEvent> {
    static void zza(ChangeEvent changeEvent, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, changeEvent.mVersionCode);
        zzb.zza(parcel, 2, changeEvent.zzaiA, i, false);
        zzb.zzc(parcel, 3, changeEvent.zzajw);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcr(x0);
    }

    public ChangeEvent zzaL(Parcel parcel) {
        int i = 0;
        int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            DriveId driveId2;
            int zzg;
            int zzao = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(zzao)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzao);
                    zzao = i3;
                    break;
                case 2:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzao, DriveId.CREATOR);
                    zzao = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzao = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzao);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzao);
                    zzao = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = zzao;
        }
        if (parcel.dataPosition() == zzap) {
            return new ChangeEvent(i2, driveId, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ChangeEvent[] zzcr(int i) {
        return new ChangeEvent[i];
    }
}
