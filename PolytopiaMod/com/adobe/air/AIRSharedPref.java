package com.adobe.air;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import com.adobe.air.utils.Utils;

public final class AIRSharedPref {
    private static final String LOG_TAG = "AIRSharedPref";
    private static String SP_CONFIG_DATA = "AIRSharedPref.ConfigData";
    private static String SP_CONFIG_DATA_DEFAULT = "\n";
    private static String SP_CONFIG_REQUEST_TIME = "AIRSharedPref.ConfigRequestTime";
    private static String SP_CONFIG_REQUEST_TIME_DEFAULT = null;

    private static String getPreferencesKey() {
        return Utils.getRuntimePackageName() + ".AIRSharedPref";
    }

    public static String getConfigRequestTime(Context context) {
        String str = SP_CONFIG_REQUEST_TIME_DEFAULT;
        try {
            str = context.createPackageContext(Utils.getRuntimePackageName(), 4).getSharedPreferences(getPreferencesKey(), 1).getString(SP_CONFIG_REQUEST_TIME, SP_CONFIG_REQUEST_TIME_DEFAULT);
        } catch (ClassCastException e) {
        } catch (NameNotFoundException e2) {
        }
        return str != SP_CONFIG_REQUEST_TIME_DEFAULT ? str : str;
    }

    public static String getConfigData(Context context) {
        String str = SP_CONFIG_DATA_DEFAULT;
        try {
            str = context.createPackageContext(Utils.getRuntimePackageName(), 4).getSharedPreferences(getPreferencesKey(), 1).getString(SP_CONFIG_DATA, SP_CONFIG_DATA_DEFAULT);
        } catch (ClassCastException e) {
        } catch (NameNotFoundException e2) {
        }
        return str != SP_CONFIG_DATA_DEFAULT ? str : str;
    }

    public static boolean setConfigRequestTime(Context context, String str) {
        Editor edit = context.getSharedPreferences(getPreferencesKey(), 1).edit();
        edit.putString(SP_CONFIG_REQUEST_TIME, str);
        return edit.commit();
    }

    public static boolean setConfigData(Context context, String str) {
        Editor edit = context.getSharedPreferences(getPreferencesKey(), 1).edit();
        edit.putString(SP_CONFIG_DATA, str);
        return edit.commit();
    }
}
