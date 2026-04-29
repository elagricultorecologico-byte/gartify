/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.privacysandbox.ads.adservices.topics.a
 *  androidx.privacysandbox.ads.adservices.topics.d
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.List
 *  java.util.Locale
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  okhttp3.internal.publicsuffix.PublicSuffixDatabase
 */
package m3;

import I2.o;
import V2.k;
import b3.g;
import b3.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m3.s;
import m3.t;
import n3.d;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import s3.c;

public final class l {
    public static final a j = new a(null);
    private static final Pattern k = Pattern.compile((String)"(\\d{2,4})[^\\d]*");
    private static final Pattern l = Pattern.compile((String)"(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern m = Pattern.compile((String)"(\\d{1,2})[^\\d]*");
    private static final Pattern n = Pattern.compile((String)"(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String a;
    private final String b;
    private final long c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    private l(String string, String string2, long l2, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.a = string;
        this.b = string2;
        this.c = l2;
        this.d = string3;
        this.e = string4;
        this.f = bl;
        this.g = bl2;
        this.h = bl3;
        this.i = bl4;
    }

    public /* synthetic */ l(String string, String string2, long l2, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4, V2.g g2) {
        this(string, string2, l2, string3, string4, bl, bl2, bl3, bl4);
    }

    public final String e() {
        return this.d;
    }

    public boolean equals(Object object) {
        if (object instanceof l) {
            object = (l)object;
            if (V2.k.a(((l)object).a, this.a) && V2.k.a(((l)object).b, this.b) && ((l)object).c == this.c && V2.k.a(((l)object).d, this.d) && V2.k.a(((l)object).e, this.e) && ((l)object).f == this.f && ((l)object).g == this.g && ((l)object).h == this.h && ((l)object).i == this.i) {
                return true;
            }
        }
        return false;
    }

    public final long f() {
        return this.c;
    }

    public final boolean g() {
        return this.i;
    }

    public final boolean h() {
        return this.g;
    }

    public int hashCode() {
        return ((((((((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + androidx.privacysandbox.ads.adservices.topics.d.a((long)this.c)) * 31 + this.d.hashCode()) * 31 + this.e.hashCode()) * 31 + androidx.privacysandbox.ads.adservices.topics.a.a((boolean)this.f)) * 31 + androidx.privacysandbox.ads.adservices.topics.a.a((boolean)this.g)) * 31 + androidx.privacysandbox.ads.adservices.topics.a.a((boolean)this.h)) * 31 + androidx.privacysandbox.ads.adservices.topics.a.a((boolean)this.i);
    }

    public final String i() {
        return this.a;
    }

    public final String j() {
        return this.e;
    }

    public final boolean k() {
        return this.h;
    }

    public final boolean l() {
        return this.f;
    }

    public final String m(boolean bl) {
        Object object = new StringBuilder();
        object.append(this.i());
        object.append('=');
        object.append(this.n());
        if (this.k()) {
            if (this.f() == Long.MIN_VALUE) {
                object.append("; max-age=0");
            } else {
                object.append("; expires=");
                object.append(s3.c.b(new Date(this.f())));
            }
        }
        if (!this.g()) {
            object.append("; domain=");
            if (bl) {
                object.append(".");
            }
            object.append(this.e());
        }
        object.append("; path=");
        object.append(this.j());
        if (this.l()) {
            object.append("; secure");
        }
        if (this.h()) {
            object.append("; httponly");
        }
        object = object.toString();
        V2.k.d(object, "toString()");
        return object;
    }

    public final String n() {
        return this.b;
    }

    public String toString() {
        return this.m(false);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g2) {
            this();
        }

        private final int a(String string, int n2, int n3, boolean bl) {
            while (n2 < n3) {
                char c2 = string.charAt(n2);
                c2 = !(c2 < ' ' && c2 != '\t' || c2 >= '\u007f' || c2 <= '9' && '0' <= c2 || c2 <= 'z' && 'a' <= c2 || c2 <= 'Z' && 'A' <= c2 || c2 == ':') ? (char)'\u0000' : '\u0001';
                if (c2 == (bl ^ '\u0001')) {
                    return n2;
                }
                ++n2;
            }
            return n3;
        }

        private final boolean b(String string, String string2) {
            if (V2.k.a(string, string2)) {
                return true;
            }
            return b3.h.t(string, string2, false, 2, null) && string.charAt(string.length() - string2.length() - 1) == '.' && !n3.d.i(string);
        }

        private final String f(String string) {
            if (!b3.h.t(string, ".", false, 2, null)) {
                if ((string = n3.a.e(b3.h.e0(string, "."))) != null) {
                    return string;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        private final long g(String string, int n2, int n3) {
            int n4;
            int n5;
            int n6;
            int n7 = this.a(string, n2, n3, false);
            Matcher matcher = n.matcher((CharSequence)string);
            int n8 = -1;
            int n9 = n6 = (n5 = (n2 = (n4 = -1)));
            int n10 = n6;
            n6 = n2;
            n2 = n8;
            while (n7 < n3) {
                int n11;
                int n12;
                int n13;
                int n14;
                int n15;
                String string2;
                int n16 = this.a(string, n7 + 1, n3, true);
                matcher.region(n7, n16);
                if (n4 == -1 && matcher.usePattern(n).matches()) {
                    string2 = matcher.group(1);
                    V2.k.d(string2, "matcher.group(1)");
                    n15 = Integer.parseInt((String)string2);
                    string2 = matcher.group(2);
                    V2.k.d(string2, "matcher.group(2)");
                    n14 = Integer.parseInt((String)string2);
                    string2 = matcher.group(3);
                    V2.k.d(string2, "matcher.group(3)");
                    n13 = Integer.parseInt((String)string2);
                    n8 = n2;
                    n12 = n6;
                    n11 = n5;
                } else if (n6 == -1 && matcher.usePattern(m).matches()) {
                    string2 = matcher.group(1);
                    V2.k.d(string2, "matcher.group(1)");
                    n12 = Integer.parseInt((String)string2);
                    n8 = n2;
                    n15 = n4;
                    n11 = n5;
                    n14 = n10;
                    n13 = n9;
                } else if (n5 == -1 && matcher.usePattern(l).matches()) {
                    String string3 = matcher.group(1);
                    V2.k.d(string3, "matcher.group(1)");
                    string2 = Locale.US;
                    V2.k.d(string2, "US");
                    string3 = string3.toLowerCase((Locale)string2);
                    V2.k.d(string3, "this as java.lang.String).toLowerCase(locale)");
                    string2 = l.pattern();
                    V2.k.d(string2, "MONTH_PATTERN.pattern()");
                    n11 = b3.h.S(string2, string3, 0, false, 6, null) / 4;
                    n8 = n2;
                    n15 = n4;
                    n12 = n6;
                    n14 = n10;
                    n13 = n9;
                } else {
                    n8 = n2;
                    n15 = n4;
                    n12 = n6;
                    n11 = n5;
                    n14 = n10;
                    n13 = n9;
                    if (n2 == -1) {
                        n8 = n2;
                        n15 = n4;
                        n12 = n6;
                        n11 = n5;
                        n14 = n10;
                        n13 = n9;
                        if (matcher.usePattern(k).matches()) {
                            string2 = matcher.group(1);
                            V2.k.d(string2, "matcher.group(1)");
                            n8 = Integer.parseInt((String)string2);
                            n13 = n9;
                            n14 = n10;
                            n11 = n5;
                            n12 = n6;
                            n15 = n4;
                        }
                    }
                }
                n7 = this.a(string, n16 + 1, n3, false);
                n2 = n8;
                n4 = n15;
                n6 = n12;
                n5 = n11;
                n10 = n14;
                n9 = n13;
            }
            n3 = n2;
            if (70 <= n2) {
                n3 = n2;
                if (n2 < 100) {
                    n3 = n2 + 1900;
                }
            }
            n2 = n3;
            if (n3 >= 0) {
                n2 = n3;
                if (n3 < 70) {
                    n2 = n3 + 2000;
                }
            }
            if (n2 >= 1601) {
                if (n5 != -1) {
                    if (1 <= n6 && n6 < 32) {
                        if (n4 >= 0 && n4 < 24) {
                            if (n10 >= 0 && n10 < 60) {
                                if (n9 >= 0 && n9 < 60) {
                                    string = new GregorianCalendar(n3.d.f);
                                    string.setLenient(false);
                                    string.set(1, n2);
                                    string.set(2, n5 - 1);
                                    string.set(5, n6);
                                    string.set(11, n4);
                                    string.set(12, n10);
                                    string.set(13, n9);
                                    string.set(14, 0);
                                    return string.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.");
                            }
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        private final long h(String string) {
            long l2 = Long.MIN_VALUE;
            try {
                long l3 = Long.parseLong((String)string);
                if (l3 <= 0L) {
                    return Long.MIN_VALUE;
                }
                return l3;
            }
            catch (NumberFormatException numberFormatException) {
                if (new g("-?\\d+").a(string)) {
                    if (!b3.h.E(string, "-", false, 2, null)) {
                        l2 = Long.MAX_VALUE;
                    }
                    return l2;
                }
                throw numberFormatException;
            }
        }

        public final l c(t t2, String string) {
            V2.k.e(t2, "url");
            V2.k.e(string, "setCookie");
            return this.d(System.currentTimeMillis(), t2, string);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final l d(long l2, t object, String string) {
            boolean bl;
            V2.k.e(object, "url");
            V2.k.e(string, "setCookie");
            int n2 = n3.d.r(string, ';', 0, 0, 6, null);
            int n3 = n3.d.r(string, '=', 0, n2, 2, null);
            l l3 = null;
            if (n3 == n2) {
                return null;
            }
            String string2 = n3.d.X(string, 0, n3, 1, null);
            if (string2.length() == 0) {
                return null;
            }
            if (n3.d.y(string2) != -1) {
                return null;
            }
            String string3 = n3.d.W(string, n3 + 1, n2);
            if (n3.d.y(string3) != -1) {
                return null;
            }
            n3 = n2 + 1;
            n2 = string.length();
            Object object2 = null;
            Object object3 = null;
            boolean bl2 = false;
            boolean bl3 = bl = false;
            boolean bl4 = true;
            long l4 = -1L;
            long l5 = 253402300799999L;
            while (true) {
                boolean bl5;
                long l6;
                boolean bl6;
                boolean bl7;
                Object object4;
                long l7;
                Object object5;
                int n4;
                block27: {
                    block25: {
                        String string4;
                        block28: {
                            block26: {
                                block24: {
                                    if (n3 >= n2) break block25;
                                    n4 = n3.d.p(string, ';', n3, n2);
                                    int n5 = n3.d.p(string, '=', n3, n4);
                                    string4 = n3.d.W(string, n3, n5);
                                    object5 = n5 < n4 ? n3.d.W(string, n5 + 1, n4) : "";
                                    if (b3.h.u(string4, "expires", true)) {
                                        l5 = l7 = this.g((String)object5, 0, object5.length());
                                        break block24;
                                    }
                                    if (!b3.h.u(string4, "max-age", true)) break block26;
                                    try {
                                        l4 = l7 = this.h((String)object5);
                                    }
                                    catch (IllegalArgumentException | NumberFormatException throwable) {
                                        object5 = object2;
                                        object4 = object3;
                                        l7 = l4;
                                        bl7 = bl4;
                                        bl6 = bl;
                                        l6 = l5;
                                        bl5 = bl3;
                                    }
                                }
                                bl6 = true;
                                object5 = object2;
                                object4 = object3;
                                l7 = l4;
                                bl7 = bl4;
                                l6 = l5;
                                bl5 = bl3;
                                break block27;
                            }
                            if (b3.h.u(string4, "domain", true)) {
                                object5 = this.f((String)object5);
                                bl7 = false;
                                object4 = object3;
                                l7 = l4;
                                bl6 = bl;
                                l6 = l5;
                                bl5 = bl3;
                            }
                            if (!b3.h.u(string4, "path", true)) break block28;
                            object4 = object5;
                            object5 = object2;
                            l7 = l4;
                            bl7 = bl4;
                            bl6 = bl;
                            l6 = l5;
                            bl5 = bl3;
                            break block27;
                        }
                        if (b3.h.u(string4, "secure", true)) {
                            bl5 = true;
                            object5 = object2;
                            object4 = object3;
                            l7 = l4;
                            bl7 = bl4;
                            bl6 = bl;
                            l6 = l5;
                            break block27;
                        } else {
                            object5 = object2;
                            object4 = object3;
                            l7 = l4;
                            bl7 = bl4;
                            bl6 = bl;
                            l6 = l5;
                            bl5 = bl3;
                            if (b3.h.u(string4, "httponly", true)) {
                                bl2 = true;
                                bl5 = bl3;
                                l6 = l5;
                                bl6 = bl;
                                bl7 = bl4;
                                l7 = l4;
                                object4 = object3;
                                object5 = object2;
                            }
                        }
                        break block27;
                    }
                    if (l4 == Long.MIN_VALUE) {
                        l2 = Long.MIN_VALUE;
                    } else if (l4 != -1L) {
                        l5 = l4 <= 9223372036854775L ? l4 * (long)1000 : Long.MAX_VALUE;
                        l2 = (l5 = l2 + l5) >= l2 && l5 <= 253402300799999L ? l5 : 253402300799999L;
                    } else {
                        l2 = l5;
                    }
                    object5 = ((t)object).h();
                    if (object2 == null) {
                        string = object5;
                    } else {
                        string = object2;
                        if (!this.b((String)object5, (String)object2)) {
                            return l3;
                        }
                    }
                    if (object5.length() != string.length() && PublicSuffixDatabase.e.c().c(string) == null) {
                        return l3;
                    }
                    object5 = "/";
                    if (object3 != null) {
                        object2 = object3;
                        if (b3.h.E((String)object3, "/", false, 2, l3)) return new l(string2, string3, l2, string, (String)object2, bl3, bl2, bl, bl4, null);
                    }
                    object3 = ((t)object).d();
                    n3 = b3.h.W((CharSequence)object3, '/', 0, false, 6, null);
                    object = object5;
                    if (n3 != 0) {
                        object = object3.substring(0, n3);
                        V2.k.d(object, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    }
                    object2 = object;
                    return new l(string2, string3, l2, string, (String)object2, bl3, bl2, bl, bl4, null);
                }
                n3 = n4 + 1;
                object2 = object5;
                object3 = object4;
                l4 = l7;
                bl4 = bl7;
                bl = bl6;
                l5 = l6;
                bl3 = bl5;
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        public final List e(t t2, s s2) {
            V2.k.e(t2, "url");
            V2.k.e(s2, "headers");
            List list = s2.j("Set-Cookie");
            int n2 = list.size();
            s s3 = null;
            for (int i2 = 0; i2 < n2; ++i2) {
                l l2 = this.c(t2, (String)list.get(i2));
                if (l2 == null) {
                    s2 = s3;
                } else {
                    s2 = s3;
                    if (s3 == null) {
                        s2 = new ArrayList();
                    }
                    s2.add(l2);
                }
                s3 = s2;
            }
            if (s3 != null) {
                t2 = Collections.unmodifiableList(s3);
                V2.k.d(t2, "{\n        Collections.un\u2026ableList(cookies)\n      }");
                return t2;
            }
            return o.g();
        }
    }
}

