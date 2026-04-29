/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  c3.s0
 *  c3.x0
 *  c3.y0
 *  h3.K
 *  i3.a
 *  i3.b
 *  java.lang.Object
 */
package c3;

import L2.e;
import L2.i;
import L2.j;
import N2.h;
import U2.p;
import V2.k;
import c3.D;
import c3.F0;
import c3.I;
import c3.K;
import c3.L0;
import c3.P;
import c3.Q;
import c3.T;
import c3.a;
import c3.f;
import c3.p0;
import c3.s0;
import c3.x0;
import c3.y0;
import h3.z;
import i3.b;

abstract class g {
    public static final P a(I object, i i3, K k3, p p3) {
        object = D.k((I)object, i3);
        object = k3.f() ? new x0((i)object, p3) : new Q((i)object, true);
        ((a)object).J0(k3, object, p3);
        return object;
    }

    public static /* synthetic */ P b(I i3, i i4, K k3, p p3, int n3, Object object) {
        if ((n3 & 1) != 0) {
            i4 = j.g;
        }
        if ((n3 & 2) != 0) {
            k3 = K.g;
        }
        return f.a(i3, i4, k3, p3);
    }

    public static final p0 c(I object, i i3, K k3, p p3) {
        object = D.k((I)object, i3);
        object = k3.f() ? new y0((i)object, p3) : new F0((i)object, true);
        ((a)object).J0(k3, object, p3);
        return object;
    }

    public static /* synthetic */ p0 d(I i3, i i4, K k3, p p3, int n3, Object object) {
        if ((n3 & 1) != 0) {
            i4 = j.g;
        }
        if ((n3 & 2) != 0) {
            k3 = K.g;
        }
        return f.c(i3, i4, k3, p3);
    }

    public static final Object e(i object, p p3, e e3) {
        i i3 = e3.getContext();
        Object object2 = D.j(i3, (i)object);
        s0.d((i)object2);
        if (object2 == i3) {
            object = new z((i)object2, e3);
            object = b.b((z)object, (Object)object, (p)p3);
        } else {
            object = L2.f.a;
            if (k.a(object2.i((i.c)object), i3.i((i.c)object))) {
                object = new L0((i)object2, e3);
                i3 = ((a)object).getContext();
                object2 = h3.K.i((i)i3, null);
                try {
                    object = b.b((z)object, (Object)object, (p)p3);
                }
                finally {
                    h3.K.f((i)i3, (Object)object2);
                }
            } else {
                object = new T((i)object2, e3);
                i3.a.c((p)p3, (Object)object, (e)object);
                object = ((T)object).K0();
            }
        }
        if (object == M2.b.e()) {
            h.c(e3);
        }
        return object;
    }
}

