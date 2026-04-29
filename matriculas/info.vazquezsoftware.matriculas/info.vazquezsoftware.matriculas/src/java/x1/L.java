/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 */
package x1;

import android.os.Parcel;
import android.os.Parcelable;
import x1.E;
import y1.a;
import y1.c;

public class l
extends a {
    public static final Parcelable.Creator<l> CREATOR = new E();
    private final int g;
    private final int h;
    private final int i;
    private final long j;
    private final long k;
    private final String l;
    private final String m;
    private final int n;
    private final int o;

    public l(int n2, int n3, int n4, long l2, long l3, String string, String string2, int n5, int n6) {
        this.g = n2;
        this.h = n3;
        this.i = n4;
        this.j = l2;
        this.k = l3;
        this.l = string;
        this.m = string2;
        this.n = n5;
        this.o = n6;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        int n3 = this.g;
        n2 = c.a(parcel);
        c.h(parcel, 1, n3);
        c.h(parcel, 2, this.h);
        c.h(parcel, 3, this.i);
        c.l(parcel, 4, this.j);
        c.l(parcel, 5, this.k);
        c.n(parcel, 6, this.l, false);
        c.n(parcel, 7, this.m, false);
        c.h(parcel, 8, this.n);
        c.h(parcel, 9, this.o);
        c.b(parcel, n2);
    }
}

