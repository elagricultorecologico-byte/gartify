/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  y1.c
 */
package b1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.g1;
import y1.a;
import y1.c;

public final class f1
extends a {
    public static final Parcelable.Creator<f1> CREATOR = new g1();
    public final int g;

    public f1(int n3) {
        this.g = n3;
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        int n4 = this.g;
        n3 = c.a((Parcel)parcel);
        c.h((Parcel)parcel, (int)2, (int)n4);
        c.b((Parcel)parcel, (int)n3);
    }
}

