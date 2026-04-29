/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package B0;

public class g {
    public final String a;
    public final int b;

    public g(String string, int n2) {
        this.a = string;
        this.b = n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof g)) {
            return false;
        }
        object = (g)object;
        if (this.b != ((g)object).b) {
            return false;
        }
        return this.a.equals((Object)((g)object).a);
    }

    public int hashCode() {
        return this.a.hashCode() * 31 + this.b;
    }
}

