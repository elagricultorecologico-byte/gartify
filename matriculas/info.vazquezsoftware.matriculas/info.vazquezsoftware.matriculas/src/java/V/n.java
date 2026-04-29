/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import v.l;
import v.p;

public class n
extends p {
    public f k;
    g l;

    public n(e object) {
        super((e)object);
        this.k = object = new f(this);
        this.l = null;
        this.h.e = f.a.l;
        this.i.e = f.a.m;
        ((f)object).e = f.a.n;
        this.f = 1;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(d object) {
        int n2;
        float f2;
        int n3;
        block17: {
            block18: {
                block22: {
                    block24: {
                        float f3;
                        block23: {
                            block19: {
                                block20: {
                                    block21: {
                                        n3 = v.n$a.a[this.j.ordinal()];
                                        if (n3 != 1) {
                                            if (n3 != 2) {
                                                if (n3 == 3) {
                                                    e e2 = this.b;
                                                    this.n((d)object, e2.P, e2.R, 1);
                                                    return;
                                                }
                                            } else {
                                                this.o((d)object);
                                            }
                                        } else {
                                            this.p((d)object);
                                        }
                                        object = this.e;
                                        if (!((f)object).c || ((f)object).j || this.d != e.b.i) break block17;
                                        object = this.b;
                                        n3 = ((e)object).x;
                                        if (n3 == 2) break block18;
                                        if (n3 != 3 || !((e)object).e.e.j) break block17;
                                        n3 = ((e)object).w();
                                        if (n3 == -1) break block19;
                                        if (n3 == 0) break block20;
                                        if (n3 == 1) break block21;
                                        n3 = 0;
                                        break block22;
                                    }
                                    object = this.b;
                                    f2 = ((e)object).e.e.g;
                                    f3 = ((e)object).v();
                                    break block23;
                                }
                                object = this.b;
                                f2 = (float)((e)object).e.e.g * ((e)object).v();
                                break block24;
                            }
                            object = this.b;
                            f2 = ((e)object).e.e.g;
                            f3 = ((e)object).v();
                        }
                        f2 /= f3;
                    }
                    n3 = (int)(f2 + 0.5f);
                }
                this.e.d(n3);
                break block17;
            }
            if ((object = ((e)object).K()) != null) {
                object = ((e)object).f.e;
                if (((f)object).j) {
                    f2 = this.b.E;
                    n3 = (int)((float)((f)object).g * f2 + 0.5f);
                    this.e.d(n3);
                }
            }
        }
        f f4 = this.h;
        if (!f4.c) return;
        object = this.i;
        if (!((f)object).c) {
            return;
        }
        if (f4.j && ((f)object).j && this.e.j) {
            return;
        }
        if (!this.e.j && this.d == e.b.i) {
            object = this.b;
            if (((e)object).w == 0 && !((e)object).k0()) {
                f4 = (f)this.h.l.get(0);
                object = (f)this.i.l.get(0);
                n3 = f4.g;
                f4 = this.h;
                int n4 = ((f)object).g + this.i.f;
                f4.d(n3 += f4.f);
                this.i.d(n4);
                this.e.d(n4 - n3);
                return;
            }
        }
        if (!this.e.j && this.d == e.b.i && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
            f4 = (f)this.h.l.get(0);
            object = (f)this.i.l.get(0);
            n2 = f4.g;
            n3 = this.h.f;
            n2 = ((f)object).g + this.i.f - (n2 + n3);
            object = this.e;
            n3 = ((g)object).m;
            if (n2 < n3) {
                ((g)object).d(n2);
            } else {
                ((g)object).d(n3);
            }
        }
        if (!this.e.j) {
            return;
        }
        if (this.h.l.size() <= 0) return;
        if (this.i.l.size() <= 0) return;
        object = (f)this.h.l.get(0);
        f4 = (f)this.i.l.get(0);
        n3 = ((f)object).g + this.h.f;
        n2 = f4.g + this.i.f;
        f2 = this.b.R();
        if (object == f4) {
            n3 = ((f)object).g;
            n2 = f4.g;
            f2 = 0.5f;
        }
        int n5 = this.e.g;
        this.h.d((int)((float)n3 + 0.5f + (float)(n2 - n3 - n5) * f2));
        this.i.d(this.h.g + this.e.g);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    void d() {
        e e2;
        e e3 = this.b;
        if (e3.a) {
            this.e.d(e3.x());
        }
        if (!this.e.j) {
            e.b b2;
            this.d = this.b.T();
            if (this.b.Z()) {
                this.l = new v.a(this);
            }
            if ((b2 = this.d) != e.b.i) {
                e e4;
                if (b2 == e.b.j && (e4 = this.b.K()) != null && e4.T() == e.b.g) {
                    int n2 = e4.x();
                    int n3 = this.b.P.f();
                    int n4 = this.b.R.f();
                    this.b(this.h, e4.f.h, this.b.P.f());
                    this.b(this.i, e4.f.i, -this.b.R.f());
                    this.e.d(n2 - n3 - n4);
                    return;
                }
                if (this.d == e.b.g) {
                    this.e.d(this.b.x());
                }
            }
        } else if (this.d == e.b.j && (e2 = this.b.K()) != null && e2.T() == e.b.g) {
            this.b(this.h, e2.f.h, this.b.P.f());
            this.b(this.i, e2.f.i, -this.b.R.f());
            return;
        }
        g g2 = this.e;
        boolean bl = g2.j;
        if (bl) {
            e e5 = this.b;
            if (e5.a) {
                u.d[] dArray = e5.W;
                u.d d2 = dArray[2];
                u.d d3 = d2.f;
                if (d3 != null && dArray[3].f != null) {
                    if (e5.k0()) {
                        this.h.f = this.b.W[2].f();
                        this.i.f = -this.b.W[3].f();
                    } else {
                        f f2;
                        f f3 = this.h(this.b.W[2]);
                        if (f3 != null) {
                            this.b(this.h, f3, this.b.W[2].f());
                        }
                        if ((f2 = this.h(this.b.W[3])) != null) {
                            this.b(this.i, f2, -this.b.W[3].f());
                        }
                        this.h.b = true;
                        this.i.b = true;
                    }
                    if (!this.b.Z()) return;
                    this.b(this.k, this.h, this.b.p());
                    return;
                }
                if (d3 != null) {
                    f f4 = this.h(d2);
                    if (f4 == null) return;
                    this.b(this.h, f4, this.b.W[2].f());
                    this.b(this.i, this.h, this.e.g);
                    if (!this.b.Z()) return;
                    this.b(this.k, this.h, this.b.p());
                    return;
                }
                d3 = dArray[3];
                if (d3.f != null) {
                    f f5 = this.h(d3);
                    if (f5 != null) {
                        this.b(this.i, f5, -this.b.W[3].f());
                        this.b(this.h, this.i, -this.e.g);
                    }
                    if (!this.b.Z()) return;
                    this.b(this.k, this.h, this.b.p());
                    return;
                }
                u.d d4 = dArray[4];
                if (d4.f != null) {
                    f f6 = this.h(d4);
                    if (f6 == null) return;
                    this.b(this.k, f6, 0);
                    this.b(this.h, this.k, -this.b.p());
                    this.b(this.i, this.h, this.e.g);
                    return;
                }
                if (e5 instanceof i || e5.K() == null || this.b.o((d.a)d.a.m).f != null) return;
                f f7 = this.b.K().f.h;
                this.b(this.h, f7, this.b.Y());
                this.b(this.i, this.h, this.e.g);
                if (!this.b.Z()) return;
                this.b(this.k, this.h, this.b.p());
                return;
            }
        }
        if (!bl && this.d == e.b.i) {
            e e6 = this.b;
            int n5 = e6.x;
            if (n5 != 2) {
                if (n5 == 3 && !e6.k0()) {
                    e e7 = this.b;
                    if (e7.w != 3) {
                        g g3 = e7.e.e;
                        this.e.l.add((Object)g3);
                        g3.k.add((Object)this.e);
                        g g4 = this.e;
                        g4.b = true;
                        g4.k.add((Object)this.h);
                        this.e.k.add((Object)this.i);
                    }
                }
            } else {
                e e8 = e6.K();
                if (e8 != null) {
                    g g5 = e8.f.e;
                    this.e.l.add((Object)g5);
                    g5.k.add((Object)this.e);
                    g g6 = this.e;
                    g6.b = true;
                    g6.k.add((Object)this.h);
                    this.e.k.add((Object)this.i);
                }
            }
        } else {
            g2.b(this);
        }
        e e9 = this.b;
        u.d[] dArray = e9.W;
        u.d d5 = dArray[2];
        u.d d6 = d5.f;
        if (d6 != null && dArray[3].f != null) {
            if (e9.k0()) {
                this.h.f = this.b.W[2].f();
                this.i.f = -this.b.W[3].f();
            } else {
                f f8 = this.h(this.b.W[2]);
                f f9 = this.h(this.b.W[3]);
                if (f8 != null) {
                    f8.b(this);
                }
                if (f9 != null) {
                    f9.b(this);
                }
                this.j = p.b.j;
            }
            if (this.b.Z()) {
                this.c(this.k, this.h, 1, this.l);
            }
        } else if (d6 != null) {
            f f10 = this.h(d5);
            if (f10 != null) {
                e.b b3;
                e.b b4;
                this.b(this.h, f10, this.b.W[2].f());
                this.c(this.i, this.h, 1, this.e);
                if (this.b.Z()) {
                    this.c(this.k, this.h, 1, this.l);
                }
                if ((b4 = this.d) == (b3 = e.b.i) && this.b.v() > 0.0f) {
                    l l2 = this.b.e;
                    if (l2.d == b3) {
                        l2.e.k.add((Object)this.e);
                        this.e.l.add((Object)this.b.e.e);
                        this.e.a = this;
                    }
                }
            }
        } else {
            d6 = dArray[3];
            if (d6.f != null) {
                f f11 = this.h(d6);
                if (f11 != null) {
                    this.b(this.i, f11, -this.b.W[3].f());
                    this.c(this.h, this.i, -1, this.e);
                    if (this.b.Z()) {
                        this.c(this.k, this.h, 1, this.l);
                    }
                }
            } else {
                u.d d7 = dArray[4];
                if (d7.f != null) {
                    f f12 = this.h(d7);
                    if (f12 != null) {
                        this.b(this.k, f12, 0);
                        this.c(this.h, this.k, -1, this.l);
                        this.c(this.i, this.h, 1, this.e);
                    }
                } else if (!(e9 instanceof i) && e9.K() != null) {
                    e.b b5;
                    e.b b6;
                    f f13 = this.b.K().f.h;
                    this.b(this.h, f13, this.b.Y());
                    this.c(this.i, this.h, 1, this.e);
                    if (this.b.Z()) {
                        this.c(this.k, this.h, 1, this.l);
                    }
                    if ((b6 = this.d) == (b5 = e.b.i) && this.b.v() > 0.0f) {
                        l l3 = this.b.e;
                        if (l3.d == b5) {
                            l3.e.k.add((Object)this.e);
                            this.e.l.add((Object)this.b.e.e);
                            this.e.a = this;
                        }
                    }
                }
            }
        }
        if (this.e.l.size() != 0) return;
        this.e.c = true;
    }

    @Override
    public void e() {
        f f2 = this.h;
        if (f2.j) {
            this.b.o1(f2.g);
        }
    }

    @Override
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override
    boolean m() {
        if (this.d == e.b.i) {
            return this.b.x == 0;
        }
        return true;
    }

    void q() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.k.c();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerticalRun ");
        stringBuilder.append(this.b.t());
        return stringBuilder.toString();
    }
}

