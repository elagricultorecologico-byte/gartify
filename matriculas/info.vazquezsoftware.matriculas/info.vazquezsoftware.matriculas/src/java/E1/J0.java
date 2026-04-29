/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Object
 *  java.util.Objects
 */
package e1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import e1.k0;
import java.util.Objects;

final class j0
extends BroadcastReceiver {
    final k0 a;

    j0(k0 k02) {
        Objects.requireNonNull((Object)k02);
        this.a = k02;
    }

    public final void onReceive(Context context, Intent intent) {
        this.a.d(context, intent);
    }
}

