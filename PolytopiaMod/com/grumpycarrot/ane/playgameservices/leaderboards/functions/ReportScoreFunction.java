package com.grumpycarrot.ane.playgameservices.leaderboards.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class ReportScoreFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Extension.context.leaderboards.reportScore(arg1[0].getAsString(), arg1[1].getAsInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
