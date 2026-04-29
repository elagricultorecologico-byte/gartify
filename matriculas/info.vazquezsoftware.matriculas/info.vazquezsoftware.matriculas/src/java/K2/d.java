/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package k2;

import k2.h;

public class d {
    private final boolean a;
    private final String b;
    private final k2.a c;
    private final String d;

    /* synthetic */ d(a a2, h h2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
    }

    public k2.a a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public boolean c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public static final class a {
        private boolean a;
        private String b;
        private k2.a c;
        private String d;

        public d a() {
            return new d(this, null);
        }

        public a b(k2.a a2) {
            this.c = a2;
            return this;
        }

        public a c(boolean bl) {
            this.a = bl;
            return this;
        }
    }
}

