/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package D3;

public abstract class e {
    public static void a(String string) {
        throw new IllegalArgumentException(string);
    }

    public static void b(boolean bl) {
        if (!bl) {
            return;
        }
        throw new IllegalArgumentException("Must be false");
    }

    public static void c(boolean bl, String string) {
        if (!bl) {
            return;
        }
        throw new IllegalArgumentException(string);
    }

    public static void d(boolean bl) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException("Must be true");
    }

    public static void e(boolean bl, String string) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(string);
    }

    public static void f(Object[] objectArray) {
        e.g(objectArray, "Array must not contain any null objects");
    }

    public static void g(Object[] objectArray, String string) {
        int n2 = objectArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (objectArray[i2] != null) {
                continue;
            }
            throw new IllegalArgumentException(string);
        }
    }

    public static void h(String string) {
        if (string != null && string.length() != 0) {
            return;
        }
        throw new IllegalArgumentException("String must not be empty");
    }

    public static void i(String string, String string2) {
        if (string != null && string.length() != 0) {
            return;
        }
        throw new IllegalArgumentException(string2);
    }

    public static void j(Object object) {
        if (object != null) {
            return;
        }
        throw new IllegalArgumentException("Object must not be null");
    }

    public static void k(Object object, String string) {
        if (object != null) {
            return;
        }
        throw new IllegalArgumentException(string);
    }
}

