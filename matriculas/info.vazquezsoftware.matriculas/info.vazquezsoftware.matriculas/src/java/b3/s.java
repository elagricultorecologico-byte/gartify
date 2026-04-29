/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b3;

import V2.k;
import Y2.d;
import b3.c;
import b3.r;
import b3.u;

abstract class s
extends r {
    public static /* synthetic */ String A(String string, String string2, String string3, boolean bl, int n3, Object object) {
        if ((n3 & 4) != 0) {
            bl = false;
        }
        return s.y(string, string2, string3, bl);
    }

    public static boolean B(String string, String string2, int n3, boolean bl) {
        k.e(string, "<this>");
        k.e(string2, "prefix");
        if (!bl) {
            return string.startsWith(string2, n3);
        }
        return s.v(string, n3, string2, 0, string2.length(), bl);
    }

    public static boolean C(String string, String string2, boolean bl) {
        k.e(string, "<this>");
        k.e(string2, "prefix");
        if (!bl) {
            return string.startsWith(string2);
        }
        return s.v(string, 0, string2, 0, string2.length(), bl);
    }

    public static /* synthetic */ boolean D(String string, String string2, int n3, boolean bl, int n4, Object object) {
        if ((n4 & 4) != 0) {
            bl = false;
        }
        return s.B(string, string2, n3, bl);
    }

    public static /* synthetic */ boolean E(String string, String string2, boolean bl, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl = false;
        }
        return s.C(string, string2, bl);
    }

    public static String q(char[] cArray) {
        k.e(cArray, "<this>");
        return new String(cArray);
    }

    public static String r(char[] cArray, int n3, int n4) {
        k.e(cArray, "<this>");
        I2.c.g.a(n3, n4, cArray.length);
        return new String(cArray, n3, n4 - n3);
    }

    public static final boolean s(String string, String string2, boolean bl) {
        k.e(string, "<this>");
        k.e(string2, "suffix");
        if (!bl) {
            return string.endsWith(string2);
        }
        return s.v(string, string.length() - string2.length(), string2, 0, string2.length(), true);
    }

    public static /* synthetic */ boolean t(String string, String string2, boolean bl, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl = false;
        }
        return s.s(string, string2, bl);
    }

    public static boolean u(String string, String string2, boolean bl) {
        if (string == null) {
            return string2 == null;
        }
        if (!bl) {
            return string.equals((Object)string2);
        }
        return string.equalsIgnoreCase(string2);
    }

    public static final boolean v(String string, int n3, String string2, int n4, int n5, boolean bl) {
        k.e(string, "<this>");
        k.e(string2, "other");
        if (!bl) {
            return string.regionMatches(n3, string2, n4, n5);
        }
        return string.regionMatches(bl, n3, string2, n4, n5);
    }

    public static String w(CharSequence object, int n3) {
        k.e(object, "<this>");
        if (n3 >= 0) {
            if (n3 != 0) {
                int n4 = 1;
                if (n3 != 1) {
                    int n5 = object.length();
                    if (n5 != 0) {
                        if (n5 != 1) {
                            StringBuilder stringBuilder = new StringBuilder(object.length() * n3);
                            if (1 <= n3) {
                                while (true) {
                                    stringBuilder.append(object);
                                    if (n4 == n3) break;
                                    ++n4;
                                }
                            }
                            object = stringBuilder.toString();
                            k.b(object);
                            return object;
                        }
                        char c3 = object.charAt(0);
                        object = new char[n3];
                        for (n4 = 0; n4 < n3; ++n4) {
                            object[n4] = (CharSequence)c3;
                        }
                        return new String((char[])object);
                    }
                    return "";
                }
                return object.toString();
            }
            return "";
        }
        object = new StringBuilder();
        object.append("Count 'n' must be non-negative, but was ");
        object.append(n3);
        object.append('.');
        throw new IllegalArgumentException(object.toString().toString());
    }

    public static final String x(String string, char c3, char c4, boolean bl) {
        k.e(string, "<this>");
        if (!bl) {
            string = string.replace(c3, c4);
            k.d(string, "replace(...)");
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i3 = 0; i3 < string.length(); ++i3) {
            char c5;
            char c6 = c5 = string.charAt(i3);
            if (c.d(c5, c3, bl)) {
                c6 = c4;
            }
            stringBuilder.append(c6);
        }
        return stringBuilder.toString();
    }

    public static final String y(String string, String string2, String string3, boolean bl) {
        k.e(string, "<this>");
        k.e(string2, "oldValue");
        k.e(string3, "newValue");
        int n3 = 0;
        int n4 = u.O(string, string2, 0, bl);
        if (n4 < 0) {
            return string;
        }
        int n5 = string2.length();
        int n6 = d.b(n5, 1);
        int n7 = string.length() - n5 + string3.length();
        if (n7 >= 0) {
            int n8;
            StringBuilder stringBuilder = new StringBuilder(n7);
            do {
                stringBuilder.append((CharSequence)string, n3, n4);
                stringBuilder.append(string3);
                n8 = n4 + n5;
                if (n4 >= string.length()) break;
                n7 = u.O(string, string2, n4 + n6, bl);
                n3 = n8;
                n4 = n7;
            } while (n7 > 0);
            stringBuilder.append((CharSequence)string, n8, string.length());
            string = stringBuilder.toString();
            k.d(string, "toString(...)");
            return string;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String z(String string, char c3, char c4, boolean bl, int n3, Object object) {
        if ((n3 & 4) != 0) {
            bl = false;
        }
        return s.x(string, c3, c4, bl);
    }
}

