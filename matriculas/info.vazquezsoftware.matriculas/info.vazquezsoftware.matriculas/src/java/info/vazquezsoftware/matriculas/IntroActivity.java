/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.widget.LinearLayout
 *  androidx.appcompat.app.d
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package info.vazquezsoftware.matriculas;

import F2.a;
import F2.c;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.d;
import info.vazquezsoftware.matriculas.InformacionActivity;
import info.vazquezsoftware.matriculas.MainActivity;
import q2.h;
import r2.i;
import r2.j;
import r2.p;
import s2.e;

public class IntroActivity
extends d {
    private LinearLayout I;

    public static /* synthetic */ void o0(IntroActivity introActivity, String string) {
        introActivity.u0(string);
    }

    public static /* synthetic */ void p0(IntroActivity introActivity) {
        introActivity.v0();
    }

    private void s0() {
        c.b(new a(this){
            final IntroActivity a;
            {
                this.a = introActivity;
            }

            @Override
            public void b(String string) {
                this.a.startActivity(new Intent((Context)this.a, MainActivity.class));
                this.a.finish();
            }

            @Override
            public void c(String string) {
                this.a.startActivity(new Intent((Context)this.a, MainActivity.class));
                this.a.finish();
            }
        });
    }

    private void t0() {
        this.I.setVisibility(0);
        new Thread((Runnable)new i(this)).start();
    }

    private /* synthetic */ void u0(String string) {
        InformacionActivity.e0 = new e("High Floor", this.getString(2131886211), this.getString(2131886212));
    }

    private /* synthetic */ void v0() {
        e.j((Context)this, new j(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131492896);
        this.I = (LinearLayout)this.findViewById(2131296547);
        if (p.f((Context)this)) {
            this.s0();
            return;
        }
        h.p((Activity)this, new h.a(this){
            final IntroActivity a;
            {
                this.a = introActivity;
            }

            @Override
            public void a(boolean bl) {
                this.a.t0();
                this.a.s0();
            }

            @Override
            public void b() {
                this.a.t0();
                this.a.s0();
            }
        });
    }
}

