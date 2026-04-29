/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Object
 */
package e;

import V2.g;
import V2.k;
import android.content.Context;
import android.content.Intent;

public final class c
extends e.a {
    public static final a a = new a(null);

    public Intent d(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "input");
        return intent;
    }

    public d.a e(int n2, Intent intent) {
        return new d.a(n2, intent);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }
}

