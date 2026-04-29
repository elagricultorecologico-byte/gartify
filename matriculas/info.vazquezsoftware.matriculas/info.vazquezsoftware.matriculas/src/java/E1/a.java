/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.util.Objects
 */
package e1;

import e1.B;
import java.util.Objects;

final class a
implements Runnable {
    final B g;

    a(B b2) {
        Objects.requireNonNull((Object)b2);
        this.g = b2;
    }

    public final void run() {
        B b2 = this.g;
        b2.c(Thread.currentThread());
        b2.a();
    }
}

