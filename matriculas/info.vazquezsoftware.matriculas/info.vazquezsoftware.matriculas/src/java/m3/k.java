/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 *  java.util.Objects
 *  javax.net.ssl.SSLSocket
 */
package m3;

import I2.o;
import V2.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import m3.D;
import m3.h;
import n3.d;

public final class k {
    public static final b e = new b(null);
    private static final h[] f;
    private static final h[] g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    private final boolean a;
    private final boolean b;
    private final String[] c;
    private final String[] d;

    static {
        h h2 = m3.h.o1;
        h h3 = m3.h.p1;
        Object object = m3.h.q1;
        Object object2 = m3.h.a1;
        Object object3 = m3.h.e1;
        h h4 = m3.h.b1;
        h h5 = m3.h.f1;
        h h6 = m3.h.l1;
        h h7 = m3.h.k1;
        Object[] objectArray = new h[]{h2, h3, object, object2, object3, h4, h5, h6, h7};
        f = objectArray;
        Object[] objectArray2 = new h[]{h2, h3, object, object2, object3, h4, h5, h6, h7, m3.h.L0, m3.h.M0, m3.h.j0, m3.h.k0, m3.h.H, m3.h.L, m3.h.l};
        g = objectArray2;
        object3 = new a(true).c((h[])Arrays.copyOf((Object[])objectArray, (int)objectArray.length));
        object2 = D.i;
        object = D.j;
        h = ((a)object3).j(new D[]{object2, object}).h(true).a();
        i = new a(true).c((h[])Arrays.copyOf((Object[])objectArray2, (int)objectArray2.length)).j(new D[]{object2, object}).h(true).a();
        j = new a(true).c((h[])Arrays.copyOf((Object[])objectArray2, (int)objectArray2.length)).j(new D[]{object2, object, D.k, D.l}).h(true).a();
        k = new a(false).a();
    }

    public k(boolean bl, boolean bl2, String[] stringArray, String[] stringArray2) {
        this.a = bl;
        this.b = bl2;
        this.c = stringArray;
        this.d = stringArray2;
    }

    private final k g(SSLSocket object, boolean bl) {
        Object[] objectArray;
        Object object2;
        if (this.c != null) {
            object2 = object.getEnabledCipherSuites();
            V2.k.d(object2, "sslSocket.enabledCipherSuites");
            object2 = n3.d.E((String[])object2, this.c, m3.h.b.c());
        } else {
            object2 = object.getEnabledCipherSuites();
        }
        if (this.d != null) {
            objectArray = object.getEnabledProtocols();
            V2.k.d(objectArray, "sslSocket.enabledProtocols");
            objectArray = n3.d.E((String[])objectArray, this.d, K2.a.b());
        } else {
            objectArray = object.getEnabledProtocols();
        }
        String[] stringArray = object.getSupportedCipherSuites();
        V2.k.d(stringArray, "supportedCipherSuites");
        int n2 = n3.d.x(stringArray, "TLS_FALLBACK_SCSV", m3.h.b.c());
        object = object2;
        if (bl) {
            object = object2;
            if (n2 != -1) {
                V2.k.d(object2, "cipherSuitesIntersection");
                object = stringArray[n2];
                V2.k.d(object, "supportedCipherSuites[indexOfFallbackScsv]");
                object = n3.d.o((String[])object2, (String)object);
            }
        }
        object2 = new a(this);
        V2.k.d(object, "cipherSuitesIntersection");
        object = ((a)object2).b((String[])Arrays.copyOf((Object[])object, (int)((String[])object).length));
        V2.k.d(objectArray, "tlsVersionsIntersection");
        return ((a)object).i((String[])Arrays.copyOf((Object[])objectArray, (int)objectArray.length)).a();
    }

    public final void c(SSLSocket sSLSocket, boolean bl) {
        V2.k.e(sSLSocket, "sslSocket");
        k k2 = this.g(sSLSocket, bl);
        if (k2.i() != null) {
            sSLSocket.setEnabledProtocols(k2.d);
        }
        if (k2.d() != null) {
            sSLSocket.setEnabledCipherSuites(k2.c);
        }
    }

    public final List d() {
        String[] stringArray = this.c;
        if (stringArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(stringArray.length);
        for (String string : stringArray) {
            arrayList.add((Object)m3.h.b.b(string));
        }
        return o.K((Iterable)arrayList);
    }

    public final boolean e(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "socket");
        if (!this.a) {
            return false;
        }
        String[] stringArray = this.d;
        if (stringArray != null && !n3.d.u(stringArray, sSLSocket.getEnabledProtocols(), K2.a.b())) {
            return false;
        }
        stringArray = this.c;
        return stringArray == null || n3.d.u(stringArray, sSLSocket.getEnabledCipherSuites(), m3.h.b.c());
    }

    public boolean equals(Object object) {
        if (!(object instanceof k)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        boolean bl = this.a;
        object = (k)object;
        if (bl != ((k)object).a) {
            return false;
        }
        if (bl) {
            if (!Arrays.equals((Object[])this.c, (Object[])((k)object).c)) {
                return false;
            }
            if (!Arrays.equals((Object[])this.d, (Object[])((k)object).d)) {
                return false;
            }
            if (this.b != ((k)object).b) {
                return false;
            }
        }
        return true;
    }

    public final boolean f() {
        return this.a;
    }

    public final boolean h() {
        return this.b;
    }

    public int hashCode() {
        if (this.a) {
            Object[] objectArray = this.c;
            int n2 = 0;
            int n3 = objectArray == null ? 0 : Arrays.hashCode((Object[])objectArray);
            objectArray = this.d;
            if (objectArray != null) {
                n2 = Arrays.hashCode((Object[])objectArray);
            }
            return ((527 + n3) * 31 + n2) * 31 + (this.b ^ 1);
        }
        return 17;
    }

    public final List i() {
        String[] stringArray = this.d;
        if (stringArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(stringArray.length);
        for (String string : stringArray) {
            arrayList.add((Object)D.h.a(string));
        }
        return o.K((Iterable)arrayList);
    }

    public String toString() {
        if (!this.a) {
            return "ConnectionSpec()";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectionSpec(cipherSuites=");
        stringBuilder.append((Object)Objects.toString((Object)this.d(), (String)"[all enabled]"));
        stringBuilder.append(", tlsVersions=");
        stringBuilder.append((Object)Objects.toString((Object)this.i(), (String)"[all enabled]"));
        stringBuilder.append(", supportsTlsExtensions=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public static final class a {
        private boolean a;
        private String[] b;
        private String[] c;
        private boolean d;

        public a(k k2) {
            V2.k.e(k2, "connectionSpec");
            this.a = k2.f();
            this.b = k2.c;
            this.c = k2.d;
            this.d = k2.h();
        }

        public a(boolean bl) {
            this.a = bl;
        }

        public final k a() {
            return new k(this.a, this.d, this.b, this.c);
        }

        public final a b(String ... stringArray) {
            V2.k.e(stringArray, "cipherSuites");
            if (this.d()) {
                boolean bl = stringArray.length == 0;
                if (!bl) {
                    this.e((String[])stringArray.clone());
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }

        public final a c(h ... objectArray) {
            V2.k.e(objectArray, "cipherSuites");
            if (this.d()) {
                ArrayList arrayList = new ArrayList(objectArray.length);
                int n2 = objectArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    arrayList.add((Object)objectArray[i2].c());
                }
                objectArray = arrayList.toArray((Object[])new String[0]);
                if (objectArray != null) {
                    objectArray = (String[])objectArray;
                    return this.b((String[])Arrays.copyOf((Object[])objectArray, (int)objectArray.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }

        public final boolean d() {
            return this.a;
        }

        public final void e(String[] stringArray) {
            this.b = stringArray;
        }

        public final void f(boolean bl) {
            this.d = bl;
        }

        public final void g(String[] stringArray) {
            this.c = stringArray;
        }

        public final a h(boolean bl) {
            if (this.d()) {
                this.f(bl);
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }

        public final a i(String ... stringArray) {
            V2.k.e(stringArray, "tlsVersions");
            if (this.d()) {
                boolean bl = stringArray.length == 0;
                if (!bl) {
                    this.g((String[])stringArray.clone());
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }

        public final a j(D ... objectArray) {
            V2.k.e(objectArray, "tlsVersions");
            if (this.d()) {
                ArrayList arrayList = new ArrayList(objectArray.length);
                int n2 = objectArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    arrayList.add((Object)objectArray[i2].e());
                }
                objectArray = arrayList.toArray((Object[])new String[0]);
                if (objectArray != null) {
                    objectArray = (String[])objectArray;
                    return this.i((String[])Arrays.copyOf((Object[])objectArray, (int)objectArray.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }
    }
}

