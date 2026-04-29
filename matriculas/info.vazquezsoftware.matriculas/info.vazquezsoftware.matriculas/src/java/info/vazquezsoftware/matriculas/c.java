/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class c
implements Runnable {
    public final InformacionActivity.b g;

    public /* synthetic */ c(InformacionActivity.b b2) {
        this.g = b2;
    }

    public final void run() {
        InformacionActivity.b.c(this.g);
    }
}

