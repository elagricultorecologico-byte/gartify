/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 */
package J2;

import V2.k;
import java.util.Arrays;

public abstract class b {
    public static final Object[] a(int n2) {
        if (n2 >= 0) {
            return new Object[n2];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final Object[] b(Object[] objectArray, int n2) {
        k.e((Object)objectArray, (String)"<this>");
        objectArray = Arrays.copyOf((Object[])objectArray, (int)n2);
        k.d((Object)objectArray, (String)"copyOf(...)");
        return objectArray;
    }

    public static final void c(Object[] objectArray, int n2) {
        k.e((Object)objectArray, (String)"<this>");
        objectArray[n2] = null;
    }

    public static final void d(Object[] objectArray, int n2, int n3) {
        k.e((Object)objectArray, (String)"<this>");
        while (n2 < n3) {
            b.c(objectArray, n2);
            ++n2;
        }
    }
}

