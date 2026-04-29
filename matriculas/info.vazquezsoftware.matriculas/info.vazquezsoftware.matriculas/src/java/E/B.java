/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.core.content.a
 *  java.lang.Boolean
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package e;

import H2.j;
import H2.n;
import I2.E;
import I2.i;
import I2.o;
import V2.g;
import V2.k;
import Y2.d;
import android.content.Context;
import android.content.Intent;
import e.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class b
extends e.a {
    public static final a a = new a(null);

    public Intent d(Context context, String[] stringArray) {
        k.e(context, "context");
        k.e(stringArray, "input");
        return a.a(stringArray);
    }

    public a.a e(Context context, String[] stringArray) {
        int n2;
        k.e(context, "context");
        k.e(stringArray, "input");
        if (stringArray.length == 0) {
            return new Object(E.f()){
                private final Object a;
                {
                    this.a = object;
                }

                public final Object a() {
                    return this.a;
                }
            };
        }
        int n3 = stringArray.length;
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            if (androidx.core.content.a.a((Context)context, (String)stringArray[n2]) == 0) {
                continue;
            }
            return null;
        }
        context = new LinkedHashMap(d.b(E.c(stringArray.length), 16));
        n3 = stringArray.length;
        for (n2 = n4; n2 < n3; ++n2) {
            j j2 = n.a(stringArray[n2], Boolean.TRUE);
            context.put(j2.c(), j2.d());
        }
        return new /* invalid duplicate definition of identical inner class */;
    }

    public Map f(int n2, Intent intent) {
        if (n2 != -1) {
            return E.f();
        }
        if (intent == null) {
            return E.f();
        }
        Object[] objectArray = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] nArray = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (nArray != null && objectArray != null) {
            intent = new ArrayList(nArray.length);
            int n3 = nArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                boolean bl = nArray[n2] == 0;
                intent.add((Object)bl);
            }
            return E.i((Iterable)o.O((Iterable)i.p(objectArray), (Iterable)intent));
        }
        return E.f();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final Intent a(String[] intent) {
            k.e(intent, "input");
            intent = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[])intent);
            k.d(intent, "Intent(ACTION_REQUEST_PE\u2026EXTRA_PERMISSIONS, input)");
            return intent;
        }
    }
}

