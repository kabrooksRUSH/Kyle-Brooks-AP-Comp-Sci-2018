package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj.zza;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.internal.zzdz.zzb;
import com.google.android.gms.internal.zzdz.zzc;
import com.google.android.gms.internal.zzdz.zzd;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public final class zzgt extends zza {
    private static zzgt zzFA;
    private static final Object zzpy = new Object();
    private final Context mContext;
    private final zzgs zzFB;
    private final zzbr zzFC;
    private final zzdz zzrf;

    class C06415 implements zzb<zzbb> {
        final /* synthetic */ zzgt zzFL;

        C06415(zzgt com_google_android_gms_internal_zzgt) {
            this.zzFL = com_google_android_gms_internal_zzgt;
        }

        public void zza(zzbb com_google_android_gms_internal_zzbb) {
            com_google_android_gms_internal_zzbb.zza("/log", zzdj.zzxv);
        }

        public /* synthetic */ void zzc(Object obj) {
            zza((zzbb) obj);
        }
    }

    zzgt(Context context, zzbr com_google_android_gms_internal_zzbr, zzgs com_google_android_gms_internal_zzgs) {
        this.mContext = context;
        this.zzFB = com_google_android_gms_internal_zzgs;
        this.zzFC = com_google_android_gms_internal_zzbr;
        this.zzrf = new zzdz(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(8115000, 8115000, true), com_google_android_gms_internal_zzbr.zzdc(), new C06415(this), new zzc());
    }

    private static AdResponseParcel zza(Context context, zzdz com_google_android_gms_internal_zzdz, zzbr com_google_android_gms_internal_zzbr, zzgs com_google_android_gms_internal_zzgs, AdRequestInfoParcel adRequestInfoParcel) {
        AdResponseParcel adResponseParcel;
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Starting ad request from service.");
        zzby.initialize(context);
        final zzcg com_google_android_gms_internal_zzcg = new zzcg(((Boolean) zzby.zzuQ.get()).booleanValue(), "load_ad", adRequestInfoParcel.zzqn.zzte);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzEF != -1) {
            com_google_android_gms_internal_zzcg.zza(com_google_android_gms_internal_zzcg.zzb(adRequestInfoParcel.zzEF), "cts");
        }
        zzce zzdn = com_google_android_gms_internal_zzcg.zzdn();
        com_google_android_gms_internal_zzgs.zzFv.init();
        zzgy zzC = zzp.zzbB().zzC(context);
        if (zzC.zzGE == -1) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzEC : UUID.randomUUID().toString();
        final zzgv com_google_android_gms_internal_zzgv = new zzgv(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzEn.extras != null) {
            String string = adRequestInfoParcel.zzEn.extras.getString("_ad");
            if (string != null) {
                return zzgu.zza(context, adRequestInfoParcel, string);
            }
        }
        Location zzd = com_google_android_gms_internal_zzgs.zzFv.zzd(250);
        String zzc = com_google_android_gms_internal_zzgs.zzFw.zzc(context, adRequestInfoParcel.zzEo.packageName);
        List zza = com_google_android_gms_internal_zzgs.zzFu.zza(adRequestInfoParcel);
        JSONObject zza2 = zzgu.zza(context, adRequestInfoParcel, zzC, com_google_android_gms_internal_zzgs.zzFy.zzD(context), zzd, com_google_android_gms_internal_zzbr, zzc, com_google_android_gms_internal_zzgs.zzFx.zzax(adRequestInfoParcel.zzEp), zza);
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza2.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        if (zza2 == null) {
            return new AdResponseParcel(0);
        }
        final String jSONObject = zza2.toString();
        com_google_android_gms_internal_zzcg.zza(zzdn, "arc");
        final zzce zzdn2 = com_google_android_gms_internal_zzcg.zzdn();
        if (((Boolean) zzby.zzum.get()).booleanValue()) {
            final zzdz com_google_android_gms_internal_zzdz2 = com_google_android_gms_internal_zzdz;
            final zzgv com_google_android_gms_internal_zzgv2 = com_google_android_gms_internal_zzgv;
            final zzcg com_google_android_gms_internal_zzcg2 = com_google_android_gms_internal_zzcg;
            zzid.zzIE.post(new Runnable() {

                class C06362 implements zzis.zza {
                    final /* synthetic */ C06371 zzFI;

                    C06362(C06371 c06371) {
                        this.zzFI = c06371;
                    }

                    public void run() {
                    }
                }

                public void run() {
                    zzd zzdO = com_google_android_gms_internal_zzdz2.zzdO();
                    com_google_android_gms_internal_zzgv2.zzb(zzdO);
                    com_google_android_gms_internal_zzcg2.zza(zzdn2, "rwc");
                    final zzce zzdn = com_google_android_gms_internal_zzcg2.zzdn();
                    zzdO.zza(new zzis.zzc<zzbe>(this) {
                        final /* synthetic */ C06371 zzFI;

                        public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                            com_google_android_gms_internal_zzcg2.zza(zzdn, "jsf");
                            com_google_android_gms_internal_zzcg2.zzdo();
                            com_google_android_gms_internal_zzbe.zza("/invalidRequest", com_google_android_gms_internal_zzgv2.zzFR);
                            com_google_android_gms_internal_zzbe.zza("/loadAdURL", com_google_android_gms_internal_zzgv2.zzFS);
                            try {
                                com_google_android_gms_internal_zzbe.zza("AFMA_buildAdURL", jSONObject);
                            } catch (Throwable e) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e);
                            }
                        }

                        public /* synthetic */ void zzc(Object obj) {
                            zzb((zzbe) obj);
                        }
                    }, new C06362(this));
                }
            });
        } else {
            final Context context2 = context;
            final AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
            final zzce com_google_android_gms_internal_zzce = zzdn2;
            final String str = jSONObject;
            final zzbr com_google_android_gms_internal_zzbr2 = com_google_android_gms_internal_zzbr;
            zzid.zzIE.post(new Runnable() {
                public void run() {
                    zziz zza = zzp.zzbw().zza(context2, new AdSizeParcel(), false, false, null, adRequestInfoParcel2.zzqj);
                    if (zzp.zzby().zzgu()) {
                        zza.clearCache(true);
                    }
                    zza.getWebView().setWillNotDraw(true);
                    com_google_android_gms_internal_zzgv.zze(zza);
                    com_google_android_gms_internal_zzcg.zza(com_google_android_gms_internal_zzce, "rwc");
                    zzja.zza zzb = zzgt.zza(str, com_google_android_gms_internal_zzcg, com_google_android_gms_internal_zzcg.zzdn());
                    zzja zzhe = zza.zzhe();
                    zzhe.zza("/invalidRequest", com_google_android_gms_internal_zzgv.zzFR);
                    zzhe.zza("/loadAdURL", com_google_android_gms_internal_zzgv.zzFS);
                    zzhe.zza("/log", zzdj.zzxv);
                    zzhe.zza(zzb);
                    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Loading the JS library.");
                    zza.loadUrl(com_google_android_gms_internal_zzbr2.zzdc());
                }
            });
        }
        try {
            zzgx com_google_android_gms_internal_zzgx = (zzgx) com_google_android_gms_internal_zzgv.zzfS().get(10, TimeUnit.SECONDS);
            if (com_google_android_gms_internal_zzgx == null) {
                adResponseParcel = new AdResponseParcel(0);
                return adResponseParcel;
            } else if (com_google_android_gms_internal_zzgx.getErrorCode() != -2) {
                adResponseParcel = new AdResponseParcel(com_google_android_gms_internal_zzgx.getErrorCode());
                zzid.zzIE.post(new Runnable() {
                    public void run() {
                        com_google_android_gms_internal_zzgv.zzfT();
                        if (com_google_android_gms_internal_zzgv.zzfR() != null) {
                            com_google_android_gms_internal_zzgv.zzfR().release();
                        }
                    }
                });
                return adResponseParcel;
            } else {
                if (com_google_android_gms_internal_zzcg.zzdq() != null) {
                    com_google_android_gms_internal_zzcg.zza(com_google_android_gms_internal_zzcg.zzdq(), "rur");
                }
                jSONObject = null;
                if (com_google_android_gms_internal_zzgx.zzfW()) {
                    jSONObject = com_google_android_gms_internal_zzgs.zzFt.zzaw(adRequestInfoParcel.zzEo.packageName);
                }
                adResponseParcel = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzqj.zzJu, com_google_android_gms_internal_zzgx.getUrl(), jSONObject, zzc, com_google_android_gms_internal_zzgx, com_google_android_gms_internal_zzcg, com_google_android_gms_internal_zzgs);
                if (adResponseParcel.zzEW == 1) {
                    com_google_android_gms_internal_zzgs.zzFw.clearToken(context, adRequestInfoParcel.zzEo.packageName);
                }
                com_google_android_gms_internal_zzcg.zza(zzdn, "tts");
                adResponseParcel.zzEY = com_google_android_gms_internal_zzcg.zzdp();
                zzid.zzIE.post(/* anonymous class already generated */);
                return adResponseParcel;
            }
        } catch (Exception e2) {
            adResponseParcel = new AdResponseParcel(0);
            return adResponseParcel;
        } finally {
            zzid.zzIE.post(/* anonymous class already generated */);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.google.android.gms.internal.zzgx r19, com.google.android.gms.internal.zzcg r20, com.google.android.gms.internal.zzgs r21) {
        /*
        if (r20 == 0) goto L_0x00f6;
    L_0x0002:
        r2 = r20.zzdn();
        r3 = r2;
    L_0x0007:
        r8 = new com.google.android.gms.internal.zzgw;	 Catch:{ IOException -> 0x010e }
        r8.<init>(r13);	 Catch:{ IOException -> 0x010e }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x010e }
        r2.<init>();	 Catch:{ IOException -> 0x010e }
        r4 = "AdRequestServiceImpl: Sending request: ";
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x010e }
        r0 = r16;
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x010e }
        r2 = r2.toString();	 Catch:{ IOException -> 0x010e }
        com.google.android.gms.ads.internal.util.client.zzb.zzaF(r2);	 Catch:{ IOException -> 0x010e }
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x010e }
        r0 = r16;
        r4.<init>(r0);	 Catch:{ IOException -> 0x010e }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.zzp.zzbz();	 Catch:{ IOException -> 0x010e }
        r10 = r5.elapsedRealtime();	 Catch:{ IOException -> 0x010e }
        r6 = r2;
        r7 = r4;
    L_0x0036:
        if (r21 == 0) goto L_0x003f;
    L_0x0038:
        r0 = r21;
        r2 = r0.zzFz;	 Catch:{ IOException -> 0x010e }
        r2.zzfY();	 Catch:{ IOException -> 0x010e }
    L_0x003f:
        r2 = r7.openConnection();	 Catch:{ IOException -> 0x010e }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x010e }
        r4 = com.google.android.gms.ads.internal.zzp.zzbv();	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r4.zza(r14, r15, r5, r2);	 Catch:{ all -> 0x0100 }
        r4 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x0100 }
        if (r4 != 0) goto L_0x005a;
    L_0x0053:
        r4 = "x-afma-drt-cookie";
        r0 = r17;
        r2.addRequestProperty(r4, r0);	 Catch:{ all -> 0x0100 }
    L_0x005a:
        r4 = android.text.TextUtils.isEmpty(r18);	 Catch:{ all -> 0x0100 }
        if (r4 != 0) goto L_0x007a;
    L_0x0060:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0100 }
        r4.<init>();	 Catch:{ all -> 0x0100 }
        r5 = "Bearer ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0100 }
        r0 = r18;
        r4 = r4.append(r0);	 Catch:{ all -> 0x0100 }
        r4 = r4.toString();	 Catch:{ all -> 0x0100 }
        r5 = "Authorization";
        r2.addRequestProperty(r5, r4);	 Catch:{ all -> 0x0100 }
    L_0x007a:
        if (r19 == 0) goto L_0x00a6;
    L_0x007c:
        r4 = r19.zzfV();	 Catch:{ all -> 0x0100 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0100 }
        if (r4 != 0) goto L_0x00a6;
    L_0x0086:
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ all -> 0x0100 }
        r4 = r19.zzfV();	 Catch:{ all -> 0x0100 }
        r9 = r4.getBytes();	 Catch:{ all -> 0x0100 }
        r4 = r9.length;	 Catch:{ all -> 0x0100 }
        r2.setFixedLengthStreamingMode(r4);	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r4 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x00fa }
        r12 = r2.getOutputStream();	 Catch:{ all -> 0x00fa }
        r4.<init>(r12);	 Catch:{ all -> 0x00fa }
        r4.write(r9);	 Catch:{ all -> 0x01d0 }
        com.google.android.gms.internal.zzmt.zzb(r4);	 Catch:{ all -> 0x0100 }
    L_0x00a6:
        r9 = r2.getResponseCode();	 Catch:{ all -> 0x0100 }
        r12 = r2.getHeaderFields();	 Catch:{ all -> 0x0100 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r4) goto L_0x0136;
    L_0x00b2:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 >= r4) goto L_0x0136;
    L_0x00b6:
        r6 = r7.toString();	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r4 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0130 }
        r7 = r2.getInputStream();	 Catch:{ all -> 0x0130 }
        r4.<init>(r7);	 Catch:{ all -> 0x0130 }
        r5 = com.google.android.gms.ads.internal.zzp.zzbv();	 Catch:{ all -> 0x01cd }
        r5 = r5.zza(r4);	 Catch:{ all -> 0x01cd }
        com.google.android.gms.internal.zzmt.zzb(r4);	 Catch:{ all -> 0x0100 }
        zza(r6, r12, r5, r9);	 Catch:{ all -> 0x0100 }
        r8.zzb(r6, r12, r5);	 Catch:{ all -> 0x0100 }
        if (r20 == 0) goto L_0x00e4;
    L_0x00d7:
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r6 = "ufe";
        r4[r5] = r6;	 Catch:{ all -> 0x0100 }
        r0 = r20;
        r0.zza(r3, r4);	 Catch:{ all -> 0x0100 }
    L_0x00e4:
        r3 = r8.zzj(r10);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x00f4;
    L_0x00ed:
        r0 = r21;
        r2 = r0.zzFz;	 Catch:{ IOException -> 0x010e }
        r2.zzfZ();	 Catch:{ IOException -> 0x010e }
    L_0x00f4:
        r2 = r3;
    L_0x00f5:
        return r2;
    L_0x00f6:
        r2 = 0;
        r3 = r2;
        goto L_0x0007;
    L_0x00fa:
        r3 = move-exception;
        r4 = r5;
    L_0x00fc:
        com.google.android.gms.internal.zzmt.zzb(r4);	 Catch:{ all -> 0x0100 }
        throw r3;	 Catch:{ all -> 0x0100 }
    L_0x0100:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x010d;
    L_0x0106:
        r0 = r21;
        r2 = r0.zzFz;	 Catch:{ IOException -> 0x010e }
        r2.zzfZ();	 Catch:{ IOException -> 0x010e }
    L_0x010d:
        throw r3;	 Catch:{ IOException -> 0x010e }
    L_0x010e:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Error while connecting to ad server: ";
        r3 = r3.append(r4);
        r2 = r2.getMessage();
        r2 = r3.append(r2);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r2);
        r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x00f5;
    L_0x0130:
        r3 = move-exception;
        r4 = r5;
    L_0x0132:
        com.google.android.gms.internal.zzmt.zzb(r4);	 Catch:{ all -> 0x0100 }
        throw r3;	 Catch:{ all -> 0x0100 }
    L_0x0136:
        r4 = r7.toString();	 Catch:{ all -> 0x0100 }
        r5 = 0;
        zza(r4, r12, r5, r9);	 Catch:{ all -> 0x0100 }
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 < r4) goto L_0x018f;
    L_0x0142:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 >= r4) goto L_0x018f;
    L_0x0146:
        r4 = "Location";
        r4 = r2.getHeaderField(r4);	 Catch:{ all -> 0x0100 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0100 }
        if (r5 == 0) goto L_0x016b;
    L_0x0152:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r3);	 Catch:{ all -> 0x0100 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0100 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x0169;
    L_0x0162:
        r0 = r21;
        r2 = r0.zzFz;	 Catch:{ IOException -> 0x010e }
        r2.zzfZ();	 Catch:{ IOException -> 0x010e }
    L_0x0169:
        r2 = r3;
        goto L_0x00f5;
    L_0x016b:
        r5 = new java.net.URL;	 Catch:{ all -> 0x0100 }
        r5.<init>(r4);	 Catch:{ all -> 0x0100 }
        r4 = r6 + 1;
        r6 = 5;
        if (r4 <= r6) goto L_0x01ba;
    L_0x0175:
        r3 = "Too many redirects.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r3);	 Catch:{ all -> 0x0100 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0100 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x018c;
    L_0x0185:
        r0 = r21;
        r2 = r0.zzFz;	 Catch:{ IOException -> 0x010e }
        r2.zzfZ();	 Catch:{ IOException -> 0x010e }
    L_0x018c:
        r2 = r3;
        goto L_0x00f5;
    L_0x018f:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0100 }
        r3.<init>();	 Catch:{ all -> 0x0100 }
        r4 = "Received error HTTP response code: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0100 }
        r3 = r3.append(r9);	 Catch:{ all -> 0x0100 }
        r3 = r3.toString();	 Catch:{ all -> 0x0100 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r3);	 Catch:{ all -> 0x0100 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0100 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x01b7;
    L_0x01b0:
        r0 = r21;
        r2 = r0.zzFz;	 Catch:{ IOException -> 0x010e }
        r2.zzfZ();	 Catch:{ IOException -> 0x010e }
    L_0x01b7:
        r2 = r3;
        goto L_0x00f5;
    L_0x01ba:
        r8.zzh(r12);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x01c9;
    L_0x01c2:
        r0 = r21;
        r2 = r0.zzFz;	 Catch:{ IOException -> 0x010e }
        r2.zzfZ();	 Catch:{ IOException -> 0x010e }
    L_0x01c9:
        r6 = r4;
        r7 = r5;
        goto L_0x0036;
    L_0x01cd:
        r3 = move-exception;
        goto L_0x0132;
    L_0x01d0:
        r3 = move-exception;
        goto L_0x00fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgt.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzgx, com.google.android.gms.internal.zzcg, com.google.android.gms.internal.zzgs):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzgt zza(Context context, zzbr com_google_android_gms_internal_zzbr, zzgs com_google_android_gms_internal_zzgs) {
        zzgt com_google_android_gms_internal_zzgt;
        synchronized (zzpy) {
            if (zzFA == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzFA = new zzgt(context, com_google_android_gms_internal_zzbr, com_google_android_gms_internal_zzgs);
            }
            com_google_android_gms_internal_zzgt = zzFA;
        }
        return com_google_android_gms_internal_zzgt;
    }

    private static zzja.zza zza(final String str, final zzcg com_google_android_gms_internal_zzcg, final zzce com_google_android_gms_internal_zzce) {
        return new zzja.zza() {
            public void zza(zziz com_google_android_gms_internal_zziz, boolean z) {
                com_google_android_gms_internal_zzcg.zza(com_google_android_gms_internal_zzce, "jsf");
                com_google_android_gms_internal_zzcg.zzdo();
                com_google_android_gms_internal_zziz.zza("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzN(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.m12v("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.m12v("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        com.google.android.gms.ads.internal.util.client.zzb.m12v("      " + str32);
                    }
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.m12v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT) {
                    com.google.android.gms.ads.internal.util.client.zzb.m12v(str2.substring(i2, Math.min(str2.length(), i2 + CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT)));
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.m12v("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.m12v("  Response Code:\n    " + i + "\n}");
        }
    }

    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final zzk com_google_android_gms_ads_internal_request_zzk) {
        zzp.zzby().zzb(this.mContext, adRequestInfoParcel.zzqj);
        zzid.zzb(new Runnable(this) {
            final /* synthetic */ zzgt zzFL;

            public void run() {
                AdResponseParcel zze;
                try {
                    zze = this.zzFL.zze(adRequestInfoParcel);
                } catch (Throwable e) {
                    zzp.zzby().zzc(e, true);
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response due to an Exception.", e);
                    zze = null;
                }
                if (zze == null) {
                    zze = new AdResponseParcel(0);
                }
                try {
                    com_google_android_gms_ads_internal_request_zzk.zzb(zze);
                } catch (Throwable e2) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", e2);
                }
            }
        });
    }

    public AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzrf, this.zzFC, this.zzFB, adRequestInfoParcel);
    }
}
