package com.pozirk.payment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class BillingActivity extends Activity {
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!Billing.getInstance().handlePurchaseResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProgressBar progress = new ProgressBar(this, null, 16842874);
        RelativeLayout layout = new RelativeLayout(this);
        LayoutParams params = new LayoutParams(-2, -2);
        params.addRule(13);
        layout.addView(progress, params);
        setContentView(layout);
        Billing.getInstance().purchase(this);
    }

    public void onDestroy() {
        Billing.getInstance().endPurchase(this);
        super.onDestroy();
    }
}
