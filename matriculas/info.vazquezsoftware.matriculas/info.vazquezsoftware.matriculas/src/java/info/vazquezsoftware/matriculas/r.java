/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import info.vazquezsoftware.matriculas.PremiumActivity;

public final class r
implements Runnable {
    public final PremiumActivity.a g;
    public final int h;

    public /* synthetic */ r(PremiumActivity.a a2, int n2) {
        this.g = a2;
        this.h = n2;
    }

    public final void run() {
        PremiumActivity.a.f(this.g, this.h);
    }
}

