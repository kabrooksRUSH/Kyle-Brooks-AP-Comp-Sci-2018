package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbi implements Creator<OnStartStreamSession> {
    static void zza(OnStartStreamSession onStartStreamSession, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, onStartStreamSession.mVersionCode);
        zzb.zza(parcel, 2, onStartStreamSession.zzamm, i, false);
        zzb.zza(parcel, 3, onStartStreamSession.zzamn, false);
        zzb.zza(parcel, 4, onStartStreamSession.zzrW, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdp(x0);
    }

    public OnStartStreamSession zzbD(Parcel parcel) {
        String str = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        IBinder iBinder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzap) {
            IBinder iBinder2;
            ParcelFileDescriptor parcelFileDescriptor2;
            int zzg;
            String str2;
            int zzao = zza.zzao(parcel);
            String str3;
            switch (zza.zzbM(zzao)) {
                case 1:
                    str3 = str;
                    iBinder2 = iBinder;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = zza.zzg(parcel, zzao);
                    str2 = str3;
                    break;
                case 2:
                    zzg = i;
                    IBinder iBinder3 = iBinder;
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zza.zza(parcel, zzao, ParcelFileDescriptor.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case 3:
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i;
                    str3 = str;
                    iBinder2 = zza.zzq(parcel, zzao);
                    str2 = str3;
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzao);
                    iBinder2 = iBinder;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    str2 = str;
                    iBinder2 = iBinder;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i;
                    break;
            }
            i = zzg;
            parcelFileDescriptor = parcelFileDescriptor2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzap) {
            return new OnStartStreamSession(i, parcelFileDescriptor, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public OnStartStreamSession[] zzdp(int i) {
        return new OnStartStreamSession[i];
    }
}
