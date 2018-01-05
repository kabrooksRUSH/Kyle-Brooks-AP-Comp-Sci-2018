package com.pozirk.payment;

import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import java.util.ArrayList;
import java.util.List;

public class RestoreFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            long len;
            long i;
            FREObject freObj;
            FREArray freItems = arg1[0];
            FREArray freSubs = arg1[1];
            Billing billing = Billing.getInstance();
            List<String> items = null;
            List<String> subs = null;
            if (freItems != null && freItems.getLength() > 0) {
                items = new ArrayList();
                len = freItems.getLength();
                for (i = 0; i < len; i++) {
                    freObj = freItems.getObjectAt(i);
                    if (freObj != null) {
                        items.add(freObj.getAsString());
                    }
                }
            }
            if (freSubs != null && freSubs.getLength() > 0) {
                subs = new ArrayList();
                len = freSubs.getLength();
                for (i = 0; i < len; i++) {
                    freObj = freSubs.getObjectAt(i);
                    if (freObj != null) {
                        items.add(freObj.getAsString());
                    }
                }
            }
            billing.restore(items, subs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
