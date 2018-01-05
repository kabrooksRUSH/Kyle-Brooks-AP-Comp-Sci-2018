package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzbq implements Creator<SetDrivePreferencesRequest> {
    static void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, setDrivePreferencesRequest.mVersionCode);
        zzb.zza(parcel, 2, setDrivePreferencesRequest.zzamd, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdw(x0);
    }

    public SetDrivePreferencesRequest zzbK(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) zza.zza(parcel, zzao, DrivePreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new SetDrivePreferencesRequest(i, drivePreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public SetDrivePreferencesRequest[] zzdw(int i) {
        return new SetDrivePreferencesRequest[i];
    }
}
