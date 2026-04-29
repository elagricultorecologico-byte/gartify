/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  y1.c
 */
package a1;

import a1.m;
import android.os.Parcel;
import android.os.Parcelable;
import y1.a;
import y1.c;

public final class l
extends a {
    public static final Parcelable.Creator<l> CREATOR = new m();
    public final boolean g;
    public final boolean h;
    public final String i;
    public final boolean j;
    public final float k;
    public final int l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    l(boolean bl, boolean bl2, String string, boolean bl3, float f3, int n3, boolean bl4, boolean bl5, boolean bl6) {
        this.g = bl;
        this.h = bl2;
        this.i = string;
        this.j = bl3;
        this.k = f3;
        this.l = n3;
        this.m = bl4;
        this.n = bl5;
        this.o = bl6;
    }

    public l(boolean bl, boolean bl2, boolean bl3, float f3, int n3, boolean bl4, boolean bl5, boolean bl6) {
        this(bl, bl2, null, bl3, f3, -1, bl4, bl5, bl6);
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        boolean bl = this.g;
        n3 = c.a((Parcel)parcel);
        c.c((Parcel)parcel, (int)2, (boolean)bl);
        c.c((Parcel)parcel, (int)3, (boolean)this.h);
        c.n((Parcel)parcel, (int)4, (String)this.i, (boolean)false);
        c.c((Parcel)parcel, (int)5, (boolean)this.j);
        c.f((Parcel)parcel, (int)6, (float)this.k);
        c.h((Parcel)parcel, (int)7, (int)this.l);
        c.c((Parcel)parcel, (int)8, (boolean)this.m);
        c.c((Parcel)parcel, (int)9, (boolean)this.n);
        c.c((Parcel)parcel, (int)10, (boolean)this.o);
        c.b((Parcel)parcel, (int)n3);
    }
}

