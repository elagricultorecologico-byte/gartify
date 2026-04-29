/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package t2;

import android.os.Handler;
import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicBoolean;
import t2.f;

public final class a
implements Runnable {
    public final f g;
    public final AtomicBoolean h;
    public final WebView[] i;
    public final Handler j;
    public final f.b k;

    public /* synthetic */ a(f f2, AtomicBoolean atomicBoolean, WebView[] webViewArray, Handler handler, f.b b2) {
        this.g = f2;
        this.h = atomicBoolean;
        this.i = webViewArray;
        this.j = handler;
        this.k = b2;
    }

    public final void run() {
        f.a(this.g, this.h, this.i, this.j, this.k);
    }
}

