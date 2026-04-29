/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package V2;

import H2.c;
import U2.a;
import U2.l;
import U2.p;
import U2.q;
import V2.h;
import V2.k;

public abstract class w {
    public static Object a(Object object, int n3) {
        if (object != null && !w.c(object, n3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.jvm.functions.Function");
            stringBuilder.append(n3);
            w.f(object, stringBuilder.toString());
        }
        return object;
    }

    public static int b(Object object) {
        if (object instanceof h) {
            return ((h)object).d();
        }
        if (object instanceof a) {
            return 0;
        }
        if (object instanceof l) {
            return 1;
        }
        if (object instanceof p) {
            return 2;
        }
        if (object instanceof q) {
            return 3;
        }
        return -1;
    }

    public static boolean c(Object object, int n3) {
        return object instanceof c && w.b(object) == n3;
    }

    private static Throwable d(Throwable throwable) {
        return k.i(throwable, w.class.getName());
    }

    public static ClassCastException e(ClassCastException classCastException) {
        throw (ClassCastException)w.d(classCastException);
    }

    public static void f(Object object, String string) {
        object = object == null ? "null" : object.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(" cannot be cast to ");
        stringBuilder.append(string);
        w.g(stringBuilder.toString());
    }

    public static void g(String string) {
        throw w.e(new ClassCastException(string));
    }
}

