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

public class g
extends c {
    private static final String i = j.f("StorageNotLowTracker");

    public g(Context context, a a2) {
        super(context, a2);
    }

    @Override
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
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
                    if (object.equals((Object)"android.intent.action.DEVICE_STORAGE_LOW")) break block3;
                    if (object.equals((Object)"android.intent.action.DEVICE_STORAGE_OK")) break block4;
                }
                return;
            }
            this.d(Boolean.TRUE);
            return;
        }
        this.d(Boolean.FALSE);
    }

    public Boolean i() {
        Object object = this.b.registerReceiver(null, this.g());
        if (object != null && object.getAction() != null) {
            object = object.getAction();
            object.getClass();
            if (!object.equals((Object)"android.intent.action.DEVICE_STORAGE_LOW")) {
                if (!object.equals((Object)"android.intent.action.DEVICE_STORAGE_OK")) {
                    return null;
                }
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

