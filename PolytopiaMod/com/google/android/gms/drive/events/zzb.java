package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<ChangesAvailableEvent> {
    static void zza(ChangesAvailableEvent changesAvailableEvent, Parcel parcel, int i) {
        int zzaq = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, changesAvailableEvent.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, changesAvailableEvent.zzRs, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, changesAvailableEvent.zzajx, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcs(x0);
    }

    public ChangesAvailableEvent zzaM(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    changesAvailableOptions = (ChangesAvailableOptions) zza.zza(parcel, zzao, ChangesAvailableOptions.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new ChangesAvailableEvent(i, str, changesAvailableOptions);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ChangesAvailableEvent[] zzcs(int i) {
        return new ChangesAvailableEvent[i];
    }
}
