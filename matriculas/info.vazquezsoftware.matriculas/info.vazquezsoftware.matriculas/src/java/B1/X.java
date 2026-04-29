/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.Jl
 *  com.google.android.gms.internal.ads.Kl
 *  com.google.android.gms.internal.ads.cr
 *  com.google.android.gms.internal.ads.ct
 *  f1.a
 *  f1.g
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Random
 */
package b1;

import b1.B1;
import b1.Y1;
import b1.a2;
import b1.b2;
import b1.v;
import com.google.android.gms.internal.ads.Jl;
import com.google.android.gms.internal.ads.Kl;
import com.google.android.gms.internal.ads.cr;
import com.google.android.gms.internal.ads.ct;
import f1.a;
import f1.g;
import java.util.Random;

public final class x {
    private static final x g = new x();
    public static final int h = 0;
    private final g a;
    private final v b;
    private boolean c;
    private final a d;
    private final Random e;
    private final String f;

    protected x() {
        g g3 = new g();
        v v2 = new v(new a2(), new Y1(), new B1(), new Jl(), new ct(), new cr(), new Kl(), new b2());
        a a3 = new a(0, 260910000, true);
        Random random = new Random();
        String string = f1.g.u();
        this.a = g3;
        this.b = v2;
        this.c = false;
        this.d = a3;
        this.e = random;
        this.f = string;
    }

    public static g a() {
        return x.g.a;
    }

    public static v b() {
        return x.g.b;
    }

    public static void c() {
        x.g.c = false;
    }

    public static void d() {
        x.g.c = true;
    }

    public static boolean e() {
        return x.g.c;
    }

    public static String f() {
        return x.g.f;
    }

    public static a g() {
        return x.g.d;
    }

    public static Random h() {
        return x.g.e;
    }
}

