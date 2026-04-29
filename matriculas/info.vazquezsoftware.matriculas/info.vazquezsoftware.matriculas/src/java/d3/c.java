/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.CharArrayReader
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.nio.charset.IllegalCharsetNameException
 *  java.util.Locale
 *  java.util.Random
 *  java.util.regex.Pattern
 */
package D3;

import D3.e;
import F3.d;
import F3.f;
import F3.h;
import F3.q;
import G3.g;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

public abstract class c {
    private static final Pattern a;
    public static final Charset b;
    static final String c;
    private static final char[] d;

    static {
        Charset charset;
        a = Pattern.compile((String)"(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
        b = charset = Charset.forName((String)"UTF-8");
        c = charset.name();
        d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    private static a a(ByteBuffer byteBuffer) {
        byte by;
        byteBuffer.mark();
        byte[] byArray = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(byArray);
            byteBuffer.rewind();
        }
        if ((by = byArray[0]) == 0 && byArray[1] == 0 && byArray[2] == -2 && byArray[3] == -1 || by == -1 && byArray[1] == -2 && byArray[2] == 0 && byArray[3] == 0) {
            return new a("UTF-32", false);
        }
        if (by == -2 && byArray[1] == -1 || by == -1 && byArray[1] == -2) {
            return new a("UTF-16", false);
        }
        if (by == -17 && byArray[1] == -69 && byArray[2] == -65) {
            return new a("UTF-8", true);
        }
        return null;
    }

    static ByteBuffer b() {
        return ByteBuffer.allocate((int)0);
    }

    static String c(String string) {
        if (string == null) {
            return null;
        }
        if ((string = a.matcher((CharSequence)string)).find()) {
            return D3.c.g(string.group(1).trim().replace((CharSequence)"charset=", (CharSequence)""));
        }
        return null;
    }

    static String d() {
        StringBuilder stringBuilder = E3.c.b();
        Random random = new Random();
        for (int i2 = 0; i2 < 32; ++i2) {
            char[] cArray = d;
            stringBuilder.append(cArray[random.nextInt(cArray.length)]);
        }
        return E3.c.n(stringBuilder);
    }

    static f e(InputStream object, String object2, String object3, g g2) {
        Object object4;
        a a2;
        E3.a a3;
        boolean bl;
        block24: {
            Object var11_11;
            block23: {
                f f2;
                boolean bl2;
                block21: {
                    if (object == null) {
                        return new f((String)object3);
                    }
                    bl = false;
                    a3 = E3.a.j((InputStream)object, 32768, 0);
                    a3.mark(32768);
                    object = D3.c.f((InputStream)a3, 5119);
                    bl2 = a3.read() == -1;
                    a3.reset();
                    a2 = D3.c.a((ByteBuffer)object);
                    object4 = a2 != null ? a2.a : object2;
                    var11_11 = null;
                    if (object4 != null) break block23;
                    try {
                        object2 = b.decode((ByteBuffer)object);
                        if (object2.hasArray()) {
                            object = new CharArrayReader(object2.array(), object2.arrayOffset(), object2.limit());
                            f2 = g2.c((Reader)object, (String)object3);
                            break block21;
                        }
                        f2 = g2.d(object2.toString(), (String)object3);
                    }
                    catch (C3.e e2) {
                        throw e2.a();
                    }
                }
                Object object5 = f2.C0("meta[http-equiv=content-type], meta[charset]");
                int n2 = object5.size();
                int n3 = 0;
                object = null;
                do {
                    object2 = object;
                    if (n3 >= n2) break;
                    object2 = object5.get(n3);
                    ++n3;
                    h h2 = (h)object2;
                    if (h2.s("http-equiv")) {
                        object = D3.c.c(h2.d("content"));
                    }
                    object2 = object;
                    if (object == null) {
                        object2 = object;
                        if (h2.s("charset")) {
                            object2 = h2.d("charset");
                        }
                    }
                    object = object2;
                } while (object2 == null);
                object5 = object2;
                if (object2 == null) {
                    object5 = object2;
                    if (f2.k() > 0) {
                        object = f2.i(0);
                        object = object instanceof q ? (q)object : (object instanceof d && ((d)(object = (d)object)).Z() ? ((d)object).W() : null);
                        object5 = object2;
                        if (object != null) {
                            object5 = object2;
                            if (((q)object).Y().equalsIgnoreCase("xml")) {
                                object5 = ((q)object).d("encoding");
                            }
                        }
                    }
                }
                if ((object = D3.c.g((String)object5)) != null && !object.equalsIgnoreCase(c)) {
                    object4 = object.trim().replaceAll("[\"']", "");
                    object = var11_11;
                } else {
                    object = !bl2 ? var11_11 : f2;
                }
                break block24;
            }
            e.i((String)object4, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            object = var11_11;
        }
        object2 = object;
        if (object == null) {
            object = object4;
            if (object4 == null) {
                object = c;
            }
            object2 = new BufferedReader((Reader)new InputStreamReader((InputStream)a3, (String)object), 32768);
            if (a2 != null && a2.b) {
                if (object2.skip(1L) == 1L) {
                    bl = true;
                }
                e.d(bl);
            }
            try {
                object3 = g2.c((Reader)object2, (String)object3);
            }
            catch (C3.e e3) {
                throw e3.a();
            }
            object = object.equals((Object)c) ? b : Charset.forName((String)object);
            ((f)object3).R0().b((Charset)object);
            object2 = object3;
            if (!object.canEncode()) {
                ((f)object3).L0(b);
                object2 = object3;
            }
        }
        a3.close();
        return object2;
    }

    public static ByteBuffer f(InputStream inputStream, int n2) {
        boolean bl = n2 >= 0;
        e.e(bl, "maxSize must be 0 (unlimited) or larger");
        return E3.a.j(inputStream, 32768, n2).f(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String g(String string) {
        if (string == null) return null;
        if (string.length() == 0) {
            return null;
        }
        string = string.trim().replaceAll("[\"']", "");
        try {
            if (Charset.isSupported((String)string)) {
                return string;
            }
            boolean bl = Charset.isSupported((String)(string = string.toUpperCase(Locale.ENGLISH)));
            if (!bl) return null;
            return string;
        }
        catch (IllegalCharsetNameException illegalCharsetNameException) {
            return null;
        }
    }

    private static class a {
        private final String a;
        private final boolean b;

        public a(String string, boolean bl) {
            this.a = string;
            this.b = bl;
        }
    }
}

