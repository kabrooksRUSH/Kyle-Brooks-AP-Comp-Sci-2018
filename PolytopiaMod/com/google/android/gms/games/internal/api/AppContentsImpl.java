package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzlb.zzb;

public final class AppContentsImpl implements AppContents {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {
        public LoadAppContentResult zzaa(final Status status) {
            return new LoadAppContentResult(this) {
                final /* synthetic */ LoadsImpl zzaxc;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaa(status);
        }
    }

    class C04331 extends LoadsImpl {
        final /* synthetic */ boolean zzawR;
        final /* synthetic */ int zzawZ;
        final /* synthetic */ String zzaxa;
        final /* synthetic */ String[] zzaxb;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzawZ, this.zzaxa, this.zzaxb, this.zzawR);
        }
    }
}
