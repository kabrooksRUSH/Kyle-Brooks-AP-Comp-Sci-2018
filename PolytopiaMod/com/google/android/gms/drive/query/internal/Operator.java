package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR = new zzn();
    public static final Operator zzaom = new Operator("=");
    public static final Operator zzaon = new Operator("<");
    public static final Operator zzaoo = new Operator("<=");
    public static final Operator zzaop = new Operator(">");
    public static final Operator zzaoq = new Operator(">=");
    public static final Operator zzaor = new Operator("and");
    public static final Operator zzaos = new Operator("or");
    public static final Operator zzaot = new Operator("not");
    public static final Operator zzaou = new Operator("contains");
    final String mTag;
    final int mVersionCode;

    Operator(int versionCode, String tag) {
        this.mVersionCode = versionCode;
        this.mTag = tag;
    }

    private Operator(String tag) {
        this(1, tag);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzn.zza(this, out, flags);
    }
}
