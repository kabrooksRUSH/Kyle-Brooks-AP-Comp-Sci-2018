package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzaw implements Creator<OnContentsResponse> {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, onContentsResponse.mVersionCode);
        zzb.zza(parcel, 2, onContentsResponse.zzakR, i, false);
        zzb.zza(parcel, 3, onContentsResponse.zzalX);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdd(x0);
    }

    public OnContentsResponse zzbr(Parcel parcel) {
        boolean z = false;
        int zzap = zza.zzap(parcel);
        Contents contents = null;
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            Contents contents2;
            int zzg;
            boolean z2;
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    boolean z3 = z;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzao);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    Contents contents3 = (Contents) zza.zza(parcel, zzao, Contents.CREATOR);
                    z2 = z;
                    contents2 = contents3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzao);
                    contents2 = contents;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    z2 = z;
                    contents2 = contents;
                    zzg = i;
                    break;
            }
            i = zzg;
            contents = contents2;
            z = z2;
        }
        if (parcel.dataPosition() == zzap) {
            return new OnContentsResponse(i, contents, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public OnContentsResponse[] zzdd(int i) {
        return new OnContentsResponse[i];
    }
}
