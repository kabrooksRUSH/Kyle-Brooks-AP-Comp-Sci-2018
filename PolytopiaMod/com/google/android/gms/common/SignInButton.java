package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzg.zza;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzaat;
    private OnClickListener zzaau;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzaau = null;
        setStyle(0, 0);
    }

    private static Button zza(Context context, int i, int i2) {
        Button com_google_android_gms_common_internal_zzab = new zzab(context);
        com_google_android_gms_common_internal_zzab.zza(context.getResources(), i, i2);
        return com_google_android_gms_common_internal_zzab;
    }

    private void zzai(Context context) {
        if (this.zzaat != null) {
            removeView(this.zzaat);
        }
        try {
            this.zzaat = zzaa.zzb(context, this.mSize, this.mColor);
        } catch (zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.zzaat = zza(context, this.mSize, this.mColor);
        }
        addView(this.zzaat);
        this.zzaat.setEnabled(isEnabled());
        this.zzaat.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.zzaau != null && view == this.zzaat) {
            this.zzaau.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.zzaat.setEnabled(enabled);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.zzaau = listener;
        if (this.zzaat != null) {
            this.zzaat.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.mColor);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        boolean z = buttonSize >= 0 && buttonSize < 3;
        zzx.zza(z, "Unknown button size %d", Integer.valueOf(buttonSize));
        z = colorScheme >= 0 && colorScheme < 2;
        zzx.zza(z, "Unknown color scheme %s", Integer.valueOf(colorScheme));
        this.mSize = buttonSize;
        this.mColor = colorScheme;
        zzai(getContext());
    }
}
