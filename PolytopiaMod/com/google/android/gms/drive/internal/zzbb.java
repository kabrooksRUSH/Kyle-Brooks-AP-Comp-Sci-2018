package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class zzbb implements Creator<OnEventResponse> {
    static void zza(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, onEventResponse.mVersionCode);
        zzb.zzc(parcel, 2, onEventResponse.zzaho);
        zzb.zza(parcel, 3, onEventResponse.zzame, i, false);
        zzb.zza(parcel, 5, onEventResponse.zzamf, i, false);
        zzb.zza(parcel, 6, onEventResponse.zzamg, i, false);
        zzb.zza(parcel, 7, onEventResponse.zzamh, i, false);
        zzb.zza(parcel, 8, onEventResponse.zzami, i, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdi(x0);
    }

    public OnEventResponse zzbw(Parcel parcel) {
        int i = 0;
        ProgressEvent progressEvent = null;
        int zzap = zza.zzap(parcel);
        ChangesAvailableEvent changesAvailableEvent = null;
        QueryResultEventParcelable queryResultEventParcelable = null;
        CompletionEvent completionEvent = null;
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 3:
                    changeEvent = (ChangeEvent) zza.zza(parcel, zzao, ChangeEvent.CREATOR);
                    break;
                case 5:
                    completionEvent = (CompletionEvent) zza.zza(parcel, zzao, CompletionEvent.CREATOR);
                    break;
                case 6:
                    queryResultEventParcelable = (QueryResultEventParcelable) zza.zza(parcel, zzao, QueryResultEventParcelable.CREATOR);
                    break;
                case 7:
                    changesAvailableEvent = (ChangesAvailableEvent) zza.zza(parcel, zzao, ChangesAvailableEvent.CREATOR);
                    break;
                case 8:
                    progressEvent = (ProgressEvent) zza.zza(parcel, zzao, ProgressEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new OnEventResponse(i2, i, changeEvent, completionEvent, queryResultEventParcelable, changesAvailableEvent, progressEvent);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public OnEventResponse[] zzdi(int i) {
        return new OnEventResponse[i];
    }
}
