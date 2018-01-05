package com.grumpycarrot.ane.playgameservices.leaderboards.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class GetCurrentPlayerLeaderboardScoreFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            String leaderboardId = arg1[0].getAsString();
            int span = arg1[1].getAsInt();
            int leaderboardCollection = arg1[2].getAsInt();
            if (leaderboardId != null) {
                Extension.context.leaderboards.currentPlayerLeaderboardScore(leaderboardId, span, leaderboardCollection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
