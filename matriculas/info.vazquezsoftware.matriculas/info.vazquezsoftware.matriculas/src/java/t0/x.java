/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  b1.U1
 *  java.lang.Object
 */
package T0;

import b1.U1;

public final class x {
    private final boolean a;
    private final boolean b;
    private final boolean c;

    /* synthetic */ x(a a2, byte[] byArray) {
        this.a = a2.e();
        this.b = a2.f();
        this.c = a2.g();
    }

    public x(U1 u1) {
        this.a = u1.g;
        this.b = u1.h;
        this.c = u1.i;
    }

    public boolean a() {
        return this.c;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.a;
    }

    public static final class a {
        private boolean a = true;
        private boolean b = false;
        private boolean c = false;

        public x a() {
            return new x(this, null);
        }

        public a b(boolean bl) {
            this.c = bl;
            return this;
        }

        public a c(boolean bl) {
            this.b = bl;
            return this;
        }

        public a d(boolean bl) {
            this.a = bl;
            return this;
        }

        final /* synthetic */ boolean e() {
            return this.a;
        }

        final /* synthetic */ boolean f() {
            return this.b;
        }

        final /* synthetic */ boolean g() {
            return this.c;
        }
    }
}

