/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.Yj
 *  com.google.android.gms.internal.ads.xr
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package o1;

import T0.g;
import android.content.Context;
import b1.A;
import b1.i1;
import b1.w1;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.Yj;
import com.google.android.gms.internal.ads.xr;
import o1.b;
import o1.c;

public class a {
    private final w1 a;

    public a(w1 w12) {
        this.a = w12;
    }

    public static void a(Context context, T0.c c3, g g2, b b2) {
        o1.a.c(context, c3, g2, null, b2);
    }

    private static void c(Context context, T0.c c3, g object, String string, b b2) {
        Yi.a((Context)context);
        if (((Boolean)Yj.j.e()).booleanValue()) {
            Oi oi = Yi.Cc;
            if (((Boolean)A.c().d(oi)).booleanValue()) {
                f1.c.b.execute((Runnable)new c(context, c3, (g)object, string, b2));
                return;
            }
        }
        object = object == null ? null : ((g)object).a();
        new xr(context, c3, (i1)object, string).b(b2);
    }

    public String b() {
        return this.a.a();
    }
}

