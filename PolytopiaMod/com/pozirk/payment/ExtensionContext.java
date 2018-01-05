package com.pozirk.payment;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import java.util.HashMap;
import java.util.Map;

public class ExtensionContext extends FREContext {
    public Map<String, FREFunction> getFunctions() {
        Map<String, FREFunction> functionMap = new HashMap();
        functionMap.put("init", new InitFunction());
        functionMap.put("purchase", new PurchaseFunction());
        functionMap.put("restore", new RestoreFunction());
        functionMap.put("consume", new ConsumeFunction());
        functionMap.put("getPurchaseDetails", new GetPurchaseDetailsFunction());
        functionMap.put("getSkuDetails", new GetSkuDetailsFunction());
        return functionMap;
    }

    public void dispose() {
        Billing billing = Billing.getInstance();
        if (billing != null) {
            billing.dispose();
        }
    }
}
