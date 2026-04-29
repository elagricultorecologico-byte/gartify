/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.ElementType
 *  java.lang.annotation.Retention
 *  java.lang.annotation.RetentionPolicy
 *  java.lang.annotation.Target
 *  java.util.Map
 *  java.util.Set
 */
package org.chromium.support_lib_boundary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Set;

public interface WebSettingsBoundaryInterface {
    public int getAttributionBehavior();

    public boolean getBackForwardCacheEnabled();

    public int getDisabledActionModeMenuItems();

    public boolean getEnterpriseAuthenticationAppLinkPolicyEnabled();

    public int getForceDark();

    public int getForceDarkBehavior();

    public boolean getOffscreenPreRaster();

    public Set<String> getRequestedWithHeaderOriginAllowList();

    public boolean getSafeBrowsingEnabled();

    public int getSpeculativeLoadingStatus();

    public Map<String, Object> getUserAgentMetadataMap();

    public int getWebViewMediaIntegrityApiDefaultStatus();

    public Map<String, Integer> getWebViewMediaIntegrityApiOverrideRules();

    public int getWebauthnSupport();

    public boolean getWillSuppressErrorPage();

    public boolean isAlgorithmicDarkeningAllowed();

    public void setAlgorithmicDarkeningAllowed(boolean var1);

    public void setAttributionBehavior(int var1);

    public void setBackForwardCacheEnabled(boolean var1);

    public void setDisabledActionModeMenuItems(int var1);

    public void setEnterpriseAuthenticationAppLinkPolicyEnabled(boolean var1);

    public void setForceDark(int var1);

    public void setForceDarkBehavior(int var1);

    public void setOffscreenPreRaster(boolean var1);

    public void setRequestedWithHeaderOriginAllowList(Set<String> var1);

    public void setSafeBrowsingEnabled(boolean var1);

    public void setSpeculativeLoadingStatus(int var1);

    public void setUserAgentMetadataFromMap(Map<String, Object> var1);

    public void setWebViewMediaIntegrityApiStatus(int var1, Map<String, Integer> var2);

    public void setWebauthnSupport(int var1);

    public void setWillSuppressErrorPage(boolean var1);

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface AttributionBehavior {
        public static final int APP_SOURCE_AND_APP_TRIGGER = 3;
        public static final int APP_SOURCE_AND_WEB_TRIGGER = 1;
        public static final int DISABLED = 0;
        public static final int WEB_SOURCE_AND_WEB_TRIGGER = 2;
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface ForceDarkBehavior {
        public static final int FORCE_DARK_ONLY = 0;
        public static final int MEDIA_QUERY_ONLY = 1;
        public static final int PREFER_MEDIA_QUERY_OVER_FORCE_DARK = 2;
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface SpeculativeLoadingStatus {
        public static final int DISABLED = 0;
        public static final int PRERENDER_ENABLED = 1;
    }

    @Retention(value=RetentionPolicy.SOURCE)
    @Target(value={ElementType.TYPE_USE})
    public static @interface WebViewMediaIntegrityApiStatus {
        public static final int DISABLED = 0;
        public static final int ENABLED = 2;
        public static final int ENABLED_WITHOUT_APP_IDENTITY = 1;
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface WebauthnSupport {
        public static final int APP = 1;
        public static final int BROWSER = 2;
        public static final int NONE = 0;
    }
}

