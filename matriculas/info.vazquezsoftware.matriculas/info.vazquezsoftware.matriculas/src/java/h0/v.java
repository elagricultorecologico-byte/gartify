/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  N0.e
 *  O0.r
 *  O0.v
 *  R0.a
 *  java.lang.Object
 */
package H0;

import H0.t;
import J0.b;
import N0.e;
import O0.r;
import R0.a;

public final class v
implements b {
    private final G2.a a;
    private final G2.a b;
    private final G2.a c;
    private final G2.a d;
    private final G2.a e;

    public v(G2.a a2, G2.a a3, G2.a a4, G2.a a5, G2.a a6) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
        this.e = a6;
    }

    public static v a(G2.a a2, G2.a a3, G2.a a4, G2.a a5, G2.a a6) {
        return new v(a2, a3, a4, a5, a6);
    }

    public static t c(a a2, a a3, e e2, r r2, O0.v v2) {
        return new t(a2, a3, e2, r2, v2);
    }

    public t b() {
        return v.c((a)this.a.get(), (a)this.b.get(), (e)this.c.get(), (r)this.d.get(), (O0.v)this.e.get());
    }
}

