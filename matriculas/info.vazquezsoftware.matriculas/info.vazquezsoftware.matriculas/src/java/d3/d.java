/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.app.E
 *  java.io.BufferedWriter
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.CookieManager
 *  java.net.HttpURLConnection
 *  java.net.IDN
 *  java.net.MalformedURLException
 *  java.net.Proxy
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.regex.Pattern
 *  java.util.zip.GZIPInputStream
 *  java.util.zip.Inflater
 *  java.util.zip.InflaterInputStream
 *  javax.net.ssl.HttpsURLConnection
 *  javax.net.ssl.SSLSocketFactory
 */
package D3;

import C3.a;
import D3.e;
import E3.a;
import F3.f;
import G3.g;
import G3.j;
import androidx.appcompat.app.E;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class d
implements C3.a {
    private static final Charset c = Charset.forName((String)"UTF-8");
    private static final Charset d = Charset.forName((String)"ISO-8859-1");
    private c a;
    private a.d b;

    public d() {
        this.a = new c();
    }

    private d(c c2, d d2) {
        this.a = c2;
        this.b = d2;
    }

    public static C3.a g(String string) {
        d d2 = new d();
        d2.a(string);
        return d2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String h(String string) {
        try {
            URL uRL = new URL(string);
            String string2 = D3.d.i(uRL).toExternalForm();
            return string2;
        }
        catch (Exception exception) {
            return string;
        }
    }

    static URL i(URL uRL) {
        uRL = D3.d.l(uRL);
        try {
            String string = uRL.toExternalForm().replace((CharSequence)" ", (CharSequence)"%20");
            URI uRI = new URI(string);
            uRI = new URL(uRI.toASCIIString());
            return uRI;
        }
        catch (MalformedURLException | URISyntaxException throwable) {
            return uRL;
        }
    }

    private static boolean k(a.c c2) {
        if (!(c2 = c2.h().iterator()).hasNext()) {
            return false;
        }
        E.a((Object)c2.next());
        throw null;
    }

    private static URL l(URL uRL) {
        if (!E3.c.f(uRL.getHost())) {
            try {
                String string = IDN.toASCII((String)uRL.getHost());
                uRL = new URL(uRL.getProtocol(), string, uRL.getPort(), uRL.getFile());
                return uRL;
            }
            catch (MalformedURLException malformedURLException) {
                throw new IllegalArgumentException((Throwable)malformedURLException);
            }
        }
        return uRL;
    }

    @Override
    public C3.a a(String string) {
        e.i(string, "Must supply a valid URL");
        try {
            c c2 = this.a;
            URL uRL = new URL(D3.d.h(string));
            c2.i(uRL);
            return this;
        }
        catch (MalformedURLException malformedURLException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Malformed URL: ");
            stringBuilder.append(string);
            throw new IllegalArgumentException(stringBuilder.toString(), (Throwable)malformedURLException);
        }
    }

    @Override
    public C3.a b(int n2) {
        this.a.L(n2);
        return this;
    }

    @Override
    public f get() {
        this.a.s(a.b.h);
        this.j();
        e.j(this.b);
        return this.b.c();
    }

    public a.d j() {
        d d2 = D3.d$d.A(this.a);
        this.b = d2;
        return d2;
    }

    private static abstract class b
    implements a.a {
        private static final URL e;
        URL a = e;
        a.b b = a.b.h;
        Map c = new LinkedHashMap();
        Map d = new LinkedHashMap();

        static {
            try {
                URL uRL;
                e = uRL = new URL("http://undefined/");
                return;
            }
            catch (MalformedURLException malformedURLException) {
                throw new IllegalStateException((Throwable)malformedURLException);
            }
        }

        private b() {
        }

        private static String l(String string) {
            byte[] byArray = string.getBytes(d);
            if (!D3.d$b.r(byArray)) {
                return string;
            }
            return new String(byArray, c);
        }

        private List m(String string) {
            D3.e.j(string);
            for (Map.Entry entry : this.c.entrySet()) {
                if (!string.equalsIgnoreCase((String)entry.getKey())) continue;
                return (List)entry.getValue();
            }
            return Collections.EMPTY_LIST;
        }

        private static boolean r(byte[] byArray) {
            int n2 = byArray.length;
            int n3 = 3;
            if (n2 < 3 || (byArray[0] & 0xFF) != 239 || (byArray[1] & 0xFF) != 187 || (byArray[2] & 0xFF) != 191) {
                n3 = 0;
            }
            int n4 = byArray.length;
            while (n3 < n4) {
                block10: {
                    int n5;
                    block5: {
                        block8: {
                            block9: {
                                block7: {
                                    block6: {
                                        n2 = byArray[n3];
                                        if ((n2 & 0x80) != 0) break block6;
                                        n5 = n3;
                                        break block5;
                                    }
                                    if ((n2 & 0xE0) != 192) break block7;
                                    n2 = n3 + 1;
                                    break block8;
                                }
                                if ((n2 & 0xF0) != 224) break block9;
                                n2 = n3 + 2;
                                break block8;
                            }
                            if ((n2 & 0xF8) != 240) break block10;
                            n2 = n3 + 3;
                        }
                        if (n2 >= byArray.length) {
                            return false;
                        }
                        do {
                            n5 = n3;
                            if (n3 >= n2) break block5;
                            n3 = n5 = n3 + 1;
                        } while ((byArray[n5] & 0xC0) == 128);
                        return false;
                    }
                    n3 = n5 + 1;
                    continue;
                }
                return false;
            }
            return true;
        }

        private Map.Entry w(String string3) {
            String string2 = E3.b.a(string3);
            for (String string3 : this.c.entrySet()) {
                if (!E3.b.a((String)string3.getKey()).equals((Object)string2)) continue;
                return string3;
            }
            return null;
        }

        @Override
        public Map a() {
            return this.d;
        }

        @Override
        public a.a d(String string, String string2) {
            D3.e.i(string, "Header name must not be empty");
            this.v(string);
            this.j(string, string2);
            return this;
        }

        @Override
        public URL e() {
            URL uRL = this.a;
            if (uRL != e) {
                return uRL;
            }
            throw new IllegalArgumentException("URL not set. Make sure to call #url(...) before executing the request.");
        }

        @Override
        public String f(String string) {
            D3.e.k(string, "Header name must not be null");
            string = this.m(string);
            if (string.size() > 0) {
                return E3.c.k((Collection)string, ", ");
            }
            return null;
        }

        @Override
        public a.a i(URL uRL) {
            D3.e.k(uRL, "URL must not be null");
            this.a = D3.d.l(uRL);
            return this;
        }

        public a.a j(String string, String string2) {
            D3.e.h(string);
            String string3 = string2;
            if (string2 == null) {
                string3 = "";
            }
            List list = this.q(string);
            string2 = list;
            if (list.isEmpty()) {
                string2 = new ArrayList();
                this.c.put((Object)string, (Object)string2);
            }
            string2.add((Object)D3.d$b.l(string3));
            return this;
        }

        public a.a k(String string, String string2) {
            D3.e.i(string, "Cookie name must not be empty");
            D3.e.k(string2, "Cookie value must not be null");
            this.d.put((Object)string, (Object)string2);
            return this;
        }

        public boolean n(String string) {
            D3.e.i(string, "Cookie name must not be empty");
            return this.d.containsKey((Object)string);
        }

        public boolean o(String string) {
            D3.e.i(string, "Header name must not be empty");
            return this.m(string).isEmpty() ^ true;
        }

        public boolean p(String string, String string2) {
            D3.e.h(string);
            D3.e.h(string2);
            string = this.q(string).iterator();
            while (string.hasNext()) {
                if (!string2.equalsIgnoreCase((String)string.next())) continue;
                return true;
            }
            return false;
        }

        public List q(String string) {
            D3.e.h(string);
            return this.m(string);
        }

        public a.a s(a.b b2) {
            D3.e.k((Object)b2, "Method must not be null");
            this.b = b2;
            return this;
        }

        public a.b t() {
            return this.b;
        }

        public Map u() {
            return this.c;
        }

        public a.a v(String string) {
            D3.e.i(string, "Header name must not be empty");
            string = this.w(string);
            if (string != null) {
                this.c.remove(string.getKey());
            }
            return this;
        }
    }

    public static class c
    extends b
    implements a.c {
        private Proxy f;
        private int g = 30000;
        private int h = 0x200000;
        private boolean i = true;
        private final Collection j;
        private String k = null;
        private boolean l = false;
        private boolean m = false;
        private g n;
        private boolean o = false;
        private String p = D3.c.c;
        private SSLSocketFactory q;
        private CookieManager r;
        private volatile boolean s = false;

        static {
            System.setProperty((String)"sun.net.http.allowRestrictedHeaders", (String)"true");
        }

        c() {
            this.j = new ArrayList();
            this.b = a.b.h;
            this.j("Accept-Encoding", "gzip");
            this.j("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
            this.n = G3.g.b();
            this.r = new CookieManager();
        }

        static /* synthetic */ boolean x(c c2) {
            return c2.s;
        }

        static /* synthetic */ boolean y(c c2, boolean bl) {
            c2.s = bl;
            return bl;
        }

        static /* synthetic */ boolean z(c c2) {
            return c2.o;
        }

        CookieManager A() {
            return this.r;
        }

        public boolean B() {
            return this.i;
        }

        public boolean C() {
            return this.m;
        }

        public boolean D() {
            return this.l;
        }

        public int E() {
            return this.h;
        }

        public c F(g g2) {
            this.n = g2;
            this.o = true;
            return this;
        }

        public g G() {
            return this.n;
        }

        public Proxy H() {
            return this.f;
        }

        public a.c I(String string) {
            this.k = string;
            return this;
        }

        public SSLSocketFactory J() {
            return this.q;
        }

        public int K() {
            return this.g;
        }

        public c L(int n2) {
            boolean bl = n2 >= 0;
            e.e(bl, "Timeout milliseconds must be 0 (infinite) or greater");
            this.g = n2;
            return this;
        }

        @Override
        public String b() {
            return this.p;
        }

        @Override
        public String g() {
            return this.k;
        }

        @Override
        public Collection h() {
            return this.j;
        }
    }

    public static class d
    extends b
    implements a.d {
        private static final Pattern q = Pattern.compile((String)"(application|text)/\\w*\\+?xml.*");
        private final int f;
        private final String g;
        private ByteBuffer h;
        private InputStream i;
        private HttpURLConnection j;
        private String k;
        private final String l;
        private boolean m = false;
        private boolean n = false;
        private int o = 0;
        private final c p;

        private d(HttpURLConnection httpURLConnection2, c c2, d d2) {
            this.j = httpURLConnection2;
            this.p = c2;
            this.b = a.b.valueOf(httpURLConnection2.getRequestMethod());
            this.a = httpURLConnection2.getURL();
            this.f = httpURLConnection2.getResponseCode();
            this.g = httpURLConnection2.getResponseMessage();
            this.l = httpURLConnection2.getContentType();
            httpURLConnection2 = D3.d$d.z(httpURLConnection2);
            this.C((Map)httpURLConnection2);
            D3.b.d(c2, this.a, (Map)httpURLConnection2);
            if (d2 != null) {
                int n2;
                for (HttpURLConnection httpURLConnection2 : d2.a().entrySet()) {
                    if (this.n((String)httpURLConnection2.getKey())) continue;
                    this.k((String)httpURLConnection2.getKey(), (String)httpURLConnection2.getValue());
                }
                d2.D();
                this.o = n2 = d2.o + 1;
                if (n2 >= 20) {
                    throw new IOException(String.format((String)"Too many redirects occurred trying to load URL %s", (Object[])new Object[]{d2.e()}));
                }
            }
        }

        static d A(c c2) {
            return D3.d$d.B(c2, null);
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static d B(c var0, d var1_1) {
            block29: {
                block27: {
                    block30: {
                        block28: {
                            block31: {
                                var11_3 = var0;
                                synchronized (var11_3) {
                                    e.c(D3.d$c.x(var0), "Multiple threads were detected trying to execute the same request concurrently. Make sure to use Connection#newRequest() and do not share an executing request between threads.");
                                    D3.d$c.y(var0, true);
                                }
                                e.k(var0, "Request must not be null");
                                var7_4 /* !! */  = var0.e();
                                e.k(var7_4 /* !! */ , "URL must be specified to connect");
                                var7_4 /* !! */  = var7_4 /* !! */ .getProtocol();
                                if (!var7_4 /* !! */ .equals((Object)"http") && !var7_4 /* !! */ .equals((Object)"https")) {
                                    throw new MalformedURLException("Only http & https protocols supported");
                                }
                                var4_8 = var0.t().d();
                                var3_9 = var0.g() != null;
                                if (!var4_8) {
                                    var7_4 /* !! */  = new StringBuilder();
                                    var7_4 /* !! */ .append("Cannot set a request body for HTTP method ");
                                    var7_4 /* !! */ .append((Object)var0.t());
                                    e.c(var3_9, var7_4 /* !! */ .toString());
                                }
                                var2_10 = var0.h().size();
                                var9_11 = null;
                                if (var2_10 <= 0 || var4_8 && !var3_9) break block31;
                                D3.d$d.E(var0);
                                ** GOTO lbl-1000
                            }
                            if (var4_8) {
                                var7_4 /* !! */  = D3.d$d.F(var0);
                            } else lbl-1000:
                            // 2 sources

                            {
                                var7_4 /* !! */  = null;
                            }
                            var5_12 = System.nanoTime();
                            var10_13 = D3.d$d.y(var0);
                            try {
                                block26: {
                                    try {
                                        var10_13.connect();
                                        if (!var10_13.getDoOutput()) break block26;
                                        D3.d$d.G(var0, var10_13.getOutputStream(), (String)var7_4 /* !! */ );
                                    }
                                    catch (IOException var7_5) {
                                        var1_1 /* !! */  = var9_11;
                                        break block27;
                                    }
                                }
                                var2_10 = var10_13.getResponseCode();
                                var8_14 = new d(var10_13, var0, (d)var1_1 /* !! */ );
                                try {
                                    if (var8_14.o("Location") && var0.B()) {
                                        if (var2_10 == 307) break block28;
                                        var0.s(a.b.h);
                                        var0.h().clear();
                                        var0.I(null);
                                        var0.v("Content-Type");
                                        break block28;
                                    }
                                    ** GOTO lbl-1000
                                }
                                catch (IOException var7_6) {
                                    var1_1 /* !! */  = var8_14;
                                    break block27;
                                }
                            }
                            catch (Throwable var1_2) {
                                break block29;
                            }
                        }
                        var7_4 /* !! */  = var8_14.f("Location");
                        e.j(var7_4 /* !! */ );
                        var1_1 /* !! */  = var7_4 /* !! */ ;
                        if (var7_4 /* !! */ .startsWith("http:/")) {
                            var1_1 /* !! */  = var7_4 /* !! */ ;
                            if (var7_4 /* !! */ .charAt(6) != '/') {
                                var1_1 /* !! */  = var7_4 /* !! */ .substring(6);
                            }
                        }
                        var0.i(D3.d.i(E3.c.p(var0.e(), (String)var1_1 /* !! */ )));
                        D3.d$c.y(var0, false);
                        var1_1 /* !! */  = D3.d$d.B(var0, var8_14);
                        D3.d$c.y(var0, false);
                        return var1_1 /* !! */ ;
lbl-1000:
                        // 1 sources

                        {
                            if ((var2_10 < 200 || var2_10 >= 400) && !var0.D()) ** GOTO lbl-1000
                            var1_1 /* !! */  = var8_14.x();
                            if (!(var1_1 /* !! */  == null || var0.C() || var1_1 /* !! */ .startsWith("text/") || D3.d$d.q.matcher((CharSequence)var1_1 /* !! */ ).matches())) {
                                var7_4 /* !! */  = new C3.f("Unhandled content type. Must be text/*, application/xml, or application/*+xml", (String)var1_1 /* !! */ , var0.e().toString());
                                throw var7_4 /* !! */ ;
                            }
                            if (var1_1 /* !! */  != null && D3.d$d.q.matcher((CharSequence)var1_1 /* !! */ ).matches() && !D3.d$c.z(var0)) {
                                var0.F(G3.g.g());
                            }
                            var8_14.k = D3.c.c(var8_14.l);
                            if (var10_13.getContentLength() != 0 && var0.t() != a.b.m) {
                                var1_1 /* !! */  = var10_13.getErrorStream() != null ? var10_13.getErrorStream() : var10_13.getInputStream();
                                var8_14.i = var1_1 /* !! */ ;
                                e.j(var1_1 /* !! */ );
                                if (var8_14.p("Content-Encoding", "gzip")) {
                                    var1_1 /* !! */  = new GZIPInputStream(var8_14.i);
                                    var8_14.i = var1_1 /* !! */ ;
                                } else if (var8_14.p("Content-Encoding", "deflate")) {
                                    var1_1 /* !! */  = var8_14.i;
                                    var9_11 = new Inflater(true);
                                    var7_4 /* !! */  = new InflaterInputStream((InputStream)var1_1 /* !! */ , var9_11);
                                    var8_14.i = var7_4 /* !! */ ;
                                }
                                var8_14.i = E3.a.j(var8_14.i, 32768, var0.E()).i(var5_12, var0.K());
                                break block30;
                            }
                            var8_14.h = D3.c.b();
                        }
                    }
                    D3.d$c.y(var0, false);
                    var8_14.m = true;
                    return var8_14;
lbl-1000:
                    // 1 sources

                    {
                        var1_1 /* !! */  = new C3.b("HTTP error fetching URL", var2_10, var0.e().toString());
                        throw var1_1 /* !! */ ;
                    }
                }
                if (var1_1 /* !! */  != null) {
                    var1_1 /* !! */ .D();
                }
                throw var7_7;
            }
            D3.d$c.y(var0, false);
            throw var1_2;
        }

        /*
         * Unable to fully structure code
         */
        private void D() {
            var1_1 = this.i;
            if (var1_1 != null) {
                try {
                    var1_1.close();
lbl5:
                    // 2 sources

                    while (true) {
                        this.i = null;
                        break;
                    }
                }
                catch (Throwable var1_2) {
                    this.i = null;
                    throw var1_2;
                }
            }
            if ((var1_1 = this.j) != null) {
                var1_1.disconnect();
                this.j = null;
            }
            return;
            catch (IOException var1_3) {
                ** continue;
            }
        }

        private static void E(a.c c2) {
            URL uRL = c2.e();
            StringBuilder stringBuilder = E3.c.b();
            stringBuilder.append(uRL.getProtocol());
            stringBuilder.append("://");
            stringBuilder.append(uRL.getAuthority());
            stringBuilder.append(uRL.getPath());
            stringBuilder.append("?");
            if (uRL.getQuery() != null) {
                stringBuilder.append(uRL.getQuery());
            }
            if (!(uRL = c2.h().iterator()).hasNext()) {
                c2.i(new URL(E3.c.n(stringBuilder)));
                c2.h().clear();
                return;
            }
            E.a((Object)uRL.next());
            throw null;
        }

        private static String F(a.c c2) {
            String string = c2.f("Content-Type");
            if (string != null) {
                if (string.contains((CharSequence)"multipart/form-data") && !string.contains((CharSequence)"boundary")) {
                    string = D3.c.d();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("multipart/form-data; boundary=");
                    stringBuilder.append(string);
                    c2.d("Content-Type", stringBuilder.toString());
                    return string;
                }
                return null;
            }
            if (D3.d.k(c2)) {
                string = D3.c.d();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("multipart/form-data; boundary=");
                stringBuilder.append(string);
                c2.d("Content-Type", stringBuilder.toString());
                return string;
            }
            string = new StringBuilder();
            string.append("application/x-www-form-urlencoded; charset=");
            string.append(c2.b());
            c2.d("Content-Type", string.toString());
            return null;
        }

        private static void G(a.c object, OutputStream outputStream, String string) {
            block6: {
                block4: {
                    Collection collection;
                    block5: {
                        block2: {
                            block3: {
                                collection = object.h();
                                outputStream = new BufferedWriter((Writer)new OutputStreamWriter(outputStream, object.b()));
                                if (string == null) break block2;
                                object = collection.iterator();
                                if (object.hasNext()) break block3;
                                outputStream.write("--");
                                outputStream.write(string);
                                outputStream.write("--");
                                break block4;
                            }
                            E.a((Object)object.next());
                            outputStream.write("--");
                            outputStream.write(string);
                            outputStream.write("\r\n");
                            outputStream.write("Content-Disposition: form-data; name=\"");
                            throw null;
                        }
                        if ((object = object.g()) == null) break block5;
                        outputStream.write((String)object);
                        break block4;
                    }
                    object = collection.iterator();
                    if (object.hasNext()) break block6;
                }
                outputStream.close();
                return;
            }
            E.a((Object)object.next());
            throw null;
        }

        private static HttpURLConnection y(c object2) {
            Proxy proxy = ((c)object2).H();
            proxy = proxy == null ? ((c)object2).e().openConnection() : ((c)object2).e().openConnection(proxy);
            proxy = (HttpURLConnection)proxy;
            proxy.setRequestMethod(((c)object2).t().name());
            proxy.setInstanceFollowRedirects(false);
            proxy.setConnectTimeout(((c)object2).K());
            proxy.setReadTimeout(((c)object2).K() / 2);
            if (((c)object2).J() != null && proxy instanceof HttpsURLConnection) {
                ((HttpsURLConnection)proxy).setSSLSocketFactory(((c)object2).J());
            }
            if (((c)object2).t().d()) {
                proxy.setDoOutput(true);
            }
            D3.b.a((c)object2, (HttpURLConnection)proxy);
            for (Map.Entry entry : ((c)object2).u().entrySet()) {
                for (Object object2 : (List)entry.getValue()) {
                    proxy.addRequestProperty((String)entry.getKey(), (String)object2);
                }
            }
            return proxy;
        }

        private static LinkedHashMap z(HttpURLConnection httpURLConnection) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int n2 = 0;
            while (true) {
                int n3;
                String string = httpURLConnection.getHeaderFieldKey(n2);
                String string2 = httpURLConnection.getHeaderField(n2);
                if (string == null && string2 == null) {
                    return linkedHashMap;
                }
                n2 = n3 = n2 + 1;
                if (string == null) continue;
                if (string2 == null) {
                    n2 = n3;
                    continue;
                }
                if (linkedHashMap.containsKey((Object)string)) {
                    ((List)linkedHashMap.get((Object)string)).add((Object)string2);
                    n2 = n3;
                    continue;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add((Object)string2);
                linkedHashMap.put((Object)string, (Object)arrayList);
                n2 = n3;
            }
        }

        void C(Map object) {
            for (Map.Entry entry : object.entrySet()) {
                object = (String)entry.getKey();
                if (object == null) continue;
                entry = (List)entry.getValue();
                if (object.equalsIgnoreCase("Set-Cookie")) {
                    for (String string : entry) {
                        if (string == null) continue;
                        Object object2 = new j(string);
                        string = ((j)object2).b("=").trim();
                        object2 = ((j)object2).g(";").trim();
                        if (string.length() <= 0 || this.d.containsKey((Object)string)) continue;
                        this.k(string, (String)object2);
                    }
                }
                entry = entry.iterator();
                while (entry.hasNext()) {
                    this.j((String)object, (String)entry.next());
                }
            }
        }

        @Override
        public f c() {
            e.e(this.m, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (this.h != null) {
                this.i = new ByteArrayInputStream(this.h.array());
                this.n = false;
            }
            e.c(this.n, "Input stream already read and parsed, cannot re-read.");
            f f2 = D3.c.e(this.i, this.k, this.a.toExternalForm(), this.p.G());
            f2.N0(new d(this.p, this));
            this.k = f2.R0().c().name();
            this.n = true;
            this.D();
            return f2;
        }

        public String x() {
            return this.l;
        }
    }
}

