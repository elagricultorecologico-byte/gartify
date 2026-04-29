/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package j3;

import c3.M;
import j3.h;
import j3.j;

final class i
extends h {
    public final Runnable i;

    public i(Runnable runnable, long l2, boolean bl) {
        super(l2, bl);
        this.i = runnable;
    }

    public void run() {
        this.i.run();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Task[");
        stringBuilder.append(M.a(this.i));
        stringBuilder.append('@');
        stringBuilder.append(M.b(this.i));
        stringBuilder.append(", ");
        stringBuilder.append(this.g);
        stringBuilder.append(", ");
        stringBuilder.append(j.a(this.h));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

