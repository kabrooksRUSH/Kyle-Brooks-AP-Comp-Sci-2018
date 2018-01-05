package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh {
    private static final String[] zzQD = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> zzQE = new HashMap(zzQD.length);

    static {
        int i = 0;
        while (i < zzQD.length) {
            zzQE.put(zzQD[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String zzak(int i) {
        return (i < 0 || i >= zzQD.length) ? null : zzQD[i];
    }

    public static int zzbz(String str) {
        Integer num = (Integer) zzQE.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int zzls() {
        return zzQD.length;
    }
}
