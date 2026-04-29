/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package E3;

import java.util.Locale;

public abstract class b {
    public static String a(String string) {
        if (string != null) {
            return string.toLowerCase(Locale.ENGLISH);
        }
        return "";
    }

    public static String b(String string) {
        return b.a(string).trim();
    }

    public static String c(String string, boolean bl) {
        if (bl) {
            return b.a(string);
        }
        return b.b(string);
    }
}

