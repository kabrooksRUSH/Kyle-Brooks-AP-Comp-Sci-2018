package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzm implements Creator<CreateFileIntentSenderRequest> {
    static void zza(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, createFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, createFileIntentSenderRequest.zzako, i, false);
        zzb.zzc(parcel, 3, createFileIntentSenderRequest.zzaiy);
        zzb.zza(parcel, 4, createFileIntentSenderRequest.zzajf, false);
        zzb.zza(parcel, 5, createFileIntentSenderRequest.zzaji, i, false);
        zzb.zza(parcel, 6, createFileIntentSenderRequest.zzakp, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcJ(x0);
    }

    public CreateFileIntentSenderRequest zzbb(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int zzap = zza.zzap(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzao, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    driveId = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    break;
                case 6:
                    num = zza.zzh(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public CreateFileIntentSenderRequest[] zzcJ(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
