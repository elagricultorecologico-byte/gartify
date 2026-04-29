/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.consent_sdk.a
 *  java.lang.Object
 *  java.lang.System
 *  java.util.Queue
 */
package k2;

import android.content.Context;
import java.util.Queue;
import k2.c;

public abstract class f {
    public static c a(Context context) {
        return com.google.android.gms.internal.consent_sdk.a.a((Context)context).b();
    }

    public static void b(Context context, b b2, a a2) {
        context = com.google.android.gms.internal.consent_sdk.a.a((Context)context);
        ((Queue)context.d().g.get()).add((Object)System.currentTimeMillis());
        context.c().b(b2, a2, false);
    }
}

