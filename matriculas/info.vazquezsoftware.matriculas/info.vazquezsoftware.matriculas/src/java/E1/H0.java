/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.webkit.WebSettings
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.Callable
 */
package e1;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import e1.o0;
import java.util.concurrent.Callable;

final class h0
implements Callable {
    private final Context a;
    private final Context b;

    /* synthetic */ h0(Context context, Context context2) {
        this.a = context;
        this.b = context2;
    }

    public final /* synthetic */ Object call() {
        Context context = this.a;
        Object object = this.b;
        boolean bl = false;
        if (context != null) {
            o0.k("Attempting to read user agent from Google Play Services.");
            context = context.getSharedPreferences("admob_user_agent", 0);
        } else {
            o0.k("Attempting to read user agent from local cache.");
            context = object.getSharedPreferences("admob_user_agent", 0);
            bl = true;
        }
        String string = context.getString("user_agent", "");
        if (TextUtils.isEmpty((CharSequence)string)) {
            o0.k("Reading user agent from WebSettings");
            object = WebSettings.getDefaultUserAgent((Context)object);
            if (bl) {
                context.edit().putString("user_agent", (String)object).apply();
                o0.k("Persisting user agent.");
            }
            return object;
        }
        return string;
    }
}

