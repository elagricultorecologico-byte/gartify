/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.security.GeneralSecurityException
 *  java.security.cert.X509Certificate
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package y3;

import V2.g;
import V2.k;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import y3.c;
import y3.e;

public final class a
extends c {
    public static final a c = new a(null);
    private final e b;

    public a(e e2) {
        k.e(e2, "trustRootIndex");
        this.b = e2;
    }

    private final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!k.a(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        }
        catch (GeneralSecurityException generalSecurityException) {
            return false;
        }
    }

    @Override
    public List a(List list, String string) {
        k.e(list, "chain");
        k.e(string, "hostname");
        string = new ArrayDeque((Collection)list);
        list = new ArrayList();
        Object object = string.removeFirst();
        k.d(object, "queue.removeFirst()");
        list.add(object);
        int n2 = 0;
        boolean bl = false;
        block0: while (n2 < 9) {
            block11: {
                block10: {
                    X509Certificate x509Certificate;
                    block9: {
                        ++n2;
                        object = (X509Certificate)list.get(list.size() - 1);
                        x509Certificate = this.b.a((X509Certificate)object);
                        if (x509Certificate == null) break block9;
                        if (list.size() > 1 || !k.a(object, x509Certificate)) {
                            list.add((Object)x509Certificate);
                        }
                        if (!this.b(x509Certificate, x509Certificate)) {
                            bl = true;
                            continue;
                        }
                        break block10;
                    }
                    x509Certificate = string.iterator();
                    k.d(x509Certificate, "queue.iterator()");
                    while (x509Certificate.hasNext()) {
                        Object object2 = x509Certificate.next();
                        if (object2 != null) {
                            if (!this.b((X509Certificate)object, (X509Certificate)(object2 = (X509Certificate)object2))) continue;
                            x509Certificate.remove();
                            list.add(object2);
                            continue block0;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    if (!bl) break block11;
                }
                return list;
            }
            throw new SSLPeerUnverifiedException(k.j("Failed to find a trusted cert that signed ", object));
        }
        throw new SSLPeerUnverifiedException(k.j("Certificate chain too long: ", list));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof a && k.a(((a)object).b, this.b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }
}

