/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class j
implements Runnable {
    public final InformacionActivity.a g;

    public /* synthetic */ j(InformacionActivity.a a2) {
        this.g = a2;
    }

    public final void run() {
        InformacionActivity.a.c(this.g);
    }
}

