/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package w1;

import w1.c;
import w1.e;

final class u
implements c.a {
    final e a;

    u(e e2) {
        this.a = e2;
    }

    @Override
    public final void a(boolean bl) {
        e e2 = this.a;
        e.n(e2).sendMessage(e.n(e2).obtainMessage(1, (Object)bl));
    }
}

