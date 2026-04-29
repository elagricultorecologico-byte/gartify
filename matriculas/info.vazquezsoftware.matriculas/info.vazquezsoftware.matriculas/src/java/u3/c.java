/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package u3;

import V2.g;
import V2.k;
import z3.e;

public final class c {
    public static final a d = new a(null);
    public static final e e;
    public static final e f;
    public static final e g;
    public static final e h;
    public static final e i;
    public static final e j;
    public final e a;
    public final e b;
    public final int c;

    static {
        e.a a2 = z3.e.j;
        e = a2.c(":");
        f = a2.c(":status");
        g = a2.c(":method");
        h = a2.c(":path");
        i = a2.c(":scheme");
        j = a2.c(":authority");
    }

    public c(String string, String string2) {
        k.e(string, "name");
        k.e(string2, "value");
        e.a a2 = z3.e.j;
        this(a2.c(string), a2.c(string2));
    }

    public c(e e2, String string) {
        k.e(e2, "name");
        k.e(string, "value");
        this(e2, z3.e.j.c(string));
    }

    public c(e e2, e e3) {
        k.e(e2, "name");
        k.e(e3, "value");
        this.a = e2;
        this.b = e3;
        this.c = e2.u() + 32 + e3.u();
    }

    public final e a() {
        return this.a;
    }

    public final e b() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        object = (c)object;
        if (!k.a(this.a, ((c)object).a)) {
            return false;
        }
        return k.a(this.b, ((c)object).b);
    }

    public int hashCode() {
        return this.a.hashCode() * 31 + this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.x());
        stringBuilder.append(": ");
        stringBuilder.append(this.b.x());
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }
}

