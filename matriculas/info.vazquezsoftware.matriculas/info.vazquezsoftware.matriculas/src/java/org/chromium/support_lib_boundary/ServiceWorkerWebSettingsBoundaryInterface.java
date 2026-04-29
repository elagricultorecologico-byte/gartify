/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
package org.chromium.support_lib_boundary;

import java.util.Set;

public interface ServiceWorkerWebSettingsBoundaryInterface {
    public boolean getAllowContentAccess();

    public boolean getAllowFileAccess();

    public boolean getBlockNetworkLoads();

    public int getCacheMode();

    public Set<String> getRequestedWithHeaderOriginAllowList();

    public void setAllowContentAccess(boolean var1);

    public void setAllowFileAccess(boolean var1);

    public void setBlockNetworkLoads(boolean var1);

    public void setCacheMode(int var1);

    public void setRequestedWithHeaderOriginAllowList(Set<String> var1);
}

