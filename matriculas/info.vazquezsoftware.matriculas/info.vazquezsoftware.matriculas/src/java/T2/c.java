/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Runnable
 */
package t2;

import android.webkit.WebView;
import t2.f;

public final class c
implements Runnable {
    public final WebView g;

    public /* synthetic */ c(WebView webView) {
        this.g = webView;
    }

    public final void run() {
        f.c(this.g);
    }
}

