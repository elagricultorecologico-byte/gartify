/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  u1.t
 *  x1.m
 *  x1.m$a
 *  y1.c
 */
package u1;

import android.os.Parcel;
import android.os.Parcelable;
import u1.t;
import x1.m;
import y1.a;
import y1.c;

public class d
extends a {
    public static final Parcelable.Creator<d> CREATOR = new t();
    private final String g;
    private final int h;
    private final long i;
    private final boolean j;

    public d(String string, int n2, long l2, boolean bl) {
        this.g = string;
        this.h = n2;
        this.i = l2;
        this.j = bl;
    }

    public d(String string, long l2) {
        this(string, -1, l2, false);
    }

    public d(String string, long l2, boolean bl) {
        this(string, -1, l2, bl);
    }

    public boolean a() {
        return this.j;
    }

    public String b() {
        return this.g;
    }

    public long c() {
        long l2;
        long l3 = l2 = this.i;
        if (l2 == -1L) {
            l3 = this.h;
        }
        return l3;
    }

    public final boolean equals(Object object) {
        if (object instanceof d) {
            object = (d)object;
            if (m.a((Object)this.b(), (Object)((d)object).b()) && this.c() == ((d)object).c() && this.a() == ((d)object).a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return m.b((Object[])new Object[]{this.b(), this.c(), this.a()});
    }

    public final String toString() {
        m.a a2 = m.c((Object)this);
        a2.a("name", (Object)this.b());
        a2.a("version", (Object)this.c());
        a2.a("is_fully_rolled_out", (Object)this.a());
        return a2.toString();
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        n2 = c.a((Parcel)parcel);
        c.n((Parcel)parcel, (int)1, (String)this.b(), (boolean)false);
        c.h((Parcel)parcel, (int)2, (int)this.h);
        c.l((Parcel)parcel, (int)3, (long)this.c());
        c.c((Parcel)parcel, (int)4, (boolean)this.a());
        c.b((Parcel)parcel, (int)n2);
    }
}

