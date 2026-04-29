/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
package O0;

import G2.a;
import O0.v;
import O0.x;
import P0.d;
import Q0.b;
import java.util.concurrent.Executor;

public final class w
implements J0.b {
    private final a a;
    private final a b;
    private final a c;
    private final a d;

    public w(a a2, a a3, a a4, a a5) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
    }

    public static w a(a a2, a a3, a a4, a a5) {
        return new w(a2, a3, a4, a5);
    }

    public static v c(Executor executor, d d2, x x2, b b2) {
        return new v(executor, d2, x2, b2);
    }

    public v b() {
        return w.c((Executor)this.a.get(), (d)this.b.get(), (x)this.c.get(), (b)this.d.get());
    }
}

