/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.StringBuilder
 */
package Y2;

import V2.k;

abstract class e {
    public static final void a(boolean bl, Number number) {
        k.e(number, "step");
        if (bl) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Step must be positive, was: ");
        stringBuilder.append((Object)number);
        stringBuilder.append('.');
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}

