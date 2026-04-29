/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package u;

import r.i;
import u.d;
import u.e;
import u.f;

public class h
extends e {
    protected float L0 = -1.0f;
    protected int M0 = -1;
    protected int N0 = -1;
    protected boolean O0 = true;
    private d P0 = this.P;
    private int Q0 = 0;
    private int R0 = 0;
    private boolean S0;

    public h() {
        this.X.clear();
        this.X.add((Object)this.P0);
        int n2 = this.W.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.W[i2] = this.P0;
        }
    }

    public void A1(float f2) {
        if (f2 > -1.0f) {
            this.L0 = f2;
            this.M0 = -1;
            this.N0 = -1;
        }
    }

    public void B1(int n2) {
        if (this.Q0 != n2) {
            this.Q0 = n2;
            this.X.clear();
            this.P0 = this.Q0 == 1 ? this.O : this.P;
            this.X.add((Object)this.P0);
            int n3 = this.W.length;
            for (n2 = 0; n2 < n3; ++n2) {
                this.W[n2] = this.P0;
            }
        }
    }

    @Override
    public void g(r.d d3, boolean bl) {
        Object object = (f)this.K();
        if (object != null) {
            d d4 = ((e)object).o(d.a.h);
            Object object2 = ((e)object).o(d.a.j);
            e e2 = this.a0;
            boolean bl2 = true;
            boolean bl3 = e2 != null && e2.Z[0] == e.b.h;
            if (this.Q0 == 0) {
                d4 = ((e)object).o(d.a.i);
                object2 = ((e)object).o(d.a.k);
                object = this.a0;
                bl3 = object != null && ((e)object).Z[1] == e.b.h ? bl2 : false;
            }
            if (this.S0 && this.P0.n()) {
                object = d3.q(this.P0);
                d3.f((i)object, this.P0.e());
                if (this.M0 != -1) {
                    if (bl3) {
                        d3.h(d3.q(object2), (i)object, 0, 5);
                    }
                } else if (this.N0 != -1 && bl3) {
                    object2 = d3.q(object2);
                    d3.h((i)object, d3.q(d4), 0, 5);
                    d3.h((i)object2, (i)object, 0, 5);
                }
                this.S0 = false;
                return;
            }
            if (this.M0 != -1) {
                object = d3.q(this.P0);
                d3.e((i)object, d3.q(d4), this.M0, 8);
                if (bl3) {
                    d3.h(d3.q(object2), (i)object, 0, 5);
                    return;
                }
            } else if (this.N0 != -1) {
                object = d3.q(this.P0);
                object2 = d3.q(object2);
                d3.e((i)object, (i)object2, -this.N0, 8);
                if (bl3) {
                    d3.h((i)object, d3.q(d4), 0, 5);
                    d3.h((i)object2, (i)object, 0, 5);
                    return;
                }
            } else if (this.L0 != -1.0f) {
                d3.d(r.d.s(d3, d3.q(this.P0), d3.q(object2), this.L0));
            }
        }
    }

    @Override
    public boolean h() {
        return true;
    }

    @Override
    public boolean n0() {
        return this.S0;
    }

    @Override
    public d o(d.a a2) {
        int n2 = u.h$a.a[a2.ordinal()];
        if (n2 != 1 && n2 != 2 ? (n2 == 3 || n2 == 4) && this.Q0 == 0 : this.Q0 == 1) {
            return this.P0;
        }
        return null;
    }

    @Override
    public boolean o0() {
        return this.S0;
    }

    @Override
    public void r1(r.d d3, boolean bl) {
        if (this.K() == null) {
            return;
        }
        int n2 = d3.y(this.P0);
        if (this.Q0 == 1) {
            this.n1(n2);
            this.o1(0);
            this.M0(this.K().x());
            this.l1(0);
            return;
        }
        this.n1(0);
        this.o1(n2);
        this.l1(this.K().W());
        this.M0(0);
    }

    public d s1() {
        return this.P0;
    }

    public int t1() {
        return this.Q0;
    }

    public int u1() {
        return this.M0;
    }

    public int v1() {
        return this.N0;
    }

    public float w1() {
        return this.L0;
    }

    public void x1(int n2) {
        this.P0.t(n2);
        this.S0 = true;
    }

    public void y1(int n2) {
        if (n2 > -1) {
            this.L0 = -1.0f;
            this.M0 = n2;
            this.N0 = -1;
        }
    }

    public void z1(int n2) {
        if (n2 > -1) {
            this.L0 = -1.0f;
            this.M0 = -1;
            this.N0 = n2;
        }
    }
}

