/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.internal.ads.Hf
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.er
 *  com.google.android.gms.internal.ads.qk0
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package d1;

import a1.t;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import b1.A;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.Hf;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.er;
import com.google.android.gms.internal.ads.qk0;
import d1.D;
import d1.a;
import d1.c;
import d1.e;
import d1.m;
import e1.F0;
import e1.o0;
import f1.p;

public final class d
extends er
implements Hf {
    private final AdOverlayInfoParcel g;
    private final Activity h;
    private boolean i;
    private boolean j;
    private boolean k;
    private final boolean l;
    private boolean m;
    private boolean n;

    public d(Activity object, AdOverlayInfoParcel object2) {
        boolean bl;
        block8: {
            boolean bl2;
            block7: {
                bl2 = false;
                this.i = false;
                this.j = false;
                this.k = false;
                this.m = false;
                this.n = false;
                this.g = object2;
                this.h = object;
                object = Yi.H5;
                if (((Boolean)A.c().d((Oi)object)).booleanValue()) break block7;
                object = Yi.I5;
                if (((Boolean)A.c().d((Oi)object)).booleanValue()) break block7;
                object = Yi.M5;
                bl = bl2;
                if (!((Boolean)A.c().d((Oi)object)).booleanValue()) break block8;
            }
            object = object2.g;
            bl = bl2;
            if (object != null) {
                bl = bl2;
                if (object.p) {
                    object2 = Build.MANUFACTURER;
                    object = Yi.K5;
                    bl = bl2;
                    if (object2.matches((String)A.c().d((Oi)object))) {
                        object = Build.MODEL;
                        object2 = Yi.L5;
                        bl = bl2;
                        if (object.matches((String)A.c().d((Oi)object2))) {
                            bl = true;
                        }
                    }
                }
            }
        }
        this.l = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void d() {
        d d2 = this;
        synchronized (d2) {
            Throwable throwable2;
            block7: {
                block5: {
                    D d3;
                    block6: {
                        try {
                            if (this.j) break block5;
                            d3 = this.g.i;
                            if (d3 == null) break block6;
                            d3.w2(4);
                        }
                        catch (Throwable throwable2) {
                            break block7;
                        }
                    }
                    this.j = true;
                    if (this.l) {
                        d3 = Yi.M5;
                        if (((Boolean)A.c().d((Oi)d3)).booleanValue()) {
                            t.k().c((Hf)this);
                            return;
                        }
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    public final void B0(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.i);
    }

    public final void I4(Bundle object) {
        boolean bl;
        Object object2 = Yi.la;
        if (((Boolean)A.c().d(object2)).booleanValue() && !this.k) {
            this.h.requestWindowFeature(1);
        }
        boolean bl2 = bl = false;
        if (object != null) {
            bl2 = bl;
            if (object.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
                bl2 = true;
            }
        }
        if ((object2 = this.g) == null) {
            this.h.finish();
            return;
        }
        if (bl2) {
            this.h.finish();
            return;
        }
        if (object == null) {
            object = object2.h;
            if (object != null) {
                object.C();
            }
            if ((object = object2.A) != null) {
                object.G();
            }
            if ((object = this.h).getIntent() != null && object.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (object = object2.i) != null) {
                object.g();
            }
        }
        if (this.l) {
            object = Yi.M5;
            if (((Boolean)A.c().d((Oi)object)).booleanValue()) {
                t.k().b((Hf)this);
            }
        }
        Activity activity = this.h;
        object = object2.g;
        object2 = object2.o;
        t.e();
        if (!a.b((Context)activity, (m)object, (e)object2, ((m)object).o, null, "")) {
            activity.finish();
        }
    }

    public final void T2(int n2, String[] stringArray, int[] nArray) {
    }

    public final void Z(boolean bl) {
        if (bl) {
            if (this.n) {
                int n2 = o0.b;
                p.a("Foregrounded: finishing activity from LauncherOverlay");
                this.h.finish();
            }
            return;
        }
        this.n = true;
    }

    final /* synthetic */ void b() {
        if (this.m) {
            this.h.finish();
        }
    }

    public final void c() {
    }

    public final void e() {
        D d2 = this.g.i;
        if (d2 != null) {
            d2.J2();
        }
    }

    public final boolean f() {
        Oi oi = Yi.I5;
        return (Boolean)A.c().d(oi) != false && this.l && this.m;
    }

    public final void f0(C1.a a2) {
    }

    public final void h() {
    }

    public final void h3(int n2, int n3, Intent intent) {
    }

    public final void i() {
        this.m = false;
        D d2 = this.g.i;
        if (d2 != null) {
            d2.L3();
        }
        if (this.h.isFinishing()) {
            this.d();
        }
    }

    public final void j() {
        if (this.i) {
            o0.k("LauncherOverlay finishing activity");
            this.h.finish();
            return;
        }
        this.i = true;
        this.m = true;
        Object object = this.g.i;
        if (object != null) {
            object.e5();
        }
        if (this.l) {
            object = Yi.H5;
            if (((Boolean)A.c().d((Oi)object)).booleanValue()) {
                qk0 qk02 = F0.l;
                object = new c(this);
                Oi oi = Yi.J5;
                qk02.postDelayed((Runnable)object, (long)((Integer)A.c().d(oi)).intValue());
            }
        }
    }

    public final void l() {
    }

    public final void m() {
        if (this.h.isFinishing()) {
            this.d();
        }
    }

    public final void p() {
        this.k = true;
    }

    public final void s() {
        if (this.h.isFinishing()) {
            this.d();
        }
    }
}

