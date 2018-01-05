package com.adobe.air;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.adobe.air.ShakeListener.Listener;
import com.adobe.air.wand.WandActivity;
import java.lang.Thread.State;
import java.util.List;

public class ShakeListenerService extends Service {
    private final String AIR_WAND_CLASS_NAME = "com.adobe.air.wand.WandActivity";
    private BackgroundThread backGroundThread = null;
    private ShakeListener mShakeListener;
    private Context mcontext;

    class BackgroundThread extends Thread {

        class C00691 implements Listener {
            C00691() {
            }

            public void onShake() {
                List runningTasks = ((ActivityManager) ShakeListenerService.this.getApplicationContext().getSystemService("activity")).getRunningTasks(1);
                if (!runningTasks.isEmpty()) {
                    ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
                    if (componentName.getPackageName().equals(ShakeListenerService.this.getApplicationContext().getPackageName()) && !componentName.getClassName().equalsIgnoreCase("com.adobe.air.wand.WandActivity")) {
                        Intent intent = new Intent(ShakeListenerService.this.getApplicationContext(), WandActivity.class);
                        intent.setFlags(272629760);
                        ShakeListenerService.this.startActivity(intent);
                    }
                }
            }
        }

        public BackgroundThread(Context context) {
            ShakeListenerService.this.mcontext = context;
        }

        public void run() {
            try {
                ShakeListenerService.this.mShakeListener = new ShakeListener(ShakeListenerService.this.mcontext);
                ShakeListenerService.this.mShakeListener.registerListener(new C00691());
            } catch (Exception e) {
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (this.backGroundThread == null) {
            this.backGroundThread = new BackgroundThread(getApplicationContext());
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.backGroundThread == null) {
            this.backGroundThread = new BackgroundThread(getApplicationContext());
        }
        if (this.backGroundThread.getState() == State.NEW || this.backGroundThread.getState() == State.TERMINATED) {
            if (this.backGroundThread.getState() == State.TERMINATED) {
                this.backGroundThread = new BackgroundThread(getApplicationContext());
            }
            this.backGroundThread.start();
        }
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.backGroundThread != null) {
            try {
                this.backGroundThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.backGroundThread = null;
        }
    }
}
