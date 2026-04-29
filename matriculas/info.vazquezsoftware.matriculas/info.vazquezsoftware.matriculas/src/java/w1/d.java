/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Set
 */
package w1;

import android.util.Log;
import java.util.Set;
import v1.a;
import w1.C;
import w1.N;
import w1.b;
import w1.e;
import w1.z;
import x1.c;
import x1.i;

final class D
implements c.c,
N {
    private final a.f a;
    private final b b;
    private i c;
    private Set d;
    private boolean e;
    final e f;

    public D(e e2, a.f f2, b b2) {
        this.f = e2;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = f2;
        this.b = b2;
    }

    static /* bridge */ /* synthetic */ a.f e(D d2) {
        return d2.a;
    }

    static /* bridge */ /* synthetic */ b f(D d2) {
        return d2.b;
    }

    static /* bridge */ /* synthetic */ void g(D d2, boolean bl) {
        d2.e = true;
    }

    static /* bridge */ /* synthetic */ void h(D d2) {
        d2.i();
    }

    private final void i() {
        i i2;
        if (this.e && (i2 = this.c) != null) {
            this.a.m(i2, this.d);
        }
    }

    @Override
    public final void a(u1.b b2) {
        w1.e.n(this.f).post((Runnable)new C(this, b2));
    }

    @Override
    public final void b(u1.b b2) {
        z z2 = (z)w1.e.w(this.f).get((Object)this.b);
        if (z2 != null) {
            z2.G(b2);
        }
    }

    @Override
    public final void c(i i2, Set set) {
        if (i2 != null && set != null) {
            this.c = i2;
            this.d = set;
            this.i();
            return;
        }
        Log.wtf((String)"GoogleApiManager", (String)"Received null response from onSignInSuccess", (Throwable)new Exception());
        this.b(new u1.b(4));
    }

    @Override
    public final void d(int n2) {
        z z2 = (z)w1.e.w(this.f).get((Object)this.b);
        if (z2 != null) {
            if (z.K(z2)) {
                z2.G(new u1.b(17));
                return;
            }
            z2.a(n2);
        }
    }
}

