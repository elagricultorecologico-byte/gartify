/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package G3;

abstract class i {
    j a;

    private i() {
    }

    static void n(StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    final c a() {
        return (c)this;
    }

    final d b() {
        return (d)this;
    }

    final e c() {
        return (e)this;
    }

    final g d() {
        return (g)this;
    }

    final h e() {
        return (h)this;
    }

    final boolean f() {
        return this instanceof b;
    }

    final boolean g() {
        return this.a == j.k;
    }

    final boolean h() {
        return this.a == j.j;
    }

    final boolean i() {
        return this.a == j.g;
    }

    final boolean j() {
        return this.a == j.l;
    }

    final boolean k() {
        return this.a == j.i;
    }

    final boolean l() {
        return this.a == j.h;
    }

    abstract i m();

    String o() {
        return this.getClass().getSimpleName();
    }

    static final class b
    extends c {
        b(String string) {
            this.p(string);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<![CDATA[");
            stringBuilder.append(this.q());
            stringBuilder.append("]]>");
            return stringBuilder.toString();
        }
    }

    static class c
    extends i {
        private String b;

        c() {
            this.a = j.k;
        }

        @Override
        i m() {
            this.b = null;
            return this;
        }

        c p(String string) {
            this.b = string;
            return this;
        }

        String q() {
            return this.b;
        }

        public String toString() {
            return this.q();
        }
    }

    static final class d
    extends i {
        private final StringBuilder b = new StringBuilder();
        private String c;
        boolean d = false;

        d() {
            this.a = j.j;
        }

        private void r() {
            String string = this.c;
            if (string != null) {
                this.b.append(string);
                this.c = null;
            }
        }

        @Override
        i m() {
            i.n(this.b);
            this.c = null;
            this.d = false;
            return this;
        }

        final d p(char c2) {
            this.r();
            this.b.append(c2);
            return this;
        }

        final d q(String string) {
            this.r();
            if (this.b.length() == 0) {
                this.c = string;
                return this;
            }
            this.b.append(string);
            return this;
        }

        String s() {
            String string = this.c;
            if (string != null) {
                return string;
            }
            return this.b.toString();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!--");
            stringBuilder.append(this.s());
            stringBuilder.append("-->");
            return stringBuilder.toString();
        }
    }

    static final class e
    extends i {
        final StringBuilder b = new StringBuilder();
        String c = null;
        final StringBuilder d = new StringBuilder();
        final StringBuilder e = new StringBuilder();
        boolean f = false;

        e() {
            this.a = j.g;
        }

        @Override
        i m() {
            i.n(this.b);
            this.c = null;
            i.n(this.d);
            i.n(this.e);
            this.f = false;
            return this;
        }

        String p() {
            return this.b.toString();
        }

        String q() {
            return this.c;
        }

        String r() {
            return this.d.toString();
        }

        public String s() {
            return this.e.toString();
        }

        public boolean t() {
            return this.f;
        }
    }

    static final class f
    extends i {
        f() {
            this.a = j.l;
        }

        @Override
        i m() {
            return this;
        }

        public String toString() {
            return "";
        }
    }

    static final class g
    extends i {
        g() {
            this.a = j.i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("</");
            stringBuilder.append(this.H());
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    static final class h
    extends i {
        h() {
            this.a = j.h;
        }

        @Override
        i F() {
            super.F();
            this.j = null;
            return this;
        }

        h I(String string, F3.b b2) {
            this.b = string;
            this.j = b2;
            this.c = E3.b.a(string);
            return this;
        }

        public String toString() {
            if (this.z() && this.j.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<");
                stringBuilder.append(this.H());
                stringBuilder.append(" ");
                stringBuilder.append(this.j.toString());
                stringBuilder.append(">");
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<");
            stringBuilder.append(this.H());
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    static abstract class i
    extends i {
        protected String b;
        protected String c;
        private String d;
        private StringBuilder e = new StringBuilder();
        private String f;
        private boolean g = false;
        private boolean h = false;
        boolean i = false;
        F3.b j;

        i() {
        }

        private void w() {
            this.h = true;
            String string = this.f;
            if (string != null) {
                this.e.append(string);
                this.f = null;
            }
        }

        final boolean A() {
            return this.i;
        }

        final i B(String string) {
            this.b = string;
            this.c = E3.b.a(string);
            return this;
        }

        final String C() {
            String string = this.b;
            boolean bl = string == null || string.length() == 0;
            D3.e.b(bl);
            return this.b;
        }

        final void D() {
            String string;
            if (this.j == null) {
                this.j = new F3.b();
            }
            if ((string = this.d) != null) {
                this.d = string = string.trim();
                if (string.length() > 0) {
                    string = this.h ? (this.e.length() > 0 ? this.e.toString() : this.f) : (this.g ? "" : null);
                    this.j.k(this.d, string);
                }
            }
            this.d = null;
            this.g = false;
            this.h = false;
            G3.i.n(this.e);
            this.f = null;
        }

        final String E() {
            return this.c;
        }

        i F() {
            this.b = null;
            this.c = null;
            this.d = null;
            G3.i.n(this.e);
            this.f = null;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = null;
            return this;
        }

        final void G() {
            this.g = true;
        }

        final String H() {
            String string = this.b;
            if (string != null) {
                return string;
            }
            return "[unset]";
        }

        final void p(char c2) {
            this.q(String.valueOf((char)c2));
        }

        final void q(String string) {
            String string2 = this.d;
            if (string2 != null) {
                string = string2.concat(string);
            }
            this.d = string;
        }

        final void r(char c2) {
            this.w();
            this.e.append(c2);
        }

        final void s(String string) {
            this.w();
            if (this.e.length() == 0) {
                this.f = string;
                return;
            }
            this.e.append(string);
        }

        final void t(int[] nArray) {
            this.w();
            for (int n2 : nArray) {
                this.e.appendCodePoint(n2);
            }
        }

        final void u(char c2) {
            this.v(String.valueOf((char)c2));
        }

        final void v(String string) {
            String string2 = this.b;
            if (string2 != null) {
                string = string2.concat(string);
            }
            this.b = string;
            this.c = E3.b.a(string);
        }

        final void x() {
            if (this.d != null) {
                this.D();
            }
        }

        final boolean y(String string) {
            F3.b b2 = this.j;
            return b2 != null && b2.u(string);
        }

        final boolean z() {
            return this.j != null;
        }
    }

    public static final class j
    extends Enum {
        public static final /* enum */ j g;
        public static final /* enum */ j h;
        public static final /* enum */ j i;
        public static final /* enum */ j j;
        public static final /* enum */ j k;
        public static final /* enum */ j l;
        private static final j[] m;

        static {
            j j2;
            j j3;
            j j4;
            j j5;
            j j6;
            j j7;
            g = j7 = new j("Doctype", 0);
            h = j6 = new j("StartTag", 1);
            i = j5 = new j("EndTag", 2);
            j = j4 = new j("Comment", 3);
            k = j3 = new j("Character", 4);
            l = j2 = new j("EOF", 5);
            m = new j[]{j7, j6, j5, j4, j3, j2};
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private j() {
            void var2_-1;
            void var1_-1;
        }

        public static j valueOf(String string) {
            return (j)Enum.valueOf(j.class, (String)string);
        }

        public static j[] values() {
            return (j[])m.clone();
        }
    }
}

