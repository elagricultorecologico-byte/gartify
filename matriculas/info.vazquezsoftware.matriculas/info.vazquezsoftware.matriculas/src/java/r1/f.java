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
package r1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.g;
import y1.a;
import y1.c;

public final class f
extends a {
    public static final Parcelable.Creator<f> CREATOR = new g();
    private final String g;
    private final int h;

    public f(String string, int n2) {
        this.g = string;
        this.h = n2;
    }

    public final int a() {
        return this.h;
    }

    public final String b() {
        return this.g;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        n2 = c.a((Parcel)parcel);
        c.n((Parcel)parcel, (int)1, (String)this.g, (boolean)false);
        c.h((Parcel)parcel, (int)2, (int)this.h);
        c.b((Parcel)parcel, (int)n2);
    }
}

