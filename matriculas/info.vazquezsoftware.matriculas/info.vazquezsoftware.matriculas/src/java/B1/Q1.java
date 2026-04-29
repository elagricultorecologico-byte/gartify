/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.HashMap
 *  java.util.Map
 */
package b1;

import Z0.b;
import b1.o1;
import b1.t1;
import java.util.HashMap;
import java.util.Map;

final class q1
implements b {
    private final t1 a;

    /* synthetic */ q1(t1 t12) {
        this.a = t12;
    }

    @Override
    public final /* synthetic */ Map a() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"com.google.android.gms.ads.MobileAds", (Object)new o1(this.a));
        return hashMap;
    }
}

