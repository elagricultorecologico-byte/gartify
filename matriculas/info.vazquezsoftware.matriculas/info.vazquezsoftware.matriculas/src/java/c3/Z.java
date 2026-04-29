/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package c3;

import H2.k;
import H2.l;
import L2.e;
import c3.i;
import c3.x;

public abstract class z {
    public static final Object a(Object object, e object2) {
        if (object instanceof x) {
            object2 = k.g;
            return k.a(l.a(((x)object).a));
        }
        return k.a(object);
    }

    public static final Object b(Object object) {
        Throwable throwable = k.b(object);
        if (throwable == null) {
            return object;
        }
        return new x(throwable, false, 2, null);
    }

    public static final Object c(Object object, i i2) {
        i2 = k.b(object);
        if (i2 == null) {
            return object;
        }
        return new x((Throwable)i2, false, 2, null);
    }
}

