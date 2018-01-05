package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new zzh();
    final int mVersionCode;
    final Bundle zzamG;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.mVersionCode = versionCode;
        this.zzamG = (Bundle) zzx.zzw(valueBundle);
        this.zzamG.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.zzamG.keySet()) {
            if (zze.zzcF(str) == null) {
                arrayList.add(str);
                zzz.zzy("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.zzamG.remove(str2);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzrM = zzrM();
        zzrM.zzb(metadataField, t);
        return zzrM;
    }

    public static MetadataBundle zza(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.zzamG));
    }

    public static MetadataBundle zzrM() {
        return new MetadataBundle(new Bundle());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzamG.keySet();
        if (!keySet.equals(metadataBundle.zzamG.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!zzw.equal(this.zzamG.get(str), metadataBundle.zzamG.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.zzamG.keySet()) {
            i *= 31;
            i = this.zzamG.get(str).hashCode() + i;
        }
        return i;
    }

    public void setContext(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zznd.zzano);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.zzc(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.zzamG + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zzj(this.zzamG);
    }

    public <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zze.zzcF(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.zza(t, this.zzamG);
    }

    public boolean zzc(MetadataField<?> metadataField) {
        return this.zzamG.containsKey(metadataField.getName());
    }

    public Set<MetadataField<?>> zzrN() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String zzcF : this.zzamG.keySet()) {
            hashSet.add(zze.zzcF(zzcF));
        }
        return hashSet;
    }
}
