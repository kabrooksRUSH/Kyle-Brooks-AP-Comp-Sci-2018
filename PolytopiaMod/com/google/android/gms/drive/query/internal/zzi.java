package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzi implements Creator<HasFilter> {
    static void zza(HasFilter hasFilter, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, hasFilter.mVersionCode);
        zzb.zza(parcel, 1, hasFilter.zzanW, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzch(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdT(x0);
    }

    public HasFilter zzch(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzao, MetadataBundle.CREATOR);
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
            return new HasFilter(i, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public HasFilter[] zzdT(int i) {
        return new HasFilter[i];
    }
}