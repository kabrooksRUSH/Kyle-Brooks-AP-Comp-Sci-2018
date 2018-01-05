package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class zzbm {
    private final int zzsp;
    private final int zzsq;
    private final int zzsr;
    private final zzbl zzss = new zzbo();

    class C05621 implements Comparator<String> {
        final /* synthetic */ zzbm zzst;

        C05621(zzbm com_google_android_gms_internal_zzbm) {
            this.zzst = com_google_android_gms_internal_zzbm;
        }

        public int compare(String s1, String s2) {
            return s2.length() - s1.length();
        }
    }

    class C05632 implements Comparator<com.google.android.gms.internal.zzbp.zza> {
        final /* synthetic */ zzbm zzst;

        C05632(zzbm com_google_android_gms_internal_zzbm) {
            this.zzst = com_google_android_gms_internal_zzbm;
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return zza((com.google.android.gms.internal.zzbp.zza) x0, (com.google.android.gms.internal.zzbp.zza) x1);
        }

        public int zza(com.google.android.gms.internal.zzbp.zza com_google_android_gms_internal_zzbp_zza, com.google.android.gms.internal.zzbp.zza com_google_android_gms_internal_zzbp_zza2) {
            return (int) (com_google_android_gms_internal_zzbp_zza.value - com_google_android_gms_internal_zzbp_zza2.value);
        }
    }

    static class zza {
        ByteArrayOutputStream zzsu = new ByteArrayOutputStream(4096);
        Base64OutputStream zzsv = new Base64OutputStream(this.zzsu, 10);

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.zzsv.close();
            } catch (Throwable e) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zzsu.close();
                byteArrayOutputStream = this.zzsu.toString();
            } catch (Throwable e2) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = "";
            } finally {
                this.zzsu = null;
                this.zzsv = null;
            }
            return byteArrayOutputStream;
        }

        public void write(byte[] data) throws IOException {
            this.zzsv.write(data);
        }
    }

    public zzbm(int i) {
        this.zzsq = i;
        this.zzsp = 6;
        this.zzsr = 0;
    }

    private String zzA(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzcz = zzcz();
        Arrays.sort(split, new C05621(this));
        int i = 0;
        while (i < split.length && i < this.zzsq) {
            if (split[i].trim().length() != 0) {
                try {
                    zzcz.write(this.zzss.zzz(split[i]));
                } catch (Throwable e) {
                    zzb.zzb("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return zzcz.toString();
    }

    String zzB(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzcz = zzcz();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzsq, new C05632(this));
        for (String zzD : split) {
            String[] zzD2 = zzbn.zzD(zzD);
            if (zzD2.length >= this.zzsp) {
                zzbp.zza(zzD2, this.zzsq, this.zzsp, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzcz.write(this.zzss.zzz(((com.google.android.gms.internal.zzbp.zza) it.next()).zzsx));
            } catch (Throwable e) {
                zzb.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzcz.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.zzsr) {
            case 0:
                return zzB(stringBuffer.toString());
            case 1:
                return zzA(stringBuffer.toString());
            default:
                return "";
        }
    }

    zza zzcz() {
        return new zza();
    }
}
