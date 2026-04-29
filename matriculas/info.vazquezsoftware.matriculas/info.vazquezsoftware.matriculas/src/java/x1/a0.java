/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  java.lang.Object
 *  java.lang.String
 */
package x1;

import android.content.ComponentName;
import x1.m;
import x1.n;

public final class a0 {
    private final String a;
    private final String b;
    private final ComponentName c;
    private final int d;
    private final boolean e;

    public a0(String string, String string2, int n2, boolean bl) {
        n.f(string);
        this.a = string;
        n.f(string2);
        this.b = string2;
        this.c = null;
        this.d = 4225;
        this.e = bl;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final ComponentName c() {
        return this.c;
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof a0)) {
            return false;
        }
        object = (a0)object;
        return m.a(this.a, ((a0)object).a) && m.a(this.b, ((a0)object).b) && m.a(this.c, ((a0)object).c) && this.e == ((a0)object).e;
    }

    public final int hashCode() {
        return m.b(this.a, this.b, this.c, 4225, this.e);
    }

    public final String toString() {
        String string;
        String string2 = string = this.a;
        if (string == null) {
            string2 = this.c;
            n.i(string2);
            string2 = string2.flattenToString();
        }
        return string2;
    }
}

