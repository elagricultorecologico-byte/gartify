/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package u;

import u.d;
import u.e;
import u.f;

public abstract class k {
    static boolean[] a = new boolean[3];

    static void a(f object, r.d d3, e e2) {
        int n2;
        int n3;
        e2.t = -1;
        e2.u = -1;
        Object object2 = ((e)object).Z[0];
        e.b b2 = e.b.h;
        if (object2 != b2 && e2.Z[0] == e.b.j) {
            n3 = e2.O.g;
            n2 = ((e)object).W() - e2.Q.g;
            object2 = e2.O;
            ((d)object2).i = d3.q(object2);
            object2 = e2.Q;
            ((d)object2).i = d3.q(object2);
            d3.f(e2.O.i, n3);
            d3.f(e2.Q.i, n2);
            e2.t = 2;
            e2.P0(n3, n2);
        }
        if (((e)object).Z[1] != b2 && e2.Z[1] == e.b.j) {
            n2 = e2.P.g;
            n3 = ((e)object).x() - e2.R.g;
            object = e2.P;
            ((d)object).i = d3.q(object);
            object = e2.R;
            ((d)object).i = d3.q(object);
            d3.f(e2.P.i, n2);
            d3.f(e2.R.i, n3);
            if (e2.l0 > 0 || e2.V() == 8) {
                object = e2.S;
                ((d)object).i = d3.q(object);
                d3.f(e2.S.i, e2.l0 + n2);
            }
            e2.u = 2;
            e2.g1(n2, n3);
        }
    }

    public static final boolean b(int n2, int n3) {
        return (n2 & n3) == n3;
    }
}

