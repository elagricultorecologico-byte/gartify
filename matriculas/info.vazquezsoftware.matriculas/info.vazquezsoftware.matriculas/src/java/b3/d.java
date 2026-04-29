/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package b3;

import V2.k;
import java.nio.charset.Charset;

public final class d {
    public static final d a = new d();
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final Charset g;
    private static volatile Charset h;
    private static volatile Charset i;

    static {
        Charset charset = Charset.forName((String)"UTF-8");
        k.d(charset, "forName(...)");
        b = charset;
        charset = Charset.forName((String)"UTF-16");
        k.d(charset, "forName(...)");
        c = charset;
        charset = Charset.forName((String)"UTF-16BE");
        k.d(charset, "forName(...)");
        d = charset;
        charset = Charset.forName((String)"UTF-16LE");
        k.d(charset, "forName(...)");
        e = charset;
        charset = Charset.forName((String)"US-ASCII");
        k.d(charset, "forName(...)");
        f = charset;
        charset = Charset.forName((String)"ISO-8859-1");
        k.d(charset, "forName(...)");
        g = charset;
    }

    private d() {
    }

    public final Charset a() {
        Charset charset;
        Charset charset2 = charset = i;
        if (charset == null) {
            charset2 = Charset.forName((String)"UTF-32BE");
            k.d(charset2, "forName(...)");
            i = charset2;
        }
        return charset2;
    }

    public final Charset b() {
        Charset charset;
        Charset charset2 = charset = h;
        if (charset == null) {
            charset2 = Charset.forName((String)"UTF-32LE");
            k.d(charset2, "forName(...)");
            h = charset2;
        }
        return charset2;
    }
}

