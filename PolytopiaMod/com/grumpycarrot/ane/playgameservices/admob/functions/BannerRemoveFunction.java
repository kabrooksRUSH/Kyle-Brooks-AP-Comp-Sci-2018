package com.grumpycarrot.ane.playgameservices.admob.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class BannerRemoveFunction implements FREFunction {
    public FREObject call(FREContext context, FREObject[] args) {
        Extension.context.banner.remove();
        return null;
    }
}
