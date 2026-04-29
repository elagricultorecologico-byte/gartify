/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 */
package z0;

import D0.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import t0.j;
import z0.d;

public abstract class c
extends d {
    private static final String h = j.f("BrdcstRcvrCnstrntTrckr");
    private final BroadcastReceiver g = new BroadcastReceiver(this){
        final c a;
        {
            this.a = c2;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                this.a.h(context, intent);
            }
        }
    };

    public c(Context context, a a2) {
        super(context, a2);
    }

    @Override
    public void e() {
        j.c().a(h, String.format((String)"%s: registering receiver", (Object[])new Object[]{this.getClass().getSimpleName()}), new Throwable[0]);
        this.b.registerReceiver(this.g, this.g());
    }

    @Override
    public void f() {
        j.c().a(h, String.format((String)"%s: unregistering receiver", (Object[])new Object[]{this.getClass().getSimpleName()}), new Throwable[0]);
        this.b.unregisterReceiver(this.g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context var1, Intent var2);
}

