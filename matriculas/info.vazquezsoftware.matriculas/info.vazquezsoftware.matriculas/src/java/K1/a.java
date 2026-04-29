/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicReference
 */
package k1;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class a {
    private final Context a;
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicReference c = new AtomicReference((Object)k1.a$a.h);
    private final AtomicReference d = new AtomicReference((Object)k1.a$b.h);
    private final AtomicReference e = new AtomicReference((Object)k1.a$c.h);

    a(Context context) {
        this.a = context;
    }

    public a a() {
        return (a)((Object)this.c.get());
    }

    public c b() {
        return (c)((Object)this.e.get());
    }

    public void c() {
        AtomicBoolean atomicBoolean = this.b;
        if (atomicBoolean.get()) {
            return;
        }
        a a2 = k1.a$a.d(this.a.getSharedPreferences("admob", 0).getInt("advertised_memory_tier", k1.a$a.h.e()));
        if (a2 != null) {
            this.c.set((Object)a2);
        }
        atomicBoolean.set(true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(a a2) {
        a a3 = this;
        synchronized (a3) {
            if (a2 == null) {
                return;
            }
            this.c.set((Object)a2);
            this.a.getSharedPreferences("admob", 0).edit().putInt("advertised_memory_tier", a2.e()).apply();
            return;
        }
    }

    public void e(b b2) {
        if (b2 != null) {
            this.d.set((Object)b2);
        }
    }

    public void f(c c2) {
        if (c2 != null) {
            this.e.set((Object)c2);
        }
    }

    public static final class a
    extends Enum {
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        public static final /* enum */ a l;
        public static final /* enum */ a m;
        public static final /* enum */ a n;
        public static final /* enum */ a o;
        public static final /* enum */ a p;
        public static final /* enum */ a q;
        private static final a[] r;
        private final int g;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            a a6;
            a a7;
            a a8;
            a a9;
            a a10;
            a a11;
            h = a11 = new a("UNKNOWN", 0, 0);
            i = a10 = new a("INVALID_DATA_SOURCE", 1, 1);
            j = a9 = new a("EXTREME_LOW", 2, 2);
            k = a8 = new a("VERY_LOW", 3, 3);
            l = a7 = new a("LOW", 4, 4);
            m = a6 = new a("MID", 5, 5);
            n = a5 = new a("MID_PLUS", 6, 6);
            o = a4 = new a("HIGH", 7, 7);
            p = a3 = new a("VERY_HIGH", 8, 8);
            q = a2 = new a("EXTREME_HIGH", 9, 9);
            r = new a[]{a11, a10, a9, a8, a7, a6, a5, a4, a3, a2};
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private a() {
            void var3_2;
            void var2_-1;
            void var1_-1;
            this.g = var3_2;
        }

        public static a d(int n2) {
            for (a a2 : k1.a$a.values()) {
                if (a2.g != n2) continue;
                return a2;
            }
            return null;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])r.clone();
        }

        public int e() {
            return this.g;
        }
    }

    public static final class b
    extends Enum {
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        public static final /* enum */ b j;
        public static final /* enum */ b k;
        public static final /* enum */ b l;
        public static final /* enum */ b m;
        public static final /* enum */ b n;
        public static final /* enum */ b o;
        public static final /* enum */ b p;
        public static final /* enum */ b q;
        private static final b[] r;
        private final int g;

        static {
            b b2;
            b b3;
            b b4;
            b b5;
            b b6;
            b b7;
            b b8;
            b b9;
            b b10;
            b b11;
            h = b11 = new b("UNKNOWN", 0, 0);
            i = b10 = new b("INVALID_DATA_SOURCE", 1, 1);
            j = b9 = new b("EXTREME_LOW", 2, 2);
            k = b8 = new b("VERY_LOW", 3, 3);
            l = b7 = new b("LOW", 4, 4);
            m = b6 = new b("MID", 5, 5);
            n = b5 = new b("MID_PLUS", 6, 6);
            o = b4 = new b("HIGH", 7, 7);
            p = b3 = new b("VERY_HIGH", 8, 8);
            q = b2 = new b("EXTREME_HIGH", 9, 9);
            r = new b[]{b11, b10, b9, b8, b7, b6, b5, b4, b3, b2};
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private b() {
            void var3_2;
            void var2_-1;
            void var1_-1;
            this.g = var3_2;
        }

        public static b d(int n2) {
            for (b b2 : k1.a$b.values()) {
                if (b2.g != n2) continue;
                return b2;
            }
            return null;
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])r.clone();
        }
    }

    public static final class c
    extends Enum {
        public static final /* enum */ c h;
        public static final /* enum */ c i;
        public static final /* enum */ c j;
        public static final /* enum */ c k;
        public static final /* enum */ c l;
        public static final /* enum */ c m;
        public static final /* enum */ c n;
        public static final /* enum */ c o;
        private static final c[] p;
        private final int g;

        static {
            c c2;
            c c3;
            c c4;
            c c5;
            c c6;
            c c7;
            c c8;
            c c9;
            h = c9 = new c("UNKNOWN", 0, 0);
            i = c8 = new c("INVALID_DATA_SOURCE", 1, 1);
            j = c7 = new c("EXTREME_LOW", 2, 2);
            k = c6 = new c("LOW", 3, 3);
            l = c5 = new c("MID", 4, 4);
            m = c4 = new c("MID_PLUS", 5, 5);
            n = c3 = new c("HIGH", 6, 6);
            o = c2 = new c("EXTREME_HIGH", 7, 7);
            p = new c[]{c9, c8, c7, c6, c5, c4, c3, c2};
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private c() {
            void var3_2;
            void var2_-1;
            void var1_-1;
            this.g = var3_2;
        }

        public static c d(int n2) {
            for (c c2 : k1.a$c.values()) {
                if (c2.g != n2) continue;
                return c2;
            }
            return null;
        }

        public static c valueOf(String string) {
            return (c)Enum.valueOf(c.class, (String)string);
        }

        public static c[] values() {
            return (c[])p.clone();
        }
    }
}

