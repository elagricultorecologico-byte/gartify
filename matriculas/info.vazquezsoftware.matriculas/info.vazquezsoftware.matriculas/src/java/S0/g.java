/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.webkit.WebView
 *  java.lang.ClassLoader
 *  java.lang.Object
 */
package s0;

import android.os.Looper;
import android.webkit.WebView;
import s0.e;
import s0.f;

public abstract class g {
    public static ClassLoader a() {
        return e.a();
    }

    public static Looper b(WebView webView) {
        return f.a(webView);
    }
}

