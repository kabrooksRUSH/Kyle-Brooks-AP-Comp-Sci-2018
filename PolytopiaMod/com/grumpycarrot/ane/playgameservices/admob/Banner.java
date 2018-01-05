package com.grumpycarrot.ane.playgameservices.admob;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.grumpycarrot.ane.playgameservices.Extension;

public class Banner extends AdListener {
    private AdView adView;
    private RelativeLayout mAdLayout;
    private String mDeviceId;
    private Boolean mIsTest;

    public void dispose() {
        this.mAdLayout.removeView(this.adView);
        this.adView.destroy();
        this.adView = null;
        this.mAdLayout = null;
    }

    public void init(String adMobId, String devId, Boolean test, int bannerSize, int position) {
        this.mIsTest = test;
        this.mDeviceId = devId;
        this.adView = new AdView(Extension.context.getActivity());
        this.adView.setAdUnitId(adMobId);
        createLayout(position);
        switch (bannerSize) {
            case 0:
                this.adView.setAdSize(AdSize.BANNER);
                break;
            case 1:
                this.adView.setAdSize(AdSize.FLUID);
                break;
            case 2:
                this.adView.setAdSize(AdSize.FULL_BANNER);
                break;
            case 3:
                this.adView.setAdSize(AdSize.LARGE_BANNER);
                break;
            case 4:
                this.adView.setAdSize(AdSize.LEADERBOARD);
                break;
            case 5:
                this.adView.setAdSize(AdSize.MEDIUM_RECTANGLE);
                break;
            case 6:
                this.adView.setAdSize(AdSize.SMART_BANNER);
                break;
        }
        if (VERSION.SDK_INT >= 11) {
            this.adView.setLayerType(2, null);
        }
        this.adView.setAdListener(this);
        this.adView.setVisibility(8);
    }

    private void createLayout(int position) {
        if (this.mAdLayout == null) {
            this.mAdLayout = new RelativeLayout(Extension.context.getActivity());
            ((ViewGroup) ((ViewGroup) Extension.context.getActivity().findViewById(16908290)).getChildAt(0)).addView(this.mAdLayout, new LayoutParams(-1, -1));
        }
        this.mAdLayout.addView(this.adView, getRelativeParams(position));
        Extension.logEvent("createLayout FINSIHED");
    }

    private RelativeLayout.LayoutParams getRelativeParams(int position) {
        int firstVerb = 10;
        int secondVerb = 14;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-2, -2);
        switch (position) {
            case 0:
                firstVerb = 10;
                secondVerb = 9;
                break;
            case 1:
                firstVerb = 10;
                secondVerb = 14;
                break;
            case 2:
                firstVerb = 10;
                secondVerb = 11;
                break;
            case 3:
                firstVerb = 9;
                secondVerb = 15;
                break;
            case 4:
                firstVerb = 14;
                secondVerb = 15;
                break;
            case 5:
                firstVerb = 11;
                secondVerb = 15;
                break;
            case 6:
                firstVerb = 9;
                secondVerb = 12;
                break;
            case 7:
                firstVerb = 14;
                secondVerb = 12;
                break;
            case 8:
                firstVerb = 11;
                secondVerb = 12;
                break;
        }
        params.addRule(firstVerb, -1);
        params.addRule(secondVerb, -1);
        return params;
    }

    public void loadBannerAd() {
        AdRequest adRequest;
        if (this.mIsTest.booleanValue()) {
            adRequest = new Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice(this.mDeviceId).build();
        } else {
            adRequest = new Builder().build();
        }
        this.adView.loadAd(adRequest);
    }

    public void remove() {
        if (this.mAdLayout != null) {
            this.mAdLayout.removeView(this.adView);
            this.adView.destroy();
            this.adView = null;
        }
    }

    public void show() {
        this.adView.setVisibility(0);
        this.adView.resume();
    }

    public void hide() {
        this.adView.setVisibility(8);
        this.adView.pause();
    }

    public Boolean isVisible() {
        return Boolean.valueOf(this.adView.isShown());
    }

    public Boolean isActivated() {
        return Boolean.valueOf(this.adView.isActivated());
    }

    public void onAdLoaded() {
        Extension.context.sendEventToAir("ON_BANNER_LOADED");
    }

    public void onAdFailedToLoad(int error) {
        Extension.context.sendEventToAir("ON_BANNER_FAILED_TO_LOAD", errorCodeToString(error));
    }

    public void onAdOpened() {
        Extension.context.sendEventToAir("ON_BANNER_OPENED");
    }

    public void onAdClosed() {
        Extension.context.sendEventToAir("ON_BANNER_CLOSED");
    }

    public void onAdLeftApplication() {
        Extension.context.sendEventToAir("ON_BANNER_LEFT_APP");
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
