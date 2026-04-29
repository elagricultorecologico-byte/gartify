/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.net.IDN
 *  java.net.InetAddress
 *  java.util.Arrays
 *  java.util.Locale
 */
package n3;

import V2.k;
import b3.h;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import n3.d;
import z3.b;

public abstract class a {
    private static final boolean a(String string) {
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (k.f(c2, 31) > 0 && k.f(c2, 127) < 0) {
                if (h.R(" #%/:?@[\\]", c2, 0, false, 6, null) == -1) continue;
                return true;
            }
            return true;
        }
        return false;
    }

    private static final boolean b(String string, int n2, int n3, byte[] byArray, int n4) {
        int n5 = n4;
        int n6 = n2;
        while (n6 < n3) {
            char c2;
            if (n5 == byArray.length) {
                return false;
            }
            n2 = n6;
            if (n5 != n4) {
                if (string.charAt(n6) != '.') {
                    return false;
                }
                n2 = n6 + 1;
            }
            int n7 = 0;
            for (n6 = n2; n6 < n3 && k.f(c2 = string.charAt(n6), 48) >= 0 && k.f(c2, 57) <= 0; ++n6) {
                if (n7 == 0 && n2 != n6) {
                    return false;
                }
                if ((n7 = n7 * 10 + c2 - 48) <= 255) continue;
                return false;
            }
            if (n6 - n2 == 0) {
                return false;
            }
            byArray[n5] = (byte)n7;
            ++n5;
        }
        return n5 == n4 + 4;
    }

    private static final InetAddress c(String string, int n2, int n3) {
        int n4;
        byte[] byArray;
        block14: {
            byArray = new byte[16];
            int n5 = 0;
            int n6 = -1;
            int n7 = -1;
            int n8 = n2;
            while (true) {
                n2 = n5;
                n4 = n6;
                if (n8 >= n3) break block14;
                if (n5 == 16) {
                    return null;
                }
                n4 = n8 + 2;
                if (n4 <= n3 && h.D(string, "::", n8, false, 4, null)) {
                    if (n6 != -1) {
                        return null;
                    }
                    n2 = n5 + 2;
                    if (n4 == n3) {
                        n4 = n2;
                        break block14;
                    }
                    n6 = n2;
                    n8 = n4;
                    n5 = n2;
                    n2 = n8;
                } else {
                    n2 = n8;
                    if (n5 != 0) {
                        if (h.D(string, ":", n8, false, 4, null)) {
                            n2 = n8 + 1;
                        } else {
                            if (h.D(string, ".", n8, false, 4, null)) {
                                if (!a.b(string, n7, n3, byArray, n5 - 2)) {
                                    return null;
                                }
                                n2 = n5 + 2;
                                n4 = n6;
                                break block14;
                            }
                            return null;
                        }
                    }
                }
                n7 = 0;
                for (n8 = n2; n8 < n3 && (n4 = d.H(string.charAt(n8))) != -1; ++n8) {
                    n7 = (n7 << 4) + n4;
                }
                n4 = n8 - n2;
                if (n4 == 0 || n4 > 4) break;
                byArray[n5] = (byte)(n7 >>> 8 & 0xFF);
                n4 = n5 + 2;
                byArray[n5 + 1] = (byte)(n7 & 0xFF);
                n5 = n4;
                n7 = n2;
            }
            return null;
        }
        if (n2 != 16) {
            if (n4 == -1) {
                return null;
            }
            n3 = n2 - n4;
            System.arraycopy((Object)byArray, (int)n4, (Object)byArray, (int)(16 - n3), (int)n3);
            Arrays.fill((byte[])byArray, (int)n4, (int)(16 - n2 + n4), (byte)0);
        }
        return InetAddress.getByAddress((byte[])byArray);
    }

    private static final String d(byte[] byArray) {
        int n2;
        int n3 = -1;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        while (n5 < byArray.length) {
            int n7;
            for (n7 = n5; n7 < 16 && byArray[n7] == 0 && byArray[n7 + 1] == 0; n7 += 2) {
            }
            int n8 = n7 - n5;
            int n9 = n3;
            n2 = n6;
            if (n8 > n6) {
                n9 = n3;
                n2 = n6;
                if (n8 >= 4) {
                    n2 = n8;
                    n9 = n5;
                }
            }
            n5 = n7 + 2;
            n3 = n9;
            n6 = n2;
        }
        b b2 = new b();
        n5 = n4;
        while (n5 < byArray.length) {
            if (n5 == n3) {
                b2.P0(58);
                n5 = n2 = n5 + n6;
                if (n2 != 16) continue;
                b2.P0(58);
                n5 = n2;
                continue;
            }
            if (n5 > 0) {
                b2.P0(58);
            }
            b2.Q0(d.d(byArray[n5], 255) << 8 | d.d(byArray[n5 + 1], 255));
            n5 += 2;
        }
        return b2.l0();
    }

    public static final String e(String string) {
        block8: {
            k.e(string, "<this>");
            if (h.J(string, ":", false, 2, null)) {
                InetAddress inetAddress = h.E(string, "[", false, 2, null) && h.t(string, "]", false, 2, null) ? a.c(string, 1, string.length() - 1) : a.c(string, 0, string.length());
                if (inetAddress == null) {
                    return null;
                }
                byte[] byArray = inetAddress.getAddress();
                if (byArray.length == 16) {
                    k.d(byArray, "address");
                    return a.d(byArray);
                }
                if (byArray.length == 4) {
                    return inetAddress.getHostAddress();
                }
                inetAddress = new StringBuilder();
                inetAddress.append("Invalid IPv6 address: '");
                inetAddress.append(string);
                inetAddress.append('\'');
                throw new AssertionError((Object)inetAddress.toString());
            }
            try {
                String string2 = IDN.toASCII((String)string);
                k.d(string2, "toASCII(host)");
                string = Locale.US;
                k.d(string, "US");
                string = string2.toLowerCase((Locale)string);
                k.d(string, "this as java.lang.String).toLowerCase(locale)");
                if (string.length() != 0) break block8;
                return null;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return null;
            }
        }
        boolean bl = a.a(string);
        if (bl) {
            return null;
        }
        return string;
    }
}

