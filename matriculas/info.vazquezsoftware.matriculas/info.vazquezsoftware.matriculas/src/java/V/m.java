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
import u.e;
import v.c;
import v.d;
import v.f;
import v.k;
import v.l;
import v.n;
import v.p;

class m {
    public static int h;
    public int a = 0;
    public boolean b = false;
    p c = null;
    p d = null;
    ArrayList e = new ArrayList();
    int f;
    int g;

    m(p p2, int n2) {
        int n3;
        this.f = n3 = h;
        h = n3 + 1;
        this.c = p2;
        this.d = p2;
        this.g = n2;
    }

    private long c(f f2, long l2) {
        long l3;
        p p2 = f2.d;
        if (p2 instanceof k) {
            return l2;
        }
        int n2 = f2.k.size();
        long l4 = l2;
        for (int i2 = 0; i2 < n2; ++i2) {
            d d2 = (d)f2.k.get(i2);
            l3 = l4;
            if (d2 instanceof f) {
                d2 = (f)d2;
                l3 = ((f)d2).d == p2 ? l4 : Math.min((long)l4, (long)this.c((f)d2, (long)((f)d2).f + l2));
            }
            l4 = l3;
        }
        if (f2 == p2.i) {
            l3 = p2.j();
            f2 = p2.h;
            return Math.min((long)Math.min((long)l4, (long)this.c(f2, l2 -= l3)), (long)(l2 - (long)p2.h.f));
        }
        return l4;
    }

    private long d(f f2, long l2) {
        long l3;
        p p2 = f2.d;
        if (p2 instanceof k) {
            return l2;
        }
        int n2 = f2.k.size();
        long l4 = l2;
        for (int i2 = 0; i2 < n2; ++i2) {
            d d2 = (d)f2.k.get(i2);
            l3 = l4;
            if (d2 instanceof f) {
                d2 = (f)d2;
                l3 = ((f)d2).d == p2 ? l4 : Math.max((long)l4, (long)this.d((f)d2, (long)((f)d2).f + l2));
            }
            l4 = l3;
        }
        if (f2 == p2.h) {
            l3 = p2.j();
            f2 = p2.i;
            return Math.max((long)Math.max((long)l4, (long)this.d(f2, l2 += l3)), (long)(l2 - (long)p2.i.f));
        }
        return l4;
    }

    public void a(p p2) {
        this.e.add((Object)p2);
        this.d = p2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public long b(u.f object, int n2) {
        long l2;
        void var18_7;
        p p2 = this.c;
        boolean bl = p2 instanceof c;
        long l3 = 0L;
        if (bl ? ((c)p2).f != n2 : (n2 == 0 ? !(p2 instanceof l) : !(p2 instanceof n))) {
            return 0L;
        }
        if (n2 == 0) {
            l l4 = ((e)object).e;
        } else {
            n n3 = ((e)object).f;
        }
        f f2 = var18_7.h;
        object = n2 == 0 ? ((e)object).e : ((e)object).f;
        object = ((p)object).i;
        bl = p2.h.l.contains((Object)f2);
        boolean bl2 = this.c.i.l.contains(object);
        long l5 = this.c.j();
        if (bl && bl2) {
            float f3;
            l2 = this.d(this.c.h, 0L);
            long l6 = this.c(this.c.i, 0L);
            long l7 = l2 - l5;
            object = this.c;
            int n4 = ((p)object).i.f;
            l2 = l7;
            if (l7 >= (long)(-n4)) {
                l2 = l7 + (long)n4;
            }
            l7 = -l6;
            n4 = ((p)object).h.f;
            l7 = l6 = l7 - l5 - (long)n4;
            if (l6 >= (long)n4) {
                l7 = l6 - (long)n4;
            }
            if ((f3 = ((p)object).b.q(n2)) > 0.0f) {
                l3 = (long)((float)l7 / f3 + (float)l2 / (1.0f - f3));
            }
            float f4 = l3;
            l7 = (long)(f4 * f3 + 0.5f);
            l2 = (long)(f4 * (1.0f - f3) + 0.5f);
            object = this.c;
            l2 = (long)((p)object).h.f + (l7 + l5 + l2);
            n2 = ((p)object).i.f;
            return l2 - (long)n2;
        }
        if (bl) {
            object = this.c.h;
            return Math.max((long)this.d((f)object, ((f)object).f), (long)((long)this.c.h.f + l5));
        }
        if (bl2) {
            object = this.c.i;
            long l8 = this.c((f)object, ((f)object).f);
            long l9 = -this.c.i.f;
            return Math.max((long)(-l8), (long)(l9 + l5));
        }
        object = this.c;
        l2 = (long)((p)object).h.f + ((p)object).j();
        n2 = this.c.i.f;
        return l2 - (long)n2;
    }
}

