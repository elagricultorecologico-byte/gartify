/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  h3.K
 *  h3.h
 *  java.lang.Object
 *  java.lang.Throwable
 */
package c3;

import H2.k;
import H2.l;
import H2.q;
import L2.e;
import L2.i;
import c3.D;
import c3.F;
import c3.J0;
import c3.L0;
import c3.U;
import c3.a0;
import h3.K;
import h3.h;

public abstract class V {
    public static final void a(U u2, int n3) {
        Object object = u2.f();
        boolean bl = n3 == 4;
        if (!bl && object instanceof h && V.b(n3) == V.b(u2.i)) {
            Object object2 = (h)object;
            object = object2.j;
            if (((F)object).K0((i)(object2 = object2.getContext()))) {
                ((F)object).J0((i)object2, u2);
                return;
            }
            V.e(u2);
            return;
        }
        V.d(u2, (e)object, bl);
    }

    public static final boolean b(int n3) {
        return n3 == 1 || n3 == 2;
        {
        }
    }

    public static final boolean c(int n3) {
        return n3 == 2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final void d(U object, e object2, boolean bl) {
        Object object3;
        block7: {
            object3 = ((U)object).j();
            Throwable throwable = ((U)object).g(object3);
            if (throwable != null) {
                object = k.g;
                object = l.a(throwable);
            } else {
                k.a a3 = k.g;
                object = ((U)object).h(object3);
            }
            Object object4 = k.a(object);
            if (!bl) {
                object2.e(object4);
                return;
            }
            V2.k.c(object2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            h h3 = (h)object2;
            object = h3.k;
            object3 = h3.m;
            object2 = object.getContext();
            object3 = K.i((i)object2, (Object)object3);
            object = object3 != K.a ? D.m((e)object, (i)object2, object3) : null;
            try {
                h3.k.e(object4);
                q q2 = q.a;
                if (object == null) break block7;
            }
            catch (Throwable throwable2) {
                if (object == null || ((L0)object).K0()) {
                    K.f((i)object2, (Object)object3);
                }
                throw throwable2;
            }
            if (!((L0)object).K0()) {
                return;
            }
        }
        K.f((i)object2, (Object)object3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final void e(U u2) {
        a0 a02 = J0.a.a();
        if (a02.T0()) {
            a02.P0(u2);
            return;
        }
        a02.R0(true);
        try {
            boolean bl;
            V.d(u2, u2.f(), true);
            while (bl = a02.V0()) {
            }
            return;
        }
        catch (Throwable throwable) {
            try {
                u2.i(throwable);
                return;
            }
            finally {
                a02.N0(true);
            }
        }
    }
}

