/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 */
package z3;

import I2.i;
import V2.g;
import V2.k;
import z3.t;

public final class s {
    public static final a h = new a(null);
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public s f;
    public s g;

    public s() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public s(byte[] byArray, int n2, int n3, boolean bl, boolean bl2) {
        k.e(byArray, "data");
        this.a = byArray;
        this.b = n2;
        this.c = n3;
        this.d = bl;
        this.e = bl2;
    }

    public final void a() {
        block5: {
            int n2;
            s s2;
            block7: {
                block6: {
                    s2 = this.g;
                    int n3 = 0;
                    int n4 = s2 != this ? 1 : 0;
                    if (n4 == 0) break block5;
                    k.b(s2);
                    if (!s2.e) break block6;
                    n2 = this.c - this.b;
                    s2 = this.g;
                    k.b(s2);
                    int n5 = s2.c;
                    s2 = this.g;
                    k.b(s2);
                    if (s2.d) {
                        n4 = n3;
                    } else {
                        s2 = this.g;
                        k.b(s2);
                        n4 = s2.b;
                    }
                    if (n2 <= 8192 - n5 + n4) break block7;
                }
                return;
            }
            s2 = this.g;
            k.b(s2);
            this.f(s2, n2);
            this.b();
            t.b(this);
            return;
        }
        throw new IllegalStateException("cannot compact");
    }

    public final s b() {
        s s2 = this.f;
        if (s2 == this) {
            s2 = null;
        }
        s s3 = this.g;
        k.b(s3);
        s3.f = this.f;
        s3 = this.f;
        k.b(s3);
        s3.g = this.g;
        this.f = null;
        this.g = null;
        return s2;
    }

    public final s c(s s2) {
        k.e(s2, "segment");
        s2.g = this;
        s2.f = this.f;
        s s3 = this.f;
        k.b(s3);
        s3.g = s2;
        this.f = s2;
        return s2;
    }

    public final s d() {
        this.d = true;
        return new s(this.a, this.b, this.c, true, false);
    }

    public final s e(int n2) {
        int n3 = n2 > 0 && n2 <= this.c - this.b ? 1 : 0;
        if (n3 != 0) {
            Object object;
            s s2;
            if (n2 >= 1024) {
                s2 = this.d();
            } else {
                s2 = t.c();
                byte[] byArray = this.a;
                object = s2.a;
                n3 = this.b;
                i.h(byArray, (byte[])object, 0, n3, n3 + n2, 2, null);
            }
            s2.c = s2.b + n2;
            this.b += n2;
            object = this.g;
            k.b(object);
            ((s)object).c(s2);
            return s2;
        }
        throw new IllegalArgumentException("byteCount out of range");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void f(s s2, int n2) {
        byte[] byArray;
        int n3;
        k.e(s2, "sink");
        if (!s2.e) throw new IllegalStateException("only owner can write");
        int n4 = s2.c;
        if (n4 + n2 > 8192) {
            if (s2.d) throw new IllegalArgumentException();
            n3 = s2.b;
            if (n4 + n2 - n3 > 8192) throw new IllegalArgumentException();
            byArray = s2.a;
            i.h(byArray, byArray, 0, n3, n4, 2, null);
            s2.c -= s2.b;
            s2.b = 0;
        }
        byte[] byArray2 = this.a;
        byArray = s2.a;
        n3 = s2.c;
        n4 = this.b;
        i.d(byArray2, byArray, n3, n4, n4 + n2);
        s2.c += n2;
        this.b += n2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }
}

