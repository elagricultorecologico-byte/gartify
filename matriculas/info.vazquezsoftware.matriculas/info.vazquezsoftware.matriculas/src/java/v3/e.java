/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalStateException
 *  java.lang.NoClassDefFoundError
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.security.Provider
 *  java.util.Arrays
 *  java.util.List
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 *  org.conscrypt.Conscrypt
 *  org.conscrypt.Conscrypt$Version
 *  org.conscrypt.ConscryptHostnameVerifier
 */
package v3;

import V2.g;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;
import v3.k;

public final class e
extends k {
    public static final a e;
    private static final boolean f;
    private final Provider d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        boolean bl;
        block3: {
            a a2;
            e = a2 = new a(null);
            boolean bl2 = false;
            try {
                Class.forName((String)"org.conscrypt.Conscrypt$Version", (boolean)false, (ClassLoader)a2.getClass().getClassLoader());
                bl = bl2;
                if (!Conscrypt.isAvailable()) break block3;
                boolean bl3 = a2.a(2, 1, 0);
                bl = bl2;
                if (bl3) {
                    bl = true;
                }
            }
            catch (ClassNotFoundException | NoClassDefFoundError throwable) {
                bl = bl2;
            }
        }
        f = bl;
    }

    private e() {
        Provider provider = Conscrypt.newProvider();
        V2.k.d(provider, "newProvider()");
        this.d = provider;
    }

    public /* synthetic */ e(g g2) {
        this();
    }

    @Override
    public void e(SSLSocket sSLSocket, String objectArray, List list) {
        V2.k.e(sSLSocket, "sslSocket");
        V2.k.e(list, "protocols");
        if (Conscrypt.isConscrypt((SSLSocket)sSLSocket)) {
            Conscrypt.setUseSessionTickets((SSLSocket)sSLSocket, (boolean)true);
            objectArray = k.a.b(list).toArray((Object[])new String[0]);
            if (objectArray != null) {
                Conscrypt.setApplicationProtocols((SSLSocket)sSLSocket, (String[])((String[])objectArray));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        super.e(sSLSocket, (String)objectArray, list);
    }

    @Override
    public String g(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "sslSocket");
        if (Conscrypt.isConscrypt((SSLSocket)sSLSocket)) {
            return Conscrypt.getApplicationProtocol((SSLSocket)sSLSocket);
        }
        return super.g(sSLSocket);
    }

    @Override
    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS", (Provider)this.d);
        V2.k.d(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override
    public SSLSocketFactory n(X509TrustManager x509TrustManager) {
        V2.k.e(x509TrustManager, "trustManager");
        SSLContext sSLContext = this.m();
        sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
        x509TrustManager = sSLContext.getSocketFactory();
        V2.k.d(x509TrustManager, "newSSLContext().apply {\n\u2026null)\n    }.socketFactory");
        return x509TrustManager;
    }

    @Override
    public X509TrustManager o() {
        Object object;
        X509TrustManager x509TrustManager = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
        x509TrustManager.init(null);
        x509TrustManager = x509TrustManager.getTrustManagers();
        V2.k.b(x509TrustManager);
        if (((TrustManager[])x509TrustManager).length == 1 && (object = x509TrustManager[0]) instanceof X509TrustManager) {
            if (object != null) {
                x509TrustManager = (X509TrustManager)object;
                Conscrypt.setHostnameVerifier((TrustManager)x509TrustManager, (ConscryptHostnameVerifier)b.a);
                return x509TrustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        x509TrustManager = Arrays.toString((Object[])x509TrustManager);
        V2.k.d(x509TrustManager, "toString(this)");
        throw new IllegalStateException(V2.k.j("Unexpected default trust managers: ", x509TrustManager).toString());
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final boolean a(int n2, int n3, int n4) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != n2) {
                return version.major() > n2;
            }
            if (version.minor() != n3) {
                return version.minor() > n3;
            }
            return version.patch() >= n4;
        }

        public final e b() {
            if (this.c()) {
                return new e(null);
            }
            return null;
        }

        public final boolean c() {
            return f;
        }
    }

    public static final class b
    implements ConscryptHostnameVerifier {
        public static final b a = new b();

        private b() {
        }
    }
}

