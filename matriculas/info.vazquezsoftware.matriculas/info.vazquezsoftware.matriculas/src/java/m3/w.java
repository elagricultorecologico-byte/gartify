/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.r
 *  java.lang.Cloneable
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.X509TrustManager
 */
package m3;

import V2.g;
import androidx.activity.r;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import m3.c;
import m3.e;
import m3.f;
import m3.j;
import m3.k;
import m3.m;
import m3.o;
import m3.p;
import m3.q;
import m3.x;
import m3.y;
import r3.h;
import v3.k;
import y3.c;
import y3.d;

public class w
implements Cloneable {
    public static final b J = new b(null);
    private static final List K = n3.d.w((Object[])new x[]{m3.x.l, m3.x.j});
    private static final List L = n3.d.w(m3.k.i, m3.k.k);
    private final f A;
    private final y3.c B;
    private final int C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private final long H;
    private final h I;
    private final o g;
    private final j h;
    private final List i;
    private final List j;
    private final q.c k;
    private final boolean l;
    private final m3.b m;
    private final boolean n;
    private final boolean o;
    private final m p;
    private final p q;
    private final Proxy r;
    private final ProxySelector s;
    private final m3.b t;
    private final SocketFactory u;
    private final SSLSocketFactory v;
    private final X509TrustManager w;
    private final List x;
    private final List y;
    private final HostnameVerifier z;

    public w() {
        this(new a());
    }

    public w(a object) {
        List list;
        Object object2;
        Object object3;
        V2.k.e(object, "builder");
        this.g = ((a)object).l();
        this.h = ((a)object).i();
        this.i = n3.d.S(((a)object).r());
        this.j = n3.d.S(((a)object).t());
        this.k = ((a)object).n();
        this.l = ((a)object).A();
        this.m = ((a)object).c();
        this.n = ((a)object).o();
        this.o = ((a)object).p();
        this.p = ((a)object).k();
        ((a)object).d();
        this.q = ((a)object).m();
        this.r = ((a)object).w();
        if (((a)object).w() != null) {
            object3 = x3.a.a;
        } else {
            object3 = ((a)object).y();
            object2 = object3;
            if (object3 == null) {
                object2 = ProxySelector.getDefault();
            }
            object3 = object2;
            if (object2 == null) {
                object3 = x3.a.a;
            }
        }
        this.s = object3;
        this.t = ((a)object).x();
        this.u = ((a)object).C();
        this.x = list = ((a)object).j();
        this.y = ((a)object).v();
        this.z = ((a)object).q();
        this.C = ((a)object).e();
        this.D = ((a)object).h();
        this.E = ((a)object).z();
        this.F = ((a)object).E();
        this.G = ((a)object).u();
        this.H = ((a)object).s();
        object3 = ((a)object).B();
        object2 = object3;
        if (object3 == null) {
            object2 = new h();
        }
        this.I = object2;
        if (!androidx.activity.r.a((Object)list) || !list.isEmpty()) {
            object2 = list.iterator();
            while (object2.hasNext()) {
                if (!((k)object2.next()).f()) continue;
                if (((a)object).D() != null) {
                    this.v = ((a)object).D();
                    object2 = ((a)object).f();
                    V2.k.b(object2);
                    this.B = object2;
                    object3 = ((a)object).F();
                    V2.k.b(object3);
                    this.w = object3;
                    object = ((a)object).g();
                    V2.k.b(object2);
                    this.A = ((f)object).e((y3.c)object2);
                } else {
                    object3 = v3.k.a;
                    object2 = ((k.a)object3).g().o();
                    this.w = object2;
                    object3 = ((k.a)object3).g();
                    V2.k.b(object2);
                    this.v = ((v3.k)object3).n((X509TrustManager)object2);
                    object3 = y3.c.a;
                    V2.k.b(object2);
                    object2 = ((c.a)object3).a((X509TrustManager)object2);
                    this.B = object2;
                    object = ((a)object).g();
                    V2.k.b(object2);
                    this.A = ((f)object).e((y3.c)object2);
                }
                break;
            }
        } else {
            this.v = null;
            this.B = null;
            this.w = null;
            this.A = f.d;
        }
        this.G();
    }

    private final void G() {
        block11: {
            block12: {
                block13: {
                    block14: {
                        block15: {
                            block16: {
                                block10: {
                                    if (this.i.contains(null)) break block11;
                                    if (this.j.contains(null)) break block12;
                                    List list = this.x;
                                    if (!androidx.activity.r.a((Object)list) || !list.isEmpty()) {
                                        list = list.iterator();
                                        while (list.hasNext()) {
                                            if (!((k)list.next()).f()) continue;
                                            if (this.v != null) {
                                                if (this.B != null) {
                                                    if (this.w == null) {
                                                        throw new IllegalStateException("x509TrustManager == null");
                                                    }
                                                    break block10;
                                                }
                                                throw new IllegalStateException("certificateChainCleaner == null");
                                            }
                                            throw new IllegalStateException("sslSocketFactory == null");
                                        }
                                    }
                                    if (this.v != null) break block13;
                                    if (this.B != null) break block14;
                                    if (this.w != null) break block15;
                                    if (!V2.k.a(this.A, f.d)) break block16;
                                }
                                return;
                            }
                            throw new IllegalStateException("Check failed.");
                        }
                        throw new IllegalStateException("Check failed.");
                    }
                    throw new IllegalStateException("Check failed.");
                }
                throw new IllegalStateException("Check failed.");
            }
            throw new IllegalStateException(V2.k.j("Null network interceptor: ", this.v()).toString());
        }
        throw new IllegalStateException(V2.k.j("Null interceptor: ", this.u()).toString());
    }

    public final m3.b A() {
        return this.t;
    }

    public final ProxySelector B() {
        return this.s;
    }

    public final int C() {
        return this.E;
    }

    public final boolean D() {
        return this.l;
    }

    public final SocketFactory E() {
        return this.u;
    }

    public final SSLSocketFactory F() {
        SSLSocketFactory sSLSocketFactory = this.v;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int H() {
        return this.F;
    }

    public final m3.b c() {
        return this.m;
    }

    public Object clone() {
        return super.clone();
    }

    public final c d() {
        return null;
    }

    public final int e() {
        return this.C;
    }

    public final f g() {
        return this.A;
    }

    public final int h() {
        return this.D;
    }

    public final j i() {
        return this.h;
    }

    public final List k() {
        return this.x;
    }

    public final m l() {
        return this.p;
    }

    public final o m() {
        return this.g;
    }

    public final p n() {
        return this.q;
    }

    public final q.c o() {
        return this.k;
    }

    public final boolean q() {
        return this.n;
    }

    public final boolean r() {
        return this.o;
    }

    public final h s() {
        return this.I;
    }

    public final HostnameVerifier t() {
        return this.z;
    }

    public final List u() {
        return this.i;
    }

    public final List v() {
        return this.j;
    }

    public e w(y y2) {
        V2.k.e(y2, "request");
        return new r3.e(this, y2, false);
    }

    public final int x() {
        return this.G;
    }

    public final List y() {
        return this.y;
    }

    public final Proxy z() {
        return this.r;
    }

    public static final class a {
        private int A;
        private long B;
        private h C;
        private o a = new o();
        private j b = new j();
        private final List c = new ArrayList();
        private final List d = new ArrayList();
        private q.c e = n3.d.g(m3.q.b);
        private boolean f = true;
        private m3.b g;
        private boolean h;
        private boolean i;
        private m j;
        private p k;
        private Proxy l;
        private ProxySelector m;
        private m3.b n;
        private SocketFactory o;
        private SSLSocketFactory p;
        private X509TrustManager q;
        private List r;
        private List s;
        private HostnameVerifier t;
        private f u;
        private y3.c v;
        private int w;
        private int x;
        private int y;
        private int z;

        public a() {
            Object object = m3.b.b;
            this.g = object;
            this.h = true;
            this.i = true;
            this.j = m3.m.b;
            this.k = m3.p.b;
            this.n = object;
            object = SocketFactory.getDefault();
            V2.k.d(object, "getDefault()");
            this.o = object;
            object = J;
            this.r = ((b)object).a();
            this.s = ((b)object).b();
            this.t = y3.d.a;
            this.u = m3.f.d;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.B = 1024L;
        }

        public final boolean A() {
            return this.f;
        }

        public final h B() {
            return this.C;
        }

        public final SocketFactory C() {
            return this.o;
        }

        public final SSLSocketFactory D() {
            return this.p;
        }

        public final int E() {
            return this.z;
        }

        public final X509TrustManager F() {
            return this.q;
        }

        public final a G(long l2, TimeUnit timeUnit) {
            V2.k.e(timeUnit, "unit");
            this.I(n3.d.k("timeout", l2, timeUnit));
            return this;
        }

        public final void H(int n2) {
            this.x = n2;
        }

        public final void I(int n2) {
            this.y = n2;
        }

        public final void J(int n2) {
            this.z = n2;
        }

        public final a K(long l2, TimeUnit timeUnit) {
            V2.k.e(timeUnit, "unit");
            this.J(n3.d.k("timeout", l2, timeUnit));
            return this;
        }

        public final w a() {
            return new w(this);
        }

        public final a b(long l2, TimeUnit timeUnit) {
            V2.k.e(timeUnit, "unit");
            this.H(n3.d.k("timeout", l2, timeUnit));
            return this;
        }

        public final m3.b c() {
            return this.g;
        }

        public final c d() {
            return null;
        }

        public final int e() {
            return this.w;
        }

        public final y3.c f() {
            return this.v;
        }

        public final f g() {
            return this.u;
        }

        public final int h() {
            return this.x;
        }

        public final j i() {
            return this.b;
        }

        public final List j() {
            return this.r;
        }

        public final m k() {
            return this.j;
        }

        public final o l() {
            return this.a;
        }

        public final p m() {
            return this.k;
        }

        public final q.c n() {
            return this.e;
        }

        public final boolean o() {
            return this.h;
        }

        public final boolean p() {
            return this.i;
        }

        public final HostnameVerifier q() {
            return this.t;
        }

        public final List r() {
            return this.c;
        }

        public final long s() {
            return this.B;
        }

        public final List t() {
            return this.d;
        }

        public final int u() {
            return this.A;
        }

        public final List v() {
            return this.s;
        }

        public final Proxy w() {
            return this.l;
        }

        public final m3.b x() {
            return this.n;
        }

        public final ProxySelector y() {
            return this.m;
        }

        public final int z() {
            return this.y;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        public final List a() {
            return L;
        }

        public final List b() {
            return K;
        }
    }
}

