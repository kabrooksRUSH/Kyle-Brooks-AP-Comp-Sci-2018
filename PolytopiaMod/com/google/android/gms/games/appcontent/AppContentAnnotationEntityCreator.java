package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AppContentAnnotationEntityCreator implements Creator<AppContentAnnotationEntity> {
    static void zza(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, appContentAnnotationEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentAnnotationEntity.zztV(), i, false);
        zzb.zza(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        zzb.zza(parcel, 5, appContentAnnotationEntity.getId(), false);
        zzb.zza(parcel, 6, appContentAnnotationEntity.zztY(), false);
        zzb.zza(parcel, 7, appContentAnnotationEntity.zztT(), false);
        zzb.zzc(parcel, 8, appContentAnnotationEntity.zztU());
        zzb.zzc(parcel, 9, appContentAnnotationEntity.zztX());
        zzb.zza(parcel, 10, appContentAnnotationEntity.zztW(), false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfM(x0);
    }

    public AppContentAnnotationEntity zzdT(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzap = zza.zzap(parcel);
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    str5 = zza.zzp(parcel, zzao);
                    break;
                case 2:
                    uri = (Uri) zza.zza(parcel, zzao, Uri.CREATOR);
                    break;
                case 3:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 9:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 10:
                    bundle = zza.zzr(parcel, zzao);
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new AppContentAnnotationEntity(i3, str5, uri, str4, str3, str2, str, i2, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public AppContentAnnotationEntity[] zzfM(int i) {
        return new AppContentAnnotationEntity[i];
    }
}
