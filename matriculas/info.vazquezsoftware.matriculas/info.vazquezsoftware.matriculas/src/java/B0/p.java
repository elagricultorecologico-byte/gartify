/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.b
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  t0.a
 *  t0.b
 *  t0.j
 *  t0.n
 *  t0.s
 */
package B0;

import n.a;
import t0.j;
import t0.n;
import t0.s;

public final class p {
    private static final String s = t0.j.f((String)"WorkSpec");
    public static final a t = new a(){};
    public String a;
    public s b = t0.s.g;
    public String c;
    public String d;
    public androidx.work.b e;
    public androidx.work.b f;
    public long g;
    public long h;
    public long i;
    public t0.b j;
    public int k;
    public t0.a l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;
    public n r;

    public p(p p2) {
        androidx.work.b b2;
        this.e = b2 = androidx.work.b.c;
        this.f = b2;
        this.j = t0.b.i;
        this.l = t0.a.g;
        this.m = 30000L;
        this.p = -1L;
        this.r = t0.n.g;
        this.a = p2.a;
        this.c = p2.c;
        this.b = p2.b;
        this.d = p2.d;
        this.e = new androidx.work.b(p2.e);
        this.f = new androidx.work.b(p2.f);
        this.g = p2.g;
        this.h = p2.h;
        this.i = p2.i;
        this.j = new t0.b(p2.j);
        this.k = p2.k;
        this.l = p2.l;
        this.m = p2.m;
        this.n = p2.n;
        this.o = p2.o;
        this.p = p2.p;
        this.q = p2.q;
        this.r = p2.r;
    }

    public p(String string, String string2) {
        androidx.work.b b2;
        this.e = b2 = androidx.work.b.c;
        this.f = b2;
        this.j = t0.b.i;
        this.l = t0.a.g;
        this.m = 30000L;
        this.p = -1L;
        this.r = t0.n.g;
        this.a = string;
        this.c = string2;
    }

    public long a() {
        if (this.c()) {
            long l2 = this.l == t0.a.h ? this.m * (long)this.k : (long)Math.scalb((float)this.m, (int)(this.k - 1));
            return this.n + Math.min((long)18000000L, (long)l2);
        }
        boolean bl = this.d();
        long l3 = 0L;
        if (bl) {
            long l4 = System.currentTimeMillis();
            long l5 = this.n;
            l4 = l5 == 0L ? (l4 += this.g) : l5;
            long l6 = this.i;
            long l7 = this.h;
            if (l6 != l7) {
                if (l5 == 0L) {
                    l3 = l6 * -1L;
                }
                return l4 + l7 + l3;
            }
            if (l5 != 0L) {
                l3 = l7;
            }
            return l4 + l3;
        }
        long l8 = l3 = this.n;
        if (l3 == 0L) {
            l8 = System.currentTimeMillis();
        }
        return l8 + this.g;
    }

    public boolean b() {
        return t0.b.i.equals((Object)this.j) ^ true;
    }

    public boolean c() {
        return this.b == t0.s.g && this.k > 0;
    }

    public boolean d() {
        return this.h != 0L;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && p.class == object.getClass()) {
            object = (p)object;
            if (this.g != ((p)object).g) {
                return false;
            }
            if (this.h != ((p)object).h) {
                return false;
            }
            if (this.i != ((p)object).i) {
                return false;
            }
            if (this.k != ((p)object).k) {
                return false;
            }
            if (this.m != ((p)object).m) {
                return false;
            }
            if (this.n != ((p)object).n) {
                return false;
            }
            if (this.o != ((p)object).o) {
                return false;
            }
            if (this.p != ((p)object).p) {
                return false;
            }
            if (this.q != ((p)object).q) {
                return false;
            }
            if (!this.a.equals((Object)((p)object).a)) {
                return false;
            }
            if (this.b != ((p)object).b) {
                return false;
            }
            if (!this.c.equals((Object)((p)object).c)) {
                return false;
            }
            String string = this.d;
            if (string != null ? !string.equals((Object)((p)object).d) : ((p)object).d != null) {
                return false;
            }
            if (!this.e.equals((Object)((p)object).e)) {
                return false;
            }
            if (!this.f.equals((Object)((p)object).f)) {
                return false;
            }
            if (!this.j.equals((Object)((p)object).j)) {
                return false;
            }
            if (this.l != ((p)object).l) {
                return false;
            }
            if (this.r == ((p)object).r) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n2 = this.a.hashCode();
        int n3 = this.b.hashCode();
        int n4 = this.c.hashCode();
        String string = this.d;
        int n5 = string != null ? string.hashCode() : 0;
        int n6 = this.e.hashCode();
        int n7 = this.f.hashCode();
        long l2 = this.g;
        int n8 = (int)(l2 ^ l2 >>> 32);
        l2 = this.h;
        int n9 = (int)(l2 ^ l2 >>> 32);
        l2 = this.i;
        int n10 = (int)(l2 ^ l2 >>> 32);
        int n11 = this.j.hashCode();
        int n12 = this.k;
        int n13 = this.l.hashCode();
        l2 = this.m;
        int n14 = (int)(l2 ^ l2 >>> 32);
        l2 = this.n;
        int n15 = (int)(l2 ^ l2 >>> 32);
        l2 = this.o;
        int n16 = (int)(l2 ^ l2 >>> 32);
        l2 = this.p;
        return ((((((((((((((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n12) * 31 + n13) * 31 + n14) * 31 + n15) * 31 + n16) * 31 + (int)(l2 ^ l2 >>> 32)) * 31 + this.q) * 31 + this.r.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{WorkSpec: ");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class b {
        public String a;
        public s b;

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof b)) {
                return false;
            }
            object = (b)object;
            if (this.b != ((b)object).b) {
                return false;
            }
            return this.a.equals((Object)((b)object).a);
        }

        public int hashCode() {
            return this.a.hashCode() * 31 + this.b.hashCode();
        }
    }
}

