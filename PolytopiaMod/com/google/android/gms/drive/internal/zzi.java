package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzi implements Creator<CloseContentsRequest> {
    static void zza(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, closeContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, closeContentsRequest.zzake, i, false);
        zzb.zza(parcel, 3, closeContentsRequest.zzaki, false);
        zzb.zzc(parcel, 4, closeContentsRequest.zzakg);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcF(x0);
    }

    public CloseContentsRequest zzaY(Parcel parcel) {
        Boolean bool = null;
        int i = 0;
        int zzap = zza.zzap(parcel);
        Contents contents = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            Boolean bool2;
            Contents contents2;
            int zzg;
            int zzao = zza.zzao(parcel);
            int i3;
            switch (zza.zzbM(zzao)) {
                case 1:
                    i3 = i;
                    bool2 = bool;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzao);
                    zzao = i3;
                    break;
                case 2:
                    zzg = i2;
                    Boolean bool3 = bool;
                    contents2 = (Contents) zza.zza(parcel, zzao, Contents.CREATOR);
                    zzao = i;
                    bool2 = bool3;
                    break;
                case 3:
                    contents2 = contents;
                    zzg = i2;
                    i3 = i;
                    bool2 = zza.zzd(parcel, zzao);
                    zzao = i3;
                    break;
                case 4:
                    zzao = zza.zzg(parcel, zzao);
                    bool2 = bool;
                    contents2 = contents;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzao = i;
                    bool2 = bool;
                    contents2 = contents;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            contents = contents2;
            bool = bool2;
            i = zzao;
        }
        if (parcel.dataPosition() == zzap) {
            return new CloseContentsRequest(i2, contents, bool, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public CloseContentsRequest[] zzcF(int i) {
        return new CloseContentsRequest[i];
    }
}
