/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 */
package u3;

import V2.g;
import V2.k;

public final class m {
    public static final a c = new a(null);
    private int a;
    private final int[] b = new int[10];

    public final int a(int n2) {
        return this.b[n2];
    }

    public final int b() {
        if ((this.a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    public final int c() {
        if ((this.a & 0x80) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    public final int d() {
        if ((this.a & 0x10) != 0) {
            return this.b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int e(int n2) {
        if ((this.a & 0x20) != 0) {
            n2 = this.b[5];
        }
        return n2;
    }

    public final boolean f(int n2) {
        return (1 << n2 & this.a) != 0;
    }

    public final void g(m m2) {
        k.e(m2, "other");
        for (int i2 = 0; i2 < 10; ++i2) {
            if (!m2.f(i2)) continue;
            this.h(i2, m2.a(i2));
        }
    }

    public final m h(int n2, int n3) {
        int[] nArray;
        if (n2 >= 0 && n2 < (nArray = this.b).length) {
            this.a = 1 << n2 | this.a;
            nArray[n2] = n3;
        }
        return this;
    }

    public final int i() {
        return Integer.bitCount((int)this.a);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }
}

