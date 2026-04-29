/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Pair
 *  android.view.MotionEvent
 *  android.view.View
 *  android.webkit.JavascriptInterface
 *  android.webkit.WebView
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.internal.ads.Dc0
 *  com.google.android.gms.internal.ads.Fu
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.QS
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.ez0
 *  com.google.android.gms.internal.ads.fk
 *  com.google.android.gms.internal.ads.jg0
 *  com.google.android.gms.internal.ads.md
 *  com.google.android.gms.internal.ads.nd
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.UUID
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package l1;

import T0.c;
import T0.g;
import a1.t;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import b1.A;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.Dc0;
import com.google.android.gms.internal.ads.Fu;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.QS;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.ez0;
import com.google.android.gms.internal.ads.fk;
import com.google.android.gms.internal.ads.jg0;
import com.google.android.gms.internal.ads.md;
import com.google.android.gms.internal.ads.nd;
import e1.X0;
import e1.o0;
import f1.p;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l1.I;
import l1.J;
import l1.K;
import l1.L;
import l1.M;
import l1.P;
import l1.V;
import l1.b;
import l1.h0;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private final Context a;
    private final WebView b;
    private final md c;
    private final Dc0 d;
    private final int e;
    private final QS f;
    private final boolean g;
    private final ez0 h = Fu.f;
    private final jg0 i;
    private final V j;
    private final b k;
    private final P l;

    a(WebView webView, md md2, QS qS, jg0 jg02, Dc0 dc0, V v2, b b2, P p2) {
        this.b = webView;
        webView = webView.getContext();
        this.a = webView;
        this.c = md2;
        this.f = qS;
        Yi.a((Context)webView);
        webView = Yi.Xa;
        this.e = (Integer)A.c().d((Oi)webView);
        webView = Yi.Ya;
        this.g = (Boolean)A.c().d((Oi)webView);
        this.i = jg02;
        this.d = dc0;
        this.j = v2;
        this.k = b2;
        this.l = p2;
    }

    final /* synthetic */ void a(Bundle bundle, o1.b b2) {
        X0 x0 = t.j();
        Context context = this.a;
        boolean bl = (x0 = x0.a(context)) != null ? x0.acceptThirdPartyCookies(this.b) : false;
        bundle.putBoolean("accept_3p_cookie", bl);
        o1.a.a(context, T0.c.h, ((g.a)new g.a().c(AdMobAdapter.class, bundle)).k(), b2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final /* synthetic */ void b(String string) {
        block3: {
            nd nd22;
            block4: {
                Oi oi;
                block2: {
                    string = Uri.parse((String)string);
                    try {
                        oi = Yi.vd;
                        if (!((Boolean)A.c().d(oi)).booleanValue() || (oi = this.d) == null) break block2;
                        oi = oi.a((Uri)string, this.a, (View)this.b, null);
                        string = oi;
                        break block3;
                    }
                    catch (nd nd22) {
                        break block4;
                    }
                }
                oi = this.c.d((Uri)string, this.a, (View)this.b, null);
                string = oi;
                break block3;
            }
            int n2 = o0.b;
            p.b("Failed to append the click signal to URL: ", nd22);
            t.l().j((Throwable)nd22, "TaggingLibraryJsInterface.recordClick");
        }
        this.i.b(string.toString(), null, null, null);
    }

    final /* synthetic */ WebView c() {
        return this.b;
    }

    final /* synthetic */ ez0 d() {
        return this.h;
    }

    final /* synthetic */ b e() {
        return this.k;
    }

    final /* synthetic */ P f() {
        return this.l;
    }

    @JavascriptInterface
    public String getClickSignals(String string) {
        RuntimeException runtimeException2;
        block3: {
            try {
                long l2 = t.o().b();
                string = this.c.b().i(this.a, string, (View)this.b);
                if (this.g) {
                    long l3 = t.o().b();
                    QS qS = this.f;
                    Pair pair = new Pair((Object)"clat", (Object)String.valueOf((long)(l3 - l2)));
                    h0.e(qS, null, "csg", pair);
                    return string;
                }
            }
            catch (RuntimeException runtimeException2) {
                break block3;
            }
            return string;
        }
        int n2 = o0.b;
        p.d("Exception getting click signals. ", runtimeException2);
        t.l().j((Throwable)runtimeException2, "TaggingLibraryJsInterface.getClickSignals");
        return "";
    }

    /*
     * WARNING - void declaration
     */
    @JavascriptInterface
    public String getClickSignalsWithTimeout(String object, int n2) {
        void var1_5;
        if (n2 <= 0) {
            object = new StringBuilder(String.valueOf((int)n2).length() + 51);
            object.append("Invalid timeout for getting click signals. Timeout=");
            object.append(n2);
            object = object.toString();
            n2 = o0.b;
            p.c((String)object);
            return "";
        }
        n2 = Math.min((int)n2, (int)this.e);
        object = Fu.a.g0((Callable)new K(this, (String)object));
        long l2 = n2;
        try {
            object = (String)object.get(l2, TimeUnit.MILLISECONDS);
            return object;
        }
        catch (ExecutionException executionException) {
        }
        catch (TimeoutException timeoutException) {
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        n2 = o0.b;
        p.d("Exception getting click signals with timeout. ", (Throwable)var1_5);
        t.l().j((Throwable)var1_5, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
        if (var1_5 instanceof TimeoutException) {
            return "17";
        }
        return "";
    }

    @JavascriptInterface
    public String getQueryInfo() {
        t.g();
        String string = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        I i2 = new I(this, string);
        if (((Boolean)fk.e.e()).booleanValue()) {
            this.j.b(this.b, i2);
            return string;
        }
        Oi oi = Yi.ab;
        if (((Boolean)A.c().d(oi)).booleanValue()) {
            this.h.execute((Runnable)new M(this, bundle, i2));
            return string;
        }
        o1.a.a(this.a, T0.c.h, ((g.a)new g.a().c(AdMobAdapter.class, bundle)).k(), i2);
        return string;
    }

    @JavascriptInterface
    public String getViewSignals() {
        RuntimeException runtimeException2;
        block3: {
            String string;
            try {
                long l2 = t.o().b();
                string = this.c.b().k(this.a, (View)this.b, null);
                if (this.g) {
                    long l3 = t.o().b();
                    QS qS = this.f;
                    Pair pair = new Pair((Object)"vlat", (Object)String.valueOf((long)(l3 - l2)));
                    h0.e(qS, null, "vsg", pair);
                    return string;
                }
            }
            catch (RuntimeException runtimeException2) {
                break block3;
            }
            return string;
        }
        int n2 = o0.b;
        p.d("Exception getting view signals. ", runtimeException2);
        t.l().j((Throwable)runtimeException2, "TaggingLibraryJsInterface.getViewSignals");
        return "";
    }

    /*
     * WARNING - void declaration
     */
    @JavascriptInterface
    public String getViewSignalsWithTimeout(int n2) {
        void var4_7;
        if (n2 <= 0) {
            Object object = new StringBuilder(String.valueOf((int)n2).length() + 50);
            object.append("Invalid timeout for getting view signals. Timeout=");
            object.append(n2);
            object = object.toString();
            n2 = o0.b;
            p.c((String)object);
            return "";
        }
        n2 = Math.min((int)n2, (int)this.e);
        Object object = Fu.a.g0((Callable)new J(this));
        long l2 = n2;
        try {
            object = (String)object.get(l2, TimeUnit.MILLISECONDS);
            return object;
        }
        catch (ExecutionException executionException) {
        }
        catch (TimeoutException timeoutException) {
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        n2 = o0.b;
        p.d("Exception getting view signals with timeout. ", (Throwable)var4_7);
        t.l().j((Throwable)var4_7, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
        if (var4_7 instanceof TimeoutException) {
            return "17";
        }
        return "";
    }

    @JavascriptInterface
    public void recordClick(String string) {
        Oi oi = Yi.cb;
        if (((Boolean)A.c().d(oi)).booleanValue() && !TextUtils.isEmpty((CharSequence)string)) {
            Fu.a.execute((Runnable)new L(this, string));
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @JavascriptInterface
    public void reportTouchEvent(String string) {
        void var1_5;
        int n2;
        block8: {
            try {
                float f2;
                int n3;
                int n4;
                int n5;
                block10: {
                    block9: {
                        JSONObject jSONObject = new JSONObject(string);
                        n5 = jSONObject.getInt("x");
                        n4 = jSONObject.getInt("y");
                        n3 = jSONObject.getInt("duration_ms");
                        f2 = (float)jSONObject.getDouble("force");
                        int n6 = jSONObject.getInt("type");
                        if (n6 == 0) break block9;
                        n2 = 1;
                        if (n6 == 1) break block10;
                        n2 = 2;
                        if (n6 != 2) {
                            n2 = 3;
                            if (n6 != 3) {
                                n2 = -1;
                            }
                        }
                        break block10;
                    }
                    n2 = 0;
                }
                string = MotionEvent.obtain((long)0L, (long)n3, (int)n2, (float)n5, (float)n4, (float)f2, (float)1.0f, (int)0, (float)1.0f, (float)1.0f, (int)0, (int)0);
            }
            catch (JSONException jSONException) {
                break block8;
            }
            catch (RuntimeException runtimeException) {
                break block8;
            }
            try {
                this.c.c((MotionEvent)string);
                return;
            }
            catch (JSONException jSONException) {
            }
            catch (RuntimeException runtimeException) {}
        }
        n2 = o0.b;
        p.d("Failed to parse the touch string. ", (Throwable)var1_5);
        t.l().j((Throwable)var1_5, "TaggingLibraryJsInterface.reportTouchEvent");
    }
}

