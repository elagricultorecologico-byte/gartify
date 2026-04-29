/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Arrays
 *  java.util.HashMap
 */
package r;

import java.util.Arrays;
import java.util.HashMap;
import r.c;
import r.e;
import r.h;
import r.i;
import r.j;
import u.d;

public class d {
    public static boolean s = false;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = true;
    public static boolean w;
    public static long x;
    public static long y;
    private int a = 1000;
    public boolean b = false;
    int c = 0;
    private HashMap d = null;
    private a e;
    private int f = 32;
    private int g = 32;
    r.b[] h;
    public boolean i = false;
    public boolean j = false;
    private boolean[] k = new boolean[32];
    int l = 1;
    int m = 0;
    private int n = 32;
    final c o;
    private i[] p = new i[1000];
    private int q = 0;
    private a r;

    public d() {
        c c3;
        this.h = new r.b[32];
        this.D();
        this.o = c3 = new c();
        this.e = new h(c3);
        if (w) {
            this.r = new b(c3);
            return;
        }
        this.r = new r.b(c3);
    }

    private int C(a a2, boolean bl) {
        int n2;
        for (n2 = 0; n2 < this.l; ++n2) {
            this.k[n2] = false;
        }
        boolean bl2 = false;
        n2 = 0;
        while (!bl2) {
            Object object;
            i i2;
            int n3;
            block16: {
                block17: {
                    block15: {
                        n3 = n2 + 1;
                        if (n3 >= this.l * 2) break block15;
                        if (a2.getKey() != null) {
                            this.k[a2.getKey().i] = true;
                        }
                        if ((i2 = a2.c(this, this.k)) == null) break block16;
                        object = this.k;
                        n2 = i2.i;
                        if (!object[n2]) break block17;
                    }
                    return n3;
                }
                object[n2] = true;
            }
            if (i2 != null) {
                float f2 = Float.MAX_VALUE;
                int n4 = -1;
                for (n2 = 0; n2 < this.m; ++n2) {
                    int n5;
                    float f3;
                    object = this.h[n2];
                    if (object.a.p == i.a.g) {
                        f3 = f2;
                        n5 = n4;
                    } else if (object.f) {
                        f3 = f2;
                        n5 = n4;
                    } else {
                        f3 = f2;
                        n5 = n4;
                        if (object.t(i2)) {
                            float f4 = object.e.c(i2);
                            f3 = f2;
                            n5 = n4;
                            if (f4 < 0.0f) {
                                f4 = -object.b / f4;
                                f3 = f2;
                                n5 = n4;
                                if (f4 < f2) {
                                    n5 = n2;
                                    f3 = f4;
                                }
                            }
                        }
                    }
                    f2 = f3;
                    n4 = n5;
                }
                n2 = n3;
                if (n4 <= -1) continue;
                object = this.h[n4];
                object.a.j = -1;
                object.x(i2);
                i2 = object.a;
                i2.j = n4;
                i2.l(this, (r.b)object);
                n2 = n3;
                continue;
            }
            bl2 = true;
            n2 = n3;
        }
        return n2;
    }

    private void D() {
        int n2;
        boolean bl = w;
        int n3 = 0;
        if (bl) {
            for (n2 = n3; n2 < this.m; ++n2) {
                r.b b2 = this.h[n2];
                if (b2 != null) {
                    this.o.a.a(b2);
                }
                this.h[n2] = null;
            }
        } else {
            for (n2 = 0; n2 < this.m; ++n2) {
                r.b b3 = this.h[n2];
                if (b3 != null) {
                    this.o.b.a(b3);
                }
                this.h[n2] = null;
            }
        }
    }

    private i a(i.a object, String iArray) {
        i i2 = (i)this.o.c.b();
        if (i2 == null) {
            i2 = new i((i.a)((Object)object), (String)iArray);
            i2.j((i.a)((Object)object), (String)iArray);
            object = i2;
        } else {
            i2.h();
            i2.j((i.a)((Object)object), (String)iArray);
            object = i2;
        }
        int n2 = this.q;
        int n3 = this.a;
        if (n2 >= n3) {
            this.a = n3 *= 2;
            this.p = (i[])Arrays.copyOf((Object[])this.p, (int)n3);
        }
        iArray = this.p;
        n3 = this.q;
        this.q = n3 + 1;
        iArray[n3] = object;
        return object;
    }

    private void l(r.b object) {
        int n2;
        Object object2;
        if (u && ((r.b)object).f) {
            ((r.b)object).a.i(this, ((r.b)object).b);
        } else {
            object2 = this.h;
            n2 = this.m;
            object2[n2] = object;
            object2 = ((r.b)object).a;
            ((i)object2).j = n2;
            this.m = n2 + 1;
            ((i)object2).l(this, (r.b)object);
        }
        if (u && this.b) {
            n2 = 0;
            while (n2 < this.m) {
                if (this.h[n2] == null) {
                    System.out.println("WTF");
                }
                object = this.h[n2];
                int n3 = n2;
                if (object != null) {
                    n3 = n2;
                    if (((r.b)object).f) {
                        int n4;
                        ((r.b)object).a.i(this, ((r.b)object).b);
                        if (w) {
                            this.o.a.a(object);
                        } else {
                            this.o.b.a(object);
                        }
                        this.h[n2] = null;
                        int n5 = n3 = n2 + 1;
                        while (n3 < (n4 = this.m)) {
                            object2 = this.h;
                            n5 = n3 - 1;
                            object2[n5] = object = object2[n3];
                            object = ((r.b)object).a;
                            if (((i)object).j == n3) {
                                ((i)object).j = n5;
                            }
                            n5 = n3++;
                        }
                        if (n5 < n4) {
                            this.h[n5] = null;
                        }
                        this.m = n4 - 1;
                        n3 = n2 - 1;
                    }
                }
                n2 = n3 + 1;
            }
            this.b = false;
        }
    }

    private void n() {
        for (int i2 = 0; i2 < this.m; ++i2) {
            r.b b2 = this.h[i2];
            b2.a.l = b2.b;
        }
    }

    public static r.b s(d d3, i i2, i i3, float f2) {
        return d3.r().j(i2, i3, f2);
    }

    private int u(a object) {
        for (int i2 = 0; i2 < this.m; ++i2) {
            object = this.h[i2];
            if (((r.b)object).a.p == i.a.g) continue;
            float f2 = ((r.b)object).b;
            float f3 = 0.0f;
            if (!(f2 < 0.0f)) continue;
            boolean bl = false;
            i2 = 0;
            while (!bl) {
                Object object2;
                int n2 = i2 + 1;
                f2 = Float.MAX_VALUE;
                int n3 = 0;
                i2 = -1;
                int n4 = -1;
                int n5 = 0;
                while (true) {
                    int n6;
                    int n7;
                    float f4;
                    int n8;
                    block24: {
                        int n9;
                        float f5;
                        int n10;
                        block19: {
                            block17: {
                                block18: {
                                    block16: {
                                        n10 = this.m;
                                        n8 = 1;
                                        if (n3 >= n10) break;
                                        object = this.h[n3];
                                        if (((r.b)object).a.p != i.a.g) break block16;
                                        f5 = f3;
                                        f4 = f2;
                                        n7 = i2;
                                        n6 = n4;
                                        n10 = n5;
                                        break block17;
                                    }
                                    if (!((r.b)object).f) break block18;
                                    f5 = f3;
                                    f4 = f2;
                                    n7 = i2;
                                    n6 = n4;
                                    n10 = n5;
                                    break block17;
                                }
                                f5 = f3;
                                f4 = f2;
                                n7 = i2;
                                n6 = n4;
                                n10 = n5;
                                if (!(((r.b)object).b < f3)) break block17;
                                if (!v) break block19;
                                int n11 = ((r.b)object).e.f();
                                n8 = 0;
                                while (true) {
                                    block21: {
                                        block20: {
                                            f5 = f3;
                                            f4 = f2;
                                            n7 = i2;
                                            n6 = n4;
                                            n10 = n5;
                                            if (n8 >= n11) break;
                                            object2 = ((r.b)object).e.h(n8);
                                            f5 = ((r.b)object).e.c((i)object2);
                                            if (!(f5 <= f3)) break block20;
                                            f4 = f2;
                                            n6 = i2;
                                            n9 = n4;
                                            n7 = n5;
                                            break block21;
                                        }
                                        n6 = 0;
                                        n10 = i2;
                                        i2 = n6;
                                        while (true) {
                                            block23: {
                                                block22: {
                                                    f4 = f2;
                                                    n6 = n10;
                                                    n9 = n4;
                                                    n7 = n5;
                                                    if (i2 >= 9) break;
                                                    f4 = ((i)object2).n[i2] / f5;
                                                    if (f4 < f2 && i2 == n5) break block22;
                                                    n6 = n5;
                                                    if (i2 <= n5) break block23;
                                                }
                                                n4 = ((i)object2).i;
                                                n6 = i2;
                                                n10 = n3;
                                                f2 = f4;
                                            }
                                            ++i2;
                                            n5 = n6;
                                        }
                                    }
                                    ++n8;
                                    f2 = f4;
                                    i2 = n6;
                                    n4 = n9;
                                    n5 = n7;
                                }
                            }
                            f3 = f5;
                            n8 = n7;
                            n7 = n10;
                            break block24;
                        }
                        f5 = f3;
                        n10 = n8;
                        while (true) {
                            block26: {
                                block25: {
                                    f4 = f2;
                                    n8 = i2;
                                    n6 = n4;
                                    n7 = n5;
                                    f3 = f5;
                                    if (n10 >= this.l) break;
                                    object2 = this.o.d[n10];
                                    f4 = ((r.b)object).e.c((i)object2);
                                    if (!(f4 <= f5)) break block25;
                                    f3 = f2;
                                    n8 = i2;
                                    n9 = n4;
                                    n7 = n5;
                                    break block26;
                                }
                                n7 = 0;
                                n6 = i2;
                                i2 = n7;
                                while (true) {
                                    block28: {
                                        block27: {
                                            f3 = f2;
                                            n8 = n6;
                                            n9 = n4;
                                            n7 = n5;
                                            if (i2 >= 9) break;
                                            f3 = ((i)object2).n[i2] / f4;
                                            if (f3 < f2 && i2 == n5) break block27;
                                            n7 = n5;
                                            if (i2 <= n5) break block28;
                                        }
                                        n7 = i2;
                                        n6 = n3;
                                        n4 = n10;
                                        f2 = f3;
                                    }
                                    ++i2;
                                    n5 = n7;
                                }
                            }
                            ++n10;
                            f2 = f3;
                            i2 = n8;
                            n4 = n9;
                            n5 = n7;
                        }
                    }
                    ++n3;
                    f2 = f4;
                    i2 = n8;
                    n4 = n6;
                    n5 = n7;
                }
                if (i2 != -1) {
                    object2 = this.h[i2];
                    ((r.b)object2).a.j = -1;
                    ((r.b)object2).x(this.o.d[n4]);
                    object = ((r.b)object2).a;
                    ((i)object).j = i2;
                    ((i)object).l(this, (r.b)object2);
                } else {
                    bl = true;
                }
                if (n2 > this.l / 2) {
                    bl = true;
                }
                i2 = n2;
            }
            return i2;
        }
        return 0;
    }

    public static e x() {
        return null;
    }

    private void z() {
        int n2;
        this.f = n2 = this.f * 2;
        this.h = (r.b[])Arrays.copyOf((Object[])this.h, (int)n2);
        c c3 = this.o;
        c3.d = (i[])Arrays.copyOf((Object[])c3.d, (int)this.f);
        n2 = this.f;
        this.k = new boolean[n2];
        this.g = n2;
        this.n = n2;
    }

    public void A() {
        if (this.e.isEmpty()) {
            this.n();
            return;
        }
        if (!this.i && !this.j) {
            this.B(this.e);
            return;
        }
        for (int i2 = 0; i2 < this.m; ++i2) {
            if (this.h[i2].f) continue;
            this.B(this.e);
            return;
        }
        this.n();
    }

    void B(a a2) {
        this.u(a2);
        this.C(a2, false);
        this.n();
    }

    public void E() {
        Object object;
        c c3;
        int n2 = 0;
        while (true) {
            c3 = this.o;
            object = c3.d;
            if (n2 >= ((i[])object).length) break;
            if ((object = object[n2]) != null) {
                ((i)object).h();
            }
            ++n2;
        }
        c3.c.c(this.p, this.q);
        this.q = 0;
        Arrays.fill((Object[])this.o.d, null);
        object = this.d;
        if (object != null) {
            object.clear();
        }
        this.c = 0;
        this.e.clear();
        this.l = 1;
        for (n2 = 0; n2 < this.m; ++n2) {
            object = this.h[n2];
            if (object == null) continue;
            ((r.b)object).c = false;
        }
        this.D();
        this.m = 0;
        if (w) {
            this.r = new b(this.o);
            return;
        }
        this.r = new r.b(this.o);
    }

    public void b(u.e object, u.e object2, float f2, int n2) {
        Object object3 = d.a.h;
        i i2 = this.q(((u.e)object).o((d.a)((Object)object3)));
        Object object4 = d.a.i;
        i i3 = this.q(((u.e)object).o((d.a)((Object)object4)));
        Object object5 = d.a.j;
        i i4 = this.q(((u.e)object).o((d.a)((Object)object5)));
        Object object6 = d.a.k;
        object = this.q(((u.e)object).o((d.a)((Object)object6)));
        object3 = this.q(((u.e)object2).o((d.a)((Object)object3)));
        object4 = this.q(((u.e)object2).o((d.a)((Object)object4)));
        object5 = this.q(((u.e)object2).o((d.a)((Object)object5)));
        object6 = this.q(((u.e)object2).o((d.a)((Object)object6)));
        object2 = this.r();
        double d3 = f2;
        double d4 = Math.sin((double)d3);
        double d5 = n2;
        ((r.b)object2).q(i3, (i)object, (i)object4, (i)object6, (float)(d4 * d5));
        this.d((r.b)object2);
        object = this.r();
        ((r.b)object).q(i2, i4, (i)object3, (i)object5, (float)(Math.cos((double)d3) * d5));
        this.d((r.b)object);
    }

    public void c(i i2, i i3, int n2, float f2, i i4, i i5, int n3, int n4) {
        r.b b2 = this.r();
        b2.h(i2, i3, n2, f2, i4, i5, n3);
        if (n4 != 8) {
            b2.d(this, n4);
        }
        this.d(b2);
    }

    /*
     * Unable to fully structure code
     */
    public void d(r.b var1_1) {
        block13: {
            block14: {
                if (var1_1 == null) break block13;
                var2_2 = this.m;
                var3_3 = 1;
                if (var2_2 + 1 >= this.n || this.l + 1 >= this.g) {
                    this.z();
                }
                var4_4 = var1_1.f;
                var2_2 = 0;
                if (var4_4) break block14;
                var1_1.D(this);
                if (var1_1.isEmpty()) break block13;
                var1_1.r();
                if (!var1_1.f(this)) ** GOTO lbl-1000
                var1_1.a = var5_5 = this.p();
                var2_2 = this.m;
                this.l(var1_1);
                if (this.m == var2_2 + 1) {
                    this.r.a(var1_1);
                    this.C(this.r, true);
                    var2_2 = var3_3;
                    if (var5_5.j == -1) {
                        if (var1_1.a == var5_5 && (var5_5 = var1_1.v(var5_5)) != null) {
                            var1_1.x(var5_5);
                        }
                        if (!var1_1.f) {
                            var1_1.a.l(this, var1_1);
                        }
                        if (r.d.w) {
                            this.o.a.a(var1_1);
                        } else {
                            this.o.b.a(var1_1);
                        }
                        --this.m;
                        var2_2 = var3_3;
                    }
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 = 0;
                }
                if (!var1_1.s()) break block13;
            }
            if (var2_2 == 0) {
                this.l(var1_1);
            }
        }
    }

    public r.b e(i i2, i i3, int n2, int n3) {
        if (t && n3 == 8 && i3.m && i2.j == -1) {
            i2.i(this, i3.l + (float)n2);
            return null;
        }
        r.b b2 = this.r();
        b2.n(i2, i3, n2);
        if (n3 != 8) {
            b2.d(this, n3);
        }
        this.d(b2);
        return b2;
    }

    public void f(i i2, int n2) {
        if (t && i2.j == -1) {
            float f2 = n2;
            i2.i(this, f2);
            for (n2 = 0; n2 < this.c + 1; ++n2) {
                i i3 = this.o.d[n2];
                if (i3 == null || !i3.t || i3.u != i2.i) continue;
                i3.i(this, i3.v + f2);
            }
            return;
        }
        int n3 = i2.j;
        if (n3 != -1) {
            r.b b2 = this.h[n3];
            if (b2.f) {
                b2.b = n2;
                return;
            }
            if (b2.e.f() == 0) {
                b2.f = true;
                b2.b = n2;
                return;
            }
            b2 = this.r();
            b2.m(i2, n2);
            this.d(b2);
            return;
        }
        r.b b3 = this.r();
        b3.i(i2, n2);
        this.d(b3);
    }

    public void g(i i2, i i3, int n2, boolean bl) {
        r.b b2 = this.r();
        i i4 = this.t();
        i4.k = 0;
        b2.o(i2, i3, i4, n2);
        this.d(b2);
    }

    public void h(i i2, i i3, int n2, int n3) {
        r.b b2 = this.r();
        i i4 = this.t();
        i4.k = 0;
        b2.o(i2, i3, i4, n2);
        if (n3 != 8) {
            this.m(b2, (int)(b2.e.c(i4) * -1.0f), n3);
        }
        this.d(b2);
    }

    public void i(i i2, i i3, int n2, boolean bl) {
        r.b b2 = this.r();
        i i4 = this.t();
        i4.k = 0;
        b2.p(i2, i3, i4, n2);
        this.d(b2);
    }

    public void j(i i2, i i3, int n2, int n3) {
        r.b b2 = this.r();
        i i4 = this.t();
        i4.k = 0;
        b2.p(i2, i3, i4, n2);
        if (n3 != 8) {
            this.m(b2, (int)(b2.e.c(i4) * -1.0f), n3);
        }
        this.d(b2);
    }

    public void k(i i2, i i3, i i4, i i5, float f2, int n2) {
        r.b b2 = this.r();
        b2.k(i2, i3, i4, i5, f2);
        if (n2 != 8) {
            b2.d(this, n2);
        }
        this.d(b2);
    }

    void m(r.b b2, int n2, int n3) {
        b2.e(this.o(n3, null), n2);
    }

    public i o(int n2, String object) {
        int n3;
        if (this.l + 1 >= this.g) {
            this.z();
        }
        object = this.a(i.a.j, (String)object);
        this.c = n3 = this.c + 1;
        ++this.l;
        ((i)object).i = n3;
        ((i)object).k = n2;
        this.o.d[n3] = object;
        this.e.b((i)object);
        return object;
    }

    public i p() {
        int n2;
        if (this.l + 1 >= this.g) {
            this.z();
        }
        i i2 = this.a(i.a.i, null);
        this.c = n2 = this.c + 1;
        ++this.l;
        i2.i = n2;
        this.o.d[n2] = i2;
        return i2;
    }

    public i q(Object object) {
        Object object2 = null;
        if (object == null) {
            return null;
        }
        if (this.l + 1 >= this.g) {
            this.z();
        }
        if (object instanceof u.d) {
            int n2;
            u.d d3 = (u.d)object;
            object = object2 = d3.i();
            if (object2 == null) {
                d3.s(this.o);
                object = d3.i();
            }
            if ((n2 = ((i)object).i) != -1 && n2 <= this.c && this.o.d[n2] != null) {
                return object;
            }
            if (n2 != -1) {
                ((i)object).h();
            }
            this.c = n2 = this.c + 1;
            ++this.l;
            ((i)object).i = n2;
            ((i)object).p = i.a.g;
            this.o.d[n2] = object;
            object2 = object;
        }
        return object2;
    }

    public r.b r() {
        r.b b2;
        if (w) {
            b2 = (r.b)this.o.a.b();
            if (b2 == null) {
                b2 = new b(this.o);
                ++y;
            } else {
                b2.y();
            }
        } else {
            b2 = (r.b)this.o.b.b();
            if (b2 == null) {
                b2 = new r.b(this.o);
                ++x;
            } else {
                b2.y();
            }
        }
        r.i.f();
        return b2;
    }

    public i t() {
        int n2;
        if (this.l + 1 >= this.g) {
            this.z();
        }
        i i2 = this.a(i.a.i, null);
        this.c = n2 = this.c + 1;
        ++this.l;
        i2.i = n2;
        this.o.d[n2] = i2;
        return i2;
    }

    public void v(e e2) {
    }

    public c w() {
        return this.o;
    }

    public int y(Object object) {
        if ((object = ((u.d)object).i()) != null) {
            return (int)(((i)object).l + 0.5f);
        }
        return 0;
    }

    static interface a {
        public void a(a var1);

        public void b(i var1);

        public i c(d var1, boolean[] var2);

        public void clear();

        public i getKey();

        public boolean isEmpty();
    }

    static class b
    extends r.b {
        b(c c3) {
            this.e = new j(this, c3);
        }
    }
}

