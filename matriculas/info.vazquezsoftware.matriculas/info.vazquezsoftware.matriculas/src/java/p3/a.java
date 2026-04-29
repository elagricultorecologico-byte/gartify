/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 */
package p3;

import V2.g;
import V2.k;
import b3.h;
import java.io.Closeable;
import m3.A;
import m3.B;
import m3.c;
import m3.e;
import m3.q;
import m3.s;
import m3.u;
import m3.x;
import m3.y;
import n3.d;
import p3.b;

public final class a
implements u {
    public static final a a = new a(null);

    public a(c c2) {
    }

    @Override
    public A a(u.a object) {
        k.e(object, "chain");
        e e2 = object.call();
        Object object2 = new b.b(System.currentTimeMillis(), object.b(), null).b();
        y y2 = ((b)object2).b();
        A a2 = ((b)object2).a();
        object2 = e2 instanceof r3.e ? (r3.e)e2 : null;
        object2 = object2 == null ? null : ((r3.e)object2).m();
        Object object3 = object2;
        if (object2 == null) {
            object3 = q.b;
        }
        if (y2 == null && a2 == null) {
            object = new A.a().s(object.b()).q(x.j).g(504).n("Unsatisfiable Request (only-if-cached)").b(d.c).t(-1L).r(System.currentTimeMillis()).c();
            ((q)object3).z(e2, (A)object);
            return object;
        }
        if (y2 == null) {
            k.b(a2);
            object = a2.Z().d(p3.a.a.f(a2)).c();
            ((q)object3).b(e2, (A)object);
            return object;
        }
        if (a2 != null) {
            ((q)object3).a(e2, a2);
        }
        object = object.a(y2);
        if (a2 != null) {
            if (object == null || ((A)object).p() != 304) {
                object2 = a2.a();
                if (object2 != null) {
                    d.m((Closeable)object2);
                }
            } else {
                object3 = a2.Z();
                object2 = a;
                ((A.a)object3).l(((a)object2).c(a2.M(), ((A)object).M())).t(((A)object).k0()).r(((A)object).c0()).d(((a)object2).f(a2)).o(((a)object2).f((A)object)).c();
                object = ((A)object).a();
                k.b(object);
                ((B)object).close();
                k.b(null);
                throw null;
            }
        }
        k.b(object);
        object2 = ((A)object).Z();
        object3 = a;
        return ((A.a)object2).d(((a)object3).f(a2)).o(((a)object3).f((A)object)).c();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        private final s c(s object, s s2) {
            int n2;
            s.a a2 = new s.a();
            int n3 = ((s)object).size();
            int n4 = 0;
            for (n2 = 0; n2 < n3; ++n2) {
                String string = ((s)object).f(n2);
                String string2 = ((s)object).i(n2);
                if (h.u("Warning", string, true) && h.E(string2, "1", false, 2, null) || !this.d(string) && this.e(string) && s2.c(string) != null) continue;
                a2.c(string, string2);
            }
            n3 = s2.size();
            for (n2 = n4; n2 < n3; ++n2) {
                object = s2.f(n2);
                if (this.d((String)object) || !this.e((String)object)) continue;
                a2.c((String)object, s2.i(n2));
            }
            return a2.d();
        }

        private final boolean d(String string) {
            return h.u("Content-Length", string, true) || h.u("Content-Encoding", string, true) || h.u("Content-Type", string, true);
            {
            }
        }

        private final boolean e(String string) {
            return !h.u("Connection", string, true) && !h.u("Keep-Alive", string, true) && !h.u("Proxy-Authenticate", string, true) && !h.u("Proxy-Authorization", string, true) && !h.u("TE", string, true) && !h.u("Trailers", string, true) && !h.u("Transfer-Encoding", string, true) && !h.u("Upgrade", string, true);
        }

        private final A f(A a2) {
            B b2 = a2 == null ? null : a2.a();
            A a3 = a2;
            if (b2 != null) {
                a3 = a2.Z().b(null).c();
            }
            return a3;
        }
    }
}

