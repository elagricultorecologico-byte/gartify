/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package e3;

import c3.N0;

final class p {
    public final N0 a;

    public p(N0 n02) {
        this.a = n02;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WaiterEB(");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

