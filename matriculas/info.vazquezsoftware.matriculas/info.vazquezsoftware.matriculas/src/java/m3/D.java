/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 */
package m3;

import V2.g;
import V2.k;
import b3.h;
import java.util.concurrent.TimeUnit;
import m3.s;

public final class d {
    public static final b n = new b(null);
    public static final d o = new a().d().a();
    public static final d p = new a().e().c(Integer.MAX_VALUE, TimeUnit.SECONDS).a();
    private final boolean a;
    private final boolean b;
    private final int c;
    private final int d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private String m;

    private d(boolean bl, boolean bl2, int n2, int n3, boolean bl3, boolean bl4, boolean bl5, int n4, int n5, boolean bl6, boolean bl7, boolean bl8, String string) {
        this.a = bl;
        this.b = bl2;
        this.c = n2;
        this.d = n3;
        this.e = bl3;
        this.f = bl4;
        this.g = bl5;
        this.h = n4;
        this.i = n5;
        this.j = bl6;
        this.k = bl7;
        this.l = bl8;
        this.m = string;
    }

    public /* synthetic */ d(boolean bl, boolean bl2, int n2, int n3, boolean bl3, boolean bl4, boolean bl5, int n4, int n5, boolean bl6, boolean bl7, boolean bl8, String string, g g2) {
        this(bl, bl2, n2, n3, bl3, bl4, bl5, n4, n5, bl6, bl7, bl8, string);
    }

    public final boolean a() {
        return this.l;
    }

    public final boolean b() {
        return this.e;
    }

    public final boolean c() {
        return this.f;
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.h;
    }

    public final int f() {
        return this.i;
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.a;
    }

    public final boolean i() {
        return this.b;
    }

    public final boolean j() {
        return this.k;
    }

    public final boolean k() {
        return this.j;
    }

    public final int l() {
        return this.d;
    }

    public String toString() {
        String string;
        String string2 = string = this.m;
        if (string == null) {
            string2 = new StringBuilder();
            if (this.h()) {
                string2.append("no-cache, ");
            }
            if (this.i()) {
                string2.append("no-store, ");
            }
            if (this.d() != -1) {
                string2.append("max-age=");
                string2.append(this.d());
                string2.append(", ");
            }
            if (this.l() != -1) {
                string2.append("s-maxage=");
                string2.append(this.l());
                string2.append(", ");
            }
            if (this.b()) {
                string2.append("private, ");
            }
            if (this.c()) {
                string2.append("public, ");
            }
            if (this.g()) {
                string2.append("must-revalidate, ");
            }
            if (this.e() != -1) {
                string2.append("max-stale=");
                string2.append(this.e());
                string2.append(", ");
            }
            if (this.f() != -1) {
                string2.append("min-fresh=");
                string2.append(this.f());
                string2.append(", ");
            }
            if (this.k()) {
                string2.append("only-if-cached, ");
            }
            if (this.j()) {
                string2.append("no-transform, ");
            }
            if (this.a()) {
                string2.append("immutable, ");
            }
            if (string2.length() == 0) {
                return "";
            }
            string2.delete(string2.length() - 2, string2.length());
            string2 = string2.toString();
            V2.k.d(string2, "StringBuilder().apply(builderAction).toString()");
            this.m = string2;
        }
        return string2;
    }

    public static final class a {
        private boolean a;
        private boolean b;
        private int c = -1;
        private int d = -1;
        private int e = -1;
        private boolean f;
        private boolean g;
        private boolean h;

        private final int b(long l2) {
            if (l2 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)l2;
        }

        public final d a() {
            return new d(this.a, this.b, this.c, -1, false, false, false, this.d, this.e, this.f, this.g, this.h, null, null);
        }

        public final a c(int n2, TimeUnit timeUnit) {
            V2.k.e(timeUnit, "timeUnit");
            if (n2 >= 0) {
                this.d = this.b(timeUnit.toSeconds((long)n2));
                return this;
            }
            throw new IllegalArgumentException(V2.k.j("maxStale < 0: ", n2).toString());
        }

        public final a d() {
            this.a = true;
            return this;
        }

        public final a e() {
            this.f = true;
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        private final int a(String string, String string2, int n2) {
            int n3 = string.length();
            while (n2 < n3) {
                if (b3.h.I(string2, string.charAt(n2), false, 2, null)) {
                    return n2;
                }
                ++n2;
            }
            return string.length();
        }

        /*
         * Enabled aggressive block sorting
         */
        public final d b(s s2) {
            V2.k.e(s2, "headers");
            int n2 = s2.size();
            boolean bl = true;
            boolean bl2 = true;
            int n3 = 0;
            String string = null;
            boolean bl3 = false;
            boolean bl4 = false;
            int n4 = -1;
            int n5 = -1;
            boolean bl5 = false;
            boolean bl6 = false;
            boolean bl7 = false;
            int n6 = -1;
            int n7 = -1;
            boolean bl8 = false;
            boolean bl9 = false;
            boolean bl10 = false;
            while (true) {
                boolean bl11;
                boolean bl12;
                boolean bl13;
                int n8;
                int n9;
                boolean bl14;
                boolean bl15;
                boolean bl16;
                int n10;
                int n11;
                boolean bl17;
                boolean bl18;
                String string2;
                boolean bl19;
                boolean bl20;
                block28: {
                    String string3;
                    String string4;
                    block27: {
                        block24: {
                            block26: {
                                block25: {
                                    if (n3 >= n2) break block24;
                                    string4 = s2.f(n3);
                                    string3 = s2.i(n3);
                                    if (!b3.h.u(string4, "Cache-Control", bl)) break block25;
                                    if (string != null) break block26;
                                    string4 = string3;
                                    break block27;
                                }
                                bl20 = bl;
                                bl19 = bl2;
                                string2 = string;
                                bl18 = bl3;
                                bl17 = bl4;
                                n11 = n4;
                                n10 = n5;
                                bl16 = bl5;
                                bl15 = bl6;
                                bl14 = bl7;
                                n9 = n6;
                                n8 = n7;
                                bl13 = bl8;
                                bl12 = bl9;
                                bl11 = bl10;
                                if (!b3.h.u(string4, "Pragma", bl)) break block28;
                            }
                            bl2 = false;
                            string4 = string;
                            break block27;
                        }
                        if (!bl2) {
                            string = null;
                        }
                        return new d(bl3, bl4, n4, n5, bl5, bl6, bl7, n6, n7, bl8, bl9, bl10, string, null);
                    }
                    int n12 = 0;
                    string = string3;
                    while (true) {
                        bl20 = bl;
                        bl19 = bl2;
                        string2 = string4;
                        bl18 = bl3;
                        bl17 = bl4;
                        n11 = n4;
                        n10 = n5;
                        bl16 = bl5;
                        bl15 = bl6;
                        bl14 = bl7;
                        n9 = n6;
                        n8 = n7;
                        bl13 = bl8;
                        bl12 = bl9;
                        bl11 = bl10;
                        if (n12 >= string.length()) break;
                        n11 = this.a(string, "=,;", n12);
                        string3 = string.substring(n12, n11);
                        V2.k.d(string3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        string2 = b3.h.t0(string3).toString();
                        if (n11 != string.length() && string.charAt(n11) != ',' && string.charAt(n11) != ';') {
                            if ((n11 = n3.d.D(string, n11 + 1)) < string.length() && string.charAt(n11) == '\"') {
                                n12 = n11 + 1;
                                n11 = b3.h.R(string, '\"', n12, false, 4, null);
                                string3 = string.substring(n12, n11);
                                V2.k.d(string3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                n12 = n11 + 1;
                            } else {
                                n12 = this.a(string, ",;", n11);
                                string3 = string.substring(n11, n12);
                                V2.k.d(string3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                string3 = b3.h.t0(string3).toString();
                            }
                        } else {
                            n12 = n11 + 1;
                            string3 = null;
                        }
                        if (b3.h.u("no-cache", string2, bl)) {
                            bl = bl3 = bl;
                            continue;
                        }
                        if (b3.h.u("no-store", string2, bl)) {
                            bl = bl4 = bl;
                            continue;
                        }
                        if (b3.h.u("max-age", string2, bl)) {
                            n9 = n3.d.V(string3, -1);
                            n8 = n7;
                            n10 = n6;
                            n11 = n5;
                        } else if (b3.h.u("s-maxage", string2, bl)) {
                            n11 = n3.d.V(string3, -1);
                            n9 = n4;
                            n10 = n6;
                            n8 = n7;
                        } else {
                            if (b3.h.u("private", string2, bl)) {
                                bl = bl5 = bl;
                                continue;
                            }
                            if (b3.h.u("public", string2, bl)) {
                                bl = bl6 = bl;
                                continue;
                            }
                            if (b3.h.u("must-revalidate", string2, bl)) {
                                bl = bl7 = bl;
                                continue;
                            }
                            if (b3.h.u("max-stale", string2, bl)) {
                                n10 = n3.d.V(string3, Integer.MAX_VALUE);
                                n9 = n4;
                                n11 = n5;
                                n8 = n7;
                            } else if (b3.h.u("min-fresh", string2, bl)) {
                                n8 = n3.d.V(string3, -1);
                                n9 = n4;
                                n11 = n5;
                                n10 = n6;
                            } else {
                                if (b3.h.u("only-if-cached", string2, bl)) {
                                    bl = bl8 = bl;
                                    continue;
                                }
                                if (b3.h.u("no-transform", string2, bl)) {
                                    bl = bl9 = bl;
                                    continue;
                                }
                                n9 = n4;
                                n11 = n5;
                                n10 = n6;
                                n8 = n7;
                                if (b3.h.u("immutable", string2, bl)) {
                                    bl = bl10 = bl;
                                    continue;
                                }
                            }
                        }
                        n4 = n9;
                        n5 = n11;
                        n6 = n10;
                        n7 = n8;
                    }
                }
                ++n3;
                bl = bl20;
                bl2 = bl19;
                string = string2;
                bl3 = bl18;
                bl4 = bl17;
                n4 = n11;
                n5 = n10;
                bl5 = bl16;
                bl6 = bl15;
                bl7 = bl14;
                n6 = n9;
                n7 = n8;
                bl8 = bl13;
                bl9 = bl12;
                bl10 = bl11;
            }
        }
    }
}

