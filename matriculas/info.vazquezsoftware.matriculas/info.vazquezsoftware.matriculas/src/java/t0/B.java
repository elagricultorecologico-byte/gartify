/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
package t0;

import android.os.Build;
import t0.c;
import t0.k;

public final class b {
    public static final b i = new a().a();
    private k a = k.g;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private long f = -1L;
    private long g = -1L;
    private c h = new c();

    public b() {
    }

    b(a a2) {
        this.b = a2.a;
        int n2 = Build.VERSION.SDK_INT;
        this.c = a2.b;
        this.a = a2.c;
        this.d = a2.d;
        this.e = a2.e;
        if (n2 >= 24) {
            this.h = a2.h;
            this.f = a2.f;
            this.g = a2.g;
        }
    }

    public b(b b2) {
        this.b = b2.b;
        this.c = b2.c;
        this.a = b2.a;
        this.d = b2.d;
        this.e = b2.e;
        this.h = b2.h;
    }

    public c a() {
        return this.h;
    }

    public k b() {
        return this.a;
    }

    public long c() {
        return this.f;
    }

    public long d() {
        return this.g;
    }

    public boolean e() {
        return this.h.c() > 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && b.class == object.getClass()) {
            object = (b)object;
            if (this.b != ((b)object).b) {
                return false;
            }
            if (this.c != ((b)object).c) {
                return false;
            }
            if (this.d != ((b)object).d) {
                return false;
            }
            if (this.e != ((b)object).e) {
                return false;
            }
            if (this.f != ((b)object).f) {
                return false;
            }
            if (this.g != ((b)object).g) {
                return false;
            }
            if (this.a != ((b)object).a) {
                return false;
            }
            return this.h.equals(((b)object).h);
        }
        return false;
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.c;
    }

    public int hashCode() {
        int n2 = this.a.hashCode();
        int n3 = this.b;
        int n4 = this.c;
        int n5 = this.d;
        int n6 = this.e;
        long l2 = this.f;
        int n7 = (int)(l2 ^ l2 >>> 32);
        l2 = this.g;
        return ((((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + (int)(l2 ^ l2 >>> 32)) * 31 + this.h.hashCode();
    }

    public boolean i() {
        return this.e;
    }

    public void j(c c3) {
        this.h = c3;
    }

    public void k(k k2) {
        this.a = k2;
    }

    public void l(boolean bl) {
        this.d = bl;
    }

    public void m(boolean bl) {
        this.b = bl;
    }

    public void n(boolean bl) {
        this.c = bl;
    }

    public void o(boolean bl) {
        this.e = bl;
    }

    public void p(long l2) {
        this.f = l2;
    }

    public void q(long l2) {
        this.g = l2;
    }

    public static final class a {
        boolean a = false;
        boolean b = false;
        k c = k.g;
        boolean d = false;
        boolean e = false;
        long f = -1L;
        long g = -1L;
        c h = new c();

        public b a() {
            return new b(this);
        }

        public a b(k k2) {
            this.c = k2;
            return this;
        }
    }
}

