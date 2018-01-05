package com.adobe.flashruntime.air;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.adobe.air.AndroidActivityWrapper;
import com.adobe.air.FlashEGL;
import com.adobe.air.FlashEGLFactory;
import com.adobe.flashruntime.shared.VideoView;

public class VideoViewAIR extends VideoView {
    private static String kLogTag = "VideoViewAIR";
    protected AndroidActivityWrapper mActivityWrapper;
    private FlashEGL mVideoFlashEGL = null;

    class C00851 implements Callback {
        C00851() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            VideoViewAIR.this.nativeSetSurfaceSize(VideoViewAIR.this.getFPInstance(), i2, i3);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            VideoViewAIR.this.mActivityWrapper.planeStepCascade();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            VideoViewAIR.this.mActivityWrapper.planeBreakCascade();
        }
    }

    private native void nativeSetSurfaceSize(long j, int i, int i2);

    public VideoViewAIR(Context context, AndroidActivityWrapper androidActivityWrapper) {
        super(context);
        this.mActivityWrapper = androidActivityWrapper;
        this.mActivityWrapper.registerPlane(this, 7);
        this.mActivityWrapper.planeStepCascade();
        getHolder().addCallback(new C00851());
    }

    public FlashEGL getVideoEgl() {
        if (this.mVideoFlashEGL == null) {
            this.mVideoFlashEGL = FlashEGLFactory.CreateFlashEGL();
        }
        return this.mVideoFlashEGL;
    }
}
