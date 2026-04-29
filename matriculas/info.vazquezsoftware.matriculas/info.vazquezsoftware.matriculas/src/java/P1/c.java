/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.Yj
 *  com.google.android.gms.internal.ads.Zs
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  p1.e
 *  x1.n
 */
package p1;

import T0.g;
import T0.u;
import android.app.Activity;
import android.content.Context;
import b1.A;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.Yj;
import com.google.android.gms.internal.ads.Zs;
import f1.p;
import p1.d;
import p1.e;
import x1.n;

public abstract class c {
    public static void b(Context context, String string, g g3, d d2) {
        n.j((Object)context, (Object)"Context cannot be null.");
        n.j((Object)string, (Object)"AdUnitId cannot be null.");
        n.j((Object)g3, (Object)"AdRequest cannot be null.");
        n.j((Object)d2, (Object)"LoadCallback cannot be null.");
        n.e((String)"#008 Must be called on the main UI thread.");
        Yi.a((Context)context);
        if (((Boolean)Yj.k.e()).booleanValue()) {
            Oi oi = Yi.Cc;
            if (((Boolean)A.c().d(oi)).booleanValue()) {
                f1.c.b.execute((Runnable)new e(context, string, g3, d2));
                return;
            }
        }
        p.a("Loading on UI thread");
        new Zs(context, string).d(g3.a(), d2);
    }

    public abstract u a();

    public abstract void c(Activity var1, T0.p var2);
}

