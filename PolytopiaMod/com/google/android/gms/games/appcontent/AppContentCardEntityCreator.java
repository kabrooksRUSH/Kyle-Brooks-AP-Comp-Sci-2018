package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
    static void zza(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, appContentCardEntity.getActions(), false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, appContentCardEntity.getVersionCode());
        zzb.zzc(parcel, 2, appContentCardEntity.zzua(), false);
        zzb.zzc(parcel, 3, appContentCardEntity.zztP(), false);
        zzb.zza(parcel, 4, appContentCardEntity.zztQ(), false);
        zzb.zzc(parcel, 5, appContentCardEntity.zzub());
        zzb.zza(parcel, 6, appContentCardEntity.getDescription(), false);
        zzb.zza(parcel, 7, appContentCardEntity.getExtras(), false);
        zzb.zza(parcel, 10, appContentCardEntity.zzuc(), false);
        zzb.zza(parcel, 11, appContentCardEntity.getTitle(), false);
        zzb.zzc(parcel, 12, appContentCardEntity.zzud());
        zzb.zza(parcel, 13, appContentCardEntity.getType(), false);
        zzb.zza(parcel, 14, appContentCardEntity.getId(), false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfN(x0);
    }

    public AppContentCardEntity zzdU(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzao, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    arrayList2 = zza.zzc(parcel, zzao, AppContentAnnotationEntity.CREATOR);
                    break;
                case 3:
                    arrayList3 = zza.zzc(parcel, zzao, AppContentConditionEntity.CREATOR);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 7:
                    bundle = zza.zzr(parcel, zzao);
                    break;
                case 10:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 11:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 13:
                    str5 = zza.zzp(parcel, zzao);
                    break;
                case 14:
                    str6 = zza.zzp(parcel, zzao);
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    i = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, str3, str4, i3, str5, str6);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public AppContentCardEntity[] zzfN(int i) {
        return new AppContentCardEntity[i];
    }
}
