/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StringBuilder
 */
package e3;

import H2.q;
import U2.l;
import V2.t;
import e3.a;
import e3.d;
import e3.h;
import h3.w;

public class m
extends d {
    private final int n;
    private final a o;

    public m(int n2, a a2, l l2) {
        super(n2, l2);
        this.n = n2;
        this.o = a2;
        if (a2 != a.g) {
            if (n2 >= 1) {
                return;
            }
            a2 = new StringBuilder();
            a2.append("Buffered channel capacity must be at least 1, but ");
            a2.append(n2);
            a2.append(" was specified");
            throw new IllegalArgumentException(a2.toString().toString());
        }
        a2 = new StringBuilder();
        a2.append("This implementation does not support suspension for senders, use ");
        a2.append(t.b(d.class).c());
        a2.append(" instead");
        throw new IllegalArgumentException(a2.toString().toString());
    }

    private final Object P0(Object object, boolean bl) {
        Object object2 = super.d(object);
        if (!h.f(object2) && !h.e(object2)) {
            if (bl && (object2 = this.c) != null && (object = w.c((l)object2, object, null, 2, null)) != null) {
                throw object;
            }
            return h.a.c(q.a);
        }
        return object2;
    }

    private final Object Q0(Object object, boolean bl) {
        if (this.o == a.i) {
            return this.P0(object, bl);
        }
        return this.F0(object);
    }

    @Override
    public Object d(Object object) {
        return this.Q0(object, false);
    }

    @Override
    protected boolean g0() {
        return this.o == a.h;
    }
}

