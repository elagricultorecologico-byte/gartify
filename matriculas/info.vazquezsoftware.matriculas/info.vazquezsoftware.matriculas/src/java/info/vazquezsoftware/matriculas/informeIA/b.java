/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package info.vazquezsoftware.matriculas.informeIA;

import info.vazquezsoftware.matriculas.informeIA.InformeIAActivity;

public final class b
implements Runnable {
    public final InformeIAActivity.a g;
    public final A2.b h;

    public /* synthetic */ b(InformeIAActivity.a a2, A2.b b2) {
        this.g = a2;
        this.h = b2;
    }

    public final void run() {
        InformeIAActivity.a.d(this.g, this.h);
    }
}

