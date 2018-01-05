package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzk implements Creator<LogicalFilter> {
    static void zza(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, logicalFilter.mVersionCode);
        zzb.zza(parcel, 1, logicalFilter.zzanV, i, false);
        zzb.zzc(parcel, 2, logicalFilter.zzaok, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdV(x0);
    }

    public LogicalFilter zzcj(Parcel parcel) {
        List list = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < zzap) {
            int i2;
            Operator operator2;
            ArrayList zzc;
            int zzao = zza.zzao(parcel);
            List list2;
            switch (zza.zzbM(zzao)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) zza.zza(parcel, zzao, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzao, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    List list3 = list;
                    operator2 = operator;
                    i2 = zza.zzg(parcel, zzao);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzc = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzap) {
            return new LogicalFilter(i, operator, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public LogicalFilter[] zzdV(int i) {
        return new LogicalFilter[i];
    }
}
