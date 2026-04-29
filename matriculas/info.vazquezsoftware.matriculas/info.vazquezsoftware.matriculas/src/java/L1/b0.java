/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.FS
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.ArrayDeque
 */
package l1;

import com.google.android.gms.internal.ads.FS;
import java.util.ArrayDeque;
import l1.c0;

final class b0
implements Runnable {
    private final c0 g;
    private final FS h;
    private final ArrayDeque i;
    private final ArrayDeque j;

    /* synthetic */ b0(c0 c02, FS fS, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        this.g = c02;
        this.h = fS;
        this.i = arrayDeque;
        this.j = arrayDeque2;
    }

    public final /* synthetic */ void run() {
        this.g.f(this.h, this.i, this.j);
    }
}

