/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayList
 */
package G3;

import F3.a;
import F3.f;
import F3.g;
import G3.b;
import G3.f;
import G3.h;
import G3.i;
import G3.l;
import G3.m;
import java.util.ArrayList;

abstract class c
extends Enum {
    public static final /* enum */ c A;
    public static final /* enum */ c B;
    public static final /* enum */ c C;
    private static final String D;
    private static final c[] E;
    public static final /* enum */ c g;
    public static final /* enum */ c h;
    public static final /* enum */ c i;
    public static final /* enum */ c j;
    public static final /* enum */ c k;
    public static final /* enum */ c l;
    public static final /* enum */ c m;
    public static final /* enum */ c n;
    public static final /* enum */ c o;
    public static final /* enum */ c p;
    public static final /* enum */ c q;
    public static final /* enum */ c r;
    public static final /* enum */ c s;
    public static final /* enum */ c t;
    public static final /* enum */ c u;
    public static final /* enum */ c v;
    public static final /* enum */ c w;
    public static final /* enum */ c x;
    public static final /* enum */ c y;
    public static final /* enum */ c z;

    static {
        c c2;
        c c3;
        c c4;
        c c5;
        c c6;
        c c7;
        c c8;
        c c9;
        c c10;
        c c11;
        c c12;
        c c13;
        c c14;
        c c15;
        c c16;
        c c17;
        c c18;
        c c19;
        c c20;
        c c21;
        c c22;
        c c23;
        c c24;
        g = c24 = new c(){

            @Override
            boolean n(i i2, b b2) {
                block7: {
                    block6: {
                        block5: {
                            if (c.l(i2)) {
                                return true;
                            }
                            if (!i2.h()) break block5;
                            b2.Q(i2.b());
                            break block6;
                        }
                        if (!i2.i()) break block7;
                        i2 = i2.c();
                        g g2 = new g(b2.h.c(((i.e)i2).p()), ((i.e)i2).r(), ((i.e)i2).s());
                        g2.X(((i.e)i2).q());
                        b2.y().V(g2);
                        if (((i.e)i2).t()) {
                            b2.y().V0(f.b.h);
                        }
                        b2.G0(h);
                    }
                    return true;
                }
                b2.G0(h);
                return b2.f(i2);
            }
        };
        h = c23 = new c(){

            private boolean o(i i2, b b2) {
                b2.X("html");
                b2.G0(i);
                return b2.f(i2);
            }

            @Override
            boolean n(i i2, b b2) {
                block9: {
                    block7: {
                        block8: {
                            block6: {
                                if (i2.i()) {
                                    b2.r(this);
                                    return false;
                                }
                                if (!i2.h()) break block6;
                                b2.Q(i2.b());
                                break block7;
                            }
                            if (!c.l(i2)) break block8;
                            b2.P(i2.a());
                            break block7;
                        }
                        if (!i2.l() || !i2.e().E().equals((Object)"html")) break block9;
                        b2.N(i2.e());
                        b2.G0(i);
                    }
                    return true;
                }
                if (i2.k() && E3.c.d(i2.d().E(), G3.c$y.e)) {
                    return this.o(i2, b2);
                }
                if (i2.k()) {
                    b2.r(this);
                    return false;
                }
                return this.o(i2, b2);
            }
        };
        i = c22 = new c(){

            @Override
            boolean n(i i2, b b2) {
                block10: {
                    block8: {
                        block9: {
                            block7: {
                                if (!c.l(i2)) break block7;
                                b2.P(i2.a());
                                break block8;
                            }
                            if (!i2.h()) break block9;
                            b2.Q(i2.b());
                            break block8;
                        }
                        if (i2.i()) {
                            b2.r(this);
                            return false;
                        }
                        if (i2.l() && i2.e().E().equals((Object)"html")) {
                            return m.n(i2, b2);
                        }
                        if (!i2.l() || !i2.e().E().equals((Object)"head")) break block10;
                        b2.E0(b2.N(i2.e()));
                        b2.G0(j);
                    }
                    return true;
                }
                if (i2.k() && E3.c.d(i2.d().E(), G3.c$y.e)) {
                    b2.h("head");
                    return b2.f(i2);
                }
                if (i2.k()) {
                    b2.r(this);
                    return false;
                }
                b2.h("head");
                return b2.f(i2);
            }
        };
        j = c21 = new c(){

            private boolean o(i i2, m m2) {
                m2.g("head");
                return m2.f(i2);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            boolean n(i object, b b2) {
                if (c.l((i)object)) {
                    b2.P(((i)object).a());
                    return true;
                }
                int n2 = G3.c$p.a[((i)object).a.ordinal()];
                if (n2 == 1) {
                    b2.Q(((i)object).b());
                    return true;
                }
                if (n2 == 2) {
                    b2.r(this);
                    return false;
                }
                if (n2 != 3) {
                    if (n2 != 4) {
                        return this.o((i)object, b2);
                    }
                    String string = ((i)object).d().E();
                    if (string.equals((Object)"head")) {
                        b2.l0();
                        b2.G0(l);
                        return true;
                    }
                    if (E3.c.d(string, G3.c$y.c)) {
                        return this.o((i)object, b2);
                    }
                    b2.r(this);
                    return false;
                }
                i.h h2 = ((i)object).e();
                String string = h2.E();
                if (string.equals((Object)"html")) {
                    return m.n((i)object, b2);
                }
                if (E3.c.d(string, G3.c$y.a)) {
                    object = b2.R(h2);
                    if (!string.equals((Object)"base")) return true;
                    if (!((F3.m)object).s("href")) return true;
                    b2.h0((F3.h)object);
                    return true;
                }
                if (string.equals((Object)"meta")) {
                    b2.R(h2);
                    return true;
                }
                if (string.equals((Object)"title")) {
                    c.j(h2, b2);
                    return true;
                }
                if (E3.c.d(string, G3.c$y.b)) {
                    c.i(h2, b2);
                    return true;
                }
                if (string.equals((Object)"noscript")) {
                    b2.N(h2);
                    b2.G0(k);
                    return true;
                }
                if (string.equals((Object)"script")) {
                    b2.c.w(G3.l.l);
                    b2.g0();
                    b2.G0(n);
                    b2.N(h2);
                    return true;
                }
                if (!string.equals((Object)"head")) return this.o((i)object, b2);
                b2.r(this);
                return false;
            }
        };
        k = c20 = new c(){

            private boolean o(i i2, b b2) {
                b2.r(this);
                b2.P(new i.c().p(i2.toString()));
                return true;
            }

            @Override
            boolean n(i i2, b b2) {
                block9: {
                    block8: {
                        block7: {
                            if (!i2.i()) break block7;
                            b2.r(this);
                            break block8;
                        }
                        if (i2.l() && i2.e().E().equals((Object)"html")) {
                            return b2.q0(i2, m);
                        }
                        if (!i2.k() || !i2.d().E().equals((Object)"noscript")) break block9;
                        b2.l0();
                        b2.G0(j);
                    }
                    return true;
                }
                if (!(c.l(i2) || i2.h() || i2.l() && E3.c.d(i2.e().E(), G3.c$y.f))) {
                    if (i2.k() && i2.d().E().equals((Object)"br")) {
                        return this.o(i2, b2);
                    }
                    if (i2.l() && E3.c.d(i2.e().E(), G3.c$y.K) || i2.k()) {
                        b2.r(this);
                        return false;
                    }
                    return this.o(i2, b2);
                }
                return b2.q0(i2, j);
            }
        };
        l = c19 = new c(){

            private boolean o(i i2, b b2) {
                b2.h("body");
                b2.s(true);
                return b2.f(i2);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            boolean n(i i2, b b2) {
                if (c.l(i2)) {
                    b2.P(i2.a());
                    return true;
                }
                if (i2.h()) {
                    b2.Q(i2.b());
                    return true;
                }
                if (i2.i()) {
                    b2.r(this);
                    return true;
                }
                if (i2.l()) {
                    Object object = i2.e();
                    String string = ((i.i)object).E();
                    if (string.equals((Object)"html")) {
                        return b2.q0(i2, m);
                    }
                    if (string.equals((Object)"body")) {
                        b2.N((i.h)object);
                        b2.s(false);
                        b2.G0(m);
                        return true;
                    }
                    if (string.equals((Object)"frameset")) {
                        b2.N((i.h)object);
                        b2.G0(y);
                        return true;
                    }
                    if (E3.c.d(string, G3.c$y.g)) {
                        b2.r(this);
                        object = b2.B();
                        b2.r0((F3.h)object);
                        b2.q0(i2, j);
                        b2.w0((F3.h)object);
                        return true;
                    }
                    if (string.equals((Object)"head")) {
                        b2.r(this);
                        return false;
                    }
                    this.o(i2, b2);
                    return true;
                }
                if (!i2.k()) {
                    this.o(i2, b2);
                    return true;
                }
                if (E3.c.d(i2.d().E(), G3.c$y.d)) {
                    this.o(i2, b2);
                    return true;
                }
                b2.r(this);
                return false;
            }
        };
        m = c18 = new c(){

            private boolean p(i stringArray, b b2) {
                i.g g2 = stringArray.d();
                String string = g2.E();
                string.getClass();
                int n2 = -1;
                switch (string.hashCode()) {
                    default: {
                        break;
                    }
                    case 1869063452: {
                        if (!string.equals((Object)"sarcasm")) break;
                        n2 = 15;
                        break;
                    }
                    case 3536714: {
                        if (!string.equals((Object)"span")) break;
                        n2 = 14;
                        break;
                    }
                    case 3213227: {
                        if (!string.equals((Object)"html")) break;
                        n2 = 13;
                        break;
                    }
                    case 3148996: {
                        if (!string.equals((Object)"form")) break;
                        n2 = 12;
                        break;
                    }
                    case 3029410: {
                        if (!string.equals((Object)"body")) break;
                        n2 = 11;
                        break;
                    }
                    case 3453: {
                        if (!string.equals((Object)"li")) break;
                        n2 = 10;
                        break;
                    }
                    case 3278: {
                        if (!string.equals((Object)"h6")) break;
                        n2 = 9;
                        break;
                    }
                    case 3277: {
                        if (!string.equals((Object)"h5")) break;
                        n2 = 8;
                        break;
                    }
                    case 3276: {
                        if (!string.equals((Object)"h4")) break;
                        n2 = 7;
                        break;
                    }
                    case 3275: {
                        if (!string.equals((Object)"h3")) break;
                        n2 = 6;
                        break;
                    }
                    case 3274: {
                        if (!string.equals((Object)"h2")) break;
                        n2 = 5;
                        break;
                    }
                    case 3273: {
                        if (!string.equals((Object)"h1")) break;
                        n2 = 4;
                        break;
                    }
                    case 3216: {
                        if (!string.equals((Object)"dt")) break;
                        n2 = 3;
                        break;
                    }
                    case 3200: {
                        if (!string.equals((Object)"dd")) break;
                        n2 = 2;
                        break;
                    }
                    case 3152: {
                        if (!string.equals((Object)"br")) break;
                        n2 = 1;
                        break;
                    }
                    case 112: {
                        if (!string.equals((Object)"p")) break;
                        n2 = 0;
                    }
                }
                switch (n2) {
                    default: {
                        if (E3.c.d(string, G3.c$y.s)) {
                            return this.q((i)stringArray, b2);
                        }
                        if (E3.c.d(string, G3.c$y.r)) {
                            if (!b2.G(string)) {
                                b2.r(this);
                                return false;
                            }
                            b2.u();
                            if (!b2.a().s0().equals((Object)string)) {
                                b2.r(this);
                            }
                            b2.n0(string);
                            break;
                        }
                        if (E3.c.d(string, G3.c$y.m)) {
                            if (b2.G("name")) break;
                            if (!b2.G(string)) {
                                b2.r(this);
                                return false;
                            }
                            b2.u();
                            if (!b2.a().s0().equals((Object)string)) {
                                b2.r(this);
                            }
                            b2.n0(string);
                            b2.m();
                            break;
                        }
                        return this.o((i)stringArray, b2);
                    }
                    case 14: 
                    case 15: {
                        return this.o((i)stringArray, b2);
                    }
                    case 13: {
                        if (!b2.g("body")) break;
                        return b2.f(g2);
                    }
                    case 12: {
                        stringArray = b2.z();
                        b2.C0(null);
                        if (stringArray != null && b2.G(string)) {
                            b2.u();
                            if (!b2.a().s0().equals((Object)string)) {
                                b2.r(this);
                            }
                            b2.w0((F3.h)stringArray);
                            break;
                        }
                        b2.r(this);
                        return false;
                    }
                    case 11: {
                        if (!b2.G("body")) {
                            b2.r(this);
                            return false;
                        }
                        b2.G0(x);
                        break;
                    }
                    case 10: {
                        if (!b2.F(string)) {
                            b2.r(this);
                            return false;
                        }
                        b2.v(string);
                        if (!b2.a().s0().equals((Object)string)) {
                            b2.r(this);
                        }
                        b2.n0(string);
                        break;
                    }
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 9: {
                        stringArray = G3.c$y.i;
                        if (!b2.I(stringArray)) {
                            b2.r(this);
                            return false;
                        }
                        b2.v(string);
                        if (!b2.a().s0().equals((Object)string)) {
                            b2.r(this);
                        }
                        b2.o0(stringArray);
                        break;
                    }
                    case 2: 
                    case 3: {
                        if (!b2.G(string)) {
                            b2.r(this);
                            return false;
                        }
                        b2.v(string);
                        if (!b2.a().s0().equals((Object)string)) {
                            b2.r(this);
                        }
                        b2.n0(string);
                        break;
                    }
                    case 1: {
                        b2.r(this);
                        b2.h("br");
                        return false;
                    }
                    case 0: {
                        if (!b2.E(string)) {
                            b2.r(this);
                            b2.h(string);
                            return b2.f(g2);
                        }
                        b2.v(string);
                        if (!b2.a().s0().equals((Object)string)) {
                            b2.r(this);
                        }
                        b2.n0(string);
                    }
                }
                return true;
            }

            private boolean q(i i2, b b2) {
                String string = i2.d().E();
                ArrayList arrayList = b2.D();
                int n2 = 0;
                while (true) {
                    int n3;
                    F3.m[] mArray;
                    F3.h h2;
                    boolean bl = true;
                    if (n2 >= 8) break;
                    F3.h h3 = b2.w(string);
                    if (h3 == null) {
                        return this.o(i2, b2);
                    }
                    if (!b2.j0(h3)) {
                        b2.r(this);
                        b2.v0(h3);
                        return true;
                    }
                    if (!b2.G(h3.s0())) {
                        b2.r(this);
                        return false;
                    }
                    if (b2.a() != h3) {
                        b2.r(this);
                    }
                    int n4 = arrayList.size();
                    F3.h h4 = null;
                    int n5 = -1;
                    int n6 = 0;
                    boolean bl2 = false;
                    F3.h h5 = null;
                    while (true) {
                        boolean bl3;
                        h2 = h4;
                        if (n6 >= n4) break;
                        h2 = h4;
                        if (n6 >= 64) break;
                        mArray = (F3.m[])arrayList.get(n6);
                        if (mArray == h3) {
                            h2 = (F3.h)arrayList.get(n6 - 1);
                            n3 = b2.p0((F3.h)mArray);
                            bl3 = true;
                        } else {
                            n3 = n5;
                            bl3 = bl2;
                            h2 = h5;
                            if (bl2) {
                                n3 = n5;
                                bl3 = bl2;
                                h2 = h5;
                                if (b2.e0((F3.h)mArray)) {
                                    h2 = mArray;
                                    break;
                                }
                            }
                        }
                        ++n6;
                        n5 = n3;
                        bl2 = bl3;
                        h5 = h2;
                    }
                    if (h2 == null) {
                        b2.n0(h3.s0());
                        b2.v0(h3);
                        return true;
                    }
                    F3.h h6 = h4 = h2;
                    for (n6 = 0; n6 < 3; ++n6) {
                        mArray = h4;
                        if (b2.j0(h4)) {
                            mArray = b2.k(h4);
                        }
                        if (!b2.c0((F3.h)mArray)) {
                            b2.w0((F3.h)mArray);
                            h4 = mArray;
                            continue;
                        }
                        if (mArray == h3) break;
                        h4 = new F3.h(G3.h.r(mArray.x(), f.d), b2.x());
                        b2.y0((F3.h)mArray, h4);
                        b2.A0((F3.h)mArray, h4);
                        if (h6 == h2) {
                            n5 = b2.p0(h4) + 1;
                        }
                        if (h6.v0() != null) {
                            h6.I();
                        }
                        h4.V(h6);
                        h6 = h4;
                    }
                    if (h5 != null) {
                        if (E3.c.d(h5.s0(), G3.c$y.t)) {
                            if (h6.v0() != null) {
                                h6.I();
                            }
                            b2.T(h6);
                        } else {
                            if (h6.v0() != null) {
                                h6.I();
                            }
                            h5.V(h6);
                        }
                    }
                    h4 = new F3.h(h3.F0(), b2.x());
                    h4.e().l(h3.e());
                    mArray = (F3.m[])h2.l().toArray((Object[])new F3.m[0]);
                    n3 = mArray.length;
                    for (n6 = 0; n6 < n3; ++n6) {
                        h4.V(mArray[n6]);
                    }
                    h2.V(h4);
                    b2.v0(h3);
                    b2.t0(h4, n5);
                    b2.w0(h3);
                    b2.W(h2, h4);
                    ++n2;
                }
                return true;
            }

            /*
             * Enabled aggressive block sorting
             */
            private boolean r(i object, b b2) {
                int n2;
                Object object22 = ((i)object).e();
                Object object3 = ((i.i)object22).E();
                object3.getClass();
                int n3 = -1;
                switch (object3.hashCode()) {
                    case 2115613112: {
                        if (!object3.equals((Object)"noembed")) break;
                        n3 = 1;
                        break;
                    }
                    case 2091304424: {
                        if (!object3.equals((Object)"isindex")) break;
                        n3 = 2;
                        break;
                    }
                    case 1973234167: {
                        if (!object3.equals((Object)"plaintext")) break;
                        n3 = 3;
                        break;
                    }
                    case 181975684: {
                        if (!object3.equals((Object)"listing")) break;
                        n3 = 4;
                        break;
                    }
                    case 110115790: {
                        if (!object3.equals((Object)"table")) break;
                        n3 = 5;
                        break;
                    }
                    case 100358090: {
                        if (!object3.equals((Object)"input")) break;
                        n3 = 6;
                        break;
                    }
                    case 100313435: {
                        if (!object3.equals((Object)"image")) break;
                        n3 = 7;
                        break;
                    }
                    case 3536714: {
                        if (!object3.equals((Object)"span")) break;
                        n3 = 8;
                        break;
                    }
                    case 3386833: {
                        if (!object3.equals((Object)"nobr")) break;
                        n3 = 9;
                        break;
                    }
                    case 3344136: {
                        if (!object3.equals((Object)"math")) break;
                        n3 = 10;
                        break;
                    }
                    case 3213227: {
                        if (!object3.equals((Object)"html")) break;
                        n3 = 11;
                        break;
                    }
                    case 3148996: {
                        if (!object3.equals((Object)"form")) break;
                        n3 = 12;
                        break;
                    }
                    case 3029410: {
                        if (!object3.equals((Object)"body")) break;
                        n3 = 13;
                        break;
                    }
                    case 118811: {
                        if (!object3.equals((Object)"xmp")) break;
                        n3 = 14;
                        break;
                    }
                    case 114276: {
                        if (!object3.equals((Object)"svg")) break;
                        n3 = 15;
                        break;
                    }
                    case 111267: {
                        if (!object3.equals((Object)"pre")) break;
                        n3 = 16;
                        break;
                    }
                    case 3650: {
                        if (!object3.equals((Object)"rt")) break;
                        n3 = 17;
                        break;
                    }
                    case 3646: {
                        if (!object3.equals((Object)"rp")) break;
                        n3 = 18;
                        break;
                    }
                    case 3453: {
                        if (!object3.equals((Object)"li")) break;
                        n3 = 19;
                        break;
                    }
                    case 3338: {
                        if (!object3.equals((Object)"hr")) break;
                        n3 = 20;
                        break;
                    }
                    case 3278: {
                        if (!object3.equals((Object)"h6")) break;
                        n3 = 21;
                        break;
                    }
                    case 3277: {
                        if (!object3.equals((Object)"h5")) break;
                        n3 = 22;
                        break;
                    }
                    case 3276: {
                        if (!object3.equals((Object)"h4")) break;
                        n3 = 23;
                        break;
                    }
                    case 3275: {
                        if (!object3.equals((Object)"h3")) break;
                        n3 = 24;
                        break;
                    }
                    case 3274: {
                        if (!object3.equals((Object)"h2")) break;
                        n3 = 25;
                        break;
                    }
                    case 3273: {
                        if (!object3.equals((Object)"h1")) break;
                        n3 = 26;
                        break;
                    }
                    case 3216: {
                        if (!object3.equals((Object)"dt")) break;
                        n3 = 27;
                        break;
                    }
                    case 3200: {
                        if (!object3.equals((Object)"dd")) break;
                        n3 = 28;
                        break;
                    }
                    case 97: {
                        if (!object3.equals((Object)"a")) break;
                        n3 = 29;
                        break;
                    }
                    case -80773204: {
                        if (!object3.equals((Object)"optgroup")) break;
                        n3 = 30;
                        break;
                    }
                    case -906021636: {
                        if (!object3.equals((Object)"select")) break;
                        n3 = 31;
                        break;
                    }
                    case -1003243718: {
                        if (!object3.equals((Object)"textarea")) break;
                        n3 = 32;
                        break;
                    }
                    case -1010136971: {
                        if (!object3.equals((Object)"option")) break;
                        n3 = 33;
                        break;
                    }
                    case -1191214428: {
                        if (!object3.equals((Object)"iframe")) break;
                        n3 = 34;
                        break;
                    }
                    case -1377687758: {
                        if (!object3.equals((Object)"button")) break;
                        n3 = 35;
                        break;
                    }
                    case -1644953643: {
                        if (!object3.equals((Object)"frameset")) break;
                        n3 = 36;
                        break;
                    }
                }
                switch (n3) {
                    default: {
                        n2 = -1;
                        break;
                    }
                    case 1: {
                        n2 = 35;
                        break;
                    }
                    case 2: {
                        n2 = 34;
                        break;
                    }
                    case 3: {
                        n2 = 33;
                        break;
                    }
                    case 4: {
                        n2 = 32;
                        break;
                    }
                    case 5: {
                        n2 = 31;
                        break;
                    }
                    case 6: {
                        n2 = 30;
                        break;
                    }
                    case 7: {
                        n2 = 29;
                        break;
                    }
                    case 8: {
                        n2 = 28;
                        break;
                    }
                    case 9: {
                        n2 = 27;
                        break;
                    }
                    case 10: {
                        n2 = 26;
                        break;
                    }
                    case 11: {
                        n2 = 25;
                        break;
                    }
                    case 12: {
                        n2 = 24;
                        break;
                    }
                    case 13: {
                        n2 = 23;
                        break;
                    }
                    case 14: {
                        n2 = 22;
                        break;
                    }
                    case 15: {
                        n2 = 21;
                        break;
                    }
                    case 16: {
                        n2 = 20;
                        break;
                    }
                    case 17: {
                        n2 = 19;
                        break;
                    }
                    case 18: {
                        n2 = 18;
                        break;
                    }
                    case 19: {
                        n2 = 17;
                        break;
                    }
                    case 20: {
                        n2 = 16;
                        break;
                    }
                    case 21: {
                        n2 = 15;
                        break;
                    }
                    case 22: {
                        n2 = 14;
                        break;
                    }
                    case 23: {
                        n2 = 13;
                        break;
                    }
                    case 24: {
                        n2 = 12;
                        break;
                    }
                    case 25: {
                        n2 = 11;
                        break;
                    }
                    case 26: {
                        n2 = 10;
                        break;
                    }
                    case 27: {
                        n2 = 9;
                        break;
                    }
                    case 28: {
                        n2 = 8;
                        break;
                    }
                    case 29: {
                        n2 = 7;
                        break;
                    }
                    case 30: {
                        n2 = 6;
                        break;
                    }
                    case 31: {
                        n2 = 5;
                        break;
                    }
                    case 32: {
                        n2 = 4;
                        break;
                    }
                    case 33: {
                        n2 = 3;
                        break;
                    }
                    case 34: {
                        n2 = 2;
                        break;
                    }
                    case 35: {
                        n2 = 1;
                        break;
                    }
                    case 36: {
                        n2 = 0;
                    }
                }
                switch (n2) {
                    default: {
                        if (E3.c.d((String)object3, G3.c$y.n)) {
                            b2.u0();
                            b2.R((i.h)object22);
                            b2.s(false);
                            return true;
                        }
                        if (E3.c.d((String)object3, G3.c$y.h)) {
                            if (b2.E("p")) {
                                b2.g("p");
                            }
                            b2.N((i.h)object22);
                            return true;
                        }
                        if (E3.c.d((String)object3, G3.c$y.g)) {
                            return b2.q0((i)object, j);
                        }
                        if (E3.c.d((String)object3, G3.c$y.l)) {
                            b2.u0();
                            b2.s0(b2.N((i.h)object22));
                            return true;
                        }
                        if (E3.c.d((String)object3, G3.c$y.m)) {
                            b2.u0();
                            b2.N((i.h)object22);
                            b2.U();
                            b2.s(false);
                            return true;
                        }
                        if (E3.c.d((String)object3, G3.c$y.o)) {
                            b2.R((i.h)object22);
                            return true;
                        }
                        if (E3.c.d((String)object3, G3.c$y.q)) {
                            b2.r(this);
                            return false;
                        }
                        b2.u0();
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 35: {
                        c.i((i.h)object22, b2);
                        return true;
                    }
                    case 34: {
                        b2.r(this);
                        if (b2.z() != null) {
                            return false;
                        }
                        b2.h("form");
                        if (((i.i)object22).y("action")) {
                            b2.z().Z("action", ((i.i)object22).j.s("action"));
                        }
                        b2.h("hr");
                        b2.h("label");
                        object = ((i.i)object22).y("prompt") ? ((i.i)object22).j.s("prompt") : "This is a searchable index. Enter search keywords: ";
                        b2.f(new i.c().p((String)object));
                        object = new F3.b();
                        if (((i.i)object22).z()) {
                            for (Object object22 : ((i.i)object22).j) {
                                if (E3.c.d(((a)object22).b(), G3.c$y.p)) continue;
                                ((F3.b)object).E((a)object22);
                            }
                        }
                        ((F3.b)object).F("name", "isindex");
                        b2.i("input", (F3.b)object);
                        b2.g("label");
                        b2.h("hr");
                        b2.g("form");
                        return true;
                    }
                    case 33: {
                        if (b2.E("p")) {
                            b2.g("p");
                        }
                        b2.N((i.h)object22);
                        b2.c.w(G3.l.m);
                        return true;
                    }
                    case 31: {
                        if (b2.y().U0() != f.b.h && b2.E("p")) {
                            b2.g("p");
                        }
                        b2.N((i.h)object22);
                        b2.s(false);
                        b2.G0(o);
                        return true;
                    }
                    case 30: {
                        b2.u0();
                        if (b2.R((i.h)object22).d("type").equalsIgnoreCase("hidden")) return true;
                        b2.s(false);
                        return true;
                    }
                    case 29: {
                        if (b2.A("svg") == null) {
                            return b2.f(((i.i)object22).B("img"));
                        }
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 28: {
                        b2.u0();
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 27: {
                        b2.u0();
                        if (b2.G("nobr")) {
                            b2.r(this);
                            b2.g("nobr");
                            b2.u0();
                        }
                        b2.s0(b2.N((i.h)object22));
                        return true;
                    }
                    case 26: {
                        b2.u0();
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 25: {
                        b2.r(this);
                        object = (F3.h)b2.D().get(0);
                        if (!((i.i)object22).z()) return true;
                        b2 = ((i.i)object22).j.iterator();
                        while (b2.hasNext()) {
                            object22 = (a)b2.next();
                            if (((F3.m)object).s(((a)object22).b())) continue;
                            ((F3.h)object).e().E((a)object22);
                        }
                        return true;
                    }
                    case 24: {
                        if (b2.z() != null) {
                            b2.r(this);
                            return false;
                        }
                        if (b2.E("p")) {
                            b2.g("p");
                        }
                        b2.S((i.h)object22, true);
                        return true;
                    }
                    case 23: {
                        b2.r(this);
                        object = b2.D();
                        if (object.size() == 1) return false;
                        if (object.size() > 2 && !((F3.h)object.get(1)).s0().equals((Object)"body")) {
                            return false;
                        }
                        b2.s(false);
                        object = (F3.h)object.get(1);
                        if (!((i.i)object22).z()) return true;
                        b2 = ((i.i)object22).j.iterator();
                        while (b2.hasNext()) {
                            object22 = (a)b2.next();
                            if (((F3.m)object).s(((a)object22).b())) continue;
                            ((F3.h)object).e().E((a)object22);
                        }
                        return true;
                    }
                    case 22: {
                        if (b2.E("p")) {
                            b2.g("p");
                        }
                        b2.u0();
                        b2.s(false);
                        c.i((i.h)object22, b2);
                        return true;
                    }
                    case 21: {
                        b2.u0();
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 20: 
                    case 32: {
                        if (b2.E("p")) {
                            b2.g("p");
                        }
                        b2.N((i.h)object22);
                        b2.b.x("\n");
                        b2.s(false);
                        return true;
                    }
                    case 18: 
                    case 19: {
                        if (!b2.G("ruby")) return true;
                        b2.u();
                        if (!b2.a().s0().equals((Object)"ruby")) {
                            b2.r(this);
                            b2.m0("ruby");
                        }
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 17: {
                        b2.s(false);
                        object3 = b2.D();
                        for (n2 = object3.size() - 1; n2 > 0; --n2) {
                            object = (F3.h)object3.get(n2);
                            if (((F3.h)object).s0().equals((Object)"li")) {
                                b2.g("li");
                                break;
                            }
                            if (b2.e0((F3.h)object) && !E3.c.d(((F3.h)object).s0(), G3.c$y.j)) break;
                        }
                        if (b2.E("p")) {
                            b2.g("p");
                        }
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 16: {
                        if (b2.E("p")) {
                            b2.g("p");
                        }
                        b2.R((i.h)object22);
                        b2.s(false);
                        return true;
                    }
                    case 10: 
                    case 11: 
                    case 12: 
                    case 13: 
                    case 14: 
                    case 15: {
                        if (b2.E("p")) {
                            b2.g("p");
                        }
                        if (E3.c.d(b2.a().s0(), G3.c$y.i)) {
                            b2.r(this);
                            b2.l0();
                        }
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 8: 
                    case 9: {
                        b2.s(false);
                        object3 = b2.D();
                        for (n2 = object3.size() - 1; n2 > 0; --n2) {
                            object = (F3.h)object3.get(n2);
                            if (E3.c.d(((F3.h)object).s0(), G3.c$y.k)) {
                                b2.g(((F3.h)object).s0());
                                break;
                            }
                            if (b2.e0((F3.h)object) && !E3.c.d(((F3.h)object).s0(), G3.c$y.j)) break;
                        }
                        if (b2.E("p")) {
                            b2.g("p");
                        }
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 7: {
                        if (b2.w("a") != null) {
                            b2.r(this);
                            b2.g("a");
                            object = b2.A("a");
                            if (object != null) {
                                b2.v0((F3.h)object);
                                b2.w0((F3.h)object);
                            }
                        }
                        b2.u0();
                        b2.s0(b2.N((i.h)object22));
                        return true;
                    }
                    case 5: {
                        b2.u0();
                        b2.N((i.h)object22);
                        b2.s(false);
                        object = b2.F0();
                        if (!(object.equals((Object)o) || object.equals((Object)q) || object.equals((Object)s) || object.equals((Object)t) || object.equals((Object)u))) {
                            b2.G0(v);
                            return true;
                        }
                        b2.G0(w);
                        return true;
                    }
                    case 4: {
                        b2.N((i.h)object22);
                        if (((i.i)object22).A()) return true;
                        b2.c.w(G3.l.i);
                        b2.g0();
                        b2.s(false);
                        b2.G0(n);
                        return true;
                    }
                    case 3: 
                    case 6: {
                        if (b2.a().s0().equals((Object)"option")) {
                            b2.g("option");
                        }
                        b2.u0();
                        b2.N((i.h)object22);
                        return true;
                    }
                    case 2: {
                        b2.s(false);
                        c.i((i.h)object22, b2);
                        return true;
                    }
                    case 1: {
                        if (b2.E("button")) {
                            b2.r(this);
                            b2.g("button");
                            b2.f((i)object22);
                            return true;
                        }
                        b2.u0();
                        b2.N((i.h)object22);
                        b2.s(false);
                        return true;
                    }
                    case 0: 
                }
                b2.r(this);
                object = b2.D();
                if (object.size() == 1) return false;
                if (object.size() > 2 && !((F3.h)object.get(1)).s0().equals((Object)"body")) {
                    return false;
                }
                if (!b2.t()) {
                    return false;
                }
                object3 = (F3.h)object.get(1);
                if (((F3.h)object3).v0() != null) {
                    ((F3.m)object3).I();
                }
                while (object.size() > 1) {
                    object.remove(object.size() - 1);
                }
                b2.N((i.h)object22);
                b2.G0(y);
                return true;
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            boolean n(i i2, b b2) {
                int n2 = G3.c$p.a[i2.a.ordinal()];
                if (n2 == 1) {
                    b2.Q(i2.b());
                    return true;
                }
                if (n2 == 2) {
                    b2.r(this);
                    return false;
                }
                if (n2 == 3) return this.r(i2, b2);
                if (n2 == 4) return this.p(i2, b2);
                if (n2 != 5) {
                    return true;
                }
                if (((i.c)(i2 = i2.a())).q().equals((Object)D)) {
                    b2.r(this);
                    return false;
                }
                if (b2.t() && c.l(i2)) {
                    b2.u0();
                    b2.P((i.c)i2);
                    return true;
                }
                b2.u0();
                b2.P((i.c)i2);
                b2.s(false);
                return true;
            }

            boolean o(i object, b b2) {
                object = ((i)object).d().c;
                ArrayList arrayList = b2.D();
                for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
                    F3.h h2 = (F3.h)arrayList.get(i2);
                    if (h2.s0().equals(object)) {
                        b2.v((String)object);
                        if (!object.equals((Object)b2.a().s0())) {
                            b2.r(this);
                        }
                        b2.n0((String)object);
                        break;
                    }
                    if (!b2.e0(h2)) continue;
                    b2.r(this);
                    return false;
                }
                return true;
            }
        };
        n = c17 = new c(){

            @Override
            boolean n(i i2, b b2) {
                if (i2.g()) {
                    b2.P(i2.a());
                } else {
                    if (i2.j()) {
                        b2.r(this);
                        b2.l0();
                        b2.G0(b2.k0());
                        return b2.f(i2);
                    }
                    if (i2.k()) {
                        b2.l0();
                        b2.G0(b2.k0());
                    }
                }
                return true;
            }
        };
        o = c16 = new c(){

            @Override
            boolean n(i i2, b b2) {
                block18: {
                    block26: {
                        block20: {
                            String string;
                            i.h h2;
                            block24: {
                                block25: {
                                    block23: {
                                        block22: {
                                            block21: {
                                                block19: {
                                                    if (i2.g()) {
                                                        b2.i0();
                                                        b2.g0();
                                                        b2.G0(p);
                                                        return b2.f(i2);
                                                    }
                                                    if (i2.h()) {
                                                        b2.Q(i2.b());
                                                        return true;
                                                    }
                                                    if (i2.i()) {
                                                        b2.r(this);
                                                        return false;
                                                    }
                                                    if (!i2.l()) break block18;
                                                    h2 = i2.e();
                                                    string = h2.E();
                                                    if (!string.equals((Object)"caption")) break block19;
                                                    b2.p();
                                                    b2.U();
                                                    b2.N(h2);
                                                    b2.G0(q);
                                                    break block20;
                                                }
                                                if (!string.equals((Object)"colgroup")) break block21;
                                                b2.p();
                                                b2.N(h2);
                                                b2.G0(r);
                                                break block20;
                                            }
                                            if (string.equals((Object)"col")) {
                                                b2.h("colgroup");
                                                return b2.f(i2);
                                            }
                                            if (!E3.c.d(string, G3.c$y.u)) break block22;
                                            b2.p();
                                            b2.N(h2);
                                            b2.G0(s);
                                            break block20;
                                        }
                                        if (E3.c.d(string, G3.c$y.v)) {
                                            b2.h("tbody");
                                            return b2.f(i2);
                                        }
                                        if (!string.equals((Object)"table")) break block23;
                                        b2.r(this);
                                        if (b2.g("table")) {
                                            return b2.f(i2);
                                        }
                                        break block20;
                                    }
                                    if (E3.c.d(string, G3.c$y.w)) {
                                        return b2.q0(i2, j);
                                    }
                                    if (!string.equals((Object)"input")) break block24;
                                    if (!h2.z() || !h2.j.s("type").equalsIgnoreCase("hidden")) break block25;
                                    b2.R(h2);
                                    break block20;
                                }
                                return this.o(i2, b2);
                            }
                            if (!string.equals((Object)"form")) break block26;
                            b2.r(this);
                            if (b2.z() != null) {
                                return false;
                            }
                            b2.S(h2, false);
                        }
                        return true;
                    }
                    return this.o(i2, b2);
                }
                if (i2.k()) {
                    String string = i2.d().E();
                    if (string.equals((Object)"table")) {
                        if (!b2.M(string)) {
                            b2.r(this);
                            return false;
                        }
                        b2.n0("table");
                        b2.B0();
                        return true;
                    }
                    if (E3.c.d(string, G3.c$y.B)) {
                        b2.r(this);
                        return false;
                    }
                    return this.o(i2, b2);
                }
                if (i2.j()) {
                    if (b2.a().s0().equals((Object)"html")) {
                        b2.r(this);
                    }
                    return true;
                }
                return this.o(i2, b2);
            }

            boolean o(i i2, b b2) {
                b2.r(this);
                if (E3.c.d(b2.a().s0(), G3.c$y.C)) {
                    b2.D0(true);
                    boolean bl = b2.q0(i2, m);
                    b2.D0(false);
                    return bl;
                }
                return b2.q0(i2, m);
            }
        };
        p = c15 = new c(){

            @Override
            boolean n(i i2, b b2) {
                if (i2.a == i.j.k) {
                    if (((i.c)(i2 = i2.a())).q().equals((Object)D)) {
                        b2.r(this);
                        return false;
                    }
                    b2.C().add((Object)((i.c)i2).q());
                    return true;
                }
                if (b2.C().size() > 0) {
                    for (String string : b2.C()) {
                        if (!c.m(string)) {
                            b2.r(this);
                            if (E3.c.d(b2.a().s0(), G3.c$y.C)) {
                                b2.D0(true);
                                b2.q0(new i.c().p(string), m);
                                b2.D0(false);
                                continue;
                            }
                            b2.q0(new i.c().p(string), m);
                            continue;
                        }
                        b2.P(new i.c().p(string));
                    }
                    b2.i0();
                }
                b2.G0(b2.k0());
                return b2.f(i2);
            }
        };
        q = c14 = new c(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            boolean n(i i2, b b2) {
                if (!i2.k() || !i2.d().E().equals((Object)"caption")) {
                    if (i2.l() && E3.c.d(i2.e().E(), G3.c$y.A) || i2.k() && i2.d().E().equals((Object)"table")) {
                        b2.r(this);
                        if (!b2.g("caption")) return true;
                        return b2.f(i2);
                    }
                } else {
                    if (!b2.M(i2.d().E())) {
                        b2.r(this);
                        return false;
                    }
                    b2.u();
                    if (!b2.a().s0().equals((Object)"caption")) {
                        b2.r(this);
                    }
                    b2.n0("caption");
                    b2.m();
                    b2.G0(o);
                    return true;
                }
                if (!i2.k() || !E3.c.d(i2.d().E(), G3.c$y.L)) return b2.q0(i2, m);
                b2.r(this);
                return false;
            }
        };
        r = c13 = new c(){

            private boolean o(i i2, m m2) {
                if (m2.g("colgroup")) {
                    return m2.f(i2);
                }
                return true;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            boolean n(i i2, b b2) {
                if (c.l(i2)) {
                    b2.P(i2.a());
                    return true;
                }
                int n2 = G3.c$p.a[i2.a.ordinal()];
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                if (n2 != 6) {
                                    return this.o(i2, b2);
                                }
                                if (!b2.a().s0().equals((Object)"html")) return this.o(i2, b2);
                                return true;
                            }
                            if (!i2.d().c.equals((Object)"colgroup")) return this.o(i2, b2);
                            if (b2.a().s0().equals((Object)"html")) {
                                b2.r(this);
                                return false;
                            }
                            b2.l0();
                            b2.G0(o);
                            return true;
                        } else {
                            i.h h2 = i2.e();
                            String string = h2.E();
                            string.getClass();
                            if (!string.equals((Object)"col")) {
                                if (string.equals((Object)"html")) return b2.q0(i2, m);
                                return this.o(i2, b2);
                            }
                            b2.R(h2);
                        }
                        return true;
                    } else {
                        b2.r(this);
                    }
                    return true;
                } else {
                    b2.Q(i2.b());
                }
                return true;
            }
        };
        s = c12 = new c(){

            private boolean o(i i2, b b2) {
                return b2.q0(i2, o);
            }

            private boolean p(i i2, b b2) {
                if (!(b2.M("tbody") || b2.M("thead") || b2.G("tfoot"))) {
                    b2.r(this);
                    return false;
                }
                b2.o();
                b2.g(b2.a().s0());
                return b2.f(i2);
            }

            @Override
            boolean n(i i2, b b2) {
                String string;
                i.h h2;
                block13: {
                    block11: {
                        block12: {
                            block9: {
                                String string2;
                                block10: {
                                    int n2 = G3.c$p.a[i2.a.ordinal()];
                                    if (n2 == 3) break block9;
                                    if (n2 != 4) {
                                        return this.o(i2, b2);
                                    }
                                    string2 = i2.d().E();
                                    if (!E3.c.d(string2, G3.c$y.J)) break block10;
                                    if (!b2.M(string2)) {
                                        b2.r(this);
                                        return false;
                                    }
                                    b2.o();
                                    b2.l0();
                                    b2.G0(o);
                                    break block11;
                                }
                                if (string2.equals((Object)"table")) {
                                    return this.p(i2, b2);
                                }
                                if (E3.c.d(string2, G3.c$y.E)) {
                                    b2.r(this);
                                    return false;
                                }
                                return this.o(i2, b2);
                            }
                            h2 = i2.e();
                            string = h2.E();
                            if (!string.equals((Object)"template")) break block12;
                            b2.N(h2);
                            break block11;
                        }
                        if (!string.equals((Object)"tr")) break block13;
                        b2.o();
                        b2.N(h2);
                        b2.G0(t);
                    }
                    return true;
                }
                if (E3.c.d(string, G3.c$y.x)) {
                    b2.r(this);
                    b2.h("tr");
                    return b2.f(h2);
                }
                if (E3.c.d(string, G3.c$y.D)) {
                    return this.p(i2, b2);
                }
                return this.o(i2, b2);
            }
        };
        t = c11 = new c(){

            private boolean o(i i2, b b2) {
                return b2.q0(i2, o);
            }

            private boolean p(i i2, m m2) {
                if (m2.g("tr")) {
                    return m2.f(i2);
                }
                return false;
            }

            @Override
            boolean n(i i2, b b2) {
                block11: {
                    String string;
                    block13: {
                        block14: {
                            block9: {
                                block12: {
                                    block7: {
                                        String string2;
                                        block10: {
                                            i.h h2;
                                            block8: {
                                                if (!i2.l()) break block7;
                                                h2 = i2.e();
                                                string2 = h2.E();
                                                if (!string2.equals((Object)"template")) break block8;
                                                b2.N(h2);
                                                break block9;
                                            }
                                            if (!E3.c.d(string2, G3.c$y.x)) break block10;
                                            b2.q();
                                            b2.N(h2);
                                            b2.G0(u);
                                            b2.U();
                                            break block9;
                                        }
                                        if (E3.c.d(string2, G3.c$y.F)) {
                                            return this.p(i2, b2);
                                        }
                                        return this.o(i2, b2);
                                    }
                                    if (!i2.k()) break block11;
                                    string = i2.d().E();
                                    if (!string.equals((Object)"tr")) break block12;
                                    if (!b2.M(string)) {
                                        b2.r(this);
                                        return false;
                                    }
                                    b2.q();
                                    b2.l0();
                                    b2.G0(s);
                                    break block9;
                                }
                                if (string.equals((Object)"table")) {
                                    return this.p(i2, b2);
                                }
                                if (!E3.c.d(string, G3.c$y.u)) break block13;
                                if (!b2.M(string) || !b2.M("tr")) break block14;
                                b2.q();
                                b2.l0();
                                b2.G0(s);
                            }
                            return true;
                        }
                        b2.r(this);
                        return false;
                    }
                    if (E3.c.d(string, G3.c$y.G)) {
                        b2.r(this);
                        return false;
                    }
                    return this.o(i2, b2);
                }
                return this.o(i2, b2);
            }
        };
        u = c10 = new c(){

            private boolean o(i i2, b b2) {
                return b2.q0(i2, m);
            }

            private void p(b b2) {
                if (b2.M("td")) {
                    b2.g("td");
                    return;
                }
                b2.g("th");
            }

            @Override
            boolean n(i i2, b b2) {
                if (i2.k()) {
                    String string = i2.d().E();
                    if (E3.c.d(string, G3.c$y.x)) {
                        if (!b2.M(string)) {
                            b2.r(this);
                            b2.G0(t);
                            return false;
                        }
                        b2.u();
                        if (!b2.a().s0().equals((Object)string)) {
                            b2.r(this);
                        }
                        b2.n0(string);
                        b2.m();
                        b2.G0(t);
                        return true;
                    }
                    if (E3.c.d(string, G3.c$y.y)) {
                        b2.r(this);
                        return false;
                    }
                    if (E3.c.d(string, G3.c$y.z)) {
                        if (!b2.M(string)) {
                            b2.r(this);
                            return false;
                        }
                        this.p(b2);
                        return b2.f(i2);
                    }
                    return this.o(i2, b2);
                }
                if (i2.l() && E3.c.d(i2.e().E(), G3.c$y.A)) {
                    if (!b2.M("td") && !b2.M("th")) {
                        b2.r(this);
                        return false;
                    }
                    this.p(b2);
                    return b2.f(i2);
                }
                return this.o(i2, b2);
            }
        };
        v = c9 = new c(){

            private boolean o(i i2, b b2) {
                b2.r(this);
                return false;
            }

            @Override
            boolean n(i i2, b b2) {
                block0 : switch (G3.c$p.a[i2.a.ordinal()]) {
                    default: {
                        return this.o(i2, b2);
                    }
                    case 6: {
                        if (b2.a().s0().equals((Object)"html")) break;
                        b2.r(this);
                        break;
                    }
                    case 5: {
                        i2 = i2.a();
                        if (((i.c)i2).q().equals((Object)D)) {
                            b2.r(this);
                            return false;
                        }
                        b2.P((i.c)i2);
                        break;
                    }
                    case 4: {
                        String string = i2.d().E();
                        string.getClass();
                        int n2 = -1;
                        switch (string.hashCode()) {
                            default: {
                                break;
                            }
                            case -80773204: {
                                if (!string.equals((Object)"optgroup")) break;
                                n2 = 2;
                                break;
                            }
                            case -906021636: {
                                if (!string.equals((Object)"select")) break;
                                n2 = 1;
                                break;
                            }
                            case -1010136971: {
                                if (!string.equals((Object)"option")) break;
                                n2 = 0;
                            }
                        }
                        switch (n2) {
                            default: {
                                return this.o(i2, b2);
                            }
                            case 2: {
                                if (b2.a().s0().equals((Object)"option") && b2.k(b2.a()) != null && b2.k(b2.a()).s0().equals((Object)"optgroup")) {
                                    b2.g("option");
                                }
                                if (b2.a().s0().equals((Object)"optgroup")) {
                                    b2.l0();
                                    break block0;
                                }
                                b2.r(this);
                                break block0;
                            }
                            case 1: {
                                if (!b2.J(string)) {
                                    b2.r(this);
                                    return false;
                                }
                                b2.n0(string);
                                b2.B0();
                                break block0;
                            }
                            case 0: 
                        }
                        if (b2.a().s0().equals((Object)"option")) {
                            b2.l0();
                            break;
                        }
                        b2.r(this);
                        break;
                    }
                    case 3: {
                        i.h h2 = i2.e();
                        String string = h2.E();
                        if (string.equals((Object)"html")) {
                            return b2.q0(h2, m);
                        }
                        if (string.equals((Object)"option")) {
                            if (b2.a().s0().equals((Object)"option")) {
                                b2.g("option");
                            }
                            b2.N(h2);
                            break;
                        }
                        if (string.equals((Object)"optgroup")) {
                            if (b2.a().s0().equals((Object)"option")) {
                                b2.g("option");
                            }
                            if (b2.a().s0().equals((Object)"optgroup")) {
                                b2.g("optgroup");
                            }
                            b2.N(h2);
                            break;
                        }
                        if (string.equals((Object)"select")) {
                            b2.r(this);
                            return b2.g("select");
                        }
                        if (E3.c.d(string, G3.c$y.H)) {
                            b2.r(this);
                            if (!b2.J("select")) {
                                return false;
                            }
                            b2.g("select");
                            return b2.f(h2);
                        }
                        if (string.equals((Object)"script")) {
                            return b2.q0(i2, j);
                        }
                        return this.o(i2, b2);
                    }
                    case 2: {
                        b2.r(this);
                        return false;
                    }
                    case 1: {
                        b2.Q(i2.b());
                    }
                }
                return true;
            }
        };
        w = c8 = new c(){

            @Override
            boolean n(i i2, b b2) {
                if (i2.l() && E3.c.d(i2.e().E(), G3.c$y.I)) {
                    b2.r(this);
                    b2.g("select");
                    return b2.f(i2);
                }
                if (i2.k() && E3.c.d(i2.d().E(), G3.c$y.I)) {
                    b2.r(this);
                    if (b2.M(i2.d().E())) {
                        b2.g("select");
                        return b2.f(i2);
                    }
                    return false;
                }
                return b2.q0(i2, v);
            }
        };
        x = c7 = new c(){

            @Override
            boolean n(i i2, b b2) {
                block10: {
                    block7: {
                        block9: {
                            block8: {
                                block6: {
                                    if (!c.l(i2)) break block6;
                                    b2.P(i2.a());
                                    break block7;
                                }
                                if (!i2.h()) break block8;
                                b2.Q(i2.b());
                                break block7;
                            }
                            if (i2.i()) {
                                b2.r(this);
                                return false;
                            }
                            if (i2.l() && i2.e().E().equals((Object)"html")) {
                                return b2.q0(i2, m);
                            }
                            if (!i2.k() || !i2.d().E().equals((Object)"html")) break block9;
                            if (b2.b0()) {
                                b2.r(this);
                                return false;
                            }
                            b2.G0(A);
                            break block7;
                        }
                        if (!i2.j()) break block10;
                    }
                    return true;
                }
                b2.r(this);
                b2.G0(m);
                return b2.f(i2);
            }
        };
        y = c6 = new c(){

            @Override
            boolean n(i object, b b2) {
                block25: {
                    block21: {
                        block24: {
                            block23: {
                                block22: {
                                    block20: {
                                        if (!c.l((i)object)) break block20;
                                        b2.P(((i)object).a());
                                        break block21;
                                    }
                                    if (!((i)object).h()) break block22;
                                    b2.Q(((i)object).b());
                                    break block21;
                                }
                                if (((i)object).i()) {
                                    b2.r(this);
                                    return false;
                                }
                                if (!((i)object).l()) break block23;
                                i.h h2 = ((i)object).e();
                                object = h2.E();
                                object.getClass();
                                int n2 = -1;
                                switch (object.hashCode()) {
                                    default: {
                                        break;
                                    }
                                    case 1192721831: {
                                        if (!object.equals((Object)"noframes")) break;
                                        n2 = 3;
                                        break;
                                    }
                                    case 97692013: {
                                        if (!object.equals((Object)"frame")) break;
                                        n2 = 2;
                                        break;
                                    }
                                    case 3213227: {
                                        if (!object.equals((Object)"html")) break;
                                        n2 = 1;
                                        break;
                                    }
                                    case -1644953643: {
                                        if (!object.equals((Object)"frameset")) break;
                                        n2 = 0;
                                    }
                                }
                                switch (n2) {
                                    default: {
                                        b2.r(this);
                                        return false;
                                    }
                                    case 3: {
                                        return b2.q0(h2, j);
                                    }
                                    case 2: {
                                        b2.R(h2);
                                        break;
                                    }
                                    case 1: {
                                        return b2.q0(h2, m);
                                    }
                                    case 0: {
                                        b2.N(h2);
                                        break;
                                    }
                                }
                                break block21;
                            }
                            if (!((i)object).k() || !((i)object).d().E().equals((Object)"frameset")) break block24;
                            if (b2.a().s0().equals((Object)"html")) {
                                b2.r(this);
                                return false;
                            }
                            b2.l0();
                            if (!b2.b0() && !b2.a().s0().equals((Object)"frameset")) {
                                b2.G0(z);
                            }
                            break block21;
                        }
                        if (!((i)object).j()) break block25;
                        if (!b2.a().s0().equals((Object)"html")) {
                            b2.r(this);
                        }
                    }
                    return true;
                }
                b2.r(this);
                return false;
            }
        };
        z = c5 = new c(){

            @Override
            boolean n(i i2, b b2) {
                block10: {
                    block7: {
                        block9: {
                            block8: {
                                block6: {
                                    if (!c.l(i2)) break block6;
                                    b2.P(i2.a());
                                    break block7;
                                }
                                if (!i2.h()) break block8;
                                b2.Q(i2.b());
                                break block7;
                            }
                            if (i2.i()) {
                                b2.r(this);
                                return false;
                            }
                            if (i2.l() && i2.e().E().equals((Object)"html")) {
                                return b2.q0(i2, m);
                            }
                            if (!i2.k() || !i2.d().E().equals((Object)"html")) break block9;
                            b2.G0(B);
                            break block7;
                        }
                        if (i2.l() && i2.e().E().equals((Object)"noframes")) {
                            return b2.q0(i2, j);
                        }
                        if (!i2.j()) break block10;
                    }
                    return true;
                }
                b2.r(this);
                return false;
            }
        };
        A = c4 = new c(){

            @Override
            boolean n(i i2, b b2) {
                block4: {
                    block6: {
                        block3: {
                            block5: {
                                block2: {
                                    if (!i2.h()) break block2;
                                    b2.Q(i2.b());
                                    break block3;
                                }
                                if (i2.i() || i2.l() && i2.e().E().equals((Object)"html")) break block4;
                                if (!c.l(i2)) break block5;
                                F3.h h2 = b2.n0("html");
                                b2.P(i2.a());
                                b2.e.add((Object)h2);
                                b2.e.add((Object)h2.D0("body"));
                                break block3;
                            }
                            if (!i2.j()) break block6;
                        }
                        return true;
                    }
                    b2.r(this);
                    b2.G0(m);
                    return b2.f(i2);
                }
                return b2.q0(i2, m);
            }
        };
        B = c3 = new c(){

            @Override
            boolean n(i i2, b b2) {
                block6: {
                    block7: {
                        block5: {
                            block4: {
                                if (!i2.h()) break block4;
                                b2.Q(i2.b());
                                break block5;
                            }
                            if (i2.i() || c.l(i2) || i2.l() && i2.e().E().equals((Object)"html")) break block6;
                            if (!i2.j()) break block7;
                        }
                        return true;
                    }
                    if (i2.l() && i2.e().E().equals((Object)"noframes")) {
                        return b2.q0(i2, j);
                    }
                    b2.r(this);
                    return false;
                }
                return b2.q0(i2, m);
            }
        };
        C = c2 = new c(){

            @Override
            boolean n(i i2, b b2) {
                return true;
            }
        };
        E = new c[]{c24, c23, c22, c21, c20, c19, c18, c17, c16, c15, c14, c13, c12, c11, c10, c9, c8, c7, c6, c5, c4, c3, c2};
        D = String.valueOf((char)'\u0000');
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private c() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    /* synthetic */ c(k k2) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    private static void i(i.h h2, b b2) {
        b2.c.w(G3.l.k);
        b2.g0();
        b2.G0(n);
        b2.N(h2);
    }

    private static void j(i.h h2, b b2) {
        b2.c.w(G3.l.i);
        b2.g0();
        b2.G0(n);
        b2.N(h2);
    }

    private static boolean l(i i2) {
        if (i2.g()) {
            return E3.c.g(i2.a().q());
        }
        return false;
    }

    private static boolean m(String string) {
        return E3.c.g(string);
    }

    public static c valueOf(String string) {
        return (c)Enum.valueOf(c.class, (String)string);
    }

    public static c[] values() {
        return (c[])E.clone();
    }

    abstract boolean n(i var1, b var2);

    static final abstract class y {
        static final String[] A;
        static final String[] B;
        static final String[] C;
        static final String[] D;
        static final String[] E;
        static final String[] F;
        static final String[] G;
        static final String[] H;
        static final String[] I;
        static final String[] J;
        static final String[] K;
        static final String[] L;
        static final String[] a;
        static final String[] b;
        static final String[] c;
        static final String[] d;
        static final String[] e;
        static final String[] f;
        static final String[] g;
        static final String[] h;
        static final String[] i;
        static final String[] j;
        static final String[] k;
        static final String[] l;
        static final String[] m;
        static final String[] n;
        static final String[] o;
        static final String[] p;
        static final String[] q;
        static final String[] r;
        static final String[] s;
        static final String[] t;
        static final String[] u;
        static final String[] v;
        static final String[] w;
        static final String[] x;
        static final String[] y;
        static final String[] z;

        static {
            a = new String[]{"base", "basefont", "bgsound", "command", "link"};
            b = new String[]{"noframes", "style"};
            c = new String[]{"body", "br", "html"};
            d = new String[]{"body", "html"};
            e = new String[]{"body", "br", "head", "html"};
            f = new String[]{"basefont", "bgsound", "link", "meta", "noframes", "style"};
            g = new String[]{"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"};
            h = new String[]{"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
            i = new String[]{"h1", "h2", "h3", "h4", "h5", "h6"};
            j = new String[]{"address", "div", "p"};
            k = new String[]{"dd", "dt"};
            l = new String[]{"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
            m = new String[]{"applet", "marquee", "object"};
            n = new String[]{"area", "br", "embed", "img", "keygen", "wbr"};
            o = new String[]{"param", "source", "track"};
            p = new String[]{"action", "name", "prompt"};
            q = new String[]{"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
            r = new String[]{"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
            s = new String[]{"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
            t = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            u = new String[]{"tbody", "tfoot", "thead"};
            v = new String[]{"td", "th", "tr"};
            w = new String[]{"script", "style"};
            x = new String[]{"td", "th"};
            y = new String[]{"body", "caption", "col", "colgroup", "html"};
            z = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            A = new String[]{"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
            B = new String[]{"body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
            C = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            D = new String[]{"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
            E = new String[]{"body", "caption", "col", "colgroup", "html", "td", "th", "tr"};
            F = new String[]{"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
            G = new String[]{"body", "caption", "col", "colgroup", "html", "td", "th"};
            H = new String[]{"input", "keygen", "textarea"};
            I = new String[]{"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
            J = new String[]{"tbody", "tfoot", "thead"};
            K = new String[]{"head", "noscript"};
            L = new String[]{"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        }
    }
}

