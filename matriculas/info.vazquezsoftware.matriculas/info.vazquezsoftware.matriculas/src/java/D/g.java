/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package D;

import D.f;
import V2.k;

public class g
extends f {
    private final Object c = new Object();

    public g(int n2) {
        super(n2);
    }

    @Override
    public boolean a(Object object) {
        Object object2;
        k.e((Object)object, (String)"instance");
        Object object3 = object2 = this.c;
        synchronized (object3) {
            boolean bl = super.a(object);
            return bl;
        }
    }

    @Override
    public Object b() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            Object object3 = super.b();
            return object3;
        }
    }
}

