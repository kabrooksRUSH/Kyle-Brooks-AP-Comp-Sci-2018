package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzn implements Creator<CreateFileRequest> {
    static void zza(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, createFileRequest.mVersionCode);
        zzb.zza(parcel, 2, createFileRequest.zzakq, i, false);
        zzb.zza(parcel, 3, createFileRequest.zzako, i, false);
        zzb.zza(parcel, 4, createFileRequest.zzake, i, false);
        zzb.zza(parcel, 5, createFileRequest.zzakp, false);
        zzb.zza(parcel, 6, createFileRequest.zzajW);
        zzb.zza(parcel, 7, createFileRequest.zzaiX, false);
        zzb.zzc(parcel, 8, createFileRequest.zzakr);
        zzb.zzc(parcel, 9, createFileRequest.zzaks);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcK(x0);
    }

    public CreateFileRequest zzbc(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzap = zza.zzap(parcel);
        int i2 = 0;
        boolean z = false;
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzao, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) zza.zza(parcel, zzao, Contents.CREATOR);
                    break;
                case 5:
                    num = zza.zzh(parcel, zzao);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzao);
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
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public CreateFileRequest[] zzcK(int i) {
        return new CreateFileRequest[i];
    }
}
