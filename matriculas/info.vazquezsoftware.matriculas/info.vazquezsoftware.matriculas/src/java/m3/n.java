/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 */
package m3;

import V2.k;
import java.nio.charset.Charset;
import z3.e;

public final class n {
    public static final n a = new n();

    private n() {
    }

    public static final String a(String string, String string2, Charset charset) {
        k.e(string, "username");
        k.e(string2, "password");
        k.e(charset, "charset");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(':');
        stringBuilder.append(string2);
        string = stringBuilder.toString();
        return k.j("Basic ", e.j.b(string, charset).d());
    }
}

