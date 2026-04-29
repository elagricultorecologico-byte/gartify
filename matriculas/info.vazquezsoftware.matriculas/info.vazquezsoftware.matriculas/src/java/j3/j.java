/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.TimeUnit
 */
package j3;

import Y2.d;
import h3.E;
import j3.e;
import j3.g;
import j3.h;
import j3.i;
import java.util.concurrent.TimeUnit;

public abstract class j {
    public static final String a = E.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
    public static final long b = E.h("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
    public static final int c = E.g("kotlinx.coroutines.scheduler.core.pool.size", Y2.d.b(E.a(), 2), 1, 0, 8, null);
    public static final int d = E.g("kotlinx.coroutines.scheduler.max.pool.size", 0x1FFFFE, 0, 0x1FFFFE, 4, null);
    public static final long e = TimeUnit.SECONDS.toNanos(E.h("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
    public static g f = j3.e.a;

    public static final /* synthetic */ String a(boolean bl) {
        return j.c(bl);
    }

    public static final h b(Runnable runnable, long l2, boolean bl) {
        return new i(runnable, l2, bl);
    }

    private static final String c(boolean bl) {
        if (bl) {
            return "Blocking";
        }
        return "Non-blocking";
    }
}

