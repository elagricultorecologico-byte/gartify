/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package u2;

import u2.b;
import u2.c;

public final class a
implements Runnable {
    public final String g;
    public final c h;

    public /* synthetic */ a(String string, c c2) {
        this.g = string;
        this.h = c2;
    }

    public final void run() {
        b.a(this.g, this.h);
    }
}

