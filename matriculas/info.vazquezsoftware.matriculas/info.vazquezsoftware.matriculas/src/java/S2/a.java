/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  androidx.lifecycle.B
 *  androidx.lifecycle.e
 *  androidx.lifecycle.f
 *  androidx.lifecycle.o
 *  androidx.lifecycle.p
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Date
 */
package s2;

import T0.b;
import T0.g;
import T0.l;
import T0.m;
import V0.a;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.B;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.o;
import info.vazquezsoftware.matriculas.appopenads.MyApplication;
import java.util.Date;
import r2.p;

public class a
implements f,
Application.ActivityLifecycleCallbacks {
    private static String l;
    public static boolean m = true;
    private final MyApplication g;
    private V0.a h = null;
    private Activity i;
    private long j = 0L;
    private boolean k = false;

    public a(MyApplication myApplication) {
        this.g = myApplication;
        myApplication.registerActivityLifecycleCallbacks(this);
        l = myApplication.getString(2131886111);
        B.n().x().a((o)this);
    }

    private boolean l(long l2) {
        return new Date().getTime() - this.j < l2 * 3600000L;
    }

    public /* synthetic */ void A(androidx.lifecycle.p p2) {
        e.e((f)this, (androidx.lifecycle.p)p2);
    }

    public void F(androidx.lifecycle.p p2) {
        if (!this.k) {
            this.h = null;
            this.g();
        }
    }

    public /* synthetic */ void a(androidx.lifecycle.p p2) {
        e.d((f)this, (androidx.lifecycle.p)p2);
    }

    public /* synthetic */ void f(androidx.lifecycle.p p2) {
        e.b((f)this, (androidx.lifecycle.p)p2);
    }

    public void g() {
        Object object = this.g;
        if (object != null && !p.f((Context)object) && !this.h()) {
            object = new g.a().k();
            V0.a.b((Context)this.g, l, (g)object, new a.a(this){
                final a a;
                {
                    this.a = a2;
                }

                @Override
                public void a(m m2) {
                }

                public void c(V0.a a2) {
                    this.a.h = a2;
                    this.a.j = new Date().getTime();
                }
            });
        }
    }

    public boolean h() {
        return this.h != null && this.l(4L);
    }

    public /* synthetic */ void i(androidx.lifecycle.p p2) {
        e.a((f)this, (androidx.lifecycle.p)p2);
    }

    public void k() {
        Object object = this.g;
        if (object != null && !p.f((Context)object)) {
            if (!m) {
                m = true;
                return;
            }
            if (this.h() && this.h()) {
                object = new l(this){
                    final a a;
                    {
                        this.a = a2;
                    }

                    @Override
                    public void b() {
                        this.a.h = null;
                        this.a.k = false;
                        this.a.i.finish();
                    }

                    @Override
                    public void c(b b2) {
                        this.a.h = null;
                        this.a.k = false;
                    }

                    @Override
                    public void d() {
                        this.a.k = true;
                    }
                };
                this.h.c((l)object);
                this.h.d(this.i);
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        this.i = null;
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        this.i = activity;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.i = activity;
        if (!p.f((Context)activity) && !activity.toString().contains((CharSequence)"IntroActivity")) {
            this.k();
        }
    }

    public void onActivityStopped(Activity activity) {
    }

    public /* synthetic */ void p(androidx.lifecycle.p p2) {
        e.c((f)this, (androidx.lifecycle.p)p2);
    }
}

