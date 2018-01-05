package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<ParcelableEvent> {
    static void zza(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, parcelableEvent.mVersionCode);
        zzb.zza(parcel, 2, parcelableEvent.zzHP, false);
        zzb.zza(parcel, 3, parcelableEvent.zzGY, false);
        zzb.zzb(parcel, 4, parcelableEvent.zzaoH, false);
        zzb.zza(parcel, 5, parcelableEvent.zzaoI);
        zzb.zza(parcel, 6, parcelableEvent.zzaoB, false);
        zzb.zza(parcel, 7, parcelableEvent.zzaoL, false);
        zzb.zza(parcel, 8, parcelableEvent.zzaoM, i, false);
        zzb.zza(parcel, 9, parcelableEvent.zzaoN, i, false);
        zzb.zza(parcel, 10, parcelableEvent.zzaoO, i, false);
        zzb.zza(parcel, 11, parcelableEvent.zzaoP, i, false);
        zzb.zza(parcel, 12, parcelableEvent.zzaoQ, i, false);
        zzb.zza(parcel, 13, parcelableEvent.zzaoR, i, false);
        zzb.zza(parcel, 14, parcelableEvent.zzaoS, i, false);
        zzb.zza(parcel, 15, parcelableEvent.zzaoT, i, false);
        zzb.zza(parcel, 17, parcelableEvent.zzaoK);
        zzb.zza(parcel, 16, parcelableEvent.zzaoJ);
        zzb.zza(parcel, 18, parcelableEvent.zzaoU, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzei(x0);
    }

    public ParcelableEvent zzcv(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        FieldChangedDetails fieldChangedDetails = null;
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
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 4:
                    list = zza.zzD(parcel, zzao);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 7:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) zza.zza(parcel, zzao, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) zza.zza(parcel, zzao, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) zza.zza(parcel, zzao, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) zza.zza(parcel, zzao, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) zza.zza(parcel, zzao, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) zza.zza(parcel, zzao, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) zza.zza(parcel, zzao, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) zza.zza(parcel, zzao, ObjectChangedDetails.CREATOR);
                    break;
                case 16:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 17:
                    z3 = zza.zzc(parcel, zzao);
                    break;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    fieldChangedDetails = (FieldChangedDetails) zza.zza(parcel, zzao, FieldChangedDetails.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new ParcelableEvent(i, str, str2, list, z, z2, z3, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails, fieldChangedDetails);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public ParcelableEvent[] zzei(int i) {
        return new ParcelableEvent[i];
    }
}
