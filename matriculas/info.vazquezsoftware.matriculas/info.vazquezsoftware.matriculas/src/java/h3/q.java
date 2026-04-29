/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.b
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceArray
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package h3;

import V2.g;
import h3.D;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class q {
    public static final a e = new a(null);
    private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, (String)"_next$volatile");
    private static final AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(q.class, (String)"_state$volatile");
    public static final D h = new D("REMOVE_FROZEN");
    private volatile Object _next$volatile;
    private volatile long _state$volatile;
    private final int a;
    private final boolean b;
    private final int c;
    private final AtomicReferenceArray d;

    public q(int n2, boolean bl) {
        int n3;
        this.a = n2;
        this.b = bl;
        this.c = n3 = n2 - 1;
        this.d = new AtomicReferenceArray(n2);
        if (n3 <= 0x3FFFFFFF) {
            if ((n2 & n3) == 0) {
                return;
            }
            throw new IllegalStateException("Check failed.");
        }
        throw new IllegalStateException("Check failed.");
    }

    private final q b(long l2) {
        int n2;
        q q2 = new q(this.a * 2, this.b);
        int n3 = (int)(0x3FFFFFFFL & l2);
        int n4 = (int)((0xFFFFFFFC0000000L & l2) >> 30);
        while ((n3 & (n2 = this.c)) != (n2 & n4)) {
            Object object;
            Object object2 = object = this.f().get(this.c & n3);
            if (object == null) {
                object2 = new b(n3);
            }
            q2.f().set(q2.c & n3, object2);
            ++n3;
        }
        q.g.set((Object)q2, e.d(l2, 0x1000000000000000L));
        return q2;
    }

    private final q c(long l2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q.f;
        q q2;
        while ((q2 = (q)atomicReferenceFieldUpdater.get((Object)this)) == null) {
            androidx.concurrent.futures.b.a((AtomicReferenceFieldUpdater)q.f, (Object)this, null, (Object)this.b(l2));
        }
        return q2;
    }

    private final q e(int n2, Object object) {
        Object object2 = this.f().get(this.c & n2);
        if (object2 instanceof b && ((b)object2).a == n2) {
            this.f().set(n2 & this.c, object);
            return this;
        }
        return null;
    }

    private final /* synthetic */ AtomicReferenceArray f() {
        return this.d;
    }

    private final long k() {
        long l2;
        long l3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = q.g;
        do {
            if (((l3 = atomicLongFieldUpdater.get((Object)this)) & 0x1000000000000000L) == 0L) continue;
            return l3;
        } while (!atomicLongFieldUpdater.compareAndSet((Object)this, l3, l2 = 0x1000000000000000L | l3));
        return l2;
    }

    private final q n(int n2, int n3) {
        long l2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = q.g;
        do {
            l2 = atomicLongFieldUpdater.get((Object)this);
            n2 = (int)(0x3FFFFFFFL & l2);
            if ((0x1000000000000000L & l2) == 0L) continue;
            return this.l();
        } while (!q.g.compareAndSet((Object)this, l2, e.b(l2, n3)));
        this.f().set(this.c & n2, null);
        return null;
    }

    public final int a(Object object) {
        int n2;
        int n3;
        Object object2 = q.g;
        while (true) {
            long l2;
            if ((0x3000000000000000L & (l2 = object2.get((Object)this))) != 0L) {
                return e.a(l2);
            }
            n3 = (int)((0xFFFFFFFC0000000L & l2) >> 30);
            n2 = this.c;
            int n4 = (int)(0x3FFFFFFFL & l2);
            if ((n3 + 2 & n2) == (n4 & n2)) {
                return 1;
            }
            if (!this.b && this.f().get(n3 & n2) != null) {
                n2 = this.a;
                if (n2 >= 1024 && (n3 - n4 & 0x3FFFFFFF) <= n2 >> 1) continue;
                return 1;
            }
            if (q.g.compareAndSet((Object)this, l2, e.c(l2, n3 + 1 & 0x3FFFFFFF))) break;
        }
        this.f().set(n3 & n2, object);
        object2 = this;
        while ((q.g.get(object2) & 0x1000000000000000L) != 0L) {
            q q2 = ((q)object2).l().e(n3, object);
            object2 = q2;
            if (q2 != null) continue;
        }
        return 0;
    }

    public final boolean d() {
        long l2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = q.g;
        do {
            if (((l2 = atomicLongFieldUpdater.get((Object)this)) & 0x2000000000000000L) != 0L) {
                return true;
            }
            if ((0x1000000000000000L & l2) == 0L) continue;
            return false;
        } while (!atomicLongFieldUpdater.compareAndSet((Object)this, l2, 0x2000000000000000L | l2));
        return true;
    }

    public final int g() {
        long l2 = q.g.get((Object)this);
        int n2 = (int)(0x3FFFFFFFL & l2);
        return (int)((l2 & 0xFFFFFFFC0000000L) >> 30) - n2 & 0x3FFFFFFF;
    }

    public final boolean j() {
        long l2 = q.g.get((Object)this);
        return (int)(0x3FFFFFFFL & l2) == (int)((l2 & 0xFFFFFFFC0000000L) >> 30);
    }

    public final q l() {
        return this.c(this.k());
    }

    /*
     * Unable to fully structure code
     */
    public final Object m() {
        var6_1 = q.i();
        do lbl-1000:
        // 3 sources

        {
            block5: {
                if ((0x1000000000000000L & (var4_5 = var6_1.get((Object)this))) != 0L) {
                    return q.h;
                }
                var2_3 = (int)((0xFFFFFFFC0000000L & var4_5) >> 30);
                var3_4 = this.c;
                var1_2 = (int)(0x3FFFFFFFL & var4_5);
                if ((var2_3 & var3_4) == (var3_4 & var1_2)) {
                    return null;
                }
                var8_6 = this.f().get(this.c & var1_2);
                if (var8_6 != null) break block5;
                if (!this.b) ** GOTO lbl-1000
                return null;
            }
            if (var8_6 instanceof b) {
                return null;
            }
            var2_3 = var1_2 + 1 & 0x3FFFFFFF;
            if (!q.i().compareAndSet((Object)this, var4_5, q.e.b(var4_5, var2_3))) continue;
            this.f().set(this.c & var1_2, null);
            return var8_6;
        } while (!this.b);
        var6_1 = this;
        do {
            var7_7 = super.n(var1_2, var2_3);
            var6_1 = var7_7;
        } while (var7_7 != null);
        return var8_6;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g3) {
            this();
        }

        public final int a(long l2) {
            if ((l2 & 0x2000000000000000L) != 0L) {
                return 2;
            }
            return 1;
        }

        public final long b(long l2, int n2) {
            return this.d(l2, 0x3FFFFFFFL) | (long)n2;
        }

        public final long c(long l2, int n2) {
            return this.d(l2, 0xFFFFFFFC0000000L) | (long)n2 << 30;
        }

        public final long d(long l2, long l3) {
            return l2 & (l3 ^ 0xFFFFFFFFFFFFFFFFL);
        }
    }

    public static final class b {
        public final int a;

        public b(int n2) {
            this.a = n2;
        }
    }
}

