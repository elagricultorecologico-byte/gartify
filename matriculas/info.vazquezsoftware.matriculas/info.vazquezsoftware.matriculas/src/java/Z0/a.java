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

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import t0.j;
import z0.c;

public class a
extends c {
    private static final String i = j.f("BatteryChrgTracker");

    public a(Context context, D0.a a2) {
        super(context, a2);
    }

    private boolean j(Intent intent) {
        int n2 = intent.getIntExtra("status", -1);
        return n2 == 2 || n2 == 5;
        {
        }
    }

    @Override
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void h(Context object, Intent intent) {
        int n2 = 1;
        object = intent.getAction();
        if (object == null) {
            return;
        }
        j.c().a(i, String.format((String)"Received %s", (Object[])new Object[]{object}), new Throwable[0]);
        int n3 = -1;
        switch (object.hashCode()) {
            case 1019184907: {
                if (!object.equals((Object)"android.intent.action.ACTION_POWER_CONNECTED")) break;
                n3 = 1;
                break;
            }
            case 948344062: {
                if (!object.equals((Object)"android.os.action.CHARGING")) break;
                n3 = 2;
                break;
            }
            case -54942926: {
                if (!object.equals((Object)"android.os.action.DISCHARGING")) break;
                n3 = 3;
                break;
            }
            case -1886648615: {
                if (!object.equals((Object)"android.intent.action.ACTION_POWER_DISCONNECTED")) break;
                n3 = 4;
                break;
            }
        }
        switch (n3) {
            default: {
                n2 = -1;
                break;
            }
            case 1: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 0;
                break;
            }
            case 3: 
        }
        switch (n2) {
            default: {
                return;
            }
            case 3: {
                this.d(Boolean.TRUE);
                return;
            }
            case 2: {
                this.d(Boolean.TRUE);
                return;
            }
            case 1: {
                this.d(Boolean.FALSE);
                return;
            }
            case 0: 
        }
        this.d(Boolean.FALSE);
    }

    public Boolean i() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if ((intentFilter = this.b.registerReceiver(null, intentFilter)) == null) {
            j.c().b(i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        return this.j((Intent)intentFilter);
    }
}

