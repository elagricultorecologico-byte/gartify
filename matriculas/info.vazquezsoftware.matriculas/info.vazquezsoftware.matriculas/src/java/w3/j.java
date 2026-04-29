/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package w3;

import V2.g;
import V2.k;
import java.lang.reflect.Method;

public final class j {
    public static final a d = new a(null);
    private final Method a;
    private final Method b;
    private final Method c;

    public j(Method method, Method method2, Method method3) {
        this.a = method;
        this.b = method2;
        this.c = method3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object a(String string) {
        k.e(string, "closer");
        Method method = this.a;
        if (method == null) return null;
        try {
            Object object = method.invoke(null, null);
            Method method2 = this.b;
            k.b(method2);
            method2.invoke(object, new Object[]{string});
            return object;
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean b(Object object) {
        if (object == null) return false;
        try {
            Method method = this.c;
            k.b(method);
            method.invoke(object, null);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final j a() {
            Method method;
            Class clazz;
            Method method2 = null;
            try {
                clazz = Class.forName((String)"dalvik.system.CloseGuard");
                Method method3 = clazz.getMethod("get", null);
                method = clazz.getMethod("open", new Class[]{String.class});
                clazz = clazz.getMethod("warnIfOpen", null);
                method2 = method3;
            }
            catch (Exception exception) {
                clazz = null;
                method = null;
            }
            return new j(method2, method, (Method)clazz);
        }
    }
}

