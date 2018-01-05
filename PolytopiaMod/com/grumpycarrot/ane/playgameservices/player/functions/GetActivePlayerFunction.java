package com.grumpycarrot.ane.playgameservices.player.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;
import com.grumpycarrot.ane.playgameservices.Extension;

public class GetActivePlayerFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        FREObject player = null;
        try {
            player = FREObject.newObject(Extension.context.currentPlayer.getActivePlayer());
        } catch (FREWrongThreadException e) {
            e.printStackTrace();
        }
        return player;
    }
}
