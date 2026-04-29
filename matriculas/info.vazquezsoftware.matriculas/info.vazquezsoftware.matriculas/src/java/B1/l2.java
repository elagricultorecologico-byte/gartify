/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  y1.c
 */
package b1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b1.a1;
import b1.m2;
import y1.a;
import y1.c;

public final class l2
extends a {
    public static final Parcelable.Creator<l2> CREATOR = new m2();
    public final String g;
    public long h;
    public a1 i;
    public final Bundle j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public l2(String string, long l3, a1 a12, Bundle bundle, String string2, String string3, String string4, String string5) {
        this.g = string;
        this.h = l3;
        this.i = a12;
        this.j = bundle;
        this.k = string2;
        this.l = string3;
        this.m = string4;
        this.n = string5;
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        String string = this.g;
        int n4 = c.a((Parcel)parcel);
        c.n((Parcel)parcel, (int)1, (String)string, (boolean)false);
        c.l((Parcel)parcel, (int)2, (long)this.h);
        c.m((Parcel)parcel, (int)3, (Parcelable)this.i, (int)n3, (boolean)false);
        c.d((Parcel)parcel, (int)4, (Bundle)this.j, (boolean)false);
        c.n((Parcel)parcel, (int)5, (String)this.k, (boolean)false);
        c.n((Parcel)parcel, (int)6, (String)this.l, (boolean)false);
        c.n((Parcel)parcel, (int)7, (String)this.m, (boolean)false);
        c.n((Parcel)parcel, (int)8, (String)this.n, (boolean)false);
        c.b((Parcel)parcel, (int)n4);
    }
}

