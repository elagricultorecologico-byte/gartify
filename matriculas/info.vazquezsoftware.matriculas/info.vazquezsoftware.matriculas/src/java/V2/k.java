/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Arrays
 */
package V2;

import H2.p;
import java.util.Arrays;

public abstract class k {
    public static boolean a(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public static void b(Object object) {
        if (object == null) {
            k.k();
        }
    }

    public static void c(Object object, String string) {
        if (object == null) {
            k.l(string);
        }
    }

    public static void d(Object object, String string) {
        if (object != null) {
            return;
        }
        object = new StringBuilder();
        object.append(string);
        object.append(" must not be null");
        throw (NullPointerException)k.h((Throwable)new NullPointerException(object.toString()));
    }

    public static void e(Object object, String string) {
        if (object == null) {
            k.m(string);
        }
    }

    public static int f(int n3, int n4) {
        if (n3 < n4) {
            return -1;
        }
        if (n3 == n4) {
            return 0;
        }
        return 1;
    }

    private static String g(String string) {
        int n3;
        Object object = Thread.currentThread().getStackTrace();
        String string2 = k.class.getName();
        int n4 = 0;
        do {
            n3 = ++n4;
        } while (!object[n4].getClassName().equals((Object)string2));
        while (object[n3].getClassName().equals((Object)string2)) {
            ++n3;
        }
        string2 = object[n3];
        object = string2.getClassName();
        string2 = string2.getMethodName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameter specified as non-null is null: method ");
        stringBuilder.append((String)object);
        stringBuilder.append(".");
        stringBuilder.append(string2);
        stringBuilder.append(", parameter ");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    private static Throwable h(Throwable throwable) {
        return k.i(throwable, k.class.getName());
    }

    static Throwable i(Throwable throwable, String string) {
        Object[] objectArray = throwable.getStackTrace();
        int n3 = objectArray.length;
        int n4 = -1;
        for (int i3 = 0; i3 < n3; ++i3) {
            if (!string.equals((Object)objectArray[i3].getClassName())) continue;
            n4 = i3;
        }
        throwable.setStackTrace((StackTraceElement[])Arrays.copyOfRange((Object[])objectArray, (int)(n4 + 1), (int)n3));
        return throwable;
    }

    public static String j(String string, Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    public static void k() {
        throw (NullPointerException)k.h((Throwable)new NullPointerException());
    }

    public static void l(String string) {
        throw (NullPointerException)k.h((Throwable)new NullPointerException(string));
    }

    private static void m(String string) {
        throw (NullPointerException)k.h((Throwable)new NullPointerException(k.g(string)));
    }

    public static void n(String string) {
        throw (p)k.h((Throwable)new p(string));
    }

    public static void o(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lateinit property ");
        stringBuilder.append(string);
        stringBuilder.append(" has not been initialized");
        k.n(stringBuilder.toString());
    }
}

