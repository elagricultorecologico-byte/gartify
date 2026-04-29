/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package u3;

import V2.g;

public final class b
extends Enum {
    public static final a h;
    public static final /* enum */ b i;
    public static final /* enum */ b j;
    public static final /* enum */ b k;
    public static final /* enum */ b l;
    public static final /* enum */ b m;
    public static final /* enum */ b n;
    public static final /* enum */ b o;
    public static final /* enum */ b p;
    public static final /* enum */ b q;
    public static final /* enum */ b r;
    public static final /* enum */ b s;
    public static final /* enum */ b t;
    public static final /* enum */ b u;
    public static final /* enum */ b v;
    private static final b[] w;
    private final int g;

    static {
        i = new b("NO_ERROR", 0, 0);
        j = new b("PROTOCOL_ERROR", 1, 1);
        k = new b("INTERNAL_ERROR", 2, 2);
        l = new b("FLOW_CONTROL_ERROR", 3, 3);
        m = new b("SETTINGS_TIMEOUT", 4, 4);
        n = new b("STREAM_CLOSED", 5, 5);
        o = new b("FRAME_SIZE_ERROR", 6, 6);
        p = new b("REFUSED_STREAM", 7, 7);
        q = new b("CANCEL", 8, 8);
        r = new b("COMPRESSION_ERROR", 9, 9);
        s = new b("CONNECT_ERROR", 10, 10);
        t = new b("ENHANCE_YOUR_CALM", 11, 11);
        u = new b("INADEQUATE_SECURITY", 12, 12);
        v = new b("HTTP_1_1_REQUIRED", 13, 13);
        w = b.d();
        h = new a(null);
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

    private static final /* synthetic */ b[] d() {
        return new b[]{i, j, k, l, m, n, o, p, q, r, s, t, u, v};
    }

    public static b valueOf(String string) {
        return (b)Enum.valueOf(b.class, (String)string);
    }

    public static b[] values() {
        return (b[])w.clone();
    }

    public final int e() {
        return this.g;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final b a(int n2) {
            for (b b2 : b.values()) {
                if (b2.e() != n2) continue;
                return b2;
            }
            return null;
        }
    }
}

