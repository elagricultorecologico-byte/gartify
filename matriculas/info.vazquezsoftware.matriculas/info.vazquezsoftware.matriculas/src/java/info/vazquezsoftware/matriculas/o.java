/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class o
implements Runnable {
    public final InformacionActivity.g g;

    public /* synthetic */ o(InformacionActivity.g g2) {
        this.g = g2;
    }

    public final void run() {
        InformacionActivity.g.c(this.g);
    }
}

