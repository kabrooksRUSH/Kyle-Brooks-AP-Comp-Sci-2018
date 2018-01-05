package com.pozirk.payment;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class Extension implements FREExtension {
    private FREContext _ctx;

    public FREContext createContext(String extId) {
        FREContext extensionContext = new ExtensionContext();
        this._ctx = extensionContext;
        return extensionContext;
    }

    public void dispose() {
        Billing billing = Billing.getInstance();
        if (billing != null) {
            billing.dispose();
        }
        this._ctx.dispose();
        this._ctx = null;
    }

    public void initialize() {
    }
}
