/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package q3;

import H2.q;
import V2.g;
import V2.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import q3.d;

public final class e {
    public static final b h = new b(null);
    public static final e i = new e(new c(n3.d.M(k.j(n3.d.i, " TaskRunner"), true)));
    private static final Logger j;
    private final a a;
    private int b;
    private boolean c;
    private long d;
    private final List e;
    private final List f;
    private final Runnable g;

    static {
        Logger logger = Logger.getLogger((String)e.class.getName());
        k.d(logger, "getLogger(TaskRunner::class.java.name)");
        j = logger;
    }

    public e(a a2) {
        k.e(a2, "backend");
        this.a = a2;
        this.b = 10000;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new Runnable(this){
            final e g;
            {
                this.g = e2;
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            public void run() {
                Throwable throwable32;
                long l2;
                boolean bl;
                e e2;
                q3.a a2;
                Object object;
                while (true) {
                    object = this.g;
                    e e3 = object;
                    // MONITORENTER : e3
                    a2 = ((e)object).d();
                    // MONITOREXIT : e3
                    if (a2 == null) {
                        return;
                    }
                    object = a2.d();
                    k.b(object);
                    e2 = this.g;
                    bl = h.a().isLoggable(Level.FINE);
                    if (bl) {
                        l2 = ((d)object).h().g().a();
                        q3.b.a(a2, (d)object, "starting");
                    } else {
                        l2 = -1L;
                    }
                    e2.j(a2);
                    q q2 = q.a;
                    if (!bl) continue;
                    q3.b.a(a2, (d)object, k.j("finished run in ", q3.b.b(((d)object).h().g().a() - l2)));
                }
                catch (Throwable throwable2) {
                    try {
                        e2.g().execute(this);
                        throw throwable2;
                    }
                    catch (Throwable throwable32) {}
                }
                if (!bl) throw throwable32;
                q3.b.a(a2, (d)object, k.j("failed a run in ", q3.b.b(((d)object).h().g().a() - l2)));
                throw throwable32;
            }
        };
    }

    private final void c(q3.a a2, long l2) {
        if (n3.d.h && !Thread.holdsLock((Object)this)) {
            a2 = new StringBuilder();
            a2.append("Thread ");
            a2.append(Thread.currentThread().getName());
            a2.append(" MUST hold lock on ");
            a2.append(this);
            throw new AssertionError((Object)a2.toString());
        }
        d d2 = a2.d();
        k.b(d2);
        if (d2.c() == a2) {
            boolean bl = d2.d();
            d2.m(false);
            d2.l(null);
            this.e.remove((Object)d2);
            if (l2 != -1L && !bl && !d2.g()) {
                d2.k(a2, l2, true);
            }
            if (!d2.e().isEmpty()) {
                this.f.add((Object)d2);
            }
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    private final void e(q3.a a2) {
        if (n3.d.h && !Thread.holdsLock((Object)this)) {
            a2 = new StringBuilder();
            a2.append("Thread ");
            a2.append(Thread.currentThread().getName());
            a2.append(" MUST hold lock on ");
            a2.append(this);
            throw new AssertionError((Object)a2.toString());
        }
        a2.g(-1L);
        d d2 = a2.d();
        k.b(d2);
        d2.e().remove((Object)a2);
        this.f.remove((Object)d2);
        d2.l(a2);
        this.e.add((Object)d2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void j(q3.a object) {
        e e2;
        long l2;
        if (n3.d.h && Thread.holdsLock((Object)this)) {
            object = new StringBuilder();
            object.append("Thread ");
            object.append((Object)Thread.currentThread().getName());
            object.append(" MUST NOT hold lock on ");
            object.append((Object)this);
            throw new AssertionError((Object)object.toString());
        }
        Thread thread = Thread.currentThread();
        String string = thread.getName();
        thread.setName(((q3.a)object).b());
        try {
            l2 = ((q3.a)object).f();
            e2 = this;
        }
        catch (Throwable throwable) {
            e e3 = this;
            synchronized (e3) {
                this.c((q3.a)object, -1L);
                object = q.a;
            }
            thread.setName(string);
            throw throwable;
        }
        synchronized (e2) {
            this.c((q3.a)object, l2);
            object = q.a;
        }
        thread.setName(string);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final q3.a d() {
        if (n3.d.h && !Thread.holdsLock((Object)this)) {
            var8_1 = new StringBuilder();
            var8_1.append("Thread ");
            var8_1.append((Object)Thread.currentThread().getName());
            var8_1.append(" MUST hold lock on ");
            var8_1.append((Object)this);
            throw new AssertionError((Object)var8_1.toString());
        }
        block4: while (true) {
            block15: {
                if (this.f.isEmpty()) {
                    return null;
                }
                var4_7 = this.a.a();
                var10_10 = this.f.iterator();
                var2_6 = 0x7FFFFFFFFFFFFFFFL;
                var8_2 = null;
                while (var10_10.hasNext()) {
                    var9_9 = (q3.a)((d)var10_10.next()).e().get(0);
                    var6_8 = Math.max((long)0L, (long)(var9_9.c() - var4_7));
                    if (var6_8 > 0L) {
                        var2_6 = Math.min((long)var6_8, (long)var2_6);
                        continue;
                    }
                    if (var8_2 != null) {
                        var1_5 = true;
                        break block15;
                    }
                    var8_2 = var9_9;
                }
                var1_5 = false;
            }
            if (var8_2 != null) {
                this.e(var8_2);
                if (var1_5 || !this.c && !this.f.isEmpty()) {
                    this.a.execute(this.g);
                }
                return var8_2;
            }
            if (this.c) {
                if (var2_6 < this.d - var4_7) {
                    this.a.c(this);
                }
                return null;
            }
            this.c = true;
            this.d = var4_7 + var2_6;
            this.a.b(this, var2_6);
lbl45:
            // 2 sources

            while (true) {
                this.c = false;
                continue block4;
                break;
            }
            {
                catch (Throwable var8_3) {
                    break;
                }
                catch (InterruptedException var8_4) {}
                {
                    this.f();
                    ** continue;
                }
            }
        }
        this.c = false;
        throw var8_3;
    }

    public final void f() {
        int n2;
        int n3 = this.e.size() - 1;
        if (n3 >= 0) {
            while (true) {
                n2 = n3 - 1;
                ((d)this.e.get(n3)).b();
                if (n2 < 0) break;
                n3 = n2;
            }
        }
        if ((n3 = this.f.size() - 1) >= 0) {
            while (true) {
                n2 = n3 - 1;
                d d2 = (d)this.f.get(n3);
                d2.b();
                if (d2.e().isEmpty()) {
                    this.f.remove(n3);
                }
                if (n2 < 0) break;
                n3 = n2;
            }
        }
    }

    public final a g() {
        return this.a;
    }

    public final void h(d d2) {
        k.e(d2, "taskQueue");
        if (n3.d.h && !Thread.holdsLock((Object)this)) {
            d2 = new StringBuilder();
            d2.append("Thread ");
            d2.append(Thread.currentThread().getName());
            d2.append(" MUST hold lock on ");
            d2.append(this);
            throw new AssertionError((Object)d2.toString());
        }
        if (d2.c() == null) {
            if (!d2.e().isEmpty()) {
                n3.d.c(this.f, d2);
            } else {
                this.f.remove((Object)d2);
            }
        }
        if (this.c) {
            this.a.c(this);
            return;
        }
        this.a.execute(this.g);
    }

    public final d i() {
        e e2 = this;
        synchronized (e2) {
            int n2 = this.b;
            this.b = n2 + 1;
            return new d(this, k.j("Q", n2));
        }
    }

    public static interface a {
        public long a();

        public void b(e var1, long var2);

        public void c(e var1);

        public void execute(Runnable var1);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        public final Logger a() {
            return j;
        }
    }

    public static final class c
    implements a {
        private final ThreadPoolExecutor a;

        public c(ThreadFactory threadFactory) {
            k.e(threadFactory, "threadFactory");
            this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), threadFactory);
        }

        @Override
        public long a() {
            return System.nanoTime();
        }

        @Override
        public void b(e e2, long l2) {
            k.e(e2, "taskRunner");
            long l3 = l2 / 1000000L;
            if (l3 <= 0L && l2 <= 0L) {
                return;
            }
            e2.wait(l3, (int)(l2 - 1000000L * l3));
        }

        @Override
        public void c(e e2) {
            k.e(e2, "taskRunner");
            e2.notify();
        }

        @Override
        public void execute(Runnable runnable) {
            k.e(runnable, "runnable");
            this.a.execute(runnable);
        }
    }
}

