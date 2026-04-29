/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Comparator
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package m3;

import V2.g;
import V2.k;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class h {
    public static final h A;
    public static final h A0;
    public static final h B;
    public static final h B0;
    public static final h C;
    public static final h C0;
    public static final h D;
    public static final h D0;
    public static final h E;
    public static final h E0;
    public static final h F;
    public static final h F0;
    public static final h G;
    public static final h G0;
    public static final h H;
    public static final h H0;
    public static final h I;
    public static final h I0;
    public static final h J;
    public static final h J0;
    public static final h K;
    public static final h K0;
    public static final h L;
    public static final h L0;
    public static final h M;
    public static final h M0;
    public static final h N;
    public static final h N0;
    public static final h O;
    public static final h O0;
    public static final h P;
    public static final h P0;
    public static final h Q;
    public static final h Q0;
    public static final h R;
    public static final h R0;
    public static final h S;
    public static final h S0;
    public static final h T;
    public static final h T0;
    public static final h U;
    public static final h U0;
    public static final h V;
    public static final h V0;
    public static final h W;
    public static final h W0;
    public static final h X;
    public static final h X0;
    public static final h Y;
    public static final h Y0;
    public static final h Z;
    public static final h Z0;
    public static final h a0;
    public static final h a1;
    public static final b b;
    public static final h b0;
    public static final h b1;
    private static final Comparator c;
    public static final h c0;
    public static final h c1;
    private static final Map d;
    public static final h d0;
    public static final h d1;
    public static final h e;
    public static final h e0;
    public static final h e1;
    public static final h f;
    public static final h f0;
    public static final h f1;
    public static final h g;
    public static final h g0;
    public static final h g1;
    public static final h h;
    public static final h h0;
    public static final h h1;
    public static final h i;
    public static final h i0;
    public static final h i1;
    public static final h j;
    public static final h j0;
    public static final h j1;
    public static final h k;
    public static final h k0;
    public static final h k1;
    public static final h l;
    public static final h l0;
    public static final h l1;
    public static final h m;
    public static final h m0;
    public static final h m1;
    public static final h n;
    public static final h n0;
    public static final h n1;
    public static final h o;
    public static final h o0;
    public static final h o1;
    public static final h p;
    public static final h p0;
    public static final h p1;
    public static final h q;
    public static final h q0;
    public static final h q1;
    public static final h r;
    public static final h r0;
    public static final h r1;
    public static final h s;
    public static final h s0;
    public static final h s1;
    public static final h t;
    public static final h t0;
    public static final h u;
    public static final h u0;
    public static final h v;
    public static final h v0;
    public static final h w;
    public static final h w0;
    public static final h x;
    public static final h x0;
    public static final h y;
    public static final h y0;
    public static final h z;
    public static final h z0;
    private final String a;

    static {
        b b2;
        b = b2 = new b(null);
        c = new Comparator(){

            public int a(String string, String string2) {
                int n2;
                V2.k.e(string, "a");
                V2.k.e(string2, "b");
                int n3 = Math.min((int)string.length(), (int)string2.length());
                for (n2 = 4; n2 < n3; ++n2) {
                    char c2;
                    char c3 = string.charAt(n2);
                    if (c3 == (c2 = string2.charAt(n2))) continue;
                    if (V2.k.f(c3, c2) < 0) {
                        return -1;
                    }
                    return 1;
                }
                n2 = string.length();
                if (n2 != (n3 = string2.length())) {
                    if (n2 < n3) {
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
        };
        d = new LinkedHashMap();
        e = b2.d("SSL_RSA_WITH_NULL_MD5", 1);
        f = b2.d("SSL_RSA_WITH_NULL_SHA", 2);
        g = b2.d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        h = b2.d("SSL_RSA_WITH_RC4_128_MD5", 4);
        i = b2.d("SSL_RSA_WITH_RC4_128_SHA", 5);
        j = b2.d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        k = b2.d("SSL_RSA_WITH_DES_CBC_SHA", 9);
        l = b2.d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        m = b2.d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        n = b2.d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        o = b2.d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        p = b2.d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        q = b2.d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        r = b2.d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        s = b2.d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        t = b2.d("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        u = b2.d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        v = b2.d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        w = b2.d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        x = b2.d("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        y = b2.d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        z = b2.d("TLS_KRB5_WITH_RC4_128_SHA", 32);
        A = b2.d("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        B = b2.d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        C = b2.d("TLS_KRB5_WITH_RC4_128_MD5", 36);
        D = b2.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        E = b2.d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        F = b2.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        G = b2.d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        H = b2.d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        I = b2.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        J = b2.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        K = b2.d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        L = b2.d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        M = b2.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        N = b2.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        O = b2.d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        P = b2.d("TLS_RSA_WITH_NULL_SHA256", 59);
        Q = b2.d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        R = b2.d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        S = b2.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        T = b2.d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        U = b2.d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        V = b2.d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        W = b2.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        X = b2.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        Y = b2.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        Z = b2.d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        a0 = b2.d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        b0 = b2.d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        c0 = b2.d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        d0 = b2.d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        e0 = b2.d("TLS_PSK_WITH_RC4_128_SHA", 138);
        f0 = b2.d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        g0 = b2.d("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        h0 = b2.d("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        i0 = b2.d("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        j0 = b2.d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        k0 = b2.d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        l0 = b2.d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        m0 = b2.d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        n0 = b2.d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        o0 = b2.d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        p0 = b2.d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        q0 = b2.d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        r0 = b2.d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        s0 = b2.d("TLS_FALLBACK_SCSV", 22016);
        t0 = b2.d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        u0 = b2.d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        v0 = b2.d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        w0 = b2.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        x0 = b2.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        y0 = b2.d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        z0 = b2.d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        A0 = b2.d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        B0 = b2.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        C0 = b2.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        D0 = b2.d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        E0 = b2.d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        F0 = b2.d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        G0 = b2.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        H0 = b2.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        I0 = b2.d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        J0 = b2.d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        K0 = b2.d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        L0 = b2.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        M0 = b2.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        N0 = b2.d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        O0 = b2.d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        P0 = b2.d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        Q0 = b2.d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        R0 = b2.d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        S0 = b2.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        T0 = b2.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        U0 = b2.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        V0 = b2.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        W0 = b2.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        X0 = b2.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        Y0 = b2.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        Z0 = b2.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        a1 = b2.d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        b1 = b2.d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        c1 = b2.d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        d1 = b2.d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        e1 = b2.d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f1 = b2.d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        g1 = b2.d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        h1 = b2.d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        i1 = b2.d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        j1 = b2.d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        k1 = b2.d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        l1 = b2.d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        m1 = b2.d("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        n1 = b2.d("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        o1 = b2.d("TLS_AES_128_GCM_SHA256", 4865);
        p1 = b2.d("TLS_AES_256_GCM_SHA384", 4866);
        q1 = b2.d("TLS_CHACHA20_POLY1305_SHA256", 4867);
        r1 = b2.d("TLS_AES_128_CCM_SHA256", 4868);
        s1 = b2.d("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    private h(String string) {
        this.a = string;
    }

    public /* synthetic */ h(String string, g g2) {
        this(string);
    }

    public final String c() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        private final h d(String string, int n2) {
            h h2 = new h(string, null);
            d.put((Object)string, (Object)h2);
            return h2;
        }

        private final String e(String string) {
            if (b3.h.E(string, "TLS_", false, 2, null)) {
                string = string.substring(4);
                V2.k.d(string, "this as java.lang.String).substring(startIndex)");
                return V2.k.j("SSL_", string);
            }
            String string2 = string;
            if (b3.h.E(string, "SSL_", false, 2, null)) {
                string = string.substring(4);
                V2.k.d(string, "this as java.lang.String).substring(startIndex)");
                string2 = V2.k.j("TLS_", string);
            }
            return string2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final h b(String string) {
            b b2 = this;
            synchronized (b2) {
                Throwable throwable2;
                block5: {
                    h h2;
                    block3: {
                        block4: {
                            try {
                                h h3;
                                V2.k.e(string, "javaName");
                                h2 = h3 = (h)d.get((Object)string);
                                if (h3 != null) break block3;
                                h2 = h3 = (h)d.get((Object)this.e(string));
                                if (h3 != null) break block4;
                                h2 = new h(string, null);
                            }
                            catch (Throwable throwable2) {
                                break block5;
                            }
                        }
                        d.put((Object)string, (Object)h2);
                    }
                    return h2;
                }
                throw throwable2;
            }
        }

        public final Comparator c() {
            return c;
        }
    }
}

