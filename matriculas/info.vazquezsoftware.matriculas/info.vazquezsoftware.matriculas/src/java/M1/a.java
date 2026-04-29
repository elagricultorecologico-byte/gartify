/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.Eu0
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 */
package m1;

import a1.t;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import b1.A;
import com.google.android.gms.internal.ads.Eu0;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import e1.F0;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class a {
    private final Context a;
    private final String b;
    private final String c;
    private final PackageInfo d;
    private final String e;
    private final k1.a f;

    public a(Context context, f1.a a2, PackageInfo packageInfo, String string, k1.a a3) {
        this.a = context;
        this.b = context.getPackageName();
        this.c = a2.g;
        this.d = packageInfo;
        this.e = string;
        this.f = a3;
    }

    public void a(Map map) {
        map.put((Object)"s", (Object)"gmob_sdk");
        map.put((Object)"v", (Object)"3");
        map.put((Object)"os", (Object)Build.VERSION.RELEASE);
        map.put((Object)"api_v", (Object)Build.VERSION.SDK);
        t.g();
        map.put((Object)"device", (Object)F0.e0());
        map.put((Object)"app", (Object)this.b);
        t.g();
        Context context = this.a;
        boolean bl = F0.h(context);
        String string = "1";
        String string2 = true != bl ? "0" : "1";
        map.put((Object)"is_lite_sdk", (Object)string2);
        string2 = Yi.a;
        List list = A.b().f();
        string2 = Yi.P7;
        if (((Boolean)A.c().d((Oi)string2)).booleanValue()) {
            list.addAll((Collection)t.l().r().l().h());
        }
        map.put((Object)"e", (Object)TextUtils.join((CharSequence)",", (Iterable)list));
        map.put((Object)"sdkVersion", (Object)this.c);
        string2 = Yi.Kc;
        if (((Boolean)A.c().d((Oi)string2)).booleanValue()) {
            t.g();
            string2 = string;
            if (!F0.e(context)) {
                string2 = "0";
            }
            map.put((Object)"is_bstar", (Object)string2);
        }
        string2 = Yi.Oa;
        if (((Boolean)A.c().d((Oi)string2)).booleanValue()) {
            string2 = Yi.g3;
            if (((Boolean)A.c().d((Oi)string2)).booleanValue()) {
                map.put((Object)"plugin", (Object)Eu0.a((String)t.l().x()));
            }
        }
        string2 = Yi.Sc;
        if (((Boolean)A.c().d((Oi)string2)).booleanValue()) {
            map.put((Object)"uev", (Object)Eu0.a((String)this.e));
        }
        string2 = Yi.Z2;
        if (((Boolean)A.c().d((Oi)string2)).booleanValue()) {
            map.put((Object)"mem_tier", (Object)this.f.a().name());
        }
        string2 = Yi.a3;
        if (((Boolean)A.c().d((Oi)string2)).booleanValue()) {
            map.put((Object)"proc_tier", (Object)this.f.b().name());
        }
        string2 = Yi.b3;
        if (((Boolean)A.c().d((Oi)string2)).booleanValue() && (string2 = this.d) != null) {
            map.put((Object)"vc", (Object)String.valueOf((int)((PackageInfo)string2).versionCode));
            map.put((Object)"vn", (Object)String.valueOf((Object)((PackageInfo)string2).versionName));
        }
    }
}

