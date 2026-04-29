/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package v;

import u.d;
import u.e;
import u.i;
import v.d;
import v.f;
import v.g;
import v.n;
import v.p;

public class l
extends p {
    private static int[] k = new int[2];

    public l(e e2) {
        super(e2);
        this.h.e = f.a.j;
        this.i.e = f.a.k;
        this.f = 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void q(int[] nArray, int n2, int n3, int n4, int n5, float f2, int n6) {
        n2 = n3 - n2;
        n3 = n5 - n4;
        if (n6 != -1) {
            if (n6 != 0) {
                if (n6 != 1) return;
                n3 = (int)((float)n2 * f2 + 0.5f);
                nArray[0] = n2;
                nArray[1] = n3;
                return;
            }
            nArray[0] = (int)((float)n3 * f2 + 0.5f);
            nArray[1] = n3;
            return;
        }
        n4 = (int)((float)n3 * f2 + 0.5f);
        n5 = (int)((float)n2 / f2 + 0.5f);
        if (n4 <= n2) {
            nArray[0] = n4;
            nArray[1] = n3;
            return;
        }
        if (n5 > n3) return;
        nArray[0] = n2;
        nArray[1] = n5;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(d object) {
        int n2;
        int n3;
        d d2;
        float f2;
        int n4;
        block31: {
            Object object2;
            block32: {
                block42: {
                    block43: {
                        int n5;
                        int n6;
                        block41: {
                            block40: {
                                int n7;
                                int n8;
                                int n9;
                                int n10;
                                block33: {
                                    block37: {
                                        block39: {
                                            float f3;
                                            block38: {
                                                block34: {
                                                    block35: {
                                                        block36: {
                                                            n4 = v.l$a.a[this.j.ordinal()];
                                                            if (n4 != 1) {
                                                                if (n4 != 2) {
                                                                    if (n4 == 3) {
                                                                        e e2 = this.b;
                                                                        this.n((d)object, e2.O, e2.Q, 0);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    this.o((d)object);
                                                                }
                                                            } else {
                                                                this.p((d)object);
                                                            }
                                                            if (this.e.j || this.d != e.b.i) break block31;
                                                            object2 = this.b;
                                                            n4 = ((e)object2).w;
                                                            if (n4 == 2) break block32;
                                                            if (n4 != 3) break block31;
                                                            n4 = ((e)object2).x;
                                                            if (n4 == 0 || n4 == 3) break block33;
                                                            n4 = ((e)object2).w();
                                                            if (n4 == -1) break block34;
                                                            if (n4 == 0) break block35;
                                                            if (n4 == 1) break block36;
                                                            n4 = 0;
                                                            break block37;
                                                        }
                                                        object = this.b;
                                                        f2 = ((e)object).f.e.g;
                                                        f3 = ((e)object).v();
                                                        break block38;
                                                    }
                                                    object = this.b;
                                                    f2 = (float)((e)object).f.e.g / ((e)object).v();
                                                    break block39;
                                                }
                                                object = this.b;
                                                f2 = ((e)object).f.e.g;
                                                f3 = ((e)object).v();
                                            }
                                            f2 *= f3;
                                        }
                                        n4 = (int)(f2 + 0.5f);
                                    }
                                    this.e.d(n4);
                                    break block31;
                                }
                                d2 = ((e)object2).f;
                                object = ((p)d2).h;
                                d2 = ((p)d2).i;
                                n4 = ((e)object2).O.f != null ? 1 : 0;
                                n3 = ((e)object2).P.f != null ? 1 : 0;
                                n2 = ((e)object2).Q.f != null ? 1 : 0;
                                n6 = ((e)object2).R.f != null ? 1 : 0;
                                n5 = ((e)object2).w();
                                if (n4 == 0 || n3 == 0 || n2 == 0 || n6 == 0) break block40;
                                f2 = this.b.v();
                                if (((f)object).j && ((f)d2).j) {
                                    object2 = this.h;
                                    if (!((f)object2).c) return;
                                    if (!this.i.c) {
                                        return;
                                    }
                                    n3 = ((f)((f)object2).l.get((int)0)).g;
                                    int n11 = this.h.f;
                                    n4 = ((f)this.i.l.get((int)0)).g;
                                    int n12 = this.i.f;
                                    int n13 = ((f)object).g;
                                    int n14 = ((f)object).f;
                                    n6 = ((f)d2).g;
                                    n2 = ((f)d2).f;
                                    this.q(k, n11 + n3, n4 - n12, n14 + n13, n6 - n2, f2, n5);
                                    this.e.d(k[0]);
                                    this.b.f.e.d(k[1]);
                                    return;
                                }
                                object2 = this.h;
                                if (((f)object2).j) {
                                    f f4 = this.i;
                                    if (f4.j) {
                                        if (!((f)object).c) return;
                                        if (!((f)d2).c) {
                                            return;
                                        }
                                        n6 = ((f)object2).g;
                                        n10 = ((f)object2).f;
                                        n9 = f4.g;
                                        n8 = f4.f;
                                        n3 = ((f)((f)object).l.get((int)0)).g;
                                        n4 = ((f)object).f;
                                        n2 = ((f)((f)d2).l.get((int)0)).g;
                                        n7 = ((f)d2).f;
                                        this.q(k, n6 + n10, n9 - n8, n4 + n3, n2 - n7, f2, n5);
                                        this.e.d(k[0]);
                                        this.b.f.e.d(k[1]);
                                    }
                                }
                                object2 = this.h;
                                if (!((f)object2).c) return;
                                if (!this.i.c) return;
                                if (!((f)object).c) return;
                                if (!((f)d2).c) {
                                    return;
                                }
                                n6 = ((f)((f)object2).l.get((int)0)).g;
                                n9 = this.h.f;
                                n3 = ((f)this.i.l.get((int)0)).g;
                                n7 = this.i.f;
                                n4 = ((f)((f)object).l.get((int)0)).g;
                                n2 = ((f)object).f;
                                n10 = ((f)((f)d2).l.get((int)0)).g;
                                n8 = ((f)d2).f;
                                this.q(k, n9 + n6, n3 - n7, n2 + n4, n10 - n8, f2, n5);
                                this.e.d(k[0]);
                                this.b.f.e.d(k[1]);
                                break block31;
                            }
                            if (n4 == 0 || n2 == 0) break block41;
                            if (!this.h.c) return;
                            if (!this.i.c) {
                                return;
                            }
                            f2 = this.b.v();
                            n4 = ((f)this.h.l.get((int)0)).g + this.h.f;
                            n3 = ((f)this.i.l.get((int)0)).g - this.i.f;
                            if (n5 != -1 && n5 != 0) {
                                if (n5 == 1) {
                                    n2 = (int)((float)(n4 = this.g(n3 - n4, 0)) / f2 + 0.5f);
                                    if (n2 != (n3 = this.g(n2, 1))) {
                                        n4 = (int)((float)n3 * f2 + 0.5f);
                                    }
                                    this.e.d(n4);
                                    this.b.f.e.d(n3);
                                }
                                break block31;
                            } else {
                                n2 = (int)((float)(n4 = this.g(n3 - n4, 0)) * f2 + 0.5f);
                                if (n2 != (n3 = this.g(n2, 1))) {
                                    n4 = (int)((float)n3 / f2 + 0.5f);
                                }
                                this.e.d(n4);
                                this.b.f.e.d(n3);
                            }
                            break block31;
                        }
                        if (n3 == 0 || n6 == 0) break block31;
                        if (!((f)object).c) return;
                        if (!((f)d2).c) {
                            return;
                        }
                        f2 = this.b.v();
                        n4 = ((f)((f)object).l.get((int)0)).g + ((f)object).f;
                        n3 = ((f)((f)d2).l.get((int)0)).g - ((f)d2).f;
                        if (n5 == -1) break block42;
                        if (n5 == 0) break block43;
                        if (n5 == 1) break block42;
                        break block31;
                    }
                    n2 = (int)((float)(n4 = this.g(n3 - n4, 1)) * f2 + 0.5f);
                    if (n2 != (n3 = this.g(n2, 0))) {
                        n4 = (int)((float)n3 / f2 + 0.5f);
                    }
                    this.e.d(n3);
                    this.b.f.e.d(n4);
                    break block31;
                }
                if ((n2 = (int)((float)(n4 = this.g(n3 - n4, 1)) / f2 + 0.5f)) != (n3 = this.g(n2, 0))) {
                    n4 = (int)((float)n3 * f2 + 0.5f);
                }
                this.e.d(n3);
                this.b.f.e.d(n4);
                break block31;
            }
            object = ((e)object2).K();
            if (object != null) {
                object = ((e)object).e.e;
                if (((f)object).j) {
                    f2 = this.b.B;
                    n4 = (int)((float)((f)object).g * f2 + 0.5f);
                    this.e.d(n4);
                }
            }
        }
        d2 = this.h;
        if (!((f)d2).c) return;
        object = this.i;
        if (!((f)object).c) {
            return;
        }
        if (((f)d2).j && ((f)object).j && this.e.j) {
            return;
        }
        if (!this.e.j && this.d == e.b.i) {
            object = this.b;
            if (((e)object).w == 0 && !((e)object).i0()) {
                d2 = (f)this.h.l.get(0);
                object = (f)this.i.l.get(0);
                n4 = ((f)d2).g;
                d2 = this.h;
                n3 = n4 + ((f)d2).f;
                n4 = ((f)object).g + this.i.f;
                ((f)d2).d(n3);
                this.i.d(n4);
                this.e.d(n4 - n3);
                return;
            }
        }
        if (!this.e.j && this.d == e.b.i && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
            object = (f)this.h.l.get(0);
            d2 = (f)this.i.l.get(0);
            n4 = ((f)object).g;
            n3 = this.h.f;
            n4 = Math.min((int)(((f)d2).g + this.i.f - (n4 + n3)), (int)this.e.m);
            object = this.b;
            n2 = ((e)object).A;
            n4 = n3 = Math.max((int)((e)object).z, (int)n4);
            if (n2 > 0) {
                n4 = Math.min((int)n2, (int)n3);
            }
            this.e.d(n4);
        }
        if (!this.e.j) {
            return;
        }
        d2 = (f)this.h.l.get(0);
        object = (f)this.i.l.get(0);
        n4 = ((f)d2).g + this.h.f;
        n3 = ((f)object).g + this.i.f;
        f2 = this.b.y();
        if (d2 == object) {
            n4 = ((f)d2).g;
            n3 = ((f)object).g;
            f2 = 0.5f;
        }
        n2 = this.e.g;
        this.h.d((int)((float)n4 + 0.5f + (float)(n3 - n4 - n2) * f2));
        this.i.d(this.h.g + this.e.g);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    void d() {
        Object object;
        e e2 = this.b;
        if (e2.a) {
            this.e.d(e2.W());
        }
        if (!this.e.j) {
            e.b b2;
            this.d = b2 = this.b.A();
            if (b2 != e.b.i) {
                e e3;
                e.b b3 = e.b.j;
                if (b2 == b3 && (e3 = this.b.K()) != null && (e3.A() == e.b.g || e3.A() == b3)) {
                    int n2 = e3.W();
                    int n3 = this.b.O.f();
                    int n4 = this.b.Q.f();
                    this.b(this.h, e3.e.h, this.b.O.f());
                    this.b(this.i, e3.e.i, -this.b.Q.f());
                    this.e.d(n2 - n3 - n4);
                    return;
                }
                if (this.d == e.b.g) {
                    this.e.d(this.b.W());
                }
            }
        } else {
            e e4;
            e.b b4 = this.d;
            e.b b5 = e.b.j;
            if (b4 == b5 && (e4 = this.b.K()) != null && (e4.A() == e.b.g || e4.A() == b5)) {
                this.b(this.h, e4.e.h, this.b.O.f());
                this.b(this.i, e4.e.i, -this.b.Q.f());
                return;
            }
        }
        g g2 = this.e;
        if (g2.j) {
            e e5 = this.b;
            if (e5.a) {
                u.d[] dArray = e5.W;
                u.d d2 = dArray[0];
                u.d d3 = d2.f;
                if (d3 != null && dArray[1].f != null) {
                    f f2;
                    if (e5.i0()) {
                        this.h.f = this.b.W[0].f();
                        this.i.f = -this.b.W[1].f();
                        return;
                    }
                    f f3 = this.h(this.b.W[0]);
                    if (f3 != null) {
                        this.b(this.h, f3, this.b.W[0].f());
                    }
                    if ((f2 = this.h(this.b.W[1])) != null) {
                        this.b(this.i, f2, -this.b.W[1].f());
                    }
                    this.h.b = true;
                    this.i.b = true;
                    return;
                }
                if (d3 != null) {
                    f f4 = this.h(d2);
                    if (f4 == null) return;
                    this.b(this.h, f4, this.b.W[0].f());
                    this.b(this.i, this.h, this.e.g);
                    return;
                }
                u.d d4 = dArray[1];
                if (d4.f != null) {
                    f f5 = this.h(d4);
                    if (f5 == null) return;
                    this.b(this.i, f5, -this.b.W[1].f());
                    this.b(this.h, this.i, -this.e.g);
                    return;
                }
                if (e5 instanceof i || e5.K() == null || this.b.o((d.a)d.a.m).f != null) return;
                f f6 = this.b.K().e.h;
                this.b(this.h, f6, this.b.X());
                this.b(this.i, this.h, this.e.g);
                return;
            }
        }
        if (this.d == e.b.i) {
            e e6 = this.b;
            int n5 = e6.w;
            if (n5 != 2) {
                if (n5 == 3) {
                    if (e6.x == 3) {
                        this.h.a = this;
                        this.i.a = this;
                        object = e6.f;
                        ((p)object).h.a = this;
                        ((p)object).i.a = this;
                        g2.a = this;
                        if (e6.k0()) {
                            this.e.l.add((Object)this.b.f.e);
                            this.b.f.e.k.add((Object)this.e);
                            n n6 = this.b.f;
                            n6.e.a = this;
                            this.e.l.add((Object)n6.h);
                            this.e.l.add((Object)this.b.f.i);
                            this.b.f.h.k.add((Object)this.e);
                            this.b.f.i.k.add((Object)this.e);
                        } else if (this.b.i0()) {
                            this.b.f.e.l.add((Object)this.e);
                            this.e.k.add((Object)this.b.f.e);
                        } else {
                            this.b.f.e.l.add((Object)this.e);
                        }
                    } else {
                        g g3 = e6.f.e;
                        g2.l.add((Object)g3);
                        g3.k.add((Object)this.e);
                        this.b.f.h.k.add((Object)this.e);
                        this.b.f.i.k.add((Object)this.e);
                        g g4 = this.e;
                        g4.b = true;
                        g4.k.add((Object)this.h);
                        this.e.k.add((Object)this.i);
                        this.h.l.add((Object)this.e);
                        this.i.l.add((Object)this.e);
                    }
                }
            } else {
                e e7 = e6.K();
                if (e7 != null) {
                    g g5 = e7.f.e;
                    this.e.l.add((Object)g5);
                    g5.k.add((Object)this.e);
                    g g6 = this.e;
                    g6.b = true;
                    g6.k.add((Object)this.h);
                    this.e.k.add((Object)this.i);
                }
            }
        }
        e e8 = this.b;
        u.d[] dArray = e8.W;
        u.d d5 = dArray[0];
        object = d5.f;
        if (object != null && dArray[1].f != null) {
            if (e8.i0()) {
                this.h.f = this.b.W[0].f();
                this.i.f = -this.b.W[1].f();
                return;
            }
            f f7 = this.h(this.b.W[0]);
            f f8 = this.h(this.b.W[1]);
            if (f7 != null) {
                f7.b(this);
            }
            if (f8 != null) {
                f8.b(this);
            }
            this.j = p.b.j;
            return;
        }
        if (object != null) {
            f f9 = this.h(d5);
            if (f9 == null) return;
            this.b(this.h, f9, this.b.W[0].f());
            this.c(this.i, this.h, 1, this.e);
            return;
        }
        u.d d6 = dArray[1];
        if (d6.f != null) {
            f f10 = this.h(d6);
            if (f10 == null) return;
            this.b(this.i, f10, -this.b.W[1].f());
            this.c(this.h, this.i, -1, this.e);
            return;
        }
        if (e8 instanceof i || e8.K() == null) return;
        f f11 = this.b.K().e.h;
        this.b(this.h, f11, this.b.X());
        this.c(this.i, this.h, 1, this.e);
    }

    @Override
    public void e() {
        f f2 = this.h;
        if (f2.j) {
            this.b.n1(f2.g);
        }
    }

    @Override
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override
    boolean m() {
        if (this.d == e.b.i) {
            return this.b.w == 0;
        }
        return true;
    }

    void r() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HorizontalRun ");
        stringBuilder.append(this.b.t());
        return stringBuilder.toString();
    }
}

