/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 */
package w3;

import V2.k;
import java.util.List;
import javax.net.ssl.SSLSocket;
import w3.m;

public final class l
implements m {
    private final a a;
    private m b;

    public l(a a2) {
        k.e(a2, "socketAdapterFactory");
        this.a = a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final m e(SSLSocket object) {
        l l2 = this;
        synchronized (l2) {
            try {
                if (this.b != null) return this.b;
                if (!this.a.a((SSLSocket)object)) return this.b;
                this.b = this.a.b((SSLSocket)object);
                return this.b;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    @Override
    public boolean a(SSLSocket sSLSocket) {
        k.e(sSLSocket, "sslSocket");
        return this.a.a(sSLSocket);
    }

    @Override
    public boolean b() {
        return true;
    }

    @Override
    public String c(SSLSocket sSLSocket) {
        k.e(sSLSocket, "sslSocket");
        m m2 = this.e(sSLSocket);
        if (m2 == null) {
            return null;
        }
        return m2.c(sSLSocket);
    }

    @Override
    public void d(SSLSocket sSLSocket, String string, List list) {
        k.e(sSLSocket, "sslSocket");
        k.e(list, "protocols");
        m m2 = this.e(sSLSocket);
        if (m2 == null) {
            return;
        }
        m2.d(sSLSocket, string, list);
    }

    public static interface a {
        public boolean a(SSLSocket var1);

        public m b(SSLSocket var1);
    }
}

