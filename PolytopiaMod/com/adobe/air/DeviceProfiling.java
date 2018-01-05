package com.adobe.air;

import android.app.Activity;
import com.adobe.air.utils.AIRLogger;
import com.adobe.air.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

class DeviceProfiling {
    private static final int BUFFER_SIZE = 8192;
    private static final String DEFAULT_PROFILER_PORT = "9999";
    private static final String DELIM_STRING = "=";
    private static final String FLASH_TRUST_DIR = "FlashPlayerTrust";
    private static final String LOG_TAG = "DeviceProfiling";
    private static final String META_INF = ("META-INF" + File.separator + AndroidConstants.AIR);
    private static final String MM_DOT_CFG = "mm.cfg";
    private static final String PROFILER_HOST_ID = "raw.debugger";
    private static final String PROFILER_RES_ID = "raw.profileragent";
    private static final String PROFILER_SWF_NAME = "ProfilerAgent.swf";
    private static final String PROFILE_CONFIG_FILENAME = "Profiling.cfg";
    private static ResourceFileManager mResManager;

    DeviceProfiling() {
    }

    public static boolean checkAndInitiateProfiler(Activity activity) {
        mResManager = new ResourceFileManager(activity);
        boolean resExists = mResManager.resExists(mResManager.lookupResId("raw.debugger"));
        boolean resExists2 = mResManager.resExists(mResManager.lookupResId("raw.profileragent"));
        if (resExists && resExists2) {
            extractProfilerResource();
            insertPreloadTagEntry();
            insertTrustConfigEntry();
            return true;
        }
        AIRLogger.m0d(LOG_TAG, "Preload SWF/debughost resource does not exist inside the APK" + resExists + " " + resExists2);
        return false;
    }

    private static void extractProfilerResource() {
        File file = new File(ApplicationFileManager.getAppRoot() + File.separator + META_INF + File.separator + PROFILER_SWF_NAME);
        file.getParentFile().mkdirs();
        try {
            mResManager.extractResource(mResManager.lookupResId("raw.profileragent"), file);
        } catch (Exception e) {
            AIRLogger.m0d(LOG_TAG, " Exception while writing/closing preloadSWF File " + e.getMessage());
        }
    }

    private static void insertTrustConfigEntry() {
        File file = new File(ApplicationFileManager.getAppRoot() + File.separator + META_INF + File.separator + FLASH_TRUST_DIR);
        file.mkdir();
        try {
            Utils.copyTo(new File(Utils.GetExternalStorageDirectory() + File.separator + FLASH_TRUST_DIR), file);
        } catch (Exception e) {
            AIRLogger.m0d(LOG_TAG, "Recursive Copy for FlashPlayerTrust folder failed." + e.getMessage());
        }
        try {
            Utils.writeStringToFile(ApplicationFileManager.getAppRoot() + File.separator + META_INF, new File(ApplicationFileManager.getAppRoot() + File.separator + META_INF + File.separator + FLASH_TRUST_DIR + File.separator + PROFILE_CONFIG_FILENAME));
        } catch (Exception e2) {
            AIRLogger.m0d(LOG_TAG, " Write to FlashPlayerTrust Failed" + e2.getMessage());
        }
    }

    private static void insertPreloadTagEntry() {
        String concat;
        File file = new File(Utils.GetExternalStorageDirectory() + File.separator + "." + AndroidConstants.ADOBE + File.separator + AndroidConstants.AIR + File.separator + MM_DOT_CFG);
        File file2 = new File(ApplicationFileManager.getAndroidAppDataPath() + File.separator + MM_DOT_CFG);
        File file3 = new File(ApplicationFileManager.getAndroidAppDataPath() + File.separator + AndroidConstants.DEBUGGER_INFO);
        String str = ApplicationFileManager.getAppRoot() + File.separator + META_INF + File.separator + PROFILER_SWF_NAME;
        try {
            mResManager.extractResource(mResManager.lookupResId("raw.debugger"), file3);
        } catch (Exception e) {
            AIRLogger.m0d(LOG_TAG, " Extracting Resource debugInfo failed " + e.getMessage());
        }
        HashMap hashMap = new HashMap();
        try {
            hashMap = Utils.parseKeyValuePairFile(file3, new String(DELIM_STRING));
        } catch (Exception e2) {
            AIRLogger.m0d(LOG_TAG, " Parsing for key-value pairs failed/mm.cfg not found " + e2.getMessage());
        }
        String concat2 = new String("PreloadSwf=").concat(str).concat("?");
        StringBuffer stringBuffer = new StringBuffer();
        if (hashMap.get("Host") != null) {
            concat = concat2.concat("host=").concat((String) hashMap.get("Host"));
        } else {
            concat = concat2;
        }
        concat2 = concat.concat("&").concat("port=").concat(DEFAULT_PROFILER_PORT);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file), BUFFER_SIZE);
                Object obj = null;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.equals(concat2)) {
                        obj = 1;
                    }
                    stringBuffer.append(readLine).append("\n");
                }
                if (obj == null) {
                    stringBuffer.append(concat2).append("\n");
                }
                bufferedReader.close();
            } catch (Exception e3) {
                AIRLogger.m0d(LOG_TAG, "Reading from Configuration file with path" + file.getAbsolutePath() + " failed." + e3.getMessage());
            }
        } else {
            stringBuffer.append(concat2).append("\n");
        }
        try {
            Utils.writeBufferToFile(stringBuffer, file2);
        } catch (Exception e32) {
            AIRLogger.m0d(LOG_TAG, " Writing string buffer to file failed " + e32.getMessage());
        }
    }
}
