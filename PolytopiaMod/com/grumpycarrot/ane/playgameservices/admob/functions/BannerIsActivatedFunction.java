package com.grumpycarrot.ane.playgameservices.admob.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class BannerIsActivatedFunction implements FREFunction {
    public FREObject call(FREContext context, FREObject[] args) {
        try {
            return FREObject.newObject(Extension.context.banner.isActivated().booleanValue());
        } catch (Exception e) {
            return null;
        }
    }
}
