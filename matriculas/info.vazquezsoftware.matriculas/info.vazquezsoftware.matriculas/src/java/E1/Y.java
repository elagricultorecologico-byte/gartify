/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 *  com.google.android.gms.common.util.k
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.uU
 *  com.google.android.gms.internal.ads.vU
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.charset.StandardCharsets
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.UUID
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package e1;

import a1.t;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import b1.A;
import b1.K0;
import com.google.android.gms.common.util.k;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.uU;
import com.google.android.gms.internal.ads.vU;
import e1.F0;
import e1.N;
import e1.o0;
import e1.v;
import e1.x;
import f1.p;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public final class y {
    private final Object a = new Object();
    private String b = "";
    private String c = "";
    private boolean d = false;
    private boolean e = false;
    protected String f = "";
    private vU g;

    protected static final String o(Context object, String string, String string2) {
        block6: {
            TimeoutException timeoutException2;
            block5: {
                InterruptedException interruptedException2;
                block4: {
                    HashMap hashMap = new HashMap();
                    hashMap.put((Object)"User-Agent", (Object)t.g().P((Context)object, string2));
                    object = new N((Context)object).b(0, string, (Map)hashMap, null);
                    try {
                        string2 = Yi.W5;
                        string2 = (String)object.get((long)((Integer)A.c().d((Oi)string2)).intValue(), TimeUnit.MILLISECONDS);
                        return string2;
                    }
                    catch (Exception exception) {
                    }
                    catch (InterruptedException interruptedException2) {
                        break block4;
                    }
                    catch (TimeoutException timeoutException2) {
                        break block5;
                    }
                    string = String.valueOf((Object)string);
                    int n2 = o0.b;
                    p.d("Error retrieving a response from: ".concat(string), exception);
                    break block6;
                }
                string = String.valueOf((Object)string);
                int n3 = o0.b;
                p.d("Interrupted while retrieving a response from: ".concat(string), interruptedException2);
                object.cancel(true);
                break block6;
            }
            string = String.valueOf((Object)string);
            int n4 = o0.b;
            p.d("Timeout while retrieving a response from: ".concat(string), timeoutException2);
            object.cancel(true);
        }
        return null;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Uri p(Context object, String string, String string2, String string3) {
        Object object2;
        Uri.Builder builder = Uri.parse((String)string).buildUpon();
        Object object3 = object2 = this.a;
        synchronized (object3) {
            if (TextUtils.isEmpty((CharSequence)this.b)) {
                int n2;
                t.g();
                try {
                    FileInputStream fileInputStream = object.openFileInput("debug_signals_id.txt");
                    string = new String(k.d((InputStream)fileInputStream, (boolean)true), StandardCharsets.UTF_8);
                }
                catch (IOException iOException) {
                    n2 = o0.b;
                    p.a("Error reading from internal storage.");
                    string = "";
                }
                this.b = string;
                if (TextUtils.isEmpty((CharSequence)string)) {
                    t.g();
                    this.b = UUID.randomUUID().toString();
                    t.g();
                    string = this.b;
                    try {
                        object = object.openFileOutput("debug_signals_id.txt", 0);
                        object.write(string.getBytes(StandardCharsets.UTF_8));
                        object.close();
                    }
                    catch (Exception exception) {
                        n2 = o0.b;
                        p.d("Error writing to file in internal storage.", exception);
                    }
                }
            }
            object = this.b;
        }
        builder.appendQueryParameter("linkedDeviceId", (String)object);
        builder.appendQueryParameter("adSlotPath", string2);
        builder.appendQueryParameter("afmaVersion", string3);
        return builder.build();
        {
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final void a(vU vU2) {
        this.g = vU2;
    }

    public final vU b() {
        return this.g;
    }

    public final void c(Context context) {
        Oi oi = Yi.Ca;
        if (((Boolean)A.c().d(oi)).booleanValue() && (oi = this.g) != null) {
            oi.p((K0)new v(this, context), uU.j);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final boolean d(Context object, String object2, String object3) {
        JSONException jSONException2;
        block7: {
            block6: {
                boolean bl;
                Oi oi = Yi.T5;
                if (TextUtils.isEmpty((CharSequence)(object = y.o(object, this.p((Context)object, (String)A.c().d(oi), (String)object2, (String)object3).toString(), (String)object3)))) {
                    int n2 = o0.b;
                    p.a("Not linked for in app preview.");
                    return false;
                }
                object = object.trim();
                try {
                    object3 = new JSONObject((String)object);
                    object = object3.optString("gct");
                    this.f = object3.optString("status");
                    object3 = Yi.Ca;
                    if (!((Boolean)A.c().d((Oi)object3)).booleanValue()) break block6;
                    object3 = this.f;
                    bl = "0".equals(object3) || "2".equals(object3);
                }
                catch (JSONException jSONException2) {
                    break block7;
                }
                this.j(bl);
                object3 = t.l().r();
                if (!bl) {
                    object2 = "";
                }
                object3.y((String)object2);
            }
            Object object4 = object2 = this.a;
            synchronized (object4) {
                this.c = object;
                return true;
            }
        }
        int n3 = o0.b;
        p.g("Fail to get in app preview response json.", jSONException2);
        return false;
    }

    public final boolean e(Context object, String string, String string2) {
        Oi oi = Yi.U5;
        if (TextUtils.isEmpty((CharSequence)(object = y.o((Context)object, this.p((Context)object, (String)A.c().d(oi), string, string2).toString(), string2)))) {
            int n2 = o0.b;
            p.a("Not linked for debug signals.");
            return false;
        }
        string2 = object.trim();
        try {
            object = new JSONObject(string2);
            object = object.optString("debug_mode");
        }
        catch (JSONException jSONException) {
            int n3 = o0.b;
            p.g("Fail to get debug mode response json.", jSONException);
            return false;
        }
        boolean bl = "1".equals(object);
        this.j(bl);
        object = Yi.Ca;
        if (((Boolean)A.c().d((Oi)object)).booleanValue()) {
            object = t.l().r();
            if (!bl) {
                string = "";
            }
            object.y(string);
        }
        return bl;
    }

    public final void f(Context context, String string, String string2) {
        t.g();
        Oi oi = Yi.S5;
        F0.z(context, this.p(context, (String)A.c().d(oi), string, string2));
    }

    public final boolean g(Context context, String string, String string2, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string2) && this.m()) {
            int n2 = o0.b;
            p.a("Sending troubleshooting signals to the server.");
            this.h(context, string, string2, string3);
            return true;
        }
        return false;
    }

    public final void h(Context context, String string, String string2, String string3) {
        Oi oi = Yi.V5;
        string3 = this.p(context, (String)A.c().d(oi), string3, string).buildUpon();
        string3.appendQueryParameter("debugData", string2);
        t.g();
        F0.o(context, string, string3.build().toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String i() {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.c;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void j(boolean bl) {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        this.e = bl;
                        Oi oi = Yi.Ca;
                        if (!((Boolean)A.c().d(oi)).booleanValue()) break block3;
                        t.l().r().w0(bl);
                        oi = this.g;
                        if (oi == null) break block3;
                        oi.c(bl);
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
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
    public final boolean k() {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.e;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void l(boolean bl) {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            this.d = bl;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean m() {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.d;
        }
    }

    protected final void n(Context context, String string, boolean bl, boolean bl2) {
        if (!(context instanceof Activity)) {
            int n2 = o0.b;
            p.e("Can not create dialog without Activity Context");
            return;
        }
        F0.l.post((Runnable)new x(this, context, string, bl, bl2));
    }
}

