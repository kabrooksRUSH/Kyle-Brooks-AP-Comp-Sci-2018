package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzajc = new MetadataChangeSet(MetadataBundle.zzrM());
    private final MetadataBundle zzajd;

    public static class Builder {
        private final MetadataBundle zzajd = MetadataBundle.zzrM();
        private zza zzaje;

        private int zzcD(String str) {
            return str == null ? 0 : str.getBytes().length;
        }

        private String zzj(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        private void zzk(String str, int i, int i2) {
            zzx.zzb(i2 <= i, zzj(str, i, i2));
        }

        private zza zzqX() {
            if (this.zzaje == null) {
                this.zzaje = new zza();
            }
            return this.zzaje;
        }

        public MetadataChangeSet build() {
            if (this.zzaje != null) {
                this.zzajd.zzb(zznd.zzamL, this.zzaje.zzrI());
            }
            return new MetadataChangeSet(this.zzajd);
        }

        public Builder deleteCustomProperty(CustomPropertyKey key) {
            zzx.zzb((Object) key, (Object) "key");
            zzqX().zza(key, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey key, String value) {
            zzx.zzb((Object) key, (Object) "key");
            zzx.zzb((Object) value, (Object) "value");
            zzk("The total size of key string and value string of a custom property", MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, zzcD(key.getKey()) + zzcD(value));
            zzqX().zza(key, value);
            return this;
        }

        public Builder setDescription(String description) {
            this.zzajd.zzb(zznd.zzamM, description);
            return this;
        }

        public Builder setIndexableText(String text) {
            zzk("Indexable text size", MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES, zzcD(text));
            this.zzajd.zzb(zznd.zzamS, text);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.zzajd.zzb(zznf.zzanC, date);
            return this;
        }

        public Builder setMimeType(String mimeType) {
            this.zzajd.zzb(zznd.zzang, mimeType);
            return this;
        }

        public Builder setPinned(boolean pinned) {
            this.zzajd.zzb(zznd.zzamY, Boolean.valueOf(pinned));
            return this;
        }

        public Builder setStarred(boolean starred) {
            this.zzajd.zzb(zznd.zzann, Boolean.valueOf(starred));
            return this;
        }

        public Builder setTitle(String title) {
            this.zzajd.zzb(zznd.zzanp, title);
            return this;
        }

        public Builder setViewed(boolean viewed) {
            this.zzajd.zzb(zznd.zzanf, Boolean.valueOf(viewed));
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle bag) {
        this.zzajd = MetadataBundle.zza(bag);
    }

    public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzajd.zza(zznd.zzamL);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzrH();
    }

    public String getDescription() {
        return (String) this.zzajd.zza(zznd.zzamM);
    }

    public String getIndexableText() {
        return (String) this.zzajd.zza(zznd.zzamS);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.zzajd.zza(zznf.zzanC);
    }

    public String getMimeType() {
        return (String) this.zzajd.zza(zznd.zzang);
    }

    public String getTitle() {
        return (String) this.zzajd.zza(zznd.zzanp);
    }

    public Boolean isPinned() {
        return (Boolean) this.zzajd.zza(zznd.zzamY);
    }

    public Boolean isStarred() {
        return (Boolean) this.zzajd.zza(zznd.zzann);
    }

    public Boolean isViewed() {
        return (Boolean) this.zzajd.zza(zznd.zzanf);
    }

    public MetadataBundle zzqW() {
        return this.zzajd;
    }
}
