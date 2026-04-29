/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayList
 *  java.util.Arrays
 */
package u;

import java.util.ArrayList;
import java.util.Arrays;
import u.d;
import u.e;
import u.f;
import u.l;

public class g
extends l {
    private int a1 = -1;
    private int b1 = -1;
    private int c1 = -1;
    private int d1 = -1;
    private int e1 = -1;
    private int f1 = -1;
    private float g1 = 0.5f;
    private float h1 = 0.5f;
    private float i1 = 0.5f;
    private float j1 = 0.5f;
    private float k1 = 0.5f;
    private float l1 = 0.5f;
    private int m1 = 0;
    private int n1 = 0;
    private int o1 = 2;
    private int p1 = 2;
    private int q1 = 0;
    private int r1 = -1;
    private int s1 = 0;
    private ArrayList t1 = new ArrayList();
    private e[] u1 = null;
    private e[] v1 = null;
    private int[] w1 = null;
    private e[] x1;
    private int y1 = 0;

    static /* synthetic */ int S1(g g2) {
        return g2.c1;
    }

    static /* synthetic */ float T1(g g2) {
        return g2.i1;
    }

    static /* synthetic */ int U1(g g2) {
        return g2.e1;
    }

    static /* synthetic */ float V1(g g2) {
        return g2.k1;
    }

    static /* synthetic */ float W1(g g2) {
        return g2.h1;
    }

    static /* synthetic */ int X1(g g2) {
        return g2.d1;
    }

    static /* synthetic */ float Y1(g g2) {
        return g2.j1;
    }

    static /* synthetic */ int Z1(g g2) {
        return g2.f1;
    }

    static /* synthetic */ float a2(g g2) {
        return g2.l1;
    }

    static /* synthetic */ int b2(g g2) {
        return g2.o1;
    }

    static /* synthetic */ int g2(g g2) {
        return g2.b1;
    }

    static /* synthetic */ int h2(g g2) {
        return g2.p1;
    }

    static /* synthetic */ int i2(g g2) {
        return g2.a1;
    }

    static /* synthetic */ float j2(g g2) {
        return g2.g1;
    }

    private void k2(boolean bl) {
        if (this.w1 != null && this.v1 != null && this.u1 != null) {
            Object object;
            e e2;
            int n2;
            int n3;
            for (n3 = 0; n3 < this.y1; ++n3) {
                this.x1[n3].u0();
            }
            Object object2 = this.w1;
            int n4 = object2[0];
            int n5 = object2[1];
            float f2 = this.g1;
            object2 = null;
            for (n3 = 0; n3 < n4; ++n3) {
                if (bl) {
                    n2 = n4 - n3 - 1;
                    f2 = 1.0f - this.g1;
                } else {
                    n2 = n3;
                }
                e2 = this.v1[n2];
                object = object2;
                if (e2 != null) {
                    if (e2.V() == 8) {
                        object = object2;
                    } else {
                        if (n3 == 0) {
                            e2.k(e2.O, this.O, this.A1());
                            e2.O0(this.a1);
                            e2.N0(f2);
                        }
                        if (n3 == n4 - 1) {
                            e2.k(e2.Q, this.Q, this.B1());
                        }
                        if (n3 > 0 && object2 != null) {
                            e2.k(e2.O, object2.Q, this.m1);
                            object2.k(object2.Q, e2.O, 0);
                        }
                        object = e2;
                    }
                }
                object2 = object;
            }
            for (n3 = 0; n3 < n5; ++n3) {
                e2 = this.u1[n3];
                object = object2;
                if (e2 != null) {
                    if (e2.V() == 8) {
                        object = object2;
                    } else {
                        if (n3 == 0) {
                            e2.k(e2.P, this.P, this.C1());
                            e2.f1(this.b1);
                            e2.e1(this.h1);
                        }
                        if (n3 == n5 - 1) {
                            e2.k(e2.R, this.R, this.z1());
                        }
                        if (n3 > 0 && object2 != null) {
                            e2.k(e2.P, object2.R, this.n1);
                            object2.k(object2.R, e2.P, 0);
                        }
                        object = e2;
                    }
                }
                object2 = object;
            }
            for (n3 = 0; n3 < n4; ++n3) {
                for (n2 = 0; n2 < n5; ++n2) {
                    int n6 = n2 * n4 + n3;
                    if (this.s1 == 1) {
                        n6 = n3 * n5 + n2;
                    }
                    if (n6 >= ((int[])(object2 = (Object)this.x1)).length || (object = (Object)object2[n6]) == null || ((e)object).V() == 8) continue;
                    object2 = this.v1[n3];
                    e2 = this.u1[n2];
                    if (object != object2) {
                        ((e)object).k(((e)object).O, object2.O, 0);
                        ((e)object).k(((e)object).Q, object2.Q, 0);
                    }
                    if (object == e2) continue;
                    ((e)object).k(((e)object).P, e2.P, 0);
                    ((e)object).k(((e)object).R, e2.R, 0);
                }
            }
        }
    }

    private int l2(e e2, int n2) {
        if (e2 == null) {
            return 0;
        }
        if (e2.T() == e.b.i) {
            int n3 = e2.x;
            if (n3 == 0) {
                return 0;
            }
            if (n3 == 2) {
                if ((n2 = (int)(e2.E * (float)n2)) != e2.x()) {
                    e2.Z0(true);
                    this.E1(e2, e2.A(), e2.W(), e.b.g, n2);
                }
                return n2;
            }
            if (n3 == 1) {
                return e2.x();
            }
            if (n3 == 3) {
                return (int)((float)e2.W() * e2.d0 + 0.5f);
            }
        }
        return e2.x();
    }

    private int m2(e e2, int n2) {
        if (e2 == null) {
            return 0;
        }
        if (e2.A() == e.b.i) {
            int n3 = e2.w;
            if (n3 == 0) {
                return 0;
            }
            if (n3 == 2) {
                if ((n2 = (int)(e2.B * (float)n2)) != e2.W()) {
                    e2.Z0(true);
                    this.E1(e2, e.b.g, n2, e2.T(), e2.x());
                }
                return n2;
            }
            if (n3 == 1) {
                return e2.W();
            }
            if (n3 == 3) {
                return (int)((float)e2.x() * e2.d0 + 0.5f);
            }
        }
        return e2.W();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void n2(e[] var1_1, int var2_2, int var3_3, int var4_4, int[] var5_5) {
        block35: {
            if (var3_3 == 0) {
                var8_7 = var6_6 = this.r1;
                if (var6_6 <= 0) {
                    var6_6 = 0;
                    var7_9 = var9_8 = 0;
                    while (true) {
                        var8_7 = var6_6;
                        if (var9_8 >= var2_2) break;
                        var8_7 = var7_9;
                        if (var9_8 > 0) {
                            var8_7 = var7_9 + this.m1;
                        }
                        if ((var13_10 /* !! */  = var1_1 /* !! */ [var9_8]) == null) {
                            var7_9 = var8_7;
                        } else {
                            var7_9 = var8_7 + this.m2((e)var13_10 /* !! */ , var4_4);
                            if (var7_9 > var4_4) {
                                var8_7 = var6_6;
                                break;
                            }
                            ++var6_6;
                        }
                        ++var9_8;
                    }
                }
                var7_9 = var8_7;
                var6_6 = 0;
            } else {
                var8_7 = var6_6 = this.r1;
                if (var6_6 <= 0) {
                    var6_6 = 0;
                    var7_9 = var9_8 = 0;
                    while (true) {
                        var8_7 = var6_6;
                        if (var9_8 >= var2_2) break;
                        var8_7 = var7_9;
                        if (var9_8 > 0) {
                            var8_7 = var7_9 + this.n1;
                        }
                        if ((var13_10 /* !! */  = var1_1 /* !! */ [var9_8]) == null) {
                            var7_9 = var8_7;
                        } else {
                            var7_9 = var8_7 + this.l2((e)var13_10 /* !! */ , var4_4);
                            if (var7_9 > var4_4) {
                                var8_7 = var6_6;
                                break;
                            }
                            ++var6_6;
                        }
                        ++var9_8;
                    }
                }
                var7_9 = 0;
                var6_6 = var8_7;
            }
            if (this.w1 == null) {
                this.w1 = new int[2];
            }
            if (var6_6 != 0) break block35;
            var11_11 = var6_6;
            var10_12 = var7_9;
            if (var3_3 == 1) ** GOTO lbl57
        }
        if (var7_9 == 0 && var3_3 == 0) {
            var10_12 = var7_9;
            var11_11 = var6_6;
lbl57:
            // 6 sources

            while (true) {
                var12_13 = true;
                var6_6 = var11_11;
                var7_9 = var10_12;
                break;
            }
        } else {
            var12_13 = false;
        }
        while (!var12_13) {
            block36: {
                if (var3_3 == 0) {
                    var6_6 = (int)Math.ceil((double)((float)var2_2 / (float)var7_9));
                } else {
                    var7_9 = (int)Math.ceil((double)((float)var2_2 / (float)var6_6));
                }
                var13_10 /* !! */  = this.v1;
                if (var13_10 /* !! */  != null && var13_10 /* !! */ .length >= var7_9) {
                    Arrays.fill((Object[])var13_10 /* !! */ , null);
                } else {
                    this.v1 = new e[var7_9];
                }
                var13_10 /* !! */  = this.u1;
                if (var13_10 /* !! */  != null && var13_10 /* !! */ .length >= var6_6) {
                    Arrays.fill((Object[])var13_10 /* !! */ , null);
                } else {
                    this.u1 = new e[var6_6];
                }
                for (var8_7 = 0; var8_7 < var7_9; ++var8_7) {
                    for (var9_8 = 0; var9_8 < var6_6; ++var9_8) {
                        var10_12 = var9_8 * var7_9 + var8_7;
                        if (var3_3 == 1) {
                            var10_12 = var8_7 * var6_6 + var9_8;
                        }
                        if (var10_12 >= var1_1 /* !! */ .length || (var13_10 /* !! */  = var1_1 /* !! */ [var10_12]) == null) continue;
                        var10_12 = this.m2((e)var13_10 /* !! */ , var4_4);
                        var14_14 = this.v1[var8_7];
                        if (var14_14 == null || var14_14.W() < var10_12) {
                            this.v1[var8_7] = var13_10 /* !! */ ;
                        }
                        var10_12 = this.l2((e)var13_10 /* !! */ , var4_4);
                        var14_14 = this.u1[var9_8];
                        if (var14_14 != null && var14_14.x() >= var10_12) continue;
                        this.u1[var9_8] = var13_10 /* !! */ ;
                    }
                }
                var8_7 = 0;
                for (var9_8 = 0; var9_8 < var7_9; ++var9_8) {
                    var13_10 /* !! */  = this.v1[var9_8];
                    var10_12 = var8_7;
                    if (var13_10 /* !! */  != null) {
                        var10_12 = var8_7;
                        if (var9_8 > 0) {
                            var10_12 = var8_7 + this.m1;
                        }
                        var10_12 += this.m2((e)var13_10 /* !! */ , var4_4);
                    }
                    var8_7 = var10_12;
                }
                var9_8 = 0;
                for (var10_12 = 0; var10_12 < var6_6; ++var10_12) {
                    var13_10 /* !! */  = this.u1[var10_12];
                    var11_11 = var9_8;
                    if (var13_10 /* !! */  != null) {
                        var11_11 = var9_8;
                        if (var10_12 > 0) {
                            var11_11 = var9_8 + this.n1;
                        }
                        var11_11 += this.l2((e)var13_10 /* !! */ , var4_4);
                    }
                    var9_8 = var11_11;
                }
                var5_5[0] = var8_7;
                var5_5[1] = var9_8;
                if (var3_3 != 0) break block36;
                var11_11 = var6_6;
                var10_12 = var7_9;
                if (var8_7 <= var4_4) ** GOTO lbl57
                var11_11 = var6_6;
                var10_12 = var7_9;
                if (var7_9 <= 1) ** GOTO lbl57
                --var7_9;
                continue;
            }
            var11_11 = var6_6;
            var10_12 = var7_9;
            if (var9_8 <= var4_4) ** GOTO lbl57
            var11_11 = var6_6;
            var10_12 = var7_9;
            if (var6_6 > 1) ** break;
            ** continue;
            --var6_6;
        }
        var1_1 /* !! */  = (e[])this.w1;
        var1_1 /* !! */ [0] = (e)var7_9;
        var1_1 /* !! */ [1] = (e)var6_6;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void o2(e[] var1_1, int var2_2, int var3_3, int var4_4, int[] var5_5) {
        var16_6 = this;
        if (var2_2 == 0) {
            return;
        }
        var16_6.t1.clear();
        var19_7 = var16_6.O;
        var18_8 = var16_6.P;
        var17_9 = var16_6.Q;
        var20_10 = var16_6.R;
        var17_9 = new a((g)var16_6, var3_3, (d)var19_7, (d)var18_8, (d)var17_9, (d)var20_10, var4_4);
        var16_6.t1.add(var17_9);
        if (var3_3 == 0) {
            var6_11 = 0;
            var8_12 = 0;
            var9_13 = 0;
            while (true) {
                var18_8 = var16_6;
                var7_14 = var6_11;
                if (var9_13 < var2_2) {
                    var19_7 = var1_1 /* !! */ [var9_13];
                    var11_16 = var16_6.m2((e)var19_7, var4_4);
                    var7_14 = var6_11;
                    if (var19_7.A() == e.b.i) {
                        var7_14 = var6_11 + 1;
                    }
                    var6_11 = (var8_12 == var4_4 || var16_6.m1 + var8_12 + var11_16 > var4_4) && u.g$a.a((a)var17_9) != null ? 1 : 0;
                    var10_15 = var6_11;
                    if (var6_11 == 0) {
                        var10_15 = var6_11;
                        if (var9_13 > 0) {
                            var12_17 = var16_6.r1;
                            var10_15 = var6_11;
                            if (var12_17 > 0) {
                                var10_15 = var6_11;
                                if (var9_13 % var12_17 == 0) {
                                    var10_15 = 1;
                                }
                            }
                        }
                    }
                    if (var10_15 != 0) {
                        var18_8 = new a((g)var16_6, var3_3, var16_6.O, var16_6.P, var16_6.Q, var16_6.R, var4_4);
                        var18_8.i(var9_13);
                        var16_6.t1.add(var18_8);
                        while (true) {
                            var8_12 = var11_16;
                            var17_9 = var18_8;
                            break;
                        }
                    } else {
                        var18_8 = var17_9;
                        if (var9_13 <= 0) ** continue;
                        var8_12 += var16_6.m1 + var11_16;
                    }
                    var17_9.b((e)var19_7);
                    ++var9_13;
                    var6_11 = var7_14;
                    continue;
                }
                break;
            }
        } else {
            var6_11 = 0;
            var8_12 = 0;
            var9_13 = 0;
            while (true) {
                var18_8 = var16_6;
                var7_14 = var6_11;
                if (var9_13 >= var2_2) break;
                var19_7 = var1_1 /* !! */ [var9_13];
                var11_16 = var16_6.l2((e)var19_7, var4_4);
                var7_14 = var6_11;
                if (var19_7.T() == e.b.i) {
                    var7_14 = var6_11 + 1;
                }
                var6_11 = (var8_12 == var4_4 || var16_6.n1 + var8_12 + var11_16 > var4_4) && u.g$a.a((a)var17_9) != null ? 1 : 0;
                var10_15 = var6_11;
                if (var6_11 == 0) {
                    var10_15 = var6_11;
                    if (var9_13 > 0) {
                        var12_17 = var16_6.r1;
                        var10_15 = var6_11;
                        if (var12_17 > 0) {
                            var10_15 = var6_11;
                            if (var9_13 % var12_17 == 0) {
                                var10_15 = 1;
                            }
                        }
                    }
                }
                if (var10_15 != 0) {
                    var18_8 = new a((g)var16_6, var3_3, var16_6.O, var16_6.P, var16_6.Q, var16_6.R, var4_4);
                    var18_8.i(var9_13);
                    var16_6.t1.add(var18_8);
                    while (true) {
                        var8_12 = var11_16;
                        var17_9 = var18_8;
                        break;
                    }
                } else {
                    var18_8 = var17_9;
                    if (var9_13 <= 0) ** continue;
                    var8_12 += var16_6.n1 + var11_16;
                }
                var17_9.b((e)var19_7);
                ++var9_13;
                var6_11 = var7_14;
            }
        }
        var15_18 = var18_8.t1.size();
        var17_9 = var18_8.O;
        var16_6 = var18_8.P;
        var19_7 = var18_8.Q;
        var20_10 = var18_8.R;
        var9_13 = var18_8.A1();
        var6_11 = var18_8.C1();
        var10_15 = var18_8.B1();
        var11_16 = var18_8.z1();
        var1_1 /* !! */  = var18_8.A();
        var2_2 = var1_1 /* !! */  != (var21_19 = e.b.h) && var18_8.T() != var21_19 ? 0 : 1;
        if (var7_14 > 0 && var2_2 != 0) {
            for (var2_2 = 0; var2_2 < var15_18; ++var2_2) {
                var1_1 /* !! */  = (a)var18_8.t1.get(var2_2);
                if (var3_3 == 0) {
                    var1_1 /* !! */ .g(var4_4 - var1_1 /* !! */ .f());
                    continue;
                }
                var1_1 /* !! */ .g(var4_4 - var1_1 /* !! */ .e());
            }
        }
        var12_17 = 0;
        var7_14 = var6_11;
        var6_11 = 0;
        for (var8_12 = 0; var8_12 < var15_18; ++var8_12) {
            var21_19 = (a)var18_8.t1.get(var8_12);
            if (var3_3 == 0) {
                if (var8_12 < var15_18 - 1) {
                    var1_1 /* !! */  = u.g$a.a((a)((a)var18_8.t1.get((int)(var8_12 + 1)))).P;
                    var2_2 = 0;
                } else {
                    var1_1 /* !! */  = var18_8.R;
                    var2_2 = var18_8.z1();
                }
                var20_10 = u.g$a.a((a)var21_19).R;
                var21_19.j(var3_3, (d)var17_9, (d)var16_6, (d)var19_7, (d)var1_1 /* !! */ , var9_13, var7_14, var10_15, var2_2, var4_4);
                var7_14 = Math.max((int)var12_17, (int)var21_19.f());
                var6_11 = var11_16 = var21_19.e() + var6_11;
                if (var8_12 > 0) {
                    var6_11 = var11_16 + var18_8.n1;
                }
                var16_6 = var20_10;
                var13_20 = 0;
                var11_16 = var2_2;
            } else {
                if (var8_12 < var15_18 - 1) {
                    var1_1 /* !! */  = u.g$a.a((a)((a)var18_8.t1.get((int)(var8_12 + 1)))).O;
                    var2_2 = 0;
lbl136:
                    // 2 sources

                    while (true) {
                        continue;
                        break;
                    }
                }
                var1_1 /* !! */  = var18_8.Q;
                var2_2 = var18_8.B1();
                ** continue;
                var19_7 = var1_1 /* !! */ ;
                var1_1 /* !! */  = u.g$a.a((a)var21_19).Q;
                var21_19.j(var3_3, (d)var17_9, (d)var16_6, (d)var19_7, (d)var20_10, var9_13, var7_14, var2_2, var11_16, var4_4);
                var9_13 = var21_19.f() + var12_17;
                var12_17 = Math.max((int)var6_11, (int)var21_19.e());
                var6_11 = var9_13;
                if (var8_12 > 0) {
                    var6_11 = var9_13 + var18_8.m1;
                }
                var14_21 = var6_11;
                var9_13 = 0;
                var17_9 = var1_1 /* !! */ ;
                var10_15 = var2_2;
                var13_20 = var7_14;
                var1_1 /* !! */  = var20_10;
                var6_11 = var12_17;
                var7_14 = var14_21;
            }
            var12_17 = var7_14;
            var20_10 = var1_1 /* !! */ ;
            var7_14 = var13_20;
        }
        var5_5[0] = var12_17;
        var5_5[1] = var6_11;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void p2(e[] var1_1, int var2_2, int var3_3, int var4_4, int[] var5_5) {
        var17_6 = this;
        if (var2_2 == 0) {
            return;
        }
        var17_6.t1.clear();
        var20_7 = var17_6.O;
        var19_8 = var17_6.P;
        var21_9 = var17_6.Q;
        var18_10 = var17_6.R;
        var18_10 = new a((g)var17_6, var3_3, (d)var20_7, (d)var19_8, (d)var21_9, (d)var18_10, var4_4);
        var17_6.t1.add(var18_10);
        var13_11 = 1;
        if (var3_3 == 0) {
            var10_12 = 0;
            var6_13 = 0;
            var8_14 = 0;
            var9_15 = 0;
            while (true) {
                var19_8 = var17_6;
                var7_16 = var6_13;
                if (var9_15 < var2_2) {
                    ++var10_12;
                    var20_7 = var1_1[var9_15];
                    var12_18 = var17_6.m2((e)var20_7, var4_4);
                    var7_16 = var6_13;
                    if (var20_7.A() == e.b.i) {
                        var7_16 = var6_13 + 1;
                    }
                    var6_13 = (var8_14 == var4_4 || var17_6.m1 + var8_14 + var12_18 > var4_4) && u.g$a.a((a)var18_10) != null ? 1 : 0;
                    var11_17 = var6_13;
                    if (var6_13 == 0) {
                        var11_17 = var6_13;
                        if (var9_15 > 0) {
                            var14_19 = var17_6.r1;
                            var11_17 = var6_13;
                            if (var14_19 > 0) {
                                var11_17 = var6_13;
                                if (var10_12 > var14_19) {
                                    var11_17 = 1;
                                }
                            }
                        }
                    }
                    if (var11_17 != 0) {
                        var19_8 = new a((g)var17_6, var3_3, var17_6.O, var17_6.P, var17_6.Q, var17_6.R, var4_4);
                        var19_8.i(var9_15);
                        var17_6.t1.add(var19_8);
                        var6_13 = 1;
                        while (true) {
                            var8_14 = var12_18;
                            var18_10 = var19_8;
                            break;
                        }
                    } else {
                        var19_8 = var18_10;
                        var6_13 = var10_12;
                        if (var9_15 <= 0) ** continue;
                        var8_14 += var17_6.m1 + var12_18;
                        var6_13 = var10_12;
                    }
                    var18_10.b((e)var20_7);
                    ++var9_15;
                    var10_12 = var6_13;
                    var6_13 = var7_16;
                    continue;
                }
                break;
            }
        } else {
            var10_12 = 0;
            var6_13 = 0;
            var8_14 = 0;
            var9_15 = 0;
            while (true) {
                var19_8 = var17_6;
                var7_16 = var6_13;
                if (var9_15 >= var2_2) break;
                ++var10_12;
                var20_7 = var1_1[var9_15];
                var12_18 = var17_6.l2((e)var20_7, var4_4);
                var7_16 = var6_13;
                if (var20_7.T() == e.b.i) {
                    var7_16 = var6_13 + 1;
                }
                var6_13 = (var8_14 == var4_4 || var17_6.n1 + var8_14 + var12_18 > var4_4) && u.g$a.a((a)var18_10) != null ? 1 : 0;
                var11_17 = var6_13;
                if (var6_13 == 0) {
                    var11_17 = var6_13;
                    if (var9_15 > 0) {
                        var14_19 = var17_6.r1;
                        var11_17 = var6_13;
                        if (var14_19 > 0) {
                            var11_17 = var6_13;
                            if (var10_12 > var14_19) {
                                var11_17 = 1;
                            }
                        }
                    }
                }
                if (var11_17 != 0) {
                    var19_8 = new a((g)var17_6, var3_3, var17_6.O, var17_6.P, var17_6.Q, var17_6.R, var4_4);
                    var19_8.i(var9_15);
                    var17_6.t1.add(var19_8);
                    var6_13 = 1;
                    while (true) {
                        var8_14 = var12_18;
                        var18_10 = var19_8;
                        break;
                    }
                } else {
                    var19_8 = var18_10;
                    var6_13 = var10_12;
                    if (var9_15 <= 0) ** continue;
                    var8_14 += var17_6.n1 + var12_18;
                    var6_13 = var10_12;
                }
                var18_10.b((e)var20_7);
                ++var9_15;
                var10_12 = var6_13;
                var6_13 = var7_16;
            }
        }
        var16_20 = var19_8.t1.size();
        var18_10 = var19_8.O;
        var17_6 = var19_8.P;
        var20_7 = var19_8.Q;
        var21_9 = var19_8.R;
        var10_12 = var19_8.A1();
        var8_14 = var19_8.C1();
        var11_17 = var19_8.B1();
        var12_18 = var19_8.z1();
        var22_21 /* !! */  = var19_8.A();
        var2_2 = var22_21 /* !! */  != (var1_1 = e.b.h) && var19_8.T() != var1_1 ? 0 : 1;
        if (var7_16 > 0 && var2_2 != 0) {
            for (var2_2 = 0; var2_2 < var16_20; ++var2_2) {
                var1_1 = (a)var19_8.t1.get(var2_2);
                if (var3_3 == 0) {
                    var1_1.g(var4_4 - var1_1.f());
                    continue;
                }
                var1_1.g(var4_4 - var1_1.e());
            }
        }
        var6_13 = 0;
        var7_16 = var8_14;
        var2_2 = 0;
        var8_14 = var13_11;
        var13_11 = var2_2;
        for (var9_15 = 0; var9_15 < var16_20; ++var9_15) {
            var22_21 /* !! */  = (a)var19_8.t1.get(var9_15);
            if (var3_3 == 0) {
                if (var9_15 < var16_20 - 1) {
                    var1_1 = u.g$a.a((a)((a)var19_8.t1.get((int)(var9_15 + 1)))).P;
                    var2_2 = 0;
                } else {
                    var1_1 = var19_8.R;
                    var2_2 = var19_8.z1();
                }
                var21_9 = u.g$a.a((a)var22_21 /* !! */ ).R;
                var22_21 /* !! */ .j(var3_3, (d)var18_10, (d)var17_6, (d)var20_7, (d)var1_1, var10_12, var7_16, var11_17, var2_2, var4_4);
                var7_16 = Math.max((int)var13_11, (int)var22_21 /* !! */ .f());
                var6_13 = var12_18 = var22_21 /* !! */ .e() + var6_13;
                if (var9_15 > 0) {
                    var6_13 = var12_18 + var19_8.n1;
                }
                var17_6 = var21_9;
                var14_19 = 0;
                var12_18 = var2_2;
            } else {
                if (var9_15 < var16_20 - 1) {
                    var1_1 = u.g$a.a((a)((a)var19_8.t1.get((int)(var9_15 + 1)))).O;
                    var2_2 = 0;
lbl151:
                    // 2 sources

                    while (true) {
                        continue;
                        break;
                    }
                }
                var1_1 = var19_8.Q;
                var2_2 = var19_8.B1();
                ** continue;
                var20_7 = var1_1;
                var1_1 = u.g$a.a((a)var22_21 /* !! */ ).Q;
                var22_21 /* !! */ .j(var3_3, (d)var18_10, (d)var17_6, (d)var20_7, (d)var21_9, var10_12, var7_16, var2_2, var12_18, var4_4);
                var10_12 = var22_21 /* !! */ .f() + var13_11;
                var15_22 = Math.max((int)var6_13, (int)var22_21 /* !! */ .e());
                var6_13 = var10_12;
                if (var9_15 > 0) {
                    var6_13 = var10_12 + var19_8.m1;
                }
                var13_11 = var6_13;
                var10_12 = 0;
                var18_10 = var1_1;
                var11_17 = var2_2;
                var14_19 = var7_16;
                var1_1 = var21_9;
                var6_13 = var15_22;
                var7_16 = var13_11;
            }
            var13_11 = var7_16;
            var21_9 = var1_1;
            var7_16 = var14_19;
        }
        var5_5[0] = var13_11;
        var5_5[var8_14] = var6_13;
    }

    private void q2(e[] eArray, int n2, int n3, int n4, int[] nArray) {
        a a2;
        if (n2 == 0) {
            return;
        }
        if (this.t1.size() == 0) {
            a2 = new a(this, n3, this.O, this.P, this.Q, this.R, n4);
            this.t1.add((Object)a2);
        } else {
            a2 = (a)this.t1.get(0);
            a2.c();
            a2.j(n3, this.O, this.P, this.Q, this.R, this.A1(), this.C1(), this.B1(), this.z1(), n4);
        }
        for (n3 = 0; n3 < n2; ++n3) {
            a2.b(eArray[n3]);
        }
        nArray[0] = a2.f();
        nArray[1] = a2.e();
    }

    public void A2(int n2) {
        this.e1 = n2;
    }

    public void B2(float f2) {
        this.l1 = f2;
    }

    public void C2(int n2) {
        this.f1 = n2;
    }

    @Override
    public void D1(int n2, int n3, int n4, int n5) {
        int n6;
        if (this.M0 > 0 && !this.F1()) {
            this.I1(0, 0);
            this.H1(false);
            return;
        }
        int n7 = this.A1();
        int n8 = this.B1();
        int n9 = this.C1();
        int n10 = this.z1();
        int[] nArray = new int[2];
        int n11 = n3 - n7 - n8;
        int n12 = this.s1;
        if (n12 == 1) {
            n11 = n5 - n9 - n10;
        }
        if (n12 == 0) {
            if (this.a1 == -1) {
                this.a1 = 0;
            }
            if (this.b1 == -1) {
                this.b1 = 0;
            }
        } else {
            if (this.a1 == -1) {
                this.a1 = 0;
            }
            if (this.b1 == -1) {
                this.b1 = 0;
            }
        }
        e[] eArray = this.L0;
        int n13 = 0;
        int n14 = n12 = 0;
        while (true) {
            n6 = n14;
            n14 = this.M0;
            if (n13 >= n14) break;
            n14 = n6;
            if (this.L0[n13].V() == 8) {
                n14 = n6 + 1;
            }
            ++n13;
        }
        if (n6 > 0) {
            eArray = new e[n14 - n6];
            n14 = n13 = n12;
            while (n13 < this.M0) {
                e e2 = this.L0[n13];
                n6 = n14;
                if (e2.V() != 8) {
                    eArray[n14] = e2;
                    n6 = n14 + 1;
                }
                ++n13;
                n14 = n6;
            }
        }
        this.x1 = eArray;
        this.y1 = n14;
        n13 = this.q1;
        if (n13 != 0) {
            if (n13 != 1) {
                if (n13 != 2) {
                    if (n13 == 3) {
                        this.p2(eArray, n14, this.s1, n11, nArray);
                    }
                } else {
                    this.n2(eArray, n14, this.s1, n11, nArray);
                }
            } else {
                this.o2(eArray, n14, this.s1, n11, nArray);
            }
        } else {
            this.q2(eArray, n14, this.s1, n11, nArray);
        }
        n13 = nArray[n12] + n7 + n8;
        n14 = nArray[1] + n9 + n10;
        n2 = n2 == 0x40000000 ? n3 : (n2 == Integer.MIN_VALUE ? Math.min((int)n13, (int)n3) : (n2 == 0 ? n13 : n12));
        n3 = n4 == 0x40000000 ? n5 : (n4 == Integer.MIN_VALUE ? Math.min((int)n14, (int)n5) : (n4 == 0 ? n14 : n12));
        this.I1(n2, n3);
        this.l1(n2);
        this.M0(n3);
        if (this.M0 > 0) {
            n12 = 1;
        }
        this.H1(n12 != 0);
    }

    public void D2(int n2) {
        this.r1 = n2;
    }

    public void E2(int n2) {
        this.s1 = n2;
    }

    public void F2(int n2) {
        this.p1 = n2;
    }

    public void G2(float f2) {
        this.h1 = f2;
    }

    public void H2(int n2) {
        this.n1 = n2;
    }

    public void I2(int n2) {
        this.b1 = n2;
    }

    public void J2(int n2) {
        this.q1 = n2;
    }

    @Override
    public void g(r.d object, boolean bl) {
        super.g((r.d)object, bl);
        bl = this.K() != null && ((f)this.K()).R1();
        int n2 = this.q1;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        int n3 = this.t1.size();
                        for (n2 = 0; n2 < n3; ++n2) {
                            object = (a)this.t1.get(n2);
                            boolean bl2 = n2 == n3 - 1;
                            ((a)object).d(bl, n2, bl2);
                        }
                    }
                } else {
                    this.k2(bl);
                }
            } else {
                int n4 = this.t1.size();
                for (n2 = 0; n2 < n4; ++n2) {
                    object = (a)this.t1.get(n2);
                    boolean bl3 = n2 == n4 - 1;
                    ((a)object).d(bl, n2, bl3);
                }
            }
        } else if (this.t1.size() > 0) {
            ((a)this.t1.get(0)).d(bl, 0, true);
        }
        this.H1(false);
    }

    public void r2(float f2) {
        this.i1 = f2;
    }

    public void s2(int n2) {
        this.c1 = n2;
    }

    public void t2(float f2) {
        this.j1 = f2;
    }

    public void u2(int n2) {
        this.d1 = n2;
    }

    public void v2(int n2) {
        this.o1 = n2;
    }

    public void w2(float f2) {
        this.g1 = f2;
    }

    public void x2(int n2) {
        this.m1 = n2;
    }

    public void y2(int n2) {
        this.a1 = n2;
    }

    public void z2(float f2) {
        this.k1 = f2;
    }

    private class a {
        private int a;
        private e b;
        int c;
        private d d;
        private d e;
        private d f;
        private d g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        final g r;

        a(g g2, int n2, d d3, d d4, d d5, d d6, int n3) {
            this.r = g2;
            this.b = null;
            this.c = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.a = n2;
            this.d = d3;
            this.e = d4;
            this.f = d5;
            this.g = d6;
            this.h = g2.A1();
            this.i = g2.C1();
            this.j = g2.B1();
            this.k = g2.z1();
            this.q = n3;
        }

        static /* synthetic */ e a(a a2) {
            return a2.b;
        }

        private void h() {
            this.l = 0;
            this.m = 0;
            this.b = null;
            this.c = 0;
            int n2 = this.o;
            for (int i2 = 0; i2 < n2 && this.n + i2 < this.r.y1; ++i2) {
                int n3;
                int n4;
                e e2 = this.r.x1[this.n + i2];
                if (this.a == 0) {
                    n4 = e2.W();
                    n3 = this.r.m1;
                    if (e2.V() == 8) {
                        n3 = 0;
                    }
                    this.l += n4 + n3;
                    n3 = this.r.l2(e2, this.q);
                    if (this.b != null && this.c >= n3) continue;
                    this.b = e2;
                    this.c = n3;
                    this.m = n3;
                    continue;
                }
                int n5 = this.r.m2(e2, this.q);
                n4 = this.r.l2(e2, this.q);
                n3 = this.r.n1;
                if (e2.V() == 8) {
                    n3 = 0;
                }
                this.m += n4 + n3;
                if (this.b != null && this.c >= n5) continue;
                this.b = e2;
                this.c = n5;
                this.l = n5;
            }
        }

        public void b(e e2) {
            int n2 = this.a;
            int n3 = 0;
            int n4 = 0;
            if (n2 == 0) {
                n2 = this.r.m2(e2, this.q);
                if (e2.A() == e.b.i) {
                    ++this.p;
                    n2 = 0;
                }
                n3 = this.r.m1;
                if (e2.V() == 8) {
                    n3 = n4;
                }
                this.l += n2 + n3;
                n2 = this.r.l2(e2, this.q);
                if (this.b == null || this.c < n2) {
                    this.b = e2;
                    this.c = n2;
                    this.m = n2;
                }
            } else {
                int n5 = this.r.m2(e2, this.q);
                n2 = this.r.l2(e2, this.q);
                if (e2.T() == e.b.i) {
                    ++this.p;
                    n2 = 0;
                }
                n4 = this.r.n1;
                if (e2.V() != 8) {
                    n3 = n4;
                }
                this.m += n2 + n3;
                if (this.b == null || this.c < n5) {
                    this.b = e2;
                    this.c = n5;
                    this.l = n5;
                }
            }
            ++this.o;
        }

        public void c() {
            this.c = 0;
            this.b = null;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
        }

        /*
         * Unable to fully structure code
         */
        public void d(boolean var1_1, int var2_2, boolean var3_3) {
            block63: {
                block64: {
                    var12_4 = this.o;
                    for (var6_5 = 0; var6_5 < var12_4 && this.n + var6_5 < u.g.e2(this.r); ++var6_5) {
                        var13_6 = u.g.f2(this.r)[this.n + var6_5];
                        if (var13_6 == null) continue;
                        var13_6.u0();
                    }
                    if (var12_4 == 0 || this.b == null) break block63;
                    var9_7 = var3_3 != false && var2_2 == 0;
                    var7_8 = -1;
                    var8_9 = -1;
                    for (var6_5 = 0; var6_5 < var12_4 && this.n + (var10_10 = var1_1 != false ? var12_4 - 1 - var6_5 : var6_5) < u.g.e2(this.r); ++var6_5) {
                        var13_6 = u.g.f2(this.r)[this.n + var10_10];
                        var11_11 = var7_8;
                        var10_10 = var8_9;
                        if (var13_6 != null) {
                            var11_11 = var7_8;
                            var10_10 = var8_9;
                            if (var13_6.V() == 0) {
                                var8_9 = var7_8;
                                if (var7_8 == -1) {
                                    var8_9 = var6_5;
                                }
                                var10_10 = var6_5;
                                var11_11 = var8_9;
                            }
                        }
                        var7_8 = var11_11;
                        var8_9 = var10_10;
                    }
                    var6_5 = this.a;
                    var14_12 = null;
                    var13_6 = null;
                    if (var6_5 != 0) break block64;
                    var15_13 = this.b;
                    var15_13.f1(u.g.g2(this.r));
                    var6_5 = var10_10 = this.i;
                    if (var2_2 > 0) {
                        var6_5 = var10_10 + u.g.R1(this.r);
                    }
                    var15_13.P.a(this.e, var6_5);
                    if (var3_3) {
                        var15_13.R.a(this.g, this.k);
                    }
                    if (var2_2 > 0) {
                        this.e.d.R.a(var15_13.P, 0);
                    }
                    var2_2 = u.g.h2(this.r);
                    var10_10 = 3;
                    if (var2_2 == 3 && !var15_13.Z()) {
                        for (var2_2 = 0; var2_2 < var12_4 && this.n + (var6_5 = var1_1 != false ? var12_4 - 1 - var2_2 : var2_2) < u.g.e2(this.r); ++var2_2) {
                            var14_12 = u.g.f2(this.r)[this.n + var6_5];
                            if (!var14_12.Z()) {
                                continue;
                            }
                            break;
                        }
                    } else {
                        var14_12 = var15_13;
                    }
                    var2_2 = var10_10;
                    for (var6_5 = 0; var6_5 < var12_4 && this.n + (var10_10 = var1_1 != false ? var12_4 - 1 - var6_5 : var6_5) < u.g.e2(this.r); ++var6_5) {
                        block65: {
                            block62: {
                                block66: {
                                    var16_19 = u.g.f2(this.r)[this.n + var10_10];
                                    if (var16_19 == null) continue;
                                    if (var6_5 == 0) {
                                        var16_19.k(var16_19.O, this.d, this.h);
                                    }
                                    if (var10_10 != 0) break block65;
                                    var10_10 = u.g.i2(this.r);
                                    var4_15 = var5_17 = u.g.j2(this.r);
                                    if (var1_1) {
                                        var4_15 = 1.0f - var5_17;
                                    }
                                    if (this.n != 0 || u.g.S1(this.r) == -1) break block66;
                                    var2_2 = u.g.S1(this.r);
                                    if (var1_1) {
                                        var4_15 = u.g.T1(this.r);
lbl68:
                                        // 2 sources

                                        while (true) {
                                            var4_15 = 1.0f - var4_15;
lbl70:
                                            // 3 sources

                                            while (true) {
                                                var5_17 = var4_15;
                                                break block62;
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                    var4_15 = u.g.T1(this.r);
                                    ** GOTO lbl70
                                }
                                var2_2 = var10_10;
                                var5_17 = var4_15;
                                if (var3_3) {
                                    var2_2 = var10_10;
                                    var5_17 = var4_15;
                                    if (u.g.U1(this.r) != -1) {
                                        var2_2 = u.g.U1(this.r);
                                        if (var1_1) {
                                            var4_15 = u.g.V1(this.r);
                                            ** continue;
                                        }
                                        var4_15 = u.g.V1(this.r);
                                        ** continue;
                                    }
                                }
                            }
                            var16_19.O0(var2_2);
                            var16_19.N0(var5_17);
                        }
                        if (var6_5 == var12_4 - 1) {
                            var16_19.k(var16_19.Q, this.f, this.j);
                        }
                        if (var13_6 != null) {
                            var16_19.O.a(var13_6.Q, u.g.Q1(this.r));
                            if (var6_5 == var7_8) {
                                var16_19.O.u(this.h);
                            }
                            var13_6.Q.a(var16_19.O, 0);
                            if (var6_5 == var8_9 + 1) {
                                var13_6.Q.u(this.j);
                            }
                        }
                        if (var16_19 != var15_13) {
                            var10_10 = u.g.h2(this.r);
                            var2_2 = 3;
                            if (var10_10 == 3 && var14_12.Z() && var16_19 != var14_12 && var16_19.Z()) {
                                var16_19.S.a(var14_12.S, 0);
                                var13_6 = var16_19;
                                continue;
                            }
                            var10_10 = u.g.h2(this.r);
                            if (var10_10 != 0) {
                                if (var10_10 != 1) {
                                    if (var9_7) {
                                        var16_19.P.a(this.e, this.i);
                                        var16_19.R.a(this.g, this.k);
                                        var13_6 = var16_19;
                                        continue;
                                    }
                                    var16_19.P.a(var15_13.P, 0);
                                    var16_19.R.a(var15_13.R, 0);
                                    var13_6 = var16_19;
                                    continue;
                                }
                                var16_19.R.a(var15_13.R, 0);
                                var13_6 = var16_19;
                                continue;
                            }
                            var16_19.P.a(var15_13.P, 0);
                            var13_6 = var16_19;
                            continue;
                        }
                        var2_2 = 3;
                        var13_6 = var16_19;
                    }
                    break block63;
                }
                var15_14 = this.b;
                var15_14.O0(u.g.i2(this.r));
                var6_5 = var10_10 = this.h;
                if (var2_2 > 0) {
                    var6_5 = var10_10 + u.g.Q1(this.r);
                }
                if (var1_1) {
                    var15_14.Q.a(this.f, var6_5);
                    if (var3_3) {
                        var15_14.O.a(this.d, this.j);
                    }
                    if (var2_2 > 0) {
                        this.f.d.O.a(var15_14.Q, 0);
                    }
                } else {
                    var15_14.O.a(this.d, var6_5);
                    if (var3_3) {
                        var15_14.Q.a(this.f, this.j);
                    }
                    if (var2_2 > 0) {
                        this.d.d.Q.a(var15_14.O, 0);
                    }
                }
                var13_6 = var14_12;
                for (var6_5 = 0; var6_5 < var12_4 && this.n + var6_5 < u.g.e2(this.r); ++var6_5) {
                    var14_12 = u.g.f2(this.r)[this.n + var6_5];
                    if (var14_12 == null) continue;
                    if (var6_5 == 0) {
                        var14_12.k(var14_12.P, this.e, this.i);
                        var10_10 = u.g.g2(this.r);
                        var5_18 = u.g.W1(this.r);
                        if (this.n == 0 && u.g.X1(this.r) != -1) {
                            var2_2 = u.g.X1(this.r);
                            var4_16 = u.g.Y1(this.r);
                        } else {
                            var2_2 = var10_10;
                            var4_16 = var5_18;
                            if (var3_3) {
                                var2_2 = var10_10;
                                var4_16 = var5_18;
                                if (u.g.Z1(this.r) != -1) {
                                    var2_2 = u.g.Z1(this.r);
                                    var4_16 = u.g.a2(this.r);
                                }
                            }
                        }
                        var14_12.f1(var2_2);
                        var14_12.e1(var4_16);
                    }
                    if (var6_5 == var12_4 - 1) {
                        var14_12.k(var14_12.R, this.g, this.k);
                    }
                    if (var13_6 != null) {
                        var14_12.P.a(var13_6.R, u.g.R1(this.r));
                        if (var6_5 == var7_8) {
                            var14_12.P.u(this.i);
                        }
                        var13_6.R.a(var14_12.P, 0);
                        if (var6_5 == var8_9 + 1) {
                            var13_6.R.u(this.k);
                        }
                    }
                    if (var14_12 != var15_14) {
                        if (var1_1) {
                            var2_2 = u.g.b2(this.r);
                            if (var2_2 != 0) {
                                if (var2_2 != 1) {
                                    if (var2_2 == 2) {
                                        var14_12.O.a(var15_14.O, 0);
                                        var14_12.Q.a(var15_14.Q, 0);
                                    }
                                } else {
                                    var14_12.O.a(var15_14.O, 0);
                                }
                            } else {
                                var14_12.Q.a(var15_14.Q, 0);
                            }
                        } else {
                            var2_2 = u.g.b2(this.r);
                            if (var2_2 != 0) {
                                if (var2_2 != 1) {
                                    if (var2_2 == 2) {
                                        if (var9_7) {
                                            var14_12.O.a(this.d, this.h);
                                            var14_12.Q.a(this.f, this.j);
                                        } else {
                                            var14_12.O.a(var15_14.O, 0);
                                            var14_12.Q.a(var15_14.Q, 0);
                                        }
                                    }
                                } else {
                                    var14_12.Q.a(var15_14.Q, 0);
                                }
                            } else {
                                var14_12.O.a(var15_14.O, 0);
                            }
                        }
                    }
                    var13_6 = var14_12;
                }
            }
        }

        public int e() {
            if (this.a == 1) {
                return this.m - this.r.n1;
            }
            return this.m;
        }

        public int f() {
            if (this.a == 0) {
                return this.l - this.r.m1;
            }
            return this.l;
        }

        public void g(int n2) {
            int n3 = this.p;
            if (n3 == 0) {
                return;
            }
            int n4 = this.o;
            n2 /= n3;
            for (n3 = 0; n3 < n4 && this.n + n3 < this.r.y1; ++n3) {
                int n5;
                e e2 = this.r.x1[this.n + n3];
                if (this.a == 0) {
                    n5 = n2;
                    if (e2 != null) {
                        n5 = n2;
                        if (e2.A() == e.b.i) {
                            n5 = n2;
                            if (e2.w == 0) {
                                this.r.E1(e2, e.b.g, n2, e2.T(), e2.x());
                                n5 = n2;
                            }
                        }
                    }
                } else {
                    n5 = n2;
                    if (e2 != null) {
                        n5 = n2;
                        if (e2.T() == e.b.i) {
                            n5 = n2;
                            if (e2.x == 0) {
                                this.r.E1(e2, e2.A(), e2.W(), e.b.g, n2);
                                n5 = n2;
                            }
                        }
                    }
                }
                n2 = n5;
            }
            this.h();
        }

        public void i(int n2) {
            this.n = n2;
        }

        public void j(int n2, d d3, d d4, d d5, d d6, int n3, int n4, int n5, int n6, int n7) {
            this.a = n2;
            this.d = d3;
            this.e = d4;
            this.f = d5;
            this.g = d6;
            this.h = n3;
            this.i = n4;
            this.j = n5;
            this.k = n6;
            this.q = n7;
        }
    }
}

