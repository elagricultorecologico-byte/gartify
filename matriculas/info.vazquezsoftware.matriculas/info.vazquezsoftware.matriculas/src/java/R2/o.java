/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.provider.Settings$Global
 *  java.lang.Object
 *  java.lang.String
 */
package r2;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.provider.Settings;

public abstract class o {
    public static boolean a(Context context) {
        return (context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && context.isConnected();
    }

    public static boolean b(Context context) {
        return Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)"airplane_mode_on", (int)0) != 0;
    }
}

