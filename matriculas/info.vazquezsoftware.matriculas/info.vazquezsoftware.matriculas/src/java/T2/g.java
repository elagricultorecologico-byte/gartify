/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package t2;

import t2.f;

public final class g
implements Runnable {
    public final f.c g;
    public final String h;

    public /* synthetic */ g(f.c c3, String string) {
        this.g = c3;
        this.h = string;
    }

    public final void run() {
        f.c.a(this.g, this.h);
    }
}

