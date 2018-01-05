package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

public class zza implements Creator<AddEventListenerRequest> {
    static void zza(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, addEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, addEventListenerRequest.zzaiA, i, false);
        zzb.zzc(parcel, 3, addEventListenerRequest.zzaho);
        zzb.zza(parcel, 4, addEventListenerRequest.zzajx, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcy(x0);
    }

    public AddEventListenerRequest zzaR(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions = null;
        int i = 0;
        int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            int i3;
            DriveId driveId2;
            int zzg;
            ChangesAvailableOptions changesAvailableOptions2;
            int zzao = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
            ChangesAvailableOptions changesAvailableOptions3;
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(zzao)) {
                case 1:
                    changesAvailableOptions3 = changesAvailableOptions;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzao);
                    changesAvailableOptions2 = changesAvailableOptions3;
                    break;
                case 2:
                    zzg = i2;
                    int i4 = i;
                    driveId2 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzao, DriveId.CREATOR);
                    changesAvailableOptions2 = changesAvailableOptions;
                    i3 = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    zzg = i2;
                    changesAvailableOptions3 = changesAvailableOptions;
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzao);
                    changesAvailableOptions2 = changesAvailableOptions3;
                    break;
                case 4:
                    changesAvailableOptions2 = (ChangesAvailableOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzao, ChangesAvailableOptions.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzao);
                    changesAvailableOptions2 = changesAvailableOptions;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = i3;
            changesAvailableOptions = changesAvailableOptions2;
        }
        if (parcel.dataPosition() == zzap) {
            return new AddEventListenerRequest(i2, driveId, i, changesAvailableOptions);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public AddEventListenerRequest[] zzcy(int i) {
        return new AddEventListenerRequest[i];
    }
}
