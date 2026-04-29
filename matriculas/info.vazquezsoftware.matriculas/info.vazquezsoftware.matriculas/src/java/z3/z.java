/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package z3;

import V2.k;

public abstract class z {
    /*
     * Enabled aggressive block sorting
     */
    public static final long a(String string, int n2, int n3) {
        k.e(string, "<this>");
        int n4 = 1;
        int n5 = n2 >= 0 ? 1 : 0;
        if (n5 == 0) {
            throw new IllegalArgumentException(k.j("beginIndex < 0: ", n2).toString());
        }
        n5 = n3 >= n2 ? 1 : 0;
        if (n5 == 0) {
            string = new StringBuilder();
            string.append("endIndex < beginIndex: ");
            string.append(n3);
            string.append(" < ");
            string.append(n2);
            throw new IllegalArgumentException(string.toString().toString());
        }
        n5 = n3 <= string.length() ? n4 : 0;
        if (n5 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > string.length: ");
            stringBuilder.append(n3);
            stringBuilder.append(" > ");
            stringBuilder.append(string.length());
            throw new IllegalArgumentException(stringBuilder.toString().toString());
        }
        long l2 = 0L;
        while (n2 < n3) {
            char c2 = string.charAt(n2);
            if (c2 < '\u0080') {
                ++l2;
            } else {
                if (c2 < '\u0800') {
                    n5 = 2;
                } else {
                    if (c2 >= '\ud800' && c2 <= '\udfff') {
                        n4 = n2 + 1;
                        n5 = n4 < n3 ? (int)string.charAt(n4) : 0;
                        if (c2 <= '\udbff' && n5 >= 56320 && n5 <= 57343) {
                            l2 += (long)4;
                            n2 += 2;
                            continue;
                        }
                        ++l2;
                        n2 = n4;
                        continue;
                    }
                    n5 = 3;
                }
                l2 += (long)n5;
            }
            ++n2;
        }
        return l2;
    }

    public static /* synthetic */ long b(String string, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n2 = 0;
        }
        if ((n4 & 2) != 0) {
            n3 = string.length();
        }
        return z.a(string, n2, n3);
    }
}

