/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.StringBuilder
 */
package b3;

import Y2.c;

abstract class b {
    public static int a(int n3) {
        if (2 <= n3 && n3 < 37) {
            return n3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("radix ");
        stringBuilder.append(n3);
        stringBuilder.append(" was not in valid range ");
        stringBuilder.append((Object)new c(2, 36));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static final int b(char c3, int n3) {
        return Character.digit((int)c3, (int)n3);
    }

    public static final boolean c(char c3) {
        return Character.isWhitespace((char)c3) || Character.isSpaceChar((char)c3);
        {
        }
    }
}

