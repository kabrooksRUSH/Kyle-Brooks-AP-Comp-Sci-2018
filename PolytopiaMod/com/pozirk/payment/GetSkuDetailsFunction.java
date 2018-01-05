package com.pozirk.payment;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.android.payment.utils.SkuDetails;

public class GetSkuDetailsFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            FREObject sku = arg1[0];
            FREObject res = FREObject.newObject("com.pozirk.payment.android.InAppSkuDetails", null);
            SkuDetails skuDetails = Billing.getInstance().getSKuDetails(sku.getAsString());
            if (skuDetails != null) {
                res.setProperty("_sku", FREObject.newObject(skuDetails.getSku()));
                res.setProperty("_type", FREObject.newObject(skuDetails.getType()));
                res.setProperty("_price", FREObject.newObject(skuDetails.getPrice()));
                res.setProperty("_title", FREObject.newObject(skuDetails.getTitle()));
                res.setProperty("_descr", FREObject.newObject(skuDetails.getDescription()));
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
