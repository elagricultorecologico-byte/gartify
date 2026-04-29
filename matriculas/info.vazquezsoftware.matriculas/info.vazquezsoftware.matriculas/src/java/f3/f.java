/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetEncoder
 */
package F3;

import D3.c;
import D3.e;
import F3.h;
import F3.i;
import F3.m;
import F3.q;
import G3.g;
import H3.d;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class f
extends h {
    private static final d w = new d.J("title");
    private C3.a q;
    private a r = new a();
    private g s;
    private b t = b.g;
    private final String u;
    private boolean v = false;

    public f(String string) {
        super(G3.h.r("#root", G3.f.c), string);
        this.u = string;
        this.s = G3.g.b();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void O0() {
        if (!this.v) return;
        a.a a2 = this.R0().o();
        if (a2 == a.a.g) {
            h h2 = this.D0("meta[charset]");
            if (h2 != null) {
                h2.Z("charset", this.K0().displayName());
            } else {
                this.P0().W("meta").Z("charset", this.K0().displayName());
            }
            this.C0("meta[name=charset]").i();
            return;
        }
        if (a2 != a.a.h) return;
        m m2 = (m)this.r().get(0);
        if (m2 instanceof q) {
            q q2 = (q)m2;
            if (q2.Y().equals((Object)"xml")) {
                q2.c("encoding", this.K0().displayName());
                if (!q2.s("version")) return;
                q2.c("version", "1.0");
                return;
            }
            q q3 = new q("xml", false);
            q3.c("version", "1.0");
            q3.c("encoding", this.K0().displayName());
            this.w0(q3);
            return;
        }
        q q4 = new q("xml", false);
        q4.c("version", "1.0");
        q4.c("encoding", this.K0().displayName());
        this.w0(q4);
    }

    private h Q0() {
        for (h h2 : this.c0()) {
            if (!h2.s0().equals((Object)"html")) continue;
            return h2;
        }
        return this.W("html");
    }

    public h J0() {
        h h2 = this.Q0();
        for (h h3 : h2.c0()) {
            if (!"body".equals((Object)h3.s0()) && !"frameset".equals((Object)h3.s0())) continue;
            return h3;
        }
        return h2.W("body");
    }

    public Charset K0() {
        return this.r.c();
    }

    public void L0(Charset charset) {
        this.W0(true);
        this.r.b(charset);
        this.O0();
    }

    public f M0() {
        f f2 = (f)super.e0();
        f2.r = this.r.d();
        return f2;
    }

    public f N0(C3.a a2) {
        e.j(a2);
        this.q = a2;
        return this;
    }

    public h P0() {
        h h2 = this.Q0();
        for (h h3 : h2.c0()) {
            if (!h3.s0().equals((Object)"head")) continue;
            return h3;
        }
        return h2.x0("head");
    }

    public a R0() {
        return this.r;
    }

    public f S0(g g2) {
        this.s = g2;
        return this;
    }

    public g T0() {
        return this.s;
    }

    public b U0() {
        return this.t;
    }

    public f V0(b b2) {
        this.t = b2;
        return this;
    }

    public void W0(boolean bl) {
        this.v = bl;
    }

    @Override
    public String x() {
        return "#document";
    }

    @Override
    public String z() {
        return super.m0();
    }

    public static class F3.f$a
    implements Cloneable {
        private i.c g = i.c.l;
        private Charset h = c.b;
        private final ThreadLocal i = new ThreadLocal();
        i.b j;
        private boolean k = true;
        private boolean l = false;
        private int m = 1;
        private a n = a.g;

        public F3.f$a a(String string) {
            this.b(Charset.forName((String)string));
            return this;
        }

        public F3.f$a b(Charset charset) {
            this.h = charset;
            return this;
        }

        public Charset c() {
            return this.h;
        }

        public F3.f$a d() {
            F3.f$a a2;
            try {
                a2 = (F3.f$a)super.clone();
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                throw new RuntimeException((Throwable)cloneNotSupportedException);
            }
            a2.a(this.h.name());
            a2.g = i.c.valueOf(this.g.name());
            return a2;
        }

        CharsetEncoder e() {
            CharsetEncoder charsetEncoder = (CharsetEncoder)this.i.get();
            if (charsetEncoder != null) {
                return charsetEncoder;
            }
            return this.l();
        }

        public F3.f$a g(i.c c2) {
            this.g = c2;
            return this;
        }

        public i.c h() {
            return this.g;
        }

        public int i() {
            return this.m;
        }

        public boolean k() {
            return this.l;
        }

        CharsetEncoder l() {
            CharsetEncoder charsetEncoder = this.h.newEncoder();
            this.i.set((Object)charsetEncoder);
            this.j = i.b.d(charsetEncoder.charset().name());
            return charsetEncoder;
        }

        public F3.f$a m(boolean bl) {
            this.k = bl;
            return this;
        }

        public boolean n() {
            return this.k;
        }

        public a o() {
            return this.n;
        }

        public F3.f$a q(a a2) {
            this.n = a2;
            return this;
        }

        public static final class a
        extends Enum {
            public static final /* enum */ a g;
            public static final /* enum */ a h;
            private static final a[] i;

            static {
                a a2;
                a a3;
                g = a3 = new a("html", 0);
                h = a2 = new a("xml", 1);
                i = new a[]{a3, a2};
            }

            /*
             * WARNING - Possible parameter corruption
             * WARNING - void declaration
             */
            private a() {
                void var2_-1;
                void var1_-1;
            }

            public static a valueOf(String string) {
                return (a)Enum.valueOf(a.class, (String)string);
            }

            public static a[] values() {
                return (a[])i.clone();
            }
        }
    }

    public static final class b
    extends Enum {
        public static final /* enum */ b g;
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        private static final b[] j;

        static {
            b b2;
            b b3;
            b b4;
            g = b4 = new b("noQuirks", 0);
            h = b3 = new b("quirks", 1);
            i = b2 = new b("limitedQuirks", 2);
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

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])j.clone();
        }
    }
}

