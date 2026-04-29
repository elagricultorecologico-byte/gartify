/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicInteger
 */
package e1;

import android.content.DialogInterface;
import e1.u;
import java.util.concurrent.atomic.AtomicInteger;

final class m
implements DialogInterface.OnClickListener {
    private final u g;
    private final AtomicInteger h;
    private final int i;
    private final int j;
    private final int k;

    /* synthetic */ m(u u2, AtomicInteger atomicInteger, int n2, int n3, int n4) {
        this.g = u2;
        this.h = atomicInteger;
        this.i = n2;
        this.j = n3;
        this.k = n4;
    }

    public final /* synthetic */ void onClick(DialogInterface dialogInterface, int n2) {
        this.g.i(this.h, this.i, this.j, this.k, dialogInterface, n2);
    }
}

