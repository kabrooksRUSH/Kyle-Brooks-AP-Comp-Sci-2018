package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR = new zza();
    final int mVersionCode;
    final List<DriveSpace> zzajA;
    private final Set<DriveSpace> zzajB;
    final boolean zzalC;
    final LogicalFilter zzanK;
    final String zzanL;
    final SortOrder zzanM;
    final List<String> zzanN;
    final boolean zzanO;

    public static class Builder {
        private Set<DriveSpace> zzajB;
        private boolean zzalC;
        private String zzanL;
        private SortOrder zzanM;
        private List<String> zzanN;
        private boolean zzanO;
        private final List<Filter> zzanP = new ArrayList();

        public Builder(Query query) {
            this.zzanP.add(query.getFilter());
            this.zzanL = query.getPageToken();
            this.zzanM = query.getSortOrder();
            this.zzanN = query.zzrO();
            this.zzanO = query.zzrP();
            this.zzajB = query.zzrQ();
            this.zzalC = query.zzrR();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.zzanP.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.zzaor, this.zzanP), this.zzanL, this.zzanM, this.zzanN, this.zzanO, this.zzajB, this.zzalC);
        }

        @Deprecated
        public Builder setPageToken(String token) {
            this.zzanL = token;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzanM = sortOrder;
            return this;
        }
    }

    private Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean includeParents, List<DriveSpace> spacesList, Set<DriveSpace> spaces, boolean includeUnsubscribed) {
        this.mVersionCode = versionCode;
        this.zzanK = clause;
        this.zzanL = pageToken;
        this.zzanM = sortOrder;
        this.zzanN = requestedMetadataFields;
        this.zzanO = includeParents;
        this.zzajA = spacesList;
        this.zzajB = spaces;
        this.zzalC = includeUnsubscribed;
    }

    Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean includeParents, List<DriveSpace> spacesList, boolean includeUnsubscribed) {
        this(versionCode, clause, pageToken, sortOrder, requestedMetadataFields, includeParents, spacesList, spacesList == null ? null : new HashSet(spacesList), includeUnsubscribed);
    }

    private Query(LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean includeParents, Set<DriveSpace> spaces, boolean includeUnsubscribed) {
        this(1, clause, pageToken, sortOrder, requestedMetadataFields, includeParents, spaces == null ? null : new ArrayList(spaces), spaces, includeUnsubscribed);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzanK;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzanL;
    }

    public SortOrder getSortOrder() {
        return this.zzanM;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzanK, this.zzanM, this.zzanL, this.zzajA});
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public List<String> zzrO() {
        return this.zzanN;
    }

    public boolean zzrP() {
        return this.zzanO;
    }

    public Set<DriveSpace> zzrQ() {
        return this.zzajB;
    }

    public boolean zzrR() {
        return this.zzalC;
    }
}
