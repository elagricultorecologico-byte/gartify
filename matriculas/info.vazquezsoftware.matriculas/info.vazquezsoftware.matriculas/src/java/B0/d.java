/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package B0;

public class d {
    public String a;
    public Long b;

    public d(String string, long l2) {
        this.a = string;
        this.b = l2;
    }

    public d(String string, boolean bl) {
        long l2 = bl ? 1L : 0L;
        this(string, l2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof d)) {
            return false;
        }
        d d2 = (d)object;
        if (!this.a.equals((Object)d2.a)) {
            return false;
        }
        object = this.b;
        d2 = d2.b;
        if (object != null) {
            return object.equals((Object)d2);
        }
        return d2 == null;
    }

    public int hashCode() {
        int n2 = this.a.hashCode();
        Long l2 = this.b;
        int n3 = l2 != null ? l2.hashCode() : 0;
        return n2 * 31 + n3;
    }
}

