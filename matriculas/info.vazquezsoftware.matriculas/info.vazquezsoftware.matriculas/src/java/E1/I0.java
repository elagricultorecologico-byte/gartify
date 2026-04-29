/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 *  android.webkit.WebSettings
 *  com.google.android.gms.common.util.d
 *  com.google.android.gms.common.util.q
 *  java.lang.Object
 *  java.lang.String
 *  u1.k
 */
package e1;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.q;
import e1.o0;
import u1.k;

public final class i0 {
    private static i0 b;
    String a;

    private i0() {
    }

    public static i0 a() {
        if (b == null) {
            b = new i0();
        }
        return b;
    }

    public final void b(Context context) {
        block5: {
            String string;
            block7: {
                Context context2;
                Object object;
                block6: {
                    o0.k("Updating user agent.");
                    string = WebSettings.getDefaultUserAgent((Context)context);
                    if (string.equals((Object)this.a)) break block5;
                    context2 = object = k.c((Context)context);
                    if (d.a()) break block6;
                    if (object != null) break block7;
                    context2 = null;
                }
                object = WebSettings.getDefaultUserAgent((Context)context);
                object = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", (String)object);
                if (context2 == null) {
                    object.apply();
                } else {
                    q.a((Context)context, (SharedPreferences.Editor)object, (String)"admob_user_agent");
                }
            }
            this.a = string;
        }
        o0.k("User agent is updated.");
    }
}

