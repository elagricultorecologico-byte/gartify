/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.security.GeneralSecurityException
 *  java.security.Security
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 */
package v3;

import I2.o;
import V2.g;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import m3.w;
import m3.x;
import v3.b;
import v3.c;
import v3.d;
import v3.e;
import v3.f;
import v3.i;
import v3.j;

public class k {
    public static final a a;
    private static volatile k b;
    private static final Logger c;

    static {
        a a2;
        a = a2 = new a(null);
        b = a2.f();
        c = Logger.getLogger((String)w.class.getName());
    }

    public static /* synthetic */ void k(k k2, String string, int n2, Throwable throwable, int n3, Object object) {
        if (object == null) {
            if ((n3 & 2) != 0) {
                n2 = 4;
            }
            if ((n3 & 4) != 0) {
                throwable = null;
            }
            k2.j(string, n2, throwable);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void b(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "sslSocket");
    }

    public y3.c c(X509TrustManager x509TrustManager) {
        V2.k.e(x509TrustManager, "trustManager");
        return new y3.a(this.d(x509TrustManager));
    }

    public y3.e d(X509TrustManager objectArray) {
        V2.k.e(objectArray, "trustManager");
        objectArray = objectArray.getAcceptedIssuers();
        V2.k.d(objectArray, "trustManager.acceptedIssuers");
        return new y3.b((X509Certificate[])Arrays.copyOf((Object[])objectArray, (int)objectArray.length));
    }

    public void e(SSLSocket sSLSocket, String string, List list) {
        V2.k.e(sSLSocket, "sslSocket");
        V2.k.e(list, "protocols");
    }

    public void f(Socket socket, InetSocketAddress inetSocketAddress, int n2) {
        V2.k.e(socket, "socket");
        V2.k.e(inetSocketAddress, "address");
        socket.connect((SocketAddress)inetSocketAddress, n2);
    }

    public String g(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "sslSocket");
        return null;
    }

    public Object h(String string) {
        V2.k.e(string, "closer");
        if (c.isLoggable(Level.FINE)) {
            return new Throwable(string);
        }
        return null;
    }

    public boolean i(String string) {
        V2.k.e(string, "hostname");
        return true;
    }

    public void j(String string, int n2, Throwable throwable) {
        V2.k.e(string, "message");
        Level level = n2 == 5 ? Level.WARNING : Level.INFO;
        c.log(level, string, throwable);
    }

    public void l(String string, Object object) {
        V2.k.e(string, "message");
        String string2 = string;
        if (object == null) {
            string2 = V2.k.j(string, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        this.j(string2, 5, (Throwable)object);
    }

    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
        V2.k.d(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory n(X509TrustManager x509TrustManager) {
        V2.k.e(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContext = this.m();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            x509TrustManager = sSLContext.getSocketFactory();
            V2.k.d(x509TrustManager, "newSSLContext().apply {\n\u2026ll)\n      }.socketFactory");
            return x509TrustManager;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new AssertionError(V2.k.j("No System TLS: ", (Object)generalSecurityException), (Throwable)generalSecurityException);
        }
    }

    public X509TrustManager o() {
        Object object = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
        object.init(null);
        Object[] objectArray = object.getTrustManagers();
        V2.k.b(objectArray);
        if (objectArray.length == 1 && (object = objectArray[0]) instanceof X509TrustManager) {
            if (object != null) {
                return (X509TrustManager)object;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        object = Arrays.toString((Object[])objectArray);
        V2.k.d(object, "toString(this)");
        throw new IllegalStateException(V2.k.j("Unexpected default trust managers: ", object).toString());
    }

    public String toString() {
        String string = this.getClass().getSimpleName();
        V2.k.d(string, "javaClass.simpleName");
        return string;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        private final k d() {
            k k2;
            w3.e.a.b();
            k k3 = k2 = v3.b.e.a();
            if (k2 == null) {
                k3 = v3.c.f.a();
                V2.k.b(k3);
            }
            return k3;
        }

        private final k e() {
            k k2;
            if (this.j() && (k2 = e.e.b()) != null) {
                return k2;
            }
            if (this.i() && (k2 = d.e.a()) != null) {
                return k2;
            }
            if (this.k() && (k2 = j.e.a()) != null) {
                return k2;
            }
            k2 = i.d.a();
            if (k2 != null) {
                return k2;
            }
            k2 = f.i.a();
            if (k2 != null) {
                return k2;
            }
            return new k();
        }

        private final k f() {
            if (this.h()) {
                return this.d();
            }
            return this.e();
        }

        private final boolean i() {
            return V2.k.a("BC", Security.getProviders()[0].getName());
        }

        private final boolean j() {
            return V2.k.a("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean k() {
            return V2.k.a("OpenJSSE", Security.getProviders()[0].getName());
        }

        public final List b(List object) {
            Object object22;
            V2.k.e(object, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object object22 : object) {
                if ((x)((Object)object22) == x.i) continue;
                arrayList.add(object22);
            }
            object22 = new ArrayList(o.o((Iterable)arrayList, 10));
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                object = arrayList.get(i2);
                object22.add((Object)((x)((Object)object)).toString());
            }
            return object22;
        }

        public final byte[] c(List object2) {
            V2.k.e(object2, "protocols");
            z3.b b2 = new z3.b();
            for (Object object2 : this.b((List)object2)) {
                b2.P0(object2.length());
                b2.U0((String)object2);
            }
            return b2.Z();
        }

        public final k g() {
            return b;
        }

        public final boolean h() {
            return V2.k.a("Dalvik", System.getProperty((String)"java.vm.name"));
        }
    }
}

