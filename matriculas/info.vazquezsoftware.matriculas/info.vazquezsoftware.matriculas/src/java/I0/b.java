/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package I0;

import I0.g;

final class b
extends g {
    private final g.a a;
    private final long b;

    b(g.a a2, long l2) {
        if (a2 != null) {
            this.a = a2;
            this.b = l2;
            return;
        }
        throw new NullPointerException("Null status");
    }

    @Override
    public long b() {
        return this.b;
    }

    @Override
    public g.a c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof g && this.a.equals((Object)((g)(object = (g)object)).c()) && this.b == ((g)object).b();
    }

    public int hashCode() {
        int n2 = this.a.hashCode();
        long l2 = this.b;
        return (n2 ^ 0xF4243) * 1000003 ^ (int)(l2 ^ l2 >>> 32);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BackendResponse{status=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", nextRequestWaitMillis=");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

