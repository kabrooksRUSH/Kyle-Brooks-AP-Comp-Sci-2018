package com.adobe.air;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.Display;
import android.view.OrientationEventListener;

class OrientationManager {
    private static final float AIR_NAMESPACE_VERSION_3_3 = 3.3f;
    private static final float AIR_NAMESPACE_VERSION_3_8 = 3.8f;
    private static final String LOG_TAG = "OrientationManager";
    private static OrientationManager sMgr = null;
    public int mAfterOrientation;
    private boolean mAutoOrients = false;
    public int mBeforeOrientation;
    private int mDeviceDefault = EDefault.PORTRAIT.ordinal();
    private int mDeviceOrientation = EOrientation.UNKNOWN.ordinal();
    public boolean mDispatchOrientationChangePending = false;
    private int mFinalOrientation = EOrientation.UNKNOWN.ordinal();
    private boolean mFirstCreate = true;
    private int mHardKeyboardHidden = 2;
    private float mNamespaceVersion;
    private int mOldDeviceOrientation = EOrientation.UNKNOWN.ordinal();
    private int mOrientation = EOrientation.DEFAULT.ordinal();
    private OrientationEventListener mOrientationEventListner;
    private int mOsDefaultOrientation = 1;
    private int mOsReversedOrientation = 9;
    private int mOsRotatedLeftOrientation = 8;
    private int mOsRotatedRightOrientation = 0;
    private int mRequestedAspectRatio = -1;
    private boolean mSetOrientation = false;
    private AIRWindowSurfaceView mView = null;
    private Activity m_activity = null;

    public enum EAspectRatio {
        UNKNOWN,
        PORTRAIT,
        LANDSCAPE
    }

    public enum EDefault {
        PORTRAIT,
        LANDSCAPE
    }

    public enum EOrientation {
        UNKNOWN,
        DEFAULT,
        ROTATED_LEFT,
        ROTATED_RIGHT,
        UPSIDE_DOWN
    }

    public native void nativeOrientationChanged(int i, int i2);

    public native boolean nativeOrientationChanging(int i, int i2);

    private OrientationManager() {
    }

    public static OrientationManager getOrientationManager() {
        if (sMgr == null) {
            sMgr = new OrientationManager();
        }
        return sMgr;
    }

    private boolean isReOrientingAllowed() {
        boolean z = false;
        if (this.mNamespaceVersion < AIR_NAMESPACE_VERSION_3_3) {
            return true;
        }
        if (this.mAutoOrients) {
            if (this.mRequestedAspectRatio == -1) {
                return true;
            }
            if (this.mFirstCreate) {
                z = true;
            }
            if (this.mRequestedAspectRatio == this.mOsDefaultOrientation) {
                if (this.mDeviceOrientation == EOrientation.DEFAULT.ordinal() || this.mDeviceOrientation == EOrientation.UPSIDE_DOWN.ordinal()) {
                    return true;
                }
            } else if (this.mDeviceOrientation == EOrientation.ROTATED_LEFT.ordinal() || this.mDeviceOrientation == EOrientation.ROTATED_RIGHT.ordinal()) {
                return true;
            }
        }
        return z;
    }

    private boolean setSensorBasedOrientation() {
        int i = this.mOrientation;
        boolean z = this.mRequestedAspectRatio != -1;
        if (this.mAutoOrients) {
            if (this.mSetOrientation && this.mNamespaceVersion >= AIR_NAMESPACE_VERSION_3_3) {
                this.mSetOrientation = false;
            }
            if (!z || this.mNamespaceVersion < AIR_NAMESPACE_VERSION_3_3) {
                this.m_activity.setRequestedOrientation(2);
                return true;
            } else if (this.mRequestedAspectRatio != this.mOsDefaultOrientation) {
                if (this.mDeviceOrientation == (this.mOsDefaultOrientation == 1 ? EOrientation.ROTATED_LEFT.ordinal() : EOrientation.ROTATED_RIGHT.ordinal())) {
                    this.m_activity.setRequestedOrientation(this.mRequestedAspectRatio);
                    return true;
                } else if (this.mOsDefaultOrientation == 1) {
                    this.m_activity.setRequestedOrientation(8);
                    return true;
                } else {
                    this.m_activity.setRequestedOrientation(9);
                    return true;
                }
            } else if (this.mDeviceOrientation == EOrientation.DEFAULT.ordinal()) {
                this.m_activity.setRequestedOrientation(this.mRequestedAspectRatio);
                return true;
            } else if (this.mDeviceOrientation == EOrientation.UPSIDE_DOWN.ordinal()) {
                this.m_activity.setRequestedOrientation(this.mOsReversedOrientation);
                return true;
            }
        }
        return false;
    }

    public void onActivityCreated(Activity activity, AIRWindowSurfaceView aIRWindowSurfaceView) {
        this.m_activity = activity;
        this.mView = aIRWindowSurfaceView;
        this.mHardKeyboardHidden = this.m_activity.getResources().getConfiguration().hardKeyboardHidden;
        if (this.mFirstCreate) {
            setDeviceDefault();
            setOrientationParamsFromMetaData();
        }
        this.mOrientationEventListner = new OrientationEventListener(this.m_activity.getApplicationContext(), 3) {
            public void onOrientationChanged(int i) {
                int ordinal = EOrientation.UNKNOWN.ordinal();
                if (i == -1) {
                    OrientationManager.this.mDeviceOrientation = EOrientation.UNKNOWN.ordinal();
                    ordinal = EOrientation.UNKNOWN.ordinal();
                } else if (i >= 45 && i < 135) {
                    OrientationManager.this.mDeviceOrientation = EOrientation.ROTATED_RIGHT.ordinal();
                    ordinal = EOrientation.ROTATED_LEFT.ordinal();
                } else if (i >= 135 && i < 225) {
                    OrientationManager.this.mDeviceOrientation = EOrientation.UPSIDE_DOWN.ordinal();
                    ordinal = EOrientation.UPSIDE_DOWN.ordinal();
                } else if (i >= 225 && i < 315) {
                    OrientationManager.this.mDeviceOrientation = EOrientation.ROTATED_LEFT.ordinal();
                    ordinal = EOrientation.ROTATED_RIGHT.ordinal();
                } else if ((i >= 0 && i < 45) || (i >= 315 && i < 360)) {
                    OrientationManager.this.mDeviceOrientation = EOrientation.DEFAULT.ordinal();
                    ordinal = EOrientation.DEFAULT.ordinal();
                }
                if (AndroidActivityWrapper.GetAndroidActivityWrapper().isApplicationLaunched() && OrientationManager.this.mAutoOrients && OrientationManager.this.mOldDeviceOrientation != OrientationManager.this.mDeviceOrientation && ordinal != EOrientation.UNKNOWN.ordinal() && OrientationManager.this.mOrientation != ordinal) {
                    int i2 = System.getInt(OrientationManager.this.m_activity.getContentResolver(), "accelerometer_rotation", 0);
                    if (!(OrientationManager.this.m_activity == null || i2 == 0 || !OrientationManager.this.isReOrientingAllowed())) {
                        if (OrientationManager.this.nativeOrientationChanging(OrientationManager.this.mOrientation, ordinal)) {
                            OrientationManager.this.setNearestOrientation(OrientationManager.this.mOrientation);
                        } else if (OrientationManager.this.setSensorBasedOrientation()) {
                            OrientationManager.this.nativeOrientationChanged(OrientationManager.this.mOrientation, ordinal);
                            OrientationManager.this.mOrientation = ordinal;
                        }
                        OrientationManager.this.mFinalOrientation = OrientationManager.this.mOrientation;
                    }
                } else if (OrientationManager.this.mAutoOrients && OrientationManager.this.mSetOrientation && OrientationManager.this.mOldDeviceOrientation != OrientationManager.this.mDeviceOrientation && OrientationManager.this.mOldDeviceOrientation != EOrientation.UNKNOWN.ordinal() && OrientationManager.this.mDeviceOrientation != EOrientation.UNKNOWN.ordinal() && OrientationManager.this.mNamespaceVersion < OrientationManager.AIR_NAMESPACE_VERSION_3_3) {
                    if (OrientationManager.this.m_activity != null) {
                        OrientationManager.this.m_activity.setRequestedOrientation(2);
                    }
                    OrientationManager.this.mSetOrientation = false;
                }
                OrientationManager.this.mOldDeviceOrientation = OrientationManager.this.mDeviceOrientation;
            }
        };
        AndroidActivityWrapper GetAndroidActivityWrapper = AndroidActivityWrapper.GetAndroidActivityWrapper();
        if (GetAndroidActivityWrapper.isScreenOn() && !GetAndroidActivityWrapper.isScreenLocked()) {
            if (!this.mFirstCreate) {
                applyLastOrientation();
            }
            this.mOrientation = getCurrentOrientation();
        }
        this.mFirstCreate = false;
    }

    public void onActivityDestroyed() {
        this.m_activity = null;
    }

    public void onActivityResumed() {
        enableEventListener(true);
    }

    public void onActivityPaused() {
        enableEventListener(false);
    }

    public void enableEventListener(boolean z) {
        if (z) {
            this.mOrientationEventListner.enable();
        } else {
            this.mOrientationEventListner.disable();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mAfterOrientation = getCurrentOrientation();
        this.mBeforeOrientation = this.mOrientation;
        if (this.mHardKeyboardHidden != configuration.hardKeyboardHidden) {
            this.mHardKeyboardHidden = configuration.hardKeyboardHidden;
            if (this.mAutoOrients && this.mSetOrientation) {
                if (this.m_activity != null) {
                    this.m_activity.setRequestedOrientation(2);
                }
                this.mSetOrientation = false;
            }
        }
        if (this.mBeforeOrientation == this.mAfterOrientation) {
            return;
        }
        if (this.mFinalOrientation == EOrientation.UNKNOWN.ordinal() || this.mAfterOrientation == this.mFinalOrientation) {
            this.mFinalOrientation = EOrientation.UNKNOWN.ordinal();
            this.mOrientation = this.mAfterOrientation;
            if (!AndroidActivityWrapper.GetAndroidActivityWrapper().isApplicationLaunched()) {
                return;
            }
            if (this.mView.getVisibleBoundHeight() == this.mView.getVisibleBoundWidth()) {
                nativeOrientationChanged(this.mBeforeOrientation, this.mAfterOrientation);
                this.mDispatchOrientationChangePending = false;
                return;
            }
            this.mDispatchOrientationChangePending = true;
        }
    }

    public int getOrientation() {
        this.mOrientation = getCurrentOrientation();
        return this.mOrientation;
    }

    public int getDeviceOrientation() {
        if (this.mHardKeyboardHidden != 1) {
            return this.mDeviceOrientation;
        }
        if (this.mOsDefaultOrientation == 1) {
            return EOrientation.ROTATED_LEFT.ordinal();
        }
        return EOrientation.DEFAULT.ordinal();
    }

    public void setOrientation(int i) {
        int i2 = this.mOrientation;
        if (VERSION.SDK_INT > 8) {
            setNearestOrientation(i);
            this.mSetOrientation = true;
            this.mOrientation = getCurrentOrientation();
        } else if (i == EOrientation.DEFAULT.ordinal()) {
            if (this.m_activity != null) {
                if (this.mOsDefaultOrientation == 1) {
                    this.m_activity.setRequestedOrientation(1);
                } else {
                    this.m_activity.setRequestedOrientation(0);
                }
                this.mSetOrientation = true;
            }
        } else if (i == EOrientation.ROTATED_RIGHT.ordinal()) {
            if (this.m_activity != null && this.mOsDefaultOrientation == 1) {
                this.m_activity.setRequestedOrientation(0);
                this.mSetOrientation = true;
            }
        } else if (i == EOrientation.ROTATED_LEFT.ordinal() && this.m_activity != null && this.mOsDefaultOrientation == 0) {
            this.m_activity.setRequestedOrientation(1);
            this.mSetOrientation = true;
        }
        int currentOrientation = getCurrentOrientation();
        if (this.mNamespaceVersion >= AIR_NAMESPACE_VERSION_3_8 && currentOrientation != i2) {
            nativeOrientationChanged(i2, currentOrientation);
        }
    }

    public void setNearestOrientation(int i) {
        if (this.m_activity == null) {
            return;
        }
        if (i == EOrientation.DEFAULT.ordinal()) {
            this.m_activity.setRequestedOrientation(this.mOsDefaultOrientation);
        } else if (i == EOrientation.ROTATED_LEFT.ordinal()) {
            this.m_activity.setRequestedOrientation(this.mOsRotatedLeftOrientation);
        } else if (i == EOrientation.ROTATED_RIGHT.ordinal()) {
            this.m_activity.setRequestedOrientation(this.mOsRotatedRightOrientation);
        } else if (i == EOrientation.UPSIDE_DOWN.ordinal()) {
            this.m_activity.setRequestedOrientation(this.mOsReversedOrientation);
        }
    }

    public void setAspectRatio(int i) {
        if (this.m_activity != null) {
            if (this.mNamespaceVersion < AIR_NAMESPACE_VERSION_3_3) {
                this.mSetOrientation = true;
            }
            if (i == EAspectRatio.PORTRAIT.ordinal()) {
                this.m_activity.setRequestedOrientation(1);
                this.mRequestedAspectRatio = 1;
            } else if (i == EAspectRatio.LANDSCAPE.ordinal()) {
                this.m_activity.setRequestedOrientation(0);
                this.mRequestedAspectRatio = 0;
            } else {
                this.mRequestedAspectRatio = -1;
                if (this.mAutoOrients) {
                    this.m_activity.setRequestedOrientation(2);
                }
            }
            this.mOrientation = getCurrentOrientation();
        }
    }

    public void setAutoOrients(boolean z) {
        if (this.m_activity != null) {
            this.mAutoOrients = z;
            if (!this.mAutoOrients) {
                this.m_activity.setRequestedOrientation(5);
            } else if (this.mNamespaceVersion < AIR_NAMESPACE_VERSION_3_3 || this.mRequestedAspectRatio == -1) {
                this.m_activity.setRequestedOrientation(2);
            }
        }
    }

    public boolean getAutoOrients() {
        return this.mAutoOrients;
    }

    public int[] getSupportedOrientations() {
        if (VERSION.SDK_INT <= 8) {
            int[] iArr = new int[2];
            if (this.mOsDefaultOrientation == 1) {
                iArr[0] = EOrientation.DEFAULT.ordinal();
                iArr[1] = EOrientation.ROTATED_RIGHT.ordinal();
                return iArr;
            }
            iArr[0] = EOrientation.DEFAULT.ordinal();
            iArr[1] = EOrientation.ROTATED_LEFT.ordinal();
            return iArr;
        }
        return new int[]{EOrientation.DEFAULT.ordinal(), EOrientation.ROTATED_LEFT.ordinal(), EOrientation.ROTATED_RIGHT.ordinal(), EOrientation.UPSIDE_DOWN.ordinal()};
    }

    private int getCurrentOrientation() {
        int ordinal = EOrientation.DEFAULT.ordinal();
        if (this.m_activity == null) {
            return ordinal;
        }
        int rotation = this.m_activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return EOrientation.DEFAULT.ordinal();
        }
        if (rotation == 1) {
            return EOrientation.ROTATED_RIGHT.ordinal();
        }
        if (rotation == 2) {
            return EOrientation.UPSIDE_DOWN.ordinal();
        }
        if (rotation == 3) {
            return EOrientation.ROTATED_LEFT.ordinal();
        }
        return ordinal;
    }

    private void setDeviceDefault() {
        Display defaultDisplay = this.m_activity.getWindow().getWindowManager().getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        int i = defaultDisplay.getHeight() >= defaultDisplay.getWidth() ? 1 : 0;
        int i2;
        if (rotation == 0 || rotation == 2) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if ((i == 0 || r0 == 0) && !(i == 0 && r0 == 0)) {
            this.mOsDefaultOrientation = 0;
            this.mOsRotatedLeftOrientation = 1;
            if (VERSION.SDK_INT <= 8) {
                this.mOsRotatedRightOrientation = this.mOsRotatedLeftOrientation;
                this.mOsReversedOrientation = this.mOsDefaultOrientation;
                return;
            }
            this.mOsRotatedRightOrientation = 9;
            this.mOsReversedOrientation = 8;
            return;
        }
        this.mOsDefaultOrientation = 1;
        this.mOsRotatedRightOrientation = 0;
        if (VERSION.SDK_INT <= 8) {
            this.mOsRotatedLeftOrientation = this.mOsRotatedRightOrientation;
            this.mOsReversedOrientation = this.mOsDefaultOrientation;
            return;
        }
        this.mOsRotatedLeftOrientation = 8;
        this.mOsReversedOrientation = 9;
    }

    private void setOrientationParamsFromMetaData() {
        try {
            Bundle bundle = this.m_activity.getPackageManager().getActivityInfo(this.m_activity.getComponentName(), 128).metaData;
            if (bundle != null) {
                Boolean bool = (Boolean) bundle.get("autoOrients");
                String str = (String) bundle.get("aspectRatio");
                this.mNamespaceVersion = bundle.getFloat("namespaceVersion");
                if (str != null) {
                    if (str.equals("portrait")) {
                        setAspectRatio(EAspectRatio.PORTRAIT.ordinal());
                    } else if (str.equals("landscape")) {
                        setAspectRatio(EAspectRatio.LANDSCAPE.ordinal());
                    }
                }
                if (bool != null && bool.booleanValue()) {
                    setAutoOrients(true);
                } else if (this.mNamespaceVersion >= AIR_NAMESPACE_VERSION_3_8 && (str == null || str.equals("any"))) {
                    setAutoOrients(false);
                } else if (this.mNamespaceVersion <= AIR_NAMESPACE_VERSION_3_8 && str == null) {
                    setAutoOrients(false);
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    private void applyLastOrientation() {
        if (this.mAutoOrients) {
            if (!this.mSetOrientation || this.mOldDeviceOrientation != this.mDeviceOrientation || this.mNamespaceVersion < AIR_NAMESPACE_VERSION_3_3) {
                setAutoOrients(this.mAutoOrients);
                this.mAfterOrientation = getCurrentOrientation();
                this.mBeforeOrientation = this.mOrientation;
                if (this.mBeforeOrientation != this.mAfterOrientation) {
                    boolean nativeOrientationChanging;
                    if (AndroidActivityWrapper.GetAndroidActivityWrapper().isApplicationLaunched()) {
                        nativeOrientationChanging = nativeOrientationChanging(this.mBeforeOrientation, this.mAfterOrientation);
                    } else {
                        nativeOrientationChanging = false;
                    }
                    if (nativeOrientationChanging) {
                        setNearestOrientation(this.mBeforeOrientation);
                        return;
                    }
                    this.mOrientation = this.mAfterOrientation;
                    if (!AndroidActivityWrapper.GetAndroidActivityWrapper().isApplicationLaunched()) {
                        return;
                    }
                    if (this.mView.getVisibleBoundHeight() == this.mView.getVisibleBoundWidth()) {
                        nativeOrientationChanged(this.mBeforeOrientation, this.mAfterOrientation);
                        this.mDispatchOrientationChangePending = false;
                        return;
                    }
                    this.mDispatchOrientationChangePending = true;
                }
            }
        } else if (this.mSetOrientation || (this.mNamespaceVersion >= AIR_NAMESPACE_VERSION_3_3 && this.mRequestedAspectRatio != -1)) {
            setOrientation(this.mOrientation);
        } else {
            setAutoOrients(this.mAutoOrients);
        }
    }
}
