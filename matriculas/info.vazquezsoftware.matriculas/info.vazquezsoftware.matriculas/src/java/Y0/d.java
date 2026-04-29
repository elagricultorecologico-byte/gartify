/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.Override
 */
package y0;

import B0.p;
import D0.a;
import android.content.Context;
import android.os.Build;
import t0.k;
import x0.b;
import y0.c;
import z0.h;

public class d
extends c {
    public d(Context context, a a2) {
        super(h.c(context, a2).d());
    }

    @Override
    boolean b(p p2) {
        return p2.j.b() == k.h;
    }

    boolean i(b b2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return !b2.a() || !b2.d();
            {
            }
        }
        return b2.a() ^ true;
    }
}

