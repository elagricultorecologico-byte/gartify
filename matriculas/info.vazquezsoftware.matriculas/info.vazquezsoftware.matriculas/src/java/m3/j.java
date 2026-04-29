/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.TimeUnit
 */
package m3;

import V2.k;
import java.util.concurrent.TimeUnit;
import q3.e;
import r3.g;

public final class j {
    private final g a;

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public j(int n2, long l2, TimeUnit timeUnit) {
        k.e(timeUnit, "timeUnit");
        this(new g(e.i, n2, l2, timeUnit));
    }

    public j(g g2) {
        k.e(g2, "delegate");
        this.a = g2;
    }

    public final g a() {
        return this.a;
    }
}

