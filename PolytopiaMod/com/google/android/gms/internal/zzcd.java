package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@zzgr
public abstract class zzcd {
    @zzgr
    public static final zzcd zzvK = new C05701();
    @zzgr
    public static final zzcd zzvL = new C05712();
    @zzgr
    public static final zzcd zzvM = new C05723();

    static class C05701 extends zzcd {
        C05701() {
        }

        public String zzd(String str, String str2) {
            return str2;
        }
    }

    static class C05712 extends zzcd {
        C05712() {
        }

        public String zzd(String str, String str2) {
            return str != null ? str : str2;
        }
    }

    static class C05723 extends zzcd {
        C05723() {
        }

        private String zzS(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String zzd(String str, String str2) {
            String zzS = zzS(str);
            String zzS2 = zzS(str2);
            return TextUtils.isEmpty(zzS) ? zzS2 : TextUtils.isEmpty(zzS2) ? zzS : zzS + "," + zzS2;
        }
    }

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzd((String) map.get(str), str2));
    }

    public abstract String zzd(String str, String str2);
}
