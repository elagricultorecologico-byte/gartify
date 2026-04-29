/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.http.X509TrustManagerExtensions
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.X509TrustManager
 */
package w3;

import V2.g;
import V2.k;
import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import y3.c;

public final class d
extends c {
    public static final a d = new a(null);
    private final X509TrustManager b;
    private final X509TrustManagerExtensions c;

    public d(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        k.e(x509TrustManager, "trustManager");
        k.e(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.b = x509TrustManager;
        this.c = x509TrustManagerExtensions;
    }

    @Override
    public List a(List list, String object) {
        k.e(list, "chain");
        k.e(object, "hostname");
        list = list.toArray((Object[])new X509Certificate[0]);
        if (list != null) {
            list = (X509Certificate[])list;
            try {
                list = this.c.checkServerTrusted((X509Certificate[])list, "RSA", object);
                k.d(list, "x509TrustManagerExtensio\u2026ficates, \"RSA\", hostname)");
                return list;
            }
            catch (CertificateException certificateException) {
                object = new SSLPeerUnverifiedException(certificateException.getMessage());
                object.initCause((Throwable)certificateException);
                throw object;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public boolean equals(Object object) {
        return object instanceof d && ((d)object).b == this.b;
    }

    public int hashCode() {
        return System.identityHashCode((Object)this.b);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final d a(X509TrustManager x509TrustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            k.e(x509TrustManager, "trustManager");
            d d2 = null;
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                d2 = new d(x509TrustManager, x509TrustManagerExtensions);
            }
            return d2;
        }
    }
}

