/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package v;

import java.util.ArrayList;
import u.e;
import v.d;
import v.f;
import v.g;
import v.p;

public class c
extends p {
    ArrayList k = new ArrayList();
    private int l;

    public c(e e2, int n2) {
        super(e2);
        this.f = n2;
        this.q();
    }

    private void q() {
        Object object = this.b;
        e e2 = ((e)object).L(this.f);
        while (e2 != null) {
            e e3 = e2.L(this.f);
            object = e2;
            e2 = e3;
        }
        this.b = object;
        this.k.add((Object)((e)object).N(this.f));
        for (e2 = ((e)object).J(this.f); e2 != null; e2 = e2.J(this.f)) {
            this.k.add((Object)e2.N(this.f));
        }
        e2 = this.k;
        int n2 = e2.size();
        int n3 = 0;
        while (n3 < n2) {
            object = e2.get(n3);
            int n4 = n3 + 1;
            object = (p)object;
            int n5 = this.f;
            if (n5 == 0) {
                ((p)object).b.c = this;
                n3 = n4;
                continue;
            }
            n3 = n4;
            if (n5 != 1) continue;
            ((p)object).b.d = this;
            n3 = n4;
        }
        if (this.f == 0 && ((u.f)this.b.K()).R1() && this.k.size() > 1) {
            e2 = this.k;
            this.b = ((p)e2.get((int)(e2.size() - 1))).b;
        }
        n3 = this.f == 0 ? this.b.z() : this.b.S();
        this.l = n3;
    }

    private e r() {
        for (int i2 = 0; i2 < this.k.size(); ++i2) {
            p p2 = (p)this.k.get(i2);
            if (p2.b.V() == 8) continue;
            return p2.b;
        }
        return null;
    }

    private e s() {
        for (int i2 = this.k.size() - 1; i2 >= 0; --i2) {
            p p2 = (p)this.k.get(i2);
            if (p2.b.V() == 8) continue;
            return p2.b;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(d object) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        boolean bl;
        block89: {
            int n9;
            int n10;
            int n11;
            block99: {
                block97: {
                    float f2;
                    int n12;
                    float f3;
                    float f4;
                    int n13;
                    block98: {
                        int n14;
                        block96: {
                            int n15;
                            block88: {
                                block87: {
                                    block86: {
                                        if (!this.h.j) return;
                                        if (!this.i.j) {
                                            return;
                                        }
                                        object = this.b.K();
                                        bl = object instanceof u.f ? ((u.f)object).R1() : false;
                                        n13 = this.i.g - this.h.g;
                                        n8 = this.k.size();
                                        n7 = 0;
                                        while (true) {
                                            n6 = -1;
                                            if (n7 >= n8) break;
                                            n5 = n7;
                                            if (((p)this.k.get((int)n7)).b.V() == 8) {
                                                ++n7;
                                                continue;
                                            }
                                            break block86;
                                            break;
                                        }
                                        n5 = -1;
                                    }
                                    n7 = n4 = n8 - 1;
                                    while (true) {
                                        n3 = n6;
                                        if (n7 < 0) break block87;
                                        if (((p)this.k.get((int)n7)).b.V() != 8) break;
                                        --n7;
                                    }
                                    n3 = n7;
                                }
                                n11 = 0;
                                while (true) {
                                    if (n11 >= 2) {
                                        f4 = 0.0f;
                                        n14 = 0;
                                        n2 = 0;
                                        n6 = 0;
                                        break block88;
                                    }
                                    n2 = 0;
                                    n7 = 0;
                                    n6 = 0;
                                    f3 = 0.0f;
                                    for (n10 = 0; n10 < n8; ++n10) {
                                        block91: {
                                            block93: {
                                                block95: {
                                                    g g2;
                                                    block94: {
                                                        block92: {
                                                            block90: {
                                                                object = (p)this.k.get(n10);
                                                                if (((p)object).b.V() != 8) break block90;
                                                                n12 = n7;
                                                                break block91;
                                                            }
                                                            n15 = n6 + 1;
                                                            n6 = n2;
                                                            if (n10 > 0) {
                                                                n6 = n2;
                                                                if (n10 >= n5) {
                                                                    n6 = n2 + ((p)object).h.f;
                                                                }
                                                            }
                                                            g2 = ((p)object).e;
                                                            n9 = g2.g;
                                                            n2 = ((p)object).d != e.b.i ? 1 : 0;
                                                            if (n2 == 0) break block92;
                                                            n12 = this.f;
                                                            if (n12 == 0 && !((p)object).b.e.e.j) {
                                                                return;
                                                            }
                                                            if (n12 == 1 && !((p)object).b.f.e.j) {
                                                                return;
                                                            }
                                                            n12 = n2;
                                                            n14 = n9;
                                                            n2 = n7;
                                                            break block93;
                                                        }
                                                        if (((p)object).a != 1 || n11 != 0) break block94;
                                                        n2 = g2.m;
                                                        ++n7;
                                                        break block95;
                                                    }
                                                    n12 = n2;
                                                    n14 = n9;
                                                    n2 = n7;
                                                    if (!g2.j) break block93;
                                                    n2 = n9;
                                                }
                                                n12 = 1;
                                                n14 = n2;
                                                n2 = n7;
                                            }
                                            if (n12 == 0) {
                                                f2 = ((p)object).b.D0[this.f];
                                                n9 = n6;
                                                n7 = ++n2;
                                                f4 = f3;
                                                if (f2 >= 0.0f) {
                                                    f4 = f3 + f2;
                                                    n9 = n6;
                                                    n7 = n2;
                                                }
                                            } else {
                                                n9 = n6 + n14;
                                                f4 = f3;
                                                n7 = n2;
                                            }
                                            n2 = n9;
                                            n12 = n7;
                                            n6 = n15;
                                            f3 = f4;
                                            if (n10 < n4) {
                                                n2 = n9;
                                                n12 = n7;
                                                n6 = n15;
                                                f3 = f4;
                                                if (n10 < n3) {
                                                    n2 = n9 + -((p)object).i.f;
                                                    f3 = f4;
                                                    n6 = n15;
                                                    n12 = n7;
                                                }
                                            }
                                        }
                                        n7 = n12;
                                    }
                                    if (n2 < n13 || n7 == 0) break;
                                    ++n11;
                                }
                                n14 = n6;
                                n6 = n7;
                                f4 = f3;
                            }
                            n9 = this.h.g;
                            if (bl) {
                                n9 = this.i.g;
                            }
                            f3 = 0.5f;
                            n7 = n9;
                            if (n2 > n13) {
                                n7 = bl ? n9 + (int)((float)(n2 - n13) / 2.0f + 0.5f) : n9 - (int)((float)(n2 - n13) / 2.0f + 0.5f);
                            }
                            if (n6 <= 0) {
                                f4 = 0.5f;
                                n11 = n6;
                                n6 = n2;
                            } else {
                                f2 = n13 - n2;
                                n11 = (int)(f2 / (float)n6 + 0.5f);
                                n9 = 0;
                                n10 = n7;
                                for (n15 = 0; n15 < n8; ++n15) {
                                    int n16;
                                    e e2;
                                    object = (p)this.k.get(n15);
                                    if (((p)object).b.V() == 8 || ((p)object).d != e.b.i) continue;
                                    g g3 = ((p)object).e;
                                    if (g3.j) continue;
                                    n7 = f4 > 0.0f ? (int)(((p)object).b.D0[this.f] * f2 / f4 + f3) : n11;
                                    if (this.f == 0) {
                                        e2 = ((p)object).b;
                                        n16 = e2.A;
                                        n12 = e2.z;
                                    } else {
                                        e2 = ((p)object).b;
                                        n16 = e2.D;
                                        n12 = e2.C;
                                    }
                                    int n17 = ((p)object).a == 1 ? Math.min((int)n7, (int)g3.m) : n7;
                                    n12 = n17 = Math.max((int)n12, (int)n17);
                                    if (n16 > 0) {
                                        n12 = Math.min((int)n16, (int)n17);
                                    }
                                    if (n12 != n7) {
                                        ++n9;
                                        n7 = n12;
                                    }
                                    ((p)object).e.d(n7);
                                }
                                n11 = n2;
                                n2 = n6;
                                if (n9 > 0) {
                                    n12 = n6 - n9;
                                    n6 = 0;
                                    n7 = 0;
                                    while (true) {
                                        n11 = n7;
                                        n2 = n12;
                                        if (n6 >= n8) break;
                                        object = (p)this.k.get(n6);
                                        if (((p)object).b.V() != 8) {
                                            n2 = n7;
                                            if (n6 > 0) {
                                                n2 = n7;
                                                if (n6 >= n5) {
                                                    n2 = n7 + ((p)object).h.f;
                                                }
                                            }
                                            n7 = n2 += ((p)object).e.g;
                                            if (n6 < n4) {
                                                n7 = n2;
                                                if (n6 < n3) {
                                                    n7 = n2 + -((p)object).i.f;
                                                }
                                            }
                                        }
                                        ++n6;
                                    }
                                }
                                if (this.l == 2 && n9 == 0) {
                                    this.l = 0;
                                    n6 = n11;
                                    n11 = n2;
                                    f4 = f3;
                                    n7 = n10;
                                } else {
                                    n6 = n11;
                                    n11 = n2;
                                    f4 = f3;
                                    n7 = n10;
                                }
                            }
                            n10 = 0;
                            n9 = 0;
                            n2 = 0;
                            if (n6 > n13) {
                                this.l = 2;
                            }
                            if (n14 > 0 && n11 == 0 && n5 == n3) {
                                this.l = 2;
                            }
                            if ((n12 = this.l) != 1) break block96;
                            n6 = n14 > 1 ? (n13 - n6) / (n14 - 1) : (n14 == 1 ? (n13 - n6) / 2 : 0);
                            n9 = n6;
                            if (n11 > 0) {
                                n9 = 0;
                            }
                            break block97;
                        }
                        if (n12 != 0) break block98;
                        n9 = (n13 - n6) / (n14 + 1);
                        if (n11 > 0) {
                            n9 = 0;
                        }
                        break block99;
                    }
                    if (n12 != 2) return;
                    f3 = this.f == 0 ? this.b.y() : this.b.R();
                    f2 = f3;
                    if (bl) {
                        f2 = 1.0f - f3;
                    }
                    if ((n6 = (int)((float)(n13 - n6) * f2 + f4)) < 0 || n11 > 0) {
                        n6 = 0;
                    }
                    if (bl) {
                        n7 -= n6;
                        n6 = n9;
                        break block89;
                    } else {
                        n7 += n6;
                        n6 = n9;
                    }
                    break block89;
                }
                n6 = n2;
                n2 = n7;
                while (n6 < n8) {
                    n7 = bl ? n8 - (n6 + 1) : n6;
                    p p2 = (p)this.k.get(n7);
                    if (p2.b.V() == 8) {
                        p2.h.d(n2);
                        p2.i.d(n2);
                        n7 = n2;
                    } else {
                        n7 = n2;
                        if (n6 > 0) {
                            n7 = bl ? n2 - n9 : n2 + n9;
                        }
                        n2 = n7;
                        if (n6 > 0) {
                            n2 = n7;
                            if (n6 >= n5) {
                                n2 = bl ? n7 - p2.h.f : n7 + p2.h.f;
                            }
                        }
                        if (bl) {
                            p2.i.d(n2);
                        } else {
                            p2.h.d(n2);
                        }
                        object = p2.e;
                        n7 = n11 = ((f)object).g;
                        if (p2.d == e.b.i) {
                            n7 = n11;
                            if (p2.a == 1) {
                                n7 = ((g)object).m;
                            }
                        }
                        n2 = bl ? (n2 -= n7) : (n2 += n7);
                        if (bl) {
                            p2.h.d(n2);
                        } else {
                            p2.i.d(n2);
                        }
                        p2.g = true;
                        n7 = n2;
                        if (n6 < n4) {
                            n7 = n2;
                            if (n6 < n3) {
                                n7 = bl ? n2 - -p2.i.f : n2 + -p2.i.f;
                            }
                        }
                    }
                    ++n6;
                    n2 = n7;
                }
                return;
            }
            n6 = n10;
            while (n6 < n8) {
                n2 = bl ? n8 - (n6 + 1) : n6;
                p p3 = (p)this.k.get(n2);
                if (p3.b.V() == 8) {
                    p3.h.d(n7);
                    p3.i.d(n7);
                } else {
                    n2 = bl ? n7 - n9 : n7 + n9;
                    n7 = n2;
                    if (n6 > 0) {
                        n7 = n2;
                        if (n6 >= n5) {
                            n7 = bl ? n2 - p3.h.f : n2 + p3.h.f;
                        }
                    }
                    if (bl) {
                        p3.i.d(n7);
                    } else {
                        p3.h.d(n7);
                    }
                    object = p3.e;
                    n2 = n11 = ((f)object).g;
                    if (p3.d == e.b.i) {
                        n2 = n11;
                        if (p3.a == 1) {
                            n2 = Math.min((int)n11, (int)((g)object).m);
                        }
                    }
                    n2 = bl ? n7 - n2 : n7 + n2;
                    if (bl) {
                        p3.h.d(n2);
                    } else {
                        p3.i.d(n2);
                    }
                    n7 = n2;
                    if (n6 < n4) {
                        n7 = n2;
                        if (n6 < n3) {
                            n7 = bl ? n2 - -p3.i.f : n2 + -p3.i.f;
                        }
                    }
                }
                ++n6;
            }
            return;
        }
        while (n6 < n8) {
            n2 = bl ? n8 - (n6 + 1) : n6;
            object = (p)this.k.get(n2);
            if (((p)object).b.V() == 8) {
                ((p)object).h.d(n7);
                ((p)object).i.d(n7);
            } else {
                n2 = n7;
                if (n6 > 0) {
                    n2 = n7;
                    if (n6 >= n5) {
                        n2 = bl ? n7 - ((p)object).h.f : n7 + ((p)object).h.f;
                    }
                }
                if (bl) {
                    ((p)object).i.d(n2);
                } else {
                    ((p)object).h.d(n2);
                }
                g g4 = ((p)object).e;
                n7 = g4.g;
                if (((p)object).d == e.b.i && ((p)object).a == 1) {
                    n7 = g4.m;
                }
                n2 = bl ? (n2 -= n7) : (n2 += n7);
                if (bl) {
                    ((p)object).h.d(n2);
                } else {
                    ((p)object).i.d(n2);
                }
                n7 = n2;
                if (n6 < n4) {
                    n7 = n2;
                    if (n6 < n3) {
                        n7 = bl ? n2 - -((p)object).i.f : n2 + -((p)object).i.f;
                    }
                }
            }
            ++n6;
        }
    }

    @Override
    void d() {
        Object object;
        int n2;
        Object object2 = this.k;
        int n3 = object2.size();
        for (n2 = 0; n2 < n3; ++n2) {
            object = object2.get(n2);
            ((p)object).d();
        }
        n2 = this.k.size();
        if (n2 < 1) {
            return;
        }
        object2 = ((p)this.k.get((int)0)).b;
        object = ((p)this.k.get((int)(n2 - 1))).b;
        if (this.f == 0) {
            Object object3 = ((e)object2).O;
            object = ((e)object).Q;
            object2 = this.i((u.d)object3, 0);
            n2 = ((u.d)object3).f();
            object3 = this.r();
            if (object3 != null) {
                n2 = ((e)object3).O.f();
            }
            if (object2 != null) {
                this.b(this.h, (f)object2, n2);
            }
            object2 = this.i((u.d)object, 0);
            n2 = ((u.d)object).f();
            object = this.s();
            if (object != null) {
                n2 = ((e)object).Q.f();
            }
            if (object2 != null) {
                this.b(this.i, (f)object2, -n2);
            }
        } else {
            object2 = ((e)object2).P;
            object = ((e)object).R;
            f f2 = this.i((u.d)object2, 1);
            n2 = ((u.d)object2).f();
            object2 = this.r();
            if (object2 != null) {
                n2 = ((e)object2).P.f();
            }
            if (f2 != null) {
                this.b(this.h, f2, n2);
            }
            object2 = this.i((u.d)object, 1);
            n2 = ((u.d)object).f();
            object = this.s();
            if (object != null) {
                n2 = ((e)object).R.f();
            }
            if (object2 != null) {
                this.b(this.i, (f)object2, -n2);
            }
        }
        this.h.a = this;
        this.i.a = this;
    }

    @Override
    public void e() {
        for (int i2 = 0; i2 < this.k.size(); ++i2) {
            ((p)this.k.get(i2)).e();
        }
    }

    @Override
    void f() {
        this.c = null;
        ArrayList arrayList = this.k;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrayList.get(i2);
            ((p)object).f();
        }
    }

    @Override
    public long j() {
        int n2 = this.k.size();
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            p p2 = (p)this.k.get(i2);
            l2 = l2 + (long)p2.h.f + p2.j() + (long)p2.i.f;
        }
        return l2;
    }

    @Override
    boolean m() {
        int n2 = this.k.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (((p)this.k.get(i2)).m()) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ChainRun ");
        String string = this.f == 0 ? "horizontal : " : "vertical : ";
        stringBuilder.append(string);
        string = this.k;
        int n2 = string.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = string.get(i2);
            object = (p)object;
            stringBuilder.append("<");
            stringBuilder.append(object);
            stringBuilder.append("> ");
        }
        return stringBuilder.toString();
    }
}

