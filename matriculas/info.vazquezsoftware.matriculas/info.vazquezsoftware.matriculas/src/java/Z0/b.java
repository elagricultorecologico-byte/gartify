/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 */
package z0;

import D0.a;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import t0.j;
import z0.c;

public class b
extends c {
    private static final String i = j.f("BatteryNotLowTracker");

    public b(Context context, a a2) {
        super(context, a2);
    }

    @Override
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override
    public void h(Context object, Intent intent) {
        block3: {
            block4: {
                block2: {
                    if (intent.getAction() == null) break block2;
                    j.c().a(i, String.format((String)"Received %s", (Object[])new Object[]{intent.getAction()}), new Throwable[0]);
                    object = intent.getAction();
                    object.getClass();
                    if (object.equals((Object)"android.intent.action.BATTERY_OKAY")) break block3;
                    if (object.equals((Object)"android.intent.action.BATTERY_LOW")) break block4;
                }
                return;
            }
            this.d(Boolean.FALSE);
            return;
        }
        this.d(Boolean.TRUE);
    }

    public Boolean i() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        intentFilter = this.b.registerReceiver(null, intentFilter);
        boolean bl = false;
        if (intentFilter == null) {
            j.c().b(i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int n2 = intentFilter.getIntExtra("status", -1);
        int n3 = intentFilter.getIntExtra("level", -1);
        int n4 = intentFilter.getIntExtra("scale", -1);
        float f2 = (float)n3 / (float)n4;
        if (n2 == 1 || f2 > 0.15f) {
            bl = true;
        }
        return bl;
    }
}

