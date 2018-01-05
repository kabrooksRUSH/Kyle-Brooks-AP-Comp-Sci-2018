package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class MostRecentGameInfoRef extends zzc implements MostRecentGameInfo {
    private final PlayerColumnNames zzauo;

    public MostRecentGameInfoRef(DataHolder holder, int dataRow, PlayerColumnNames columnNames) {
        super(holder, dataRow);
        this.zzauo = columnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvC();
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MostRecentGameInfoEntity) zzvC()).writeToParcel(dest, flags);
    }

    public Uri zzvA() {
        return zzcf(this.zzauo.zzazM);
    }

    public Uri zzvB() {
        return zzcf(this.zzauo.zzazN);
    }

    public MostRecentGameInfo zzvC() {
        return new MostRecentGameInfoEntity(this);
    }

    public String zzvw() {
        return getString(this.zzauo.zzazI);
    }

    public String zzvx() {
        return getString(this.zzauo.zzazJ);
    }

    public long zzvy() {
        return getLong(this.zzauo.zzazK);
    }

    public Uri zzvz() {
        return zzcf(this.zzauo.zzazL);
    }
}
