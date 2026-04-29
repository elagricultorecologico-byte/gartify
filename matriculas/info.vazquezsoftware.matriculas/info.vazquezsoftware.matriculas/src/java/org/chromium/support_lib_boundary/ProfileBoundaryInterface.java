/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.CookieManager
 *  android.webkit.GeolocationPermissions
 *  android.webkit.ServiceWorkerController
 *  android.webkit.ValueCallback
 *  android.webkit.WebStorage
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationHandler
 */
package org.chromium.support_lib_boundary;

import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import java.lang.reflect.InvocationHandler;

public interface ProfileBoundaryInterface {
    public void cancelPrefetch(String var1);

    public void clearPrefetch(String var1, ValueCallback<InvocationHandler> var2);

    public CookieManager getCookieManager();

    public GeolocationPermissions getGeoLocationPermissions();

    public String getName();

    public ServiceWorkerController getServiceWorkerController();

    public WebStorage getWebStorage();

    public void prefetchUrl(String var1, ValueCallback<InvocationHandler> var2);

    public void prefetchUrl(String var1, InvocationHandler var2, ValueCallback<InvocationHandler> var3);
}

