/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  B3.a
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.InvocationHandler
 *  org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface
 *  org.chromium.support_lib_boundary.StaticsBoundaryInterface
 *  org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface
 *  org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface
 */
package s0;

import B3.a;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import s0.v;

public class w
implements v {
    final WebViewProviderFactoryBoundaryInterface a;

    public w(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.a = webViewProviderFactoryBoundaryInterface;
    }

    @Override
    public String[] a() {
        return this.a.getSupportedFeatures();
    }

    @Override
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface)B3.a.a(WebViewProviderBoundaryInterface.class, (InvocationHandler)this.a.createWebView(webView));
    }

    @Override
    public ProfileStoreBoundaryInterface getProfileStore() {
        return (ProfileStoreBoundaryInterface)B3.a.a(ProfileStoreBoundaryInterface.class, (InvocationHandler)this.a.getProfileStore());
    }

    @Override
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface)B3.a.a(StaticsBoundaryInterface.class, (InvocationHandler)this.a.getStatics());
    }
}

