/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Looper
 *  android.security.NetworkSecurityPolicy
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.Fu
 *  com.google.android.gms.internal.ads.Of
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Qj
 *  com.google.android.gms.internal.ads.Rj
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.lu
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package e1;

import a1.t;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import b1.A;
import com.google.android.gms.internal.ads.Fu;
import com.google.android.gms.internal.ads.Of;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Qj;
import com.google.android.gms.internal.ads.Rj;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.lu;
import e1.o0;
import e1.q0;
import e1.r0;
import e1.s0;
import f1.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l2.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t0
implements q0 {
    private String A = "{}";
    private int B = -1;
    private int C = -1;
    private long D = 0L;
    private boolean E = false;
    private int F = 0;
    private int G = 0;
    private final Object a = new Object();
    private boolean b;
    private final List c = new ArrayList();
    private a d;
    private Of e = null;
    private SharedPreferences f;
    private SharedPreferences.Editor g;
    private boolean h = true;
    private String i;
    private String j;
    private boolean k = true;
    private String l = "-1";
    private int m = -1;
    private lu n = new lu("", 0L);
    private long o = 0L;
    private long p = 0L;
    private int q = -1;
    private int r = 0;
    private Set s = Collections.EMPTY_SET;
    private JSONObject t = new JSONObject();
    private boolean u = true;
    private boolean v = true;
    private String w = null;
    private String x = "";
    private boolean y = false;
    private String z = "";

    /*
     * WARNING - void declaration
     */
    private final void Q() {
        a a2 = this.d;
        if (a2 != null && !a2.isDone()) {
            InterruptedException interruptedException2;
            block6: {
                void var2_6;
                try {
                    this.d.get(1L, TimeUnit.SECONDS);
                    return;
                }
                catch (TimeoutException timeoutException) {
                }
                catch (ExecutionException executionException) {
                }
                catch (CancellationException cancellationException) {
                }
                catch (InterruptedException interruptedException2) {
                    break block6;
                }
                int n2 = o0.b;
                f1.p.d("Fail to initialize AdSharedPreferenceManager.", (Throwable)var2_6);
                return;
            }
            Thread.currentThread().interrupt();
            int n3 = o0.b;
            f1.p.g("Interrupted while waiting for preferences loaded.", interruptedException2);
        }
    }

    private final void R() {
        Fu.a.execute((Runnable)new r0(this));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void A(boolean bl) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.u == bl) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.u = bl;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", bl);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void B(int n2) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.r == n2) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.r = n2;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putInt("version_code", n2);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void C(boolean bl) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.E) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.E = true;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putBoolean("is_install_referrer_reported", true);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void D(int n2) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.C == n2) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.C = n2;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", n2);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final long E() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.D;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean F() {
        Object object = Yi.i1;
        if (!((Boolean)b1.A.c().d(object)).booleanValue()) {
            return false;
        }
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.k;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void G(boolean bl) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (bl == this.k) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.k = bl;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putBoolean("gad_idless", bl);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    @Override
    public final void H(Runnable runnable) {
        this.c.add((Object)runnable);
    }

    @Override
    public final String I() {
        this.Q();
        return this.l;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void J(String string) {
        Object object = Yi.Qa;
        if (!((Boolean)b1.A.c().d(object)).booleanValue()) {
            return;
        }
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block6: {
                try {
                    if (this.A.equals((Object)string)) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                this.A = string;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putString("inspector_ui_storage", string);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void K(long l2) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.p == l2) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.p = l2;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", l2);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final String L() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.x;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Of M() {
        Object object;
        if (!this.b) {
            return null;
        }
        if (this.d() && this.c()) {
            return null;
        }
        if (!((Boolean)Qj.b.e()).booleanValue()) {
            return null;
        }
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block8: {
                try {
                    if (Looper.getMainLooper() == null) {
                        return null;
                    }
                }
                catch (Throwable throwable2) {
                    break block8;
                }
                if (this.e == null) {
                    Of of;
                    this.e = of = new Of();
                }
                this.e.a();
                int n2 = o0.b;
                f1.p.e("start fetching content...");
                return this.e;
            }
            throw throwable2;
        }
    }

    @Override
    public final int N() {
        this.Q();
        return this.m;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    final /* synthetic */ void O(Context object, String string) {
        Throwable throwable3;
        block10: {
            block9: {
                Object object2;
                block8: {
                    object2 = object.getSharedPreferences("admob", 0);
                    string = object2.edit();
                    try {
                        Object object3 = object = this.a;
                        // MONITORENTER : object3
                    }
                    catch (Throwable throwable2) {
                        a1.t.l().j(throwable2, "AdSharedPreferenceManagerImpl.initializeOnBackgroundThread");
                        o0.l("AdSharedPreferenceManagerImpl.initializeOnBackgroundThread, errorMessage = ", throwable2);
                        return;
                    }
                    try {
                        this.f = object2;
                        this.g = string;
                        NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
                        this.h = this.f.getBoolean("use_https", this.h);
                        this.u = this.f.getBoolean("content_url_opted_out", this.u);
                        this.i = this.f.getString("content_url_hashes", this.i);
                        this.k = this.f.getBoolean("gad_idless", this.k);
                        this.v = this.f.getBoolean("content_vertical_opted_out", this.v);
                        this.j = this.f.getString("content_vertical_hashes", this.j);
                        this.r = this.f.getInt("version_code", this.r);
                        if (!((Boolean)Rj.g.e()).booleanValue() || !b1.A.c().c()) break block8;
                        string = new lu("", 0L);
                        this.n = string;
                        break block9;
                    }
                    catch (Throwable throwable3) {
                        break block10;
                    }
                }
                object2 = this.f.getString("app_settings_json", this.n.d());
                long l2 = this.f.getLong("app_settings_last_update_ms", this.n.b());
                string = new lu((String)object2, l2);
                this.n = string;
            }
            this.o = this.f.getLong("app_last_background_time_ms", this.o);
            this.q = this.f.getInt("request_in_session_count", this.q);
            this.p = this.f.getLong("first_ad_req_time_ms", this.p);
            this.s = this.f.getStringSet("never_pool_slots", this.s);
            this.w = this.f.getString("display_cutout", this.w);
            this.B = this.f.getInt("app_measurement_npa", this.B);
            this.C = this.f.getInt("sd_app_measure_npa", this.C);
            this.D = this.f.getLong("sd_app_measure_npa_ts", this.D);
            this.x = this.f.getString("inspector_info", this.x);
            this.y = this.f.getBoolean("linked_device", this.y);
            this.z = this.f.getString("linked_ad_unit", this.z);
            this.A = this.f.getString("inspector_ui_storage", this.A);
            this.l = this.f.getString("IABTCF_TCString", this.l);
            this.m = this.f.getInt("gad_has_consent_for_cookies", this.m);
            this.E = this.f.getBoolean("is_install_referrer_reported", this.E);
            this.F = this.f.getInt("total_inflight_ad_limit", this.F);
            this.G = this.f.getInt("default_queue_capacity", this.G);
            try {
                string = new JSONObject(this.f.getString("native_advanced_settings", "{}"));
                this.t = string;
            }
            catch (JSONException jSONException) {
                int n2 = o0.b;
                f1.p.g("Could not convert native advanced settings to json object", jSONException);
            }
            this.R();
            // MONITOREXIT : object3
            return;
        }
        // MONITOREXIT : object3
        throw throwable3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void O0(long l2) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.o == l2) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.o = l2;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", l2);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void P(String string) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block7: {
                long l2;
                block5: {
                    block6: {
                        try {
                            lu lu2;
                            l2 = a1.t.o().b();
                            if (string == null || string.equals((Object)this.n.d())) break block5;
                            this.n = lu2 = new lu(string, l2);
                            lu2 = this.g;
                            if (lu2 == null) break block6;
                            lu2.putString("app_settings_json", string);
                            this.g.putLong("app_settings_last_update_ms", l2);
                            this.g.apply();
                        }
                        catch (Throwable throwable2) {
                            break block7;
                        }
                    }
                    this.R();
                    string = this.c.iterator();
                    while (true) {
                        if (!string.hasNext()) {
                            return;
                        }
                        ((Runnable)string.next()).run();
                    }
                }
                this.n.a(l2);
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void a(boolean bl) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        long l2 = System.currentTimeMillis();
                        Oi oi = Yi.Rb;
                        long l3 = (Long)b1.A.c().d(oi);
                        oi = this.g;
                        if (oi == null) break block3;
                        oi.putBoolean("is_topics_ad_personalization_allowed", bl);
                        this.g.putLong("topics_consent_expiry_time_ms", l2 + l3);
                        this.g.apply();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean a0() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.E;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void b(String string) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block6: {
                block3: {
                    block5: {
                        block4: {
                            try {
                                this.l = string;
                                if (this.g == null) break block3;
                                if (!string.equals((Object)"-1")) break block4;
                                this.g.remove("IABTCF_TCString");
                                break block5;
                            }
                            catch (Throwable throwable2) {
                                break block6;
                            }
                        }
                        this.g.putString("IABTCF_TCString", string);
                    }
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean c() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.v;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final String c0() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.z;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean d() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.u;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void d0(String string) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (TextUtils.equals((CharSequence)this.w, (CharSequence)string)) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.w = string;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putString("display_cutout", string);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void e(boolean bl) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.v == bl) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.v = bl;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", bl);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final int e0() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.G;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final int f() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.r;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void g(int n2) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.F == n2) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.F = n2;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putInt("total_inflight_ad_limit", n2);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final lu h() {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.n;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void i(long l2) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.D == l2) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.D = l2;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", l2);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final int i0() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.F;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void j(int n2) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block6: {
                block3: {
                    block5: {
                        SharedPreferences.Editor editor;
                        block4: {
                            try {
                                this.m = n2;
                                editor = this.g;
                                if (editor == null) break block3;
                                if (n2 != -1) break block4;
                                editor.remove("gad_has_consent_for_cookies");
                                break block5;
                            }
                            catch (Throwable throwable2) {
                                break block6;
                            }
                        }
                        editor.putInt("gad_has_consent_for_cookies", n2);
                    }
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final String k() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.A;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final lu l() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            try {
                Oi oi = Yi.ed;
                if ((Boolean)b1.A.c().d(oi) == false) return this.n;
                if (!this.n.j()) return this.n;
                oi = this.c.iterator();
                while (oi.hasNext()) {
                    ((Runnable)oi.next()).run();
                }
                return this.n;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final long m() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.p;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final long n() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.o;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public final void o(Context context) {
        Object object;
        Object object2 = object = this.a;
        // MONITORENTER : object2
        if (this.f != null) {
            // MONITOREXIT : object2
            return;
        }
        this.d = Fu.a.v0((Runnable)new s0(this, context, "admob"));
        this.b = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final JSONObject p() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.t;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final int q() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.q;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void r() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        JSONObject jSONObject;
                        this.t = jSONObject = new JSONObject();
                        jSONObject = this.g;
                        if (jSONObject == null) break block3;
                        jSONObject.remove("native_advanced_settings");
                        this.g.apply();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void s(int n2) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.q == n2) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.q = n2;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putInt("request_in_session_count", n2);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final String t() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.w;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void u(String string, String string2, boolean bl) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            int n2;
            int n3;
            int n4;
            JSONArray jSONArray;
            JSONArray jSONArray2;
            try {
                jSONArray = jSONArray2 = this.t.optJSONArray(string);
                if (jSONArray2 == null) {
                    jSONArray = new JSONArray();
                }
                n4 = jSONArray.length();
                n3 = 0;
            }
            catch (Throwable throwable) {}
            throw throwable;
            while (true) {
                n2 = n4;
                if (n3 >= jSONArray.length()) break;
                jSONArray2 = jSONArray.optJSONObject(n3);
                if (jSONArray2 == null) {
                    return;
                }
                if (string2.equals((Object)jSONArray2.optString("template_id"))) {
                    if (bl && jSONArray2.optBoolean("uses_media_view", false)) {
                        return;
                    }
                    n2 = n3;
                    break;
                }
                ++n3;
            }
            try {
                jSONArray2 = new JSONObject();
                jSONArray2.put("template_id", (Object)string2);
                jSONArray2.put("uses_media_view", bl);
                jSONArray2.put("timestamp_ms", a1.t.o().b());
                jSONArray.put(n2, (Object)jSONArray2);
                this.t.put(string, (Object)jSONArray);
            }
            catch (JSONException jSONException) {
                n3 = o0.b;
                f1.p.g("Could not update native advanced settings", jSONException);
            }
            string = this.g;
            if (string != null) {
                string.putString("native_advanced_settings", this.t.toString());
                this.g.apply();
            }
            this.R();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void v(String string) {
        Object object = Yi.na;
        if (!((Boolean)b1.A.c().d(object)).booleanValue()) {
            return;
        }
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block6: {
                try {
                    if (this.x.equals((Object)string)) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                this.x = string;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putString("inspector_info", string);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void w(int n2) {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.G == n2) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                this.G = n2;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putInt("default_queue_capacity", n2);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void w0(boolean bl) {
        Object object = Yi.Ca;
        if (!((Boolean)b1.A.c().d(object)).booleanValue()) {
            return;
        }
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block6: {
                try {
                    if (this.y == bl) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                this.y = bl;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putBoolean("linked_device", bl);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean x() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.y;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void y(String string) {
        Object object = Yi.Ca;
        if (!((Boolean)b1.A.c().d(object)).booleanValue()) {
            return;
        }
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block6: {
                try {
                    if (this.z.equals((Object)string)) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                this.z = string;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putString("linked_ad_unit", string);
                    this.g.apply();
                }
                this.R();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean z() {
        Object object;
        this.Q();
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                boolean bl;
                SharedPreferences sharedPreferences;
                try {
                    sharedPreferences = this.f;
                    bl = false;
                    if (sharedPreferences == null) {
                        return false;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                if (sharedPreferences.getLong("topics_consent_expiry_time_ms", 0L) < System.currentTimeMillis()) {
                    return false;
                }
                boolean bl2 = bl;
                if (!this.f.getBoolean("is_topics_ad_personalization_allowed", false)) return bl2;
                bl2 = bl;
                if (this.k) return bl2;
                return true;
            }
            throw throwable2;
        }
    }
}

