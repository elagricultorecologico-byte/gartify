/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.a
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.List
 */
package t0;

import android.content.Context;
import androidx.work.a;
import java.util.Collections;
import java.util.List;
import t0.m;
import t0.u;
import u0.j;

public abstract class t {
    protected t() {
    }

    public static t d(Context context) {
        return j.k(context);
    }

    public static void e(Context context, a a2) {
        j.e(context, a2);
    }

    public abstract m a(String var1);

    public abstract m b(List var1);

    public final m c(u u2) {
        return this.b(Collections.singletonList((Object)u2));
    }
}

