package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Creator<ResolveAccountRequest> {
    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, resolveAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, resolveAccountRequest.getAccount(), i, false);
        zzb.zzc(parcel, 3, resolveAccountRequest.getSessionId());
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzal(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbJ(x0);
    }

    public ResolveAccountRequest zzal(Parcel parcel) {
        int i = 0;
        int zzap = zza.zzap(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            Account account2;
            int zzg;
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    int i3 = i;
                    account2 = account;
                    zzg = zza.zzg(parcel, zzao);
                    zzao = i3;
                    break;
                case 2:
                    zzg = i2;
                    Account account3 = (Account) zza.zza(parcel, zzao, Account.CREATOR);
                    zzao = i;
                    account2 = account3;
                    break;
                case 3:
                    zzao = zza.zzg(parcel, zzao);
                    account2 = account;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzao = i;
                    account2 = account;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            account = account2;
            i = zzao;
        }
        if (parcel.dataPosition() == zzap) {
            return new ResolveAccountRequest(i2, account, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ResolveAccountRequest[] zzbJ(int i) {
        return new ResolveAccountRequest[i];
    }
}
