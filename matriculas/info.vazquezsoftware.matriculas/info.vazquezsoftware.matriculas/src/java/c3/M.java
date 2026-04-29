/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 */
package c3;

import L2.e;
import c3.X;
import c3.Y;
import c3.h;
import c3.i;
import c3.k;

public abstract class m {
    public static final void a(i i2, X x2) {
        m.c(i2, new Y(x2));
    }

    public static final k b(e e2) {
        if (!(e2 instanceof h3.h)) {
            return new k(e2, 1);
        }
        k k2 = ((h3.h)e2).n();
        if (k2 != null) {
            if (!k2.O()) {
                k2 = null;
            }
            if (k2 != null) {
                return k2;
            }
        }
        return new k(e2, 2);
    }

    public static final void c(i i2, h h2) {
        if (i2 instanceof k) {
            ((k)i2).H(h2);
            return;
        }
        throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
    }
}

