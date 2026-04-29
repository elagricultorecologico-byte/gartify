/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  b1.A
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Sn
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.Yj
 *  f1.c
 *  g1.b
 *  g1.c
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  x1.n
 */
package g1;

import T0.e;
import T0.g;
import T0.l;
import T0.u;
import android.app.Activity;
import android.content.Context;
import b1.A;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Sn;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.Yj;
import g1.b;
import g1.c;
import x1.n;

public abstract class a {
    public static void b(Context context, String string, g g3, b b2) {
        n.j((Object)context, (Object)"Context cannot be null.");
        n.j((Object)string, (Object)"AdUnitId cannot be null.");
        n.j((Object)g3, (Object)"AdRequest cannot be null.");
        n.j((Object)b2, (Object)"LoadCallback cannot be null.");
        n.e((String)"#008 Must be called on the main UI thread.");
        Yi.a((Context)context);
        if (((Boolean)Yj.i.e()).booleanValue()) {
            Oi oi = Yi.Cc;
            if (((Boolean)A.c().d(oi)).booleanValue()) {
                f1.c.b.execute((Runnable)new c(context, string, g3, b2));
                return;
            }
        }
        new Sn(context, string).f(g3.a(), (e)b2);
    }

    public abstract u a();

    public abstract void c(l var1);

    public abstract void d(boolean var1);

    public abstract void e(Activity var1);
}

