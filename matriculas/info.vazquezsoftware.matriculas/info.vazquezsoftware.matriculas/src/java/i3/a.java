/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package i3;

import H2.k;
import H2.l;
import H2.q;
import L2.e;
import M2.b;
import U2.p;
import h3.i;

public abstract class a {
    private static final void a(e e2, Throwable throwable) {
        k.a a2 = k.g;
        e2.e(k.a(l.a(throwable)));
        throw throwable;
    }

    public static final void b(e e2, e e3) {
        try {
            e2 = b.c(e2);
            k.a a2 = k.g;
            i.b(e2, k.a(q.a));
            return;
        }
        catch (Throwable throwable) {
            a.a(e3, throwable);
            return;
        }
    }

    public static final void c(p object, Object object2, e e2) {
        try {
            object = b.c(b.a((p)object, object2, e2));
            object2 = k.g;
            i.b((e)object, k.a(q.a));
            return;
        }
        catch (Throwable throwable) {
            a.a(e2, throwable);
            return;
        }
    }
}

