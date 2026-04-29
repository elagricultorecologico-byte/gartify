/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package v;

import java.util.ArrayList;
import r.d;
import u.d;
import u.e;
import u.f;
import u.h;
import u.i;
import u.k;
import u.l;

public class b {
    private final ArrayList a = new ArrayList();
    private a b = new a();
    private f c;

    public b(f f2) {
        this.c = f2;
    }

    private boolean a(b object, e e2, int n2) {
        this.b.a = e2.A();
        this.b.b = e2.T();
        this.b.c = e2.W();
        this.b.d = e2.x();
        a a2 = this.b;
        a2.i = false;
        a2.j = n2;
        e.b b2 = a2.a;
        e.b b3 = e.b.i;
        boolean bl = b2 == b3;
        n2 = a2.b == b3 ? 1 : 0;
        bl = bl && e2.d0 > 0.0f;
        n2 = n2 != 0 && e2.d0 > 0.0f ? 1 : 0;
        if (bl && e2.y[0] == 4) {
            a2.a = e.b.g;
        }
        if (n2 != 0 && e2.y[1] == 4) {
            a2.b = e.b.g;
        }
        object.b(e2, a2);
        e2.l1(this.b.e);
        e2.M0(this.b.f);
        e2.L0(this.b.h);
        e2.B0(this.b.g);
        object = this.b;
        ((a)object).j = v.b$a.k;
        return ((a)object).i;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void b(f var1_1) {
        var6_2 = var1_1.L0.size();
        var7_3 = var1_1.V1(64);
        var9_4 = var1_1.K1();
        for (var4_5 = 0; var4_5 < var6_2; ++var4_5) {
            block11: {
                var8_9 = (e)var1_1.L0.get(var4_5);
                if (var8_9 instanceof h || var8_9 instanceof u.a || var8_9.l0() || var7_3 && (var10_10 /* !! */  = var8_9.e) != null && (var11_11 /* !! */  = var8_9.f) != null && var10_10 /* !! */ .e.j && var11_11 /* !! */ .e.j) continue;
                var12_12 = var8_9.u(0);
                var5_8 = true;
                var11_11 /* !! */  = var8_9.u(1);
                var10_10 /* !! */  = e.b.i;
                var2_6 = var12_12 == var10_10 /* !! */  && var8_9.w != 1 && var11_11 /* !! */  == var10_10 /* !! */  && var8_9.x != 1;
                var3_7 = var2_6;
                if (var2_6) ** GOTO lbl-1000
                var3_7 = var2_6;
                if (!var1_1.V1(1)) ** GOTO lbl-1000
                var3_7 = var2_6;
                if (var8_9 instanceof l) ** GOTO lbl-1000
                var3_7 = var2_6;
                if (var12_12 == var10_10 /* !! */ ) {
                    var3_7 = var2_6;
                    if (var8_9.w == 0) {
                        var3_7 = var2_6;
                        if (var11_11 /* !! */  != var10_10 /* !! */ ) {
                            var3_7 = var2_6;
                            if (!var8_9.i0()) {
                                var3_7 = true;
                            }
                        }
                    }
                }
                var2_6 = var3_7;
                if (var11_11 /* !! */  == var10_10 /* !! */ ) {
                    var2_6 = var3_7;
                    if (var8_9.x == 0) {
                        var2_6 = var3_7;
                        if (var12_12 != var10_10 /* !! */ ) {
                            var2_6 = var3_7;
                            if (!var8_9.i0()) {
                                var2_6 = true;
                            }
                        }
                    }
                }
                if (var12_12 == var10_10 /* !! */ ) break block11;
                var3_7 = var2_6;
                if (var11_11 /* !! */  != var10_10 /* !! */ ) ** GOTO lbl-1000
            }
            var3_7 = var2_6;
            if (var8_9.d0 > 0.0f) {
                var2_6 = var5_8;
            } else lbl-1000:
            // 5 sources

            {
                var2_6 = var3_7;
            }
            if (var2_6) continue;
            this.a(var9_4, var8_9, v.b$a.k);
        }
        var9_4.a();
    }

    private void c(f f2, String string, int n2, int n3, int n4) {
        f2.getClass();
        int n5 = f2.I();
        int n6 = f2.H();
        f2.b1(0);
        f2.a1(0);
        f2.l1(n3);
        f2.M0(n4);
        f2.b1(n5);
        f2.a1(n6);
        this.c.Z1(n2);
        this.c.t1();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public long d(f f2, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        void var21_21;
        int n11;
        e.b b2;
        Object object;
        b b3 = f2.K1();
        int n12 = f2.L0.size();
        n10 = f2.W();
        int n13 = f2.x();
        boolean bl = k.b(n2, 128);
        n2 = !bl && !k.b(n2, 64) ? 0 : 1;
        if (n2 != 0) {
            for (n3 = 0; n3 < n12; ++n3) {
                object = (e)f2.L0.get(n3);
                e.b b4 = ((e)object).A();
                n4 = b4 == (b2 = e.b.i) ? 1 : 0;
                n9 = ((e)object).T() == b2 ? 1 : 0;
                n4 = n4 != 0 && n9 != 0 && ((e)object).v() > 0.0f ? 1 : 0;
                if (!(((e)object).i0() && n4 != 0 || ((e)object).k0() && n4 != 0 || object instanceof l || ((e)object).i0()) && !((e)object).k0()) continue;
                n2 = 0;
                break;
            }
        }
        if (n2 != 0) {
            boolean bl2 = d.s;
        }
        if ((n11 = n2 & (n3 = n5 == 0x40000000 && n7 == 0x40000000 || bl ? 1 : 0)) != 0) {
            void var20_30;
            n2 = Math.min((int)f2.G(), (int)n6);
            n3 = Math.min((int)f2.F(), (int)n8);
            if (n5 == 0x40000000 && f2.W() != n2) {
                f2.l1(n2);
                f2.O1();
            }
            if (n7 == 0x40000000 && f2.x() != n3) {
                f2.M0(n3);
                f2.O1();
            }
            if (n5 == 0x40000000 && n7 == 0x40000000) {
                boolean bl3 = f2.G1(bl);
                n2 = 2;
            } else {
                boolean bl4;
                boolean bl5 = f2.H1(bl);
                if (n5 == 0x40000000) {
                    bl4 = bl5 & f2.I1(bl, 0);
                    n2 = 1;
                } else {
                    n2 = 0;
                }
                if (n7 == 0x40000000) {
                    boolean bl6 = f2.I1(bl, 1) & bl4;
                    ++n2;
                }
            }
            void var21_15 = var20_30;
            n3 = n2;
            if (var20_30 != false) {
                void var21_18;
                if (n5 == 0x40000000) {
                    boolean bl7 = true;
                } else {
                    boolean bl8 = false;
                }
                boolean bl9 = n7 == 0x40000000;
                f2.q1((boolean)var21_18, bl9);
                void var21_19 = var20_30;
                n3 = n2;
            }
        } else {
            boolean bl10 = false;
            n3 = 0;
        }
        if (var21_21 == false || n3 != 2) {
            int n14 = f2.L1();
            if (n12 > 0) {
                this.b(f2);
            }
            this.e(f2);
            n7 = this.a.size();
            if (n12 > 0) {
                this.c(f2, "First pass", 0, n10, n13);
            }
            if (n7 > 0) {
                int n15;
                int n16;
                b2 = f2.A();
                n8 = b2 == (object = e.b.h) ? 1 : 0;
                n9 = f2.T() == object ? 1 : 0;
                n3 = Math.max((int)f2.W(), (int)this.c.I());
                n2 = Math.max((int)f2.x(), (int)this.c.H());
                n4 = 0;
                for (n5 = 0; n5 < n7; ++n5) {
                    object = (e)this.a.get(n5);
                    if (!(object instanceof l)) continue;
                    n16 = ((e)object).W();
                    n15 = ((e)object).x();
                    int n17 = this.a(b3, (e)object, v.b$a.l);
                    n6 = ((e)object).W();
                    n12 = ((e)object).x();
                    if (n6 != n16) {
                        ((e)object).l1(n6);
                        n4 = n3;
                        if (n8 != 0) {
                            n4 = n3;
                            if (((e)object).M() > n3) {
                                n4 = Math.max((int)n3, (int)(((e)object).M() + ((e)object).o(d.a.j).f()));
                            }
                        }
                        n3 = n4;
                        n4 = 1;
                    } else {
                        n4 = n17 | n4;
                    }
                    n6 = n4;
                    n4 = n2;
                    if (n12 != n15) {
                        ((e)object).M0(n12);
                        n4 = n2;
                        if (n9 != 0) {
                            n4 = n2;
                            if (((e)object).r() > n2) {
                                n4 = Math.max((int)n2, (int)(((e)object).r() + ((e)object).o(d.a.k).f()));
                            }
                        }
                        n6 = 1;
                    }
                    n2 = n4;
                    n4 = n6 |= ((l)object).G1();
                }
                n12 = 0;
                n6 = n7;
                n5 = n11;
                while (n12 < 2) {
                    for (n11 = 0; n11 < n6; ++n11) {
                        object = (e)this.a.get(n11);
                        if (object instanceof i && !(object instanceof l) || object instanceof h || ((e)object).V() == 8 || n5 != 0 && ((e)object).e.e.j && ((e)object).f.e.j || object instanceof l) {
                            n7 = n4;
                            n4 = n3;
                        } else {
                            int n18 = ((e)object).W();
                            n16 = ((e)object).x();
                            n15 = ((e)object).p();
                            n7 = v.b$a.l;
                            if (n12 == 1) {
                                n7 = v.b$a.m;
                            }
                            n7 = this.a(b3, (e)object, n7) | n4;
                            int n19 = ((e)object).W();
                            int n20 = ((e)object).x();
                            n4 = n3;
                            if (n19 != n18) {
                                ((e)object).l1(n19);
                                n4 = n3;
                                if (n8 != 0) {
                                    n4 = n3;
                                    if (((e)object).M() > n3) {
                                        n4 = Math.max((int)n3, (int)(((e)object).M() + ((e)object).o(d.a.j).f()));
                                    }
                                }
                                n7 = 1;
                            }
                            n3 = n2;
                            if (n20 != n16) {
                                ((e)object).M0(n20);
                                n3 = n2;
                                if (n9 != 0) {
                                    n3 = n2;
                                    if (((e)object).r() > n2) {
                                        n3 = Math.max((int)n2, (int)(((e)object).r() + ((e)object).o(d.a.k).f()));
                                    }
                                }
                                n7 = 1;
                            }
                            if (((e)object).Z() && n15 != ((e)object).p()) {
                                n7 = 1;
                                n2 = n3;
                            } else {
                                n2 = n3;
                            }
                        }
                        n3 = n4;
                        n4 = n7;
                    }
                    if (n4 == 0) break;
                    this.c(f2, "intermediate pass", ++n12, n10, n13);
                    n4 = 0;
                }
            }
            f2.Y1(n14);
        }
        return 0L;
    }

    public void e(f f2) {
        this.a.clear();
        int n2 = f2.L0.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            e.b b2;
            e e2 = (e)f2.L0.get(i2);
            e.b b3 = e2.A();
            if (b3 != (b2 = e.b.i) && e2.T() != b2) continue;
            this.a.add((Object)e2);
        }
        f2.O1();
    }

    public static class a {
        public static int k = 0;
        public static int l = 1;
        public static int m = 2;
        public e.b a;
        public e.b b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public int j;
    }
}

