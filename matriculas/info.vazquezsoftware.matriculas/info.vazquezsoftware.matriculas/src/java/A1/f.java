/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.By0
 *  com.google.android.gms.internal.ads.Fu
 *  com.google.android.gms.internal.ads.Iu
 *  com.google.android.gms.internal.ads.KS
 *  com.google.android.gms.internal.ads.Lo
 *  com.google.android.gms.internal.ads.Mo
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Qo
 *  com.google.android.gms.internal.ads.Uy0
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.af0
 *  com.google.android.gms.internal.ads.bf0
 *  com.google.android.gms.internal.ads.lu
 *  com.google.android.gms.internal.ads.of0
 *  e1.o0
 *  f1.a
 *  f1.p
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.Executor
 *  org.json.JSONObject
 */
package a1;

import a1.d;
import a1.e;
import a1.t;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import b1.A;
import com.google.android.gms.internal.ads.By0;
import com.google.android.gms.internal.ads.Fu;
import com.google.android.gms.internal.ads.Iu;
import com.google.android.gms.internal.ads.KS;
import com.google.android.gms.internal.ads.Lo;
import com.google.android.gms.internal.ads.Mo;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Qo;
import com.google.android.gms.internal.ads.Uy0;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.af0;
import com.google.android.gms.internal.ads.bf0;
import com.google.android.gms.internal.ads.lu;
import com.google.android.gms.internal.ads.of0;
import e1.o0;
import f1.p;
import java.util.concurrent.Executor;
import l2.a;
import org.json.JSONObject;

public final class f {
    private Context a;
    private long b = 0L;

    static final /* synthetic */ a d(Long object, KS kS, bf0 bf02, of0 of02, JSONObject jSONObject) {
        boolean bl = jSONObject.optBoolean("isSuccessful", false);
        if (bl) {
            String string = jSONObject.getString("appSettingsJson");
            t.l().r().P(string);
            if (object != null) {
                f.f(kS, "cld_s", t.o().c() - object);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)(object = jSONObject.optString("errorReason", "")))) {
            bf02.C0((String)object);
        }
        bf02.e(bl);
        of02.b(bf02.n());
        return Uy0.a(null);
    }

    static final /* synthetic */ void e(KS kS, Long l3) {
        f.f(kS, "cld_r", t.o().c() - l3);
    }

    private static final void f(KS kS, String string, long l3) {
        if (kS != null) {
            Oi oi = Yi.ee;
            if (((Boolean)A.c().d(oi)).booleanValue()) {
                kS = kS.a();
                kS.c("action", "lat_init");
                kS.c(string, Long.toString((long)l3));
                kS.d();
            }
        }
    }

    public final void a(Context context, f1.a a3, String string, Runnable runnable, of0 of02, KS kS, Long l3, boolean bl) {
        this.c(context, a3, true, null, string, null, runnable, of02, kS, l3, bl);
    }

    public final void b(Context context, f1.a a3, String string, lu lu2, of0 of02, boolean bl) {
        String string2 = lu2 != null ? lu2.e() : null;
        this.c(context, a3, false, lu2, string2, string, null, of02, null, null, bl);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void c(Context var1_1, f1.a var2_8, boolean var3_9, lu var4_10, String var5_11, String var6_12, Runnable var7_13, of0 var8_14, KS var9_15, Long var10_16, boolean var11_17) {
        block28: {
            block26: {
                block25: {
                    block24: {
                        if (t.o().c() - this.b < 5000L) {
                            var12_18 = o0.b;
                            p.f((String)"Not retrying to fetch app settings");
                            return;
                        }
                        this.b = t.o().c();
                        if (var4_10 != null && !TextUtils.isEmpty((CharSequence)var4_10.d())) {
                            var16_22 = var4_10.b();
                            var14_23 = t.o().b();
                            var18_24 = Yi.b5;
                            if (var14_23 - var16_22 <= (Long)A.c().d((Oi)var18_24) && var4_10.c()) {
                                return;
                            }
                        }
                        if (var1_1 == null) {
                            var12_19 = o0.b;
                            p.f((String)"Context not provided to fetch application settings");
                            return;
                        }
                        if (TextUtils.isEmpty((CharSequence)var5_11) && TextUtils.isEmpty((CharSequence)var6_12)) {
                            var12_20 = o0.b;
                            p.f((String)"App settings could not be fetched. Required parameters missing");
                            return;
                        }
                        var18_24 = var1_1.getApplicationContext();
                        var4_10 = var18_24;
                        if (var18_24 == null) {
                            var4_10 = var1_1;
                        }
                        this.a = var4_10;
                        var4_10 = af0.a((Context)var1_1, (int)4);
                        var4_10.a();
                        var18_24 = t.v().b(this.a, var2_8 /* !! */ , var8_14);
                        var19_25 = Qo.a;
                        var19_25 = var18_24.a("google.afma.config.fetchAppSettings", (Mo)var19_25, (Lo)var19_25);
                        var18_24 = new JSONObject();
                        var13_26 = TextUtils.isEmpty((CharSequence)var5_11);
                        if (var13_26) break block24;
                        {
                            catch (Exception var1_7) {}
                        }
                        var18_24.put("app_id", var5_11);
                        break block25;
                    }
                    var13_26 = TextUtils.isEmpty((CharSequence)var6_12);
                    if (var13_26) break block25;
                    var18_24.put("ad_unit_id", var6_12);
                }
                var18_24.put("is_init", var3_9);
                var18_24.put("pn", (Object)var1_1.getPackageName());
                var5_11 = Yi.a;
                var18_24.put("experiment_ids", (Object)TextUtils.join((CharSequence)",", (Iterable)A.b().e()));
                var18_24.put("js", (Object)var2_8 /* !! */ .g);
                var2_8 /* !! */  = Yi.Ta;
                var3_9 = (Boolean)A.c().d((Oi)var2_8 /* !! */ );
                if (!var3_9) break block26;
                try {
                    var18_24.put("inspector_enabled", var11_17);
                }
                catch (Exception var1_2) {}
                break block28;
            }
            try {
                var2_8 /* !! */  = this.a.getApplicationInfo();
                if (var2_8 /* !! */  != null && (var1_1 = B1.e.a(var1_1).f(var2_8 /* !! */ .packageName, 0)) != null) {
                    var18_24.put("version", var1_1.versionCode);
                }
                ** GOTO lbl77
            }
            catch (PackageManager.NameNotFoundException var1_3) {
                block27: {
                    o0.k((String)"Error fetching PackageInfo.");
lbl77:
                    // 2 sources

                    var5_11 = var19_25.b((Object)var18_24);
                    try {
                        var2_8 /* !! */  = new d(this, var10_16, var9_15, (bf0)var4_10, var8_14);
                    }
                    catch (Exception var1_6) {
                        break block28;
                    }
                    try {
                        var1_1 = Fu.h;
                        var2_8 /* !! */  = Uy0.j((a)var5_11, (By0)var2_8 /* !! */ , (Executor)var1_1);
                        if (var7_13 == null) break block27;
                        var5_11.f(var7_13, (Executor)var1_1);
                    }
                    catch (Exception var1_4) {
                        break block28;
                    }
                }
                if (var10_16 != null) {
                    var6_12 = new e(this, var9_15, var10_16);
                    var5_11.f((Runnable)var6_12, (Executor)var1_1);
                }
                var5_11 = Yi.G8;
                var3_9 = (Boolean)A.c().d((Oi)var5_11);
                if (var3_9) {
                    Iu.b((a)var2_8 /* !! */ , (String)"ConfigLoader.maybeFetchNewAppSettings");
                    return;
                }
                Iu.a((a)var2_8 /* !! */ , (String)"ConfigLoader.maybeFetchNewAppSettings", (Executor)var1_1);
                return;
            }
        }
        var12_21 = o0.b;
        p.d((String)"Error requesting application settings", (Throwable)var1_5);
        var4_10.f((Throwable)var1_5);
        var4_10.e(false);
        var8_14.b(var4_10.n());
    }
}

