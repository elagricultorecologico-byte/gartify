/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator$DurationScaleChangeListener
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.lang.ThreadLocal
 *  java.util.ArrayList
 *  p.i
 */
package O;

import O.a;
import O.g;
import O.j;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import p.i;

public class c {
    private static final ThreadLocal j = new ThreadLocal();
    private final i a = new i();
    final ArrayList b = new ArrayList();
    private final b c = new b(this);
    private final Runnable d = new O.b(this);
    private j e;
    long f = 0L;
    private boolean g = false;
    public float h = 1.0f;
    public e i;

    public c(j j2) {
        this.e = j2;
    }

    public static /* synthetic */ void a(c c2) {
        c2.c.a();
    }

    private void e() {
        if (this.g) {
            for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
                if (this.b.get(i2) != null) continue;
                this.b.remove(i2);
            }
            if (this.b.size() == 0 && Build.VERSION.SDK_INT >= 33) {
                this.i.a();
            }
            this.g = false;
        }
    }

    static c h() {
        ThreadLocal threadLocal = j;
        if (threadLocal.get() == null) {
            threadLocal.set((Object)new c(new f()));
        }
        return (c)threadLocal.get();
    }

    private boolean i(c c2, long l2) {
        Long l3 = (Long)this.a.get((Object)c2);
        if (l3 == null) {
            return true;
        }
        if (l3 < l2) {
            this.a.remove((Object)c2);
            return true;
        }
        return false;
    }

    void d(c c2, long l2) {
        if (this.b.size() == 0) {
            this.e.a(this.d);
            if (Build.VERSION.SDK_INT >= 33) {
                this.h = O.a.a();
                if (this.i == null) {
                    this.i = new d(this);
                }
                this.i.b();
            }
        }
        if (!this.b.contains((Object)c2)) {
            this.b.add((Object)c2);
        }
        if (l2 > 0L) {
            this.a.put((Object)c2, (Object)(SystemClock.uptimeMillis() + l2));
        }
    }

    void f(long l2) {
        long l3 = SystemClock.uptimeMillis();
        for (int i2 = 0; i2 < this.b.size(); ++i2) {
            c c2 = (c)this.b.get(i2);
            if (c2 == null || !this.i(c2, l3)) continue;
            c2.a(l2);
        }
        this.e();
    }

    public float g() {
        return this.h;
    }

    boolean j() {
        return this.e.b();
    }

    void k(c c2) {
        this.a.remove((Object)c2);
        int n2 = this.b.indexOf((Object)c2);
        if (n2 >= 0) {
            this.b.set(n2, null);
            this.g = true;
        }
    }

    private class b {
        final c a;

        private b(c c2) {
            this.a = c2;
        }

        void a() {
            this.a.f = SystemClock.uptimeMillis();
            c c2 = this.a;
            c2.f(c2.f);
            if (this.a.b.size() > 0) {
                this.a.e.a(this.a.d);
            }
        }
    }

    static interface c {
        public boolean a(long var1);
    }

    public class d
    implements e {
        ValueAnimator.DurationScaleChangeListener a;
        final c b;

        public d(c c2) {
            this.b = c2;
        }

        public static /* synthetic */ void c(d d2, float f2) {
            d2.b.h = f2;
        }

        @Override
        public boolean a() {
            boolean bl = O.d.a(this.a);
            this.a = null;
            return bl;
        }

        @Override
        public boolean b() {
            if (this.a == null) {
                O.f f2 = new O.f(this);
                this.a = f2;
                return O.e.a(f2);
            }
            return true;
        }
    }

    public static interface e {
        public boolean a();

        public boolean b();
    }

    static final class f
    implements j {
        private final Choreographer a = Choreographer.getInstance();
        private final Looper b = Looper.myLooper();

        f() {
        }

        public static /* synthetic */ void c(Runnable runnable, long l2) {
            runnable.run();
        }

        @Override
        public void a(Runnable runnable) {
            this.a.postFrameCallback((Choreographer.FrameCallback)new g(runnable));
        }

        @Override
        public boolean b() {
            return Thread.currentThread() == this.b.getThread();
        }
    }
}

