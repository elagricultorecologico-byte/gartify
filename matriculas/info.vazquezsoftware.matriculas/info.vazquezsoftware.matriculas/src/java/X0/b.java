/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package x0;

public class b {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    public b(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.a = bl;
        this.b = bl2;
        this.c = bl3;
        this.d = bl4;
    }

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        object = (b)object;
        return this.a == ((b)object).a && this.b == ((b)object).b && this.c == ((b)object).c && this.d == ((b)object).d;
    }

    public int hashCode() {
        int n2;
        int n3 = n2 = this.a;
        if (this.b) {
            n3 = n2 + 16;
        }
        n2 = n3;
        if (this.c) {
            n2 = n3 + 256;
        }
        n3 = n2;
        if (this.d) {
            n3 = n2 + 4096;
        }
        return n3;
    }

    public String toString() {
        return String.format((String)"[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", (Object[])new Object[]{this.a, this.b, this.c, this.d});
    }
}

