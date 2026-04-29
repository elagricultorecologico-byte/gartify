/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.LinkedHashMap
 *  java.util.Set
 */
package q;

import V2.k;
import java.util.LinkedHashMap;
import java.util.Set;

public final class c {
    private final LinkedHashMap a;

    public c(int n2, float f2) {
        this.a = new LinkedHashMap(n2, f2, true);
    }

    public final Object a(Object object) {
        k.e(object, "key");
        return this.a.get(object);
    }

    public final Set b() {
        Set set = this.a.entrySet();
        k.d(set, "map.entries");
        return set;
    }

    public final boolean c() {
        return this.a.isEmpty();
    }

    public final Object d(Object object, Object object2) {
        k.e(object, "key");
        k.e(object2, "value");
        return this.a.put(object, object2);
    }

    public final Object e(Object object) {
        k.e(object, "key");
        return this.a.remove(object);
    }
}

