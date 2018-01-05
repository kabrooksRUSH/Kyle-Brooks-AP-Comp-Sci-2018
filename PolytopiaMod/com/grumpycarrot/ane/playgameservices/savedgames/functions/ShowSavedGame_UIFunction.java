package com.grumpycarrot.ane.playgameservices.savedgames.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class ShowSavedGame_UIFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Extension.context.savedGames.showSavedGamesUI(arg1[0].getAsString(), arg1[1].getAsBool(), arg1[2].getAsBool(), arg1[3].getAsInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
