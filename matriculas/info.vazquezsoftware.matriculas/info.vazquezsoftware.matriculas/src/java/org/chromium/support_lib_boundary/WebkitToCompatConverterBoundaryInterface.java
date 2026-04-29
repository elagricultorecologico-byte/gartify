/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebSettings
 *  java.lang.Object
 *  java.lang.reflect.InvocationHandler
 */
package org.chromium.support_lib_boundary;

import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import java.lang.reflect.InvocationHandler;

public interface WebkitToCompatConverterBoundaryInterface {
    public InvocationHandler convertCookieManager(Object var1);

    public Object convertSafeBrowsingResponse(InvocationHandler var1);

    public InvocationHandler convertSafeBrowsingResponse(Object var1);

    public Object convertServiceWorkerSettings(InvocationHandler var1);

    public InvocationHandler convertServiceWorkerSettings(Object var1);

    public InvocationHandler convertSettings(WebSettings var1);

    public Object convertWebMessagePort(InvocationHandler var1);

    public InvocationHandler convertWebMessagePort(Object var1);

    public Object convertWebResourceError(InvocationHandler var1);

    public InvocationHandler convertWebResourceError(Object var1);

    public InvocationHandler convertWebResourceRequest(WebResourceRequest var1);
}

