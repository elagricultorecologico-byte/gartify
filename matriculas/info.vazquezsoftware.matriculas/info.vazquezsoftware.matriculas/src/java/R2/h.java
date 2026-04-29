/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package r2;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class h
implements Runnable {
    public final InformacionActivity g;

    public /* synthetic */ h(InformacionActivity informacionActivity) {
        this.g = informacionActivity;
    }

    public final void run() {
        InformacionActivity.r0(this.g);
    }
}

