/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.x
 *  androidx.work.impl.utils.futures.c
 *  java.lang.Object
 */
package u0;

import androidx.lifecycle.x;
import t0.m;

public class c
implements m {
    private final x c = new x();
    private final androidx.work.impl.utils.futures.c d = androidx.work.impl.utils.futures.c.u();

    public c() {
        this.a(m.b);
    }

    public void a(m.b b2) {
        this.c.h((Object)b2);
        if (b2 instanceof m.b.c) {
            this.d.q((Object)((m.b.c)b2));
            return;
        }
        if (b2 instanceof m.b.a) {
            b2 = (m.b.a)b2;
            this.d.r(((m.b.a)b2).a());
        }
    }
}

