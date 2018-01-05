package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new C05381();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzaAL;
    private final byte[] zzaAM;
    private final int zzaAN;

    static class C05381 implements Creator<RealTimeMessage> {
        C05381() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzeh(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzgn(x0);
        }

        public RealTimeMessage zzeh(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        public RealTimeMessage[] zzgn(int i) {
            return new RealTimeMessage[i];
        }
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.zzaAL = (String) zzx.zzw(senderParticipantId);
        this.zzaAM = (byte[]) ((byte[]) zzx.zzw(messageData)).clone();
        this.zzaAN = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzaAM;
    }

    public String getSenderParticipantId() {
        return this.zzaAL;
    }

    public boolean isReliable() {
        return this.zzaAN == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.zzaAL);
        parcel.writeByteArray(this.zzaAM);
        parcel.writeInt(this.zzaAN);
    }
}
