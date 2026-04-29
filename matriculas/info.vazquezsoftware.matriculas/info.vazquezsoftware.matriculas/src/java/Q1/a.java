/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.Yj
 *  com.google.android.gms.internal.ads.kt
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  q1.c
 *  x1.n
 */
package q1;

import T0.g;
import T0.p;
import T0.u;
import android.app.Activity;
import android.content.Context;
import b1.A;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.Yj;
import com.google.android.gms.internal.ads.kt;
import q1.b;
import q1.c;
import x1.n;

public abstract class a {
    public static void b(Context context, String string, g g3, b b2) {
        n.j((Object)context, (Object)"Context cannot be null.");
        n.j((Object)string, (Object)"AdUnitId cannot be null.");
        n.j((Object)g3, (Object)"AdRequest cannot be null.");
        n.j((Object)b2, (Object)"LoadCallback cannot be null.");
        n.e((String)"#008 Must be called on the main UI thread.");
        Yi.a((Context)context);
        if (((Boolean)Yj.k.e()).booleanValue()) {
            Oi oi = Yi.Cc;
            if (((Boolean)A.c().d(oi)).booleanValue()) {
                f1.c.b.execute((Runnable)new c(context, string, g3, b2));
                return;
            }
        }
        new kt(context, string).d(g3.a(), b2);
    }

    public abstract u a();

    public abstract void c(Activity var1, p var2);
}

