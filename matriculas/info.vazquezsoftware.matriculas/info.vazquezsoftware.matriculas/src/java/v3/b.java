/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.security.NetworkSecurityPolicy
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
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
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import v3.k;
import w3.c;
import w3.d;
import w3.h;
import w3.i;
import w3.l;
import w3.m;

public final class b
extends k {
    public static final a e = new a(null);
    private static final boolean f;
    private final List d;

    static {
        boolean bl = k.a.h() && Build.VERSION.SDK_INT >= 29;
        f = bl;
    }

    public b() {
        List list = o.j(c.a.a(), new l(h.f.d()), new l(w3.k.a.a()), new l(i.a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object object : list) {
            if (!((m)object).b()) continue;
            arrayList.add(object);
        }
        this.d = arrayList;
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
    public boolean i(String string) {
        V2.k.e(string, "hostname");
        return v3.a.a(NetworkSecurityPolicy.getInstance(), string);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final k a() {
            if (this.b()) {
                return new b();
            }
            return null;
        }

        public final boolean b() {
            return f;
        }
    }
}

