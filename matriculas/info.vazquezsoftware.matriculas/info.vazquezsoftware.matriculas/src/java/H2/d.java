/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package h2;

import android.content.Context;
import h2.c;
import h2.h;
import h2.m;

public abstract class d {
    public static c a(Context context) {
        Context context2 = context.getApplicationContext();
        if (context2 != null) {
            context = context2;
        }
        return new h(new m(context));
    }
}

