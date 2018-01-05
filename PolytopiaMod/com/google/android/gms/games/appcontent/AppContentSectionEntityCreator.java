package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
    static void zza(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, appContentSectionEntity.getActions(), false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, appContentSectionEntity.getVersionCode());
        zzb.zzc(parcel, 3, appContentSectionEntity.zzuk(), false);
        zzb.zza(parcel, 4, appContentSectionEntity.zztQ(), false);
        zzb.zza(parcel, 5, appContentSectionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentSectionEntity.zzuc(), false);
        zzb.zza(parcel, 7, appContentSectionEntity.getTitle(), false);
        zzb.zza(parcel, 8, appContentSectionEntity.getType(), false);
        zzb.zza(parcel, 9, appContentSectionEntity.getId(), false);
        zzb.zza(parcel, 10, appContentSectionEntity.zzul(), false);
        zzb.zzc(parcel, 14, appContentSectionEntity.zzua(), false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfP(x0);
    }

    public AppContentSectionEntity zzdW(Parcel parcel) {
        ArrayList arrayList = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Bundle bundle = null;
        String str6 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    arrayList3 = zza.zzc(parcel, zzao, AppContentActionEntity.CREATOR);
                    break;
                case 3:
                    arrayList2 = zza.zzc(parcel, zzao, AppContentCardEntity.CREATOR);
                    break;
                case 4:
                    str6 = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    bundle = zza.zzr(parcel, zzao);
                    break;
                case 6:
                    str5 = zza.zzp(parcel, zzao);
                    break;
                case 7:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 8:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 9:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 10:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 14:
                    arrayList = zza.zzc(parcel, zzao, AppContentAnnotationEntity.CREATOR);
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
            return new AppContentSectionEntity(i, arrayList3, arrayList2, str6, bundle, str5, str4, str3, str2, str, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public AppContentSectionEntity[] zzfP(int i) {
        return new AppContentSectionEntity[i];
    }
}
