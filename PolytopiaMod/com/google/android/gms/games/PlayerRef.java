package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends zzc implements Player {
    private final PlayerLevelInfo zzaud;
    private final PlayerColumnNames zzauo;
    private final MostRecentGameInfoRef zzaup;

    public PlayerRef(DataHolder holder, int dataRow) {
        this(holder, dataRow, null);
    }

    public PlayerRef(DataHolder holder, int dataRow, String prefix) {
        super(holder, dataRow);
        this.zzauo = new PlayerColumnNames(prefix);
        this.zzaup = new MostRecentGameInfoRef(holder, dataRow, this.zzauo);
        if (zztJ()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.zzauo.zzazA);
            int integer2 = getInteger(this.zzauo.zzazD);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.zzauo.zzazB), getLong(this.zzauo.zzazC));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.zzauo.zzazC), getLong(this.zzauo.zzazE));
            } else {
                playerLevel = playerLevel2;
            }
            this.zzaud = new PlayerLevelInfo(getLong(this.zzauo.zzazz), getLong(this.zzauo.zzazF), playerLevel2, playerLevel);
            return;
        }
        this.zzaud = null;
    }

    private boolean zztJ() {
        return (zzcg(this.zzauo.zzazz) || getLong(this.zzauo.zzazz) == -1) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString(this.zzauo.zzazr);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zza(this.zzauo.zzazr, dataOut);
    }

    public Uri getHiResImageUri() {
        return zzcf(this.zzauo.zzazu);
    }

    public String getHiResImageUrl() {
        return getString(this.zzauo.zzazv);
    }

    public Uri getIconImageUri() {
        return zzcf(this.zzauo.zzazs);
    }

    public String getIconImageUrl() {
        return getString(this.zzauo.zzazt);
    }

    public long getLastPlayedWithTimestamp() {
        return (!zzce(this.zzauo.zzazy) || zzcg(this.zzauo.zzazy)) ? -1 : getLong(this.zzauo.zzazy);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzaud;
    }

    public String getName() {
        return getString(this.zzauo.name);
    }

    public String getPlayerId() {
        return getString(this.zzauo.zzazq);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.zzauo.zzazw);
    }

    public String getTitle() {
        return getString(this.zzauo.title);
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zza(this.zzauo.title, dataOut);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.zzb(this);
    }

    public String toString() {
        return PlayerEntity.zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }

    public String zztE() {
        return getString(this.zzauo.zzazP);
    }

    public boolean zztF() {
        return getBoolean(this.zzauo.zzazO);
    }

    public int zztG() {
        return getInteger(this.zzauo.zzazx);
    }

    public boolean zztH() {
        return getBoolean(this.zzauo.zzazH);
    }

    public MostRecentGameInfo zztI() {
        return zzcg(this.zzauo.zzazI) ? null : this.zzaup;
    }
}
