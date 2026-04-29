/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  b1.h0
 *  b1.v
 *  b1.x
 *  com.google.android.gms.internal.ads.kp
 *  com.google.android.gms.internal.ads.op
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 */
package T0;

import android.content.Context;
import b1.h0;
import b1.v;
import b1.x;
import com.google.android.gms.internal.ads.kp;
import com.google.android.gms.internal.ads.op;

public abstract class z {
    private static volatile h0 a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h0 a(Context context) {
        if (a != null) return a;
        Class<z> clazz = z.class;
        synchronized (z.class) {
            try {
                if (a != null) return a;
                v v2 = x.b();
                kp kp2 = new kp();
                a = v2.d(context, (op)kp2);
                // ** MonitorExit[var3_2] (shouldn't be in output)
                return a;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }
}

