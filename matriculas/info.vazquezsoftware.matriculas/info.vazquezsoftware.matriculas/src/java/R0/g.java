/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.util.Set
 *  org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface
 */
package r0;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import r0.d;
import s0.a;
import s0.s;
import s0.t;
import s0.u;
import s0.v;

public abstract class g {
    private static final Uri a = Uri.parse((String)"*");
    private static final Uri b = Uri.parse((String)"");

    public static d a(WebView webView, String string, Set set) {
        if (s.V.d()) {
            return g.h(webView).a(string, (String[])set.toArray((Object[])new String[0]));
        }
        throw s.a();
    }

    public static void b(WebView webView, String string, Set set, a a2) {
        if (s.U.d()) {
            g.h(webView).b(string, (String[])set.toArray((Object[])new String[0]), a2);
            return;
        }
        throw s.a();
    }

    private static void c(WebView webView) {
        if (Build.VERSION.SDK_INT >= 28) {
            Looper looper = s0.g.b(webView);
            if (looper == Looper.myLooper()) {
                return;
            }
            webView = new StringBuilder();
            webView.append("A WebView method was called on thread '");
            webView.append(Thread.currentThread().getName());
            webView.append("'. All WebView methods must be called on the same thread. (Expected Looper ");
            webView.append((Object)looper);
            webView.append(" called on ");
            webView.append((Object)Looper.myLooper());
            webView.append(", FYI main Looper is ");
            webView.append((Object)Looper.getMainLooper());
            webView.append(")");
            throw new RuntimeException(webView.toString());
        }
        try {
            Method method = WebView.class.getDeclaredMethod("checkThread", null);
            method.setAccessible(true);
            method.invoke((Object)webView, null);
            return;
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private static WebViewProviderBoundaryInterface d(WebView webView) {
        return g.f().createWebView(webView);
    }

    public static PackageInfo e() {
        if (Build.VERSION.SDK_INT >= 26) {
            return s0.d.a();
        }
        try {
            PackageInfo packageInfo = g.g();
            return packageInfo;
        }
        catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException throwable) {
            return null;
        }
    }

    private static v f() {
        return t.c();
    }

    private static PackageInfo g() {
        return (PackageInfo)Class.forName((String)"android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    private static u h(WebView webView) {
        return new u(g.d(webView));
    }

    public static String i() {
        if (s.X.d()) {
            return g.f().getStatics().getVariationsHeader();
        }
        throw s.a();
    }

    public static WebViewClient j(WebView webView) {
        a.e e2 = s.H;
        if (e2.a()) {
            return s0.d.b(webView);
        }
        if (e2.d()) {
            g.c(webView);
            return g.h(webView).c();
        }
        throw s.a();
    }

    public static boolean k() {
        if (s.R.d()) {
            return g.f().getStatics().isMultiProcessEnabled();
        }
        throw s.a();
    }

    public static void l(WebView webView, String string) {
        if (s.U.d()) {
            g.h(webView).d(string);
            return;
        }
        throw s.a();
    }

    public static void m(WebView webView, boolean bl) {
        if (s.f0.d()) {
            g.h(webView).e(bl);
            return;
        }
        throw s.a();
    }

    public static void n(WebView webView, String string) {
        if (s.c0.d()) {
            g.h(webView).f(string);
            return;
        }
        throw s.a();
    }
}

