/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package m3;

import V2.g;
import V2.k;
import java.io.IOException;

public final class x
extends Enum {
    public static final a h;
    public static final /* enum */ x i;
    public static final /* enum */ x j;
    public static final /* enum */ x k;
    public static final /* enum */ x l;
    public static final /* enum */ x m;
    public static final /* enum */ x n;
    private static final x[] o;
    private final String g;

    static {
        i = new x("HTTP_1_0", 0, "http/1.0");
        j = new x("HTTP_1_1", 1, "http/1.1");
        k = new x("SPDY_3", 2, "spdy/3.1");
        l = new x("HTTP_2", 3, "h2");
        m = new x("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        n = new x("QUIC", 5, "quic");
        o = x.d();
        h = new a(null);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private x() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.g = var3_2;
    }

    private static final /* synthetic */ x[] d() {
        return new x[]{i, j, k, l, m, n};
    }

    public static x valueOf(String string) {
        return (x)Enum.valueOf(x.class, (String)string);
    }

    public static x[] values() {
        return (x[])o.clone();
    }

    public String toString() {
        return this.g;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final x a(String string) {
            V2.k.e(string, "protocol");
            x x2 = i;
            if (V2.k.a(string, x2.g)) {
                return x2;
            }
            x2 = j;
            if (V2.k.a(string, x2.g)) {
                return x2;
            }
            x2 = m;
            if (V2.k.a(string, x2.g)) {
                return x2;
            }
            x2 = l;
            if (V2.k.a(string, x2.g)) {
                return x2;
            }
            x2 = k;
            if (V2.k.a(string, x2.g)) {
                return x2;
            }
            x2 = n;
            if (V2.k.a(string, x2.g)) {
                return x2;
            }
            throw new IOException(V2.k.j("Unexpected protocol: ", string));
        }
    }
}

