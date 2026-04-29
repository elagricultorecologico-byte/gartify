/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.webkit.WebView
 *  java.lang.Object
 */
package s0;

import android.os.Looper;
import android.webkit.WebView;

public abstract class f {
    public static /* bridge */ /* synthetic */ Looper a(WebView webView) {
        return webView.getWebViewLooper();
    }
}

