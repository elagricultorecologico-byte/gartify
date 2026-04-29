/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package p;

import p.j;
import q.a;

public abstract class k {
    private static final Object a = new Object();

    public static final /* synthetic */ void a(j j2) {
        k.e(j2);
    }

    public static final /* synthetic */ Object b() {
        return a;
    }

    public static final Object c(j object, int n2) {
        V2.k.e(object, "<this>");
        n2 = q.a.a(((j)object).h, ((j)object).j, n2);
        if (n2 >= 0 && (object = ((j)object).i[n2]) != a) {
            return object;
        }
        return null;
    }

    public static final Object d(j object, int n2, Object object2) {
        V2.k.e(object, "<this>");
        n2 = q.a.a(((j)object).h, ((j)object).j, n2);
        if (n2 >= 0 && (object = ((j)object).i[n2]) != a) {
            return object;
        }
        return object2;
    }

    private static final void e(j j2) {
        int n2 = j2.j;
        int[] nArray = j2.h;
        Object[] objectArray = j2.i;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = objectArray[i2];
            int n4 = n3;
            if (object != a) {
                if (i2 != n3) {
                    nArray[n3] = nArray[i2];
                    objectArray[n3] = object;
                    objectArray[i2] = null;
                }
                n4 = n3 + 1;
            }
            n3 = n4;
        }
        j2.g = false;
        j2.j = n3;
    }
}

