/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package j0;

public abstract class e {
    public static final String[] a = new String[0];

    public static void a(StringBuilder stringBuilder, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append("?");
            if (i2 >= n2 - 1) continue;
            stringBuilder.append(",");
        }
    }

    public static StringBuilder b() {
        return new StringBuilder();
    }
}

