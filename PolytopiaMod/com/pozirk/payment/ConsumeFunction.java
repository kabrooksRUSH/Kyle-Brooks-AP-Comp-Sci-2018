package com.pozirk.payment;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class ConsumeFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Billing.getInstance().consume(arg1[0].getAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
