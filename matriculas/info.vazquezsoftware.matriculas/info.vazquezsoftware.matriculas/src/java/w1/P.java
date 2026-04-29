/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package w1;

import L1.e;
import L1.i;
import L1.j;
import w1.q;

final class p
implements e {
    final j a;
    final q b;

    p(q q2, j j2) {
        this.b = q2;
        this.a = j2;
    }

    @Override
    public final void a(i i2) {
        q.a(this.b).remove((Object)this.a);
    }
}

