package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Creator<ParcelableCollaborator> CREATOR = new zzq();
    final int mVersionCode;
    final String zzGY;
    final String zzHP;
    final String zzTa;
    final String zzaoA;
    final boolean zzaox;
    final boolean zzaoy;
    final String zzaoz;

    ParcelableCollaborator(int versionCode, boolean isMe, boolean isAnonymous, String sessionId, String userId, String displayName, String color, String photoUrl) {
        this.mVersionCode = versionCode;
        this.zzaox = isMe;
        this.zzaoy = isAnonymous;
        this.zzHP = sessionId;
        this.zzGY = userId;
        this.zzTa = displayName;
        this.zzaoz = color;
        this.zzaoA = photoUrl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.zzHP.equals(((ParcelableCollaborator) obj).zzHP);
    }

    public int hashCode() {
        return this.zzHP.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.zzaox + ", isAnonymous=" + this.zzaoy + ", sessionId=" + this.zzHP + ", userId=" + this.zzGY + ", displayName=" + this.zzTa + ", color=" + this.zzaoz + ", photoUrl=" + this.zzaoA + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }
}
