/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package u;

import java.util.ArrayList;
import u.e;

public class c {
    protected e a;
    protected e b;
    protected e c;
    protected e d;
    protected e e;
    protected e f;
    protected e g;
    protected ArrayList h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    int l;
    int m;
    int n;
    boolean o;
    private int p;
    private boolean q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    private boolean v;

    public c(e e2, int n2, boolean bl) {
        this.a = e2;
        this.p = n2;
        this.q = bl;
    }

    private void b() {
        int n2 = this.p * 2;
        Object object = this.a;
        boolean bl = true;
        this.o = true;
        Object object2 = object;
        boolean bl2 = false;
        while (!bl2) {
            Object object3;
            ++this.i;
            Object object4 = ((e)object).F0;
            int n3 = this.p;
            Object object5 = null;
            object4[n3] = null;
            ((e)object).E0[n3] = null;
            if (((e)object).V() != 8) {
                int n4;
                ++this.l;
                object3 = ((e)object).u(this.p);
                if (object3 != (object4 = e.b.i)) {
                    this.m += ((e)object).E(this.p);
                }
                this.m = n4 = this.m + ((e)object).W[n2].f();
                object3 = ((e)object).W;
                n3 = n2 + 1;
                this.m = n4 + object3[n3].f();
                this.n = n4 = this.n + ((e)object).W[n2].f();
                this.n = n4 + ((e)object).W[n3].f();
                if (this.b == null) {
                    this.b = object;
                }
                this.d = object;
                object3 = ((e)object).Z;
                n4 = this.p;
                if (object3[n4] == object4) {
                    n3 = ((e)object).y[n4];
                    if (n3 == 0 || n3 == 3 || n3 == 2) {
                        ++this.j;
                        float f2 = ((e)object).D0[n4];
                        if (f2 > 0.0f) {
                            this.k += f2;
                        }
                        if (u.c.c((e)object, n4)) {
                            if (f2 < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList();
                            }
                            this.h.add(object);
                        }
                        if (this.f == null) {
                            this.f = object;
                        }
                        if ((object4 = this.g) != null) {
                            object4.E0[this.p] = object;
                        }
                        this.g = object;
                    }
                    if (this.p == 0) {
                        if (((e)object).w != 0) {
                            this.o = false;
                        } else if (((e)object).z != 0 || ((e)object).A != 0) {
                            this.o = false;
                        }
                    } else if (((e)object).x != 0) {
                        this.o = false;
                    } else if (((e)object).C != 0 || ((e)object).D != 0) {
                        this.o = false;
                    }
                    if (((e)object).d0 != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (object2 != object) {
                ((e)object2).F0[this.p] = object;
            }
            object4 = ((e)object).W[n2 + 1].f;
            object2 = object5;
            if (object4 != null) {
                object4 = object4.d;
                object3 = object4.W[n2].f;
                object2 = object5;
                if (object3 != null) {
                    object2 = object3.d != object ? object5 : object4;
                }
            }
            if (object2 == null) {
                object2 = object;
                bl2 = true;
            }
            object5 = object;
            object = object2;
            object2 = object5;
        }
        object2 = this.b;
        if (object2 != null) {
            this.m -= ((e)object2).W[n2].f();
        }
        if ((object2 = this.d) != null) {
            this.m -= ((e)object2).W[n2 + 1].f();
        }
        this.c = object;
        this.e = this.p == 0 && this.q ? object : this.a;
        if (!this.s || !this.r) {
            bl = false;
        }
        this.t = bl;
    }

    private static boolean c(e e2, int n2) {
        return e2.V() != 8 && e2.Z[n2] == e.b.i && ((n2 = e2.y[n2]) == 0 || n2 == 3);
    }

    public void a() {
        if (!this.v) {
            this.b();
        }
        this.v = true;
    }
}

