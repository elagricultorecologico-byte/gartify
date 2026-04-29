/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Array
 */
package p;

import java.lang.reflect.Array;

abstract class c {
    static Object[] a(Object[] objectArray, int n2) {
        if (objectArray.length < n2) {
            return (Object[])Array.newInstance((Class)objectArray.getClass().getComponentType(), (int)n2);
        }
        if (objectArray.length > n2) {
            objectArray[n2] = null;
        }
        return objectArray;
    }
}

