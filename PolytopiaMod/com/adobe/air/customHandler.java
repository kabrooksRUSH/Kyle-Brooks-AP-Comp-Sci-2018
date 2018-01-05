package com.adobe.air;

import android.os.Handler;
import android.os.Message;

public class customHandler extends Handler {
    public static final int KEY_MSG_ID = 1121;
    public static final int TIME_OUT_MSG_ID = 1119;
    public static final int TOUCH_MSG_ID = 1120;

    public native void callTimeoutFunction(int i, int i2);

    public native boolean nativeOnKeyCallback(int i, int i2, int i3, boolean z, boolean z2, boolean z3);

    public native boolean nativeOnTouchCallback(int i, float f, float f2, float f3, int i2, float f4, float f5, boolean z, float[] fArr, int i3);

    public void handleMessage(Message message) {
        if (message.what == TIME_OUT_MSG_ID) {
            callTimeoutFunction(message.arg1, message.arg2);
        } else if (message.what == TOUCH_MSG_ID) {
            TouchEventData touchEventData = (TouchEventData) message.obj;
            nativeOnTouchCallback(touchEventData.mTouchEventType, touchEventData.mXCoord, touchEventData.mYCoord, touchEventData.mPressure, touchEventData.mPointerID, touchEventData.mContactX, touchEventData.mContactY, touchEventData.mIsPrimaryPoint, touchEventData.mHistory, touchEventData.mMetaState);
        } else if (message.what == KEY_MSG_ID) {
            KeyEventData keyEventData = (KeyEventData) message.obj;
            nativeOnKeyCallback(keyEventData.mKeyAction, keyEventData.mKeyCode, keyEventData.mUnicode, keyEventData.mAlt, keyEventData.mShift, keyEventData.mSym);
        }
    }
}
