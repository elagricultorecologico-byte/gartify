/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  x1.F
 *  y1.c
 */
package K1;

import K1.k;
import android.os.Parcel;
import android.os.Parcelable;
import x1.F;
import y1.a;
import y1.c;

public final class j
extends a {
    public static final Parcelable.Creator<j> CREATOR = new k();
    final int g;
    final F h;

    j(int n2, F f2) {
        this.g = n2;
        this.h = f2;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        int n3 = c.a((Parcel)parcel);
        c.h((Parcel)parcel, (int)1, (int)this.g);
        c.m((Parcel)parcel, (int)2, (Parcelable)this.h, (int)n2, (boolean)false);
        c.b((Parcel)parcel, (int)n3);
    }
}

