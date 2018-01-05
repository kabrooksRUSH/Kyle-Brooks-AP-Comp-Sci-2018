package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

public class zzah implements Creator<GetChangesRequest> {
    static void zza(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, getChangesRequest.mVersionCode);
        zzb.zza(parcel, 2, getChangesRequest.zzalA, i, false);
        zzb.zzc(parcel, 3, getChangesRequest.zzalB);
        zzb.zzc(parcel, 4, getChangesRequest.zzajA, false);
        zzb.zza(parcel, 5, getChangesRequest.zzalC);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcV(x0);
    }

    public GetChangesRequest zzbj(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzap = zza.zzap(parcel);
        int i = 0;
        ChangeSequenceNumber changeSequenceNumber = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    changeSequenceNumber = (ChangeSequenceNumber) zza.zza(parcel, zzao, ChangeSequenceNumber.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzao, DriveSpace.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new GetChangesRequest(i2, changeSequenceNumber, i, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public GetChangesRequest[] zzcV(int i) {
        return new GetChangesRequest[i];
    }
}
