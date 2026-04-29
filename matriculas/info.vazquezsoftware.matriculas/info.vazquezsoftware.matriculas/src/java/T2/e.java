/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package t2;

import android.webkit.WebView;
import t2.f;

public final class e
implements Runnable {
    public final f.a g;
    public final WebView h;
    public final String i;

    public /* synthetic */ e(f.a a2, WebView webView, String string) {
        this.g = a2;
        this.h = webView;
        this.i = string;
    }

    public final void run() {
        f.a.a(this.g, this.h, this.i);
    }
}

