package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.drive.ExecutionOptions;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public final class zzdj {
    public static final zzdk zzxA = new zzdi();
    public static final zzdk zzxo = new C05731();
    public static final zzdk zzxp = new C05753();
    public static final zzdk zzxq = new C05764();
    public static final zzdk zzxr = new C05775();
    public static final zzdk zzxs = new C05786();
    public static final zzdk zzxt = new C05797();
    public static final zzdk zzxu = new C05808();
    public static final zzdk zzxv = new C05819();
    public static final zzdk zzxw = new zzdk() {
        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                zzan zzhg = com_google_android_gms_internal_zziz.zzhg();
                if (zzhg != null) {
                    zzhg.zzab().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzb.zzaH("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzdk zzxx = new C05742();
    public static final zzdk zzxy = new zzds();
    public static final zzdk zzxz = new zzdw();

    static class C05731 implements zzdk {
        C05731() {
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
        }
    }

    static class C05742 implements zzdk {
        C05742() {
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            if (((Boolean) zzby.zzvs.get()).booleanValue()) {
                com_google_android_gms_internal_zziz.zzE(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    static class C05753 implements zzdk {
        C05753() {
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzb.zzaH("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = com_google_android_gms_internal_zziz.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null));
            }
            com_google_android_gms_internal_zziz.zzb("openableURLs", hashMap);
        }
    }

    static class C05764 implements zzdk {
        C05764() {
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            PackageManager packageManager = com_google_android_gms_internal_zziz.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null);
                            } catch (Throwable e) {
                                zzb.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            zzb.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    com_google_android_gms_internal_zziz.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    com_google_android_gms_internal_zziz.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                com_google_android_gms_internal_zziz.zzb("openableIntents", new JSONObject());
            }
        }
    }

    static class C05775 implements zzdk {
        C05775() {
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzb.zzaH("URL missing from click GMSG.");
                return;
            }
            Uri zza;
            Uri parse = Uri.parse(str);
            try {
                zzan zzhg = com_google_android_gms_internal_zziz.zzhg();
                if (zzhg != null && zzhg.zzb(parse)) {
                    zza = zzhg.zza(parse, com_google_android_gms_internal_zziz.getContext());
                    new zzij(com_google_android_gms_internal_zziz.getContext(), com_google_android_gms_internal_zziz.zzhh().zzJu, zza.toString()).zzgz();
                }
            } catch (zzao e) {
                zzb.zzaH("Unable to append parameter to URL: " + str);
            }
            zza = parse;
            new zzij(com_google_android_gms_internal_zziz.getContext(), com_google_android_gms_internal_zziz.zzhh().zzJu, zza.toString()).zzgz();
        }
    }

    static class C05786 implements zzdk {
        C05786() {
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            zzd zzhc = com_google_android_gms_internal_zziz.zzhc();
            if (zzhc != null) {
                zzhc.close();
                return;
            }
            zzhc = com_google_android_gms_internal_zziz.zzhd();
            if (zzhc != null) {
                zzhc.close();
            } else {
                zzb.zzaH("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    }

    static class C05797 implements zzdk {
        C05797() {
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            com_google_android_gms_internal_zziz.zzD("1".equals(map.get("custom_close")));
        }
    }

    static class C05808 implements zzdk {
        C05808() {
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzb.zzaH("URL missing from httpTrack GMSG.");
            } else {
                new zzij(com_google_android_gms_internal_zziz.getContext(), com_google_android_gms_internal_zziz.zzhh().zzJu, str).zzgz();
            }
        }
    }

    static class C05819 implements zzdk {
        C05819() {
        }

        public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
            zzb.zzaG("Received log message: " + ((String) map.get("string")));
        }
    }
}
