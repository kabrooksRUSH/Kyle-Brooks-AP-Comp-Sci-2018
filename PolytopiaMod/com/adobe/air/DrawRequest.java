package com.adobe.air;

import android.graphics.Bitmap;

/* compiled from: AIRWindowThreadedSurfaceView */
class DrawRequest {
    public static final int messageID = 1009;
    public int bgColor;
    public Bitmap bm;
    public int dstHt;
    public int dstWd;
    public int dstX;
    public int dstY;
    public boolean fullsc = false;
    public int ht;
    public boolean scale = false;
    public int wd;
    public int f0x;
    public int f1y;

    public DrawRequest(int i, int i2, int i3, int i4, Bitmap bitmap) {
        this.f0x = i;
        this.f1y = i2;
        this.wd = i3;
        this.ht = i4;
        this.bm = bitmap;
        this.scale = false;
    }

    public DrawRequest(int i, int i2, int i3, int i4, Bitmap bitmap, int i5, int i6, int i7, int i8, boolean z, int i9) {
        this.f0x = i;
        this.f1y = i2;
        this.wd = i3;
        this.ht = i4;
        this.bm = bitmap;
        this.dstX = i5;
        this.dstY = i6;
        this.dstWd = i7;
        this.dstHt = i8;
        this.scale = true;
        this.fullsc = z;
        this.bgColor = i9;
    }
}
