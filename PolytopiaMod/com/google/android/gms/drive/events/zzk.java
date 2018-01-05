package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<QueryResultEventParcelable> {
    static void zza(QueryResultEventParcelable queryResultEventParcelable, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, queryResultEventParcelable.mVersionCode);
        zzb.zza(parcel, 2, queryResultEventParcelable.zzabq, i, false);
        zzb.zza(parcel, 3, queryResultEventParcelable.zzajR);
        zzb.zzc(parcel, 4, queryResultEventParcelable.zzajS);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcw(x0);
    }

    public QueryResultEventParcelable zzaQ(Parcel parcel) {
        int i = 0;
        int zzap = zza.zzap(parcel);
        DataHolder dataHolder = null;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            boolean z2;
            DataHolder dataHolder2;
            int zzg;
            int zzao = zza.zzao(parcel);
            int i3;
            switch (zza.zzbM(zzao)) {
                case 1:
                    i3 = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzao);
                    zzao = i3;
                    break;
                case 2:
                    zzg = i2;
                    boolean z3 = z;
                    dataHolder2 = (DataHolder) zza.zza(parcel, zzao, DataHolder.CREATOR);
                    zzao = i;
                    z2 = z3;
                    break;
                case 3:
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    i3 = i;
                    z2 = zza.zzc(parcel, zzao);
                    zzao = i3;
                    break;
                case 4:
                    zzao = zza.zzg(parcel, zzao);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzao = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            dataHolder = dataHolder2;
            z = z2;
            i = zzao;
        }
        if (parcel.dataPosition() == zzap) {
            return new QueryResultEventParcelable(i2, dataHolder, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public QueryResultEventParcelable[] zzcw(int i) {
        return new QueryResultEventParcelable[i];
    }
}
