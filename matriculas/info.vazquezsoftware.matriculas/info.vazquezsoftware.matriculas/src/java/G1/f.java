/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  androidx.core.content.a
 *  java.lang.Object
 */
package G1;

import E0.k;
import G1.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.a;

public abstract class f
extends a {
    public static Intent l(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (e.a()) {
            int n2 = true != e.a() ? 0 : 2;
            return k.a(context, broadcastReceiver, intentFilter, n2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}

