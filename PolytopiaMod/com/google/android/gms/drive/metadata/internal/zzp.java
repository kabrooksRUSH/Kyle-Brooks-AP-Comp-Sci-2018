package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzp extends zzj<UserMetadata> {
    public zzp(String str, int i) {
        super(str, zzcI(str), Collections.emptyList(), i);
    }

    private static String zzA(String str, String str2) {
        return str + "." + str2;
    }

    private String zzcH(String str) {
        return zzA(getName(), str);
    }

    private static Collection<String> zzcI(String str) {
        return Arrays.asList(new String[]{zzA(str, "permissionId"), zzA(str, "displayName"), zzA(str, "picture"), zzA(str, "isAuthenticatedUser"), zzA(str, "emailAddress")});
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzce(zzcH("permissionId")) && !dataHolder.zzi(zzcH("permissionId"), i, i2);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzj(dataHolder, i, i2);
    }

    protected UserMetadata zzj(DataHolder dataHolder, int i, int i2) {
        String zzd = dataHolder.zzd(zzcH("permissionId"), i, i2);
        if (zzd == null) {
            return null;
        }
        String zzd2 = dataHolder.zzd(zzcH("displayName"), i, i2);
        String zzd3 = dataHolder.zzd(zzcH("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.zze(zzcH("isAuthenticatedUser"), i, i2));
        return new UserMetadata(zzd, zzd2, zzd3, valueOf.booleanValue(), dataHolder.zzd(zzcH("emailAddress"), i, i2));
    }
}
