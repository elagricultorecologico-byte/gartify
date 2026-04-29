/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  B3.a
 *  android.os.Build$VERSION
 *  android.webkit.WebView
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.InvocationTargetException
 *  org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface
 */
package s0;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import s0.g;
import s0.i;
import s0.v;
import s0.w;

public abstract class t {
    static v a() {
        InvocationHandler invocationHandler;
        try {
            invocationHandler = t.b();
        }
        catch (ClassNotFoundException classNotFoundException) {
            return new i();
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException throwable) {
            throw new RuntimeException(throwable);
        }
        return new w((WebViewProviderFactoryBoundaryInterface)B3.a.a(WebViewProviderFactoryBoundaryInterface.class, (InvocationHandler)invocationHandler));
    }

    private static InvocationHandler b() {
        return (InvocationHandler)Class.forName((String)"org.chromium.support_lib_glue.SupportLibReflectionUtil", (boolean)false, (ClassLoader)t.d()).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static v c() {
        return a.a;
    }

    public static ClassLoader d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return g.a();
        }
        return t.e().getClass().getClassLoader();
    }

    private static Object e() {
        try {
            Object object = WebView.class.getDeclaredMethod("getFactory", null);
            object.setAccessible(true);
            object = object.invoke(null, null);
            return object;
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private static abstract class a {
        static final v a = t.a();
    }
}

