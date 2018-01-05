package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzmo;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
    private final int mVersionCode;
    private final String zzTa;
    private final int zzVl;
    private final boolean zzaAG;
    private final ParticipantResult zzaAH;
    private final String zzatF;
    private final String zzatG;
    private final Uri zzatu;
    private final Uri zzatv;
    private final PlayerEntity zzaux;
    private final String zzavf;
    private final String zzawg;
    private final int zzys;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzef(x0);
        }

        public ParticipantEntity zzef(Parcel parcel) {
            Object obj = 1;
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzoT()) || DowngradeableSafeParcel.zzck(ParticipantEntity.class.getCanonicalName())) {
                return super.zzef(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities, ParticipantResult result, String iconImageUrl, String hiResImageUrl) {
        this.mVersionCode = versionCode;
        this.zzawg = participantId;
        this.zzTa = displayName;
        this.zzatu = iconImageUri;
        this.zzatv = hiResImageUri;
        this.zzys = status;
        this.zzavf = clientAddress;
        this.zzaAG = connectedToRoom;
        this.zzaux = player;
        this.zzVl = capabilities;
        this.zzaAH = result;
        this.zzatF = iconImageUrl;
        this.zzatG = hiResImageUrl;
    }

    public ParticipantEntity(Participant participant) {
        this.mVersionCode = 3;
        this.zzawg = participant.getParticipantId();
        this.zzTa = participant.getDisplayName();
        this.zzatu = participant.getIconImageUri();
        this.zzatv = participant.getHiResImageUri();
        this.zzys = participant.getStatus();
        this.zzavf = participant.zzut();
        this.zzaAG = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.zzaux = player == null ? null : new PlayerEntity(player);
        this.zzVl = participant.getCapabilities();
        this.zzaAH = participant.getResult();
        this.zzatF = participant.getIconImageUrl();
        this.zzatG = participant.getHiResImageUrl();
    }

    static int zza(Participant participant) {
        return zzw.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzut(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return zzw.equal(participant2.getPlayer(), participant.getPlayer()) && zzw.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && zzw.equal(participant2.zzut(), participant.zzut()) && zzw.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && zzw.equal(participant2.getDisplayName(), participant.getDisplayName()) && zzw.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && zzw.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && zzw.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && zzw.equal(participant2.getResult(), participant.getResult()) && zzw.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String zzb(Participant participant) {
        return zzw.zzv(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zzut()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.zzVl;
    }

    public String getDisplayName() {
        return this.zzaux == null ? this.zzTa : this.zzaux.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.zzaux == null) {
            zzmo.zzb(this.zzTa, dataOut);
        } else {
            this.zzaux.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.zzaux == null ? this.zzatv : this.zzaux.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.zzaux == null ? this.zzatG : this.zzaux.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.zzaux == null ? this.zzatu : this.zzaux.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.zzaux == null ? this.zzatF : this.zzaux.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.zzawg;
    }

    public Player getPlayer() {
        return this.zzaux;
    }

    public ParticipantResult getResult() {
        return this.zzaAH;
    }

    public int getStatus() {
        return this.zzys;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConnectedToRoom() {
        return this.zzaAG;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (zzoU()) {
            dest.writeString(this.zzawg);
            dest.writeString(this.zzTa);
            dest.writeString(this.zzatu == null ? null : this.zzatu.toString());
            if (this.zzatv != null) {
                str = this.zzatv.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.zzys);
            dest.writeString(this.zzavf);
            dest.writeInt(this.zzaAG ? 1 : 0);
            if (this.zzaux != null) {
                i = 1;
            }
            dest.writeInt(i);
            if (this.zzaux != null) {
                this.zzaux.writeToParcel(dest, flags);
                return;
            }
            return;
        }
        ParticipantEntityCreator.zza(this, dest, flags);
    }

    public String zzut() {
        return this.zzavf;
    }
}
