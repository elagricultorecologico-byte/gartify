/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  y1.c
 */
package K1;

import K1.i;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import y1.a;
import y1.c;

public final class h
extends a {
    public static final Parcelable.Creator<h> CREATOR = new i();
    private final List g;
    private final String h;

    public h(List list, String string) {
        this.g = list;
        this.h = string;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        List list = this.g;
        n2 = c.a((Parcel)parcel);
        c.p((Parcel)parcel, (int)1, (List)list, (boolean)false);
        c.n((Parcel)parcel, (int)2, (String)this.h, (boolean)false);
        c.b((Parcel)parcel, (int)n2);
    }
}

