package com.adobe.air;

/* compiled from: ApplicationFileManager */
class FileInfo {
    public long mFileSize;
    public boolean mIsDirectory;
    public boolean mIsFile;

    FileInfo(long j, boolean z, boolean z2) {
        this.mFileSize = j;
        this.mIsFile = z;
        this.mIsDirectory = z2;
    }
}
