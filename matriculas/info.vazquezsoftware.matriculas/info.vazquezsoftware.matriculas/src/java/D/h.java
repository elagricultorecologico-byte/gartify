/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package D;

import java.util.Locale;

public abstract class h {
    public static void a(boolean bl) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void b(boolean bl, Object object) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf((Object)object));
    }

    public static int c(int n2, int n3, int n4, String string) {
        if (n2 >= n3) {
            if (n2 <= n4) {
                return n2;
            }
            throw new IllegalArgumentException(String.format((Locale)Locale.US, (String)"%s is out of range of [%d, %d] (too high)", (Object[])new Object[]{string, n3, n4}));
        }
        throw new IllegalArgumentException(String.format((Locale)Locale.US, (String)"%s is out of range of [%d, %d] (too low)", (Object[])new Object[]{string, n3, n4}));
    }

    public static int d(int n2) {
        if (n2 >= 0) {
            return n2;
        }
        throw new IllegalArgumentException();
    }

    public static int e(int n2, String string) {
        if (n2 >= 0) {
            return n2;
        }
        throw new IllegalArgumentException(string);
    }

    public static int f(int n2, int n3) {
        if ((n2 & n3) == n2) {
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Requested flags 0x");
        stringBuilder.append(Integer.toHexString((int)n2));
        stringBuilder.append(", but only 0x");
        stringBuilder.append(Integer.toHexString((int)n3));
        stringBuilder.append(" are allowed");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static Object g(Object object) {
        object.getClass();
        return object;
    }

    public static Object h(Object object, Object object2) {
        if (object != null) {
            return object;
        }
        throw new NullPointerException(String.valueOf((Object)object2));
    }

    public static void i(boolean bl, String string) {
        if (bl) {
            return;
        }
        throw new IllegalStateException(string);
    }
}

