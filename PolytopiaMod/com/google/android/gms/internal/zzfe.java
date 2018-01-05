package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0094R;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzgr
public class zzfe extends zzfh {
    private final Context mContext;
    private final Map<String, String> zzvS;

    class C06222 implements OnClickListener {
        final /* synthetic */ zzfe zzAu;

        C06222(zzfe com_google_android_gms_internal_zzfe) {
            this.zzAu = com_google_android_gms_internal_zzfe;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zzAu.zzak("User canceled the download.");
        }
    }

    public zzfe(zziz com_google_android_gms_internal_zziz, Map<String, String> map) {
        super(com_google_android_gms_internal_zziz, "storePicture");
        this.zzvS = map;
        this.mContext = com_google_android_gms_internal_zziz.zzgZ();
    }

    public void execute() {
        if (this.mContext == null) {
            zzak("Activity context is not available");
        } else if (zzp.zzbv().zzL(this.mContext).zzcY()) {
            final String str = (String) this.zzvS.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzak("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                final String zzaj = zzaj(str);
                if (zzp.zzbv().zzaB(zzaj)) {
                    Builder zzK = zzp.zzbv().zzK(this.mContext);
                    zzK.setTitle(zzp.zzby().zzd(C0094R.string.store_picture_title, "Save image"));
                    zzK.setMessage(zzp.zzby().zzd(C0094R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    zzK.setPositiveButton(zzp.zzby().zzd(C0094R.string.accept, "Accept"), new OnClickListener(this) {
                        final /* synthetic */ zzfe zzAu;

                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                ((DownloadManager) this.zzAu.mContext.getSystemService("download")).enqueue(this.zzAu.zzg(str, zzaj));
                            } catch (IllegalStateException e) {
                                this.zzAu.zzak("Could not store picture.");
                            }
                        }
                    });
                    zzK.setNegativeButton(zzp.zzby().zzd(C0094R.string.decline, "Decline"), new C06222(this));
                    zzK.create().show();
                    return;
                }
                zzak("Image type not recognized: " + zzaj);
            } else {
                zzak("Invalid image url: " + str);
            }
        } else {
            zzak("Feature is not supported by the device.");
        }
    }

    String zzaj(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    Request zzg(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzp.zzbx().zza(request);
        return request;
    }
}
