/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package v;

import u.d;
import u.e;
import v.d;
import v.f;
import v.g;
import v.m;

public abstract class p
implements d {
    public int a;
    e b;
    m c;
    protected e.b d;
    g e = new g(this);
    public int f = 0;
    boolean g = false;
    public f h = new f(this);
    public f i = new f(this);
    protected b j = v.p$b.g;

    public p(e e2) {
        this.b = e2;
    }

    private void l(int n2, int n3) {
        block6: {
            block7: {
                block9: {
                    block8: {
                        p p2;
                        e e2;
                        block10: {
                            int n4 = this.a;
                            if (n4 == 0) break block6;
                            if (n4 == 1) break block7;
                            if (n4 == 2) break block8;
                            if (n4 != 3) break block9;
                            e2 = this.b;
                            p2 = e2.e;
                            Object object = p2.d;
                            e.b b2 = e.b.i;
                            if (object != b2 || p2.a != 3) break block10;
                            object = e2.f;
                            if (((p)object).d == b2 && ((p)object).a == 3) break block9;
                        }
                        if (n2 == 0) {
                            p2 = e2.f;
                        }
                        if (p2.e.j) {
                            float f2 = e2.v();
                            n2 = n2 == 1 ? (int)((float)p2.e.g / f2 + 0.5f) : (int)(f2 * (float)p2.e.g + 0.5f);
                            this.e.d(n2);
                            return;
                        }
                        break block9;
                    }
                    Object object = this.b.K();
                    if (object != null) {
                        object = n2 == 0 ? ((e)object).e : ((e)object).f;
                        object = ((p)object).e;
                        if (((f)object).j) {
                            float f3 = n2 == 0 ? this.b.B : this.b.E;
                            n3 = (int)((float)((f)object).g * f3 + 0.5f);
                            this.e.d(this.g(n3, n2));
                        }
                    }
                }
                return;
            }
            n2 = this.g(this.e.m, n2);
            this.e.d(Math.min((int)n2, (int)n3));
            return;
        }
        this.e.d(this.g(n3, n2));
    }

    @Override
    public abstract void a(d var1);

    protected final void b(f f2, f f3, int n2) {
        f2.l.add((Object)f3);
        f2.f = n2;
        f3.k.add((Object)f2);
    }

    protected final void c(f f2, f f3, int n2, g g2) {
        f2.l.add((Object)f3);
        f2.l.add((Object)this.e);
        f2.h = n2;
        f2.i = g2;
        f3.k.add((Object)f2);
        g2.k.add((Object)f2);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int n2, int n3) {
        if (n3 == 0) {
            e e2 = this.b;
            int n4 = e2.A;
            n3 = Math.max((int)e2.z, (int)n2);
            if (n4 > 0) {
                n3 = Math.min((int)n4, (int)n2);
            }
            if (n3 != n2) {
                return n3;
            }
        } else {
            e e3 = this.b;
            int n5 = e3.D;
            n3 = Math.max((int)e3.C, (int)n2);
            if (n5 > 0) {
                n3 = Math.min((int)n5, (int)n2);
            }
            if (n3 != n2) {
                return n3;
            }
        }
        return n2;
    }

    protected final f h(u.d object) {
        Object object2 = ((u.d)object).f;
        if (object2 == null) {
            return null;
        }
        object = object2.d;
        object2 = object2.e;
        int n2 = v.p$a.a[object2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            return null;
                        }
                        return ((e)object).f.i;
                    }
                    return ((e)object).f.k;
                }
                return ((e)object).f.h;
            }
            return ((e)object).e.i;
        }
        return ((e)object).e.h;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected final f i(u.d object, int n2) {
        u.d d2 = ((u.d)object).f;
        if (d2 == null) {
            return null;
        }
        object = d2.d;
        object = n2 == 0 ? ((e)object).e : ((e)object).f;
        d.a a2 = d2.e;
        n2 = v.p$a.a[a2.ordinal()];
        if (n2 == 1) return ((p)object).h;
        if (n2 == 2) return ((p)object).i;
        if (n2 == 3) return ((p)object).h;
        if (n2 == 5) return ((p)object).i;
        return null;
    }

    public long j() {
        g g2 = this.e;
        if (g2.j) {
            return g2.g;
        }
        return 0L;
    }

    public boolean k() {
        return this.g;
    }

    abstract boolean m();

    protected void n(d d2, u.d object, u.d d3, int n2) {
        d2 = this.h((u.d)object);
        f f2 = this.h(d3);
        if (((f)d2).j && f2.j) {
            int n3 = ((f)d2).g + ((u.d)object).f();
            int n4 = f2.g - d3.f();
            int n5 = n4 - n3;
            if (!this.e.j && this.d == e.b.i) {
                this.l(n2, n5);
            }
            object = this.e;
            if (((f)object).j) {
                if (((f)object).g == n5) {
                    this.h.d(n3);
                    this.i.d(n4);
                    return;
                }
                float f3 = n2 == 0 ? this.b.y() : this.b.R();
                n2 = n3;
                if (d2 == f2) {
                    n2 = ((f)d2).g;
                    n4 = f2.g;
                    f3 = 0.5f;
                }
                n3 = this.e.g;
                this.h.d((int)((float)n2 + 0.5f + (float)(n4 - n2 - n3) * f3));
                this.i.d(this.h.g + this.e.g);
            }
        }
    }

    protected void o(d d2) {
    }

    protected void p(d d2) {
    }

    static final class b
    extends Enum {
        public static final /* enum */ b g = new b("NONE", 0);
        public static final /* enum */ b h = new b("START", 1);
        public static final /* enum */ b i = new b("END", 2);
        public static final /* enum */ b j = new b("CENTER", 3);
        private static final b[] k = v.p$b.d();

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

