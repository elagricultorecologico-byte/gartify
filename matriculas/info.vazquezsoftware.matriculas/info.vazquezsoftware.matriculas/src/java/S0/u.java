/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  B3.a
 *  android.webkit.WebViewClient
 *  java.lang.Object
 *  java.lang.String
 *  org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface
 */
package s0;

import B3.a;
import android.webkit.WebViewClient;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import r0.g;
import s0.n;
import s0.q;

public class u {
    final WebViewProviderBoundaryInterface a;

    public u(WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.a = webViewProviderBoundaryInterface;
    }

    public n a(String string, String[] stringArray) {
        return n.a(this.a.addDocumentStartJavaScript(string, stringArray));
    }

    public void b(String string, String[] stringArray, g.a a2) {
        this.a.addWebMessageListener(string, stringArray, B3.a.c((Object)new q(a2)));
    }

    public WebViewClient c() {
        return this.a.getWebViewClient();
    }

    public void d(String string) {
        this.a.removeWebMessageListener(string);
    }

    public void e(boolean bl) {
        this.a.setAudioMuted(bl);
    }

    public void f(String string) {
        this.a.setProfile(string);
    }
}

