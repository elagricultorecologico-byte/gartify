/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.r
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateParsingException
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Locale
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLException
 *  javax.net.ssl.SSLSession
 */
package y3;

import I2.o;
import V2.k;
import androidx.activity.r;
import b3.h;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import n3.a;
import z3.z;

public final class d
implements HostnameVerifier {
    public static final d a = new d();

    private d() {
    }

    private final String b(String string) {
        String string2 = string;
        if (this.d(string)) {
            string2 = Locale.US;
            k.d(string2, "US");
            string2 = string.toLowerCase((Locale)string2);
            k.d(string2, "this as java.lang.String).toLowerCase(locale)");
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final List c(X509Certificate x509Certificate, int n2) {
        try {
            Collection collection = x509Certificate.getSubjectAlternativeNames();
            if (collection == null) {
                return o.g();
            }
            x509Certificate = new ArrayList();
            collection = collection.iterator();
            while (true) {
                if (!collection.hasNext()) {
                    return x509Certificate;
                }
                Object object = (List)collection.next();
                if (object == null || object.size() < 2 || !k.a(object.get(0), n2) || (object = object.get(1)) == null) continue;
                x509Certificate.add((Object)((String)object));
            }
        }
        catch (CertificateParsingException certificateParsingException) {
            return o.g();
        }
    }

    private final boolean d(String string) {
        return string.length() == (int)z.b(string, 0, 0, 3, null);
    }

    private final boolean f(String string, String string2) {
        if (!(string == null || string.length() == 0 || h.E(string, ".", false, 2, null) || h.t(string, "..", false, 2, null) || string2 == null || string2.length() == 0 || h.E(string2, ".", false, 2, null) || h.t(string2, "..", false, 2, null))) {
            String string3 = string;
            if (!h.t(string, ".", false, 2, null)) {
                string3 = k.j(string, ".");
            }
            string = string2;
            if (!h.t(string2, ".", false, 2, null)) {
                string = k.j(string2, ".");
            }
            if (!h.J(string = this.b(string), "*", false, 2, null)) {
                return k.a(string3, string);
            }
            if (h.E(string, "*.", false, 2, null) && h.R(string, '*', 1, false, 4, null) == -1) {
                if (string3.length() < string.length()) {
                    return false;
                }
                if (k.a("*.", string)) {
                    return false;
                }
                string = string.substring(1);
                k.d(string, "this as java.lang.String).substring(startIndex)");
                if (!h.t(string3, string, false, 2, null)) {
                    return false;
                }
                int n2 = string3.length() - string.length();
                return n2 <= 0 || h.W(string3, '.', n2 - 1, false, 4, null) == -1;
            }
        }
        return false;
    }

    private final boolean g(String string, X509Certificate object2) {
        string = this.b(string);
        if (r.a((Object)(object2 = this.c((X509Certificate)object2, 2))) && object2.isEmpty()) {
            return false;
        }
        for (Object object2 : object2) {
            if (!a.f(string, (String)object2)) continue;
            return true;
        }
        return false;
    }

    private final boolean h(String string, X509Certificate x509Certificate) {
        string = n3.a.e(string);
        if (r.a((Object)(x509Certificate = this.c(x509Certificate, 7))) && x509Certificate.isEmpty()) {
            return false;
        }
        x509Certificate = x509Certificate.iterator();
        while (x509Certificate.hasNext()) {
            if (!k.a(string, n3.a.e((String)x509Certificate.next()))) continue;
            return true;
        }
        return false;
    }

    public final List a(X509Certificate x509Certificate) {
        k.e(x509Certificate, "certificate");
        return o.G((Collection)this.c(x509Certificate, 7), (Iterable)this.c(x509Certificate, 2));
    }

    public final boolean e(String string, X509Certificate x509Certificate) {
        k.e(string, "host");
        k.e(x509Certificate, "certificate");
        if (n3.d.i(string)) {
            return this.h(string, x509Certificate);
        }
        return this.g(string, x509Certificate);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean verify(String object, SSLSession sSLSession) {
        block6: {
            Certificate certificate;
            k.e(object, "host");
            k.e(certificate, "session");
            boolean bl = this.d((String)object);
            boolean bl2 = false;
            if (!bl) {
                return false;
            }
            try {
                certificate = certificate.getPeerCertificates()[0];
                if (certificate == null) break block6;
            }
            catch (SSLException sSLException) {
                return bl2;
            }
            bl = this.e((String)object, (X509Certificate)certificate);
            return bl;
        }
        NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        throw nullPointerException;
    }
}

