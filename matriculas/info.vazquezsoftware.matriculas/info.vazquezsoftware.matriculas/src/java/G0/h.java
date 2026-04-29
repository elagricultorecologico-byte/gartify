/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package G0;

import G0.n;

final class h
extends n {
    private final long a;

    h(long l2) {
        this.a = l2;
    }

    @Override
    public long c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof n && this.a == ((n)(object = (n)object)).c();
    }

    public int hashCode() {
        long l2 = this.a;
        return (int)(l2 ^ l2 >>> 32) ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogResponse{nextRequestWaitMillis=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

