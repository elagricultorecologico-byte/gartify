/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.os.Bundle
 *  android.preference.PreferenceManager
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.Cu0
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.au0
 *  com.google.android.gms.internal.ads.sl0
 *  com.google.android.gms.internal.ads.tl0
 *  com.google.android.gms.internal.ads.ul0
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package e1;

import a1.t;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import b1.A;
import com.google.android.gms.internal.ads.Cu0;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.au0;
import com.google.android.gms.internal.ads.sl0;
import com.google.android.gms.internal.ads.tl0;
import com.google.android.gms.internal.ads.ul0;
import e1.o0;
import f1.p;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d {
    public static void a(Context context) {
        Oi oi = Yi.h7;
        if (((Boolean)A.c().d(oi)).booleanValue() && context != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
        try {
            sl0 sl02 = sl0.i((Context)context);
            oi = tl0.i((Context)context);
            context = ul0.a((Context)context);
            sl02.l();
            sl02.m();
            oi.k();
            context.b(null);
            return;
        }
        catch (IOException iOException) {
            t.l().j((Throwable)iOException, "clearStorageOnIdlessMode");
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bundle b(Context context, String string) {
        int n2;
        block15: {
            if (!TextUtils.isEmpty((CharSequence)string)) {
                try {
                    string = new JSONArray(string);
                    break block15;
                }
                catch (JSONException jSONException) {
                    n2 = o0.b;
                    p.b("JSON parsing error", jSONException);
                }
            }
            string = null;
        }
        if (string == null) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        int n3 = 0;
        while (true) {
            block16: {
                void var4_14;
                String string2;
                block17: {
                    block19: {
                        block18: {
                            if (n3 >= string.length()) {
                                return bundle;
                            }
                            JSONObject jSONObject = string.optJSONObject(n3);
                            string2 = jSONObject.optString("bk");
                            String string3 = jSONObject.optString("sk");
                            n2 = jSONObject.optInt("type", -1);
                            n2 = n2 != 0 ? (n2 != 1 ? (n2 != 2 ? 0 : 3) : 2) : 1;
                            if (TextUtils.isEmpty((CharSequence)string2) || TextUtils.isEmpty((CharSequence)string3) || n2 == 0) break block16;
                            List list = Cu0.a((au0)au0.b((char)'/')).e((CharSequence)string3);
                            if (list.size() > 2 || list.isEmpty()) {
                                Object var4_9 = null;
                            } else {
                                void var4_12;
                                if (list.size() == 1) {
                                    string3 = PreferenceManager.getDefaultSharedPreferences((Context)context);
                                    String string4 = (String)list.get(0);
                                } else {
                                    string3 = context.getSharedPreferences((String)list.get(0), 0);
                                    String string5 = (String)list.get(1);
                                }
                                Object object = string3.getAll().get((Object)var4_12);
                            }
                            if (var4_14 == null) break block16;
                            if (--n2 == 0) break block17;
                            if (n2 == 1) break block18;
                            if (var4_14 instanceof Boolean) {
                                bundle.putBoolean(string2, ((Boolean)var4_14).booleanValue());
                            }
                            break block16;
                        }
                        if (!(var4_14 instanceof Integer)) break block19;
                        bundle.putInt(string2, ((Integer)var4_14).intValue());
                        break block16;
                    }
                    if (var4_14 instanceof Long) {
                        bundle.putLong(string2, ((Long)var4_14).longValue());
                        break block16;
                    } else if (var4_14 instanceof Float) {
                        bundle.putFloat(string2, ((Float)var4_14).floatValue());
                    }
                    break block16;
                }
                if (var4_14 instanceof String) {
                    bundle.putString(string2, (String)var4_14);
                }
            }
            ++n3;
        }
    }

    public static Bundle c(Context context, String string, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return Bundle.EMPTY;
        }
        PreferenceManager.getDefaultSharedPreferences((Context)context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        return d.b(context, string);
    }
}

