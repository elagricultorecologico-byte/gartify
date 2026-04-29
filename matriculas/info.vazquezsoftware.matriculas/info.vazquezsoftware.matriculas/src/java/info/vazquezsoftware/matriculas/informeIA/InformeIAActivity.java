/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.SpannableStringBuilder
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.StyleSpan
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.appcompat.app.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 *  v2.a
 */
package info.vazquezsoftware.matriculas.informeIA;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.d;
import info.vazquezsoftware.matriculas.MainActivity;
import info.vazquezsoftware.matriculas.informeIA.a;
import info.vazquezsoftware.matriculas.informeIA.b;
import info.vazquezsoftware.matriculas.informeIA.c;
import java.util.Objects;
import r2.k;
import r2.m;

public class InformeIAActivity
extends d {
    private String I = "";
    private String J = "";
    private String K = "";
    private String L = "";
    private String M = null;
    private TextView N;
    private TextView O;
    private TextView P;
    private LinearLayout Q;
    private ScrollView R;
    private Button S;
    private final Handler T = new Handler(Looper.getMainLooper());
    private Runnable U;
    private boolean V = false;
    private A2.b W = null;
    private String X = null;

    private /* synthetic */ void A0() {
        this.V = true;
        this.X = "Error: El experto de IA est\u00e1 tardando demasiado en responder. Int\u00e9ntalo de nuevo.";
        this.x0();
    }

    private /* synthetic */ void B0(View view) {
        this.y0();
    }

    private void C0(String string) {
        this.Q.setVisibility(8);
        this.R.setVisibility(0);
        this.S.setVisibility(8);
        this.P.setText((CharSequence)string);
        this.P.setTextColor(-65536);
    }

    private void D0(A2.b b2) {
        this.Q.setVisibility(8);
        this.R.setVisibility(0);
        this.S.setVisibility(0);
        this.E0(b2);
    }

    private void E0(A2.b b2) {
        String string2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.w0(spannableStringBuilder, "\ud83d\udcb6 VALORACI\u00d3N ESTIMADA", -16777216, b2.a);
        Object object2 = new StringBuilder();
        for (String string2 : b2.b) {
            object2.append("\u2022 ");
            object2.append(string2);
            object2.append("\n");
        }
        this.w0(spannableStringBuilder, "\u2705 PUNTOS FUERTES", -16777216, object2.toString().trim());
        string2 = new StringBuilder();
        for (Object object2 : b2.c) {
            string2.append("\u2022 ");
            string2.append((String)object2);
            string2.append("\n");
        }
        this.w0(spannableStringBuilder, "\u26a0\ufe0f PUNTOS D\u00c9BILES", -16777216, string2.toString().trim());
        this.w0(spannableStringBuilder, "\u2696\ufe0f CONCLUSI\u00d3N DEL EXPERTO", -16777216, b2.d);
        this.P.setText((CharSequence)spannableStringBuilder);
    }

    private void F0() {
        this.N = (TextView)this.findViewById(2131296844);
        this.O = (TextView)this.findViewById(2131296847);
        this.P = (TextView)this.findViewById(2131296831);
        this.Q = (LinearLayout)this.findViewById(2131296548);
        this.R = (ScrollView)this.findViewById(2131296777);
        this.S = (Button)this.findViewById(2131296376);
        this.N.setText((CharSequence)this.I.toUpperCase());
        this.O.setText((CharSequence)String.format((String)"%s \u2022  %s", (Object[])new Object[]{this.J, this.K}));
        this.S.setOnClickListener((View.OnClickListener)new A2.c(this));
    }

    public static /* synthetic */ void o0(InformeIAActivity informeIAActivity) {
        informeIAActivity.A0();
    }

    public static /* synthetic */ void p0(InformeIAActivity informeIAActivity, View view) {
        informeIAActivity.B0(view);
    }

    private void w0(SpannableStringBuilder spannableStringBuilder, String string, int n2, String string2) {
        int n3 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence)string).append((CharSequence)"\n");
        int n4 = spannableStringBuilder.length();
        spannableStringBuilder.setSpan((Object)new StyleSpan(1), n3, n4, 33);
        spannableStringBuilder.setSpan((Object)new ForegroundColorSpan(n2), n3, n4, 33);
        spannableStringBuilder.append((CharSequence)string2).append((CharSequence)"\n\n");
    }

    private void x0() {
        if (this.V && !this.isFinishing() && !this.isDestroyed()) {
            Object object = this.U;
            if (object != null) {
                this.T.removeCallbacks(object);
                this.U = null;
            }
            if ((object = this.W) != null) {
                this.D0((A2.b)object);
                return;
            }
            object = this.X;
            if (object != null) {
                this.C0((String)object);
            }
        }
    }

    private void y0() {
        Object object = new StringBuilder();
        object.append("Informe IA para ");
        object.append(this.I);
        object.append(":\n\n");
        object.append(this.P.getText().toString());
        object = object.toString();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", (String)object);
        intent.setType("text/plain");
        this.startActivity(Intent.createChooser((Intent)intent, (CharSequence)"Compartir Informe"));
    }

    private void z0(A2.b object) {
        this.Q.setVisibility(0);
        this.R.setVisibility(4);
        this.S.setVisibility(4);
        if (object != null) {
            this.V = true;
            this.W = object;
            this.x0();
            return;
        }
        object = new A2.d(this);
        this.U = object;
        this.T.postDelayed((Runnable)object, 20000L);
        info.vazquezsoftware.matriculas.informeIA.a.b(this.I, this.J, this.K, new a.a(this){
            final InformeIAActivity a;
            {
                this.a = informeIAActivity;
            }

            public static /* synthetic */ void c(a a2) {
                a2.e();
            }

            public static /* synthetic */ void d(a a2, A2.b b2) {
                a2.f(b2);
            }

            private /* synthetic */ void e() {
                this.a.V = true;
                this.a.X = "No se ha podido generar la tasaci\u00f3n. Revisa tu conexi\u00f3n o int\u00e9ntalo de nuevo.";
                this.a.x0();
            }

            private /* synthetic */ void f(A2.b b2) {
                this.a.V = true;
                this.a.W = b2;
                this.a.x0();
            }

            @Override
            public void a(String string) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DeepSeek error: ");
                stringBuilder.append(string);
                k.a("XXX", stringBuilder.toString());
                this.a.T.post((Runnable)new c(this));
            }

            @Override
            public void b(A2.b b2) {
                if (this.a.L != null && !this.a.L.isEmpty()) {
                    m m2;
                    v2.a a2 = v2.a.j((Context)this.a);
                    m m3 = m2 = a2.i(this.a.L);
                    if (m2 == null) {
                        m3 = new m();
                        m3.s(this.a.L);
                    }
                    m3.r(b2.b());
                    a2.A(m3);
                }
                this.a.T.post((Runnable)new b(this, b2));
            }
        });
    }

    public boolean j0() {
        this.c().k();
        return true;
    }

    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.setContentView(2131492895);
        object = this.c0();
        Objects.requireNonNull((Object)object);
        object.r(true);
        this.setTitle(2131886209);
        if (this.getIntent().getExtras() != null) {
            this.L = this.getIntent().getStringExtra(MainActivity.M);
            object = this.getIntent().getStringExtra("modelo");
            this.I = object;
            if (object == null) {
                this.I = this.getIntent().getStringExtra("modelo_general");
            }
            this.J = this.getIntent().getStringExtra("fecha");
            this.K = this.getIntent().getStringExtra("distintivo");
            this.M = this.getIntent().getStringExtra("informe_ia_cached");
            if (this.I == null) {
                this.I = "";
            }
            this.I = this.I.replace((CharSequence)"\n", (CharSequence)" ");
            if (this.J == null) {
                this.J = "";
            }
            if (this.K == null) {
                this.K = "";
            }
        }
        this.F0();
        object = this.M;
        if (!(object != null && !object.isEmpty() || (object = this.L) == null || object.isEmpty() || (object = v2.a.j((Context)this).i(this.L)) == null || ((m)object).g() == null || ((m)object).g().isEmpty())) {
            this.M = ((m)object).g();
        }
        if ((object = this.M) != null && !object.isEmpty()) {
            this.z0(A2.b.a(this.M));
            return;
        }
        this.z0(null);
    }

    protected void onDestroy() {
        super.onDestroy();
        Runnable runnable = this.U;
        if (runnable != null) {
            this.T.removeCallbacks(runnable);
        }
        this.T.removeCallbacksAndMessages(null);
    }
}

