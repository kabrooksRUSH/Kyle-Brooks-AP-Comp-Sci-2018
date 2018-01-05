package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@zzgr
public final class zzfa {

    static /* synthetic */ class C06171 {
        static final /* synthetic */ int[] zzzT = new int[Gender.values().length];

        static {
            zzzU = new int[ErrorCode.values().length];
            try {
                zzzU[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzzU[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzzU[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzzU[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zzzT[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                zzzT[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                zzzT[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int zza(ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize zzb(AdSizeParcel adSizeParcel) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < adSizeArr.length) {
            if (adSizeArr[i].getWidth() == adSizeParcel.width && adSizeArr[i].getHeight() == adSizeParcel.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(zza.zza(adSizeParcel.width, adSizeParcel.height, adSizeParcel.zzte));
    }

    public static MediationAdRequest zzh(AdRequestParcel adRequestParcel) {
        return new MediationAdRequest(new Date(adRequestParcel.zzsB), zzr(adRequestParcel.zzsC), adRequestParcel.zzsD != null ? new HashSet(adRequestParcel.zzsD) : null, adRequestParcel.zzsE, adRequestParcel.zzsJ);
    }

    public static Gender zzr(int i) {
        switch (i) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
