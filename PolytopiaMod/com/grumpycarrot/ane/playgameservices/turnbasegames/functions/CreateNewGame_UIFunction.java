package com.grumpycarrot.ane.playgameservices.turnbasegames.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class CreateNewGame_UIFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Extension.context.turnBaseMulti.selectOpponents(arg1[0].getAsInt(), arg1[1].getAsInt(), arg1[2].getAsBool());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
