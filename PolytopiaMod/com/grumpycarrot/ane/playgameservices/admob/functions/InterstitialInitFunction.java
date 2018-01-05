package com.grumpycarrot.ane.playgameservices.admob.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class InterstitialInitFunction implements FREFunction {
    public FREObject call(FREContext context, FREObject[] args) {
        try {
            Extension.context.interstitial.init(args[0].getAsString(), args[1].getAsString(), Boolean.valueOf(args[2].getAsBool()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
