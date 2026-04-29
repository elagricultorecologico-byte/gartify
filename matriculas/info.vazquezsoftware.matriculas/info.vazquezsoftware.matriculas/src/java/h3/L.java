/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package h3;

import c3.F;
import h3.v;

public abstract class l {
    public static final void a(int n2) {
        if (n2 >= 1) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected positive parallelism level, but got ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public static final F b(F f2, String string) {
        if (string != null) {
            return new v(f2, string);
        }
        return f2;
    }
}

