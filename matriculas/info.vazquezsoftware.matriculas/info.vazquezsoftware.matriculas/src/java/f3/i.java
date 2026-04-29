/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.CharsetEncoder
 *  java.util.Arrays
 *  java.util.HashMap
 */
package F3;

import D3.e;
import F3.f;
import F3.j;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;

public abstract class i {
    private static final char[] a = new char[]{',', ';'};
    private static final HashMap b = new HashMap();
    private static final f.a c = new f.a();

    private static void b(Appendable appendable, c object, int n2) {
        if (!"".equals(object = object.n(n2))) {
            appendable.append('&').append((CharSequence)object).append(';');
            return;
        }
        appendable.append((CharSequence)"&#x").append((CharSequence)Integer.toHexString((int)n2)).append(';');
    }

    private static boolean c(b b2, char c2, CharsetEncoder charsetEncoder) {
        int n2 = F3.i$a.a[b2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                return charsetEncoder.canEncode(c2);
            }
            return true;
        }
        return c2 < '\u0080';
    }

    public static int d(String string, int[] nArray) {
        String string2 = (String)b.get((Object)string);
        if (string2 != null) {
            nArray[0] = string2.codePointAt(0);
            nArray[1] = string2.codePointAt(1);
            return 2;
        }
        int n2 = F3.i$c.m.m(string);
        if (n2 != -1) {
            nArray[0] = n2;
            return 1;
        }
        return 0;
    }

    static void e(Appendable appendable, String string, f.a a2, boolean bl, boolean bl2, boolean bl3) {
        int n2;
        boolean bl4;
        c c2 = a2.h();
        CharsetEncoder charsetEncoder = a2.e();
        b b2 = a2.j;
        int n3 = string.length();
        boolean bl5 = bl4 = false;
        for (int i2 = 0; i2 < n3; i2 += Character.charCount((int)n2)) {
            boolean bl6;
            boolean bl7;
            block32: {
                block29: {
                    block30: {
                        block31: {
                            n2 = string.codePointAt(i2);
                            bl7 = bl4;
                            bl6 = bl5;
                            if (!bl2) break block29;
                            if (!E3.c.j(n2)) break block30;
                            if (!bl3) break block31;
                            bl7 = bl4;
                            bl6 = bl5;
                            if (!bl4) break block32;
                        }
                        if (bl5) {
                            bl7 = bl4;
                            bl6 = bl5;
                        } else {
                            appendable.append(' ');
                            bl6 = true;
                            bl7 = bl4;
                        }
                        break block32;
                    }
                    bl6 = false;
                    bl7 = true;
                }
                if (n2 < 65536) {
                    char c3 = (char)n2;
                    if (c3 != '\"') {
                        if (c3 != '&') {
                            if (c3 != '<') {
                                if (c3 != '>') {
                                    if (c3 != '\u00a0') {
                                        if (i.c(b2, c3, charsetEncoder)) {
                                            appendable.append(c3);
                                        } else {
                                            i.b(appendable, c2, n2);
                                        }
                                    } else if (c2 != F3.i$c.k) {
                                        appendable.append((CharSequence)"&nbsp;");
                                    } else {
                                        appendable.append((CharSequence)"&#xa0;");
                                    }
                                } else if (!bl) {
                                    appendable.append((CharSequence)"&gt;");
                                } else {
                                    appendable.append(c3);
                                }
                            } else if (bl && c2 != F3.i$c.k && a2.o() != f.a.a.h) {
                                appendable.append(c3);
                            } else {
                                appendable.append((CharSequence)"&lt;");
                            }
                        } else {
                            appendable.append((CharSequence)"&amp;");
                        }
                    } else if (bl) {
                        appendable.append((CharSequence)"&quot;");
                    } else {
                        appendable.append(c3);
                    }
                } else {
                    String string2 = new String(Character.toChars((int)n2));
                    if (charsetEncoder.canEncode((CharSequence)string2)) {
                        appendable.append((CharSequence)string2);
                    } else {
                        i.b(appendable, c2, n2);
                    }
                }
            }
            bl4 = bl7;
            bl5 = bl6;
        }
    }

    public static boolean f(String string) {
        return F3.i$c.l.m(string) != -1;
    }

    public static boolean g(String string) {
        return F3.i$c.m.m(string) != -1;
    }

    private static void h(c c2, String string, int n2) {
        F3.i$c.e(c2, new String[n2]);
        F3.i$c.g(c2, new int[n2]);
        F3.i$c.i(c2, new int[n2]);
        F3.i$c.l(c2, new String[n2]);
        G3.a a2 = new G3.a(string);
        boolean bl = false;
        int n3 = 0;
        while (!a2.u()) {
            string = a2.n('=');
            a2.a();
            int n4 = Integer.parseInt((String)a2.p(a), (int)36);
            int n5 = a2.t();
            a2.a();
            if (n5 == 44) {
                n5 = Integer.parseInt((String)a2.n(';'), (int)36);
                a2.a();
            } else {
                n5 = -1;
            }
            int n6 = Integer.parseInt((String)a2.n('&'), (int)36);
            a2.a();
            ((c)c2).g[n3] = string;
            ((c)c2).h[n3] = n4;
            ((c)c2).i[n6] = n4;
            ((c)c2).j[n6] = string;
            if (n5 != -1) {
                b.put((Object)string, (Object)new String(new int[]{n4, n5}, 0, 2));
            }
            ++n3;
        }
        if (n3 == n2) {
            bl = true;
        }
        e.e(bl, "Unexpected count of entities loaded");
    }

    static final class b
    extends Enum {
        public static final /* enum */ b g;
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        private static final b[] j;

        static {
            b b2;
            b b3;
            b b4;
            g = b4 = new b("ascii", 0);
            h = b3 = new b("utf", 1);
            i = b2 = new b("fallback", 2);
            j = new b[]{b4, b3, b2};
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private b() {
            void var2_-1;
            void var1_-1;
        }

        static b d(String string) {
            if (string.equals((Object)"US-ASCII")) {
                return g;
            }
            if (string.startsWith("UTF-")) {
                return h;
            }
            return i;
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])j.clone();
        }
    }

    public static final class c
    extends Enum {
        public static final /* enum */ c k;
        public static final /* enum */ c l;
        public static final /* enum */ c m;
        private static final c[] n;
        private String[] g;
        private int[] h;
        private int[] i;
        private String[] j;

        static {
            c c2;
            c c3;
            c c4;
            k = c4 = new c("xhtml", 0, F3.j.a, 4);
            l = c3 = new c("base", 1, F3.j.b, 106);
            m = c2 = new c("extended", 2, F3.j.c, 2125);
            n = new c[]{c4, c3, c2};
        }

        /*
         * WARNING - void declaration
         */
        private c() {
            void var4_1;
            void var3_2;
            void var2_-1;
            void var1_-1;
            F3.i.h(this, (String)var3_2, (int)var4_1);
        }

        static /* synthetic */ String[] e(c c2, String[] stringArray) {
            c2.g = stringArray;
            return stringArray;
        }

        static /* synthetic */ int[] g(c c2, int[] nArray) {
            c2.h = nArray;
            return nArray;
        }

        static /* synthetic */ int[] i(c c2, int[] nArray) {
            c2.i = nArray;
            return nArray;
        }

        static /* synthetic */ String[] l(c c2, String[] stringArray) {
            c2.j = stringArray;
            return stringArray;
        }

        public static c valueOf(String string) {
            return (c)Enum.valueOf(c.class, (String)string);
        }

        public static c[] values() {
            return (c[])n.clone();
        }

        int m(String string) {
            int n2 = Arrays.binarySearch((Object[])this.g, (Object)string);
            if (n2 >= 0) {
                return this.h[n2];
            }
            return -1;
        }

        String n(int n2) {
            int n3 = Arrays.binarySearch((int[])this.i, (int)n2);
            if (n3 >= 0) {
                int n4;
                int[] nArray;
                String[] stringArray = this.j;
                if (n3 < stringArray.length - 1 && (nArray = this.i)[n4 = n3 + 1] == n2) {
                    return stringArray[n4];
                }
                return stringArray[n3];
            }
            return "";
        }
    }
}

