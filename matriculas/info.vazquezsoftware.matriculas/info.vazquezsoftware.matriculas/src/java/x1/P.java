/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 */
package x1;

import android.os.Parcel;
import android.os.Parcelable;
import x1.N;
import y1.a;
import y1.c;

public class p
extends a {
    public static final Parcelable.Creator<p> CREATOR = new N();
    private final int g;
    private final boolean h;
    private final boolean i;
    private final int j;
    private final int k;

    public p(int n2, boolean bl, boolean bl2, int n3, int n4) {
        this.g = n2;
        this.h = bl;
        this.i = bl2;
        this.j = n3;
        this.k = n4;
    }

    public int a() {
        return this.j;
    }

    public int b() {
        return this.k;
    }

    public boolean c() {
        return this.h;
    }

    public boolean f() {
        return this.i;
    }

    public int g() {
        return this.g;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        n2 = c.a(parcel);
        c.h(parcel, 1, this.g());
        c.c(parcel, 2, this.c());
        c.c(parcel, 3, this.f());
        c.h(parcel, 4, this.a());
        c.h(parcel, 5, this.b());
        c.b(parcel, n2);
    }
}

