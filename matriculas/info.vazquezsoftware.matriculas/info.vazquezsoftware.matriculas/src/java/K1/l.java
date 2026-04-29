/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  u1.b
 *  x1.H
 *  y1.c
 */
package K1;

import K1.m;
import android.os.Parcel;
import android.os.Parcelable;
import u1.b;
import x1.H;
import y1.a;
import y1.c;

public final class l
extends a {
    public static final Parcelable.Creator<l> CREATOR = new m();
    final int g;
    private final b h;
    private final H i;

    l(int n2, b b2, H h2) {
        this.g = n2;
        this.h = b2;
        this.i = h2;
    }

    public final b a() {
        return this.h;
    }

    public final H b() {
        return this.i;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        int n3 = c.a((Parcel)parcel);
        c.h((Parcel)parcel, (int)1, (int)this.g);
        c.m((Parcel)parcel, (int)2, (Parcelable)this.h, (int)n2, (boolean)false);
        c.m((Parcel)parcel, (int)3, (Parcelable)this.i, (int)n2, (boolean)false);
        c.b((Parcel)parcel, (int)n3);
    }
}

