package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public static final int zzQh = Integer.parseInt("-1");
    private static final RegisterSectionInfo zzQi = new zza("SsbContext").zzM(true).zzbA("blob").zzlt();
    final int mVersionCode;
    public final String zzQj;
    final RegisterSectionInfo zzQk;
    public final int zzQl;
    public final byte[] zzQm;

    DocumentSection(int versionCode, String content, RegisterSectionInfo sectionInfo, int globalSearchSectionType, byte[] blobContent) {
        boolean z = globalSearchSectionType == zzQh || zzh.zzak(globalSearchSectionType) != null;
        zzx.zzb(z, "Invalid section type " + globalSearchSectionType);
        this.mVersionCode = versionCode;
        this.zzQj = content;
        this.zzQk = sectionInfo;
        this.zzQl = globalSearchSectionType;
        this.zzQm = blobContent;
        String zzlq = zzlq();
        if (zzlq != null) {
            throw new IllegalArgumentException(zzlq);
        }
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo) {
        this(1, content, sectionInfo, zzQh, null);
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo, String globalSearchSectionType) {
        this(1, content, sectionInfo, zzh.zzbz(globalSearchSectionType), null);
    }

    public DocumentSection(byte[] blobContent, RegisterSectionInfo sectionInfo) {
        this(1, null, sectionInfo, zzQh, blobContent);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzQi);
    }

    public int describeContents() {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        zzd.zza(this, dest, flags);
    }

    public RegisterSectionInfo zzlp() {
        return this.zzQk;
    }

    public String zzlq() {
        return (this.zzQl == zzQh || zzh.zzak(this.zzQl) != null) ? (this.zzQj == null || this.zzQm == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.zzQl;
    }
}
