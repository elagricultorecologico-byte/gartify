/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.text.TextUtils
 *  androidx.core.app.q
 *  com.google.android.gms.common.util.i
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package u1;

import B1.e;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.q;
import com.google.android.gms.common.util.i;
import u1.k;

public class h {
    public static final int a = k.a;
    private static final h b = new h();

    h() {
    }

    public static h f() {
        return b;
    }

    public int a(Context context) {
        return k.a(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Intent b(Context context, int n2, String string) {
        if (n2 != 1 && n2 != 2) {
            if (n2 != 3) {
                return null;
            }
            string = Uri.fromParts((String)"package", (String)"com.google.android.gms", null);
            context = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            context.setData((Uri)string);
            return context;
        }
        if (context != null && i.f((Context)context)) {
            context = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            context.setPackage("com.google.android.wearable.app");
            return context;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(a);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty((CharSequence)string)) {
            stringBuilder.append(string);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(e.a((Context)context).f((String)context.getPackageName(), (int)0).versionCode);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        }
        String string2 = stringBuilder.toString();
        string = new Intent("android.intent.action.VIEW");
        context = Uri.parse((String)"market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            context.appendQueryParameter("pcampaignid", string2);
        }
        string.setData(context.build());
        string.setPackage("com.android.vending");
        string.addFlags(524288);
        return string;
    }

    public PendingIntent c(Context context, int n2, int n3) {
        return this.d(context, n2, n3, null);
    }

    public PendingIntent d(Context context, int n2, int n3, String string) {
        if ((string = this.b(context, n2, string)) == null) {
            return null;
        }
        return q.b((Context)context, (int)n3, (Intent)string, (int)0x8000000, (boolean)false);
    }

    public String e(int n2) {
        return k.b(n2);
    }

    public int g(Context context) {
        return this.h(context, a);
    }

    public int h(Context context, int n2) {
        if (k.f(context, n2 = k.e(context, n2))) {
            return 18;
        }
        return n2;
    }

    public boolean i(Context context, String string) {
        return k.i(context, string);
    }

    public boolean j(int n2) {
        return k.h(n2);
    }
}

