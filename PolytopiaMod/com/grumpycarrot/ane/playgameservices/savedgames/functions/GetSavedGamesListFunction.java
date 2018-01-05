package com.grumpycarrot.ane.playgameservices.savedgames.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class GetSavedGamesListFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Extension.context.savedGames.loadSnapshots(arg1[0].getAsBool());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
