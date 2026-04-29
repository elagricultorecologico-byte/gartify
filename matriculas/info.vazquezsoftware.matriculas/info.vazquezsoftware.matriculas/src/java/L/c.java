/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.concurrent.Executor
 */
package l;

import java.util.concurrent.Executor;
import l.a;
import l.b;
import l.d;
import l.e;

public class c
extends e {
    private static volatile c c;
    private static final Executor d;
    private static final Executor e;
    private e a;
    private final e b;

    static {
        d = new a();
        e = new b();
    }

    private c() {
        d d2 = new d();
        this.b = d2;
        this.a = d2;
    }

    public static /* synthetic */ void d(Runnable runnable) {
        l.c.g().c(runnable);
    }

    public static /* synthetic */ void e(Runnable runnable) {
        l.c.g().a(runnable);
    }

    public static Executor f() {
        return e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c g() {
        if (c != null) {
            return c;
        }
        Class<c> clazz = c.class;
        synchronized (c.class) {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        c c2;
                        if (c != null) break block4;
                        c = c2 = new c();
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                // ** MonitorExit[var1] (shouldn't be in output)
                return c;
            }
            // ** MonitorExit[var1] (shouldn't be in output)
            throw throwable2;
        }
    }

    @Override
    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    @Override
    public boolean b() {
        return this.a.b();
    }

    @Override
    public void c(Runnable runnable) {
        this.a.c(runnable);
    }
}

