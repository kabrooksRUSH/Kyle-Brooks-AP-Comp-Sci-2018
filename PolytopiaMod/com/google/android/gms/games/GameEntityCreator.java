package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.adobe.air.AndroidActivityWrapper.FlashPermission;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GameEntityCreator implements Creator<GameEntity> {
    static void zza(GameEntity gameEntity, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, gameEntity.getApplicationId(), false);
        zzb.zza(parcel, 2, gameEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, gameEntity.getPrimaryCategory(), false);
        zzb.zza(parcel, 4, gameEntity.getSecondaryCategory(), false);
        zzb.zza(parcel, 5, gameEntity.getDescription(), false);
        zzb.zza(parcel, 6, gameEntity.getDeveloperName(), false);
        zzb.zza(parcel, 7, gameEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        zzb.zza(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        zzb.zza(parcel, 10, gameEntity.zztx());
        zzb.zza(parcel, 11, gameEntity.zztz());
        zzb.zza(parcel, 12, gameEntity.zztA(), false);
        zzb.zzc(parcel, 13, gameEntity.zztB());
        zzb.zzc(parcel, 14, gameEntity.getAchievementTotalCount());
        zzb.zzc(parcel, 15, gameEntity.getLeaderboardCount());
        zzb.zza(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        zzb.zza(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, gameEntity.getVersionCode());
        zzb.zza(parcel, 19, gameEntity.getHiResImageUrl(), false);
        zzb.zza(parcel, 18, gameEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 21, gameEntity.isMuted());
        zzb.zza(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        zzb.zza(parcel, 23, gameEntity.areSnapshotsEnabled());
        zzb.zza(parcel, 22, gameEntity.zzty());
        zzb.zza(parcel, 25, gameEntity.hasGamepadSupport());
        zzb.zza(parcel, 24, gameEntity.getThemeColor(), false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfF(x0);
    }

    public GameEntity zzdN(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
        boolean z8 = false;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 4:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    str5 = zza.zzp(parcel, zzao);
                    break;
                case 6:
                    str6 = zza.zzp(parcel, zzao);
                    break;
                case 7:
                    uri = (Uri) zza.zza(parcel, zzao, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) zza.zza(parcel, zzao, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) zza.zza(parcel, zzao, Uri.CREATOR);
                    break;
                case 10:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 11:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 12:
                    str7 = zza.zzp(parcel, zzao);
                    break;
                case 13:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 14:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 15:
                    i4 = zza.zzg(parcel, zzao);
                    break;
                case 16:
                    z3 = zza.zzc(parcel, zzao);
                    break;
                case 17:
                    z4 = zza.zzc(parcel, zzao);
                    break;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    str8 = zza.zzp(parcel, zzao);
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    str9 = zza.zzp(parcel, zzao);
                    break;
                case 20:
                    str10 = zza.zzp(parcel, zzao);
                    break;
                case 21:
                    z5 = zza.zzc(parcel, zzao);
                    break;
                case FlashPermission.CAMERA_ROLL /*22*/:
                    z6 = zza.zzc(parcel, zzao);
                    break;
                case 23:
                    z7 = zza.zzc(parcel, zzao);
                    break;
                case 24:
                    str11 = zza.zzp(parcel, zzao);
                    break;
                case 25:
                    z8 = zza.zzc(parcel, zzao);
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    i = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11, z8);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public GameEntity[] zzfF(int i) {
        return new GameEntity[i];
    }
}
