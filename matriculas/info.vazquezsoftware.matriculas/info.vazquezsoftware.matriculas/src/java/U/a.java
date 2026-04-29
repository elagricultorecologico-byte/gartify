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
package u;

import r.i;
import u.d;
import u.e;
import u.j;

public class a
extends j {
    private int N0 = 0;
    private boolean O0 = true;
    private int P0 = 0;
    boolean Q0 = false;

    public void A1(boolean bl) {
        this.O0 = bl;
    }

    public void B1(int n2) {
        this.N0 = n2;
    }

    public void C1(int n2) {
        this.P0 = n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void g(r.d d3, boolean bl) {
        int n2;
        int n3;
        Object object;
        d d4;
        int n4;
        block14: {
            d[] dArray;
            d[] dArray2 = this.W;
            dArray2[0] = this.O;
            dArray2[2] = this.P;
            dArray2[1] = this.Q;
            dArray2[3] = this.R;
            for (n4 = 0; n4 < (dArray = this.W).length; ++n4) {
                d d5 = dArray[n4];
                d5.i = d3.q(d5);
            }
            n4 = this.N0;
            if (n4 < 0 || n4 >= 4) return;
            d4 = dArray[n4];
            if (!this.Q0) {
                this.u1();
            }
            if (this.Q0) {
                this.Q0 = false;
                n4 = this.N0;
                if (n4 != 0 && n4 != 1) {
                    if (n4 != 2 && n4 != 3) return;
                    d3.f(this.P.i, this.g0);
                    d3.f(this.R.i, this.g0);
                    return;
                } else {
                    d3.f(this.O.i, this.f0);
                    d3.f(this.Q.i, this.f0);
                    return;
                }
            }
            for (n4 = 0; n4 < this.M0; ++n4) {
                object = this.L0[n4];
                if (!this.O0 && !((e)object).h() || ((n3 = this.N0) != 0 && n3 != 1 || ((e)object).A() != e.b.i || ((e)object).O.f == null || ((e)object).Q.f == null) && ((n3 = this.N0) != 2 && n3 != 3 || ((e)object).T() != e.b.i || ((e)object).P.f == null || ((e)object).R.f == null)) continue;
                bl = true;
                break block14;
            }
            bl = false;
        }
        n4 = !this.O.l() && !this.Q.l() ? 0 : 1;
        n3 = !this.P.l() && !this.R.l() ? 0 : 1;
        n4 = !bl && ((n2 = this.N0) == 0 && n4 != 0 || n2 == 2 && n3 != 0 || n2 == 1 && n4 != 0 || n2 == 3 && n3 != 0) ? 1 : 0;
        n4 = n4 == 0 ? 4 : 5;
        for (n3 = 0; n3 < this.M0; ++n3) {
            e e2 = this.L0[n3];
            if (!this.O0 && !e2.h()) continue;
            object = d3.q(e2.W[this.N0]);
            d[] dArray = e2.W;
            int n5 = this.N0;
            d d6 = dArray[n5];
            d6.i = object;
            d d7 = d6.f;
            n2 = d7 != null && d7.d == this ? d6.g : 0;
            if (n5 != 0 && n5 != 2) {
                d3.g(d4.i, (i)object, this.P0 + n2, bl);
            } else {
                d3.i(d4.i, (i)object, this.P0 - n2, bl);
            }
            d3.e(d4.i, (i)object, this.P0 + n2, n4);
        }
        n4 = this.N0;
        if (n4 == 0) {
            d3.e(this.Q.i, this.O.i, 0, 8);
            d3.e(this.O.i, this.a0.Q.i, 0, 4);
            d3.e(this.O.i, this.a0.O.i, 0, 0);
            return;
        }
        if (n4 == 1) {
            d3.e(this.O.i, this.Q.i, 0, 8);
            d3.e(this.O.i, this.a0.O.i, 0, 4);
            d3.e(this.O.i, this.a0.Q.i, 0, 0);
            return;
        }
        if (n4 == 2) {
            d3.e(this.R.i, this.P.i, 0, 8);
            d3.e(this.P.i, this.a0.R.i, 0, 4);
            d3.e(this.P.i, this.a0.P.i, 0, 0);
            return;
        }
        if (n4 != 3) return;
        d3.e(this.P.i, this.R.i, 0, 8);
        d3.e(this.P.i, this.a0.P.i, 0, 4);
        d3.e(this.P.i, this.a0.R.i, 0, 0);
    }

    @Override
    public boolean h() {
        return true;
    }

    @Override
    public boolean n0() {
        return this.Q0;
    }

    @Override
    public boolean o0() {
        return this.Q0;
    }

    @Override
    public String toString() {
        Object object;
        Object object2 = new StringBuilder();
        object2.append("[Barrier] ");
        object2.append(this.t());
        object2.append(" {");
        object2 = object2.toString();
        for (int i2 = 0; i2 < this.M0; ++i2) {
            e e2 = this.L0[i2];
            object = object2;
            if (i2 > 0) {
                object = new StringBuilder();
                object.append((String)object2);
                object.append(", ");
                object = object.toString();
            }
            object2 = new StringBuilder();
            object2.append((String)object);
            object2.append(e2.t());
            object2 = object2.toString();
        }
        object = new StringBuilder();
        object.append((String)object2);
        object.append("}");
        return object.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean u1() {
        int n2;
        e e2;
        int n3;
        int n4;
        int n5 = 0;
        int n6 = 1;
        for (n4 = 0; n4 < (n3 = this.M0); ++n4) {
            block26: {
                block27: {
                    block28: {
                        block25: {
                            e2 = this.L0[n4];
                            if (this.O0 || e2.h()) break block25;
                            n3 = n6;
                            break block26;
                        }
                        n3 = this.N0;
                        if ((n3 == 0 || n3 == 1) && !e2.n0()) break block27;
                        n2 = this.N0;
                        if (n2 == 2) break block28;
                        n3 = n6;
                        if (n2 != 3) break block26;
                    }
                    n3 = n6;
                    if (e2.o0()) break block26;
                }
                n3 = 0;
            }
            n6 = n3;
        }
        if (n6 != 0 && n3 > 0) {
            n4 = 0;
            n3 = 0;
        } else {
            return false;
        }
        while (n5 < this.M0) {
            e2 = this.L0[n5];
            if (this.O0 || e2.h()) {
                int n7;
                n2 = n4;
                n6 = n3;
                if (n3 == 0) {
                    n6 = this.N0;
                    if (n6 == 0) {
                        n4 = e2.o(d.a.h).e();
                    } else if (n6 == 1) {
                        n4 = e2.o(d.a.j).e();
                    } else if (n6 == 2) {
                        n4 = e2.o(d.a.i).e();
                    } else if (n6 == 3) {
                        n4 = e2.o(d.a.k).e();
                    }
                    n6 = 1;
                    n2 = n4;
                }
                if ((n7 = this.N0) == 0) {
                    n4 = Math.min((int)n2, (int)e2.o(d.a.h).e());
                    n3 = n6;
                } else if (n7 == 1) {
                    n4 = Math.max((int)n2, (int)e2.o(d.a.j).e());
                    n3 = n6;
                } else if (n7 == 2) {
                    n4 = Math.min((int)n2, (int)e2.o(d.a.i).e());
                    n3 = n6;
                } else {
                    n4 = n2;
                    n3 = n6;
                    if (n7 == 3) {
                        n4 = Math.max((int)n2, (int)e2.o(d.a.k).e());
                        n3 = n6;
                    }
                }
            }
            ++n5;
        }
        n6 = n4 + this.P0;
        n4 = this.N0;
        if (n4 != 0 && n4 != 1) {
            this.J0(n6, n6);
        } else {
            this.G0(n6, n6);
        }
        this.Q0 = true;
        return true;
    }

    public boolean v1() {
        return this.O0;
    }

    public int w1() {
        return this.N0;
    }

    public int x1() {
        return this.P0;
    }

    public int y1() {
        int n2 = this.N0;
        if (n2 != 0 && n2 != 1) {
            if (n2 != 2 && n2 != 3) {
                return -1;
            }
            return 1;
        }
        return 0;
    }

    protected void z1() {
        for (int i2 = 0; i2 < this.M0; ++i2) {
            e e2 = this.L0[i2];
            if (!this.O0 && !e2.h()) continue;
            int n2 = this.N0;
            if (n2 != 0 && n2 != 1) {
                if (n2 != 2 && n2 != 3) continue;
                e2.T0(1, true);
                continue;
            }
            e2.T0(0, true);
        }
    }
}

