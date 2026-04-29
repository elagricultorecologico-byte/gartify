/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationHandler
 *  java.util.List
 */
package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;
import java.util.List;

public interface ProfileStoreBoundaryInterface {
    public boolean deleteProfile(String var1);

    public List<String> getAllProfileNames();

    public InvocationHandler getOrCreateProfile(String var1);

    public InvocationHandler getProfile(String var1);
}

