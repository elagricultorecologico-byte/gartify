/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface
 *  org.chromium.support_lib_boundary.StaticsBoundaryInterface
 *  org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface
 */
package s0;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

public interface v {
    public String[] a();

    public WebViewProviderBoundaryInterface createWebView(WebView var1);

    public ProfileStoreBoundaryInterface getProfileStore();

    public StaticsBoundaryInterface getStatics();
}

