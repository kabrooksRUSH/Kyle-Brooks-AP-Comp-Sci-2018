package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.internal.zzmx;
import java.lang.ref.WeakReference;

public class PopupManager {
    protected GamesClientImpl zzawM;
    protected PopupLocationInfo zzawN;

    public static final class PopupLocationInfo {
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder zzawO;
        public int zzawP;

        private PopupLocationInfo(int gravity, IBinder windowToken) {
            this.zzawP = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = gravity;
            this.zzawO = windowToken;
        }

        public Bundle zzve() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.zzawP);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
        private boolean zzavm = false;
        private WeakReference<View> zzawQ;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int gravity) {
            super(gamesClientImpl, gravity);
        }

        private void zzp(View view) {
            int i = -1;
            if (zzmx.zzqz()) {
                Display display = view.getDisplay();
                if (display != null) {
                    i = display.getDisplayId();
                }
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.zzawN.zzawP = i;
            this.zzawN.zzawO = windowToken;
            this.zzawN.left = iArr[0];
            this.zzawN.top = iArr[1];
            this.zzawN.right = iArr[0] + width;
            this.zzawN.bottom = iArr[1] + height;
            if (this.zzavm) {
                zzvf();
                this.zzavm = false;
            }
        }

        public void onGlobalLayout() {
            if (this.zzawQ != null) {
                View view = (View) this.zzawQ.get();
                if (view != null) {
                    zzp(view);
                }
            }
        }

        public void onViewAttachedToWindow(View v) {
            zzp(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.zzawM.zzuT();
            v.removeOnAttachStateChangeListener(this);
        }

        protected void zzfY(int i) {
            this.zzawN = new PopupLocationInfo(i, null);
        }

        public void zzo(View view) {
            View view2;
            Context context;
            this.zzawM.zzuT();
            if (this.zzawQ != null) {
                view2 = (View) this.zzawQ.get();
                context = this.zzawM.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (zzmx.zzqy()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.zzawQ = null;
            context = this.zzawM.getContext();
            if (view == null && (context instanceof Activity)) {
                view2 = ((Activity) context).findViewById(16908290);
                if (view2 == null) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                GamesLog.zzy("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
                view = view2;
            }
            if (view != null) {
                zzp(view);
                this.zzawQ = new WeakReference(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            GamesLog.zzz("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void zzvf() {
            if (this.zzawN.zzawO != null) {
                super.zzvf();
            } else {
                this.zzavm = this.zzawQ != null;
            }
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int gravity) {
        this.zzawM = gamesClientImpl;
        zzfY(gravity);
    }

    public static PopupManager zza(GamesClientImpl gamesClientImpl, int i) {
        return zzmx.zzqv() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    public void setGravity(int gravity) {
        this.zzawN.gravity = gravity;
    }

    protected void zzfY(int i) {
        this.zzawN = new PopupLocationInfo(i, new Binder());
    }

    public void zzo(View view) {
    }

    public void zzvf() {
        this.zzawM.zza(this.zzawN.zzawO, this.zzawN.zzve());
    }

    public Bundle zzvg() {
        return this.zzawN.zzve();
    }

    public IBinder zzvh() {
        return this.zzawN.zzawO;
    }

    public PopupLocationInfo zzvi() {
        return this.zzawN;
    }
}
