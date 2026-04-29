/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.HashSet
 */
package v;

import java.util.ArrayList;
import java.util.HashSet;
import u.e;
import u.h;
import v.b;
import v.c;
import v.d;
import v.f;
import v.g;
import v.j;
import v.k;
import v.l;
import v.m;
import v.n;
import v.p;

public class e {
    private u.f a;
    private boolean b = true;
    private boolean c = true;
    private u.f d;
    private ArrayList e = new ArrayList();
    private ArrayList f = new ArrayList();
    private b.b g = null;
    private b.a h = new b.a();
    ArrayList i = new ArrayList();

    public e(u.f f2) {
        this.a = f2;
        this.d = f2;
    }

    private void a(f object, int n2, int n3, f f2, ArrayList arrayList, m object22) {
        d d22 = ((f)object).d;
        if (d22.c == null) {
            object = this.a;
            if (d22 != ((u.e)object).e && d22 != ((u.e)object).f) {
                object = object22;
                if (object22 == null) {
                    object = new m((p)d22, n3);
                    arrayList.add(object);
                }
                d22.c = object;
                ((m)object).a((p)d22);
                for (d d3 : d22.h.k) {
                    if (!(d3 instanceof f)) continue;
                    this.a((f)d3, n2, 0, f2, arrayList, (m)object);
                }
                for (d d3 : d22.i.k) {
                    if (!(d3 instanceof f)) continue;
                    this.a((f)d3, n2, 1, f2, arrayList, (m)object);
                }
                if (n2 == 1 && d22 instanceof n) {
                    for (d d3 : ((n)d22).k.k) {
                        if (!(d3 instanceof f)) continue;
                        this.a((f)d3, n2, 2, f2, arrayList, (m)object);
                    }
                }
                for (Object object22 : d22.h.l) {
                    if (object22 == f2) {
                        ((m)object).b = true;
                    }
                    this.a((f)object22, n2, 0, f2, arrayList, (m)object);
                }
                for (Object object22 : d22.i.l) {
                    if (object22 == f2) {
                        ((m)object).b = true;
                    }
                    this.a((f)object22, n2, 1, f2, arrayList, (m)object);
                }
                if (n2 == 1 && d22 instanceof n) {
                    for (d d22 : ((n)d22).k.l) {
                        this.a((f)d22, n2, 2, f2, arrayList, (m)object);
                    }
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private boolean b(u.f f2) {
        ArrayList arrayList = f2.L0;
        int n2 = arrayList.size();
        int n3 = 0;
        int n4 = 0;
        while (true) {
            int n5;
            block39: {
                void var11_52;
                void var10_38;
                u.d[] dArray;
                int n6;
                void var9_18;
                u.e e2;
                block35: {
                    block36: {
                        float f3;
                        float f4;
                        void var10_33;
                        e.b b2;
                        block42: {
                            e.b b3;
                            void var11_48;
                            block45: {
                                block44: {
                                    block43: {
                                        block37: {
                                            e.b b4;
                                            block41: {
                                                block40: {
                                                    block38: {
                                                        block34: {
                                                            block32: {
                                                                block33: {
                                                                    e.b b5;
                                                                    block30: {
                                                                        block31: {
                                                                            if (n4 >= n2) {
                                                                                return n3 != 0;
                                                                            }
                                                                            Object object = arrayList.get(n4);
                                                                            n5 = n4 + 1;
                                                                            e2 = (u.e)object;
                                                                            e.b[] bArray = e2.Z;
                                                                            e.b b6 = bArray[n3];
                                                                            b5 = bArray[1];
                                                                            if (e2.V() == 8) {
                                                                                e2.a = true;
                                                                                n4 = n5;
                                                                                continue;
                                                                            }
                                                                            if (e2.B < 1.0f && b6 == e.b.i) {
                                                                                e2.w = 2;
                                                                            }
                                                                            if (e2.E < 1.0f && b5 == e.b.i) {
                                                                                e2.x = 2;
                                                                            }
                                                                            if (e2.v() > 0.0f) {
                                                                                e.b b7 = e.b.i;
                                                                                if (b6 == b7 && (b5 == e.b.h || b5 == e.b.g)) {
                                                                                    e2.w = 3;
                                                                                } else if (b5 == b7 && (b6 == e.b.h || b6 == e.b.g)) {
                                                                                    e2.x = 3;
                                                                                } else if (b6 == b7 && b5 == b7) {
                                                                                    if (e2.w == 0) {
                                                                                        e2.w = 3;
                                                                                    }
                                                                                    if (e2.x == 0) {
                                                                                        e2.x = 3;
                                                                                    }
                                                                                }
                                                                            }
                                                                            b2 = e.b.i;
                                                                            e.b b8 = b6;
                                                                            if (b6 != b2) break block30;
                                                                            e.b b9 = b6;
                                                                            if (e2.w != 1) break block30;
                                                                            if (e2.O.f == null) break block31;
                                                                            e.b b10 = b6;
                                                                            if (e2.Q.f != null) break block30;
                                                                        }
                                                                        e.b b11 = e.b.h;
                                                                    }
                                                                    e.b b12 = b5;
                                                                    if (b5 != b2) break block32;
                                                                    e.b b13 = b5;
                                                                    if (e2.x != 1) break block32;
                                                                    if (e2.P.f == null) break block33;
                                                                    e.b b14 = b5;
                                                                    if (e2.R.f != null) break block32;
                                                                }
                                                                e.b b15 = e.b.h;
                                                            }
                                                            l l2 = e2.e;
                                                            l2.d = var10_33;
                                                            l2.a = n4 = e2.w;
                                                            n n7 = e2.f;
                                                            n7.d = var9_18;
                                                            n7.a = n6 = e2.x;
                                                            dArray = e.b.j;
                                                            if (var10_33 != dArray && var10_33 != e.b.g && var10_33 != e.b.h || var9_18 != dArray && var9_18 != e.b.g && var9_18 != e.b.h) break block34;
                                                            void var11_43 = var10_33;
                                                            n4 = e2.W();
                                                            void var10_36 = var11_43;
                                                            if (var11_43 != dArray) break block35;
                                                            break block36;
                                                        }
                                                        if (var10_33 != b2 || var9_18 != (b4 = e.b.h) && var9_18 != e.b.g) break block37;
                                                        if (n4 != 3) break block38;
                                                        if (var9_18 == b4) {
                                                            this.l(e2, b4, 0, b4, 0);
                                                        }
                                                        n4 = e2.x();
                                                        n6 = (int)((float)n4 * e2.d0 + 0.5f);
                                                        e.b b16 = e.b.g;
                                                        this.l(e2, b16, n6, b16, n4);
                                                        e2.e.e.d(e2.W());
                                                        e2.f.e.d(e2.x());
                                                        e2.a = true;
                                                        break block39;
                                                    }
                                                    if (n4 != 1) break block40;
                                                    this.l(e2, b4, 0, (e.b)var9_18, 0);
                                                    e2.e.e.m = e2.W();
                                                    break block39;
                                                }
                                                if (n4 != 2) break block41;
                                                e.b b17 = f2.Z[n3];
                                                e.b b18 = e.b.g;
                                                if (b17 != b18 && b17 != dArray) break block37;
                                                this.l(e2, b18, (int)(e2.B * (float)f2.W() + 0.5f), (e.b)var9_18, e2.x());
                                                e2.e.e.d(e2.W());
                                                e2.f.e.d(e2.x());
                                                e2.a = true;
                                                break block39;
                                            }
                                            u.d[] dArray2 = e2.W;
                                            if (dArray2[n3].f != null && dArray2[1].f != null) break block37;
                                            this.l(e2, b4, 0, (e.b)var9_18, 0);
                                            e2.e.e.d(e2.W());
                                            e2.f.e.d(e2.x());
                                            e2.a = true;
                                            break block39;
                                        }
                                        if ((var11_48 = var9_18) != b2 || var10_33 != (b3 = e.b.h) && var10_33 != e.b.g) break block42;
                                        if (n6 != 3) break block43;
                                        if (var10_33 == b3) {
                                            this.l(e2, b3, 0, b3, 0);
                                        }
                                        n6 = e2.W();
                                        f3 = f4 = e2.d0;
                                        if (e2.w() == -1) {
                                            f3 = 1.0f / f4;
                                        }
                                        n4 = (int)((float)n6 * f3 + 0.5f);
                                        e.b b19 = e.b.g;
                                        this.l(e2, b19, n6, b19, n4);
                                        e2.e.e.d(e2.W());
                                        e2.f.e.d(e2.x());
                                        e2.a = true;
                                        break block39;
                                    }
                                    if (n6 != 1) break block44;
                                    this.l(e2, (e.b)var10_33, 0, b3, 0);
                                    e2.f.e.m = e2.x();
                                    break block39;
                                }
                                if (n6 != 2) break block45;
                                e.b b20 = f2.Z[1];
                                e.b b21 = e.b.g;
                                if (b20 != b21 && b20 != dArray) break block42;
                                f3 = e2.E;
                                this.l(e2, (e.b)var10_33, e2.W(), b21, (int)(f3 * (float)f2.x() + 0.5f));
                                e2.e.e.d(e2.W());
                                e2.f.e.d(e2.x());
                                e2.a = true;
                                break block39;
                            }
                            dArray = e2.W;
                            if (dArray[2].f != null && dArray[3].f != null) break block42;
                            this.l(e2, b3, 0, (e.b)var11_48, 0);
                            e2.e.e.d(e2.W());
                            e2.f.e.d(e2.x());
                            e2.a = true;
                            break block39;
                        }
                        if (var10_33 != b2 || var9_18 != b2) break block39;
                        if (n4 != 1 && n6 != 1) {
                            e.b b22;
                            e.b[] bArray;
                            e.b b23;
                            if (n6 == 2 && n4 == 2 && (b23 = (bArray = f2.Z)[n3]) == (b22 = e.b.g) && bArray[1] == b22) {
                                f3 = e2.B;
                                f4 = e2.E;
                                this.l(e2, b22, (int)(f3 * (float)f2.W() + 0.5f), b22, (int)(f4 * (float)f2.x() + 0.5f));
                                e2.e.e.d(e2.W());
                                e2.f.e.d(e2.x());
                                e2.a = true;
                            }
                            break block39;
                        } else {
                            e.b b24 = e.b.h;
                            this.l(e2, b24, 0, b24, 0);
                            e2.e.e.m = e2.W();
                            e2.f.e.m = e2.x();
                        }
                        break block39;
                    }
                    n4 = f2.W() - e2.O.g - e2.Q.g;
                    e.b b25 = e.b.g;
                }
                n6 = e2.x();
                void var11_50 = var9_18;
                if (var9_18 == dArray) {
                    n6 = f2.x() - e2.P.g - e2.R.g;
                    e.b b26 = e.b.g;
                }
                this.l(e2, (e.b)var10_38, n4, (e.b)var11_52, n6);
                e2.e.e.d(e2.W());
                e2.f.e.d(e2.x());
                e2.a = true;
            }
            n4 = n5;
        }
    }

    private int e(u.f f2, int n2) {
        int n3 = this.i.size();
        long l2 = 0L;
        for (int i2 = 0; i2 < n3; ++i2) {
            l2 = Math.max((long)l2, (long)((m)this.i.get(i2)).b(f2, n2));
        }
        return (int)l2;
    }

    private void i(p d22, int n2, ArrayList arrayList) {
        for (d d3 : d22.h.k) {
            if (d3 instanceof f) {
                this.a((f)d3, n2, 0, d22.i, arrayList, null);
                continue;
            }
            if (!(d3 instanceof p)) continue;
            this.a(((p)d3).h, n2, 0, d22.i, arrayList, null);
        }
        for (d d3 : d22.i.k) {
            if (d3 instanceof f) {
                this.a((f)d3, n2, 1, d22.h, arrayList, null);
                continue;
            }
            if (!(d3 instanceof p)) continue;
            this.a(((p)d3).i, n2, 1, d22.h, arrayList, null);
        }
        if (n2 == 1) {
            for (d d22 : ((n)d22).k.k) {
                if (!(d22 instanceof f)) continue;
                this.a((f)d22, n2, 2, null, arrayList, null);
            }
        }
    }

    private void l(u.e e2, e.b b2, int n2, e.b b3, int n3) {
        b.a a2 = this.h;
        a2.a = b2;
        a2.b = b3;
        a2.c = n2;
        a2.d = n3;
        this.g.b(e2, a2);
        e2.l1(this.h.e);
        e2.M0(this.h.f);
        e2.L0(this.h.h);
        e2.B0(this.h.g);
    }

    public void c() {
        this.d(this.e);
        this.i.clear();
        m.h = 0;
        this.i(this.a.e, 0, this.i);
        this.i(this.a.f, 1, this.i);
        this.b = false;
    }

    public void d(ArrayList arrayList) {
        int n2;
        arrayList.clear();
        this.d.e.f();
        this.d.f.f();
        arrayList.add((Object)this.d.e);
        arrayList.add((Object)this.d.f);
        ArrayList arrayList2 = this.d.L0;
        int n3 = arrayList2.size();
        Object object = null;
        int n4 = 0;
        int n5 = 0;
        while (n5 < n3) {
            Object object2 = arrayList2.get(n5);
            n2 = n5 + 1;
            u.e e2 = (u.e)object2;
            if (e2 instanceof h) {
                arrayList.add((Object)new j(e2));
                n5 = n2;
                continue;
            }
            if (e2.i0()) {
                if (e2.c == null) {
                    e2.c = new c(e2, 0);
                }
                object2 = object;
                if (object == null) {
                    object2 = new HashSet();
                }
                object2.add((Object)e2.c);
                object = object2;
            } else {
                arrayList.add((Object)e2.e);
            }
            if (e2.k0()) {
                if (e2.d == null) {
                    e2.d = new c(e2, 1);
                }
                object2 = object;
                if (object == null) {
                    object2 = new HashSet();
                }
                object2.add((Object)e2.d);
            } else {
                arrayList.add((Object)e2.f);
                object2 = object;
            }
            object = object2;
            n5 = n2;
            if (!(e2 instanceof u.j)) continue;
            arrayList.add((Object)new k(e2));
            object = object2;
            n5 = n2;
        }
        if (object != null) {
            arrayList.addAll(object);
        }
        n2 = arrayList.size();
        for (n5 = 0; n5 < n2; ++n5) {
            object = arrayList.get(n5);
            ((p)object).f();
        }
        n2 = arrayList.size();
        for (n5 = n4; n5 < n2; ++n5) {
            object = arrayList.get(n5);
            object = (p)object;
            if (((p)object).b == this.d) continue;
            ((p)object).d();
        }
    }

    public boolean f(boolean bl) {
        Object object;
        Object object2;
        block20: {
            Object object3;
            int n2;
            int n3;
            int n4;
            boolean bl2 = this.b;
            boolean bl3 = false;
            if (bl2 || this.c) {
                object2 = this.a.L0;
                n4 = object2.size();
                for (n3 = 0; n3 < n4; ++n3) {
                    object = object2.get(n3);
                    object = (u.e)object;
                    ((u.e)object).n();
                    ((u.e)object).a = false;
                    ((u.e)object).e.r();
                    ((u.e)object).f.q();
                }
                this.a.n();
                object2 = this.a;
                object2.a = false;
                object2.e.r();
                this.a.f.q();
                this.c = false;
            }
            if (this.b(this.d)) {
                return false;
            }
            this.a.n1(0);
            this.a.o1(0);
            object = this.a.u(0);
            object2 = this.a.u(1);
            if (this.b) {
                this.c();
            }
            int n5 = this.a.X();
            n4 = this.a.Y();
            this.a.e.h.d(n5);
            this.a.f.h.d(n4);
            this.m();
            Object object4 = e.b.h;
            if (object == object4 || object2 == object4) {
                block19: {
                    bl2 = bl;
                    if (bl) {
                        object4 = this.e;
                        n2 = object4.size();
                        n3 = 0;
                        do {
                            bl2 = bl;
                            if (n3 >= n2) break block19;
                            object3 = object4.get(n3);
                            ++n3;
                        } while (((p)object3).m());
                        bl2 = false;
                    }
                }
                if (bl2 && object == e.b.h) {
                    this.a.Q0(e.b.g);
                    object4 = this.a;
                    ((u.e)object4).l1(this.e((u.f)object4, 0));
                    object4 = this.a;
                    ((u.e)object4).e.e.d(((u.e)object4).W());
                }
                if (bl2 && object2 == e.b.h) {
                    this.a.h1(e.b.g);
                    object4 = this.a;
                    ((u.e)object4).M0(this.e((u.f)object4, 1));
                    object4 = this.a;
                    ((u.e)object4).f.e.d(((u.e)object4).x());
                }
            }
            Object object5 = this.a;
            object3 = object5.Z[0];
            object4 = e.b.g;
            if (object3 != object4 && object3 != e.b.j) {
                n3 = 0;
            } else {
                n3 = object5.W() + n5;
                this.a.e.i.d(n3);
                this.a.e.e.d(n3 - n5);
                this.m();
                object3 = this.a;
                object5 = ((u.e)object3).Z[1];
                if (object5 == object4 || object5 == e.b.j) {
                    n3 = ((u.e)object3).x() + n4;
                    this.a.f.i.d(n3);
                    this.a.f.e.d(n3 - n4);
                }
                this.m();
                n3 = 1;
            }
            object4 = this.e;
            n5 = object4.size();
            for (n4 = 0; n4 < n5; ++n4) {
                object3 = object4.get(n4);
                object3 = (p)object3;
                if (((p)object3).b == this.a && !((p)object3).g) continue;
                ((p)object3).e();
            }
            object4 = this.e;
            n2 = object4.size();
            n4 = 0;
            while (n4 < n2) {
                object3 = object4.get(n4);
                n5 = n4 + 1;
                object3 = (p)object3;
                if (n3 == 0 && ((p)object3).b == this.a) {
                    n4 = n5;
                    continue;
                }
                if (!((p)object3).h.j) {
                    bl = bl3;
                } else if (!((p)object3).i.j && !(object3 instanceof j)) {
                    bl = bl3;
                } else {
                    n4 = n5;
                    if (((p)object3).e.j) continue;
                    n4 = n5;
                    if (object3 instanceof c) continue;
                    n4 = n5;
                    if (object3 instanceof j) continue;
                    bl = bl3;
                }
                break block20;
            }
            bl = true;
        }
        this.a.Q0((e.b)((Object)object));
        this.a.h1((e.b)((Object)object2));
        return bl;
    }

    public boolean g(boolean bl) {
        if (this.b) {
            Object object = this.a.L0;
            int n2 = object.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object2 = object.get(i2);
                object2 = (u.e)object2;
                ((u.e)object2).n();
                ((u.e)object2).a = false;
                l l2 = ((u.e)object2).e;
                l2.e.j = false;
                l2.g = false;
                l2.r();
                object2 = ((u.e)object2).f;
                ((p)object2).e.j = false;
                ((p)object2).g = false;
                ((n)object2).q();
            }
            this.a.n();
            object = this.a;
            ((u.e)object).a = false;
            object = ((u.e)object).e;
            ((p)object).e.j = false;
            ((p)object).g = false;
            ((l)object).r();
            object = this.a.f;
            ((p)object).e.j = false;
            ((p)object).g = false;
            ((n)object).q();
            this.c();
        }
        if (this.b(this.d)) {
            return false;
        }
        this.a.n1(0);
        this.a.o1(0);
        this.a.e.h.d(0);
        this.a.f.h.d(0);
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean h(boolean var1_1, int var2_2) {
        block20: {
            block19: {
                block21: {
                    var10_3 /* !! */  = this.a;
                    var9_4 = false;
                    var11_5 = var10_3 /* !! */ .u(0);
                    var10_3 /* !! */  = this.a.u(1);
                    var6_6 = this.a.X();
                    var5_7 = this.a.Y();
                    if (var1_1 && (var11_5 == (var12_8 /* !! */  = e.b.h) || var10_3 /* !! */  == var12_8 /* !! */ )) {
                        block18: {
                            var12_8 /* !! */  = this.e;
                            var7_9 = var12_8 /* !! */ .size();
                            var3_10 = 0;
                            while (true) {
                                var8_12 = var1_1;
                                if (var3_10 >= var7_9) break block18;
                                var13_13 /* !! */  = var12_8 /* !! */ .get(var3_10);
                                var4_11 = var3_10 + 1;
                                var13_13 /* !! */  = (p)var13_13 /* !! */ ;
                                var3_10 = var4_11;
                                if (var13_13 /* !! */ .f != var2_2) continue;
                                var3_10 = var4_11;
                                if (!var13_13 /* !! */ .m()) break;
                            }
                            var8_12 = false;
                        }
                        if (var2_2 == 0) {
                            if (var8_12 && var11_5 == e.b.h) {
                                this.a.Q0(e.b.g);
                                var12_8 /* !! */  = this.a;
                                var12_8 /* !! */ .l1(this.e((u.f)var12_8 /* !! */ , 0));
                                var12_8 /* !! */  = this.a;
                                var12_8 /* !! */ .e.e.d(var12_8 /* !! */ .W());
                            }
                        } else if (var8_12 && var10_3 /* !! */  == e.b.h) {
                            this.a.h1(e.b.g);
                            var12_8 /* !! */  = this.a;
                            var12_8 /* !! */ .M0(this.e((u.f)var12_8 /* !! */ , 1));
                            var12_8 /* !! */  = this.a;
                            var12_8 /* !! */ .f.e.d(var12_8 /* !! */ .x());
                        }
                    }
                    if (var2_2 != 0) break block21;
                    var12_8 /* !! */  = this.a;
                    var13_13 /* !! */  = var12_8 /* !! */ .Z[0];
                    if (var13_13 /* !! */  == e.b.g || var13_13 /* !! */  == e.b.j) {
                        var3_10 = var12_8 /* !! */ .W() + var6_6;
                        this.a.e.i.d(var3_10);
                        this.a.e.e.d(var3_10 - var6_6);
lbl45:
                        // 2 sources

                        while (true) {
                            var3_10 = 1;
                            break block19;
                            break;
                        }
                    }
                    ** GOTO lbl-1000
                }
                var13_13 /* !! */  = this.a;
                var12_8 /* !! */  = var13_13 /* !! */ .Z[1];
                if (var12_8 /* !! */  != e.b.g && var12_8 /* !! */  != e.b.j) lbl-1000:
                // 2 sources

                {
                    var3_10 = 0;
                } else {
                    var3_10 = var13_13 /* !! */ .x() + var5_7;
                    this.a.f.i.d(var3_10);
                    this.a.f.e.d(var3_10 - var5_7);
                    ** continue;
                }
            }
            this.m();
            var12_8 /* !! */  = this.e;
            var5_7 = var12_8 /* !! */ .size();
            for (var4_11 = 0; var4_11 < var5_7; ++var4_11) {
                var13_13 /* !! */  = var12_8 /* !! */ .get(var4_11);
                var13_13 /* !! */  = (p)var13_13 /* !! */ ;
                if (var13_13 /* !! */ .f != var2_2 || var13_13 /* !! */ .b == this.a && !var13_13 /* !! */ .g) continue;
                var13_13 /* !! */ .e();
            }
            var12_8 /* !! */  = this.e;
            var6_6 = var12_8 /* !! */ .size();
            var4_11 = 0;
            while (var4_11 < var6_6) {
                var13_13 /* !! */  = var12_8 /* !! */ .get(var4_11);
                var5_7 = var4_11 + 1;
                var13_13 /* !! */  = (p)var13_13 /* !! */ ;
                if (var13_13 /* !! */ .f != var2_2) {
                    var4_11 = var5_7;
                    continue;
                }
                if (var3_10 == 0 && var13_13 /* !! */ .b == this.a) {
                    var4_11 = var5_7;
                    continue;
                }
                if (!var13_13 /* !! */ .h.j) {
                    var1_1 = var9_4;
                } else if (!var13_13 /* !! */ .i.j) {
                    var1_1 = var9_4;
                } else {
                    var4_11 = var5_7;
                    if (var13_13 /* !! */  instanceof c) continue;
                    var4_11 = var5_7;
                    if (var13_13 /* !! */ .e.j) continue;
                    var1_1 = var9_4;
                }
                break block20;
            }
            var1_1 = true;
        }
        this.a.Q0(var11_5);
        this.a.h1((e.b)var10_3 /* !! */ );
        return var1_1;
    }

    public void j() {
        this.b = true;
    }

    public void k() {
        this.c = true;
    }

    public void m() {
        ArrayList arrayList = this.a.L0;
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            Object object = arrayList.get(n3);
            int n4 = n3 + 1;
            object = (u.e)object;
            if (((u.e)object).a) {
                n3 = n4;
                continue;
            }
            Object object2 = ((u.e)object).Z;
            e.b b2 = object2[0];
            e.b b3 = object2[1];
            n3 = ((u.e)object).w;
            int n5 = ((u.e)object).x;
            e.b b4 = e.b.h;
            n3 = b2 != b4 && (b2 != e.b.i || n3 != 1) ? 0 : 1;
            n5 = b3 != b4 && (b3 != e.b.i || n5 != 1) ? 0 : 1;
            object2 = ((u.e)object).e.e;
            boolean bl = ((f)object2).j;
            g g2 = ((u.e)object).f.e;
            boolean bl2 = g2.j;
            if (bl && bl2) {
                b2 = e.b.g;
                this.l((u.e)object, b2, ((f)object2).g, b2, g2.g);
                ((u.e)object).a = true;
            } else if (bl && n5 != 0) {
                this.l((u.e)object, e.b.g, ((f)object2).g, b4, g2.g);
                if (b3 == e.b.i) {
                    ((u.e)object).f.e.m = ((u.e)object).x();
                } else {
                    ((u.e)object).f.e.d(((u.e)object).x());
                    ((u.e)object).a = true;
                }
            } else if (bl2 && n3 != 0) {
                this.l((u.e)object, b4, ((f)object2).g, e.b.g, g2.g);
                if (b2 == e.b.i) {
                    ((u.e)object).e.e.m = ((u.e)object).W();
                } else {
                    ((u.e)object).e.e.d(((u.e)object).W());
                    ((u.e)object).a = true;
                }
            }
            n3 = n4;
            if (!((u.e)object).a) continue;
            object2 = ((u.e)object).f.l;
            n3 = n4;
            if (object2 == null) continue;
            ((g)object2).d(((u.e)object).p());
            n3 = n4;
        }
    }

    public void n(b.b b2) {
        this.g = b2;
    }
}

