/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.security.NetworkSecurityPolicy
 *  java.lang.Object
 *  java.lang.String
 */
package v3;

import android.security.NetworkSecurityPolicy;

public abstract class a {
    public static /* bridge */ /* synthetic */ boolean a(NetworkSecurityPolicy networkSecurityPolicy, String string) {
        return networkSecurityPolicy.isCleartextTrafficPermitted(string);
    }
}

