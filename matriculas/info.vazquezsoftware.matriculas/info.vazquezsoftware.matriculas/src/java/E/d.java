/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  java.lang.Object
 */
package e;

import V2.g;
import V2.k;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import d.f;

public final class d
extends e.a {
    public static final a a = new a(null);

    public Intent d(Context context, f f2) {
        k.e(context, "context");
        k.e(f2, "input");
        context = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", (Parcelable)f2);
        k.d(context, "Intent(ACTION_INTENT_SEN\u2026NT_SENDER_REQUEST, input)");
        return context;
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

