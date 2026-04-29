/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.reflect.Array
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 */
package V2;

import V2.k;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class f {
    private static final Object[] a = new Object[0];

    /*
     * Enabled aggressive block sorting
     */
    public static final Object[] a(Collection objectArray) {
        k.e(objectArray, "collection");
        int n3 = objectArray.size();
        if (n3 == 0) {
            return a;
        }
        Iterator iterator = objectArray.iterator();
        if (!iterator.hasNext()) {
            return a;
        }
        Object[] objectArray2 = new Object[n3];
        n3 = 0;
        while (true) {
            int n4 = n3 + 1;
            objectArray2[n3] = iterator.next();
            if (n4 >= objectArray2.length) {
                int n5;
                if (!iterator.hasNext()) {
                    return objectArray2;
                }
                n3 = n5 = n4 * 3 + 1 >>> 1;
                if (n5 <= n4) {
                    n3 = 0x7FFFFFFD;
                    if (n4 >= 0x7FFFFFFD) {
                        throw new OutOfMemoryError();
                    }
                }
                objectArray = Arrays.copyOf((Object[])objectArray2, (int)n3);
            } else {
                objectArray = objectArray2;
                if (!iterator.hasNext()) {
                    objectArray = Arrays.copyOf((Object[])objectArray2, (int)n4);
                    k.d(objectArray, "copyOf(...)");
                    return objectArray;
                }
            }
            n3 = n4;
            objectArray2 = objectArray;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final Object[] b(Collection objectArray, Object[] objectArray2) {
        k.e(objectArray, "collection");
        objectArray2.getClass();
        int n3 = objectArray.size();
        int n4 = 0;
        if (n3 == 0) {
            if (objectArray2.length <= 0) return objectArray2;
            objectArray2[0] = null;
            return objectArray2;
        }
        Iterator iterator = objectArray.iterator();
        if (!iterator.hasNext()) {
            if (objectArray2.length <= 0) return objectArray2;
            objectArray2[0] = null;
            return objectArray2;
        }
        if (n3 <= objectArray2.length) {
            objectArray = objectArray2;
        } else {
            objectArray = Array.newInstance((Class)objectArray2.getClass().getComponentType(), (int)n3);
            k.c(objectArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        while (true) {
            Object[] objectArray3;
            n3 = n4 + 1;
            objectArray[n4] = iterator.next();
            if (n3 >= objectArray.length) {
                int n5;
                if (!iterator.hasNext()) {
                    return objectArray;
                }
                n4 = n5 = n3 * 3 + 1 >>> 1;
                if (n5 <= n3) {
                    n4 = 0x7FFFFFFD;
                    if (n3 >= 0x7FFFFFFD) {
                        throw new OutOfMemoryError();
                    }
                }
                objectArray3 = Arrays.copyOf((Object[])objectArray, (int)n4);
            } else {
                objectArray3 = objectArray;
                if (!iterator.hasNext()) {
                    if (objectArray != objectArray2) break;
                    objectArray2[n3] = null;
                    return objectArray2;
                }
            }
            n4 = n3;
            objectArray = objectArray3;
        }
        objectArray = Arrays.copyOf((Object[])objectArray, (int)n3);
        k.d(objectArray, "copyOf(...)");
        return objectArray;
    }
}

