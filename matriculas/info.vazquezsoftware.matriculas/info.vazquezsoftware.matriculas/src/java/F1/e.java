/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package f1;

import android.content.Context;
import f1.d;
import f1.f;
import f1.g;
import f1.u;

final class e
implements f {
    private final g a;
    private final Context b;

    /* synthetic */ e(g g2, Context context) {
        this.a = g2;
        this.b = context;
    }

    @Override
    public final /* synthetic */ u b(String string) {
        new d(this.a, this.b, string).start();
        return u.g;
    }
}

