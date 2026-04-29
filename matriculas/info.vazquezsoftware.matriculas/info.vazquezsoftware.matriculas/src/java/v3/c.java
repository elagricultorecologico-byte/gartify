/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.security.NetworkSecurityPolicy
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.security.cert.TrustAnchor
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.X509TrustManager
 */
package v3;

import I2.o;
import V2.g;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import v3.k;
import w3.d;
import w3.h;
import w3.i;
import w3.j;
import w3.l;
import w3.m;
import w3.n;
import y3.e;

public final class c
extends k {
    public static final a f = new a(null);
    private static final boolean g;
    private final List d;
    private final j e;

    static {
        boolean bl = k.a.h();
        boolean bl2 = false;
        if (bl && Build.VERSION.SDK_INT < 30) {
            bl2 = true;
        }
        g = bl2;
    }

    public c() {
        Object object2 = o.j(n.a.b(n.j, null, 1, null), new l(h.f.d()), new l(w3.k.a.a()), new l(i.a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object object2 : object2) {
            if (!((m)object2).b()) continue;
            arrayList.add(object2);
        }
        this.d = arrayList;
        this.e = j.d.a();
    }

    @Override
    public y3.c c(X509TrustManager x509TrustManager) {
        V2.k.e(x509TrustManager, "trustManager");
        d d2 = w3.d.d.a(x509TrustManager);
        if (d2 == null) {
            return super.c(x509TrustManager);
        }
        return d2;
    }

    @Override
    public e d(X509TrustManager x509TrustManager) {
        V2.k.e(x509TrustManager, "trustManager");
        try {
            Object object = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            object.setAccessible(true);
            V2.k.d(object, "method");
            object = new b(x509TrustManager, (Method)object);
            return object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return super.d(x509TrustManager);
        }
    }

    @Override
    public void e(SSLSocket sSLSocket, String string, List list) {
        Object object2;
        block2: {
            V2.k.e(sSLSocket, "sslSocket");
            V2.k.e(list, "protocols");
            for (Object object2 : this.d) {
                if (!((m)object2).a(sSLSocket)) continue;
                break block2;
            }
            object2 = null;
        }
        object2 = (m)object2;
        if (object2 == null) {
            return;
        }
        object2.d(sSLSocket, string, list);
    }

    @Override
    public void f(Socket socket, InetSocketAddress inetSocketAddress, int n2) {
        V2.k.e(socket, "socket");
        V2.k.e(inetSocketAddress, "address");
        try {
            socket.connect((SocketAddress)inetSocketAddress, n2);
            return;
        }
        catch (ClassCastException classCastException) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", (Throwable)classCastException);
            }
            throw classCastException;
        }
    }

    @Override
    public String g(SSLSocket sSLSocket) {
        Object object2;
        block2: {
            V2.k.e(sSLSocket, "sslSocket");
            for (Object object2 : this.d) {
                if (!((m)object2).a(sSLSocket)) continue;
                break block2;
            }
            object2 = null;
        }
        object2 = (m)object2;
        if (object2 == null) {
            return null;
        }
        return object2.c(sSLSocket);
    }

    @Override
    public Object h(String string) {
        V2.k.e(string, "closer");
        return this.e.a(string);
    }

    @Override
    public boolean i(String string) {
        V2.k.e(string, "hostname");
        if (Build.VERSION.SDK_INT >= 24) {
            return v3.a.a(NetworkSecurityPolicy.getInstance(), string);
        }
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    @Override
    public void l(String string, Object object) {
        V2.k.e(string, "message");
        if (!this.e.b(object)) {
            k.k(this, string, 5, null, 4, null);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final k a() {
            if (this.b()) {
                return new c();
            }
            return null;
        }

        public final boolean b() {
            return g;
        }
    }

    public static final class b
    implements e {
        private final X509TrustManager a;
        private final Method b;

        public b(X509TrustManager x509TrustManager, Method method) {
            V2.k.e(x509TrustManager, "trustManager");
            V2.k.e(method, "findByIssuerAndSignatureMethod");
            this.a = x509TrustManager;
            this.b = method;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public X509Certificate a(X509Certificate object) {
            V2.k.e(object, "cert");
            try {
                object = this.b.invoke((Object)this.a, new Object[]{object});
                if (object != null) {
                    return ((TrustAnchor)object).getTrustedCert();
                }
                object = new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
                throw object;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError("unable to get issues and signature", (Throwable)illegalAccessException);
            }
            catch (InvocationTargetException invocationTargetException) {
                return null;
            }
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof b)) {
                return false;
            }
            object = (b)object;
            if (!V2.k.a(this.a, ((b)object).a)) {
                return false;
            }
            return V2.k.a(this.b, ((b)object).b);
        }

        public int hashCode() {
            return this.a.hashCode() * 31 + this.b.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CustomTrustRootIndex(trustManager=");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(", findByIssuerAndSignatureMethod=");
            stringBuilder.append((Object)this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
}

