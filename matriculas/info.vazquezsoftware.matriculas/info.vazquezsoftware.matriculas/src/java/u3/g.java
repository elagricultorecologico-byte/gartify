/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.net.ProtocolException
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.TimeUnit
 */
package u3;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import m3.A;
import m3.s;
import m3.w;
import s3.d;
import s3.e;
import s3.k;
import u3.b;
import u3.c;
import u3.f;
import u3.i;
import z3.v;
import z3.x;
import z3.y;

public final class g
implements d {
    public static final a g = new a(null);
    private static final List h = n3.d.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    private static final List i = n3.d.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    private final r3.f a;
    private final s3.g b;
    private final f c;
    private volatile i d;
    private final m3.x e;
    private volatile boolean f;

    public g(w object, r3.f f2, s3.g g2, f f3) {
        V2.k.e(object, "client");
        V2.k.e(f2, "connection");
        V2.k.e(g2, "chain");
        V2.k.e(f3, "http2Connection");
        this.a = f2;
        this.b = g2;
        this.c = f3;
        f2 = object.y();
        object = m3.x.m;
        if (!f2.contains(object)) {
            object = m3.x.l;
        }
        this.e = object;
    }

    @Override
    public x a(A object) {
        V2.k.e(object, "response");
        object = this.d;
        V2.k.b(object);
        return ((i)object).p();
    }

    @Override
    public void b(m3.y object) {
        V2.k.e(object, "request");
        if (this.d != null) {
            return;
        }
        boolean bl = ((m3.y)object).a() != null;
        object = g.a((m3.y)object);
        this.d = this.c.U0((List)object, bl);
        if (!this.f) {
            object = this.d;
            V2.k.b(object);
            Object object2 = ((i)object).v();
            long l2 = this.b.h();
            object = TimeUnit.MILLISECONDS;
            ((y)object2).g(l2, (TimeUnit)object);
            object2 = this.d;
            V2.k.b(object2);
            ((i)object2).G().g(this.b.j(), (TimeUnit)object);
            return;
        }
        object = this.d;
        V2.k.b(object);
        ((i)object).f(u3.b.q);
        throw new IOException("Canceled");
    }

    @Override
    public void c() {
        i i2 = this.d;
        V2.k.b(i2);
        i2.n().close();
    }

    @Override
    public void cancel() {
        this.f = true;
        i i2 = this.d;
        if (i2 == null) {
            return;
        }
        i2.f(u3.b.q);
    }

    @Override
    public v d(m3.y object, long l2) {
        V2.k.e(object, "request");
        object = this.d;
        V2.k.b(object);
        return ((i)object).n();
    }

    @Override
    public long e(A a2) {
        V2.k.e(a2, "response");
        if (!s3.e.b(a2)) {
            return 0L;
        }
        return n3.d.v(a2);
    }

    @Override
    public void f() {
        this.c.flush();
    }

    @Override
    public A.a g(boolean bl) {
        Object object = this.d;
        V2.k.b(object);
        object = ((i)object).E();
        object = g.b((s)object, this.e);
        if (bl && ((A.a)object).h() == 100) {
            return null;
        }
        return object;
    }

    @Override
    public r3.f h() {
        return this.a;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g2) {
            this();
        }

        public final List a(m3.y object) {
            V2.k.e(object, "request");
            s s2 = ((m3.y)object).e();
            ArrayList arrayList = new ArrayList(s2.size() + 4);
            arrayList.add((Object)new c(u3.c.g, ((m3.y)object).g()));
            arrayList.add((Object)new c(u3.c.h, s3.i.a.c(((m3.y)object).i())));
            String string = ((m3.y)object).d("Host");
            if (string != null) {
                arrayList.add((Object)new c(u3.c.j, string));
            }
            arrayList.add((Object)new c(u3.c.i, ((m3.y)object).i().p()));
            int n2 = s2.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                string = s2.f(i2);
                object = Locale.US;
                V2.k.d(object, "US");
                object = string.toLowerCase((Locale)object);
                V2.k.d(object, "this as java.lang.String).toLowerCase(locale)");
                if (h.contains(object) && (!V2.k.a(object, "te") || !V2.k.a(s2.i(i2), "trailers"))) continue;
                arrayList.add((Object)new c((String)object, s2.i(i2)));
            }
            return arrayList;
        }

        /*
         * Enabled aggressive block sorting
         */
        public final A.a b(s s2, m3.x x2) {
            V2.k.e(s2, "headerBlock");
            V2.k.e((Object)x2, "protocol");
            s.a a2 = new s.a();
            int n2 = s2.size();
            k k2 = null;
            for (int i2 = 0; i2 < n2; ++i2) {
                k k3;
                String string = s2.f(i2);
                String string2 = s2.i(i2);
                if (V2.k.a(string, ":status")) {
                    k3 = k.d.a(V2.k.j("HTTP/1.1 ", string2));
                } else {
                    k3 = k2;
                    if (!i.contains((Object)string)) {
                        a2.c(string, string2);
                        k3 = k2;
                    }
                }
                k2 = k3;
            }
            if (k2 != null) {
                return new A.a().q(x2).g(k2.b).n(k2.c).l(a2.d());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }
}

