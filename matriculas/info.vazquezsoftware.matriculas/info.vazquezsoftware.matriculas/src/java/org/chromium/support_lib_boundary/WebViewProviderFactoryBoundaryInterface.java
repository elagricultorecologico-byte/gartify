/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationHandler
 */
package org.chromium.support_lib_boundary;

import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;

public interface WebViewProviderFactoryBoundaryInterface {
    public InvocationHandler createWebView(WebView var1);

    public InvocationHandler getDropDataProvider();

    public InvocationHandler getProfileStore();

    public InvocationHandler getProxyController();

    public InvocationHandler getServiceWorkerController();

    public InvocationHandler getStatics();

    public String[] getSupportedFeatures();

    public InvocationHandler getTracingController();

    public InvocationHandler getWebkitToCompatConverter();
}

