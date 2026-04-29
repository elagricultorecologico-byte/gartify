/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Override
 */
package z1;

import L1.i;
import android.content.Context;
import v1.a;
import v1.e;
import w1.n;
import x1.q;
import x1.s;
import x1.t;
import z1.b;
import z1.c;

public final class d
extends e
implements s {
    private static final a.g k;
    private static final a.a l;
    private static final a m;
    public static final int n = 0;

    static {
        a.g g2;
        k = g2 = new a.g();
        c c2 = new c();
        l = c2;
        m = new a("ClientTelemetry.API", c2, g2);
    }

    public d(Context context, t t2) {
        super(context, m, t2, e.a.c);
    }

    @Override
    public final i a(q q2) {
        n.a a2 = w1.n.a();
        a2.d(G1.d.a);
        a2.c(false);
        a2.b(new b(q2));
        return this.d(a2.a());
    }
}

