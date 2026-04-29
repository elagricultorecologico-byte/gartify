/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package r2;

public abstract class r {
    public static String a(String string) {
        String string2 = string;
        if (string != null) {
            if (string.isEmpty()) {
                string2 = string;
            } else {
                string2 = new StringBuilder();
                string2.append(string.substring(0, 1).toUpperCase());
                string2.append(string.substring(1).toLowerCase());
                string2 = string2.toString();
            }
        }
        return string2;
    }

    public static String b(String string) {
        return r.c(string);
    }

    public static String c(String object) {
        object = object.toCharArray();
        for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
            object[i2] = (char)(object[i2] ^ 0xAB);
        }
        return new String((char[])object);
    }
}

