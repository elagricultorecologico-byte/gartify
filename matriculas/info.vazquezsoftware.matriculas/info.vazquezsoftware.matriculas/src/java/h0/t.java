/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  N0.e
 *  O0.r
 *  O0.v
 *  R0.a
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Throwable
 *  java.util.Collections
 *  java.util.Set
 */
package H0;

import F0.b;
import H0.e;
import H0.f;
import H0.g;
import H0.h;
import H0.i;
import H0.n;
import H0.o;
import H0.p;
import H0.s;
import H0.u;
import O0.r;
import O0.v;
import R0.a;
import android.content.Context;
import java.util.Collections;
import java.util.Set;

public class t
implements s {
    private static volatile u e;
    private final a a;
    private final a b;
    private final N0.e c;
    private final r d;

    t(a a2, a a3, N0.e e2, r r2, v v2) {
        this.a = a2;
        this.b = a3;
        this.c = e2;
        this.d = r2;
        v2.c();
    }

    private i b(n n2) {
        return i.a().i(this.a.a()).k(this.b.a()).j(n2.g()).h(new h(n2.b(), n2.d())).g(n2.c().a()).d();
    }

    public static t c() {
        u u2 = e;
        if (u2 != null) {
            return u2.f();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set d(f f2) {
        if (f2 instanceof g) {
            return Collections.unmodifiableSet((Set)((g)f2).a());
        }
        return Collections.singleton((Object)F0.b.b("proto"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void f(Context context) {
        if (e != null) {
            return;
        }
        Class<t> clazz = t.class;
        synchronized (t.class) {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        if (e != null) break block4;
                        e = H0.e.i().b(context).a();
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                // ** MonitorExit[var1_2] (shouldn't be in output)
                return;
            }
            // ** MonitorExit[var1_2] (shouldn't be in output)
            throw throwable2;
        }
    }

    @Override
    public void a(n n2, F0.h h2) {
        this.c.a(n2.f().f(n2.c().c()), this.b(n2), h2);
    }

    public r e() {
        return this.d;
    }

    public F0.g g(f f2) {
        return new p(t.d(f2), o.a().b(f2.getName()).c(f2.b()).a(), this);
    }
}

