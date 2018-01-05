package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;

public interface zzox {

    public static final class zza extends zzry<zza> {
        public zza[] zzaCU;

        public static final class zza extends zzry<zza> {
            private static volatile zza[] zzaCV;
            public int viewId;
            public String zzaCW;
            public String zzaCX;

            public zza() {
                zzwe();
            }

            public static zza[] zzwd() {
                if (zzaCV == null) {
                    synchronized (zzsc.zzbiu) {
                        if (zzaCV == null) {
                            zzaCV = new zza[0];
                        }
                    }
                }
                return zzaCV;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzox_zza_zza = (zza) o;
                if (this.zzaCW == null) {
                    if (com_google_android_gms_internal_zzox_zza_zza.zzaCW != null) {
                        return false;
                    }
                } else if (!this.zzaCW.equals(com_google_android_gms_internal_zzox_zza_zza.zzaCW)) {
                    return false;
                }
                if (this.zzaCX == null) {
                    if (com_google_android_gms_internal_zzox_zza_zza.zzaCX != null) {
                        return false;
                    }
                } else if (!this.zzaCX.equals(com_google_android_gms_internal_zzox_zza_zza.zzaCX)) {
                    return false;
                }
                return this.viewId == com_google_android_gms_internal_zzox_zza_zza.viewId ? (this.zzbik == null || this.zzbik.isEmpty()) ? com_google_android_gms_internal_zzox_zza_zza.zzbik == null || com_google_android_gms_internal_zzox_zza_zza.zzbik.isEmpty() : this.zzbik.equals(com_google_android_gms_internal_zzox_zza_zza.zzbik) : false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((this.zzaCX == null ? 0 : this.zzaCX.hashCode()) + (((this.zzaCW == null ? 0 : this.zzaCW.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + this.viewId) * 31;
                if (!(this.zzbik == null || this.zzbik.isEmpty())) {
                    i = this.zzbik.hashCode();
                }
                return hashCode + i;
            }

            protected int zzB() {
                int zzB = super.zzB();
                if (!this.zzaCW.equals("")) {
                    zzB += zzrx.zzn(1, this.zzaCW);
                }
                if (!this.zzaCX.equals("")) {
                    zzB += zzrx.zzn(2, this.zzaCX);
                }
                return this.viewId != 0 ? zzB + zzrx.zzA(3, this.viewId) : zzB;
            }

            public void zza(zzrx com_google_android_gms_internal_zzrx) throws IOException {
                if (!this.zzaCW.equals("")) {
                    com_google_android_gms_internal_zzrx.zzb(1, this.zzaCW);
                }
                if (!this.zzaCX.equals("")) {
                    com_google_android_gms_internal_zzrx.zzb(2, this.zzaCX);
                }
                if (this.viewId != 0) {
                    com_google_android_gms_internal_zzrx.zzy(3, this.viewId);
                }
                super.zza(com_google_android_gms_internal_zzrx);
            }

            public /* synthetic */ zzse zzb(zzrw com_google_android_gms_internal_zzrw) throws IOException {
                return zzq(com_google_android_gms_internal_zzrw);
            }

            public zza zzq(zzrw com_google_android_gms_internal_zzrw) throws IOException {
                while (true) {
                    int zzFo = com_google_android_gms_internal_zzrw.zzFo();
                    switch (zzFo) {
                        case 0:
                            break;
                        case 10:
                            this.zzaCW = com_google_android_gms_internal_zzrw.readString();
                            continue;
                        case ConnectionResult.SERVICE_UPDATING /*18*/:
                            this.zzaCX = com_google_android_gms_internal_zzrw.readString();
                            continue;
                        case 24:
                            this.viewId = com_google_android_gms_internal_zzrw.zzFr();
                            continue;
                        default:
                            if (!zza(com_google_android_gms_internal_zzrw, zzFo)) {
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public zza zzwe() {
                this.zzaCW = "";
                this.zzaCX = "";
                this.viewId = 0;
                this.zzbik = null;
                this.zzbiv = -1;
                return this;
            }
        }

        public zza() {
            zzwc();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzox_zza = (zza) o;
            return zzsc.equals(this.zzaCU, com_google_android_gms_internal_zzox_zza.zzaCU) ? (this.zzbik == null || this.zzbik.isEmpty()) ? com_google_android_gms_internal_zzox_zza.zzbik == null || com_google_android_gms_internal_zzox_zza.zzbik.isEmpty() : this.zzbik.equals(com_google_android_gms_internal_zzox_zza.zzbik) : false;
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zzaCU)) * 31;
            int hashCode2 = (this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode();
            return hashCode2 + hashCode;
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzaCU != null && this.zzaCU.length > 0) {
                for (zzse com_google_android_gms_internal_zzse : this.zzaCU) {
                    if (com_google_android_gms_internal_zzse != null) {
                        zzB += zzrx.zzc(1, com_google_android_gms_internal_zzse);
                    }
                }
            }
            return zzB;
        }

        public void zza(zzrx com_google_android_gms_internal_zzrx) throws IOException {
            if (this.zzaCU != null && this.zzaCU.length > 0) {
                for (zzse com_google_android_gms_internal_zzse : this.zzaCU) {
                    if (com_google_android_gms_internal_zzse != null) {
                        com_google_android_gms_internal_zzrx.zza(1, com_google_android_gms_internal_zzse);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzrx);
        }

        public /* synthetic */ zzse zzb(zzrw com_google_android_gms_internal_zzrw) throws IOException {
            return zzp(com_google_android_gms_internal_zzrw);
        }

        public zza zzp(zzrw com_google_android_gms_internal_zzrw) throws IOException {
            while (true) {
                int zzFo = com_google_android_gms_internal_zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsh.zzc(com_google_android_gms_internal_zzrw, 10);
                        zzFo = this.zzaCU == null ? 0 : this.zzaCU.length;
                        Object obj = new zza[(zzc + zzFo)];
                        if (zzFo != 0) {
                            System.arraycopy(this.zzaCU, 0, obj, 0, zzFo);
                        }
                        while (zzFo < obj.length - 1) {
                            obj[zzFo] = new zza();
                            com_google_android_gms_internal_zzrw.zza(obj[zzFo]);
                            com_google_android_gms_internal_zzrw.zzFo();
                            zzFo++;
                        }
                        obj[zzFo] = new zza();
                        com_google_android_gms_internal_zzrw.zza(obj[zzFo]);
                        this.zzaCU = obj;
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzrw, zzFo)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zza zzwc() {
            this.zzaCU = zza.zzwd();
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }
    }

    public static final class zzb extends zzry<zzb> {
        private static volatile zzb[] zzaCY;
        public String name;
        public zzd zzaCZ;

        public zzb() {
            zzwg();
        }

        public static zzb[] zzwf() {
            if (zzaCY == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzaCY == null) {
                        zzaCY = new zzb[0];
                    }
                }
            }
            return zzaCY;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzox_zzb = (zzb) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzox_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzox_zzb.name)) {
                return false;
            }
            if (this.zzaCZ == null) {
                if (com_google_android_gms_internal_zzox_zzb.zzaCZ != null) {
                    return false;
                }
            } else if (!this.zzaCZ.equals(com_google_android_gms_internal_zzox_zzb.zzaCZ)) {
                return false;
            }
            return (this.zzbik == null || this.zzbik.isEmpty()) ? com_google_android_gms_internal_zzox_zzb.zzbik == null || com_google_android_gms_internal_zzox_zzb.zzbik.isEmpty() : this.zzbik.equals(com_google_android_gms_internal_zzox_zzb.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaCZ == null ? 0 : this.zzaCZ.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.zzbik == null || this.zzbik.isEmpty())) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals("")) {
                zzB += zzrx.zzn(1, this.name);
            }
            return this.zzaCZ != null ? zzB + zzrx.zzc(2, this.zzaCZ) : zzB;
        }

        public void zza(zzrx com_google_android_gms_internal_zzrx) throws IOException {
            if (!this.name.equals("")) {
                com_google_android_gms_internal_zzrx.zzb(1, this.name);
            }
            if (this.zzaCZ != null) {
                com_google_android_gms_internal_zzrx.zza(2, this.zzaCZ);
            }
            super.zza(com_google_android_gms_internal_zzrx);
        }

        public /* synthetic */ zzse zzb(zzrw com_google_android_gms_internal_zzrw) throws IOException {
            return zzr(com_google_android_gms_internal_zzrw);
        }

        public zzb zzr(zzrw com_google_android_gms_internal_zzrw) throws IOException {
            while (true) {
                int zzFo = com_google_android_gms_internal_zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzrw.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzaCZ == null) {
                            this.zzaCZ = new zzd();
                        }
                        com_google_android_gms_internal_zzrw.zza(this.zzaCZ);
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzrw, zzFo)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzb zzwg() {
            this.name = "";
            this.zzaCZ = null;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }
    }

    public static final class zzc extends zzry<zzc> {
        public String type;
        public zzb[] zzaDa;

        public zzc() {
            zzwh();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzox_zzc = (zzc) o;
            if (this.type == null) {
                if (com_google_android_gms_internal_zzox_zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(com_google_android_gms_internal_zzox_zzc.type)) {
                return false;
            }
            return zzsc.equals(this.zzaDa, com_google_android_gms_internal_zzox_zzc.zzaDa) ? (this.zzbik == null || this.zzbik.isEmpty()) ? com_google_android_gms_internal_zzox_zzc.zzbik == null || com_google_android_gms_internal_zzox_zzc.zzbik.isEmpty() : this.zzbik.equals(com_google_android_gms_internal_zzox_zzc.zzbik) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.type == null ? 0 : this.type.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzsc.hashCode(this.zzaDa)) * 31;
            if (!(this.zzbik == null || this.zzbik.isEmpty())) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (!this.type.equals("")) {
                zzB += zzrx.zzn(1, this.type);
            }
            if (this.zzaDa == null || this.zzaDa.length <= 0) {
                return zzB;
            }
            int i = zzB;
            for (zzse com_google_android_gms_internal_zzse : this.zzaDa) {
                if (com_google_android_gms_internal_zzse != null) {
                    i += zzrx.zzc(2, com_google_android_gms_internal_zzse);
                }
            }
            return i;
        }

        public void zza(zzrx com_google_android_gms_internal_zzrx) throws IOException {
            if (!this.type.equals("")) {
                com_google_android_gms_internal_zzrx.zzb(1, this.type);
            }
            if (this.zzaDa != null && this.zzaDa.length > 0) {
                for (zzse com_google_android_gms_internal_zzse : this.zzaDa) {
                    if (com_google_android_gms_internal_zzse != null) {
                        com_google_android_gms_internal_zzrx.zza(2, com_google_android_gms_internal_zzse);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzrx);
        }

        public /* synthetic */ zzse zzb(zzrw com_google_android_gms_internal_zzrw) throws IOException {
            return zzs(com_google_android_gms_internal_zzrw);
        }

        public zzc zzs(zzrw com_google_android_gms_internal_zzrw) throws IOException {
            while (true) {
                int zzFo = com_google_android_gms_internal_zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.type = com_google_android_gms_internal_zzrw.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        int zzc = zzsh.zzc(com_google_android_gms_internal_zzrw, 18);
                        zzFo = this.zzaDa == null ? 0 : this.zzaDa.length;
                        Object obj = new zzb[(zzc + zzFo)];
                        if (zzFo != 0) {
                            System.arraycopy(this.zzaDa, 0, obj, 0, zzFo);
                        }
                        while (zzFo < obj.length - 1) {
                            obj[zzFo] = new zzb();
                            com_google_android_gms_internal_zzrw.zza(obj[zzFo]);
                            com_google_android_gms_internal_zzrw.zzFo();
                            zzFo++;
                        }
                        obj[zzFo] = new zzb();
                        com_google_android_gms_internal_zzrw.zza(obj[zzFo]);
                        this.zzaDa = obj;
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzrw, zzFo)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzc zzwh() {
            this.type = "";
            this.zzaDa = zzb.zzwf();
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }
    }

    public static final class zzd extends zzry<zzd> {
        public boolean zzaDb;
        public long zzaDc;
        public double zzaDd;
        public zzc zzaDe;
        public String zzagS;

        public zzd() {
            zzwi();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzox_zzd = (zzd) o;
            if (this.zzaDb != com_google_android_gms_internal_zzox_zzd.zzaDb) {
                return false;
            }
            if (this.zzagS == null) {
                if (com_google_android_gms_internal_zzox_zzd.zzagS != null) {
                    return false;
                }
            } else if (!this.zzagS.equals(com_google_android_gms_internal_zzox_zzd.zzagS)) {
                return false;
            }
            if (this.zzaDc != com_google_android_gms_internal_zzox_zzd.zzaDc || Double.doubleToLongBits(this.zzaDd) != Double.doubleToLongBits(com_google_android_gms_internal_zzox_zzd.zzaDd)) {
                return false;
            }
            if (this.zzaDe == null) {
                if (com_google_android_gms_internal_zzox_zzd.zzaDe != null) {
                    return false;
                }
            } else if (!this.zzaDe.equals(com_google_android_gms_internal_zzox_zzd.zzaDe)) {
                return false;
            }
            return (this.zzbik == null || this.zzbik.isEmpty()) ? com_google_android_gms_internal_zzox_zzd.zzbik == null || com_google_android_gms_internal_zzox_zzd.zzbik.isEmpty() : this.zzbik.equals(com_google_android_gms_internal_zzox_zzd.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzagS == null ? 0 : this.zzagS.hashCode()) + (((this.zzaDb ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + ((int) (this.zzaDc ^ (this.zzaDc >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzaDd);
            hashCode = ((this.zzaDe == null ? 0 : this.zzaDe.hashCode()) + (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31)) * 31;
            if (!(this.zzbik == null || this.zzbik.isEmpty())) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzaDb) {
                zzB += zzrx.zzc(1, this.zzaDb);
            }
            if (!this.zzagS.equals("")) {
                zzB += zzrx.zzn(2, this.zzagS);
            }
            if (this.zzaDc != 0) {
                zzB += zzrx.zzd(3, this.zzaDc);
            }
            if (Double.doubleToLongBits(this.zzaDd) != Double.doubleToLongBits(0.0d)) {
                zzB += zzrx.zzb(4, this.zzaDd);
            }
            return this.zzaDe != null ? zzB + zzrx.zzc(5, this.zzaDe) : zzB;
        }

        public void zza(zzrx com_google_android_gms_internal_zzrx) throws IOException {
            if (this.zzaDb) {
                com_google_android_gms_internal_zzrx.zzb(1, this.zzaDb);
            }
            if (!this.zzagS.equals("")) {
                com_google_android_gms_internal_zzrx.zzb(2, this.zzagS);
            }
            if (this.zzaDc != 0) {
                com_google_android_gms_internal_zzrx.zzb(3, this.zzaDc);
            }
            if (Double.doubleToLongBits(this.zzaDd) != Double.doubleToLongBits(0.0d)) {
                com_google_android_gms_internal_zzrx.zza(4, this.zzaDd);
            }
            if (this.zzaDe != null) {
                com_google_android_gms_internal_zzrx.zza(5, this.zzaDe);
            }
            super.zza(com_google_android_gms_internal_zzrx);
        }

        public /* synthetic */ zzse zzb(zzrw com_google_android_gms_internal_zzrw) throws IOException {
            return zzt(com_google_android_gms_internal_zzrw);
        }

        public zzd zzt(zzrw com_google_android_gms_internal_zzrw) throws IOException {
            while (true) {
                int zzFo = com_google_android_gms_internal_zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        this.zzaDb = com_google_android_gms_internal_zzrw.zzFs();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zzagS = com_google_android_gms_internal_zzrw.readString();
                        continue;
                    case 24:
                        this.zzaDc = com_google_android_gms_internal_zzrw.zzFq();
                        continue;
                    case 33:
                        this.zzaDd = com_google_android_gms_internal_zzrw.readDouble();
                        continue;
                    case 42:
                        if (this.zzaDe == null) {
                            this.zzaDe = new zzc();
                        }
                        com_google_android_gms_internal_zzrw.zza(this.zzaDe);
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzrw, zzFo)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzd zzwi() {
            this.zzaDb = false;
            this.zzagS = "";
            this.zzaDc = 0;
            this.zzaDd = 0.0d;
            this.zzaDe = null;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }
    }
}
