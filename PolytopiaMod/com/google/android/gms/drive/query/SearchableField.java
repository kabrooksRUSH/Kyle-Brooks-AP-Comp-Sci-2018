package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED = zznd.zzamY;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME = zznf.zzanC;
    public static final SearchableMetadataField<String> MIME_TYPE = zznd.zzang;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE = zznf.zzanD;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS = zznd.zzanl;
    public static final SearchableMetadataField<Boolean> STARRED = zznd.zzann;
    public static final SearchableMetadataField<String> TITLE = zznd.zzanp;
    public static final SearchableMetadataField<Boolean> TRASHED = zznd.zzanq;
    public static final SearchableOrderedMetadataField<Date> zzanQ = zznf.zzanF;
    public static final SearchableMetadataField<AppVisibleCustomProperties> zzanR = zznd.zzamL;
}
