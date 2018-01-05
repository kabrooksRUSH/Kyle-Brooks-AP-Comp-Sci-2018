package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public class zzig {
    private final String[] zzIO;
    private final double[] zzIP;
    private final double[] zzIQ;
    private final int[] zzIR;
    private int zzIS;

    public static class zza {
        public final int count;
        public final String name;
        public final double zzIT;
        public final double zzIU;
        public final double zzIV;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzIU = d;
            this.zzIT = d2;
            this.zzIV = d3;
            this.count = i;
        }

        public boolean equals(Object other) {
            if (!(other instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzig_zza = (zza) other;
            return zzw.equal(this.name, com_google_android_gms_internal_zzig_zza.name) && this.zzIT == com_google_android_gms_internal_zzig_zza.zzIT && this.zzIU == com_google_android_gms_internal_zzig_zza.zzIU && this.count == com_google_android_gms_internal_zzig_zza.count && Double.compare(this.zzIV, com_google_android_gms_internal_zzig_zza.zzIV) == 0;
        }

        public int hashCode() {
            return zzw.hashCode(this.name, Double.valueOf(this.zzIT), Double.valueOf(this.zzIU), Double.valueOf(this.zzIV), Integer.valueOf(this.count));
        }

        public String toString() {
            return zzw.zzv(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzIU)).zzg("maxBound", Double.valueOf(this.zzIT)).zzg("percent", Double.valueOf(this.zzIV)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public static class zzb {
        private final List<String> zzIW = new ArrayList();
        private final List<Double> zzIX = new ArrayList();
        private final List<Double> zzIY = new ArrayList();

        public zzb zza(String str, double d, double d2) {
            int i = 0;
            while (i < this.zzIW.size()) {
                double doubleValue = ((Double) this.zzIY.get(i)).doubleValue();
                double doubleValue2 = ((Double) this.zzIX.get(i)).doubleValue();
                if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                    break;
                }
                i++;
            }
            this.zzIW.add(i, str);
            this.zzIY.add(i, Double.valueOf(d));
            this.zzIX.add(i, Double.valueOf(d2));
            return this;
        }

        public zzig zzgK() {
            return new zzig();
        }
    }

    private zzig(zzb com_google_android_gms_internal_zzig_zzb) {
        int size = com_google_android_gms_internal_zzig_zzb.zzIX.size();
        this.zzIO = (String[]) com_google_android_gms_internal_zzig_zzb.zzIW.toArray(new String[size]);
        this.zzIP = zzg(com_google_android_gms_internal_zzig_zzb.zzIX);
        this.zzIQ = zzg(com_google_android_gms_internal_zzig_zzb.zzIY);
        this.zzIR = new int[size];
        this.zzIS = 0;
    }

    private double[] zzg(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<zza> getBuckets() {
        List<zza> arrayList = new ArrayList(this.zzIO.length);
        for (int i = 0; i < this.zzIO.length; i++) {
            arrayList.add(new zza(this.zzIO[i], this.zzIQ[i], this.zzIP[i], ((double) this.zzIR[i]) / ((double) this.zzIS), this.zzIR[i]));
        }
        return arrayList;
    }

    public void zza(double d) {
        this.zzIS++;
        int i = 0;
        while (i < this.zzIQ.length) {
            if (this.zzIQ[i] <= d && d < this.zzIP[i]) {
                int[] iArr = this.zzIR;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.zzIQ[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
