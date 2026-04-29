/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.app.E
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package m3;

import I2.o;
import V2.g;
import V2.k;
import androidx.appcompat.app.E;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import y3.c;
import z3.e;

public final class f {
    public static final b c = new b(null);
    public static final f d = new a().a();
    private final Set a;
    private final c b;

    public f(Set set, c c2) {
        k.e(set, "pins");
        this.a = set;
        this.b = c2;
    }

    public /* synthetic */ f(Set set, c c2, int n2, g g2) {
        if ((n2 & 2) != 0) {
            c2 = null;
        }
        this(set, c2);
    }

    public final void a(String string, List list) {
        k.e(string, "hostname");
        k.e(list, "peerCertificates");
        this.b(string, new U2.a(this, list, string){
            final f h;
            final List i;
            final String j;
            {
                this.h = f2;
                this.i = list;
                this.j = string;
                super(0);
            }

            public final List b() {
                c c2 = this.h.d();
                c2 = c2 == null ? null : c2.a(this.i, this.j);
                c c3 = c2;
                if (c2 == null) {
                    c3 = this.i;
                }
                c2 = new ArrayList(o.o((Iterable)c3, 10));
                c3 = c3.iterator();
                while (c3.hasNext()) {
                    c2.add((X509Certificate)((Certificate)c3.next()));
                }
                return c2;
            }
        });
    }

    public final void b(String string, U2.a a2) {
        X509Certificate x509Certificate;
        k.e(string, "hostname");
        k.e(a2, "cleanedPeerCertificatesFn");
        List list = this.c(string);
        if (list.isEmpty()) {
            return;
        }
        a2 = (List)a2.a();
        Iterator iterator = a2.iterator();
        while (iterator.hasNext()) {
            x509Certificate = (X509Certificate)iterator.next();
            x509Certificate = list.iterator();
            if (!x509Certificate.hasNext()) continue;
            E.a((Object)x509Certificate.next());
            throw null;
        }
        iterator = new StringBuilder();
        iterator.append("Certificate pinning failure!");
        iterator.append("\n  Peer certificate chain:");
        x509Certificate = a2.iterator();
        while (x509Certificate.hasNext()) {
            a2 = (X509Certificate)x509Certificate.next();
            iterator.append("\n    ");
            iterator.append(c.a((Certificate)a2));
            iterator.append(": ");
            iterator.append(a2.getSubjectDN().getName());
        }
        iterator.append("\n  Pinned certificates for ");
        iterator.append(string);
        iterator.append(":");
        string = list.iterator();
        while (string.hasNext()) {
            E.a((Object)string.next());
            iterator.append("\n    ");
            iterator.append(null);
        }
        string = iterator.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final List c(String string) {
        k.e(string, "hostname");
        Set set = this.a;
        string = o.g();
        set = set.iterator();
        if (!set.hasNext()) {
            return string;
        }
        E.a((Object)set.next());
        throw null;
    }

    public final c d() {
        return this.b;
    }

    public final f e(c c2) {
        k.e(c2, "certificateChainCleaner");
        if (k.a(this.b, c2)) {
            return this;
        }
        return new f(this.a, c2);
    }

    public boolean equals(Object object) {
        if (object instanceof f) {
            object = (f)object;
            if (k.a(((f)object).a, this.a) && k.a(((f)object).b, this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n2 = this.a.hashCode();
        c c2 = this.b;
        int n3 = c2 != null ? c2.hashCode() : 0;
        return (1517 + n2) * 41 + n3;
    }

    public static final class a {
        private final List a = new ArrayList();

        public final f a() {
            return new f(o.N((Iterable)this.a), null, 2, null);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        public final String a(Certificate certificate) {
            k.e(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return k.j("sha256/", this.b((X509Certificate)certificate).d());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }

        public final e b(X509Certificate object) {
            k.e(object, "<this>");
            e.a a2 = e.j;
            object = object.getPublicKey().getEncoded();
            k.d(object, "publicKey.encoded");
            return e.a.e(a2, (byte[])object, 0, 0, 3, null).t();
        }
    }
}

