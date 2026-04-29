/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InterruptedIOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.concurrent.TimeUnit
 */
package z3;

import V2.g;
import V2.k;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class y {
    public static final b d = new b(null);
    public static final y e = new y(){

        @Override
        public y d(long l2) {
            return this;
        }

        @Override
        public void f() {
        }

        @Override
        public y g(long l2, TimeUnit timeUnit) {
            k.e(timeUnit, "unit");
            return this;
        }
    };
    private boolean a;
    private long b;
    private long c;

    public y a() {
        this.a = false;
        return this;
    }

    public y b() {
        this.c = 0L;
        return this;
    }

    public long c() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public y d(long l2) {
        this.a = true;
        this.b = l2;
        return this;
    }

    public boolean e() {
        return this.a;
    }

    public void f() {
        if (!Thread.currentThread().isInterrupted()) {
            if (this.a && this.b - System.nanoTime() <= 0L) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("interrupted");
    }

    public y g(long l2, TimeUnit timeUnit) {
        k.e(timeUnit, "unit");
        boolean bl = l2 >= 0L;
        if (bl) {
            this.c = timeUnit.toNanos(l2);
            return this;
        }
        throw new IllegalArgumentException(k.j("timeout < 0: ", l2).toString());
    }

    public long h() {
        return this.c;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }
    }
}

