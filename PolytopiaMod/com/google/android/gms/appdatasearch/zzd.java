package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<DocumentSection> {
    static void zza(DocumentSection documentSection, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, documentSection.zzQj, false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, documentSection.mVersionCode);
        zzb.zza(parcel, 3, documentSection.zzQk, i, false);
        zzb.zzc(parcel, 4, documentSection.zzQl);
        zzb.zza(parcel, 5, documentSection.zzQm, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzag(x0);
    }

    public DocumentSection[] zzag(int i) {
        return new DocumentSection[i];
    }

    public DocumentSection zzt(Parcel parcel) {
        byte[] bArr = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        int i2 = -1;
        RegisterSectionInfo registerSectionInfo = null;
        String str = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    registerSectionInfo = (RegisterSectionInfo) zza.zza(parcel, zzao, RegisterSectionInfo.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 5:
                    bArr = zza.zzs(parcel, zzao);
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
            return new DocumentSection(i, str, registerSectionInfo, i2, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }
}
