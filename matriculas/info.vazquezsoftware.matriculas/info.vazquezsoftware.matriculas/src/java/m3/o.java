/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.app.E
 *  java.lang.AssertionError
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Deque
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package m3;

import H2.q;
import V2.k;
import androidx.appcompat.app.E;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import n3.d;
import r3.e;

public final class o {
    private int a = 64;
    private int b = 5;
    private Runnable c;
    private ExecutorService d;
    private final ArrayDeque e = new ArrayDeque();
    private final ArrayDeque f = new ArrayDeque();
    private final ArrayDeque g = new ArrayDeque();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final void c(Deque object, Object object2) {
        block4: {
            o o2 = this;
            // MONITORENTER : o2
            if (!object.remove(object2)) break block4;
            object = this.e();
            object2 = q.a;
            // MONITOREXIT : o2
            if (this.g()) return;
            if (object == null) return;
            object.run();
            return;
        }
        object = new AssertionError((Object)"Call wasn't in-flight!");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final boolean g() {
        if (n3.d.h && Thread.holdsLock((Object)this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append((Object)this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        ArrayList arrayList = new ArrayList();
        o o2 = this;
        // MONITORENTER : o2
        Object object = this.e.iterator();
        k.d(object, "readyAsyncCalls.iterator()");
        if (object.hasNext()) {
            E.a((Object)object.next());
            if (this.f.size() < this.f()) throw null;
        }
        boolean bl = this.h() > 0;
        object = q.a;
        // MONITOREXIT : o2
        if (arrayList.size() <= 0) {
            return bl;
        }
        E.a((Object)arrayList.get(0));
        this.b();
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(e e2) {
        o o2 = this;
        synchronized (o2) {
            k.e(e2, "call");
            this.g.add((Object)e2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final ExecutorService b() {
        o o2 = this;
        synchronized (o2) {
            Throwable throwable2;
            block4: {
                ExecutorService executorService;
                block3: {
                    try {
                        if (this.d != null) break block3;
                        executorService = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, (TimeUnit)executorService, (BlockingQueue)synchronousQueue, n3.d.M(k.j(n3.d.i, " Dispatcher"), false));
                        this.d = threadPoolExecutor;
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                executorService = this.d;
                k.b(executorService);
                return executorService;
            }
            throw throwable2;
        }
    }

    public final void d(e e2) {
        k.e(e2, "call");
        this.c((Deque)this.g, e2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Runnable e() {
        o o2 = this;
        synchronized (o2) {
            return this.c;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int f() {
        o o2 = this;
        synchronized (o2) {
            return this.a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int h() {
        o o2 = this;
        synchronized (o2) {
            int n2 = this.f.size();
            int n3 = this.g.size();
            return n2 + n3;
        }
    }
}

