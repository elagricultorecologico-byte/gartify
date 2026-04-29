/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.widget.FrameLayout
 *  com.google.android.gms.internal.ads.Fr
 *  com.google.android.gms.internal.ads.Jl
 *  com.google.android.gms.internal.ads.Kl
 *  com.google.android.gms.internal.ads.Ps
 *  com.google.android.gms.internal.ads.Tk
 *  com.google.android.gms.internal.ads.Yq
 *  com.google.android.gms.internal.ads.Zt
 *  com.google.android.gms.internal.ads.cr
 *  com.google.android.gms.internal.ads.ct
 *  com.google.android.gms.internal.ads.fr
 *  com.google.android.gms.internal.ads.op
 *  f1.p
 *  java.lang.Object
 *  java.lang.String
 */
package b1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import b1.B1;
import b1.Q;
import b1.T0;
import b1.V;
import b1.Y1;
import b1.a2;
import b1.b;
import b1.b2;
import b1.d;
import b1.f;
import b1.h;
import b1.h0;
import b1.h2;
import b1.j;
import b1.l;
import b1.m;
import b1.o;
import b1.q;
import b1.u;
import b1.x;
import com.google.android.gms.internal.ads.Fr;
import com.google.android.gms.internal.ads.Jl;
import com.google.android.gms.internal.ads.Kl;
import com.google.android.gms.internal.ads.Ps;
import com.google.android.gms.internal.ads.Tk;
import com.google.android.gms.internal.ads.Yq;
import com.google.android.gms.internal.ads.Zt;
import com.google.android.gms.internal.ads.cr;
import com.google.android.gms.internal.ads.ct;
import com.google.android.gms.internal.ads.fr;
import com.google.android.gms.internal.ads.op;
import f1.p;

public final class v {
    private final a2 a;
    private final Y1 b;
    private final B1 c;
    private final Jl d;
    private final cr e;
    private Fr f;
    private final b2 g;

    public v(a2 a22, Y1 y12, B1 b12, Jl jl, ct ct2, cr cr2, Kl kl2, b2 b22) {
        this.a = a22;
        this.b = y12;
        this.c = b12;
        this.d = jl;
        this.e = cr2;
        this.g = b22;
    }

    static /* synthetic */ void k(Context context, String string) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", string);
        x.a().t(context, x.g().g, "gmob-apps", bundle, true);
    }

    public final V a(Context context, h2 h22, String string, op op2) {
        return (V)new l(this, context, h22, string, op2).d(context, false);
    }

    public final V b(Context context, h2 h22, String string, op op2) {
        return (V)new m(this, context, h22, string, op2).d(context, false);
    }

    public final Q c(Context context, String string, op op2) {
        return (Q)new o(this, context, string, op2).d(context, false);
    }

    public final h0 d(Context context, op op2) {
        return (h0)new q(this, context, op2).d(context, false);
    }

    public final Tk e(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (Tk)new u(this, frameLayout, frameLayout2, context).d(context, false);
    }

    public final Ps f(Context context, String string, op op2) {
        return (Ps)new b(this, context, string, op2).d(context, false);
    }

    public final fr g(Activity activity) {
        d d3 = new d(this, activity);
        Intent intent = activity.getIntent();
        boolean bl = intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar");
        boolean bl2 = false;
        if (!bl) {
            p.c((String)"useClientJar flag not found in activity intent extras.");
        } else {
            bl2 = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (fr)d3.d((Context)activity, bl2);
    }

    public final T0 h(Context context, op op2) {
        return (T0)new f(this, context, op2).d(context, false);
    }

    public final Zt i(Context context, op op2) {
        return (Zt)new h(this, context, op2).d(context, false);
    }

    public final Yq j(Context context, op op2) {
        return (Yq)new j(this, context, op2).d(context, false);
    }

    final /* synthetic */ a2 l() {
        return this.a;
    }

    final /* synthetic */ Y1 m() {
        return this.b;
    }

    final /* synthetic */ B1 n() {
        return this.c;
    }

    final /* synthetic */ Jl o() {
        return this.d;
    }

    final /* synthetic */ cr p() {
        return this.e;
    }

    final /* synthetic */ Fr q() {
        return this.f;
    }

    final /* synthetic */ void r(Fr fr2) {
        this.f = fr2;
    }

    final /* synthetic */ b2 s() {
        return this.g;
    }
}

