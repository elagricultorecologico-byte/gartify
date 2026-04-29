/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class f
implements Runnable {
    public final InformacionActivity.c g;

    public /* synthetic */ f(InformacionActivity.c c2) {
        this.g = c2;
    }

    public final void run() {
        InformacionActivity.c.c(this.g);
    }
}

