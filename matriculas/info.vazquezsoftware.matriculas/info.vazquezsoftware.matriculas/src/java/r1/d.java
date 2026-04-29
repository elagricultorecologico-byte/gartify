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
import r1.e;
import y1.a;
import y1.c;

public final class d
extends a {
    public static final Parcelable.Creator<d> CREATOR = new e();
    private final String g;
    private final String h;

    public d(String string, String string2) {
        this.g = string;
        this.h = string2;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        n2 = c.a((Parcel)parcel);
        c.n((Parcel)parcel, (int)1, (String)this.g, (boolean)false);
        c.n((Parcel)parcel, (int)2, (String)this.h, (boolean)false);
        c.b((Parcel)parcel, (int)n2);
    }
}

