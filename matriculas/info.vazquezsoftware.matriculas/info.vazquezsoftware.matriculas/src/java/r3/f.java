/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.r
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.ConnectException
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.Socket
 *  java.net.UnknownServiceException
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLSession
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 */
package r3;

import I2.o;
import V2.k;
import b3.h;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import m3.A;
import m3.C;
import m3.D;
import m3.q;
import m3.r;
import m3.t;
import m3.w;
import m3.x;
import m3.y;
import r3.e;
import r3.g;
import r3.i;
import s3.d;
import u3.f;
import u3.m;
import u3.n;
import y3.c;
import z3.l;

public final class f
extends f.c
implements m3.i {
    public static final a t = new a(null);
    private final g c;
    private final C d;
    private Socket e;
    private Socket f;
    private r g;
    private x h;
    private u3.f i;
    private z3.d j;
    private z3.c k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final List r;
    private long s;

    public f(g g2, C c2) {
        V2.k.e(g2, "connectionPool");
        V2.k.e(c2, "route");
        this.c = g2;
        this.d = c2;
        this.q = 1;
        this.r = new ArrayList();
        this.s = Long.MAX_VALUE;
    }

    private final boolean A(List list) {
        if (androidx.activity.r.a((Object)list) && list.isEmpty()) {
            return false;
        }
        for (C c2 : list) {
            Proxy.Type type = c2.b().type();
            if (type != (list = Proxy.Type.DIRECT) || this.d.b().type() != list || !V2.k.a(this.d.d(), c2.d())) continue;
            return true;
        }
        return false;
    }

    private final void E(int n2) {
        Socket socket = this.f;
        V2.k.b(socket);
        Object object = this.j;
        V2.k.b(object);
        z3.c c2 = this.k;
        V2.k.b(c2);
        socket.setSoTimeout(0);
        object = new f.a(true, q3.e.i).s(socket, this.d.a().l().h(), (z3.d)object, c2).k(this).l(n2).a();
        this.i = object;
        this.q = u3.f.I.a().d();
        u3.f.h1((u3.f)object, false, null, 3, null);
    }

    private final boolean F(t t2) {
        if (n3.d.h && !Thread.holdsLock((Object)this)) {
            t2 = new StringBuilder();
            t2.append("Thread ");
            t2.append(Thread.currentThread().getName());
            t2.append(" MUST hold lock on ");
            t2.append(this);
            throw new AssertionError((Object)t2.toString());
        }
        Object object = this.d.a().l();
        if (t2.l() != ((t)object).l()) {
            return false;
        }
        if (V2.k.a(t2.h(), ((t)object).h())) {
            return true;
        }
        if (!this.m && (object = this.g) != null) {
            V2.k.b(object);
            if (this.e(t2, (r)object)) {
                return true;
            }
        }
        return false;
    }

    private final boolean e(t t2, r r2) {
        return !(r2 = r2.d()).isEmpty() && y3.d.a.e(t2.h(), (X509Certificate)r2.get(0));
    }

    private final void h(int n2, int n3, m3.e e2, q object) {
        Proxy proxy = this.d.b();
        m3.a a2 = this.d.a();
        Proxy.Type type = proxy.type();
        int n4 = type == null ? -1 : r3.f$b.a[type.ordinal()];
        if (n4 != 1 && n4 != 2) {
            type = new Socket(proxy);
        } else {
            type = a2.j().createSocket();
            V2.k.b(type);
        }
        this.e = type;
        object.i(e2, this.d.d(), proxy);
        type.setSoTimeout(n3);
        try {
            v3.k.a.g().f((Socket)type, this.d.d(), n2);
        }
        catch (ConnectException connectException) {
            object = new ConnectException(V2.k.j("Failed to connect to ", this.d.d()));
            object.initCause(connectException);
            throw object;
        }
        try {
            this.j = z3.l.b(z3.l.f((Socket)type));
            this.k = z3.l.a(z3.l.d((Socket)type));
            return;
        }
        catch (NullPointerException nullPointerException) {
            if (!V2.k.a(nullPointerException.getMessage(), "throw with null exception")) {
                return;
            }
            throw new IOException((Throwable)nullPointerException);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void i(r3.b object) {
        void var1_4;
        SSLSocketFactory sSLSocketFactory;
        block12: {
            m3.k k2;
            block10: {
                r r2;
                SSLPeerUnverifiedException sSLPeerUnverifiedException;
                U2.a a2;
                block11: {
                    a2 = this.d.a();
                    sSLSocketFactory = ((m3.a)((Object)a2)).k();
                    k2 = null;
                    sSLPeerUnverifiedException = null;
                    V2.k.b(sSLSocketFactory);
                    sSLSocketFactory = sSLSocketFactory.createSocket(this.e, ((m3.a)((Object)a2)).l().h(), ((m3.a)((Object)a2)).l().l(), true);
                    if (sSLSocketFactory == null) break block10;
                    sSLSocketFactory = (SSLSocket)sSLSocketFactory;
                    try {
                        k2 = object.a((SSLSocket)sSLSocketFactory);
                        if (!k2.h()) break block11;
                        v3.k.a.g().e((SSLSocket)sSLSocketFactory, ((m3.a)((Object)a2)).l().h(), ((m3.a)((Object)a2)).f());
                    }
                    catch (Throwable throwable) {
                        break block12;
                    }
                }
                sSLSocketFactory.startHandshake();
                object = sSLSocketFactory.getSession();
                Object object2 = m3.r.e;
                V2.k.d(object, "sslSocketSession");
                object2 = ((r.a)object2).a((SSLSession)object);
                HostnameVerifier hostnameVerifier = ((m3.a)((Object)a2)).e();
                V2.k.b(hostnameVerifier);
                if (!hostnameVerifier.verify(((m3.a)((Object)a2)).l().h(), (SSLSession)object)) {
                    object = ((r)object2).d();
                    if (!object.isEmpty()) {
                        k2 = (X509Certificate)object.get(0);
                        sSLPeerUnverifiedException = new StringBuilder();
                        sSLPeerUnverifiedException.append("\n              |Hostname ");
                        sSLPeerUnverifiedException.append(((m3.a)((Object)a2)).l().h());
                        sSLPeerUnverifiedException.append(" not verified:\n              |    certificate: ");
                        sSLPeerUnverifiedException.append(m3.f.c.a((Certificate)k2));
                        sSLPeerUnverifiedException.append("\n              |    DN: ");
                        sSLPeerUnverifiedException.append((Object)k2.getSubjectDN().getName());
                        sSLPeerUnverifiedException.append("\n              |    subjectAltNames: ");
                        sSLPeerUnverifiedException.append((Object)y3.d.a.a((X509Certificate)k2));
                        sSLPeerUnverifiedException.append("\n              ");
                        object = new SSLPeerUnverifiedException(b3.h.l(sSLPeerUnverifiedException.toString(), null, 1, null));
                        throw object;
                    }
                    object = new StringBuilder();
                    object.append("Hostname ");
                    object.append(((m3.a)((Object)a2)).l().h());
                    object.append(" not verified (no certificates)");
                    sSLPeerUnverifiedException = new SSLPeerUnverifiedException(object.toString());
                    throw sSLPeerUnverifiedException;
                }
                object = ((m3.a)((Object)a2)).a();
                V2.k.b(object);
                D d2 = ((r)object2).e();
                m3.h h2 = ((r)object2).a();
                hostnameVerifier = ((r)object2).c();
                U2.a a3 = new U2.a((m3.f)object, (r)object2, (m3.a)((Object)a2)){
                    final m3.f h;
                    final r i;
                    final m3.a j;
                    {
                        this.h = f2;
                        this.i = r2;
                        this.j = a2;
                        super(0);
                    }

                    public final List b() {
                        c c2 = this.h.d();
                        V2.k.b(c2);
                        return c2.a(this.i.d(), this.j.l().h());
                    }
                };
                this.g = r2 = new r(d2, h2, (List)hostnameVerifier, a3);
                object2 = ((m3.a)((Object)a2)).l().h();
                a2 = new U2.a(this){
                    final f h;
                    {
                        this.h = f2;
                        super(0);
                    }

                    public final List b() {
                        r r2 = this.h.g;
                        V2.k.b(r2);
                        List list = r2.d();
                        r2 = new ArrayList(I2.o.o((Iterable)list, 10));
                        list = list.iterator();
                        while (list.hasNext()) {
                            r2.add((X509Certificate)((Certificate)list.next()));
                        }
                        return r2;
                    }
                };
                ((m3.f)object).b((String)object2, a2);
                object = sSLPeerUnverifiedException;
                if (k2.h()) {
                    object = v3.k.a.g().g((SSLSocket)sSLSocketFactory);
                }
                this.f = sSLSocketFactory;
                this.j = z3.l.b(z3.l.f((Socket)sSLSocketFactory));
                this.k = z3.l.a(z3.l.d((Socket)sSLSocketFactory));
                object = object != null ? x.h.a((String)object) : x.j;
                this.h = object;
                v3.k.a.g().b((SSLSocket)sSLSocketFactory);
                return;
            }
            try {
                object = new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                throw object;
            }
            catch (Throwable throwable) {
                sSLSocketFactory = k2;
            }
        }
        if (sSLSocketFactory != null) {
            v3.k.a.g().b((SSLSocket)sSLSocketFactory);
        }
        if (sSLSocketFactory == null) {
            throw var1_4;
        }
        n3.d.n((Socket)sSLSocketFactory);
        throw var1_4;
    }

    private final void j(int n2, int n3, int n4, m3.e e2, q q2) {
        y y2 = this.l();
        t t2 = y2.i();
        int n5 = 0;
        while (n5 < 21) {
            ++n5;
            this.h(n2, n3, e2, q2);
            y2 = this.k(n3, n4, y2, t2);
            if (y2 == null) break;
            Socket socket = this.e;
            if (socket != null) {
                n3.d.n(socket);
            }
            this.e = null;
            this.k = null;
            this.j = null;
            q2.g(e2, this.d.d(), this.d.b(), null);
        }
    }

    private final y k(int n2, int n3, y y2, t object) {
        z3.c c2;
        Object object2;
        block2: {
            Object object3;
            block3: {
                block4: {
                    object2 = new StringBuilder();
                    object2.append("CONNECT ");
                    object2.append(n3.d.Q((t)object, true));
                    object2.append(" HTTP/1.1");
                    object = object2.toString();
                    do {
                        object2 = this.j;
                        V2.k.b(object2);
                        c2 = this.k;
                        V2.k.b(c2);
                        t3.b b2 = new t3.b(null, this, (z3.d)object2, c2);
                        z3.y y3 = object2.h();
                        long l2 = n2;
                        object3 = TimeUnit.MILLISECONDS;
                        y3.g(l2, (TimeUnit)object3);
                        c2.h().g(n3, (TimeUnit)object3);
                        b2.A(y2.e(), (String)object);
                        b2.c();
                        object3 = b2.g(false);
                        V2.k.b(object3);
                        object3 = ((A.a)object3).s(y2).c();
                        b2.z((A)object3);
                        int n4 = ((A)object3).p();
                        if (n4 == 200) break block2;
                        if (n4 != 407) break block3;
                        y2 = this.d.a().h().a(this.d, (A)object3);
                        if (y2 == null) break block4;
                    } while (!b3.h.u("close", A.L((A)object3, "Connection", null, 2, null), true));
                    return y2;
                }
                throw new IOException("Failed to authenticate with proxy");
            }
            throw new IOException(V2.k.j("Unexpected response code for CONNECT: ", ((A)object3).p()));
        }
        if (object2.g().O() && c2.g().O()) {
            return null;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private final y l() {
        y y2 = new y.a().n(this.d.a().l()).f("CONNECT", null).d("Host", n3.d.Q(this.d.a().l(), true)).d("Proxy-Connection", "Keep-Alive").d("User-Agent", "okhttp/4.10.0").b();
        Object object = new A.a().s(y2).q(x.j).g(407).n("Preemptive Authenticate").b(n3.d.c).t(-1L).r(-1L).k("Proxy-Authenticate", "OkHttp-Preemptive").c();
        object = this.d.a().h().a(this.d, (A)object);
        if (object == null) {
            return y2;
        }
        return object;
    }

    private final void m(r3.b object, int n2, m3.e e2, q q2) {
        if (this.d.a().k() == null) {
            e2 = this.d.a().f();
            if (e2.contains(object = x.m)) {
                this.f = this.e;
                this.h = object;
                this.E(n2);
                return;
            }
            this.f = this.e;
            this.h = x.j;
            return;
        }
        q2.B(e2);
        this.i((r3.b)object);
        q2.A(e2, this.g);
        if (this.h == x.l) {
            this.E(n2);
        }
    }

    public final void B(long l2) {
        this.s = l2;
    }

    public final void C(boolean bl) {
        this.l = bl;
    }

    public Socket D() {
        Socket socket = this.f;
        V2.k.b(socket);
        return socket;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void G(e e2, IOException iOException) {
        f f2 = this;
        synchronized (f2) {
            Throwable throwable2;
            block11: {
                block10: {
                    block8: {
                        block9: {
                            try {
                                int n2;
                                V2.k.e(e2, "call");
                                if (!(iOException instanceof n)) break block8;
                                if (((n)iOException).g != u3.b.p) break block9;
                                this.p = n2 = this.p + 1;
                                if (n2 > 1) {
                                    this.l = true;
                                    ++this.n;
                                }
                                break block10;
                            }
                            catch (Throwable throwable2) {
                                break block11;
                            }
                        }
                        if (((n)iOException).g != u3.b.q || !e2.r()) {
                            this.l = true;
                            ++this.n;
                        }
                        break block10;
                    }
                    if (!this.v() || iOException instanceof u3.a) {
                        this.l = true;
                        if (this.o == 0) {
                            if (iOException != null) {
                                this.g(e2.k(), this.d, iOException);
                            }
                            ++this.n;
                        }
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(u3.f f2, m m2) {
        f f3 = this;
        synchronized (f3) {
            V2.k.e(f2, "connection");
            V2.k.e(m2, "settings");
            this.q = m2.d();
            return;
        }
    }

    @Override
    public void b(u3.i i2) {
        V2.k.e(i2, "stream");
        i2.d(u3.b.p, null);
    }

    public final void d() {
        Socket socket = this.e;
        if (socket == null) {
            return;
        }
        n3.d.n(socket);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void f(int var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5, m3.e var6_6, q var7_7) {
        V2.k.e(var6_6, "call");
        V2.k.e(var7_7, "eventListener");
        if (this.h != null) {
            throw new IllegalStateException("already connected");
        }
        var9_8 /* !! */  = this.d.a().b();
        var13_11 = new r3.b(var9_8 /* !! */ );
        if (this.d.a().k() == null) {
            if (!var9_8 /* !! */ .contains((Object)m3.k.k)) {
                throw new i((IOException)new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            var9_8 /* !! */  = this.d.a().l().h();
            if (!v3.k.a.g().i((String)var9_8 /* !! */ )) {
                var6_6 = new StringBuilder();
                var6_6.append("CLEARTEXT communication to ");
                var6_6.append((String)var9_8 /* !! */ );
                var6_6.append(" not permitted by network security policy");
                throw new i((IOException)new UnknownServiceException(var6_6.toString()));
            }
        } else if (this.d.a().f().contains((Object)x.m)) {
            throw new i((IOException)new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        var11_12 = null;
        do {
            block25: {
                block23: {
                    block24: {
                        block22: {
                            var10_14 = var6_6;
                            var9_8 /* !! */  = var7_7;
                            var8_13 = this.d.c();
                            if (!var8_13) break block22;
                            this.j(var1_1, var2_2, var3_3, (m3.e)var10_14, (q)var9_8 /* !! */ );
                            try {
                                if (this.e == null) break block23;
lbl34:
                                // 2 sources

                                while (true) {
                                    var9_8 /* !! */  = var6_6;
                                    var10_14 = var7_7;
                                    break block24;
                                    break;
                                }
                            }
                            catch (IOException v0) {
                                var9_8 /* !! */  = var6_6;
                                var9_8 /* !! */  = var7_7;
                                var9_8 /* !! */  = v0;
lbl42:
                                // 3 sources

                                while (true) {
                                    var10_14 = var6_6;
                                    var10_14 = var7_7;
lbl45:
                                    // 2 sources

                                    while (true) {
                                        var10_14 = var6_6;
                                        var12_15 = var7_7;
                                        break block25;
                                        break;
                                    }
                                    break;
                                }
                            }
                            catch (IOException var9_10) {
                                ** GOTO lbl42
                            }
                            catch (IOException var12_16) {
                                var9_8 /* !! */  = var12_16;
                                ** continue;
                            }
                        }
                        this.h(var1_1, var2_2, (m3.e)var10_14, (q)var9_8 /* !! */ );
                        ** continue;
                    }
                    try {
                        this.m(var13_11, var4_4, (m3.e)var9_8 /* !! */ , (q)var10_14);
                        var10_14.g((m3.e)var9_8 /* !! */ , this.d.d(), this.d.b(), this.h);
                    }
                    catch (IOException var9_9) {
                        ** continue;
                    }
                }
                if (this.d.c() && this.e == null) {
                    throw new i((IOException)new ProtocolException("Too many tunnel connections attempted: 21"));
                }
                this.s = System.nanoTime();
                return;
            }
            var14_17 = this.f;
            if (var14_17 != null) {
                n3.d.n(var14_17);
            }
            var14_17 = this.e;
            if (var14_17 != null) {
                n3.d.n(var14_17);
            }
            this.f = null;
            this.e = null;
            this.j = null;
            this.k = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.q = 1;
            var12_15.h((m3.e)var10_14, this.d.d(), this.d.b(), null, (IOException)var9_8 /* !! */ );
            if (var11_12 == null) {
                var11_12 = new i((IOException)var9_8 /* !! */ );
                continue;
            }
            var11_12.a((IOException)var9_8 /* !! */ );
        } while (var5_5 && var13_11.b((IOException)var9_8 /* !! */ ));
        throw var11_12;
    }

    public final void g(w w2, C c2, IOException iOException) {
        V2.k.e(w2, "client");
        V2.k.e(c2, "failedRoute");
        V2.k.e((Object)iOException, "failure");
        if (c2.b().type() != Proxy.Type.DIRECT) {
            m3.a a2 = c2.a();
            a2.i().connectFailed(a2.l().q(), c2.b().address(), iOException);
        }
        w2.s().b(c2);
    }

    public final List n() {
        return this.r;
    }

    public final long o() {
        return this.s;
    }

    public final boolean p() {
        return this.l;
    }

    public final int q() {
        return this.n;
    }

    public r r() {
        return this.g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void s() {
        f f2 = this;
        synchronized (f2) {
            ++this.o;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean t(m3.a object, List object2) {
        V2.k.e(object, "address");
        if (n3.d.h && !Thread.holdsLock((Object)this)) {
            object = new StringBuilder();
            object.append("Thread ");
            object.append((Object)Thread.currentThread().getName());
            object.append(" MUST hold lock on ");
            object.append((Object)this);
            throw new AssertionError((Object)object.toString());
        }
        if (this.r.size() >= this.q) return false;
        if (this.l) {
            return false;
        }
        if (!this.d.a().d((m3.a)object)) {
            return false;
        }
        if (V2.k.a(((m3.a)object).l().h(), this.z().a().l().h())) {
            return true;
        }
        if (this.i == null) {
            return false;
        }
        if (object2 == null) return false;
        if (!this.A((List)object2)) {
            return false;
        }
        if (((m3.a)object).e() != y3.d.a) {
            return false;
        }
        if (!this.F(((m3.a)object).l())) {
            return false;
        }
        try {
            object2 = ((m3.a)object).a();
            V2.k.b(object2);
            object = ((m3.a)object).l().h();
            r r2 = this.r();
            V2.k.b(r2);
            ((m3.f)object2).a((String)object, r2.d());
            return true;
        }
        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection{");
        stringBuilder.append(this.d.a().l().h());
        stringBuilder.append(':');
        stringBuilder.append(this.d.a().l().l());
        stringBuilder.append(", proxy=");
        stringBuilder.append((Object)this.d.b());
        stringBuilder.append(" hostAddress=");
        stringBuilder.append((Object)this.d.d());
        stringBuilder.append(" cipherSuite=");
        Object object = this.g;
        Object object2 = "none";
        if (object != null && (object = ((r)object).a()) != null) {
            object2 = object;
        }
        stringBuilder.append(object2);
        stringBuilder.append(" protocol=");
        stringBuilder.append((Object)this.h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean u(boolean bl) {
        long l2;
        if (n3.d.h && Thread.holdsLock((Object)this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append((Object)this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        long l3 = System.nanoTime();
        Object object = this.e;
        V2.k.b(object);
        Socket socket = this.f;
        V2.k.b(socket);
        z3.d d2 = this.j;
        V2.k.b(d2);
        if (object.isClosed()) return false;
        if (socket.isClosed()) return false;
        if (socket.isInputShutdown()) return false;
        if (socket.isOutputShutdown()) {
            return false;
        }
        object = this.i;
        if (object != null) {
            return ((u3.f)object).S0(l3);
        }
        f f2 = this;
        synchronized (f2) {
            l2 = this.o();
        }
        if (l3 - l2 < 10000000000L) return true;
        if (!bl) return true;
        return n3.d.F(socket, d2);
    }

    public final boolean v() {
        return this.i != null;
    }

    public final d w(w w2, s3.g g2) {
        V2.k.e(w2, "client");
        V2.k.e(g2, "chain");
        Object object = this.f;
        V2.k.b(object);
        z3.d d2 = this.j;
        V2.k.b(d2);
        z3.c c2 = this.k;
        V2.k.b(c2);
        u3.f f2 = this.i;
        if (f2 != null) {
            return new u3.g(w2, this, g2, f2);
        }
        object.setSoTimeout(g2.k());
        object = d2.h();
        long l2 = g2.h();
        f2 = TimeUnit.MILLISECONDS;
        ((z3.y)object).g(l2, (TimeUnit)f2);
        c2.h().g(g2.j(), (TimeUnit)f2);
        return new t3.b(w2, this, d2, c2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void x() {
        f f2 = this;
        synchronized (f2) {
            this.m = true;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void y() {
        f f2 = this;
        synchronized (f2) {
            this.l = true;
            return;
        }
    }

    public C z() {
        return this.d;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g2) {
            this();
        }
    }

    public abstract class b {
        public static final int[] a;

        static {
            int[] nArray = new int[Proxy.Type.values().length];
            nArray[Proxy.Type.DIRECT.ordinal()] = 1;
            nArray[Proxy.Type.HTTP.ordinal()] = 2;
            a = nArray;
        }
    }
}

