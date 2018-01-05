package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder implements SafeParcelable {
    public static final Creator<FilterHolder> CREATOR = new zzd();
    final int mVersionCode;
    private final Filter zzajh;
    final ComparisonFilter<?> zzanZ;
    final FieldOnlyFilter zzaoa;
    final LogicalFilter zzaob;
    final NotFilter zzaoc;
    final InFilter<?> zzaod;
    final MatchAllFilter zzaoe;
    final HasFilter zzaof;
    final FullTextSearchFilter zzaog;
    final OwnedByMeFilter zzaoh;

    FilterHolder(int versionCode, ComparisonFilter<?> comparisonField, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> containsFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter, FullTextSearchFilter fullTextSearchFilter, OwnedByMeFilter ownedByMeFilter) {
        this.mVersionCode = versionCode;
        this.zzanZ = comparisonField;
        this.zzaoa = fieldOnlyFilter;
        this.zzaob = logicalFilter;
        this.zzaoc = notFilter;
        this.zzaod = containsFilter;
        this.zzaoe = matchAllFilter;
        this.zzaof = hasFilter;
        this.zzaog = fullTextSearchFilter;
        this.zzaoh = ownedByMeFilter;
        if (this.zzanZ != null) {
            this.zzajh = this.zzanZ;
        } else if (this.zzaoa != null) {
            this.zzajh = this.zzaoa;
        } else if (this.zzaob != null) {
            this.zzajh = this.zzaob;
        } else if (this.zzaoc != null) {
            this.zzajh = this.zzaoc;
        } else if (this.zzaod != null) {
            this.zzajh = this.zzaod;
        } else if (this.zzaoe != null) {
            this.zzajh = this.zzaoe;
        } else if (this.zzaof != null) {
            this.zzajh = this.zzaof;
        } else if (this.zzaog != null) {
            this.zzajh = this.zzaog;
        } else if (this.zzaoh != null) {
            this.zzajh = this.zzaoh;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        zzx.zzb((Object) filter, (Object) "Null filter.");
        this.mVersionCode = 2;
        this.zzanZ = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.zzaoa = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.zzaob = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.zzaoc = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.zzaod = filter instanceof InFilter ? (InFilter) filter : null;
        this.zzaoe = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.zzaof = filter instanceof HasFilter ? (HasFilter) filter : null;
        this.zzaog = filter instanceof FullTextSearchFilter ? (FullTextSearchFilter) filter : null;
        this.zzaoh = filter instanceof OwnedByMeFilter ? (OwnedByMeFilter) filter : null;
        if (this.zzanZ == null && this.zzaoa == null && this.zzaob == null && this.zzaoc == null && this.zzaod == null && this.zzaoe == null && this.zzaof == null && this.zzaog == null && this.zzaoh == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzajh = filter;
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzajh;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", new Object[]{this.zzajh});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
