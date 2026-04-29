/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.net.ProtocolException
 */
package s3;

import V2.k;
import b3.h;
import java.net.ProtocolException;
import m3.A;
import m3.B;
import m3.u;
import m3.y;
import m3.z;
import n3.d;
import r3.c;
import s3.f;
import s3.g;
import z3.l;

public final class b
implements u {
    private final boolean a;

    public b(boolean bl) {
        this.a = bl;
    }

    @Override
    public A a(u.a object) {
        int n2;
        int n3;
        Object object2;
        int n4;
        k.e(object, "chain");
        object = (g)object;
        c c2 = ((g)object).g();
        k.b(c2);
        y y2 = ((g)object).i();
        z z2 = y2.a();
        long l2 = System.currentTimeMillis();
        c2.t(y2);
        boolean bl = f.a(y2.g());
        Object var9_7 = null;
        if (bl && z2 != null) {
            if (h.u("100-continue", y2.d("Expect"), true)) {
                c2.f();
                object = c2.p(true);
                c2.r();
                n4 = 0;
            } else {
                n4 = 1;
                object = null;
            }
            if (object == null) {
                if (z2.d()) {
                    c2.f();
                    z2.f(l.a(c2.c(y2, true)));
                    object2 = object;
                    n3 = n4;
                } else {
                    object2 = l.a(c2.c(y2, false));
                    z2.f((z3.c)object2);
                    object2.close();
                    object2 = object;
                    n3 = n4;
                }
            } else {
                c2.n();
                object2 = object;
                n3 = n4;
                if (!c2.h().v()) {
                    c2.m();
                    object2 = object;
                    n3 = n4;
                }
            }
        } else {
            c2.n();
            n3 = 1;
            object2 = null;
        }
        if (z2 == null || !z2.d()) {
            c2.e();
        }
        object = object2;
        n4 = n3;
        if (object2 == null) {
            object2 = c2.p(false);
            k.b(object2);
            object = object2;
            n4 = n3;
            if (n3 != 0) {
                c2.r();
                n4 = 0;
                object = object2;
            }
        }
        object = ((A.a)object).s(y2).j(c2.h().r()).t(l2).r(System.currentTimeMillis()).c();
        n3 = n2 = ((A)object).p();
        if (n2 == 100) {
            object = c2.p(false);
            k.b(object);
            if (n4 != 0) {
                c2.r();
            }
            object = ((A.a)object).s(y2).j(c2.h().r()).t(l2).r(System.currentTimeMillis()).c();
            n3 = ((A)object).p();
        }
        c2.q((A)object);
        object = this.a && n3 == 101 ? ((A)object).Z().b(d.c).c() : ((A)object).Z().b(c2.o((A)object)).c();
        if (h.u("close", ((A)object).i0().d("Connection"), true) || h.u("close", A.L((A)object, "Connection", null, 2, null), true)) {
            c2.m();
        }
        if ((n3 == 204 || n3 == 205) && (l2 = (object2 = ((A)object).a()) == null ? -1L : ((B)object2).i()) > 0L) {
            object2 = new StringBuilder();
            object2.append("HTTP ");
            object2.append(n3);
            object2.append(" had non-zero Content-Length: ");
            object = ((A)object).a();
            object = object == null ? var9_7 : Long.valueOf((long)((B)object).i());
            object2.append(object);
            throw new ProtocolException(object2.toString());
        }
        return object;
    }
}

