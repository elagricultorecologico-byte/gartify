/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  B3.a
 *  android.net.Uri
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationHandler
 *  org.chromium.support_lib_boundary.WebMessageBoundaryInterface
 *  org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
 */
package s0;

import android.net.Uri;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import r0.a;
import r0.e;
import r0.g;
import s0.k;
import s0.p;

public class q
implements WebMessageListenerBoundaryInterface {
    private final g.a a;

    public q(g.a a2) {
        this.a = a2;
    }

    public String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_LISTENER", "WEB_MESSAGE_ARRAY_BUFFER"};
    }

    public void onPostMessage(WebView webView, InvocationHandler object, Uri uri, boolean bl, InvocationHandler object2) {
        if ((object = p.b((WebMessageBoundaryInterface)B3.a.a(WebMessageBoundaryInterface.class, (InvocationHandler)object))) != null) {
            object2 = k.b(object2);
            this.a.a(webView, (e)object, uri, bl, (a)object2);
        }
    }
}

