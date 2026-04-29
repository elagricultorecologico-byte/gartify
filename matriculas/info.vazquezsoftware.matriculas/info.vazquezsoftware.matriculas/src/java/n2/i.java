/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package N2;

import V2.k;
import java.lang.reflect.Method;

final class i {
    public static final i a = new i();
    private static final a b = new a(null, null, null);
    private static a c;

    private i() {
    }

    private final a a(N2.a object) {
        try {
            Method method = Class.class.getDeclaredMethod("getModule", null);
            Method method2 = object.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null);
            Method method3 = object.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null);
            c = object = new a(method, method2, method3);
            return object;
        }
        catch (Exception exception) {
            a a2;
            c = a2 = b;
            return a2;
        }
    }

    public final String b(N2.a object) {
        a a2;
        k.e((Object)object, (String)"continuation");
        a a3 = a2 = c;
        if (a2 == null) {
            a3 = this.a((N2.a)object);
        }
        if (a3 == b) {
            return null;
        }
        a2 = a3.a;
        if (a2 != null && (object = a2.invoke(object.getClass(), null)) != null && (a2 = a3.b) != null && (object = a2.invoke(object, null)) != null && (object = (a3 = a3.c) != null ? a3.invoke(object, null) : null) instanceof String) {
            return (String)object;
        }
        return null;
    }

    private static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }
}

