/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package h3;

import h3.o;

final class x {
    public final o a;

    public x(o o2) {
        this.a = o2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Removed[");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

