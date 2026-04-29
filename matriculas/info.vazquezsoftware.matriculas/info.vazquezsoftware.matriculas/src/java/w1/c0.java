/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Objects
 */
package w1;

import android.os.Bundle;
import java.util.Objects;
import w1.d0;
import w1.g;

final class c0
implements Runnable {
    final g g;
    final String h;
    final d0 i;

    c0(d0 d02, g g2, String string) {
        this.g = g2;
        this.h = string;
        Objects.requireNonNull((Object)d02);
        this.i = d02;
    }

    public final void run() {
        d0 d02 = this.i;
        if (d02.k() > 0) {
            String string;
            g g2 = this.g;
            if (d02.l() != null) {
                string = this.h;
                string = d02.l().getBundle(string);
            } else {
                string = null;
            }
            g2.f((Bundle)string);
        }
        if (d02.k() >= 2) {
            this.g.j();
        }
        if (d02.k() >= 3) {
            this.g.h();
        }
        if (d02.k() >= 4) {
            this.g.k();
        }
        if (d02.k() >= 5) {
            this.g.g();
        }
    }
}

