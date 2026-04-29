/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  c3.z
 *  h3.K
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 */
package c3;

import H2.j;
import H2.n;
import H2.q;
import L2.e;
import L2.f;
import L2.i;
import c3.D;
import c3.F;
import c3.M0;
import c3.z;
import h3.K;

public final class L0
extends h3.z {
    private final ThreadLocal k;
    private volatile boolean threadLocalIsSet;

    public L0(i i3, e object) {
        i i4 = M0.g;
        i4 = i3.i((i.c)((Object)i4)) == null ? i3.s0(i4) : i3;
        super(i4, (e)object);
        this.k = new ThreadLocal();
        if (!(object.getContext().i(f.a) instanceof F)) {
            object = K.i((i)i3, null);
            K.f((i)i3, (Object)object);
            this.L0(i3, object);
        }
    }

    @Override
    protected void F0(Object object) {
        Object object2;
        if (this.threadLocalIsSet) {
            object2 = (j)this.k.get();
            if (object2 != null) {
                K.f((i)((i)((j)object2).a()), (Object)((j)object2).b());
            }
            this.k.remove();
        }
        Object object3 = z.a((Object)object, (e)this.j);
        e e3 = this.j;
        i i3 = e3.getContext();
        object = null;
        object2 = K.i((i)i3, null);
        if (object2 != K.a) {
            object = D.m(e3, i3, object2);
        }
        try {
            this.j.e(object3);
            object3 = q.a;
        }
        catch (Throwable throwable) {
            if (object == null || ((L0)object).K0()) {
                K.f((i)i3, (Object)object2);
            }
            throw throwable;
        }
        if (object != null && !((L0)object).K0()) {
            return;
        }
        K.f((i)i3, (Object)object2);
    }

    public final boolean K0() {
        boolean bl = this.threadLocalIsSet && this.k.get() == null;
        this.k.remove();
        return bl ^ true;
    }

    public final void L0(i i3, Object object) {
        this.threadLocalIsSet = true;
        this.k.set((Object)n.a(i3, object));
    }
}

