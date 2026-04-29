/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package v;

import u.e;
import u.h;
import v.d;
import v.f;
import v.p;

class j
extends p {
    j(e e2) {
        super(e2);
        e2.e.f();
        e2.f.f();
        this.f = ((h)e2).t1();
    }

    private void q(f f2) {
        this.h.k.add((Object)f2);
        f2.l.add((Object)this.h);
    }

    @Override
    public void a(d d2) {
        d2 = this.h;
        if (!((f)d2).c || ((f)d2).j) {
            return;
        }
        d2 = (f)((f)d2).l.get(0);
        h h2 = (h)this.b;
        int n2 = (int)((float)((f)d2).g * h2.w1() + 0.5f);
        this.h.d(n2);
    }

    @Override
    void d() {
        Object object = (h)this.b;
        int n2 = ((h)object).u1();
        int n3 = ((h)object).v1();
        ((h)object).w1();
        if (((h)object).t1() == 1) {
            if (n2 != -1) {
                this.h.l.add((Object)this.b.a0.e.h);
                this.b.a0.e.h.k.add((Object)this.h);
                this.h.f = n2;
            } else if (n3 != -1) {
                this.h.l.add((Object)this.b.a0.e.i);
                this.b.a0.e.i.k.add((Object)this.h);
                this.h.f = -n3;
            } else {
                object = this.h;
                ((f)object).b = true;
                ((f)object).l.add((Object)this.b.a0.e.i);
                this.b.a0.e.i.k.add((Object)this.h);
            }
            this.q(this.b.e.h);
            this.q(this.b.e.i);
            return;
        }
        if (n2 != -1) {
            this.h.l.add((Object)this.b.a0.f.h);
            this.b.a0.f.h.k.add((Object)this.h);
            this.h.f = n2;
        } else if (n3 != -1) {
            this.h.l.add((Object)this.b.a0.f.i);
            this.b.a0.f.i.k.add((Object)this.h);
            this.h.f = -n3;
        } else {
            object = this.h;
            ((f)object).b = true;
            ((f)object).l.add((Object)this.b.a0.f.i);
            this.b.a0.f.i.k.add((Object)this.h);
        }
        this.q(this.b.f.h);
        this.q(this.b.f.i);
    }

    @Override
    public void e() {
        if (((h)this.b).t1() == 1) {
            this.b.n1(this.h.g);
            return;
        }
        this.b.o1(this.h.g);
    }

    @Override
    void f() {
        this.h.c();
    }

    @Override
    boolean m() {
        return false;
    }
}

