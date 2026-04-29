/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  java.lang.Object
 */
package z0;

import android.net.ConnectivityManager;

public abstract class e {
    public static /* bridge */ /* synthetic */ void a(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}

