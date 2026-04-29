/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package w1;

import v1.a;
import x1.m;

public final class b {
    private final int a;
    private final a b;
    private final a.d c;
    private final String d;

    private b(a a2, a.d d2, String string) {
        this.b = a2;
        this.c = d2;
        this.d = string;
        this.a = m.b(a2, d2, string);
    }

    public static b a(a a2, a.d d2, String string) {
        return new b(a2, d2, string);
    }

    public final String b() {
        return this.b.b();
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        object = (b)object;
        return m.a(this.b, ((b)object).b) && m.a(this.c, ((b)object).c) && m.a(this.d, ((b)object).d);
    }

    public final int hashCode() {
        return this.a;
    }
}

