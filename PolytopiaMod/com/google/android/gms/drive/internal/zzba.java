package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzba implements Creator<OnDrivePreferencesResponse> {
    static void zza(OnDrivePreferencesResponse onDrivePreferencesResponse, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, onDrivePreferencesResponse.mVersionCode);
        zzb.zza(parcel, 2, onDrivePreferencesResponse.zzamd, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdh(x0);
    }

    public OnDrivePreferencesResponse zzbv(Parcel parcel) {
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
            return new OnDrivePreferencesResponse(i, drivePreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public OnDrivePreferencesResponse[] zzdh(int i) {
        return new OnDrivePreferencesResponse[i];
    }
}
