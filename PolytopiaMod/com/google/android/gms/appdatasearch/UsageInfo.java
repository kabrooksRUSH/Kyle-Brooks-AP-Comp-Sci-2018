package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzse;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final DocumentId zzQU;
    final long zzQV;
    int zzQW;
    final DocumentContents zzQX;
    final boolean zzQY;
    int zzQZ;
    int zzRa;
    public final String zzub;

    public static final class zza {
        private String zzLe;
        private DocumentId zzQU;
        private long zzQV = -1;
        private int zzQW = -1;
        private DocumentContents zzQX;
        private boolean zzQY = false;
        private int zzQZ = -1;
        private int zzRa = 0;

        public zza zzO(boolean z) {
            this.zzQY = z;
            return this;
        }

        public zza zza(DocumentContents documentContents) {
            this.zzQX = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.zzQU = documentId;
            return this;
        }

        public zza zzan(int i) {
            this.zzQW = i;
            return this;
        }

        public zza zzao(int i) {
            this.zzRa = i;
            return this;
        }

        public UsageInfo zzlv() {
            return new UsageInfo(this.zzQU, this.zzQV, this.zzQW, this.zzLe, this.zzQX, this.zzQY, this.zzQZ, this.zzRa);
        }

        public zza zzw(long j) {
            this.zzQV = j;
            return this;
        }
    }

    UsageInfo(int versionCode, DocumentId documentId, long timestamp, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this.mVersionCode = versionCode;
        this.zzQU = documentId;
        this.zzQV = timestamp;
        this.zzQW = usageType;
        this.zzub = query;
        this.zzQX = document;
        this.zzQY = isDeviceOnly;
        this.zzQZ = taskPosition;
        this.zzRa = eventStatus;
    }

    private UsageInfo(DocumentId documentId, long timestampMs, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this(1, documentId, timestampMs, usageType, query, document, isDeviceOnly, taskPosition, eventStatus);
    }

    public UsageInfo(String packageName, Intent viewIntent, String title, Uri webUrl, String schemaOrgType, List<AppIndexingLink> outLinks, int eventStatus) {
        this(1, zza(packageName, viewIntent), System.currentTimeMillis(), 0, null, zza(viewIntent, title, webUrl, schemaOrgType, outLinks).zzlo(), false, -1, eventStatus);
    }

    public static com.google.android.gms.appdatasearch.DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        com.google.android.gms.appdatasearch.DocumentContents.zza com_google_android_gms_appdatasearch_DocumentContents_zza = new com.google.android.gms.appdatasearch.DocumentContents.zza();
        com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzbC(str));
        if (uri != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzi(uri));
        }
        if (list != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzo(list));
        }
        String action = intent.getAction();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzq("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzq("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzq("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzq("intent_extra_data", action));
            }
        }
        return com_google_android_gms_appdatasearch_DocumentContents_zza.zzbx(str2).zzK(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzp(str, zzg(intent));
    }

    private static DocumentSection zzbC(String str) {
        return new DocumentSection(str, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("title").zzal(1).zzN(true).zzbB("name").zzlt(), "text1");
    }

    private static String zzg(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzi(Uri uri) {
        return new DocumentSection(uri.toString(), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("web_url").zzal(4).zzM(true).zzbB("url").zzlt());
    }

    private static DocumentSection zzo(List<AppIndexingLink> list) {
        zzse com_google_android_gms_internal_zzox_zza = new com.google.android.gms.internal.zzox.zza();
        com.google.android.gms.internal.zzox.zza.zza[] com_google_android_gms_internal_zzox_zza_zzaArr = new com.google.android.gms.internal.zzox.zza.zza[list.size()];
        for (int i = 0; i < com_google_android_gms_internal_zzox_zza_zzaArr.length; i++) {
            com_google_android_gms_internal_zzox_zza_zzaArr[i] = new com.google.android.gms.internal.zzox.zza.zza();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            com_google_android_gms_internal_zzox_zza_zzaArr[i].zzaCW = appIndexingLink.appIndexingUrl.toString();
            com_google_android_gms_internal_zzox_zza_zzaArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                com_google_android_gms_internal_zzox_zza_zzaArr[i].zzaCX = appIndexingLink.webUrl.toString();
            }
        }
        com_google_android_gms_internal_zzox_zza.zzaCU = com_google_android_gms_internal_zzox_zza_zzaArr;
        return new DocumentSection(zzse.zzf(com_google_android_gms_internal_zzox_zza), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("outlinks").zzM(true).zzbB(".private:outLinks").zzbA("blob").zzlt());
    }

    private static DocumentId zzp(String str, String str2) {
        return new DocumentId(str, "", str2);
    }

    private static DocumentSection zzq(String str, String str2) {
        return new DocumentSection(str2, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(str).zzM(true).zzlt(), str);
    }

    public int describeContents() {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.zzQU, Long.valueOf(this.zzQV), Integer.valueOf(this.zzQW), Integer.valueOf(this.zzRa)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        zzj.zza(this, dest, flags);
    }

    public DocumentContents zzlu() {
        return this.zzQX;
    }
}
