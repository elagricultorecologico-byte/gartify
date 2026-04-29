/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
package O0;

import I0.e;
import O0.r;
import O0.x;
import P0.c;
import P0.d;
import Q0.b;
import R0.a;
import android.content.Context;
import java.util.concurrent.Executor;

public final class s
implements J0.b {
    private final G2.a a;
    private final G2.a b;
    private final G2.a c;
    private final G2.a d;
    private final G2.a e;
    private final G2.a f;
    private final G2.a g;
    private final G2.a h;
    private final G2.a i;

    public s(G2.a a2, G2.a a3, G2.a a4, G2.a a5, G2.a a6, G2.a a7, G2.a a8, G2.a a9, G2.a a10) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
        this.e = a6;
        this.f = a7;
        this.g = a8;
        this.h = a9;
        this.i = a10;
    }

    public static s a(G2.a a2, G2.a a3, G2.a a4, G2.a a5, G2.a a6, G2.a a7, G2.a a8, G2.a a9, G2.a a10) {
        return new s(a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }

    public static r c(Context context, e e2, d d2, x x2, Executor executor, b b2, a a2, a a3, c c2) {
        return new r(context, e2, d2, x2, executor, b2, a2, a3, c2);
    }

    public r b() {
        return s.c((Context)this.a.get(), (e)this.b.get(), (d)this.c.get(), (x)this.d.get(), (Executor)this.e.get(), (b)this.f.get(), (a)this.g.get(), (a)this.h.get(), (c)this.i.get());
    }
}

