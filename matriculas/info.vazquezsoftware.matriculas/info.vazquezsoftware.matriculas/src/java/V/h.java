/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 */
package v;

import java.util.ArrayList;
import u.a;
import u.d;
import u.e;
import u.f;
import u.m;
import v.b;

public abstract class h {
    private static b.a a = new b.a();
    private static int b = 0;
    private static int c = 0;

    private static boolean a(int n2, e e2) {
        e.b b2;
        e.b b3 = e2.A();
        e.b b4 = e2.T();
        Object object = e2.K() != null ? (f)e2.K() : null;
        if (object != null) {
            object.A();
            b2 = e.b.g;
        }
        if (object != null) {
            object.T();
            object = e.b.g;
        }
        n2 = !(b3 == (object = e.b.g) || e2.n0() || b3 == e.b.h || b3 == (b2 = e.b.i) && e2.w == 0 && e2.d0 == 0.0f && e2.a0(0) || b3 == b2 && e2.w == 1 && e2.d0(0, e2.W())) ? 0 : 1;
        boolean bl = b4 == object || e2.o0() || b4 == e.b.h || b4 == (object = e.b.i) && e2.x == 0 && e2.d0 == 0.0f && e2.a0(1) || b4 == object && e2.x == 1 && e2.d0(1, e2.x());
        if (e2.d0 > 0.0f && (n2 != 0 || bl)) {
            return true;
        }
        return n2 != 0 && bl;
    }

    private static void b(int n2, e e2, b.b b2, boolean bl) {
        Object object;
        boolean bl2;
        Object object2;
        if (e2.g0()) {
            return;
        }
        int n3 = b;
        int n4 = 1;
        int n5 = 1;
        b = n3 + 1;
        if (!(e2 instanceof f) && e2.m0() && h.a(n3 = n2 + 1, e2)) {
            f.U1(n3, e2, b2, new b.a(), b.a.k);
        }
        d d22 = e2.o(d.a.h);
        Object object3 = e2.o(d.a.j);
        int n6 = d22.e();
        int n7 = ((d)object3).e();
        n3 = n4;
        if (d22.d() != null) {
            n3 = n4;
            if (d22.n()) {
                d22 = d22.d().iterator();
                while (true) {
                    Object object4;
                    n3 = n5;
                    if (!d22.hasNext()) break;
                    Object object5 = (d)d22.next();
                    object2 = object5.d;
                    n4 = n2 + 1;
                    bl2 = h.a(n4, (e)object2);
                    if (((e)object2).m0() && bl2) {
                        f.U1(n4, (e)object2, b2, new b.a(), b.a.k);
                    }
                    n3 = object5 == ((e)object2).O && (object = ((e)object2).Q.f) != null && object.n() || object5 == ((e)object2).Q && (object = ((e)object2).O.f) != null && object.n() ? n5 : 0;
                    object = ((e)object2).A();
                    if (object == (object4 = e.b.i) && !bl2) {
                        if (((e)object2).A() != object4 || ((e)object2).A < 0 || ((e)object2).z < 0 || ((e)object2).V() != 8 && (((e)object2).w != 0 || ((e)object2).v() != 0.0f) || ((e)object2).i0() || ((e)object2).l0() || n3 == 0 || ((e)object2).i0()) continue;
                        h.e(n4, e2, b2, (e)object2, bl);
                        continue;
                    }
                    if (((e)object2).m0()) continue;
                    object4 = ((e)object2).O;
                    if (object5 == object4 && ((e)object2).Q.f == null) {
                        n3 = ((d)object4).f() + n6;
                        ((e)object2).G0(n3, ((e)object2).W() + n3);
                        h.b(n4, (e)object2, b2, bl);
                        continue;
                    }
                    object = ((e)object2).Q;
                    if (object5 == object && ((d)object4).f == null) {
                        n3 = n6 - object.f();
                        ((e)object2).G0(n3 - ((e)object2).W(), n3);
                        h.b(n4, (e)object2, b2, bl);
                        continue;
                    }
                    if (n3 == 0 || ((e)object2).i0()) continue;
                    h.d(n4, b2, (e)object2, bl);
                }
            }
        }
        if (e2 instanceof u.h) {
            return;
        }
        if (((d)object3).d() != null && ((d)object3).n()) {
            for (d d22 : ((d)object3).d()) {
                object3 = d22.d;
                n4 = n2 + 1;
                bl2 = h.a(n4, (e)object3);
                if (((e)object3).m0() && bl2) {
                    f.U1(n4, (e)object3, b2, new b.a(), b.a.k);
                }
                n5 = d22 == ((e)object3).O && (object2 = ((e)object3).Q.f) != null && ((d)object2).n() || d22 == ((e)object3).Q && (object2 = ((e)object3).O.f) != null && ((d)object2).n() ? n3 : 0;
                object2 = ((e)object3).A();
                if (object2 == (object = e.b.i) && !bl2) {
                    if (((e)object3).A() != object || ((e)object3).A < 0 || ((e)object3).z < 0 || ((e)object3).V() != 8 && (((e)object3).w != 0 || ((e)object3).v() != 0.0f) || ((e)object3).i0() || ((e)object3).l0() || n5 == 0 || ((e)object3).i0()) continue;
                    h.e(n4, e2, b2, (e)object3, bl);
                    continue;
                }
                if (((e)object3).m0()) continue;
                object2 = ((e)object3).O;
                if (d22 == object2 && ((e)object3).Q.f == null) {
                    n5 = ((d)object2).f() + n7;
                    ((e)object3).G0(n5, ((e)object3).W() + n5);
                    h.b(n4, (e)object3, b2, bl);
                    continue;
                }
                object = ((e)object3).Q;
                if (d22 == object && ((d)object2).f == null) {
                    n5 = n7 - object.f();
                    ((e)object3).G0(n5 - ((e)object3).W(), n5);
                    h.b(n4, (e)object3, b2, bl);
                    continue;
                }
                if (n5 == 0 || ((e)object3).i0()) continue;
                h.d(n4, b2, (e)object3, bl);
            }
        }
        e2.q0();
    }

    private static void c(int n2, a a2, b.b b2, int n3, boolean bl) {
        if (a2.u1()) {
            if (n3 == 0) {
                h.b(n2 + 1, a2, b2, bl);
                return;
            }
            h.i(n2 + 1, a2, b2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void d(int n2, b.b b2, e e2, boolean bl) {
        float f2 = e2.y();
        int n3 = e2.O.f.e();
        int n4 = e2.Q.f.e();
        int n5 = e2.O.f();
        int n6 = e2.Q.f();
        if (n3 == n4) {
            f2 = 0.5f;
        } else {
            n3 = n5 + n3;
            n4 -= n6;
        }
        n5 = e2.W();
        n6 = n4 - n3 - n5;
        if (n3 > n4) {
            n6 = n3 - n4 - n5;
        }
        f2 = n6 > 0 ? f2 * (float)n6 + 0.5f : (f2 *= (float)n6);
        n6 = (int)f2;
        int n7 = n6 + n3;
        n6 = n7 + n5;
        if (n3 > n4) {
            n6 = n7 - n5;
        }
        e2.G0(n7, n6);
        h.b(n2 + 1, e2, b2, bl);
    }

    private static void e(int n2, e e2, b.b b2, e e3, boolean bl) {
        float f2 = e3.y();
        int n3 = e3.O.f.e() + e3.O.f();
        int n4 = e3.Q.f.e() - e3.Q.f();
        if (n4 >= n3) {
            int n5;
            int n6 = n5 = e3.W();
            if (e3.V() != 8) {
                int n7 = e3.w;
                if (n7 == 2) {
                    n6 = e2 instanceof f ? e2.W() : e2.K().W();
                    n6 = (int)(e3.y() * 0.5f * (float)n6);
                } else {
                    n6 = n5;
                    if (n7 == 0) {
                        n6 = n4 - n3;
                    }
                }
                n5 = Math.max((int)e3.z, (int)n6);
                n7 = e3.A;
                n6 = n5;
                if (n7 > 0) {
                    n6 = Math.min((int)n7, (int)n5);
                }
            }
            n5 = n3 + (int)(f2 * (float)(n4 - n3 - n6) + 0.5f);
            e3.G0(n5, n6 + n5);
            h.b(n2 + 1, e3, b2, bl);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void f(int n2, b.b b2, e e2) {
        float f2 = e2.R();
        int n3 = e2.P.f.e();
        int n4 = e2.R.f.e();
        int n5 = e2.P.f();
        int n6 = e2.R.f();
        if (n3 == n4) {
            f2 = 0.5f;
        } else {
            n3 = n5 + n3;
            n4 -= n6;
        }
        int n7 = e2.x();
        n6 = n4 - n3 - n7;
        if (n3 > n4) {
            n6 = n3 - n4 - n7;
        }
        f2 = n6 > 0 ? f2 * (float)n6 + 0.5f : (f2 *= (float)n6);
        int n8 = (int)f2;
        n6 = n3 + n8;
        n5 = n6 + n7;
        if (n3 > n4) {
            n6 = n3 - n8;
            n5 = n6 - n7;
        }
        e2.J0(n6, n5);
        h.i(n2 + 1, e2, b2);
    }

    private static void g(int n2, e e2, b.b b2, e e3) {
        float f2 = e3.R();
        int n3 = e3.P.f.e() + e3.P.f();
        int n4 = e3.R.f.e() - e3.R.f();
        if (n4 >= n3) {
            int n5;
            int n6 = n5 = e3.x();
            if (e3.V() != 8) {
                int n7 = e3.x;
                if (n7 == 2) {
                    n6 = e2 instanceof f ? e2.x() : e2.K().x();
                    n6 = (int)(f2 * 0.5f * (float)n6);
                } else {
                    n6 = n5;
                    if (n7 == 0) {
                        n6 = n4 - n3;
                    }
                }
                n5 = Math.max((int)e3.C, (int)n6);
                n7 = e3.D;
                n6 = n5;
                if (n7 > 0) {
                    n6 = Math.min((int)n7, (int)n5);
                }
            }
            n5 = n3 + (int)(f2 * (float)(n4 - n3 - n6) + 0.5f);
            e3.J0(n5, n6 + n5);
            h.i(n2 + 1, e3, b2);
        }
    }

    public static void h(f e2, b.b b2) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        Object object = e2.A();
        Object object2 = e2.T();
        b = 0;
        c = 0;
        e2.v0();
        ArrayList arrayList = ((m)e2).s1();
        int n7 = arrayList.size();
        for (n6 = 0; n6 < n7; ++n6) {
            ((e)arrayList.get(n6)).v0();
        }
        boolean bl = ((f)e2).R1();
        if (object == e.b.g) {
            e2.G0(0, e2.W());
        } else {
            e2.H0(0);
        }
        n6 = n5 = 0;
        for (n4 = 0; n4 < n7; ++n4) {
            object = (e)arrayList.get(n4);
            if (object instanceof u.h) {
                object = (u.h)object;
                n3 = n5;
                n2 = n6;
                if (((u.h)object).t1() == 1) {
                    if (((u.h)object).u1() != -1) {
                        ((u.h)object).x1(((u.h)object).u1());
                    } else if (((u.h)object).v1() != -1 && e2.n0()) {
                        ((u.h)object).x1(e2.W() - ((u.h)object).v1());
                    } else if (e2.n0()) {
                        ((u.h)object).x1((int)(((u.h)object).w1() * (float)e2.W() + 0.5f));
                    }
                    n3 = 1;
                    n2 = n6;
                }
            } else {
                n3 = n5;
                n2 = n6;
                if (object instanceof a) {
                    n3 = n5;
                    n2 = n6;
                    if (((a)object).y1() == 0) {
                        n2 = 1;
                        n3 = n5;
                    }
                }
            }
            n5 = n3;
            n6 = n2;
        }
        if (n5 != 0) {
            for (n5 = 0; n5 < n7; ++n5) {
                object = (e)arrayList.get(n5);
                if (!(object instanceof u.h) || ((u.h)(object = (u.h)object)).t1() != 1) continue;
                h.b(0, (e)object, b2, bl);
            }
        }
        h.b(0, e2, b2, bl);
        if (n6 != 0) {
            for (n6 = 0; n6 < n7; ++n6) {
                object = (e)arrayList.get(n6);
                if (!(object instanceof a) || ((a)(object = (a)object)).y1() != 0) continue;
                h.c(0, (a)object, b2, 0, bl);
            }
        }
        if (object2 == e.b.g) {
            e2.J0(0, e2.x());
        } else {
            e2.I0(0);
        }
        n6 = n5 = 0;
        for (n4 = 0; n4 < n7; ++n4) {
            object2 = (e)arrayList.get(n4);
            if (object2 instanceof u.h) {
                object2 = (u.h)object2;
                n3 = n5;
                n2 = n6;
                if (((u.h)object2).t1() == 0) {
                    if (((u.h)object2).u1() != -1) {
                        ((u.h)object2).x1(((u.h)object2).u1());
                    } else if (((u.h)object2).v1() != -1 && e2.o0()) {
                        ((u.h)object2).x1(e2.x() - ((u.h)object2).v1());
                    } else if (e2.o0()) {
                        ((u.h)object2).x1((int)(((u.h)object2).w1() * (float)e2.x() + 0.5f));
                    }
                    n3 = 1;
                    n2 = n6;
                }
            } else {
                n3 = n5;
                n2 = n6;
                if (object2 instanceof a) {
                    n3 = n5;
                    n2 = n6;
                    if (((a)object2).y1() == 1) {
                        n2 = 1;
                        n3 = n5;
                    }
                }
            }
            n5 = n3;
            n6 = n2;
        }
        if (n5 != 0) {
            for (n5 = 0; n5 < n7; ++n5) {
                object2 = (e)arrayList.get(n5);
                if (!(object2 instanceof u.h) || ((u.h)(object2 = (u.h)object2)).t1() != 0) continue;
                h.i(1, (e)object2, b2);
            }
        }
        h.i(0, e2, b2);
        if (n6 != 0) {
            for (n6 = 0; n6 < n7; ++n6) {
                e2 = (e)arrayList.get(n6);
                if (!(e2 instanceof a) || ((a)(e2 = (a)e2)).y1() != 1) continue;
                h.c(0, (a)e2, b2, 1, bl);
            }
        }
        for (n6 = 0; n6 < n7; ++n6) {
            e2 = (e)arrayList.get(n6);
            if (!e2.m0() || !h.a(0, e2)) continue;
            f.U1(0, e2, b2, a, b.a.k);
            if (e2 instanceof u.h) {
                if (((u.h)e2).t1() == 0) {
                    h.i(0, e2, b2);
                    continue;
                }
                h.b(0, e2, b2, bl);
                continue;
            }
            h.b(0, e2, b2, bl);
            h.i(0, e2, b2);
        }
    }

    private static void i(int n2, e e2, b.b b2) {
        Object object;
        boolean bl;
        Object object2;
        Object object32;
        if (e2.p0()) {
            return;
        }
        int n3 = c;
        int n4 = 1;
        int n5 = 1;
        c = n3 + 1;
        if (!(e2 instanceof f) && e2.m0() && h.a(n3 = n2 + 1, e2)) {
            f.U1(n3, e2, b2, new b.a(), b.a.k);
        }
        Object object4 = e2.o(d.a.i);
        d d2 = e2.o(d.a.k);
        int n6 = ((d)object4).e();
        int n7 = d2.e();
        n3 = n4;
        if (((d)object4).d() != null) {
            n3 = n4;
            if (((d)object4).n()) {
                object32 = ((d)object4).d().iterator();
                while (true) {
                    Object object5;
                    n3 = n5;
                    if (!object32.hasNext()) break;
                    object2 = (d)object32.next();
                    object4 = object2.d;
                    n4 = n2 + 1;
                    bl = h.a(n4, (e)object4);
                    if (((e)object4).m0() && bl) {
                        f.U1(n4, (e)object4, b2, new b.a(), b.a.k);
                    }
                    n3 = object2 == ((e)object4).P && (object = ((e)object4).R.f) != null && object.n() || object2 == ((e)object4).R && (object = ((e)object4).P.f) != null && object.n() ? n5 : 0;
                    object = ((e)object4).T();
                    if (object == (object5 = e.b.i) && !bl) {
                        if (((e)object4).T() != object5 || ((e)object4).D < 0 || ((e)object4).C < 0 || ((e)object4).V() != 8 && (((e)object4).x != 0 || ((e)object4).v() != 0.0f) || ((e)object4).k0() || ((e)object4).l0() || n3 == 0 || ((e)object4).k0()) continue;
                        h.g(n4, e2, b2, (e)object4);
                        continue;
                    }
                    if (((e)object4).m0()) continue;
                    object5 = ((e)object4).P;
                    if (object2 == object5 && ((e)object4).R.f == null) {
                        n3 = ((d)object5).f() + n6;
                        ((e)object4).J0(n3, ((e)object4).x() + n3);
                        h.i(n4, (e)object4, b2);
                        continue;
                    }
                    object = ((e)object4).R;
                    if (object2 == object && ((d)object5).f == null) {
                        n3 = n6 - object.f();
                        ((e)object4).J0(n3 - ((e)object4).x(), n3);
                        h.i(n4, (e)object4, b2);
                        continue;
                    }
                    if (n3 == 0 || ((e)object4).k0()) continue;
                    h.f(n4, b2, (e)object4);
                }
            }
        }
        if (e2 instanceof u.h) {
            return;
        }
        if (d2.d() != null && d2.n()) {
            d2 = d2.d().iterator();
            while (d2.hasNext()) {
                object32 = (d)d2.next();
                object4 = ((d)object32).d;
                n4 = n2 + 1;
                bl = h.a(n4, (e)object4);
                if (((e)object4).m0() && bl) {
                    f.U1(n4, (e)object4, b2, new b.a(), b.a.k);
                }
                n5 = object32 == ((e)object4).P && (object2 = ((e)object4).R.f) != null && object2.n() || object32 == ((e)object4).R && (object2 = ((e)object4).P.f) != null && object2.n() ? n3 : 0;
                object2 = ((e)object4).T();
                if (object2 == (object = e.b.i) && !bl) {
                    if (((e)object4).T() != object || ((e)object4).D < 0 || ((e)object4).C < 0 || ((e)object4).V() != 8 && (((e)object4).x != 0 || ((e)object4).v() != 0.0f) || ((e)object4).k0() || ((e)object4).l0() || n5 == 0 || ((e)object4).k0()) continue;
                    h.g(n4, e2, b2, (e)object4);
                    continue;
                }
                if (((e)object4).m0()) continue;
                object = ((e)object4).P;
                if (object32 == object && ((e)object4).R.f == null) {
                    n5 = object.f() + n7;
                    ((e)object4).J0(n5, ((e)object4).x() + n5);
                    h.i(n4, (e)object4, b2);
                    continue;
                }
                object2 = ((e)object4).R;
                if (object32 == object2 && object.f == null) {
                    n5 = n7 - object2.f();
                    ((e)object4).J0(n5 - ((e)object4).x(), n5);
                    h.i(n4, (e)object4, b2);
                    continue;
                }
                if (n5 == 0 || ((e)object4).k0()) continue;
                h.f(n4, b2, (e)object4);
            }
        }
        if ((d2 = e2.o(d.a.l)).d() != null && d2.n()) {
            n3 = d2.e();
            for (Object object32 : d2.d()) {
                object4 = ((d)object32).d;
                n5 = n2 + 1;
                bl = h.a(n5, (e)object4);
                if (((e)object4).m0() && bl) {
                    f.U1(n5, (e)object4, b2, new b.a(), b.a.k);
                }
                if (((e)object4).T() == e.b.i && !bl || ((e)object4).m0() || object32 != ((e)object4).S) continue;
                ((e)object4).F0(((d)object32).f() + n3);
                h.i(n5, (e)object4, b2);
            }
        }
        e2.r0();
    }
}

