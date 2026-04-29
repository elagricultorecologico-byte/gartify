/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 */
package c3;

import L2.i;
import U2.l;
import c3.X;
import c3.p0;
import c3.r0;
import c3.s0;
import c3.u0;
import c3.v;
import c3.v0;
import java.util.concurrent.CancellationException;

abstract class t0 {
    public static final v a(p0 p02) {
        return new r0(p02);
    }

    public static /* synthetic */ v b(p0 p02, int n2, Object object) {
        if ((n2 & 1) != 0) {
            p02 = null;
        }
        return s0.a(p02);
    }

    public static final void c(i i2, CancellationException cancellationException) {
        if ((i2 = (p0)i2.i(p0.e)) != null) {
            i2.n0(cancellationException);
        }
    }

    public static final void d(i i2) {
        if ((i2 = (p0)i2.i(p0.e)) != null) {
            s0.e((p0)i2);
        }
    }

    public static final void e(p0 p02) {
        if (p02.f()) {
            return;
        }
        throw p02.b0();
    }

    public static final X f(p0 p02, boolean bl, u0 u02) {
        if (p02 instanceof v0) {
            return ((v0)p02).S(bl, u02);
        }
        return p02.X(u02.w(), bl, new l(u02){

            public final void l(Throwable throwable) {
                ((u0)this.h).x(throwable);
            }
        });
    }

    public static /* synthetic */ X g(p0 p02, boolean bl, u0 u02, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = true;
        }
        return s0.f(p02, bl, u02);
    }
}

