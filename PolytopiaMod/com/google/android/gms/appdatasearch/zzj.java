package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<UsageInfo> {
    static void zza(UsageInfo usageInfo, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, usageInfo.zzQU, i, false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, usageInfo.mVersionCode);
        zzb.zza(parcel, 2, usageInfo.zzQV);
        zzb.zzc(parcel, 3, usageInfo.zzQW);
        zzb.zza(parcel, 4, usageInfo.zzub, false);
        zzb.zza(parcel, 5, usageInfo.zzQX, i, false);
        zzb.zza(parcel, 6, usageInfo.zzQY);
        zzb.zzc(parcel, 7, usageInfo.zzQZ);
        zzb.zzc(parcel, 8, usageInfo.zzRa);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzy(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzap(x0);
    }

    public UsageInfo[] zzap(int i) {
        return new UsageInfo[i];
    }

    public UsageInfo zzy(Parcel parcel) {
        DocumentContents documentContents = null;
        int i = 0;
        int zzap = zza.zzap(parcel);
        long j = 0;
        int i2 = -1;
        boolean z = false;
        String str = null;
        int i3 = 0;
        DocumentId documentId = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    documentId = (DocumentId) zza.zza(parcel, zzao, DocumentId.CREATOR);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzao);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    documentContents = (DocumentContents) zza.zza(parcel, zzao, DocumentContents.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzao);
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    i4 = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new UsageInfo(i4, documentId, j, i3, str, documentContents, z, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }
}
