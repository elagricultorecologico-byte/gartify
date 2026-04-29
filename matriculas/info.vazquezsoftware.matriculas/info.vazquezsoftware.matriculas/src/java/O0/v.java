/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
package O0;

import H0.o;
import O0.t;
import O0.u;
import O0.x;
import P0.d;
import Q0.b;
import java.util.concurrent.Executor;

public class v {
    private final Executor a;
    private final d b;
    private final x c;
    private final b d;

    v(Executor executor, d d2, x x2, b b2) {
        this.a = executor;
        this.b = d2;
        this.c = x2;
        this.d = b2;
    }

    public static /* synthetic */ Object a(v v2) {
        for (o o2 : v2.b.V()) {
            v2.c.b(o2, 1);
        }
        return null;
    }

    public static /* synthetic */ void b(v v2) {
        v2.d.a(new u(v2));
    }

    public void c() {
        this.a.execute((Runnable)new t(this));
    }
}

