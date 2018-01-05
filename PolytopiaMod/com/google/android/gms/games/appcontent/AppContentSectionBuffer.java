package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends zzf<AppContentSection> {
    private final ArrayList<DataHolder> zzauU;

    public void release() {
        super.release();
        int size = this.zzauU.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = (DataHolder) this.zzauU.get(i);
            if (dataHolder != null) {
                dataHolder.close();
            }
        }
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzm(i, i2);
    }

    protected AppContentSection zzm(int i, int i2) {
        return new AppContentSectionRef(this.zzauU, i, i2);
    }

    protected String zzoA() {
        return "card_id";
    }

    protected String zzoy() {
        return "section_id";
    }
}
