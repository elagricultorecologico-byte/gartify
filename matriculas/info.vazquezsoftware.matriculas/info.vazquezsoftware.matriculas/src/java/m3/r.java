/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLSession
 */
package m3;

import H2.e;
import H2.f;
import I2.o;
import V2.g;
import V2.k;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import m3.D;
import m3.h;
import n3.d;

public final class r {
    public static final a e = new a(null);
    private final D a;
    private final h b;
    private final List c;
    private final e d;

    public r(D d2, h h2, List list, U2.a a2) {
        k.e((Object)d2, "tlsVersion");
        k.e(h2, "cipherSuite");
        k.e(list, "localCertificates");
        k.e(a2, "peerCertificatesFn");
        this.a = d2;
        this.b = h2;
        this.c = list;
        this.d = f.a(new U2.a(a2){
            final U2.a h;
            {
                this.h = a2;
                super(0);
            }

            public final List b() {
                try {
                    List list = (List)this.h.a();
                    return list;
                }
                catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
                    return o.g();
                }
            }
        });
    }

    private final String b(Certificate object) {
        if (object instanceof X509Certificate) {
            return ((X509Certificate)object).getSubjectDN().toString();
        }
        object = object.getType();
        k.d(object, "type");
        return object;
    }

    public final h a() {
        return this.b;
    }

    public final List c() {
        return this.c;
    }

    public final List d() {
        return (List)this.d.getValue();
    }

    public final D e() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object instanceof r) {
            object = (r)object;
            if (((r)object).a == this.a && k.a(((r)object).b, this.b) && k.a(((r)object).d(), this.d()) && k.a(((r)object).c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.d().hashCode()) * 31 + this.c.hashCode();
    }

    public String toString() {
        Object object = this.d();
        ArrayList arrayList = new ArrayList(o.o((Iterable)object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add((Object)this.b((Certificate)object.next()));
        }
        object = arrayList.toString();
        arrayList = new StringBuilder();
        arrayList.append("Handshake{tlsVersion=");
        arrayList.append((Object)this.a);
        arrayList.append(" cipherSuite=");
        arrayList.append((Object)this.b);
        arrayList.append(" peerCertificates=");
        arrayList.append((String)object);
        arrayList.append(" localCertificates=");
        List list = this.c;
        object = new ArrayList(o.o((Iterable)list, 10));
        list = list.iterator();
        while (list.hasNext()) {
            object.add((Object)this.b((Certificate)list.next()));
        }
        arrayList.append(object);
        arrayList.append('}');
        return arrayList.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        private final List b(Certificate[] certificateArray) {
            if (certificateArray != null) {
                return n3.d.w(Arrays.copyOf((Object[])certificateArray, (int)certificateArray.length));
            }
            return o.g();
        }

        public final r a(SSLSession sSLSession) {
            k.e(sSLSession, "<this>");
            String string = sSLSession.getCipherSuite();
            if (string != null) {
                boolean bl = k.a(string, "TLS_NULL_WITH_NULL_NULL") ? true : k.a(string, "SSL_NULL_WITH_NULL_NULL");
                if (!bl) {
                    h h2 = h.b.b(string);
                    string = sSLSession.getProtocol();
                    if (string != null) {
                        if (!k.a("NONE", string)) {
                            D d2 = D.h.a(string);
                            try {
                                string = this.b(sSLSession.getPeerCertificates());
                            }
                            catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
                                string = o.g();
                            }
                            return new r(d2, h2, this.b(sSLSession.getLocalCertificates()), new U2.a((List)string){
                                final List h;
                                {
                                    this.h = list;
                                    super(0);
                                }

                                public final List b() {
                                    return this.h;
                                }
                            });
                        }
                        throw new IOException("tlsVersion == NONE");
                    }
                    throw new IllegalStateException("tlsVersion == null");
                }
                throw new IOException(k.j("cipherSuite == ", string));
            }
            throw new IllegalStateException("cipherSuite == null");
        }
    }
}

