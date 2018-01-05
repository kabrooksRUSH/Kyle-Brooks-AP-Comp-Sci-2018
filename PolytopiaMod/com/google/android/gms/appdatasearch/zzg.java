package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<Response> {
    static void zza(Response response, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, response.mVersionCode);
        zzb.zza(parcel, 1, response.zzQA, i, false);
        zzb.zzc(parcel, 2, response.zzQB, false);
        zzb.zza(parcel, 3, response.zzQC, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaj(x0);
    }

    public Response[] zzaj(int i) {
        return new Response[i];
    }

    public Response zzw(Parcel parcel) {
        String[] strArr = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        List list = null;
        Status status = null;
        while (parcel.dataPosition() < zzap) {
            int i2;
            Status status2;
            String[] strArr2;
            List list2;
            int zzao = zza.zzao(parcel);
            String[] strArr3;
            switch (zza.zzbM(zzao)) {
                case 1:
                    i2 = i;
                    List list3 = list;
                    status2 = (Status) zza.zza(parcel, zzao, Status.CREATOR);
                    strArr2 = strArr;
                    list2 = list3;
                    break;
                case 2:
                    status2 = status;
                    i2 = i;
                    strArr3 = strArr;
                    Object zzc = zza.zzc(parcel, zzao, UsageInfo.CREATOR);
                    strArr2 = strArr3;
                    break;
                case 3:
                    strArr2 = zza.zzB(parcel, zzao);
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    strArr3 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzao);
                    strArr2 = strArr3;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    strArr2 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            list = list2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == zzap) {
            return new Response(i, status, list, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }
}
