/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.util.List
 *  java.util.Objects
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSocketFactory
 */
package m3;

import V2.k;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import m3.b;
import m3.f;
import m3.p;
import m3.t;
import n3.d;

public final class a {
    private final p a;
    private final SocketFactory b;
    private final SSLSocketFactory c;
    private final HostnameVerifier d;
    private final f e;
    private final b f;
    private final Proxy g;
    private final ProxySelector h;
    private final t i;
    private final List j;
    private final List k;

    public a(String string, int n2, p object, SocketFactory object2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, f f2, b b2, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        V2.k.e(string, "uriHost");
        V2.k.e(object, "dns");
        V2.k.e(object2, "socketFactory");
        V2.k.e(b2, "proxyAuthenticator");
        V2.k.e(list, "protocols");
        V2.k.e(list2, "connectionSpecs");
        V2.k.e(proxySelector, "proxySelector");
        this.a = object;
        this.b = object2;
        this.c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.e = f2;
        this.f = b2;
        this.g = proxy;
        this.h = proxySelector;
        object2 = new t.a();
        object = sSLSocketFactory != null ? "https" : "http";
        this.i = ((t.a)object2).v((String)object).l(string).r(n2).a();
        this.j = n3.d.S(list);
        this.k = n3.d.S(list2);
    }

    public final f a() {
        return this.e;
    }

    public final List b() {
        return this.k;
    }

    public final p c() {
        return this.a;
    }

    public final boolean d(a a2) {
        V2.k.e(a2, "that");
        return V2.k.a(this.a, a2.a) && V2.k.a(this.f, a2.f) && V2.k.a(this.j, a2.j) && V2.k.a(this.k, a2.k) && V2.k.a(this.h, a2.h) && V2.k.a(this.g, a2.g) && V2.k.a(this.c, a2.c) && V2.k.a(this.d, a2.d) && V2.k.a(this.e, a2.e) && this.i.l() == a2.i.l();
    }

    public final HostnameVerifier e() {
        return this.d;
    }

    public boolean equals(Object object) {
        if (object instanceof a) {
            t t2 = this.i;
            object = (a)object;
            if (V2.k.a(t2, ((a)object).i) && this.d((a)object)) {
                return true;
            }
        }
        return false;
    }

    public final List f() {
        return this.j;
    }

    public final Proxy g() {
        return this.g;
    }

    public final b h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((527 + this.i.hashCode()) * 31 + this.a.hashCode()) * 31 + this.f.hashCode()) * 31 + this.j.hashCode()) * 31 + this.k.hashCode()) * 31 + this.h.hashCode()) * 31 + Objects.hashCode((Object)this.g)) * 31 + Objects.hashCode((Object)this.c)) * 31 + Objects.hashCode((Object)this.d)) * 31 + Objects.hashCode((Object)this.e);
    }

    public final ProxySelector i() {
        return this.h;
    }

    public final SocketFactory j() {
        return this.b;
    }

    public final SSLSocketFactory k() {
        return this.c;
    }

    public final t l() {
        return this.i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Address{");
        stringBuilder.append(this.i.h());
        stringBuilder.append(':');
        stringBuilder.append(this.i.l());
        stringBuilder.append(", ");
        Object object = this.g;
        object = object != null ? V2.k.j("proxy=", object) : V2.k.j("proxySelector=", this.h);
        stringBuilder.append((String)object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

