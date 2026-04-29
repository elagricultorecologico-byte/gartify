/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package w1;

import w1.y;
import w1.z;

final class x
implements Runnable {
    final y g;

    x(y y2) {
        this.g = y2;
    }

    public final void run() {
        z z2 = this.g.a;
        z.s(z2).d(z.s(z2).getClass().getName().concat(" disconnecting because it was signed out."));
    }
}

