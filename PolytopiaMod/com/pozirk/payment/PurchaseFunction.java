package com.pozirk.payment;

import android.content.Intent;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class PurchaseFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            if (Billing.getInstance().activity() == null) {
                FREObject sku = arg1[0];
                FREObject type = arg1[1];
                FREObject payload = arg1[2];
                if (sku == null || sku.getAsString().length() == 0) {
                    Billing.getInstance()._ctx.dispatchStatusEventAsync("PURCHASE_ERROR", "Invalid product id.");
                } else if (type == null || type.getAsString().length() == 0) {
                    Billing.getInstance()._ctx.dispatchStatusEventAsync("PURCHASE_ERROR", "Invalid purchase type.");
                } else {
                    Billing.getInstance().schedulePurchase(sku.getAsString(), type.getAsString(), payload == null ? null : payload.getAsString());
                    arg0.getActivity().startActivity(new Intent(arg0.getActivity(), BillingActivity.class));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
