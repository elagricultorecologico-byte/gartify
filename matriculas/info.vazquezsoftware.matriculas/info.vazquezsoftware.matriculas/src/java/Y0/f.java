/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 */
package y0;

import B0.p;
import D0.a;
import android.content.Context;
import android.os.Build;
import t0.j;
import t0.k;
import x0.b;
import y0.c;
import z0.h;

public class f
extends c {
    private static final String e = j.f("NetworkNotRoamingCtrlr");

    public f(Context context, a a2) {
        super(h.c(context, a2).d());
    }

    @Override
    boolean b(p p2) {
        return p2.j.b() == k.j;
    }

    boolean i(b b2) {
        if (Build.VERSION.SDK_INT < 24) {
            j.c().a(e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return b2.a() ^ true;
        }
        return !b2.a() || !b2.c();
        {
        }
    }
}

