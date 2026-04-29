/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 */
package w1;

import w1.e;
import w1.x;
import w1.z;
import x1.c;

final class y
implements c.e {
    final z a;

    y(z z2) {
        this.a = z2;
    }

    @Override
    public final void a() {
        e.n(this.a.s).post((Runnable)new x(this));
    }
}

