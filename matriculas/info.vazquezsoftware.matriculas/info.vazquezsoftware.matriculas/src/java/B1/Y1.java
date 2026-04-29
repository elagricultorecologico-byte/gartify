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
package b1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.A1;
import y1.a;
import y1.c;

public final class y1
extends a {
    public static final Parcelable.Creator<y1> CREATOR = new A1();
    private final int g;
    private final int h;
    private final String i;

    public y1(int n3, int n4, String string) {
        this.g = n3;
        this.h = n4;
        this.i = string;
    }

    public final int a() {
        return this.h;
    }

    public final String b() {
        return this.i;
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        n3 = c.a((Parcel)parcel);
        c.h((Parcel)parcel, (int)1, (int)this.g);
        c.h((Parcel)parcel, (int)2, (int)this.h);
        c.n((Parcel)parcel, (int)3, (String)this.i, (boolean)false);
        c.b((Parcel)parcel, (int)n3);
    }
}

