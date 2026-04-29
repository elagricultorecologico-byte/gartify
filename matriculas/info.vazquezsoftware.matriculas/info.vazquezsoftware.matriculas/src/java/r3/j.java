/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.InetAddress
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.SocketAddress
 *  java.net.SocketException
 *  java.net.URI
 *  java.net.UnknownHostException
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.NoSuchElementException
 */
package r3;

import I2.o;
import V2.g;
import V2.k;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import m3.C;
import m3.e;
import m3.q;
import m3.t;
import n3.d;
import r3.h;

public final class j {
    public static final a i = new a(null);
    private final m3.a a;
    private final h b;
    private final e c;
    private final q d;
    private List e;
    private int f;
    private List g;
    private final List h;

    public j(m3.a a2, h h2, e e2, q q2) {
        k.e(a2, "address");
        k.e(h2, "routeDatabase");
        k.e(e2, "call");
        k.e(q2, "eventListener");
        this.a = a2;
        this.b = h2;
        this.c = e2;
        this.d = q2;
        this.e = o.g();
        this.g = o.g();
        this.h = new ArrayList();
        this.f(a2.l(), a2.g());
    }

    private final boolean b() {
        return this.f < this.e.size();
    }

    private final Proxy d() {
        if (this.b()) {
            List list = this.e;
            int n2 = this.f;
            this.f = n2 + 1;
            list = (Proxy)list.get(n2);
            this.e((Proxy)list);
            return list;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No route to ");
        stringBuilder.append(this.a.l().h());
        stringBuilder.append("; exhausted proxy configurations: ");
        stringBuilder.append((Object)this.e);
        throw new SocketException(stringBuilder.toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final void e(Proxy proxy) {
        int n2;
        Object object;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress socketAddress = proxy.address();
            if (!(socketAddress instanceof InetSocketAddress)) throw new IllegalArgumentException(k.j("Proxy.address() is not an InetSocketAddress: ", socketAddress.getClass()).toString());
            object = i;
            k.d(socketAddress, "proxyAddress");
            socketAddress = (InetSocketAddress)socketAddress;
            object = ((a)object).a((InetSocketAddress)socketAddress);
            n2 = socketAddress.getPort();
        } else {
            object = this.a.l().h();
            n2 = this.a.l().l();
        }
        if (1 <= n2 && n2 < 65536) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList.add((Object)InetSocketAddress.createUnresolved((String)object, (int)n2));
                return;
            }
            this.d.m(this.c, (String)object);
            proxy = this.a.c().a((String)object);
            if (!proxy.isEmpty()) {
                this.d.l(this.c, (String)object, (List)proxy);
                proxy = proxy.iterator();
                while (proxy.hasNext()) {
                    arrayList.add((Object)new InetSocketAddress((InetAddress)proxy.next(), n2));
                }
                return;
            }
            proxy = new StringBuilder();
            proxy.append((Object)this.a.c());
            proxy.append(" returned no addresses for ");
            proxy.append((String)object);
            throw new UnknownHostException(proxy.toString());
        }
        proxy = new StringBuilder();
        proxy.append("No route to ");
        proxy.append((String)object);
        proxy.append(':');
        proxy.append(n2);
        proxy.append("; port is out of range");
        throw new SocketException(proxy.toString());
    }

    private final void f(t t2, Proxy proxy) {
        this.d.o(this.c, t2);
        proxy = j.g(proxy, t2, this);
        this.e = proxy;
        this.f = 0;
        this.d.n(this.c, t2, (List)proxy);
    }

    private static final List g(Proxy proxy, t t2, j j2) {
        if (proxy != null) {
            return o.b(proxy);
        }
        proxy = t2.q();
        if (proxy.getHost() == null) {
            return n3.d.w(Proxy.NO_PROXY);
        }
        proxy = j2.a.i().select((URI)proxy);
        if (proxy != null && !proxy.isEmpty()) {
            k.d(proxy, "proxiesOrNull");
            return n3.d.S((List)proxy);
        }
        return n3.d.w(Proxy.NO_PROXY);
    }

    public final boolean a() {
        return this.b() || !this.h.isEmpty();
        {
        }
    }

    public final b c() {
        if (this.a()) {
            ArrayList arrayList = new ArrayList();
            while (this.b()) {
                Proxy proxy = this.d();
                for (Object object : this.g) {
                    if (this.b.c((C)(object = new C(this.a, proxy, (InetSocketAddress)object)))) {
                        this.h.add(object);
                        continue;
                    }
                    arrayList.add(object);
                }
                if (arrayList.isEmpty()) continue;
            }
            if (arrayList.isEmpty()) {
                o.q((Collection)arrayList, (Iterable)this.h);
                this.h.clear();
            }
            return new b((List)arrayList);
        }
        throw new NoSuchElementException();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final String a(InetSocketAddress object) {
            k.e(object, "<this>");
            InetAddress inetAddress = object.getAddress();
            if (inetAddress == null) {
                object = object.getHostName();
                k.d(object, "hostName");
                return object;
            }
            object = inetAddress.getHostAddress();
            k.d(object, "address.hostAddress");
            return object;
        }
    }

    public static final class b {
        private final List a;
        private int b;

        public b(List list) {
            k.e(list, "routes");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }

        public final boolean b() {
            return this.b < this.a.size();
        }

        public final C c() {
            if (this.b()) {
                List list = this.a;
                int n2 = this.b;
                this.b = n2 + 1;
                return (C)list.get(n2);
            }
            throw new NoSuchElementException();
        }
    }
}

