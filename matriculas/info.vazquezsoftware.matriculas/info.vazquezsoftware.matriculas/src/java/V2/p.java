/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package V2;

import V2.c;
import V2.k;
import Z2.a;
import Z2.f;

public abstract class p
extends c
implements f {
    private final boolean n;

    public p(Object object, Class clazz, String string, String string2, int n3) {
        boolean bl = false;
        boolean bl2 = (n3 & 1) == 1;
        super(object, clazz, string, string2, bl2);
        bl2 = bl;
        if ((n3 & 2) == 2) {
            bl2 = true;
        }
        this.n = bl2;
    }

    @Override
    public a b() {
        if (this.n) {
            return this;
        }
        return super.b();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof p) {
            object = (p)object;
            return this.i().equals(((c)object).i()) && this.f().equals((Object)((c)object).f()) && this.k().equals((Object)((c)object).k()) && k.a(this.e(), ((c)object).e());
        }
        if (object instanceof f) {
            return object.equals((Object)this.b());
        }
        return false;
    }

    public int hashCode() {
        return (this.i().hashCode() * 31 + this.f().hashCode()) * 31 + this.k().hashCode();
    }

    public String toString() {
        a a3 = this.b();
        if (a3 != this) {
            return a3.toString();
        }
        a3 = new StringBuilder();
        a3.append("property ");
        a3.append(this.f());
        a3.append(" (Kotlin reflection is not available)");
        return a3.toString();
    }
}

