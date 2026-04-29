/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package x1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import x1.l;
import x1.u;
import y1.a;
import y1.c;

public class q
extends a {
    public static final Parcelable.Creator<q> CREATOR = new u();
    private final int g;
    private List h;

    public q(int n2, List list) {
        this.g = n2;
        this.h = list;
    }

    public final int a() {
        return this.g;
    }

    public final List b() {
        return this.h;
    }

    public final void c(l l2) {
        if (this.h == null) {
            this.h = new ArrayList();
        }
        this.h.add((Object)l2);
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        n2 = c.a(parcel);
        c.h(parcel, 1, this.g);
        c.r(parcel, 2, this.h, false);
        c.b(parcel, n2);
    }
}

