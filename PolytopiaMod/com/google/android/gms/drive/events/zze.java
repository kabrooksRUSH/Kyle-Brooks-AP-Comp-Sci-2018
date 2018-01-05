package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;

public class zze implements Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, completionEvent.mVersionCode);
        zzb.zza(parcel, 2, completionEvent.zzaiA, i, false);
        zzb.zza(parcel, 3, completionEvent.zzRs, false);
        zzb.zza(parcel, 4, completionEvent.zzajC, i, false);
        zzb.zza(parcel, 5, completionEvent.zzajD, i, false);
        zzb.zza(parcel, 6, completionEvent.zzajE, i, false);
        zzb.zzb(parcel, 7, completionEvent.zzajF, false);
        zzb.zzc(parcel, 8, completionEvent.zzys);
        zzb.zza(parcel, 9, completionEvent.zzajG, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcu(x0);
    }

    public CompletionEvent zzaO(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzap = zza.zzap(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzao, DriveId.CREATOR);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zza.zza(parcel, zzao, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzao, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzao, MetadataBundle.CREATOR);
                    break;
                case 7:
                    list = zza.zzD(parcel, zzao);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 9:
                    iBinder = zza.zzq(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public CompletionEvent[] zzcu(int i) {
        return new CompletionEvent[i];
    }
}
