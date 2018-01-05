package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class zzar implements Creator<LoadRealtimeRequest> {
    static void zza(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, loadRealtimeRequest.mVersionCode);
        zzb.zza(parcel, 2, loadRealtimeRequest.zzaiA, i, false);
        zzb.zza(parcel, 3, loadRealtimeRequest.zzalI);
        zzb.zzb(parcel, 4, loadRealtimeRequest.zzalJ, false);
        zzb.zza(parcel, 5, loadRealtimeRequest.zzalK);
        zzb.zza(parcel, 6, loadRealtimeRequest.zzalL, i, false);
        zzb.zza(parcel, 7, loadRealtimeRequest.zzalM, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdb(x0);
    }

    public LoadRealtimeRequest zzbp(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzap = zza.zzap(parcel);
        DataHolder dataHolder = null;
        List list = null;
        boolean z2 = false;
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
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 4:
                    list = zza.zzD(parcel, zzao);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 6:
                    dataHolder = (DataHolder) zza.zza(parcel, zzao, DataHolder.CREATOR);
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
            return new LoadRealtimeRequest(i, driveId, z2, list, z, dataHolder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public LoadRealtimeRequest[] zzdb(int i) {
        return new LoadRealtimeRequest[i];
    }
}
