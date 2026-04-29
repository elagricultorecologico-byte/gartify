/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package t2;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicBoolean;
import t2.f;

public final class b
implements Runnable {
    public final f g;
    public final Context h;
    public final WebView[] i;
    public final AtomicBoolean j;
    public final f.b k;
    public final Handler l;
    public final String m;

    public /* synthetic */ b(f f2, Context context, WebView[] webViewArray, AtomicBoolean atomicBoolean, f.b b2, Handler handler, String string) {
        this.g = f2;
        this.h = context;
        this.i = webViewArray;
        this.j = atomicBoolean;
        this.k = b2;
        this.l = handler;
        this.m = string;
    }

    public final void run() {
        f.b(this.g, this.h, this.i, this.j, this.k, this.l, this.m);
    }
}

