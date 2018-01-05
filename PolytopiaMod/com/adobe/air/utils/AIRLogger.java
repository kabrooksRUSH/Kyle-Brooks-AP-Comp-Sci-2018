package com.adobe.air.utils;

import android.util.Log;

public class AIRLogger {
    static boolean g_enableReleaseLogging = false;
    private static String mflag = (Utils.GetExternalStorageDirectory() + "/.AIR/enable_logging");

    public static void Enable(boolean z) {
        g_enableReleaseLogging = z;
        Log.v("Release Logging: ", "enabled = " + g_enableReleaseLogging);
    }

    public static boolean isEnabled() {
        return g_enableReleaseLogging;
    }

    public static int m1d(String str, String str2, Throwable th) {
        return g_enableReleaseLogging ? Log.d(str, str2, th) : 0;
    }

    public static int m0d(String str, String str2) {
        return g_enableReleaseLogging ? Log.d(str, str2) : 0;
    }

    public static int m2e(String str, String str2) {
        return g_enableReleaseLogging ? Log.e(str, str2) : 0;
    }

    public static int m3e(String str, String str2, Throwable th) {
        return g_enableReleaseLogging ? Log.e(str, str2, th) : 0;
    }

    public static int m5i(String str, String str2, Throwable th) {
        return g_enableReleaseLogging ? Log.i(str, str2, th) : 0;
    }

    public static int m4i(String str, String str2) {
        return g_enableReleaseLogging ? Log.i(str, str2) : 0;
    }

    public static int m7v(String str, String str2, Throwable th) {
        return g_enableReleaseLogging ? Log.v(str, str2, th) : 0;
    }

    public static int m6v(String str, String str2) {
        return g_enableReleaseLogging ? Log.v(str, str2) : 0;
    }

    public static int m8w(String str, String str2) {
        return g_enableReleaseLogging ? Log.w(str, str2) : 0;
    }

    public static int m10w(String str, Throwable th) {
        return g_enableReleaseLogging ? Log.w(str, th) : 0;
    }

    public static int m9w(String str, String str2, Throwable th) {
        return g_enableReleaseLogging ? Log.w(str, str2, th) : 0;
    }

    public static int println(int i, String str, String str2) {
        return g_enableReleaseLogging ? Log.println(i, str, str2) : 0;
    }

    public static boolean isLoggable(String str, int i) {
        return g_enableReleaseLogging ? Log.isLoggable(str, i) : false;
    }
}
