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

public final class a
implements Runnable {
    public final String g;
    public final f.a h;

    public /* synthetic */ a(String string, f.a a2) {
        this.g = string;
        this.h = a2;
    }

    public final void run() {
        f.a(this.g, this.h);
    }
}

