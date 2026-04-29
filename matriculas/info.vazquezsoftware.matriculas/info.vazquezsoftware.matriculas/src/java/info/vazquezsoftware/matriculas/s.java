/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import E2.c;
import info.vazquezsoftware.matriculas.PremiumActivity;

public final class s
implements Runnable {
    public final PremiumActivity.a g;
    public final c.d h;

    public /* synthetic */ s(PremiumActivity.a a2, c.d d2) {
        this.g = a2;
        this.h = d2;
    }

    public final void run() {
        PremiumActivity.a.e(this.g, this.h);
    }
}

