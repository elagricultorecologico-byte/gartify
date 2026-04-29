/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package t3;

import V2.g;
import V2.k;
import m3.s;
import z3.d;

public final class a {
    public static final a c = new a(null);
    private final d a;
    private long b;

    public a(d d2) {
        k.e(d2, "source");
        this.a = d2;
        this.b = 262144L;
    }

    public final s a() {
        s.a a2 = new s.a();
        String string;
        while ((string = this.b()).length() != 0) {
            a2.b(string);
        }
        return a2.d();
    }

    public final String b() {
        String string = this.a.d0(this.b);
        this.b -= (long)string.length();
        return string;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }
}

