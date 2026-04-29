/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 */
package z0;

import android.content.Context;
import z0.a;
import z0.b;
import z0.f;
import z0.g;

public class h {
    private static h e;
    private a a;
    private b b;
    private f c;
    private g d;

    private h(Context context, D0.a a2) {
        context = context.getApplicationContext();
        this.a = new a(context, a2);
        this.b = new b(context, a2);
        this.c = new f(context, a2);
        this.d = new g(context, a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h c(Context object, D0.a a2) {
        Class<h> clazz = h.class;
        synchronized (h.class) {
            try {
                h h2;
                if (e != null) return e;
                e = h2 = new h((Context)object, a2);
                return e;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public a a() {
        return this.a;
    }

    public b b() {
        return this.b;
    }

    public f d() {
        return this.c;
    }

    public g e() {
        return this.d;
    }
}

