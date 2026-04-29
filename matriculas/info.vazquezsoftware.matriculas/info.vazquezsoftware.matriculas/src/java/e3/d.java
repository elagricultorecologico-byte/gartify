/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.r
 *  androidx.concurrent.futures.b
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 *  k3.a
 */
package e3;

import H2.k;
import H2.q;
import I2.o;
import L2.i;
import androidx.activity.r;
import c3.N0;
import c3.m;
import e3.b;
import e3.c;
import e3.e;
import e3.f;
import e3.h;
import e3.j;
import e3.k;
import e3.l;
import e3.p;
import h3.A;
import h3.B;
import h3.C;
import h3.D;
import h3.P;
import h3.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.a;

public class d
implements f {
    private static final AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(d.class, (String)"sendersAndCloseStatus$volatile");
    private static final AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(d.class, (String)"receivers$volatile");
    private static final AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(d.class, (String)"bufferEnd$volatile");
    private static final AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(d.class, (String)"completedExpandBuffersAndPauseFlag$volatile");
    private static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, (String)"sendSegment$volatile");
    private static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, (String)"receiveSegment$volatile");
    private static final AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, (String)"bufferEndSegment$volatile");
    private static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, (String)"_closeCause$volatile");
    private static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, (String)"closeHandler$volatile");
    private volatile Object _closeCause$volatile;
    private final int b;
    private volatile long bufferEnd$volatile;
    private volatile Object bufferEndSegment$volatile;
    public final U2.l c;
    private volatile Object closeHandler$volatile;
    private volatile long completedExpandBuffersAndPauseFlag$volatile;
    private final U2.q d;
    private volatile Object receiveSegment$volatile;
    private volatile long receivers$volatile;
    private volatile Object sendSegment$volatile;
    private volatile long sendersAndCloseStatus$volatile;

    public d(int n2, U2.l c2) {
        this.b = n2;
        this.c = c2;
        if (n2 >= 0) {
            this.bufferEnd$volatile = e3.e.s(n2);
            this.completedExpandBuffersAndPauseFlag$volatile = this.I();
            j j2 = new j(0L, null, this, 3);
            this.sendSegment$volatile = j2;
            this.receiveSegment$volatile = j2;
            if (this.h0()) {
                j2 = e3.e.m();
                V2.k.c(j2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = j2;
            c2 = c2 != null ? new b(this) : null;
            this.d = c2;
            this._closeCause$volatile = e3.e.l();
            return;
        }
        c2 = new StringBuilder();
        c2.append("Invalid channel capacity: ");
        c2.append(n2);
        c2.append(", should be >=0");
        throw new IllegalArgumentException(c2.toString().toString());
    }

    private final j A(long l2) {
        long l3;
        j j2 = this.x();
        if (this.g0() && (l3 = this.i0(j2)) != -1L) {
            this.C(l3);
        }
        this.w(j2, l2);
        return j2;
    }

    private final void A0(N0 n02) {
        this.B0(n02, false);
    }

    private final void B() {
        this.e0();
    }

    private final void B0(N0 object, boolean bl) {
        if (object instanceof c3.i) {
            L2.e e2 = (L2.e)object;
            object = H2.k.g;
            object = bl ? this.N() : this.R();
            e2.e(H2.k.a(H2.l.a((Throwable)object)));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected waiter: ");
        stringBuilder.append(object);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private final boolean C0(long l2) {
        if (this.f0(l2)) {
            return false;
        }
        return this.v(l2 & 0xFFFFFFFFFFFFFFFL) ^ true;
    }

    private final void D() {
        if (this.h0()) {
            return;
        }
        j j2 = (j)e3.d.k.get((Object)this);
        while (true) {
            long l2 = e3.d.g.getAndIncrement((Object)this);
            int n2 = e3.e.b;
            long l3 = l2 / (long)n2;
            if (this.U() <= l2) {
                if (j2.c < l3 && j2.f() != null) {
                    this.m0(l3, j2);
                }
                e3.d.Y(this, 0L, 1, null);
                return;
            }
            if (j2.c != l3) {
                j j3 = this.E(l3, j2, l2);
                if (j3 == null) continue;
                j2 = j3;
            }
            if (this.G0(j2, (int)(l2 % (long)n2), l2)) {
                e3.d.Y(this, 0L, 1, null);
                return;
            }
            e3.d.Y(this, 0L, 1, null);
        }
    }

    private final boolean D0(Object object, Object object2) {
        if (object instanceof c3.i) {
            V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            c3.i i2 = (c3.i)object;
            object = this.c;
            object = object != null ? this.u((U2.l)object) : null;
            return e3.e.t(i2, object2, (U2.q)object);
        }
        object2 = new StringBuilder();
        object2.append("Unexpected receiver type: ");
        object2.append(object);
        throw new IllegalStateException(object2.toString().toString());
    }

    private final j E(long l2, j j2, long l3) {
        Object object;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e3.d.k;
        U2.p p2 = (U2.p)((Object)e3.e.x());
        block0: while (!B.c(object = h3.a.c(j2, l2, p2))) {
            A a2 = B.b(object);
            while (true) {
                A a3 = (A)atomicReferenceFieldUpdater.get((Object)this);
                if (a3.c >= a2.c) break block0;
                if (!a2.u()) continue block0;
                if (androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)atomicReferenceFieldUpdater, (Object)this, (Object)a3, (Object)a2)) {
                    if (!a3.p()) break block0;
                    a3.n();
                    break block0;
                }
                if (!a2.p()) continue;
                a2.n();
            }
        }
        if (B.c(object)) {
            this.B();
            this.m0(l2, j2);
            e3.d.Y(this, 0L, 1, null);
            return null;
        }
        j2 = (j)B.b(object);
        if (j2.c > l2) {
            int n2;
            p2 = e3.d.g;
            if (p2.compareAndSet(this, l3 + 1L, (l2 = j2.c) * (long)(n2 = e3.e.b))) {
                this.X(j2.c * (long)n2 - l3);
            } else {
                e3.d.Y(this, 0L, 1, null);
            }
            return null;
        }
        return j2;
    }

    private final boolean E0(Object object, j j2, int n2) {
        if (object instanceof c3.i) {
            V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return e3.e.B((c3.i)object, q.a, null, 2, null);
        }
        j2 = new StringBuilder();
        j2.append("Unexpected waiter: ");
        j2.append(object);
        throw new IllegalStateException(j2.toString().toString());
    }

    private final j F(long l2, j j2) {
        long l3;
        Object object;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e3.d.j;
        Object object2 = (U2.p)((Object)e3.e.x());
        block0: while (!B.c(object = h3.a.c(j2, l2, (U2.p)object2))) {
            A a2 = B.b(object);
            while (true) {
                A a3 = (A)atomicReferenceFieldUpdater.get((Object)this);
                if (a3.c >= a2.c) break block0;
                if (!a2.u()) continue block0;
                if (androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)atomicReferenceFieldUpdater, (Object)this, (Object)a3, (Object)a2)) {
                    if (!a3.p()) break block0;
                    a3.n();
                    break block0;
                }
                if (!a2.p()) continue;
                a2.n();
            }
        }
        if (B.c(object)) {
            this.B();
            if (j2.c * (long)e3.e.b < this.U()) {
                j2.c();
            }
            return null;
        }
        object2 = (j)B.b(object);
        if (!this.h0() && l2 <= this.I() / (long)e3.e.b) {
            j2 = e3.d.k;
            while (true) {
                object = (A)j2.get(this);
                if (((A)object).c >= ((A)object2).c || !((A)object2).u()) break;
                if (androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)j2, (Object)this, (Object)object, (Object)object2)) {
                    if (!((A)object).p()) break;
                    ((h3.b)object).n();
                    break;
                }
                if (!((A)object2).p()) continue;
                ((h3.b)object2).n();
            }
        }
        if ((l3 = ((A)object2).c) > l2) {
            int n2 = e3.e.b;
            this.M0(l3 * (long)n2);
            if (((A)object2).c * (long)n2 < this.U()) {
                ((h3.b)object2).c();
            }
            return null;
        }
        return object2;
    }

    private final j G(long l2, j j2) {
        Object object;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e3.d.i;
        U2.p p2 = (U2.p)((Object)e3.e.x());
        block0: while (!B.c(object = h3.a.c(j2, l2, p2))) {
            A a2 = B.b(object);
            while (true) {
                A a3 = (A)atomicReferenceFieldUpdater.get((Object)this);
                if (a3.c >= a2.c) break block0;
                if (!a2.u()) continue block0;
                if (androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)atomicReferenceFieldUpdater, (Object)this, (Object)a3, (Object)a2)) {
                    if (!a3.p()) break block0;
                    a3.n();
                    break block0;
                }
                if (!a2.p()) continue;
                a2.n();
            }
        }
        if (B.c(object)) {
            this.B();
            if (j2.c * (long)e3.e.b < this.Q()) {
                j2.c();
            }
            return null;
        }
        j2 = (j)B.b(object);
        long l3 = j2.c;
        if (l3 > l2) {
            int n2 = e3.e.b;
            this.N0(l3 * (long)n2);
            if (j2.c * (long)n2 < this.Q()) {
                j2.c();
            }
            return null;
        }
        return j2;
    }

    private final boolean G0(j j2, int n2, long l2) {
        Object object = j2.B(n2);
        if (object instanceof N0 && l2 >= e3.d.f.get((Object)this) && j2.v(n2, object, e3.e.o())) {
            if (this.E0(object, j2, n2)) {
                j2.F(n2, e3.e.d);
                return true;
            }
            j2.F(n2, e3.e.j());
            j2.C(n2, false);
            return false;
        }
        return this.H0(j2, n2, l2);
    }

    private final boolean H0(j j2, int n2, long l2) {
        block8: {
            Object object;
            while (true) {
                if ((object = j2.B(n2)) instanceof N0) {
                    if (l2 < e3.d.f.get((Object)this)) {
                        if (!j2.v(n2, object, new p((N0)object))) continue;
                        return true;
                    }
                    if (!j2.v(n2, object, e3.e.o())) continue;
                    if (this.E0(object, j2, n2)) {
                        j2.F(n2, e3.e.d);
                        return true;
                    }
                    j2.F(n2, e3.e.j());
                    j2.C(n2, false);
                    return false;
                }
                if (object == e3.e.j()) {
                    return false;
                }
                if (object == null) {
                    if (!j2.v(n2, object, e3.e.k())) continue;
                    return true;
                }
                if (object == e3.e.d) {
                    return true;
                }
                if (object == e3.e.n() || object == e3.e.f() || object == e3.e.i()) break block8;
                if (object == e3.e.y()) {
                    return true;
                }
                if (object != e3.e.p()) break;
            }
            j2 = new StringBuilder();
            j2.append("Unexpected cell state: ");
            j2.append(object);
            throw new IllegalStateException(j2.toString().toString());
        }
        return true;
    }

    private final long I() {
        return e3.d.g.get((Object)this);
    }

    private final Object I0(j j2, int n2, long l2, Object object) {
        Object object2 = j2.B(n2);
        if (object2 == null) {
            if (l2 >= (e3.d.e.get((Object)this) & 0xFFFFFFFFFFFFFFFL)) {
                if (object == null) {
                    return e3.e.r();
                }
                if (j2.v(n2, object2, object)) {
                    this.D();
                    return e3.e.q();
                }
            }
        } else if (object2 == e3.e.d && j2.v(n2, object2, e3.e.f())) {
            this.D();
            return j2.D(n2);
        }
        return this.J0(j2, n2, l2, object);
    }

    private final Object J0(j j2, int n2, long l2, Object object) {
        while (true) {
            Object object2;
            if ((object2 = j2.B(n2)) != null && object2 != e3.e.k()) {
                if (object2 == e3.e.d) {
                    if (!j2.v(n2, object2, e3.e.f())) continue;
                    this.D();
                    return j2.D(n2);
                }
                if (object2 == e3.e.j()) {
                    return e3.e.h();
                }
                if (object2 == e3.e.n()) {
                    return e3.e.h();
                }
                if (object2 == e3.e.y()) {
                    this.D();
                    return e3.e.h();
                }
                if (object2 == e3.e.o() || !j2.v(n2, object2, e3.e.p())) continue;
                boolean bl = object2 instanceof p;
                object = object2;
                if (bl) {
                    object = ((p)object2).a;
                }
                if (this.E0(object, j2, n2)) {
                    j2.F(n2, e3.e.f());
                    this.D();
                    return j2.D(n2);
                }
                j2.F(n2, e3.e.j());
                j2.C(n2, false);
                if (bl) {
                    this.D();
                }
                return e3.e.h();
            }
            if (l2 < (e3.d.e.get((Object)this) & 0xFFFFFFFFFFFFFFFL)) {
                if (!j2.v(n2, object2, e3.e.n())) continue;
                this.D();
                return e3.e.h();
            }
            if (object == null) {
                return e3.e.r();
            }
            if (j2.v(n2, object2, object)) break;
        }
        this.D();
        return e3.e.q();
    }

    private final int K0(j j2, int n2, Object object, long l2, Object object2, boolean bl) {
        j2.G(n2, object);
        if (bl) {
            return this.L0(j2, n2, object, l2, object2, bl);
        }
        Object object3 = j2.B(n2);
        if (object3 == null) {
            if (this.v(l2)) {
                if (j2.v(n2, null, e3.e.d)) {
                    return 1;
                }
            } else {
                if (object2 == null) {
                    return 3;
                }
                if (j2.v(n2, null, object2)) {
                    return 2;
                }
            }
        } else if (object3 instanceof N0) {
            j2.w(n2);
            if (this.D0(object3, object)) {
                j2.F(n2, e3.e.f());
                this.q0();
                return 0;
            }
            if (j2.x(n2, e3.e.i()) != e3.e.i()) {
                j2.C(n2, true);
            }
            return 5;
        }
        return this.L0(j2, n2, object, l2, object2, bl);
    }

    private final int L0(j j2, int n2, Object object, long l2, Object object2, boolean bl) {
        Object object3;
        block11: {
            while (true) {
                if ((object3 = j2.B(n2)) == null) {
                    if (this.v(l2) && !bl) {
                        if (!j2.v(n2, null, e3.e.d)) continue;
                        return 1;
                    }
                    if (bl) {
                        if (!j2.v(n2, null, e3.e.j())) continue;
                        j2.C(n2, false);
                        return 4;
                    }
                    if (object2 == null) {
                        return 3;
                    }
                    if (!j2.v(n2, null, object2)) continue;
                    return 2;
                }
                if (object3 != e3.e.k()) break block11;
                if (j2.v(n2, object3, e3.e.d)) break;
            }
            return 1;
        }
        if (object3 == e3.e.i()) {
            j2.w(n2);
            return 5;
        }
        if (object3 == e3.e.n()) {
            j2.w(n2);
            return 5;
        }
        if (object3 == e3.e.y()) {
            j2.w(n2);
            this.B();
            return 4;
        }
        j2.w(n2);
        object2 = object3;
        if (object3 instanceof p) {
            object2 = ((p)object3).a;
        }
        if (this.D0(object2, object)) {
            j2.F(n2, e3.e.f());
            this.q0();
            return 0;
        }
        if (j2.x(n2, e3.e.i()) != e3.e.i()) {
            j2.C(n2, true);
        }
        return 5;
    }

    private final void M0(long l2) {
        long l3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = e3.d.f;
        while ((l3 = atomicLongFieldUpdater.get((Object)this)) < l2 && !e3.d.f.compareAndSet((Object)this, l3, l2)) {
        }
    }

    private final Throwable N() {
        Throwable throwable;
        Object object = throwable = this.K();
        if (throwable == null) {
            object = new k("Channel was closed");
        }
        return object;
    }

    private final void N0(long l2) {
        long l3;
        long l4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = e3.d.e;
        while ((l4 = 0xFFFFFFFFFFFFFFFL & (l3 = atomicLongFieldUpdater.get((Object)this))) < l2) {
            l4 = e3.e.b(l4, (int)(l3 >> 60));
            if (!e3.d.e.compareAndSet((Object)this, l3, l4)) continue;
        }
    }

    private final void X(long l2) {
        if ((e3.d.h.addAndGet((Object)this, l2) & 0x4000000000000000L) != 0L) {
            while ((e3.d.h.get((Object)this) & 0x4000000000000000L) != 0L) {
            }
        }
    }

    static /* synthetic */ void Y(d d2, long l2, int n2, Object object) {
        if (object == null) {
            if ((n2 & 1) != 0) {
                l2 = 1L;
            }
            d2.X(l2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void Z() {
        Object object;
        Object object2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e3.d.m;
        while (!androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)atomicReferenceFieldUpdater, (Object)this, (Object)object2, (Object)(object = (object2 = atomicReferenceFieldUpdater.get((Object)this)) == null ? e3.e.d() : e3.e.e()))) {
        }
        if (object2 == null) {
            return;
        }
        object = (U2.l)V2.w.a(object2, 1);
        ((U2.l)object2).j(this.K());
    }

    private final boolean a0(j j2, int n2, long l2) {
        Object object;
        do {
            if ((object = j2.B(n2)) == null || object == e3.e.k()) continue;
            if (object == e3.e.d) {
                return true;
            }
            if (object == e3.e.j()) {
                return false;
            }
            if (object == e3.e.y()) {
                return false;
            }
            if (object == e3.e.f()) {
                return false;
            }
            if (object == e3.e.n()) {
                return false;
            }
            if (object == e3.e.o()) {
                return true;
            }
            if (object == e3.e.p()) {
                return false;
            }
            return l2 == this.Q();
        } while (!j2.v(n2, object, e3.e.n()));
        this.D();
        return false;
    }

    private final boolean b0(long l2, boolean bl) {
        int n2 = (int)(l2 >> 60);
        if (n2 != 0 && n2 != 1) {
            if (n2 != 2) {
                if (n2 == 3) {
                    this.z(l2 & 0xFFFFFFFFFFFFFFFL);
                    return true;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected close status: ");
                stringBuilder.append(n2);
                throw new IllegalStateException(stringBuilder.toString().toString());
            }
            this.A(l2 & 0xFFFFFFFFFFFFFFFL);
            if (bl) {
                return !this.W();
            }
            return true;
        }
        return false;
    }

    private final boolean d0(long l2) {
        return this.b0(l2, true);
    }

    public static /* synthetic */ q e(Object object, d d2, a a2, Throwable throwable, Object object2, i i2) {
        return e3.d.t0(object, d2, a2, throwable, object2, i2);
    }

    public static /* synthetic */ U2.q f(d d2, a a2, Object object, Object object2) {
        return e3.d.s0(d2, a2, object, object2);
    }

    private final boolean f0(long l2) {
        return this.b0(l2, false);
    }

    public static final /* synthetic */ Z2.d g(d d2, U2.l l2) {
        return d2.u(l2);
    }

    private final boolean h0() {
        long l2 = this.I();
        return l2 == 0L || l2 == Long.MAX_VALUE;
        {
        }
    }

    private final long i0(j j2) {
        Object object;
        do {
            block1: for (int i2 = e3.e.b - 1; -1 < i2; --i2) {
                long l2 = j2.c * (long)e3.e.b + (long)i2;
                if (l2 < this.Q()) {
                    return -1L;
                }
                do {
                    if ((object = j2.B(i2)) == null || object == e3.e.k()) continue;
                    if (object != e3.e.d) continue block1;
                    return l2;
                } while (!j2.v(i2, object, e3.e.y()));
                j2.t();
            }
            object = (j)j2.h();
            j2 = object;
        } while (object != null);
        return -1L;
    }

    private final void j0() {
        long l2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = e3.d.e;
        while ((int)((l2 = atomicLongFieldUpdater.get((Object)this)) >> 60) == 0 && !atomicLongFieldUpdater.compareAndSet((Object)this, l2, e3.e.b(0xFFFFFFFFFFFFFFFL & l2, 1))) {
        }
    }

    private final void k0() {
        long l2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = e3.d.e;
        while (!atomicLongFieldUpdater.compareAndSet((Object)this, l2 = atomicLongFieldUpdater.get((Object)this), e3.e.b(0xFFFFFFFFFFFFFFFL & l2, 3))) {
        }
    }

    private final void l0() {
        long l2;
        long l3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = e3.d.e;
        do {
            int n2;
            if ((n2 = (int)((l3 = atomicLongFieldUpdater.get((Object)this)) >> 60)) != 0) {
                if (n2 != 1) break;
                l2 = e3.e.b(0xFFFFFFFFFFFFFFFL & l3, 3);
                continue;
            }
            l2 = e3.e.b(0xFFFFFFFFFFFFFFFL & l3, 2);
        } while (!atomicLongFieldUpdater.compareAndSet((Object)this, l3, l2));
    }

    /*
     * Unable to fully structure code
     */
    private final void m0(long var1_1, j var3_2) {
        while (true) {
            var4_3 = var3_2;
            if (var3_2.c >= var1_1) break;
            var4_3 = (j)var3_2.f();
            if (var4_3 == null) {
                var4_3 = var3_2;
                break;
            }
            var3_2 = var4_3;
        }
        block1: while (true) {
            if (var4_3.k() && (var3_2 = (j)var4_3.f()) != null) {
                var4_3 = var3_2;
                continue;
            }
            var3_2 = e3.d.J();
            while (true) {
                var5_4 = (A)var3_2.get(this);
                if (var5_4.c >= var4_3.c) {
                    return;
                }
                if (var4_3.u()) ** break;
                continue block1;
                if (androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)var3_2, (Object)this, (Object)var5_4, (Object)var4_3)) {
                    if (var5_4.p()) {
                        var5_4.n();
                    }
                    return;
                }
                if (!var4_3.p()) continue;
                var4_3.n();
            }
            break;
        }
    }

    private final void n0(Throwable object, Object object2, i i2) {
        object = this.c;
        V2.k.b(object);
        w.a((U2.l)object, object2, i2);
    }

    public static final /* synthetic */ void p(d d2, c3.i i2) {
        d2.p0(i2);
    }

    private final void p0(c3.i i2) {
        k.a a2 = H2.k.g;
        i2.e(H2.k.a(H2.l.a(this.N())));
    }

    private static final U2.q s0(d d2, a a2, Object object, Object object2) {
        return new c(object2, d2, a2);
    }

    private static final q t0(Object object, d d2, a a2, Throwable throwable, Object object2, i i2) {
        if (object != e3.e.y()) {
            w.a(d2.c, object, a2.getContext());
        }
        return q.a;
    }

    private final Z2.d u(U2.l l2) {
        return new U2.q(this){

            public final void l(Throwable throwable, Object object, i i2) {
                ((d)this.h).n0(throwable, object, i2);
            }
        };
    }

    private final void u0(N0 n02, j j2, int n2) {
        this.r0();
        n02.a(j2, n2);
    }

    private final boolean v(long l2) {
        return l2 < this.I() || l2 < this.Q() + (long)this.b;
        {
        }
    }

    private final void v0(N0 n02, j j2, int n2) {
        n02.a(j2, n2 + e3.e.b);
    }

    /*
     * Unable to fully structure code
     */
    private final void w(j var1_1, long var2_2) {
        var5_3 = h3.j.b(null, 1, null);
        var6_4 = var1_1;
        var1_1 = var5_3;
        block0: while (true) {
            var5_3 = var1_1;
            if (var6_4 == null) break;
            for (var4_5 = e3.e.b - 1; -1 < var4_5; --var4_5) {
                block6: {
                    var5_3 = var1_1;
                    if (var6_4.c * (long)e3.e.b + (long)var4_5 < var2_2) break block0;
                    do lbl-1000:
                    // 4 sources

                    {
                        block7: {
                            if ((var7_6 = var6_4.B(var4_5)) == null || var7_6 == e3.e.k()) continue;
                            if (!(var7_6 instanceof p)) break block7;
                            if (!var6_4.v(var4_5, var7_6, e3.e.y())) ** GOTO lbl-1000
                            var5_3 = h3.j.c(var1_1, ((p)var7_6).a);
                            var6_4.C(var4_5, true);
                            break block6;
                        }
                        var5_3 = var1_1;
                        if (!(var7_6 instanceof N0)) break block6;
                        if (!var6_4.v(var4_5, var7_6, e3.e.y())) ** GOTO lbl-1000
                        var5_3 = h3.j.c(var1_1, var7_6);
                        var6_4.C(var4_5, true);
                        break block6;
                    } while (!var6_4.v(var4_5, var7_6, e3.e.y()));
                    var6_4.t();
                    var5_3 = var1_1;
                }
                var1_1 = var5_3;
            }
            var6_4 = (j)var6_4.h();
        }
        if (var5_3 != null) {
            if (!(var5_3 instanceof ArrayList)) {
                this.z0((N0)var5_3);
                return;
            }
            V2.k.c(var5_3, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            var1_1 = (ArrayList)var5_3;
            for (var4_5 = var1_1.size() - 1; -1 < var4_5; --var4_5) {
                this.z0((N0)var1_1.get(var4_5));
            }
        }
    }

    static /* synthetic */ Object w0(d object, L2.e e2) {
        Object object2 = (j)e3.d.j.get(object);
        d d2 = object;
        object = object2;
        while (!d2.c0()) {
            long l2 = e3.d.f.getAndIncrement((Object)d2);
            int n2 = e3.e.b;
            long l3 = l2 / (long)n2;
            n2 = (int)(l2 % (long)n2);
            if (((A)object).c != l3) {
                object2 = d2.F(l3, (j)object);
                if (object2 == null) continue;
                object = object2;
            }
            if ((object2 = d2.I0((j)object, n2, l2, null)) != e3.e.q()) {
                if (object2 == e3.e.h()) {
                    if (l2 >= d2.U()) continue;
                    ((h3.b)object).c();
                    continue;
                }
                if (object2 == e3.e.r()) {
                    return d2.x0((j)object, n2, l2, e2);
                }
                ((h3.b)object).c();
                return object2;
            }
            throw new IllegalStateException("unexpected");
        }
        throw C.a(d2.N());
    }

    private final j x() {
        Object object = e3.d.k.get((Object)this);
        Object object2 = (j)e3.d.i.get((Object)this);
        Object object3 = object;
        if (((A)object2).c > ((j)object).c) {
            object3 = object2;
        }
        object = (j)e3.d.j.get((Object)this);
        object2 = object3;
        if (((A)object).c > ((j)object3).c) {
            object2 = object;
        }
        return (j)h3.a.b((h3.b)object2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object x0(j var1_1, int var2_3, long var3_4, L2.e var5_5) {
        block16: {
            var9_6 = c3.m.b(M2.b.c(var5_5));
            var11_7 = e3.d.s(this, (j)var1_1, var2_3, var3_4, var9_6);
            if (var11_7 == e3.e.q()) {
                e3.d.q(this, var9_6, (j)var1_1, var2_3);
                break block16;
            }
            var13_8 = e3.e.h();
            var8_9 = null;
            var12_10 = null;
            var10_11 = null;
            if (var11_7 != var13_8) ** GOTO lbl17
            if (var3_4 < this.U()) {
                var1_1.c();
            }
            var1_1 = (j)e3.d.j().get((Object)this);
            ** GOTO lbl27
            {
                block17: {
                    catch (Throwable var1_2) {}
lbl17:
                    // 1 sources

                    var1_1.c();
                    var8_9 = this.c;
                    var1_1 = var12_10;
                    if (var8_9 != null) {
                        var1_1 = e3.d.g(this, (U2.l)var8_9);
                    }
                    var8_9 = (U2.q)var1_1;
                    var1_1 = var11_7;
                    break block17;
                    var9_6.N();
                    throw var1_2;
lbl27:
                    // 1 sources

                    while (true) {
                        if (this.c0()) {
                            e3.d.p(this, var9_6);
                            break block16;
                        }
                        var3_4 = e3.d.k().getAndIncrement((Object)this);
                        var2_3 = e3.e.b;
                        var6_12 = var3_4 / (long)var2_3;
                        var2_3 = (int)(var3_4 % (long)var2_3);
                        if (var1_1.c != var6_12) {
                            var11_7 = e3.d.h(this, var6_12, (j)var1_1);
                            if (var11_7 == null) continue;
                            var1_1 = var11_7;
                        }
                        if ((var11_7 = e3.d.s(this, (j)var1_1, var2_3, var3_4, var9_6)) == e3.e.q()) {
                            var8_9 = var10_11;
                            if (r.a((Object)var9_6)) {
                                var8_9 = var9_6;
                            }
                            if (var8_9 != null) {
                                e3.d.q(this, (N0)var8_9, (j)var1_1, var2_3);
                            }
                            break block16;
                        }
                        if (var11_7 != e3.e.h()) break;
                        if (var3_4 >= this.U()) continue;
                        var1_1.c();
                    }
                    if (var11_7 == e3.e.r()) {
                        var1_1 = new IllegalStateException("unexpected");
                        throw var1_1;
                    }
                    var1_1.c();
                    var10_11 = this.c;
                    var1_1 = var8_9;
                    if (var10_11 != null) {
                        var1_1 = e3.d.g(this, var10_11);
                    }
                    var8_9 = (U2.q)var1_1;
                    var1_1 = var11_7;
                }
                var9_6.c(var1_1, (U2.q)var8_9);
            }
        }
        var1_1 = var9_6.y();
        if (var1_1 == M2.b.e()) {
            N2.h.c(var5_5);
        }
        return var1_1;
    }

    private final void y0(j object) {
        int n2;
        Object object2;
        j j2;
        U2.l l2 = this.c;
        Object object3 = null;
        Object object4 = h3.j.b(null, 1, null);
        j j3 = object;
        block0: do {
            object2 = object4;
            object = object3;
            block1: for (n2 = e3.e.b - 1; -1 < n2; --n2) {
                long l3 = j3.c * (long)e3.e.b + (long)n2;
                while ((object4 = j3.B(n2)) != e3.e.f()) {
                    if (object4 == e3.e.d) {
                        if (l3 < this.Q()) break block0;
                        if (!j3.v(n2, object4, e3.e.y())) continue;
                        object4 = object;
                        if (l2 != null) {
                            object4 = w.b(l2, j3.A(n2), (P)((Object)object));
                        }
                        j3.w(n2);
                        j3.t();
                        object = object4;
                        continue block1;
                    }
                    if (object4 != e3.e.k() && object4 != null) {
                        if (!(object4 instanceof N0) && !(object4 instanceof p)) {
                            if (object4 == e3.e.o() || object4 == e3.e.p()) break block0;
                            if (object4 == e3.e.o()) continue;
                            continue block1;
                        }
                        if (l3 < this.Q()) break block0;
                        object3 = object4 instanceof p ? ((p)object4).a : (N0)object4;
                        if (!j3.v(n2, object4, e3.e.y())) continue;
                        object4 = object;
                        if (l2 != null) {
                            object4 = w.b(l2, j3.A(n2), (P)((Object)object));
                        }
                        object2 = h3.j.c(object2, object3);
                        j3.w(n2);
                        j3.t();
                        object = object4;
                        continue block1;
                    }
                    if (!j3.v(n2, object4, e3.e.y())) continue;
                    j3.t();
                    continue block1;
                }
                break block0;
            }
            j2 = (j)j3.h();
            object3 = object;
            object4 = object2;
            j3 = j2;
        } while (j2 != null);
        if (object2 != null) {
            if (!(object2 instanceof ArrayList)) {
                this.A0((N0)object2);
            } else {
                V2.k.c(object2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
                object4 = (ArrayList)object2;
                for (n2 = object4.size() - 1; -1 < n2; --n2) {
                    this.A0((N0)object4.get(n2));
                }
            }
        }
        if (object == null) {
            return;
        }
        throw object;
    }

    private final void z(long l2) {
        this.y0(this.A(l2));
    }

    private final void z0(N0 n02) {
        this.B0(n02, true);
    }

    protected final void C(long l2) {
        Object object = (j)e3.d.j.get((Object)this);
        long l3;
        while (l2 >= Math.max((long)((long)this.b + (l3 = e3.d.f.get((Object)this))), (long)this.I())) {
            j j2;
            Object object2;
            if (!e3.d.f.compareAndSet((Object)this, l3, 1L + l3)) continue;
            int n2 = e3.e.b;
            long l4 = l3 / (long)n2;
            n2 = (int)(l3 % (long)n2);
            if (((A)object).c != l4) {
                object2 = this.F(l4, (j)object);
                j2 = object2;
                if (object2 == null) {
                    continue;
                }
            } else {
                j2 = object;
            }
            if ((object = this.I0(j2, n2, l3, null)) == e3.e.h()) {
                if (l3 < this.U()) {
                    j2.c();
                }
            } else {
                j2.c();
                object2 = this.c;
                if (object2 != null && (object = w.c((U2.l)object2, object, null, 2, null)) != null) {
                    throw object;
                }
            }
            object = j2;
        }
        return;
    }

    protected final Object F0(Object object) {
        block6: {
            block7: {
                int n2;
                int n3;
                boolean bl;
                Object object2;
                D d2;
                block8: {
                    block9: {
                        long l2;
                        d2 = e3.e.d;
                        j j2 = (j)e3.d.i.get((Object)this);
                        object2 = object;
                        object = j2;
                        while (true) {
                            long l3 = e3.d.e.getAndIncrement((Object)this);
                            l2 = 0xFFFFFFFFFFFFFFFL & l3;
                            bl = this.f0(l3);
                            n3 = e3.e.b;
                            l3 = l2 / (long)n3;
                            n2 = (int)(l2 % (long)n3);
                            if (((A)object).c != l3) {
                                j2 = this.G(l3, (j)object);
                                if (j2 == null) {
                                    if (!bl) continue;
                                    return e3.h.a.a(this.R());
                                }
                                object = j2;
                            }
                            int n4 = this.K0((j)object, n2, object2, l2, d2, bl);
                            if (n4 == 0) break block6;
                            if (n4 == 1) break block7;
                            if (n4 == 2) break block8;
                            if (n4 == 3) break block9;
                            if (n4 == 4) break;
                            if (n4 != 5) continue;
                            ((h3.b)object).c();
                        }
                        if (l2 < this.Q()) {
                            ((h3.b)object).c();
                        }
                        return e3.h.a.a(this.R());
                    }
                    throw new IllegalStateException("unexpected");
                }
                if (bl) {
                    ((A)object).t();
                    return e3.h.a.a(this.R());
                }
                object2 = d2 instanceof N0 ? (N0)((Object)d2) : null;
                if (object2 != null) {
                    this.v0((N0)object2, (j)object, n2);
                }
                this.C(((A)object).c * (long)n3 + (long)n2);
                return e3.h.a.c(q.a);
            }
            return e3.h.a.c(q.a);
        }
        ((h3.b)object).c();
        return e3.h.a.c(q.a);
    }

    protected final Throwable K() {
        return (Throwable)e3.d.l.get((Object)this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void O0(long l2) {
        int n2;
        if (this.h0()) return;
        while (this.I() <= l2) {
        }
        int n3 = e3.e.g();
        for (n2 = 0; n2 < n3; ++n2) {
            l2 = this.I();
            if (l2 == (0x3FFFFFFFFFFFFFFFL & e3.d.h.get((Object)this)) && l2 == this.I()) return;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = e3.d.h;
        while (!atomicLongFieldUpdater.compareAndSet((Object)this, l2 = atomicLongFieldUpdater.get((Object)this), e3.e.a(l2 & 0x3FFFFFFFFFFFFFFFL, true))) {
        }
        while (true) {
            l2 = this.I();
            long l3 = e3.d.h.get((Object)this);
            long l4 = l3 & 0x3FFFFFFFFFFFFFFFL;
            n2 = (0x4000000000000000L & l3) != 0L ? 1 : 0;
            if (l2 == l4 && l2 == this.I()) {
                atomicLongFieldUpdater = e3.d.h;
                while (!atomicLongFieldUpdater.compareAndSet((Object)this, l2 = atomicLongFieldUpdater.get((Object)this), e3.e.a(l2 & 0x3FFFFFFFFFFFFFFFL, false))) {
                }
                return;
            }
            if (n2 != 0) continue;
            e3.d.h.compareAndSet((Object)this, l3, e3.e.a(l4, true));
        }
    }

    public final long Q() {
        return e3.d.f.get((Object)this);
    }

    protected final Throwable R() {
        Throwable throwable;
        Object object = throwable = this.K();
        if (throwable == null) {
            object = new l("Channel was closed");
        }
        return object;
    }

    public final long U() {
        return e3.d.e.get((Object)this) & 0xFFFFFFFFFFFFFFFL;
    }

    public final boolean W() {
        while (true) {
            j j2 = (j)e3.d.j.get((Object)this);
            long l2 = this.Q();
            if (this.U() <= l2) {
                return false;
            }
            int n2 = e3.e.b;
            long l3 = l2 / (long)n2;
            j j3 = j2;
            if (j2.c != l3) {
                j3 = j2 = this.F(l3, j2);
                if (j2 == null) {
                    if (((j)e3.d.j.get((Object)this)).c >= l3) continue;
                    return false;
                }
            }
            j3.c();
            if (this.a0(j3, (int)(l2 % (long)n2), l2)) {
                return true;
            }
            e3.d.f.compareAndSet((Object)this, l2, 1L + l2);
        }
    }

    @Override
    public boolean a(Throwable throwable) {
        return this.y(throwable, false);
    }

    @Override
    public Object b(L2.e e2) {
        return e3.d.w0(this, e2);
    }

    @Override
    public Object c() {
        j j2;
        long l2 = e3.d.f.get((Object)this);
        long l3 = e3.d.e.get((Object)this);
        if (this.d0(l3)) {
            return e3.h.a.a(this.K());
        }
        if (l2 >= (l3 & 0xFFFFFFFFFFFFFFFL)) {
            return e3.h.a.b();
        }
        D d2 = e3.e.i();
        Object object = (j)e3.d.j.get((Object)this);
        while (true) {
            if (this.c0()) {
                return e3.h.a.a(this.K());
            }
            l3 = e3.d.f.getAndIncrement((Object)this);
            int n2 = e3.e.b;
            l2 = l3 / (long)n2;
            n2 = (int)(l3 % (long)n2);
            if (((A)object).c != l2) {
                j j3;
                j2 = j3 = this.F(l2, (j)object);
                if (j3 == null) {
                    continue;
                }
            } else {
                j2 = object;
            }
            object = this.I0(j2, n2, l3, d2);
            if (object == e3.e.q()) {
                object = d2 instanceof N0 ? (N0)((Object)d2) : null;
                if (object != null) {
                    this.u0((N0)object, j2, n2);
                }
                this.O0(l3);
                j2.t();
                return e3.h.a.b();
            }
            if (object != e3.e.h()) break;
            if (l3 < this.U()) {
                j2.c();
            }
            object = j2;
        }
        if (object != e3.e.r()) {
            j2.c();
            return e3.h.a.c(object);
        }
        throw new IllegalStateException("unexpected");
    }

    public boolean c0() {
        return this.d0(e3.d.e.get((Object)this));
    }

    @Override
    public Object d(Object object) {
        block7: {
            block8: {
                int n2;
                boolean bl;
                Object object2;
                D d2;
                block9: {
                    block10: {
                        long l2;
                        if (this.C0(e3.d.e.get((Object)this))) {
                            return e3.h.a.b();
                        }
                        d2 = e3.e.j();
                        j j2 = (j)e3.d.i.get((Object)this);
                        object2 = object;
                        object = j2;
                        while (true) {
                            long l3 = e3.d.e.getAndIncrement((Object)this);
                            l2 = 0xFFFFFFFFFFFFFFFL & l3;
                            bl = this.f0(l3);
                            n2 = e3.e.b;
                            l3 = l2 / (long)n2;
                            n2 = (int)(l2 % (long)n2);
                            if (((A)object).c != l3) {
                                j2 = this.G(l3, (j)object);
                                if (j2 == null) {
                                    if (!bl) continue;
                                    return e3.h.a.a(this.R());
                                }
                                object = j2;
                            }
                            int n3 = this.K0((j)object, n2, object2, l2, d2, bl);
                            if (n3 == 0) break block7;
                            if (n3 == 1) break block8;
                            if (n3 == 2) break block9;
                            if (n3 == 3) break block10;
                            if (n3 == 4) break;
                            if (n3 != 5) continue;
                            ((h3.b)object).c();
                        }
                        if (l2 < this.Q()) {
                            ((h3.b)object).c();
                        }
                        return e3.h.a.a(this.R());
                    }
                    throw new IllegalStateException("unexpected");
                }
                if (bl) {
                    ((A)object).t();
                    return e3.h.a.a(this.R());
                }
                object2 = d2 instanceof N0 ? (N0)((Object)d2) : null;
                if (object2 != null) {
                    this.v0((N0)object2, (j)object, n2);
                }
                ((A)object).t();
                return e3.h.a.b();
            }
            return e3.h.a.c(q.a);
        }
        ((h3.b)object).c();
        return e3.h.a.c(q.a);
    }

    public boolean e0() {
        return this.f0(e3.d.e.get((Object)this));
    }

    protected boolean g0() {
        return false;
    }

    protected void o0() {
    }

    protected void q0() {
    }

    protected void r0() {
    }

    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = (int)(e3.d.e.get((Object)this) >> 60);
        if (n2 != 2) {
            if (n2 == 3) {
                stringBuilder.append("cancelled,");
            }
        } else {
            stringBuilder.append("closed,");
        }
        Object object2 = new StringBuilder();
        object2.append("capacity=");
        object2.append(this.b);
        object2.append(',');
        stringBuilder.append(object2.toString());
        stringBuilder.append("data=[");
        object2 = e3.d.j.get((Object)this);
        Object object3 = e3.d.i.get((Object)this);
        boolean bl = true;
        object3 = o.i(object2, object3, e3.d.k.get((Object)this));
        object2 = new ArrayList();
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object = object3.next();
            if ((j)object == e3.e.m()) continue;
            object2.add(object);
        }
        Iterator iterator = object2.iterator();
        if (iterator.hasNext()) {
            long l2;
            long l3;
            long l4;
            object3 = iterator.next();
            if (!iterator.hasNext()) {
                object2 = object3;
            } else {
                l4 = ((j)object3).c;
                do {
                    object = iterator.next();
                    l3 = ((j)object).c;
                    object2 = object3;
                    l2 = l4;
                    if (l4 > l3) {
                        object2 = object;
                        l2 = l3;
                    }
                    object3 = object2;
                    l4 = l2;
                } while (iterator.hasNext());
            }
            object3 = (j)object2;
            l3 = this.Q();
            l4 = this.U();
            block2: do {
                int n3 = e3.e.b;
                for (n2 = 0; n2 < n3; ++n2) {
                    l2 = ((A)object3).c * (long)e3.e.b + (long)n2;
                    long l5 = l2 - l4;
                    long l6 = l5 == 0L ? 0 : (l5 < 0L ? -1 : 1);
                    if (l6 >= 0 && l2 >= l3) break block2;
                    object2 = ((j)object3).B(n2);
                    object = ((j)object3).A(n2);
                    if (object2 instanceof c3.i) {
                        long l7 = l2 == l3 ? 0 : (l2 < l3 ? -1 : 1);
                        object2 = l7 < 0 && l6 >= 0 ? "receive" : (l6 < 0 && l7 >= 0 ? "send" : "cont");
                    } else if (object2 instanceof p) {
                        iterator = new StringBuilder();
                        iterator.append("EB(");
                        iterator.append(object2);
                        iterator.append(')');
                        object2 = iterator.toString();
                    } else if (!V2.k.a(object2, e3.e.p()) && !V2.k.a(object2, e3.e.o())) {
                        if (object2 == null || V2.k.a(object2, e3.e.k()) || V2.k.a(object2, e3.e.f()) || V2.k.a(object2, e3.e.n()) || V2.k.a(object2, e3.e.i()) || V2.k.a(object2, e3.e.j()) || V2.k.a(object2, e3.e.y())) continue;
                        object2 = object2.toString();
                    } else {
                        object2 = "resuming_sender";
                    }
                    if (object != null) {
                        iterator = new StringBuilder();
                        iterator.append('(');
                        iterator.append((String)object2);
                        iterator.append(',');
                        iterator.append(object);
                        iterator.append("),");
                        stringBuilder.append(iterator.toString());
                        continue;
                    }
                    object = new StringBuilder();
                    object.append((String)object2);
                    object.append(',');
                    stringBuilder.append(object.toString());
                }
            } while ((object3 = (j)((h3.b)object3).f()) != null);
            if (b3.h.v0((CharSequence)stringBuilder) == ',') {
                V2.k.d(stringBuilder.deleteCharAt(stringBuilder.length() - 1), "deleteCharAt(...)");
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        throw new NoSuchElementException();
    }

    protected boolean y(Throwable throwable, boolean bl) {
        if (bl) {
            this.j0();
        }
        boolean bl2 = androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)e3.d.l, (Object)this, (Object)e3.e.l(), (Object)throwable);
        if (bl) {
            this.k0();
        } else {
            this.l0();
        }
        this.B();
        this.o0();
        if (bl2) {
            this.Z();
        }
        return bl2;
    }
}

