/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.KS
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d1;

import a1.t;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import b1.A;
import com.google.android.gms.internal.ads.KS;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import d1.b;
import d1.e;
import d1.m;
import e1.F0;
import e1.o0;
import f1.p;

public final class a {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final boolean a(Context context, Intent intent, e e2, b b2, boolean bl, KS kS, String string, Bundle object) {
        ActivityNotFoundException activityNotFoundException2;
        block8: {
            block7: {
                block6: {
                    if (bl) {
                        return a.c(context, intent.getData(), e2, b2, object);
                    }
                    try {
                        object = intent.toURI();
                        int n2 = String.valueOf((Object)object).length();
                        StringBuilder stringBuilder = new StringBuilder(n2 + 21);
                        stringBuilder.append("Launching an intent: ");
                        stringBuilder.append((String)object);
                        o0.k(stringBuilder.toString());
                        object = Yi.Ce;
                        if (!((Boolean)A.c().d((Oi)object)).booleanValue()) break block6;
                        t.g();
                        F0.D(context, intent, kS, string);
                        break block7;
                    }
                    catch (ActivityNotFoundException activityNotFoundException2) {
                        break block8;
                    }
                }
                t.g();
                F0.y(context, intent);
            }
            if (e2 != null) {
                e2.i();
            }
            if (b2 != null) {
                b2.Z(true);
            }
            return true;
        }
        String string2 = activityNotFoundException2.getMessage();
        int n3 = o0.b;
        p.f(string2);
        if (b2 != null) {
            b2.Z(false);
        }
        return false;
    }

    public static final boolean b(Context context, m m2, e e2, b b2, KS kS, String string) {
        int n2 = 0;
        if (m2 == null) {
            n2 = o0.b;
            p.f("No intent data for launcher overlay.");
            return false;
        }
        Yi.a((Context)context);
        Intent intent = m2.n;
        if (intent != null) {
            return a.a(context, intent, e2, b2, m2.p, kS, string, m2.q);
        }
        intent = new Intent();
        String string2 = m2.h;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            n2 = o0.b;
            p.f("Open GMSG did not contain a URL.");
            return false;
        }
        Oi oi = m2.i;
        if (!TextUtils.isEmpty((CharSequence)oi)) {
            intent.setDataAndType(Uri.parse((String)string2), (String)oi);
        } else {
            intent.setData(Uri.parse((String)string2));
        }
        intent.setAction("android.intent.action.VIEW");
        oi = m2.j;
        if (!TextUtils.isEmpty((CharSequence)oi)) {
            intent.setPackage((String)oi);
        }
        if (!TextUtils.isEmpty((CharSequence)(string2 = m2.k))) {
            oi = string2.split("/", 2);
            if (((String[])oi).length < 2) {
                n2 = o0.b;
                p.f("Could not parse component name from open GMSG: ".concat(string2));
                return false;
            }
            intent.setClassName((String)oi[0], (String)oi[1]);
        }
        if (!TextUtils.isEmpty((CharSequence)(oi = m2.l))) {
            try {
                int n3;
                n2 = n3 = Integer.parseInt((String)oi);
            }
            catch (NumberFormatException numberFormatException) {
                int n4 = o0.b;
                p.f("Could not parse intent flags.");
            }
            intent.addFlags(n2);
        }
        oi = Yi.x5;
        if (((Boolean)A.c().d(oi)).booleanValue()) {
            intent.addFlags(0x10000000);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            oi = Yi.w5;
            if (((Boolean)A.c().d(oi)).booleanValue()) {
                t.g();
                F0.b0(context, intent);
            }
        }
        return a.a(context, intent, e2, b2, m2.p, kS, string, m2.q);
    }

    private static final boolean c(Context context, Uri uri, e e2, b b2, Bundle bundle) {
        int n2;
        block4: {
            int n3;
            n2 = n3 = t.g().Y(context, uri, bundle);
            if (e2 == null) break block4;
            try {
                e2.i();
                n2 = n3;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                String string = activityNotFoundException.getMessage();
                n2 = o0.b;
                p.f(string);
                n2 = 6;
            }
        }
        if (b2 != null) {
            b2.b(n2);
        }
        return n2 == 5;
    }
}

