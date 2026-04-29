/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 */
package V2;

import V2.h;
import V2.i;
import V2.l;
import V2.n;
import V2.u;
import Z2.b;
import Z2.c;
import Z2.d;
import Z2.e;

public abstract class t {
    private static final u a;
    private static final b[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        u u2 = null;
        try {
            u u3;
            u2 = u3 = (u)Class.forName((String)"kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        }
        catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException throwable) {}
        if (u2 == null) {
            u2 = new u();
        }
        a = u2;
        b = new b[0];
    }

    public static d a(i i3) {
        return a.a(i3);
    }

    public static b b(Class clazz) {
        return a.b(clazz);
    }

    public static c c(Class clazz) {
        return a.c(clazz, "");
    }

    public static e d(n n3) {
        return a.d(n3);
    }

    public static String e(h h3) {
        return a.e(h3);
    }

    public static String f(l l3) {
        return a.f(l3);
    }
}

