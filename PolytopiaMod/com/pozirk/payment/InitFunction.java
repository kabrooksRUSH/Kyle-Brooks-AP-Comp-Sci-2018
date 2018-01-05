package com.pozirk.payment;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class InitFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        ExtensionContext ctx = (ExtensionContext) arg0;
        try {
            Billing.getInstance().init(arg0.getActivity(), ctx, arg1[0].getAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
