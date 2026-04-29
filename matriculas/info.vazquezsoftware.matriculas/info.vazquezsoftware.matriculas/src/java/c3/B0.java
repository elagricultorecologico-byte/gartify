/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.b
 *  h3.q
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package c3;

import L2.i;
import V2.k;
import androidx.concurrent.futures.b;
import c3.J0;
import c3.N;
import c3.S;
import c3.c;
import c3.c0;
import c3.e0;
import h3.M;
import h3.q;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class b0
extends c0
implements S {
    private static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(b0.class, Object.class, (String)"_queue$volatile");
    private static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(b0.class, Object.class, (String)"_delayed$volatile");
    private static final AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(b0.class, (String)"_isCompleted$volatile");
    private volatile Object _delayed$volatile;
    private volatile int _isCompleted$volatile = 0;
    private volatile Object _queue$volatile;

    private final void Y0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b0.l;
        while (true) {
            Object object;
            if ((object = atomicReferenceFieldUpdater.get((Object)this)) == null) {
                if (!b.a((AtomicReferenceFieldUpdater)b0.l, (Object)this, null, (Object)e0.a())) continue;
                break;
            }
            if (object instanceof q) {
                ((q)object).d();
                return;
            }
            if (object == e0.a()) break;
            q q2 = new q(8, true);
            k.c(object, "null cannot be cast to non-null type java.lang.Runnable");
            q2.a((Object)((Runnable)object));
            if (b.a((AtomicReferenceFieldUpdater)b0.l, (Object)this, (Object)object, (Object)q2)) break;
        }
    }

    private final Runnable Z0() {
        Object object;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b0.l;
        while (true) {
            if ((object = atomicReferenceFieldUpdater.get((Object)this)) == null) {
                return null;
            }
            if (object instanceof q) {
                k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                q q2 = (q)object;
                Object object2 = q2.m();
                if (object2 != q.h) {
                    return (Runnable)object2;
                }
                b.a((AtomicReferenceFieldUpdater)b0.l, (Object)this, (Object)object, (Object)q2.l());
                continue;
            }
            if (object == e0.a()) {
                return null;
            }
            if (b.a((AtomicReferenceFieldUpdater)b0.l, (Object)this, (Object)object, null)) break;
        }
        k.c(object, "null cannot be cast to non-null type java.lang.Runnable");
        return (Runnable)object;
    }

    private final void b1() {
        a a3 = (a)b0.m.get((Object)this);
    }

    private final boolean c1(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b0.l;
        while (true) {
            q q2;
            Object object = atomicReferenceFieldUpdater.get((Object)this);
            if (this.g1()) {
                return false;
            }
            if (object == null) {
                if (!b.a((AtomicReferenceFieldUpdater)b0.l, (Object)this, null, (Object)runnable)) continue;
                return true;
            }
            if (object instanceof q) {
                k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                q2 = (q)object;
                int n3 = q2.a((Object)runnable);
                if (n3 != 0) {
                    if (n3 != 1) {
                        if (n3 != 2) continue;
                        return false;
                    }
                    b.a((AtomicReferenceFieldUpdater)b0.l, (Object)this, (Object)object, (Object)q2.l());
                    continue;
                }
                return true;
            }
            if (object == e0.a()) {
                return false;
            }
            q2 = new q(8, true);
            k.c(object, "null cannot be cast to non-null type java.lang.Runnable");
            q2.a((Object)((Runnable)object));
            q2.a((Object)runnable);
            if (b.a((AtomicReferenceFieldUpdater)b0.l, (Object)this, (Object)object, (Object)q2)) break;
        }
        return true;
    }

    private final boolean g1() {
        return b0.n.get((Object)this) != 0;
    }

    private final void j1() {
        c.a();
        System.nanoTime();
        a a3 = (a)b0.m.get((Object)this);
    }

    private final void l1(boolean bl) {
        b0.n.set((Object)this, bl ? 1 : 0);
    }

    @Override
    public final void J0(i i3, Runnable runnable) {
        this.a1(runnable);
    }

    @Override
    protected long Q0() {
        if (super.Q0() == 0L) {
            return 0L;
        }
        Object object = b0.l.get((Object)this);
        if (object != null) {
            if (object instanceof q) {
                if (!((q)object).j()) {
                    return 0L;
                }
            } else {
                if (object == e0.a()) {
                    return Long.MAX_VALUE;
                }
                return 0L;
            }
        }
        object = (a)b0.m.get((Object)this);
        return Long.MAX_VALUE;
    }

    public void a1(Runnable runnable) {
        this.b1();
        if (this.c1(runnable)) {
            this.X0();
            return;
        }
        N.o.a1(runnable);
    }

    protected boolean h1() {
        if (!this.U0()) {
            return false;
        }
        Object object = (a)b0.m.get((Object)this);
        object = b0.l.get((Object)this);
        if (object == null) {
            return true;
        }
        if (object instanceof q) {
            return ((q)object).j();
        }
        return object == e0.a();
    }

    public long i1() {
        if (this.V0()) {
            return 0L;
        }
        this.b1();
        Runnable runnable = this.Z0();
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        return this.Q0();
    }

    protected final void k1() {
        b0.l.set((Object)this, null);
        b0.m.set((Object)this, null);
    }

    @Override
    public void shutdown() {
        J0.a.b();
        this.l1(true);
        this.Y0();
        while (this.i1() <= 0L) {
        }
        this.j1();
    }

    public static final abstract class a
    extends M {
    }
}

