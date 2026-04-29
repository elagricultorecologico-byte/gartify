/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URL
 *  java.util.Collection
 *  java.util.Map
 */
package C3;

import F3.f;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

public interface a {
    public a a(String var1);

    public a b(int var1);

    public f get();

    public static interface a {
        public Map a();

        public a d(String var1, String var2);

        public URL e();

        public String f(String var1);

        public a i(URL var1);
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
        private static final b[] p;
        private final boolean g;

        static {
            b b2;
            b b3;
            b b4;
            b b5;
            b b6;
            b b7;
            b b8;
            b b9;
            h = b9 = new b("GET", 0, false);
            i = b8 = new b("POST", 1, true);
            j = b7 = new b("PUT", 2, true);
            k = b6 = new b("DELETE", 3, false);
            l = b5 = new b("PATCH", 4, true);
            m = b4 = new b("HEAD", 5, false);
            n = b3 = new b("OPTIONS", 6, false);
            o = b2 = new b("TRACE", 7, false);
            p = new b[]{b9, b8, b7, b6, b5, b4, b3, b2};
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

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])p.clone();
        }

        public final boolean d() {
            return this.g;
        }
    }

    public static interface c
    extends a {
        public String b();

        public String g();

        public Collection h();
    }

    public static interface d
    extends a {
        public f c();
    }
}

