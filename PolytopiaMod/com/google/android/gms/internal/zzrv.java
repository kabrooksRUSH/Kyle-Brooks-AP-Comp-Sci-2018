package com.google.android.gms.internal;

import com.google.android.gms.drive.FileUploadPreferences;

public class zzrv {
    private final byte[] zzbhX = new byte[FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED];
    private int zzbhY;
    private int zzbhZ;

    public zzrv(byte[] bArr) {
        int i;
        for (i = 0; i < FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED; i++) {
            this.zzbhX[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED; i2++) {
            i = ((i + this.zzbhX[i2]) + bArr[i2 % bArr.length]) & 255;
            byte b = this.zzbhX[i2];
            this.zzbhX[i2] = this.zzbhX[i];
            this.zzbhX[i] = b;
        }
        this.zzbhY = 0;
        this.zzbhZ = 0;
    }

    public void zzA(byte[] bArr) {
        int i = this.zzbhY;
        int i2 = this.zzbhZ;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.zzbhX[i]) & 255;
            byte b = this.zzbhX[i];
            this.zzbhX[i] = this.zzbhX[i2];
            this.zzbhX[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzbhX[(this.zzbhX[i] + this.zzbhX[i2]) & 255]);
        }
        this.zzbhY = i;
        this.zzbhZ = i2;
    }
}
