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
import V2.h;
import V2.k;
import V2.t;
import Z2.a;
import Z2.d;

public abstract class i
extends c
implements h,
d {
    private final int n;
    private final int o;

    public i(int n3, Object object, Class clazz, String string, String string2, int n4) {
        boolean bl = (n4 & 1) == 1;
        super(object, clazz, string, string2, bl);
        this.n = n3;
        this.o = n4 >> 1;
    }

    @Override
    protected a c() {
        return t.a(this);
    }

    @Override
    public int d() {
        return this.n;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof i) {
            object = (i)object;
            return this.f().equals((Object)((c)object).f()) && this.k().equals((Object)((c)object).k()) && this.o == ((i)object).o && this.n == ((i)object).n && k.a(this.e(), ((c)object).e()) && k.a(this.i(), ((c)object).i());
        }
        if (object instanceof d) {
            return object.equals((Object)this.b());
        }
        return false;
    }

    public int hashCode() {
        int n3 = this.i() == null ? 0 : this.i().hashCode() * 31;
        return (n3 + this.f().hashCode()) * 31 + this.k().hashCode();
    }

    public String toString() {
        a a3 = this.b();
        if (a3 != this) {
            return a3.toString();
        }
        if ("<init>".equals((Object)this.f())) {
            return "constructor (Kotlin reflection is not available)";
        }
        a3 = new StringBuilder();
        a3.append("function ");
        a3.append(this.f());
        a3.append(" (Kotlin reflection is not available)");
        return a3.toString();
    }
}

