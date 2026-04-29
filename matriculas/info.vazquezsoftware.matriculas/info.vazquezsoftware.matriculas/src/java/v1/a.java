/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package v1;

import x1.n;

public final class a {
    private final a a;
    private final g b;
    private final String c;

    public a(String string, a a2, g g2) {
        n.j(a2, "Cannot construct an Api with a null ClientBuilder");
        n.j(g2, "Cannot construct an Api with a null ClientKey");
        this.c = string;
        this.a = a2;
        this.b = g2;
    }

    public final a a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public static abstract class c {
    }

    public static final class g
    extends c {
    }
}

