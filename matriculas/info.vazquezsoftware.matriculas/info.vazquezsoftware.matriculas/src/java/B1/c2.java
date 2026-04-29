/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  f1.q
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  x1.m
 *  y1.c
 */
package b1;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b1.R1;
import b1.b0;
import b1.e2;
import f1.q;
import java.util.ArrayList;
import java.util.List;
import x1.m;
import y1.a;
import y1.c;

public final class c2
extends a {
    public static final Parcelable.Creator<c2> CREATOR = new e2();
    public final String A;
    public final List B;
    public final int C;
    public final String D;
    public final int E;
    public final long F;
    public final long G;
    public final Bundle H = new Bundle();
    public final int g;
    public final long h;
    public final Bundle i;
    public final int j;
    public final List k;
    public final boolean l;
    public final int m;
    public final boolean n;
    public final String o;
    public final R1 p;
    public final Location q;
    public final String r;
    public final Bundle s;
    public final Bundle t;
    public final List u;
    public final String v;
    public final String w;
    public final boolean x;
    public final b0 y;
    public final int z;

    public c2(int n3, long l3, Bundle object, int n4, List list, boolean bl, int n5, boolean bl2, String string, R1 r12, Location location, String string2, Bundle bundle, Bundle bundle2, List list2, String string3, String string4, boolean bl3, b0 b02, int n6, String string5, List list3, int n7, String string6, int n8, long l4, long l5) {
        this.g = n3;
        this.h = l3;
        Bundle bundle3 = object;
        if (object == null) {
            bundle3 = new Bundle();
        }
        this.i = bundle3;
        this.j = n4;
        this.k = list;
        this.l = bl;
        this.m = n5;
        this.n = bl2;
        this.o = string;
        this.p = r12;
        this.q = location;
        this.r = string2;
        object = bundle == null ? new Bundle() : bundle;
        this.s = object;
        this.t = bundle2;
        this.u = list2;
        this.v = string3;
        this.w = string4;
        this.x = bl3;
        this.y = b02;
        this.z = n6;
        this.A = string5;
        object = list3 == null ? new ArrayList() : list3;
        this.B = object;
        this.C = n7;
        this.D = string6;
        this.E = n8;
        this.F = l4;
        this.G = l5;
    }

    public final boolean a(Object object) {
        if (!(object instanceof c2)) {
            return false;
        }
        object = (c2)object;
        return this.g == ((c2)object).g && this.h == ((c2)object).h && f1.q.a((Bundle)this.i, (Bundle)((c2)object).i) && this.j == ((c2)object).j && x1.m.a((Object)this.k, (Object)((c2)object).k) && this.l == ((c2)object).l && this.m == ((c2)object).m && this.n == ((c2)object).n && x1.m.a((Object)this.o, (Object)((c2)object).o) && x1.m.a((Object)this.p, (Object)((c2)object).p) && x1.m.a((Object)this.q, (Object)((c2)object).q) && x1.m.a((Object)this.r, (Object)((c2)object).r) && f1.q.a((Bundle)this.s, (Bundle)((c2)object).s) && f1.q.a((Bundle)this.t, (Bundle)((c2)object).t) && x1.m.a((Object)this.u, (Object)((c2)object).u) && x1.m.a((Object)this.v, (Object)((c2)object).v) && x1.m.a((Object)this.w, (Object)((c2)object).w) && this.x == ((c2)object).x && this.z == ((c2)object).z && x1.m.a((Object)this.A, (Object)((c2)object).A) && x1.m.a((Object)this.B, (Object)((c2)object).B) && this.C == ((c2)object).C && x1.m.a((Object)this.D, (Object)((c2)object).D) && this.E == ((c2)object).E;
    }

    public final boolean b() {
        return this.c() || this.f();
        {
        }
    }

    public final boolean c() {
        return this.i.getBoolean("is_sdk_preload", false);
    }

    public final boolean equals(Object object) {
        if (!(object instanceof c2)) {
            return false;
        }
        c2 c22 = (c2)object;
        return this.a(object) && this.F == c22.F;
    }

    public final boolean f() {
        return this.i.getBoolean("zenith_v2", false);
    }

    public final int hashCode() {
        return x1.m.b((Object[])new Object[]{this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G});
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        int n4 = this.g;
        int n5 = c.a((Parcel)parcel);
        c.h((Parcel)parcel, (int)1, (int)n4);
        c.l((Parcel)parcel, (int)2, (long)this.h);
        c.d((Parcel)parcel, (int)3, (Bundle)this.i, (boolean)false);
        c.h((Parcel)parcel, (int)4, (int)this.j);
        c.p((Parcel)parcel, (int)5, (List)this.k, (boolean)false);
        c.c((Parcel)parcel, (int)6, (boolean)this.l);
        c.h((Parcel)parcel, (int)7, (int)this.m);
        c.c((Parcel)parcel, (int)8, (boolean)this.n);
        c.n((Parcel)parcel, (int)9, (String)this.o, (boolean)false);
        c.m((Parcel)parcel, (int)10, (Parcelable)this.p, (int)n3, (boolean)false);
        c.m((Parcel)parcel, (int)11, (Parcelable)this.q, (int)n3, (boolean)false);
        c.n((Parcel)parcel, (int)12, (String)this.r, (boolean)false);
        c.d((Parcel)parcel, (int)13, (Bundle)this.s, (boolean)false);
        c.d((Parcel)parcel, (int)14, (Bundle)this.t, (boolean)false);
        c.p((Parcel)parcel, (int)15, (List)this.u, (boolean)false);
        c.n((Parcel)parcel, (int)16, (String)this.v, (boolean)false);
        c.n((Parcel)parcel, (int)17, (String)this.w, (boolean)false);
        c.c((Parcel)parcel, (int)18, (boolean)this.x);
        c.m((Parcel)parcel, (int)19, (Parcelable)this.y, (int)n3, (boolean)false);
        c.h((Parcel)parcel, (int)20, (int)this.z);
        c.n((Parcel)parcel, (int)21, (String)this.A, (boolean)false);
        c.p((Parcel)parcel, (int)22, (List)this.B, (boolean)false);
        c.h((Parcel)parcel, (int)23, (int)this.C);
        c.n((Parcel)parcel, (int)24, (String)this.D, (boolean)false);
        c.h((Parcel)parcel, (int)25, (int)this.E);
        c.l((Parcel)parcel, (int)26, (long)this.F);
        c.l((Parcel)parcel, (int)27, (long)this.G);
        c.b((Parcel)parcel, (int)n5);
    }
}

