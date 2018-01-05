package com.grumpycarrot.ane.playgameservices.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class InitAPIFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Extension.context.initAPI(arg1[0].getAsBool(), arg1[1].getAsBool(), arg1[2].getAsBool(), arg1[3].getAsInt(), arg1[4].getAsBool());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
