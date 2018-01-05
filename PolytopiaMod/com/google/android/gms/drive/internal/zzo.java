package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzo implements Creator<CreateFolderRequest> {
    static void zza(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, createFolderRequest.mVersionCode);
        zzb.zza(parcel, 2, createFolderRequest.zzakq, i, false);
        zzb.zza(parcel, 3, createFolderRequest.zzako, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcL(x0);
    }

    public CreateFolderRequest zzbd(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzap) {
            DriveId driveId2;
            int zzg;
            MetadataBundle metadataBundle2;
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzao);
                    metadataBundle2 = metadataBundle3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case 3:
                    metadataBundle2 = (MetadataBundle) zza.zza(parcel, zzao, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == zzap) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public CreateFolderRequest[] zzcL(int i) {
        return new CreateFolderRequest[i];
    }
}
