package com.grumpycarrot.ane.playgameservices.turnbasegames.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class CreateAutoMatchFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Extension.context.turnBaseMulti.createAutoMatch(arg1[0].getAsInt(), arg1[1].getAsInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
