package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zzmo;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
    private final String mName;
    private final int mVersionCode;
    private final String zzTa;
    private final String zzYf;
    private final String zzajf;
    private final String zzatF;
    private final String zzatG;
    private final long zzatZ;
    private final Uri zzatu;
    private final Uri zzatv;
    private final int zzaua;
    private final long zzaub;
    private final MostRecentGameInfoEntity zzauc;
    private final PlayerLevelInfo zzaud;
    private final boolean zzaue;
    private final boolean zzauf;
    private final String zzaug;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdO(x0);
        }

        public PlayerEntity zzdO(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzoT()) || DowngradeableSafeParcel.zzck(PlayerEntity.class.getCanonicalName())) {
                return super.zzdO(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(12, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null, null, null, null, true, false, parcel.readString(), parcel.readString());
        }
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl, String title, MostRecentGameInfoEntity mostRecentGameInfo, PlayerLevelInfo playerLevelInfo, boolean isProfileVisible, boolean hasDebugAccess, String gamerTag, String name) {
        this.mVersionCode = versionCode;
        this.zzYf = playerId;
        this.zzTa = displayName;
        this.zzatu = iconImageUri;
        this.zzatF = iconImageUrl;
        this.zzatv = hiResImageUri;
        this.zzatG = hiResImageUrl;
        this.zzatZ = retrievedTimestamp;
        this.zzaua = isInCircles;
        this.zzaub = lastPlayedWithTimestamp;
        this.zzajf = title;
        this.zzaue = isProfileVisible;
        this.zzauc = mostRecentGameInfo;
        this.zzaud = playerLevelInfo;
        this.zzauf = hasDebugAccess;
        this.zzaug = gamerTag;
        this.mName = name;
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean isPlusEnabled) {
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        this.mVersionCode = 12;
        this.zzYf = isPlusEnabled ? player.getPlayerId() : null;
        this.zzTa = player.getDisplayName();
        this.zzatu = player.getIconImageUri();
        this.zzatF = player.getIconImageUrl();
        this.zzatv = player.getHiResImageUri();
        this.zzatG = player.getHiResImageUrl();
        this.zzatZ = player.getRetrievedTimestamp();
        this.zzaua = player.zztG();
        this.zzaub = player.getLastPlayedWithTimestamp();
        this.zzajf = player.getTitle();
        this.zzaue = player.zztH();
        MostRecentGameInfo zztI = player.zztI();
        if (zztI != null) {
            mostRecentGameInfoEntity = new MostRecentGameInfoEntity(zztI);
        }
        this.zzauc = mostRecentGameInfoEntity;
        this.zzaud = player.getLevelInfo();
        this.zzauf = player.zztF();
        this.zzaug = player.zztE();
        this.mName = player.getName();
        if (isPlusEnabled) {
            zzb.zzs(this.zzYf);
        }
        zzb.zzs(this.zzTa);
        zzb.zzZ(this.zzatZ > 0);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzw.equal(player2.getPlayerId(), player.getPlayerId()) && zzw.equal(player2.getDisplayName(), player.getDisplayName()) && zzw.equal(Boolean.valueOf(player2.zztF()), Boolean.valueOf(player.zztF())) && zzw.equal(player2.getIconImageUri(), player.getIconImageUri()) && zzw.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && zzw.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && zzw.equal(player2.getTitle(), player.getTitle()) && zzw.equal(player2.getLevelInfo(), player.getLevelInfo()) && zzw.equal(player2.zztE(), player.zztE()) && zzw.equal(player2.getName(), player.getName());
    }

    static int zzb(Player player) {
        return zzw.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zztF()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zztE(), player.getName());
    }

    static String zzc(Player player) {
        return zzw.zzv(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zztF())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).zzg("GamerTag", player.zztE()).zzg("Name", player.getName()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.zzTa;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzTa, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.zzatv;
    }

    public String getHiResImageUrl() {
        return this.zzatG;
    }

    public Uri getIconImageUri() {
        return this.zzatu;
    }

    public String getIconImageUrl() {
        return this.zzatF;
    }

    public long getLastPlayedWithTimestamp() {
        return this.zzaub;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzaud;
    }

    public String getName() {
        return this.mName;
    }

    public String getPlayerId() {
        return this.zzYf;
    }

    public long getRetrievedTimestamp() {
        return this.zzatZ;
    }

    public String getTitle() {
        return this.zzajf;
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzajf, dataOut);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (zzoU()) {
            dest.writeString(this.zzYf);
            dest.writeString(this.zzTa);
            dest.writeString(this.zzatu == null ? null : this.zzatu.toString());
            if (this.zzatv != null) {
                str = this.zzatv.toString();
            }
            dest.writeString(str);
            dest.writeLong(this.zzatZ);
            return;
        }
        PlayerEntityCreator.zza(this, dest, flags);
    }

    public String zztE() {
        return this.zzaug;
    }

    public boolean zztF() {
        return this.zzauf;
    }

    public int zztG() {
        return this.zzaua;
    }

    public boolean zztH() {
        return this.zzaue;
    }

    public MostRecentGameInfo zztI() {
        return this.zzauc;
    }
}
