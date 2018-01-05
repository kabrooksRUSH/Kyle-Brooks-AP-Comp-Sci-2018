package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
    public static final Creator<ParcelableEvent> CREATOR = new zzc();
    final int mVersionCode;
    final String zzGY;
    final String zzHP;
    final String zzaoB;
    final List<String> zzaoH;
    final boolean zzaoI;
    final boolean zzaoJ;
    final boolean zzaoK;
    final String zzaoL;
    final TextInsertedDetails zzaoM;
    final TextDeletedDetails zzaoN;
    final ValuesAddedDetails zzaoO;
    final ValuesRemovedDetails zzaoP;
    final ValuesSetDetails zzaoQ;
    final ValueChangedDetails zzaoR;
    final ReferenceShiftedDetails zzaoS;
    final ObjectChangedDetails zzaoT;
    final FieldChangedDetails zzaoU;

    ParcelableEvent(int versionCode, String sessionId, String userId, List<String> compoundOperationNames, boolean isLocal, boolean isUndo, boolean isRedo, String objectId, String objectType, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails, FieldChangedDetails fieldChangedDetails) {
        this.mVersionCode = versionCode;
        this.zzHP = sessionId;
        this.zzGY = userId;
        this.zzaoH = compoundOperationNames;
        this.zzaoI = isLocal;
        this.zzaoJ = isUndo;
        this.zzaoK = isRedo;
        this.zzaoB = objectId;
        this.zzaoL = objectType;
        this.zzaoM = textInsertedDetails;
        this.zzaoN = textDeletedDetails;
        this.zzaoO = valuesAddedDetails;
        this.zzaoP = valuesRemovedDetails;
        this.zzaoQ = valuesSetDetails;
        this.zzaoR = valueChangedDetails;
        this.zzaoS = referenceShiftedDetails;
        this.zzaoT = objectChangedDetails;
        this.zzaoU = fieldChangedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
