/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.b
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package l3;

import H2.q;
import N2.h;
import c3.M;
import c3.N0;
import c3.k;
import c3.m;
import h3.A;
import h3.D;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l3.b;
import l3.c;
import l3.d;
import l3.e;
import l3.g;
import l3.i;

public class f
extends i
implements l3.a {
    private static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, (String)"owner$volatile");
    private final U2.q h;
    private volatile Object owner$volatile;

    public f(boolean bl) {
        super(1, bl ? 1 : 0);
        D d2 = bl ? null : g.c();
        this.owner$volatile = d2;
        this.h = new b(this);
    }

    private static final U2.q A(f f2, k3.a a2, Object object, Object object2) {
        return new c(f2, object);
    }

    private static final q B(f f2, Object object, Throwable throwable, Object object2, L2.i i2) {
        f2.a(object);
        return q.a;
    }

    private final int D(Object object) {
        block3: {
            int n2;
            do {
                if (this.p()) {
                    f.i.set((Object)this, object);
                    return 0;
                }
                if (object == null) {
                    return 1;
                }
                n2 = this.w(object);
                if (n2 == 1) break block3;
            } while (n2 != 2);
            return 1;
        }
        return 2;
    }

    public static /* synthetic */ q s(f f2, Object object, Throwable throwable, Object object2, L2.i i2) {
        return f.B(f2, object, throwable, object2, i2);
    }

    public static /* synthetic */ U2.q t(f f2, k3.a a2, Object object, Object object2) {
        return f.A(f2, a2, object, object2);
    }

    private final int w(Object object) {
        Object object2;
        do {
            if (this.x()) continue;
            return 0;
        } while ((object2 = f.i.get((Object)this)) == g.c());
        if (object2 == object) {
            return 1;
        }
        return 2;
    }

    static /* synthetic */ Object y(f object, Object object2, L2.e e2) {
        if (((f)object).C(object2)) {
            return q.a;
        }
        if ((object = ((f)object).z(object2, e2)) == M2.b.e()) {
            return object;
        }
        return q.a;
    }

    private final Object z(Object object, L2.e e2) {
        k k2 = m.b(M2.b.c(e2));
        try {
            a a2 = new a(this, k2, object);
            this.d(a2);
        }
        catch (Throwable throwable) {
            k2.N();
            throw throwable;
        }
        object = k2.y();
        if (object == M2.b.e()) {
            N2.h.c(e2);
        }
        if (object == M2.b.e()) {
            return object;
        }
        return q.a;
    }

    public boolean C(Object object) {
        int n2 = this.D(object);
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    throw new IllegalStateException("unexpected");
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("This mutex is already locked by the specified owner: ");
                stringBuilder.append(object);
                throw new IllegalStateException(stringBuilder.toString().toString());
            }
            return false;
        }
        return true;
    }

    @Override
    public void a(Object object) {
        while (this.x()) {
            Object object2 = f.i.get((Object)this);
            if (object2 == g.c()) continue;
            if (object2 != object && object != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("This mutex is locked by ");
                stringBuilder.append(object2);
                stringBuilder.append(", but ");
                stringBuilder.append(object);
                stringBuilder.append(" is expected");
                throw new IllegalStateException(stringBuilder.toString().toString());
            }
            if (!androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)f.i, (Object)this, (Object)object2, (Object)g.c())) continue;
            this.o();
            return;
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    @Override
    public Object b(Object object, L2.e e2) {
        return f.y(this, object, e2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mutex@");
        stringBuilder.append(M.b(this));
        stringBuilder.append("[isLocked=");
        stringBuilder.append(this.x());
        stringBuilder.append(",owner=");
        stringBuilder.append(f.i.get((Object)this));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public boolean x() {
        return this.h() == 0;
    }

    private final class a
    implements c3.i,
    N0 {
        public final k g;
        public final Object h;
        final f i;

        public a(f f2, k k2, Object object) {
            this.i = f2;
            this.g = k2;
            this.h = object;
        }

        public static /* synthetic */ q b(f f2, a a2, Throwable throwable, q q2, L2.i i2) {
            return a.i(f2, a2, throwable, q2, i2);
        }

        public static /* synthetic */ q d(f f2, a a2, Throwable throwable) {
            return a.g(f2, a2, throwable);
        }

        private static final q g(f f2, a a2, Throwable throwable) {
            f2.a(a2.h);
            return q.a;
        }

        private static final q i(f f2, a a2, Throwable throwable, q q2, L2.i i2) {
            f.i.set((Object)f2, a2.h);
            f2.a(a2.h);
            return q.a;
        }

        @Override
        public void a(A a2, int n2) {
            this.g.a(a2, n2);
        }

        @Override
        public void e(Object object) {
            this.g.e(object);
        }

        public void f(q q2, U2.q q3) {
            f.i.set((Object)this.i, this.h);
            this.g.P(q2, new e(this.i, this));
        }

        @Override
        public L2.i getContext() {
            return this.g.getContext();
        }

        public Object h(q object, Object object2, U2.q object3) {
            object3 = this.i;
            if ((object = this.g.k(object, object2, new d((f)object3, this))) != null) {
                f.i.set((Object)this.i, this.h);
            }
            return object;
        }

        @Override
        public void l(Object object) {
            this.g.l(object);
        }
    }
}

