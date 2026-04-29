/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.b
 *  c3.m
 *  c3.n0
 *  c3.o0
 *  c3.p0$a
 *  c3.q
 *  c3.q0
 *  c3.s0
 *  c3.v0$c
 *  c3.w0
 *  c3.x
 *  c3.y
 *  h3.D
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.Collections
 *  java.util.IdentityHashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package c3;

import H2.a;
import L2.e;
import L2.i;
import N2.h;
import U2.l;
import V2.s;
import androidx.concurrent.futures.b;
import c3.A0;
import c3.B0;
import c3.D0;
import c3.E0;
import c3.M;
import c3.X;
import c3.Z;
import c3.i;
import c3.k;
import c3.k0;
import c3.l0;
import c3.m;
import c3.n0;
import c3.o0;
import c3.p;
import c3.p0;
import c3.q;
import c3.q0;
import c3.r;
import c3.s0;
import c3.u0;
import c3.v0;
import c3.w0;
import c3.x;
import c3.y;
import h3.D;
import h3.o;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class v0
implements p0,
r,
D0 {
    private static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, (String)"_state$volatile");
    private static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, (String)"_parentHandle$volatile");
    private volatile Object _parentHandle$volatile;
    private volatile Object _state$volatile;

    public v0(boolean bl) {
        Z z2 = bl ? w0.c() : w0.d();
        this._state$volatile = z2;
    }

    private final Throwable B(Object object) {
        if ((object = object instanceof x ? (x)object : null) != null) {
            return ((x)object).a;
        }
        return null;
    }

    private final boolean B0(l0 l02, Throwable throwable) {
        A0 a02 = this.F(l02);
        if (a02 == null) {
            return false;
        }
        c c3 = new /* Unavailable Anonymous Inner Class!! */;
        if (!b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)l02, (Object)c3)) {
            return false;
        }
        this.g0(a02, throwable);
        return true;
    }

    private final Throwable C(c object, List list) {
        boolean bl = list.isEmpty();
        Object var4_4 = null;
        if (bl) {
            if (object.j()) {
                return new q0(this.t(), null, (p0)this);
            }
            return null;
        }
        Iterator iterator = list.iterator();
        do {
            object = var4_4;
        } while (iterator.hasNext() && (Throwable)(object = iterator.next()) instanceof CancellationException);
        if ((object = (Throwable)object) != null) {
            return object;
        }
        return (Throwable)list.get(0);
    }

    private final Object C0(Object object, Object object2) {
        if (!(object instanceof l0)) {
            return w0.a();
        }
        if ((object instanceof Z || object instanceof u0) && !(object instanceof q) && !(object2 instanceof x)) {
            if (this.z0((l0)object, object2)) {
                return object2;
            }
            return w0.b();
        }
        return this.D0((l0)object, object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final Object D0(l0 l02, Object object) {
        A0 a02 = this.F(l02);
        if (a02 == null) {
            return w0.b();
        }
        boolean bl = l02 instanceof c;
        Object var6_6 = null;
        Object object2 = bl ? l02 : null;
        c c3 = object2;
        if (object2 == null) {
            c3 = new /* Unavailable Anonymous Inner Class!! */;
        }
        s s2 = new s();
        c c4 = c3;
        // MONITORENTER : c4
        if (c3.k()) {
            l02 = w0.a();
            // MONITOREXIT : c4
            return l02;
        }
        c3.n(true);
        if (c3 != l02 && !b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)l02, (Object)c3)) {
            l02 = w0.b();
            // MONITOREXIT : c4
            return l02;
        }
        bl = c3.j();
        l02 = object instanceof x ? (x)object : null;
        if (l02 != null) {
            c3.a(((x)l02).a);
        }
        object2 = c3.d();
        l02 = var6_6;
        if (!bl) {
            l02 = object2;
        }
        s2.g = l02;
        object2 = H2.q.a;
        // MONITOREXIT : c4
        if (l02 != null) {
            this.g0(a02, (Throwable)l02);
        }
        if ((l02 = this.f0(a02)) != null && this.E0(c3, (q)l02, object)) {
            return w0.b;
        }
        a02.h(2);
        l02 = this.f0(a02);
        if (l02 == null) return this.y(c3, object);
        if (!this.E0(c3, (q)l02, object)) return this.y(c3, object);
        return w0.b;
    }

    private final boolean E0(c c3, q q2, Object object) {
        q q3;
        do {
            if (s0.f((p0)q2.e, (boolean)false, (u0)new /* Unavailable Anonymous Inner Class!! */) != B0.a) {
                return true;
            }
            q2 = q3 = this.f0((o)q2);
        } while (q3 != null);
        return false;
    }

    private final A0 F(l0 l02) {
        A0 a02 = l02.g();
        if (a02 == null) {
            if (l02 instanceof Z) {
                return new A0();
            }
            if (l02 instanceof u0) {
                this.q0((u0)l02);
                return null;
            }
            a02 = new StringBuilder();
            a02.append("State should have list: ");
            a02.append(l02);
            throw new IllegalStateException(a02.toString().toString());
        }
        return a02;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final Object V(Object object) {
        Object var5_3 = null;
        Throwable throwable = null;
        while (true) {
            Object object2;
            Throwable throwable2;
            Object object3;
            if ((object3 = this.J()) instanceof c) {
                Object object4 = object3;
                // MONITORENTER : object4
                if ((object3).l()) {
                    object = w0.f();
                    // MONITOREXIT : object4
                    return object;
                }
                boolean bl = (object3).j();
                if (object != null || !bl) {
                    throwable2 = throwable;
                    if (throwable == null) {
                        throwable2 = this.x(object);
                    }
                    (object3).a(throwable2);
                }
                throwable = (object3).d();
                object = var5_3;
                if (!bl) {
                    object = throwable;
                }
                // MONITOREXIT : object4
                if (object == null) return w0.a();
                this.g0((object3).g(), (Throwable)object);
                return w0.a();
            }
            if (!(object3 instanceof l0)) return w0.f();
            throwable2 = throwable;
            if (throwable == null) {
                throwable2 = this.x(object);
            }
            if ((object2 = (l0)object3).f()) {
                throwable = throwable2;
                if (!this.B0((l0)object2, throwable2)) continue;
                return w0.a();
            }
            object2 = this.C0(object3, new x(throwable2, false, 2, null));
            if (object2 == w0.a()) {
                object = new StringBuilder();
                object.append("Cannot happen in ");
                object.append(object3);
                throw new IllegalStateException(object.toString().toString());
            }
            throwable = throwable2;
            if (object2 != w0.b()) return object2;
        }
    }

    private final q f0(o o3) {
        o o4;
        while (true) {
            o4 = o3;
            if (!o3.r()) break;
            o3 = o3.n();
        }
        while (true) {
            o4 = o3 = o4.m();
            if (o3.r()) continue;
            if (o3 instanceof q) {
                return (q)o3;
            }
            o4 = o3;
            if (o3 instanceof A0) break;
        }
        return null;
    }

    public static final /* synthetic */ void g(v0 v02, c c3, q q2, Object object) {
        v02.w(c3, q2, object);
    }

    private final void g0(A0 a02, Throwable throwable) {
        this.j0(throwable);
        a02.h(4);
        Object object = a02.l();
        V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        object = (o)object;
        Object object2 = null;
        while (!V2.k.a(object, a02)) {
            StringBuilder stringBuilder = object2;
            if (object instanceof u0) {
                stringBuilder = object2;
                if (((u0)object).w()) {
                    try {
                        ((u0)object).x(throwable);
                        stringBuilder = object2;
                    }
                    catch (Throwable throwable2) {
                        if (object2 != null) {
                            a.a(object2, throwable2);
                            stringBuilder = object2;
                        }
                        object2 = new StringBuilder();
                        object2.append("Exception in completion handler ");
                        object2.append(object);
                        object2.append(" for ");
                        object2.append((Object)this);
                        stringBuilder = new y(object2.toString(), throwable2);
                        object2 = H2.q.a;
                    }
                }
            }
            object = ((o)object).m();
            object2 = stringBuilder;
        }
        if (object2 != null) {
            this.Q((Throwable)object2);
        }
        this.s(throwable);
    }

    private final void h(Throwable throwable, List list2) {
        if (list2.size() > 1) {
            Set set = Collections.newSetFromMap((Map)new IdentityHashMap(list2.size()));
            for (List list2 : list2) {
                if (list2 == throwable || list2 == throwable || list2 instanceof CancellationException || !set.add((Object)list2)) continue;
                a.a(throwable, (Throwable)list2);
            }
        }
    }

    private final void h0(A0 a02, Throwable throwable) {
        a02.h(1);
        Object object = a02.l();
        V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        object = (o)object;
        Object object2 = null;
        while (!V2.k.a(object, a02)) {
            StringBuilder stringBuilder = object2;
            if (object instanceof u0) {
                try {
                    ((u0)object).x(throwable);
                    stringBuilder = object2;
                }
                catch (Throwable throwable2) {
                    if (object2 != null) {
                        a.a(object2, throwable2);
                        stringBuilder = object2;
                    }
                    object2 = new StringBuilder();
                    object2.append("Exception in completion handler ");
                    object2.append(object);
                    object2.append(" for ");
                    object2.append((Object)this);
                    stringBuilder = new y(object2.toString(), throwable2);
                    object2 = H2.q.a;
                }
            }
            object = ((o)object).m();
            object2 = stringBuilder;
        }
        if (object2 != null) {
            this.Q((Throwable)object2);
        }
    }

    private final Object n(e e3) {
        Object object = new /* Unavailable Anonymous Inner Class!! */;
        object.E();
        m.a((i)object, (X)s0.g((p0)this, (boolean)false, (u0)new E0((k)object), (int)1, null));
        object = object.y();
        if (object == M2.b.e()) {
            N2.h.c(e3);
        }
        return object;
    }

    private final void p0(Z z2) {
        l0 l02 = new A0();
        if (!z2.f()) {
            l02 = new k0((A0)l02);
        }
        b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)z2, (Object)l02);
    }

    private final void q0(u0 u02) {
        u02.e(new A0());
        o o3 = u02.m();
        b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)u02, (Object)o3);
    }

    private final Object r(Object object) {
        Object object2;
        while (!(!((object2 = this.J()) instanceof l0) || object2 instanceof c && (object2).k())) {
            if ((object2 = this.C0(object2, new x(this.x(object), false, 2, null))) == w0.b()) continue;
            return object2;
        }
        return w0.a();
    }

    private final boolean s(Throwable throwable) {
        if (this.U()) {
            return true;
        }
        boolean bl = throwable instanceof CancellationException;
        p p3 = this.H();
        if (p3 != null && p3 != B0.a) {
            return p3.b(throwable) || bl;
            {
            }
        }
        return bl;
    }

    private final int u0(Object object) {
        if (object instanceof Z) {
            if (((Z)object).f()) {
                return 0;
            }
            if (!b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)object, (Object)w0.c())) {
                return -1;
            }
            this.o0();
            return 1;
        }
        if (object instanceof k0) {
            if (!b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)object, (Object)((k0)object).g())) {
                return -1;
            }
            this.o0();
            return 1;
        }
        return 0;
    }

    private final void v(l0 l02, Object object) {
        p p3 = this.H();
        if (p3 != null) {
            p3.a();
            this.t0(B0.a);
        }
        boolean bl = object instanceof x;
        Object var5_6 = null;
        p3 = bl ? (x)object : null;
        object = var5_6;
        if (p3 != null) {
            object = ((x)p3).a;
        }
        if (l02 instanceof u0) {
            try {
                ((u0)l02).x((Throwable)object);
                return;
            }
            catch (Throwable throwable) {
                object = new StringBuilder();
                object.append("Exception in completion handler ");
                object.append((Object)l02);
                object.append(" for ");
                object.append((Object)this);
                this.Q((Throwable)new y(object.toString(), throwable));
            }
        } else if ((l02 = l02.g()) != null) {
            this.h0((A0)l02, (Throwable)object);
        }
    }

    private final String v0(Object object) {
        if (object instanceof c) {
            if ((object = object).j()) {
                return "Cancelling";
            }
            if (object.k()) {
                return "Completing";
            }
            return "Active";
        }
        if (object instanceof l0) {
            if (((l0)object).f()) {
                return "Active";
            }
            return "New";
        }
        if (object instanceof x) {
            return "Cancelled";
        }
        return "Completed";
    }

    private final void w(c c3, q q2, Object object) {
        block3: {
            block2: {
                q q3 = this.f0((o)q2);
                if (q3 != null && this.E0(c3, q3, object)) break block2;
                c3.g().h(2);
                q2 = this.f0((o)q2);
                if (q2 == null || !this.E0(c3, q2, object)) break block3;
            }
            return;
        }
        this.j(this.y(c3, object));
    }

    private final Throwable x(Object object) {
        boolean bl = object == null ? true : object instanceof Throwable;
        if (bl) {
            Throwable throwable = (Throwable)object;
            object = throwable;
            if (throwable == null) {
                object = new q0(this.t(), null, (p0)this);
            }
            return object;
        }
        V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((D0)object).Z();
    }

    public static /* synthetic */ CancellationException x0(v0 v02, Throwable throwable, String string, int n3, Object object) {
        if (object == null) {
            if ((n3 & 1) != 0) {
                string = null;
            }
            return v02.w0(throwable, string);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final Object y(c c3, Object object) {
        void var4_9;
        void var4_6;
        if (object instanceof x) {
            x x2 = (x)object;
        } else {
            Object var4_5 = null;
        }
        if (var4_6 != null) {
            Throwable throwable = var4_6.a;
        } else {
            Object var4_8 = null;
        }
        c c4 = c3;
        // MONITORENTER : c4
        boolean bl = c3.j();
        List list = c3.m((Throwable)var4_9);
        Throwable throwable = this.C(c3, list);
        if (throwable != null) {
            this.h(throwable, list);
        }
        if (throwable != null && throwable != var4_9) {
            object = new x(throwable, false, 2, null);
        }
        if (throwable != null && (this.s(throwable) || this.O(throwable))) {
            V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((x)object).c();
        }
        if (!bl) {
            this.j0(throwable);
        }
        this.m0(object);
        b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)c3, (Object)w0.g((Object)object));
        this.v((l0)c3, object);
        return object;
    }

    private final boolean z0(l0 l02, Object object) {
        if (!b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)l02, (Object)w0.g((Object)object))) {
            return false;
        }
        this.j0(null);
        this.m0(object);
        this.v(l02, object);
        return true;
    }

    @Override
    public final void A0(D0 d02) {
        this.o(d02);
    }

    public boolean D() {
        return true;
    }

    public boolean E() {
        return false;
    }

    public p0 G() {
        p p3 = this.H();
        if (p3 != null) {
            return p3.getParent();
        }
        return null;
    }

    public final p H() {
        return (p)v0.h.get((Object)this);
    }

    @Override
    public Object I(Object object, U2.p p3) {
        return p0.a.a((p0)this, (Object)object, (U2.p)p3);
    }

    public final Object J() {
        return v0.g.get((Object)this);
    }

    @Override
    public final X M(l l3) {
        return this.S(true, (u0)new o0(l3));
    }

    protected boolean O(Throwable throwable) {
        return false;
    }

    public void Q(Throwable throwable) {
        throw throwable;
    }

    protected final void R(p0 object) {
        if (object == null) {
            this.t0(B0.a);
            return;
        }
        object.start();
        object = object.Y(this);
        this.t0((p)object);
        if (this.T()) {
            object.a();
            this.t0(B0.a);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final X S(boolean bl, u0 u02) {
        Throwable throwable;
        boolean bl2;
        Object object;
        block12: {
            block13: {
                u02.y(this);
                while (true) {
                    boolean bl3;
                    block14: {
                        l0 l02;
                        object = this.J();
                        bl3 = object instanceof Z;
                        bl2 = true;
                        throwable = null;
                        if (bl3) {
                            l02 = (Z)object;
                            if (((Z)l02).f()) {
                                if (!b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)object, (Object)u02)) continue;
                                break block12;
                            } else {
                                this.p0((Z)l02);
                                continue;
                            }
                        }
                        if (!(object instanceof l0)) break block13;
                        l0 l03 = (l0)object;
                        l02 = l03.g();
                        if (l02 == null) {
                            V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                            this.q0((u0)object);
                            continue;
                        }
                        if (u02.w()) {
                            object = l03 instanceof c ? l03 : null;
                            if ((object = object != null ? object.d() : null) == null) {
                                bl3 = ((o)((Object)l02)).c(u02, 5);
                                break block14;
                            } else {
                                if (bl) {
                                    u02.x((Throwable)object);
                                }
                                return B0.a;
                            }
                        }
                        bl3 = ((o)((Object)l02)).c(u02, 1);
                    }
                    if (bl3) break;
                }
                break block12;
            }
            bl2 = false;
        }
        if (bl2) {
            return u02;
        }
        if (bl) {
            object = this.J();
            object = object instanceof x ? (x)object : null;
            if (object != null) {
                throwable = ((x)object).a;
            }
            u02.x(throwable);
        }
        return B0.a;
    }

    public final boolean T() {
        return this.J() instanceof l0 ^ true;
    }

    protected boolean U() {
        return false;
    }

    public final boolean W(Object object) {
        Object object2;
        do {
            if ((object2 = this.C0(this.J(), object)) == w0.a()) {
                return false;
            }
            if (object2 != w0.b) continue;
            return true;
        } while (object2 == w0.b());
        this.j(object2);
        return true;
    }

    @Override
    public final X X(boolean bl, boolean bl2, l l3) {
        l3 = bl ? new n0(l3) : new o0(l3);
        return this.S(bl2, (u0)((Object)l3));
    }

    @Override
    public final p Y(r object) {
        Object object2;
        q q2;
        block10: {
            block12: {
                block11: {
                    boolean bl;
                    q2 = new q((r)object);
                    q2.y(this);
                    while (true) {
                        Object object3;
                        if ((object3 = this.J()) instanceof Z) {
                            object = (Z)object3;
                            if (((Z)object).f()) {
                                if (!b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)object3, (Object)q2)) continue;
                                return q2;
                            }
                            this.p0((Z)object);
                            continue;
                        }
                        bl = object3 instanceof l0;
                        object2 = null;
                        object = null;
                        if (!bl) break block10;
                        object2 = ((l0)object3).g();
                        if (object2 != null) break;
                        V2.k.c(object3, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        this.q0((u0)object3);
                    }
                    if (((o)object2).c((o)q2, 7)) break block11;
                    bl = ((o)object2).c((o)q2, 3);
                    object2 = this.J();
                    if (object2 instanceof c) {
                        object = (object2).d();
                    } else if ((object2 = object2 instanceof x ? (x)object2 : null) != null) {
                        object = ((x)object2).a;
                    }
                    q2.x((Throwable)object);
                    if (!bl) break block12;
                }
                return q2;
            }
            return B0.a;
        }
        object = this.J();
        object = object instanceof x ? (x)object : null;
        if (object != null) {
            object2 = ((x)object).a;
        }
        q2.x((Throwable)object2);
        return B0.a;
    }

    @Override
    public CancellationException Z() {
        Object object;
        block8: {
            Throwable throwable;
            CancellationException cancellationException;
            block6: {
                block7: {
                    block5: {
                        object = this.J();
                        boolean bl = object instanceof c;
                        cancellationException = null;
                        if (!bl) break block5;
                        throwable = (object).d();
                        break block6;
                    }
                    if (!(object instanceof x)) break block7;
                    throwable = ((x)object).a;
                    break block6;
                }
                if (object instanceof l0) break block8;
                throwable = null;
            }
            if (throwable instanceof CancellationException) {
                cancellationException = (CancellationException)throwable;
            }
            CancellationException cancellationException2 = cancellationException;
            if (cancellationException == null) {
                cancellationException = new StringBuilder();
                cancellationException.append("Parent job is ");
                cancellationException.append(this.v0(object));
                cancellationException2 = new q0(cancellationException.toString(), throwable, (p0)this);
            }
            return cancellationException2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot be cancelling child in this state: ");
        stringBuilder.append(object);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    @Override
    public final CancellationException b0() {
        Object object = this.J();
        if (object instanceof c) {
            Throwable throwable = (object).d();
            if (throwable != null) {
                object = new StringBuilder();
                object.append(M.a(this));
                object.append(" is cancelling");
                object = this.w0(throwable, object.toString());
                if (object != null) {
                    return object;
                }
            }
            object = new StringBuilder();
            object.append("Job is still new or active: ");
            object.append((Object)this);
            throw new IllegalStateException(object.toString().toString());
        }
        if (!(object instanceof l0)) {
            if (object instanceof x) {
                return v0.x0(this, ((x)object).a, null, 1, null);
            }
            object = new StringBuilder();
            object.append(M.a(this));
            object.append(" has completed normally");
            return new q0(object.toString(), null, (p0)this);
        }
        object = new StringBuilder();
        object.append("Job is still new or active: ");
        object.append((Object)this);
        throw new IllegalStateException(object.toString().toString());
    }

    @Override
    public L2.i c0(i.c c3) {
        return p0.a.c((p0)this, (i.c)c3);
    }

    public final Object d0(Object object) {
        Object object2;
        while ((object2 = this.C0(this.J(), object)) != w0.a()) {
            if (object2 == w0.b()) continue;
            return object2;
        }
        object2 = new StringBuilder();
        object2.append("Job ");
        object2.append((Object)this);
        object2.append(" is already complete or completing, but is being completed with ");
        object2.append(object);
        throw new IllegalStateException(object2.toString(), this.B(object));
    }

    public String e0() {
        return M.a(this);
    }

    @Override
    public boolean f() {
        Object object = this.J();
        return object instanceof l0 && ((l0)object).f();
    }

    @Override
    public final i.c getKey() {
        return p0.e;
    }

    @Override
    public i.b i(i.c c3) {
        return p0.a.b((p0)this, (i.c)c3);
    }

    protected void j(Object object) {
    }

    protected void j0(Throwable throwable) {
    }

    protected final Object m(e e3) {
        Object object;
        do {
            if ((object = this.J()) instanceof l0) continue;
            if (!(object instanceof x)) {
                return w0.h((Object)object);
            }
            throw ((x)object).a;
        } while (this.u0(object) < 0);
        return this.n(e3);
    }

    protected void m0(Object object) {
    }

    @Override
    public void n0(CancellationException cancellationException) {
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException == null) {
            cancellationException2 = new q0(this.t(), null, (p0)this);
        }
        this.q((Throwable)cancellationException2);
    }

    public final boolean o(Object object) {
        Object object2;
        D d3 = w0.a();
        if (this.E()) {
            d3 = object2 = this.r(object);
            if (object2 == w0.b) {
                return true;
            }
        }
        object2 = d3;
        if (d3 == w0.a()) {
            object2 = this.V(object);
        }
        if (object2 == w0.a()) {
            return true;
        }
        if (object2 == w0.b) {
            return true;
        }
        if (object2 == w0.f()) {
            return false;
        }
        this.j(object2);
        return true;
    }

    protected void o0() {
    }

    public void q(Throwable throwable) {
        this.o(throwable);
    }

    public final void r0(u0 u02) {
        block2: {
            Object object;
            while ((object = this.J()) instanceof u0) {
                if (object == u02 && !b.a((AtomicReferenceFieldUpdater)v0.g, (Object)this, (Object)object, (Object)w0.c())) continue;
                break block2;
            }
            if (object instanceof l0 && ((l0)object).g() != null) {
                u02.s();
            }
        }
    }

    @Override
    public L2.i s0(L2.i i3) {
        return p0.a.d((p0)this, (L2.i)i3);
    }

    @Override
    public final boolean start() {
        int n3;
        while ((n3 = this.u0(this.J())) != 0) {
            if (n3 != 1) continue;
            return true;
        }
        return false;
    }

    protected String t() {
        return "Job was cancelled";
    }

    public final void t0(p p3) {
        v0.h.set((Object)this, (Object)p3);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.y0());
        stringBuilder.append('@');
        stringBuilder.append(M.b(this));
        return stringBuilder.toString();
    }

    public boolean u(Throwable throwable) {
        if (throwable instanceof CancellationException) {
            return true;
        }
        return this.o(throwable) && this.D();
    }

    protected final CancellationException w0(Throwable throwable, String string) {
        Object object = throwable instanceof CancellationException ? (CancellationException)throwable : null;
        CancellationException cancellationException = object;
        if (object == null) {
            object = string;
            if (string == null) {
                object = this.t();
            }
            cancellationException = new q0((String)object, throwable, (p0)this);
        }
        return cancellationException;
    }

    public final String y0() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e0());
        stringBuilder.append('{');
        stringBuilder.append(this.v0(this.J()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final Object z() {
        Object object = this.J();
        if (!(object instanceof l0)) {
            if (!(object instanceof x)) {
                return w0.h((Object)object);
            }
            throw ((x)object).a;
        }
        throw new IllegalStateException("This job has not completed yet");
    }
}

