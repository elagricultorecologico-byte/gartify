/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.security.cert.X509Certificate
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Set
 *  javax.security.auth.x500.X500Principal
 */
package y3;

import V2.k;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import y3.e;

public final class b
implements e {
    private final Map a;

    public b(X509Certificate ... x509CertificateArray) {
        k.e(x509CertificateArray, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int n2 = x509CertificateArray.length;
        int n3 = 0;
        while (n3 < n2) {
            Object object;
            X509Certificate x509Certificate = x509CertificateArray[n3];
            ++n3;
            X500Principal x500Principal = x509Certificate.getSubjectX500Principal();
            k.d(x500Principal, "caCert.subjectX500Principal");
            Object object2 = object = linkedHashMap.get((Object)x500Principal);
            if (object == null) {
                object2 = new LinkedHashSet();
                linkedHashMap.put((Object)x500Principal, object2);
            }
            ((Set)object2).add((Object)x509Certificate);
        }
        this.a = linkedHashMap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public X509Certificate a(X509Certificate x509Certificate) {
        k.e(x509Certificate, "cert");
        Object object = x509Certificate.getIssuerX500Principal();
        object = (Set)this.a.get(object);
        Object var3_4 = null;
        if (object == null) {
            return null;
        }
        Iterator iterator = object.iterator();
        while (true) {
            object = var3_4;
            if (!iterator.hasNext()) return (X509Certificate)object;
            object = iterator.next();
            X509Certificate x509Certificate2 = (X509Certificate)object;
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
            }
            catch (Exception exception) {
                continue;
            }
            return (X509Certificate)object;
        }
    }

    public boolean equals(Object object) {
        return object == this || object instanceof b && k.a(((b)object).a, this.a);
        {
        }
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

