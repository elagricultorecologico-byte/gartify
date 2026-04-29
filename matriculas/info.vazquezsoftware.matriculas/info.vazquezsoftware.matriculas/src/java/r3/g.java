/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.TimeUnit
 */
package r3;

import H2.q;
import V2.k;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import q3.d;
import r3.e;
import r3.f;

public final class g {
    public static final a f = new a(null);
    private final int a;
    private final long b;
    private final d c;
    private final b d;
    private final ConcurrentLinkedQueue e;

    public g(q3.e e2, int n2, long l2, TimeUnit timeUnit) {
        k.e(e2, "taskRunner");
        k.e(timeUnit, "timeUnit");
        this.a = n2;
        this.b = timeUnit.toNanos(l2);
        this.c = e2.i();
        this.d = new q3.a(this, k.j(n3.d.i, " ConnectionPool")){
            final g e;
            {
                this.e = g2;
                super(string, false, 2, null);
            }

            @Override
            public long f() {
                return this.e.b(System.nanoTime());
            }
        };
        this.e = new ConcurrentLinkedQueue();
        if (l2 > 0L) {
            return;
        }
        throw new IllegalArgumentException(k.j("keepAliveDuration <= 0: ", l2).toString());
    }

    private final int d(f f2, long l2) {
        if (n3.d.h && !Thread.holdsLock((Object)f2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append((Object)f2);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        List list = f2.n();
        int n2 = 0;
        while (n2 < list.size()) {
            Object object = (Reference)list.get(n2);
            if (object.get() != null) {
                ++n2;
                continue;
            }
            object = (e.a)((Object)object);
            Object object2 = new StringBuilder();
            object2.append("A connection to ");
            object2.append((Object)f2.z().a().l());
            object2.append(" was leaked. Did you forget to close a response body?");
            object2 = object2.toString();
            v3.k.a.g().l((String)object2, ((e.a)((Object)object)).a());
            list.remove(n2);
            f2.C(true);
            if (!list.isEmpty()) continue;
            f2.B(l2 - this.b);
            return 0;
        }
        return list.size();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(m3.a a2, e e2, List list, boolean bl) {
        Throwable throwable2;
        k.e(a2, "address");
        k.e(e2, "call");
        Iterator iterator = this.e.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                return false;
            }
            f f2 = (f)iterator.next();
            k.d(f2, "connection");
            f f3 = f2;
            synchronized (f3) {
                block8: {
                    block7: {
                        if (bl) {
                            try {
                                if (f2.v()) break block7;
                                break block8;
                            }
                            catch (Throwable throwable2) {
                                break;
                            }
                        }
                    }
                    if (f2.t(a2, list)) {
                        e2.a(f2);
                        return true;
                    }
                }
                q q2 = q.a;
            }
        }
        {
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final long b(long l2) {
        long l3;
        Iterator iterator = this.e.iterator();
        int n2 = 0;
        long l4 = Long.MIN_VALUE;
        f f2 = null;
        int n3 = 0;
        while (iterator.hasNext()) {
            f f3 = (f)iterator.next();
            k.d(f3, "connection");
            f f4 = f3;
            synchronized (f4) {
                if (this.d(f3, l2) > 0) {
                    ++n3;
                } else {
                    ++n2;
                    long l5 = l2 - f3.o();
                    l3 = l4;
                    if (l5 > l4) {
                        f2 = f3;
                        l3 = l5;
                    }
                    q q2 = q.a;
                    l4 = l3;
                }
            }
        }
        l3 = this.b;
        if (l4 < l3 && n2 <= this.a) {
            if (n2 > 0) {
                return l3 - l4;
            }
            if (n3 > 0) {
                return l3;
            }
            return -1L;
        }
        k.b(f2);
        f f5 = f2;
        synchronized (f5) {
            boolean bl = f2.n().isEmpty();
            if (!bl) {
                return 0L;
            }
            l3 = f2.o();
            if (l3 + l4 != l2) {
                return 0L;
            }
            f2.C(true);
            this.e.remove((Object)f2);
        }
        n3.d.n(f2.D());
        if (this.e.isEmpty()) {
            this.c.a();
        }
        return 0L;
    }

    public final boolean c(f f2) {
        k.e(f2, "connection");
        if (n3.d.h && !Thread.holdsLock((Object)f2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append((Object)f2);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        if (!f2.p() && this.a != 0) {
            q3.d.j(this.c, this.d, 0L, 2, null);
            return false;
        }
        f2.C(true);
        this.e.remove((Object)f2);
        if (this.e.isEmpty()) {
            this.c.a();
        }
        return true;
    }

    public final void e(f f2) {
        k.e(f2, "connection");
        if (n3.d.h && !Thread.holdsLock((Object)f2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append((Object)f2);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        this.e.add((Object)f2);
        q3.d.j(this.c, this.d, 0L, 2, null);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g2) {
            this();
        }
    }
}

