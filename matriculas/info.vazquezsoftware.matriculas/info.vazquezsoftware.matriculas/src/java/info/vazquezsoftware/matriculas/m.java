/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas;

import info.vazquezsoftware.matriculas.InformacionActivity;

public final class m
implements Runnable {
    public final InformacionActivity.f g;

    public /* synthetic */ m(InformacionActivity.f f2) {
        this.g = f2;
    }

    public final void run() {
        InformacionActivity.f.d(this.g);
    }
}

