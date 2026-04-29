/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.HashMap
 *  java.util.Map$Entry
 */
package m;

import java.util.HashMap;
import java.util.Map;
import m.b;

public class a
extends b {
    private final HashMap k = new HashMap();

    public boolean contains(Object object) {
        return this.k.containsKey(object);
    }

    @Override
    protected b.c f(Object object) {
        return (b.c)this.k.get(object);
    }

    @Override
    public Object k(Object object, Object object2) {
        b.c c3 = this.f(object);
        if (c3 != null) {
            return c3.h;
        }
        this.k.put(object, (Object)this.j(object, object2));
        return null;
    }

    @Override
    public Object l(Object object) {
        Object object2 = super.l(object);
        this.k.remove(object);
        return object2;
    }

    public Map.Entry m(Object object) {
        if (this.contains(object)) {
            return ((b.c)this.k.get((Object)object)).j;
        }
        return null;
    }
}

