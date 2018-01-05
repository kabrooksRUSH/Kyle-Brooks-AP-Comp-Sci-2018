package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR = new zzbb();
    final int mVersionCode;
    final int zzaho;
    final ChangeEvent zzame;
    final CompletionEvent zzamf;
    final QueryResultEventParcelable zzamg;
    final ChangesAvailableEvent zzamh;
    final ProgressEvent zzami;

    OnEventResponse(int versionCode, int eventType, ChangeEvent changeEvent, CompletionEvent completionEvent, QueryResultEventParcelable queryResultEvent, ChangesAvailableEvent changesAvailableEvent, ProgressEvent progressEvent) {
        this.mVersionCode = versionCode;
        this.zzaho = eventType;
        this.zzame = changeEvent;
        this.zzamf = completionEvent;
        this.zzamg = queryResultEvent;
        this.zzamh = changesAvailableEvent;
        this.zzami = progressEvent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbb.zza(this, dest, flags);
    }

    public DriveEvent zzrA() {
        switch (this.zzaho) {
            case 1:
                return this.zzame;
            case 2:
                return this.zzamf;
            case 3:
                return this.zzamg;
            case 4:
                return this.zzamh;
            case 5:
            case 6:
                return this.zzami;
            default:
                throw new IllegalStateException("Unexpected event type " + this.zzaho);
        }
    }
}
