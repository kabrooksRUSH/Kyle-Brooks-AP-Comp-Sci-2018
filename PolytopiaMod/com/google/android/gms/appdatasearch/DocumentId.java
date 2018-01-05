package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentId implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final String zzQe;
    final String zzQf;
    final String zzQg;

    DocumentId(int versionCode, String packageName, String corpusName, String uri) {
        this.mVersionCode = versionCode;
        this.zzQe = packageName;
        this.zzQf = corpusName;
        this.zzQg = uri;
    }

    public DocumentId(String packageName, String corpusName, String uri) {
        this(1, packageName, corpusName, uri);
    }

    public int describeContents() {
        zzc com_google_android_gms_appdatasearch_zzc = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.zzQe, this.zzQf, this.zzQg});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc com_google_android_gms_appdatasearch_zzc = CREATOR;
        zzc.zza(this, dest, flags);
    }
}
