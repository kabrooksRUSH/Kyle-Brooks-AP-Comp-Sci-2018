package com.grumpycarrot.ane.playgameservices.admob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import com.grumpycarrot.ane.playgameservices.Extension;

public class Interstitial extends AdListener {
    private String deviceId;
    private InterstitialAd interstitialAd = null;
    private Boolean isTest;

    public void dispose() {
        this.interstitialAd = null;
    }

    public void init(String adMobId, String devId, Boolean test) {
        this.isTest = test;
        this.deviceId = devId;
        this.interstitialAd = new InterstitialAd(Extension.context.getActivity());
        this.interstitialAd.setAdUnitId(adMobId);
        this.interstitialAd.setAdListener(this);
    }

    public void loadInterstitial() {
        AdRequest adRequest;
        if (this.isTest.booleanValue()) {
            adRequest = new Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice(this.deviceId).build();
        } else {
            adRequest = new Builder().build();
        }
        this.interstitialAd.loadAd(adRequest);
    }

    public void showInterstitial() {
        if (this.interstitialAd.isLoaded()) {
            this.interstitialAd.show();
        }
    }

    public Boolean isInterstialLoaded() {
        return Boolean.valueOf(this.interstitialAd.isLoaded());
    }

    public void onAdLoaded() {
        Extension.context.sendEventToAir("ON_INTERSTITIAL_LOADED");
    }

    public void onAdFailedToLoad(int errorCode) {
        Extension.context.sendEventToAir("ON_INTERSTITIAL_FAILED_TO_LOAD", errorCodeToString(errorCode));
    }

    public void onAdClosed() {
        Extension.context.sendEventToAir("ON_INTERSTITIAL_CLOSED");
    }

    public void onAdLeftApplication() {
        Extension.context.sendEventToAir("ON_INTERSTITIAL_LEFT_APP");
    }

    public void onAdOpened() {
        Extension.context.sendEventToAir("ON_INTERSTITIAL_OPEN");
    }

    private String errorCodeToString(int errorCode) {
        String errorString = "";
        switch (errorCode) {
            case 0:
                return "ERROR_CODE_INTERNAL_ERROR";
            case 1:
                return "ERROR_CODE_INVALID_REQUEST";
            case 2:
                return "ERROR_CODE_NETWORK_ERROR";
            case 3:
                return "ERROR_CODE_NO_FILL";
            default:
                return errorString;
        }
    }
}
