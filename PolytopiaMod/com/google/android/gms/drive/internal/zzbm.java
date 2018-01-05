package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class zzbm implements Creator<OpenFileIntentSenderRequest> {
    static void zza(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, openFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, openFileIntentSenderRequest.zzajf, false);
        zzb.zza(parcel, 3, openFileIntentSenderRequest.zzajg, false);
        zzb.zza(parcel, 4, openFileIntentSenderRequest.zzaji, i, false);
        zzb.zza(parcel, 5, openFileIntentSenderRequest.zzamq, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzds(x0);
    }

    public OpenFileIntentSenderRequest zzbG(Parcel parcel) {
        FilterHolder filterHolder = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        DriveId driveId = null;
        String[] strArr = null;
        String str = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    strArr = zza.zzB(parcel, zzao);
                    break;
                case 4:
                    driveId = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    break;
                case 5:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzao, FilterHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId, filterHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public OpenFileIntentSenderRequest[] zzds(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
