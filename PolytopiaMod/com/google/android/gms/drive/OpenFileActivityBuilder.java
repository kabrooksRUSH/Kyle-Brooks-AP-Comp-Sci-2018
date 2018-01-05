package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzg;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzajf;
    private String[] zzajg;
    private Filter zzajh;
    private DriveId zzaji;

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzajg == null) {
            this.zzajg = new String[0];
        }
        if (this.zzajg.length <= 0 || this.zzajh == null) {
            try {
                return ((zzu) apiClient.zza(Drive.zzRk)).zzrm().zza(new OpenFileIntentSenderRequest(this.zzajf, this.zzajg, this.zzaji, this.zzajh == null ? null : new FilterHolder(this.zzajh)));
            } catch (Throwable e) {
                throw new RuntimeException("Unable to connect Drive Play Service", e);
            }
        }
        throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzaji = (DriveId) zzx.zzw(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.zzajf = (String) zzx.zzw(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        zzx.zzb(mimeTypes != null, (Object) "mimeTypes may not be null");
        this.zzajg = mimeTypes;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        boolean z = true;
        zzx.zzb(filter != null, (Object) "filter may not be null");
        if (zzg.zza(filter)) {
            z = false;
        }
        zzx.zzb(z, (Object) "FullTextSearchFilter cannot be used as a selection filter");
        this.zzajh = filter;
        return this;
    }
}
