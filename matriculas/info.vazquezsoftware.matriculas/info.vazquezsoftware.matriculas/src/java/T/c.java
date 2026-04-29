/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.g
 *  V2.k
 *  android.os.Looper
 *  android.util.Log
 *  android.view.ViewGroup
 *  androidx.fragment.app.f
 *  androidx.fragment.app.n
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Set
 */
package T;

import I2.E;
import I2.K;
import I2.o;
import T.d;
import T.e;
import T.g;
import T.h;
import V2.k;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.f;
import androidx.fragment.app.n;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class c {
    public static final c a = new c();
    private static c b = c.d;

    private c() {
    }

    public static /* synthetic */ void a(String string, g g2) {
        c.d(string, g2);
    }

    private final c b(f object) {
        while (object != null) {
            if (object.a0()) {
                n n2 = object.H();
                k.d((Object)n2, (String)"declaringFragment.parentFragmentManager");
                if (n2.x0() != null) {
                    object = n2.x0();
                    k.b((Object)object);
                    return object;
                }
            }
            object = object.G();
        }
        return b;
    }

    private final void c(c c2, g g2) {
        f f2 = g2.a();
        String string = f2.getClass().getName();
        if (c2.a().contains((Object)T.c$a.g)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Policy violation in ");
            stringBuilder.append(string);
            Log.d((String)"FragmentStrictMode", (String)stringBuilder.toString(), (Throwable)g2);
        }
        c2.b();
        if (c2.a().contains((Object)T.c$a.h)) {
            this.j(f2, new T.b(string, g2));
        }
    }

    private static final void d(String string, g g2) {
        k.e((Object)((Object)g2), (String)"$violation");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Policy violation with PENALTY_DEATH in ");
        stringBuilder.append(string);
        Log.e((String)"FragmentStrictMode", (String)stringBuilder.toString(), (Throwable)g2);
        throw g2;
    }

    private final void e(g g2) {
        if (n.E0((int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("StrictMode violation in ");
            stringBuilder.append(g2.a().getClass().getName());
            Log.d((String)"FragmentManager", (String)stringBuilder.toString(), (Throwable)g2);
        }
    }

    public static final void f(f f2, String object) {
        k.e((Object)f2, (String)"fragment");
        k.e((Object)object, (String)"previousFragmentId");
        T.a a2 = new T.a(f2, (String)object);
        object = a;
        super.e(a2);
        c c2 = super.b(f2);
        if (c2.a().contains((Object)T.c$a.i) && super.k(c2, f2.getClass(), a2.getClass())) {
            super.c(c2, a2);
        }
    }

    public static final void g(f f2, ViewGroup object) {
        k.e((Object)f2, (String)"fragment");
        d d2 = new d(f2, (ViewGroup)object);
        object = a;
        super.e(d2);
        c c2 = super.b(f2);
        if (c2.a().contains((Object)T.c$a.j) && super.k(c2, f2.getClass(), d2.getClass())) {
            super.c(c2, d2);
        }
    }

    public static final void h(f f2) {
        k.e((Object)f2, (String)"fragment");
        e e2 = new e(f2);
        c c2 = a;
        c2.e(e2);
        c c3 = c2.b(f2);
        if (c3.a().contains((Object)T.c$a.m) && c2.k(c3, f2.getClass(), e2.getClass())) {
            c2.c(c3, e2);
        }
    }

    public static final void i(f f2, ViewGroup object) {
        k.e((Object)f2, (String)"fragment");
        k.e((Object)object, (String)"container");
        object = new h(f2, (ViewGroup)object);
        c c2 = a;
        c2.e((g)((Object)object));
        c c3 = c2.b(f2);
        if (c3.a().contains((Object)T.c$a.n) && c2.k(c3, f2.getClass(), object.getClass())) {
            c2.c(c3, (g)((Object)object));
        }
    }

    private final void j(f f2, Runnable runnable) {
        if (f2.a0()) {
            f2 = f2.H().r0().p();
            k.d((Object)f2, (String)"fragment.parentFragmentManager.host.handler");
            if (k.a((Object)f2.getLooper(), (Object)Looper.myLooper())) {
                runnable.run();
                return;
            }
            f2.post(runnable);
            return;
        }
        runnable.run();
    }

    private final boolean k(c c2, Class object, Class clazz) {
        object = object.getName();
        if ((c2 = (Set)c2.c().get(object)) == null) {
            return true;
        }
        if (!k.a((Object)clazz.getSuperclass(), g.class) && o.t((Iterable)c2, clazz.getSuperclass())) {
            return false;
        }
        return c2.contains(clazz) ^ true;
    }

    public static final class a
    extends Enum {
        public static final /* enum */ a g = new a("PENALTY_LOG", 0);
        public static final /* enum */ a h = new a("PENALTY_DEATH", 1);
        public static final /* enum */ a i = new a("DETECT_FRAGMENT_REUSE", 2);
        public static final /* enum */ a j = new a("DETECT_FRAGMENT_TAG_USAGE", 3);
        public static final /* enum */ a k = new a("DETECT_RETAIN_INSTANCE_USAGE", 4);
        public static final /* enum */ a l = new a("DETECT_SET_USER_VISIBLE_HINT", 5);
        public static final /* enum */ a m = new a("DETECT_TARGET_FRAGMENT_USAGE", 6);
        public static final /* enum */ a n = new a("DETECT_WRONG_FRAGMENT_CONTAINER", 7);
        private static final a[] o = T.c$a.d();

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private a() {
            void var2_-1;
            void var1_-1;
        }

        private static final /* synthetic */ a[] d() {
            return new a[]{g, h, i, j, k, l, m, n};
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])o.clone();
        }
    }

    public static interface b {
    }

    public static final class c {
        public static final a c = new a(null);
        public static final c d = new c(K.b(), null, E.f());
        private final Set a;
        private final Map b;

        public c(Set set, b b2, Map map2) {
            k.e((Object)set, (String)"flags");
            k.e((Object)map2, (String)"allowedViolations");
            this.a = set;
            set = new LinkedHashMap();
            for (Map map2 : map2.entrySet()) {
                set.put((Object)((String)map2.getKey()), (Object)((Set)map2.getValue()));
            }
            this.b = set;
        }

        public final Set a() {
            return this.a;
        }

        public final b b() {
            return null;
        }

        public final Map c() {
            return this.b;
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(V2.g g2) {
                this();
            }
        }
    }
}

