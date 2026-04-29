/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.b
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceArray
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package j3;

import V2.s;
import androidx.concurrent.futures.b;
import e3.i;
import j3.d;
import j3.h;
import j3.j;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class l {
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, (String)"lastScheduledTask$volatile");
    private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(l.class, (String)"producerIndex$volatile");
    private static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(l.class, (String)"consumerIndex$volatile");
    private static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(l.class, (String)"blockingTasksInBuffer$volatile");
    private final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer$volatile;
    private volatile int consumerIndex$volatile;
    private volatile Object lastScheduledTask$volatile;
    private volatile int producerIndex$volatile;

    private final h b(h h2) {
        if (this.e() == 127) {
            return h2;
        }
        if (h2.h) {
            l.e.incrementAndGet((Object)this);
        }
        int n2 = l.c.get((Object)this) & 0x7F;
        while (this.a.get(n2) != null) {
            Thread.yield();
        }
        this.a.lazySet(n2, (Object)h2);
        l.c.incrementAndGet((Object)this);
        return null;
    }

    private final void c(h h2) {
        if (h2 != null && h2.h) {
            l.e.decrementAndGet((Object)this);
        }
    }

    private final int e() {
        return l.c.get((Object)this) - l.d.get((Object)this);
    }

    private final h m() {
        h h2;
        int n2;
        do {
            if ((n2 = l.d.get((Object)this)) - l.c.get((Object)this) != 0) continue;
            return null;
        } while (!l.d.compareAndSet((Object)this, n2, n2 + 1) || (h2 = (h)this.a.getAndSet(n2 & 0x7F, null)) == null);
        this.c(h2);
        return h2;
    }

    private final boolean n(d d2) {
        h h2 = this.m();
        if (h2 == null) {
            return false;
        }
        d2.a(h2);
        return true;
    }

    private final h o(boolean bl) {
        h h2;
        while ((h2 = (h)l.b.get((Object)this)) != null && h2.h == bl) {
            if (!androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)l.b, (Object)this, (Object)h2, null)) continue;
            return h2;
        }
        int n2 = l.d.get((Object)this);
        int n3 = l.c.get((Object)this);
        while (n2 != n3) {
            if (bl && l.e.get((Object)this) == 0) {
                return null;
            }
            if ((h2 = this.q(--n3, bl)) == null) continue;
            return h2;
        }
        return null;
    }

    private final h p(int n2) {
        int n3 = l.d.get((Object)this);
        int n4 = l.c.get((Object)this);
        boolean bl = true;
        if (n2 == 1) {
            n2 = n3;
        } else {
            bl = false;
            n2 = n3;
        }
        while (n2 != n4) {
            if (bl && l.e.get((Object)this) == 0) {
                return null;
            }
            h h2 = this.q(n2, bl);
            if (h2 == null) {
                ++n2;
                continue;
            }
            return h2;
        }
        return null;
    }

    private final h q(int n2, boolean bl) {
        h h2 = (h)this.a.get(n2 &= 0x7F);
        if (h2 != null && h2.h == bl && i.a(this.a, n2, h2, null)) {
            if (bl) {
                l.e.decrementAndGet((Object)this);
            }
            return h2;
        }
        return null;
    }

    private final long s(int n2, s s2) {
        h h2;
        do {
            long l2;
            if ((h2 = (h)l.b.get((Object)this)) == null) {
                return -2L;
            }
            int n3 = h2.h ? 1 : 2;
            if ((n3 & n2) == 0) {
                return -2L;
            }
            long l3 = j.f.a() - h2.g;
            if (l3 >= (l2 = j.b)) continue;
            return l2 - l3;
        } while (!androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)l.b, (Object)this, (Object)h2, null));
        s2.g = h2;
        return -1L;
    }

    public final h a(h h2, boolean bl) {
        if (bl) {
            return this.b(h2);
        }
        h2 = (h)l.b.getAndSet((Object)this, (Object)h2);
        if (h2 == null) {
            return null;
        }
        return this.b(h2);
    }

    public final int i() {
        if (l.b.get((Object)this) != null) {
            return this.e() + 1;
        }
        return this.e();
    }

    public final void j(d d2) {
        h h2 = (h)l.b.getAndSet((Object)this, null);
        if (h2 != null) {
            d2.a(h2);
        }
        while (this.n(d2)) {
        }
    }

    public final h k() {
        h h2;
        h h3 = h2 = (h)l.b.getAndSet((Object)this, null);
        if (h2 == null) {
            h3 = this.m();
        }
        return h3;
    }

    public final h l() {
        return this.o(true);
    }

    public final long r(int n2, s s2) {
        h h2 = n2 == 3 ? this.m() : this.p(n2);
        if (h2 != null) {
            s2.g = h2;
            return -1L;
        }
        return this.s(n2, s2);
    }
}

