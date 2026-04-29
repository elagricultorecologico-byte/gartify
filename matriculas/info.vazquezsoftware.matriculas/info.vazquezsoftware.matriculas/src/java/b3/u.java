/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package b3;

import H2.j;
import H2.n;
import I2.i;
import I2.o;
import V2.k;
import Y2.a;
import Y2.d;
import b3.b;
import b3.c;
import b3.e;
import b3.f;
import b3.s;
import b3.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class u
extends s {
    public static /* synthetic */ j F(char[] cArray, boolean bl, CharSequence charSequence, int n3) {
        return u.c0(cArray, bl, charSequence, n3);
    }

    public static final boolean G(CharSequence charSequence, char c3, boolean bl) {
        k.e(charSequence, "<this>");
        return u.R(charSequence, c3, 0, bl, 2, null) >= 0;
    }

    public static final boolean H(CharSequence charSequence, CharSequence charSequence2, boolean bl) {
        k.e(charSequence, "<this>");
        k.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            return u.S(charSequence, (String)charSequence2, 0, bl, 2, null) >= 0;
        }
        return u.Q(charSequence, charSequence2, 0, charSequence.length(), bl, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean I(CharSequence charSequence, char c3, boolean bl, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl = false;
        }
        return u.G(charSequence, c3, bl);
    }

    public static /* synthetic */ boolean J(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl = false;
        }
        return u.H(charSequence, charSequence2, bl);
    }

    public static final boolean K(CharSequence charSequence, CharSequence charSequence2, boolean bl) {
        k.e(charSequence, "<this>");
        k.e(charSequence2, "suffix");
        if (!bl && charSequence instanceof String && charSequence2 instanceof String) {
            return s.t((String)charSequence, (String)charSequence2, false, 2, null);
        }
        return u.d0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), bl);
    }

    public static /* synthetic */ boolean L(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl = false;
        }
        return u.K(charSequence, charSequence2, bl);
    }

    public static final int M(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int N(CharSequence charSequence, char c3, int n3, boolean bl) {
        k.e(charSequence, "<this>");
        if (!bl && charSequence instanceof String) {
            return ((String)charSequence).indexOf((int)c3, n3);
        }
        return u.T(charSequence, new char[]{c3}, n3, bl);
    }

    public static final int O(CharSequence charSequence, String string, int n3, boolean bl) {
        k.e(charSequence, "<this>");
        k.e(string, "string");
        if (!bl && charSequence instanceof String) {
            return ((String)charSequence).indexOf(string, n3);
        }
        return u.Q(charSequence, string, n3, charSequence.length(), bl, false, 16, null);
    }

    private static final int P(CharSequence charSequence, CharSequence charSequence2, int n3, int n4, boolean bl, boolean bl2) {
        Object object = !bl2 ? new Y2.c(d.b(n3, 0), d.c(n4, charSequence.length())) : d.f(d.c(n3, u.M(charSequence)), d.b(n4, 0));
        if (charSequence instanceof String && charSequence2 instanceof String) {
            n3 = ((a)object).c();
            int n5 = ((a)object).f();
            n4 = ((a)object).h();
            if (n4 > 0 && n3 <= n5 || n4 < 0 && n5 <= n3) {
                while (true) {
                    if (s.v((String)(object = (String)charSequence2), 0, (String)charSequence, n3, object.length(), bl)) {
                        return n3;
                    }
                    if (n3 != n5) {
                        n3 += n4;
                        continue;
                    }
                    break;
                }
            }
        } else {
            n3 = ((a)object).c();
            int n6 = ((a)object).f();
            n4 = ((a)object).h();
            if (n4 > 0 && n3 <= n6 || n4 < 0 && n6 <= n3) {
                while (true) {
                    if (bl2 = u.d0(charSequence2, 0, charSequence, n3, charSequence2.length(), bl)) {
                        return n3;
                    }
                    if (n3 == n6) break;
                    n3 += n4;
                }
            }
        }
        return -1;
    }

    static /* synthetic */ int Q(CharSequence charSequence, CharSequence charSequence2, int n3, int n4, boolean bl, boolean bl2, int n5, Object object) {
        if ((n5 & 0x10) != 0) {
            bl2 = false;
        }
        return u.P(charSequence, charSequence2, n3, n4, bl, bl2);
    }

    public static /* synthetic */ int R(CharSequence charSequence, char c3, int n3, boolean bl, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n3 = 0;
        }
        if ((n4 & 4) != 0) {
            bl = false;
        }
        return u.N(charSequence, c3, n3, bl);
    }

    public static /* synthetic */ int S(CharSequence charSequence, String string, int n3, boolean bl, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n3 = 0;
        }
        if ((n4 & 4) != 0) {
            bl = false;
        }
        return u.O(charSequence, string, n3, bl);
    }

    public static final int T(CharSequence charSequence, char[] cArray, int n3, boolean bl) {
        int n4;
        k.e(charSequence, "<this>");
        k.e(cArray, "chars");
        if (!bl && cArray.length == 1 && charSequence instanceof String) {
            char c3 = i.u(cArray);
            return ((String)charSequence).indexOf((int)c3, n3);
        }
        if ((n3 = d.b(n3, 0)) <= (n4 = u.M(charSequence))) {
            while (true) {
                char c4 = charSequence.charAt(n3);
                int n5 = cArray.length;
                for (int i3 = 0; i3 < n5; ++i3) {
                    if (!c.d(cArray[i3], c4, bl)) continue;
                    return n3;
                }
                if (n3 == n4) break;
                ++n3;
            }
        }
        return -1;
    }

    public static final boolean U(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        for (int i3 = 0; i3 < charSequence.length(); ++i3) {
            if (b.c(charSequence.charAt(i3))) continue;
            return false;
        }
        return true;
    }

    public static final int V(CharSequence charSequence, char c3, int n3, boolean bl) {
        k.e(charSequence, "<this>");
        if (!bl && charSequence instanceof String) {
            return ((String)charSequence).lastIndexOf((int)c3, n3);
        }
        return u.X(charSequence, new char[]{c3}, n3, bl);
    }

    public static /* synthetic */ int W(CharSequence charSequence, char c3, int n3, boolean bl, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n3 = u.M(charSequence);
        }
        if ((n4 & 4) != 0) {
            bl = false;
        }
        return u.V(charSequence, c3, n3, bl);
    }

    public static final int X(CharSequence charSequence, char[] cArray, int n3, boolean bl) {
        k.e(charSequence, "<this>");
        k.e(cArray, "chars");
        if (!bl && cArray.length == 1 && charSequence instanceof String) {
            char c3 = i.u(cArray);
            return ((String)charSequence).lastIndexOf((int)c3, n3);
        }
        for (n3 = d.c(n3, u.M(charSequence)); -1 < n3; --n3) {
            char c4 = charSequence.charAt(n3);
            int n4 = cArray.length;
            for (int i3 = 0; i3 < n4; ++i3) {
                if (!c.d(cArray[i3], c4, bl)) continue;
                return n3;
            }
        }
        return -1;
    }

    public static final a3.d Y(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        return new a3.d(charSequence){
            final CharSequence a;
            {
                this.a = charSequence;
            }

            @Override
            public Iterator iterator() {
                return new f(this.a);
            }
        };
    }

    public static final List Z(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        return a3.e.h(u.Y(charSequence));
    }

    private static final a3.d a0(CharSequence charSequence, char[] cArray, int n3, boolean bl, int n4) {
        u.g0(n4);
        return new e(charSequence, n3, n4, new t(cArray, bl));
    }

    static /* synthetic */ a3.d b0(CharSequence charSequence, char[] cArray, int n3, boolean bl, int n4, int n5, Object object) {
        if ((n5 & 2) != 0) {
            n3 = 0;
        }
        if ((n5 & 4) != 0) {
            bl = false;
        }
        if ((n5 & 8) != 0) {
            n4 = 0;
        }
        return u.a0(charSequence, cArray, n3, bl, n4);
    }

    private static final j c0(char[] cArray, boolean bl, CharSequence charSequence, int n3) {
        k.e(charSequence, "$this$DelimitedRangesSequence");
        n3 = u.T(charSequence, cArray, n3, bl);
        if (n3 < 0) {
            return null;
        }
        return n.a(n3, 1);
    }

    public static final boolean d0(CharSequence charSequence, int n3, CharSequence charSequence2, int n4, int n5, boolean bl) {
        k.e(charSequence, "<this>");
        k.e(charSequence2, "other");
        if (n4 >= 0 && n3 >= 0 && n3 <= charSequence.length() - n5 && n4 <= charSequence2.length() - n5) {
            for (int i3 = 0; i3 < n5; ++i3) {
                if (c.d(charSequence.charAt(n3 + i3), charSequence2.charAt(n4 + i3), bl)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public static String e0(String string, CharSequence charSequence) {
        k.e(string, "<this>");
        k.e(charSequence, "prefix");
        String string2 = string;
        if (u.l0(string, charSequence, false, 2, null)) {
            string2 = string.substring(charSequence.length());
            k.d(string2, "substring(...)");
        }
        return string2;
    }

    public static String f0(String string, CharSequence charSequence) {
        k.e(string, "<this>");
        k.e(charSequence, "suffix");
        String string2 = string;
        if (u.L(string, charSequence, false, 2, null)) {
            string2 = string.substring(0, string.length() - charSequence.length());
            k.d(string2, "substring(...)");
        }
        return string2;
    }

    public static final void g0(int n3) {
        if (n3 >= 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Limit must be non-negative, but was ");
        stringBuilder.append(n3);
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public static final List h0(CharSequence charSequence, char[] object, boolean bl, int n3) {
        k.e(charSequence, "<this>");
        k.e(object, "delimiters");
        if (((char[])object).length == 1) {
            return u.i0(charSequence, String.valueOf((char)object[0]), bl, n3);
        }
        Iterable iterable = a3.e.c(u.b0(charSequence, object, 0, bl, n3, 2, null));
        object = new ArrayList(o.o(iterable, 10));
        iterable = iterable.iterator();
        while (iterable.hasNext()) {
            object.add((Object)u.m0(charSequence, (Y2.c)iterable.next()));
        }
        return object;
    }

    private static final List i0(CharSequence charSequence, String string, boolean bl, int n3) {
        u.g0(n3);
        int n4 = 0;
        int n5 = u.O(charSequence, string, 0, bl);
        if (n5 != -1 && n3 != 1) {
            int n6;
            boolean bl2 = n3 > 0;
            int n7 = 10;
            if (bl2) {
                n7 = d.c(n3, 10);
            }
            ArrayList arrayList = new ArrayList(n7);
            n7 = n5;
            do {
                arrayList.add((Object)charSequence.subSequence(n4, n7).toString());
                n6 = string.length() + n7;
                if (bl2 && arrayList.size() == n3 - 1) break;
                n5 = u.O(charSequence, string, n6, bl);
                n4 = n6;
                n7 = n5;
            } while (n5 != -1);
            arrayList.add((Object)charSequence.subSequence(n6, charSequence.length()).toString());
            return arrayList;
        }
        return o.b(charSequence.toString());
    }

    public static /* synthetic */ List j0(CharSequence charSequence, char[] cArray, boolean bl, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            bl = false;
        }
        if ((n4 & 4) != 0) {
            n3 = 0;
        }
        return u.h0(charSequence, cArray, bl, n3);
    }

    public static final boolean k0(CharSequence charSequence, CharSequence charSequence2, boolean bl) {
        k.e(charSequence, "<this>");
        k.e(charSequence2, "prefix");
        if (!bl && charSequence instanceof String && charSequence2 instanceof String) {
            return s.E((String)charSequence, (String)charSequence2, false, 2, null);
        }
        return u.d0(charSequence, 0, charSequence2, 0, charSequence2.length(), bl);
    }

    public static /* synthetic */ boolean l0(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl = false;
        }
        return u.k0(charSequence, charSequence2, bl);
    }

    public static final String m0(CharSequence charSequence, Y2.c c3) {
        k.e(charSequence, "<this>");
        k.e(c3, "range");
        return charSequence.subSequence(c3.l().intValue(), c3.k() + 1).toString();
    }

    public static final String n0(String string, char c3, String string2) {
        k.e(string, "<this>");
        k.e(string2, "missingDelimiterValue");
        int n3 = u.R(string, c3, 0, false, 6, null);
        if (n3 == -1) {
            return string2;
        }
        string = string.substring(n3 + 1, string.length());
        k.d(string, "substring(...)");
        return string;
    }

    public static final String o0(String string, String string2, String string3) {
        k.e(string, "<this>");
        k.e(string2, "delimiter");
        k.e(string3, "missingDelimiterValue");
        int n3 = u.S(string, string2, 0, false, 6, null);
        if (n3 == -1) {
            return string3;
        }
        string = string.substring(n3 + string2.length(), string.length());
        k.d(string, "substring(...)");
        return string;
    }

    public static /* synthetic */ String p0(String string, char c3, String string2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            string2 = string;
        }
        return u.n0(string, c3, string2);
    }

    public static /* synthetic */ String q0(String string, String string2, String string3, int n3, Object object) {
        if ((n3 & 2) != 0) {
            string3 = string;
        }
        return u.o0(string, string2, string3);
    }

    public static final String r0(String string, char c3, String string2) {
        k.e(string, "<this>");
        k.e(string2, "missingDelimiterValue");
        int n3 = u.W(string, c3, 0, false, 6, null);
        if (n3 == -1) {
            return string2;
        }
        string = string.substring(n3 + 1, string.length());
        k.d(string, "substring(...)");
        return string;
    }

    public static /* synthetic */ String s0(String string, char c3, String string2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            string2 = string;
        }
        return u.r0(string, c3, string2);
    }

    public static CharSequence t0(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        int n3 = charSequence.length() - 1;
        int n4 = 0;
        boolean bl = false;
        while (n4 <= n3) {
            int n5 = !bl ? n4 : n3;
            boolean bl2 = b.c(charSequence.charAt(n5));
            if (!bl) {
                if (!bl2) {
                    bl = true;
                    continue;
                }
                ++n4;
                continue;
            }
            if (!bl2) break;
            --n3;
        }
        return charSequence.subSequence(n4, n3 + 1);
    }
}

