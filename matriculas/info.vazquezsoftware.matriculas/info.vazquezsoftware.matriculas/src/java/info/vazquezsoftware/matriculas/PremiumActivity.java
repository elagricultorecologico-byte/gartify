/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.Button
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package info.vazquezsoftware.matriculas;

import E2.c;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.d;
import info.vazquezsoftware.matriculas.IntroActivity;
import info.vazquezsoftware.matriculas.r;
import info.vazquezsoftware.matriculas.s;
import r2.p;
import r2.t;

public class PremiumActivity
extends d {
    private c I;
    private Button J;

    public void onClickPremium(View view) {
        this.I.h((Activity)this);
    }

    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.setContentView(2131492899);
        t.b(this.findViewById(2131296707), 20);
        this.J = (Button)this.findViewById(2131296374);
        this.c0().r(true);
        object = new c("premium_version", new c.c(this){
            final PremiumActivity a;
            {
                this.a = premiumActivity;
            }

            public static /* synthetic */ void e(a a2, c.d d2) {
                a2.g(d2);
            }

            public static /* synthetic */ void f(a a2, int n2) {
                a2.h(n2);
            }

            private /* synthetic */ void g(c.d d2) {
                this.a.J.setEnabled(true);
                TextView textView = (TextView)this.a.findViewById(2131296840);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.getString(2131886207));
                stringBuilder.append("\n");
                stringBuilder.append(d2.a());
                textView.setText((CharSequence)stringBuilder.toString());
            }

            private /* synthetic */ void h(int n2) {
                if (n2 != 1) {
                    if (n2 != 7) {
                        Toast.makeText((Context)this.a, (CharSequence)"Compra fallida", (int)0).show();
                        return;
                    }
                    Toast.makeText((Context)this.a, (CharSequence)"Ya eras Premium", (int)0).show();
                    p.g((Context)this.a, true);
                    return;
                }
                Toast.makeText((Context)this.a, (CharSequence)"Cancelado", (int)0).show();
            }

            @Override
            public void a(String string) {
                Toast.makeText((Context)this.a, (CharSequence)"Error de conexi\u00f3n.", (int)0).show();
            }

            @Override
            public void b(int n2) {
                this.a.runOnUiThread(new r(this, n2));
            }

            @Override
            public void c(c.e e2) {
                p.g((Context)this.a, true);
                this.a.p0();
            }

            @Override
            public void d(c.d d2) {
                this.a.runOnUiThread(new s(this, d2));
            }
        });
        this.I = object;
        ((c)object).i((Context)this);
    }

    public void p0() {
        this.startActivity(new Intent((Context)this, IntroActivity.class));
        this.finishAffinity();
    }
}

