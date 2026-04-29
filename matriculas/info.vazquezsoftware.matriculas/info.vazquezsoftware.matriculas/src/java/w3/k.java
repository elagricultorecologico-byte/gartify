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
 *  org.conscrypt.Conscrypt
 */
package w3;

import V2.g;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;
import v3.e;
import w3.l;
import w3.m;

public final class k
implements m {
    public static final b a = new b(null);
    private static final l.a b = new l.a(){

        @Override
        public boolean a(SSLSocket sSLSocket) {
            V2.k.e(sSLSocket, "sslSocket");
            return e.e.c() && Conscrypt.isConscrypt((SSLSocket)sSLSocket);
        }

        @Override
        public m b(SSLSocket sSLSocket) {
            V2.k.e(sSLSocket, "sslSocket");
            return new k();
        }
    };

    @Override
    public boolean a(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt((SSLSocket)sSLSocket);
    }

    @Override
    public boolean b() {
        return e.e.c();
    }

    @Override
    public String c(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "sslSocket");
        if (this.a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol((SSLSocket)sSLSocket);
        }
        return null;
    }

    @Override
    public void d(SSLSocket sSLSocket, String objectArray, List list) {
        V2.k.e(sSLSocket, "sslSocket");
        V2.k.e(list, "protocols");
        if (this.a(sSLSocket)) {
            Conscrypt.setUseSessionTickets((SSLSocket)sSLSocket, (boolean)true);
            objectArray = v3.k.a.b(list).toArray((Object[])new String[0]);
            if (objectArray != null) {
                Conscrypt.setApplicationProtocols((SSLSocket)sSLSocket, (String[])((String[])objectArray));
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

