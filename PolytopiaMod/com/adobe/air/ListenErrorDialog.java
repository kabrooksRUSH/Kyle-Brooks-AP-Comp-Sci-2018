package com.adobe.air;

import air.com.midjiwan.polytopia.C0003R;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adobe.air.AndroidLocale.STRING_ID;

public final class ListenErrorDialog {
    private final int ICON_ERROR = C0003R.drawable.banner;
    private final int PADDING_LENGTH = 20;
    private final Activity mActivity;
    private final String mDebuggerPort;

    class C00501 implements OnClickListener {
        C00501() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ListenErrorDialog.this.gotResultFromDialog(false);
        }
    }

    class C00512 implements OnClickListener {
        C00512() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ListenErrorDialog.this.gotResultFromDialog(true);
        }
    }

    class C00523 implements OnCancelListener {
        C00523() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            ListenErrorDialog.this.gotResultFromDialog(false);
        }
    }

    ListenErrorDialog(Activity activity, int i) {
        this.mActivity = activity;
        this.mDebuggerPort = Integer.toString(i);
    }

    public void createAndShowDialog() {
        View linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        View textView = new TextView(this.mActivity);
        textView.setText(AndroidLocale.GetLocalizedString(STRING_ID.IDA_DEBUGGER_LISTEN_ERROR_MESSAGE).replaceFirst("%1", this.mDebuggerPort));
        textView.setLayoutParams(new LayoutParams(-2, -1));
        textView.setPadding(20, 20, 20, 20);
        linearLayout.addView(textView);
        Builder builder = new Builder(this.mActivity);
        builder.setIcon(C0003R.drawable.banner);
        builder.setView(linearLayout);
        builder.setTitle(AndroidLocale.GetLocalizedString(STRING_ID.IDA_DEBUGGER_LISTEN_ERROR_TITLE));
        builder.setPositiveButton(AndroidLocale.GetLocalizedString(STRING_ID.IDA_CANCEL), new C00501());
        builder.setNegativeButton(AndroidLocale.GetLocalizedString(STRING_ID.IDA_CONTINUE), new C00512());
        builder.setOnCancelListener(new C00523());
        builder.show();
    }

    public void gotResultFromDialog(boolean z) {
        AndroidActivityWrapper GetAndroidActivityWrapper = AndroidActivityWrapper.GetAndroidActivityWrapper();
        if (z) {
            GetAndroidActivityWrapper.gotResultFromDialog(false, "");
        } else {
            exitGracefully();
        }
    }

    private void exitGracefully() {
        System.exit(0);
    }
}
