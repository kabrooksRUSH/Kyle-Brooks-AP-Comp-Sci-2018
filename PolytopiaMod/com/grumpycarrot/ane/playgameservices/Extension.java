package com.grumpycarrot.ane.playgameservices;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class Extension implements FREExtension {
    public static ExtensionContext context;

    public FREContext createContext(String extId) {
        context = new ExtensionContext();
        return context;
    }

    public void initialize() {
    }

    public void dispose() {
        context.dispose();
        context = null;
    }

    public static void logEvent(String eventName) {
    }
}
