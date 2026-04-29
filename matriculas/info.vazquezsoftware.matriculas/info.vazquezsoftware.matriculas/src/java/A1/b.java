/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.Pr
 *  com.google.android.gms.internal.ads.zt
 *  e1.F0
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 */
package a1;

import a1.t;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.Pr;
import com.google.android.gms.internal.ads.zt;
import e1.F0;
import java.util.Collections;

public final class b {
    private final Context a;
    private boolean b;
    private final zt c;
    private final Pr d;

    public b(Context context, zt zt2, Pr pr) {
        this.a = context;
        this.c = zt2;
        this.d = new Pr(false, Collections.EMPTY_LIST);
    }

    private final boolean d() {
        zt zt2 = this.c;
        return zt2 != null && zt2.a().l || this.d.g;
    }

    public final void a() {
        this.b = true;
    }

    public final boolean b() {
        return !this.d() || this.b;
        {
        }
    }

    public final void c(String string) {
        if (this.d()) {
            String string2 = string;
            if (string == null) {
                string2 = "";
            }
            if ((string = this.c) != null) {
                string.b(string2, null, 3);
                return;
            }
            string = this.d;
            if (((Pr)string).g && (string = ((Pr)string).h) != null) {
                string = string.iterator();
                while (string.hasNext()) {
                    String string3 = (String)string.next();
                    if (TextUtils.isEmpty((CharSequence)string3)) continue;
                    string3 = string3.replace((CharSequence)"{NAVIGATION_URL}", (CharSequence)Uri.encode((String)string2));
                    Context context = this.a;
                    t.g();
                    F0.o((Context)context, (String)"", (String)string3);
                }
            }
        }
    }
}

