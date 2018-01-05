package com.grumpycarrot.ane.playgameservices.achievements.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class LoadAchievementsFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Extension.context.achievements.loadAchievements(arg1[0].getAsBool());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
