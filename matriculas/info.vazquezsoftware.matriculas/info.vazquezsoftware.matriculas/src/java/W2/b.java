/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package w2;

import w2.f;

public final class b
implements Runnable {
    public final f.a g;
    public final String h;

    public /* synthetic */ b(f.a a2, String string) {
        this.g = a2;
        this.h = string;
    }

    public final void run() {
        f.b(this.g, this.h);
    }
}

