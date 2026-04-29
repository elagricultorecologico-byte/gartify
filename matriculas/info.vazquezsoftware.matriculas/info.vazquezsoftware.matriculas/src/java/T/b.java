/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package T;

import T.c;
import T.g;

public final class b
implements Runnable {
    public final String g;
    public final g h;

    public /* synthetic */ b(String string, g g2) {
        this.g = string;
        this.h = g2;
    }

    public final void run() {
        c.a(this.g, this.h);
    }
}

