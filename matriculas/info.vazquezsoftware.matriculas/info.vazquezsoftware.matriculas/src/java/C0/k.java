/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.ArrayDeque
 *  java.util.concurrent.Executor
 */
package C0;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class k
implements Executor {
    private final ArrayDeque g;
    private final Executor h;
    private final Object i;
    private volatile Runnable j;

    public k(Executor executor) {
        this.h = executor;
        this.g = new ArrayDeque();
        this.i = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b() {
        Object object;
        Object object2 = object = this.i;
        synchronized (object2) {
            boolean bl = this.g.isEmpty();
            return bl ^ true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void c() {
        Object object;
        Object object2 = object = this.i;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        Runnable runnable;
                        this.j = runnable = (Runnable)this.g.poll();
                        if (runnable == null) break block3;
                        this.h.execute(this.j);
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void execute(Runnable runnable) {
        Object object;
        Object object2 = object = this.i;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        ArrayDeque arrayDeque = this.g;
                        a a2 = new a(this, runnable);
                        arrayDeque.add((Object)a2);
                        if (this.j != null) break block3;
                        this.c();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    static class a
    implements Runnable {
        final k g;
        final Runnable h;

        a(k k2, Runnable runnable) {
            this.g = k2;
            this.h = runnable;
        }

        public void run() {
            try {
                this.h.run();
                return;
            }
            finally {
                this.g.c();
            }
        }
    }
}

