/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package h3;

import L2.i;
import L2.j;
import c3.F;
import c3.H;
import c3.O;
import c3.S;
import h3.l;
import h3.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class k
extends F
implements S {
    private static final AtomicIntegerFieldUpdater o = AtomicIntegerFieldUpdater.newUpdater(k.class, (String)"runningWorkers$volatile");
    private final S i;
    private final F j;
    private final int k;
    private final String l;
    private final p m;
    private final Object n;
    private volatile int runningWorkers$volatile;

    public k(F f2, int n2, String string) {
        S s2 = f2 instanceof S ? (S)((Object)f2) : null;
        S s3 = s2;
        if (s2 == null) {
            s3 = O.a();
        }
        this.i = s3;
        this.j = f2;
        this.k = n2;
        this.l = string;
        this.m = new p(false);
        this.n = new Object();
    }

    private final Runnable Q0() {
        Object object;
        while ((object = (Runnable)this.m.e()) == null) {
            Object object2 = object = this.n;
            synchronized (object2) {
                block5: {
                    h3.k.o.decrementAndGet((Object)this);
                    int n2 = this.m.c();
                    if (n2 != 0) break block5;
                    return null;
                }
                h3.k.o.incrementAndGet((Object)this);
            }
        }
        return object;
    }

    private final boolean R0() {
        Object object;
        Object object2 = object = this.n;
        synchronized (object2) {
            block4: {
                int n2 = h3.k.o.get((Object)this);
                int n3 = this.k;
                if (n2 < n3) break block4;
                return false;
            }
            h3.k.o.incrementAndGet((Object)this);
            return true;
        }
    }

    @Override
    public void J0(i object, Runnable runnable) {
        this.m.a(runnable);
        if (h3.k.o.get((Object)this) < this.k && this.R0() && (object = this.Q0()) != null) {
            object = new a(this, (Runnable)object);
            this.j.J0(this, (Runnable)object);
        }
    }

    @Override
    public F L0(int n2, String string) {
        h3.l.a(n2);
        if (n2 >= this.k) {
            return h3.l.b(this, string);
        }
        return super.L0(n2, string);
    }

    @Override
    public String toString() {
        String string;
        String string2 = string = this.l;
        if (string == null) {
            string2 = new StringBuilder();
            string2.append((Object)this.j);
            string2.append(".limitedParallelism(");
            string2.append(this.k);
            string2.append(')');
            string2 = string2.toString();
        }
        return string2;
    }

    private final class a
    implements Runnable {
        private Runnable g;
        final k h;

        public a(k k2, Runnable runnable) {
            this.h = k2;
            this.g = runnable;
        }

        public void run() {
            int n2 = 0;
            while (true) {
                int n3;
                try {
                    this.g.run();
                }
                catch (Throwable throwable) {
                    H.a(L2.j.g, throwable);
                }
                Runnable runnable = this.h.Q0();
                if (runnable == null) {
                    return;
                }
                this.g = runnable;
                n2 = n3 = n2 + 1;
                if (n3 < 16) continue;
                n2 = n3;
                if (this.h.j.K0(this.h)) break;
            }
            this.h.j.J0(this.h, this);
        }
    }
}

