package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    public String getAlternateLink() {
        return (String) zza(zznd.zzamK);
    }

    public int getContentAvailability() {
        Integer num = (Integer) zza(zznh.zzanI);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) zza(zznf.zzanB);
    }

    public Map<CustomPropertyKey, String> getCustomProperties() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) zza(zznd.zzamL);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzrH();
    }

    public String getDescription() {
        return (String) zza(zznd.zzamM);
    }

    public DriveId getDriveId() {
        return (DriveId) zza(zznd.zzamJ);
    }

    public String getEmbedLink() {
        return (String) zza(zznd.zzamN);
    }

    public String getFileExtension() {
        return (String) zza(zznd.zzamO);
    }

    public long getFileSize() {
        return ((Long) zza(zznd.zzamP)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) zza(zznf.zzanC);
    }

    public String getMimeType() {
        return (String) zza(zznd.zzang);
    }

    public Date getModifiedByMeDate() {
        return (Date) zza(zznf.zzanE);
    }

    public Date getModifiedDate() {
        return (Date) zza(zznf.zzanD);
    }

    public String getOriginalFilename() {
        return (String) zza(zznd.zzanh);
    }

    public long getQuotaBytesUsed() {
        return ((Long) zza(zznd.zzanm)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) zza(zznf.zzanF);
    }

    public String getTitle() {
        return (String) zza(zznd.zzanp);
    }

    public String getWebContentLink() {
        return (String) zza(zznd.zzanr);
    }

    public String getWebViewLink() {
        return (String) zza(zznd.zzans);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) zza(zznd.zzamV);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isExplicitlyTrashed() {
        Boolean bool = (Boolean) zza(zznd.zzamW);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) zza(zznd.zzamT);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) zza(zznh.zzanJ);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) zza(zznd.zzamY);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) zza(zznd.zzana);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) zza(zznd.zzanb);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) zza(zznd.zzann);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashable() {
        Boolean bool = (Boolean) zza(zznd.zzane);
        return bool == null ? true : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) zza(zznd.zzanq);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) zza(zznd.zzanf);
        return bool == null ? false : bool.booleanValue();
    }

    public abstract <T> T zza(MetadataField<T> metadataField);
}
