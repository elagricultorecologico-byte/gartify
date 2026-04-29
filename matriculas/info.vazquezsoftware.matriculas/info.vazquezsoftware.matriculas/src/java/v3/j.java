/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.security.Provider
 *  java.util.Arrays
 *  java.util.List
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 *  org.openjsse.net.ssl.OpenJSSE
 */
package v3;

import V2.g;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.net.ssl.OpenJSSE;
import v3.k;

public final class j
extends k {
    public static final a e;
    private static final boolean f;
    private final Provider d = (Provider)new OpenJSSE();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        a a2;
        e = a2 = new a(null);
        boolean bl = false;
        try {
            Class.forName((String)"org.openjsse.net.ssl.OpenJSSE", (boolean)false, (ClassLoader)a2.getClass().getClassLoader());
            bl = true;
        }
        catch (ClassNotFoundException classNotFoundException) {}
        f = bl;
    }

    private j() {
    }

    public /* synthetic */ j(g g2) {
        this();
    }

    @Override
    public void e(SSLSocket sSLSocket, String string, List list) {
        V2.k.e(sSLSocket, "sslSocket");
        V2.k.e(list, "protocols");
        super.e(sSLSocket, string, list);
    }

    @Override
    public String g(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "sslSocket");
        return super.g(sSLSocket);
    }

    @Override
    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance((String)"TLSv1.3", (Provider)this.d);
        V2.k.d(sSLContext, "getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override
    public X509TrustManager o() {
        Object object;
        Object object2 = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm(), (Provider)this.d);
        object2.init(null);
        object2 = object2.getTrustManagers();
        V2.k.b(object2);
        if (((TrustManager[])object2).length == 1 && (object = object2[0]) instanceof X509TrustManager) {
            if (object != null) {
                return (X509TrustManager)object;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        object2 = Arrays.toString((Object[])object2);
        V2.k.d(object2, "toString(this)");
        throw new IllegalStateException(V2.k.j("Unexpected default trust managers: ", object2).toString());
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final j a() {
            if (this.b()) {
                return new j(null);
            }
            return null;
        }

        public final boolean b() {
            return f;
        }
    }
}

