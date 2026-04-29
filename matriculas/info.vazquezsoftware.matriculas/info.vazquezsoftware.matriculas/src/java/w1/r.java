/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Object
 *  java.lang.Override
 */
package w1;

import android.app.Activity;
import w1.a0;
import w1.b;
import w1.e;
import w1.g;
import w1.h;
import x1.n;

public final class r
extends a0 {
    private final p.b l = new p.b();
    private final e m;

    r(h h2, e e2, u1.g g2) {
        super(h2, g2);
        this.m = e2;
        this.g.a("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity object, e e2, b b2) {
        h h2 = w1.g.c(object);
        r r2 = (r)h2.b("ConnectionlessLifecycleHelper", r.class);
        object = r2;
        if (r2 == null) {
            object = new r(h2, e2, u1.g.m());
        }
        n.j(b2, "ApiKey cannot be null");
        object.l.add(b2);
        e2.a((r)object);
    }

    private final void v() {
        if (!this.l.isEmpty()) {
            this.m.a(this);
        }
    }

    @Override
    public final void h() {
        super.h();
        this.v();
    }

    @Override
    public final void j() {
        super.j();
        this.v();
    }

    @Override
    public final void k() {
        super.k();
        this.m.b(this);
    }

    @Override
    protected final void m(u1.b b2, int n2) {
        this.m.B(b2, n2);
    }

    @Override
    protected final void n() {
        this.m.C();
    }

    final p.b t() {
        return this.l;
    }
}

