package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final Creator<MilestoneEntity> CREATOR = new MilestoneEntityCreator();
    private final int mState;
    private final int mVersionCode;
    private final long zzaBn;
    private final long zzaBo;
    private final byte[] zzaBp;
    private final String zzavb;
    private final String zzawj;

    MilestoneEntity(int versionCode, String milestoneId, long currentProgress, long targetProgress, byte[] completionBlob, int state, String eventId) {
        this.mVersionCode = versionCode;
        this.zzawj = milestoneId;
        this.zzaBn = currentProgress;
        this.zzaBo = targetProgress;
        this.zzaBp = completionBlob;
        this.mState = state;
        this.zzavb = eventId;
    }

    public MilestoneEntity(Milestone milestone) {
        this.mVersionCode = 4;
        this.zzawj = milestone.getMilestoneId();
        this.zzaBn = milestone.getCurrentProgress();
        this.zzaBo = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.zzavb = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.zzaBp = null;
            return;
        }
        this.zzaBp = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.zzaBp, 0, completionRewardData.length);
    }

    static int zza(Milestone milestone) {
        return zzw.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean zza(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return zzw.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && zzw.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && zzw.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && zzw.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && zzw.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String zzb(Milestone milestone) {
        return zzw.zzv(milestone).zzg("MilestoneId", milestone.getMilestoneId()).zzg("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).zzg("TargetProgress", Long.valueOf(milestone.getTargetProgress())).zzg("State", Integer.valueOf(milestone.getState())).zzg("CompletionRewardData", milestone.getCompletionRewardData()).zzg("EventId", milestone.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.zzaBp;
    }

    public long getCurrentProgress() {
        return this.zzaBn;
    }

    public String getEventId() {
        return this.zzavb;
    }

    public String getMilestoneId() {
        return this.zzawj;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.zzaBo;
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

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MilestoneEntityCreator.zza(this, out, flags);
    }
}
