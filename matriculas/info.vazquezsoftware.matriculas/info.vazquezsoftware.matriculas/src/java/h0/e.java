/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  J0.a
 *  J0.c
 *  J0.d
 *  N0.d
 *  N0.g
 *  N0.i
 *  O0.s
 *  O0.w
 *  P0.N
 *  P0.V
 *  P0.d
 *  P0.g
 *  P0.h
 *  P0.i
 *  P0.j
 *  R0.c
 *  R0.d
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Override
 */
package H0;

import H0.k;
import H0.t;
import H0.u;
import H0.v;
import I0.j;
import I0.l;
import J0.a;
import N0.i;
import O0.s;
import O0.w;
import P0.N;
import P0.V;
import P0.d;
import P0.g;
import P0.h;
import R0.c;
import android.content.Context;

final class e
extends u {
    private G2.a g;
    private G2.a h;
    private G2.a i;
    private G2.a j;
    private G2.a k;
    private G2.a l;
    private G2.a m;
    private G2.a n;
    private G2.a o;
    private G2.a p;
    private G2.a q;
    private G2.a r;
    private G2.a s;

    private e(Context context) {
        this.j(context);
    }

    public static u.a i() {
        return new b();
    }

    private void j(Context object) {
        this.g = a.a((G2.a)H0.k.a());
        object = J0.c.a((Object)object);
        this.h = object;
        object = I0.j.a((G2.a)object, (G2.a)c.a(), (G2.a)R0.d.a());
        this.i = object;
        this.j = a.a((G2.a)I0.l.a(this.h, (G2.a)object));
        this.k = V.a((G2.a)this.h, (G2.a)P0.g.a(), (G2.a)P0.i.a());
        this.l = a.a((G2.a)P0.h.a((G2.a)this.h));
        this.m = a.a((G2.a)N.a((G2.a)c.a(), (G2.a)R0.d.a(), (G2.a)P0.j.a(), (G2.a)this.k, (G2.a)this.l));
        object = N0.g.b((G2.a)c.a());
        this.n = object;
        Object object2 = N0.i.a((G2.a)this.h, (G2.a)this.m, (G2.a)object, (G2.a)R0.d.a());
        this.o = object2;
        G2.a a2 = this.g;
        object = this.j;
        G2.a a3 = this.m;
        this.p = N0.d.a((G2.a)a2, (G2.a)object, (G2.a)object2, (G2.a)a3, (G2.a)a3);
        a3 = this.h;
        object = this.j;
        object2 = this.m;
        this.q = O0.s.a((G2.a)a3, (G2.a)object, (G2.a)object2, (G2.a)this.o, (G2.a)this.g, (G2.a)object2, (G2.a)c.a(), (G2.a)R0.d.a(), (G2.a)this.m);
        a3 = this.g;
        object = this.m;
        this.r = w.a((G2.a)a3, (G2.a)object, (G2.a)this.o, (G2.a)object);
        this.s = a.a((G2.a)v.a((G2.a)c.a(), (G2.a)R0.d.a(), this.p, this.q, this.r));
    }

    @Override
    d a() {
        return (d)this.m.get();
    }

    @Override
    t f() {
        return (t)this.s.get();
    }

    private static final class b
    implements u.a {
        private Context a;

        private b() {
        }

        @Override
        public u a() {
            J0.d.a((Object)this.a, Context.class);
            return new e(this.a);
        }

        public b c(Context context) {
            this.a = (Context)J0.d.b((Object)context);
            return this;
        }
    }
}

