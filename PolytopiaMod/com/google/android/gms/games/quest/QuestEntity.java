package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzmo;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
    public static final Creator<QuestEntity> CREATOR = new QuestEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final int zzWJ;
    private final GameEntity zzaAy;
    private final String zzaBq;
    private final long zzaBr;
    private final Uri zzaBs;
    private final String zzaBt;
    private final long zzaBu;
    private final Uri zzaBv;
    private final String zzaBw;
    private final long zzaBx;
    private final long zzaBy;
    private final ArrayList<MilestoneEntity> zzaBz;
    private final String zzaqZ;
    private final long zzauA;

    QuestEntity(int versionCode, GameEntity game, String questId, long acceptedTimestamp, Uri bannerImageUri, String bannerImageUrl, String description, long endTimestamp, long lastUpdatedTimestamp, Uri iconImageUri, String iconImageUrl, String name, long notifyTimestamp, long startTimestamp, int state, int type, ArrayList<MilestoneEntity> milestones) {
        this.mVersionCode = versionCode;
        this.zzaAy = game;
        this.zzaBq = questId;
        this.zzaBr = acceptedTimestamp;
        this.zzaBs = bannerImageUri;
        this.zzaBt = bannerImageUrl;
        this.zzaqZ = description;
        this.zzaBu = endTimestamp;
        this.zzauA = lastUpdatedTimestamp;
        this.zzaBv = iconImageUri;
        this.zzaBw = iconImageUrl;
        this.mName = name;
        this.zzaBx = notifyTimestamp;
        this.zzaBy = startTimestamp;
        this.mState = state;
        this.zzWJ = type;
        this.zzaBz = milestones;
    }

    public QuestEntity(Quest quest) {
        this.mVersionCode = 2;
        this.zzaAy = new GameEntity(quest.getGame());
        this.zzaBq = quest.getQuestId();
        this.zzaBr = quest.getAcceptedTimestamp();
        this.zzaqZ = quest.getDescription();
        this.zzaBs = quest.getBannerImageUri();
        this.zzaBt = quest.getBannerImageUrl();
        this.zzaBu = quest.getEndTimestamp();
        this.zzaBv = quest.getIconImageUri();
        this.zzaBw = quest.getIconImageUrl();
        this.zzauA = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.zzaBx = quest.zzvQ();
        this.zzaBy = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.zzWJ = quest.getType();
        List zzvP = quest.zzvP();
        int size = zzvP.size();
        this.zzaBz = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaBz.add((MilestoneEntity) ((Milestone) zzvP.get(i)).freeze());
        }
    }

    static int zza(Quest quest) {
        return zzw.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zzvP(), quest.getName(), Long.valueOf(quest.zzvQ()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean zza(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return zzw.equal(quest2.getGame(), quest.getGame()) && zzw.equal(quest2.getQuestId(), quest.getQuestId()) && zzw.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && zzw.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && zzw.equal(quest2.getDescription(), quest.getDescription()) && zzw.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && zzw.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && zzw.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && zzw.equal(quest2.zzvP(), quest.zzvP()) && zzw.equal(quest2.getName(), quest.getName()) && zzw.equal(Long.valueOf(quest2.zzvQ()), Long.valueOf(quest.zzvQ())) && zzw.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && zzw.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String zzb(Quest quest) {
        return zzw.zzv(quest).zzg("Game", quest.getGame()).zzg("QuestId", quest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).zzg("BannerImageUri", quest.getBannerImageUri()).zzg("BannerImageUrl", quest.getBannerImageUrl()).zzg("Description", quest.getDescription()).zzg("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).zzg("IconImageUri", quest.getIconImageUri()).zzg("IconImageUrl", quest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).zzg("Milestones", quest.zzvP()).zzg("Name", quest.getName()).zzg("NotifyTimestamp", Long.valueOf(quest.zzvQ())).zzg("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).zzg("State", Integer.valueOf(quest.getState())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Quest freeze() {
        return this;
    }

    public long getAcceptedTimestamp() {
        return this.zzaBr;
    }

    public Uri getBannerImageUri() {
        return this.zzaBs;
    }

    public String getBannerImageUrl() {
        return this.zzaBt;
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) zzvP().get(0);
    }

    public String getDescription() {
        return this.zzaqZ;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzmo.zzb(this.zzaqZ, dataOut);
    }

    public long getEndTimestamp() {
        return this.zzaBu;
    }

    public Game getGame() {
        return this.zzaAy;
    }

    public Uri getIconImageUri() {
        return this.zzaBv;
    }

    public String getIconImageUrl() {
        return this.zzaBw;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzauA;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zzmo.zzb(this.mName, dataOut);
    }

    public String getQuestId() {
        return this.zzaBq;
    }

    public long getStartTimestamp() {
        return this.zzaBy;
    }

    public int getState() {
        return this.mState;
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

    public boolean isDataValid() {
        return true;
    }

    public boolean isEndingSoon() {
        return this.zzaBx <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        QuestEntityCreator.zza(this, out, flags);
    }

    public List<Milestone> zzvP() {
        return new ArrayList(this.zzaBz);
    }

    public long zzvQ() {
        return this.zzaBx;
    }
}
