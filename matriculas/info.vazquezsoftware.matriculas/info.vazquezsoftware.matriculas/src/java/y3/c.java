/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  javax.net.ssl.X509TrustManager
 */
package y3;

import V2.g;
import V2.k;
import java.util.List;
import javax.net.ssl.X509TrustManager;

public abstract class c {
    public static final a a = new a(null);

    public abstract List a(List var1, String var2);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final c a(X509TrustManager x509TrustManager) {
            k.e(x509TrustManager, "trustManager");
            return v3.k.a.g().c(x509TrustManager);
        }
    }
}

