/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.ReflectiveOperationException
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.Collection
 */
package B3;

import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

public abstract class a {
    public static Object a(Class clazz, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return clazz.cast(Proxy.newProxyInstance((ClassLoader)a.class.getClassLoader(), (Class[])new Class[]{clazz}, (InvocationHandler)invocationHandler));
    }

    public static boolean b(Collection collection, String string) {
        block2: {
            block3: {
                if (collection.contains((Object)string)) break block2;
                if (!a.e()) break block3;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(":dev");
                if (collection.contains((Object)stringBuilder.toString())) break block2;
            }
            return false;
        }
        return true;
    }

    public static InvocationHandler c(Object object) {
        if (object == null) {
            return null;
        }
        return new a(object);
    }

    public static Method d(Method method, ClassLoader classArray) {
        Class clazz = Class.forName((String)method.getDeclaringClass().getName(), (boolean)true, (ClassLoader)classArray);
        classArray = method.getParameterTypes();
        return clazz.getDeclaredMethod(method.getName(), classArray);
    }

    private static boolean e() {
        String string = Build.TYPE;
        return "eng".equals((Object)string) || "userdebug".equals((Object)string);
        {
        }
    }

    private static class a
    implements InvocationHandler {
        private final Object a;

        public a(Object object) {
            this.a = object;
        }

        public Object invoke(Object object, Method method, Object[] stringBuilder) {
            InvocationTargetException invocationTargetException2;
            block3: {
                object = this.a.getClass().getClassLoader();
                try {
                    object = B3.a.d(method, (ClassLoader)object).invoke(this.a, (Object[])stringBuilder);
                    return object;
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                }
                catch (InvocationTargetException invocationTargetException2) {
                    break block3;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Reflection failed for method ");
                stringBuilder.append((Object)method);
                throw new RuntimeException(stringBuilder.toString(), (Throwable)reflectiveOperationException);
            }
            throw invocationTargetException2.getTargetException();
        }
    }
}

