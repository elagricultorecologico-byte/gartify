/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 *  v.c
 *  v.f
 *  v.l
 *  v.n
 *  v.p
 */
package u;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import r.c;
import r.i;
import u.d;
import u.f;
import u.h;
import u.k;
import u.l;
import v.n;
import v.p;

public class e {
    public static float K0 = 0.5f;
    public int A = 0;
    int A0;
    public float B = 1.0f;
    boolean B0;
    public int C = 0;
    boolean C0;
    public int D = 0;
    public float[] D0;
    public float E = 1.0f;
    protected e[] E0;
    int F = -1;
    protected e[] F0;
    float G = 1.0f;
    e G0;
    private int[] H;
    e H0;
    public float I;
    public int I0;
    private boolean J = false;
    public int J0;
    private boolean K;
    private boolean L = false;
    private int M = 0;
    private int N = 0;
    public d O;
    public d P;
    public d Q;
    public d R;
    public d S;
    d T;
    d U;
    public d V;
    public d[] W;
    protected ArrayList X;
    private boolean[] Y;
    public b[] Z;
    public boolean a = false;
    public e a0;
    public p[] b = new p[2];
    int b0;
    public v.c c;
    int c0;
    public v.c d;
    public float d0;
    public v.l e = null;
    protected int e0;
    public n f = null;
    protected int f0;
    public boolean[] g = new boolean[]{true, true};
    protected int g0;
    boolean h = false;
    int h0;
    private boolean i = true;
    int i0;
    private boolean j = false;
    protected int j0;
    private boolean k = true;
    protected int k0;
    private int l = -1;
    int l0;
    private int m = -1;
    protected int m0;
    public t.a n = new t.a(this);
    protected int n0;
    public String o;
    float o0;
    private boolean p = false;
    float p0;
    private boolean q = false;
    private Object q0;
    private boolean r = false;
    private int r0;
    private boolean s = false;
    private int s0;
    public int t = -1;
    private boolean t0;
    public int u = -1;
    private String u0;
    private int v = 0;
    private String v0;
    public int w = 0;
    boolean w0;
    public int x = 0;
    boolean x0;
    public int[] y = new int[2];
    boolean y0;
    public int z = 0;
    int z0;

    public e() {
        float f2;
        Object object;
        this.H = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.I = Float.NaN;
        this.O = new d(this, d.a.h);
        this.P = new d(this, d.a.i);
        this.Q = new d(this, d.a.j);
        this.R = new d(this, d.a.k);
        this.S = new d(this, d.a.l);
        this.T = new d(this, d.a.n);
        this.U = new d(this, d.a.o);
        this.V = object = new d(this, d.a.m);
        this.W = new d[]{this.O, this.Q, this.P, this.R, this.S, object};
        this.X = new ArrayList();
        this.Y = new boolean[2];
        object = u.e$b.g;
        this.Z = new b[]{object, object};
        this.a0 = null;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0.0f;
        this.e0 = -1;
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.o0 = f2 = K0;
        this.p0 = f2;
        this.r0 = 0;
        this.s0 = 0;
        this.t0 = false;
        this.u0 = null;
        this.v0 = null;
        this.y0 = false;
        this.z0 = 0;
        this.A0 = 0;
        this.D0 = new float[]{-1.0f, -1.0f};
        this.E0 = new e[]{null, null};
        this.F0 = new e[]{null, null};
        this.G0 = null;
        this.H0 = null;
        this.I0 = -1;
        this.J0 = -1;
        this.d();
    }

    private void A0(StringBuilder stringBuilder, String string, float f2, int n2) {
        if (f2 == 0.0f) {
            return;
        }
        stringBuilder.append(string);
        stringBuilder.append(" :  [");
        stringBuilder.append(f2);
        stringBuilder.append(",");
        stringBuilder.append(n2);
        stringBuilder.append("");
        stringBuilder.append("],\n");
    }

    private void P(StringBuilder stringBuilder, String string, int n2, int n3, int n4, int n5, int n6, int n7, float f2, b b2, float f3) {
        stringBuilder.append(string);
        stringBuilder.append(" :  {\n");
        this.z0(stringBuilder, "      behavior", b2.toString(), u.e$b.g.toString());
        this.y0(stringBuilder, "      size", n2, 0);
        this.y0(stringBuilder, "      min", n3, 0);
        this.y0(stringBuilder, "      max", n4, Integer.MAX_VALUE);
        this.y0(stringBuilder, "      matchMin", n6, 0);
        this.y0(stringBuilder, "      matchDef", n7, 0);
        this.x0(stringBuilder, "      matchPercent", f2, 1.0f);
        stringBuilder.append("    },\n");
    }

    private void Q(StringBuilder stringBuilder, String string, d d3) {
        if (d3.f == null) {
            return;
        }
        stringBuilder.append("    ");
        stringBuilder.append(string);
        stringBuilder.append(" : [ '");
        stringBuilder.append((Object)d3.f);
        stringBuilder.append("'");
        if (d3.h != Integer.MIN_VALUE || d3.g != 0) {
            stringBuilder.append(",");
            stringBuilder.append(d3.g);
            if (d3.h != Integer.MIN_VALUE) {
                stringBuilder.append(",");
                stringBuilder.append(d3.h);
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" ] ,\n");
    }

    private void d() {
        this.X.add((Object)this.O);
        this.X.add((Object)this.P);
        this.X.add((Object)this.Q);
        this.X.add((Object)this.R);
        this.X.add((Object)this.T);
        this.X.add((Object)this.U);
        this.X.add((Object)this.V);
        this.X.add((Object)this.S);
    }

    private boolean f0(int n2) {
        d[] dArray = this.W;
        d d3 = dArray[n2 *= 2];
        d d4 = d3.f;
        if (d4 != null && d4.f != d3) {
            d3 = dArray[n2 + 1];
            d4 = d3.f;
            if (d4 != null && d4.f == d3) {
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void i(r.d object, boolean bl, boolean bl2, boolean bl3, boolean bl4, i object2, i i2, b object3, boolean bl5, d object4, d bArray, int n2, int n3, int n4, int n5, float f2, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, int n6, int n7, int n8, int n9, float f3, boolean bl11) {
        void var7_20;
        i i3;
        int n10;
        int n11;
        int n12;
        b[] bArray2;
        i i4;
        b b2;
        block84: {
            e e2;
            i i5;
            i i6;
            block86: {
                block83: {
                    block82: {
                        i i7;
                        int n13;
                        void var14_35;
                        int n14;
                        int n15;
                        i i8;
                        block104: {
                            i i9;
                            block107: {
                                block108: {
                                    void var20_41;
                                    e e3;
                                    e e4;
                                    e e5;
                                    int n16;
                                    void var17_38;
                                    block105: {
                                        block106: {
                                            void var21_42;
                                            void var16_37;
                                            int n17;
                                            int n18;
                                            int n19;
                                            int n20;
                                            block103: {
                                                block88: {
                                                    block90: {
                                                        block94: {
                                                            block95: {
                                                                block100: {
                                                                    block101: {
                                                                        block98: {
                                                                            boolean bl12;
                                                                            block102: {
                                                                                block99: {
                                                                                    block97: {
                                                                                        block96: {
                                                                                            block93: {
                                                                                                block92: {
                                                                                                    block91: {
                                                                                                        block89: {
                                                                                                            boolean bl13;
                                                                                                            int n21;
                                                                                                            block87: {
                                                                                                                block85: {
                                                                                                                    void var19_40;
                                                                                                                    void var27_48;
                                                                                                                    void var8_21;
                                                                                                                    i4 = ((r.d)object).q((Object)b2);
                                                                                                                    i6 = ((r.d)object).q(bArray2);
                                                                                                                    i8 = ((r.d)object).q(((d)((Object)b2)).j());
                                                                                                                    i5 = ((r.d)object).q(bArray2.j());
                                                                                                                    r.d.x();
                                                                                                                    n21 = ((d)((Object)b2)).o();
                                                                                                                    bl13 = bArray2.o();
                                                                                                                    boolean bl14 = this.V.o();
                                                                                                                    n15 = bl13 ? n21 + 1 : n21;
                                                                                                                    n12 = n15;
                                                                                                                    if (bl14) {
                                                                                                                        n12 = n15 + 1;
                                                                                                                    }
                                                                                                                    n14 = var17_38 != false ? 3 : n20;
                                                                                                                    n20 = var8_21.ordinal();
                                                                                                                    n19 = n20 != 0 && n20 != 1 && n20 == 2 && n14 != 4 ? 1 : 0;
                                                                                                                    int n22 = this.l;
                                                                                                                    n15 = n19;
                                                                                                                    n20 = n11;
                                                                                                                    if (n22 != -1) {
                                                                                                                        n15 = n19;
                                                                                                                        n20 = n11;
                                                                                                                        if (bl) {
                                                                                                                            this.l = -1;
                                                                                                                            n20 = n22;
                                                                                                                            n15 = 0;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if ((n11 = this.m) != -1 && !bl) {
                                                                                                                        this.m = -1;
                                                                                                                        n15 = 0;
                                                                                                                    } else {
                                                                                                                        n11 = n20;
                                                                                                                    }
                                                                                                                    if (this.s0 == 8) {
                                                                                                                        n11 = 0;
                                                                                                                        n20 = 0;
                                                                                                                    } else {
                                                                                                                        n20 = n15;
                                                                                                                    }
                                                                                                                    if (var27_48 != false) {
                                                                                                                        if (n21 == 0 && !bl13 && !bl14) {
                                                                                                                            ((r.d)object).f(i4, n10);
                                                                                                                        } else if (n21 != 0 && !bl13) {
                                                                                                                            ((r.d)object).e(i4, i8, ((d)((Object)b2)).f(), 8);
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if ((n10 = n20) == 0) {
                                                                                                                        if (bl12) {
                                                                                                                            ((r.d)object).e(i6, i4, 0, 3);
                                                                                                                            if (var14_35 > 0) {
                                                                                                                                ((r.d)object).h(i6, i4, (int)var14_35, 8);
                                                                                                                            }
                                                                                                                            if (n16 < Integer.MAX_VALUE) {
                                                                                                                                ((r.d)object).j(i6, i4, n16, 8);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            ((r.d)object).e(i6, i4, n11, 8);
                                                                                                                        }
                                                                                                                        n15 = n10;
                                                                                                                        n10 = n13;
                                                                                                                        n13 = n18;
                                                                                                                    } else if (n12 != 2 && var17_38 == false && (n14 == 1 || n14 == 0)) {
                                                                                                                        n10 = n11 = Math.max((int)n18, (int)n11);
                                                                                                                        if (n13 > 0) {
                                                                                                                            n10 = Math.min((int)n13, (int)n11);
                                                                                                                        }
                                                                                                                        ((r.d)object).e(i6, i4, n10, 8);
                                                                                                                        n10 = n13;
                                                                                                                        n15 = 0;
                                                                                                                        n13 = n18;
                                                                                                                    } else {
                                                                                                                        n16 = n18 == -2 ? n11 : n18;
                                                                                                                        n20 = n13 == -2 ? n11 : n13;
                                                                                                                        n18 = n11;
                                                                                                                        if (n11 > 0) {
                                                                                                                            n18 = n11;
                                                                                                                            if (n14 != 1) {
                                                                                                                                n18 = 0;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        n11 = n18;
                                                                                                                        if (n16 > 0) {
                                                                                                                            ((r.d)object).h(i6, i4, n16, 8);
                                                                                                                            n11 = Math.max((int)n18, (int)n16);
                                                                                                                        }
                                                                                                                        n18 = n11;
                                                                                                                        if (n20 > 0) {
                                                                                                                            if (!bl2 || n14 != 1) {
                                                                                                                                ((r.d)object).j(i6, i4, n20, 8);
                                                                                                                            }
                                                                                                                            n18 = Math.min((int)n11, (int)n20);
                                                                                                                        }
                                                                                                                        if (n14 == 1) {
                                                                                                                            if (bl2) {
                                                                                                                                ((r.d)object).e(i6, i4, n18, 8);
                                                                                                                            } else if (var19_40 != false) {
                                                                                                                                ((r.d)object).e(i6, i4, n18, 5);
                                                                                                                                ((r.d)object).j(i6, i4, n18, 8);
                                                                                                                            } else {
                                                                                                                                ((r.d)object).e(i6, i4, n18, 5);
                                                                                                                                ((r.d)object).j(i6, i4, n18, 8);
                                                                                                                            }
                                                                                                                            n15 = n10;
                                                                                                                            n10 = n20;
                                                                                                                            n13 = n16;
                                                                                                                        } else {
                                                                                                                            if (n14 == 2) {
                                                                                                                                void var26_47;
                                                                                                                                void var8_24;
                                                                                                                                void var38_64;
                                                                                                                                d.a a2;
                                                                                                                                d.a a3 = ((d)((Object)b2)).k();
                                                                                                                                if (a3 != (a2 = d.a.i) && ((d)((Object)b2)).k() != d.a.k) {
                                                                                                                                    i i10 = ((r.d)object).q(this.a0.o(d.a.h));
                                                                                                                                    i i11 = ((r.d)object).q(this.a0.o(d.a.j));
                                                                                                                                } else {
                                                                                                                                    i i12 = ((r.d)object).q(this.a0.o(a2));
                                                                                                                                    i i13 = ((r.d)object).q(this.a0.o(d.a.k));
                                                                                                                                }
                                                                                                                                ((r.d)object).d(((r.d)object).r().k(i6, i4, (i)var38_64, (i)var8_24, (float)var26_47));
                                                                                                                                if (bl2) {
                                                                                                                                    n10 = 0;
                                                                                                                                }
                                                                                                                                n15 = n10;
                                                                                                                            } else {
                                                                                                                                bl4 = true;
                                                                                                                                n15 = n10;
                                                                                                                            }
                                                                                                                            n10 = n20;
                                                                                                                            n13 = n16;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    i3 = i6;
                                                                                                                    if (var27_48 == false || var19_40 != false) break block84;
                                                                                                                    if (n21 == 0 && !bl13 && !bl14) break block82;
                                                                                                                    if (n21 == 0 || bl13) break block85;
                                                                                                                    e e6 = ((d)((Object)b2)).f.d;
                                                                                                                    n10 = bl2 && e6 instanceof u.a ? 8 : 5;
                                                                                                                    i i14 = i5;
                                                                                                                    break block86;
                                                                                                                }
                                                                                                                if (n21 != 0 || !bl13) break block87;
                                                                                                                ((r.d)object).e(i3, i5, -bArray2.f(), 8);
                                                                                                                if (bl2) {
                                                                                                                    e e7;
                                                                                                                    if (this.j && i4.m && (e7 = this.a0) != null) {
                                                                                                                        f f4 = (f)e7;
                                                                                                                        if (bl) {
                                                                                                                            f4.A1((d)((Object)b2));
                                                                                                                            break block82;
                                                                                                                        } else {
                                                                                                                            f4.F1((d)((Object)b2));
                                                                                                                        }
                                                                                                                        break block82;
                                                                                                                    } else {
                                                                                                                        ((r.d)object).h(i4, (i)object2, 0, 5);
                                                                                                                    }
                                                                                                                }
                                                                                                                break block82;
                                                                                                            }
                                                                                                            if (n21 == 0 || !bl13) break block82;
                                                                                                            e5 = ((d)((Object)b2)).f.d;
                                                                                                            e4 = bArray2.f.d;
                                                                                                            e3 = this.K();
                                                                                                            n12 = 6;
                                                                                                            if (n15 == 0) break block88;
                                                                                                            if (n14 != 0) break block89;
                                                                                                            if (n10 == 0 && n13 == 0) {
                                                                                                                if (i8.m && i5.m) {
                                                                                                                    ((r.d)object).e(i4, i8, ((d)((Object)b2)).f(), 8);
                                                                                                                    ((r.d)object).e(i3, i5, -bArray2.f(), 8);
                                                                                                                    return;
                                                                                                                }
                                                                                                                n10 = 8;
                                                                                                                n17 = 8;
                                                                                                                n11 = 0;
                                                                                                                n16 = 1;
                                                                                                                n20 = 0;
                                                                                                            } else {
                                                                                                                n10 = 5;
                                                                                                                n17 = 5;
                                                                                                                n11 = 1;
                                                                                                                n16 = 0;
                                                                                                                n20 = 1;
                                                                                                            }
                                                                                                            n19 = !(e5 instanceof u.a) && !(e4 instanceof u.a) ? n17 : 4;
                                                                                                            int n23 = 6;
                                                                                                            n18 = n16;
                                                                                                            n17 = n11;
                                                                                                            n16 = n10;
                                                                                                            n11 = n19;
                                                                                                            n10 = n23;
                                                                                                            break block90;
                                                                                                        }
                                                                                                        if (n14 != 2) break block91;
                                                                                                        n11 = !(e5 instanceof u.a) && !(e4 instanceof u.a) ? 5 : 4;
                                                                                                        n16 = 5;
                                                                                                        break block92;
                                                                                                    }
                                                                                                    if (n14 != 1) break block93;
                                                                                                    n11 = 4;
                                                                                                    n16 = 8;
                                                                                                }
                                                                                                n20 = 1;
                                                                                                n17 = 1;
                                                                                                break block94;
                                                                                            }
                                                                                            if (n14 != 3) break block95;
                                                                                            if (this.F != -1) break block96;
                                                                                            n10 = var20_41 != false ? (bl2 ? 5 : 4) : 8;
                                                                                            n11 = 5;
                                                                                            n16 = 8;
                                                                                            n20 = 1;
                                                                                            n17 = 1;
                                                                                            n18 = 1;
                                                                                            break block90;
                                                                                        }
                                                                                        if (var17_38 == false) break block97;
                                                                                        if (n17 != 2 && n17 != 1) {
                                                                                            n11 = 8;
                                                                                            n10 = 5;
                                                                                        } else {
                                                                                            n11 = 5;
                                                                                            n10 = 4;
                                                                                        }
                                                                                        bl12 = true;
                                                                                        n16 = n11;
                                                                                        n11 = n10;
                                                                                        break block98;
                                                                                    }
                                                                                    if (n10 <= 0) break block99;
                                                                                    n11 = 5;
                                                                                    break block100;
                                                                                }
                                                                                if (n10 != 0 || n13 != 0) break block101;
                                                                                if (var20_41 != false) break block102;
                                                                                n11 = 8;
                                                                                break block100;
                                                                            }
                                                                            n10 = e5 != e3 && e4 != e3 ? 4 : 5;
                                                                            bl12 = true;
                                                                            n11 = 4;
                                                                            n16 = n10;
                                                                        }
                                                                        n18 = 1;
                                                                        n17 = 1;
                                                                        n20 = 1;
                                                                        n10 = 6;
                                                                        break block90;
                                                                    }
                                                                    n11 = 4;
                                                                }
                                                                n18 = 1;
                                                                n17 = 1;
                                                                n20 = 1;
                                                                n10 = 6;
                                                                n16 = 5;
                                                                break block90;
                                                            }
                                                            n11 = 4;
                                                            n16 = 5;
                                                            n20 = 0;
                                                            n17 = 0;
                                                        }
                                                        n10 = 6;
                                                        n18 = 0;
                                                    }
                                                    n19 = n10;
                                                    break block103;
                                                }
                                                if (i8.m && i5.m) {
                                                    ((r.d)object).c(i4, i8, ((d)((Object)b2)).f(), (float)var16_37, i5, i3, bArray2.f(), 8);
                                                    if (!bl2) return;
                                                    if (!bl4) return;
                                                    n10 = bArray2.f != null ? bArray2.f() : 0;
                                                    if (i5 == var7_20) return;
                                                    ((r.d)object).h((i)var7_20, i3, n10, 5);
                                                    return;
                                                }
                                                n20 = 1;
                                                n17 = 1;
                                                n19 = 6;
                                                n16 = 5;
                                                n11 = 4;
                                                n18 = 0;
                                            }
                                            if (n20 != 0 && i8 == i5 && e5 != e3) {
                                                n20 = 0;
                                                n10 = 0;
                                            } else {
                                                n10 = 1;
                                            }
                                            if (n17 != 0) {
                                                void var18_39;
                                                if (n15 == 0 && var18_39 == false && var20_41 == false && i8 == object2 && i5 == var7_20) {
                                                    n17 = 8;
                                                    bl2 = false;
                                                    n16 = 8;
                                                    n10 = 0;
                                                } else {
                                                    n17 = n19;
                                                }
                                                ((r.d)object).c(i4, i8, ((d)((Object)b2)).f(), (float)var16_37, i5, i3, bArray2.f(), n17);
                                            }
                                            i7 = i6;
                                            n17 = 1;
                                            i9 = i5;
                                            if (this.s0 == 8 && !bArray2.m()) {
                                                return;
                                            }
                                            if (n20 != 0) {
                                                if (bl2 && i8 != i9 && n15 == 0 && (e5 instanceof u.a || e4 instanceof u.a)) {
                                                    n16 = 6;
                                                }
                                                ((r.d)object).h(i4, i8, ((d)((Object)b2)).f(), n16);
                                                ((r.d)object).j(i7, i9, -bArray2.f(), n16);
                                            }
                                            if (bl2 && var21_42 != false && !(e5 instanceof u.a) && !(e4 instanceof u.a) && e4 != e3) {
                                                n10 = 6;
                                                n16 = 6;
                                                n20 = n17;
                                            } else {
                                                n20 = n10;
                                                n10 = n11;
                                            }
                                            if (n20 == 0) break block104;
                                            n11 = n10;
                                            if (n18 == 0) break block105;
                                            if (var20_41 == false) break block106;
                                            n11 = n10;
                                            if (!bl3) break block105;
                                        }
                                        n11 = n12;
                                        if (e5 != e3) {
                                            n11 = e4 == e3 ? n12 : n10;
                                        }
                                        if (e5 instanceof h || e4 instanceof h) {
                                            n11 = 5;
                                        }
                                        if (e5 instanceof u.a || e4 instanceof u.a) {
                                            n11 = 5;
                                        }
                                        if (var20_41 != false) {
                                            n11 = 5;
                                        }
                                        n11 = Math.max((int)n11, (int)n10);
                                    }
                                    n10 = n11;
                                    if (!bl2) break block107;
                                    n10 = n11 = Math.min((int)n16, (int)n11);
                                    if (var17_38 == false) break block107;
                                    n10 = n11;
                                    if (var20_41 != false) break block107;
                                    if (e5 == e3) break block108;
                                    n10 = n11;
                                    if (e4 != e3) break block107;
                                }
                                n10 = 4;
                            }
                            ((r.d)object).e(i4, i8, ((d)((Object)b2)).f(), n10);
                            ((r.d)object).e(i7, i9, -bArray2.f(), n10);
                        }
                        if (bl2) {
                            n10 = object2 == i8 ? ((d)((Object)b2)).f() : 0;
                            if (i8 != object2) {
                                ((r.d)object).h(i4, (i)object2, n10, 5);
                            }
                        }
                        if (bl2 && n15 != 0 && var14_35 == false && n13 == 0) {
                            if (n15 != 0 && n14 == 3) {
                                ((r.d)object).h(i7, i4, 0, 8);
                                break block83;
                            } else {
                                ((r.d)object).h(i7, i4, 0, 5);
                            }
                        }
                        break block83;
                    }
                    i i15 = i5;
                }
                i i17 = i6;
                i17 = i5;
                n10 = 5;
            }
            if (!bl2) return;
            if (!bl4) return;
            n11 = bArray2.f != null ? bArray2.f() : 0;
            if (i5 == var7_20) return;
            if (this.j && i6.m && (e2 = this.a0) != null) {
                object = (f)e2;
                if (bl) {
                    ((f)object).z1((d)bArray2);
                    return;
                }
                ((f)object).E1((d)bArray2);
                return;
            }
            ((r.d)object).h((i)var7_20, i6, n11, n10);
            return;
        }
        if (n12 >= 2) return;
        if (!bl2) return;
        if (!bl4) return;
        ((r.d)object).h(i4, (i)object2, 0, 8);
        n11 = !bl && this.S.f != null ? 0 : 1;
        n10 = n11;
        if (!bl) {
            d d3 = this.S.f;
            n10 = n11;
            if (d3 != null) {
                b b3;
                e e8 = d3.d;
                n10 = e8.d0 != 0.0f && (b3 = (bArray2 = e8.Z)[0]) == (b2 = u.e$b.i) && bArray2[1] == b2 ? 1 : 0;
            }
        }
        if (n10 == 0) return;
        ((r.d)object).h((i)var7_20, i3, 0, 8);
    }

    private void x0(StringBuilder stringBuilder, String string, float f2, float f3) {
        if (f2 == f3) {
            return;
        }
        stringBuilder.append(string);
        stringBuilder.append(" :   ");
        stringBuilder.append(f2);
        stringBuilder.append(",\n");
    }

    private void y0(StringBuilder stringBuilder, String string, int n2, int n3) {
        if (n2 == n3) {
            return;
        }
        stringBuilder.append(string);
        stringBuilder.append(" :   ");
        stringBuilder.append(n2);
        stringBuilder.append(",\n");
    }

    private void z0(StringBuilder stringBuilder, String string, String string2, String string3) {
        if (string3.equals((Object)string2)) {
            return;
        }
        stringBuilder.append(string);
        stringBuilder.append(" :   ");
        stringBuilder.append(string2);
        stringBuilder.append(",\n");
    }

    public b A() {
        return this.Z[0];
    }

    public int B() {
        d d3 = this.O;
        int n2 = d3 != null ? d3.g : 0;
        d3 = this.Q;
        int n3 = n2;
        if (d3 != null) {
            n3 = n2 + d3.g;
        }
        return n3;
    }

    public void B0(int n2) {
        this.l0 = n2;
        boolean bl = n2 > 0;
        this.J = bl;
    }

    public int C() {
        return this.M;
    }

    public void C0(Object object) {
        this.q0 = object;
    }

    public int D() {
        return this.N;
    }

    public void D0(String string) {
        this.u0 = string;
    }

    public int E(int n2) {
        if (n2 == 0) {
            return this.W();
        }
        if (n2 == 1) {
            return this.x();
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    public void E0(String var1_1) {
        block8: {
            block10: {
                block9: {
                    if (var1_1 == null || var1_1.length() == 0) break block8;
                    var9_3 = var1_1.length();
                    var10_4 = var1_1.indexOf(44);
                    var7_5 = 0;
                    var6_6 = 0;
                    var8_7 = -1;
                    var5_8 = var7_5;
                    var4_9 = var8_7;
                    if (var10_4 > 0) {
                        var5_8 = var7_5;
                        var4_9 = var8_7;
                        if (var10_4 < var9_3 - 1) {
                            var11_10 = var1_1.substring(0, var10_4);
                            var4_9 = var11_10.equalsIgnoreCase("W") != false ? var6_6 : (var11_10.equalsIgnoreCase("H") != false ? 1 : -1);
                            var5_8 = var10_4 + 1;
                        }
                    }
                    if ((var6_6 = var1_1.indexOf(58)) < 0 || var6_6 >= var9_3 - 1) break block9;
                    var11_10 = var1_1.substring(var5_8, var6_6);
                    var1_1 = var1_1.substring(var6_6 + 1);
                    if (var11_10.length() <= 0 || var1_1.length() <= 0) break block10;
                    var3_11 = Float.parseFloat((String)var11_10);
                    var2_12 = Float.parseFloat((String)var1_1);
                    if (!(var3_11 > 0.0f) || !(var2_12 > 0.0f)) break block10;
                    if (var4_9 != 1) ** GOTO lbl28
                    var2_12 = Math.abs((float)(var2_12 / var3_11));
                    ** GOTO lbl40
lbl28:
                    // 1 sources

                    var2_12 = Math.abs((float)(var3_11 / var2_12));
                    ** GOTO lbl40
                }
                if ((var1_1 = var1_1.substring(var5_8)).length() <= 0) break block10;
                try {
                    var2_12 = Float.parseFloat((String)var1_1);
                    ** GOTO lbl40
                }
                catch (NumberFormatException var1_2) {
                    ** continue;
                }
            }
            while (true) {
                var2_12 = 0.0f;
lbl40:
                // 4 sources

                if (var2_12 > 0.0f) {
                    this.d0 = var2_12;
                    this.e0 = var4_9;
                }
                return;
            }
        }
        this.d0 = 0.0f;
    }

    public int F() {
        return this.H[1];
    }

    public void F0(int n2) {
        if (!this.J) {
            return;
        }
        int n3 = n2 - this.l0;
        int n4 = this.c0;
        this.g0 = n3;
        this.P.t(n3);
        this.R.t(n4 + n3);
        this.S.t(n2);
        this.q = true;
    }

    public int G() {
        return this.H[0];
    }

    public void G0(int n2, int n3) {
        if (this.p) {
            return;
        }
        this.O.t(n2);
        this.Q.t(n3);
        this.f0 = n2;
        this.b0 = n3 - n2;
        this.p = true;
    }

    public int H() {
        return this.n0;
    }

    public void H0(int n2) {
        this.O.t(n2);
        this.f0 = n2;
    }

    public int I() {
        return this.m0;
    }

    public void I0(int n2) {
        this.P.t(n2);
        this.g0 = n2;
    }

    public e J(int n2) {
        if (n2 == 0) {
            d d3 = this.Q;
            d d4 = d3.f;
            if (d4 != null && d4.f == d3) {
                return d4.d;
            }
        } else if (n2 == 1) {
            d d5 = this.R;
            d d6 = d5.f;
            if (d6 != null && d6.f == d5) {
                return d6.d;
            }
        }
        return null;
    }

    public void J0(int n2, int n3) {
        if (this.q) {
            return;
        }
        this.P.t(n2);
        this.R.t(n3);
        this.g0 = n2;
        this.c0 = n3 - n2;
        if (this.J) {
            this.S.t(n2 + this.l0);
        }
        this.q = true;
    }

    public e K() {
        return this.a0;
    }

    public void K0(int n2, int n3, int n4, int n5) {
        int n6 = n4 - n2;
        n4 = n5 - n3;
        this.f0 = n2;
        this.g0 = n3;
        if (this.s0 == 8) {
            this.b0 = 0;
            this.c0 = 0;
            return;
        }
        b[] bArray = this.Z;
        b b2 = bArray[0];
        b b3 = u.e$b.g;
        n2 = n6;
        if (b2 == b3) {
            n3 = this.b0;
            n2 = n6;
            if (n6 < n3) {
                n2 = n3;
            }
        }
        n3 = n4;
        if (bArray[1] == b3) {
            n5 = this.c0;
            n3 = n4;
            if (n4 < n5) {
                n3 = n5;
            }
        }
        this.b0 = n2;
        this.c0 = n3;
        n4 = this.n0;
        if (n3 < n4) {
            this.c0 = n4;
        }
        if (n2 < (n4 = this.m0)) {
            this.b0 = n4;
        }
        if ((n4 = this.A) > 0 && b2 == u.e$b.i) {
            this.b0 = Math.min((int)this.b0, (int)n4);
        }
        if ((n4 = this.D) > 0 && this.Z[1] == u.e$b.i) {
            this.c0 = Math.min((int)this.c0, (int)n4);
        }
        if (n2 != (n4 = this.b0)) {
            this.l = n4;
        }
        if (n3 != (n2 = this.c0)) {
            this.m = n2;
        }
    }

    public e L(int n2) {
        if (n2 == 0) {
            d d3 = this.O;
            d d4 = d3.f;
            if (d4 != null && d4.f == d3) {
                return d4.d;
            }
        } else if (n2 == 1) {
            d d5 = this.P;
            d d6 = d5.f;
            if (d6 != null && d6.f == d5) {
                return d6.d;
            }
        }
        return null;
    }

    public void L0(boolean bl) {
        this.J = bl;
    }

    public int M() {
        return this.X() + this.b0;
    }

    public void M0(int n2) {
        this.c0 = n2;
        int n3 = this.n0;
        if (n2 < n3) {
            this.c0 = n3;
        }
    }

    public p N(int n2) {
        if (n2 == 0) {
            return this.e;
        }
        if (n2 == 1) {
            return this.f;
        }
        return null;
    }

    public void N0(float f2) {
        this.o0 = f2;
    }

    public void O(StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("  ");
        stringBuilder2.append(this.o);
        stringBuilder2.append(":{\n");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("    actualWidth:");
        stringBuilder2.append(this.b0);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\n");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("    actualHeight:");
        stringBuilder2.append(this.c0);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\n");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("    actualLeft:");
        stringBuilder2.append(this.f0);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\n");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("    actualTop:");
        stringBuilder2.append(this.g0);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\n");
        this.Q(stringBuilder, "left", this.O);
        this.Q(stringBuilder, "top", this.P);
        this.Q(stringBuilder, "right", this.Q);
        this.Q(stringBuilder, "bottom", this.R);
        this.Q(stringBuilder, "baseline", this.S);
        this.Q(stringBuilder, "centerX", this.T);
        this.Q(stringBuilder, "centerY", this.U);
        this.P(stringBuilder, "    width", this.b0, this.m0, this.H[0], this.l, this.z, this.w, this.B, this.Z[0], this.D0[0]);
        this.P(stringBuilder, "    height", this.c0, this.n0, this.H[1], this.m, this.C, this.x, this.E, this.Z[1], this.D0[1]);
        this.A0(stringBuilder, "    dimensionRatio", this.d0, this.e0);
        this.x0(stringBuilder, "    horizontalBias", this.o0, K0);
        this.x0(stringBuilder, "    verticalBias", this.p0, K0);
        this.y0(stringBuilder, "    horizontalChainStyle", this.z0, 0);
        this.y0(stringBuilder, "    verticalChainStyle", this.A0, 0);
        stringBuilder.append("  }");
    }

    public void O0(int n2) {
        this.z0 = n2;
    }

    public void P0(int n2, int n3) {
        this.f0 = n2;
        this.b0 = n2 = n3 - n2;
        n3 = this.m0;
        if (n2 < n3) {
            this.b0 = n3;
        }
    }

    public void Q0(b b2) {
        this.Z[0] = b2;
    }

    public float R() {
        return this.p0;
    }

    public void R0(int n2, int n3, int n4, float f2) {
        this.w = n2;
        this.z = n3;
        n3 = n4;
        if (n4 == Integer.MAX_VALUE) {
            n3 = 0;
        }
        this.A = n3;
        this.B = f2;
        if (f2 > 0.0f && f2 < 1.0f && n2 == 0) {
            this.w = 2;
        }
    }

    public int S() {
        return this.A0;
    }

    public void S0(float f2) {
        this.D0[0] = f2;
    }

    public b T() {
        return this.Z[1];
    }

    protected void T0(int n2, boolean bl) {
        this.Y[n2] = bl;
    }

    public int U() {
        int n2 = this.O != null ? this.P.g : 0;
        int n3 = n2;
        if (this.Q != null) {
            n3 = n2 + this.R.g;
        }
        return n3;
    }

    public void U0(boolean bl) {
        this.K = bl;
    }

    public int V() {
        return this.s0;
    }

    public void V0(boolean bl) {
        this.L = bl;
    }

    public int W() {
        if (this.s0 == 8) {
            return 0;
        }
        return this.b0;
    }

    public void W0(int n2, int n3) {
        this.M = n2;
        this.N = n3;
        this.Z0(false);
    }

    public int X() {
        e e2 = this.a0;
        if (e2 != null && e2 instanceof f) {
            return ((f)e2).S0 + this.f0;
        }
        return this.f0;
    }

    public void X0(int n2) {
        this.H[1] = n2;
    }

    public int Y() {
        e e2 = this.a0;
        if (e2 != null && e2 instanceof f) {
            return ((f)e2).T0 + this.g0;
        }
        return this.g0;
    }

    public void Y0(int n2) {
        this.H[0] = n2;
    }

    public boolean Z() {
        return this.J;
    }

    public void Z0(boolean bl) {
        this.i = bl;
    }

    public boolean a0(int n2) {
        int n3;
        int n4;
        if (n2 == 0) {
            int n5;
            n2 = this.O.f != null ? 1 : 0;
            return n2 + (n5 = this.Q.f != null ? 1 : 0) < 2;
        }
        n2 = this.P.f != null ? 1 : 0;
        return n2 + (n4 = this.R.f != null ? 1 : 0) + (n3 = this.S.f != null ? 1 : 0) < 2;
    }

    public void a1(int n2) {
        if (n2 < 0) {
            this.n0 = 0;
            return;
        }
        this.n0 = n2;
    }

    public boolean b0() {
        int n2 = this.X.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!((d)this.X.get(i2)).m()) continue;
            return true;
        }
        return false;
    }

    public void b1(int n2) {
        if (n2 < 0) {
            this.m0 = 0;
            return;
        }
        this.m0 = n2;
    }

    public boolean c0() {
        return this.l != -1 || this.m != -1;
        {
        }
    }

    public void c1(int n2, int n3) {
        this.f0 = n2;
        this.g0 = n3;
    }

    public boolean d0(int n2, int n3) {
        if (n2 == 0) {
            d d3 = this.O.f;
            if (d3 != null && d3.n() && (d3 = this.Q.f) != null && d3.n()) {
                return this.Q.f.e() - this.Q.f() - (this.O.f.e() + this.O.f()) >= n3;
            }
        } else {
            d d4 = this.P.f;
            if (d4 != null && d4.n() && (d4 = this.R.f) != null && d4.n() && this.R.f.e() - this.R.f() - (this.P.f.e() + this.P.f()) >= n3) {
                return true;
            }
        }
        return false;
    }

    public void d1(e e2) {
        this.a0 = e2;
    }

    public void e(f f2, r.d d3, HashSet hashSet, int n2, boolean bl) {
        block12: {
            block13: {
                block11: {
                    if (!bl) break block11;
                    if (!hashSet.contains((Object)this)) break block12;
                    u.k.a(f2, d3, this);
                    hashSet.remove((Object)this);
                    this.g(d3, f2.V1(64));
                }
                if (n2 != 0) break block13;
                HashSet hashSet2 = this.O.d();
                if (hashSet2 != null) {
                    hashSet2 = hashSet2.iterator();
                    while (hashSet2.hasNext()) {
                        ((d)hashSet2.next()).d.e(f2, d3, hashSet, n2, true);
                    }
                }
                if ((hashSet2 = this.Q.d()) == null) break block12;
                hashSet2 = hashSet2.iterator();
                while (hashSet2.hasNext()) {
                    ((d)hashSet2.next()).d.e(f2, d3, hashSet, n2, true);
                }
                break block12;
            }
            Object object = this.P.d();
            if (object != null) {
                object = object.iterator();
                while (object.hasNext()) {
                    ((d)object.next()).d.e(f2, d3, hashSet, n2, true);
                }
            }
            if ((object = this.R.d()) != null) {
                object = object.iterator();
                while (object.hasNext()) {
                    ((d)object.next()).d.e(f2, d3, hashSet, n2, true);
                }
            }
            if ((object = this.S.d()) != null) {
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    object = ((d)iterator.next()).d;
                    ((e)object).e(f2, d3, hashSet, n2, true);
                }
            }
        }
    }

    public void e0(d.a a2, e e2, d.a a3, int n2, int n3) {
        this.o(a2).b(e2.o(a3), n2, n3, true);
    }

    public void e1(float f2) {
        this.p0 = f2;
    }

    boolean f() {
        return this instanceof l || this instanceof h;
        {
        }
    }

    public void f1(int n2) {
        this.A0 = n2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void g(r.d var1_1, boolean var2_2) {
        block65: {
            block67: {
                block66: {
                    block61: {
                        block63: {
                            block64: {
                                block62: {
                                    block60: {
                                        block58: {
                                            block59: {
                                                block57: {
                                                    var32_3 = var1_1.q(this.O);
                                                    var26_4 = var1_1.q(this.Q);
                                                    var33_5 = var1_1.q(this.P);
                                                    var31_6 = var1_1.q(this.R);
                                                    var34_7 = var1_1.q(this.S);
                                                    var27_8 /* !! */  = this.a0;
                                                    if (var27_8 /* !! */  == null) break block57;
                                                    var14_9 = var27_8 /* !! */  != null && var27_8 /* !! */ .Z[0] == u.e$b.h;
                                                    var13_10 = var27_8 /* !! */  != null && var27_8 /* !! */ .Z[1] == u.e$b.h;
                                                    var4_11 = this.v;
                                                    if (var4_11 == 1) break block58;
                                                    if (var4_11 == 2) break block59;
                                                    if (var4_11 != 3) break block60;
                                                }
                                                var13_10 = false;
                                                var14_9 = false;
                                                break block60;
                                            }
                                            var14_9 = false;
                                            break block60;
                                        }
                                        var13_10 = false;
                                    }
                                    if (this.s0 == 8 && !this.t0 && !this.b0() && (var27_8 /* !! */  = (Object)this.Y)[0] == false && var27_8 /* !! */ [1] == false) {
                                        return;
                                    }
                                    var15_12 = this.p;
                                    if (var15_12 || this.q) {
                                        if (var15_12) {
                                            var1_1.f(var32_3, this.f0);
                                            var1_1.f((i)var26_4, this.f0 + this.b0);
                                            if (var14_9 && (var27_8 /* !! */  = this.a0) != null) {
                                                if (this.k) {
                                                    var27_8 /* !! */  = (f)var27_8 /* !! */ ;
                                                    var27_8 /* !! */ .A1(this.O);
                                                    var27_8 /* !! */ .z1(this.Q);
                                                } else {
                                                    var1_1.h(var1_1.q(var27_8 /* !! */ .Q), (i)var26_4, 0, 5);
                                                }
                                            }
                                        }
                                        if (this.q) {
                                            var1_1.f(var33_5, this.g0);
                                            var1_1.f(var31_6, this.g0 + this.c0);
                                            if (this.S.m()) {
                                                var1_1.f((i)var34_7, this.g0 + this.l0);
                                            }
                                            if (var13_10 && (var27_8 /* !! */  = this.a0) != null) {
                                                if (this.k) {
                                                    var27_8 /* !! */  = (f)var27_8 /* !! */ ;
                                                    var27_8 /* !! */ .F1(this.P);
                                                    var27_8 /* !! */ .E1(this.R);
                                                } else {
                                                    var1_1.h(var1_1.q(var27_8 /* !! */ .R), var31_6, 0, 5);
                                                }
                                            }
                                        }
                                        if (this.p && this.q) {
                                            this.p = false;
                                            this.q = false;
                                            return;
                                        }
                                    }
                                    var15_12 = r.d.s;
                                    if (var2_2 && (var27_8 /* !! */  = this.e) != null && (var28_13 /* !! */  = this.f) != null) {
                                        var29_14 /* !! */  = var27_8 /* !! */ .h;
                                        if (var29_14 /* !! */ .j && var27_8 /* !! */ .i.j && var28_13 /* !! */ .h.j && var28_13 /* !! */ .i.j) {
                                            var1_1.f(var32_3, var29_14 /* !! */ .g);
                                            var1_1.f((i)var26_4, this.e.i.g);
                                            var1_1.f(var33_5, this.f.h.g);
                                            var1_1.f(var31_6, this.f.i.g);
                                            var1_1.f((i)var34_7, this.f.k.g);
                                            if (this.a0 != null) {
                                                if (var14_9 && this.g[0] && !this.i0()) {
                                                    var1_1.h(var1_1.q(this.a0.Q), (i)var26_4, 0, 8);
                                                }
                                                if (var13_10 && this.g[1] && !this.k0()) {
                                                    var1_1.h(var1_1.q(this.a0.R), var31_6, 0, 8);
                                                }
                                            }
                                            this.p = false;
                                            this.q = false;
                                            return;
                                        }
                                    }
                                    if (this.a0 != null) {
                                        if (this.f0(0)) {
                                            ((f)this.a0).w1(this, 0);
                                            var15_12 = true;
                                        } else {
                                            var15_12 = this.i0();
                                        }
                                        if (this.f0(1)) {
                                            ((f)this.a0).w1(this, 1);
                                            var16_15 = true;
                                        } else {
                                            var16_15 = this.k0();
                                        }
                                        if (!var15_12 && var14_9 && this.s0 != 8 && this.O.f == null && this.Q.f == null) {
                                            var1_1.h(var1_1.q(this.a0.Q), (i)var26_4, 0, 1);
                                        }
                                        if (!var16_15 && var13_10 && this.s0 != 8 && this.P.f == null && this.R.f == null && this.S == null) {
                                            var1_1.h(var1_1.q(this.a0.R), var31_6, 0, 1);
                                        }
                                        var17_16 = var16_15;
                                        var16_15 = var15_12;
                                    } else {
                                        var16_15 = false;
                                        var17_16 = false;
                                    }
                                    var10_17 = this.b0;
                                    var7_18 = this.m0;
                                    if (var10_17 >= var7_18) {
                                        var7_18 = var10_17;
                                    }
                                    var9_19 = this.c0;
                                    var4_11 = this.n0;
                                    if (var9_19 >= var4_11) {
                                        var4_11 = var9_19;
                                    }
                                    var28_13 /* !! */  = this.Z;
                                    var27_8 /* !! */  = var28_13 /* !! */ [0];
                                    var35_20 = u.e$b.i;
                                    var15_12 = var27_8 /* !! */  != var35_20;
                                    var28_13 /* !! */  = var28_13 /* !! */ [1];
                                    var18_21 = var28_13 /* !! */  != var35_20;
                                    this.F = var11_22 = this.e0;
                                    this.G = var3_23 = this.d0;
                                    var6_24 = this.w;
                                    var8_25 = this.x;
                                    if (!(var3_23 > 0.0f)) break block61;
                                    var12_26 = this.s0;
                                    var5_27 = var4_11;
                                    if (var12_26 == 8) break block61;
                                    if (var27_8 /* !! */  == var35_20 && var6_24 == 0) {
                                        var6_24 = 3;
                                    }
                                    var4_11 = var28_13 /* !! */  == var35_20 && var8_25 == 0 ? 3 : var8_25;
                                    if (var27_8 /* !! */  != var35_20 || var28_13 /* !! */  != var35_20 || var6_24 != 3 || var4_11 != 3) break block62;
                                    this.p1(var14_9, var13_10, var15_12, var18_21);
                                    var9_19 = var5_27;
                                    break block63;
                                }
                                if (var27_8 /* !! */  != var35_20 || var6_24 != 3) break block64;
                                this.F = 0;
                                var7_18 = (int)((float)var9_19 * var3_23);
                                if (var28_13 /* !! */  != var35_20) {
                                    var8_25 = 4;
                                    var6_24 = var4_11;
                                    var4_11 = var5_27;
                                    var5_27 = var6_24;
                                    var6_24 = var8_25;
lbl131:
                                    // 3 sources

                                    while (true) {
                                        var15_12 = false;
                                        var8_25 = var5_27;
lbl134:
                                        // 3 sources

                                        while (true) {
                                            continue;
                                            break;
                                        }
                                        break;
                                    }
                                }
                                var15_12 = true;
                                var8_25 = var4_11;
                                var4_11 = var5_27;
                                ** GOTO lbl134
                            }
                            var9_19 = var5_27;
                            if (var28_13 /* !! */  != var35_20) break block63;
                            var9_19 = var5_27;
                            if (var4_11 != 3) break block63;
                            this.F = 1;
                            if (var11_22 == -1) {
                                this.G = 1.0f / var3_23;
                            }
                            var9_19 = var8_25 = (int)(this.G * (float)var10_17);
                            if (var27_8 /* !! */  == var35_20) break block63;
                            var5_27 = 4;
                            var4_11 = var8_25;
                            ** GOTO lbl131
                        }
                        var15_12 = true;
                        var8_25 = var4_11;
                        var4_11 = var9_19;
                        ** while (true)
                    }
                    var5_27 = var8_25;
                    ** while (true)
                    var27_8 /* !! */  = var26_4;
                    var28_13 /* !! */  = (v.l)this.y;
                    var28_13 /* !! */ [0] = (b)var6_24;
                    var28_13 /* !! */ [1] = (b)var8_25;
                    this.h = var15_12;
                    var19_28 = var15_12 && ((var5_27 = this.F) == 0 || var5_27 == -1);
                    var18_21 = var15_12 != false && ((var5_27 = this.F) == 1 || var5_27 == -1);
                    var28_13 /* !! */  = this.Z[0];
                    var36_29 = u.e$b.h;
                    var20_30 = var28_13 /* !! */  == var36_29 && this instanceof f != false;
                    var5_27 = var20_30 != false ? 0 : var7_18;
                    var22_31 = this.V.o() ^ true;
                    var28_13 /* !! */  = (v.l)this.Y;
                    var24_32 = var28_13 /* !! */ [0];
                    var23_33 = var28_13 /* !! */ [1];
                    var7_18 = this.t;
                    var30_34 = null;
                    if (var7_18 == 2 || this.p) ** GOTO lbl187
                    if (!var2_2 || (var28_13 /* !! */  = this.e) == null) ** GOTO lbl-1000
                    var29_14 /* !! */  = var28_13 /* !! */ .h;
                    if (var29_14 /* !! */ .j && var28_13 /* !! */ .i.j) {
                        if (var2_2) {
                            var1_1.f(var32_3, var29_14 /* !! */ .g);
                            var1_1.f((i)var27_8 /* !! */ , this.e.i.g);
                            if (this.a0 != null && var14_9 && this.g[0] && !this.i0()) {
                                var1_1.h(var1_1.q(this.a0.Q), (i)var27_8 /* !! */ , 0, 8);
                            }
                        }
lbl187:
                        // 6 sources

                        var27_8 /* !! */  = var26_4;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var28_13 /* !! */  = (var28_13 /* !! */  = this.a0) != null ? var1_1.q(var28_13 /* !! */ .Q) : null;
                        var29_14 /* !! */  = this.a0;
                        var29_14 /* !! */  = var29_14 /* !! */  != null ? var1_1.q(var29_14 /* !! */ .O) : null;
                        var25_35 = this.g[0];
                        var37_36 = this.Z;
                        var38_37 = var37_36[0];
                        var39_38 = this.O;
                        var27_8 /* !! */  = this.Q;
                        var7_18 = this.f0;
                        var10_17 = this.m0;
                        var9_19 = this.H[0];
                        var3_23 = this.o0;
                        var21_39 = var37_36[1] == var35_20;
                        this.i(var1_1, true, var14_9, var13_10, var25_35, (i)var29_14 /* !! */ , (i)var28_13 /* !! */ , var38_37, var20_30, var39_38, (d)var27_8 /* !! */ , var7_18, var5_27, var10_17, var9_19, var3_23, var19_28, var21_39, var16_15, var17_16, (boolean)var24_32, var6_24, var8_25, this.z, this.A, this.B, var22_31);
                    }
                    var28_13 /* !! */  = var26_4;
                    if (!var2_2 || (var26_4 = this.f) == null) ** GOTO lbl-1000
                    var27_8 /* !! */  = var26_4.h;
                    if (var27_8 /* !! */ .j && var26_4.i.j) {
                        var1_1.f(var33_5, var27_8 /* !! */ .g);
                        var5_27 = this.f.i.g;
                        var1_1.f(var31_6, var5_27);
                        var1_1.f((i)var34_7, this.f.k.g);
                        var26_4 = this.a0;
                        if (var26_4 != null && !var17_16 && var13_10 && this.g[1]) {
                            var1_1.h(var1_1.q(var26_4.R), var31_6, 0, 8);
                        }
                        var5_27 = 0;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var5_27 = 1;
                    }
                    if (this.u == 2) {
                        var5_27 = 0;
                    }
                    if (var5_27 == 0 || this.q) break block65;
                    var2_2 = this.Z[1] == var36_29 && this instanceof f != false;
                    if (var2_2) {
                        var4_11 = 0;
                    }
                    var26_4 = (var26_4 = this.a0) != null ? var1_1.q(var26_4.R) : null;
                    var29_14 /* !! */  = this.a0;
                    var27_8 /* !! */  = var30_34;
                    if (var29_14 /* !! */  != null) {
                        var27_8 /* !! */  = var1_1.q(var29_14 /* !! */ .P);
                    }
                    if (this.l0 > 0) break block66;
                    var19_28 = var22_31;
                    if (this.s0 != 8) break block67;
                }
                var29_14 /* !! */  = this.S;
                if (var29_14 /* !! */ .f != null) {
                    var1_1.e((i)var34_7, var33_5, this.p(), 8);
                    var1_1.e((i)var34_7, var1_1.q(this.S.f), this.S.f(), 8);
                    if (var13_10) {
                        var1_1.h((i)var26_4, var1_1.q(this.R), 0, 5);
                    }
                    var19_28 = false;
                } else if (this.s0 == 8) {
                    var1_1.e((i)var34_7, var33_5, var29_14 /* !! */ .f(), 8);
                    var19_28 = var22_31;
                } else {
                    var1_1.e((i)var34_7, var33_5, this.p(), 8);
                    var19_28 = var22_31;
                }
            }
            var21_39 = this.g[1];
            var29_14 /* !! */  = this.Z;
            var36_29 = var29_14 /* !! */ [1];
            var34_7 = this.P;
            var30_34 = this.R;
            var9_19 = this.g0;
            var7_18 = this.n0;
            var5_27 = this.H[1];
            var3_23 = this.p0;
            var20_30 = var29_14 /* !! */ [0] == var35_20;
            this.i(var1_1, false, var13_10, var14_9, var21_39, (i)var27_8 /* !! */ , (i)var26_4, var36_29, var2_2, (d)var34_7, var30_34, var9_19, var4_11, var7_18, var5_27, var3_23, var18_21, var20_30, var17_16, var16_15, (boolean)var23_33, var8_25, var6_24, this.C, this.D, this.E, var19_28);
        }
        if (var15_12) {
            if (this.F == 1) {
                var1_1.k(var31_6, var33_5, (i)var28_13 /* !! */ , var32_3, this.G, 8);
            } else {
                var1_1.k((i)var28_13 /* !! */ , var32_3, var31_6, var33_5, this.G, 8);
            }
        }
        if (this.V.o()) {
            var1_1.b(this, this.V.j().h(), (float)Math.toRadians((double)(this.I + 90.0f)), this.V.f());
        }
        this.p = false;
        this.q = false;
    }

    public boolean g0() {
        return this.r;
    }

    public void g1(int n2, int n3) {
        this.g0 = n2;
        this.c0 = n3 -= n2;
        n2 = this.n0;
        if (n3 < n2) {
            this.c0 = n2;
        }
    }

    public boolean h() {
        return this.s0 != 8;
    }

    public boolean h0(int n2) {
        return this.Y[n2];
    }

    public void h1(b b2) {
        this.Z[1] = b2;
    }

    public boolean i0() {
        block3: {
            block2: {
                d d3 = this.O;
                d d4 = d3.f;
                if (d4 != null && d4.f == d3) break block2;
                d4 = this.Q;
                d3 = d4.f;
                if (d3 == null || d3.f != d4) break block3;
            }
            return true;
        }
        return false;
    }

    public void i1(int n2, int n3, int n4, float f2) {
        this.x = n2;
        this.C = n3;
        n3 = n4;
        if (n4 == Integer.MAX_VALUE) {
            n3 = 0;
        }
        this.D = n3;
        this.E = f2;
        if (f2 > 0.0f && f2 < 1.0f && n2 == 0) {
            this.x = 2;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void j(d.a object, e object2, d.a object3, int n2) {
        Object object4;
        d d3;
        int n3;
        void var3_19;
        d.a a2 = d.a.m;
        if (object == a2) {
            if (var3_19 == a2) {
                d.a a3 = d.a.h;
                d d4 = this.o(a3);
                d.a a4 = d.a.j;
                d d5 = this.o(a4);
                d.a a5 = d.a.i;
                d d6 = this.o(a5);
                d.a a6 = d.a.k;
                d d7 = this.o(a6);
                boolean bl = true;
                if (d4 != null && d4.o() || d5 != null && d5.o()) {
                    n3 = 0;
                } else {
                    this.j(a3, (e)((Object)d3), a3, 0);
                    this.j(a4, (e)((Object)d3), a4, 0);
                    n3 = 1;
                }
                if (d6 != null && d6.o() || d7 != null && d7.o()) {
                    bl = false;
                } else {
                    this.j(a5, (e)((Object)d3), a5, 0);
                    this.j(a6, (e)((Object)d3), a6, 0);
                }
                if (n3 != 0 && bl) {
                    this.o(a2).a(((e)((Object)d3)).o(a2), 0);
                    return;
                }
                if (n3 != 0) {
                    d.a a7 = d.a.n;
                    this.o(a7).a(((e)((Object)d3)).o(a7), 0);
                    return;
                }
                if (!bl) return;
                d.a a8 = d.a.o;
                this.o(a8).a(((e)((Object)d3)).o(a8), 0);
                return;
            }
            d.a a9 = d.a.h;
            if (var3_19 != a9 && var3_19 != d.a.j) {
                d.a a10 = d.a.i;
                if (var3_19 != a10 && var3_19 != d.a.k) return;
                this.j(a10, (e)((Object)d3), (d.a)var3_19, 0);
                this.j(d.a.k, (e)((Object)d3), (d.a)var3_19, 0);
                this.o(a2).a(((e)((Object)d3)).o((d.a)var3_19), 0);
                return;
            }
            this.j(a9, (e)((Object)d3), (d.a)var3_19, 0);
            d.a a11 = d.a.j;
            this.j(a11, (e)((Object)d3), (d.a)var3_19, 0);
            this.o(a2).a(((e)((Object)d3)).o((d.a)var3_19), 0);
            return;
        }
        d.a a12 = d.a.n;
        if (object == a12 && (var3_19 == (object4 = d.a.h) || var3_19 == d.a.j)) {
            d d8 = this.o((d.a)((Object)object4));
            d d9 = ((e)((Object)d3)).o((d.a)var3_19);
            d3 = this.o(d.a.j);
            d8.a(d9, 0);
            d3.a(d9, 0);
            this.o(a12).a(d9, 0);
            return;
        }
        d.a a13 = d.a.o;
        if (object == a13 && (var3_19 == (object4 = d.a.i) || var3_19 == d.a.k)) {
            d d10 = ((e)((Object)d3)).o((d.a)var3_19);
            this.o((d.a)((Object)object4)).a(d10, 0);
            this.o(d.a.k).a(d10, 0);
            this.o(a13).a(d10, 0);
            return;
        }
        if (object == a12 && var3_19 == a12) {
            d.a a14 = d.a.h;
            this.o(a14).a(((e)((Object)d3)).o(a14), 0);
            d.a a15 = d.a.j;
            this.o(a15).a(((e)((Object)d3)).o(a15), 0);
            this.o(a12).a(((e)((Object)d3)).o((d.a)var3_19), 0);
            return;
        }
        if (object == a13 && var3_19 == a13) {
            d.a a16 = d.a.i;
            this.o(a16).a(((e)((Object)d3)).o(a16), 0);
            d.a a17 = d.a.k;
            this.o(a17).a(((e)((Object)d3)).o(a17), 0);
            this.o(a13).a(((e)((Object)d3)).o((d.a)var3_19), 0);
            return;
        }
        object4 = this.o((d.a)((Object)object));
        if (!((d)object4).p(d3 = ((e)((Object)d3)).o((d.a)var3_19))) return;
        d.a a18 = d.a.l;
        if (object == a18) {
            d d11 = this.o(d.a.i);
            d d12 = this.o(d.a.k);
            if (d11 != null) {
                d11.q();
            }
            if (d12 != null) {
                d12.q();
            }
        } else if (object != d.a.i && object != d.a.k) {
            if (object == d.a.h || object == d.a.j) {
                d d13 = this.o(a2);
                if (d13.j() != d3) {
                    d13.q();
                }
                d d14 = this.o((d.a)((Object)object)).g();
                d d15 = this.o(a12);
                if (d15.o()) {
                    d14.q();
                    d15.q();
                }
            }
        } else {
            d d16;
            d d17 = this.o(a18);
            if (d17 != null) {
                d17.q();
            }
            if ((d16 = this.o(a2)).j() != d3) {
                d16.q();
            }
            d d18 = this.o((d.a)((Object)object)).g();
            d d19 = this.o(a13);
            if (d19.o()) {
                d18.q();
                d19.q();
            }
        }
        ((d)object4).a(d3, n3);
    }

    public boolean j0() {
        return this.K;
    }

    public void j1(float f2) {
        this.D0[1] = f2;
    }

    public void k(d d3, d d4, int n2) {
        if (d3.h() == this) {
            this.j(d3.k(), d4.h(), d4.k(), n2);
        }
    }

    public boolean k0() {
        block3: {
            block2: {
                d d3 = this.P;
                d d4 = d3.f;
                if (d4 != null && d4.f == d3) break block2;
                d4 = this.R;
                d3 = d4.f;
                if (d3 == null || d3.f != d4) break block3;
            }
            return true;
        }
        return false;
    }

    public void k1(int n2) {
        this.s0 = n2;
    }

    public void l(e e2, float f2, int n2) {
        d.a a2 = d.a.m;
        this.e0(a2, e2, a2, n2, 0);
        this.I = f2;
    }

    public boolean l0() {
        return this.L;
    }

    public void l1(int n2) {
        this.b0 = n2;
        int n3 = this.m0;
        if (n2 < n3) {
            this.b0 = n3;
        }
    }

    public void m(r.d d3) {
        d3.q(this.O);
        d3.q(this.P);
        d3.q(this.Q);
        d3.q(this.R);
        if (this.l0 > 0) {
            d3.q(this.S);
        }
    }

    public boolean m0() {
        return this.i && this.s0 != 8;
    }

    public void m1(int n2) {
        if (n2 >= 0 && n2 <= 3) {
            this.v = n2;
        }
    }

    public void n() {
        if (this.e == null) {
            this.e = new v.l(this);
        }
        if (this.f == null) {
            this.f = new n(this);
        }
    }

    public boolean n0() {
        return this.p || this.O.n() && this.Q.n();
        {
        }
    }

    public void n1(int n2) {
        this.f0 = n2;
    }

    public d o(d.a a2) {
        switch (u.e$a.a[a2.ordinal()]) {
            default: {
                throw new AssertionError((Object)a2.name());
            }
            case 9: {
                return null;
            }
            case 8: {
                return this.U;
            }
            case 7: {
                return this.T;
            }
            case 6: {
                return this.V;
            }
            case 5: {
                return this.S;
            }
            case 4: {
                return this.R;
            }
            case 3: {
                return this.Q;
            }
            case 2: {
                return this.P;
            }
            case 1: 
        }
        return this.O;
    }

    public boolean o0() {
        return this.q || this.P.n() && this.R.n();
        {
        }
    }

    public void o1(int n2) {
        this.g0 = n2;
    }

    public int p() {
        return this.l0;
    }

    public boolean p0() {
        return this.s;
    }

    public void p1(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (this.F == -1) {
            if (bl3 && !bl4) {
                this.F = 0;
            } else if (!bl3 && bl4) {
                this.F = 1;
                if (this.e0 == -1) {
                    this.G = 1.0f / this.G;
                }
            }
        }
        if (!(this.F != 0 || this.P.o() && this.R.o())) {
            this.F = 1;
        } else if (!(this.F != 1 || this.O.o() && this.Q.o())) {
            this.F = 0;
        }
        if (!(this.F != -1 || this.P.o() && this.R.o() && this.O.o() && this.Q.o())) {
            if (this.P.o() && this.R.o()) {
                this.F = 0;
            } else if (this.O.o() && this.Q.o()) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
        if (this.F == -1) {
            int n2 = this.z;
            if (n2 > 0 && this.C == 0) {
                this.F = 0;
                return;
            }
            if (n2 == 0 && this.C > 0) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
    }

    public float q(int n2) {
        if (n2 == 0) {
            return this.o0;
        }
        if (n2 == 1) {
            return this.p0;
        }
        return -1.0f;
    }

    public void q0() {
        this.r = true;
    }

    public void q1(boolean bl, boolean bl2) {
        int n2;
        int n3;
        int n4;
        int n5;
        boolean bl3;
        boolean bl4;
        block15: {
            int n6;
            block14: {
                bl4 = bl & this.e.k();
                bl3 = bl2 & this.f.k();
                v.l l2 = this.e;
                n5 = l2.h.g;
                n n7 = this.f;
                n4 = n7.h.g;
                n3 = l2.i.g;
                n6 = n7.i.g;
                if (n3 - n5 < 0 || n6 - n4 < 0 || n5 == Integer.MIN_VALUE || n5 == Integer.MAX_VALUE || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n3 == Integer.MIN_VALUE || n3 == Integer.MAX_VALUE || n6 == Integer.MIN_VALUE) break block14;
                n2 = n6;
                if (n6 != Integer.MAX_VALUE) break block15;
            }
            n6 = 0;
            n4 = n5 = (n3 = 0);
            n2 = n5;
            n5 = n3;
            n3 = n6;
        }
        n3 -= n5;
        n2 -= n4;
        if (bl4) {
            this.f0 = n5;
        }
        if (bl3) {
            this.g0 = n4;
        }
        if (this.s0 == 8) {
            this.b0 = 0;
            this.c0 = 0;
            return;
        }
        if (bl4) {
            n5 = n3;
            if (this.Z[0] == u.e$b.g) {
                n4 = this.b0;
                n5 = n3;
                if (n3 < n4) {
                    n5 = n4;
                }
            }
            this.b0 = n5;
            n4 = this.m0;
            if (n5 < n4) {
                this.b0 = n4;
            }
        }
        if (bl3) {
            n5 = n2;
            if (this.Z[1] == u.e$b.g) {
                n4 = this.c0;
                n5 = n2;
                if (n2 < n4) {
                    n5 = n4;
                }
            }
            this.c0 = n5;
            n4 = this.n0;
            if (n5 < n4) {
                this.c0 = n4;
            }
        }
    }

    public int r() {
        return this.Y() + this.c0;
    }

    public void r0() {
        this.s = true;
    }

    public void r1(r.d d3, boolean bl) {
        int n2;
        int n3;
        int n4;
        int n5;
        block12: {
            block11: {
                v.l l2;
                int n6 = d3.y(this.O);
                n5 = d3.y(this.P);
                n4 = d3.y(this.Q);
                int n7 = d3.y(this.R);
                n3 = n6;
                n2 = n4;
                if (bl) {
                    l2 = this.e;
                    n3 = n6;
                    n2 = n4;
                    if (l2 != null) {
                        d3 = l2.h;
                        n3 = n6;
                        n2 = n4;
                        if (((v.f)d3).j) {
                            l2 = l2.i;
                            n3 = n6;
                            n2 = n4;
                            if (l2.j) {
                                n3 = ((v.f)d3).g;
                                n2 = l2.g;
                            }
                        }
                    }
                }
                n4 = n5;
                n6 = n7;
                if (bl) {
                    l2 = this.f;
                    n4 = n5;
                    n6 = n7;
                    if (l2 != null) {
                        d3 = l2.h;
                        n4 = n5;
                        n6 = n7;
                        if (((v.f)d3).j) {
                            l2 = l2.i;
                            n4 = n5;
                            n6 = n7;
                            if (l2.j) {
                                n4 = ((v.f)d3).g;
                                n6 = l2.g;
                            }
                        }
                    }
                }
                if (n2 - n3 < 0 || n6 - n4 < 0 || n3 == Integer.MIN_VALUE || n3 == Integer.MAX_VALUE || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n2 == Integer.MIN_VALUE || n2 == Integer.MAX_VALUE || n6 == Integer.MIN_VALUE) break block11;
                n5 = n3;
                n3 = n2;
                n2 = n6;
                if (n6 != Integer.MAX_VALUE) break block12;
            }
            n5 = 0;
            n2 = 0;
            n3 = n4 = 0;
        }
        this.K0(n5, n4, n3, n2);
    }

    public Object s() {
        return this.q0;
    }

    public boolean s0() {
        b[] bArray = this.Z;
        b b2 = bArray[0];
        b b3 = u.e$b.i;
        return b2 == b3 && bArray[1] == b3;
    }

    public String t() {
        return this.u0;
    }

    public void t0() {
        b b2;
        float f2;
        this.O.q();
        this.P.q();
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.a0 = null;
        this.I = Float.NaN;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0.0f;
        this.e0 = -1;
        this.f0 = 0;
        this.g0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = f2 = K0;
        this.p0 = f2;
        Object[] objectArray = this.Z;
        objectArray[0] = b2 = u.e$b.g;
        objectArray[1] = b2;
        this.q0 = null;
        this.r0 = 0;
        this.s0 = 0;
        this.v0 = null;
        this.w0 = false;
        this.x0 = false;
        this.z0 = 0;
        this.A0 = 0;
        this.B0 = false;
        this.C0 = false;
        objectArray = this.D0;
        objectArray[0] = (b)-1.0f;
        objectArray[1] = (b)-1.0f;
        this.t = -1;
        this.u = -1;
        objectArray = this.H;
        objectArray[0] = (b)Integer.MAX_VALUE;
        objectArray[1] = (b)Integer.MAX_VALUE;
        this.w = 0;
        this.x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.z = 0;
        this.C = 0;
        this.h = false;
        this.F = -1;
        this.G = 1.0f;
        this.y0 = false;
        objectArray = this.g;
        objectArray[0] = (b)true;
        objectArray[1] = (b)true;
        this.L = false;
        objectArray = this.Y;
        objectArray[0] = (b)false;
        objectArray[1] = (b)false;
        this.i = true;
        objectArray = this.y;
        objectArray[0] = (b)false;
        objectArray[1] = (b)false;
        this.l = -1;
        this.m = -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.v0;
        String string2 = "";
        if (string != null) {
            string = new StringBuilder();
            string.append("type: ");
            string.append(this.v0);
            string.append(" ");
            string = string.toString();
        } else {
            string = "";
        }
        stringBuilder.append(string);
        string = string2;
        if (this.u0 != null) {
            string = new StringBuilder();
            string.append("id: ");
            string.append(this.u0);
            string.append(" ");
            string = string.toString();
        }
        stringBuilder.append(string);
        stringBuilder.append("(");
        stringBuilder.append(this.f0);
        stringBuilder.append(", ");
        stringBuilder.append(this.g0);
        stringBuilder.append(") - (");
        stringBuilder.append(this.b0);
        stringBuilder.append(" x ");
        stringBuilder.append(this.c0);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b u(int n2) {
        if (n2 == 0) {
            return this.A();
        }
        if (n2 == 1) {
            return this.T();
        }
        return null;
    }

    public void u0() {
        e e2 = this.K();
        if (e2 == null || !(e2 instanceof f) || !((f)this.K()).N1()) {
            int n2 = this.X.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                ((d)this.X.get(i2)).q();
            }
        }
    }

    public float v() {
        return this.d0;
    }

    public void v0() {
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        int n2 = this.X.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((d)this.X.get(i2)).r();
        }
    }

    public int w() {
        return this.e0;
    }

    public void w0(c c3) {
        this.O.s(c3);
        this.P.s(c3);
        this.Q.s(c3);
        this.R.s(c3);
        this.S.s(c3);
        this.V.s(c3);
        this.T.s(c3);
        this.U.s(c3);
    }

    public int x() {
        if (this.s0 == 8) {
            return 0;
        }
        return this.c0;
    }

    public float y() {
        return this.o0;
    }

    public int z() {
        return this.z0;
    }

    public static final class b
    extends Enum {
        public static final /* enum */ b g = new b("FIXED", 0);
        public static final /* enum */ b h = new b("WRAP_CONTENT", 1);
        public static final /* enum */ b i = new b("MATCH_CONSTRAINT", 2);
        public static final /* enum */ b j = new b("MATCH_PARENT", 3);
        private static final b[] k = u.e$b.d();

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private b() {
            void var2_-1;
            void var1_-1;
        }

        private static /* synthetic */ b[] d() {
            return new b[]{g, h, i, j};
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])k.clone();
        }
    }
}

