/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.webkit.ValueCallback
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Set
 */
package org.chromium.support_lib_boundary;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import java.util.List;
import java.util.Set;

public interface StaticsBoundaryInterface {
    public Uri getSafeBrowsingPrivacyPolicyUrl();

    public String getVariationsHeader();

    public void initSafeBrowsing(Context var1, ValueCallback<Boolean> var2);

    public boolean isMultiProcessEnabled();

    public void setSafeBrowsingAllowlist(Set<String> var1, ValueCallback<Boolean> var2);

    public void setSafeBrowsingWhitelist(List<String> var1, ValueCallback<Boolean> var2);
}

