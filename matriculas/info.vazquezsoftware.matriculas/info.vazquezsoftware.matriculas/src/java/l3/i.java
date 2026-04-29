/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.b
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package l3;

import H2.q;
import c3.N0;
import h3.A;
import h3.B;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l3.h;
import l3.j;
import l3.k;

public class i {
    private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, (String)"head$volatile");
    private static final AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(i.class, (String)"deqIdx$volatile");
    private static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, (String)"tail$volatile");
    private static final AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(i.class, (String)"enqIdx$volatile");
    private static final AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(i.class, (String)"_availablePermits$volatile");
    private volatile int _availablePermits$volatile;
    private final int a;
    private final U2.q b;
    private volatile long deqIdx$volatile;
    private volatile long enqIdx$volatile;
    private volatile Object head$volatile;
    private volatile Object tail$volatile;

    public i(int n2, int n3) {
        this.a = n2;
        if (n2 > 0) {
            if (n3 >= 0 && n3 <= n2) {
                k k2 = new k(0L, null, 2);
                this.head$volatile = k2;
                this.tail$volatile = k2;
                this._availablePermits$volatile = n2 - n3;
                this.b = new h(this);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The number of acquired permits should be in 0..");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString().toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Semaphore should have at least 1 permit, but had ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public static /* synthetic */ q c(i i2, Throwable throwable, q q2, L2.i i3) {
        return i.n(i2, throwable, q2, i3);
    }

    private final boolean e(N0 n0) {
        Object object;
        Object object2;
        k k2 = (k)i.e.get((Object)this);
        long l2 = i.f.getAndIncrement((Object)this);
        a a2 = l3.i$a.p;
        Object object3 = i.e;
        long l3 = l2 / (long)j.f();
        block0: while (!B.c(object2 = h3.a.c(k2, l3, a2))) {
            object = B.b(object2);
            while (true) {
                A a3 = (A)object3.get((Object)this);
                if (a3.c >= ((A)object).c) break block0;
                if (!((A)object).u()) continue block0;
                if (androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)object3, (Object)this, (Object)a3, (Object)object)) {
                    if (!a3.p()) break block0;
                    a3.n();
                    break block0;
                }
                if (!((A)object).p()) continue;
                ((h3.b)object).n();
            }
        }
        object2 = (k)B.b(object2);
        int n2 = (int)(l2 % (long)j.f());
        if (e3.i.a(((k)object2).v(), n2, null, n0)) {
            n0.a((A)object2, n2);
            return true;
        }
        object3 = j.e();
        object = j.g();
        if (e3.i.a(((k)object2).v(), n2, object3, object)) {
            if (n0 instanceof c3.i) {
                V2.k.c(n0, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                ((c3.i)((Object)n0)).c(q.a, this.b);
                return true;
            }
            object3 = new StringBuilder();
            object3.append("unexpected: ");
            object3.append((Object)n0);
            throw new IllegalStateException(object3.toString().toString());
        }
        return false;
    }

    private final void f() {
        int n2;
        while ((n2 = i.g.get((Object)this)) > this.a && !i.g.compareAndSet((Object)this, n2, this.a)) {
        }
    }

    private final int g() {
        int n2;
        while ((n2 = i.g.getAndDecrement((Object)this)) > this.a) {
        }
        return n2;
    }

    private static final q n(i i2, Throwable throwable, q q2, L2.i i3) {
        i2.o();
        return q.a;
    }

    private final boolean q(Object object) {
        if (object instanceof c3.i) {
            V2.k.c(object, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            c3.i i2 = (c3.i)object;
            object = i2.k(q.a, null, this.b);
            if (object != null) {
                i2.l(object);
                return true;
            }
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected: ");
        stringBuilder.append(object);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private final boolean r() {
        Object object;
        Object object2;
        Object object3 = (k)i.c.get((Object)this);
        long l2 = i.d.getAndIncrement((Object)this);
        long l3 = l2 / (long)j.f();
        b b2 = l3.i$b.p;
        Object object4 = i.c;
        block0: while (!B.c(object2 = h3.a.c((A)object3, l3, b2))) {
            A a2 = B.b(object2);
            while (true) {
                object = (A)object4.get((Object)this);
                if (((A)object).c >= a2.c) break block0;
                if (!a2.u()) continue block0;
                if (androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)object4, (Object)this, (Object)object, (Object)a2)) {
                    if (!((A)object).p()) break block0;
                    ((h3.b)object).n();
                    break block0;
                }
                if (!a2.p()) continue;
                a2.n();
            }
        }
        object4 = (k)B.b(object2);
        ((h3.b)object4).c();
        long l4 = ((A)object4).c;
        if (l4 > l3) {
            return false;
        }
        int n2 = (int)(l2 % (long)j.f());
        object3 = j.e();
        object3 = ((k)object4).v().getAndSet(n2, object3);
        if (object3 == null) {
            int n3 = j.d();
            for (int i2 = 0; i2 < n3; ++i2) {
                if (((k)object4).v().get(n2) != j.g()) continue;
                return true;
            }
            object = j.e();
            object3 = j.b();
            return e3.i.a(((k)object4).v(), n2, object, object3) ^ true;
        }
        if (object3 == j.c()) {
            return false;
        }
        return this.q(object3);
    }

    protected final void d(c3.i i2) {
        do {
            if (this.g() > 0) {
                i2.c(q.a, this.b);
                return;
            }
            V2.k.c(i2, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        } while (!this.e((N0)((Object)i2)));
    }

    public final int h() {
        return Math.max((int)i.g.get((Object)this), (int)0);
    }

    public final void o() {
        int n2;
        while ((n2 = i.g.getAndIncrement((Object)this)) < this.a) {
            if (n2 < 0 && !this.r()) continue;
            return;
        }
        this.f();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The number of released permits cannot be greater than ");
        stringBuilder.append(this.a);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    public final boolean p() {
        while (true) {
            int n2;
            if ((n2 = i.g.get((Object)this)) > this.a) {
                this.f();
                continue;
            }
            if (n2 <= 0) {
                return false;
            }
            if (i.g.compareAndSet((Object)this, n2, n2 - 1)) break;
        }
        return true;
    }
}

