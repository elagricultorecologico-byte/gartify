/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.google.android.gms.internal.ads.Cs
 *  com.google.android.gms.internal.ads.Lj
 *  com.google.android.gms.internal.ads.lg
 *  com.google.android.gms.internal.ads.or
 *  com.google.android.gms.internal.ads.sr
 *  com.google.android.gms.internal.ads.tj
 *  f1.a
 *  f1.g
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.Map
 *  x1.n
 */
package a1;

import C1.b;
import a1.o;
import a1.p;
import a1.q;
import a1.r;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import b1.E;
import b1.H;
import b1.K;
import b1.Q0;
import b1.U;
import b1.U1;
import b1.X0;
import b1.Z;
import b1.b1;
import b1.c2;
import b1.f1;
import b1.h2;
import b1.l0;
import b1.n2;
import b1.p0;
import b1.s0;
import b1.x;
import com.google.android.gms.internal.ads.Cs;
import com.google.android.gms.internal.ads.Lj;
import com.google.android.gms.internal.ads.lg;
import com.google.android.gms.internal.ads.or;
import com.google.android.gms.internal.ads.sr;
import com.google.android.gms.internal.ads.tj;
import f1.a;
import f1.g;
import java.util.Map;
import x1.n;

public final class s
extends U {
    private final a g;
    private final h2 h;
    private final Context i;
    private final r j;
    private WebView k;
    private H l;
    private AsyncTask m;

    public s(Context context, h2 h22, String string, a a3) {
        this.i = context;
        this.g = a3;
        this.h = h22;
        this.k = new WebView(context);
        this.j = new r(context, string);
        this.M5(0);
        this.k.setVerticalScrollBarEnabled(false);
        this.k.getSettings().setJavaScriptEnabled(true);
        this.k.setWebViewClient((WebViewClient)new o(this));
        this.k.setOnTouchListener((View.OnTouchListener)new p(this));
    }

    @Override
    public final l0 A() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override
    public final H C() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override
    public final void C5(f1 f12) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final boolean D() {
        return false;
    }

    @Override
    public final b1 E() {
        return null;
    }

    @Override
    public final void E5(or or2) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void F3(Cs cs) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void H2(String string) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final boolean I() {
        return false;
    }

    @Override
    public final boolean I0(c2 c22) {
        n.j((Object)this.k, (Object)"This Search Ad has already been torn down");
        a a3 = this.g;
        this.j.f(c22, a3);
        this.m = new q(this, null).execute(new Void[0]);
        return true;
    }

    @Override
    public final void K1(E e3) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void K3(H h3) {
        this.l = h3;
    }

    final int L5(String string) {
        if (TextUtils.isEmpty((CharSequence)(string = Uri.parse((String)string).getQueryParameter("height")))) {
            return 0;
        }
        try {
            x.a();
            int n3 = f1.g.e((Context)this.i, (int)Integer.parseInt((String)string));
            return n3;
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    final void M5(int n3) {
        if (this.k == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, n3);
        this.k.setLayoutParams(layoutParams);
    }

    final String N5() {
        Object object = new Uri.Builder();
        object.scheme("https://").appendEncodedPath((String)Lj.d.e());
        Object object22 = this.j;
        if (((r)object22).b() != null) {
            object.appendQueryParameter("query", ((r)object22).b());
        }
        object.appendQueryParameter("pubId", ((r)object22).c());
        object.appendQueryParameter("mappver", ((r)object22).d());
        Map map = ((r)object22).e();
        for (Object object22 : map.keySet()) {
            object.appendQueryParameter((String)object22, (String)map.get(object22));
        }
        object22 = object.build();
        object = this.O5();
        object22 = object22.getEncodedQuery();
        map = new StringBuilder(object.length() + 1 + String.valueOf((Object)object22).length());
        map.append((String)object);
        map.append("#");
        map.append((String)object22);
        return map.toString();
    }

    final String O5() {
        String string;
        String string2 = string = this.j.a();
        if (TextUtils.isEmpty((CharSequence)string)) {
            string2 = "www.google.com";
        }
        string = (String)Lj.d.e();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf((Object)string2).length() + 8 + String.valueOf((Object)string).length());
        stringBuilder.append("https://");
        stringBuilder.append(string2);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    final /* synthetic */ void P5(String string) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string));
        this.i.startActivity(intent);
    }

    final /* synthetic */ WebView Q5() {
        return this.k;
    }

    final /* synthetic */ H R5() {
        return this.l;
    }

    @Override
    public final long S() {
        return 0L;
    }

    @Override
    public final void S2(Q0 q02) {
    }

    @Override
    public final void T1(tj tj2) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void V4(Z z2) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void W1(C1.a a3) {
    }

    @Override
    public final void Y1(boolean bl) {
    }

    @Override
    public final C1.a b() {
        n.e((String)"getAdFrame must be called on the main UI thread.");
        return b.h1(this.k);
    }

    @Override
    public final void b4(U1 u12) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void c1(sr sr2, String string) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void d() {
        n.e((String)"destroy must be called on the main UI thread.");
        this.m.cancel(true);
        this.k.destroy();
        this.k = null;
    }

    @Override
    public final void e() {
        n.e((String)"pause must be called on the main UI thread.");
    }

    @Override
    public final void e2(s0 s02) {
    }

    @Override
    public final void f() {
        n.e((String)"resume must be called on the main UI thread.");
    }

    @Override
    public final void g3(lg lg2) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void i() {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final Bundle j() {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void j4(l0 l02) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final boolean k() {
        return false;
    }

    @Override
    public final void m2(n2 n22) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void n() {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void n2(long l3) {
    }

    @Override
    public final h2 o() {
        return this.h;
    }

    @Override
    public final String p() {
        return null;
    }

    @Override
    public final X0 r() {
        return null;
    }

    @Override
    public final String t() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override
    public final void u1(String string) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void v5(p0 p02) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final String w() {
        return null;
    }

    @Override
    public final void w0(boolean bl) {
        throw new IllegalStateException("Unused method");
    }

    @Override
    public final void w4(h2 h22) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override
    public final void y3(c2 c22, K k3) {
    }
}

