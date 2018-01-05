package com.grumpycarrot.ane.playgameservices.savedgames.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class WriteGameFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Extension.context.savedGames.writeGame(arg1[0].getAsString(), arg1[1].getAsString(), arg1[2].getAsString(), (long) arg1[3].getAsInt(), (long) arg1[4].getAsInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
