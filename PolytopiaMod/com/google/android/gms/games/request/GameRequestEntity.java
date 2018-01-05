package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final Creator<GameRequestEntity> CREATOR = new GameRequestEntityCreator();
    private final int mVersionCode;
    private final String zzBY;
    private final int zzWJ;
    private final GameEntity zzaAy;
    private final long zzaAz;
    private final PlayerEntity zzaBA;
    private final ArrayList<PlayerEntity> zzaBB;
    private final long zzaBC;
    private final Bundle zzaBD;
    private final byte[] zzaBg;
    private final int zzys;

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses, int status) {
        this.mVersionCode = versionCode;
        this.zzaAy = game;
        this.zzaBA = sender;
        this.zzaBg = data;
        this.zzBY = requestId;
        this.zzaBB = recipients;
        this.zzWJ = type;
        this.zzaAz = creationTimestamp;
        this.zzaBC = expirationTimestamp;
        this.zzaBD = recipientStatuses;
        this.zzys = status;
    }

    public GameRequestEntity(GameRequest request) {
        this.mVersionCode = 2;
        this.zzaAy = new GameEntity(request.getGame());
        this.zzaBA = new PlayerEntity(request.getSender());
        this.zzBY = request.getRequestId();
        this.zzWJ = request.getType();
        this.zzaAz = request.getCreationTimestamp();
        this.zzaBC = request.getExpirationTimestamp();
        this.zzys = request.getStatus();
        Object data = request.getData();
        if (data == null) {
            this.zzaBg = null;
        } else {
            this.zzaBg = new byte[data.length];
            System.arraycopy(data, 0, this.zzaBg, 0, data.length);
        }
        List recipients = request.getRecipients();
        int size = recipients.size();
        this.zzaBB = new ArrayList(size);
        this.zzaBD = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.zzaBB.add((PlayerEntity) player);
            this.zzaBD.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzw.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzw.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzw.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzw.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzw.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzw.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzw.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzw.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzw.zzv(gameRequest).zzg("Game", gameRequest.getGame()).zzg("Sender", gameRequest.getSender()).zzg("Recipients", gameRequest.getRecipients()).zzg("Data", gameRequest.getData()).zzg("RequestId", gameRequest.getRequestId()).zzg("Type", Integer.valueOf(gameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.zzaAz;
    }

    public byte[] getData() {
        return this.zzaBg;
    }

    public long getExpirationTimestamp() {
        return this.zzaBC;
    }

    public Game getGame() {
        return this.zzaAy;
    }

    public int getRecipientStatus(String playerId) {
        return this.zzaBD.getInt(playerId, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.zzaBB);
    }

    public String getRequestId() {
        return this.zzBY;
    }

    public Player getSender() {
        return this.zzaBA;
    }

    public int getStatus() {
        return this.zzys;
    }

    public int getType() {
        return this.zzWJ;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.zza(this, dest, flags);
    }

    public Bundle zzvR() {
        return this.zzaBD;
    }
}
