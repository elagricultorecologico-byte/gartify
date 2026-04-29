/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.activity.q
 *  androidx.appcompat.app.c$a
 *  androidx.appcompat.app.d
 *  androidx.lifecycle.p
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 *  u2.b
 *  u2.d
 *  v2.a
 *  w2.f
 *  x2.c
 *  x2.d
 *  y2.b
 *  y2.d
 *  z2.b
 *  z2.d
 */
package info.vazquezsoftware.matriculas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import info.vazquezsoftware.matriculas.ClasificacionActivity;
import info.vazquezsoftware.matriculas.MainActivity;
import info.vazquezsoftware.matriculas.i;
import info.vazquezsoftware.matriculas.informeIA.InformeIAActivity;
import info.vazquezsoftware.matriculas.j;
import info.vazquezsoftware.matriculas.k;
import info.vazquezsoftware.matriculas.l;
import info.vazquezsoftware.matriculas.m;
import info.vazquezsoftware.matriculas.n;
import info.vazquezsoftware.matriculas.o;
import info.vazquezsoftware.matriculas.p;
import info.vazquezsoftware.matriculas.q;
import java.util.Objects;
import r2.t;
import t2.f;
import w2.f;

public class InformacionActivity
extends androidx.appcompat.app.d {
    public static s2.e e0;
    private static int f0;
    private String I;
    private String J;
    private v2.a K;
    private LinearLayout L;
    private RelativeLayout M;
    private TextView N;
    private RelativeLayout O;
    private ImageView P;
    private TextView Q;
    private TextView R;
    private Button S;
    private TextView T;
    private TextView U;
    private ImageView V;
    private ImageView W;
    private Button X;
    private Button Y;
    private boolean Z = false;
    private boolean a0 = false;
    private boolean b0 = false;
    private AsyncTask c0;
    private r2.m d0;

    private void G0(int n2) {
        c.a a2 = new c.a((Context)this);
        a2.j(2131886165);
        EditText editText = new EditText((Context)this);
        editText.setInputType(131073);
        editText.setText((CharSequence)this.d0.a());
        a2.l((View)editText);
        a2.h(2131886201, (DialogInterface.OnClickListener)new r2.d(this, editText, n2));
        a2.f(2131886131, (DialogInterface.OnClickListener)new r2.e());
        a2.m();
    }

    private void H0(boolean bl) {
        t2.f.i((Context)this, this.J, new f.b(this, bl){
            final boolean a;
            final InformacionActivity b;
            {
                this.b = informacionActivity;
                this.a = bl;
            }

            public static /* synthetic */ void c(g g2) {
                g2.f();
            }

            public static /* synthetic */ void d(g g2) {
                g2.e();
            }

            private /* synthetic */ void e() {
                this.b.K0();
            }

            private /* synthetic */ void f() {
                this.b.Y0(true);
                this.b.U.setText((CharSequence)this.b.d0.a());
            }

            @Override
            public void a(String string) {
                f0 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("This is the error: ");
                stringBuilder.append(string);
                r2.k.a("XXX", stringBuilder.toString());
                if (!this.a && !(string = F2.c.c("6")).equals((Object)"D")) {
                    this.b.c1(string, true);
                    return;
                }
                this.b.runOnUiThread(new n(this));
            }

            @Override
            public void b(String string) {
                f0 = f0 + 1;
                this.b.d0.k(string);
                this.b.runOnUiThread(new o(this));
                this.b.K.A(this.b.d0);
            }
        });
    }

    private void I0(boolean bl) {
        u2.b.b((String)this.J, (u2.c)new u2.c(this, bl){
            final boolean a;
            final InformacionActivity b;
            {
                this.b = informacionActivity;
                this.a = bl;
            }

            public static /* synthetic */ void c(f f2) {
                f2.f();
            }

            public static /* synthetic */ void d(f f2) {
                f2.e();
            }

            private /* synthetic */ void e() {
                this.b.K0();
            }

            private /* synthetic */ void f() {
                this.b.Y0(true);
                this.b.U.setText((CharSequence)this.b.d0.a());
            }

            @Override
            public void a(String string) {
                f0 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("This is the error: ");
                stringBuilder.append(string);
                r2.k.a("XXX", stringBuilder.toString());
                if (!this.a && !(string = F2.c.c("1")).equals((Object)"D")) {
                    this.b.c1(string, true);
                    return;
                }
                this.b.runOnUiThread(new m(this));
            }

            @Override
            public void b(u2.d d2) {
                String string;
                f0 = f0 + 1;
                r2.m m2 = this.b.d0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(d2.a);
                stringBuilder.append("\n");
                stringBuilder.append(d2.b);
                stringBuilder.append("\n");
                if (d2.c.length() > 0) {
                    string = new StringBuilder();
                    string.append(d2.c);
                    string.append("\n");
                    string = string.toString();
                } else {
                    string = "";
                }
                stringBuilder.append(string);
                stringBuilder.append(d2.d);
                m2.k(stringBuilder.toString());
                this.b.runOnUiThread(new l(this));
                this.b.K.A(this.b.d0);
            }
        });
    }

    private void J0() {
        Button button = this.Y;
        if (button != null) {
            if (this.Z && this.a0 && this.b0) {
                button.setEnabled(true);
                if (!r2.p.d((Context)this)) {
                    button = AnimationUtils.loadAnimation((Context)this, (int)2130771980);
                    this.Y.startAnimation((Animation)button);
                    return;
                }
            } else {
                button.setEnabled(false);
                this.Y.clearAnimation();
            }
        }
    }

    private void K0() {
        this.Y0(false);
        Toast.makeText((Context)this, (int)2131886163, (int)0).show();
    }

    private void L0() {
        this.Z = false;
        this.J0();
        this.S.setVisibility(8);
        this.Q.setText(2131886107);
        this.P.setBackgroundResource(2131230886);
        this.P.startAnimation(AnimationUtils.loadAnimation((Context)this, (int)2130772013));
        w2.f.f((Context)this, (String)this.J, (f.a)new f.a(this){
            final InformacionActivity a;
            {
                this.a = informacionActivity;
            }

            @Override
            public void a(String string) {
                this.a.P.clearAnimation();
                this.a.Z = true;
                this.a.S.setVisibility(0);
                this.a.P.setBackgroundResource(2131230989);
                this.a.Q.setText(2131886176);
                this.a.J0();
            }

            @Override
            public void b(String string) {
                this.a.P.clearAnimation();
                this.a.Z = true;
                if (string.contains((CharSequence)"Ambiental B")) {
                    this.a.Q.setText(2131886183);
                    this.a.P.setBackgroundResource(2131230842);
                    this.a.d0.l(4);
                } else if (string.contains((CharSequence)"Ambiental 0")) {
                    this.a.Q.setText(2131886184);
                    this.a.P.setBackgroundResource(2131230860);
                    this.a.d0.l(1);
                } else if (string.contains((CharSequence)"Ambiental C")) {
                    this.a.Q.setText(2131886188);
                    this.a.P.setBackgroundResource(2131231012);
                    this.a.d0.l(3);
                } else if (string.contains((CharSequence)"Ambiental ECO")) {
                    this.a.Q.setText(2131886185);
                    this.a.P.setBackgroundResource(2131230887);
                    this.a.d0.l(2);
                } else if (string.contains((CharSequence)"Sin distintivo")) {
                    this.a.Q.setText(2131886187);
                    this.a.P.setBackgroundResource(2131231008);
                    this.a.d0.l(5);
                } else {
                    this.a.Q.setText(2131886186);
                    this.a.P.setBackgroundResource(2131230989);
                    this.a.d0.l(0);
                }
                this.a.K.A(this.a.d0);
                this.a.J0();
            }
        });
    }

    private void M0(boolean bl) {
        y2.b.b((String)this.J, (y2.c)new y2.c(this, bl){
            final boolean a;
            final InformacionActivity b;
            {
                this.b = informacionActivity;
                this.a = bl;
            }

            public static /* synthetic */ void c(e e2) {
                e2.d();
            }

            private /* synthetic */ void d() {
                this.b.K0();
            }

            @Override
            public void a(String string) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("This is the error: ");
                stringBuilder.append(string);
                r2.k.a("XXX", stringBuilder.toString());
                if (!this.a && !(string = F2.c.c("0")).equals((Object)"D")) {
                    this.b.c1(string, true);
                    return;
                }
                this.b.runOnUiThread(new i(this));
            }

            @Override
            public void b(y2.d d2) {
                x2.c.c((String)d2.c, (x2.a)new x2.a(this){
                    final e a;
                    {
                        this.a = e2;
                    }

                    public static /* synthetic */ void c(a a2) {
                        a2.e();
                    }

                    public static /* synthetic */ void d(a a2) {
                        a2.f();
                    }

                    private /* synthetic */ void e() {
                        this.a.b.K0();
                    }

                    private /* synthetic */ void f() {
                        this.a.b.Y0(true);
                        this.a.b.U.setText((CharSequence)this.a.b.d0.a());
                    }

                    @Override
                    public void a(String string) {
                        f0 = 0;
                        r2.k.a("XXX", string);
                        if (!this.a.a && !(string = F2.c.c("0")).equals((Object)"D")) {
                            this.a.b.c1(string, true);
                            return;
                        }
                        this.a.b.runOnUiThread(new j(this));
                    }

                    @Override
                    public void b(x2.d d2) {
                        f0 = f0 + 1;
                        r2.m m2 = this.a.b.d0;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(d2.a);
                        stringBuilder.append("\n");
                        stringBuilder.append(d2.b);
                        stringBuilder.append("\n");
                        stringBuilder.append(d2.c);
                        m2.k(stringBuilder.toString());
                        this.a.b.runOnUiThread(new k(this));
                        this.a.b.K.A(this.a.b.d0);
                    }
                });
            }
        });
    }

    private int N0(int n2) {
        if (n2 == 0) {
            return 2131230989;
        }
        if (n2 == 1) {
            return 2131230860;
        }
        if (n2 == 2) {
            return 2131230887;
        }
        if (n2 == 3) {
            return 2131231012;
        }
        if (n2 == 4) {
            return 2131230842;
        }
        if (n2 == 5) {
            return 2131231008;
        }
        return 2131230989;
    }

    private int O0(int n2) {
        if (n2 == 0) {
            return 2131886186;
        }
        if (n2 == 1) {
            return 2131886184;
        }
        if (n2 == 2) {
            return 2131886185;
        }
        if (n2 == 3) {
            return 2131886188;
        }
        if (n2 == 4) {
            return 2131886183;
        }
        if (n2 == 5) {
            return 2131886187;
        }
        return 2131886177;
    }

    private void P0(boolean bl) {
        z2.b.b((String)this.J, (z2.c)new z2.c(this, bl){
            final boolean a;
            final InformacionActivity b;
            {
                this.b = informacionActivity;
                this.a = bl;
            }

            public static /* synthetic */ void c(a a2) {
                a2.f();
            }

            public static /* synthetic */ void d(a a2) {
                a2.e();
            }

            private /* synthetic */ void e() {
                this.b.K0();
            }

            private /* synthetic */ void f() {
                this.b.Y0(true);
                this.b.U.setText((CharSequence)this.b.d0.a());
            }

            @Override
            public void a(String string) {
                f0 = 0;
                r2.k.a("XXX", string);
                if (!this.a && !(string = F2.c.c("4")).equals((Object)"D")) {
                    this.b.c1(string, true);
                    return;
                }
                this.b.runOnUiThread(new info.vazquezsoftware.matriculas.b(this));
            }

            @Override
            public void b(z2.d object) {
                f0 = f0 + 1;
                r2.m m2 = this.b.d0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(object.a);
                stringBuilder.append("\n");
                stringBuilder.append(object.b);
                if (object.c.length() > 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("\n");
                    stringBuilder2.append(object.c);
                    object = stringBuilder2.toString();
                } else {
                    object = "";
                }
                stringBuilder.append((String)object);
                m2.k(stringBuilder.toString());
                this.b.runOnUiThread(new info.vazquezsoftware.matriculas.a(this));
                this.b.K.A(this.b.d0);
            }
        });
    }

    private /* synthetic */ void Q0() {
        this.Z0(this.getCurrentFocus());
    }

    private /* synthetic */ void R0(EditText object, int n2, DialogInterface dialogInterface, int n3) {
        new Handler().postDelayed((Runnable)new r2.h(this), 100L);
        object = object.getText().toString();
        this.d0.k((String)object);
        if (n2 == 1) {
            this.d0.o(1);
            this.M.setVisibility(0);
            this.U.setVisibility(0);
            Toast.makeText((Context)this, (int)2131886254, (int)0).show();
        } else if (n2 == 0) {
            Toast.makeText((Context)this, (int)2131886166, (int)0).show();
        }
        this.U.setText((CharSequence)object);
        this.K.A(this.d0);
    }

    private /* synthetic */ void S0() {
        this.K0();
    }

    private /* synthetic */ void T0() {
        this.K0();
    }

    private void U0(boolean bl) {
        B2.b.b(this.J, new B2.c(this, bl){
            final boolean a;
            final InformacionActivity b;
            {
                this.b = informacionActivity;
                this.a = bl;
            }

            public static /* synthetic */ void c(b b2) {
                b2.f();
            }

            public static /* synthetic */ void d(b b2) {
                b2.e();
            }

            private /* synthetic */ void e() {
                this.b.K0();
            }

            private /* synthetic */ void f() {
                this.b.Y0(true);
                this.b.U.setText((CharSequence)this.b.d0.a());
            }

            @Override
            public void a(String string) {
                f0 = 0;
                r2.k.a("XXX", string);
                if (!this.a && !(string = F2.c.c("2")).equals((Object)"D")) {
                    this.b.c1(string, true);
                    return;
                }
                this.b.runOnUiThread(new info.vazquezsoftware.matriculas.d(this));
            }

            @Override
            public void b(B2.d d2) {
                String string;
                f0 = f0 + 1;
                r2.m m2 = this.b.d0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(d2.a);
                stringBuilder.append("\n");
                stringBuilder.append(d2.b);
                stringBuilder.append("\n");
                int n2 = d2.c.length();
                String string2 = "";
                if (n2 > 0) {
                    string = new StringBuilder();
                    string.append(d2.c);
                    string.append("\n");
                    string = string.toString();
                } else {
                    string = "";
                }
                stringBuilder.append(string);
                stringBuilder.append(d2.e);
                string = string2;
                if (d2.d.length() > 0) {
                    string = new StringBuilder();
                    string.append("\n");
                    string.append(d2.d);
                    string = string.toString();
                }
                stringBuilder.append(string);
                m2.k(stringBuilder.toString());
                this.b.runOnUiThread(new info.vazquezsoftware.matriculas.c(this));
                this.b.K.A(this.b.d0);
            }
        });
    }

    private void V0() {
        this.a0 = false;
        this.b0 = false;
        this.J0();
        this.M.setVisibility(0);
        this.U.setVisibility(8);
        this.W.setVisibility(8);
        this.V.setVisibility(0);
        Button button = this.X;
        if (button != null) {
            button.setEnabled(false);
        }
        button = AnimationUtils.loadAnimation((Context)this, (int)2130772013);
        this.V.startAnimation((Animation)button);
    }

    private void W0() {
        r2.c c2 = new r2.c((Context)this);
        r2.b b2 = c2.c(this.J);
        if (b2 != null) {
            r2.m m2 = this.d0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b2.a());
            stringBuilder.append("/");
            stringBuilder.append(b2.b());
            m2.p(stringBuilder.toString());
            stringBuilder = this.T;
            m2 = new StringBuilder();
            m2.append(c2.p(b2.b()));
            m2.append(", ");
            m2.append(b2.a());
            stringBuilder.setText((CharSequence)m2.toString());
            b2 = c2.m(b2);
            this.R.setText((CharSequence)this.getString(2131886113, new Object[]{b2.a(), b2.b()}));
            this.L.setVisibility(0);
        }
    }

    private void X0(boolean bl) {
        C2.b.b(this.J, new C2.c(this, bl){
            final boolean a;
            final InformacionActivity b;
            {
                this.b = informacionActivity;
                this.a = bl;
            }

            public static /* synthetic */ void c(c c2) {
                c2.f();
            }

            public static /* synthetic */ void d(c c2) {
                c2.e();
            }

            private /* synthetic */ void e() {
                this.b.K0();
            }

            private /* synthetic */ void f() {
                this.b.Y0(true);
                this.b.U.setText((CharSequence)this.b.d0.a());
            }

            @Override
            public void a(String string) {
                f0 = 0;
                r2.k.a("XXX", string);
                if (!this.a && !(string = F2.c.c("5")).equals((Object)"D")) {
                    this.b.c1(string, true);
                    return;
                }
                this.b.runOnUiThread(new info.vazquezsoftware.matriculas.e(this));
            }

            @Override
            public void b(C2.d d2) {
                String string;
                f0 = f0 + 1;
                r2.m m2 = this.b.d0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(d2.a);
                stringBuilder.append("\n");
                stringBuilder.append(d2.b);
                stringBuilder.append("\n");
                int n2 = d2.c.length();
                String string2 = "";
                if (n2 > 0) {
                    string = new StringBuilder();
                    string.append(d2.c);
                    string.append("\n");
                    string = string.toString();
                } else {
                    string = "";
                }
                stringBuilder.append(string);
                string = string2;
                if (d2.d.length() > 0) {
                    string = new StringBuilder();
                    string.append(d2.d);
                    string.append("\n");
                    string = string.toString();
                }
                stringBuilder.append(string);
                stringBuilder.append(d2.e);
                stringBuilder.append("\n");
                stringBuilder.append(d2.f);
                m2.k(stringBuilder.toString());
                this.b.runOnUiThread(new info.vazquezsoftware.matriculas.f(this));
                this.b.K.A(this.b.d0);
            }
        });
    }

    private void Y0(boolean bl) {
        this.a0 = true;
        this.b0 = bl;
        this.J0();
        this.V.clearAnimation();
        this.V.setVisibility(8);
        this.W.setVisibility(0);
        Button button = this.X;
        if (button != null) {
            button.setEnabled(true);
        }
        if (bl) {
            this.M.setVisibility(0);
            this.U.setVisibility(0);
            return;
        }
        this.M.setVisibility(0);
        this.U.setVisibility(0);
        this.U.setText(2131886163);
    }

    private void Z0(View view) {
        InputMethodManager inputMethodManager;
        if (view != null && (inputMethodManager = (InputMethodManager)this.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void a1() {
        androidx.activity.q q2 = new androidx.activity.q(this, true){
            final InformacionActivity d;
            {
                this.d = informacionActivity;
                super(bl);
            }

            public static /* synthetic */ void l(L1.i i2) {
            }

            public static /* synthetic */ void m(h h2, h2.c c2, L1.i i2) {
                h2.n(c2, i2);
            }

            private /* synthetic */ void n(h2.c c2, L1.i object) {
                if (((L1.i)object).m()) {
                    object = (h2.b)((L1.i)object).j();
                    c2.a((Activity)this.d, (h2.b)object).b(new q());
                }
            }

            public void d() {
                if (f0 > 1) {
                    h2.c c2 = h2.d.a((Context)this.d);
                    c2.b().b(new p(this, c2));
                }
                this.d.finish();
            }
        };
        this.c().h((androidx.lifecycle.p)this, q2);
    }

    private void b1(boolean bl) {
        D2.b.b(this.J, new D2.c(this, bl){
            final boolean a;
            final InformacionActivity b;
            {
                this.b = informacionActivity;
                this.a = bl;
            }

            public static /* synthetic */ void c(d d2) {
                d2.f();
            }

            public static /* synthetic */ void d(d d2) {
                d2.e();
            }

            private /* synthetic */ void e() {
                this.b.K0();
            }

            private /* synthetic */ void f() {
                this.b.Y0(true);
                this.b.U.setText((CharSequence)this.b.d0.a());
            }

            @Override
            public void a(String string) {
                f0 = 0;
                r2.k.a("XXX", string);
                if (!this.a && !(string = F2.c.c("3")).equals((Object)"D")) {
                    this.b.c1(string, true);
                    return;
                }
                this.b.runOnUiThread(new info.vazquezsoftware.matriculas.h(this));
            }

            @Override
            public void b(D2.d d2) {
                f0 = f0 + 1;
                r2.m m2 = this.b.d0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(d2.a);
                stringBuilder.append("\n");
                stringBuilder.append(d2.b);
                m2.k(stringBuilder.toString());
                this.b.runOnUiThread(new info.vazquezsoftware.matriculas.g(this));
                this.b.K.A(this.b.d0);
            }
        });
    }

    private void c1(String string, boolean bl) {
        if (string.equals((Object)"0")) {
            this.M0(bl);
            return;
        }
        if (string.equals((Object)"1")) {
            this.I0(bl);
            return;
        }
        if (string.equals((Object)"4")) {
            this.P0(bl);
            return;
        }
        if (string.equals((Object)"2")) {
            this.U0(bl);
            return;
        }
        if (string.equals((Object)"5")) {
            this.X0(bl);
            return;
        }
        if (string.equals((Object)"3")) {
            this.b1(bl);
            return;
        }
        if (string.equals((Object)"6")) {
            this.H0(bl);
            return;
        }
        if (string.equals((Object)"D")) {
            r2.k.a("XXX", "No access to plate servers.");
            this.runOnUiThread(new r2.f(this));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown remoteMode: ");
        stringBuilder.append(string);
        r2.k.a("XXX", stringBuilder.toString());
        this.runOnUiThread(new r2.g(this));
    }

    public static /* synthetic */ void o0(InformacionActivity informacionActivity) {
        informacionActivity.S0();
    }

    public static /* synthetic */ void p0(InformacionActivity informacionActivity) {
        informacionActivity.T0();
    }

    public static /* synthetic */ void q0(DialogInterface dialogInterface, int n2) {
    }

    public static /* synthetic */ void r0(InformacionActivity informacionActivity) {
        informacionActivity.Q0();
    }

    public static /* synthetic */ void s0(InformacionActivity informacionActivity, EditText editText, int n2, DialogInterface dialogInterface, int n3) {
        informacionActivity.R0(editText, n2, dialogInterface, n3);
    }

    public void onClickEditarDescripcion(View view) {
        this.G0(0);
    }

    public void onClickGuardar(View view) {
        this.G0(1);
    }

    public void onClickInfoDistintivo(View view) {
        this.startActivity(new Intent((Context)this, ClasificacionActivity.class));
    }

    public void onClickInformeIA(View object) {
        object = this.d0;
        boolean bl = object != null && ((r2.m)object).g() != null && !this.d0.g().isEmpty();
        boolean bl2 = r2.p.f((Context)this);
        if (!(bl || bl2 || r2.p.b((Context)this))) {
            new AlertDialog.Builder((Context)this).setTitle((CharSequence)"L\u00edmite diario").setMessage(2131886368).setPositiveButton(17039370, null).show();
            return;
        }
        if (!bl && !bl2) {
            r2.p.a((Context)this);
        }
        if (!r2.p.d((Context)this)) {
            r2.p.h((Context)this, true);
            this.Y.clearAnimation();
        }
        Intent intent = new Intent((Context)this, InformeIAActivity.class);
        object = this.d0;
        String string = "";
        object = object != null && ((r2.m)object).a() != null ? this.d0.a() : "";
        Object object2 = this.Q;
        object2 = object2 != null && object2.getText() != null ? this.Q.getText().toString() : "";
        TextView textView = this.R;
        String string2 = string;
        if (textView != null) {
            string2 = string;
            if (textView.getText() != null) {
                string2 = this.R.getText().toString();
            }
        }
        intent.putExtra(MainActivity.M, this.J);
        intent.putExtra("modelo", (String)object);
        intent.putExtra("distintivo", (String)object2);
        intent.putExtra("fecha", string2);
        object = this.d0;
        if (object != null && ((r2.m)object).g() != null && !this.d0.g().isEmpty()) {
            intent.putExtra("informe_ia_cached", this.d0.g());
        }
        this.startActivity(intent);
    }

    public void onClickReintentarDistintivo(View view) {
        this.L0();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.setContentView(2131492894);
        t.b(this.findViewById(2131296705), 20);
        object = this.c0();
        Objects.requireNonNull((Object)object);
        object.r(true);
        if (!r2.p.f((Context)this)) {
            try {
                e0.o((Activity)this);
            }
            catch (Exception exception) {}
        }
        this.I = this.getIntent().getStringExtra(MainActivity.M);
        r2.n n2 = new r2.n((Context)this);
        this.I = object = n2.h(this.I);
        this.J = n2.l((String)object);
        this.L = (LinearLayout)this.findViewById(2131296545);
        this.M = (RelativeLayout)this.findViewById(2131296702);
        object = (TextView)this.findViewById(2131296843);
        this.N = object;
        object.setText((CharSequence)this.I);
        this.O = (RelativeLayout)this.findViewById(2131296703);
        this.P = (ImageView)this.findViewById(2131296524);
        this.Q = (TextView)this.findViewById(2131296833);
        this.S = (Button)this.findViewById(2131296375);
        this.T = (TextView)this.findViewById(2131296836);
        this.R = (TextView)this.findViewById(2131296835);
        this.U = (TextView)this.findViewById(2131296832);
        this.V = (ImageView)this.findViewById(2131296522);
        this.W = (ImageView)this.findViewById(2131296526);
        this.X = (Button)this.findViewById(2131296372);
        object = (Button)this.findViewById(2131296373);
        this.Y = object;
        object.setEnabled(false);
        object = v2.a.j((Context)this);
        this.K = object;
        this.d0 = object = object.i(this.J);
        if (object == null) {
            this.d0 = object = new r2.m();
            ((r2.m)object).s(this.J);
            this.L0();
            this.V0();
            this.c1(F2.c.d(), false);
        } else {
            if (((r2.m)object).b() != 6 && this.d0.b() != 0) {
                this.Z = true;
                this.Q.setText(this.O0(this.d0.b()));
                this.P.setBackgroundResource(this.N0(this.d0.b()));
            } else {
                this.L0();
            }
            if (this.d0.a() != null) {
                this.a0 = true;
                this.b0 = true;
                this.M.setVisibility(0);
                this.U.setVisibility(0);
                this.U.setText((CharSequence)this.d0.a());
            } else {
                this.V0();
                this.c1(F2.c.d(), false);
            }
        }
        this.J0();
        this.W0();
        this.a1();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.onBackPressed();
        return true;
    }

    protected void onResume() {
        Object object;
        super.onResume();
        v2.a a2 = this.K;
        if (a2 != null && (object = this.J) != null && (object = a2.i((String)object)) != null) {
            this.d0 = object;
            this.J0();
        }
    }

    protected void onStop() {
        super.onStop();
        AsyncTask asyncTask = this.c0;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
    }
}

