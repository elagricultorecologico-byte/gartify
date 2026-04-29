/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package H0;

import F0.b;
import java.util.Arrays;

public final class h {
    private final b a;
    private final byte[] b;

    public h(b b2, byte[] byArray) {
        if (b2 != null) {
            if (byArray != null) {
                this.a = b2;
                this.b = byArray;
                return;
            }
            throw new NullPointerException("bytes is null");
        }
        throw new NullPointerException("encoding is null");
    }

    public byte[] a() {
        return this.b;
    }

    public b b() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof h)) {
            return false;
        }
        object = (h)object;
        if (!this.a.equals(((h)object).a)) {
            return false;
        }
        return Arrays.equals((byte[])this.b, (byte[])((h)object).b);
    }

    public int hashCode() {
        return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode((byte[])this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EncodedPayload{encoding=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", bytes=[...]}");
        return stringBuilder.toString();
    }
}

