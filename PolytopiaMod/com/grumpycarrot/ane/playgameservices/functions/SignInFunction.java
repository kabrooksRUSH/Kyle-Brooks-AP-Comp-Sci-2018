package com.grumpycarrot.ane.playgameservices.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.grumpycarrot.ane.playgameservices.Extension;

public class SignInFunction implements FREFunction {
    public FREObject call(FREContext arg0, FREObject[] arg1) {
        Extension.context.startSignIn();
        return null;
    }
}
