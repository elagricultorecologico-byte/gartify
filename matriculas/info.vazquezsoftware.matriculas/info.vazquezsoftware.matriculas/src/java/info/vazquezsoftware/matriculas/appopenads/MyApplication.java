/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  com.google.android.gms.ads.MobileAds
 *  java.lang.Object
 */
package info.vazquezsoftware.matriculas.appopenads;

import Z0.b;
import Z0.c;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.ads.MobileAds;
import r2.p;
import s2.a;
import s2.f;

public class MyApplication
extends Application {
    private static a g;

    public static /* synthetic */ void a(MyApplication myApplication, b b2) {
        myApplication.b(b2);
    }

    private /* synthetic */ void b(b b2) {
        g = new a(this);
    }

    public void onCreate() {
        super.onCreate();
        if (!p.f((Context)this)) {
            MobileAds.a((Context)this, (c)new f(this));
        }
    }
}

