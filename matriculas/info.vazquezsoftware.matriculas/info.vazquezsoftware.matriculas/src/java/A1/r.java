/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.internal.ads.Lj
 *  e1.d
 *  e1.o0
 *  f1.a
 *  f1.p
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map
 *  java.util.TreeMap
 */
package a1;

import B1.e;
import android.content.Context;
import android.content.pm.PackageManager;
import b1.R1;
import b1.c2;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.Lj;
import e1.d;
import e1.o0;
import f1.a;
import f1.p;
import java.util.Map;
import java.util.TreeMap;

final class r {
    private final Context a;
    private final String b;
    private final Map c;
    private String d;
    private String e;
    private final String f;

    public r(Context object, String string) {
        this.a = object.getApplicationContext();
        this.b = string;
        this.c = new TreeMap();
        string = object.getPackageName();
        try {
            object = B1.e.a((Context)object).f((String)object.getPackageName(), (int)0).versionName;
            int n3 = String.valueOf((Object)string).length();
            int n4 = String.valueOf((Object)object).length();
            StringBuilder stringBuilder = new StringBuilder(n3 + 1 + n4);
            stringBuilder.append(string);
            stringBuilder.append("-");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            int n5 = o0.b;
            p.d((String)"Unable to get package version name for reporting", (Throwable)nameNotFoundException);
            object = String.valueOf((Object)string).concat("-missing");
        }
        this.f = object;
    }

    public final String a() {
        return this.e;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.f;
    }

    public final Map e() {
        return this.c;
    }

    public final void f(c2 c22, a object2) {
        R1 r12 = c22.p;
        if (r12 != null) {
            this.d = r12.g;
        }
        if ((c22 = (c22 = c22.s) != null ? c22.getBundle(AdMobAdapter.class.getName()) : null) != null) {
            String string = (String)Lj.c.e();
            for (String string2 : c22.keySet()) {
                if (string.equals((Object)string2)) {
                    this.e = c22.getString(string2);
                    continue;
                }
                if (!string2.startsWith("csa_")) continue;
                this.c.put((Object)string2.substring(4), (Object)c22.getString(string2));
            }
            c22 = this.c;
            c22.put("SDKVersion", object2.g);
            if (((Boolean)Lj.a.e()).booleanValue()) {
                r12 = e1.d.b((Context)this.a, (String)((String)Lj.b.e()));
                for (Object object2 : r12.keySet()) {
                    c22.put(object2, r12.get((String)object2).toString());
                }
            }
        }
    }
}

