/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package x2;

import x2.a;
import x2.c;

public final class b
implements Runnable {
    public final String g;
    public final a h;

    public /* synthetic */ b(String string, a a2) {
        this.g = string;
        this.h = a2;
    }

    public final void run() {
        c.a(this.g, this.h);
    }
}

