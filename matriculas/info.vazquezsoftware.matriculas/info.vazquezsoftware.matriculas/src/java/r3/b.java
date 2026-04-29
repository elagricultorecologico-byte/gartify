/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 *  java.net.UnknownServiceException
 *  java.security.cert.CertificateException
 *  java.util.Arrays
 *  java.util.List
 *  javax.net.ssl.SSLException
 *  javax.net.ssl.SSLHandshakeException
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLSocket
 */
package r3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import m3.k;

public final class b {
    private final List a;
    private int b;
    private boolean c;
    private boolean d;

    public b(List list) {
        V2.k.e(list, "connectionSpecs");
        this.a = list;
    }

    private final boolean c(SSLSocket sSLSocket) {
        int n2 = this.a.size();
        for (int i2 = this.b; i2 < n2; ++i2) {
            if (!((k)this.a.get(i2)).e(sSLSocket)) continue;
            return true;
        }
        return false;
    }

    public final k a(SSLSocket object) {
        Object object2;
        block3: {
            V2.k.e(object, "sslSocket");
            int n2 = this.b;
            int n3 = this.a.size();
            while (n2 < n3) {
                int n4 = n2 + 1;
                object2 = (k)this.a.get(n2);
                if (((k)object2).e((SSLSocket)object)) {
                    this.b = n4;
                    break block3;
                }
                n2 = n4;
            }
            object2 = null;
        }
        if (object2 != null) {
            this.c = this.c((SSLSocket)object);
            ((k)object2).c((SSLSocket)object, this.d);
            return object2;
        }
        object2 = new StringBuilder();
        object2.append("Unable to find acceptable protocols. isFallback=");
        object2.append(this.d);
        object2.append(", modes=");
        object2.append((Object)this.a);
        object2.append(", supported protocols=");
        object = object.getEnabledProtocols();
        V2.k.b(object);
        object = Arrays.toString((Object[])object);
        V2.k.d(object, "toString(this)");
        object2.append((String)object);
        throw new UnknownServiceException(object2.toString());
    }

    public final boolean b(IOException iOException) {
        V2.k.e((Object)iOException, "e");
        this.d = true;
        if (!this.c) {
            return false;
        }
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return false;
        }
        if (iOException instanceof SSLHandshakeException && iOException.getCause() instanceof CertificateException) {
            return false;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return false;
        }
        return iOException instanceof SSLException;
    }
}

