/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.util.List
 */
package m3;

import V2.g;
import V2.k;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import m3.A;
import m3.e;
import m3.i;
import m3.r;
import m3.t;
import m3.x;
import m3.y;

public abstract class q {
    public static final b a = new b(null);
    public static final q b = new q(){};

    public void A(e e2, r r2) {
        k.e(e2, "call");
    }

    public void B(e e2) {
        k.e(e2, "call");
    }

    public void a(e e2, A a2) {
        k.e(e2, "call");
        k.e(a2, "cachedResponse");
    }

    public void b(e e2, A a2) {
        k.e(e2, "call");
        k.e(a2, "response");
    }

    public void c(e e2) {
        k.e(e2, "call");
    }

    public void d(e e2, IOException iOException) {
        k.e(e2, "call");
        k.e(iOException, "ioe");
    }

    public void e(e e2) {
        k.e(e2, "call");
    }

    public void f(e e2) {
        k.e(e2, "call");
    }

    public void g(e e2, InetSocketAddress inetSocketAddress, Proxy proxy, x x2) {
        k.e(e2, "call");
        k.e(inetSocketAddress, "inetSocketAddress");
        k.e(proxy, "proxy");
    }

    public void h(e e2, InetSocketAddress inetSocketAddress, Proxy proxy, x x2, IOException iOException) {
        k.e(e2, "call");
        k.e(inetSocketAddress, "inetSocketAddress");
        k.e(proxy, "proxy");
        k.e(iOException, "ioe");
    }

    public void i(e e2, InetSocketAddress inetSocketAddress, Proxy proxy) {
        k.e(e2, "call");
        k.e(inetSocketAddress, "inetSocketAddress");
        k.e(proxy, "proxy");
    }

    public void j(e e2, i i2) {
        k.e(e2, "call");
        k.e(i2, "connection");
    }

    public void k(e e2, i i2) {
        k.e(e2, "call");
        k.e(i2, "connection");
    }

    public void l(e e2, String string, List list) {
        k.e(e2, "call");
        k.e(string, "domainName");
        k.e(list, "inetAddressList");
    }

    public void m(e e2, String string) {
        k.e(e2, "call");
        k.e(string, "domainName");
    }

    public void n(e e2, t t2, List list) {
        k.e(e2, "call");
        k.e(t2, "url");
        k.e(list, "proxies");
    }

    public void o(e e2, t t2) {
        k.e(e2, "call");
        k.e(t2, "url");
    }

    public void p(e e2, long l2) {
        k.e(e2, "call");
    }

    public void q(e e2) {
        k.e(e2, "call");
    }

    public void r(e e2, IOException iOException) {
        k.e(e2, "call");
        k.e(iOException, "ioe");
    }

    public void s(e e2, y y2) {
        k.e(e2, "call");
        k.e(y2, "request");
    }

    public void t(e e2) {
        k.e(e2, "call");
    }

    public void u(e e2, long l2) {
        k.e(e2, "call");
    }

    public void v(e e2) {
        k.e(e2, "call");
    }

    public void w(e e2, IOException iOException) {
        k.e(e2, "call");
        k.e(iOException, "ioe");
    }

    public void x(e e2, A a2) {
        k.e(e2, "call");
        k.e(a2, "response");
    }

    public void y(e e2) {
        k.e(e2, "call");
    }

    public void z(e e2, A a2) {
        k.e(e2, "call");
        k.e(a2, "response");
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }
    }

    public static interface c {
        public q a(e var1);
    }
}

