/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.r
 *  androidx.concurrent.futures.b
 *  c3.l
 *  c3.n
 *  c3.o
 *  c3.s0
 *  c3.w
 *  c3.x
 *  c3.y
 *  c3.z
 *  h3.A
 *  h3.D
 *  h3.h
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package c3;

import H2.q;
import L2.i;
import N2.e;
import androidx.activity.r;
import androidx.concurrent.futures.b;
import c3.B0;
import c3.C0;
import c3.H;
import c3.M;
import c3.N0;
import c3.U;
import c3.V;
import c3.X;
import c3.d;
import c3.h;
import c3.i;
import c3.j;
import c3.l;
import c3.n;
import c3.o;
import c3.p0;
import c3.s0;
import c3.u0;
import c3.w;
import c3.x;
import c3.y;
import c3.z;
import h3.A;
import h3.D;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class k
extends U
implements i,
e,
N0 {
    private static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(k.class, (String)"_decisionAndIndex$volatile");
    private static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, (String)"_state$volatile");
    private static final AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, (String)"_parentHandle$volatile");
    private volatile int _decisionAndIndex$volatile;
    private volatile Object _parentHandle$volatile;
    private volatile Object _state$volatile;
    private final L2.e j;
    private final L2.i k;

    public k(L2.e e3, int n3) {
        super(n3);
        this.j = e3;
        this.k = e3.getContext();
        this._decisionAndIndex$volatile = 0x1FFFFFFF;
        this._state$volatile = d.a;
    }

    private final String A() {
        Object object = this.z();
        if (object instanceof C0) {
            return "Active";
        }
        if (object instanceof n) {
            return "Cancelled";
        }
        return "Completed";
    }

    private final X F() {
        Object object = (p0)this.getContext().i((i.c)p0.e);
        if (object == null) {
            return null;
        }
        object = s0.g((p0)object, (boolean)false, (u0)new o(this), (int)1, null);
        b.a((AtomicReferenceFieldUpdater)c3.k.n, (Object)this, null, (Object)object);
        return object;
    }

    private final void G(Object object) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c3.k.m;
        while (true) {
            Object object2;
            block17: {
                block16: {
                    block15: {
                        if (!((object2 = atomicReferenceFieldUpdater.get((Object)this)) instanceof d)) break block15;
                        if (!b.a((AtomicReferenceFieldUpdater)c3.k.m, (Object)this, (Object)object2, (Object)object)) continue;
                        break block16;
                    }
                    if (!(object2 instanceof h) && !(object2 instanceof A)) {
                        h h3;
                        if (object2 instanceof x) {
                            atomicReferenceFieldUpdater = (x)object2;
                            if (!atomicReferenceFieldUpdater.c()) {
                                this.K(object, object2);
                            }
                            if (object2 instanceof n) {
                                boolean bl = r.a((Object)object2);
                                object2 = null;
                                if (!bl) {
                                    atomicReferenceFieldUpdater = null;
                                }
                                if (atomicReferenceFieldUpdater != null) {
                                    object2 = atomicReferenceFieldUpdater.a;
                                }
                                if (object instanceof h) {
                                    this.o((h)object, (Throwable)object2);
                                    return;
                                }
                                V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                this.q((A)object, (Throwable)object2);
                                return;
                            }
                        } else if (object2 instanceof w) {
                            w w2 = (w)object2;
                            if (w2.b != null) {
                                this.K(object, object2);
                            }
                            if (object instanceof A) {
                                return;
                            }
                            V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                            h3 = (h)object;
                            if (w2.c()) {
                                this.o(h3, w2.e);
                                return;
                            }
                            h3 = w.b((w)w2, null, (h)h3, null, null, null, (int)29, null);
                            if (!b.a((AtomicReferenceFieldUpdater)c3.k.m, (Object)this, (Object)object2, (Object)h3)) continue;
                        } else {
                            if (object instanceof A) {
                                return;
                            }
                            V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                            h3 = new w(object2, (h)object, null, null, null, 28, null);
                            if (!b.a((AtomicReferenceFieldUpdater)c3.k.m, (Object)this, (Object)object2, (Object)h3)) continue;
                        }
                    }
                    break block17;
                }
                return;
            }
            this.K(object, object2);
        }
    }

    private final boolean J() {
        if (V.c(this.i)) {
            L2.e e3 = this.j;
            V2.k.c(e3, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((h3.h)e3).q()) {
                return true;
            }
        }
        return false;
    }

    private final void K(Object object, Object object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("It's prohibited to register multiple handlers, tried to register ");
        stringBuilder.append(object);
        stringBuilder.append(", already has ");
        stringBuilder.append(object2);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private static final q Q(U2.l l3, Throwable throwable, Object object, L2.i i3) {
        l3.j(throwable);
        return q.a;
    }

    public static /* synthetic */ void S(k k3, Object object, int n3, U2.q q2, int n4, Object object2) {
        if (object2 == null) {
            if ((n4 & 4) != 0) {
                q2 = null;
            }
            k3.R(object, n3, q2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object T(C0 c02, Object object, int n3, U2.q q2, Object object2) {
        if (object instanceof x) {
            return object;
        }
        if (!V.b(n3) && object2 == null || q2 == null && !(c02 instanceof h) && object2 == null) {
            return object;
        }
        c02 = c02 instanceof h ? (h)c02 : null;
        return new w(object, (h)c02, q2, object2, null, 16, null);
    }

    private final boolean U() {
        int n3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c3.k.l;
        do {
            int n4;
            if ((n4 = (n3 = atomicIntegerFieldUpdater.get((Object)this)) >> 29) == 0) continue;
            if (n4 == 1) {
                return false;
            }
            throw new IllegalStateException("Already resumed");
        } while (!c3.k.l.compareAndSet((Object)this, n3, 0x40000000 + (0x1FFFFFFF & n3)));
        return true;
    }

    private final D V(Object object, Object object2, U2.q q2) {
        Object object3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c3.k.m;
        while ((object3 = atomicReferenceFieldUpdater.get((Object)this)) instanceof C0) {
            Object object4 = this.T((C0)object3, object, this.i, q2, object2);
            if (!b.a((AtomicReferenceFieldUpdater)c3.k.m, (Object)this, (Object)object3, (Object)object4)) continue;
            this.u();
            return c3.l.a;
        }
        if (object3 instanceof w && object2 != null && ((w)object3).d == object2) {
            return c3.l.a;
        }
        return null;
    }

    private final boolean W() {
        int n3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c3.k.l;
        do {
            int n4;
            if ((n4 = (n3 = atomicIntegerFieldUpdater.get((Object)this)) >> 29) == 0) continue;
            if (n4 == 2) {
                return false;
            }
            throw new IllegalStateException("Already suspended");
        } while (!c3.k.l.compareAndSet((Object)this, n3, 0x20000000 + (0x1FFFFFFF & n3)));
        return true;
    }

    public static /* synthetic */ q m(U2.l l3, Throwable throwable, Object object, L2.i i3) {
        return c3.k.Q(l3, throwable, object, i3);
    }

    private final Void n(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Already resumed, but proposed with update ");
        stringBuilder.append(object);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private final void q(A a3, Throwable object) {
        int n3 = c3.k.l.get((Object)this) & 0x1FFFFFFF;
        if (n3 != 0x1FFFFFFF) {
            try {
                a3.s(n3, object, this.getContext());
                return;
            }
            catch (Throwable throwable) {
                object = this.getContext();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception in invokeOnCancellation handler for ");
                stringBuilder.append((Object)this);
                H.a((L2.i)object, (Throwable)new y(stringBuilder.toString(), throwable));
                return;
            }
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
    }

    private final boolean s(Throwable throwable) {
        if (!this.J()) {
            return false;
        }
        L2.e e3 = this.j;
        V2.k.c(e3, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((h3.h)e3).r(throwable);
    }

    private final void u() {
        if (!this.J()) {
            this.t();
        }
    }

    private final void v(int n3) {
        if (this.U()) {
            return;
        }
        V.a(this, n3);
    }

    private final X x() {
        return (X)c3.k.n.get((Object)this);
    }

    public void E() {
        X x2 = this.F();
        if (x2 != null && this.I()) {
            x2.a();
            c3.k.n.set((Object)this, (Object)B0.a);
        }
    }

    public final void H(h h3) {
        this.G(h3);
    }

    public boolean I() {
        return this.z() instanceof C0 ^ true;
    }

    protected String L() {
        return "CancellableContinuation";
    }

    public final void M(Throwable throwable) {
        if (this.s(throwable)) {
            return;
        }
        this.r(throwable);
        this.u();
    }

    public final void N() {
        L2.e e3 = this.j;
        e3 = e3 instanceof h3.h ? (h3.h)e3 : null;
        if (e3 != null && (e3 = e3.t(this)) != null) {
            this.t();
            this.r((Throwable)e3);
        }
    }

    public final boolean O() {
        Object object = c3.k.m.get((Object)this);
        if (object instanceof w && ((w)object).d != null) {
            this.t();
            return false;
        }
        c3.k.l.set((Object)this, 0x1FFFFFFF);
        c3.k.m.set((Object)this, (Object)d.a);
        return true;
    }

    public void P(Object object, U2.l c3) {
        int n3 = this.i;
        c3 = c3 != null ? new j((U2.l)c3) : null;
        this.R(object, n3, (U2.q)c3);
    }

    public final void R(Object object, int n3, U2.q q2) {
        Object object2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c3.k.m;
        while ((object2 = atomicReferenceFieldUpdater.get((Object)this)) instanceof C0) {
            Object object3 = this.T((C0)object2, object, n3, q2, null);
            if (!b.a((AtomicReferenceFieldUpdater)c3.k.m, (Object)this, (Object)object2, (Object)object3)) continue;
            this.u();
            this.v(n3);
            return;
        }
        if (object2 instanceof n && (atomicReferenceFieldUpdater = (n)object2).e()) {
            if (q2 != null) {
                this.p(q2, atomicReferenceFieldUpdater.a, object);
            }
            return;
        }
        this.n(object);
        throw new H2.d();
    }

    @Override
    public void a(A a3, int n3) {
        int n4;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c3.k.l;
        while (((n4 = atomicIntegerFieldUpdater.get((Object)this)) & 0x1FFFFFFF) == 0x1FFFFFFF) {
            if (!atomicIntegerFieldUpdater.compareAndSet((Object)this, n4, (n4 >> 29 << 29) + n3)) continue;
            this.G(a3);
            return;
        }
        throw new IllegalStateException("invokeOnCancellation should be called at most once");
    }

    @Override
    public e b() {
        L2.e e3 = this.j;
        if (e3 instanceof e) {
            return (e)((Object)e3);
        }
        return null;
    }

    @Override
    public void c(Object object, U2.q q2) {
        this.R(object, this.i, q2);
    }

    @Override
    public void d(Object object, Throwable throwable) {
        Object object2;
        object = c3.k.m;
        while (!((object2 = object.get((Object)this)) instanceof C0)) {
            if (!(object2 instanceof x)) {
                if (object2 instanceof w) {
                    w w2 = (w)object2;
                    if (!w2.c()) {
                        w w3 = w.b((w)w2, null, null, null, null, (Throwable)throwable, (int)15, null);
                        if (!b.a((AtomicReferenceFieldUpdater)c3.k.m, (Object)this, (Object)object2, (Object)w3)) continue;
                        w2.d(this, throwable);
                        return;
                    }
                    throw new IllegalStateException("Must be called at most once");
                }
                if (!b.a((AtomicReferenceFieldUpdater)c3.k.m, (Object)this, (Object)object2, (Object)new w(object2, null, null, null, throwable, 14, null))) continue;
            }
            return;
        }
        throw new IllegalStateException("Not completed");
    }

    @Override
    public void e(Object object) {
        c3.k.S(this, z.c((Object)object, (i)this), this.i, null, 4, null);
    }

    @Override
    public final L2.e f() {
        return this.j;
    }

    @Override
    public Throwable g(Object object) {
        if ((object = super.g(object)) != null) {
            return object;
        }
        return null;
    }

    @Override
    public L2.i getContext() {
        return this.k;
    }

    @Override
    public Object h(Object object) {
        Object object2 = object;
        if (object instanceof w) {
            object2 = ((w)object).a;
        }
        return object2;
    }

    @Override
    public Object j() {
        return this.z();
    }

    @Override
    public Object k(Object object, Object object2, U2.q q2) {
        return this.V(object, object2, q2);
    }

    @Override
    public void l(Object object) {
        this.v(this.i);
    }

    public final void o(h object, Throwable throwable) {
        try {
            object.a(throwable);
            return;
        }
        catch (Throwable throwable2) {
            object = this.getContext();
            throwable = new StringBuilder();
            throwable.append("Exception in invokeOnCancellation handler for ");
            throwable.append((Object)this);
            H.a((L2.i)object, (Throwable)new y(throwable.toString(), throwable2));
            return;
        }
    }

    public final void p(U2.q q2, Throwable throwable, Object object) {
        try {
            q2.g(throwable, object, this.getContext());
            return;
        }
        catch (Throwable throwable2) {
            object = this.getContext();
            q2 = new StringBuilder();
            q2.append("Exception in resume onCancellation handler for ");
            q2.append(this);
            H.a((L2.i)object, (Throwable)new y(q2.toString(), throwable2));
            return;
        }
    }

    public boolean r(Throwable throwable) {
        n n3;
        Object object;
        Object object2 = c3.k.m;
        do {
            object = object2.get((Object)this);
            boolean bl = object instanceof C0;
            boolean bl2 = false;
            if (!bl) {
                return false;
            }
            if (object instanceof h || object instanceof A) {
                bl2 = true;
            }
            n3 = new n((L2.e)this, throwable, bl2);
        } while (!b.a((AtomicReferenceFieldUpdater)c3.k.m, (Object)this, (Object)object, (Object)n3));
        object2 = (C0)object;
        if (object2 instanceof h) {
            this.o((h)object, throwable);
        } else if (object2 instanceof A) {
            this.q((A)object, throwable);
        }
        this.u();
        this.v(this.i);
        return true;
    }

    public final void t() {
        X x2 = this.x();
        if (x2 == null) {
            return;
        }
        x2.a();
        c3.k.n.set((Object)this, (Object)B0.a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.L());
        stringBuilder.append('(');
        stringBuilder.append(M.c(this.j));
        stringBuilder.append("){");
        stringBuilder.append(this.A());
        stringBuilder.append("}@");
        stringBuilder.append(M.b(this));
        return stringBuilder.toString();
    }

    public Throwable w(p0 p02) {
        return p02.b0();
    }

    public final Object y() {
        Object object;
        boolean bl = this.J();
        if (this.W()) {
            if (this.x() == null) {
                this.F();
            }
            if (bl) {
                this.N();
            }
            return M2.b.e();
        }
        if (bl) {
            this.N();
        }
        if (!((object = this.z()) instanceof x)) {
            p0 p02;
            if (V.b(this.i) && (p02 = (p0)this.getContext().i((i.c)p0.e)) != null && !p02.f()) {
                p02 = p02.b0();
                this.d(object, (Throwable)p02);
                throw p02;
            }
            return this.h(object);
        }
        throw ((x)object).a;
    }

    public final Object z() {
        return c3.k.m.get((Object)this);
    }
}

