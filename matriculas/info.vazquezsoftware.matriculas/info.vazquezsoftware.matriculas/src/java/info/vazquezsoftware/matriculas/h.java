/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class h
implements Runnable {
    public final InformacionActivity.d g;

    public /* synthetic */ h(InformacionActivity.d d2) {
        this.g = d2;
    }

    public final void run() {
        InformacionActivity.d.d(this.g);
    }
}

