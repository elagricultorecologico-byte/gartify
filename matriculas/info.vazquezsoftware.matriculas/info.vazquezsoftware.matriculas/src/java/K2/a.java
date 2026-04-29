/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.consent_sdk.A0
 *  com.google.android.gms.internal.consent_sdk.r0
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package k2;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.A0;
import com.google.android.gms.internal.consent_sdk.r0;
import java.util.ArrayList;
import java.util.List;
import k2.g;

public class a {
    private final boolean a;
    private final int b;

    /* synthetic */ a(boolean bl, a a2, g g2) {
        this.a = bl;
        this.b = a2.c;
    }

    public int a() {
        return this.b;
    }

    public boolean b() {
        return this.a;
    }

    public static class a {
        private final List a = new ArrayList();
        private final Context b;
        private int c = 0;
        private boolean d;

        public a(Context context) {
            this.b = context.getApplicationContext();
        }

        public a a() {
            boolean bl;
            boolean bl2 = bl = true;
            if (!A0.a((boolean)true)) {
                bl2 = this.a.contains((Object)r0.a((Context)this.b)) ? bl : (this.d ? bl : false);
            }
            return new a(bl2, this, null);
        }
    }
}

