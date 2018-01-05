package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.query.Query;

public class zzbn implements Creator<QueryRequest> {
    static void zza(QueryRequest queryRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, queryRequest.mVersionCode);
        zzb.zza(parcel, 2, queryRequest.zzamr, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdt(x0);
    }

    public QueryRequest zzbH(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    query = (Query) zza.zza(parcel, zzao, Query.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new QueryRequest(i, query);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public QueryRequest[] zzdt(int i) {
        return new QueryRequest[i];
    }
}
