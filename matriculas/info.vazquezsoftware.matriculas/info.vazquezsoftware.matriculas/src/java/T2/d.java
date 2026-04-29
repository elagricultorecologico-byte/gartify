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

public final class d
implements Runnable {
    public final f.b g;
    public final String h;

    public /* synthetic */ d(f.b b2, String string) {
        this.g = b2;
        this.h = string;
    }

    public final void run() {
        f.d(this.g, this.h);
    }
}

