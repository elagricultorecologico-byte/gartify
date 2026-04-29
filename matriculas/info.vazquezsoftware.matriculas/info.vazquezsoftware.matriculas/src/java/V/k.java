/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Iterator
 */
package v;

import java.util.Iterator;
import u.a;
import u.e;
import u.j;
import v.d;
import v.f;
import v.p;

class k
extends p {
    k(e e2) {
        super(e2);
    }

    private void q(f f2) {
        this.h.k.add((Object)f2);
        f2.l.add((Object)this.h);
    }

    @Override
    public void a(d object) {
        object = (a)this.b;
        int n2 = ((a)object).w1();
        Iterator iterator = this.h.l.iterator();
        int n3 = 0;
        int n4 = -1;
        while (iterator.hasNext()) {
            int n5;
            int n6;
            block6: {
                block5: {
                    n6 = ((f)iterator.next()).g;
                    if (n4 == -1) break block5;
                    n5 = n4;
                    if (n6 >= n4) break block6;
                }
                n5 = n6;
            }
            n4 = n5;
            if (n3 >= n6) continue;
            n3 = n6;
            n4 = n5;
        }
        if (n2 != 0 && n2 != 2) {
            this.h.d(n3 + ((a)object).x1());
            return;
        }
        this.h.d(n4 + ((a)object).x1());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    void d() {
        int n2;
        e e2 = this.b;
        if (!(e2 instanceof a)) return;
        this.h.b = true;
        e2 = (a)e2;
        int n3 = ((a)e2).w1();
        boolean bl = ((a)e2).v1();
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        if (n3 != 0) {
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3) return;
                    this.h.e = f.a.m;
                    for (n2 = n6; n2 < ((j)e2).M0; ++n2) {
                        Object object = ((j)e2).L0[n2];
                        if (!bl && ((e)object).V() == 8) continue;
                        object = ((e)object).f.i;
                        ((f)object).k.add((Object)this.h);
                        this.h.l.add(object);
                    }
                    this.q(this.b.f.h);
                    this.q(this.b.f.i);
                    return;
                }
                this.h.e = f.a.l;
                for (n2 = n4; n2 < ((j)e2).M0; ++n2) {
                    Object object = ((j)e2).L0[n2];
                    if (!bl && ((e)object).V() == 8) continue;
                    object = ((e)object).f.h;
                    ((f)object).k.add((Object)this.h);
                    this.h.l.add(object);
                }
                this.q(this.b.f.h);
                this.q(this.b.f.i);
                return;
            }
            this.h.e = f.a.k;
            for (n2 = 0; n2 < ((j)e2).M0; ++n2) {
                Object object = ((j)e2).L0[n2];
                if (!bl && ((e)object).V() == 8) continue;
                object = ((e)object).e.i;
                ((f)object).k.add((Object)this.h);
                this.h.l.add(object);
            }
            this.q(this.b.e.h);
            this.q(this.b.e.i);
            return;
        }
        this.h.e = f.a.j;
        for (n2 = n5; n2 < ((j)e2).M0; ++n2) {
            Object object = ((j)e2).L0[n2];
            if (!bl && ((e)object).V() == 8) continue;
            object = ((e)object).e.h;
            ((f)object).k.add((Object)this.h);
            this.h.l.add(object);
        }
        this.q(this.b.e.h);
        this.q(this.b.e.i);
    }

    @Override
    public void e() {
        e e2 = this.b;
        if (e2 instanceof a) {
            int n2 = ((a)e2).w1();
            if (n2 != 0 && n2 != 1) {
                this.b.o1(this.h.g);
                return;
            }
            this.b.n1(this.h.g);
        }
    }

    @Override
    void f() {
        this.c = null;
        this.h.c();
    }

    @Override
    boolean m() {
        return false;
    }
}

