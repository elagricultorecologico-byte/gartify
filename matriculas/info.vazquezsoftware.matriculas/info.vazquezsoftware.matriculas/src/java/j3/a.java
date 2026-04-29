/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.AutoCloseable
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Thread$State
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.concurrent.Executor
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.locks.LockSupport
 */
package j3;

import H2.i;
import H2.q;
import V2.g;
import V2.k;
import V2.s;
import c3.M;
import h3.D;
import h3.y;
import j3.h;
import j3.j;
import j3.l;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

public final class a
implements Executor,
Closeable,
AutoCloseable {
    public static final a n = new a(null);
    private static final AtomicLongFieldUpdater o = AtomicLongFieldUpdater.newUpdater(a.class, (String)"parkedWorkersStack$volatile");
    private static final AtomicLongFieldUpdater p = AtomicLongFieldUpdater.newUpdater(a.class, (String)"controlState$volatile");
    private static final AtomicIntegerFieldUpdater q = AtomicIntegerFieldUpdater.newUpdater(a.class, (String)"_isTerminated$volatile");
    public static final D r = new D("NOT_IN_STACK");
    private volatile int _isTerminated$volatile;
    private volatile long controlState$volatile;
    public final int g;
    public final int h;
    public final long i;
    public final String j;
    public final j3.d k;
    public final j3.d l;
    public final y m;
    private volatile long parkedWorkersStack$volatile;

    public a(int n2, int n3, long l2, String string) {
        this.g = n2;
        this.h = n3;
        this.i = l2;
        this.j = string;
        if (n2 >= 1) {
            if (n3 >= n2) {
                if (n3 <= 0x1FFFFE) {
                    if (l2 > 0L) {
                        this.k = new j3.d();
                        this.l = new j3.d();
                        this.m = new y((n2 + 1) * 2);
                        this.controlState$volatile = (long)n2 << 42;
                        this._isTerminated$volatile = 0;
                        return;
                    }
                    string = new StringBuilder();
                    string.append("Idle worker keep alive time ");
                    string.append(l2);
                    string.append(" must be positive");
                    throw new IllegalArgumentException(string.toString().toString());
                }
                string = new StringBuilder();
                string.append("Max pool size ");
                string.append(n3);
                string.append(" should not exceed maximal supported number of threads 2097150");
                throw new IllegalArgumentException(string.toString().toString());
            }
            string = new StringBuilder();
            string.append("Max pool size ");
            string.append(n3);
            string.append(" should be greater than or equals to core pool size ");
            string.append(n2);
            throw new IllegalArgumentException(string.toString().toString());
        }
        string = new StringBuilder();
        string.append("Core pool size ");
        string.append(n2);
        string.append(" should be at least 1");
        throw new IllegalArgumentException(string.toString().toString());
    }

    private final boolean A0(long l2) {
        if (Y2.d.b((int)(0x1FFFFFL & l2) - (int)((l2 & 0x3FFFFE00000L) >> 21), 0) < this.g) {
            int n2 = this.p();
            if (n2 == 1 && this.g > 1) {
                this.p();
            }
            if (n2 > 0) {
                return true;
            }
        }
        return false;
    }

    private final c I() {
        Thread thread = Thread.currentThread();
        thread = thread instanceof c ? (c)thread : null;
        if (thread != null && V2.k.a(((c)thread).n, this)) {
            return thread;
        }
        return null;
    }

    static /* synthetic */ boolean I0(a a2, long l2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = a.p.get((Object)a2);
        }
        return a2.A0(l2);
    }

    private final boolean J0() {
        c c2;
        do {
            if ((c2 = this.a0()) != null) continue;
            return false;
        } while (!c.o.compareAndSet((Object)c2, -1, 0));
        LockSupport.unpark((Thread)c2);
        return true;
    }

    public static /* synthetic */ void M(a a2, Runnable runnable, boolean bl, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        a2.L(runnable, bl, bl2);
    }

    private final int Z(c object) {
        object = ((c)((Object)object)).g();
        while (object != r) {
            if (object == null) {
                return 0;
            }
            int n2 = ((c)((Object)object)).f();
            if (n2 != 0) {
                return n2;
            }
            object = ((c)((Object)object)).g();
        }
        return -1;
    }

    private final c a0() {
        long l2;
        c c2;
        int n2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = a.o;
        do {
            if ((c2 = (c)((Object)this.m.b(n2 = (int)(0x1FFFFFL & (l2 = atomicLongFieldUpdater.get((Object)this)))))) != null) continue;
            return null;
        } while ((n2 = this.Z(c2)) < 0 || !a.o.compareAndSet((Object)this, l2, (long)n2 | 0x200000L + l2 & 0xFFFFFFFFFFE00000L));
        c2.o(r);
        return c2;
    }

    private final boolean i(h h2) {
        if (h2.h) {
            return this.l.a(h2);
        }
        return this.k.a(h2);
    }

    private final void l0(long l2, boolean bl) {
        if (bl || this.J0() || this.A0(l2)) {
            return;
        }
        this.J0();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final int p() {
        y y2;
        y y3 = y2 = this.m;
        synchronized (y3) {
            Throwable throwable2;
            block13: {
                block12: {
                    int n2;
                    int n3;
                    long l2;
                    block11: {
                        int n4;
                        block10: {
                            block9: {
                                try {
                                    boolean bl = this.isTerminated();
                                    if (!bl) break block9;
                                }
                                catch (Throwable throwable2) {}
                                return -1;
                            }
                            l2 = a.p.get((Object)this);
                            n3 = (int)(l2 & 0x1FFFFFL);
                            n2 = Y2.d.b(n3 - (int)((l2 & 0x3FFFFE00000L) >> 21), 0);
                            n4 = this.g;
                            if (n2 < n4) break block10;
                            return 0;
                        }
                        n4 = this.h;
                        if (n3 < n4) break block11;
                        return 0;
                    }
                    n3 = (int)(a.p.get((Object)this) & 0x1FFFFFL) + 1;
                    if (n3 <= 0 || this.m.b(n3) != null) break block12;
                    c c2 = new c(this, n3);
                    this.m.c(n3, (Object)c2);
                    l2 = a.p.incrementAndGet((Object)this);
                    if (n3 == (int)(0x1FFFFFL & l2)) {
                        // MONITOREXIT @DISABLED, blocks:[6, 8] lbl29 : w: MONITOREXIT : var9_2
                        c2.start();
                        return n2 + 1;
                    }
                    c2 = new IllegalArgumentException("Failed requirement.");
                    throw c2;
                    break block13;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.");
                throw illegalArgumentException;
            }
            throw throwable2;
        }
    }

    private final h s0(c c2, h h2, boolean bl) {
        d d2;
        if (c2 == null || (d2 = c2.i) == d.k) {
            return h2;
        }
        if (!h2.h && d2 == d.h) {
            return h2;
        }
        c2.m = true;
        return c2.g.a(h2, bl);
    }

    public final h A(Runnable runnable, boolean bl) {
        long l2 = j3.j.f.a();
        if (runnable instanceof h) {
            runnable = (h)runnable;
            runnable.g = l2;
            runnable.h = bl;
            return runnable;
        }
        return j3.j.b(runnable, l2, bl);
    }

    public final void L(Runnable object, boolean bl, boolean bl2) {
        c3.c.a();
        h h2 = this.A((Runnable)object, bl);
        boolean bl3 = h2.h;
        long l2 = bl3 ? a.p.addAndGet((Object)this, 0x200000L) : 0L;
        object = this.I();
        h2 = this.s0((c)((Object)object), h2, bl2);
        if (h2 != null && !this.i(h2)) {
            object = new StringBuilder();
            object.append(this.j);
            object.append(" was terminated");
            throw new RejectedExecutionException(object.toString());
        }
        bl = bl2 && object != null;
        if (bl3) {
            this.l0(l2, bl);
            return;
        }
        if (bl) {
            return;
        }
        this.n0();
    }

    public final boolean b0(c c2) {
        int n2;
        long l2;
        if (c2.g() != r) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = a.o;
        do {
            l2 = atomicLongFieldUpdater.get((Object)this);
            int n3 = (int)(0x1FFFFFL & l2);
            n2 = c2.f();
            c2.o(this.m.b(n3));
        } while (!a.o.compareAndSet((Object)this, l2, 0x200000L + l2 & 0xFFFFFFFFFFE00000L | (long)n2));
        return true;
    }

    public final void c0(c c2, int n2, int n3) {
        long l2;
        int n4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = a.o;
        do {
            int n5;
            l2 = atomicLongFieldUpdater.get((Object)this);
            n4 = n5 = (int)(0x1FFFFFL & l2);
            if (n5 != n2) continue;
            n4 = n3 == 0 ? this.Z(c2) : n3;
        } while (n4 < 0 || !a.o.compareAndSet((Object)this, l2, 0x200000L + l2 & 0xFFFFFFFFFFE00000L | (long)n4));
    }

    public void close() {
        this.k0(10000L);
    }

    public void execute(Runnable runnable) {
        a.M(this, runnable, false, false, 6, null);
    }

    public final void i0(h h2) {
        try {
            h2.run();
        }
        catch (Throwable throwable) {
            try {
                h2 = Thread.currentThread();
                h2.getUncaughtExceptionHandler().uncaughtException((Thread)h2, throwable);
                return;
            }
            finally {
                c3.c.a();
            }
        }
        c3.c.a();
    }

    public final boolean isTerminated() {
        return a.q.get((Object)this) != 0;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void k0(long l2) {
        y y2;
        if (!a.q.compareAndSet((Object)this, 0, 1)) {
            return;
        }
        c c2 = this.I();
        y y3 = y2 = this.m;
        // MONITORENTER : y3
        long l3 = a.p.get((Object)this);
        int n2 = (int)(l3 & 0x1FFFFFL);
        // MONITOREXIT : y3
        if (1 <= n2) {
            int n3 = 1;
            while (true) {
                Object object = this.m.b(n3);
                V2.k.b(object);
                c c3 = (c)((Object)object);
                if (c3 != c2) {
                    while (c3.getState() != Thread.State.TERMINATED) {
                        LockSupport.unpark((Thread)c3);
                        c3.join(l2);
                    }
                    c3.g.j(this.l);
                }
                if (n3 == n2) break;
                ++n3;
            }
        }
        this.l.b();
        this.k.b();
        while (true) {
            void var7_11;
            block15: {
                h h2;
                block14: {
                    if (c2 == null) break block14;
                    h h3 = h2 = c2.e(true);
                    if (h2 != null) break block15;
                }
                h h4 = h2 = (h)this.k.e();
                if (h2 == null) {
                    h h5 = h2 = (h)this.l.e();
                    if (h2 == null) {
                        if (c2 != null) {
                            c2.r(d.k);
                        }
                        a.o.set((Object)this, 0L);
                        a.p.set((Object)this, 0L);
                        return;
                    }
                }
            }
            this.i0((h)var7_11);
        }
    }

    public final void n0() {
        if (this.J0() || a.I0(this, 0L, 1, null)) {
            return;
        }
        this.J0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String toString() {
        int n2;
        int n3;
        ArrayList arrayList = new ArrayList();
        int n4 = this.m.a();
        int n5 = 0;
        int n6 = 0;
        int n7 = n3 = (n2 = 0);
        for (int i2 = 1; i2 < n4; ++i2) {
            int n8;
            int n9;
            int n10;
            int n11;
            c c2 = (c)((Object)this.m.b(i2));
            if (c2 == null) {
                n11 = n5;
                n10 = n6;
                n9 = n2;
                n8 = n7;
            } else {
                int n12 = c2.g.i();
                d d2 = c2.i;
                n11 = b.a[d2.ordinal()];
                if (n11 != 1) {
                    if (n11 != 2) {
                        if (n11 != 3) {
                            if (n11 != 4) {
                                if (n11 != 5) throw new i();
                                n8 = n7 + 1;
                                n11 = n5;
                                n10 = n6;
                                n9 = n2;
                            } else {
                                int n13 = n3 + 1;
                                n11 = n5;
                                n10 = n6;
                                n9 = n2;
                                n3 = n13;
                                n8 = n7;
                                if (n12 > 0) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(n12);
                                    stringBuilder.append('d');
                                    arrayList.add((Object)stringBuilder.toString());
                                    n11 = n5;
                                    n10 = n6;
                                    n9 = n2;
                                    n3 = n13;
                                    n8 = n7;
                                }
                            }
                        } else {
                            n11 = n5 + 1;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(n12);
                            stringBuilder.append('c');
                            arrayList.add((Object)stringBuilder.toString());
                            n10 = n6;
                            n9 = n2;
                            n8 = n7;
                        }
                    } else {
                        n10 = n6 + 1;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(n12);
                        stringBuilder.append('b');
                        arrayList.add((Object)stringBuilder.toString());
                        n11 = n5;
                        n9 = n2;
                        n8 = n7;
                    }
                } else {
                    n9 = n2 + 1;
                    n8 = n7;
                    n10 = n6;
                    n11 = n5;
                }
            }
            n5 = n11;
            n6 = n10;
            n2 = n9;
            n7 = n8;
        }
        long l2 = a.p.get((Object)this);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j);
        stringBuilder.append('@');
        stringBuilder.append(M.b(this));
        stringBuilder.append("[Pool Size {core = ");
        stringBuilder.append(this.g);
        stringBuilder.append(", max = ");
        stringBuilder.append(this.h);
        stringBuilder.append("}, Worker States {CPU = ");
        stringBuilder.append(n5);
        stringBuilder.append(", blocking = ");
        stringBuilder.append(n6);
        stringBuilder.append(", parked = ");
        stringBuilder.append(n2);
        stringBuilder.append(", dormant = ");
        stringBuilder.append(n3);
        stringBuilder.append(", terminated = ");
        stringBuilder.append(n7);
        stringBuilder.append("}, running workers queues = ");
        stringBuilder.append((Object)arrayList);
        stringBuilder.append(", global CPU queue size = ");
        stringBuilder.append(this.k.c());
        stringBuilder.append(", global blocking queue size = ");
        stringBuilder.append(this.l.c());
        stringBuilder.append(", Control State {created workers= ");
        stringBuilder.append((int)(0x1FFFFFL & l2));
        stringBuilder.append(", blocking tasks = ");
        stringBuilder.append((int)((0x3FFFFE00000L & l2) >> 21));
        stringBuilder.append(", CPUs acquired = ");
        stringBuilder.append(this.g - (int)((0x7FFFFC0000000000L & l2) >> 42));
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

    public abstract class b {
        public static final int[] a;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static {
            int[] nArray = new int[d.values().length];
            try {
                nArray[d.i.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[d.h.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[d.g.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[d.j.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[d.k.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            a = nArray;
        }
    }

    public final class c
    extends Thread {
        private static final AtomicIntegerFieldUpdater o = AtomicIntegerFieldUpdater.newUpdater(c.class, (String)"workerCtl$volatile");
        public final l g;
        private final s h;
        public d i;
        private volatile int indexInArray;
        private long j;
        private long k;
        private int l;
        public boolean m;
        final a n;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl$volatile;

        private c(a a2) {
            this.n = a2;
            this.setDaemon(true);
            this.setContextClassLoader(a2.getClass().getClassLoader());
            this.g = new l();
            this.h = new s();
            this.i = d.j;
            this.nextParkedWorker = r;
            int n2 = (int)System.nanoTime();
            if (n2 == 0) {
                n2 = 42;
            }
            this.l = n2;
        }

        public c(a a2, int n2) {
            this(a2);
            this.n(n2);
        }

        private final void b(h object) {
            this.j = 0L;
            if (this.i == d.i) {
                this.i = d.h;
            }
            if (((h)object).h) {
                if (this.r(d.h)) {
                    this.n.n0();
                }
                this.n.i0((h)object);
                object = this.n;
                a.p.addAndGet(object, -2097152L);
                if (this.i != d.k) {
                    this.i = d.j;
                }
                return;
            }
            this.n.i0((h)object);
        }

        private final h c(boolean bl) {
            if (bl) {
                h h2;
                boolean bl2 = this.j(this.n.g * 2) == 0;
                if (bl2 && (h2 = this.l()) != null) {
                    return h2;
                }
                h2 = this.g.k();
                if (h2 != null) {
                    return h2;
                }
                if (!bl2 && (h2 = this.l()) != null) {
                    return h2;
                }
            } else {
                h h3 = this.l();
                if (h3 != null) {
                    return h3;
                }
            }
            return this.s(3);
        }

        private final h d() {
            h h2;
            h h3 = h2 = this.g.l();
            if (h2 == null) {
                h3 = h2 = (h)this.n.l.e();
                if (h2 == null) {
                    h3 = this.s(1);
                }
            }
            return h3;
        }

        private final boolean i() {
            return this.nextParkedWorker != r;
        }

        private final void k() {
            if (this.j == 0L) {
                this.j = System.nanoTime() + this.n.i;
            }
            LockSupport.parkNanos((long)this.n.i);
            if (System.nanoTime() - this.j >= 0L) {
                this.j = 0L;
                this.t();
            }
        }

        private final h l() {
            if (this.j(2) == 0) {
                h h2 = (h)this.n.k.e();
                if (h2 != null) {
                    return h2;
                }
                return (h)this.n.l.e();
            }
            h h3 = (h)this.n.l.e();
            if (h3 != null) {
                return h3;
            }
            return (h)this.n.k.e();
        }

        private final void m() {
            block0: while (true) {
                boolean bl = false;
                while (!this.n.isTerminated() && this.i != d.k) {
                    h h2 = this.e(this.m);
                    if (h2 != null) {
                        this.k = 0L;
                        this.b(h2);
                        continue block0;
                    }
                    this.m = false;
                    if (this.k != 0L) {
                        if (!bl) {
                            bl = true;
                            continue;
                        }
                        this.r(d.i);
                        Thread.interrupted();
                        LockSupport.parkNanos((long)this.k);
                        this.k = 0L;
                        continue block0;
                    }
                    this.q();
                }
                break;
            }
            this.r(d.k);
        }

        private final boolean p() {
            long l2;
            if (this.i == d.g) {
                return true;
            }
            a a2 = this.n;
            AtomicLongFieldUpdater atomicLongFieldUpdater = a.p;
            do {
                if ((int)((0x7FFFFC0000000000L & (l2 = atomicLongFieldUpdater.get((Object)a2))) >> 42) != 0) continue;
                return false;
            } while (!a.p.compareAndSet((Object)a2, l2, l2 - 0x40000000000L));
            this.i = d.g;
            return true;
        }

        private final void q() {
            if (!this.i()) {
                this.n.b0(this);
                return;
            }
            c.o.set((Object)this, -1);
            while (this.i() && c.o.get((Object)this) == -1 && !this.n.isTerminated() && this.i != d.k) {
                this.r(d.i);
                Thread.interrupted();
                this.k();
            }
        }

        private final h s(int n2) {
            Object object = this.n;
            int n3 = (int)(a.p.get(object) & 0x1FFFFFL);
            if (n3 < 2) {
                return null;
            }
            int n4 = this.j(n3);
            Object object2 = this.n;
            long l2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < n3; ++i2) {
                long l3;
                int n5;
                n4 = n5 = n4 + 1;
                if (n5 > n3) {
                    n4 = 1;
                }
                if ((object = (c)((Object)((a)object2).m.b(n4))) != null && object != this) {
                    long l4 = ((c)((Object)object)).g.r(n2, this.h);
                    if (l4 == -1L) {
                        object2 = this.h;
                        object = (h)((s)object2).g;
                        ((s)object2).g = null;
                        return object;
                    }
                    l3 = l2;
                    if (l4 > 0L) {
                        l3 = Math.min((long)l2, (long)l4);
                    }
                } else {
                    l3 = l2;
                }
                l2 = l3;
            }
            if (l2 == Long.MAX_VALUE) {
                l2 = 0L;
            }
            this.k = l2;
            return null;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private final void t() {
            y y2;
            Object object = this.n;
            y y3 = y2 = ((a)object).m;
            synchronized (y3) {
                int n2;
                int n3;
                Throwable throwable2;
                block9: {
                    boolean bl;
                    block8: {
                        block7: {
                            try {
                                bl = ((a)object).isTerminated();
                                if (!bl) break block7;
                            }
                            catch (Throwable throwable2) {}
                            return;
                        }
                        n3 = (int)(a.p.get(object) & 0x1FFFFFL);
                        n2 = ((a)object).g;
                        if (n3 > n2) break block8;
                        return;
                    }
                    bl = c.o.compareAndSet((Object)this, -1, 1);
                    if (bl) break block9;
                    return;
                }
                n3 = this.indexInArray;
                this.n(0);
                ((a)object).c0(this, n3, 0);
                n2 = (int)(0x1FFFFFL & a.p.getAndDecrement(object));
                if (n2 != n3) {
                    Object object2 = ((a)object).m.b(n2);
                    V2.k.b(object2);
                    object2 = (c)((Object)object2);
                    ((a)object).m.c(n3, object2);
                    ((c)((Object)object2)).n(n3);
                    ((a)object).c0((c)((Object)object2), n2, n3);
                }
                ((a)object).m.c(n2, null);
                object = H2.q.a;
                // MONITOREXIT @DISABLED, blocks:[3, 4] lbl34 : w: MONITOREXIT : var7_4
                this.i = d.k;
                return;
                throw throwable2;
            }
        }

        public final h e(boolean bl) {
            if (this.p()) {
                return this.c(bl);
            }
            return this.d();
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final int j(int n2) {
            int n3;
            int n4 = this.l;
            n4 ^= n4 << 13;
            n4 ^= n4 >> 17;
            this.l = n3 = n4 ^ n4 << 5;
            n4 = n2 - 1;
            if ((n4 & n2) == 0) {
                return n3 & n4;
            }
            return (n3 & Integer.MAX_VALUE) % n2;
        }

        public final void n(int n2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.n.j);
            stringBuilder.append("-worker-");
            String string = n2 == 0 ? "TERMINATED" : String.valueOf((int)n2);
            stringBuilder.append(string);
            this.setName(stringBuilder.toString());
            this.indexInArray = n2;
        }

        public final void o(Object object) {
            this.nextParkedWorker = object;
        }

        public final boolean r(d d2) {
            d d3 = this.i;
            boolean bl = d3 == d.g;
            if (bl) {
                a a2 = this.n;
                a.p.addAndGet((Object)a2, 0x40000000000L);
            }
            if (d3 != d2) {
                this.i = d2;
            }
            return bl;
        }

        public void run() {
            this.m();
        }
    }

    public static final class d
    extends Enum {
        public static final /* enum */ d g = new d("CPU_ACQUIRED", 0);
        public static final /* enum */ d h = new d("BLOCKING", 1);
        public static final /* enum */ d i = new d("PARKING", 2);
        public static final /* enum */ d j = new d("DORMANT", 3);
        public static final /* enum */ d k = new d("TERMINATED", 4);
        private static final d[] l;
        private static final O2.a m;

        static {
            Enum[] enumArray = d.d();
            l = enumArray;
            m = O2.b.a(enumArray);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private d() {
            void var2_-1;
            void var1_-1;
        }

        private static final /* synthetic */ d[] d() {
            return new d[]{g, h, i, j, k};
        }

        public static d valueOf(String string) {
            return (d)Enum.valueOf(d.class, (String)string);
        }

        public static d[] values() {
            return (d[])l.clone();
        }
    }
}

