package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR = new zza();
    public static final AppVisibleCustomProperties zzamA = new zza().zzrI();
    final int mVersionCode;
    final List<CustomProperty> zzamB;

    public static class zza {
        private final Map<CustomPropertyKey, CustomProperty> zzamC = new HashMap();

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzx.zzb((Object) customPropertyKey, (Object) "key");
            this.zzamC.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public zza zza(CustomProperty customProperty) {
            zzx.zzb((Object) customProperty, (Object) "property");
            this.zzamC.put(customProperty.zzrJ(), customProperty);
            return this;
        }

        public AppVisibleCustomProperties zzrI() {
            return new AppVisibleCustomProperties(this.zzamC.values());
        }
    }

    AppVisibleCustomProperties(int versionCode, Collection<CustomProperty> properties) {
        this.mVersionCode = versionCode;
        zzx.zzw(properties);
        this.zzamB = new ArrayList(properties);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> properties) {
        this(1, (Collection) properties);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<CustomProperty> iterator() {
        return this.zzamB.iterator();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public Map<CustomPropertyKey, String> zzrH() {
        Map hashMap = new HashMap(this.zzamB.size());
        for (CustomProperty customProperty : this.zzamB) {
            hashMap.put(customProperty.zzrJ(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
