/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class i
implements Runnable {
    public final InformacionActivity.e g;

    public /* synthetic */ i(InformacionActivity.e e2) {
        this.g = e2;
    }

    public final void run() {
        InformacionActivity.e.c(this.g);
    }
}

