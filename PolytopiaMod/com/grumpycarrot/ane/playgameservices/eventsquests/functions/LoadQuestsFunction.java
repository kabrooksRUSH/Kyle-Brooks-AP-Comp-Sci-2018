package com.grumpycarrot.ane.playgameservices.eventsquests.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class LoadQuestsFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        try {
            Extension.context.eventsQuests.loadQuests(Extension.context.FREArraytoIntArray(arg1[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
