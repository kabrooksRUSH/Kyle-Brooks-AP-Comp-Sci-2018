package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzh implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, closeContentsAndUpdateMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, closeContentsAndUpdateMetadataRequest.zzakc, i, false);
        zzb.zza(parcel, 3, closeContentsAndUpdateMetadataRequest.zzakd, i, false);
        zzb.zza(parcel, 4, closeContentsAndUpdateMetadataRequest.zzake, i, false);
        zzb.zza(parcel, 5, closeContentsAndUpdateMetadataRequest.zzaiY);
        zzb.zza(parcel, 6, closeContentsAndUpdateMetadataRequest.zzaiX, false);
        zzb.zzc(parcel, 7, closeContentsAndUpdateMetadataRequest.zzakf);
        zzb.zzc(parcel, 8, closeContentsAndUpdateMetadataRequest.zzakg);
        zzb.zza(parcel, 9, closeContentsAndUpdateMetadataRequest.zzakh);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcE(x0);
    }

    public CloseContentsAndUpdateMetadataRequest zzaX(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzap = zza.zzap(parcel);
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
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
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new CloseContentsAndUpdateMetadataRequest(i3, driveId, metadataBundle, contents, z2, str, i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] zzcE(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
