package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveFileRange;
import java.util.List;

public class zzay implements Creator<OnDownloadProgressResponse> {
    static void zza(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, onDownloadProgressResponse.mVersionCode);
        zzb.zza(parcel, 2, onDownloadProgressResponse.zzama);
        zzb.zza(parcel, 3, onDownloadProgressResponse.zzamb);
        zzb.zzc(parcel, 4, onDownloadProgressResponse.zzys);
        zzb.zzc(parcel, 5, onDownloadProgressResponse.zzamc, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdf(x0);
    }

    public OnDownloadProgressResponse zzbt(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzap = zza.zzap(parcel);
        List list = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzao);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzao);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzao, DriveFileRange.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new OnDownloadProgressResponse(i2, j2, j, i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public OnDownloadProgressResponse[] zzdf(int i) {
        return new OnDownloadProgressResponse[i];
    }
}
