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
import x1.Y;
import x1.p;
import y1.a;
import y1.c;

public class e
extends a {
    public static final Parcelable.Creator<e> CREATOR = new Y();
    private final p g;
    private final boolean h;
    private final boolean i;
    private final int[] j;
    private final int k;
    private final int[] l;

    public e(p p2, boolean bl, boolean bl2, int[] nArray, int n2, int[] nArray2) {
        this.g = p2;
        this.h = bl;
        this.i = bl2;
        this.j = nArray;
        this.k = n2;
        this.l = nArray2;
    }

    public int a() {
        return this.k;
    }

    public int[] b() {
        return this.j;
    }

    public int[] c() {
        return this.l;
    }

    public boolean f() {
        return this.h;
    }

    public boolean g() {
        return this.i;
    }

    public final p h() {
        return this.g;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.m(parcel, 1, this.g, n2, false);
        c.c(parcel, 2, this.f());
        c.c(parcel, 3, this.g());
        c.i(parcel, 4, this.b(), false);
        c.h(parcel, 5, this.a());
        c.i(parcel, 6, this.c(), false);
        c.b(parcel, n3);
    }
}

