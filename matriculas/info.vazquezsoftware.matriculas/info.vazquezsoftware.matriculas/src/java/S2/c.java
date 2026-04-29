/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowMetrics
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.internal.ads.W30
 *  com.google.android.gms.internal.ads.Y30
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package s2;

import T0.a;
import T0.d;
import T0.g;
import T0.h;
import T0.i;
import T0.k;
import T0.m;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.W30;
import com.google.android.gms.internal.ads.Y30;

public class c {
    private i a;
    private final Activity b;
    private final ViewGroup c;
    private final String d;

    public c(Activity activity, ViewGroup viewGroup, String string, b b2) {
        this.b = activity;
        this.c = viewGroup;
        this.d = string;
    }

    public static /* synthetic */ void a(c c3) {
        c3.i();
    }

    static /* bridge */ /* synthetic */ b c(c c3) {
        c3.getClass();
        return null;
    }

    private void f() {
        this.b.runOnUiThread((Runnable)new s2.b(this));
    }

    private h g() {
        int n2 = (int)((float)this.h() / this.b.getResources().getDisplayMetrics().density);
        return h.a((Context)this.b, n2);
    }

    private int h() {
        int n2 = this.b.getResources().getDisplayMetrics().widthPixels;
        if (Build.VERSION.SDK_INT >= 30) {
            n2 = Y30.a((WindowMetrics)W30.a((WindowManager)this.b.getWindowManager())).width();
        }
        return n2;
    }

    private /* synthetic */ void i() {
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.height = -2;
        this.c.setLayoutParams(layoutParams);
    }

    private void k() {
        Object object = new i((Context)this.b);
        this.a = object;
        ((k)((Object)object)).setAdUnitId(this.d);
        this.a.setAdSize(this.g());
        object = new g.a();
        Bundle bundle = new Bundle();
        bundle.putString("collapsible", "bottom");
        ((a)object).c(AdMobAdapter.class, bundle);
        object = ((g.a)object).k();
        this.a.setAdListener(new d(this){
            final c g;
            {
                this.g = c3;
            }

            @Override
            public void e(m m2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Banner error: ");
                stringBuilder.append(m2.c());
                r2.k.a("ZZZ", stringBuilder.toString());
                s2.c.c(this.g);
            }

            @Override
            public void i() {
                r2.k.a("ZZZ", "Banner loaded");
                this.g.f();
                this.g.c.removeAllViews();
                this.g.c.addView((View)this.g.a);
                s2.c.c(this.g);
            }
        });
        this.a.b((g)object);
    }

    public void j() {
        this.k();
    }

    public static interface b {
    }
}

