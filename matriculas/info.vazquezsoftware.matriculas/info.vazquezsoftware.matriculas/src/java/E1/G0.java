/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  android.webkit.WebSettings
 *  com.google.android.gms.common.util.q
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.Callable
 */
package e1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.q;
import e1.o0;
import java.util.concurrent.Callable;

final class g0
implements Callable {
    private final Context a;

    /* synthetic */ g0(Context context) {
        this.a = context;
    }

    public final /* synthetic */ Object call() {
        Context context = this.a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("admob_user_agent", 0);
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty((CharSequence)string)) {
            o0.k("User agent is not initialized on Google Play Services. Initializing.");
            string = WebSettings.getDefaultUserAgent((Context)context);
            q.a((Context)context, (SharedPreferences.Editor)sharedPreferences.edit().putString("user_agent", string), (String)"admob_user_agent");
            return string;
        }
        o0.k("User agent is already initialized on Google Play Services.");
        return string;
    }
}

