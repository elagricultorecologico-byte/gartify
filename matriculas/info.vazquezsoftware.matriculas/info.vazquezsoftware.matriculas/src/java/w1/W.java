/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package w1;

import w1.z;

final class w
implements Runnable {
    final int g;
    final z h;

    w(z z2, int n2) {
        this.h = z2;
        this.g = n2;
    }

    public final void run() {
        z.y(this.h, this.g);
    }
}

