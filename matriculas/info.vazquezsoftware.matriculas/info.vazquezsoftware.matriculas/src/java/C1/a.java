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
package c1;

import android.os.Parcel;
import android.os.Parcelable;
import c1.b;
import y1.c;

public final class a
extends y1.a {
    public static final Parcelable.Creator<a> CREATOR = new b();
    public final String g;
    public final String h;
    public final String i;

    public a(String string, String string2, String string3) {
        this.g = string;
        this.h = string2;
        this.i = string3;
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        String string = this.g;
        n3 = c.a((Parcel)parcel);
        c.n((Parcel)parcel, (int)1, (String)string, (boolean)false);
        c.n((Parcel)parcel, (int)2, (String)this.h, (boolean)false);
        c.n((Parcel)parcel, (int)3, (String)this.i, (boolean)false);
        c.b((Parcel)parcel, (int)n3);
    }
}

