/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 *  org.bouncycastle.jsse.BCSSLParameters
 *  org.bouncycastle.jsse.BCSSLSocket
 */
package w3;

import V2.g;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import v3.d;
import v3.k;
import w3.l;
import w3.m;

public final class i
implements m {
    public static final b a = new b(null);
    private static final l.a b = new l.a(){

        @Override
        public boolean a(SSLSocket sSLSocket) {
            V2.k.e(sSLSocket, "sslSocket");
            d.e.b();
            return false;
        }

        @Override
        public m b(SSLSocket sSLSocket) {
            V2.k.e(sSLSocket, "sslSocket");
            return new i();
        }
    };

    @Override
    public boolean a(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "sslSocket");
        return false;
    }

    @Override
    public boolean b() {
        return d.e.b();
    }

    @Override
    public String c(SSLSocket object) {
        V2.k.e(object, "sslSocket");
        object = ((BCSSLSocket)object).getApplicationProtocol();
        boolean bl = object == null ? true : V2.k.a(object, "");
        if (bl) {
            object = null;
        }
        return object;
    }

    @Override
    public void d(SSLSocket sSLSocket, String string, List objectArray) {
        V2.k.e(sSLSocket, "sslSocket");
        V2.k.e(objectArray, "protocols");
        if (this.a(sSLSocket)) {
            sSLSocket = (BCSSLSocket)sSLSocket;
            string = sSLSocket.getParameters();
            if ((objectArray = k.a.b((List)objectArray).toArray((Object[])new String[0])) != null) {
                string.setApplicationProtocols((String[])objectArray);
                sSLSocket.setParameters((BCSSLParameters)string);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        public final l.a a() {
            return b;
        }
    }
}

