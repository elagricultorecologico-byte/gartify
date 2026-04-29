/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class n
implements Runnable {
    public final InformacionActivity.g g;

    public /* synthetic */ n(InformacionActivity.g g2) {
        this.g = g2;
    }

    public final void run() {
        InformacionActivity.g.d(this.g);
    }
}

