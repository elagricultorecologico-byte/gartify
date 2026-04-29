/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package r2;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class f
implements Runnable {
    public final InformacionActivity g;

    public /* synthetic */ f(InformacionActivity informacionActivity) {
        this.g = informacionActivity;
    }

    public final void run() {
        InformacionActivity.o0(this.g);
    }
}

