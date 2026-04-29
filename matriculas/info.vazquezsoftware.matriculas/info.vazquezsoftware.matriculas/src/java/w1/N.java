/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package w1;

import L1.j;
import u1.d;
import v1.a;
import w1.P;
import w1.Q;
import w1.l;

public abstract class n {
    private final d[] a;
    private final boolean b;
    private final int c;

    protected n(d[] dArray, boolean bl, int n2) {
        boolean bl2;
        this.a = dArray;
        boolean bl3 = bl2 = false;
        if (dArray != null) {
            bl3 = bl2;
            if (bl) {
                bl3 = true;
            }
        }
        this.b = bl3;
        this.c = n2;
    }

    public static a a() {
        return new a(null);
    }

    protected abstract void b(a.b var1, j var2);

    public boolean c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final d[] e() {
        return this.a;
    }

    public static class a {
        private l a;
        private boolean b = true;
        private d[] c;
        private int d = 0;

        /* synthetic */ a(Q q2) {
        }

        static /* bridge */ /* synthetic */ l f(a a2) {
            return a2.a;
        }

        public n a() {
            boolean bl = this.a != null;
            x1.n.b(bl, "execute parameter required");
            return new P(this, this.c, this.b, this.d);
        }

        public a b(l l2) {
            this.a = l2;
            return this;
        }

        public a c(boolean bl) {
            this.b = bl;
            return this;
        }

        public a d(d ... dArray) {
            this.c = dArray;
            return this;
        }

        public a e(int n2) {
            this.d = n2;
            return this;
        }
    }
}

