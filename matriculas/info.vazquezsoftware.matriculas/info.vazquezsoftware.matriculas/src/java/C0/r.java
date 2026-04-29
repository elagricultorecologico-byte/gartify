/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  t0.j
 */
package C0;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import t0.j;

public class r {
    private static final String f = j.f((String)"WorkTimer");
    private final ThreadFactory a;
    private final ScheduledExecutorService b;
    final Map c;
    final Map d;
    final Object e;

    public r() {
        ThreadFactory threadFactory;
        this.a = threadFactory = new ThreadFactory(this){
            private int a;
            final r b;
            {
                this.b = r2;
                this.a = 0;
            }

            public Thread newThread(Runnable runnable) {
                Thread thread = Executors.defaultThreadFactory().newThread(runnable);
                runnable = new StringBuilder();
                runnable.append("WorkManager-WorkTimer-thread-");
                runnable.append(this.a);
                thread.setName(runnable.toString());
                ++this.a;
                return thread;
            }
        };
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new Object();
        this.b = Executors.newSingleThreadScheduledExecutor((ThreadFactory)threadFactory);
    }

    public void a() {
        if (!this.b.isShutdown()) {
            this.b.shutdownNow();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(String string, long l2, b b2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            j.c().a(f, String.format((String)"Starting timer for %s", (Object[])new Object[]{string}), new Throwable[0]);
            this.c(string);
            c c2 = new c(this, string);
            this.c.put((Object)string, (Object)c2);
            this.d.put((Object)string, (Object)b2);
            this.b.schedule((Runnable)c2, l2, TimeUnit.MILLISECONDS);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(String string) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        if ((c)this.c.remove((Object)string) == null) break block3;
                        j.c().a(f, String.format((String)"Stopping timer for %s", (Object[])new Object[]{string}), new Throwable[0]);
                        this.d.remove((Object)string);
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

    public static interface b {
        public void b(String var1);
    }

    public static class c
    implements Runnable {
        private final r g;
        private final String h;

        c(r r2, String string) {
            this.g = r2;
            this.h = string;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void run() {
            Object object;
            Object object2 = object = this.g.e;
            synchronized (object2) {
                Throwable throwable2;
                block6: {
                    block5: {
                        block4: {
                            try {
                                if ((c)this.g.c.remove((Object)this.h) == null) break block4;
                                b b2 = (b)this.g.d.remove((Object)this.h);
                                if (b2 != null) {
                                    b2.b(this.h);
                                }
                                break block5;
                            }
                            catch (Throwable throwable2) {
                                break block6;
                            }
                        }
                        j.c().a("WrkTimerRunnable", String.format((String)"Timer with %s is already marked as complete.", (Object[])new Object[]{this.h}), new Throwable[0]);
                    }
                    return;
                }
                throw throwable2;
            }
        }
    }
}

