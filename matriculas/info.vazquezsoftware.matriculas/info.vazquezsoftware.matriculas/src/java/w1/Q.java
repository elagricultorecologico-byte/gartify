/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.app.E
 *  com.google.android.gms.common.api.Status
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.WeakHashMap
 */
package w1;

import L1.j;
import androidx.appcompat.app.E;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import v1.b;
import w1.e;
import w1.p;

public final class q {
    private final Map a = Collections.synchronizedMap((Map)new WeakHashMap());
    private final Map b = Collections.synchronizedMap((Map)new WeakHashMap());

    static /* bridge */ /* synthetic */ Map a(q q2) {
        return q2.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void f(boolean bl, Status status) {
        Map map;
        Map map2;
        Map map3 = map2 = this.a;
        synchronized (map3) {
            HashMap hashMap = new HashMap(this.a);
        }
        Map map4 = map = this.b;
        synchronized (map4) {
            map2 = new HashMap(this.b);
        }
        for (HashMap hashMap : hashMap.entrySet()) {
            if (!bl && !((Boolean)hashMap.getValue()).booleanValue()) continue;
            E.a((Object)hashMap.getKey());
            throw null;
        }
        map = map2.entrySet().iterator();
        while (map.hasNext()) {
            map2 = (Map.Entry)map.next();
            if (!bl && !((Boolean)map2.getValue()).booleanValue()) continue;
            ((j)map2.getKey()).d(new b(status));
        }
        return;
    }

    final void b(j j2, boolean bl) {
        this.b.put((Object)j2, (Object)bl);
        j2.a().b(new p(this, j2));
    }

    final void c(int n2, String string) {
        StringBuilder stringBuilder = new StringBuilder("The connection to Google Play services was lost");
        if (n2 == 1) {
            stringBuilder.append(" due to service disconnection.");
        } else if (n2 == 3) {
            stringBuilder.append(" due to dead object exception.");
        }
        if (string != null) {
            stringBuilder.append(" Last reason for disconnect: ");
            stringBuilder.append(string);
        }
        this.f(true, new Status(20, stringBuilder.toString()));
    }

    public final void d() {
        this.f(false, e.v);
    }

    final boolean e() {
        return !this.a.isEmpty() || !this.b.isEmpty();
        {
        }
    }
}

