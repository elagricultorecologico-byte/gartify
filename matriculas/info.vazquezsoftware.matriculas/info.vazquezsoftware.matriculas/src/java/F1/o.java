/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f1;

import f1.y;

final class o
extends y {
    private final int a;
    private final int b;
    private final double c;
    private final boolean d;

    o(int n2, int n3, double d2, boolean bl) {
        this.a = n2;
        this.b = n3;
        this.c = d2;
        this.d = bl;
    }

    @Override
    public final int a() {
        return this.a;
    }

    @Override
    public final int b() {
        return this.b;
    }

    @Override
    public final double c() {
        return this.c;
    }

    @Override
    public final boolean d() {
        return this.d;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof y && this.a == ((y)(object = (y)object)).a() && this.b == ((y)object).b() && Double.doubleToLongBits((double)this.c) == Double.doubleToLongBits((double)((y)object).c()) && this.d == ((y)object).d();
    }

    public final int hashCode() {
        double d2 = this.c;
        long l2 = Double.doubleToLongBits((double)d2);
        long l3 = Double.doubleToLongBits((double)d2);
        int n2 = true != this.d ? 1237 : 1231;
        int n3 = this.a;
        int n4 = this.b;
        return ((int)(l3 ^ l2 >>> 32) ^ ((n3 ^ 0xF4243) * 1000003 ^ n4) * 1000003) * 1000003 ^ n2;
    }

    public final String toString() {
        int n2 = this.a;
        int n3 = String.valueOf((int)n2).length();
        int n4 = this.b;
        int n5 = String.valueOf((int)n4).length();
        double d2 = this.c;
        int n6 = String.valueOf((double)d2).length();
        boolean bl = this.d;
        StringBuilder stringBuilder = new StringBuilder(n3 + 44 + n5 + 20 + n6 + 25 + String.valueOf((boolean)bl).length() + 1);
        stringBuilder.append("PingStrategy{maxAttempts=");
        stringBuilder.append(n2);
        stringBuilder.append(", initialBackoffMs=");
        stringBuilder.append(n4);
        stringBuilder.append(", backoffMultiplier=");
        stringBuilder.append(d2);
        stringBuilder.append(", bufferAfterMaxAttempts=");
        stringBuilder.append(bl);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

