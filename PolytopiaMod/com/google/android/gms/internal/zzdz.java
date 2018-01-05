package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;

@zzgr
public class zzdz {
    private final Context mContext;
    private final VersionInfoParcel zzpb;
    private final Object zzpd;
    private final String zzyo;
    private zzb<zzbb> zzyp;
    private zzb<zzbb> zzyq;
    private zze zzyr;
    private int zzys;

    public interface zzb<T> {
        void zzc(T t);
    }

    static class zza {
        static int zzyC = 60000;
        static int zzyD = 10000;
    }

    public static class zzc<T> implements zzb<T> {
        public void zzc(T t) {
        }
    }

    public static class zzd extends zzit<zzbe> {
        private final Object zzpd = new Object();
        private final zze zzyE;
        private boolean zzyF;

        class C05981 implements com.google.android.gms.internal.zzis.zzc<zzbe> {
            final /* synthetic */ zzd zzyG;

            C05981(zzd com_google_android_gms_internal_zzdz_zzd) {
                this.zzyG = com_google_android_gms_internal_zzdz_zzd;
            }

            public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                com.google.android.gms.ads.internal.util.client.zzb.m12v("Ending javascript session.");
                ((zzbf) com_google_android_gms_internal_zzbe).zzck();
            }

            public /* synthetic */ void zzc(Object obj) {
                zzb((zzbe) obj);
            }
        }

        class C05992 implements com.google.android.gms.internal.zzis.zzc<zzbe> {
            final /* synthetic */ zzd zzyG;

            C05992(zzd com_google_android_gms_internal_zzdz_zzd) {
                this.zzyG = com_google_android_gms_internal_zzdz_zzd;
            }

            public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                com.google.android.gms.ads.internal.util.client.zzb.m12v("Releasing engine reference.");
                this.zzyG.zzyE.zzdQ();
            }

            public /* synthetic */ void zzc(Object obj) {
                zzb((zzbe) obj);
            }
        }

        class C06003 implements com.google.android.gms.internal.zzis.zza {
            final /* synthetic */ zzd zzyG;

            C06003(zzd com_google_android_gms_internal_zzdz_zzd) {
                this.zzyG = com_google_android_gms_internal_zzdz_zzd;
            }

            public void run() {
                this.zzyG.zzyE.zzdQ();
            }
        }

        public zzd(zze com_google_android_gms_internal_zzdz_zze) {
            this.zzyE = com_google_android_gms_internal_zzdz_zze;
        }

        public void release() {
            synchronized (this.zzpd) {
                if (this.zzyF) {
                    return;
                }
                this.zzyF = true;
                zza(new C05981(this), new com.google.android.gms.internal.zzis.zzb());
                zza(new C05992(this), new C06003(this));
            }
        }
    }

    public static class zze extends zzit<zzbb> {
        private final Object zzpd = new Object();
        private boolean zzyH;
        private int zzyI;
        private zzb<zzbb> zzyq;

        class C06043 implements com.google.android.gms.internal.zzis.zzc<zzbb> {
            final /* synthetic */ zze zzyK;

            C06043(zze com_google_android_gms_internal_zzdz_zze) {
                this.zzyK = com_google_android_gms_internal_zzdz_zze;
            }

            public void zza(final zzbb com_google_android_gms_internal_zzbb) {
                zzid.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ C06043 zzyL;

                    public void run() {
                        this.zzyL.zzyK.zzyq.zzc(com_google_android_gms_internal_zzbb);
                        com_google_android_gms_internal_zzbb.destroy();
                    }
                });
            }

            public /* synthetic */ void zzc(Object obj) {
                zza((zzbb) obj);
            }
        }

        public zze(zzb<zzbb> com_google_android_gms_internal_zzdz_zzb_com_google_android_gms_internal_zzbb) {
            this.zzyq = com_google_android_gms_internal_zzdz_zzb_com_google_android_gms_internal_zzbb;
            this.zzyH = false;
            this.zzyI = 0;
        }

        public zzd zzdP() {
            final zzd com_google_android_gms_internal_zzdz_zzd = new zzd(this);
            synchronized (this.zzpd) {
                zza(new com.google.android.gms.internal.zzis.zzc<zzbb>(this) {
                    final /* synthetic */ zze zzyK;

                    public void zza(zzbb com_google_android_gms_internal_zzbb) {
                        com.google.android.gms.ads.internal.util.client.zzb.m12v("Getting a new session for JS Engine.");
                        com_google_android_gms_internal_zzdz_zzd.zzg(com_google_android_gms_internal_zzbb.zzci());
                    }

                    public /* synthetic */ void zzc(Object obj) {
                        zza((zzbb) obj);
                    }
                }, new com.google.android.gms.internal.zzis.zza(this) {
                    final /* synthetic */ zze zzyK;

                    public void run() {
                        com.google.android.gms.ads.internal.util.client.zzb.m12v("Rejecting reference for JS Engine.");
                        com_google_android_gms_internal_zzdz_zzd.reject();
                    }
                });
                zzx.zzZ(this.zzyI >= 0);
                this.zzyI++;
            }
            return com_google_android_gms_internal_zzdz_zzd;
        }

        protected void zzdQ() {
            boolean z = true;
            synchronized (this.zzpd) {
                if (this.zzyI < 1) {
                    z = false;
                }
                zzx.zzZ(z);
                com.google.android.gms.ads.internal.util.client.zzb.m12v("Releasing 1 reference for JS Engine");
                this.zzyI--;
                zzdS();
            }
        }

        public void zzdR() {
            boolean z = true;
            synchronized (this.zzpd) {
                if (this.zzyI < 0) {
                    z = false;
                }
                zzx.zzZ(z);
                com.google.android.gms.ads.internal.util.client.zzb.m12v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzyH = true;
                zzdS();
            }
        }

        protected void zzdS() {
            synchronized (this.zzpd) {
                zzx.zzZ(this.zzyI >= 0);
                if (this.zzyH && this.zzyI == 0) {
                    com.google.android.gms.ads.internal.util.client.zzb.m12v("No reference is left (including root). Cleaning up engine.");
                    zza(new C06043(this), new com.google.android.gms.internal.zzis.zzb());
                } else {
                    com.google.android.gms.ads.internal.util.client.zzb.m12v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public zzdz(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zzpd = new Object();
        this.zzys = 1;
        this.zzyo = str;
        this.mContext = context.getApplicationContext();
        this.zzpb = versionInfoParcel;
        this.zzyp = new zzc();
        this.zzyq = new zzc();
    }

    public zzdz(Context context, VersionInfoParcel versionInfoParcel, String str, zzb<zzbb> com_google_android_gms_internal_zzdz_zzb_com_google_android_gms_internal_zzbb, zzb<zzbb> com_google_android_gms_internal_zzdz_zzb_com_google_android_gms_internal_zzbb2) {
        this(context, versionInfoParcel, str);
        this.zzyp = com_google_android_gms_internal_zzdz_zzb_com_google_android_gms_internal_zzbb;
        this.zzyq = com_google_android_gms_internal_zzdz_zzb_com_google_android_gms_internal_zzbb2;
    }

    private zze zzdM() {
        final zze com_google_android_gms_internal_zzdz_zze = new zze(this.zzyq);
        zzid.runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzdz zzyu;

            public void run() {
                final zzbb zza = this.zzyu.zza(this.zzyu.mContext, this.zzyu.zzpb);
                zza.zza(new com.google.android.gms.internal.zzbb.zza(this) {
                    final /* synthetic */ C05951 zzyw;

                    class C05891 implements Runnable {
                        final /* synthetic */ C05901 zzyx;

                        class C05881 implements Runnable {
                            final /* synthetic */ C05891 zzyy;

                            C05881(C05891 c05891) {
                                this.zzyy = c05891;
                            }

                            public void run() {
                                zza.destroy();
                            }
                        }

                        C05891(C05901 c05901) {
                            this.zzyx = c05901;
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                            r3 = this;
                            r0 = r3.zzyx;
                            r0 = r0.zzyw;
                            r0 = r0.zzyu;
                            r1 = r0.zzpd;
                            monitor-enter(r1);
                            r0 = r3.zzyx;	 Catch:{ all -> 0x003f }
                            r0 = r0.zzyw;	 Catch:{ all -> 0x003f }
                            r0 = r0;	 Catch:{ all -> 0x003f }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x003f }
                            r2 = -1;
                            if (r0 == r2) goto L_0x0025;
                        L_0x0018:
                            r0 = r3.zzyx;	 Catch:{ all -> 0x003f }
                            r0 = r0.zzyw;	 Catch:{ all -> 0x003f }
                            r0 = r0;	 Catch:{ all -> 0x003f }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x003f }
                            r2 = 1;
                            if (r0 != r2) goto L_0x0027;
                        L_0x0025:
                            monitor-exit(r1);	 Catch:{ all -> 0x003f }
                        L_0x0026:
                            return;
                        L_0x0027:
                            r0 = r3.zzyx;	 Catch:{ all -> 0x003f }
                            r0 = r0.zzyw;	 Catch:{ all -> 0x003f }
                            r0 = r0;	 Catch:{ all -> 0x003f }
                            r0.reject();	 Catch:{ all -> 0x003f }
                            r0 = new com.google.android.gms.internal.zzdz$1$1$1$1;	 Catch:{ all -> 0x003f }
                            r0.<init>(r3);	 Catch:{ all -> 0x003f }
                            com.google.android.gms.internal.zzid.runOnUiThread(r0);	 Catch:{ all -> 0x003f }
                            r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                            com.google.android.gms.ads.internal.util.client.zzb.m12v(r0);	 Catch:{ all -> 0x003f }
                            monitor-exit(r1);	 Catch:{ all -> 0x003f }
                            goto L_0x0026;
                        L_0x003f:
                            r0 = move-exception;
                            monitor-exit(r1);	 Catch:{ all -> 0x003f }
                            throw r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdz.1.1.1.run():void");
                        }
                    }

                    public void zzcj() {
                        zzid.zzIE.postDelayed(new C05891(this), (long) zza.zzyD);
                    }
                });
                zza.zza("/jsLoaded", new zzdk(this) {
                    final /* synthetic */ C05951 zzyw;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void zza(com.google.android.gms.internal.zziz r4, java.util.Map<java.lang.String, java.lang.String> r5) {
                        /*
                        r3 = this;
                        r0 = r3.zzyw;
                        r0 = r0.zzyu;
                        r1 = r0.zzpd;
                        monitor-enter(r1);
                        r0 = r3.zzyw;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzyw;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzyw;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzyu;	 Catch:{ all -> 0x0051 }
                        r2 = 0;
                        r0.zzys = r2;	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzyw;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzyu;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzyp;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzc(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzyw;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzg(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzyw;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzyu;	 Catch:{ all -> 0x0051 }
                        r2 = r3.zzyw;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzyr = r2;	 Catch:{ all -> 0x0051 }
                        r0 = "Successfully loaded JS Engine.";
                        com.google.android.gms.ads.internal.util.client.zzb.m12v(r0);	 Catch:{ all -> 0x0051 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        goto L_0x0020;
                    L_0x0051:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdz.1.2.zza(com.google.android.gms.internal.zziz, java.util.Map):void");
                    }
                });
                final zzil com_google_android_gms_internal_zzil = new zzil();
                zzdk c05923 = new zzdk(this) {
                    final /* synthetic */ C05951 zzyw;

                    public void zza(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
                        synchronized (this.zzyw.zzyu.zzpd) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzaG("JS Engine is requesting an update");
                            if (this.zzyw.zzyu.zzys == 0) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzaG("Starting reload.");
                                this.zzyw.zzyu.zzys = 2;
                                this.zzyw.zzyu.zzdN();
                            }
                            zza.zzb("/requestReload", (zzdk) com_google_android_gms_internal_zzil.get());
                        }
                    }
                };
                com_google_android_gms_internal_zzil.set(c05923);
                zza.zza("/requestReload", c05923);
                if (this.zzyu.zzyo.endsWith(".js")) {
                    zza.zzs(this.zzyu.zzyo);
                } else if (this.zzyu.zzyo.startsWith("<html>")) {
                    zza.zzu(this.zzyu.zzyo);
                } else {
                    zza.zzt(this.zzyu.zzyo);
                }
                zzid.zzIE.postDelayed(new Runnable(this) {
                    final /* synthetic */ C05951 zzyw;

                    class C05931 implements Runnable {
                        final /* synthetic */ C05944 zzyA;

                        C05931(C05944 c05944) {
                            this.zzyA = c05944;
                        }

                        public void run() {
                            zza.destroy();
                        }
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r3 = this;
                        r0 = r3.zzyw;
                        r0 = r0.zzyu;
                        r1 = r0.zzpd;
                        monitor-enter(r1);
                        r0 = r3.zzyw;	 Catch:{ all -> 0x0037 }
                        r0 = r0;	 Catch:{ all -> 0x0037 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0037 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzyw;	 Catch:{ all -> 0x0037 }
                        r0 = r0;	 Catch:{ all -> 0x0037 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0037 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzyw;	 Catch:{ all -> 0x0037 }
                        r0 = r0;	 Catch:{ all -> 0x0037 }
                        r0.reject();	 Catch:{ all -> 0x0037 }
                        r0 = new com.google.android.gms.internal.zzdz$1$4$1;	 Catch:{ all -> 0x0037 }
                        r0.<init>(r3);	 Catch:{ all -> 0x0037 }
                        com.google.android.gms.internal.zzid.runOnUiThread(r0);	 Catch:{ all -> 0x0037 }
                        r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                        com.google.android.gms.ads.internal.util.client.zzb.m12v(r0);	 Catch:{ all -> 0x0037 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
                        goto L_0x0020;
                    L_0x0037:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdz.1.4.run():void");
                    }
                }, (long) zza.zzyC);
            }
        });
        return com_google_android_gms_internal_zzdz_zze;
    }

    protected zzbb zza(Context context, VersionInfoParcel versionInfoParcel) {
        return new zzbd(context, versionInfoParcel, null);
    }

    protected zze zzdN() {
        final zze zzdM = zzdM();
        zzdM.zza(new com.google.android.gms.internal.zzis.zzc<zzbb>(this) {
            final /* synthetic */ zzdz zzyu;

            public void zza(zzbb com_google_android_gms_internal_zzbb) {
                synchronized (this.zzyu.zzpd) {
                    this.zzyu.zzys = 0;
                    if (!(this.zzyu.zzyr == null || zzdM == this.zzyu.zzyr)) {
                        com.google.android.gms.ads.internal.util.client.zzb.m12v("New JS engine is loaded, marking previous one as destroyable.");
                        this.zzyu.zzyr.zzdR();
                    }
                    this.zzyu.zzyr = zzdM;
                }
            }

            public /* synthetic */ void zzc(Object obj) {
                zza((zzbb) obj);
            }
        }, new com.google.android.gms.internal.zzis.zza(this) {
            final /* synthetic */ zzdz zzyu;

            public void run() {
                synchronized (this.zzyu.zzpd) {
                    this.zzyu.zzys = 1;
                    com.google.android.gms.ads.internal.util.client.zzb.m12v("Failed loading new engine. Marking new engine destroyable.");
                    zzdM.zzdR();
                }
            }
        });
        return zzdM;
    }

    public zzd zzdO() {
        zzd zzdP;
        synchronized (this.zzpd) {
            if (this.zzyr == null || this.zzyr.getStatus() == -1) {
                this.zzys = 2;
                this.zzyr = zzdN();
                zzdP = this.zzyr.zzdP();
            } else if (this.zzys == 0) {
                zzdP = this.zzyr.zzdP();
            } else if (this.zzys == 1) {
                this.zzys = 2;
                zzdN();
                zzdP = this.zzyr.zzdP();
            } else if (this.zzys == 2) {
                zzdP = this.zzyr.zzdP();
            } else {
                zzdP = this.zzyr.zzdP();
            }
        }
        return zzdP;
    }
}
