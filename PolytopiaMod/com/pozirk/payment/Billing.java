package com.pozirk.payment;

import android.app.Activity;
import android.content.Intent;
import com.android.payment.utils.IabHelper;
import com.android.payment.utils.IabHelper.OnConsumeFinishedListener;
import com.android.payment.utils.IabHelper.OnIabPurchaseFinishedListener;
import com.android.payment.utils.IabHelper.OnIabSetupFinishedListener;
import com.android.payment.utils.IabHelper.QueryInventoryFinishedListener;
import com.android.payment.utils.IabResult;
import com.android.payment.utils.Inventory;
import com.android.payment.utils.Purchase;
import com.android.payment.utils.SkuDetails;
import java.util.List;

public class Billing {
    static final int RC_REQUEST = 20003;
    protected static Billing _instance = null;
    Activity _act;
    ExtensionContext _ctx;
    IabHelper _helper;
    Inventory _inventory;
    OnConsumeFinishedListener _onConsumeFinished = new C07463();
    OnIabPurchaseFinishedListener _onPurchase = new C07441();
    QueryInventoryFinishedListener _onRestore = new C07452();
    String _payload;
    String _sku;
    String _type;

    class C07441 implements OnIabPurchaseFinishedListener {
        C07441() {
        }

        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            if (result.isFailure()) {
                if (result.getResponse() == 7) {
                    Billing.this._ctx.dispatchStatusEventAsync("PURCHASE_ALREADY_OWNED", Billing.this._sku);
                } else {
                    Billing.this._ctx.dispatchStatusEventAsync("PURCHASE_ERROR", result.getMessage());
                }
            } else if (purchase.getSku().equals(Billing.this._sku)) {
                Billing.this._ctx.dispatchStatusEventAsync("PURCHASE_SUCCESS", purchase.getSku());
            } else {
                Billing.this._ctx.dispatchStatusEventAsync("PURCHASE_ERROR", purchase.getSku());
            }
            Billing.getInstance()._act.finish();
            Billing.this._act = null;
        }
    }

    class C07452 implements QueryInventoryFinishedListener {
        C07452() {
        }

        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            if (result.isFailure()) {
                Billing.this._ctx.dispatchStatusEventAsync("RESTORE_ERROR", result.getMessage());
                return;
            }
            Billing.getInstance()._inventory = inventory;
            Billing.this._ctx.dispatchStatusEventAsync("RESTORE_SUCCESS", "ku-ku");
        }
    }

    class C07463 implements OnConsumeFinishedListener {
        C07463() {
        }

        public void onConsumeFinished(Purchase purchase, IabResult result) {
            if (result.isSuccess()) {
                Billing.this._ctx.dispatchStatusEventAsync("CONSUME_SUCCESS", purchase.getSku());
            } else {
                Billing.this._ctx.dispatchStatusEventAsync("CONSUME_ERROR", result.getMessage());
            }
        }
    }

    class C07474 implements OnIabSetupFinishedListener {
        C07474() {
        }

        public void onIabSetupFinished(IabResult result) {
            if (result.isSuccess()) {
                Billing.this._ctx.dispatchStatusEventAsync("INIT_SUCCESS", "ku-ku");
            } else {
                Billing.this._ctx.dispatchStatusEventAsync("INIT_ERROR", result.getMessage());
            }
        }
    }

    public void schedulePurchase(String sku, String type, String payload) {
        this._sku = sku;
        this._type = type;
        this._payload = payload;
    }

    public void purchase(Activity act) {
        if (!this._helper.isAsyncInProgress()) {
            this._act = act;
            this._helper.launchPurchaseFlow(act, this._sku, this._type, RC_REQUEST, this._onPurchase, this._payload);
        }
    }

    public Activity activity() {
        return this._act;
    }

    public void endPurchase(Activity act) {
        if (act == this._act) {
            this._act = null;
            this._helper.flagEndAsync();
        }
    }

    public boolean handlePurchaseResult(int requestCode, int resultCode, Intent data) {
        return this._helper.handleActivityResult(requestCode, resultCode, data);
    }

    public void restore(List<String> items, List<String> subs) {
        this._helper.queryInventoryAsync(true, items, subs, this._onRestore);
    }

    public void consume(String sku) {
        if (this._inventory != null) {
            Purchase purchase = this._inventory.getPurchase(sku);
            if (purchase != null) {
                this._helper.consumeAsync(purchase, this._onConsumeFinished);
                return;
            } else {
                this._ctx.dispatchStatusEventAsync("CONSUME_ERROR", "Purchase not found.");
                return;
            }
        }
        this._ctx.dispatchStatusEventAsync("CONSUME_ERROR", "Can't consume a product, restore transactions first.");
    }

    public Purchase getPurchaseDetails(String sku) {
        if (this._inventory != null) {
            return this._inventory.getPurchase(sku);
        }
        return null;
    }

    public SkuDetails getSKuDetails(String sku) {
        if (this._inventory != null) {
            return this._inventory.getSkuDetails(sku);
        }
        return null;
    }

    public static Billing getInstance() {
        if (_instance == null) {
            _instance = new Billing();
        }
        return _instance;
    }

    public void init(Activity act, ExtensionContext ctx, String base64EncodedPublicKey) {
        this._ctx = ctx;
        this._helper = new IabHelper(act, base64EncodedPublicKey);
        this._helper.startSetup(new C07474());
    }

    public void dispose() {
        if (this._helper != null) {
            this._helper.dispose();
        }
        this._helper = null;
    }

    protected Billing() {
    }
}
