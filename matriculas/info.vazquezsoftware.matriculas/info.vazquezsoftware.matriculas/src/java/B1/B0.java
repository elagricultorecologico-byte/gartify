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
import b1.A0;
import y1.a;
import y1.c;

public final class b0
extends a {
    public static final Parcelable.Creator<b0> CREATOR = new A0();
    public final String g;
    public final String h;

    public b0(String string, String string2) {
        this.g = string;
        this.h = string2;
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        String string = this.g;
        n3 = c.a((Parcel)parcel);
        c.n((Parcel)parcel, (int)1, (String)string, (boolean)false);
        c.n((Parcel)parcel, (int)2, (String)this.h, (boolean)false);
        c.b((Parcel)parcel, (int)n3);
    }
}

