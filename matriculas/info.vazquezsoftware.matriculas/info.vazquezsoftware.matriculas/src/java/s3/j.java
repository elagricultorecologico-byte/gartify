/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.net.ProtocolException
 *  java.net.Proxy$Type
 *  java.net.SocketTimeoutException
 *  java.security.cert.CertificateException
 *  javax.net.ssl.SSLHandshakeException
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package s3;

import V2.k;
import b3.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import m3.A;
import m3.C;
import m3.t;
import m3.u;
import m3.w;
import m3.y;
import m3.z;
import n3.d;
import r3.c;
import r3.e;
import s3.f;

public final class j
implements u {
    public static final a b = new a(null);
    private final w a;

    public j(w w2) {
        k.e(w2, "client");
        this.a = w2;
    }

    private final y b(A a2, String string) {
        boolean bl = this.a.q();
        z z2 = null;
        if (!bl) {
            return null;
        }
        Object object = A.L(a2, "Location", null, 2, null);
        if (object == null) {
            return null;
        }
        t t2 = a2.i0().i().o((String)object);
        if (t2 == null) {
            return null;
        }
        if (!k.a(t2.p(), a2.i0().i().p()) && !this.a.r()) {
            return null;
        }
        object = a2.i0().h();
        if (f.a(string)) {
            int n2 = a2.p();
            f f2 = f.a;
            boolean bl2 = f2.c(string) || n2 == 308 || n2 == 307;
            if (f2.b(string) && n2 != 308 && n2 != 307) {
                ((y.a)object).f("GET", null);
            } else {
                if (bl2) {
                    z2 = a2.i0().a();
                }
                ((y.a)object).f(string, z2);
            }
            if (!bl2) {
                ((y.a)object).h("Transfer-Encoding");
                ((y.a)object).h("Content-Length");
                ((y.a)object).h("Content-Type");
            }
        }
        if (!d.j(a2.i0().i(), t2)) {
            ((y.a)object).h("Authorization");
        }
        return ((y.a)object).n(t2).b();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final y c(A a2, c object) {
        Object object2;
        object2 = object == null || (object2 = ((c)object).h()) == null ? null : ((r3.f)object2).z();
        int n2 = a2.p();
        String string = a2.i0().g();
        if (n2 == 307) return this.b(a2, string);
        if (n2 == 308) return this.b(a2, string);
        if (n2 == 401) return this.a.c().a((C)object2, a2);
        if (n2 != 421) {
            if (n2 != 503) {
                if (n2 == 407) {
                    k.b(object2);
                    if (((C)object2).b().type() != Proxy.Type.HTTP) throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    return this.a.A().a((C)object2, a2);
                }
                if (n2 != 408) {
                    switch (n2) {
                        default: {
                            return null;
                        }
                        case 300: 
                        case 301: 
                        case 302: 
                        case 303: 
                    }
                    return this.b(a2, string);
                }
                if (!this.a.D()) {
                    return null;
                }
                object = a2.i0().a();
                if (object != null && ((z)object).e()) {
                    return null;
                }
                object = a2.a0();
                if (object != null && ((A)object).p() == 408) {
                    return null;
                }
                if (this.g(a2, 0) <= 0) return a2.i0();
                return null;
            }
            object = a2.a0();
            if (object != null && ((A)object).p() == 503) {
                return null;
            }
            if (this.g(a2, Integer.MAX_VALUE) != 0) return null;
            return a2.i0();
        }
        object2 = a2.i0().a();
        if (object2 != null && ((z)object2).e()) {
            return null;
        }
        if (object == null) return null;
        if (!((c)object).k()) {
            return null;
        }
        ((c)object).h().x();
        return a2.i0();
    }

    private final boolean d(IOException iOException, boolean bl) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return iOException instanceof SocketTimeoutException && !bl;
        }
        if (iOException instanceof SSLHandshakeException && iOException.getCause() instanceof CertificateException) {
            return false;
        }
        return !(iOException instanceof SSLPeerUnverifiedException);
    }

    private final boolean e(IOException iOException, e e2, y y2, boolean bl) {
        if (!this.a.D()) {
            return false;
        }
        if (bl && this.f(iOException, y2)) {
            return false;
        }
        if (!this.d(iOException, bl)) {
            return false;
        }
        return e2.v();
    }

    private final boolean f(IOException iOException, y object) {
        return (object = ((y)object).a()) != null && ((z)object).e() || iOException instanceof FileNotFoundException;
    }

    private final int g(A object, int n2) {
        if ((object = A.L((A)object, "Retry-After", null, 2, null)) == null) {
            return n2;
        }
        if (new g("\\d+").a((CharSequence)object)) {
            object = Integer.valueOf((String)object);
            k.d(object, "valueOf(header)");
            return object.intValue();
        }
        return Integer.MAX_VALUE;
    }

    /*
     * Exception decompiling
     */
    @Override
    public A a(u.a var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 3[TRYBLOCK] [5 : 105->121)] java.lang.Throwable
         *     at fc.i.L0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:227)
         *     at dc.f.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:196)
         *     at dc.f.c(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
         *     at dc.f.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:157)
         *     at md.e.l(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
         *     at kd.k.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
         *     at kd.f.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:179)
         *     at og.h.r0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:235)
         *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithCFR(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:784)
         *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:141)
         *     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
         *     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
         *     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1154)
         *     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:652)
         *     at java.lang.Thread.run(Thread.java:1564)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g2) {
            this();
        }
    }
}

