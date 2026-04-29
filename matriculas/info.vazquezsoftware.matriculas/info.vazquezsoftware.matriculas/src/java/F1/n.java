/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f1;

import f1.x;

final class n
extends x {
    private final int a;
    private final int b;
    private final boolean c;

    n(int n2, int n3, boolean bl) {
        this.a = n2;
        this.b = n3;
        this.c = bl;
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
    public final boolean c() {
        return this.c;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof x && this.a == ((x)(object = (x)object)).a() && this.b == ((x)object).b() && this.c == ((x)object).c();
    }

    public final int hashCode() {
        int n2 = true != this.c ? 1237 : 1231;
        return n2 ^ ((this.a ^ 0xF4243) * 1000003 ^ this.b) * 1000003;
    }

    public final String toString() {
        int n2 = this.a;
        int n3 = String.valueOf((int)n2).length();
        int n4 = this.b;
        int n5 = String.valueOf((int)n4).length();
        boolean bl = this.c;
        StringBuilder stringBuilder = new StringBuilder(n3 + 59 + n5 + 26 + String.valueOf((boolean)bl).length() + 1);
        stringBuilder.append("OfflineAdConfig{impressionPrerequisite=");
        stringBuilder.append(n2);
        stringBuilder.append(", clickPrerequisite=");
        stringBuilder.append(n4);
        stringBuilder.append(", notificationFlowEnabled=");
        stringBuilder.append(bl);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

